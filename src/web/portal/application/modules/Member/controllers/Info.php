<?php
/**
 * @name IndexController
 * @author xuebingwang
 * @desc 默认控制器
 * @see http://www.php.net/manual/en/class.yaf-controller-abstract.php
*/
class InfoController extends MemberController {

    /**
     *修改头像
     */
    public function updateAvatarAction(){
        if(IS_POST){

            $data = [
                'token'=>$this->user['token'],
                'headImageUrl'=>I('headImageUrl')
            ];

            $curl = new Curl($this->config->url->api->user);
            $resp = $curl->setData($data)
                        ->send('userCenter/updateHeadImage');

            if(check_resp($resp)) {
                session('user_auth',array_merge($this->user,$data));
                $this->success('修改成功！');
            }else{
                $this->error(isset($resp['errmsg']) ? $resp['errmsg'] : '修改头像失败，请重新再试！');
            }
        }
        $this->error('提交方式不正确！');
    }
    /**
     * 银行开户信息
     */
    public function bankAction(){

        $this->meta_title = '开户行信息';
        $curl = new Curl($this->config->url->api->user);

        $resp = $curl->setData(['token'=>$this->user['token']])
                        ->send('userCenter/getBankInfoList');

        $info = [
            'BeebankInfo'=>[],
            'BerbankInfo'=>[],
        ];
        if(check_resp($resp)) {
            $info = $resp;
        }
        $this->assign('info',$info);

        $this->meta_title = '基本信息';
        $this->assign('user',$this->user);


    }
    /**
     *修改绑定手机
     */
    public function updateMobileAction(){

        if(IS_POST){
            $new_mobile = I('new_mobile');
            if(empty($new_mobile)){
                $this->error('新手机号码不能为空！');
            }
            $password = I('password');
            if(empty($password)){
                $this->error('登录密码不能为空！');
            }
            $sec_sms_code = I('second_sms_code');
            if(empty($sec_sms_code)){
                $this->error('验证码不能为空！');
            }

            $data = ['token'=>$this->user['token']];
            $data['firstSmsCode'] = I('sms_code');
            if(empty($data['firstSmsCode'])){
                $this->error('短信验证码不能为空！');
            }
            $data['secondSmsCode'] = I('second_sms_code');
            if(empty($data['secondSmsCode'])){
                $this->error('短信验证码不能为空！');
            }
            $data['loginPassword'] = encrypt(md5($password),$this->config->api->app->appKey);
            $data['oldMobileNum'] = $this->user['mobileNum'];
            $data['newMobileNum'] = $new_mobile;

            $curl = new Curl($this->config->url->api->user);
            $return = test_mobile_sms($data['newMobileNum'],$data['secondSmsCode']);
            if(!is_bool($return)){
                $this->error($return);
            }

            $resp = $curl->setData($data)
                ->send('userSecurity/updateMobileNum');

            if(check_resp($resp)) {
                $this->success('修改成功！');
            }else{
                $this->ajaxReturn(['status'=>999,'msg'=>isset($resp['errmsg']) ? $resp['errmsg'] : '修改手机号码失败，请重新再试！']);
            }
        }
        $this->error('提交方式不正确！');
    }

    /**
     * 修改支付密码
     */
    public function updateTradePwdAction(){

        if(IS_POST){
            $old_password = I('old_password');
            if(empty($old_password)){
                $this->error('原密码不能为空！');
            }
            $new_password = I('new_password');
            if(empty($new_password)){
                $this->error('新密码不能为空！');
            }
            if($new_password != I('r_new_password')){
                $this->error('两次密码输入不一致！');
            }

            $data = ['token'=>$this->user['token']];
            $data['smsCode'] = I('sms_code');
            if(empty($data['smsCode'])){
                $this->error('短信验证码不能为空！');
            }
            $data['oldTradePassword'] = encrypt(md5($old_password),$this->config->api->app->appKey);
            $data['newTradePassword'] = encrypt(md5($new_password),$this->config->api->app->appKey);

            $curl = new Curl($this->config->url->api->user);

            $resp = $curl->setData($data)
                ->send('userSecurity/updateTradePassword');

            if(check_resp($resp)) {
                $this->success('修改成功！');
            }else{
                $this->error(isset($resp['errmsg']) ? $resp['errmsg'] : '修改密码失败，请重新再试！');
            }
        }
        $this->error('提交方式不正确！');
    }

    /**
     * 修改登录密码
     */
    public function updateLoginPwdAction(){

        if(IS_POST){
            $old_password = I('old_password');
            if(empty($old_password)){
                $this->error('原密码不能为空！');
            }
            $new_password = I('new_password');
            if(empty($new_password)){
                $this->error('新密码不能为空！');
            }
            if($new_password != I('r_new_password')){
                $this->error('两次密码输入不一致！');
            }

            $data = ['token'=>$this->user['token']];
            $data['smsCode'] = I('sms_code');
            if(empty($data['smsCode'])){
                $this->error('短信验证码不能为空！');
            }
            $data['oldLoginPassword'] = encrypt(md5($old_password),$this->config->api->app->appKey);
            $data['newLoginPassword'] = encrypt(md5($new_password),$this->config->api->app->appKey);

            $curl = new Curl($this->config->url->api->user);

            $resp = $curl->setData($data)
                            ->send('userSecurity/updateLoginPassword');

            if(check_resp($resp)) {
                $this->success('修改成功！');
            }else{
                $this->error(isset($resp['errmsg']) ? $resp['errmsg'] : '修改密码失败，请重新再试！');
            }
        }
        $this->error('提交方式不正确！');
    }
    /**
     * 安全信息页面
     */
    public function safeAction(){

        $this->meta_title = '安全信息';
//        $curl = new Curl($this->config->url->api->user);

//        $resp = $curl->setData(['token'=>$this->user['token']])
//                        ->send('userSecurity/getUserSecurityInfo');
//
//        $info = [];
//        if(check_resp($resp)) {
//            $info = $resp['user'];
//        }
        $this->assign('user',$this->user);
    }
    /**
     * 默认动作，首页
     * Yaf支持直接把Yaf\Request_Abstract::getParam()得到的同名参数作为Action的形参
     * 对于如下的例子, 当访问http://yourhost/y/index/index/index/name/yantze 的时候, 你就会发现不同
     */
    public function indexAction(){

        $this->meta_title = '基本信息';
//        var_dump($this->user);die;
        $this->assign('user',$this->user);
    }

    public function editAction(){
        if(IS_POST){
            $data = ['token'=>$this->user['token']];
            $data['nickname'] = I('nickname');
            if(empty($data['nickname'])){
                $this->error('昵称不能为空！');
            }
            $data['email'] = I('email');
            if(!empty($data['email']) && !regex($data['email'],'email')){
                $this->error('邮箱格式不正确！');
            }
            $data['address'] = I('address');
//            if(empty($data['address'])){
//                $this->error('联系地址不能为空！');
//            }

            $curl = new Curl($this->config->url->api->user);

            $resp = $curl->setData($data)->send('userCenter/updateUserInfo');

            if(check_resp($resp)) {

                session('user_auth',array_merge($this->user,$data));
                $this->success('保存成功！',U('/member/info/index'));
            }else{
                $this->error(isset($resp['errmsg']) ? $resp['errmsg'] : '登录失败，请重新再试！');
            }

            $this->error(var_export($data,true));
        }

        $this->meta_title = '基本信息';
        $this->assign('user',$this->user);
    }
}
