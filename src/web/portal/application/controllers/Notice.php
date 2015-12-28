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
        $pageIndex = $this->getRequest()->getQuery('page', 1);
        $pageSize = 10;
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
        $this->layout->meta_title = '公告列表';
    }
    
    public function detailAction()
    {
        $id = $this->getRequest()->get('id', 0);
        print_r($id);exit;
    }
    
}
