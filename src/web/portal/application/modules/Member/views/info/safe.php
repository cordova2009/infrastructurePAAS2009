<div class="main">
    <div class="clear">
        <?php
        require_once APP_PATH.'modules/Member/views/common/nav.php';
        ?>
        <div class="content auto">
            <div class="tit3 bordn">安全信息</div>
            <!--list-->
            <div class="list4">
                <ul>
                    <li>
                        <span class=" ico  i-nickname"></span>
                        <span class="lab">昵称</span>
                        <span class="value"><?=$user['nickname']?></span>
                    </li>
                    <li>
                        <span class=" ico  i-name"></span>
                        <span class="lab">真实姓名</span>
                        <span class="value"><?=$user['realName']?></span>
                        <span class="right"><a href="#" class="red2">已认证</a></span>
                    </li>
                    <li>
                        <span class=" ico  i-idcard"></span>
                        <span class="lab">身份证号</span>
                        <span class="value"><?=substr_replace($user['cardID'],'**********',4,12)?></span>
                        <span class="right"><a href="#" class="red2">已认证</a></span>
                    </li>
                    <li>
                        <div class="clear">
                            <span class=" ico  i-password1"></span>
                            <span class="lab">登录密码</span>
                            <span class="value"></span>
                            <span class="right"><a href="javascript:;" class="blue showBtn" >修改</a></span>
                        </div>
                        <form class="password hide ajax-form" method="post" action="<?=U('/member/info/updateLoginPwd')?>" success="update_pwd_success">
                            <p class="tips">为了您的账户安全，请定期更换登录密码，并确保登录密码设置与交易密码不同。</p>
                            <div class="form_items">
                                <div class="form_item">
                                    <label  class="lab2">原密码</label>
                                    <input name="old_password" type="password" class="input1">
                                </div>
                                <div class="form_item">
                                    <label  class="lab2">手机验证码</label>
                                    <input name="sms_code" type="text" class="input1 wid70" >
                                    <button class="getBtn get-code no-mobile" type="button">获取验证码</button>
                                </div>
                                <div class="form_item">
                                    <label class="lab2">新密码</label>
                                    <input name="new_password" type="password" class="input1" placeholder="请输入您的新密码">
                                </div>
                                <div class="form_item">
                                    <label  class="lab2">确认新密码</label>
                                    <input name="r_new_password" type="password" class="input1" placeholder="请再次输入您的新密码">
                                </div>
                                <div class="form_item">
                                    <label  class="lab2"></label>
                                    <button type="submit" class="btn">提交</button>
                                </div>
                            </div>
                        </form>
                    </li>
                    <li>
                        <div class="clear">
                            <span class=" ico  i-phone"></span>
                            <span class="lab">绑定手机</span>
                            <span class="value"><?=substr_replace($user['mobileNum'],'*****',3,5)?></span>
                            <span class="right"><a href="javascript:;" class="blue showBtn">修改</a></span>
                        </div>
                        <div class="phone hide">
                            <div class="phone_line">
                                <dl class="clear">
                                    <dd class="s1 active">验证原手机号码</dd>
                                    <dd class="s2">验证新手机号码</dd>
                                    <dd class="s3">成功</dd>
                                </dl>
                            </div>
                            <form class="ajax-form" method="post" action="<?=U('/member/info/updateMobile')?>" success="update_mobile_success">
                                <div class="phone_form form1 active">
                                    <div class="form_item">
                                        <div class="lab2">原手机号码</div>
                                        <div class="value2"><?=substr_replace($user['mobileNum'],'*****',3,5)?></div>
                                    </div>
                                    <div class="form_item">
                                        <div class="lab2">手机验证码</div>
                                        <div class="value2">
                                            <input id="sms_code" name="sms_code" type="text" class="input1 wid120" >
                                            <button class="getBtn get-code no-mobile" type="button">获取验证码</button>
                                        </div>
                                    </div>
                                    <div class="form_item">
                                        <div class="lab2"></div>
                                        <div class="value2"><a href="javascript:;" class="btn" id="phone_next">下一步</a></div>
                                    </div>
                                </div>

                                <div class="phone_form  form2">
                                    <div class="form_item">
                                        <div class="lab2">新手机号码</div>
                                        <div class="value2">
                                            <input id="mobile" name="new_mobile" type="text" class="input1 " >
                                        </div>
                                    </div>
                                    <div class="form_item">
                                        <div class="lab2">手机验证码</div>
                                        <div class="value2">
                                            <input id="second_sms_code" name="second_sms_code" type="text" class="input1 wid120" >
                                            <input class="getBtn get-code" value="获取验证码" type="button">
                                        </div>
                                    </div>
                                    <div class="form_item">
                                        <div class="lab2">登录密码</div>
                                        <div class="value2">
                                            <input name="password" type="password" class="input1 " >
                                        </div>
                                    </div>
                                    <div class="form_item">
                                        <div class="lab2"></div>
                                        <div class="value2">
                                            <button type="submit" class="btn">下一步</button>
                                        </div>
                                    </div>
                                </div>
                                <div class="phone_form form3">
                                    <span class=" ico i-ok2"></span>
                                    <div class="auto">绑定手机修改完成<br>5秒后将退出，请重新登录</div>
                                </div>
                            </form>
                        </div>

                    </li>
                    <li>
                        <div class="clear">
                            <span class=" ico  i-email"></span>
                            <span class="lab">绑定邮箱</span>
                            <span class="value"><?=$user['email']?></span>
                        </div>
                    </li>
                    <li class="bordn">
                        <div class="clear">
                            <span class=" ico  i-password2"></span>
                            <span class="lab">交易密码</span>
                            <span class="value"></span>
                            <span class="right"><a href="javascript:;" class="blue showBtn">修改</a></span>
                        </div>
                        <form class="password hide ajax-form" method="post" action="<?=U('/member/info/updateTradePwd')?>" success="update_pwd_success">
                            <p class="tips">为了您的账户安全，请定期更换交易密码，并确保交易密码设置与登录密码不同。</p>
                            <div class="form_items">
                                <div class="form_item">
                                    <label class="lab2">原密码</label>
                                    <input name="old_password" type="password" class="input1">
                                </div>
                                <div class="form_item">
                                    <label class="lab2">手机验证码</label>
                                    <input name="sms_code" type="text" class="input1 wid70" >
                                    <button class="getBtn get-code no-mobile" type="button">获取验证码</button>
                                </div>
                                <div class="form_item">
                                    <label class="lab2">新密码</label>
                                    <input name="new_password" type="password" class="input1" placeholder="请输入您的新密码">
                                </div>
                                <div class="form_item">
                                    <label class="lab2">确认新密码</label>
                                    <input name="r_new_password" type="password" class="input1" placeholder="请再次输入您的新密码">
                                </div>
                                <div class="form_item">
                                    <label class="lab2"></label>
                                    <button type="submit" class="btn">提交</button>
                                </div>
                            </div>
                        </form>

                    </li>
                </ul>
            </div>
        </div>
    </div>
