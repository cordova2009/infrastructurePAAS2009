
<div class=" main">
			<div class="miancont2 ">
				<div class="phone_yz">
					<form action=""  id="forget-form" method="post" class="forget-form ajax-form setpassword" before="before_sub" success="forget_success">
						<div class="txt3">
							<span class="lab"><span class="red">*</span> 手机号</span> 
							<input type="text" placeholder="输入您绑定的手机号码" class="input1" id="mobile" >
						</div>
						<div class="txt3">
							<span class="lab">
								<span class="red">*</span> 验证码</span> 
								<input type="text" class="input1" maxlength="4" id="code">
								<img src="" alt="" class="yzm">
							</div>
							<div class="btnCont"><span class="lab"></span><input type="submit" class="btn" value="下一步"></div>
						</form>
						<p class="form-tips">若您无法使用上述方法找回，请联系客服400-000-2222</p>
					</div>
				</div>
			</div>
<block name="script">
		<script>
		$(function(){
			
		function get_code()
		{
			$.get('<?=U('/public/getcode/'.time());?>','',function (data){
				if(data.status==0)
				{
					$(".yzm").attr('src',data.src);
				}else{
					layer.alert(data.msg);
				}
			},'json');
		}
		get_code();
		$(".yzm").click(get_code);
		function forget_success ()
		{

		}
		function before_login(){
			if($.trim($("#mobile").val()) == ''){
				show_errmsg($("#mobile"),'请输入手机号码！');
				return false;
			}
			if($.trim($("#code").val()) == ''){
				show_errmsg($("#code"),'请输入验证码！');
				return false;
			}
			return true;
		}

		function show_errmsg(obj,msg){
       		 obj.addClass('error')
            .parent()
            .siblings('.tip').text(msg)
            .removeClass('tip-ok')
            .addClass('tip-error');
   		}
		});
		</script>
	</block>
