<?php
// +----------------------------------------------------------------------
// | OneThink [ WE CAN DO IT JUST THINK IT ]
// +----------------------------------------------------------------------
// | Copyright (c) 2013 http://www.onethink.cn All rights reserved.
// +----------------------------------------------------------------------
// | Author: 麦当苗儿 <zuojiazi@vip.qq.com> <http://www.zjzit.cn>
// +----------------------------------------------------------------------

namespace Admin\Controller;
use Admin\Service\ApiService;

class ObjectController extends AdminController {

    public function index()
    {
        if(!empty(I('object_id')))
        {
            $map['a.project_id']= ['like','%'.I("object_id").'%'];
        }
        if(!empty(I('object_name')))
        {
            $map['object_name']= ['like','%'.I("object_name").'%'];
        }
        if(!empty(I('status')))
        {
            $map['a.status']= I("status");
        }
        $prefix = C('DB_PREFIX');
        $model = M('gcgl_project a')
            ->join($prefix.'ztgl_object b on a.project_id =b.object_id')
            ->join('t_qyzz_biddee c on c.id=a.biddee_id')
            ->join('t_qyzz_bidder d on d.id =a.bidder_id');
        $list   =   $this->lists($model, $map,'a.project_id desc','a.*,b.object_name,c.company_name as biddee_name,d.company_name as bidder_name');
        $this->assign('_list', $list);
        $this->meta_title = '工程项目查询';
        $this->display();
    }
    public function collections()
    {
        if(!empty(I('object_name')))
        {
            $map['object_name']= ['like','%'.I("object_name").'%'];
        }
        if(!empty(I('status')))
        {
            $map['a.status']= I("status");
        }
        $model = M('gcgl_project_payment_receive a')->join('t_ztgl_object b on a.project_id =b.object_id');
        $list   =   $this->lists($model, $map,'should_receive_time desc','*');
        $this->assign('_list', $list);
        $this->meta_title = '工程收款';
        $this->display();
    }
    public function payment()
    {
        if(!empty(I('object_name')))
        {
            $map['object_name']= ['like','%'.I("object_name").'%'];
        }
        if(!empty(I('status')))
        {
            $map['a.status']= I("status");
        }
        $model = M('gcgl_project_payment_pay a')->join('t_ztgl_object b on a.project_id =b.object_id');
        $list   =   $this->lists($model, $map,'should_pay_time desc','*');
        $this->assign('_list', $list);
        $this->meta_title = '工程付款';
        $this->display();
    }
    public function receive()
    {
        if(IS_POST)
        {
            $data['orderId'] = I('orderId');
            $data['confirmStatus'] = I('confirmStatus');
            $data['remark'] = I('remark');
            $data['operator'] = session('user_auth')['uid'];
            $api = new ApiService();
            $resp = $api->setApiUrl(C('APIURI.paas1'))
                ->setData($data)->send('projectPayment/confirmPayment');
            if(!check_resp($resp))
            {
                $this->error('系统错误,请稍后再试');
            }
            $this->success('审核完成',U("biddeemanage/verify"));
        }
        $id = I('id');
        $item = M('gcgl_project_payment_receive a')->join('t_ztgl_object b on a.project_id =b.object_id')->where(['id'=>$id])->find();
        $this->assign('item', $item);
        $this->meta_title = '付款明细';
        $this->display();
    }

    public function paymentshow(){
        $id = I('id');
        $item = M('gcgl_project_payment_pay a')->join('t_ztgl_object b on a.project_id =b.object_id')->where(['id'=>$id])->find();
        $this->assign('item', $item);
        $this->meta_title = '付款明细';
        $this->display();
    }

    public function paymentcheck(){
        $id = I('id');
        $item = M('gcgl_project_payment_pay a')
            ->join('t_ztgl_object b on a.project_id =b.object_id')
            ->where(['id'=>$id,'status'=>'CRT'])->find();

        if(empty($item)){
            $this->error('没有找到要审核的数据！');
        }
        if(IS_POST){
            $check_status = I('check_status');
            if(empty($check_status)){
                $this->error('请选择审核是否通过！');
            }
            $check_status = ($check_status == 'Y') ? 'OK#' : 'FLS';
            $remark = I('check_remark');
            if($check_status == 'FLS' && empty($remark)){
                $this->error('审核不通过时，审核意见必须填写！');
            }
            $api = new ApiService(C('APIURI.paas1'));
            $resp = $api->setData([
                            'orderId'=>$item['order_id'],
                            'confirmStatus'=>$check_status,
                            'remark'=>$remark,
                            'operator'=>is_login(),
                        ])
                ->send('projectPayment/confirmPayment');
            if(check_resp($resp)){
                $this->success('审核成功！',U('object/payment'));
            }else{
                $this->error(isset($resp['errmsg']) ? $resp['errmsg'] : '审核失败，请重新再试或联系管理员!');
            }
        }
        $this->assign('item', $item);
        $this->meta_title = '工程款审核';
        $this->display();
    }

    public function prewarning(){
        $map= ['should_receive_time'=>['egt',date('Y-m-d H:i:s',strtotime('-5 day'))]];
        $model = M('gcgl_project_payment_receive a')->join('t_ztgl_object b on a.project_id =b.object_id');
        $list   =   $this->lists($model, $map,'should_receive_time desc','*');
        $this->assign('_list', $list);
        $this->meta_title = '工程收款风险预警';
        $this->display();
    }
    public function baseshow()
    {
        $id = I('id');
        $type = I('type');
        if($type=='bidder')
        {
            $item = $model = M('qyzz_bidder a')->where(['a.id'=>$id])->find();
            $this->assign('title', '投标人');
        }else{
            $item = $model = M('qyzz_biddee a')->where(['a.id'=>$id])->find();
            $this->assign('title', '招标人');
        }
        $this->assign('item', $item);
        $this->meta_title = '付款明细';
        $this->display();
    }
}
