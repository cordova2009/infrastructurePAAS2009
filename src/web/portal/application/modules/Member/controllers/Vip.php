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

        $this->assign('product',$this->_get_product($type));
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
        }elseif($resp['birMember'] == 'OK#'){
            $this->error('您现在已经是招标人会员，会员到期时间是：'.$resp['birMemberExpireTime'].'');
        }

        if($type == 'ter' && $resp['terMember'] == 'NCP'){
            $this->error('您还未通过招标人资质审核，请到用户管理中心进行投标人申请！');
        }elseif($resp['birMember'] == 'NCP'){
            $this->error('您还未通过投标人资质审核，请到用户管理中心进行投标人申请！');
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

        $type       = I('type','bir');
        $product    = $this->_get_product($type);

        //默认购买投标人
        $url        = 'member/buyBidderMember';

        //
        if($type == 'ter'){
            $url        = 'member/buyBiddeeMember';
        }

        $data               = ['token'=>$this->user['token']];
        $data['productId']  = $product['productId'];

        $curl               = new Curl();
        $resp               = $curl->setData($data)->send($url);

        if(!check_resp($resp)) {
            $this->error(isset($resp['errmsg']) ? $resp['errmsg'] : '购买投标方会员失败，请重新再试！');
        }
        $order = [
            'sn'=>$resp['orderId'],
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