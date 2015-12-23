<div class=" main">
    <div class="miancont2 ">
        <div class="phone_yz">
            <form id="first-form" action="<?=U('/public/checkVerify')?>" class="setpassword ajax-form" method="POST" before="before_check_verify" success="success_callback" fail="check_verify_fail">
                <div class="txt3">
                    <span class="lab"><span class="red">*</span> 手机号</span>
                    <input type="text" placeholder="输入您绑定的手机号码" class="input1" name="mobile" id="input_mobile">
                </div>
                <div class="txt3">
                    <span class="lab">
                        <span class="red">*</span> 验证码
                    </span>
                    <input type="text" class="input1" name="verify_code" />
                    <img src="<?=U('/public/getcode/'.time());?>" alt="" class="yzm" id="yzm" title="看不清，点击换一张">
                </div>
                <div class="btnCont">
                    <span class="lab"></span>
                    <input type="submit" class="btn" value="下一步">
                </div>
                <p class="form-tips">若您无法使用上述方法找回，请联系客服400-000-2222</p>
            </form>
            <form class="setpassword ajax-form hide" action="<?=U('/public/checkMobileSms')?>" method="post" success="success_callback">
                <div class="txt1">“手机验证短信”已发送至您的手机</div>
                <div class="txt2" id="mobile_wrap"></div>
                <div class="txt3">
                    <span class="lab"><span class="red">*</span>收到的验证码</span>
                    <input type="text" class="input1" name="sms_code" id="sms_code">
                    <input type="hidden" name="mobile" class="mobile_num">
                </div>
                <div class="btnCont">
                    <span class="lab"></span>
                    <input type="submit" class="btn" value="提交">
                </div>
            </form>
            <form action="<?=U('/forget')?>" class="setpassword ajax-form hide" method="post" success="success_callback" fail="reset_pwd_failed">
                <div class="txt4">重置密码：请输入您的新密码</div>
                <div class="txt3">
                    <span class="lab"><span class="red">*</span> 新密码</span>
                    <input type="password" class="input1" name="new_pwd">
                </div>
                <div class="txt3">
                    <span class="lab"><span class="red">*</span> 确认新密码</span>
                    <input type="password" class="input1" name="r_new_pwd">
                </div>
                <div class="btnCont">
                    <span class="lab"></span>
                    <input type="submit" class="btn" value="提交">
                </div>
                <input type="hidden" class="sms_code" name="sms_code" id="r_sms_code">
                <input type="hidden" name="mobile" class="mobile_num">
            </form>
            <div id="success-wrap" class="hide">
                <p class="form-tips">恭喜您，已经成功重置您的密码！</p>
                <div class="padb90"><a href="<?=U('/login')?>" class="btn-blue">返回登录</a></div>
            </div>
        </div>
    </div>
</div>
<block name="script">
    <script>
        $(function(){
            function get_code(){
                $(this).attr('src','<?=U('/public/getcode/');?>'+'?'+Math.random());
            }
            $("#yzm").click(get_code);

        });

        function success_callback(form){
            if(form.index() == 0){
                var mobile_num = $.trim($("#input_mobile").val());
                $("#mobile_wrap").text(mobile_num);
                $(".mobile_num").val(mobile_num);
            }
            if(form.index() == 1){
                $("#r_sms_code").val($("#sms_code").val());
            }
            form.hide().next().show();
        }

        function before_check_verify(){
            var mobile_num = $.trim($("#input_mobile").val());
            if(mobile_num == ''){
                layer.alert('请输入手机号码！',{icon:2});
                return false;
            }
            if(is_mobile(mobile_num)){
                layer.alert('手机号码格式不正确！',{icon:2});
                return false;
            }
            return true;
        }
        function check_verify_fail(){
            $("#yzm").click();
        }
        function reset_pwd_failed(form,resp){
            if(resp.status === 999){
                form.hide();
                $("#first-form").show();
                $("input[name=verify_code],#sms_code").val('');
                $("#yzm").click();
            }
        }
    </script>
</block>
