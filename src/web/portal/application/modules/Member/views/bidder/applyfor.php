<div class=" main">
<link href="/css/jquery.datetimepicker.css" rel="stylesheet" type="text/css">
			<div class="box  pad0 bg-orange">
				<div class="stepbox2">
					<ul class="clear">
						<li class="first active">
							<span class="num"></span>
							<div class="line"></div>
							<span class="txt">1.填写基本信息</span>
						</li>
						<li >
							<span class="num"></span>
							<div class="line"></div>
							<span class="txt">2.填写公司注册信息</span>
						</li>
						<li>
							<span class="num"></span>
							<div class="line"></div>
							<span class="txt">3.填写行业资质</span>
						</li>
						<li class="last">
							<span class="num"></span>
							<div class="line"></div>
							<span class="txt">4.提交发包方注册申请</span>
						</li>
					</ul>
				</div>
			</div>

			<div class="clear mart30">
				<div class="left side_menu">
					<div class="progressBox">
						<div class="text-center">信息完整度<span id="creditRating">0</span>%</div>
						<div class="progress">
							<span style="width:0%" class="on"></span>
						</div>
					</div>
					<ul>
						<li class="on" data-id="base">
							<a href="javascript:;">基本信息 </a>
						</li>
						<li data-id="legal">
							<a href="javascript:;">法人信息 </a>
						</li>
						<li data-id="companyRegistered">
							<a href="javascript:;">公司注册信息 </a>
						</li>
						<li data-id="bank">
							<a href="javascript:;">银行开户信息</a>
						</li>
						<li data-id="zizhi">
							<a href="javascript:;">企业资质</a>
						</li>
					</ul>
					<div class="tijiao">
						<a href="#" id="tijiao" class="btn-tijiao">提交投标人认证</a>
					</div>

				</div>
				<div class="auto  box pad0 " id="base">
				<form action="<?=U('doapply')?>" method="post" class="ajax-form" success="base_sucess">
					<div class="h2">基本信息</div>
					<div class="padm30 jibenxx">
						<div class=" charge_form padv40">
							<div class="item">
								<span class="lab"><span class="red">*</span> 公司（单位）全称</span>
								<div class="auto value ">
									<input type="text" class="input1 " name="companyName" id="companyName" value="<?=$base['companyName']?>">
								</div>
							</div>
							<div class="item">
								<span class="lab"><span class="red">*</span> 公司（单位）简称</span>
								<div class="auto value ">
									<input type="text" class="input1" name="shortName" value="<?=$base['shortName']?>">
								</div>
							</div>
							<div class="item">
								<span class="lab"><span class="red">*</span> 公司（单位）LOGO</span>
								<div class="auto value ">
									<div class="btn-file2 padm10"><input type="file" class=""  name="logoUrl"  value="<?=$base['logoUrl']?>"> 上传公司LOGO</div>
								</div>
							</div>
							<div class="item">
								<span class="lab"><span class="red">*</span> 公司（单位）简介</span>
								<div class="auto value ">
									<textarea  id="" class="textarea" name="description" ><?=$base['description']?></textarea>
								</div>
							</div>
							<div class="item">
								<span class="lab">注册资本</span>
								<div class="auto value ">
									<input type="text" class="input1 " name="registeredCapital" value="<?=$base['registeredCapital']?>" >
								</div>
							</div>
							<div class="item">
								<span class="lab"><span class="red">*</span> 办公电话</span>
								<div class="auto value ">
									<input type="text" class="input1 " placeholder="区号+座机号码+分机号码" name="telephone" value="<?=$base['telephone']?>" >
								</div>
							</div>
							<div class="item">
								<span class="lab"><span class="red">*</span> 电子邮箱</span>
								<div class="auto value ">
									<input type="text" class="input1 " name="email" value="<?=$base['email']?>">
								</div>
							</div>

							<div class="text-center padv30">
								<input type="hidden" name="type" value="base" >
								<input type="submit" class="btn-green2" value="保存并继续">
							</div>

						</div>
					</div>
					</form>
				</div>
				<div class="auto  box pad0 hide" id="legal">
					<div class="h2">法人信息</div>
					<div class="padm30 chargeBox">
						<form action="<?=U('doapply')?>" method="post" class="ajax-form" success="legal_sucess">
						<div class=" charge_form padv40">
							<div class="item">
								<span class="lab">法人姓名</span>
								<div class="auto value ">
									<input type="text" class="input1 wid350" name="name" value="<?=$name?>" >
								</div>
							</div>
							<div class="item">
								<span class="lab">法人身份证号</span>
								<div class="auto value ">
									<input type="text" class="input1 wid350" name="idCard" value="<?=$idcard?>" >
								</div>
							</div>
							<div class="item">
								<span class="lab">法人身份证扫描件</span>
								<div class="value auto">
									<div class="marb20 clear">
										<img src="/uploads/pic.jpg" alt="" class="left marr10">
										<div class="left wid110">
											<label class="btn-file3  "> 上传附件<input type="file" name="idCardfrontUrl"></label>
											<div class="progress mart20">
												<span style="width:50%" class="on"></span>
											</div>
											<p class="color8 text-center">上传中…</p>
										</div>
									</div>
									<div class="marb20 clear">
										<img src="/uploads/pic.jpg" alt="" class="left marr10">
										<div class="left wid110">
											<label class="btn-file3  "> 上传附件<input type="file" name="idCardBackUrl"></label>
											<div class="progress mart20">
												<span style="width:50%" class="on"></span>
											</div>
											<p class="color8 text-center">上传中…</p>
										</div>
									</div>
								</div>
							</div>
							<div class="item">
								<span class="lab">法人授权书扫描件</span>
								<div class="auto value ">
									<div class="btn-file3 ">上传文件 <input type="file" name="authorityBookUrl"></div>
									<i class="ico tip-qus2 verm marl20"></i>
									<span class="red tips_txt">如果法人姓名与注册账号姓名不一致，<br>
										需要上传法人授权书</span>
									</div>
								</div>


								<div class="text-center padv30">
									<input type="hidden" name="type" value="legal" >
									<input type="submit" class="btn-green2" value="保存并继续">
								</div>

							</div>
						</form>
						</div>
					</div>
				

				<div class="auto  box pad0 hide"  id="companyRegistered">
					<div class="h2">公司注册信息</div>
					<div class="padm30 jibenxx">
						<form action="<?=U('doapply')?>" method="post" class="ajax-form" success="companyRegistered_sucess">
						<div class="text-center checkBtn padv40 zhucexx">
							<a href="javascript:;" class="active">统一社会信用代码</a>
							<a href="javascript:;" class="">非统一社会信用代码</a>
						</div>
						<!--统一社会信用代码-->
						<div class=" charge_form ">
							<div class="item">
								<span class="lab"><span class="red">*</span> 统一社会信用代码</span>
								<div class="auto value ">
									<input type="text" class="input1 " name="newBusinessLicenseNum" value="<?=$registered['newBusinessLicenseNum']?>">
								</div>
							</div>
							
							<div class="item">
								<span class="lab"><span class="red">*</span> 统一社会信用代码扫描件</span>
								<div class="auto value ">
									<div class="btn-file3">上传文件 <input type="file" name="newBusinessLicenseUrl"></div>
									<div class="progress wid100 dib">
										<span style="width:50%" class="on"></span>
									</div>
									<span class="color8 text-center">上传中…</span>
								</div>
							</div>
