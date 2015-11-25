<?php
/**
 * @name PublicController
 * @author xuebingwang
 * @desc Public控制器
 * @see http://www.php.net/manual/en/class.yaf-controller-abstract.php
*/
class PublicController extends MallController {

    public function loginAction(){

        if(IS_POST){

            $account = trim($this->getRequest()->getPost('account'));
            if(empty($account)){
                $this->error('请输入用户名！');
            }
            $password = trim($this->getRequest()->getPost('password'));
            if(empty($password)){
                $this->error('请输入密码！');
            }
            $user = M('t_ucenter_member')->get('*',['username'=>$account]);

            if(empty($user)){
                $this->error('用户名密码不正确！');
            }
            if($user['password'] != think_ucenter_md5($password)){

                $this->error('用户名密码不正确！');
            }

            unset($user['password']);
            session('user_auth',$user);

            $back_url = urldecode($this->getRequest()->getPost('back_url'));
            $this->success('登录成功！',$back_url ? $back_url : '/');
        }

        $this->getView()->assign('back_url',$this->getRequest()->getQuery('back_url'));
        $this->layout->title = '会员登录';
        $this->layout->no_footer = true;
    }

    public function registerAction(){
        if(IS_POST){

            $mobile = trim($this->getRequest()->getPost('mobile'));
            $smsCode = trim($this->getRequest()->getPost('sms_code'));
            $password = trim($this->getRequest()->getPost('password'));
            if(empty($password)){
                $this->error('请输入密码！');
            }
            $re_password = trim($this->getRequest()->getPost('re_password'));
            if($password != $re_password){
                $this->error('两次密码输入不一致！');
            }

            $msg = test_mobile_sms($mobile,$smsCode);
            if(!empty($msg)){
                $this->error($msg);
            }

            $model = M('t_ucenter_member');
            if($model->get('id',['username'=>$mobile])){

                $this->error('此手机号码已经被注册，请直接登录！');
            }

            $data = [
                        'username'=>$mobile,
                        'mobile'=>$mobile,
                        'password'=>think_ucenter_md5($password),
                        'reg_time'=>time(),
                        'reg_ip'=>get_client_ip(1),
                        'status'=>1
                    ];
            $uid = $model->insert($data);
            if($uid){
                M('t_member')->insert(['uid'=>$uid,'nickname'=>$mobile,'status'=>1,'reg_ip'=>$data['reg_ip'],'reg_time'=>$data['reg_time']]);

                $data['id'] = $uid;
                unset($data['password']);
                session('user_auth',$data);
                $back_url = urldecode($this->getRequest()->getPost('back_url'));
                $this->success('注册成功，欢迎您的光临！',$back_url ? $back_url : '/');
            }else{
                $this->error('注册失败，请重新再试！');
            }
        }
        $this->getView()->assign('back_url',$this->getRequest()->getQuery('back_url'));
        $this->layout->title = '会员注册';
        $this->layout->no_footer = true;
    }

    public function forgetAction(){

    }

    public function sendSmsCodeAction(){

        $mobileNum = trim($this->getRequest()->getPost('mobile',''));
        if(empty($mobileNum)){
            $this->error('手机号码不能为空！');
        }

        $code = mt_rand(1000,9999);
        $data = $this->config->url->api->sms->toArray();

        if(send_sms($mobileNum,sprintf($data['content'],$code))){

            //将短信验证码、手机、创建时间保存至会话中
            session('MobileSmsCode',['code'=>$code,'time'=>time(),'mobile'=>$mobileNum]);
            $this->success('验证码发送成功！');
        }else{
            $this->error('验证码发送失败，请重新再试！');
        }
    }
}
