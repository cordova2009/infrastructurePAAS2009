<?php
/**
 * @name IndexController
 * @author xuebingwang
 * @desc 默认控制器
 * @see http://www.php.net/manual/en/class.yaf-controller-abstract.php
 */
class InformationController extends MemberController {

    /**
     * 默认动作，首页
     * Yaf支持直接把Yaf\Request_Abstract::getParam()得到的同名参数作为Action的形参
     * 对于如下的例子, 当访问http://yourhost/y/index/index/index/name/yantze 的时候, 你就会发现不同
     */
    public function indexAction(){
        if(empty($this->user)){
            $this->redirect(U('/login'));
        }
        $curl = new Curl($this->config->url->api->paas);
        if(IS_POST){

            $data = ['token'=>$this->user['token']];
            $data['informationId'] = I('informationId');
            if(empty($data['informationId'])){
                $data['informationId']=0;
            }
            $data['objectAmount'] = I('objectAmount');
            if(empty($data['objectAmount'])){
                $this->error('造价不能为空！');
            }
            $data['objectAmount'] =$data['objectAmount']*100;
            $data['objectName'] = I('objectName');
            if(empty($data['objectName'])){
                $this->error('项目名称不能为空！');
            }
            $data['district'] = I('district');
            if(empty($data['district'])){
                $this->error('项目区域不能为空！');
            }
            $data['phase'] = I('phase');
            if(empty($data['phase'])){
                $this->error('阶段不能为空！');
            }
            $data['objectType'] = I('objectType');
            if(empty($data['objectType'])){
                $this->error('工程类别不能为空！');
            }
            $data['employer'] = I('employer');
            if(empty($data['employer'])){
                $this->error('甲方信息不能为空！');
            }
            $data['projectPeriod'] = I('projectPeriod');
            if(empty($data['projectPeriod'])){
                $this->error('工期不能为空！');
            }
            $data['projectSituation'] = I('projectSituation');
            if(empty($data['projectSituation'])){
                $this->error('项目概况不能为空！');
            }
            $data['address'] = I('address');
            if(empty($data['address'])){
                $this->error('地址不能为空！');
            }
            $resp = $curl->setData($data)->send('userInformation/submitUserInformation');

            if(check_resp($resp)) {

                $this->success('保存成功！',U('/member/information/unpublishList'));
            }else{
                $this->error(isset($resp['errmsg']) ? $resp['errmsg'] : '提交失败，请重新再试！');
            }

            $this->error(var_export($data,true));
        }
        $data2 = ['token'=>$this->user['token']];
        $data2['informationId'] = I('informationId');
        $resp2 = $curl->setData($data2)->send('userInformation/getUserInformationDetail');
        $result=[];
        if(check_resp($resp2)) {
            $result = $resp2['result'];
        }
        $this->assign('result',$result);
        $this->meta_title = '发布信息';

    }
    public function publishListAction(){
        if(empty($this->user)){
            $this->redirect(U('/login'));
        }
        /*"body":{
            "token":"12345",
            "pageIndex":1,
            "pageSize":10,
            "status":"CRT"
        }*/
        $pageSize = 10;
        $status = 'OK#';
        $curl1 = new Curl($this->config->url->api->paas);
        $pageIndex = $this->getRequest()->getQuery('page', 0);
        $resp2 = $curl1->setData([
            'token'=>$this->user['token'],
            'pageSize'=> $pageSize,
            'pageIndex' => ($pageIndex==0?1:$pageIndex),
            'status'=> $status
        ])->send('userInformation/queryUserInformationPage');

        if(check_resp($resp2)) {
            $list = $resp2['list'];
            $page = $this->getPagination($resp2['total'], $pageSize);
            $this->assign('page', $page);
        }
        $this->assign('list',$list);
        $this->meta_title = '已发布信息';
    }


    public function unpublishListAction(){
        if(empty($this->user)){
            $this->redirect(U('/login'));
        }
        /*"body":{
            "token":"12345",
            "pageIndex":1,
            "pageSize":10,
            "status":"CRT"
        }*/
        $pageSize = 10;
        $status = 'CRT';
        $curl1 = new Curl($this->config->url->api->paas);
        $pageIndex = $this->getRequest()->getQuery('page', 0);
        $resp2 = $curl1->setData([
            'token'=>$this->user['token'],
            'pageSize'=> $pageSize,
            'pageIndex' => ($pageIndex==0?1:$pageIndex),
            'status'=> $status
        ])->send('userInformation/queryUserInformationPage');
        $list=[];
        if(check_resp($resp2)) {
            $list = $resp2['list'];
            $page = $this->getPagination($resp2['total'], $pageSize);
            $this->assign('page', $page);
        }
        $this->assign('list',$list);
        $this->meta_title = '待发布信息';
    }



    public function publishDetailAction(){

        if(empty($this->user)){
            $this->redirect(U('/login'));
        }
        /*"body":{
            "token":"12345",
            "informationId":1
        }*/
        $curl = new Curl($this->config->url->api->paas);
        $informationId = I('informationId');
        if(empty($informationId)){
            $this->error('发布信息编号获取失败！');
        }
        if(IS_POST){

            $data = ['token'=>$this->user['token']];
            $data['replyContent'] = I('replyContent');
            if(empty($data['replyContent'])){
                $this->error('评论内容不能为空！');
            }
            $data['informationId'] = I('informationId');
            $resp = $curl->setData($data)->send('/userInformation/replyUserInformation');

            if(check_resp($resp)) {

                $this->success('保存成功！',U('/member/nformation/publishDetail'));
            }else{
                $this->error(isset($resp['errmsg']) ? $resp['errmsg'] : '评论失败，请重新再试！');
            }

            $this->error(var_export($data,true));
        }

        $resp = $curl->setData([
            'token'=>$this->user['token'],
            'informationId'=>$informationId
        ])->send('userInformation/getUserInformationDetailWithComments');

        if(!check_resp($resp)) {
            $this->error('信息找不到了，请咨询管理员！');
        }
        $result = $resp['result'];
        $this->assign('result',$result);
        $this->assign('user',$this->user);
        $this->meta_title = '发布信息详情';
    }

}
