<?php
namespace Payment;

abstract class AbstractPayment
{
	/**
	 * 收款账号的加密key
	 * @var string
	 * 
	 */
    CONST MERKEY_SALT_POSTFIX = 'GEWRY%&^YAGTER*$%@#QGRTJYT(&%^$&Y^%AQYHTERU%$^&&^UTERHDSFG';
    
    /**
     * 订单
     * @var array
     */
    public $order;

    /**
     * 支付成功
     * @var boolean
     */
    var $payok = false;

    /**
     * 第三方支付单号
     * @var string
     */
    var $trade_no;
    
    /**
     * 支付网关返回的成功支付金额
     * @var float
     */
    var $pay_amount;
    
    /**
     * 收款账号
     * @var object
     */
    var $account = null;
    
    function __construct($payment)
    {	
    	$this->account = $payment;
    	$this->_initialize();
    }
    
    /**
     * 子类实现的构造方法
     */
    protected function _initialize(){}

    /**
     * 子类根据具体的支付接口实现支付后续动作
     * @param bool $isNotify
     * @return string  返回输出的信息, 用于日志记录(可选).
     */
    abstract protected function _doCustomerAfterPay($isNotify=false);

	/**
	 * 
	 * @param array $order
	 * @return AbstractPayment
	 */
    function setOrder($order=array())
    {
        $this->order = $order;
        return $this;
    }
    
    /**
     * 获取表单
     * @return Form
     */
    function beforePay(){}
    
    /**
     * 进行支付
     * 包括申请token 等前置动作
     */
    function doPay(){}
    
    /**
     * @param bool $isNotify
     * @return bool
     * 完成支付后续动作
     */
    function afterPay($isNotify=false){
    	$success = false;

    	//记录请求日志
        if(isset($GLOBALS['HTTP_RAW_POST_DATA'])){

            \SeasLog::debug('notify: '.$GLOBALS['HTTP_RAW_POST_DATA']);
        }else{

            \SeasLog::debug(($isNotify ? 'notify2: ' : 'return: ').var_export($_REQUEST,true));
        }

		$verify_result = $this->_doCustomerAfterPay($isNotify);
		$model = M('t_orders');

		if($verify_result && isset($this->order['sn'])){

    		$where['sn'] 	    = $this->order['sn'];
    		$where['amount'] 	= $this->pay_amount;
    		//数据库查找对应的订单
    		$this->order 		= $model->get('*',['AND'=>$where]);

    		if($this->order && $this->order['status'] == \OrderModel::STATUS_WATI_PAY && $this->order['pay_status'] == \OrderModel::PAY_STATUS_NO_PAY){
    		    //记录订单支付日志
    		    $this->addPayLog();

    		    if($this->payok) {
    		        \SeasLog::debug('付款成功'.var_export($this->order,TRUE));

                    $model = new \Model('t_ucenter_member');
    		        $user 	= $model->get('*',['id'=>$this->order['userid']]);
                    $success = $this->runOrderHook($user);
    		    }

    		}elseif($this->order && $this->order['pay_status'] == \OrderModel::PAY_STATUS_PAYD){
    		    //如果已经完成了付款的订单直接返回true.
    		    $success = true;
    		}else{
    		    \SeasLog::debug('没有找到订单!'.$model->last_query());
    		}
		}

        if(!$success){

            \SeasLog::debug('付款失败,订单信息：'.var_export($this->order,TRUE));
        }
		//如果找到了对应的订单,并且订单状态为未完成  支付状态为未付款

    	return $success;
    }

    /**
     * @param $user
     * @return bool
     * 支付成功后调用订单钩子进行后续处理
     */
    protected function runOrderHook($user)
    {	
    	if(empty($this->order) || empty($user)) {
            return false;
        }
        $data['pay_time'] 	= time_format();
        $data['trade_no'] 	= $this->trade_no;
        $data['pay_code'] 	= $this->account['code'];
        $data['status'] 	= \OrderModel::STATUS_COMPLETED;
        $data['pay_status'] = \OrderModel::PAY_STATUS_PAYD;
        $data['update_time']= time_format();

        //更新订单状态
        $f = M('t_orders')->update($data,['AND'=>['sn'=>$this->order['sn'],'userid'=>$user['id']]]);

        //开始调用发放电子票接口
    	return $f;
    }
    
    /**
     * 写订单付款日志
     * @return bool
     */
    protected function addPayLog()
    {
        $data['sn']	        = $this->order['sn'];
        $data['create_time']= time_format();
        $data['comment']    = time_format()."  使用 {$this->account['code']} 对" . $this->order['sn'] . "订单支付成功,支付金额".price_format($this->pay_amount).'元';
        $data['userid']     = is_login();
        $model = new \Model('t_order_logs');
        return $model->insert($data);
    }
}
