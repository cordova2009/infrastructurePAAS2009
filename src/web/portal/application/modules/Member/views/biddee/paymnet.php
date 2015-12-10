<div class="main">
			<div class="clear">
			<?php
			require_once APP_PATH.'modules/Member/views/common/nav.php';
			?>
			<div class="content auto">
					<div class="tit3">付款</div>
					<div class="padm30 chargeBox">
						<p class="padv20">请按照以下目标账户信息转账</p>
						<div class="color5 bordb padb20">
							<div class="item">
								<span class="lab">账户名</span>
								<div class="auto value ">
								<?=$bankInfo['accountName']?>	
								</div>
							</div>
							<div class="item">
								<span class="lab">账户</span>
								<div class="auto value ">
								<?=$bankInfo['accountId']?>	
								</div>
							</div>
							<div class="item">
								<span class="lab">开户行</span>
								<div class="auto value">
								<?=$bankInfo['bankName']?>	
								</div>
							</div>
						</div>

						<div class="padv40 charge_form">
						<form action="" method="post" class="ajax-form" >
							<div class="item">
								<span class="lab"><span class="red">*</span> 付款金额</span>
								<div class="auto value ">
									<span class="yuanbox">
										<span class="yuan">元</span>
										<input type="text" class="input1 " name="amount">
									</span>
								</div>
							</div>
							<div class="item">
								<span class="lab"><span class="red">*</span> 付款时间</span>
								<div class="auto value ">
									<input type="text" class="input1 datepicker date2" name="transferTime">
								</div>
							</div>
							<div class="item">
								<span class="lab"><span class="red">*</span> 转账银行名称</span>
								<div class="auto value ">
									<input type="text" class="input1 " placeholder="某某银行某某支行" name="bankName">
								</div>
							</div>
							<div class="item">
								<span class="lab"><span class="red">*</span> 银行转账凭证编号</span>
								<div class="auto value ">
									<input type="text" class="input1 " placeholder="" name="voucherNo">
								</div>
							</div>
							<div class="item">
								<span class="lab"><span class="red">*</span> 银行转账凭证扫描件</span>
								<div class="auto value">
									<label class="btn-file2 wid110 "> 上传文件<input type="file" name="file"><input type="hidden" name="voucherFileUrl" value=""></label>
								</div>
							</div>
							<div class="item">
								<span class="lab"></span>
								<div class="auto value">
								<input type="hidden" name="objectId" value="<?=$objectId?>">
									<input type="submit" value="提交付款" class="btn2 wid110">
								</div>
							</div>
							</form>
						</div>

						<div class="charge_tips2">
							<p><i class="ico i-tips"></i> 温馨提示</p>
							<p>1、为了您的资金安全，请在付款前检查目标付款账户和银行名称是否正确。</p>
							<p>2、您的付款资金将通过银行转账到目标账户。 </p>
							<p>3、转账完成后，需要在这里提交转账凭证，目标账户收到后，将会对您的付款进行确认。 </p>
							<p>4、请注意您的银行账户的转账限制，以免造成不便。</p>
							<p>5、禁止洗钱、信用卡套现、虚假交易等行为，一经发现并确认，将终止该账户的使用。</p>
							<p>6、如果充值金额在48小时候没有到账，请联系客服：400-xxx-xxxx</p>
						</div>
					</div>
				</div>
			</div>
		</div>
<block name="script">
<script>
$(function(){
    $("#left-menu .submenu:eq(2),#left-menu .submenu:eq(2) a:eq(2)").addClass('active');
    $(".tblistTbale tr:odd").addClass('bg1');

    $("input[type=file]").fileupload({
        url:'<?=U('/member/upload/picture')?>',//文件上传地址，当然也可以直接写在input的data-url属性内
        dataType: 'json',
        formData:{},//如果需要额外添加参数可以在这里添加
        done:function(e,data){
            //done方法就是上传完毕的回调函数，其他回调函数可以自行查看api
            //注意result要和jquery的ajax的data参数区分，这个对象包含了整个请求信息
            //返回的数据在result.result中，假设我们服务器返回了一个json对象
            if(data.result.status == '0'){
	    	$(this).next().val(data.result.url);
		if($(this).next().next().attr('name')=='cshow')
		{
		$(this).next().next().val(data.result.src);
		}
                layer.msg('上传成功',{icon:1});
            }else{
                layer.alert(data.result.msg,{icon:2});
            }
        }
    })
})
</script>
</block>