</div>
<div class=" charge_form hide" >
							<div class="item">
								<span class="lab"><span class="red">*</span> 营业执照编号</span>
								<div class="auto value ">
									<input type="text" class="input1 " name="businessLicenseNum" value="<?=$registered['businessLicenseNum']?>">
								</div>
							</div>
							
							<div class="item">
								<span class="lab"><span class="red">*</span> 营业执照扫描件</span>
								<div class="auto value ">
									<div class="btn-file3">上传文件 <input type="file" name="businessLicenseUrl"></div>
									<div class="progress wid100 dib">
										<span style="width:50%" class="on"></span>
									</div>
									<span class="color8 text-center">上传中…</span>
								</div>
							</div>

							<div class="item">
								<span class="lab"><span class="red">*</span> 组织机构代码证编号</span>
								<div class="auto value ">
									<input type="text" class="input1 " name="organizationCodeNum" value="<?=$registered['organizationCodeNum']?>">
								</div>
							</div>
							
							<div class="item">
								<span class="lab"><span class="red">*</span> 组织机构代码证扫描件</span>
								<div class="auto value ">
									<div class="btn-file3">上传文件 <input type="file" name="organizationCodeUrl"></div>
									<div class="progress wid100 dib hide">
										<span style="width:50%" class="on"></span>
									</div>
									<span class="color8 text-center hide">上传中…</span>
								</div>
							</div>

							<div class="item">
								<span class="lab"><span class="red">*</span> 税务登记证编号</span>
								<div class="auto value ">
									<input type="text" class="input1 " name="taxRegistrationNum" value="<?=$registered['taxRegistrationNum']?>">
								</div>
							</div>
							
							<div class="item">
								<span class="lab"><span class="red">*</span> 税务登记证扫描件</span>
								<div class="auto value ">
									<div class="btn-file3">上传文件 <input type="file" name="taxRegistrationUrl"></div>

								</div>
							</div>
