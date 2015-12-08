<block name="header">
<header class="header ">
    <div class="head-cont ">
        <div class="cent  clear">
            <div class="logo blue left">大力99</div>
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

        <form id="reg-form" method="post" action="" class="reg-form ajax-form" before="before_reg" success="reg_success">
            <!--step1-->
            <div id="step1" class="stepbox step1 active">
                <div class="text-right color8">
                    已有账号？<a class="blue" href="<?=U('login')?>">立即登录</a>
                </div>
                <dl class="clear">
                    <dt><span class="red">*</span>昵称</dt>
                    <dd class="input-cont nickname">
                        <input name="nickname" type="text" class="input" placeholder="输入昵称" tip="昵称">
                    </dd>
                    <dd class="tip"></dd>
                </dl>
                <dl class="clear">
                    <dt><span class="red">*</span>手机号码</dt>
                    <dd class="input-cont tel">
                        <input id="mobile" name="mobile" type="text" class="input" placeholder="输入手机号码" tip="手机号码">
                    </dd>
                    <dd class="tip"></dd>
                </dl>
                <dl class="clear">
                    <dt><span class="red">*</span>验证码</dt>
                    <dd class="input-cont2">
                        <input id="sms_code" name="sms_code" type="text" class="input" placeholder="输入验证码" tip="验证码">
                    </dd>
                    <dd class="">
                        <input class="getBtn" id="get-sms-code" value="获取验证码" type="button">
                    </dd>
                    <dd class="tip"></dd>
                </dl>
                <dl class="clear">
                    <dt><span class="red">*</span>登录密码</dt>
                    <dd class="input-cont password">
                        <input id="password" name="password" type="password" class="input" placeholder="输入密码" tip="登录密码">
                    </dd>
                    <dd class="tip"></dd>
                </dl>
                <dl class="clear">
                    <dt><span class="red">*</span>确认登录密码</dt>
                    <dd class="input-cont password">
                        <input name="re_password" type="password" class="input" placeholder="再次输入密码" tip="确认密码">
                    </dd>
                    <dd class="tip"></dd>
                </dl>
                <div class="next">
                    <a href="javascript:;" class="btn1">下一步</a>
                </div>
            </div>
            <!--step2-->

            <div id="step2" class="stepbox step2">
                <dl class="clear">
                    <dt><span class="red">*</span>真实姓名</dt>
                    <dd class="input-cont nickname">
                        <input name="real_name" type="text" class="input" placeholder="输入真实姓名" tip="真实姓名">
                    </dd>
                    <dd class="tip">
                    </dd>
                </dl>
                <dl class="clear">
                    <dt><span class="red">*</span>身份证号码</dt>
                    <dd class="input-cont idcard">
                        <input name="id_num" type="text" class="input" placeholder="输入身份证号码" tip="身份证号码">
                    </dd>
                    <dd class="tip">
                    </dd>
                </dl>

                <dl class="clear">
                    <dt><span class="red">*</span>交易密码</dt>
                    <dd class="input-cont password">
                        <input id="trade_password" name="trade_password" type="password" class="input" placeholder="输入密码" tip="交易密码">
                    </dd>
                    <dd class="tip">
                    </dd>
                </dl>
                <dl class="clear">
                    <dt><span class="red">*</span>确认交易密码</dt>
                    <dd class="input-cont password">
                        <input name="re_trade_password" type="password" class="input" placeholder="再次输入密码" tip="确认密码">
                    </dd>
                    <dd class="tip">
                    </dd>
                </dl>
                <div class="next">
                    <div class="rule"><label > <input id="i_agree" type="checkbox" checked="checked"> 我已阅读并同意</label><a href="#" class="blue">《XXXX网站服务协议》</a></div>
                    <button type="submit" class="btn1">下一步</button>
                </div>
            </div>
            <!--step3-->
            <div class="stepbox step3">
                <div class="success"><i class="ico i-ok"></i> 恭喜你注册成功，登录点<a href="<?=U('login')?>" class="blue">这里</a></div>
            </div>
        </form>
    </div>
