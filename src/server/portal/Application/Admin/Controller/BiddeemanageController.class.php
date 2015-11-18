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

class BiddeemanageController extends AdminController {

	public function index()
	{
		if(!empty(I('short_name')))
		{
			$map['short_name']= ['like','%'.I("short_name").'%'];
		}
		if(!empty(I('nick_name')))
		{
			$map['nick_name']= ['like','%'.I("nick_name").'%'];
		}
		$prefix = C('DB_PREFIX');
		$model = M('qyzz_biddee a')->join('t_user b on a.user_id=b.id');
		$list   =   $this->lists($model, $map,'certificate_time desc','a.*,b.nick_name');
		$this->assign('_list', $list);
		$this->meta_title = '招标人列表';
		$this->display();
	}
	public function show()
	{
		$id = I('id');
		$item = $model = M('qyzz_biddee a')->join('t_user_bankcard b on a.user_id=b.user_id and user=\'BEE\'','left')->where(['a.id'=>$id])->find();
		if(empty($item))
		{
			$this->error('招标人信息不存在');
		}
		$this->assign('item', $item);
		$this->meta_title = '招标人详情';
		$this->display();
	}
	public function verify()
	{
		if(!empty(I('short_name')))
		{
			$map['short_name']= ['like','%'.I("short_name").'%'];
		}
		if(!empty(I('nick_name')))
		{
			$map['nick_name']= ['like','%'.I("nick_name").'%'];
		}
		$prefix = C('DB_PREFIX');
		$model = M('qyzz_biddee_certicate a')->join('t_user b on a.user_id=b.id');
		$list   =   $this->lists($model, $map,'apply_time desc','a.*,b.nick_name');
		$this->assign('_list', $list);
		$this->meta_title = '招标人待审核列表';
		$this->display();
	}
	public function verifyshow()
	{
		$id = I('id');
		$item = $model = M('qyzz_biddee_certicate a')->where(['id'=>$id])->find();
		if(empty($item))
		{
			$this->error('招标人信息不存在');
		}
		$this->assign('item', $item);
		$this->meta_title = '招标人详情';
		$this->display();
	}
	public function check()
	{
		$api = new ApiService();
		$resp = $api->setApiUrl(C('APIURI.baby'))
		->setData($data)->send('courseManager/course/spend');
	}
}
