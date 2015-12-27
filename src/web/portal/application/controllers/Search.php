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

}
