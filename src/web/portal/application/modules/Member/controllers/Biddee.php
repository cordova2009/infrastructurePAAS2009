<?php
/**
 * @name PublicController
 * @author xuebingwang
 * @desc Public控制器
 * @see http://www.php.net/manual/en/class.yaf-controller-abstract.php
 */
class BiddeeController extends MemberController{


    var $pageSize=10;

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

    /**
     *
     */
    public function authInfoAction(){

        $curl = new Curl($this->config->url->api->paas);
        $resp = $curl->setData(['token'=>$this->user['token']])->send('myBiddee/authInfo/getAuthInfo');

        if(!check_resp($resp)) {
            $this->error(isset($resp['errmsg']) ? $resp['errmsg'] : '数据查询失败，请重新再试或联系客服人员！');
        }

        if(empty($resp['detail']) || empty($resp['overall'])){
            $this->error(isset($resp['errmsg']) ? $resp['errmsg'] : '数据查询失败，请重新再试或联系客服人员！');
        }

//        var_dump($resp['detail']);die;
        $this->assign('detail',$resp['detail']);
        $this->assign('overall',$resp['overall']);
        $this->layout->meta_title = '认证信息';
    }
    public function applyforAction(){

        $token = $this->user['token'];
        $curl = new Curl($this->config->url->api->paas);
        $base = $curl->setData(['token'=>$this->user['token']])->send('myBiddee/authInfo/getBaseInfo_apply');
        if(!check_resp($base)) {
            $this->error($base['errmsg']);
        }
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
                $this->success('提交申请成功！',U('/member/biddee/authInfo'));
            }else{
                $this->error(isset($resp['errmsg']) ? $resp['errmsg'] : '数据保存失败，请重新再试！');
            }
        }
        $token = isset($this->user['token'])?$this->user['token']:'';
        $curl = new Curl($this->config->url->api->paas);
        $resp = $curl->setData(['token'=>$token])->send('myBiddee/authInfo/getApplication');
        if(!check_resp($resp)) {
            if($resp['errcode']==1)
            {
                $this->redirect(U('/login'));
                return;
            }
            $this->error(isset($resp['errmsg']) ? $resp['errmsg'] : '数据保存失败，请重新再试！');
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
            $this->error('法人姓名不能为空！');
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
        if(!check_resp($resp)) {
            $this->error(isset($resp['errmsg']) ? $resp['errmsg'] : '数据保存失败，请重新再试！');
        }
        $this->success('保存成功！');
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
        if(strtotime($date['regTime']) >= strtotime('today')){
            $this->error('哇塞，您这公司成立时间还没到呢吧！');
        }
        $date['businessLicenseExpireTime']= intval(I('businessLicenseExpireTime'));

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
        if(!regex($email,'email')){
            $this->error('电子邮箱格式错误！');
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

        $token = isset($this->user['token'])?$this->user['token']:'';

        $curl = new Curl($this->config->url->api->paas);
        $resp = $curl->setData([
            'token'=>$token,
            'bankInfo'=>[
                'bank'=>$bank,
                'accountId'=>$accountId,
                'accountName'=>$accountName,
                'taxNo'=>$taxNo,
                'telephone'=>$telephone,
                'address'=>$address
            ]
        ])->send('myBiddee/authInfo/saveBankInfo');
        if(check_resp($resp)) {
            $this->success('保存成功！',U('submitapply'));
        }else{
            $this->error(isset($resp['errmsg']) ? $resp['errmsg'] : '数据保存失败，请重新再试！');
        }
    }

    /**
     *
     */
    public function probjectAction()
    {
        $curl = new Curl($this->config->url->api->paas);
        $resp = $curl->setData(['token'=>$this->user['token']])->send('tender/queryMyObjectSurvey');

        if(!check_resp($resp)) {
            $this->error($resp['errmsg']);
        }
        $this->assign('bidingNum',$resp['bidingNum']);
        $this->assign('doingNum',$resp['doingNum']);
        $this->assign('doneNum',$resp['doneNum']);
        $this->assign('pageIndex',I('pageIndex'));
        $this->assign('type',I('type','biding'));
    }

    /**
     * @return array
     */
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
    public function getProbjectAction()
    {
        $i      = I('pageIndex');
        $type   = I('type');
        if(empty($type)){
            $type = 'biding';
        }
        $func = 'queryMyTenderObject';
        if($type=='biding'){
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
        $p      = $this->pageSize;
        $i      = $i==''?0:$i;
        $token  = $this->user['token'];
        $curl   = new Curl($this->config->url->api->paas);
        $resp   = $curl->setData(['token'=>$token,'pageSize'=>$p,'pageIndex'=>$i])->send('tender/'.$func);
        if(!check_resp($resp)) {
            $this->error($resp['errmsg']);
        }

        $page   = $this->getPagination($resp['total'], $this->pageSize);
        $ret    = $this->getIndustrys();

        $this->ajaxReturn(['errcode'=>0,'errmsg'=>'OK','html'=>$this->render($type,['page'=>$page,$type=>$resp['list'],'industry'=>$ret])]);
    }

    public function surveyAction(){
        $objectId = I('id');
        if(empty($objectId)){

            $objectId= I('objectId');
        }
        $token  = $this->user['token'];
        $curl   = new Curl();
        $resp   = $curl->setData(['token'=>$token,'pageSize'=>99999999,'pageIndex'=>0,'objectId'=>$objectId])
                    ->send('tender/queryMyObjectBidList');

        if(!check_resp($resp)) {
            $this->error(isset($resp['errmsg']) ? $resp['errmsg'] : '查询投标人列表失败，请重新再试或联系客服人员！');
        }

        if(IS_POST){

            $winBidId= I('winBidId');
            if(empty($winBidId)){
                $this->error('您还没有选择中标人！');
            }

            $winBid = null;
            foreach($resp['list'] as $bid){
                if($bid['bidId'] == $winBidId){
                    $winBid = $bid;
                    break;
                }
            }
            if(empty($winBid)){
                $this->error('哇塞，您选择的投标人根本没投您的标，您是怎么选择的？');
            }

            $payType = I('payType');
            $objectId= I('objectId');
            $data = [];
            if($payType=='ONE'){
                $payDate=I('payDate_one');
                $data[]= [
                    'paySum'=>$winBid['bidAmount'],
                    'payDate'=>$payDate,
                    'period'=>1
                ];
                $payPeriod = 1;
            }

            if($payType=='PID'){
                $d = I('payDate_pid');
                $s = I('paySum_pid');
                $i = I('period_pid');
                $payPeriod = I('payPeriod_pid');
                if(!is_array($d) || !is_array($s) || !is_array($i)){
                    $this->error('提交的期数和金额不正确！');
                }
                if(!(sizeof($d) == sizeof($s) && sizeof($s) == sizeof($i))){
                    $this->error('提交的期数和金额不对应！');
                }
                $sum_total = 0;

                foreach($d as $k=>$v){
                    if(empty($v)){
                        $this->error('既然选择了期数，怎么可以不填写完呢？');
                    }
                    $tmp = [
                        'paySum'=>price_dispose($s[$k]),
                        'payDate'=>$d[$k],
                        'period'=>$i[$k]
                    ];
                    $data[]=$tmp;
                    $sum_total += $tmp['paySum'];
                }
                if($sum_total != $winBid['bidAmount']){
                    $this->error('提交的金额与中标金额不一致！');
                }
            }

            if($payType=='MON'){
                $d = I('payDate_mon');
                $s = I('paySum_mon');
                $i = I('period_mon');
                $payPeriod = I('payPeriod_mon');
                if(!is_array($d) || !is_array($s) || !is_array($i)){
                    $this->error('提交的期数和金额不正确！');
                }
                if(!(sizeof($d) == sizeof($s) && sizeof($s) == sizeof($i))){
                    $this->error('提交的期数和金额不对应！');
                }
                $sum_total = 0;
                foreach($d as $k=>$v){
                    if(empty($v)){
                        $this->error('既然选择了期数，怎么可以不填写完呢？');
                    }
                    $tmp = [
                        'paySum'=>price_dispose($s[$k]),
                        'payDate'=>$d[$k],
                        'period'=>$i[$k]
                    ];
                    $data[]=$tmp;
                    $sum_total += $tmp['paySum'];
                }
                if($sum_total != $winBid['bidAmount']){
                    $this->error('提交的金额与中标金额不一致！');
                }
            }

            if($payType=='CUM'){
                $d = I('payDate_cum');
                $s = I('paySum_cum');
                $i = I('period_cum');
                $payPeriod = I('payPeriod_cum');
                if(!is_array($d) || !is_array($s) || !is_array($i)){
                    $this->error('提交的期数和金额不正确！');
                }
                if(!(sizeof($d) == sizeof($s) && sizeof($s) == sizeof($i))){
                    $this->error('提交的期数和金额不对应！');
                }
                $sum_total = 0;

                foreach($d as $k=>$v){
                    if(empty($v)){
                        $this->error('既然选择了期数，怎么可以不填写完呢？');
                    }
                    $tmp = [
                        'paySum'=>price_dispose($s[$k]),
                        'payDate'=>$d[$k],
                        'period'=>$i[$k]
                    ];
                    $data[]=$tmp;
                    $sum_total += $tmp['paySum'];
                }
                if($sum_total != $winBid['bidAmount']){
                    $this->error('提交的金额与中标金额不一致！');
                }
            }

            $resp = $curl->setData([
                                    'token'=>$token,
                                    'objectId'=>$objectId,
                                    'winBidId'=>$winBidId,
                                    'paymentInfo'=>[
                                                'payType'=>$payType,
                                                'payPeriod'=>$payPeriod,
                                                'payList'=>$data
                                            ]
                                    ])
                            ->send('tender/bidEvaluation');
            if(!check_resp($resp)) {
                $this->error($resp['errmsg']);
            }
            $this->success('评标成功！',U('/member/biddee/probject'));
        }
        $this->assign('list',$resp['list']);

        $token = isset($this->user['token'])?$this->user['token']:'';
        $curl = new Curl($this->config->url->api->paas);
        $resp = $curl->setData(['token'=>$token,'objectId'=>$objectId])->send('tender/queryMyObjectTenderSurvey');
        if(check_resp($resp)) {
            $this->assign('survey',$resp['survey']);
        }else{
            //    $this->error(isset($resp['errmsg']) ? $resp['errmsg'] : '数据保存失败，请重新再试！');
        }
        $this->assign('objectId',$objectId);
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
    public function incomeAction()
    {
        $token = $this->user['token'];
        $curl = new Curl($this->config->url->api->paas);
        $resp = $curl->setData(['token'=>$token])->send('myPayment/getMyPaymentOverall');
        if(!check_resp($resp)) {
            $this->error($resp['errmsg']);
        }
        $this->assign('income',$resp['overall']);
        $p = $this->pageSize;
        $i = empty($i)?1:$i;
        $resp = $curl->setData(['token'=>$token,'pageSize'=>$p,'pageIndex'=>$i])->send('myPayment/queryMyPaymentList');
        if(!check_resp($resp)) {
            $this->error(isset($resp['errmsg']) ? $resp['errmsg'] : '出错了，请稍后再试！！');
        }
        $this->assign('list',$resp['list']);
        $page = $this->getPagination($resp['total'], $this->pageSize);
        $this->assign('page', $page);
        $this->assign('pageIndex',I('pageIndex'));
    }
    public function paymentAction()
    {
        $nextPeriod=I('nextPeriod');
        $objectName=I('objectName');
        if(IS_POST)
        {
            $data['amount'] = price_dispose(I('amount'));
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
        if(!check_resp($resp)) {
            $this->error(isset($resp['errmsg']) ? $resp['errmsg'] : '出错了，请稍后再试！！');
        }
        $this->assign('bankInfo',$resp['bankInfo']);
        $this->assign('objectId',$id);
        $this->assign('nextPeriod',$nextPeriod);
        $this->assign('objectName',$objectName);
    }
    public function receivedAction()
    {
        $id = I('id');
        $token = $this->user['token'];
        $curl = new Curl($this->config->url->api->paas);
        $resp = $curl->setData(['token'=>$token,'objectId'=>$id])->send('myPayment/queryPaidAmountDetail');
        if(!check_resp($resp)) {
            $this->error(isset($resp['errmsg']) ? $resp['errmsg'] : '出错了，请稍后再试！！');
        }
        $this->assign('list',$resp['list']);
        $this->assign('projectName',$resp['projectName']);
    }
    public function willreceiveAction()
    {
        $id = I('id');
        $token = $this->user['token'];
        $curl = new Curl($this->config->url->api->paas);
        $resp = $curl->setData(['token'=>$token,'objectId'=>$id])->send('myPayment/queryWillPayAmountDetail');
        if(!check_resp($resp)) {
            $this->error(isset($resp['errmsg']) ? $resp['errmsg'] : '出错了，请稍后再试！！');
        }
        $this->assign('list',$resp['list']);
        $this->assign('projectName',$resp['projectName']);
    }
}
