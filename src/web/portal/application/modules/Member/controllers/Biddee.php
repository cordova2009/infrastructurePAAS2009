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
	    $resp = $curl->setData(['token'=>$token,'baseInfo'=>['logoUrl'=>'','companyName'=>$companyName,'shortName'=>$shortName,'description'=>$description,'registeredCapital'=>$registeredCapital,'telephone'=>$telephone,'email'=>$email]])->send('myBiddee/authInfo/saveBaseInfo_apply');
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
	    $resp = $curl->setData(['token'=>$token,'bankInfo'=>['bank'=>$bank,'accountId'=>$accountId,'accountName'=>$accountName]])->send('myBiddee/authInfo/saveBankInfo_apply');
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
	    $html = $this->render($type,['page'=>$page,$type=>$resp['list']]);
	    $this->ajaxReturn(['errcode'=>0,'errmsg'=>'OK','html'=>$html]);
    }
    public function surveyAction()
    {
	    $id=I('id');
	    if(IS_AJAX)
	    {
		    $p = $this->pageSize;
		    $i = $i==''?0:$i;
		    $token = $this->user['token'];
		    $curl = new Curl($this->config->url->api->paas);
		    $resp = $curl->setData(['token'=>$token,'pageSize'=>$p,'pageIndex'=>$i,'objectId'=>$id])->send('tender/queryMyObjectBidList');
		    $page = $this->getPagination($resp['total'], $this->pageSize);
		    $resp['page'] = $page;
		    $this->ajaxReturn($resp);
	    }
	    $token = isset($this->user['token'])?$this->user['token']:'';
	    $curl = new Curl($this->config->url->api->paas);
	    $resp = $curl->setData(['token'=>$token,'objectId'=>$id])->send('tender/queryMyObjectTenderSurvey');
	    if(check_resp($resp)) {
		    $this->assign('survey',$resp['survey']);
	    }else{
		//    $this->error(isset($resp['errmsg']) ? $resp['errmsg'] : '数据保存失败，请重新再试！');
	    }
	    $curl = new Curl($this->config->url->api->paas);
	    $resp = $curl->setData(['token'=>$token,'pageSize'=>$p,'pageIndex'=>$i,'objectId'=>$id])->send('tender/queryMyObjectBidList');
	    $this->assign('list',$resp['list']);
	    $page = $this->getPagination($resp['total'], $this->pageSize);
	    $this->assign('page', $page);
    }
}
