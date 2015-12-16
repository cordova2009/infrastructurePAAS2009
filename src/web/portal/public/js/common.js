// JavaScript Document
if (!(window.console && console.log)) {
    (function() {
        var noop = function() {};
        var methods = ['assert', 'clear', 'count', 'debug', 'dir', 'dirxml', 'error', 'exception', 'group', 'groupCollapsed', 'groupEnd', 'info', 'log', 'markTimeline', 'profile', 'profileEnd', 'markTimeline', 'table', 'time', 'timeEnd', 'timeStamp', 'trace', 'warn'];
        var length = methods.length;
        var console = window.console = {};
        while (length--) {
            console[methods[length]] = noop;
        }
    }());
}
//判断浏览器是否支持 placeholder属性
function isPlaceholder(){
    var input = document.createElement('input');
    return 'placeholder' in input;
}

if (!isPlaceholder()) {//不支持placeholder 用jquery来完成
    $(document).ready(function() {
        //对password框的特殊处理1.创建一个text框 2获取焦点和失去焦点的时候切换
        var inputField    = $("input[type=text],input[type=password]");
        inputField.each(function(){
            var $this 	= $(this);
            var place	= $this.attr('placeholder');
            if(place != null){
                var className = $this.attr('class') || '';
                $this.after('<input class="'+className+'" type="text" value="'+place+'" style="color:#ccc"/>');
                if($this.val() == ''){
                    $this.hide().next().show();
                }else{
                    $this.next().hide();
                }

                $this.next().focus(function(){
                    $(this).hide().prev().show().focus()
                })

                $this.blur(function(){
                    if($this.val() == '') {
                        var o1 = $(this);
                        var o = $(this).hide().next().show().addClass(className);
                        setTimeout(function(){
                            var className = o1.attr('class');
                            o.addClass(className)
                        },200);
                    }
                });
            }
        });
    });
}

function sprintf()
{
    var arg = arguments,
        str = arg[0] || '',
        i, n;
    if(arg[1] != null && typeof(arg[1]) == 'object'){

        $.each(arg[1],function(i,v){
            str = str.replace(/%s/, v);
        });

        delete arg[1];
    }
    for (i = 1, n = arg.length; i < n; i++) {
        str = str.replace(/%s/, arg[i]);
    }
    return str;
}
/**
 * 判断是不是正确的手机号码
 * @param mobile
 * @returns {boolean}
 */
function is_mobile(mobile){

    return !/^(1[0-9])\d{9}$/i.test(mobile);
}

var wait = 30;
function time(o) {
    if (wait == 0) {
        o.prop("disabled",false).removeClass('disabled');
        var tag_name = o.get(0).tagName.toUpperCase();
        if(tag_name == 'INPUT'){
            o.val('获取验证码');
        }else if(tag_name == 'BUTTON'){
            o.text('获取验证码');
        }
        wait = 30;
    } else {
        var tag_name = o.get(0).tagName.toUpperCase();
        if(tag_name == 'INPUT'){
            o.val("重新获取"+wait)
        }else if(tag_name == 'BUTTON'){
            o.text("重新获取"+wait)
        }

        wait--;
        setTimeout(function() {time(o)},1000)
    }
}
/**
 * 以字符串形式执行方法
 * @param func
 * @param args
 * @param defaultValue
 * @returns {*}
 */
var calculateFunctionValue = function (func, args, defaultValue) {
    if (typeof func === 'string') {
        // support obj.func1.func2
        var fs = func.split('.');

        if (fs.length > 1) {
            func = window;
            $.each(fs, function (i, f) {
                func = func[f];
            });
        } else {
            func = window[func];
        }
    }
    if (typeof func === 'function') {
        return func.apply(null, args);
    }
    return defaultValue;
};
String.prototype.len=function(){return this.replace(/[^\x00-\xff]/g,"__").length;}

function toThousands() {
    this.value = (this.value || 0).toString().replace(/(\d)(?=(?:\d{3})+$)/g, '$1,');
}