</div>
<block name="script">
<script>
$(function(){
    $("#left-menu .submenu:eq(0),#left-menu .submenu:eq(0) a:eq(1)").addClass('active');

    $(".showBtn").click(function(event) {
        if(!$(this).hasClass('active')){
            $(this).parents(".clear").next(".hide").slideDown();
            $(this).addClass('active').html("取消修改");
        }else{
            $(this).removeClass('active').html("修改");
            $(this).parents(".clear").next(".hide").slideUp();
            step(0);
        }
    });
})

$("#phone_next").click(function () {
    var data = {sms_code:$("#sms_code").val()};
    var loading = layer.load();
    $.post('<?=U('/public/checkMobileSms')?>',data,function(resp){
        if(resp.status != '0'){
            valid = false;
            layer.alert(resp.msg);
        }else{
            step(1);
        }
    },'json').always(function () {
        layer.close(loading);
    });
});

function step(i){
    $(".phone_line dd").removeClass('active');
    $(".phone_line dd").eq(i).addClass('active');
    $(".phone_form ").removeClass('active');
    $(".phone_form").eq(i).addClass('active');
}
function update_mobile_success(){
    step(2);
    $.getJSON('<?=U('/logout')?>');

    setTimeout(function () {
        window.location = '<?=U('/logout')?>';
    },5000)
}
function update_pwd_success(obj){
    obj.find('input').val('');
}
</script>
</block>