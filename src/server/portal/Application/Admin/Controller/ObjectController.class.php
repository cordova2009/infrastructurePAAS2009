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
		if(!empty(I('project_id')))
		{
			$map['project_id']= ['like','%'.I("project_id").'%'];
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
		$model = M('gcgl_project a')->join('t_ztgl_object b on a.object_id =b.object_id')->join('t_qyzz_biddee c on c.id=a.biddee_id')->join('t_qyzz_bidder d on d.id =a.bidder_id');
		$list   =   $this->lists($model, $map,'project_id desc','a.*,b.object_name,c.company_name as biddee_name,d.company_name as bidder_name');
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
		$model = M('gcgl_project_payment_receive a')->join('t_ztgl_object b on a.object_id =b.object_id');
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
		$model = M('gcgl_project_payment_pay a')->join('t_ztgl_object b on a.object_id =b.object_id');
		$list   =   $this->lists($model, $map,'should_pay_time desc','*');
		$this->assign('_list', $list);
		$this->meta_title = '工程付款';
		$this->display();
	}
	public function paymentshow()
	{
		$id = I('id');
		$item = M('gcgl_project_payment_pay a')->join('t_ztgl_object b on a.object_id =b.object_id')->where(['id'=>$id])->find();
		$this->assign('item', $item);
		$this->meta_title = '付款明细';
		$this->display();
	}
	public function prewarning()
	{
		$map= ['should_receive_time'=>['egt',date('Y-m-d H:i:s',strtotime('-5 day'))]];
		$model = M('gcgl_project_payment_receive a')->join('t_ztgl_object b on a.object_id =b.object_id');
		$list   =   $this->lists($model, $map,'should_receive_time desc','*');
		$this->assign('_list', $list);
		$this->meta_title = '工程收款风险预警';
		$this->display();
	}
}
