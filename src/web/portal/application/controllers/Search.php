<?php
/**
 * @name SearchController
 * @author libaoling
 * @desc 搜索控制器
 * @see http://www.php.net/manual/en/class.yaf-controller-abstract.php
 */
class SearchController extends MallController
{

    private $pageSize = 10;

    /**
     * 投标人搜索
     */
    public function bidderAction()
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
        $this->layout->meta_title = '投标人搜索';
    }

    /**
     * 项目信息搜索
     */
    public function informationlistAction()
    {
        $pageSize = 10;
        $keyword = $this->getRequest()->getQuery('keyword');
        $pageIndex = $this->getRequest()->getQuery('page', 1);

        $tmp = str_replace(array(',', '、', ' '), ',', $keyword);
        $keywords = explode(',', $tmp);

        $curl = new Curl();
        $resp = $curl->setData([
            'keywords' => $keywords,
            'pageIndex' => ($pageIndex==0?1:$pageIndex),
            'pageSize'=> $pageSize
        ])->send('userInformation/queryUserInformationIndexPage');

        $list = [];
        if(check_resp($resp)){
            $list = $resp['list'];
            $page = $this->getPagination($resp['total'], $this->pageSize);
            $this->assign('page', $page);
        }

        $this->assign('keyword', $keyword);
        $this->assign('list', $list);
        $this->layout->meta_title = '项目信息搜索';
    }

    /**
     * 招标项目(工程)搜索
     */
    public function projectAction()
    {
        $keyword = $this->getRequest()->getQuery('keyword');
        $pageIndex = $this->getRequest()->getQuery('page', 0);

        $tmp = str_replace(array(',', '、', ' '), ',', $keyword);
        $keywords = explode(',', $tmp);

        $curl = new Curl();
        $resp = $curl->setData([
            'keywords' => $keywords,
            'pageIndex' => $pageIndex,
            'pageSize'=>  $this->pageSize
        ])->send('tender/queryObjectList_homepage');

        $list = [];
        if(check_resp($resp)){
            $list = $resp['list'];
            $page = $this->getPagination($resp['total'], $this->pageSize);
            $this->assign('page', $page);
        }

        $this->assign('list', $list);
        $this->layout->meta_title = '招标项目搜索';
    }

}
