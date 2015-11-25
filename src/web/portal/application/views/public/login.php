<block name="header">
<header class="header ">
    <div class="head-cont ">
        <div class="cent  clear">
            <div class="logo blue  left">大力99</div>
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
        <form class="login-form auto" action="">
            <ul>
                <li>
                    <span class="left"><i class="ico i-member"></i></span>
                    <div class="auto"><input type="text" class="input1"  placeholder="请输入手机号/邮箱"></div>
                </li>
                <li>
                    <span class="left"><i class="ico i-password"></i></span>
                    <div class="auto"><input type="password" class="input1" placeholder="请输入密码"></div>
                </li>
            </ul>
            <div class="clear form-txt">
                <div class="left"><label><input type="checkbox">记住用户名</label></div>
                <div class="right"><a href="<?=U('forget')?>" class="blue">忘记密码</a></div>
            </div>
            <div class="loginBtnCont">
                <input type="submit" value="立即登录" class="sub1">
                <div class="form-txt2">没有账号？<a href="<?=U('register')?>" class="blue">免费注册</a></div>
            </div>
        </form>
    </div>
</div>