</div>
<block name="script">
<script type="text/javascript">
    $(function(){

        $("input").blur(input_check)

        $("#step1 .btn1").click(function(event) {

            var valid = true;
            $("#step1 input").each(function () {
                if(this.name != '' && !input_check.call(this)){
                    valid = false;
                }
            })

            //通过验证
            if(valid){
                var data = {mobile:$("#mobile").val(),sms_code:$("#sms_code").val()};

                var loading = layer.load();
                $.post('<?=U('/public/checkMobileSms')?>',data,function(resp){
                    if(resp.status == '0'){
                        $('.reg-step ul li').eq(1).addClass('active');
                        $(".stepbox").removeClass('active');
                        $(".stepbox").eq(1).addClass('active');
                    }else{
                        layer.alert(resp.msg);
                    }
                },'json').always(function () {
                    layer.close(loading);
                });

            }
        });
    })


    function show_errmsg(obj,msg){
        obj.addClass('error')
            .parent()
            .siblings('.tip').text(msg)
            .removeClass('tip-ok')
            .addClass('tip-error');
    }

    function input_check(){

        var $this = $(this);
        if($this.attr('name') == null){
            return false;
        }

        var valid = true;
        var val = $.trim($this.val());
        if(val == ''){
            show_errmsg($this,$this.attr('tip')+'不能为空！')
            valid = false;
        }

        switch($this.attr('name')){
            case 'mobile':
                if(is_mobile(val)){
                    show_errmsg($this,'请输入正确的手机号码！');
                    valid = false;
                }
                break;
            case 'password':
            case 'trade_password':
                if(val.length < 6 || val.length > 16){
                    show_errmsg($this,'密码长度必须在6-16位之间！');
                    valid = false;
                }
                break;
            case 're_password':
                if($("#password").val() != val){
                    show_errmsg($this,'两次密码输入不一致！');
                    valid = false;
                }
                break;
            case 're_trade_password':
                if($("#trade_password").val() != val){
                    show_errmsg($this,'两次密码输入不一致！');
                    valid = false;
                }
                break;
            case 'id_num':
                if(!IdentityCodeValid(val)){
                    show_errmsg($this,'身份证号不正确！');
                    valid = false;
                }
                break;
            case 'real_name':
                if(val.len() > 10){
                    show_errmsg($this,'真实姓名长度不能超过10个汉字！');
                    valid = false;
                }
                break;
        }

        if(valid){
            $this.removeClass('error')
                .parent()
                .siblings('.tip').text('')
                .removeClass('tip-error')
                .addClass('tip-ok');
        }
        return valid;
    }

    function before_reg(){
        var valid = true;
        $("#step2 input").each(function () {
            if(this.name != '' && !input_check.call(this)){
                valid = false;
            }
        })
        if(valid && !$("#i_agree").prop('checked')){
            layer.alert('请选择同意网站服务协议！');
            valid = false;
        }
        return valid;
    }

    function reg_success(){
        $('.reg-step ul li').eq(2).addClass('active');
        $(".stepbox").removeClass('active').eq(2).addClass('active');
    }

    /*
     根据〖中华人民共和国国家标准 GB 11643-1999〗中有关公民身份号码的规定，公民身份号码是特征组合码，由十七位数字本体码和一位数字校验码组成。排列顺序从左至右依次为：六位数字地址码，八位数字出生日期码，三位数字顺序码和一位数字校验码。
     地址码表示编码对象常住户口所在县(市、旗、区)的行政区划代码。
     出生日期码表示编码对象出生的年、月、日，其中年份用四位数字表示，年、月、日之间不用分隔符。
     顺序码表示同一地址码所标识的区域范围内，对同年、月、日出生的人员编定的顺序号。顺序码的奇数分给男性，偶数分给女性。
     校验码是根据前面十七位数字码，按照ISO 7064:1983.MOD 11-2校验码计算出来的检验码。

     出生日期计算方法。
     15位的身份证编码首先把出生年扩展为4位，简单的就是增加一个19或18,这样就包含了所有1800-1999年出生的人;
     2000年后出生的肯定都是18位的了没有这个烦恼，至于1800年前出生的,那啥那时应该还没身份证号这个东东，⊙﹏⊙b汗...
     下面是正则表达式:
     出生日期1800-2099  (18|19|20)?\d{2}(0[1-9]|1[012])(0[1-9]|[12]\d|3[01])
     身份证正则表达式 /^\d{6}(18|19|20)?\d{2}(0[1-9]|1[12])(0[1-9]|[12]\d|3[01])\d{3}(\d|X)$/i
     15位校验规则 6位地址编码+6位出生日期+3位顺序号
     18位校验规则 6位地址编码+8位出生日期+3位顺序号+1位校验位

     校验位规则     公式:∑(ai×Wi)(mod 11)……………………………………(1)
     公式(1)中：
     i----表示号码字符从由至左包括校验码在内的位置序号；
     ai----表示第i位置上的号码字符值；
     Wi----示第i位置上的加权因子，其数值依据公式Wi=2^(n-1）(mod 11)计算得出。
     i 18 17 16 15 14 13 12 11 10 9 8 7 6 5 4 3 2 1
     Wi 7 9 10 5 8 4 2 1 6 3 7 9 10 5 8 4 2 1

     */
    //身份证号合法性验证
    //支持15位和18位身份证号
    //支持地址编码、出生日期、校验位验证
    function IdentityCodeValid(code) {
        var city={11:"北京",12:"天津",13:"河北",14:"山西",15:"内蒙古",21:"辽宁",22:"吉林",23:"黑龙江 ",31:"上海",32:"江苏",33:"浙江",34:"安徽",35:"福建",36:"江西",37:"山东",41:"河南",42:"湖北 ",43:"湖南",44:"广东",45:"广西",46:"海南",50:"重庆",51:"四川",52:"贵州",53:"云南",54:"西藏 ",61:"陕西",62:"甘肃",63:"青海",64:"宁夏",65:"新疆",71:"台湾",81:"香港",82:"澳门",91:"国外 "};
        var tip = "";
        var pass= true;

        if(!code || !/^\d{6}(18|19|20)?\d{2}(0[1-9]|1[012])(0[1-9]|[012]\d|3[01])\d{3}(\d|X)$/i.test(code)){
            tip = "身份证号格式错误";
            pass = false;
        }
        else if(!city[code.substr(0,2)]){
            tip = "地址编码错误";
            pass = false;
        }
        else{
            //18位身份证需要验证最后一位校验位
            if(code.length == 18){
                code = code.split('');
                //∑(ai×Wi)(mod 11)
                //加权因子
                var factor = [ 7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2 ];
                //校验位
                var parity = [ 1, 0, 'X', 9, 8, 7, 6, 5, 4, 3, 2 ];
                var sum = 0;
                var ai = 0;
                var wi = 0;
                for (var i = 0; i < 17; i++)
                {
                    ai = code[i];
                    wi = factor[i];
                    sum += ai * wi;
                }
                if(parity[sum % 11] != code[17].toUpperCase()){
                    tip = "校验位错误";
                    pass =false;
                }
            }
        }
//        if(!pass) alert(tip);
//        console.info(tip);
        return pass;
    }

</script>
</block>