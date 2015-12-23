<?php
/**
 * @name PaymentController
 * @author xuebingwang
 * @desc Payment控制器
 * @see http://www.php.net/manual/en/class.yaf-controller-abstract.php
*/
class PaymentController extends MallController {

    public function callbackAction(){

        $orderId = I('out_trade_no');
        if(empty($orderId)){
            $this->error('订单号不能为空！');
        }

        $curl = new Curl($this->config->url->api->payment);
        $resp = $curl->setData(['orderId'=>$orderId])->send('AlipayPaymentGateway/alipay/queryPayResult');
        if(!check_resp($resp) || !isset($resp['result']) || !isset($resp['result']['payResult']) || $resp['result']['payResult'] != 'OK#'){
            $this->error('您的订单尚未支付成功或正在处理中，如有问题，请联系客服人员！');
        }
        $this->success('恭喜您，支付成功！',U('/member/info/index'));
    }
}
