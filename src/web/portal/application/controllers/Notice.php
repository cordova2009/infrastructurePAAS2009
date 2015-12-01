<?php
/**
 * @name NoticeController
 * @author libaoling
 * @desc 公告控制器
 * @see http://www.php.net/manual/en/class.yaf-controller-abstract.php
*/
class NoticeController extends MallController
{
    
    public function listAction()
    {
        $pageIndex = $this->getRequest()->getQuery('page', 0);
        $pageSize = 7;
        $curl = new Curl();
        $resp = $curl->setData([
            'pageIndex' => $pageIndex,
            'pageSize'=>  $pageSize
        ])->send('siteNews/getnoticeList');
        
        $list = [];
        if(check_resp($resp)){
            $list = $resp['list'];
            $page = $this->getPagination($resp['total'], $pageSize);
            $this->assign('page', $page);
        }
        
        $this->assign('list', $list);
    }
    
    public function detailAction()
    {
        
    }
    
}
