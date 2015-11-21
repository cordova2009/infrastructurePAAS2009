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
		<td><input  value="我的招标评标概况接口"  onclick='setbinding("/tender/queryMyObjectTenderSurvey","{        \"app\":{            \"appId\":\"zjhtwallet\",            \"timeStamp\":\"TIMESTAMP\",             \"nonce\":\"NONCE\",            \"signature\":\"SIGNATURE\"        },    \"body\":{        \"token\":\"12345\",        \"objectId\":\"32456\"    }    }")'  type="button" ></td>
		<td><input  value="查询未完成招标项目基础信息接口"  onclick='setbinding("/tender/queryObjectBaseInfo","{        \"app\":{            \"appId\":\"zjhtwallet\",            \"timeStamp\":\"TIMESTAMP\",             \"nonce\":\"NONCE\",            \"signature\":\"SIGNATURE\"        },                \"body\":        {        \"token\":\"12345\",        \"objectId\":\"BH2015082135656\"    }    }")'  type="button" ></td>
		<td><input  value="保存招标项目基础信息接口"  onclick='setbinding("/tender/saveObjectBaseInfo","    {        \"app\":{            \"appId\":\"zjhtwallet\",            \"timeStamp\":\"TIMESTAMP\",             \"nonce\":\"NONCE\",            \"signature\":\"SIGNATURE\"        },                \"body\":        {        \"token\":\"12345\",        \"objectId\":\"BH2015082135656\",        \"objectName\":\"土石购买招标\",            \"industryId\":5,            \"biddingNo\":\"23009751\",            \"objectScope\":\"招标项目范围\",            \"biddeeCompanyPrincipal\":\"张三\",            \"biddeeCompanyTelephone\":\"0755-56432117\",            \"currency\":\"CNY\",            \"contractType\":\"承包方式\",            \"evaluationAmount\":\"300000\"    }    }")'  type="button" ></td>
		<td><input  value="查询未完成招标项目工程信息接口"  onclick='setbinding("/tender/queryObjectProjectInfo","    {        \"app\":{            \"appId\":\"zjhtwallet\",            \"timeStamp\":\"TIMESTAMP\",             \"nonce\":\"NONCE\",            \"signature\":\"SIGNATURE\"        },                \"body\":{        \"token\":\"12345\",        \"objectId\":\"BH2015082135656\"     }     }")'  type="button" ></td>
		<td><input  value="保存招标项目工程信息接口"  onclick='setbinding("/tender/saveObjectProjectInfo","    {        \"app\":{            \"appId\":\"zjhtwallet\",            \"timeStamp\":\"TIMESTAMP\",             \"nonce\":\"NONCE\",            \"signature\":\"SIGNATURE\"        },                \"body\":        {        \"token\":\"12345\",        \"objectId\":\"BH2015082135656\",        \"projectName\":\"金域华府3期工程开发\",            \"projectSite\":\"工程地点\",            \"projectScale\":\"工程规模及特征\",            \"projectExpectInvestment\":\"工程计划总投资\",            \"employer\":\"建设单位\",            \"employerPrincipal\":\"建设单位经办人\",            \"employerTelephone\":\"建设单位办公电话\" }     }")'  type="button" ></td>
		<td><input  value="查询未完成招标项目工程要求接口"  onclick='setbinding("/tender/queryProjectRequirementInfo","    {        \"app\":{            \"appId\":\"zjhtwallet\",            \"timeStamp\":\"TIMESTAMP\",             \"nonce\":\"NONCE\",            \"signature\":\"SIGNATURE\"        },                \"body\":{        \"token\":\"12345\",        \"objectId\":\"BH2015082135656\"     }     }")'  type="button" ></td>
	</tr>
	<tr>
		<td><input  value="保存招标项目工程要求接口"  onclick='setbinding("/tender/saveProjectRequirementInfo","    {        \"app\":{            \"appId\":\"zjhtwallet\",            \"timeStamp\":\"TIMESTAMP\",             \"nonce\":\"NONCE\",            \"signature\":\"SIGNATURE\"        },                \"body\":        {            \"token\":\"12345\",            \"objectId\":\"BH2015082135656\",            \"projectExpectStartDate\":\"2012年8月\",            \"projectExpectPeriod\":300        }    }")'  type="button" ></td>
		<td><input  value="查询未完成招标项目工程施工证明接口"  onclick='setbinding("/tender/queryObjectConstructionInfo","    {        \"app\":{            \"appId\":\"zjhtwallet\",            \"timeStamp\":\"TIMESTAMP\",             \"nonce\":\"NONCE\",            \"signature\":\"SIGNATURE\"        },    \"body\":{        \"token\":\"12345\",        \"objectId\":\"BH2015082135656\"     }   }")'  type="button" ></td>
		<td><input  value="保存招标项目工程施工证明接口"  onclick='setbinding("/tender/saveObjectConstructionInfo","    {        \"app\":{            \"appId\":\"zjhtwallet\",            \"timeStamp\":\"TIMESTAMP\",             \"nonce\":\"NONCE\",            \"signature\":\"SIGNATURE\"        },                \"body\":        {            \"token\":\"12345\",            \"objectId\":\"BH2015082135656\",            \"constructionProveType\":\"BCP\",            \"landUseCertificateNo\":\"BH2015110100123\",            \"landUseCertificateEndDate\":\"2015-03-28\",            \"landUseCertificateUrl\":\"URL\",            \"constructionLandUsePermitNo\":\"BH2015110200564\",            \"constructionLandUsePermitEndDate\":\"2015-03-28\",            \"constructionLandUsePermitUrl\":\"URL\",            \"buildingPermitNo\":\"BH2015091800267\",            \"buildingPermitEndDate\":\"2015-03-28\",            \"buildingPermitUrl\":\"URL\",            \"letterOfAcceptanceUrl\":\"URL\",            \"buildingConstructPermitNo\":\"BH2015080400897\",            \"buildingConstructPermitEndDate\":\"2015-03-28\",            \"buildingConstructPermitUrl\":\"URL\"        }    }")'  type="button" ></td>
		<td><input  value="查询未完成招标项目资质要求接口"  onclick='setbinding("/tender/queryObjectCertificationInfo","    {        \"app\":{            \"appId\":\"zjhtwallet\",            \"timeStamp\":\"TIMESTAMP\",             \"nonce\":\"NONCE\",            \"signature\":\"SIGNATURE\"        },                \"body\":        {       \"token\":\"12345\",       \"objectId\":\"BH2015082135656\"    }    }")'  type="button" ></td>
		<td><input  value="保存招标项目资质要求接口"  onclick='setbinding("/tender/saveObjectCertificationInfo"," {\"app\":{\"appId\":\"zjhtwallet\",\"timeStamp\":\"TIMESTAMP\",\"nonce\":\"NONCE\",\"signature\":\"SIGNATURE\"},\"body\":{\"token\":\"55890\",\"objectId\":\"BH2015082135656\",\"bidderCertification\":[{\"industryId\":1,\"certificateId\":3},{\"industryId\":2,\"certificateId\":4}],\"needPmCertification\":\"YES\",\"needConstructorCertification\":\"YES\",\"needSafetyPermit\":\"YES\",\"needPmSafetyCertification\":\"YES\"}}")'  type="button" ></td>
		<td><input  value="查询未完成招标项目保证金接口"  onclick='setbinding("/tender/queryObjectBondInfo","    {        \"app\":{            \"appId\":\"zjhtwallet\",            \"timeStamp\":\"TIMESTAMP\",             \"nonce\":\"NONCE\",            \"signature\":\"SIGNATURE\"        },                \"body\":        {            \"objectId\":\"BH2015082135656\",            \"token\":\"12345\"        }    } ")'  type="button" ></td>
		<td><input  value="保存招标项目保证金接口"  onclick='setbinding("/tender/saveObjectBondInfo","    {        \"app\":{            \"appId\":\"zjhtwallet\",            \"timeStamp\":\"TIMESTAMP\",             \"nonce\":\"NONCE\",            \"signature\":\"SIGNATURE\"        },                \"body\":        {            \"objectId\":\"BH2015082135656\",            \"token\":\"12345\",            \"bidBondAmount\":50000         }     }")'  type="button" ></td>
	</tr>
	<tr>
		<td><input  value="查询未完成招标项目投标文件接口"  onclick='setbinding("/tender/queryBidFileTypeInfo","    {        \"app\":{            \"appId\":\"zjhtwallet\",            \"timeStamp\":\"TIMESTAMP\",             \"nonce\":\"NONCE\",            \"signature\":\"SIGNATURE\"        },                \"body\":        {        \"token\":\"12345\",        \"objectId\":\"BH2015082135656\"    }    }")'  type="button" ></td>
		<td><input  value="保存招标项目投标文件接口"  onclick='setbinding("/tender/saveBidFileTypeInfo","    {        \"app\":{            \"appId\":\"zjhtwallet\",            \"timeStamp\":\"TIMESTAMP\",             \"nonce\":\"NONCE\",            \"signature\":\"SIGNATURE\"        },                \"body\":        {        \"token\":\"12345\",        \"objectId\":\"BH2015082135656\" ,\"needBusinessStandard\":\"YES\",        \"needTechnicalStandard\":\"YES\",      \"needCertificationCheckupFile\":\"YES\"   }    }")'  type="button" ></td>
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
		<td><input  value="提交投标接口"  onclick='setbinding("/bid/submitBid","    {        \"app\":{            \"appId\":\"zjhtwallet\",            \"timeStamp\":\"TIMESTAMP\",             \"nonce\":\"NONCE\",            \"signature\":\"SIGNATURE\"        },                \"body\":        {        \"token\":\"12345\",        \"objectId\":\"BH2015082135656\",        \"bidId\":1        }    } ")'  type="button" ></td>				
	</tr>
	<tr>
		<td><input  value="查询招标公告列表接口"  onclick='setbinding("/bid/queryObjectList","    {        \"app\":{            \"appId\":\"zjhtwallet\",            \"timeStamp\":\"TIMESTAMP\",             \"nonce\":\"NONCE\",            \"signature\":\"SIGNATURE\"        },                \"body\":        {       \"token\":\"12345\",            \"pageSize\":10,            \"pageIndex\":1        }    } ")'  type="button" ></td>
		<td><input  value="查询标的详情接口"  onclick='setbinding("/bid/queryObjectDetail","    {        \"app\":{            \"appId\":\"zjhtwallet\",            \"timeStamp\":\"TIMESTAMP\",             \"nonce\":\"NONCE\",            \"signature\":\"SIGNATURE\"        },                \"body\":        {       \"token\":\"12345\",            \"objectId\":\"BH2015082135656\"        }    } ")'  type="button" ></td>
		<td><input  value="查询投标资质接口"  onclick='setbinding("/bid/isInvitationOfBid","    {        \"app\":{            \"appId\":\"zjhtwallet\",            \"timeStamp\":\"TIMESTAMP\",             \"nonce\":\"NONCE\",            \"signature\":\"SIGNATURE\"        },                \"body\":        {       \"token\":\"12345\" }    } ")'  type="button" ></td>
	</tr>
	<tr><td colspan="6">资金管理</td></tr>
	<tr>
		<td><input type="button"  value="查询我的资金账户概况"  onclick='setbinding("/capitalManage/queryMyCapitalSurvey","{\"app\":{\"appId\":\"paas\",\"timeStamp\":\"TIMESTAMP\",  \"nonce\":\"NONCE\", \"signature\":\"21aa0011472249b4292e81504f3917bd\"  }, \"body\":{\"token\":\"96c5f0e5e3c52fa0fc632aaa30d4fb85\"}}")'></td>
		<td><input type="button"  value="查询我的资金账户流水"  onclick='setbinding("/capitalManage/queryTransactionRecords","{\"app\":{\"appId\":\"paas\",\"timeStamp\":\"TIMESTAMP\",  \"nonce\":\"NONCE\", \"signature\":\"21aa0011472249b4292e81504f3917bd\"  }, \"body\":{\"token\":\"96c5f0e5e3c52fa0fc632aaa30d4fb85\",\"pageIndex\":0,\"pageSize\":1}}")'></td>
		<td><input type="button"  value="查询用户帐户详情"  onclick='setbinding("/capitalManage/queryProjectAccount","{\"app\":{\"appId\":\"paas\",\"timeStamp\":\"TIMESTAMP\",  \"nonce\":\"NONCE\", \"signature\":\"21aa0011472249b4292e81504f3917bd\"  }, \"body\":{\"token\":\"96c5f0e5e3c52fa0fc632aaa30d4fb85\"}}")'></td>
		<td><input type="button"  value="冻结撮合担保金"  onclick='setbinding("/capitalManage/freezeBond","{\"app\":{\"appId\":\"paas\",\"timeStamp\":\"TIMESTAMP\",  \"nonce\":\"NONCE\", \"signature\":\"21aa0011472249b4292e81504f3917bd\"  }, \"body\":{\"token\":\"96c5f0e5e3c52fa0fc632aaa30d4fb85\",\"objectId\":\"BH20150201321123\",\"remark\":\"冻结50000元施工保证金\",\"tradePassword\":\"TRADE_PASSWORD\"}}")'></td>
		<td><input type="button"  value="解冻施工保证金"  onclick='setbinding("/capitalManage/unfreezeBond","{\"app\":{\"appId\":\"paas\",\"timeStamp\":\"TIMESTAMP\",  \"nonce\":\"NONCE\", \"signature\":\"21aa0011472249b4292e81504f3917bd\"  }, \"body\":{\"token\":\"96c5f0e5e3c52fa0fc632aaa30d4fb85\",\"orderId\":\"FREEZEBOND_ORDER_ID\"}}")'></td>
		<td><input type="button"  value="充值申请"  onclick='setbinding("/capitalManage/rechargeApply","{\"app\":{\"appId\":\"paas\",\"timeStamp\":\"TIMESTAMP\",  \"nonce\":\"NONCE\", \"signature\":\"21aa0011472249b4292e81504f3917bd\"  }, \"body\":{\"token\":\"96c5f0e5e3c52fa0fc632aaa30d4fb85\",\"transferTime\":\"2015-10-12\",\"bankName\":\"中国银行\",\"voucherNo\":\"20150101215522\",\"amount\":100000,\"voucherFileUrl\":\"VOCHER_FILE_URL\"}}")'></td>
		<td><input type="button"  value="查询充值申请记录"  onclick='setbinding("/capitalManage/queryRechargeApplyList","{\"app\":{\"appId\":\"paas\",\"timeStamp\":\"TIMESTAMP\",  \"nonce\":\"NONCE\", \"signature\":\"21aa0011472249b4292e81504f3917bd\"  }, \"body\":{\"token\":\"96c5f0e5e3c52fa0fc632aaa30d4fb85\"}}")'></td>	
	</tr>
	<tr>
		<td><input type="button"  value="充值申请审核"  onclick='setbinding("/capitalManage/checkRechargeApply","{\"app\":{\"appId\":\"paas\",\"timeStamp\":\"TIMESTAMP\",  \"nonce\":\"NONCE\", \"signature\":\"21aa0011472249b4292e81504f3917bd\"},\"body\":{\"orderId\":\"ORDER_ID\",\"checkWithdrawalsNo\":\"CHECK_WITHDRAWALS_NO\",\"checkResult\":\"OK#\",\"remark\":\"完成充值申请审核，充值10000元\",\"operator\":1}}")'></td>
		<td><input type="button"  value="充值成功"  onclick='setbinding("/capitalManage/successRecharge","{\"app\":{\"appId\":\"paas\",\"timeStamp\":\"TIMESTAMP\",  \"nonce\":\"NONCE\", \"signature\":\"21aa0011472249b4292e81504f3917bd\"}, \"body\":{\"orderId\":\"ORDER_ID\",\"appOrderId\":\"审核id\",\"remark\":\"完成充值申请审核，转账10000元\"}}")'></td>
		<td><input type="button"  value="提现申请"  onclick='setbinding("/capitalManage/withdrawalsApply","{\"app\":{\"appId\":\"paas\",\"timeStamp\":\"TIMESTAMP\",  \"nonce\":\"NONCE\", \"signature\":\"21aa0011472249b4292e81504f3917bd\"}, \"body\":{\"token\":\"96c5f0e5e3c52fa0fc632aaa30d4fb85\",\"amount\":100000,\"bankId\":23,\"tradePassword\":\"TRADE_PASSWORD\"}}")'></td>
		<td><input type="button"  value="查询申请提现记录"  onclick='setbinding("/capitalManage/withdrawalsApply","{\"app\":{\"appId\":\"paas\",\"timeStamp\":\"TIMESTAMP\",  \"nonce\":\"NONCE\", \"signature\":\"21aa0011472249b4292e81504f3917bd\"}, \"body\":{\"token\":\"96c5f0e5e3c52fa0fc632aaa30d4fb85\"}}")'></td>
		<td><input type="button"  value="冻结提现"  onclick='setbinding("/capitalManage/freezeWithdrawals","{\"app\":{\"appId\":\"paas\",\"timeStamp\":\"TIMESTAMP\",  \"nonce\":\"NONCE\", \"signature\":\"21aa0011472249b4292e81504f3917bd\"},\"body\":{\"orderId\":\"ORDER_ID\",\"mobileNum\":\"13714770857\",\"tradePassword\":\"TRADE_PASSWORD\",\"peerAccountUnit\":\"中国银行\",\"peerAccountId\":\"20150101215522\",\"amount\":100000,\"remark\":\"完成提现申请审核，转账10000元\"}}")'></td>
		<td><input type="button"  value="提现成功"  onclick='setbinding("/capitalManage/successWithdrawals","{\"app\":{\"appId\":\"paas\",\"timeStamp\":\"TIMESTAMP\",  \"nonce\":\"NONCE\", \"signature\":\"21aa0011472249b4292e81504f3917bd\"},\"body\":{\"orderId\":\"ORDER_ID\",\"appOrderId\":\"审核id\",\"remark\":\"完成提现申请审核，转账10000元\"}}")'></td>
	</tr>
	<tr>
		<td><input type="button"  value="提现失败"  onclick='setbinding("/capitalManage/failWithdrawals","{\"app\":{\"appId\":\"paas\",\"timeStamp\":\"TIMESTAMP\",  \"nonce\":\"NONCE\", \"signature\":\"21aa0011472249b4292e81504f3917bd\"},\"body\":{\"orderId\":\"ORDER_ID\",\"appOrderId\":\"审核id\",\"remark\":\"完成提现申请审核，转账10000元\"}}")'></td>
	</tr>
	<tr><td colspan="6">用户管理</td></tr>
	<tr>
		<td><input type="button"  value="注册"  onclick='setbinding("/userCenter/register","{\"app\":{\"appId\":\"paas\",\"timeStamp\":\"TIMESTAMP\",  \"nonce\":\"NONCE\", \"signature\":\"21aa0011472249b4292e81504f3917bd\"  },  \"body\":{\"smsCode\":\"9009\",\"nickname\":\"doudou\",\"mobileNum\":\"13714770857\",\"realName\":\"刘豆\",\"cardID\":\"420923199210180488\",\"loginPassword\":\"zYlLxP58G81a8kP8eDZyJi2LvnDxT2ewjox90v4hscP+uVm31GQvyw==\",\"tradePassword\":\"zYlLxP58G81a8kP8eDZyJi2LvnDxT2ewjox90v4hscP+uVm31GQvyw==\"}}")'></td>
		<td><input type="button"  value="用户登录"  onclick='setbinding("/userCenter/login","{\"app\":{\"appId\":\"paas\",\"timeStamp\":\"TIMESTAMP\",  \"nonce\":\"NONCE\", \"signature\":\"21aa0011472249b4292e81504f3917bd\"  },\"body\":{\"mobileNum\":\"13692228034\",\"loginPassword\":\"LOGIN_PASSWORD\"}}")'></td>
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
	<tr><td colspan="6">工程管理-招标人</td></tr>
	<tr>
		<td><input type="button"  value="查询我的招标项目付款情况"  onclick='setbinding("/myPayment/queryMyPaymentList","{\"app\":{\"appId\":\"paas\",\"timeStamp\":\"TIMESTAMP\",  \"nonce\":\"NONCE\", \"signature\":\"21aa0011472249b4292e81504f3917bd\"  },\"body\":{\"token\":\"96c5f0e5e3c52fa0fc632aaa30d4fb85\"}}")'></td>
		<td><input type="button"  value="查询我的招标项目付款概况"  onclick='setbinding("/myPayment/getMyPaymentOverall","{\"app\":{\"appId\":\"paas\",\"timeStamp\":\"TIMESTAMP\",  \"nonce\":\"NONCE\", \"signature\":\"21aa0011472249b4292e81504f3917bd\"  },\"body\":{\"token\":\"96c5f0e5e3c52fa0fc632aaa30d4fb85\"}}")'></td>
		<td><input type="button"  value="查询项目应付款详情"  onclick='setbinding("/myPayment/queryWillPayAmountDetail","{\"app\":{\"appId\":\"paas\",\"timeStamp\":\"TIMESTAMP\",  \"nonce\":\"NONCE\", \"signature\":\"21aa0011472249b4292e81504f3917bd\"  },\"body\":{\"token\":\"96c5f0e5e3c52fa0fc632aaa30d4fb85\",\"objectId\":\"ZB0020151117160110354552525\"}}")'></td>
		<td><input type="button"  value="查询项目付款详情"  onclick='setbinding("/myPayment/queryPaidAmountDetail","{\"app\":{\"appId\":\"paas\",\"timeStamp\":\"TIMESTAMP\",  \"nonce\":\"NONCE\", \"signature\":\"21aa0011472249b4292e81504f3917bd\"  },\"body\":{\"token\":\"96c5f0e5e3c52fa0fc632aaa30d4fb85\",\"objectId\":\"ZB0020151117160110354552525\"}}")'></td>
	</tr>
	<tr><td colspan="6">工程管理-投标人</td></tr>
	<tr>
		<td><input type="button"  value="查询我的中标项目收款情况"  onclick='setbinding("/myIncome/queryMyIncomeList","{\"app\":{\"appId\":\"paas\",\"timeStamp\":\"TIMESTAMP\",  \"nonce\":\"NONCE\", \"signature\":\"21aa0011472249b4292e81504f3917bd\"  },\"body\":{\"token\":\"96c5f0e5e3c52fa0fc632aaa30d4fb85\"}}")'></td>
		<td><input type="button"  value="查询我的中标项目收款概况"  onclick='setbinding("/myIncome/getMyIncomeOverall","{\"app\":{\"appId\":\"paas\",\"timeStamp\":\"TIMESTAMP\",  \"nonce\":\"NONCE\", \"signature\":\"21aa0011472249b4292e81504f3917bd\"  },\"body\":{\"token\":\"96c5f0e5e3c52fa0fc632aaa30d4fb85\"}}")'></td>
		<td><input type="button"  value="查询项目应收款详情"  onclick='setbinding("/myIncome/queryWillReceiveAmountDetail","{\"app\":{\"appId\":\"paas\",\"timeStamp\":\"TIMESTAMP\",  \"nonce\":\"NONCE\", \"signature\":\"21aa0011472249b4292e81504f3917bd\"  },\"body\":{\"token\":\"96c5f0e5e3c52fa0fc632aaa30d4fb85\",\"objectId\":\"ZB0020151117160110354552525\"}}")'></td>
		<td><input type="button"  value="查询项目收款详情"  onclick='setbinding("/myIncome/queryReceivedAmountDetail","{\"app\":{\"appId\":\"paas\",\"timeStamp\":\"TIMESTAMP\",  \"nonce\":\"NONCE\", \"signature\":\"21aa0011472249b4292e81504f3917bd\"  },\"body\":{\"token\":\"96c5f0e5e3c52fa0fc632aaa30d4fb85\",\"objectId\":\"ZB0020151117160110354552525\"}}")'></td>
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

