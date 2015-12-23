<block name="header">
<header class="header ">
    <div class="head-cont ">
        <div class="cent  clear">
            <div class="logo left"><a href="/" class="blue">大力99</a></div>
            <div class="right login-txt">
                登录
            </div>
        </div>
    </div>
</header>
</block>
<div class="logo-main">
    <div class="bgf login-cont clear">
        <div class="left ad1">
            <img src="/uploads/ad1.jpg" >
        </div>
        <form class="login-form auto ajax-form" before="before_login" action="<?=U('login')?>" method="post">
            <ul>
                <li>
                    <span class="left"><i class="ico i-member"></i></span>
                    <div class="auto"><input id="username" name="username" type="text" class="input1"  placeholder="请输入手机号"></div>
                </li>
                <li>
                    <span class="left"><i class="ico i-password"></i></span>
                    <div class="auto"><input id="password" name="password" type="password" class="input1" placeholder="请输入密码"></div>
                </li>
            </ul>
            <div class="clear form-txt">
                <div class="left"><label><input type="checkbox" id="remember">记住用户名</label></div>
                <div class="right"><a href="<?=U('forget')?>" class="blue">忘记密码</a></div>
            </div>
            <div class="loginBtnCont">
                <button type="submit" class="sub1">立即登录</button>
                <div class="form-txt2">没有账号？<a href="<?=U('register')?>" class="blue">免费注册</a></div>
            </div>
        </form>
    </div>
</div>
<block name="script">
<script src="/js/jquery.cookie-1.4.1.min.js"></script>
<script>
function before_login(){
    var username = $.trim($("#username").val());
    if(username == ''){
        layer.alert('请输入手机号码！',{icon:2});
        return false;
    }
    var password = $.trim($("#password").val());
    if(password == ''){
        layer.alert('请输入密码！',{icon:2});
        return false;
    }

    if($("#remember").prop('checked')){
        $.cookie("username", username, { expires: 7 });
        $.cookie("password", password, { expires: 7 });
    }else{

        $.cookie("username", '', { expires: -1 });
        $.cookie("password", '', { expires: -1 });
    }
    return true;
}

$("#username").val($.cookie("username"));
$("#password").val($.cookie("password"));
</script>
</block>