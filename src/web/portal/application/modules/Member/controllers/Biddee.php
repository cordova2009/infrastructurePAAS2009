<?php
/**
 * @name PublicController
 * @author xuebingwang
 * @desc Public控制器
 * @see http://www.php.net/manual/en/class.yaf-controller-abstract.php
*/
class BiddeeController extends MemberController{

    public function authInfoAction(){
	    $token = isset($this->user['token'])?$this->user['token']:'';
            $curl = new Curl($this->config->url->api->paas);
            $resp = $curl->setData(['token'=>$token])->send('myBiddee/authInfo/getAuthInfo');
            if(!check_resp($resp)) {
		 //   $this->redirect(U('/login'));
            }
	    $this->assign('datail',$resp['datail']);
	    $this->assign('overall',$resp['overall']);
	    $this->layout->meta_title = '认证信息';
    }

}
