<?php
/**
 * @name PublicController
 * @author xuebingwang
 * @desc Public控制器
 * @see http://www.php.net/manual/en/class.yaf-controller-abstract.php
*/
class TenderController extends MemberController{

    /**
     * 保存工期要求
     */
    public function saveRequirementInfoAction(){

        if(!IS_POST){
            $this->error('提交方式不正确！');
        }

        $data = ['token'=>$this->user['token']];

        $data['objectId'] = I('objectId');
        if(empty($data['objectId'])){
            $this->error('参数错误，标的ID不能为空！');
        }

        $data['projectExpectStartDate'] = I('projectExpectStartDate');
        if(empty($data['projectExpectStartDate'])){
            $this->error('请选择计划开工日期！');
        }

        $data['projectExpectPeriod'] = intval(I('projectExpectPeriod'));
        if(empty($data['projectExpectPeriod'])){
            $this->error('标准工期不能为空！');
        }

        $curl = new Curl();
        $resp = $curl->setData($data)->send('tender/saveProjectRequirementInfo');
        if(check_resp($resp)){
            $this->ajaxReturn(['msg'=>'保存成功','status'=>0,'objectId'=>$data['objectId'],'step'=>4]);
        }else{
            $this->error('保存失败！');
        }
    }
    /**
     * 保存工程施工证明
     */
    public function saveConstructionInfoAction(){

        if(!IS_POST){
            $this->error('提交方式不正确！');
        }

        $data = ['token'=>$this->user['token']];

        $data['objectId'] = I('objectId');
        if(empty($data['objectId'])){
            $this->error('参数错误，标的ID不能为空！');
        }

        $constructionProveType = I('constructionProveType');
        if(empty($constructionProveType)){
            $this->error('请至少选择一种施工证明类型！');
        }
        $data['constructionProveType'] = $constructionProveType;

        if($constructionProveType == 'ZCB' || $constructionProveType == 'KFS'){
            $tmp_array = I('landUseCertificateNo');
            if(!array_key_exists($constructionProveType,$tmp_array) || empty($tmp_array[$constructionProveType])){
                $this->error('国有土地使用证编号不能为空！');
            }
            $data['landUseCertificateNo'] = $tmp_array[$constructionProveType];
            $tmp_array = I('landUseCertificateEndDate');
            if(!array_key_exists($constructionProveType,$tmp_array) || empty($tmp_array[$constructionProveType])){
                $this->error('国有土地使用证有效期不能为空！');
            }
            $data['landUseCertificateEndDate'] = $tmp_array[$constructionProveType];
            $data['landUseCertificateUrl'] = I('landUseCertificateUrl');

            $tmp_array = I('constructionLandUsePermitNo');
            if(!array_key_exists($constructionProveType,$tmp_array) || empty($tmp_array[$constructionProveType])){
                $this->error('建设用地规划许可证编号不能为空！');
            }
            $data['constructionLandUsePermitNo'] = $tmp_array[$constructionProveType];
            $tmp_array = I('constructionLandUsePermitEndDate');
            if(!array_key_exists($constructionProveType,$tmp_array) || empty($tmp_array[$constructionProveType])){
                $this->error('建设用地规划许可证有效期不能为空！');
            }
            $data['constructionLandUsePermitEndDate'] = $tmp_array[$constructionProveType];
            $data['constructionLandUsePermitUrl'] = I('constructionLandUsePermitUrl');

            $tmp_array = I('buildingPermitNo');
            if(!array_key_exists($constructionProveType,$tmp_array) || empty($tmp_array[$constructionProveType])){
                $this->error('建设工程规划许可证编号不能为空！');
            }
            $data['buildingPermitNo'] = $tmp_array[$constructionProveType];
            $tmp_array = I('buildingPermitEndDate');
            if(!array_key_exists($constructionProveType,$tmp_array) || empty($tmp_array[$constructionProveType])){
                $this->error('建设工程规划许可证有效期不能为空！');
            }
            $data['buildingPermitEndDate'] = $tmp_array[$constructionProveType];
            $data['buildingPermitUrl'] = I('buildingPermitUrl');

            if($constructionProveType == 'ZCB'){
                $data['letterOfAcceptanceUrl'] = I('letterOfAcceptanceUrl');
            }

            $data['buildingConstructPermitNo'] = '';
            $data['buildingConstructPermitEndDate'] = '';
            $data['buildingConstructPermitUrl'] = '';

        }elseif($constructionProveType == 'BCP'){
            $data['buildingConstructPermitNo'] = I('buildingConstructPermitNo');
            if(empty($data['buildingConstructPermitNo'])){
                $this->error('建设工程施工许可证编号不能为空！');
            }
            $data['buildingConstructPermitEndDate'] = I('buildingConstructPermitEndDate');
            if(empty($data['buildingConstructPermitEndDate'])){
                $this->error('建设工程施工许可证有效期不能为空！');
            }
            $data['buildingConstructPermitUrl'] = I('buildingConstructPermitUrl');
        }

        $curl = new Curl();
        $resp = $curl->setData($data)->send('tender/saveObjectConstructionInfo');
        if(!check_resp($resp)){
            $this->ajaxReturn(['msg'=>'保存成功','status'=>0,'objectId'=>$data['objectId'],'step'=>3]);
        }else{
            $this->error('保存失败！');
        }
    }
    /**
     * 保存工程基本信息
     */
    public function saveProjectInfoAction(){

        if(!IS_POST){
            $this->error('提交方式不正确！');
        }

        $data = ['token'=>$this->user['token']];

        $data['objectId'] = I('objectId');
        if(empty($data['objectId'])){
            $this->error('参数错误，标的ID不能为空！');
        }

        $data['industryId'] = I('industryId');

        $data['projectName'] = I('projectName');
        if(empty($data['projectName'])){
            $this->error('工程名称不能为空！');
        }
        $data['projectSite'] = I('projectSite');
        if(empty($data['projectSite'])){
            $this->error('工程地点不能为空！');
        }
        $data['projectScale'] = I('projectScale');
        if(empty($data['projectScale'])){
            $this->error('工程规模及特征不能为空！');
        }
        $data['employer'] = I('employer');

        $data['employerPrincipal'] = I('employerPrincipal');

        $data['employerTelephone'] = I('employerTelephone');

        $curl = new Curl();
        $resp = $curl->setData($data)->send('tender/saveObjectProjectInfo');
        if(check_resp($resp)){
            $this->ajaxReturn(['msg'=>'保存成功','status'=>0,'objectId'=>$data['objectId'],'step'=>2]);
        }else{
            $this->error('保存失败！');
        }
    }

