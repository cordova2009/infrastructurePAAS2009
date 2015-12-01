<?php
/**
 * @name IndexController
 * @author xuebingwang
 * @desc 默认控制器
 * @see http://www.php.net/manual/en/class.yaf-controller-abstract.php
*/
class CapitalController extends MemberController {

    /**
     * 默认动作，首页
     * Yaf支持直接把Yaf\Request_Abstract::getParam()得到的同名参数作为Action的形参
     * 对于如下的例子, 当访问http://yourhost/y/index/index/index/name/yantze 的时候, 你就会发现不同
     */
    public function indexAction(){

        $curl = new Curl($this->config->url->api->capital);

        $resp = $curl->setData(['token'=>$this->user['token']])
            ->send('capitalManage/queryMyCapitalSurvey');

        if(check_resp($resp)) {
            $myCapitalInfo = $resp['myCapitalInfo'];
        }
        $this->assign('myCapitalInfo',$myCapitalInfo);

        $this->meta_title = '交易记录';

    }

    public function rechargeApplyAction(){
        if(IS_POST){
           /* {"app":{"appId":"paas","timeStamp":"TIMESTAMP",  "nonce":"NONCE", "signature":"21aa0011472249b4292e81504f3917bd"  },
                "body":{
                    "token":"96c5f0e5e3c52fa0fc632aaa30d4fb85",
                    "transferTime":"2015-10-12",
                    "bankName":"中国银行",
                    "voucherNo":"20150101215522",
                    "amount":100000,
                    "voucherFileUrl":"VOCHER_FILE_URL"
                }}*/
           $data = ['token'=>$this->user['token']];
           $data['transferTime'] = I('transferTime');
           if(empty($data['transferTime'])){
               $this->error('转账时间不能为空！');
           }
            $data['bankName'] = I('bankName');
           if(empty($data['bankName'])){
               $this->error('转账银行名称为空！');
           }
            $data['voucherNo'] = I('voucherNo');
           if(empty($data['voucherNo'])){
               $this->error('银行转账凭证号不能为空！');
           }
            $data['amount'] = I('amount');
            if(empty($data['amount'])){
                $this->error('转账金额不能为空！');
            }

            $data['voucherFileUrl'] = 'voucherFileUrl';
            /*if(empty($data['voucherFileUrl'])){
                $this->error('银行转账凭证不能为空！');
            }*/


            $curl = new Curl($this->config->url->api->capital);

           $resp = $curl->setData($data)->send('/capitalManage/rechargeApply');

           if(check_resp($resp)) {

               $this->success('保存成功！',U('/member/capital/rechargeApply'));
           }else{
               $this->error(isset($resp['errmsg']) ? $resp['errmsg'] : '充值失败，请重新再试！');
           }

           $this->error(var_export($data,true));
        }

        $this->meta_title = '充值';

    }

    public function rechargeListAction(){
        $curl1 = new Curl($this->config->url->api->capital);

        $resp2 = $curl1->setData(['token'=>$this->user['token']])
            ->send('capitalManage/queryRechargeApplyList');

        if(check_resp($resp2)) {
            $list = $resp2['list'];
        }
        $this->assign('list',$list);
        $this->meta_title = '充值记录';
    }

    public function withdrawalsApplyAction(){
        $curl1 = new Curl($this->config->url->api->capital);

        $resp2 = $curl1->setData(['token'=>$this->user['token']])
            ->send('capitalManage/queryProjectAccount');

        if(check_resp($resp2)) {
            $account = $resp2['account'];
        }
        $this->assign('account',$account);

        $curl2 = new Curl($this->config->url->api->user);

        $resp = $curl2->setData(['token'=>$this->user['token']])
            ->send('userCenter/getBankInfoList');

        $bankInfo = [
            'BeebankInfo'=>[],
            'BerbankInfo'=>[],
        ];
        if(check_resp($resp)) {
            $bankInfo = $resp;
        }
        if(!empty($bankInfo['BerbankInfo'])){
            $BerbankInfo = $bankInfo['BerbankInfo'][0]['bank'].' '.$bankInfo['BerbankInfo'][0]['accountId'];
            $BerbankId = $bankInfo['BerbankInfo'][0]['bankId'];

        }else{
            $BerbankInfo = '您还没有认证投标人!';
            $BerbankId = 0;
        }
        if(!empty($bankInfo['BeebankInfo'])){
            $BeebankInfo = $bankInfo['BeebankInfo'][0]['bank'].' '.$bankInfo['BeebankInfo'][0]['accountId'];
            $BeebankId = $bankInfo['BeebankInfo'][0]['bankId'];

        }else{
            $BeebankInfo = '您还没有认证招标人!';
            $BeebankId = 0;
        }
       // var_dump($BeebankId); die;
        $this->assign('BerbankInfo',$BerbankInfo);
        $this->assign('BerbankId',$BerbankId);
        $this->assign('BeebankInfo',$BeebankInfo);
        $this->assign('BeebankId',$BeebankId);
        $withdrewalsTime=date("Y-m-d", strtotime("+2 day"));
        $this->assign('withdrewalsTime',$withdrewalsTime);
        if(IS_POST){
            /* {"app":{"appId":"paas","timeStamp":"TIMESTAMP",  "nonce":"NONCE", "signature":"21aa0011472249b4292e81504f3917bd"},
                "body":{"token":"96c5f0e5e3c52fa0fc632aaa30d4fb85",
                "amount":100000,
                "bankId":23,
                "tradePassword":"br99T8ulqDxiZ09g77KnmEd3sgNcwIZPWR87EKrFvcf+uVm31GQvyw=="
            }}*/
            $data = ['token'=>$this->user['token']];
            $data['bankId'] = I('bankId');
            if($data['bankId']==0){
                $this->error('开户行不正确！');
            }
            $data['amount'] = I('amount');
            if(empty($data['amount'])){
                $this->error('提现金额不能为空！');
            }
            if( is_double($data['amount'])&&$data['amount']>0){
                $this->error('提现金额必须大于0！');
            }
            $data['tradePassword'] = encrypt(md5(I('tradePassword')),$this->config->api->app->appKey);
            if(empty($data['tradePassword'])){
                $this->error('交易密码不能为空！');
            }

            $curl3 = new Curl($this->config->url->api->capital);

            $resp = $curl3->setData($data)->send('/capitalManage/withdrawalsApply');

            if(check_resp($resp)) {

                $this->success('保存成功！',U('/member/capital/withdrawalsApply'));
            }else{
                $this->error(isset($resp['errmsg']) ? $resp['errmsg'] : '提现申请失败，请重新再试！');
            }

            $this->error(var_export($data,true));
        }

        $this->meta_title = '提现';

    }


    public function withdrawalsListAction(){

        $this->meta_title = '提现记录';
    }
}
