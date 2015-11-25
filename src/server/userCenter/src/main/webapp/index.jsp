<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<script src="<%=path%>/js/jquery-1.11.1.js"></script>
	<style type="text/css">
	.menu li{
		display: inline-block;
	}
	</style>
  </head>
  <body>
  	<div>
	<ul>
	<li><label>服务器</label>
	<select name="host" id="host">
	<option value="http://<%=request.getServerName()%>:<%=request.getServerPort()%><%=request.getContextPath() %>" selected>当前服务器地址</option>
	</select><input type='txt' id='realhost' >
	<li><label>接口名</label>
	<textarea id='api' cols="60"></textarea>

	</li>
	<li><label>参数</label><textarea id="param" cols="100" rows="15"></textarea></li>
	<li><label>cookie</label><textarea id="cookie" cols="100" rows="2"></textarea></li>
	<li><input type="button" value="提交" id="bt"></li>
	<li><label>响应</label><div id="resp"></div></li>
	</ul>
	</div>
	<table>
	<tr><td colspan="6">用户管理</td></tr>
	<tr>
		<td><input type="button"  value="注册"  onclick='setbinding("/userCenter/register","{\"app\":{\"appId\":\"paas\",\"timeStamp\":\"TIMESTAMP\",  \"nonce\":\"NONCE\", \"signature\":\"21aa0011472249b4292e81504f3917bd\"  },  \"body\":{\"smsCode\":\"9009\",\"nickname\":\"doudou\",\"mobileNum\":\"13714770857\",\"realName\":\"刘豆\",\"cardID\":\"420923199210180488\",\"loginPassword\":\"zYlLxP58G81a8kP8eDZyJi2LvnDxT2ewjox90v4hscP+uVm31GQvyw==\",\"tradePassword\":\"zYlLxP58G81a8kP8eDZyJi2LvnDxT2ewjox90v4hscP+uVm31GQvyw==\"}}")'></td>
		<td><input type="button"  value="用户登录"  onclick='setbinding("/userCenter/login","{\"app\":{\"appId\":\"paas\",\"timeStamp\":\"TIMESTAMP\",  \"nonce\":\"NONCE\", \"signature\":\"21aa0011472249b4292e81504f3917bd\"  },\"body\":{\"mobileNum\":\"13714770857\",\"loginPassword\":\"zYlLxP58G81a8kP8eDZyJi2LvnDxT2ewjox90v4hscP+uVm31GQvyw==\"}}")'></td>
		<td><input type="button"  value="查看帐户基础信息"  onclick='setbinding("/userCenter/getUserBaseInfo","{\"app\":{\"appId\":\"paas\",\"timeStamp\":\"TIMESTAMP\",  \"nonce\":\"NONCE\", \"signature\":\"21aa0011472249b4292e81504f3917bd\"  },\"body\":{\"token\":\"96c5f0e5e3c52fa0fc632aaa30d4fb85\"}}")'></td>
		<td><input type="button"  value="查询用户状态"  onclick='setbinding("/userCenter/getUserStatus","{\"app\":{\"appId\":\"paas\",\"timeStamp\":\"TIMESTAMP\",  \"nonce\":\"NONCE\", \"signature\":\"21aa0011472249b4292e81504f3917bd\"  },\"body\":{\"mobileNum\":\"13655641234\"}}")'></td>
		<td><input type="button"  value="修改用户头像"  onclick='setbinding("/userCenter/updateHeadImage","{\"app\":{\"appId\":\"paas\",\"timeStamp\":\"TIMESTAMP\",  \"nonce\":\"NONCE\", \"signature\":\"21aa0011472249b4292e81504f3917bd\"  },\"body\":{\"token\":\"96c5f0e5e3c52fa0fc632aaa30d4fb85\",\"headImageUrl\":\"HEAD_IMAGE_URL\"}}")'></td>
		<td><input type="button"  value="修改帐户基础信息"  onclick='setbinding("/userCenter/updateUserInfo","{\"app\":{\"appId\":\"paas\",\"timeStamp\":\"TIMESTAMP\",  \"nonce\":\"NONCE\", \"signature\":\"21aa0011472249b4292e81504f3917bd\"  },\"body\":{\"token\":\"96c5f0e5e3c52fa0fc632aaa30d4fb85\",\"nickname\":\"zhangsan\",\"address\":\"\",\"email\":\"\"}}")'></td>		
	</tr>
	<tr>
		<td><input type="button"  value="查询用户开户行信息"  onclick='setbinding("/userCenter/getBankInfoList","{\"app\":{\"appId\":\"paas\",\"timeStamp\":\"TIMESTAMP\",  \"nonce\":\"NONCE\", \"signature\":\"21aa0011472249b4292e81504f3917bd\"  },\"body\":{\"token\":\"96c5f0e5e3c52fa0fc632aaa30d4fb85\"}}")'></td>
		<td><input type="button"  value="获取短信验证码"  onclick='setbinding("/userSecurity/getSmsCode","{\"app\":{\"appId\":\"paas\",\"timeStamp\":\"TIMESTAMP\",  \"nonce\":\"NONCE\", \"signature\":\"21aa0011472249b4292e81504f3917bd\"  },\"body\":{\"mobileNum\":\"13714770857\"}}")'></td>
		<td><input type="button"  value="校验验证码"  onclick='setbinding("/userSecurity/verifySmsCodeOnly","{\"app\":{\"appId\":\"paas\",\"timeStamp\":\"TIMESTAMP\",  \"nonce\":\"NONCE\", \"signature\":\"21aa0011472249b4292e81504f3917bd\"  },\"body\":{\"mobileNum\":\"13655641234\",\"smsCode\":\"123456\"}}")'></td>
		<td><input type="button"  value="实名校验"  onclick='setbinding("/userSecurity/isRealName","{\"app\":{\"appId\":\"paas\",\"timeStamp\":\"TIMESTAMP\",  \"nonce\":\"NONCE\", \"signature\":\"21aa0011472249b4292e81504f3917bd\"  },\"body\":{\"realName\":\"王亚锋\",\"cardID\":\"610522222222222838\"}}")'></td>
		<td><input type="button"  value="查询用户安全信息"  onclick='setbinding("/userSecurity/getUserSecurityInfo","{\"app\":{\"appId\":\"paas\",\"timeStamp\":\"TIMESTAMP\",  \"nonce\":\"NONCE\", \"signature\":\"21aa0011472249b4292e81504f3917bd\"  },\"body\":{\"token\":\"96c5f0e5e3c52fa0fc632aaa30d4fb85\"}}")'></td>
		<td><input type="button"  value="重置登录密码"  onclick='setbinding("/userSecurity/forgetPassword","{\"app\":{\"appId\":\"paas\",\"timeStamp\":\"TIMESTAMP\",  \"nonce\":\"NONCE\", \"signature\":\"21aa0011472249b4292e81504f3917bd\"  },\"body\":{\"smsCode\":\"324545\",\"mobileNum\":\"13714770857\",\"loginPassword\":\"LOGIN_PASSWORD\"}}")'></td>		
	</tr>
	<tr>
		<td><input type="button"  value="修改登录密码"  onclick='setbinding("/userSecurity/updateLoginPassword","{\"app\":{\"appId\":\"paas\",\"timeStamp\":\"TIMESTAMP\",  \"nonce\":\"NONCE\", \"signature\":\"21aa0011472249b4292e81504f3917bd\"  },\"body\":{\"token\":\"96c5f0e5e3c52fa0fc632aaa30d4fb85\",\"smsCode\":\"324545\",\"oldLoginPassword\":\"OLD_LOGIN_PASSWORD\",\"newLoginPassword\":\"NEW_LOGIN_PASSWORD\"}}")'></td>
		<td><input type="button"  value="修改交易密码"  onclick='setbinding("/userSecurity/updateTradePassword","{\"app\":{\"appId\":\"paas\",\"timeStamp\":\"TIMESTAMP\",  \"nonce\":\"NONCE\", \"signature\":\"21aa0011472249b4292e81504f3917bd\"  },\"body\":{\"token\":\"96c5f0e5e3c52fa0fc632aaa30d4fb85\",\"smsCode\":\"324545\",\"oldTradePassword\":\"OLD_TRADE_PASSWORD\",\"newTradePassword\":\"NEW_TRADE_PASSWORD\"}}")'></td>
		<td><input type="button"  value="修改绑定手机号码"  onclick='setbinding("/userSecurity/updateMobileNum","{\"app\":{\"appId\":\"paas\",\"timeStamp\":\"TIMESTAMP\",  \"nonce\":\"NONCE\", \"signature\":\"21aa0011472249b4292e81504f3917bd\"  },\"body\":{\"token\":\"96c5f0e5e3c52fa0fc632aaa30d4fb85\",\"firstSmsCode\":\"324545\",\"secondSmsCode\":\"435674\",\"loginPassword\":\"LOGIN_PASSWORD\",\"oldMobileNum\":\"13512345678\",\"newMobileNum\":\"13687654321\"}}")'></td>		
	</tr>
	
