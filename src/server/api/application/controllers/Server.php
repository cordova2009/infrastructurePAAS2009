<?php

use Core\ServiceApi;

class ServerController extends ServiceApi{
    
    protected $user;
    
    public function init(){
        parent::init();

        if(!empty($this->request_data['unionid'])){

            $this->user = M('t_ucenter_member')->get(['id(userid)'],['id'=>$this->request_data['unionid']]);
        }

        if(empty($this->user)){
            $this->sendError('用户不存在',self::ERR_CODE_USER_NOT_EXIST);
        }
    }
}

?>