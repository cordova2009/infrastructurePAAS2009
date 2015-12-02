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

    }

    /**
     * 获取图形验证码
     */
    public function getCodeAction(){
        $code = new Verify(['length'=>4]);
        $code->entry(1) ;
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
