<?php
/**
 * @name PublicController
 * @author xuebingwang
 * @desc Public控制器
 * @see http://www.php.net/manual/en/class.yaf-controller-abstract.php
 */
class BidderController extends MemberController{
    var $pageSize = 10;

    /**
     * 投诉
     */
    public function complainAction(){
        if(IS_POST)
        {
            $data = ['token'=>$this->user['token']];
            $data['complainType'] = I('complainType');
            $data['refType'] ='TER';
            $data['refId']=I('objectId');
            $data['complainContent']=I('complainContent');
            $curl = new Curl($this->config->url->api->paas);
            $resp = $curl->setData($data)->send('complain/submitComplain');
            if(check_resp($resp)) {
                $this->success('保存成功！',U('/member/biddee/project'));
            }else{
                $this->error(isset($resp['errmsg']) ? $resp['errmsg'] : '数据保存失败，请重新再试！');
            }
        }
    }

    public function authInfoAction(){
        $token  = isset($this->user['token'])?$this->user['token']:'';
        $curl   = new Curl($this->config->url->api->paas);
        $resp   = $curl->setData(['token'=>$token])->send('myBidder/authInfo/getAuthInfo');

        if(!check_resp($resp)) {
            $this->error(isset($resp['errmsg']) ? $resp['errmsg'] : '数据查询失败，请重新再试或联系客服人员！');
        }

        if(empty($resp['detail']) || empty($resp['overall'])){
            $this->error(isset($resp['errmsg']) ? $resp['errmsg'] : '数据查询失败，请重新再试或联系客服人员！');
        }

        $this->assign('detail',$resp['detail']);
        $this->assign('overall',$resp['overall']);
        $this->assign('zizhi',[]);
        $this->layout->meta_title = '认证信息';
    }