$(function() {

    $("input.mobile,input.only-num").keyup(function(){
        var $this = $(this);
        $this.val($this.val().replace(/\D/g,''));
    });

    $(".price_format").each(function () {
        toThousands.call(this);
    });

    $(document).on('blur','.price_format',toThousands);

    $(document).on("click",".checkBtn2 a",function(){
        $(this).siblings('a').removeClass('active')
        $(this).addClass('active').children('input').prop('checked',true);
    });

    //
    $(document).on('submit','.ajax-form',function(){
        //$this.prop("disabled", true);
        //$this.addClass('disabled');
        var $this = $(this);
        var flag = calculateFunctionValue($this.attr('before'),[$this],'');
        if(typeof flag == 'boolean' && !flag){
            return false;
        }

        var loading = layer.load();
        $.post(this.action,$(this).serializeArray(),function(resp){
            if(resp.status == '0'){

                if(resp.url != '' && resp.msg == ''){
                    //返回url不为空并且消息为空
                    window.location = resp.url;
                }else if(resp.msg != '' && resp.url != null && resp.url != '' ){
                    //返回信息与url都不为空
                    layer.msg(resp.msg,{icon:1},function(){
                        window.location = resp.url;
                    });
                }else if(resp.msg != ''){
                    //返回消息为空
                    layer.msg(resp.msg,{icon:1},function(){
                        calculateFunctionValue($this.attr('success'),[$this,resp],'');
                    });
                }else if(resp.msg == '' && resp.url == ''){
                    //返回信息与url都为空
                    calculateFunctionValue($this.attr('success'),[$this,resp],'');
                }
            }
            else{
                layer.alert(resp.msg,{icon:2},function(index){
                    calculateFunctionValue($this.attr('fail'),[$this,resp],'');
                    layer.close(index);
                });
            }
        },'json').always(function () {
            layer.close(loading);
        });

        return false;
    });

    $(document).on("click",".checklist .i-check",function(){
        var $this = $(this);

        if($this.hasClass('radio') && $this.hasClass('on')){
            return false;
        }else if($this.hasClass('radio') && !$this.hasClass('on')){
            $(".i-check").removeClass('on');
            $this.addClass('on').next().prop('checked',true);
            return true;
        }

        if($this.hasClass('on')){
            $this.removeClass('on').nextAll('input').prop('checked',false);
        }else{
            $this.addClass('on').nextAll('input').prop('checked',true);
        }
    });

    $(document.body).on('click', '.datepicker', function(){
        $(this).datetimepicker({
            timepicker: false,
            lang: 'ch',
            format: 'Y-m-d',
            formatDate: 'Y-m-d'
        });
        $(this).datetimepicker('show')
    })


    //验证码
    $("#get-sms-code,.get-code").click(function() {
        var $this = $(this);

        var data = {};
        if(!$this.hasClass('no-mobile')){
            var mobile = $.trim($("#mobile").val());
            if(mobile == ''){
                layer.alert('请输入手机号码！',{icon:2});
                return false;
            }

            if(is_mobile(mobile)){
                layer.alert('手机号码不合法！',{icon:2});
                return false;
            }
            data = {mobile:mobile};
        }

        $this.prop("disabled", true);
        $this.addClass('disabled');
        $.post($this.attr('url') || '/public/sendSmsCode.html',data, function (resp) {
            if(resp.status == '0'){
                layer.msg(resp.msg,{icon:1});
                time($this);
            }else{
                layer.alert(resp.msg,{icon:2});
                $this.prop("disabled", false);
                $this.removeClass('disabled');
            }
        },'json');
    });

	$(".submenu").hover(function(){
		$(this).find("dl").show();
	},function(){
		$(this).find("dl").hide();
	})

	$(".sidemenu ul li>a").click(function() {
		if($(this).next(".submenu").hasClass('active')){
			$(this).next(".submenu").removeClass('active').slideUp();;
		}else{
			$(".sidemenu .submenu").removeClass('active').slideUp();
			$(this).next(".submenu").addClass('active').slideDown();
		}
		
	});

	$('[data-toggle="modal"]').click(function() {
		var target = $(this).attr("data-target");
		$(target).fadeIn();
	});

	$('[data-miss="modal"]').click(function() {
		$(this).parents(".modal").fadeOut();
	});

	$(".tab_box").slide({mainCell:".bd ",effect:"fade"})

})
