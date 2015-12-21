<?php
/**
 * @name PaymentController
 * @author xuebingwang
 * @desc Payment控制器
 * @see http://www.php.net/manual/en/class.yaf-controller-abstract.php
*/
class PaymentController extends MallController {

    public function callbackAction(){

        $curl = new Curl($this->config->url->api->payment);
        $resp = $curl->setData(['orderId'=>'RM20151221110755638323330'])->send('AlipayPaymentGateway/alipay/queryPayResult');
        var_dump($resp);

        var_dump(I('get.'));
        die;
    }
}
