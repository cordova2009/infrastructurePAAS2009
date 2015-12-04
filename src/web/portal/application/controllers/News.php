<?php
/**
 * @name NewsController
 * @author libaoling
 * @desc 消息控制器
 * @see http://www.php.net/manual/en/class.yaf-controller-abstract.php
*/
class NewsController extends MemberController
{
    
    public function listAction()
    {
        $pageIndex = $this->getRequest()->getQuery('page', 1);
        $pageSize = 10;
        $curl = new Curl();
        $resp = $curl->setData([
            'token' => $this->user['token'],
            'pageIndex' => $pageIndex,
            'pageSize'=>  $pageSize
        ])->send('myMsg/getMsgList');
        $list = [];
        if(check_resp($resp)){
            $list = $resp['data'];
            $page = $this->getPagination($resp['total'], $pageSize);
            $this->assign('page', $page);
        }
        
        $this->assign('list', $list);
        $this->layout->meta_title = '我的消息列表';
    }
    
    public function detailAction()
    {
        
    }
    
}
