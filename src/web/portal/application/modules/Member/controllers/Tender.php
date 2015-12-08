<?php
/**
 * @name PublicController
 * @author xuebingwang
 * @desc Public控制器
 * @see http://www.php.net/manual/en/class.yaf-controller-abstract.php
*/
class TenderController extends MemberController{

    /**
     * 保存招标时间要求
     */
    public function saveBidEvaluationTypeInfoAction(){

        if(!IS_POST){
            $this->error('提交方式不正确！');
        }

        $data = ['token'=>$this->user['token']];

        $data['objectId'] = I('objectId');
        if(empty($data['objectId'])){
            $this->error('参数错误，标的ID不能为空！');
        }

        $data2 = $data;

        $data['bidEvaluationType'] = I('bidEvaluationType');
        if(empty($data['bidEvaluationType'])){
            $this->error('请至少选择一种评标方法及标准！');
        }
        $data['bidEvaluationSite'] = I('bidEvaluationSite');
        if(empty($data['bidEvaluationSite'])){
            $this->error('技术标评标地点不能为空！');
        }
        $data['bidWinnerDetermineWay'] = I('bidWinnerDetermineWay');
        if(empty($data['bidWinnerDetermineWay'])){
            $this->error('请至少选择一种中标人的确定方法！');
        }
        $data['voteWinWay'] = I('voteWinWay');
        if(empty($data['voteWinWay'])){
            $this->error('请至少选择一种票决方式！');
        }

        $curl = new Curl();
        $resp = $curl->setData($data)->send('tender/saveBidEvaluationTypeInfo');

        if(check_resp($resp) && check_resp($curl->setData($data2)->send('tender/submitObject'))){
//            $this->ajaxReturn(['msg'=>'标的发布成功','status'=>0,'objectId'=>$data['objectId'],'step'=>10]);
            $this->success('标的发布成功',U('/member/biddee/probject'));
        }else{
            $this->error('保存失败！');
        }
    }

    /**
     * 保存招标时间要求
     */
    public function saveDateRequirementInfoAction(){

        if(!IS_POST){
            $this->error('提交方式不正确！');
        }

        $data = ['token'=>$this->user['token']];

        $data['objectId'] = I('objectId');
        if(empty($data['objectId'])){
            $this->error('参数错误，标的ID不能为空！');
        }

        $data['announcementBeginTime'] = I('announcementBeginTime');
        if(empty($data['announcementBeginTime'])){
            $this->error('公告开始时间不能为空！');
        }
        $data['announcementEndTime'] = I('announcementEndTime');
        if(empty($data['announcementEndTime'])){
            $this->error('公告结束时间不能为空！');
        }
        $data['biddingEndTime'] = I('biddingEndTime');
        if(empty($data['biddingEndTime'])){
            $this->error('投标截止时间不能为空！');
        }
        $data['bidOpenDate'] = I('bidOpenDate');
        if(empty($data['bidOpenDate'])){
            $this->error('开标时间不能为空！');
        }

        $curl = new Curl();
        $resp = $curl->setData($data)->send('tender/saveDateRequirementInfo');
        if(check_resp($resp)){
            $this->ajaxReturn(['msg'=>'保存成功','status'=>0,'objectId'=>$data['objectId'],'step'=>10]);
        }else{
            $this->error('保存失败！');
        }
    }

    /**
     * 保存答疑方式
     */
    public function saveAnswerQuestionAction(){

        if(!IS_POST){
            $this->error('提交方式不正确！');
        }

        $data = ['token'=>$this->user['token']];

        $data['objectId'] = I('objectId');
        if(empty($data['objectId'])){
            $this->error('参数错误，标的ID不能为空！');
        }

        $data['startTime'] = I('startTime');
        if(empty($data['startTime'])){
            $this->error('答疑开始时间不能为空！');
        }
        $data['endTime'] = I('endTime');
        if(empty($data['startTime'])){
            $this->error('答疑结束时间不能为空！');
        }

        $data['QQ'] = I('QQ');
        $data['QQtoken'] = I('QQtoken');
        $data['email'] = I('email');
        $data['telephone'] = I('telephone');
        $data['address'] = I('address');
        $data['addressAnswerTime'] = I('addressAnswerTime');
        $data['addressAnswerDate'] = I('addressAnswerDate');

        $curl = new Curl();
        $resp = $curl->setData($data)->send('tender/saveAnswerMethodInfo');
        if(check_resp($resp)){
            $this->ajaxReturn(['msg'=>'保存成功','status'=>0,'objectId'=>$data['objectId'],'step'=>9]);
        }else{
            $this->error('保存失败！');
        }
    }

