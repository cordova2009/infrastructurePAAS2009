<?php
/**
 * @name PublicController
 * @author xuebingwang
 * @desc Public控制器
 * @see http://www.php.net/manual/en/class.yaf-controller-abstract.php
*/
class PublicController extends MallController {

    /**
     * 退出
     */
    public function logoutAction(){

        session('user_auth',null);
        if(IS_AJAX){
            $this->success('退出成功');
        }
        $this->redirect(U('/login'));
    }
    /**
     * 登录
     */
    public function loginAction(){

        if(IS_POST){
            $data                   = [];
            $data['mobileNum']      = I('username');
            $data['loginPassword']  = encrypt(md5(I('password')),$this->config->api->app->appKey);

            //调用登录接口
            $curl = new Curl($this->config->url->api->user);

            $resp = $curl->setData($data)->send('userCenter/login');

            if(!check_resp($resp)) {

                $this->error(isset($resp['errmsg']) ? $resp['errmsg'] : '登录失败，请重新再试！');
            }

            //调用查询用户基础信息接口，并将信息保存至会话中
            $user = $resp['user'];
            $resp = $curl->setData(['token'=>$resp['user']['token']])
                        ->send('userCenter/getUserBaseInfo');
            if(check_resp($resp)){
                session('user_auth',array_merge($user,$resp['user']));
                $this->success('登录成功！',U('/member/info/index'));
            }else{
                $this->error(isset($resp['errmsg']) ? $resp['errmsg'] : '登录失败，请重新再试！');
            }
        }

        $this->layout->meta_title = '用户登录';
    }

    /**
     * 注册页面
     */
    public function registerAction(){
        if(IS_POST){
            $data                   = [];
            $data['mobileNum']      = I('mobile');
            $data['nickname']       = I('nickname');
            $data['smsCode']        = I('sms_code');
            $data['realName']       = encrypt(I('real_name'),$this->config->api->app->appKey);
            $data['cardID']         = encrypt(I('id_num'),$this->config->api->app->appKey);
            $data['loginPassword']  = encrypt(md5(I('password')),$this->config->api->app->appKey);
            $data['tradePassword']  = encrypt(md5(I('trade_password')),$this->config->api->app->appKey);

            $curl = new Curl($this->config->url->api->user);
            //调用实名认证接口
//            $resp = $curl->setData([])->send('userSecurity/isRealName');

            $resp = $curl->setData($data)->send('userCenter/register');

            if(check_resp($resp)){
                $this->success('');
            }else{
                $this->error(isset($resp['errmsg']) ? $resp['errmsg'] : '注册失败，请重新再试！');
            }
        }

        $this->layout->meta_title = '用户注册';
    }

    /**
     *
     */
    public function beforeRegAction(){
        $mobileNum = $this->getRequest()->getPost('mobile');

        $curl      = new Curl($this->config->url->api->user);

        $resp = $curl->setData(['mobileNum'=>$mobileNum])->send('userCenter/getUserStatus');

        if(check_resp($resp) && $resp['status'] == 'FLS'){
            //只针对未注册用户发送短信
            $this->sendSmsCodeAction();
        }else{
            $this->error('该手机号码已存在！');
        }
    }

    /**
     * 检查用户是否存在
     */
    public function checkMobileAction(){

        $mobileNum = $this->getRequest()->getPost('mobile');

        $curl      = new Curl($this->config->url->api->user);

        $resp = $curl->setData(['mobileNum'=>$mobileNum])->send('userCenter/getUserStatus');

        if(check_resp($resp) && $resp['status'] == 'FLS'){
            $this->success('');
        }else{
            $this->error('该手机号码已存在！');
        }
    }

    /**
     * 检验短信验证码
     */
    public function checkMobileSmsAction(){
        $mobile = $this->getRequest()->getPost('mobile');

        //当手机号码为空并且用户为登录状态的情况下
        if(empty($mobileNum) && is_login()){
            $mobile = is_login();
        }
        if(empty($mobile)){
            $this->error('手机号码不能为空！');
        }
        $sms_code = $this->getRequest()->getPost('sms_code');
        if(empty($sms_code)){
            $this->error('短信验证码不能为空！');
        }

        $return = test_mobile_sms($mobile,$sms_code);
        if(is_bool($return) && $return){
            $this->success('');
        }else{
            $this->error($return);
        }
    }

    /**
     * 忘记密码
     */
    public function forgetAction(){
        if(IS_POST){
            $new_pwd = I('new_pwd');
            if(empty($new_pwd)){
                $this->error('新密码不能为空！');
            }
            if(I('r_new_pwd') != $new_pwd){
                $this->error('两次密码输入不一致！');
            }
            $data['loginPassword']  = encrypt(md5($new_pwd),$this->config->api->app->appKey);
            $data['smsCode']        = I('sms_code');
            $data['mobileNum']      = I('mobile');

            $curl                   = new Curl($this->config->url->api->user);

            $resp = $curl->setData($data)->send('userSecurity/forgetPassword');

            if(check_resp($resp)){
                $this->success('');
            }else{
                $this->ajaxReturn(['status'=>999,'msg'=>isset($resp['errmsg']) ? $resp['errmsg'] : '重置密码失败，请重新再试，或联系管理员！']);
            }


        }
    }

    /**
     * 获取图形验证码
     */
    public function getCodeAction(){
        $code = new Verify(['length'=>4]);
        $code->entry(1) ;
    }

    public function checkVerifyAction(){
        $code = I('post.verify_code');
        $verify = new Verify();
        if(!$verify->check($code,1)){
            $this->error('验证码不正确！');
        }

        $mobileNum = I('post.mobile');
        if(empty($mobileNum)){

            $this->error('手机号码不能为空！');
        }

        $curl                   = new Curl($this->config->url->api->user);

        $resp = $curl->setData(['mobileNum'=>$mobileNum])->send('userCenter/getUserStatus');

        if(!check_resp($resp) || $resp['status'] != 'OK#'){
            $this->error('手机号码不存在或状态异常！');
        }

        if(send_sms($mobileNum)){
            //将短信验证码、手机、创建时间保存至会话中
            $this->success('');
        }else{
            $this->error('验证码发送失败，请重新再试！');
        }
    }
    /**
     * 发送短信验证码接口
     */
    public function sendSmsCodeAction(){

        $mobileNum = trim($this->getRequest()->getPost('mobile',''));
        if(empty($mobileNum) && is_login()){

            $mobileNum = is_login();
        }
        if(empty($mobileNum)){

            $this->error('手机号码不能为空！');
        }

        if(send_sms($mobileNum)){
            //将短信验证码、手机、创建时间保存至会话中
            $this->success('验证码发送成功！');
        }else{
            $this->error('验证码发送失败，请重新再试！');
        }
    }


}
