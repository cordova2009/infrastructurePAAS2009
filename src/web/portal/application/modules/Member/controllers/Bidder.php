<?php
/**
 * @name PublicController
 * @author xuebingwang
 * @desc Public控制器
 * @see http://www.php.net/manual/en/class.yaf-controller-abstract.php
*/
class BidderController extends MemberController{

    public function authInfoAction(){
	    $token = isset($this->user['token'])?$this->user['token']:'';
            $curl = new Curl($this->config->url->api->paas);
            $resp = $curl->setData(['token'=>$token])->send('myBidder/authInfo/getAuthInfo');
            if(!check_resp($resp)) {
		 $this->redirect(U('/login'));
            }
	    if(empty($resp['datail'])||empty($resp['overall']))
	    {
		    $this->redirect(U('applyfor'));
	    }
	    $this->assign('datail',isset($resp['datail'])?$resp['datail']:[]);
	    $this->assign('overall',isset($resp['overall'])?$resp['overall']:[]);
	    $this->layout->meta_title = '认证信息';
    }

    public function applyforAction()
    {
	    $token = isset($this->user['token'])?$this->user['token']:'';
            $curl = new Curl($this->config->url->api->paas);
            $base = $curl->setData(['token'=>$token])->send('myBidder/authInfo/getBaseInfo_apply');
            $legal= $curl->setData(['token'=>$token])->send('myBidder/authInfo/getLegalPersonInfo_apply');
            $registered = $curl->setData(['token'=>$token])->send('myBidder/authInfo/getRegisteredInfo_apply');
            $bank = $curl->setData(['token'=>$token])->send('myBidder/authInfo/getBankInfo_apply');
	    $this->assign('bankInfo',isset($bank['bankInfo'])?$bank['bankInfo']:'');
	    $this->assign('base',isset($base['baseInfo'])?$base['baseInfo']:'');
	    $this->assign('registered',isset($registered['registeredInfo'])?$registered['registeredInfo']:'');
	    $this->assign('legal',isset($legal['legalPerson'])?$legal['legalPerson']:'');
	    $name = decrypt($legal['legalPerson']['name'],$this->config->api->app->appKey);
	    $idcard = decrypt($legal['legalPerson']['idCard'],$this->config->api->app->appKey);
	    $this->assign('name',$name);
	    $this->assign('idcard',$idcard);
	    $types =$curl->setData(new stdClass())->send('tender/queryCertificateList');
	    $projectType = [];
	    $certificateName = [];
	    foreach($types['certificateList'] as $v)
	    {
		    $projectType[$v['industryId']] = $v['industryName'];
		    $certificateName[$v['industryName']] = $v['certificateList'];
		    //$certificateName[$v['industryId']] = $v['certificateList'];
	    }
	    $this->assign('projectType',$projectType);
	    $this->assign('certificateName',$certificateName);
	    $this->layout->meta_title = '申请认证信息';
    }
    public function submitapplyAction()
    {
	    if(IS_POST)
	    {
		    $token = isset($this->user['token'])?$this->user['token']:'';
		    $curl = new Curl($this->config->url->api->paas);
		    $resp = $curl->setData(['token'=>$token])->send('myBidder/authInfo/applay');
		    if(check_resp($resp)) {
			    $this->success('保存成功！');
		    }else{
			    $this->error(isset($resp['errmsg']) ? $resp['errmsg'] : '数据保存失败，请重新再试！');
		    }
	    }
	    $token = isset($this->user['token'])?$this->user['token']:'';
	    $curl = new Curl($this->config->url->api->paas);
	    $resp = $curl->setData(['token'=>$token])->send('myBidder/authInfo/getApplication');
	    if($resp['errcode']==1)
	    {
		    $this->redirect(U('/login'));
	    }
	    $this->assign('bank',$resp['bankInfo']);
	    $this->assign('base',$resp['baseInfo']);
	    $this->assign('registered',$resp['registeredInfo']);
	    $this->assign('legal',$resp['legalPerson']);
	    $name = decrypt($resp['legalPerson']['name'],$this->config->api->app->appKey);
	    $idcard = decrypt($resp['legalPerson']['idCard'],$this->config->api->app->appKey);
	    $this->assign('name',$name);
	    $this->assign('idcard',$idcard);
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
	    if($type=='zizhi')
	    {
		    $this->savezizhi();
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
		//    $this->error('法人身份证照片不能为空！');
	    }
	    $idCardBackUrl= I('idCardBackUrl');
	    if(empty($idCardBackUrl)){
		  //  $this->error('法人身份证照片不能为空！');
	    }
	    $authorityBookUrl = I('authorityBookUrl');
	    $token = isset($this->user['token'])?$this->user['token']:'';
	    $curl = new Curl($this->config->url->api->paas);
	    //$name = encrypt($name,$this->config->api->app->appKey);
	    //$idCard = encrypt($idCard,$this->config->api->app->appKey);
	    $resp = $curl->setData(['token'=>$token,'legalPerson'=>['name'=>$name,'idCard'=>$idCard,'idCardfrontUrl'=>$idCardfrontUrl,'idCardBackUrl'=>$idCardBackUrl,'authorityBookUrl'=>$authorityBookUrl]])->send('myBidder/authInfo/saveLegalPersonInfo_apply');
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
			    //$this->error('营业执照扫描件不能为空！');
		    }
		    $date['taxRegistrationNum']= I('taxRegistrationNum');
		    if(empty($date['taxRegistrationNum'])){
			    $this->error('税务登记证号码不能为空！');
		    }
		    $date['taxRegistrationUrl']= I('taxRegistrationUrl');
		    if(empty($date['taxRegistrationUrl'])){
			    //$this->error('税务登记证扫描件不能为空！');
		    }
		    $date['organizationCodeNum']= I('organizationCodeNum');
		    if(empty($date['organizationCodeNum'])){
			    $this->error('组织机构代码证号码不能为空！');
		    }
		    $date['organizationCodeUrl']= I('organizationCodeUrl');
		    if(empty($date['organizationCodeUrl'])){
			    //$this->error('组织机构代码证扫描件不能为空！');
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
			    //$this->error('统一社会信用代码扫描件不能为空！');
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
	    $resp = $curl->setData(['token'=>$token,'registeredInfo'=>$date])->send('myBidder/authInfo/saveRegisteredInfo_apply');
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
		    //$this->error('公司LOGO不能为空！');
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
	    $resp = $curl->setData(['token'=>$token,'baseInfo'=>['logoUrl'=>'','companyName'=>$companyName,'shortName'=>$shortName,'description'=>$description,'registeredCapital'=>$registeredCapital,'telephone'=>$telephone,'email'=>$email]])->send('myBidder/authInfo/saveBaseInfo_apply');
	    if(check_resp($resp)) {
		    $this->success('保存成功！');
	    }else{
		    $this->error(isset($resp['errmsg']) ? $resp['errmsg'] : '数据保存失败，请重新再试！');
	    }
    }
    private function savezizhi()
    {
	    $eqInfo  =  I('data');
	    $token = isset($this->user['token'])?$this->user['token']:'';
	    $curl = new Curl($this->config->url->api->paas);
	    $resp = $curl->setData(['token'=>$token,'eqInfo'=>$eqInfo])->send('myBidder/authInfo/saveEnterpriseQualification');
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
	    if(empty($bank)){
		    $this->error('银行账号不能为空！');
	    }
	    $accountName= I('accountName');
	    $token = isset($this->user['token'])?$this->user['token']:'';
	    $curl = new Curl($this->config->url->api->paas);
	    $resp = $curl->setData(['token'=>$token,'bankInfo'=>['bank'=>$bank,'accountId'=>$accountId,'accountName'=>$accountName]])->send('myBidder/authInfo/saveBankInfo_apply');
	    if(check_resp($resp)) {
		    $this->success('保存成功！');
	    }else{
		    $this->error(isset($resp['errmsg']) ? $resp['errmsg'] : '数据保存失败，请重新再试！');
	    }
    }

}
