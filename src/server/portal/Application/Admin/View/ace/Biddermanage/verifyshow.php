<extend name="Public/base" />

<block name="body">
	<!-- 表单 -->

<style>
td{width:50%;}
img{max-width:400px;}
</style>
<form action="{:U('check')}" method="POST" class="form-horizontal" id="form_submit" role="form">
<input type="hidden" name="id"  value="{$item.id}">
<div class="widget-box" style="opacity: 1; z-index: 0;margin-bottom:1em;">
<div class="widget-header" style="color:#999;">
          <h5 class="bigger lighter">投标人基本信息</h5>        
</div>
<div class="widget-body">
<div class=""> 
       <table class="table  table-bordered " style="margin-bottom:0px;">
	<tbody>
		<tr>
			<td><span style="color:#999;padding-right:8px;">公司名称:</span>{$item.company_name}</td>
			<td><span style="color:#999;padding-right:8px;"><input type="checkbox" value="Y" name="company_name"> 审核通过</span><input type="text" name="company_name_msg" placeholder="输入审核未通过原因"></td>
		</tr>
		<tr>
			<td><span style="color:#999;padding-right:8px;">公司简称:</span>{$item.short_name}</td>
			<td><span style="color:#999;padding-right:8px;"><input type="checkbox" value="Y" name="short_name"> 审核通过</span><input type="text" name="short_name_msg" placeholder="输入审核未通过原因"></td>
		</tr>
		<tr>
			<td><span style="color:#999;padding-right:8px;">注册资本:</span>{$item.registered_capital}</td>
			<td><span style="color:#999;padding-right:8px;"><input type="checkbox" value="Y" name="registered_capital"> 审核通过</span><input type="text" name="registered_capital_msg" placeholder="输入审核未通过原因"></td>
		</tr>
		<tr>
			<td><span style="color:#999;padding-right:8px;">联系方式:</span>{$item.contact_mobile_num}</td>
			<td><span style="color:#999;padding-right:8px;"><input type="checkbox" value="Y" name="contact_mobile_num"> 审核通过</span><input type="text" name="contact_mobile_num_msg" placeholder="输入审核未通过原因"></td>
		</tr>
		<tr>
			<td><span style="color:#999;padding-right:8px;">EMail:</span>{$item.email}</td>
			<td><span style="color:#999;padding-right:8px;"><input type="checkbox" value="Y" name="email"> 审核通过</span><input type="text" name="email_msg" placeholder="输入审核未通过原因"></td>
		</tr>
		<tr>
			<td><span style="color:#999;padding-right:8px;">公司简介:</span>{$item.description}</td>
			<td><span style="color:#999;padding-right:8px;"><input type="checkbox" value="Y" name="description"> 审核通过</span><input type="text" name="description_msg" placeholder="输入审核未通过原因"></td>
		</tr>
		<tr>
			<td><span style="color:#999;padding-right:8px;">公司LOGO:</span><img src="{$item.logo|imageView2}"/></td>
			<td><span style="color:#999;padding-right:8px;"><input type="checkbox" value="Y" name="logo"> 审核通过</span><input type="text" name="logo_msg" placeholder="输入审核未通过原因"></td>
		</tr>
	 </tbody>
	</table>
</div>
</div>
</div>
<div class="widget-box" style="opacity: 1; z-index: 0;margin-bottom:1em;">
<div class="widget-header" style="color:#999;">
          <h5 class="bigger lighter">企业法人信息</h5>        
