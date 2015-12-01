<?php
/**
 * @name MallController
 * @author xuebingwang
 * @desc 商城基控制器
 * @see http://www.php.net/manual/en/class.yaf-controller-abstract.php
*/
class MallController extends Yaf\Controller_Abstract {
           
    protected $config;
    protected $layout;
    protected $user;

    protected $waitSecond = 3;

    public function init(){
        $this->config = Yaf\Registry::get('config');

        $this->user = session('user_auth');

        $this->layout = Yaf\Registry::get('layout');
        $this->layout->user = $this->user;
    }

    /**
     * @param $name
     * @param null $value
     */
    protected function assign($name,$value=null){
        $this->getView()->assign($name,$value);
    }

    /**
     * @return string
     */
    protected function getMCA(){
        return $this->getModule().$this->getController().$this->getAction();
    }

    /**
     * 操作错误跳转的快捷方法
     * @access protected
     * @param string $message 错误信息
     * @param string $jumpUrl 页面跳转地址
     * @param mixed $ajax 是否为Ajax方式 当数字时指定跳转时间
     * @return void
     */
    protected function error($message='',$jumpUrl='',$ajax=false) {
        $this->dispatchJump($message,1,$jumpUrl,$ajax);
    }
    
    /**
     * 操作成功跳转的快捷方法
     * @access protected
     * @param string $message 提示信息
     * @param string $jumpUrl 页面跳转地址
     * @param mixed $ajax 是否为Ajax方式 当数字时指定跳转时间
     * @return void
     */
    protected function success($message='',$jumpUrl='',$ajax=false) {
        $this->dispatchJump($message,0,$jumpUrl,$ajax);
    }
    
    /**
     * 默认跳转操作 支持错误导向和正确跳转
     * 调用模板显示 默认为public目录下面的success页面
     * 提示页面为可配置 支持模板标签
     * @param string $message 提示信息
     * @param Boolean $status 状态
     * @param string $jumpUrl 页面跳转地址
     * @param mixed $ajax 是否为Ajax方式 当数字时指定跳转时间
     * @access private
     * @return void
     */
    private function dispatchJump($message,$status=1,$jumpUrl='/',$ajax=false) {
        if(true === $ajax || IS_AJAX) {// AJAX提交
            $data           =   is_array($ajax)?$ajax:array();
            $data['msg']    =   $message;
            $data['status'] =   $status;
            $data['url']    =   $jumpUrl;
            $this->ajaxReturn($data);
        }
        
        //模板没有
//        exit($message);
        $this->getView()->assign('jumpUrl',$jumpUrl);
        //如果设置了关闭窗口，则提示完毕后自动关闭窗口
        $this->getView()->assign('status',$status);   // 状态
        $this->getView()->assign('message',$message);// 提示信息

        $content = '';
        //保证输出不受静态缓存影响
        if($status) { //发送成功信息
            //发生错误时候默认停留3秒
            $this->getView()->assign('waitSecond',$this->waitSecond);
            $this->getResponse()->setBody($this->getView()->render('error.php'));
        }else{
            //默认停留1秒
            $this->getView()->assign('waitSecond',$this->waitSecond-2);
            $this->getResponse()->setBody($this->getView()->render('success.php'));
        }
        $this->layout->postDispatch($this->getRequest(),$this->getResponse());
        $this->getResponse()->response();
        // 中止执行  避免出错后继续执行
        die;
    }

    public function redirect($url){
        parent::redirect($url);
        die;
    }

    public function display($action){
        parent::display($action);
        die;
    }

    /**
     * Ajax方式返回数据到客户端
     * @access protected
     * @param mixed $data 要返回的数据
     * @param String $type AJAX返回数据格式
     * @param int $json_option 传递给json_encode的option参数
     * @return void
     */
    protected function ajaxReturn($data,$type='',$json_option=0) {
        if(empty($type)) $type  =   $this->config->ajax->return;
        switch (strtoupper($type)){
        	case 'JSON' :
        	    // 返回JSON数据格式到客户端 包含状态信息
        	    header('Content-Type:application/json; charset=utf-8');
        	    exit(json_encode($data,$json_option));
        	case 'XML'  :
        	    // 返回xml格式数据
        	    header('Content-Type:text/xml; charset=utf-8');
        	    exit(xml_encode($data));
        	case 'JSONP':
        	    // 返回JSON数据格式到客户端 包含状态信息
        	    header('Content-Type:application/json; charset=utf-8');
        	    $handler  = $this->config->ajax->jsonp->handler;
        	    exit($handler.'('.json_encode($data,$json_option).');');
        	case 'EVAL' :
        	    // 返回可执行的js脚本
        	    header('Content-Type:text/html; charset=utf-8');
        	    exit($data);
        }
    }

    /**
     * 返回当前模块名
     *
     * @access protected
     * @return string
     */
    protected function getModule()
    {
        return $this->getRequest()->module;
    }
    
    /**
     * 返回当前控制器名
     *
     * @access protected
     * @return string
     */
    protected function getController()
    {
        return $this->getRequest()->controller;
    }
    
    /**
     * 返回当前动作名
     *
     * @access protected
     * @return string
     */
    protected function getAction()
    {
        return $this->getRequest()->action;
    }
    
    protected function getPagination($total, $listRows)
    {
        $REQUEST = (array)I('request.');
        $page = new Page($total, $listRows, $REQUEST);
        $page->setConfig('theme','%FIRST% %UP_PAGE% %LINK_PAGE% %DOWN_PAGE% %END%');
        return $page->show();
    }
}
