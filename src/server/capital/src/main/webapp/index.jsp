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
	<tr><td colspan="6">资金管理</td></tr>
	<tr>
		<td><input type="button"  value="查询我的资金账户概况"  onclick='setbinding("/capitalManage/queryMyCapitalSurvey","{\"app\":{\"appId\":\"paas\",\"timeStamp\":\"TIMESTAMP\",  \"nonce\":\"NONCE\", \"signature\":\"21aa0011472249b4292e81504f3917bd\"  }, \"body\":{\"token\":\"96c5f0e5e3c52fa0fc632aaa30d4fb85\"}}")'></td>
		<td><input type="button"  value="查询我的资金账户流水"  onclick='setbinding("/capitalManage/queryTransactionRecords","{\"app\":{\"appId\":\"paas\",\"timeStamp\":\"TIMESTAMP\",  \"nonce\":\"NONCE\", \"signature\":\"21aa0011472249b4292e81504f3917bd\"  }, \"body\":{\"token\":\"96c5f0e5e3c52fa0fc632aaa30d4fb85\",\"pageIndex\":0,\"pageSize\":10}}")'></td>
		<td><input type="button"  value="查询用户帐户详情"  onclick='setbinding("/capitalManage/queryProjectAccount","{\"app\":{\"appId\":\"paas\",\"timeStamp\":\"TIMESTAMP\",  \"nonce\":\"NONCE\", \"signature\":\"21aa0011472249b4292e81504f3917bd\"  }, \"body\":{\"token\":\"96c5f0e5e3c52fa0fc632aaa30d4fb85\"}}")'></td>
		<td><input type="button"  value="冻结撮合担保金"  onclick='setbinding("/capitalManage/freezeBond","{\"app\":{\"appId\":\"paas\",\"timeStamp\":\"TIMESTAMP\",  \"nonce\":\"NONCE\", \"signature\":\"21aa0011472249b4292e81504f3917bd\"  }, \"body\":{\"token\":\"96c5f0e5e3c52fa0fc632aaa30d4fb85\",\"objectId\":\"BH20150201321123\",\"amount\":5000000,\"originalOrderId\":\"BZ00201524562456u7\",\"originalTable\":\"t_ztgl_object_makematch_bond_record\",\"remark\":\"冻结50000元施工保证金\",\"tradePassword\":\"TRADE_PASSWORD\"}}")'></td>
		<td><input type="button"  value="支付撮合手续费接口"  onclick='setbinding("/capitalManage/payMatchHandingCharge","{\"app\":{\"appId\":\"paas\",\"timeStamp\":\"TIMESTAMP\",  \"nonce\":\"NONCE\", \"signature\":\"21aa0011472249b4292e81504f3917bd\"  }, \"body\":{\"token\":\"USER_TOKEN\",\"orderId\":\"ORDER_ID\",\"appOrderId\":\"APP_ORDER_ID\",\"lose\":[{\"orderId\":\"ORDER_ID\",\"appOrderId\":\"APP_ORDER_ID\"}]}}")'></td>
		<td><input type="button"  value="充值申请"  onclick='setbinding("/capitalManage/rechargeApply","{\"app\":{\"appId\":\"paas\",\"timeStamp\":\"TIMESTAMP\",  \"nonce\":\"NONCE\", \"signature\":\"21aa0011472249b4292e81504f3917bd\"  }, \"body\":{\"token\":\"96c5f0e5e3c52fa0fc632aaa30d4fb85\",\"transferTime\":\"2015-10-12\",\"bankName\":\"中国银行\",\"voucherNo\":\"20150101215522\",\"amount\":100000,\"voucherFileUrl\":\"VOCHER_FILE_URL\"}}")'></td>
	</tr>
	<tr>
		<td><input type="button"  value="充值申请审核"  onclick='setbinding("/capitalManage/checkRechargeApply","{\"app\":{\"appId\":\"paas\",\"timeStamp\":\"TIMESTAMP\",  \"nonce\":\"NONCE\", \"signature\":\"21aa0011472249b4292e81504f3917bd\"},\"body\":{\"orderId\":\"ORDER_ID\",\"checkWithdrawalsNo\":\"CHECK_WITHDRAWALS_NO\",\"checkResult\":\"OK#\",\"remark\":\"完成充值申请审核，充值10000元\",\"operator\":1}}")'></td>
		<td><input type="button"  value="充值成功"  onclick='setbinding("/capitalManage/successRecharge","{\"app\":{\"appId\":\"paas\",\"timeStamp\":\"TIMESTAMP\",  \"nonce\":\"NONCE\", \"signature\":\"21aa0011472249b4292e81504f3917bd\"}, \"body\":{\"orderId\":\"ORDER_ID\",\"appOrderId\":\"审核id\",\"remark\":\"完成充值申请审核，转账10000元\"}}")'></td>
		<td><input type="button"  value="提现申请"  onclick='setbinding("/capitalManage/withdrawalsApply","{\"app\":{\"appId\":\"paas\",\"timeStamp\":\"TIMESTAMP\",  \"nonce\":\"NONCE\", \"signature\":\"21aa0011472249b4292e81504f3917bd\"}, \"body\":{\"token\":\"96c5f0e5e3c52fa0fc632aaa30d4fb85\",\"amount\":100000,\"bankId\":23,\"tradePassword\":\"br99T8ulqDxiZ09g77KnmEd3sgNcwIZPWR87EKrFvcf+uVm31GQvyw==\"}}")'></td>
		<td><input type="button"  value="提现申请审核"  onclick='setbinding("/capitalManage/checkWithdrawalsApply","{\"app\":{\"appId\":\"paas\",\"timeStamp\":\"TIMESTAMP\",  \"nonce\":\"NONCE\", \"signature\":\"21aa0011472249b4292e81504f3917bd\"}, \"body\":{\"orderId\":\"TX002015112217342500000799351694\",\"transferTime\":\"2015-10-21\",\"voucherNo\":\"20142312\",\"voucherFileUrl\":\"URL\",\"checkResult\":\"OK#\",\"remark\":\"提现成功\",\"operator\":1}}")'></td>
		<td><input type="button"  value="查询申请提现记录"  onclick='setbinding("/capitalManage/queryWithdrawalsApplyList","{\"app\":{\"appId\":\"paas\",\"timeStamp\":\"TIMESTAMP\",  \"nonce\":\"NONCE\", \"signature\":\"21aa0011472249b4292e81504f3917bd\"}, \"body\":{\"token\":\"96c5f0e5e3c52fa0fc632aaa30d4fb85\"}}")'></td>
		<td><input type="button"  value="查询充值申请记录"  onclick='setbinding("/capitalManage/queryRechargeApplyList","{\"app\":{\"appId\":\"paas\",\"timeStamp\":\"TIMESTAMP\",  \"nonce\":\"NONCE\", \"signature\":\"21aa0011472249b4292e81504f3917bd\"}, \"body\":{\"token\":\"96c5f0e5e3c52fa0fc632aaa30d4fb85\"}}")'></td>
	</tr>
	<tr>	
		<td><input type="button"  value="冻结提现"  onclick='setbinding("/capitalManage/freezeWithdrawals","{\"app\":{\"appId\":\"paas\",\"timeStamp\":\"TIMESTAMP\",  \"nonce\":\"NONCE\", \"signature\":\"21aa0011472249b4292e81504f3917bd\"},\"body\":{\"orderId\":\"ORDER_ID\",\"mobileNum\":\"13714770857\",\"tradePassword\":\"TRADE_PASSWORD\",\"peerAccountUnit\":\"中国银行\",\"peerAccountId\":\"20150101215522\",\"amount\":100000,\"remark\":\"完成提现申请审核，转账10000元\"}}")'></td>
		<td><input type="button"  value="提现成功"  onclick='setbinding("/capitalManage/successWithdrawals","{\"app\":{\"appId\":\"paas\",\"timeStamp\":\"TIMESTAMP\",  \"nonce\":\"NONCE\", \"signature\":\"21aa0011472249b4292e81504f3917bd\"},\"body\":{\"orderId\":\"ORDER_ID\",\"appOrderId\":\"审核id\",\"remark\":\"完成提现申请审核，转账10000元\"}}")'></td>
		<td><input type="button"  value="提现失败"  onclick='setbinding("/capitalManage/failWithdrawals","{\"app\":{\"appId\":\"paas\",\"timeStamp\":\"TIMESTAMP\",  \"nonce\":\"NONCE\", \"signature\":\"21aa0011472249b4292e81504f3917bd\"},\"body\":{\"orderId\":\"ORDER_ID\",\"appOrderId\":\"审核id\",\"remark\":\"完成提现申请审核，转账10000元\"}}")'></td>
		<td><input type="button"  value="获取平台方银行账户"  onclick='setbinding("/capitalManage/getPlatformBankcard","{\"app\":{\"appId\":\"paas\",\"timeStamp\":\"TIMESTAMP\",  \"nonce\":\"NONCE\", \"signature\":\"21aa0011472249b4292e81504f3917bd\"},\"body\":{\"token\":\"96c5f0e5e3c52fa0fc632aaa30d4fb85\"}}")'></td>
		<td><input type="button"  value="内部 用户收入"  onclick='setbinding("/capitalManage/UserAccountIncome","{\"app\":{\"appId\":\"paas\",\"timeStamp\":\"TIMESTAMP\",  \"nonce\":\"NONCE\", \"signature\":\"21aa0011472249b4292e81504f3917bd\"},\"body\":{\"amount\":1000,\"userId\":\"1\",\"appOrderId\":\"tr64734\"}}")'></td>
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

