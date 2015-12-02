<?php
/**
 * @name BidderController
 * @author libaoling
 * @desc 投标人控制器
 * @see http://www.php.net/manual/en/class.yaf-controller-abstract.php
*/
class BidderController extends MallController
{
    
    private $_curl = '';
    
    public function init()
    {
        parent::init();
        $this->_curl = new Curl();
    }
    
    /**
     * 投标人列表
     */
    public function listAction()
    {
        
    }

    public function detailAction()
    {
        
    }
    
}
