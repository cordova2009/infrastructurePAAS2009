<?php
/**
 * @name IndexController
 * @author xuebingwang
 * @desc 默认控制器
 * @see http://www.php.net/manual/en/class.yaf-controller-abstract.php
*/
class BidController extends MemberController {

    /**
     * 保存投标文件
     * @param string $sb 是否提交投标申请，yes提交，no不提交
     */
    public function submitBidAction($sb='no'){

        if(!IS_POST){
            $this->error('提交方式不正确！');
        }

        $data = ['token'=>$this->user['token']];

        $data['objectId'] = I('objectId');
        if(empty($data['objectId'])){
            $this->error('参数错误，标的ID不能为空！');
        }

        $data['bidId'] = I('bidId');
        if(empty($data['bidId'])){
            $this->error('参数错误，投标ID不能为空！');
        }

        $data['bidFile'] = I('bidFile');
        if(empty($data['bidFile'])){
            $this->error('技术文件不能为空！');
        }

        $curl = new Curl();
        $resp = $curl->setData($data)->send('bid/submitBid');
        if(check_resp($resp)){
            $this->success('提交投标申请成功',U('/member/bidder/probject'));
        }else{
            $this->error('交投标申请失败！');
        }
    }

    /**
     * 保存撮合手续费
     */
    public function saveMakeMatchBidderBondAction(){

        if(!IS_POST){
            $this->error('提交方式不正确！');
        }

        $data = ['token'=>$this->user['token']];

        $data['objectId'] = I('objectId');
        if(empty($data['objectId'])){
            $this->error('参数错误，标的ID不能为空！');
        }

        $data['bidId'] = I('bidId');
        if(empty($data['bidId'])){
            $this->error('参数错误，投标ID不能为空！');
        }

        $data['makeMatchBidderBondAmount'] = 0;

        $curl = new Curl();
        $resp = $curl->setData($data)->send('bid/saveMakeMatchBidderBond');
        if(check_resp($resp)){
            $this->ajaxReturn(['msg'=>'保存成功','status'=>0,'objectId'=>$data['objectId'],'bidId'=>$data['bidId'],'step'=>4]);
        }else{
            $this->error('保存失败！');
        }
    }

    /**
     * 保存技术标
     */
    public function saveTechnicalStandardAction(){

        if(!IS_POST){
            $this->error('提交方式不正确！');
        }

        $data = ['token'=>$this->user['token']];

        $data['objectId'] = I('objectId');
        if(empty($data['objectId'])){
            $this->error('参数错误，标的ID不能为空！');
        }

        $data['bidId'] = I('bidId');
        if(empty($data['bidId'])){
            $this->error('参数错误，投标ID不能为空！');
        }

        $data['technicalStandardUrl'] = I('technicalStandardUrl');
        if(empty($data['technicalStandardUrl'])){
            $this->error('技术标书附件不能为空！');
        }

        $curl = new Curl();
        $resp = $curl->setData($data)->send('bid/saveTechnicalStandardInfo');
        if(check_resp($resp)){
            $this->ajaxReturn(['msg'=>'保存成功','status'=>0,'objectId'=>$data['objectId'],'bidId'=>$data['bidId'],'step'=>3]);
        }else{
            $this->error('保存失败！');
        }
    }