    public function applyforAction()
    {
        $token = isset($this->user['token'])?$this->user['token']:'';
        $curl = new Curl($this->config->url->api->paas);
        $base = $curl->setData(['token'=>$token])->send('myBidder/authInfo/getBaseInfo_apply');
        if(!check_resp($base)) {
            $this->error($base['errmsg']);
        }
        $legal= $curl->setData(['token'=>$token])->send('myBidder/authInfo/getLegalPersonInfo_apply');
        $registered = $curl->setData(['token'=>$token])->send('myBidder/authInfo/getRegisteredInfo_apply');
        $bank = $curl->setData(['token'=>$token])->send('myBidder/authInfo/getBankInfo_apply');
        $this->assign('bankInfo',isset($bank['bankInfo'])?$bank['bankInfo']:'');
        $this->assign('base',isset($base['baseInfo'])?$base['baseInfo']:'');
        $this->assign('registered',isset($registered['registeredInfo'])?$registered['registeredInfo']:'');
        $this->assign('legal',isset($legal['legalPerson'])?$legal['legalPerson']:'');
        $types =$curl->setData(new stdClass())->send('tender/queryCertificateList');
        $projectType = [];
        $certificateName = [];
        foreach($types['certificateList'] as $v)
        {
            $projectType[$v['industryId']] = $v['industryName'];
            $certificateName[$v['industryId']] = $v['certificateList'];
        }
        $zizhi= $curl->setData(['token'=>$token])->send('myBidder/authInfo/getEnterpriseQualification');

        foreach($zizhi['eqInfo'] as $k=>&$v)
        {
            $v['cshow'] = imageView2($v['certificationContent'],178,112);
        }
        $this->assign('zizhi',isset($zizhi['eqInfo'])?$zizhi['eqInfo']:'');
        $this->assign('projectType',$projectType);
        $this->assign('certificateName',$certificateName);
        $this->layout->meta_title = '投标人申请认证';
    }
    public function submitapplyAction()
    {
        if(IS_POST)
        {
            $token = isset($this->user['token'])?$this->user['token']:'';
            $curl = new Curl($this->config->url->api->paas);
            $resp = $curl->setData(['token'=>$token])->send('myBidder/authInfo/applay');
            if(check_resp($resp)) {
                $this->success('保存成功！',U('/member/bidder/authInfo'));
            }else{
                $this->error(isset($resp['errmsg']) ? $resp['errmsg'] : '数据保存失败，请重新再试！');
            }
        }
        $token = isset($this->user['token'])?$this->user['token']:'';
        $curl = new Curl($this->config->url->api->paas);
        $resp = $curl->setData(['token'=>$token])->send('myBidder/authInfo/getApplication');
        if(!check_resp($resp)) {
            if($resp['errcode']==1)
            {
                $this->redirect(U('/login'));
                return;
            }
            $this->error($resp['errmsg']);
        }
        $this->assign('bank',$resp['bankInfo']);
        $this->assign('base',$resp['baseInfo']);
        $this->assign('registered',$resp['registeredInfo']);
        $this->assign('legal',$resp['legalPerson']);
        $this->assign('eqInfo',$resp['eqInfo']);
        //$name = decrypt($resp['legalPerson']['name'],$this->config->api->app->appKey);
        // $idcard = decrypt($resp['legalPerson']['idCard'],$this->config->api->app->appKey);
        // $this->assign('name',$name);
        // $this->assign('idcard',$idcard);
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
        if(!IdentityCodeValid($idCard)){
            $this->error('法人身份证号不合法！');
        }
        $idCardfrontUrl = I('idCardfrontUrl');
        if(empty($idCardfrontUrl)){
            $this->error('法人身份证正面照片不能为空！');
        }
        $idCardBackUrl= I('idCardBackUrl');
        if(empty($idCardBackUrl)){
            $this->error('法人身份证照反面片不能为空！');
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
        $date['businessLicenseExpireTime']= intval(I('businessLicenseExpireTime'));

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
            $this->error('公司LOGO不能为空！');
        }
        $registeredCapital = I('registeredCapital');
        $telephone = I('telephone');
        if(empty($telephone)){
            $this->error('办公电话不能为空！');
        }
        if(!regex($telephone,"mobile")&&!regex($telephone,"telephone")){
            $this->error('办公电话格式不正确！');
        }
        $email = I('email');
        if(empty($email)){
            $this->error('电子邮箱不能为空！');
        }
        if(!regex($email,'email')){
            $this->error('电子邮箱格式错误！');
        }
        $token = isset($this->user['token'])?$this->user['token']:'';
        $curl = new Curl($this->config->url->api->paas);
        $resp = $curl->setData(['token'=>$token,'baseInfo'=>['logoUrl'=>$logoUrl,'companyName'=>$companyName,'shortName'=>$shortName,'description'=>$description,'registeredCapital'=>$registeredCapital,'telephone'=>$telephone,'email'=>$email]])->send('myBidder/authInfo/saveBaseInfo_apply');
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
            $this->success('保存成功！',U('submitapply'));
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
        if(!regex($accountId,'number')){
            $this->error('银行账号只能为数字！');
        }
        $accountName= I('accountName');
        if(empty($accountName)){
            $this->error('开户人姓名不能为空！');
        }

        $taxNo      = I('taxNo');
        if(empty($taxNo)){
            $this->error('税号不能为空！');
        }
        $telephone  = I('telephone');
        if(!regex($telephone,'telephone')){
            $this->error('联系电话格式不正确！');
        }
        $address    = I('address');
        if(empty($address)){
            $this->error('公司地址不能为空！');
        }

        $data = [
            'token'=>$this->user['token'],
            'bankInfo'=>[
                'bank'=>$bank,
                'accountId'=>$accountId,
                'accountName'=>$accountName,
                'taxNo'=>$taxNo,
                'telephone'=>$telephone,
                'address'=>$address,
            ]
        ];

        $curl = new Curl($this->config->url->api->paas);
        $resp = $curl->setData($data)->send('myBidder/authInfo/saveBankInfo');
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
        $resp = $curl->setData(['token'=>$token])->send('tender/queryMyBidSurvey');
        if(!check_resp($resp)) {
            $this->error($resp['errmsg']);
        }
        $this->assign('bidingNum',$resp['bidingNum']);
        $this->assign('doingNum',$resp['doingNum']);
        $this->assign('doneNum',$resp['doneNum']);
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
        $func = 'queryMyBidObject';
        if($type=='biding')
        {
            $func = 'queryMyBidObject';
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
        $i = empty($i)?1:$i;
        $token = $this->user['token'];
        $curl = new Curl($this->config->url->api->paas);
        $resp  = $curl->setData(['token'=>$token,'pageSize'=>$p,'pageIndex'=>$i])->send('bid/'.$func);
        $page = $this->getPagination(isset($resp['total'])?$resp['total']:'0', $this->pageSize);
        $ret = $this->getIndustrys();
        $html = $this->render($type,['page'=>$page,$type=>$resp['list'],'industry'=>$ret]);
        $this->ajaxReturn(['errcode'=>0,'errmsg'=>'OK','html'=>$html]);
    }
    private function getIndustrys()
    {
        $tmp = [];
        $token = $this->user['token'];
        $curl = new Curl($this->config->url->api->paas);
        $resp = $curl->setData(['token'=>$token])->send('tender/getIndustryList');
        if(!check_resp($resp)) {
            $this->error($resp['errmsg']);
        }
        foreach($resp['list'] as $v)
        {
            $tmp[$v['industryId']] = ['industryIcon'=>$v['industryIcon'],'industryName'=>$v['industryName']];
        }
        return $tmp;
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
        $resp = $curl->setData(['token'=>$token,'objectId'=>$id])->send('bid/queryMyObjectTenderSurvey');
        if(!check_resp($resp)) {
            $this->error($resp['errmsg']);
        }
        $this->assign('survey',$resp['survey']);
        $curl = new Curl($this->config->url->api->paas);
        $resp = $curl->setData(['token'=>$token,'pageSize'=>$p,'pageIndex'=>$i,'objectId'=>$id])->send('bid/queryMyObjectBidList');
        $this->assign('list',$resp['list']);
        $page = $this->getPagination($resp['total'], $this->pageSize);
        $this->assign('page', $page);
    }

    public function incomeAction()
    {
        $token = $this->user['token'];
        $curl = new Curl($this->config->url->api->paas);
        $resp = $curl->setData(['token'=>$token])->send('myIncome/getMyIncomeOverall');
        if(!check_resp($resp)) {
            $this->error($resp['errmsg']);
        }
        $this->assign('income',$resp['overall']);
        $p = $this->pageSize;
        $i = empty($i)?1:$i;
        $resp = $curl->setData(['token'=>$token,'pageSize'=>$p,'pageIndex'=>$i])->send('myIncome/queryMyIncomeList');
        if(!check_resp($resp)) {
            $this->redirect(U('/login'));
        }
        $this->assign('list',$resp['list']);
        $page = $this->getPagination($resp['total'], $this->pageSize);
        $this->assign('page', $page);
        $this->assign('pageIndex',I('pageIndex'));
    }
    public function receivedAction()
    {
        $id = I('id');
        $token = $this->user['token'];
        $curl = new Curl($this->config->url->api->paas);
        $resp = $curl->setData(['token'=>$token,'objectId'=>$id])->send('myIncome/queryWillReceiveAmountDetail');
        if(!check_resp($resp)) {
            $this->error($resp['errmsg']);
        }
        $this->assign('list',$resp['list']);
    }
    public function willreceiveAction()
    {
        $id = I('id');
        $token = $this->user['token'];
        $curl = new Curl($this->config->url->api->paas);
        $resp = $curl->setData(['token'=>$token,'objectId'=>$id])->send('myIncome/queryWillReceiveAmountDetail');
        if(!check_resp($resp)) {
            $this->error($resp['errmsg']);
        }
        $this->assign('list',$resp['list']);
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
        if(!check_resp($resp)) {
            $this->error($resp['errmsg']);
        }
        $this->assign('evaluate',$resp['evaluateInfo']);
    }
}
