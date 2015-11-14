
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
	<tr><td colspan="2">会员管理</td></tr>
	<tr>
		<td><input  value="查询会员信息接口"  onclick='setbinding("/member/queryMemberInfo","{        \"app\":{            \"appId\":\"zjhtwallet\",            \"timeStamp\":\"TIMESTAMP\",             \"nonce\":\"NONCE\",            \"signature\":\"SIGNATURE\"        },    \"body\":{        \"token\":\"6789\" }    }")'  type="button" ></td>
		<td><input  value="查询可购买会员列表接口"  onclick='setbinding("/member/queryMemberProduct","{        \"app\":{            \"appId\":\"zjhtwallet\",            \"timeStamp\":\"TIMESTAMP\",             \"nonce\":\"NONCE\",            \"signature\":\"SIGNATURE\"        },                \"body\":        {        \"token\":\"6789\"  }    }")'  type="button" ></td>
		<td><input  value="购买投标方会员接口"  onclick='setbinding("/member/queryMemberProduct","{        \"app\":{            \"appId\":\"zjhtwallet\",            \"timeStamp\":\"TIMESTAMP\",             \"nonce\":\"NONCE\",            \"signature\":\"SIGNATURE\"        },                \"body\":        {        \"token\":\"6789\" ,\"productId\":\"1\",\"memberDuration\":3,\"payMethod\":\"CSA\",\"payAmount\":50000   }    }")'  type="button" ></td>
	    <td><input  value="购买招标方会员列表接口"  onclick='setbinding("/member/buyPrivilegeMember","{        \"app\":{            \"appId\":\"zjhtwallet\",            \"timeStamp\":\"TIMESTAMP\",             \"nonce\":\"NONCE\",            \"signature\":\"SIGNATURE\"        },                \"body\":        {        \"token\":\"6789\" ,\"productId\":\"1\",\"memberDuration\":3,\"payMethod\":\"CSA\",\"payAmount\":50000   }    }")'  type="button" ></td>
	</tr>
	<tr><td colspan="6">招标管理</td></tr>
	<tr>
		<td><input  value="我的招标评标概况接口"  onclick='setbinding("/tender/queryMyObjectTenderSurvey","{        \"app\":{            \"appId\":\"zjhtwallet\",            \"timeStamp\":\"TIMESTAMP\",             \"nonce\":\"NONCE\",            \"signature\":\"SIGNATURE\"        },    \"body\":{        \"token\":\"4356576\",        \"objectId\":\"32456\"    }    }")'  type="button" ></td>
		<td><input  value="查询未完成招标项目基础信息接口"  onclick='setbinding("/tender/queryObjectBaseInfo","{        \"app\":{            \"appId\":\"zjhtwallet\",            \"timeStamp\":\"TIMESTAMP\",             \"nonce\":\"NONCE\",            \"signature\":\"SIGNATURE\"        },                \"body\":        {        \"token\":\"12345\",        \"objectId\":\"BH2015082135656\"    }    }")'  type="button" ></td>
		<td><input  value="保存招标项目基础信息接口"  onclick='setbinding("/tender/saveObjectBaseInfo","    {        \"app\":{            \"appId\":\"zjhtwallet\",            \"timeStamp\":\"TIMESTAMP\",             \"nonce\":\"NONCE\",            \"signature\":\"SIGNATURE\"        },                \"body\":        {        \"token\":\"12345\",        \"objectId\":\"BH2015082135656\",        \"objectName\":\"土石购买招标\",            \"industryId\":5,            \"biddingNo\":\"23009751\",            \"objectScope\":\"招标项目范围\",            \"biddeeCompanyPrincipal\":\"张三\",            \"biddeeCompanyTelephone\":\"0755-56432117\",            \"currency\":\"采用币种\",            \"contractType\":\"承包方式\",            \"evaluationAmount\":\"300000\"    }    }")'  type="button" ></td>
		<td><input  value="查询未完成招标项目工程信息接口"  onclick='setbinding("/tender/queryObjectProjectInfo","    {        \"app\":{            \"appId\":\"zjhtwallet\",            \"timeStamp\":\"TIMESTAMP\",             \"nonce\":\"NONCE\",            \"signature\":\"SIGNATURE\"        },                \"body\":{        \"token\":\"12345\",        \"objectId\":\"BH2015082135656\"     }     }")'  type="button" ></td>
		<td><input  value="保存招标项目工程信息接口"  onclick='setbinding("/tender/saveObjectProjectInfo","    {        \"app\":{            \"appId\":\"zjhtwallet\",            \"timeStamp\":\"TIMESTAMP\",             \"nonce\":\"NONCE\",            \"signature\":\"SIGNATURE\"        },                \"body\":        {        \"token\":\"45678u5\",        \"objectId\":\"BH2015082135656\",        \"projectName\":\"金域华府3期工程开发\",            \"projectSite\":\"工程地点\",            \"projectScale\":\"工程规模及特征\",            \"projectExpectInvestment\":\"工程计划总投资\",            \"employer\":\"建设单位\",            \"employerPrincipal\":\"建设单位经办人\",            \"employerTelephone\":\"建设单位办公电话\" }     }")'  type="button" ></td>
		<td><input  value="查询未完成招标项目工程要求接口"  onclick='setbinding("/tender/queryProjectRequirementInfo","    {        \"app\":{            \"appId\":\"zjhtwallet\",            \"timeStamp\":\"TIMESTAMP\",             \"nonce\":\"NONCE\",            \"signature\":\"SIGNATURE\"        },                \"body\":{        \"token\":\"12345\",        \"objectId\":\"BH2015082135656\"     }     }")'  type="button" ></td>
	</tr>
	<tr>
		<td><input  value="保存招标项目工程施工证明接口"  onclick='setbinding("/tender/saveProjectRequirementInfo","    {        \"app\":{            \"appId\":\"zjhtwallet\",            \"timeStamp\":\"TIMESTAMP\",             \"nonce\":\"NONCE\",            \"signature\":\"SIGNATURE\"        },                \"body\":        {            \"token\":\"45678u5\",            \"objectId\":\"BH2015082135656\",            \"projectExpectStartDate\":\"2012年8月\",            \"projectExpectPeriod\":300        }    }")'  type="button" ></td>
		<td><input  value="查询未完成招标项目工程施工证明接口"  onclick='setbinding("/tender/queryObjectConstructionInfo","    {        \"app\":{            \"appId\":\"zjhtwallet\",            \"timeStamp\":\"TIMESTAMP\",             \"nonce\":\"NONCE\",            \"signature\":\"SIGNATURE\"        },                \"body\":        {            \"token\":\"45678u5\",            \"objectId\":\"BH2015082135656\",            \"projectExpectStartDate\":\"计划开工日期\",            \"projectExpectPeriod\":300        }    }")'  type="button" ></td>
	</tr>
	<tr><td colspan="6">资金管理</td></tr>
	<tr>
		<td><input type="button"  value="查询我的银行账号信息"  onclick='setbinding("/capitalManage/getMyBankInfo","{\"app\":{\"appId\":\"ADP\",\"timeStamp\":\"TIMESTAMP\",  \"nonce\":\"NONCE\", \"signature\":\"SIGNATURE\"  }, \"body\":{\"token\":\"USER_TOKEN\"}}")'></td>
		<td><input type="button"  value="查询我的资金账户概况"  onclick='setbinding("/capitalManage/queryMyCapitalSurvey","{\"app\":{\"appId\":\"ADP\",\"timeStamp\":\"TIMESTAMP\",  \"nonce\":\"NONCE\", \"signature\":\"SIGNATURE\"  }, \"body\":{\"token\":\"USER_TOKEN\"}}")'></td>
		<td><input type="button"  value="查询我的资金账户流水"  onclick='setbinding("/capitalManage/queryTransactionRecords","{\"app\":{\"appId\":\"ADP\",\"timeStamp\":\"TIMESTAMP\",  \"nonce\":\"NONCE\", \"signature\":\"SIGNATURE\"  }, \"body\":{\"token\":\"USER_TOKEN\",\"pageInde\":0,\"pageSize\":1}}")'></td>
		<td><input type="button"  value="冻结撮合担保金"  onclick='setbinding("/capitalManage/freezeBond","{\"app\":{\"appId\":\"ADP\",\"timeStamp\":\"TIMESTAMP\",  \"nonce\":\"NONCE\", \"signature\":\"SIGNATURE\"  }, \"body\":{\"token\":\"USER_TOKEN\",\"objectId":"BH20150201321123\",\"remark":"冻结50000元施工保证金\",\"tradePassword\":\"TRADE_PASSWORD\"}}")'></td>
		<td><input type="button"  value="解冻施工保证金"  onclick='setbinding("/capitalManage/unfreezeBond","{\"app\":{\"appId\":\"ADP\",\"timeStamp\":\"TIMESTAMP\",  \"nonce\":\"NONCE\", \"signature\":\"SIGNATURE\"  }, \"body\":{\"token\":\"USER_TOKEN\",\"orderId\":\"FREEZEBOND_ORDER_ID\"}}")'></td>
		<td><input type="button"  value="充值申请"  onclick='setbinding("/capitalManage/rechargeApply","{\"app\":{\"appId\":\"ADP\",\"timeStamp\":\"TIMESTAMP\",  \"nonce\":\"NONCE\", \"signature\":\"SIGNATURE\"  }, \"body\":{\"token\":\"USER_TOKEN\",\"transferTime\":\"2015-10-12\",\"bankName\":\"中国银行\",\"voucherNo\":\"20150101215522\",\"amount\":100000,\"voucherFileUrl\":\"VOCHER_FILE_URL\"}}")'></td>
	</tr>
	<tr>
		<td><input type="button"  value="查询充值申请记录"  onclick='setbinding("/capitalManage/queryRechargeApplyList","{\"app\":{\"appId\":\"ADP\",\"timeStamp\":\"TIMESTAMP\",  \"nonce\":\"NONCE\", \"signature\":\"SIGNATURE\"  }, \"body\":{\"token\":\"USER_TOKEN\"}}")'></td>
		<td><input type="button"  value="提现申请"  onclick='setbinding("/capitalManage/withdrawalsApply","{\"app\":{\"appId\":\"ADP\",\"timeStamp\":\"TIMESTAMP\",  \"nonce\":\"NONCE\", \"signature\":\"SIGNATURE\"  }, \"body\":{\"token\":\"USER_TOKEN\",\"amount\":100000,\"bankId\":23,\"tradePassword\":\"TRADE_PASSWORD\"}}")'></td>
		<td><input type="button"  value="查询申请提现记录"  onclick='setbinding("/capitalManage/withdrawalsApply","{\"app\":{\"appId\":\"ADP\",\"timeStamp\":\"TIMESTAMP\",  \"nonce\":\"NONCE\", \"signature\":\"SIGNATURE\"  }, \"body\":{\"token\":\"USER_TOKEN\"}}")'></td>
	</tr>
	<tr>用户管理</tr>
	<tr>
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