</div>
<div class="widget-body">
<div class=""> 
       <table class="table  table-bordered " style="margin-bottom:0px;">
	<tbody>
		<tr>
			<td><span style="color:#999;padding-right:8px;">法人代表:</span>{$item.legal_person}</td>
			<td><span style="color:#999;padding-right:8px;"><input type="checkbox" value="Y" name="legal_person"> 审核通过</span><input type="text" name="legal_person_msg" placeholder="输入审核未通过原因"></td>
		</tr>
		<tr>
			<td><span style="color:#999;padding-right:8px;">身份证号:</span>{$item.legal_person_idcard}</td>
			<td><span style="color:#999;padding-right:8px;"><input type="checkbox" value="Y" name="legal_person_idcard"> 审核通过</span><input type="text" name="legal_person_idcard_msg" placeholder="输入审核未通过原因"></td>
		</tr>
		<tr>
			<td ><span style="color:#999;padding-right:8px;">身份证扫描件正面:</span><img src="{$item.legal_person_idcard_front_url|imageView2}"/>
			<td><span style="color:#999;padding-right:8px;"><input type="checkbox" value="Y" name="legal_person_idcard_front_url"> 审核通过</span><input type="text" name="legal_person_idcard_front_url_msg" placeholder="输入审核未通过原因"></td>
		</tr>
		<tr>
			<td ><span style="color:#999;padding-right:8px;">身份证扫描件反面:</span><img src="{$item.legal_person_idcard_back_url|imageView2}"/></td>
			<td><span style="color:#999;padding-right:8px;"><input type="checkbox" value="Y" name="legal_person_idcard_back_url"> 审核通过</span><input type="text" name="legal_person_idcard_back_url_msg" placeholder="输入审核未通过原因"></td>
		</tr>
		<tr>
			<td ><span style="color:#999;padding-right:8px;">法人授权书:</span><img src="{$item.legal_person_authority_book|imageView2}"/></td>
			<td><span style="color:#999;padding-right:8px;"><input type="checkbox" value="Y" name="legal_person_authority_book"> 审核通过</span><input type="text" name="legal_person_authority_book_msg" placeholder="输入审核未通过原因"></td>
		</tr>
	 </tbody>
	</table>
</div>
</div>
</div>
<div class="widget-box" style="opacity: 1; z-index: 0;margin-bottom:1em;">
<div class="widget-header" style="color:#999;">
          <h5 class="bigger lighter">企业注册信息</h5>        
</div>
<div class="widget-body">
<div class=""> 
       <table class="table  table-bordered " style="margin-bottom:0px;">
	<tbody>
		<tr>
			<td colspan="2" ><span style="color:#999;padding-right:8px;">营业执照类型:</span><?php echo $item['business_license_type']=='NEW'?'三证合一':'非三证合一';?></td>
		</tr>
<?php if($item['business_license_type']=='NEW'){ ?>
		<tr>
		<td ><span style="color:#999;padding-right:8px;">统一社会信用代码:</span>{$item.unified_social_credit_code}</td>
		<td><span style="color:#999;padding-right:8px;"><input type="checkbox" value="Y" name="unified_social_credit_code"> 审核通过</span><input type="text" name="unified_social_credit_code_msg" placeholder="输入审核未通过原因"></td>
		</tr>
		<tr>
			<td ><span style="color:#999;padding-right:8px;">营业执照扫描件:</span><img src="{$item.unified_social_credit_code_url|imageView2}"/></td>
		<td><span style="color:#999;padding-right:8px;"><input type="checkbox" value="Y" name="unified_social_credit_code_url"> 审核通过</span><input type="text" name="unified_social_credit_code_url_msg" placeholder="输入审核未通过原因"></td>
		</tr>
<?php }else{?>
	<tr>
		<td><span style="color:#999;padding-right:8px;">营业执照:</span><?php echo $item['business_license'];?></td>
		<td><span style="color:#999;padding-right:8px;"><input type="checkbox" value="Y" name="business_license"> 审核通过</span><input type="text" name="business_license_msg" placeholder="输入审核未通过原因"></td>
		</tr>
		<tr>
			<td ><span style="color:#999;padding-right:8px;">营业执照扫描件:</span><img src="<?php echo imageView2($item['business_license_url'])?>"/></td>
		<td><span style="color:#999;padding-right:8px;"><input type="checkbox" value="Y" name="business_license_url"> 审核通过</span><input type="text" name="business_license_url_msg" placeholder="输入审核未通过原因"></td>
		</tr>
	<tr>
		<td><span style="color:#999;padding-right:8px;">税务登记证编号:</span><?php echo $item['tax_registration_certificate'];?></td>
		<td><span style="color:#999;padding-right:8px;"><input type="checkbox" value="Y" name="tax_registration_certificate"> 审核通过</span><input type="text" name="tax_registration_certificate_msg" placeholder="输入审核未通过原因"></td>
		</tr>
	<tr>
			<td ><span style="color:#999;padding-right:8px;">税务登记证扫描件:</span><img src="<?php echo imageView2($item['tax_registration_certificate_url'])?>"/></td>
		<td><span style="color:#999;padding-right:8px;"><input type="checkbox" value="Y" name="tax_registration_certificate_url"> 审核通过</span><input type="text" name="tax_registration_certificate_url_msg" placeholder="输入审核未通过原因"></td>
		</tr>
	<tr>
		<td><span style="color:#999;padding-right:8px;">组织机构代码证编号:</span><?php echo $item['org_code_certificate'];?></td>
		<td><span style="color:#999;padding-right:8px;"><input type="checkbox" value="Y" name="org_code_certificate"> 审核通过</span><input type="text" name="org_code_certificate_msg" placeholder="输入审核未通过原因"></td>
		</tr>
	<tr>
			<td ><span style="color:#999;padding-right:8px;">组织机构代码证扫描件:</span><img src="<?php echo imageView2($item['org_code_certificate_url'])?>"/></td>
		<td><span style="color:#999;padding-right:8px;"><input type="checkbox" value="Y" name="org_code_certificate_url"> 审核通过</span><input type="text" name="org_code_certificate_url_msg" placeholder="输入审核未通过原因"></td>
		</tr>
<?php }?>
	<tr>
		<td><span style="color:#999;padding-right:8px;">营业期限:</span><?php echo $item['business_license_expire_time'];?></td>
		<td><span style="color:#999;padding-right:8px;"><input type="checkbox" value="Y" name="business_license_expire_time"> 审核通过</span><input type="text" name="business_license_expire_time_msg" placeholder="输入审核未通过原因"></td>
		</tr>
	<tr>
		<td ><span style="color:#999;padding-right:8px;">注册时间:</span><?php echo $item['reg_time']?></td>
		<td><span style="color:#999;padding-right:8px;"><input type="checkbox" value="Y" name="reg_time"> 审核通过</span><input type="text" name="reg_time_msg" placeholder="输入审核未通过原因"></td>
		</tr>
	<tr>
		<td><span style="color:#999;padding-right:8px;">经营范围:</span><?php echo $item['business_scope'];?></td>
		<td><span style="color:#999;padding-right:8px;"><input type="checkbox" value="Y" name="business_scope"> 审核通过</span><input type="text" name="business_scope_msg" placeholder="输入审核未通过原因"></td>
		</tr>
	<tr>
		<td ><span style="color:#999;padding-right:8px;">注册地址:</span><?php echo $item['address'];?></td>
		<td><span style="color:#999;padding-right:8px;"><input type="checkbox" value="Y" name="address"> 审核通过</span><input type="text" name="address_msg" placeholder="输入审核未通过原因"></td>
		</tr>
	 </tbody>
	</table>
