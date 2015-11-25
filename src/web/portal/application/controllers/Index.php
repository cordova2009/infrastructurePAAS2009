<?php
/**
 * @name IndexController
 * @author xuebingwang
 * @desc 默认控制器
 * @see http://www.php.net/manual/en/class.yaf-controller-abstract.php
*/
class IndexController extends MallController {

    /**
    * 默认动作，首页
    * Yaf支持直接把Yaf\Request_Abstract::getParam()得到的同名参数作为Action的形参
    * 对于如下的例子, 当访问http://yourhost/y/index/index/index/name/yantze 的时候, 你就会发现不同
    */
    public function indexAction(){

        /**
        //读取缓存
        $cache_name = ROOT_PATH.'/runtime/cache/'.md5($this->getMCA()).'.php';
        if(!$this->config->application->debug && file_exists($cache_name)){
            $this->getResponse()->setBody(file_get_contents($cache_name));
            return false;
        }

        //生成缓存文件
        file_put_contents($cache_name,$this->render($this->getAction()));
         */

        $curl = new Curl();

        $resp = $curl->send('tender/queryObjectIndexSurvey');
        $object_info = [];
        if(empty($resp) || $resp['errcode'] != '0'){
            $object_info = ['objectNum'=>0,'amount'=>'0'];
        }

        $resp = $curl->send('tender/queryBidIndexSurvey');
        $bid_info = [];
        if(empty($resp) || $resp['errcode'] != '0'){
            $bid_info = ['bidNum'=>0,'amount'=>'0'];
        }

        $resp = $curl->send('tender/queryBiderIndexSurvey');
        $bider_info = [];
        if(empty($resp) || $resp['errcode'] != '0'){
            $bider_info = ['stairBiderNum'=>0,'secondBiderNum'=>'0'];
        }

        $resp = $curl->setData(['pageIndex'=>1,'pageSize'=>4])->send('tender/queryIndexObjectList');
        $object_list = [];
        if(!empty($resp) && $resp['errcode'] == '0'){
            $object_list = $resp['list'];
        }

        $resp = $curl->send('tender/queryBidIndexList');
        $bid_list = [];
        if(!empty($resp) && $resp['errcode'] == '0'){
            $bid_list = $resp['list'];
        }

        $resp = $curl->setData(['pageIndex'=>1,'pageSize'=>14])->send('tender/queryIndexBidList');
        $bider_list = [];
        if(empty($resp) || $resp['errcode'] != '0'){
            $bider_list = ['bidNum'=>0,'amount'=>'0'];
        }

        $this->assign('object_info',$object_info);
        $this->assign('bid_info',$bid_info);
        $this->assign('bider_info',$bider_info);
        $this->assign('object_list',$object_list);
        $this->assign('bid_list',$bid_list);
        $this->assign('bider_list',$bider_list);
    }

}
