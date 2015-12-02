<div class=" main">
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
					</ul>
					<div class="tijiao">
						<a href="#" id="tijiao" class="btn-tijiao">提交招标人认证</a>
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
								<span class="lab"> 注册资本</span>
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
								<input type="submit" class="btn-green2" value="保存">
							</div>
						</div>
					</form>
					</div>
				</div>

				</div>
			<!--list-->

			<block name="script">
			<script>
				function base_sucess()
				{
					$('#base').hide();
					$('#legal').show();
					$(".stepbox2 .clear li").removeClass('active');
					$(".stepbox2 .clear li:eq(1)").addClass('active');
					$(".side_menu li").removeClass('on');
					$(".side_menu li:eq(1)").addClass('on');
					$(".side_menu li:eq(0) a").html('基本信息 <i class="ico i-right"></i>');
					$('#creditRating').html('25');
					$(".progressBox .progress span").css({'width':'25%'});
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
					$('#creditRating').html('50');
					$(".progressBox .progress span").css({'width':'50%'})
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
					$('#creditRating').html('75');
					$(".progressBox .progress span").css({'width':'75%'})
				}
				function bank_sucess()
				{
					$(".stepbox2 .clear li").removeClass('active');
					$(".stepbox2 .clear li:eq(3)").addClass('active');
					$(".side_menu li:eq(3) a").html('银行开户信息 <i class="ico i-right"></i>');
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
					var base="<?=empty($base['companyName'])?'1':'0'?>";
					if(base==0)
					{
						base_sucess();
						return;
					}
					var legal="<?=empty($legal['name'])?'1':'0'?>";
					if(legal==0)
					{
						legal_sucess();
						return;
					}
					var registered="<?=empty($registered['businessLicenseType'])?'1':'0'?>";
					if(registered==0)
					{
						companyRegistered_sucess();
						return;
					}
					var bankInfo="<?=empty($bankInfo['accountId'])?'1':'0'?>";
					if(bankInfo==0)
					{
						bank_sucess();
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
					init();
				})
	
			</script>
			</block>