</div>
							<div class="item">
								<span class="lab"><span class="red">*</span> 经营范围</span>
								<div class="auto value ">
									<textarea  id="" class="textarea" name="businessScope"><?=$registered['businessScope']?></textarea>
								</div>
							</div>
							<div class="item">
								<span class="lab"><span class="red">*</span> 成立时间</span>
								<div class="auto value ">
									<input type="text" class="input1 datepicker" name="regTime" value="<?=$registered['regTime']?>">
								</div>
							</div>
							<div class="item">
								<span class="lab"><span class="red">*</span> 营业期限</span>
								<div class="auto value ">
									<div class="select">
										<select name="businessLicenseExpireTime" id="">
											<option value="1" <?=$registered['businessLicenseExpireTime']=='1'?'selected':''?> >一年</option>
											<option value="2" <?=$registered['businessLicenseExpireTime']=='1'?'selected':''?> >两年</option>
										</select>
									</div>
								</div>
							</div>
							<div class="item">
								<span class="lab"><span class="red">*</span> 公司地址</span>
								<div class="auto value ">
									<input type="text" class="input1 " name="address" value="<?=$registered['address']?>" >
								</div>
							</div>

							<div class="text-center padv30">
								<input  type="submit" class="btn-green2" value="保存并继续">
							</div>
						</div>
						<!--非统一社会信用代码-->
						<input type="hidden" name="type" value="companyRegistered" >
						<input type="hidden" name="businessLicenseType" value="<?=$registered['address']=='OLD'?'OLD':'NEW';?>" id="businessLicenseType" >
					</form>
					</div>

				<div class="auto  box pad0 hide" id="bank">
					<div class="h2">银行开户信息</div>
					<div class="padm30 chargeBox">
						<form action="<?=U('doapply')?>" method="post" class="ajax-form" success="bank_sucess">
						<div class=" charge_form padv40">
							<div class="item">
								<span class="lab"><span class="red">*</span> 开户银行</span>
								<div class="auto value ">
									<input type="text" name="bank" class="input1 wid350" value="<?=$bankInfo['bank'];?>">
								</div>
							</div>
							<div class="item">
								<span class="lab"><span class="red">*</span> 银行账号</span>
								<div class="auto value ">
									<input type="text" class="input1 wid350" name="accountId" value="<?=$bankInfo['accountId']?>">
								</div>
							</div>
							<div class="text-center padv30">
								<input type="hidden" name="type" value="bankInfo" >
								<input type="hidden" name="accountName" value="<?=$bankInfo['accountName']?>" id="accountName">
								<input type="submit" class="btn-green2" value="保存并继续">
							</div>
						</div>
					</form>
					</div>
				</div>
				<div class="auto  box pad0 hide" id="zizhi"> 
					<div class="h2">企业资质</div>
					<div class="padm30 jibenxx" id="zizhi_show">
						<div id="zizhi_model" >
						</div>
						<div class=" charge_form padv20">
							<div class="item">
								<span class="lab"><span class="red">*</span> 工程类别</span>
								<div class="auto value ">
									<a href="#" class="btn right" id="save">保存</a>
									<div class="select">
										<select name="projectType" id="projectType">
<?php foreach($projectType as $k=>$v){?>
	<option value="<?=$v?>"><?=$v?></option>
<?php }?>
										</select>
									</div>
								</div>
							</div>
							<div class="item">
								<span class="lab"><span class="red">*</span> 资质名称</span>
								<div class="auto value ">
									<div class="select">
										<select name="eqName" id="eqName" >
										</select>
									</div>
								</div>
							</div>
							<div class="item">
								<span class="lab">资质编号</span>
								<div class="auto value ">
									<input type="text" class="input1 " name="certificationNo" id="certificationNo">
								</div>
							</div>
							<div class="item">
								<span class="lab"><span class="red">*</span> 资质有效期</span>
								<div class="auto value ">
									<input type="text" class="input1 datepicker" name="expiryDate" id="expiryDate">
								</div>
							</div>
							<div class="item">
								<span class="lab"><span class="red">*</span> 适用区域</span>
								<div class="auto value ">
									<input type="text" class="input1 " name="applicableRegion" id="applicableRegion">
								</div>
							</div>

							<div class="item bordb padb30">
								<span class="lab"><span class="red">*</span> 附件上传</span>
								<div class="auto value ">
									<div class="btn-file3">上传文件 <input type="file"></div>
									<div class="wid100 dib vert marl10">
										<p class="color8 text-center lineh20">上传中…</p>
										<div class="progress mart5">
											<span style="width:50%" class="on"></span>
										</div>
									</div>
								</div>
							</div>
