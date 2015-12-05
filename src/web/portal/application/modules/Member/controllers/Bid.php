<?php
/**
 * @name IndexController
 * @author xuebingwang
 * @desc 默认控制器
 * @see http://www.php.net/manual/en/class.yaf-controller-abstract.php
*/
class BidController extends MemberController {

    /**
     * 默认动作，首页
     * Yaf支持直接把Yaf\Request_Abstract::getParam()得到的同名参数作为Action的形参
     * 对于如下的例子, 当访问http://yourhost/y/index/index/index/name/yantze 的时候, 你就会发现不同
     */
    public function requirementAction(){
        $data = ['token'=>$this->user['token']];
        $curl = new Curl($this->config->url->api->paas);
        //查询投标人营业执照
        $resp1 = $curl->setData(['token'=>$this->user['token']])
            ->send('bid/queryBidderCompanyInfo');
        if(check_resp($resp1)) {
            $bidderInfo = $resp1['bidderInfo'];
        }
        $this->assign('bidderInfo',$bidderInfo);
        //查询投标人资质证书
        $resp2 = $curl->setData(['token'=>$this->user['token']])
            ->send('bid/queryBidRequirementInfo');
        $bidRequirementInfo=[
            'bidderList'=>[],
            'requirementList'=>[],
            'missingList'=>[]
        ];
        if(check_resp($resp2)) {
            $bidRequirementInfo = $resp2['bidRequirementInfo'];
        }
        $this->assign('bidRequirementInfo',$bidRequirementInfo);
        //查询投标要求基础信息
        $resp3 = $curl->setData(['token'=>$this->user['token']])
            ->send('bid/queryObjectRequirementInfo');
        $bidSafetyInfo=[];
        $bidPeopleRequirement=[];
        if(check_resp($resp3)) {
            $bidSafetyInfo = $resp3['bidSafetyInfo'];
            $bidPeopleRequirement = $resp3['bidPeopleRequirement'];
        }
        $this->assign('bidSafetyInfo',$bidSafetyInfo);
        $this->assign('bidPeopleRequirement',$bidPeopleRequirement);

        $objectId='BH2015082135656';
        //保存投标资格审查信息
        if(IS_POST) {

            /*$objectId = I('objectId');
            if (!empty($objectId)) {
                $data['objectId'] = $objectId;
            }*/
            $bidId = I('bidId');
            if (!empty($bidId)) {
                $data['objectId'] = $bidId;
            }


            $resp = $curl->setData($data)->send('bid/saveBidRequirementInfo');
            if(check_resp($resp)){
                $this->ajaxReturn(['msg'=>'保存成功','status'=>0,'objectId'=>$resp['objectId'],'bidId'=>$resp['bidId'],'step'=>1]);
            }else{
                $this->error('保存失败！');
            }
        }
        //查询未完成的投标资格审查信息
        /*"body":
        {
            "token":"43564",
            "bidId":"TB201511040982",
            "objectId":"BH201511010612"
        }*/
        $resp4 = $curl->setData($data)
            ->send('bid/queryBidRequirementInfo');
        $integrity = 0;
        $bidRequirementInfo=[
            'certificationList'=>[]
        ];
        if(check_resp($resp4)) {
            $bidRequirementInfo = $resp4['bidRequirementInfo'];
            $integrity = round((1/11)*100);
        }
        $this->assign('bidRequirementInfo',$bidRequirementInfo);
        $this->assign('integrity',$integrity);

    }

    /**
     *
     */
    public function stepAction(){
        if(!IS_AJAX){
            $this->error('请求方式不正确！');
        }

        $step = I('step','projectInfo');
        $objectId = I('objectId');
        $bidId=I('bidId');
        if(empty($objectId)){
            $this->error('参数错误，标的ID不能为空！');
        }
        if(empty($bidId)){
            $this->error('参数错误，投标ID不能为空！');
        }

        $data = ['token'=>$this->user['token'],'objectId'=>$objectId,'bidId'=>$bidId];
        $curl = new Curl();
        $url_list = [
            'businessStandard'=>'bid/queryBusinessStandardInfo',
            'technicalStandard'=>'bid/queryTechnicalStandardInfo',
            'bidderBond'=>'bid/queryMakeMatchBidderBond',
        ];

        if(!array_key_exists($step,$url_list)){
            $this->error('参数错误，地址不正确！');
        }

        $resp = $curl->setData($data)->send($url_list[$step]);

        $this->assign('resp',$resp);
        $this->assign('objectId',$objectId);
        $this->assign('bidId',$bidId);
        $curl1 = new Curl($this->config->url->api->capital);
        switch($step){
            case 'bidderBond':
                $resp =$curl1->setData(['token'=>$this->user['token']])
                    ->send('capitalManage/queryProjectAccount');
                if(check_resp($resp)){
                    $this->assign('account',$resp['account']);
                }else{
                    $this->assign('account',null);
                }
            break;
        }

        $html = $this->render($step);
        $this->ajaxReturn(['status'=>0,'html'=>$html]);
    }

}