    /**
     * 保存招标项目投标文件
     */
    public function saveBidFileTypeInfoAction(){
        if(!IS_POST){
            $this->error('提交方式不正确！');
        }

        $data = ['token'=>$this->user['token']];

        $data['objectId'] = I('objectId');
        if(empty($data['objectId'])){
            $this->error('参数错误，标的ID不能为空！');
        }
        $yes_no = ['NO#','YES'];

        $data['tenderFile'] = I('tenderFile');
        if(empty($data['tenderFile'])){
            $this->error('请上传招标文件！');
        }
        $data['needBusinessStandard'] = $yes_no[intval(I('needBusinessStandard',0))%2];
        $data['needTechnicalStandard'] = $yes_no[intval(I('needTechnicalStandard',0))%2];
        $data['needCertificationCheckupFile'] = $yes_no[intval(I('needCertificationCheckupFile',0))%2];

        $curl = new Curl();
        $resp = $curl->setData($data)->send('tender/saveBidFileTypeInfo');
        if(check_resp($resp)){
            $this->ajaxReturn(['msg'=>'保存成功','status'=>0,'objectId'=>$data['objectId'],'step'=>8]);
        }else{
            $this->error('保存失败！');
        }
    }

    /**
     * 保存招标方式
     */
    public function saveMethodInfoAction(){
        if(!IS_POST){
            $this->error('提交方式不正确！');
        }

        $data = ['token'=>$this->user['token']];

        $data['objectId'] = I('objectId');
        if(empty($data['objectId'])){
            $this->error('参数错误，标的ID不能为空！');
        }

        $data['objectMethod'] = I('objectMethod','PUB');
        if(empty($data['objectMethod'])){
            $data['objectMethod'] = 'PUB';
        }
        //邀请招标
        if($data['objectMethod'] == 'INV'){

        }

        $curl = new Curl();
        $resp = $curl->setData($data)->send('tender/saveObjectMethodInfo');
        if(check_resp($resp)){
            $this->ajaxReturn(['msg'=>'保存成功','status'=>0,'objectId'=>$data['objectId'],'step'=>7]);
        }else{
            $this->error('保存失败！');
        }
    }

    /**
     * 保存保证金要求
     */
    public function saveBondInfoAction(){
        if(!IS_POST){
            $this->error('提交方式不正确！');
        }

        $data = ['token'=>$this->user['token']];

        $data['objectId'] = I('objectId');
        if(empty($data['objectId'])){
            $this->error('参数错误，标的ID不能为空！');
        }

        $data['bidBondAmount'] = price_dispose(I('bidBondAmount',0));
        if(empty($data['bidBondAmount'])){
            $this->error('保证金金额不能为空！');
        }

        $curl = new Curl();
        $resp = $curl->setData($data)->send('tender/saveObjectBondInfo');
        if(check_resp($resp)){
            $this->ajaxReturn(['msg'=>'保存成功','status'=>0,'objectId'=>$data['objectId'],'step'=>6]);
        }else{
            $this->error('保存失败！');
        }
    }