<!--
							<div class="bordb text-center padv40">
								<a href="#"><img src="/images/add.png" height="54" width="54" alt=""></a>
							</div>
							<p class="checklist text-center padt20"><i class="ico i-check"></i> 我已阅读并同意《XXXX协议》</p>

-->
							<div class="text-center padv30">
								<input type="hidden" name="type" value="bankInfo" >
								<input type="button" id="submit" success="zizhi_sucess" class="btn-green2" value="保存并继续" >
							</div>
						</div>
					</div>
				</div>
				</div>
			<!--list-->

			<block name="script">
			<script src="/js/jquery.datetimepicker.js"></script>
			<script>
function add(obj)
{
var tmp = [];
 tmp.push('<div class="subitem"><div class="text-right padt20"> <a href="javascript:;" class="btn " onclick="edit();">修改</a> <a href="javascript:;" class=" btn-grey2 marl10 " onclick="del();">删除</a> </div> <div class="qyzz bordb padb30"> <span class="left leftimg "><img src="');
tmp.push(obj.certificationContent);
tmp.push('"></span><div class="auto"> <div class="item"> <span class="lab">资质类别</span> <div class="auto value" data-name="projectType">');
tmp.push(obj.projectType);
tmp.push('</div> </div> <div class="item"> <span class="lab">资质名称</span> <div class="auto value" data-name="eqName">');
tmp.push(obj.eqName);
tmp.push('</div> </div> <div class="item"> <span class="lab">资质编号</span> <div class="auto value" data-name="certificationNo">');
tmp.push(obj.certificationNo);
tmp.push('</div> </div> <div class="item"> <span class="lab">资质有效期</span> <div class="auto value" data-name="expiryDate">');
tmp.push(obj.expiryDate);
tmp.push('</div> </div> <div class="item"> <span class="lab">适用区域</span> <div class="auto value" data-name="applicableRegion">');
tmp.push(obj.applicableRegion);
tmp.push('</div></div></div>');
$('#zizhi_model').append(tmp.join(''));
}
function del()
{
var _this = event.target;
$(_this).parent().parent().remove();
}
function edit()
{
var _this = event.target;
$(_this).parent().parent().find('.value').each(function(i,o){
var id = $(o).data('name')
$('#'+id).val($(o).html());
});
var src = $(_this).parent().parent().find('img').eq(0).attr('src');
$('#certificationContent').attr('src',src);
$(_this).parent().parent().remove();
}
function save(){
var obj ={};
obj.certificationContent = $('#certificationContent').val();
$('#certificationContent').val('');
obj.projectType= $('#projectType').val();
$('#projectType').val('');
obj.eqName= $('#eqName').val();
$('#eqName').val('');
obj.certificationNo= $('#certificationNo').val();
$('#certificationNo').val('');
obj.expiryDate= $('#expiryDate').val();
$('#expiryDate').val('');
obj.applicableRegion= $('#applicableRegion').val();
$('#applicableRegion').val('');
add(obj);
}
function submit()
{
var obj = [];
$('#zizhi_model').find('.subitem').each(function (i,o){
var tmp = {}
$(o).find('.value').each(function(i,o){
var id = $(o).data('name')
tmp[id]= $(o).html();
});
var src = $(o).find('img').eq(0).attr('src');
tmp.certificationContent=src;
obj.push(tmp);
});
	
	var loading = layer.load();
        $.post('<?=U('doapply')?>',{type:'zizhi',data:obj},function(resp){
            if(resp.status == '0'){

                if(resp.url != '' && resp.msg == ''){
                    window.location = resp.url;
                }else if(resp.msg != '' && resp.url != null && resp.url != '' ){
                    layer.msg(resp.msg,{icon:1},function(){
                        window.location = resp.url;
                    });
                }else if(resp.msg != ''){
                    layer.msg(resp.msg,{icon:1},function(){
                        calculateFunctionValue($this.attr('success'),[resp,$this],'');
                    });
                }
            }
            else{
                layer.alert(resp.msg);
            }
        },'json').always(function () {
            layer.close(loading);
        });
}
var eqName = <?=json_encode($certificateName);?>;
function selected()
{
var val = $('#projectType').val();
var o = eqName[val];
$('#eqName').empty();
for(var i=0;i<o.length;i++)
{
$('#eqName').append('<option value="'+o[i].certificateName+'">'+o[i].certificateName+'</option>');
}
}
				function base_sucess()
				{

					$('#base').hide();
					$('#legal').show();
					$(".stepbox2 .clear li").removeClass('active');
					$(".stepbox2 .clear li:eq(1)").addClass('active');
					$(".side_menu li").removeClass('on');
					$(".side_menu li:eq(1)").addClass('on');
					$(".side_menu li:eq(0) a").html('基本信息 <i class="ico i-right"></i>');
					$('#creditRating').html('20');
					$(".progressBox .progress span").css({'width':'20%'});
					$('#accountName').val($('#companyName').val());
				}
				function legal_sucess()
				{

					$('#legal').hide();
					$('#companyRegistered').show();
					$(".stepbox2 .clear li").removeClass('active');
					$(".stepbox2 .clear li:eq(1)").addClass('active');
					$(".side_menu li").removeClass('on');
					$(".side_menu li:eq(2)").addClass('on');
					$(".side_menu li:eq(1) a").html('法人信息 <i class="ico i-right"></i>');
					$('#creditRating').html('40');
					$(".progressBox .progress span").css({'width':'40%'})
				}
				function companyRegistered_sucess()
				{

					$('#companyRegistered').hide();
					$('#bank').show();
					$(".stepbox2 .clear li").removeClass('active');
					$(".stepbox2 .clear li:eq(2)").addClass('active');
					$(".side_menu li").removeClass('on');
					$(".side_menu li:eq(3)").addClass('on');
					$(".side_menu li:eq(2) a").html('公司注册信息 <i class="ico i-right"></i>');
					$('#creditRating').html('60');
					$(".progressBox .progress span").css({'width':'60%'})
				}
				function bank_sucess()
				{
					$('#bank').hide();
					$('#zizhi').show();
					$(".side_menu li:eq(3) a").html('银行开户信息 <i class="ico i-right"></i>');
					$('#creditRating').html('80');
					$(".progressBox .progress span").css({'width':'80%'});
				}
				function zizhi_sucess()
				{
					$(".stepbox2 .clear li").removeClass('active');
					$(".stepbox2 .clear li:eq(4)").addClass('active');
					$(".side_menu li:eq(4) a").html('企业资质 <i class="ico i-right"></i>');
					$('#creditRating').html('100');
					$(".progressBox .progress span").css({'width':'100%'});
					$('#tijiao').attr('href','<?=U('submitapply')?>');
				}
				function change()
				{
					if($(this).find('.i-right').size()==0)
					{
						return false;
					}
					$(".side_menu li").removeClass('on');
					$(this).addClass('on');
					$(".auto.box").hide();
					var id = $(this).data('id');
					$('#'+id).show();
				}
				function init()
				{
					selected();
					var base="<?=empty($base['companyName'])?'1':'0'?>";
					if(base==0)
					{
						base_sucess();
					}else{
						return;
					}
					var legal="<?=empty($legal['name'])?'1':'0'?>";
					if(legal==0)
					{
						legal_sucess();
					}else{
						return;
					}
					var registered="<?=empty($registered['businessLicenseType'])?'1':'0'?>";
					if(registered==0)
					{
						companyRegistered_sucess();
					}else{
						return;
					}
					var bankInfo="<?=empty($bankInfo['accountId'])?'1':'0'?>";
					if(bankInfo==0)
					{
						bank_sucess();
					}else{
						return;
					}
				}
				$(function(){
					$(".jibenxx .checkBtn a").click(function() {
						var i = $(this).index();
						$('#companyRegistered .charge_form').addClass('hide');
						$('#companyRegistered .charge_form').eq(i).removeClass('hide');
						if(i ==1 )
						{
							$('#businessLicenseType').val('NEW');
						}else
						{
							$('#businessLicenseType').val('OLD');
						}

					});
					$(".side_menu li").click(change);
					$("#save").click(save);
					$('#projectType').change(selected);
					$('#submit').click(submit);
					init();
				})

	
			</script>
			</block>