    /**
     *
     */
    public function baseInfoAction(){

        $curl = new Curl();

        $data = ['token'=>$this->user['token']];
        if(IS_POST){

            $objectId = I('objectId');
            if(!empty($objectId)){
                $data['objectId'] = $objectId;
            }

            $data['objectName'] = I('objectName');
            if(empty($data['objectName'])){
                $this->error('招标项目名称不能为空！');
            }
            $data['biddingNo'] = I('biddingNo');
            if(empty($data['biddingNo'])){
                $this->error('招标项目编号不能为空！');
            }
            $data['objectScope'] = I('objectScope');
            if(empty($data['objectScope'])){
                $this->error('招标项目范围不能为空！');
            }
            $data['biddeeCompanyPrincipal'] = I('biddeeCompanyPrincipal');
            if(empty($data['biddeeCompanyPrincipal'])){
                $this->error('招标经办人不能为空！');
            }
            $data['biddeeCompanyTelephone'] = I('biddeeCompanyTelephone');
            if(empty($data['biddeeCompanyTelephone'])){
                $this->error('招标办公电话不能为空！');
            }
            $data['currency'] = I('currency');
            $data['evaluationAmountVisiable'] = I('evaluationAmountVisiable');

            $data['contractType'] = I('contractType');
            if(empty($data['contractType'])){
                $this->error('承包方式不能为空！');
            }
            $data['evaluationAmount'] = price_dispose(I('evaluationAmount'));
            if(empty($data['evaluationAmount'])){
                $this->error('标的估价不能为空！');
            }

            $curl = new Curl();
            $resp = $curl->setData($data)->send('tender/saveObjectBaseInfo');
            if(check_resp($resp)){
                $this->ajaxReturn(['msg'=>'保存成功','status'=>0,'objectId'=>$resp['objectId'],'step'=>1]);
            }else{
                $this->error('保存失败！');
            }
        }

        $resp = $curl->setData($data)->send('tender/queryObjectBaseInfo');
        $integrity = 0;
        if(check_resp($resp)){

            $this->assign('info',$resp['baseInfo']);
            $integrity = round((1/11)*100);
        }

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
        if(empty($objectId)){
            $this->error('参数错误，标的ID不能为空！');
        }

        $data = ['token'=>$this->user['token'],'objectId'=>$objectId];
        $curl = new Curl();
        $url_list = [
            'projectInfo'=>'tender/queryObjectProjectInfo',
            'constructionInfo'=>'tender/queryObjectConstructionInfo',
            'requirementInfo'=>'tender/queryProjectRequirementInfo',
            'certificationInfo'=>'tender/queryObjectCertificationInfo',
            'bondInfo'=>'tender/queryObjectBondInfo',
            'bidFileTypeInfo'=>'tender/queryBidFileTypeInfo',
            'methodInfo'=>'tender/queryObjectMethodInfo',
            'answerMethodInfo'=>'tender/queryAnswerMethodInfo',
            'dateRequirementInfo'=>'tender/queryDateRequirementInfo',
            'bidEvaluationTypeInfo'=>'tender/queryBidEvaluationTypeInfo',
        ];

        if(!array_key_exists($step,$url_list)){
            $this->error('参数错误，地址不正确！');
        }

        $resp = $curl->setData($data)->send($url_list[$step]);

        $this->assign('resp',$resp);
        $this->assign('objectId',$objectId);

        switch($step){
            case 'projectInfo':
            case 'certificationInfo':
                $resp = $curl->setData(new stdClass())->send('tender/queryCertificateList');
                if(check_resp($resp)){
                    $this->assign('certificateList',$resp['certificateList']);
                }else{
                    $this->assign('certificateList',[]);
                }
            break;
        }

        $html = $this->render($step);
        $this->ajaxReturn(['status'=>0,'html'=>$html]);
    }
}