    /**
     * 保存资质证书要求
     */
    public function saveCertificationInfoAction(){
        if(!IS_POST){
            $this->error('提交方式不正确！');
        }

        $data = ['token'=>$this->user['token']];

        $data['objectId'] = I('objectId');
        if(empty($data['objectId'])){
            $this->error('参数错误，标的ID不能为空！');
        }

        $industryList = I('industry');
        $certificateList = I('certificate');
        if(sizeof($industryList) != sizeof($certificateList)){
            $this->error('参数错误，行业与证书类型不一致！');
        }

        $data['bidderCertification'] = [];
        if(!empty($industryList) && !empty($certificateList)){
            foreach($industryList as $key=>$industryId){
                $tmp_array = ['industryId'=>$industryId,'certificateId'=>$certificateList[$key]];
                $data['bidderCertification'][] = $tmp_array;
            }
        }

        $yes_no = ['NO#','YES'];

        $data['needPmCertification'] = $yes_no[intval(I('needPmCertification',0))%2];
        $data['needConstructorCertification'] = $yes_no[intval(I('needConstructorCertification',0))%2];
        $data['needSafetyPermit'] = $yes_no[intval(I('needSafetyPermit',0))%2];
        $data['needPmSafetyCertification'] = $yes_no[intval(I('needPmSafetyCertification',0))%2];

        $curl = new Curl();
        $resp = $curl->setData($data)->send('tender/saveObjectCertificationInfo');
        if(check_resp($resp)){
            $this->ajaxReturn(['msg'=>'保存成功','status'=>0,'objectId'=>$data['objectId'],'step'=>5]);
        }else{
            $this->error('保存失败！');
        }
    }

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
            /******************************国有土地使用证**********************************/
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
            $tmp_array = I('landUseCertificateUrl');
            if(!array_key_exists($constructionProveType,$tmp_array) || empty($tmp_array[$constructionProveType])){
                $this->error('国有土地使用证附件不能为空！');
            }
            $data['landUseCertificateUrl'] = $tmp_array[$constructionProveType];
            /*****************************************************************************/

            /******************************建设用地规划许可证********************************/
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
            $tmp_array = I('constructionLandUsePermitUrl');
            if(!array_key_exists($constructionProveType,$tmp_array) || empty($tmp_array[$constructionProveType])){
                $this->error('建设用地规划许可证附件不能为空！');
            }
            $data['constructionLandUsePermitUrl'] = $tmp_array[$constructionProveType];
            /*****************************************************************************/

            /**********************************建设工程规划许可证***************************/
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
            $tmp_array = I('buildingPermitUrl');
            if(!array_key_exists($constructionProveType,$tmp_array) || empty($tmp_array[$constructionProveType])){
                $this->error('建设工程规划许可证附件不能为空！');
            }
            $data['buildingPermitUrl'] = $tmp_array[$constructionProveType];
            /*****************************************************************************/

            /******************************中标通知书***************************************/
            if($constructionProveType == 'ZCB'){
                $data['letterOfAcceptanceUrl'] = I('letterOfAcceptanceUrl');
                if(empty($data['letterOfAcceptanceUrl'])){
                    $this->error('中标通知书附件不能为空！');
                }
            }
            /*****************************************************************************/

        }elseif($constructionProveType == 'BCP'){
            /***************************建设工程施工许可证***********************************/
            $data['buildingConstructPermitNo'] = I('buildingConstructPermitNo');
            if(empty($data['buildingConstructPermitNo'])){
                $this->error('建设工程施工许可证编号不能为空！');
            }
            $data['buildingConstructPermitEndDate'] = I('buildingConstructPermitEndDate');
            if(empty($data['buildingConstructPermitEndDate'])){
                $this->error('建设工程施工许可证有效期不能为空！');
            }
            $tmp_array = I('buildingConstructPermitUrl');
            if(!array_key_exists($constructionProveType,$tmp_array) || empty($tmp_array[$constructionProveType])){
                $this->error('建设工程施工许可证附件不能为空！');
            }
            $data['buildingConstructPermitUrl'] = $tmp_array[$constructionProveType];
            /*****************************************************************************/
        }

        $curl = new Curl();
        $resp = $curl->setData($data)->send('tender/saveObjectConstructionInfo');
        if(check_resp($resp)){
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
            'methodInfo'=>'tender/queryObjectMethodInfo',
            'bidFileTypeInfo'=>'tender/queryBidFileTypeInfo',
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
