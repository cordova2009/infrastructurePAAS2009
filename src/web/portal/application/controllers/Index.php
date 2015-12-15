<?php
/**
 * @name IndexController
 * @author xuebingwang
 * @desc 默认控制器
 * @see http://www.php.net/manual/en/class.yaf-controller-abstract.php
*/
class IndexController extends MallController {

    private $_curl = '';
    
    public function init()
    {
        parent::init();
        $this->_curl = new Curl();
    }

    public function testAction(){

        var_dump($this->getRequest()->getRequest());
        var_dump($this->getRequest()->getParam('a'));
        var_dump($this->getRequest()->getParams());

        die;
    }
    /**
    * 默认动作，首页
    * Yaf支持直接把Yaf\Request_Abstract::getParam()得到的同名参数作为Action的形参
    * 对于如下的例子, 当访问http://yourhost/y/index/index/index/name/yantze 的时候, 你就会发现不同
    */
    public function indexAction(){

        //招标项目公告
        $this->assign('object_info',$this->_object_info());
        //招标项目列表
        $this->assign('object_list',$this->_object_list());
        //中标结果公告
        $this->assign('bid_info',$this->_bid_info());
        //中标结果列表
        $this->assign('bid_list',$this->_bid_list());
        //投标人
        $this->assign('bidder_info',$this->_bidder_info());
        //优质投标人
        $this->assign('bidder_list',$this->_bidder_list());
        //公告
        $this->assign('site_notice',$this->_site_notice());
    }
    
    private function _object_info()
    {
        $resp = $this->_curl->send('tender/queryObjectIndexSurvey');

        $object_info = ['objectNum'=>0,'amount'=>'0'];
        if(check_resp($resp)){
            $object_info = $resp['info'];
        }
        
        return $object_info;
    }
    
    private function _bid_info()
    {
        $resp = $this->_curl->send('tender/queryBidIndexSurvey');
        $bid_info = ['bidNum'=>0,'amount'=>'0'];
        if(check_resp($resp)){
            $bid_info = $resp['info'];
        }
        
        return $bid_info;
    }
    
    private function _bidder_info()
    {
        $resp = $this->_curl->send('tender/queryBidderIndexSurvey');
        $bidder_info = ['stairBiderNum'=>0,'secondBiderNum'=>'0'];
        if(check_resp($resp)){
            $bidder_info = $resp;
        }

        return $bidder_info;
    }
    
    private function _object_list()
    {
        $resp = $this->_curl->setData(['pageIndex'=>1,'pageSize'=>4])->send('tender/queryIndexObjectList');
        $object_list = [];
        if(check_resp($resp)){
            $object_list = $resp['list'];
        }
        
        return $object_list;
    }
    
    private function _bid_list()
    {
        $resp = $this->_curl->send('tender/queryBidIndexList');
        $bid_list = [];
        if(check_resp($resp)){
            $bid_list = $resp['list'];
        }
        
        return $bid_list;
    }
    
    private function _bidder_list()
    {
        $resp = $this->_curl->setData(['pageIndex'=>1,'pageSize'=>14])->send('tender/queryIndexBidList');
        $bidder_list = [];
        if(check_resp($resp)){
            $bidder_list = $resp['list'];
        }
        
        return $bidder_list;
    }
    
    private function _site_notice()
    {
        $resp = $this->_curl->setData(['size'=>1])->send('siteNews/getSiteNewsList');
        $notices = ['title' => '暂无公告', 'createTime' => date('Y-m-d')];
        if(check_resp($resp)){
            $notices = $resp['list'];
        }
        
        return isset($notices[0]) ? $notices[0] : $notices;
    }

}
