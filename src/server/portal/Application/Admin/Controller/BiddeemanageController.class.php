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
		$map['a.status'] = 'APY';
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
		$data = $this->getData();
		$api = new ApiService();
		$resp = $api->setApiUrl(C('APIURI.paas1'))
		->setData($data)->send('myBiddee/authInfo/checkApplication');
		if($resp===false)
		{
			$this->error('系统错误,请稍后再试');
		}
		$this->success('审核完成',U("biddeemanage/verify"));

	}
	private function getData(){
		$data = [];
		$get = [
			'baseInfoCheck'=>['company_name'=>'companyName','short_name'=>'shortName','contact_mobile_num'=>'telephone','email'=>'email','description'=>'description','logo'=>'logoUrl','registered_capital'=>'registeredCapital'],
			'legalPersonCheck'=>['legal_person'=>'name','legal_person_idcard'=>'idCard','legal_person_idcard_front_url'=>'idCardfrontUrl','legal_person_idcard_back_url'=>'idCardBackUrl','legal_person_authority_book'=>'authorityBookUrl'],
			'registeredInfoCheck'=>['unified_social_credit_code_url'=>'newBusinessLicenseUrl','unified_social_credit_code'=>'newBusinessLicenseNum','business_license'=>'businessLicenseNum','business_license_url'=>'businessLicenseUrl','tax_registration_certificate'=>'taxRegistrationNum','tax_registration_certificate_url'=>'taxRegistrationUrl','org_code_certificate'=>'organizationCodeNum','org_code_certificate_url'=>'organizationCodeUrl','business_license_expire_time'=>'businessLicenseExpireTime','reg_time'=>'regTime','business_scope'=>'businessScope','address'=>'address'],
			'bankInfoCheck'=>['bank_name'=>'bank','account_no'=>'accountId','account_name'=>'accountName']
				];
		foreach($get as $k=>$v)
		{
			foreach($v as $key=>$val)
			{
				$ret = I('post.'.$key)=='Y'?'OK#':'FLS';
				$data[$k][$key] = ["result"=>$ret,"msg"=>I('post.'.$key.'_msg')];
			}
		}
		if(I('post.business_license_type')=='NEW')
		{
			$data['registeredInfoCheck']['business_license'] = ['result'=>'OK#','msg'=>''];
			$data['registeredInfoCheck']['business_license_url'] = ['result'=>'OK#','msg'=>''];
			$data['registeredInfoCheck']['org_code_certificate'] = ['result'=>'OK#','msg'=>''];
			$data['registeredInfoCheck']['org_code_certificate_url'] = ['result'=>'OK#','msg'=>''];
			$data['registeredInfoCheck']['tax_registration_certificate'] = ['result'=>'OK#','msg'=>''];
			$data['registeredInfoCheck']['tax_registration_certificate_url'] = ['result'=>'OK#','msg'=>''];
		}else{
			$data['registeredInfoCheck']['unified_social_credit_code_url'] = ['result'=>'OK#','msg'=>''];
			$data['registeredInfoCheck']['unified_social_credit_code'] = ['result'=>'OK#','msg'=>''];
		}
		$data['baseInfoCheck']['biddee_id']=I('post.id');
		return $data;
	}
}