</table>
  </body>
    <script>
    var type='payload'
    
		$("#bt").click(function (){
			$("#resp").html("");
			var hostval = $("#realhost").val()
			if(hostval==''){
				hostval=$("#host").val()
			}
			var url =hostval+$("#api").val();
			var data = $("#param").val();
			if(type=='payload')
			{
				var vcookie = $('#cookie').val();
				if(vcookie!=''){
					try{
						vcookie = eval('('+vcookie+')');
						for(item in vcookie){
							$.cookie(item, vcookie[item]);
						}
					}
					catch(e){console.print(e)}
					
				}
				
				$.ajax({type:'POST',contentType:'application/json',url:url,data:data,
				success:function(resp){ $("#resp").text(resp);},dataType:"html"}
				);
			}
			else if(type=='cookie'){
				data = eval('('+data+')');
				for(item in data){
					$.cookie(item, data[item]);
				}
				$.ajax({type:'POST',contentType:'application/json',url:url,
					success:function(resp){ $("#resp").text(resp);},dataType:"html"}
					);
			}
			else if(type=='formdata'){
				data = eval('('+data+')');
				$.ajax({type:'POST',url:url,data:data,
					success:function(resp){ $("#resp").text(resp);},dataType:"html"}
				);
			}
			else if(type=='string'){
				//以string 的形式提交，参数名为param
				$.ajax({type:'POST',url:url,data:{param:data},
					success:function(resp){ $("#resp").text(resp);},dataType:"html"}
					);
			}
			else if(type=='xml'){
				$.ajax({type:'POST',contentType:'application/xml',url:url,data:data,
					success:function(resp){ 
						var str = serializeXml(resp)
						$("#resp").text(str);
					},dataType:"xml"});
			}
			
		});
		
    function setbinding4string(api,json){
    	setbinding(api,json,null,'string');
    }
    
		function setbinding(api,json,cookiejson,submittype){
			$("#api").val(api)
			$("#param").val(json.replace("\$\{systime\}",new Date().getTime()))
			$("#cookie").val(cookiejson)
			if(!submittype){
				submittype= 'payload';
			}
			type=submittype;
		}
		
		jQuery.cookie = function(name, value, options) {
			if (typeof value != 'undefined') {
			   options = options || {};
			   if (value === null) {
			    value = '';
			    options = $.extend({}, options);
			    options.expires = -1;
			   }
			   var expires = '';
			   if (options.expires && (typeof options.expires == 'number' || options.expires.toUTCString)) {
			    var date;
			    if (typeof options.expires == 'number') {
			     date = new Date();
			     date.setTime(date.getTime() + (options.expires * 24 * 60 * 60 * 1000));
			    } else {
			     date = options.expires;
			    }
			    expires = '; expires=' + date.toUTCString();
			   }
			   var path = options.path ? '; path=' + (options.path) : '';
			   var domain = options.domain ? '; domain=' + (options.domain) : '';
			   var secure = options.secure ? '; secure' : '';
			   document.cookie = [name, '=', encodeURIComponent(value), expires, path, domain, secure].join('');
			} else {
			   var cookieValue = null;
			   if (document.cookie && document.cookie != '') {
			    var cookies = document.cookie.split(';');
			    for (var i = 0; i < cookies.length; i++) {
			     var cookie = jQuery.trim(cookies[i]);
			     if (cookie.substring(0, name.length + 1) == (name + '=')) {
			      cookieValue = decodeURIComponent(cookie.substring(name.length + 1));
			      break;
			     }
			    }
			   }
			   return cookieValue;
			}
			};
			
			function setbinding_cookie(api,json){
				$("#api").val(api)
				$("#param").val(json)
				type = 'cookie';
				
			}
			
		    function setbinding4xml(api,json){
		    	setbinding(api,json,null,'xml');
		    }
		
	</script>
  
</html>

