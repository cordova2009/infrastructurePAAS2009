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

class CapitalController extends AdminController {

	public function index()
	{
		if(!empty(I('account_id')))
		{
			$map['account_id']= ['like','%'.I("account_id").'%'];
		}
		if(!empty(I('nick_name')))
		{
			$map['nick_name']= ['like','%'.I("nick_name").'%'];
		}
		if(!empty(I('status')))
		{
			$map['a.status']= I("status");
		}
		$prefix = C('DB_PREFIX');
		$model = M('project_account a')->join('t_user b on a.user_id=b.id');
		$list   =   $this->lists($model, $map,'update_time desc','a.*,b.nick_name');
		$this->assign('_list', $list);
		$this->meta_title = '用户资金账户列表';
		$this->display();
	}
	public function showitem()
	{
		$id = I("id");
		$model = M('project_account_order a');
		$list   =   $this->lists($model, ['account_id'=>$id],'insert_time desc','*');
		$this->assign('_list', $list);
		$this->meta_title = '用户资金账户列表';
		$this->display();
	}
	public function withdraw()
	{
		if(!empty(I('status')))
		{
			$map['a.status']= I("status");
		}
		if(!empty(I('account_no')))
		{
			$map['account_no']= I("account_no");
		}
		if(!empty(I('account_name')))
		{
			$map['account_name']= ['like','%'.I("account_name").'%'];
		}
		if(!empty(I('nick_name')))
		{
			$map['nick_name']= ['like','%'.I("nick_name").'%'];
		}
		$model = M('ddgl_withdraw_apply a')->join('t_user b on a.user_id=b.id')->join('t_user_bankcard c on c.id=a.user_bankcard_id');
		$list   =   $this->lists($model, $map,'insert_time desc','a.*,b.nick_name,c.user,bank_name,account_no,account_name');
		$this->assign('_list', $list);
		$this->meta_title = '提现申请列表';
		$this->display();
	}
	public function recharge()
	{
		if(!empty(I('status')))
		{
			$map['a.status']= I("status");
		}
		if(!empty(I('account_no')))
		{
			$map['account_no']= I("account_no");
		}
		if(!empty(I('account_name')))
		{
			$map['account_name']= ['like','%'.I("account_name").'%'];
		}
		if(!empty(I('nick_name')))
		{
			$map['nick_name']= ['like','%'.I("nick_name").'%'];
		}
		$model = M('ddgl_recharge_apply a')->join('t_user b on a.user_id=b.id');
		$list   =   $this->lists($model, $map,'insert_time desc','a.*,b.nick_name');
		$this->assign('_list', $list);
		$this->meta_title = '充值申请列表';
		$this->display();
	}
	function rechargecheck ()
	{
		if(IS_POST){
			$uid= session('user_auth')['uid'];
			$remark=I('post.remark');
			$status=I('post.status');
			$id =I('post.order_id');
			$data = ['orderId'=>$id,'checkResult'=>$status,'remark'=>$remark,'operator'=>$uid];
			$api = new ApiService();
			$resp = $api->setApiUrl(C('APIURI.paas1'))
				->setData($data)->send('capitalManage/checkRechargeApply');
			if($resp===false)
			{
				$this->error('系统错误,请稍后再试');
			}
			$this->success('审核完成');
		}
		$id = I('get.id');
		$item = M('ddgl_recharge_apply a')->join('t_user b on a.user_id=b.id')->join('t_user_bankcard c on c.id=a.bank_id')->where(['a.order_id'=>$id])->field('a.*,b.nick_name,c.user,bank_name,account_no,account_name')->find();
		$this->assign('item', $item);
		$this->meta_title = '充值申请审核';
		$this->display();
	}
	function withdrawcheck()
	{
		if(IS_POST){
			$uid= session('user_auth')['uid'];
			$remark=I('post.remark');
			$status=I('post.status');
			$id =I('post.order_id');
			$checkWithdrawalsNo =I('post.voucher');
			$data = ['orderId'=>$id,'checkWithdrawalsNo'=>$checkWithdrawalsNo,'checkResult'=>$status,'remark'=>$remark,'operator'=>$uid];
			$api = new ApiService();
			$resp = $api->setApiUrl(C('APIURI.paas1'))
				->setData($data)->send('capitalManage/checkWithdrawalsApply');
			if($resp===false)
			{
				$this->error('系统错误,请稍后再试');
			}
			$this->success('审核完成');
		}
		$id = I('get.id');
		$item = M('ddgl_withdraw_apply a')->join('t_user b on a.user_id=b.id')->join('t_user_bankcard c on c.id=a.user_bankcard_id')->where(['a.order_id'=>$id])->field('a.*,b.nick_name,c.user,bank_name,account_no,account_name')->find();
		$this->assign('item', $item);
		$this->meta_title = '充值申请审核';
		$this->display();
	}
}
