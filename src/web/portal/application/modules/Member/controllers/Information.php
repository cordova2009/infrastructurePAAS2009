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
        if(IS_POST){
            /* "body":{
                 "token":"12345",
                 "objectAmount":"3000万",
                 "informationId":1,
                 "district":"广州市",
                 "objectName":"项目名称",
                 "employer":"甲方xxxxxx",
                 "phase":"招标阶段",
                 "projectPeriod":"半年",
                 "projectSituation":"本项目主要是xxxx",
                 "address":"xx路666号"
            }*/
            $data = ['token'=>$this->user['token']];
            $data['objectAmount'] = I('objectAmount');
            if(empty($data['objectAmount'])){
                $this->error('造价不能为空！');
            }
            $data['objectAmount'] =$data['objectAmount'].'元';
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

            $curl = new Curl($this->config->url->api->paas);

            $resp = $curl->setData($data)->send('userInformation/submitUserInformation');

            if(check_resp($resp)) {

                $this->success('保存成功！',U('/member/information/index'));
            }else{
                $this->error(isset($resp['errmsg']) ? $resp['errmsg'] : '提交失败，请重新再试！');
            }

            $this->error(var_export($data,true));
        }
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
            'pageIndex' => $pageIndex,
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
            'pageIndex' => $pageIndex,
            'status'=> $status
        ])->send('userInformation/queryUserInformationPage');

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
        $informationId =1;// I('informationId');
        if(empty($informationId)){
            $this->error('发布信息编号获取失败！');
        }
        $resp = $curl->setData([
            'token'=>$this->user['token'],
            'informationId'=>$informationId
        ])->send('userInformation/getUserInformationDetailWithComments');

        if(check_resp($resp)) {
            $result = $resp['result'];
        }
        $this->assign('result',$result);
        $this->meta_title = '发布信息详情';
    }

}
