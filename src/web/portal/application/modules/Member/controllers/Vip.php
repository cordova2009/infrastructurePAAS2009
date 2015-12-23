<?php
/**
 * Created by PhpStorm.
 * User: Timi
 * Date: 2015/12/5
 * Time: 17:14
 */
class VipController extends MemberController {

    public function bidIndexAction(){

    }

    public function terIndexAction(){

    }

    public function buyAction($type='ter'){

        $product = $this->_get_product($type);

        //默认购买投标人
        $url        = 'member/buyBidderMember';
        //
        if($type == 'ter'){
            $url        = 'member/buyBiddeeMember';
        }

        $curl           = new Curl();
        $resp           = $curl->setData(['token'=>$this->user['token'],'productId'=>$product['productId']])
                            ->send($url);

        if(!check_resp($resp) || !isset($resp['orderId'])) {
            $this->error(isset($resp['errmsg']) ? $resp['errmsg'] : '订单提交失败，请重新再试或联系客服人员！');
        }

        $this->assign('orderId',$resp['orderId']);
        $this->assign('product',$product);
        $this->assign('type',$type);
    }

    private function _get_product($type){

        $curl = new Curl();

        $resp = $curl->setData(['token'=>$this->user['token']])
            ->send('member/queryMemberProduct');
        if(!check_resp($resp)) {
            $this->error("查询会员产品信息失败！");
        }

        if($type =='ter' && $resp['terMember'] == 'OK#'){
            $this->error('您现在已经是招标人会员，会员到期时间是：'.$resp['terMemberExpireTime'].'');
        }elseif($type !='ter' && $resp['birMember'] == 'OK#'){
            $this->error('您现在已经是投标人会员，会员到期时间是：'.$resp['birMemberExpireTime'].'');
        }

        if($type == 'ter' && $resp['terMember'] == 'NCP'){
            $this->error('<a href="'.U('/member/biddee/authInfo').'">您还未通过招标人资质审核，请点击这里进行认证！</a>');
        }elseif($type !='ter' && $resp['birMember'] == 'NCP'){
            $this->error('<a href="'.U('/member/bidder/authInfo').'">您还未通过投标人资质审核，请点击这里进行认证！</a>');
        }

        $product = [];
        foreach($resp['results'] as $item ){
            if(strtolower($item['memberType']) == $type){
                $product = $item;
                break;
            }
        }

        if(empty($product)){
            $this->error('会员产品获取失败，请稍后再试！');
        }

        return $product;
    }

    public function payAction(){

        if(!IS_POST){
            $this->error('提交方式不正确，请返回重新提交！');
        }

        $payWay     = I('post.payWay');
        if($payWay != 'ALI'){
            $this->error('暂只支持支付宝支付！');
        }

        $orderId = I('orderId');
        if(empty($orderId)){
            $this->error('订单编号不能为空！');
        }

        $type       = I('type','bir');
        $product    = $this->_get_product($type);

        $order = [
            'sn'=>$orderId,
            'amount'=>$product['productPrice'],
            'desc'=>$product['productDesc'],
            'show_url'=>'',
        ];

//        var_dump($order);die;
        $config = new Yaf\Config\Ini(CONF_PATH.'payment.ini','common');
        $pay_server = new Payment\Alipay\Alipay($config->payment->toArray());

        echo($pay_server->setOrder($order)->doPay());
        die;
    }
}