<?php
/**
 * @name BidderController
 * @author libaoling
 * @desc 投标人控制器
 * @see http://www.php.net/manual/en/class.yaf-controller-abstract.php
*/
class BidderController extends MallController
{
    
    private $pageSize = 10;
    
    public function init()
    {
        parent::init();
    }
    
    /**
     * 投标人列表
     */
    public function listAction()
    {
        $keyword = $this->getRequest()->getQuery('keyword');
        $pageIndex = $this->getRequest()->getQuery('page', 1);

        $tmp = str_replace(array(',', '、', ' '), ',', $keyword);
        $keywords = explode(',', $tmp);

        $curl = new Curl();
        $resp = $curl->setData([
            'keywords' => $keywords,
            'pageIndex' => $pageIndex,
            'pageSize'=>  $this->pageSize
        ])->send('tender/queryBidderList_homepage');

        $list = [];
        if(check_resp($resp)){
            $list = $resp['list'];
            $page = $this->getPagination($resp['total'], $this->pageSize);
            $this->assign('page', $page);
        }

        $this->assign('list', $list);
        $this->layout->meta_title = '投标人列表';
    }

    public function detailAction()
    {
        
    }
    
}
