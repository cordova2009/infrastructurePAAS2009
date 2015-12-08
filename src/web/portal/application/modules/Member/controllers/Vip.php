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

    public function tenderIndexAction(){

    }

    public function buyBidVipAction(){
        $curl = new Curl($this->config->url->api->paas);

        $data = ['token'=>$this->user['token']];
        $data['productId'] = 'BIDDER_MEMBER_STD'; //I('productId');
        /*if(empty($data['productId'])){
            $this->error('获取会员产品失败！');
        }*/

        $resp = $curl->setData($data)->send('member/buyBidderMember');

        if(check_resp($resp)) {

            $this->success('保存成功！',U('/member/info/index'));
        }else{
            $this->error(isset($resp['errmsg']) ? $resp['errmsg'] : '购买投标方会员失败，请重新再试！');
        }

        $this->error(var_export($data,true));

    }

    public function bidVipAction(){

        $curl = new Curl($this->config->url->api->paas);

        if(IS_POST){

            $data = ['token'=>$this->user['token']];

            $data['productId'] = I('productId');
            if(empty($data['productId'])){
                $this->error('获取会员产品失败！');
            }

            $resp = $curl->setData($data)->send('/member/buyBidderMember');

            if(check_resp($resp)) {

                $this->success('保存成功！',U('/member/info/index'));
            }else{
                $this->error(isset($resp['errmsg']) ? $resp['errmsg'] : '购买投标方会员失败，请重新再试！');
            }

            $this->error(var_export($data,true));
        }

        $resp = $curl->setData(['token'=>$this->user['token']])
            ->send('member/queryMemberProduct');
        if(!check_resp($resp)) {
            $this->error("查询用户会员信息失败！");
        }
        $birMember = $resp['birMember'];

        $birMemberExpireTime=$resp['birMemberExpireTime'];
        $results=$resp['results'];
        if(empty($birMember)){
            $this->error("查询用户会员信息失败！");
        }
        if($birMember=='NCP'){
            $this->error("您还未通过投标人资质审核，请到用户管理中心进行投标人申请！");
        }
        if($birMember=='OK#'){
            $this->error("您现在已经是投标人会员，到期时间是：".$birMemberExpireTime);
        }
        $birMember2=[];
        foreach($results as $item ){
            if($item['memberType']=='BIR'){
                $birMember2=$item;
            }
        }
        $this->assign('birMember',$birMember2);


    }

    public function tenderVipAction(){

        $curl = new Curl($this->config->url->api->paas);

        if(IS_POST){

            $data = ['token'=>$this->user['token']];

            $data['productId'] = I('productId');
            if(empty($data['productId'])){
                $this->error('获取会员产品失败！');
            }

            $resp = $curl->setData($data)->send('/member/buyTenderMember');

            if(check_resp($resp)) {

                $this->success('保存成功！',U('/member/info/index'));
            }else{
                $this->error(isset($resp['errmsg']) ? $resp['errmsg'] : '购买招标方会员失败，请重新再试！');
            }

            $this->error(var_export($data,true));
        }

        $resp = $curl->setData(['token'=>$this->user['token']])
            ->send('member/queryMemberProduct');
        if(!check_resp($resp)) {
            $this->error("查询用户会员信息失败！");
        }
        $terMember = $resp['terMember'];

        $terMemberExpireTime=$resp['terMemberExpireTime'];
        $results=$resp['results'];
        if(empty($terMember)){
            $this->error("查询用户会员信息失败！");
        }
        if($terMember=='NCP'){
            $this->error("您还未通过投标人资质审核，请到用户管理中心进行投标人申请！");
        }
        if($terMember=='OK#'){
            $this->error("您现在已经是投标人会员，到期时间是：".$terMemberExpireTime);
        }
        $terMember2=[];
        foreach($results as $item ){
            if($item['memberType']=='TER'){
                $terMember2=$item;
            }
        }
        $this->assign('terMember',$terMember2);


    }

}