    /**
     * 保存商务标
     */
    public function saveBusinessStandardAction(){

        if(!IS_POST){
            $this->error('提交方式不正确！');
        }

        $data = ['token'=>$this->user['token']];

        $data['objectId'] = I('objectId');
        if(empty($data['objectId'])){
            $this->error('参数错误，标的ID不能为空！');
        }

        $data['bidId'] = I('bidId');
        if(empty($data['bidId'])){
            $this->error('参数错误，投标ID不能为空！');
        }

        $data['bidAmount'] = price_dispose(I('bidAmount'));
        if(empty($data['bidAmount'])){
            $this->error('项目报价不能为空！');
        }
        $data['projectQuotationUrl'] = I('projectQuotationUrl');
        if(empty($data['projectQuotationUrl'])){
            $this->error('项目报价表附件不能为空！');
        }

        $data['constructionStartDate'] = I('constructionStartDate');
        if(empty($data['constructionStartDate'])){
            $this->error('施工开始日期不能为空！');
        }
        $data['constructionEndDate'] = I('constructionEndDate');
        if(empty($data['constructionEndDate'])){
            $this->error('施工结束日期不能为空！');
        }
        $data['constructionCommitmentUrl'] = I('constructionCommitmentUrl');
        if(empty($data['constructionCommitmentUrl'])){
            $this->error('商务标书不能为空！');
        }

        $curl = new Curl();
        $resp = $curl->setData($data)->send('bid/saveBusinessStandardInfo');
        if(check_resp($resp)){
            $this->ajaxReturn(['msg'=>'保存成功','status'=>0,'objectId'=>$data['objectId'],'bidId'=>$data['bidId'],'step'=>2]);
        }else{
            $this->error('保存失败！');
        }
    }
    /**
     *
     */
    public function requirementAction(){

        $curl               = new Curl();
        $objectId           = I('objectId');
        $data               = ['token'=>$this->user['token']];
        $data['objectId']   = $objectId;

        //查询投标人营业执照
        $resp               = $curl->setData($data)
                                    ->send('bid/queryBidderCompanyInfo');
        if(!check_resp($resp)) {
            $this->error('<a href="'.U('/member/bidder/authInfo').'">您还没有投标人资格，请点击这里进行认证！</a>');
        }
        $this->assign('bidderInfo',$resp['bidderInfo']);

        //查询投标要求基础信息
        $resp = $curl->setData($data)
                    ->send('bid/queryObjectRequirementInfo');
        $cert_name_list = [
            'pmCertification'=>'项目经理证明',
            'constructorCertification'=>'建造师证明',
            'safetyPermit'=>'安全生产许可证明',
            'pmSafetyCertification'=>'项目经理安全生产考核合格证明',
        ];
        $this->assign('cert_name_list',$cert_name_list);

        $safetyInfo=[];
        $peopleRequirement=[];

        if(check_resp($resp)) {
            foreach($resp['bidSafetyInfo'] as $key=>$val){
                $key = lcfirst(str_replace('need','',$key));
                if($val == 'YES'){
                    $safetyInfo[$key] = '<div class="li">'.$cert_name_list[$key].'</div>';
                }
            }

            foreach($resp['bidPeopleRequirement'] as $key=>$val){
                $key = lcfirst(str_replace('need','',$key));
                if($val == 'YES'){
                    $peopleRequirement[$key] = '<div class="li">'.$cert_name_list[$key].'</div>';
                }
            }
        }

        //查询投标人在投标时已有和缺少的资质证书信息
        $resp       = $curl->setData($data)
                            ->send('bid/queryBidderCertificationInfo');
        //
        $this->assign('certificationInfo',$resp['certificationInfo']);

        //保存投标资格审查信息
        if(IS_POST) {
            if(!check_resp($resp)){
                $this->error('投标失败，获取投标资质要求失败！');
            }
            $bidderCertList = I('bidderCertList',[]);

            //这个判断只能判断数量是不是一致
            if(sizeof($bidderCertList) < sizeof($resp['certificationInfo']['requirementList'])){
                $this->error('投标失败，您提交的资质证书与要求不符！');
            }

            $certificationList = [];
            $tmp_array = [];
            foreach($resp['certificationInfo']['requirementList'] as $item){

                //这个判断才是真正判断要求的证书和提交的是否一致
                if(!in_array($item['certificateId'],$bidderCertList)){

                    $this->error('投标失败，缺少'.$item['certificationName']);
                }

                $certificationList[] = [
                    'objReqId'=>$item['certificateId'],
                    'bidderCertificationId'=>$item['certificateId'],
                ];
                $tmp_array[] = $item['certificateId'];
            }
            //将未要求的证书也加入到列表中
            foreach(array_diff($bidderCertList,$tmp_array) as $item){
                $certificationList[] = ['objReqId'=>$item,'bidderCertificationId'=>$item];
            }

            $data['bidId'] = I('bidId');
            $data['certificationList'] = $certificationList;

            array_map(function($key) use ($cert_name_list){
                $value = I($key.'No');
                if(empty($value)){
                    $this->error($cert_name_list[$key].'编号不能为空！');
                }
                $value = I($key.'EndDate');
                if(empty($value)){
                    $this->error($cert_name_list[$key].'有效期不能为空！');
                }
                $value = I($key.'Url');
                if(empty($value)){
                    $this->error('请上传'.$cert_name_list[$key].'附件！');
                }
            },array_keys($safetyInfo),array_keys($peopleRequirement));

            $data['bidSafetyInfo']['needSafetyPermitNo'] = I('safetyPermitNo');
            $data['bidSafetyInfo']['needSafetyPermitEndDate'] = I('safetyPermitEndDate');
            $data['bidSafetyInfo']['needSafetyPermitUrl'] = I('safetyPermitUrl');

            $data['bidSafetyInfo']['needPmSafetyCertificationNo'] = I('pmSafetyCertificationNo');
            $data['bidSafetyInfo']['needPmSafetyCertificationEndDate'] = I('pmSafetyCertificationEndDate');
            $data['bidSafetyInfo']['needPmSafetyCertificationUrl'] = I('pmSafetyCertificationUrl');

            $data['bidPeopleRequirement']['needPmCertificationNo'] = I('pmCertificationNo');
            $data['bidPeopleRequirement']['needPmCertificationEndDate'] = I('pmCertificationEndDate');
            $data['bidPeopleRequirement']['needPmCertificationUrl'] = I('pmCertificationUrl');

            $data['bidPeopleRequirement']['needConstructorCertificationNo'] = I('constructorCertificationNo');
            $data['bidPeopleRequirement']['needConstructorCertificationEndDate'] = I('constructorCertificationEndDate');
            $data['bidPeopleRequirement']['needConstructorCertificationUrl'] = I('constructorCertificationUrl');

            $data['bankGuarantee']['bankGuaranteeAmount'] = price_dispose(I('bankGuaranteeAmount'));
            if(empty($data['bankGuarantee']['bankGuaranteeAmount'])){
                $this->error('投标保函金额不能为空！');
            }
            $data['bankGuarantee']['bankGuaranteeUrl'] = I('bankGuaranteeUrl');
            if(empty($data['bankGuarantee']['bankGuaranteeUrl'])){
                $this->error('请上传保函凭证扫描件！');
            }
            $data['bankGuarantee']['bankGuaranteeNo'] = I('bankGuaranteeNo');
            if(empty($data['bankGuarantee']['bankGuaranteeNo'])){
                $this->error('保函凭证编号不能为空！');
            }

            $resp = $curl->setData($data)->send('bid/saveBidRequirementInfo');
            if(check_resp($resp)){
                $this->ajaxReturn(['msg'=>'保存成功','status'=>0,'objectId'=>$objectId,'bidId'=>$resp['bidId'],'step'=>1]);
            }else{
                $this->error('保存失败！');
            }
        }

        //查询未完成的投标资格审查信息
        $resp = $curl->setData($data)
                        ->send('bid/queryBidRequirementInfo');
        if(!check_resp($resp)) {
            $this->error(isset($resp['errmsg']) ? $resp['errmsg'] : '投标失败，标的不存在！');
        }

        $this->assign('bidRequirementInfo',$resp['bidRequirementInfo']);

        $this->assign('needCertList',['投标人安全生产证明'=>$safetyInfo,'投标人主要人员资质'=>$peopleRequirement]);

        $this->assign('objectId',$objectId);
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
//        if(empty($bidId)){
//            $this->error('参数错误，投标ID不能为空！');
//        }

        $data = ['token'=>$this->user['token'],'objectId'=>$objectId,'bidId'=>$bidId];
        $curl = new Curl();
        $url_list = [
            'businessStandard'=>'bid/queryBusinessStandardInfo',
            'technicalStandard'=>'bid/queryTechnicalStandardInfo',
            'makeMatchBidderBond'=>'bid/queryMakeMatchBidderBond',
            'bidFile'=>'bid/queryBidFile4Submit',
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
            case 'makeMatchBidderBond':
                $resp =$curl1->setData(['token'=>$this->user['token']])
                    ->send('capitalManage/queryProjectAccount');
                if(check_resp($resp)){
                    $this->assign('account',$resp['account']);
                }else{
                    $this->error('投标失败，获取不到您的账户信息，请联系管理员！');
                }
            break;
        }

        $html = $this->render($step);
        $this->ajaxReturn(['status'=>0,'html'=>$html]);
    }

}
