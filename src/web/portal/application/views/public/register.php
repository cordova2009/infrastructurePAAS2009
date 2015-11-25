<block name="header">
<header class="header ">
    <div class="head-cont ">
        <div class="cent  clear">
            <div class="logo blue  left">大力99</div>
            <div class="right login-txt">
                注册
            </div>
        </div>
    </div>
</header>
</block>
<div class="main">
    <div class="bgf register-cont">
        <div class="reg-step">
            <ul class="clear">
                <li class="first active">
                    <span class="num">1</span>
                    <span class="txt">填写基本资料</span>
                </li>
                <li>
                    <span class="num">2</span>
                    <div class="line"></div>
                    <span class="txt">身份证校验</span>
                </li>
                <li class="last">
                    <div class="line"></div>
                    <span class="num">3</span>
                    <span class="txt">注册成功</span>
                </li>
            </ul>
        </div>
        <!--step1-->
        <div class="stepbox step1 active">
            <div class="text-right color8">
                已有账号？<a class="blue" href="#">立即登录</a>
            </div>
            <form class="reg-form">
                <dl class="clear">
                    <dt><span class="red">*</span>昵称</dt>
                    <dd class="input-cont nickname">
                        <input type="text" class="input error" placeholder="输入昵称">
                    </dd>
                    <dd class="tip-error">
                        输入的昵称已被使用
                    </dd>
                </dl>
                <dl class="clear">
                    <dt><span class="red">*</span>手机号码</dt>
                    <dd class="input-cont tel">
                        <input type="text" class="input" placeholder="输入昵称">
                    </dd>
                    <dd class="tip-ok">
                    </dd>
                </dl>
                <dl class="clear">
                    <dt><span class="red">*</span>验证码</dt>
                    <dd class="input-cont2">
                        <input type="text" class="input" placeholder="输入验证码">
                    </dd>
                    <dd class="">
                        <input class="getBtn reg_time" value="获取验证码" type="button">
                    </dd>
                </dl>
                <dl class="clear">
                    <dt><span class="red">*</span>登录密码</dt>
                    <dd class="input-cont password">
                        <input type="password" class="input" placeholder="输入密码">
                    </dd>
                </dl>
                <dl class="clear">
                    <dt><span class="red">*</span>确认登录密码</dt>
                    <dd class="input-cont password">
                        <input type="password" class="input" placeholder="再次输入密码">
                    </dd>
                </dl>
                <div class="next">
                    <a href="javascript:;" class="btn1">下一步</a>
                </div>
            </form>
        </div>
        <!--step2-->

        <div class="stepbox step2">
            <form class="reg-form">
                <dl class="clear">
                    <dt><span class="red">*</span>真实姓名</dt>
                    <dd class="input-cont nickname">
                        <input type="text" class="input " placeholder="输入真实姓名">
                    </dd>
                    <dd class="tip-qus">
                    </dd>
                </dl>
                <dl class="clear">
                    <dt><span class="red">*</span>身份证号码</dt>
                    <dd class="input-cont idcard">
                        <input type="text" class="input" placeholder="输入身份证号码">
                    </dd>
                    <dd class="tip-qus">
                    </dd>
                </dl>

                <dl class="clear">
                    <dt><span class="red">*</span>交易密码</dt>
                    <dd class="input-cont password">
                        <input type="password" class="input" placeholder="输入密码">
                    </dd>
                </dl>
                <dl class="clear">
                    <dt><span class="red">*</span>确认交易密码</dt>
                    <dd class="input-cont password">
                        <input type="password" class="input" placeholder="再次输入密码">
                    </dd>
                </dl>
                <div class="next">
                    <div class="rule"><label > <input type="checkbox" checked="checked"> 我已阅读并同意</label><a href="#" class="blue">《XXXX网站服务协议》</a></div>
                    <a href="javascript:;" class="btn1">下一步</a>
                </div>
            </form>
        </div>

        <!--step3-->
        <div class="stepbox step3">
            <div class="success"><i class="ico i-ok"></i> 恭喜你注册成功，登录点<a href="#" class="blue">这里</a></div>
        </div>
    </div>
</div>