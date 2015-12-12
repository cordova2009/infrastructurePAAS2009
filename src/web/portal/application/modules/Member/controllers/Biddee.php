<?php
/**
 * @name PublicController
 * @author xuebingwang
 * @desc Public控制器
 * @see http://www.php.net/manual/en/class.yaf-controller-abstract.php
*/
class BiddeeController extends MemberController{


	var $pageSize=10;

    public function authInfoAction(){
	    $token = isset($this->user['token'])?$this->user['token']:'';
            $curl = new Curl($this->config->url->api->paas);
            $resp = $curl->setData(['token'=>$token])->send('myBiddee/authInfo/getAuthInfo');
            if(!check_resp($resp)) {
		 $this->redirect(U('/login'));
            }
	    if(empty($resp['datail'])||empty($resp['overall']))
	    {
		  //  $this->redirect(U('applyfor'));
	    }
	    $this->assign('datail',isset($resp['datail'])?$resp['datail']:[]);
	    $this->assign('overall',isset($resp['overall'])?$resp['overall']:[]);
	    $this->layout->meta_title = '认证信息';
    }
    public function applyforAction()
    {
	    $token = isset($this->user['token'])?$this->user['token']:'';
            $curl = new Curl($this->config->url->api->paas);
            $base = $curl->setData(['token'=>$token])->send('myBiddee/authInfo/getBaseInfo_apply');
            $legal= $curl->setData(['token'=>$token])->send('myBiddee/authInfo/getLegalPersonInfo_apply');
            $registered = $curl->setData(['token'=>$token])->send('myBiddee/authInfo/getRegisteredInfo_apply');
            $bank = $curl->setData(['token'=>$token])->send('myBiddee/authInfo/getBankInfo_apply');
	    $this->assign('bankInfo',isset($bank['bankInfo'])?$bank['bankInfo']:'');
	    $this->assign('base',isset($base['baseInfo'])?$base['baseInfo']:'');
	    $this->assign('registered',isset($registered['registeredInfo'])?$registered['registeredInfo']:'');
	    $this->assign('legal',isset($legal['legalPerson'])?$legal['legalPerson']:'');
	    //$name = decrypt($legal['legalPerson']['name'],$this->config->api->app->appKey);
	    //$idcard = decrypt($legal['legalPerson']['idCard'],$this->config->api->app->appKey);
	    //$this->assign('name',$name);
	    //$this->assign('idcard',$idcard);
	    $this->layout->meta_title = '申请认证信息';
    }
    public function submitapplyAction()
    {
	    if(IS_POST)
	    {
		    $token = isset($this->user['token'])?$this->user['token']:'';
		    $curl = new Curl($this->config->url->api->paas);
		    $resp = $curl->setData(['token'=>$token])->send('myBiddee/authInfo/applay');
		    if(check_resp($resp)) {
			    $this->success('保存成功！');
		    }else{
			    $this->error(isset($resp['errmsg']) ? $resp['errmsg'] : '数据保存失败，请重新再试！');
		    }
	    }
	    $token = isset($this->user['token'])?$this->user['token']:'';
	    $curl = new Curl($this->config->url->api->paas);
	    $resp = $curl->setData(['token'=>$token])->send('myBiddee/authInfo/getApplication');
	    if($resp['errcode']==1)
	    {
		    $this->redirect(U('/login'));
	    }
	    $this->assign('bank',$resp['bankInfo']);
	    $this->assign('base',$resp['baseInfo']);
	    $this->assign('registered',$resp['registeredInfo']);
	    $this->assign('legal',$resp['legalPerson']);
	    //$name = decrypt($resp['legalPerson']['name'],$this->config->api->app->appKey);
	    //$idcard = decrypt($resp['legalPerson']['idCard'],$this->config->api->app->appKey);
	    //$this->assign('name',$name);
	    //$this->assign('idcard',$idcard);
	    $this->layout->meta_title = '提交申请认证信息';
    }
    public function doapplyAction()
    {
	    $type=I('type');
	    if($type=='base')
	    {
		    $this->savebaseInfo();
	    }
	    if($type=='legal')
	    {
		    $this->savelegal();
	    }
	    if($type=='companyRegistered')
	    {
		    $this->companyRegistered();
	    }
	    if($type=='bankInfo')
	    {
		    $this->savebank();
	    }
	    exit;
    }
    private function savelegal()
    {
	    $name = I('name');
	    if(empty($name)){
		    $this->error('法人名称不能为空！');
	    }
	    $idCard = I('idCard');
	    if(empty($idCard)){
		    $this->error('法人身份证号不能为空！');
	    }
	    $idCardfrontUrl = I('idCardfrontUrl');
	    if(empty($idCardfrontUrl)){
		    $this->error('法人身份证照片不能为空！');
	    }
	    $idCardBackUrl= I('idCardBackUrl');
	    if(empty($idCardBackUrl)){
		    $this->error('法人身份证照片不能为空！');
	    }
	    $authorityBookUrl = I('authorityBookUrl');
	    $token = isset($this->user['token'])?$this->user['token']:'';
	    $curl = new Curl($this->config->url->api->paas);
	    //$name = encrypt($name,$this->config->api->app->appKey);
	    //$idCard = encrypt($idCard,$this->config->api->app->appKey);
	    $resp = $curl->setData(['token'=>$token,'legalPerson'=>['name'=>$name,'idCard'=>$idCard,'idCardfrontUrl'=>$idCardfrontUrl,'idCardBackUrl'=>$idCardBackUrl,'authorityBookUrl'=>$authorityBookUrl]])->send('myBiddee/authInfo/saveLegalPersonInfo_apply');
	    if(check_resp($resp)) {
		    $this->success('保存成功！');
	    }else{
		    $this->error(isset($resp['errmsg']) ? $resp['errmsg'] : '数据保存失败，请重新再试！');
	    }
    }
    private function companyRegistered()
    {
	    $date['businessLicenseType'] = I('businessLicenseType');
	    if($date['businessLicenseType']=='OLD'){
		    $date['businessLicenseNum'] = I('businessLicenseNum');
		    if(empty($date['businessLicenseNum'])){
			    $this->error('营业执照号码不能为空！');
		    }
		    $date['businessLicenseUrl']= I('businessLicenseUrl');
		    if(empty($date['businessLicenseUrl'])){
			    $this->error('营业执照扫描件不能为空！');
		    }
		    $date['taxRegistrationNum']= I('taxRegistrationNum');
		    if(empty($date['taxRegistrationNum'])){
			    $this->error('税务登记证号码不能为空！');
		    }
		    $date['taxRegistrationUrl']= I('taxRegistrationUrl');
		    if(empty($date['taxRegistrationUrl'])){
			    $this->error('税务登记证扫描件不能为空！');
		    }
		    $date['organizationCodeNum']= I('organizationCodeNum');
		    if(empty($date['organizationCodeNum'])){
			    $this->error('组织机构代码证号码不能为空！');
		    }
		    $date['organizationCodeUrl']= I('organizationCodeUrl');
		    if(empty($date['organizationCodeUrl'])){
			    $this->error('组织机构代码证扫描件不能为空！');
		    }
		    $date['newBusinessLicenseNum']='';
		    $date['newBusinessLicenseUrl']= '';
	    }else{
		    $date['newBusinessLicenseNum'] = I('newBusinessLicenseNum');
		    if(empty($date['newBusinessLicenseNum'])){
			    $this->error('统一社会信用代码不能为空！');
		    }
		    $date['newBusinessLicenseUrl']= I('newBusinessLicenseUrl');
		    if(empty($date['newBusinessLicenseUrl'])){
			    $this->error('统一社会信用代码扫描件不能为空！');
		    }
		    $date['businessLicenseNum']= '';
		    $date['businessLicenseUrl']= '';
		    $date['taxRegistrationNum']= '';
		    $date['taxRegistrationUrl']= '';
		    $date['organizationCodeNum']= '';
		    $date['organizationCodeUrl']= '';
	    }
	    $date['businessScope']= I('businessScope');
	    if(empty($date['businessScope'])){
		    $this->error('经营范围不能为空！');
	    }
	    $date['regTime']= I('regTime');
	    if(empty($date['regTime'])){
		    $this->error('成立时间不能为空！');
	    }
	    $date['businessLicenseExpireTime']= I('businessLicenseExpireTime');
	    if(empty($date['businessLicenseExpireTime'])){
		    $this->error('营业期限不能为空！');
	    }
	    $date['address'] = I('address');
	    if(empty($date['address'])){
		    $this->error('公司地址不能为空！');
	    }
	    $token = isset($this->user['token'])?$this->user['token']:'';
	    $curl = new Curl($this->config->url->api->paas);
	    $resp = $curl->setData(['token'=>$token,'registeredInfo'=>$date])->send('myBiddee/authInfo/saveRegisteredInfo_apply');
	    if(check_resp($resp)) {
		    $this->success('保存成功！');
	    }else{
		    $this->error(isset($resp['errmsg']) ? $resp['errmsg'] : '数据保存失败，请重新再试！');
	    }
    }
    private function savebaseInfo()
    {
	    $companyName = I('companyName');
	    if(empty($companyName)){
		    $this->error('公司全称不能为空！');
	    }
	    $shortName = I('shortName');
	    if(empty($shortName)){
		    $this->error('公司简称不能为空！');
	    }
	    $description = I('description');
	    if(empty($description)){
		    $this->error('公司简介不能为空！');
	    }
	    $logoUrl = I('logoUrl');
	    if(empty($logoUrl)){
		    $this->error('公司LOGO不能为空！');
	    }
	    $registeredCapital = I('registeredCapital');
	    $telephone = I('telephone');
	    if(empty($telephone)){
		    $this->error('办公电话不能为空！');
	    }
	    $email = I('email');
	    if(empty($email)){
		    $this->error('电子邮箱不能为空！');
	    }
	    $token = isset($this->user['token'])?$this->user['token']:'';
	    $curl = new Curl($this->config->url->api->paas);
	    $resp = $curl->setData(['token'=>$token,'baseInfo'=>['logoUrl'=>$logoUrl,'companyName'=>$companyName,'shortName'=>$shortName,'description'=>$description,'registeredCapital'=>$registeredCapital,'telephone'=>$telephone,'email'=>$email]])->send('myBiddee/authInfo/saveBaseInfo_apply');
	    if(check_resp($resp)) {
		    $this->success('保存成功！');
	    }else{
		    $this->error(isset($resp['errmsg']) ? $resp['errmsg'] : '数据保存失败，请重新再试！');
	    }
    }
    private function savebank()
    {
	    $bank= I('bank');
	    if(empty($bank)){
		    $this->error('开户银行不能为空！');
	    }
	    $accountId= I('accountId');
	    if(empty($accountId)){
		    $this->error('银行账号不能为空！');
	    }
	    $accountName= I('accountName');
	    $token = isset($this->user['token'])?$this->user['token']:'';
	    $curl = new Curl($this->config->url->api->paas);
	    $resp = $curl->setData(['token'=>$token,'bankInfo'=>['bank'=>$bank,'accountId'=>$accountId,'accountName'=>$accountName]])->send('myBiddee/authInfo/saveBankInfo');
	    if(check_resp($resp)) {
		    $this->success('保存成功！');
	    }else{
		    $this->error(isset($resp['errmsg']) ? $resp['errmsg'] : '数据保存失败，请重新再试！');
	    }
    }
    public function probjectAction()
    {
	    $token = $this->user['token'];
	    $curl = new Curl($this->config->url->api->paas);
	    $resp = $curl->setData(['token'=>$token])->send('tender/queryMyObjectSurvey');
	    if(check_resp($resp)) {
		    $this->assign('bidingNum',$resp['bidingNum']);
		    $this->assign('doingNum',$resp['doingNum']);
		    $this->assign('doneNum',$resp['doneNum']);
	    }
	    $this->assign('pageIndex',I('pageIndex'));
	    $this->assign('type',I('type','biding'));
    }
    private function getIndustrys()
    {
	    $tmp = [];
	    $token = $this->user['token'];
	    $curl = new Curl($this->config->url->api->paas);
	    $resp = $curl->setData(['token'=>$token])->send('tender/getIndustryList');
	    if(check_resp($resp)) {
		    foreach($resp['list'] as $v)
		    {
			    $tmp[$v['industryId']] = ['industryIcon'=>$v['industryIcon'],'industryName'=>$v['industryName']];
		    }
	    }
	    return $tmp;
    }
    public function getProbjectAction()
    {
	    $i = I('pageIndex');
	    $type = I('type');
	    if(empty($type))
	    {
		    $type = 'biding';
	    }
	    $func = 'queryMyTenderObject';
	    if($type=='biding')
	    {
		    $func = 'queryMyTenderObject';
	//    $html = $this->render($type,['page'=>'',$type=>[['industryId'=>'3','objectName'=>'ass','evaluationAmount'=>100,'projectExpectStartDate'=>'2015-01-01','projectExpectPeriod'=>300,'biddingEndTime'=>'2015-02-01','objectId'=>'asdf']],'industry'=>'']);
	  //  $this->ajaxReturn(['errcode'=>0,'errmsg'=>'OK','html'=>$html]);
	    }
	    if($type=='doing')
	    {
		    $func = 'queryMyBuildingObject';
	    }
	    if($type=='done')
	    {
		    $func = 'queryMyEndedObject';
	    }
	    $p = $this->pageSize;
	    $i = $i==''?0:$i;
	    $token = $this->user['token'];
	    $curl = new Curl($this->config->url->api->paas);
	    $resp  = $curl->setData(['token'=>$token,'pageSize'=>$p,'pageIndex'=>$i])->send('tender/'.$func);
	    $page = $this->getPagination($resp['total'], $this->pageSize);
	    $ret = $this->getIndustrys();
	    $html = $this->render($type,['page'=>$page,$type=>$resp['list'],'industry'=>$ret]);
	    $this->ajaxReturn(['errcode'=>0,'errmsg'=>'OK','html'=>$html]);
    }
    public function surveyAction()
    {
	    $id=I('id');
	    if(IS_AJAX)
	    {
		    $payType = I('payType');
		    $payPeriod = I('payPeriod');
		    $winBidId= I('winBidId');
		    $objectId= I('objectId');
		    $data = [];
		    if($payType=='ONE')
		    {
			    $payDate=I('payDate_one');
			    $paySum=I('paySum_one');
			    $data[]= ['paySum'=>$paySum,'payDate'=>$payDate,'period'=>1];
		    }
		    if($payType=='PID')
		    {
			    $d = I('payDate_pid');
			    $s = I('paySum_pid');
			    $i = I('period_pid');
			    foreach($d as $k=>$v)
			    {
				    $data[]=['paySum'=>$s[$k],'payDate'=>$d[$k],'period'=>$i[$k] ];
			    }
		    }
		    if($payType=='MON')
		    {
			    $d = I('payDate_mon');
			    $s = I('paySum_mon');
			    $i = I('period_mon');
			    foreach($d as $k=>$v)
			    {
				    $data[]=['paySum'=>$s[$k],'payDate'=>$d[$k],'period'=>$i[$k] ];
			    }
		    }
		    if($payType=='CUM')
		    {
			    $d = I('payDate_cum');
			    $s = I('paySum_cum');
			    $i = I('period_cum');
			    foreach($d as $k=>$v)
			    {
				    $data[]=['paySum'=>$s[$k],'payDate'=>$d[$k],'period'=>$i[$k] ];
			    }
		    }

		    $token = $this->user['token'];
		    $curl = new Curl($this->config->url->api->paas);
		    $resp = $curl->setData(['token'=>$token,'objectId'=>$objectId,'winBidId'=>$winBidId,'paymentInfo'=>['payType'=>$payType,'payPeriod'=>$payPeriod,'payList'=>$data]])->send('tender/bidEvaluation');
		    if(check_resp($resp)) {
			    $this->success('保存成功！');
		    }else{
			    $this->error(isset($resp['errmsg']) ? $resp['errmsg'] : '数据保存失败，请重新再试！');
		    }
	    }
/*
$this->assign('survery',['bidderNum'=>5,'objectName'=>'asdf','maxBidAmount'=>200,'minBidAmount'=>100]);
$this->assign('list',[['bidId'=>1,'bidderCompanyName'=>'asf','bidderId'=>'123123','bidTime'=>'2015-05-03','bidAmount'=>200,'projectExpectStartDate'=>'2015-09-09','projectExpectPeriod'=>200,'fileUrl'=>'asf','certificationList'=>[['certificationId'=>2,'certificationName'=>'一级建造']]]]);
$this->assign('page', '');
return;
*/
	    $token = isset($this->user['token'])?$this->user['token']:'';
	    $curl = new Curl($this->config->url->api->paas);
	    $resp = $curl->setData(['token'=>$token,'objectId'=>$id])->send('tender/queryMyObjectTenderSurvey');
	    if(check_resp($resp)) {
		    $this->assign('survey',$resp['survey']);
	    }else{
		//    $this->error(isset($resp['errmsg']) ? $resp['errmsg'] : '数据保存失败，请重新再试！');
	    }
	    $i = I('pageIndex');
	    $p = $this->pageSize;
	    $i = $i==''?0:$i;
	    $curl = new Curl($this->config->url->api->paas);
	    $resp = $curl->setData(['token'=>$token,'pageSize'=>$p,'pageIndex'=>$i,'objectId'=>$id])->send('tender/queryMyObjectBidList');
	    $this->assign('list',$resp['list']);
	    $page = $this->getPagination($resp['total'], $this->pageSize);
	    $this->assign('page', $page);
    }
    public function evaluateAction()
    {
	    $id=I('id');
	    if(IS_POST)
	    {
		    $s = I('evaluateScore');
		    $c = I('evaluateContent');
		    $t = I('tags',[]);
		    $token = isset($this->user['token'])?$this->user['token']:'';
		    $curl = new Curl($this->config->url->api->paas);
		    $resp = $curl->setData(['token'=>$token,'evaluateScore'=>$s,'tags'=>$t,'evaluateContent'=>$c])->send('bid/evaluateBiddee');
		    if(check_resp($resp)) {
			    $this->success('保存成功！');
		    }else{
			    $this->error(isset($resp['errmsg']) ? $resp['errmsg'] : '数据保存失败，请重新再试！');
		    }
	    }
	    $token = isset($this->user['token'])?$this->user['token']:'';
	    $curl = new Curl($this->config->url->api->paas);
	    $resp = $curl->setData(['token'=>$token,'objectId'=>$id])->send('bid/queryTendererEvaluate');
	    if(check_resp($resp)) {
		    $this->assign('evaluate',$resp['evaluateInfo']);
	    }else{
		//    $this->error(isset($resp['errmsg']) ? $resp['errmsg'] : '数据保存失败，请重新再试！');
	    }
    }
    public function incomeAction()
    {
	    $token = $this->user['token'];
	    $curl = new Curl($this->config->url->api->paas);
	    $resp = $curl->setData(['token'=>$token])->send('myPayment/getMyPaymentOverall');
	    if(check_resp($resp)) {
		    $this->assign('income',$resp['overall']);
	    }
	    $p = $this->pageSize;
	    $i = empty($i)?1:$i;
	    $resp = $curl->setData(['token'=>$token,'pageSize'=>$p,'pageIndex'=>$i])->send('myPayment/queryMyPaymentList');
	    if(check_resp($resp)) {
		    $this->assign('list',$resp['list']);
		    $page = $this->getPagination($resp['total'], $this->pageSize);
		    $this->assign('page', $page);
		    $this->assign('pageIndex',I('pageIndex'));
	    }
    }
    public function paymentAction()
    {
	    if(IS_POST)
	    {
		    $data['amount'] = I('amount');
		    if(empty($data['amount'])){
			    $this->error('付款金额不能为空！');
		    }
		    $data['transferTime'] = I('transferTime');
		    if(empty($data['transferTime'])){
			    $this->error('付款时间不能为空！');
		    }
		    $data['bankName'] = I('bankName');
		    if(empty($data['bankName'])){
			    $this->error('转账银行名称不能为空！');
		    }
		    $data['voucherNo'] = I('voucherNo');
		    if(empty($data['voucherNo'])){
			    $this->error('银行转账凭证编号不能为空！');
		    }
		    $data['voucherFileUrl'] = I('voucherFileUrl');
		    if(empty($data['voucherFileUrl'])){
			    $this->error('银行转账凭证扫描件不能为空！');
		    }
		    $token = $this->user['token'];
		    $data['objectId'] = I('objectId');
		    $data['token'] = $token;
		    $curl = new Curl($this->config->url->api->paas);
		    $resp = $curl->setData($data)->send('myPayment/myObjectPayment');
		    if(check_resp($resp)) {
			    $this->success('保存成功！');
		    }else{
			    $this->error(isset($resp['errmsg']) ? $resp['errmsg'] : '数据保存失败，请重新再试！');
		    }

	    }
	    $id = I('id');
	    $token = $this->user['token'];
	    $curl = new Curl($this->config->url->api->capital);
	    $resp = $curl->setData(['token'=>$token])->send('capitalManage/getPlatformBankcard');
	    if(check_resp($resp)) {
		    $this->assign('bankInfo',$resp['bankInfo']);
		    $this->assign('objectId',$id);
	    }
    }
    public function receivedAction()
    {
	    $id = I('id');
	    $token = $this->user['token'];
	    $curl = new Curl($this->config->url->api->paas);
	    $resp = $curl->setData(['token'=>$token,'objectId'=>$id])->send('myPayment/queryPaidAmountDetail');
	    if(check_resp($resp)) {
		    $this->assign('list',$resp['list']);
	    }
    }
    public function willreceiveAction()
    {
	    $id = I('id');
	    $token = $this->user['token'];
	    $curl = new Curl($this->config->url->api->paas);
	    $resp = $curl->setData(['token'=>$token,'objectId'=>$id])->send('myPayment/queryWillPayAmountDetail');
	    if(check_resp($resp)) {
		    $this->assign('list',$resp['list']);
	    }
    }
}
