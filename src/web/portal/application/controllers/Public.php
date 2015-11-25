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

        }

        $this->layout->title = '用户登录';
        $this->layout->no_footer = true;
    }

    public function registerAction(){
        if(IS_POST){

        }

        $this->layout->title = '用户注册';
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
