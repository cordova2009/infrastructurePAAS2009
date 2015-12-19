<?php
/**
 * @name MallController
 * @author xuebingwang
 * @desc 商城基控制器
 * @see http://www.php.net/manual/en/class.yaf-controller-abstract.php
*/
class MemberController extends MallController {

    public function init(){
        
        parent::init();

        if(empty($this->user)){
            if(IS_AJAX){

                $this->error('对不起，您当前不在登录状态，请重新登录！',U('/login'));
            }else{

                $this->redirect(U('/login'));
            }
        }
    }
}
