<extend name="Public/base" />

<block name="body">
	<!-- 表单 -->

<style>
td{width:50%;}
</style>
<div class="widget-box" style="opacity: 1; z-index: 0;margin-bottom:1em;">
<div class="widget-header" style="color:#999;">
          <h5 class="bigger lighter">招标人基本信息</h5>        
</div>
<div class="widget-body">
<div class=""> 
       <table class="table  table-bordered " style="margin-bottom:0px;">
	<tbody>
		<tr>
			<td><span style="color:#999;padding-right:8px;">公司名称:</span>{$item.company_name}</td>
			<td><span style="color:#999;padding-right:8px;">公司简称:</span>{$item.short_name}</td>
		</tr>
		<tr>
			<td colspan="1"><span style="color:#999;padding-right:8px;">企业成立时间:</span>{$item.reg_time}</td>
			<td><span style="color:#999;padding-right:8px;">企业营业期限:</span>{$item.business_license_expire_time}</td>
		</tr>
		<tr>
			<td><span style="color:#999;padding-right:8px;">联系方式:</span>{$item.contact_mobile_num}</td>
			<td><span style="color:#999;padding-right:8px;">EMail:</span>{$item.email}</td>
		</tr>
		<tr>
			<td><span style="color:#999;padding-right:8px;">公司简介:</span>{$item.description}</td>
			<td><span style="color:#999;padding-right:8px;">公司LOGO:</span><img src="{$item.logourl}"/></td>
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
			<td><span style="color:#999;padding-right:8px;">身份证号:</span>{$item.legal_person_idcard}</td>
		</tr>
		<tr>
			<td colspan="2"><span style="color:#999;padding-right:8px;">身份证扫描件:</span><img src="{$item.legal_person_idcard_front_url}"/><img src="{$item.legal_person_idcard_back_url}"/></td>
		</tr>
		<tr>
			<td colspan="2"><span style="color:#999;padding-right:8px;">法人授权书:</span><img src="{$item.legal_person_idcard_back_url}"/></td>
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
<?php if($item['business_license_type']=='NEW'){ ?>
		<td ><span style="color:#999;padding-right:8px;">统一社会信用代码:</span>{$item.unified_social_credit_code}</td>
		</tr>
		<tr>
			<td colspan="2"><span style="color:#999;padding-right:8px;">营业执照扫描件:</span><img src="{$item.unified_social_credit_code_url}"/></td>
		</tr>
<?php }else{?>
	<tr>
		<td><span style="color:#999;padding-right:8px;">营业执照:</span><?php echo $item['business_license'];?></td>
			<td colspan="2"><span style="color:#999;padding-right:8px;">营业执照扫描件:</span><img src="<?php echo $item['business_license_url']?>"/></td>
		</tr>
	<tr>
		<td><span style="color:#999;padding-right:8px;">税务登记证编号:</span><?php echo $item['tax_registration_certificate'];?></td>
			<td colspan="2"><span style="color:#999;padding-right:8px;">税务登记证扫描件:</span><img src="<?php echo $item['tax_registration_certificate_url']?>"/></td>
		</tr>
	<tr>
		<td><span style="color:#999;padding-right:8px;">组织机构代码证编号:</span><?php echo $item['org_code_certificate'];?></td>
			<td colspan="2"><span style="color:#999;padding-right:8px;">组织机构代码证扫描件:</span><img src="<?php echo $item['org_code_certificate_url']?>"/></td>
		</tr>
<?php }?>
	<tr>
		<td><span style="color:#999;padding-right:8px;">营业期限:</span><?php echo $item['business_license_expire_time'];?></td>
		<td ><span style="color:#999;padding-right:8px;">注册时间:</span><?php echo $item['reg_time']?></td>
		</tr>
	<tr>
		<td colspan="2"><span style="color:#999;padding-right:8px;">经营范围:</span><?php echo $item['business_scope'];?></td>
		</tr>
	<tr>
		<td colspan="2"><span style="color:#999;padding-right:8px;">注册地址:</span><?php echo $item['address'];?></td>
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
			<td><span style="color:#999;padding-right:8px;">法人代表:</span>{$item.legal_person}</td>
			<td><span style="color:#999;padding-right:8px;">身份证号:</span>{$item.legal_person_idcard}</td>
		</tr>
		<tr>
			<td colspan="2"><span style="color:#999;padding-right:8px;">身份证扫描件:</span><img src="{$item.legal_person_idcard_front_url}"/><img src="{$item.legal_person_idcard_back_url}"/></td>
		</tr>
		<tr>
			<td colspan="2"><span style="color:#999;padding-right:8px;">法人授权书:</span><img src="{$item.legal_person_idcard_back_url}"/></td>
		</tr>
	 </tbody>
	</table>
</div>
</div>
</div>
		<div class="clearfix form-actions">
            <div class="col-xs-12 center" style="margin-top:1em;">
                <a onclick="history.go(-1)" class="btn btn-info" href="javascript:;">
	               <i class="icon-reply"></i>返回上一页
	            </a>  
            </div>
        </div>
</block>

<block name="script">
<script type="text/javascript" charset="utf-8">
	Think.setValue('type',{$type|default=1});
</script>
</block>