</div>
</div>
</div>
<div class="widget-box" style="opacity: 1; z-index: 0;margin-bottom:1em;">
<div class="widget-header" style="color:#999;">
          <h5 class="bigger lighter">企业银行信息</h5>        
</div>
<div class="widget-body">
<div class=""> 
       <table class="table  table-bordered " style="margin-bottom:0px;">
	<tbody>
		<tr>
			<td><span style="color:#999;padding-right:8px;">开户行:</span>{$item.bank_name}</td>
		<td><span style="color:#999;padding-right:8px;"><input type="checkbox" value="Y" name="bank_name"> 审核通过</span><input type="text" name="bank_name_msg" placeholder="输入审核未通过原因"></td>
		</tr>
		<tr>
			<td><span style="color:#999;padding-right:8px;">银行账号:</span>{$item.account_no}</td>
		<td><span style="color:#999;padding-right:8px;"><input type="checkbox" value="Y" name="account_no"> 审核通过</span><input type="text" name="account_no_msg" placeholder="输入审核未通过原因"></td>
		</tr>
		<tr>
			<td ><span style="color:#999;padding-right:8px;">开户名:</span>{$item.account_name}</td>
		<td><span style="color:#999;padding-right:8px;"><input type="checkbox" value="Y" name="account_name"> 审核通过</span><input type="text" name="account_name_msg" placeholder="输入审核未通过原因"></td>
		</tr>
	 </tbody>
	</table>
</div>
</div>
</div>
		<div class="clearfix form-actions">
            <div class="col-xs-12 center" style="margin-top:1em;">
<button id="sub-btn" class="btn btn-success ajax-post no-refresh" target-form="form-horizontal" type="submit">
                              <i class="icon-ok bigger-110"></i> 确认提交
                          </button>
            </div>
        </div>
</form>
</block>

<block name="script">
<script type="text/javascript" charset="utf-8">
	Think.setValue('type',{$type|default=1});
</script>
</block>
