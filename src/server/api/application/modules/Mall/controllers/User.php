<?php
/**
 * Created by PhpStorm.
 * User: xuebin<406964108@qq.com>
 * Date: 2014/12/27
 * Time: 14:27
 * @copyright Copyright (c) 2014
 */

class UserController extends ServerController
{
    public function getAddressAction(){

        $model = new Model('t_user_address');
        $address = $model->get('*',['userid'=>$this->user['userid']]);

        if(empty($address)){
            $this->sendError('没有数据!');
        }else{
            $this->sendOutPut($address);
        }
    }

    public function sbfeedbackAction(){

        $model = new Model('t_tymk_user_opinion');
        $f = $model->insert(['user_id'=>$this->user['userid'],'opinion'=>$this->request_data['content'],'insert_time'=>time_format()]);

        if($f){
            $this->sendSuccess('提交成功');
        }else{
            $this->sendError('提交失败，请重新再试！');
        }
    }
}
