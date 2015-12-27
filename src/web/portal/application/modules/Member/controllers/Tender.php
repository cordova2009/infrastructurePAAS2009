<?php
/**
 * @name PublicController
 * @author xuebingwang
 * @desc Public控制器
 * @see http://www.php.net/manual/en/class.yaf-controller-abstract.php
*/
class TenderController extends MemberController{

    public function submitObjectAction(){
        if(!IS_POST){
            $this->error('提交方式不正确！');
        }

        $data = ['token'=>$this->user['token']];

        $data['objectId'] = I('objectId');
        if(empty($data['objectId'])){
            $this->error('参数错误，标的ID不能为空！');
        }

        $curl = new Curl();
        if(check_resp($curl->setData($data)->send('tender/submitObject'))){
            $this->success('标的发布成功',U('/member/biddee/probject'));
        }else{
            $this->error(isset($resp['errmsg']) ? $resp['errmsg'] :'提交招标申请失败！');
        }
    }

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
            $this->error(isset($resp['errmsg']) ? $resp['errmsg'] :'保存失败！');
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
            $this->error(isset($resp['errmsg']) ? $resp['errmsg'] :'保存失败！');
        }
    }

    /**
     * 保存答疑方式
     */
    public function saveAnswerQuestionAction(){

        if(!IS_POST){
            $this->error('提交方式不正确！');
        }

        $data = [];

        $data['token'] = $this->user['token'];

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
        if(!empty($data['telephone']) && !regex($data['telephone'],'telephone')){
            $this->error('电话格式不正确！');
        }
        $data['address'] = I('address');
        $data['addressAnswerTime'] = I('addressAnswerTime');
        $data['addressAnswerDate'] = I('addressAnswerDate');

        $answer_type = I('answer_type');
        if(empty($answer_type)
            ||(empty($data['QQ'])
            && empty($data['QQ'])
            && empty($data['QQtoken'])
            && empty($data['email'])
            && empty($data['telephone'])
            && empty($data['address'])
            && empty($data['address'])
            && empty($data['addressAnswerTime'])
            && empty($data['addressAnswerDate'])
            )
        ){
            $this->error('请选择一种答疑方式');
        }

        $curl = new Curl();
        $resp = $curl->setData($data)->send('tender/saveAnswerMethodInfo');
        if(check_resp($resp)){
            $this->ajaxReturn(['msg'=>'保存成功','status'=>0,'objectId'=>$data['objectId'],'step'=>9]);
        }else{
            $this->error(isset($resp['errmsg']) ? $resp['errmsg'] :'保存失败！');
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
            $this->error(isset($resp['errmsg']) ? $resp['errmsg'] :'保存失败！');
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
            $bidderId = I('bidderId',[]);
            $bidderName = I('bidderName',[]);
            if(empty($bidderId) || empty($bidderName)){
                $this->error('招标方式为邀请招标时，邀请投标方不能为空！');
            }
            if(sizeof($bidderId) != sizeof($bidderName)){
                $this->error('保存失败，邀请方参数错误！');
            }
            foreach($bidderId as $key=>$one){
                $data['inviteTender'][] = ['bidderId'=>$one,'bidderName'=>$bidderName[$key]];
            }
        }

        $curl = new Curl();
        $resp = $curl->setData($data)->send('tender/saveObjectMethodInfo');
        if(check_resp($resp)){
            $this->ajaxReturn(['msg'=>'保存成功','status'=>0,'objectId'=>$data['objectId'],'step'=>7]);
        }else{
            $this->error(isset($resp['errmsg']) ? $resp['errmsg'] :'保存失败！');
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
        if($data['bidBondAmount'] < 0){
            $this->error('保证金金额不能小于0元！');
        }

        $curl = new Curl();
        $resp = $curl->setData($data)->send('tender/saveObjectBondInfo');
        if(check_resp($resp)){
            $this->ajaxReturn(['msg'=>'保存成功','status'=>0,'objectId'=>$data['objectId'],'step'=>6]);
        }else{
            $this->error(isset($resp['errmsg']) ? $resp['errmsg'] :'保存失败！');
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
            $this->error(isset($resp['errmsg']) ? $resp['errmsg'] :'保存失败！');
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
            $this->error(isset($resp['errmsg']) ? $resp['errmsg'] :'保存失败！');
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

        $type = I('constructionProveType');
        if(empty($type)){
            $this->error('请至少选择一种施工证明类型！');
        }
        $data['constructionProveType'] = $type;

        if($type == 'ZCB' || $type == 'KFS'){

            /******************************国有土地使用证**********************************/
            $tmp_array = I('landUseCertificateNo');
            if(!array_key_exists($type,$tmp_array) || empty($tmp_array[$type])){
                $this->error('国有土地使用证编号不能为空！');
            }
            $data['landUseCertificateNo'] = $tmp_array[$type];
            $tmp_array = I('landUseCertificateEndDate');
            if(!array_key_exists($type,$tmp_array) || empty($tmp_array[$type])){
                $this->error('国有土地使用证有效期不能为空！');
            }
            $data['landUseCertificateEndDate'] = $tmp_array[$type];
            $tmp_array = I('landUseCertificateUrl');
            if(!array_key_exists($type,$tmp_array) || empty($tmp_array[$type])){
                $this->error('国有土地使用证附件不能为空！');
            }
            $data['landUseCertificateUrl'] = $tmp_array[$type];
            /*****************************************************************************/

            /**************建设用地规划许可证**************建设工程规划许可证******************/

            $no_array1 = I('constructionLandUsePermitNo');
            $no_array2 = I('buildingPermitNo');

            $date_array1 = I('constructionLandUsePermitEndDate');
            $date_array2 = I('buildingPermitEndDate');

            $fj_array1 = I('constructionLandUsePermitUrl');
            $fj_array2 = I('buildingPermitUrl');

            if(
                !(!empty($no_array1[$type]) && !empty($date_array1[$type]) && !empty($fj_array1[$type]))
                &&
                !(!empty($no_array2[$type]) && !empty($date_array2[$type]) && !empty($fj_array2[$type]))
            ){
                $this->error('建设用地规划许可证和建设工程规划许可证必须填写一项！');
            }

            $data['constructionLandUsePermitNo'] = $no_array1[$type];
            $data['constructionLandUsePermitEndDate'] = $date_array1[$type];
            $data['constructionLandUsePermitUrl'] = $fj_array1[$type];

            $data['buildingPermitNo'] = $no_array2[$type];
            $data['buildingPermitEndDate'] = $date_array2[$type];
            $data['buildingPermitUrl'] = $fj_array2[$type];

            /******************************中标通知书***************************************/
            if($type == 'ZCB'){
                $data['letterOfAcceptanceUrl'] = I('letterOfAcceptanceUrl');
                if(empty($data['letterOfAcceptanceUrl'])){
                    $this->error('中标通知书附件不能为空！');
                }
            }
            /*****************************************************************************/

        }elseif($type == 'BCP'){
            /***************************建设工程施工许可证***********************************/
            $data['buildingConstructPermitNo'] = I('buildingConstructPermitNo');
            if(empty($data['buildingConstructPermitNo'])){
                $this->error('建设工程施工许可证编号不能为空！');
            }
            $data['buildingConstructPermitEndDate'] = I('buildingConstructPermitEndDate');
            if(empty($data['buildingConstructPermitEndDate'])){
                $this->error('建设工程施工许可证有效期不能为空！');
            }
            $data['buildingConstructPermitUrl'] = I('buildingConstructPermitUrl');
            if(empty($data['buildingConstructPermitUrl'])){
                $this->error('建设工程施工许可证附件不能为空！');
            }
            /*****************************************************************************/
        }

        $curl = new Curl();
        $resp = $curl->setData($data)->send('tender/saveObjectConstructionInfo');
        if(check_resp($resp)){
            $this->ajaxReturn(['msg'=>'保存成功','status'=>0,'objectId'=>$data['objectId'],'step'=>3]);
        }else{
            $this->error(isset($resp['errmsg']) ? $resp['errmsg'] :'保存失败！');
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
        if(!empty($data['employerTelephone'])&&!regex($data['employerTelephone'],'telephone')){
            $this->error('建设单位办公电话格式不正确！');
        }

        $curl = new Curl();
        $resp = $curl->setData($data)->send('tender/saveObjectProjectInfo');
        if(check_resp($resp)){
            $this->ajaxReturn(['msg'=>'保存成功','status'=>0,'objectId'=>$data['objectId'],'step'=>2]);
        }else{
            $this->error(isset($resp['errmsg']) ? $resp['errmsg'] :'保存失败！');
        }
    }

    /**
     *
     */
    public function baseInfoAction(){

        $curl = new Curl();

        $data = ['token'=>$this->user['token']];

        $resp = $curl->setData($data)->send('tender/isInvitationOfTender');
        if(!check_resp($resp)){
            $this->error('<a href="'.U('/member/biddee/authInfo').'">您还没有招标人资格，请点击这里进行认证！</a>',U('/member/biddee/authInfo'));
        }

        $resp = $curl->setData($data)->send('member/queryMemberProduct');
        if(!check_resp($resp)) {
            $this->error('查询会员信息失败，请稍后再试或联系网站客服人员！');
        }

        if($resp['terMember'] != 'OK#'){
            $this->error('<a href="'.U('/member/vip/terIndex').'">您还不是招标人会员，请先充值购买！</a>',U('/member/vip/terIndex'));
        }

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
            if(!regex($data['biddeeCompanyTelephone'],'telephone')){
                $this->error('招标办公电话格式不正确！');
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
                $this->error(isset($resp['errmsg']) ? $resp['errmsg'] :'保存失败！');
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

                $industryList = [];
                if(check_resp($resp)){
                    foreach($resp['certificateList'] as $industry){
                        $industryList[$industry['industryId']] = $industry;
                    }
                }

                $this->assign('industryList',$industryList);
            break;
            case 'methodInfo':
                $resp = $curl->setData(new stdClass())->send('tender/queryBidderList');

                $bidderList = [];
                if(check_resp($resp)){
                    foreach($resp['list'] as $item){
                        $bidderList[$item['bidderId']] = $item;
                    }
                }

                $this->assign('bidderList',$bidderList);
                break;
        }

        $html = $this->render($step);
        $this->ajaxReturn(['status'=>0,'html'=>$html]);
    }
}
