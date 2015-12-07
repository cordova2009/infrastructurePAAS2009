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
	<tr><td colspan="2">公司信息</td></tr>
	<tr>
	
		<td><input  value="查询公司信息接口"  onclick='setbinding("/tender/queryCompanyInfo","{    \"app\":{        \"appId\":\"zjhtwallet\",        \"timeStamp\":\"TIMESTAMP\",         \"nonce\":\"NONCE\",        \"signature\":\"SIGNATURE\"    }    \"body\":{        \"companyId\":23,        \"type\":\"BEE\"    }}   ")'  type="button" ></td>
	</tr>
	<tr><td colspan="2">会员管理</td></tr>
	<tr>
	
		<td><input  value="查询会员信息接口"  onclick='setbinding("/member/queryMemberInfo","{        \"app\":{            \"appId\":\"zjhtwallet\",            \"timeStamp\":\"TIMESTAMP\",             \"nonce\":\"NONCE\",            \"signature\":\"SIGNATURE\"        },    \"body\":{        \"token\":\"12345\" }    }")'  type="button" ></td>
		<td><input  value="查询可购买会员列表接口"  onclick='setbinding("/member/queryMemberProduct","{        \"app\":{            \"appId\":\"zjhtwallet\",            \"timeStamp\":\"TIMESTAMP\",             \"nonce\":\"NONCE\",            \"signature\":\"SIGNATURE\"        },                \"body\":        {        \"token\":\"12345\"  }    }")'  type="button" ></td>
		<td><input  value="购买投标方会员接口"  onclick='setbinding("/member/queryMemberProduct","{        \"app\":{            \"appId\":\"zjhtwallet\",            \"timeStamp\":\"TIMESTAMP\",             \"nonce\":\"NONCE\",            \"signature\":\"SIGNATURE\"        },                \"body\":        {        \"token\":\"12345\" ,\"productId\":\"1\",\"memberDuration\":3,\"payMethod\":\"CSA\",\"payAmount\":50000   }    }")'  type="button" ></td>
	    <td><input  value="购买招标方会员列表接口"  onclick='setbinding("/member/buyPrivilegeMember","{        \"app\":{            \"appId\":\"zjhtwallet\",            \"timeStamp\":\"TIMESTAMP\",             \"nonce\":\"NONCE\",            \"signature\":\"SIGNATURE\"        },                \"body\":        {        \"token\":\"12345\" ,\"productId\":\"1\",\"memberDuration\":3,\"payMethod\":\"CSA\",\"payAmount\":50000   }    }")'  type="button" ></td>
	</tr>
	<tr>
	<tr><td colspan="2">用户信息管理</td></tr>
	<tr>
		<td><input  value="提交举报接口"  onclick='setbinding("/report/submitReport"," {    \"app\":{        \"appId\":\"zjhtwallet\",        \"timeStamp\":\"TIMESTAMP\",         \"nonce\":\"NONCE\",        \"signature\":\"SIGNATURE\"    },    \"body\":{        \"token\":\"12345\",        \"reportType\":\"UTT\",        \"refType\":\"TER\",        \"refId\":\"1\",        \"reportContent\":\"这条信息涉嫌诈骗\"    }}  ")'  type="button" ></td>
		<td><input  value="提交投诉接口"  onclick='setbinding("/complain/submitComplain"," {  \"app\":{        \"appId\":\"zjhtwallet\",        \"timeStamp\":\"TIMESTAMP\",         \"nonce\":\"NONCE\",        \"signature\":\"SIGNATURE\"    },    \"body\":{        \"token\":\"12345\",        \"complainType\":\"PPP\",        \"refType\":\"PPP\",        \"refId\":\"1\",        \"complainContent\":\"付款很慢\"    }}  ")'  type="button" ></td>
		<td><input  value="提交用户信息接口"  onclick='setbinding("/userInformation/submitUserInformation"," {    \"app\":{        \"appId\":\"zjhtwallet\",        \"timeStamp\":\"TIMESTAMP\",         \"nonce\":\"NONCE\",        \"signature\":\"SIGNATURE\"    },    \"body\":{        \"token\":\"12345\",        \"objectAmount\":\"3000万\",        \"informationId\":1,        \"district\":\"广州市\",        \"objectName\":\"项目名称\",        \"employer\":\"甲方xxxxxx\",        \"phase\":\"招标阶段\",        \"projectPeriod\":\"半年\",        \"projectSituation\":\"本项目主要是xxxx\",        \"address\":\"xx路666号\"    }}  ")'  type="button" ></td>
		<td><input  value="查看我的发布信息详情接口"  onclick='setbinding("/userInformation/getUserInformationDetail"," {    \"app\":{        \"appId\":\"zjhtwallet\",        \"timeStamp\":\"TIMESTAMP\",         \"nonce\":\"NONCE\",        \"signature\":\"SIGNATURE\"    },    \"body\":{        \"token\":\"12345\",        \"informationId\":1    }} ")'  type="button" ></td>
		<td><input  value="查看发布信息详情接口"  onclick='setbinding("/userInformation/getUserInformationDetailWithComments"," {    \"app\":{        \"appId\":\"zjhtwallet\",        \"timeStamp\":\"TIMESTAMP\",         \"nonce\":\"NONCE\",        \"signature\":\"SIGNATURE\"    },    \"body\":{        \"token\":\"12345\",        \"informationId\":1    }}  ")'  type="button" ></td>
		</tr>
		<tr>
		<td><input  value="查询发布信息列表接口"  onclick='setbinding("/userInformation/queryUserInformationPage"," {    \"app\":{        \"appId\":\"zjhtwallet\",        \"timeStamp\":\"TIMESTAMP\",         \"nonce\":\"NONCE\",        \"signature\":\"SIGNATURE\"    },    \"body\":{        \"token\":\"12345\",        \"pageIndex\":1,        \"pageSize\":10,        \"status\":\"CRT\"    }}  ")'  type="button" ></td>
		<td><input  value="回复用户信息接口"  onclick='setbinding("/userInformation/replyUserInformation"," {    \"app\":{        \"appId\":\"zjhtwallet\",        \"timeStamp\":\"TIMESTAMP\",         \"nonce\":\"NONCE\",        \"signature\":\"SIGNATURE\"    },    \"body\":{        \"token\":\"12345\",        \"informationId\":1,        \"replyContent\":\"我可以试试\"    }}  ")'  type="button" ></td>		
		</tr>
	
	<tr>
		<td colspan="6"></td>
	<tr>
	<tr><td colspan="2">公告管理</td></tr>
	<tr>
		<td><input  value="查询最新站点公告（列表）接口"  onclick='setbinding("/siteNews/getSiteNewsList"," {    \"app\":{        \"appId\":\"zjhtwallet\",        \"timeStamp\":\"TIMESTAMP\",         \"nonce\":\"NONCE\",        \"signature\":\"SIGNATURE\"    },    \"body\":{        \"size\":1    }} ")'  type="button" ></td>
		<td><input  value="查询更多网站公告（列表）接口"  onclick='setbinding("/siteNews/getnoticeList"," {    \"app\":{        \"appId\":\"zjhtwallet\",        \"timeStamp\":\"TIMESTAMP\",         \"nonce\":\"NONCE\",        \"signature\":\"SIGNATURE\"    },    \"body\":{        \"pageIndex\":1,        \"pageSize\":2    }} ")'  type="button" ></td>
		</tr>
	
	<tr>
		<td colspan="6"></td>
		<tr><td colspan="2">消息管理</td></tr>
	<tr>
	<td><input  value="添加标签"  onclick='setbinding("/tag/insert"," {\"tagName\":\"很好\",\"tagCreateObject\":\"0\",\"tagGroupName\":\"biddee_manager\",\"tagObjectCode\":\"t_qyzz_biddee\",\"businessId\":\"1\"}  ")'  type="button" ></td>
		<td><input  value="查询标签"  onclick='setbinding("/tag/searchTag"," {\"tagGroupName\":\"biddee_manager\",\"tagObjectCode\":\"t_qyzz_biddee\",\"businessId\":\"1\"}  ")'  type="button" ></td>
		
		<td><input  value="查询我的消息（列表）接口"  onclick='setbinding("/myMsg/getMsgList"," {    \"app\":{        \"appId\":\"zjhtwallet\",        \"timeStamp\":\"TIMESTAMP\",         \"nonce\":\"NONCE\",        \"signature\":\"SIGNATURE\"    },    \"body\":{        \"token\":\"12345\",        \"pageIndex\":1,        \"pageSize\":2    }}  ")'  type="button" ></td>
		<td><input  value="查询我的消息详情接口"  onclick='setbinding("/myMsg/getMsgDetail"," {    \"app\":{        \"appId\":\"zjhtwallet\",        \"timeStamp\":\"TIMESTAMP\",         \"nonce\":\"NONCE\",        \"signature\":\"SIGNATURE\"    },    \"body\":{        \"token\":\"12345\",     \"msgId\":1   }}  ")'  type="button" ></td>
		<td><input  value="获取我的消息未读个数接口"  onclick='setbinding("/myMsg/getUnreadMsgNum"," {    \"app\":{        \"appId\":\"zjhtwallet\",        \"timeStamp\":\"TIMESTAMP\",         \"nonce\":\"NONCE\",        \"signature\":\"SIGNATURE\"    },    \"body\":{        \"token\":\"12345\"   }}  ")'  type="button" ></td>
		</tr>
	
	<tr>
		<td colspan="6"></td>
	</tr>
	<tr><td colspan="6">招标人管理</td></tr>
	<tr>
		<td><input  value="查询我的招标人认证信息接口"  onclick='setbinding("/myBiddee/authInfo/getAuthInfo","{        \"app\":{            \"appId\":\"zjhtwallet\",            \"timeStamp\":\"TIMESTAMP\",             \"nonce\":\"NONCE\",            \"signature\":\"SIGNATURE\"        },    \"body\":{        \"token\":\"12345\" }    }")'  type="button" ></td>
		<td><input  value="查询保存的招标人基本信息接口"  onclick='setbinding("/myBiddee/authInfo/getBaseInfo_apply","{        \"app\":{            \"appId\":\"zjhtwallet\",            \"timeStamp\":\"TIMESTAMP\",             \"nonce\":\"NONCE\",            \"signature\":\"SIGNATURE\"        },    \"body\":{        \"token\":\"12345\" }    }")'  type="button" ></td>
		<td><input  value="保存招标人基本信息接口"  onclick='setbinding("/myBiddee/authInfo/saveBaseInfo_apply","   { \"app\":{         \"appId\":\"zjhtwallet\",         \"timeStamp\":\"TIMESTAMP\",          \"nonce\":\"NONCE\",         \"signature\":\"SIGNATURE\"     },             \"body\":{         \"token\":\"12345\",         \"baseInfo\":{            \"companyName\":\"深圳蜂鸟娱乐技术有限公司\",             \"shortName\":\"蜂鸟娱乐\",             \"description\":\"公司简介\",             \"registeredCapital\":\"\",             \"telephone\":\"\",             \"email\":\"\",     \"logoUrl\":\"LOGO_IMAGE_URL\"         }     } } ")'  type="button" ></td>
		<td><input  value="查询保存的招标人法人信息接口"  onclick='setbinding("/myBiddee/authInfo/getLegalPersonInfo_apply","{        \"app\":{            \"appId\":\"zjhtwallet\",            \"timeStamp\":\"TIMESTAMP\",             \"nonce\":\"NONCE\",            \"signature\":\"SIGNATURE\"        },    \"body\":{        \"token\":\"12345\" }    }")'  type="button" ></td>
		<td><input  value="保存招标人法人信息接口"  onclick='setbinding("/myBiddee/authInfo/saveLegalPersonInfo_apply","  { \"app\":{        \"appId\":\"zjhtwallet\",        \"timeStamp\":\"TIMESTAMP\",         \"nonce\":\"NONCE\",        \"signature\":\"SIGNATURE\"    },            \"body\":{        \"token\":\"12345\",        \"legalPerson\":{             \"name\":\"张三\",            \"idCard\":\"420923199205049230121\",            \"idCardfrontUrl\":\"法人身份证正面地址\",            \"idCardBackUrl\":\"法人身份证反面地址\",            \"authorityBookUrl\":\"\"        }    }} ")'  type="button" ></td>
		<td><input  value="查询招标人认证申请详情"  onclick='setbinding("/myBiddee/authInfo/getApplication","{        \"app\":{            \"appId\":\"zjhtwallet\",            \"timeStamp\":\"TIMESTAMP\",             \"nonce\":\"NONCE\",            \"signature\":\"SIGNATURE\"        },    \"body\":{        \"token\":\"12345\" }    }")'  type="button" ></td>
		</tr>
	<tr>
		<td><input  value="查询保存的招标人公司注册信息接口"  onclick='setbinding("/myBiddee/authInfo/getRegisteredInfo_apply","{        \"app\":{            \"appId\":\"zjhtwallet\",            \"timeStamp\":\"TIMESTAMP\",             \"nonce\":\"NONCE\",            \"signature\":\"SIGNATURE\"        },    \"body\":{        \"token\":\"12345\" }    }")'  type="button" ></td>
		<td><input  value="保存招标人公司注册信息接口"  onclick='setbinding("/myBiddee/authInfo/saveRegisteredInfo_apply","   {    \"app\":{        \"appId\":\"zjhtwallet\",        \"timeStamp\":\"TIMESTAMP\",         \"nonce\":\"NONCE\",        \"signature\":\"SIGNATURE\"    },            \"body\":{        \"token\":\"12345\",        \"registeredInfo\":{             \"businessLicenseNum\":\"BUSINESS_LICENSE_NUM\",             \"businessLicenseUrl\":\"BUSINESS_LICENSE_URL\",             \"taxRegistrationNum\":\"TAX_REGISTRATION_NUM\",             \"taxRegistrationUrl\":\"TAX_REGISTRATION_URL\",             \"organizationCodeNum\":\"ORGANIZATION_CODE_NUM\",             \"organizationCodeUrl\":\"ORGANIZATION_CODE_URL\",             \"businessScope\":\"经营范围\",             \"regTime\":\"2014-04-05\",             \"businessLicenseExpireTime\":\"2016-04-05\",             \"address\":\"\",             \"businessLicenseType\":\"OLD\",             \"newBusinessLicenseNum\":\"\",             \"newBusinessLicenseUrl\":\"\"       }           }}   ")'  type="button" ></td>
		<td><input  value="查询保存的招标人开户行信息接口"  onclick='setbinding("/myBiddee/authInfo/getBankInfo_apply","{        \"app\":{            \"appId\":\"zjhtwallet\",            \"timeStamp\":\"TIMESTAMP\",             \"nonce\":\"NONCE\",            \"signature\":\"SIGNATURE\"        },    \"body\":{        \"token\":\"12345\" }    }")'  type="button" ></td>
		<td><input  value="保存招标人开户行信息接口"  onclick='setbinding("/myBiddee/authInfo/saveBankInfo","   {    \"app\":{        \"appId\":\"zjhtwallet\",        \"timeStamp\":\"TIMESTAMP\",         \"nonce\":\"NONCE\",        \"signature\":\"SIGNATURE\"    },            \"body\":    {        \"token\":\"USER_TOKEN\",           \"bankInfo\":{             \"bank\":\"招商银行深圳支行\",            \"accountId\":\"1234567812345678\",            \"accountName\":\"深圳麦圈互动技术有限公司\"        }    }}   ")'  type="button" ></td>
		<td><input  value="提交招标人认证申请接口"  onclick='setbinding("/myBiddee/authInfo/applay","{    \"app\":{        \"appId\":\"zjhtwallet\",        \"timeStamp\":\"TIMESTAMP\",         \"nonce\":\"NONCE\",        \"signature\":\"SIGNATURE\"    },            \"body\":{        \"token\":\"USER_TOKEN\"    }}  ")'  type="button" ></td>
		<td><input  value="招标人认证审核接口"  onclick='setbinding("/myBiddee/authInfo/checkApplication","   { \"app\":{        \"appId\":\"zjhtwallet\",        \"timeStamp\":\"TIMESTAMP\",         \"nonce\":\"NONCE\",        \"signature\":\"SIGNATURE\"    },            \"body\":{        \"baseInfoCheck\":{            \"biddee_id\":999,            \"company_name\":{\"result\":\"FLS\",\"msg\":\"公司名称与工商注册名称不一致\"},            \"short_name\":{\"result\":\"OK#\",\"msg\":\"\"},            \"description\":{\"result\":\"OK#\",\"msg\":\"\"},            \"registered_capital\":{\"result\":\"OK#\",\"msg\":\"\"},            \"contact_mobile_num\":{\"result\":\"OK#\",\"msg\":\"\"},            \"email\":{\"result\":\"OK#\",\"msg\":\"\"},            \"logo\":{\"result\":\"OK#\",\"msg\":\"\"}        },        \"legalPersonCheck\":{            \"legal_person\":{\"result\":\"OK#\",\"msg\":\"\"},            \"legal_person_idcard\":{\"result\":\"OK#\",\"msg\":\"\"},            \"legal_person_idcard_front_url\":{\"result\":\"OK#\",\"msg\":\"\"},            \"legal_person_idcard_back_url\":{\"result\":\"OK#\",\"msg\":\"\"},            \"legal_person_authority_book\":{\"result\":\"OK#\",\"msg\":\"\"}        },        \"registeredInfoCheck\":{             \"business_license_num\":{\"result\":\"OK#\",\"msg\":\"\"},             \"business_license_url\":{\"result\":\"OK#\",\"msg\":\"\"},             \"tax_registration_certificate\":{\"result\":\"OK#\",\"msg\":\"\"},             \"tax_registration_certificate_url\":{\"result\":\"OK#\",\"msg\":\"\"},             \"org_code_certificate\":{\"result\":\"OK#\",\"msg\":\"\"},             \"org_code_certificate_url\":{\"result\":\"OK#\",\"msg\":\"\"},             \"business_scope\":{\"result\":\"OK#\",\"msg\":\"\"},             \"reg_time\":{\"result\":\"OK#\",\"msg\":\"\"},             \"business_license_expire_time\":{\"result\":\"OK#\",\"msg\":\"\"},             \"address\":{\"result\":\"OK#\",\"msg\":\"\"},             \"unified_social_credit_code\":{\"result\":\"OK#\",\"msg\":\"\"},             \"unified_social_credit_code_url\":{\"result\":\"OK#\",\"msg\":\"\"}        },        \"bankInfoCheck\":{             \"bank\":{\"result\":\"OK#\",\"msg\":\"\"},            \"accountId\":{\"result\":\"OK#\",\"msg\":\"\"},            \"accountName\":{\"result\":\"OK#\",\"msg\":\"\"}        }    } }   ")'  type="button" ></td>
		<tr>
		<td colspan="6"></td>
	</tr>
		<tr><td colspan="6">投标人管理</td></tr>
	<tr>
		<td><input  value="查询我的投标人认证信息接口"  onclick='setbinding("/myBidder/authInfo/getAuthInfo","{        \"app\":{            \"appId\":\"zjhtwallet\",            \"timeStamp\":\"TIMESTAMP\",             \"nonce\":\"NONCE\",            \"signature\":\"SIGNATURE\"        },    \"body\":{        \"token\":\"12345\" }    }")'  type="button" ></td>
		<td><input  value="查询保存的投标人基本信息接口"  onclick='setbinding("/myBidder/authInfo/getBaseInfo_apply","{        \"app\":{            \"appId\":\"zjhtwallet\",            \"timeStamp\":\"TIMESTAMP\",             \"nonce\":\"NONCE\",            \"signature\":\"SIGNATURE\"        },    \"body\":{        \"token\":\"12345\" }    }")'  type="button" ></td>
		<td><input  value="保存投标人基本信息接口"  onclick='setbinding("/myBidder/authInfo/saveBaseInfo_apply","   { \"app\":{         \"appId\":\"zjhtwallet\",         \"timeStamp\":\"TIMESTAMP\",          \"nonce\":\"NONCE\",         \"signature\":\"SIGNATURE\"     },             \"body\":{         \"token\":\"12345\",         \"baseInfo\":{            \"companyName\":\"深圳蜂鸟娱乐技术有限公司\",             \"shortName\":\"蜂鸟娱乐\",             \"description\":\"公司简介\",             \"registeredCapital\":\"\",             \"telephone\":\"\",             \"email\":\"\",     \"logoUrl\":\"LOGO_IMAGE_URL\"         }     } } ")'  type="button" ></td>
		<td><input  value="查询保存的投标人法人信息接口"  onclick='setbinding("/myBidder/authInfo/getLegalPersonInfo_apply","{        \"app\":{            \"appId\":\"zjhtwallet\",            \"timeStamp\":\"TIMESTAMP\",             \"nonce\":\"NONCE\",            \"signature\":\"SIGNATURE\"        },    \"body\":{        \"token\":\"12345\" }    }")'  type="button" ></td>
		<td><input  value="保存投标人法人信息接口"  onclick='setbinding("/myBidder/authInfo/saveLegalPersonInfo_apply","  { \"app\":{        \"appId\":\"zjhtwallet\",        \"timeStamp\":\"TIMESTAMP\",         \"nonce\":\"NONCE\",        \"signature\":\"SIGNATURE\"    },            \"body\":{        \"token\":\"12345\",        \"legalPerson\":{             \"name\":\"张三\",            \"idCard\":\"420923199205049230121\",            \"idCardfrontUrl\":\"法人身份证正面地址\",            \"idCardBackUrl\":\"法人身份证反面地址\",            \"authorityBookUrl\":\"\"        }    }} ")'  type="button" ></td>
		<td><input  value="查询投标人认证申请详情"  onclick='setbinding("/myBidder/authInfo/getApplication","{        \"app\":{            \"appId\":\"zjhtwallet\",            \"timeStamp\":\"TIMESTAMP\",             \"nonce\":\"NONCE\",            \"signature\":\"SIGNATURE\"        },    \"body\":{        \"token\":\"12345\" }    }")'  type="button" ></td>
	</tr>
	<tr>
		<td><input  value="查询保存的投标人公司注册信息接口"  onclick='setbinding("/myBidder/authInfo/getRegisteredInfo_apply","{        \"app\":{            \"appId\":\"zjhtwallet\",            \"timeStamp\":\"TIMESTAMP\",             \"nonce\":\"NONCE\",            \"signature\":\"SIGNATURE\"        },    \"body\":{        \"token\":\"12345\" }    }")'  type="button" ></td>
		<td><input  value="保存投标人公司注册信息接口"  onclick='setbinding("/myBidder/authInfo/saveRegisteredInfo_apply","   {    \"app\":{        \"appId\":\"zjhtwallet\",        \"timeStamp\":\"TIMESTAMP\",         \"nonce\":\"NONCE\",        \"signature\":\"SIGNATURE\"    },            \"body\":{        \"token\":\"12345\",        \"registeredInfo\":{             \"businessLicenseNum\":\"BUSINESS_LICENSE_NUM\",             \"businessLicenseUrl\":\"BUSINESS_LICENSE_URL\",             \"taxRegistrationNum\":\"TAX_REGISTRATION_NUM\",             \"taxRegistrationUrl\":\"TAX_REGISTRATION_URL\",             \"organizationCodeNum\":\"ORGANIZATION_CODE_NUM\",             \"organizationCodeUrl\":\"ORGANIZATION_CODE_URL\",             \"businessScope\":\"经营范围\",             \"regTime\":\"2014-04-05\",             \"businessLicenseExpireTime\":\"2016-04-05\",             \"address\":\"\",             \"businessLicenseType\":\"OLD\",             \"newBusinessLicenseNum\":\"\",             \"newBusinessLicenseUrl\":\"\"       }           }}   ")'  type="button" ></td>
		<td><input  value="查询保存的投标人开户行信息接口"  onclick='setbinding("/myBidder/authInfo/getBankInfo_apply","{        \"app\":{            \"appId\":\"zjhtwallet\",            \"timeStamp\":\"TIMESTAMP\",             \"nonce\":\"NONCE\",            \"signature\":\"SIGNATURE\"        },    \"body\":{        \"token\":\"12345\" }    }")'  type="button" ></td>
		<td><input  value="保存投标人开户行信息接口"  onclick='setbinding("/myBidder/authInfo/saveBankInfo","   {    \"app\":{        \"appId\":\"zjhtwallet\",        \"timeStamp\":\"TIMESTAMP\",         \"nonce\":\"NONCE\",        \"signature\":\"SIGNATURE\"    },            \"body\":    {        \"token\":\"USER_TOKEN\",           \"bankInfo\":{             \"bank\":\"招商银行深圳支行\",            \"accountId\":\"1234567812345678\",            \"accountName\":\"深圳麦圈互动技术有限公司\"        }    }}   ")'  type="button" ></td>
		<td><input  value="查询保存的投标人企业资质接口"  onclick='setbinding("/myBidder/authInfo/getEnterpriseQualification","{        \"app\":{            \"appId\":\"zjhtwallet\",            \"timeStamp\":\"TIMESTAMP\",             \"nonce\":\"NONCE\",            \"signature\":\"SIGNATURE\"        },    \"body\":{        \"token\":\"12345\" }    }")'  type="button" ></td>
		<td><input  value="保存投标人企业资质接口"  onclick='setbinding("/myBidder/authInfo/saveEnterpriseQualification","   {    \"app\":{        \"appId\":\"zjhtwallet\",        \"timeStamp\":\"TIMESTAMP\",         \"nonce\":\"NONCE\",        \"signature\":\"SIGNATURE\"    },            \"body\":{        \"token\":\"12345\",           \"eqInfo\":[{            \"projectType\":\"1##\",            \"eqName\":\"桩工程一级资质\",            \"eqRating\":\"1\",            \"eqId\":3,            \"eqDesc\":\"桩工程一级资质\",            \"expiryDate\":\"2016-09-12\"        }]        }    }    ")'  type="button" ></td>
	</tr>
	<tr>
		<td><input  value="提交投标人认证申请接口"  onclick='setbinding("/myBidder/authInfo/applay","{    \"app\":{        \"appId\":\"zjhtwallet\",        \"timeStamp\":\"TIMESTAMP\",         \"nonce\":\"NONCE\",        \"signature\":\"SIGNATURE\"    },            \"body\":{        \"token\":\"USER_TOKEN\"    }}  ")'  type="button" ></td>
		<td><input  value="投标人认证审核接口"  onclick='setbinding("/myBidder/authInfo/checkApplication","   { \"app\":{        \"appId\":\"zjhtwallet\",        \"timeStamp\":\"TIMESTAMP\",         \"nonce\":\"NONCE\",        \"signature\":\"SIGNATURE\"    },            \"body\":{        \"baseInfoCheck\":{            \"bidder_id\":999,            \"company_name\":{\"result\":\"FLS\",\"msg\":\"公司名称与工商注册名称不一致\"},            \"short_name\":{\"result\":\"OK#\",\"msg\":\"\"},            \"description\":{\"result\":\"OK#\",\"msg\":\"\"},            \"registered_capital\":{\"result\":\"OK#\",\"msg\":\"\"},            \"contact_mobile_num\":{\"result\":\"OK#\",\"msg\":\"\"},            \"email\":{\"result\":\"OK#\",\"msg\":\"\"},            \"logo\":{\"result\":\"OK#\",\"msg\":\"\"}        },        \"legalPersonCheck\":{            \"legal_person\":{\"result\":\"OK#\",\"msg\":\"\"},            \"legal_person_idcard\":{\"result\":\"OK#\",\"msg\":\"\"},            \"legal_person_idcard_front_url\":{\"result\":\"OK#\",\"msg\":\"\"},            \"legal_person_idcard_back_url\":{\"result\":\"OK#\",\"msg\":\"\"},            \"legal_person_authority_book\":{\"result\":\"OK#\",\"msg\":\"\"}        },        \"registeredInfoCheck\":{             \"business_license_num\":{\"result\":\"OK#\",\"msg\":\"\"},             \"business_license_url\":{\"result\":\"OK#\",\"msg\":\"\"},             \"tax_registration_certificate\":{\"result\":\"OK#\",\"msg\":\"\"},             \"tax_registration_certificate_url\":{\"result\":\"OK#\",\"msg\":\"\"},             \"org_code_certificate\":{\"result\":\"OK#\",\"msg\":\"\"},             \"org_code_certificate_url\":{\"result\":\"OK#\",\"msg\":\"\"},             \"business_scope\":{\"result\":\"OK#\",\"msg\":\"\"},             \"reg_time\":{\"result\":\"OK#\",\"msg\":\"\"},             \"business_license_expire_time\":{\"result\":\"OK#\",\"msg\":\"\"},             \"address\":{\"result\":\"OK#\",\"msg\":\"\"},             \"unified_social_credit_code\":{\"result\":\"OK#\",\"msg\":\"\"},             \"unified_social_credit_code_url\":{\"result\":\"OK#\",\"msg\":\"\"}        },        \"bankInfoCheck\":{             \"bank\":{\"result\":\"OK#\",\"msg\":\"\"},            \"accountId\":{\"result\":\"OK#\",\"msg\":\"\"},            \"accountName\":{\"result\":\"OK#\",\"msg\":\"\"}        }    } }   ")'  type="button" ></td>
	</tr>
	<tr><td colspan="2">招标服务（列表）</td></tr>
	<tr>
		<td><input  value="定标接口"  onclick='setbinding("/tender/bidEvaluation","  {    \"app\":{        \"appId\":\"paas\",        \"timeStamp\":\"TIMESTAMP\",         \"nonce\":\"NONCE\",        \"signature\":\"SIGNATURE\"    },    \"body\":{        \"token\":\"96c5f0e5e3c52fa0fc632aaa30d4fb85\",        \"objectId\":\"BH201302140056\",        \"winBidId\":1,        \"paymentInfo\":{            \"payType\":\"CUM\",            \"payPeriod\":12   ,         \"payList\":[{\"period\":1,\"payDate\":\"2015-06-12\",\"paySum\":50000}]        }    }}  ")'  type="button" ></td>
		<td><input  value="我的招标评标概况接口"  onclick='setbinding("/tender/queryMyObjectTenderSurvey","  {    \"app\":{        \"appId\":\"paas\",        \"timeStamp\":\"TIMESTAMP\",         \"nonce\":\"NONCE\",        \"signature\":\"SIGNATURE\"    },    \"body\":{        \"token\":\"96c5f0e5e3c52fa0fc632aaa30d4fb85\",        \"objectId\":\"32456\"    }}  ")'  type="button" ></td>
		<td><input  value="我的招标项目投标列表接口"  onclick='setbinding("/tender/queryMyObjectBidList"," {    \"app\":{        \"appId\":\"paas\",        \"timeStamp\":\"TIMESTAMP\",         \"nonce\":\"NONCE\",        \"signature\":\"SIGNATURE\"    },    \"body\":{        \"token\":\"96c5f0e5e3c52fa0fc632aaa30d4fb85\",        \"pageSize\":3,        \"pageIndex\":5,        \"objectId\":\"BH201322132456\"    }}  ")'  type="button" ></td>
		<td><input  value="查询投标人评价概况接口"  onclick='setbinding("/tender/queryTendererEvaluate"," {    \"app\":{        \"appId\":\"paas\",        \"timeStamp\":\"TIMESTAMP\",         \"nonce\":\"NONCE\",        \"signature\":\"SIGNATURE\"    },    \"body\":{        \"token\":\"96c5f0e5e3c52fa0fc632aaa30d4fb85\",        \"objectId\":\"BH2345464356\"    }}  ")'  type="button" ></td>
		<td><input  value="查询我的招标概况接口"  onclick='setbinding("/tender/queryMyObjectSurvey","{    \"app\":{        \"appId\":\"paas\",        \"timeStamp\":\"TIMESTAMP\",         \"nonce\":\"NONCE\",        \"signature\":\"SIGNATURE\"    },    \"body\":{        \"token\":\"96c5f0e5e3c52fa0fc632aaa30d4fb85\"    }} ")'  type="button" ></td>
		<td><input  value="查询我的招标项目列表接口"  onclick='setbinding("/tender/queryMyTenderObject","{    \"app\":{        \"appId\":\"paas\",        \"timeStamp\":\"TIMESTAMP\",         \"nonce\":\"NONCE\",        \"signature\":\"SIGNATURE\"    },    \"body\":{        \"token\":\"96c5f0e5e3c52fa0fc632aaa30d4fb85\",        \"pageIndex\":0,        \"pageSize\":10    }} ")'  type="button" ></td>
	</tr>
	<tr>
		<td><input  value="查询我的施工项目列表接口"  onclick='setbinding("/tender/queryMyBuildingObject","{    \"app\":{        \"appId\":\"paas\",        \"timeStamp\":\"TIMESTAMP\",         \"nonce\":\"NONCE\",        \"signature\":\"SIGNATURE\"    },    \"body\":{        \"token\":\"96c5f0e5e3c52fa0fc632aaa30d4fb85\",        \"pageIndex\":0,        \"pageSize\":10    }} ")'  type="button" ></td>
		<td><input  value="查询我的已结束项目列表接口"  onclick='setbinding("/tender/queryMyEndedObject","{    \"app\":{        \"appId\":\"paas\",        \"timeStamp\":\"TIMESTAMP\",         \"nonce\":\"NONCE\",        \"signature\":\"SIGNATURE\"    },    \"body\":{        \"token\":\"96c5f0e5e3c52fa0fc632aaa30d4fb85\",        \"pageIndex\":0,        \"pageSize\":10    }}  ")'  type="button" ></td>
		<td><input  value="查询招标项目接口"  onclick='setbinding("/tender/queryObjectList_homepage","{    \"app\":{        \"appId\":\"paas\",        \"timeStamp\":\"TIMESTAMP\",         \"nonce\":\"NONCE\",        \"signature\":\"SIGNATURE\"    },    \"body\":{        \"keywords\":[{\"keyword\":\"投标\"},{\"keyword\":\"深圳\"}] ,       \"pageIndex\":0,        \"pageSize\":10    }} ")'  type="button" ></td>
		<td><input  value="查询首页招标项目概况接口"  onclick='setbinding("/tender/queryObjectIndexSurvey","{    \"app\":{        \"appId\":\"paas\",        \"timeStamp\":\"TIMESTAMP\",         \"nonce\":\"NONCE\",        \"signature\":\"SIGNATURE\"    }}  ")'  type="button" ></td>
		<td><input  value="查询首页招标项目列表接口"  onclick='setbinding("/tender/queryIndexObjectList","{    \"app\":{        \"appId\":\"paas\",        \"timeStamp\":\"TIMESTAMP\",         \"nonce\":\"NONCE\",        \"signature\":\"SIGNATURE\"    }} ")'  type="button" ></td>
		<td><input  value="查询首页中标结果概况接口"  onclick='setbinding("/tender/queryBidIndexSurvey","{    \"app\":{        \"appId\":\"paas\",        \"timeStamp\":\"TIMESTAMP\",         \"nonce\":\"NONCE\",        \"signature\":\"SIGNATURE\"    }} ")'  type="button" ></td>
	</tr>
	<tr>
		<td><input  value="查询首页中标项目列表接口"  onclick='setbinding("/tender/queryBidIndexList","{    \"app\":{        \"appId\":\"paas\",        \"timeStamp\":\"TIMESTAMP\",         \"nonce\":\"NONCE\",        \"signature\":\"SIGNATURE\" },\"body\":{\"pageIndex\":1,\"pageSize\":1,\"projectName\":\"土石\",\"publishTime\":2}} ")'  type="button" ></td>
		
	</tr>
	<tr>
		<td colspan="6"></td>
	</tr>
	<tr><td colspan="2">投标服务（外部接口）</td></tr>
	<tr>
		<td><input  value="查询我的已结束项目列表接口"  onclick='setbinding("/bid/queryMyEndedObject","  {    \"app\":{        \"appId\":\"paas\",        \"timeStamp\":\"TIMESTAMP\",         \"nonce\":\"NONCE\",        \"signature\":\"SIGNATURE\"    },    \"body\":{        \"token\":\"96c5f0e5e3c52fa0fc632aaa30d4fb85\",        \"pageIndex\":1,        \"pageSize\":10    }}   ")'  type="button" ></td>
		<td><input  value="查询我的未中标项目接口"  onclick='setbinding("/bid/queryMyLoseObject","  {    \"app\":{        \"appId\":\"paas\",        \"timeStamp\":\"TIMESTAMP\",         \"nonce\":\"NONCE\",        \"signature\":\"SIGNATURE\"    },    \"body\":{        \"token\":\"96c5f0e5e3c52fa0fc632aaa30d4fb85\",        \"pageIndex\":1,        \"pageSize\":10    }}   ")'  type="button" ></td>
		<td><input  value="查询招标人评价概况接口"  onclick='setbinding("/tender/queryTendererEvaluate","  {    \"app\":{        \"appId\":\"paas\",        \"timeStamp\":\"TIMESTAMP\",         \"nonce\":\"NONCE\",        \"signature\":\"SIGNATURE\"    },    \"body\":{        \"token\":\"96c5f0e5e3c52fa0fc632aaa30d4fb85\",        \"objectId\":\"BH2345464356\"    }}   ")'  type="button" ></td>
		<td><input  value="查询我的投标概况接口"  onclick='setbinding("/tender/queryMyBidSurvey","  {    \"app\":{        \"appId\":\"paas\",        \"timeStamp\":\"TIMESTAMP\",         \"nonce\":\"NONCE\",        \"signature\":\"SIGNATURE\"    },    \"body\":{        \"token\":\"96c5f0e5e3c52fa0fc632aaa30d4fb85\"    }}    ")'  type="button" ></td>
		<td><input  value="查询我的投标中项目列表接口"  onclick='setbinding("/bid/queryMyBidObject","  {    \"app\":{        \"appId\":\"paas\",        \"timeStamp\":\"TIMESTAMP\",         \"nonce\":\"NONCE\",        \"signature\":\"SIGNATURE\"    },    \"body\":{        \"token\":\"96c5f0e5e3c52fa0fc632aaa30d4fb85\",        \"pageIndex\":1,        \"pageSize\":10    }}   ")'  type="button" ></td>
		<td><input  value="查询我的实施中项目列表接口"  onclick='setbinding("/bid/queryMyBuildingObject"," {    \"app\":{        \"appId\":\"paas\",        \"timeStamp\":\"TIMESTAMP\",         \"nonce\":\"NONCE\",        \"signature\":\"SIGNATURE\"    },    \"body\":{        \"token\":\"96c5f0e5e3c52fa0fc632aaa30d4fb85\",        \"pageIndex\":1,        \"pageSize\":10    }}    ")'  type="button" ></td>
		
		</tr>
	<tr>
		<td><input  value="查询首页投标人概况接口"  onclick='setbinding("/tender/queryBidderIndexSurvey","{    \"app\":{        \"appId\":\"paas\",        \"timeStamp\":\"TIMESTAMP\",         \"nonce\":\"NONCE\",        \"signature\":\"SIGNATURE\"    } }   ")'  type="button" ></td>
		<td><input  value="查询首页投标人推荐列表接口"  onclick='setbinding("/tender/queryIndexBidList","{    \"app\":{        \"appId\":\"paas\",        \"timeStamp\":\"TIMESTAMP\",         \"nonce\":\"NONCE\",        \"signature\":\"SIGNATURE\"    } }   ")'  type="button" ></td>
		</tr>
		<tr>
		<td colspan="6"></td>
	</tr>
	<tr><td colspan="6">招标管理</td></tr>
	<tr>
		<td><input  value="查询未完成招标项目基础信息接口"  onclick='setbinding("/tender/queryObjectBaseInfo","{        \"app\":{            \"appId\":\"zjhtwallet\",            \"timeStamp\":\"TIMESTAMP\",             \"nonce\":\"NONCE\",            \"signature\":\"SIGNATURE\"        },                \"body\":        {        \"token\":\"12345\",        \"objectId\":\"BH2015082135656\"    }    }")'  type="button" ></td>
		<td><input  value="保存招标项目基础信息接口"  onclick='setbinding("/tender/saveObjectBaseInfo","    {        \"app\":{            \"appId\":\"zjhtwallet\",            \"timeStamp\":\"TIMESTAMP\",             \"nonce\":\"NONCE\",            \"signature\":\"SIGNATURE\"        },                \"body\":        {        \"token\":\"12345\",        \"objectId\":\"BH2015082135656\",        \"objectName\":\"土石购买招标\",        \"biddingNo\":\"23009751\",            \"objectScope\":\"招标项目范围\",            \"biddeeCompanyPrincipal\":\"张三\",            \"biddeeCompanyTelephone\":\"0755-56432117\",            \"currency\":\"CNY\",            \"contractType\":\"承包方式\",            \"evaluationAmount\":\"300000\"    }    }")'  type="button" ></td>
		<td><input  value="查询未完成招标项目工程信息接口"  onclick='setbinding("/tender/queryObjectProjectInfo","    {        \"app\":{            \"appId\":\"zjhtwallet\",            \"timeStamp\":\"TIMESTAMP\",             \"nonce\":\"NONCE\",            \"signature\":\"SIGNATURE\"        },                \"body\":{        \"token\":\"12345\",        \"objectId\":\"BH2015082135656\"     }     }")'  type="button" ></td>
		<td><input  value="保存招标项目工程信息接口"  onclick='setbinding("/tender/saveObjectProjectInfo","    {        \"app\":{            \"appId\":\"zjhtwallet\",            \"timeStamp\":\"TIMESTAMP\",             \"nonce\":\"NONCE\",            \"signature\":\"SIGNATURE\"        },                \"body\":        {        \"token\":\"12345\",        \"objectId\":\"BH2015082135656\",        \"projectName\":\"金域华府3期工程开发\",            \"industryId\":\"TSF\",         \"projectSite\":\"工程地点\",            \"projectScale\":\"工程规模及特征\",            \"projectExpectInvestment\":\"工程计划总投资\",            \"employer\":\"建设单位\",            \"employerPrincipal\":\"建设单位经办人\",            \"employerTelephone\":\"建设单位办公电话\" }     }")'  type="button" ></td>
		<td><input  value="查询未完成招标项目工程要求接口"  onclick='setbinding("/tender/queryProjectRequirementInfo","    {        \"app\":{            \"appId\":\"zjhtwallet\",            \"timeStamp\":\"TIMESTAMP\",             \"nonce\":\"NONCE\",            \"signature\":\"SIGNATURE\"        },                \"body\":{        \"token\":\"12345\",        \"objectId\":\"BH2015082135656\"     }     }")'  type="button" ></td>
		<td><input  value="保存招标项目工程要求接口"  onclick='setbinding("/tender/saveProjectRequirementInfo","    {        \"app\":{            \"appId\":\"zjhtwallet\",            \"timeStamp\":\"TIMESTAMP\",             \"nonce\":\"NONCE\",            \"signature\":\"SIGNATURE\"        },                \"body\":        {            \"token\":\"12345\",            \"objectId\":\"BH2015082135656\",            \"projectExpectStartDate\":\"2012年8月\",            \"projectExpectPeriod\":300        }    }")'  type="button" ></td>
	</tr>
	<tr>
		<td><input  value="查询未完成招标项目工程施工证明接口"  onclick='setbinding("/tender/queryObjectConstructionInfo","    {        \"app\":{            \"appId\":\"zjhtwallet\",            \"timeStamp\":\"TIMESTAMP\",             \"nonce\":\"NONCE\",            \"signature\":\"SIGNATURE\"        },    \"body\":{        \"token\":\"12345\",        \"objectId\":\"BH2015082135656\"     }   }")'  type="button" ></td>
		<td><input  value="保存招标项目工程施工证明接口"  onclick='setbinding("/tender/saveObjectConstructionInfo","    {        \"app\":{            \"appId\":\"zjhtwallet\",            \"timeStamp\":\"TIMESTAMP\",             \"nonce\":\"NONCE\",            \"signature\":\"SIGNATURE\"        },                \"body\":        {            \"token\":\"12345\",            \"objectId\":\"BH2015082135656\",            \"constructionProveType\":\"BCP\",            \"landUseCertificateNo\":\"BH2015110100123\",            \"landUseCertificateEndDate\":\"2015-03-28\",            \"landUseCertificateUrl\":\"URL\",            \"constructionLandUsePermitNo\":\"BH2015110200564\",            \"constructionLandUsePermitEndDate\":\"2015-03-28\",            \"constructionLandUsePermitUrl\":\"URL\",            \"buildingPermitNo\":\"BH2015091800267\",            \"buildingPermitEndDate\":\"2015-03-28\",            \"buildingPermitUrl\":\"URL\",            \"letterOfAcceptanceUrl\":\"URL\",            \"buildingConstructPermitNo\":\"BH2015080400897\",            \"buildingConstructPermitEndDate\":\"2015-03-28\",            \"buildingConstructPermitUrl\":\"URL\"        }    }")'  type="button" ></td>
		<td><input  value="查询未完成招标项目资质要求接口"  onclick='setbinding("/tender/queryObjectCertificationInfo","    {        \"app\":{            \"appId\":\"zjhtwallet\",            \"timeStamp\":\"TIMESTAMP\",             \"nonce\":\"NONCE\",            \"signature\":\"SIGNATURE\"        },                \"body\":        {       \"token\":\"12345\",       \"objectId\":\"BH2015082135656\"    }    }")'  type="button" ></td>
		<td><input  value="保存招标项目资质要求接口"  onclick='setbinding("/tender/saveObjectCertificationInfo"," {\"app\":{\"appId\":\"zjhtwallet\",\"timeStamp\":\"TIMESTAMP\",\"nonce\":\"NONCE\",\"signature\":\"SIGNATURE\"},\"body\":{\"token\":\"55890\",\"objectId\":\"BH2015082135656\",\"bidderCertification\":[{\"industryId\":1,\"certificateId\":3},{\"industryId\":2,\"certificateId\":4}],\"needPmCertification\":\"YES\",\"needConstructorCertification\":\"YES\",\"needSafetyPermit\":\"YES\",\"needPmSafetyCertification\":\"YES\"}}")'  type="button" ></td>
		<td><input  value="查询未完成招标项目保证金接口"  onclick='setbinding("/tender/queryObjectBondInfo","    {        \"app\":{            \"appId\":\"zjhtwallet\",            \"timeStamp\":\"TIMESTAMP\",             \"nonce\":\"NONCE\",            \"signature\":\"SIGNATURE\"        },                \"body\":        {            \"objectId\":\"BH2015082135656\",            \"token\":\"12345\"        }    } ")'  type="button" ></td>
		<td><input  value="保存招标项目保证金接口"  onclick='setbinding("/tender/saveObjectBondInfo","    {        \"app\":{            \"appId\":\"zjhtwallet\",            \"timeStamp\":\"TIMESTAMP\",             \"nonce\":\"NONCE\",            \"signature\":\"SIGNATURE\"        },                \"body\":        {            \"objectId\":\"BH2015082135656\",            \"token\":\"12345\",            \"bidBondAmount\":50000         }     }")'  type="button" ></td>
	</tr>
	<tr>
		<td><input  value="查询未完成招标项目投标文件接口"  onclick='setbinding("/tender/queryBidFileTypeInfo","    {        \"app\":{            \"appId\":\"zjhtwallet\",            \"timeStamp\":\"TIMESTAMP\",             \"nonce\":\"NONCE\",            \"signature\":\"SIGNATURE\"        },                \"body\":        {        \"token\":\"12345\",        \"objectId\":\"BH2015082135656\"    }    }")'  type="button" ></td>
		<td><input  value="保存招标项目投标文件接口"  onclick='setbinding("/tender/saveBidFileTypeInfo","    {        \"app\":{            \"appId\":\"zjhtwallet\",            \"timeStamp\":\"TIMESTAMP\",             \"nonce\":\"NONCE\",            \"signature\":\"SIGNATURE\"        },                \"body\":        {        \"token\":\"12345\",        \"objectId\":\"BH2015082135656\" ,\"needBusinessStandard\":\"YES\",        \"needTechnicalStandard\":\"YES\",      \"needCertificationCheckupFile\":\"YES\" ,\"tenderFile\":\"tfurl\"  }    }")'  type="button" ></td>
		<td><input  value="查询未完成招标方式接口"  onclick='setbinding("/tender/queryObjectMethodInfo","    {        \"app\":{            \"appId\":\"zjhtwallet\",            \"timeStamp\":\"TIMESTAMP\",             \"nonce\":\"NONCE\",            \"signature\":\"SIGNATURE\"        },                \"body\":        {        \"token\":\"12345\",        \"objectId\":\"BH2015082135656\"    }    }")'  type="button" ></td>
		<td><input  value="保存未完成招标方式接口"  onclick='setbinding("/tender/saveObjectMethodInfo","    {        \"app\":{            \"appId\":\"zjhtwallet\",            \"timeStamp\":\"TIMESTAMP\",             \"nonce\":\"NONCE\",            \"signature\":\"SIGNATURE\"        },                \"body\":{        \"token\":\"12345\",            \"objectId\":\"BH2015082135656\",            \"objectMethod\":\"INVI\",            \"inviteTender\":[{                \"bidderName\":\"蜂鸟娱乐（点点）\",                \"bidderId\":2                },{                \"bidderName\":\"麦圈互动（胖子）\",                \"bidderId\":3            }]    }    }")'  type="button" ></td>
		<td><input  value="查询未完成招标答疑方式接口"  onclick='setbinding("/tender/queryAnswerMethodInfo","  {        \"app\":{            \"appId\":\"zjhtwallet\",            \"timeStamp\":\"TIMESTAMP\",             \"nonce\":\"NONCE\",            \"signature\":\"SIGNATURE\"        },                \"body\":        {        \"token\":\"12345\",        \"objectId\":\"BH2015082135656\"    }    }")'  type="button" ></td>
		<td><input  value="保存招标答疑方式接口"  onclick='setbinding("/tender/saveAnswerMethodInfo","    {        \"app\":{            \"appId\":\"zjhtwallet\",            \"timeStamp\":\"TIMESTAMP\",             \"nonce\":\"NONCE\",            \"signature\":\"SIGNATURE\"        },                \"body\":        {\"token\":\"12345\",\"objectId\":\"35656\",\"startTime\":\"2015-05-23\",\"endTime\":\"2015-05-26\",\"QQ\":\"4658703\",\"QQtoken\":\"XXX标的答疑\",\"email\":\"maoxian@126.com\",\"address\":\"地王大厦3栋5楼402\",\"addressAnswerTime\":\"12:00-16:30\",\"addressAnswerDate\":\"2015-05-24\",\"telephone\":\"1387654\"}    }")'  type="button" ></td>
	</tr>
	<tr>
		<td><input  value="查询未完成招标时间要求接口"  onclick='setbinding("/tender/queryDateRequirementInfo","    {        \"app\":{            \"appId\":\"zjhtwallet\",            \"timeStamp\":\"TIMESTAMP\",             \"nonce\":\"NONCE\",            \"signature\":\"SIGNATURE\"        },                \"body\":        {        \"token\":\"12345\",        \"objectId\":\"BH2015082135656\"    }    }")'  type="button" ></td>
		<td><input  value="保存招标时间要求接口"  onclick='setbinding("/tender/saveDateRequirementInfo","    {        \"app\":{            \"appId\":\"zjhtwallet\",            \"timeStamp\":\"TIMESTAMP\",             \"nonce\":\"NONCE\",            \"signature\":\"SIGNATURE\"        },                \"body\":        {            \"token\":\"12345\",            \"objectId\":\"BH2015082135656\",        \"announcementBeginTime\":\"2015-04-10\",            \"announcementEndTime\":\"2015-04-25\",            \"biddingEndTime\":\"2015-04-25\",            \"bidOpenDate\":\"2015-04-30\"     }     }")'  type="button" ></td>
		<td><input  value="查询未完成招标评标方式接口"  onclick='setbinding("/tender/queryBidEvaluationTypeInfo","    {        \"app\":{            \"appId\":\"zjhtwallet\",            \"timeStamp\":\"TIMESTAMP\",             \"nonce\":\"NONCE\",            \"signature\":\"SIGNATURE\"        },                \"body\":        {            \"token\":\"12345\",            \"objectId\":\"BH2015082135656\"     }     }")'  type="button" ></td>
		<td><input  value="保存招标评标方式接口"  onclick='setbinding("/tender/saveBidEvaluationTypeInfo","    {        \"app\":{            \"appId\":\"zjhtwallet\",            \"timeStamp\":\"TIMESTAMP\",             \"nonce\":\"NONCE\",            \"signature\":\"SIGNATURE\"        },                \"body\":        {            \"token\":\"12345\",            \"objectId\":\"BH2015082135656\",                \"bidEvaluationType\":\"QLT\",            \"bidEvaluationSite\":\"技术标评标地点\",            \"bidWinnerDetermineWay\":\"ORV\",            \"voteWinWay\":\"SMP\"     }     }")'  type="button" ></td>
		<td><input  value="发布标的接口"  onclick='setbinding("/tender/submitObject","    {        \"app\":{            \"appId\":\"zjhtwallet\",            \"timeStamp\":\"TIMESTAMP\",             \"nonce\":\"NONCE\",            \"signature\":\"SIGNATURE\"        },                \"body\":      {        \"token\":\"12345\",        \"objectId\":\"BH2015082135656\"    }     }")'  type="button" ></td>
		<td><input  value="查询招标资质接口"  onclick='setbinding("/tender/isInvitationOfTender","    {        \"app\":{            \"appId\":\"zjhtwallet\",            \"timeStamp\":\"TIMESTAMP\",             \"nonce\":\"NONCE\",            \"signature\":\"SIGNATURE\"        },                \"body\":      {        \"token\":\"12345\"    }     }")'  type="button" ></td>
	</tr>
	<tr>
		<td><input  value="查询招标资质接口"  onclick='setbinding("/tender/queryCertificateList","    {        \"app\":{            \"appId\":\"zjhtwallet\",            \"timeStamp\":\"TIMESTAMP\",             \"nonce\":\"NONCE\",            \"signature\":\"SIGNATURE\"        },                \"body\":      { }     }")'  type="button" ></td>
		<td><input  value="查询投标方列表接口"  onclick='setbinding("/tender/queryBidderList","    {        \"app\":{            \"appId\":\"zjhtwallet\",            \"timeStamp\":\"TIMESTAMP\",             \"nonce\":\"NONCE\",            \"signature\":\"SIGNATURE\"        },                \"body\":      { }     }")'  type="button" ></td>
		<td><input  value="招标方给投标方评价接口"  onclick='setbinding("/tender/evaluateBidder","{\"app\":{\"appId\":\"zjhtwallet\",\"timeStamp\":\"TIMESTAMP\",\"nonce\":\"NONCE\",\"signature\":\"SIGNATURE\"},\"body\":{\"token\":\"12345\",\"objectId\":\"BH2015082135656\",\"evaluateScore\":7,\"tags\":[\"速度够快\",\"质量很高\"],\"evaluateContent\":\"合作愉快，期待下次继续！\"}}")'  type="button" ></td>
	
	</tr>
	<tr><td colspan="6">投标管理</td></tr>
	<tr>
		<td><input  value="查询未完成的投标资格审查信息接口"  onclick='setbinding("/bid/queryBidRequirementInfo","    {        \"app\":{            \"appId\":\"zjhtwallet\",            \"timeStamp\":\"TIMESTAMP\",             \"nonce\":\"NONCE\",            \"signature\":\"SIGNATURE\"        },        \"body\":        {            \"token\":\"12345\",            \"bidId\":1,            \"objectId\":\"BH2015082135656\"        }    } ")'  type="button" ></td>
		<td><input  value="保存投标资格审查信息接口"  onclick='setbinding("/bid/saveBidRequirementInfo"," {        \"app\":{            \"appId\":\"zjhtwallet\",            \"timeStamp\":\"TIMESTAMP\",             \"nonce\":\"NONCE\",            \"signature\":\"SIGNATURE\"        },        \"body\":        {            \"token\":\"12345\",        \"objectId\":\"BH2015082135656\",        \"bidId\":1,        \"certificationList\":[{\"objReqId\":1,\"bidderCertificationId\":1},{\"objReqId\":2,\"bidderCertificationId\":2}],            \"bidSafetyInfo\":{                \"needSafetyPermitNo\":\"201562377\",                \"needSafetyPermitEndDate\":\"2015-11-21\",                \"needSafetyPermitUrl\":\"URL\",                \"needPmSafetyCertificationNo\":\"201409886432\",                \"needPmSafetyCertificationEndDate\":\"2015-09-12\",                \"needPmSafetyCertificationUrl\":\"URL\"              },            \"bidPeopleRequirement\":{                \"needPmCertificationNo\":\"20123878654\",                \"needPmCertificationEndDate\":\"2015-02-12\",                \"needPmCertificationUrl\":\"URL\",                \"needConstructorCertificationNo\":\"20150812098765\",                \"needConstructorCertificationEndDate\":\"2015-02-13\",                \"needConstructorCertificationUrl\":\"URL\"                                },            \"bankGuarantee\":{                \"bankGuaranteeAmount\":50000000,                \"bankGuaranteeUrl\":\"URL\",                \"bankGuaranteeNo\":\"BH2108765123\"            }        }    } ")'  type="button" ></td>
		<td><input  value="查询未完成投标的商务标信息接口"  onclick='setbinding("/bid/queryBusinessStandardInfo","    {        \"app\":{            \"appId\":\"zjhtwallet\",            \"timeStamp\":\"TIMESTAMP\",             \"nonce\":\"NONCE\",            \"signature\":\"SIGNATURE\"        },        \"body\":        {            \"token\":\"12345\",            \"bidId\":1,            \"objectId\":\"BH2015082135656\"        }    } ")'  type="button" ></td>
		<td><input  value="保存投标的商务标信息接口"  onclick='setbinding("/bid/saveBusinessStandardInfo","    {        \"app\":{            \"appId\":\"zjhtwallet\",            \"timeStamp\":\"TIMESTAMP\",             \"nonce\":\"NONCE\",            \"signature\":\"SIGNATURE\"        },        \"body\":        {            \"token\":\"12345\",            \"objectId\":\"BH2015082135656\",            \"bidId\":1,            \"bidAmount\":\"5000000000\",            \"projectQuotationUrl\":\"URL\",            \"constructionStartDate\":\"2015-01-21\",            \"constructionEndDate\":\"2015-08-21\",            \"constructionCommitmentUrl\":\"URL\"        }    } ")'  type="button" ></td>
		<td><input  value="查询未完成投标的技术标信息接口"  onclick='setbinding("/bid/queryTechnicalStandardInfo","    {        \"app\":{            \"appId\":\"zjhtwallet\",            \"timeStamp\":\"TIMESTAMP\",             \"nonce\":\"NONCE\",            \"signature\":\"SIGNATURE\"        },        \"body\":        {            \"token\":\"12345\",            \"bidId\":1,            \"objectId\":\"BH2015082135656\"        }    } ")'  type="button" ></td>
		<td><input  value="保存投标的技术标信息接口"  onclick='setbinding("/bid/saveTechnicalStandardInfo","    {        \"app\":{            \"appId\":\"zjhtwallet\",            \"timeStamp\":\"TIMESTAMP\",             \"nonce\":\"NONCE\",            \"signature\":\"SIGNATURE\"        },        \"body\":        {            \"token\":\"12345\",            \"objectId\":\"BH2015082135656\",            \"bidId\":1,            \"technicalStandardUrl\":\"URL\"        }    } ")'  type="button" ></td>
	</tr>
	<tr>
		<td><input  value="查询投标保证金信息接口"  onclick='setbinding("/bid/queryBidderBond","    {        \"app\":{            \"appId\":\"zjhtwallet\",            \"timeStamp\":\"TIMESTAMP\",             \"nonce\":\"NONCE\",            \"signature\":\"SIGNATURE\"        },        \"body\":        {            \"token\":\"12345\",            \"bidId\":1,            \"objectId\":\"BH2015082135656\"        }    }")'  type="button" ></td>
		<td><input  value="保存投标保证金接口"  onclick='setbinding("/bid/saveBidderBond","    {        \"app\":{            \"appId\":\"zjhtwallet\",            \"timeStamp\":\"TIMESTAMP\",             \"nonce\":\"NONCE\",            \"signature\":\"SIGNATURE\"        },                \"body\":        {       \"token\":\"12345\",            \"bidId\":1,            \"objectId\":\"BH2015082135656\",            \"bankGuaranteeNo\":\"327iueyr7w3\",            \"bankGuaranteeUrl\":\"http://xx.diue.com/ewdf\",            \"bankGuaranteeAmount\":\"300000\"        }    } ")'  type="button" ></td>
		<td><input  value="查询撮合投标保证金接口"  onclick='setbinding("/bid/queryMakeMatchBidderBond","    {        \"app\":{            \"appId\":\"zjhtwallet\",            \"timeStamp\":\"TIMESTAMP\",             \"nonce\":\"NONCE\",            \"signature\":\"SIGNATURE\"        },                \"body\":        {       \"token\":\"12345\",            \"bidId\":1,            \"objectId\":\"BH2015082135656\"        }    } ")'  type="button" ></td>
		<td><input  value="提交撮合投标保证金信息接口"  onclick='setbinding("/bid/saveMakeMatchBidderBond","    {        \"app\":{            \"appId\":\"zjhtwallet\",            \"timeStamp\":\"TIMESTAMP\",             \"nonce\":\"NONCE\",            \"signature\":\"SIGNATURE\"        },                \"body\":        {       \"token\":\"12345\",            \"bidId\":1,            \"objectId\":\"BH2015082135656\",            \"makeMatchBidderBondAmount\":300000        }    } ")'  type="button" ></td>
		<td><input  value="查询未完成投标接口"  onclick='setbinding("/bid/queryBidFile4Submit","    {        \"app\":{            \"appId\":\"zjhtwallet\",            \"timeStamp\":\"TIMESTAMP\",             \"nonce\":\"NONCE\",            \"signature\":\"SIGNATURE\"        },                \"body\":        {        \"token\":\"12345\",        \"objectId\":\"BH2015082135656\",        \"bidId\":1        }    } ")'  type="button" ></td>
		<td><input  value="提交投标接口"  onclick='setbinding("/bid/submitBid","    {        \"app\":{            \"appId\":\"zjhtwallet\",            \"timeStamp\":\"TIMESTAMP\",             \"nonce\":\"NONCE\",            \"signature\":\"SIGNATURE\"        },                \"body\":        {        \"token\":\"12345\",        \"objectId\":\"BH2015082135656\",        \"bidId\":1        }    } ")'  type="button" ></td>
		<td><input  value="查询投标要求基础信息"  onclick='setbinding("/bid/queryObjectRequirementInfo","    {        \"app\":{            \"appId\":\"zjhtwallet\",            \"timeStamp\":\"TIMESTAMP\",             \"nonce\":\"NONCE\",            \"signature\":\"SIGNATURE\"        },                \"body\":        {          \"objectId\":\"BH2015082135656\"        }    } ")'  type="button" ></td>
				
	</tr>
	<tr>
		<td><input  value="查询招标公告列表接口"  onclick='setbinding("/bid/queryObjectList"," {\"app\":{\"appId\":\"zjhtwallet\",\"timeStamp\":\"TIMESTAMP\",\"nonce\":\"NONCE\",\"signature\":\"SIGNATURE\"},\"body\":{\"token\":\"12345\",\"pageSize\":12,\"pageIndex\":1}} ")'  type="button" ></td>
		<td><input  value="查询标的详情接口"  onclick='setbinding("/bid/queryObjectDetail","    {        \"app\":{            \"appId\":\"zjhtwallet\",            \"timeStamp\":\"TIMESTAMP\",             \"nonce\":\"NONCE\",            \"signature\":\"SIGNATURE\"        },                \"body\":        {       \"token\":\"12345\",            \"objectId\":\"BH2015082135656\"        }    } ")'  type="button" ></td>
		<td><input  value="查询投标资质接口"  onclick='setbinding("/bid/isInvitationOfBid","    {        \"app\":{            \"appId\":\"zjhtwallet\",            \"timeStamp\":\"TIMESTAMP\",             \"nonce\":\"NONCE\",            \"signature\":\"SIGNATURE\"        },                \"body\":        {       \"token\":\"67890\",\"objectId\":\"BH2015082135656\" }    } ")'  type="button" ></td>
		<td><input  value="查询投标人资质证书接口"  onclick='setbinding("/bid/queryBidderCertificationInfo","    {        \"app\":{            \"appId\":\"zjhtwallet\",            \"timeStamp\":\"TIMESTAMP\",             \"nonce\":\"NONCE\",            \"signature\":\"SIGNATURE\"        },                \"body\":        {       \"token\":\"67890\",\"objectId\":\"BH2015082135656\" }    } ")'  type="button" ></td>
		<td><input  value="查询投标要求基础信息接口"  onclick='setbinding("/bid/queryObjectCertificationInfo","    {        \"app\":{            \"appId\":\"zjhtwallet\",            \"timeStamp\":\"TIMESTAMP\",             \"nonce\":\"NONCE\",            \"signature\":\"SIGNATURE\"        },                \"body\":        {    \"objectId\":\"BH2015082135656\" }    } ")'  type="button" ></td>
		<td><input  value="查询投标要求基础信息接口"  onclick='setbinding("/bid/queryObjectCertificationInfo","    {        \"app\":{            \"appId\":\"zjhtwallet\",            \"timeStamp\":\"TIMESTAMP\",             \"nonce\":\"NONCE\",            \"signature\":\"SIGNATURE\"        },                \"body\":        {    \"objectId\":\"BH2015082135656\" }    } ")'  type="button" ></td>
	</tr>
	<tr>
		<td><input  value="查询投标人基础信息接口"  onclick='setbinding("/bid/queryBidderCompanyInfo","{        \"app\":{            \"appId\":\"zjhtwallet\",            \"timeStamp\":\"TIMESTAMP\",             \"nonce\":\"NONCE\",            \"signature\":\"SIGNATURE\"        },        \"body\":{     \"token\":\"12345\"      }    }")'  type="button" ></td>
		<td><input  value="投标方给招标方评价接口"  onclick='setbinding("/bid/evaluateBiddee","{\"app\":{\"appId\":\"zjhtwallet\",\"timeStamp\":\"TIMESTAMP\",\"nonce\":\"NONCE\",\"signature\":\"SIGNATURE\"},\"body\":{\"token\":\"12345\",\"objectId\":\"BH2015082135656\",\"evaluateScore\":7,\"tags\":[\"速度够快\",\"质量很高\"],\"evaluateContent\":\"合作愉快，期待下次继续！\"}}")'  type="button" ></td>
	
	</tr>
	<tr><td colspan="6">工程管理-招标人</td></tr>
	<tr>
		<td><input type="button"  value="查询我的招标项目付款情况"  onclick='setbinding("/myPayment/queryMyPaymentList","{\"app\":{\"appId\":\"paas\",\"timeStamp\":\"TIMESTAMP\",  \"nonce\":\"NONCE\", \"signature\":\"21aa0011472249b4292e81504f3917bd\"  },\"body\":{\"token\":\"96c5f0e5e3c52fa0fc632aaa30d4fb85\"}}")'></td>
		<td><input type="button"  value="查询我的招标项目付款概况"  onclick='setbinding("/myPayment/getMyPaymentOverall","{\"app\":{\"appId\":\"paas\",\"timeStamp\":\"TIMESTAMP\",  \"nonce\":\"NONCE\", \"signature\":\"21aa0011472249b4292e81504f3917bd\"  },\"body\":{\"token\":\"96c5f0e5e3c52fa0fc632aaa30d4fb85\"}}")'></td>
		<td><input type="button"  value="查询项目应付款详情"  onclick='setbinding("/myPayment/queryWillPayAmountDetail","{\"app\":{\"appId\":\"paas\",\"timeStamp\":\"TIMESTAMP\",  \"nonce\":\"NONCE\", \"signature\":\"21aa0011472249b4292e81504f3917bd\"  },\"body\":{\"token\":\"96c5f0e5e3c52fa0fc632aaa30d4fb85\",\"objectId\":\"ZB0020151117160110354552525\"}}")'></td>
		<td><input type="button"  value="查询项目付款详情"  onclick='setbinding("/myPayment/queryPaidAmountDetail","{\"app\":{\"appId\":\"paas\",\"timeStamp\":\"TIMESTAMP\",  \"nonce\":\"NONCE\", \"signature\":\"21aa0011472249b4292e81504f3917bd\"  },\"body\":{\"token\":\"96c5f0e5e3c52fa0fc632aaa30d4fb85\",\"objectId\":\"ZB0020151117160110354552525\"}}")'></td>
		<td><input type="button"  value="项目付款"  onclick='setbinding("/myPayment/myObjectPayment","{\"app\":{\"appId\":\"paas\",\"timeStamp\":\"TIMESTAMP\",  \"nonce\":\"NONCE\", \"signature\":\"21aa0011472249b4292e81504f3917bd\"  },\"body\":{\"token\":\"96c5f0e5e3c52fa0fc632aaa30d4fb85\",\"objectId\":\"ZB0020151117160110354552525\",\"transferTime\":\"2015-10-12\",\"bankName\":\"中国银行\",\"voucherNo\":\"20150101215522\",\"amount\":100000,\"voucherFileUrl\":\"VOCHER_FILE_URL\"}}")'></td>
	</tr>
	<tr><td colspan="6">工程管理-投标人</td></tr>
	<tr>
		<td><input type="button"  value="查询我的中标项目收款情况"  onclick='setbinding("/myIncome/queryMyIncomeList","{\"app\":{\"appId\":\"paas\",\"timeStamp\":\"TIMESTAMP\",  \"nonce\":\"NONCE\", \"signature\":\"21aa0011472249b4292e81504f3917bd\"  },\"body\":{\"token\":\"96c5f0e5e3c52fa0fc632aaa30d4fb85\"}}")'></td>
		<td><input type="button"  value="查询我的中标项目收款概况"  onclick='setbinding("/myIncome/getMyIncomeOverall","{\"app\":{\"appId\":\"paas\",\"timeStamp\":\"TIMESTAMP\",  \"nonce\":\"NONCE\", \"signature\":\"21aa0011472249b4292e81504f3917bd\"  },\"body\":{\"token\":\"96c5f0e5e3c52fa0fc632aaa30d4fb85\"}}")'></td>
		<td><input type="button"  value="查询项目应收款详情"  onclick='setbinding("/myIncome/queryWillReceiveAmountDetail","{\"app\":{\"appId\":\"paas\",\"timeStamp\":\"TIMESTAMP\",  \"nonce\":\"NONCE\", \"signature\":\"21aa0011472249b4292e81504f3917bd\"  },\"body\":{\"token\":\"96c5f0e5e3c52fa0fc632aaa30d4fb85\",\"objectId\":\"ZB0020151117160110354552525\"}}")'></td>
		<td><input type="button"  value="查询项目收款详情"  onclick='setbinding("/myIncome/queryReceivedAmountDetail","{\"app\":{\"appId\":\"paas\",\"timeStamp\":\"TIMESTAMP\",  \"nonce\":\"NONCE\", \"signature\":\"21aa0011472249b4292e81504f3917bd\"  },\"body\":{\"token\":\"96c5f0e5e3c52fa0fc632aaa30d4fb85\",\"objectId\":\"ZB0020151117160110354552525\"}}")'></td>
	</tr>
	<tr><td colspan="6">会员管理</td></tr>
	<tr>
		<td><input type="button"  value="查询会员信息接口"  onclick='setbinding("/member/queryMemberInfo","{\"app\":{\"appId\":\"paas\",\"timeStamp\":\"TIMESTAMP\",  \"nonce\":\"NONCE\", \"signature\":\"21aa0011472249b4292e81504f3917bd\"  },\"body\":{\"token\":\"96c5f0e5e3c52fa0fc632aaa30d4fb85\"}}")'></td>
		<td><input type="button"  value="查询可购买会员列表接口"  onclick='setbinding("/member/queryMemberProduct","{\"app\":{\"appId\":\"paas\",\"timeStamp\":\"TIMESTAMP\",  \"nonce\":\"NONCE\", \"signature\":\"21aa0011472249b4292e81504f3917bd\"  },\"body\":{\"token\":\"96c5f0e5e3c52fa0fc632aaa30d4fb85\"}}")'></td>
		<td><input type="button"  value="购买招标方会员接口"  onclick='setbinding("/member/buyBiddeeMember","{\"app\":{\"appId\":\"paas\",\"timeStamp\":\"TIMESTAMP\",  \"nonce\":\"NONCE\", \"signature\":\"21aa0011472249b4292e81504f3917bd\"  },\"body\":{\"token\":\"96c5f0e5e3c52fa0fc632aaa30d4fb85\",\"productId\":\"BIDDEE_MEMBER_STD\"}}")'></td>
		<td><input type="button"  value="购买投标方会员接口"  onclick='setbinding("/member/buyBidderMember","{\"app\":{\"appId\":\"paas\",\"timeStamp\":\"TIMESTAMP\",  \"nonce\":\"NONCE\", \"signature\":\"21aa0011472249b4292e81504f3917bd\"  },\"body\":{\"token\":\"96c5f0e5e3c52fa0fc632aaa30d4fb85\",\"productId\":\"BIDDER_MEMBER_STD\"}}")'></td>
	</tr>
	<tr><td colspan="6">订单</td></tr>
	<tr>
		<td><input  value="支付宝网关支付通知"  onclick='setbinding("/order/payNotify","{        \"app\":{            \"appId\":\"zjhtwallet\",            \"timeStamp\":\"TIMESTAMP\",             \"nonce\":\"NONCE\",            \"signature\":\"SIGNATURE\"        },        \"body\":{           \"errcode\":0, \"errmsg\":\"支付成功\",\"orderId\":\"FN2010219392838232\",\"payTime\":\"2015-02-02 12:12:12\"        }    }")'  type="button" ></td>
	</tr>
	<tr><td colspan="6">其它</td></tr>
	<tr>
		<td><input  value="查询工程类别列表"  onclick='setbinding("/tender/getIndustryList","    {        \"app\":{            \"appId\":\"zjhtwallet\",            \"timeStamp\":\"TIMESTAMP\",             \"nonce\":\"NONCE\",            \"signature\":\"SIGNATURE\"        },                \"body\":        {          }    }")'  type="button" ></td>
		<td><input  value="查询工程类别详情"  onclick='setbinding("/tender/getIndustryDetail","    {        \"app\":{            \"appId\":\"zjhtwallet\",            \"timeStamp\":\"TIMESTAMP\",             \"nonce\":\"NONCE\",            \"signature\":\"SIGNATURE\"        },                \"body\":        {    \"industryId\":\"TSF\"      }    }")'  type="button" ></td>
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

