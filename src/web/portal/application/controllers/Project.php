<?php
/**
 * @name ProjectController
 * @author libaoling
 * @desc 招标项目控制器
 * @see http://www.php.net/manual/en/class.yaf-controller-abstract.php
*/
class ProjectController extends MallController
{
    private $_curl = '';
    
    public function init()
    {
        parent::init();
        $this->_curl = new Curl();
    }
    
    /**
     * 更多招标项目
     */
    public function listAction()
    {
        
    }

        /**
     * 中标结果列表
     */
    public function bidlistAction()
    {
        $pageSize = 10;
        $pageIndex = $this->getRequest()->getQuery('page', 0);
        
        $resp = $this->_curl->setData([
            'pageIndex' => $pageIndex,
            'pageSize'=>  $pageSize
        ])->send('tender/queryBidIndexList');
        
        $list = [];
        if(check_resp($resp)){
            $list = $resp['list'];
            $page = $this->getPagination($resp['total'], $pageSize);
            $this->assign('page', $page);
        }
        $this->assign('list', $list);
        $this->layout->meta_title = "中标结果列表";
    }
    
    /**
     * 招标详情
     */
    public function detailAction()
    {
        if(empty($this->user)){
            $this->redirect(U('/login'));
        }
        
        $objectId = $this->getRequest()->get('object_id', 0);
        
        $resp = $this->_curl->setData([
            'token' => $this->user['token'],
            'objectId'=> $objectId
        ])->send('bid/queryObjectDetail');
        
        $info = [];
        if(check_resp($resp)){
            $info = $resp['body'];
        }
        
        $this->assign('info', $info);
        
    }
    
}
