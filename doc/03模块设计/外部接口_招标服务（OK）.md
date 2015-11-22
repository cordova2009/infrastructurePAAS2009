#目的

本文档用于指导招标人服务（tender）编码实现。

#接口


##我的招标评标概况接口

本接口用于查询我的招标评标概况列表

http请求方式: post

    http://ip:port/gw/tender/queryMyObjectTenderSurvey


POST数据格式：JSON

    {
        "app":{
            "appId":"zjhtwallet",
            "timeStamp":"TIMESTAMP", 
            "nonce":"NONCE",
            "signature":"SIGNATURE"
        },
    	"body":{
    	    "token":"4356576",
    	    "objectId":"32456"
	    }
    } 


参数|是否必须|说明
----|----|-----
token|是|用户令牌
objectId|是|招标项目内部编号

2）返回说明

正常时的返回JSON数据包示例：
 
    {
        "errcode":0,"errmsg":"查询我的招标投标概况成功！",
        "survey":{
        	"bidderNum":6,
        	"objectName":"标的名称",
            "maxBidAmount":"2300000",
            "minBidAmount":"2000000"
        }
    }


错误时的JSON数据包示例：

    {
        "errcode":10000,"errmsg":查询我的招标投标列表失败，其他错误！"
    }


参数|是否必须|说明
----|----|-----
tenderNum|是|参与投标数量
objectName|是|标的名称
maxBidAmount|是|最高投标金额
minBidAmount|是|最低投标金额


##定标接口

本接口用于招标项目定标。

http请求方式: post

    http://ip:port/gw/tender/bidEvaluation


POST数据格式：JSON

    {
        "app":{
            "appId":"zjhtwallet",
            "timeStamp":"TIMESTAMP", 
            "nonce":"NONCE",
            "signature":"SIGNATURE"
        },
        "body":{
            "token":"4356576",
            "objectId":"BH201302140056",
            "winBidId":"BH23108721334",
            "paymentInfo":{
                "payType":"CUM",
                "payPeriod":12
                "payList":[{"period":1,"payDate":"2015-06-12","paySum":50000}]
            }
        }
    } 


参数|是否必须|说明
----|----|-----
token|是|用户令牌
objectId|是|招标项目内部编号
payType|是|付款方式，ONE，一次性。MON，按月。PID，按期。CUM，自定义。
payPeriod|是|付款总期数
payList.period|是|付款期数
payList.payDate|是|付款日期
payList.paySum|是|付款金额

2）返回说明

正常时的返回JSON数据包示例：
 
    {
        "errcode":0,"errmsg":"定标成功！"
    }


错误时的JSON数据包示例：

    {
        "errcode":10000,"errmsg":"定标失败，其他错误！"
    }


参数|是否必须|说明
----|----|-----
tenderNum|是|参与投标数量
objectName|是|标的名称
maxBidAmount|是|最高投标金额
minBidAmount|是|最低投标金额


##我的招标项目投标列表接口

查询工程投标列表

http请求方式: post

    http://ip:port/if/tender/queryMyObjectBidList


POST数据格式：JSON

    {
        "app":{
            "appId":"zjhtwallet",
            "timeStamp":"TIMESTAMP", 
            "nonce":"NONCE",
            "signature":"SIGNATURE"
        },
        "body":{
            "token":"45235678",
            "pageSize":3,
            "pageIndex":5,
            "objectId":"BH201322132456"
        }
    } 


参数|是否必须|说明
----|----|-----
token|是|用户令牌
objectId|是|招标项目内部编号

2）返回说明

正常时的返回JSON数据包示例：
 
    {
        "errcode":0,"errmsg":"查询我的招标投标列表接口成功！",
        "list":[{
            "bidId":"4535264477",
            "bidderCompanyName":"蜂鸟娱乐",
            "bidderId":"4536789",
            "bidTime":"2015-06-25 11:35:23",
            "bidAmount":5000000,
            "projectExpectStartDate":"2015-06-12",
            "projectExpectPeriod":300
            "fileUrl":"URL",
            "certificationList":[{
                "certificationId":1,
                "certificationName":"一级建造师"
            }]
        }]
    }


错误时的JSON数据包示例：

    {"errcode":10000,"errmsg":查询我的招标投标列表接口失败，其他错误！"}


参数|是否必须|说明
----|----|-----
bidId|是|投标记录编号
biderCompany|是|投标公司
biderId|是|投标人编号
bidDate|是|投标日期
objectOffer|是|投标金额
fileUrl|是|投标文件下载地址
projectExpectStartDate|是|计划开工日期
projectExpectPeriod|是|标准工期
certificationId|是|证书编号
certificationName|是|证书名称


##查询投标人评价概况接口

查询投标公司被评价概况接口


http请求方式: post

前置条件：用户必须先登录，

    http://ip:port/gw/bid/queryTendererEvaluate


POST数据格式：JSON

    {
        "app":{
            "appId":"zjhtwallet",
            "timeStamp":"TIMESTAMP", 
            "nonce":"NONCE",
            "signature":"SIGNATURE"
        }
        "body":{
            "token":"345df324"
            "objectId":"BH2345464356"
        }
    } 


参数|是否必须|说明
----|----|-----
appId|是|应用ID
timestamp|是|时间戳
nonce|是|随机数
signature|是|签名值,MD5(按值的字典顺序排列组合成字符串(appId,appKey,app.nonce,app.timeStamp))
objectId|是|招标项目内部编号
token|是|用户令牌

2）返回说明

正常时的返回JSON数据包示例：
 
    {
        "errcode":0,"errmsg":"查询招标单位评价概况成功",
        "evaluateInfo":{
            "bidderId":5,
            "bidderCompanyName":"蜂鸟娱乐",
            "objectId":"BH2015029371",
            "objectName":"万科金域华府2期开发",
            "winBidAmount":"50000",
            "companyEvaluateScore":7,
            "companyEvaluateNum":8,
            "tag":[{
                "tagName":"质量好啊","tagNum":3
            },{
                "tagName":"速度很快","tagNum":4
            }]
        }
    }


错误时的JSON数据包示例：

    {
        "errcode":10000,"errmsg":"查询招标单位评价概况失败，其它错误"
    }


参数|是否必须|说明
----|----|-----
biderId|是|中标单位编号
biderName|是|中标单位名称
objectId|是|招标项目内部编号
objectName|是|标的名称
winBidAmount|是|中标金额
companyEvaluateScore|是|公司评价分数
companyEvaluateNum|是|公司被评价次数
tag.tagName|是|标签名称
tag.tagNum|是|标签数量


##招标方给投标方评价接口

招投标完成后,招标方给投标方打分和评价

1）请求说明

http请求方式: post

    http://ip:port/gw/tender/evaluateBidder


POST数据格式：JSON

    {
        "app":{
            "appId":"zjhtwallet",
            "timeStamp":"TIMESTAMP", 
            "nonce":"NONCE",
            "signature":"SIGNATURE"
        },        
        "body":
        {
            "token":"4543gjh7h99",
            "objectId":"BH2015090887",
            "evaluateScore":7,
            "tags":["速度够快","质量很高"],
            "evaluateContent":"合作愉快，期待下次继续！"
        }
    } 


参数|是否必须|说明
----|----|-----
token|是|用户令牌 
objectId|是|招标项目内部编号
evaluateScore|是|评价分数
tags|是|评价标签
evaluateContent|是|评价内容


2）返回说明

正常时的返回JSON数据包示例：
 
    {
        "errcode":0,"errmsg":"评价成功"
    }


错误时的JSON数据包示例：

    {
        "errcode":10000,"errmsg":"评价失败，请重新再试！"
    }


##查询招标资质接口

本接口用来查询已经登录用户是否具有招标的资质。


前置条件：用户必须先登录，

    http://ip:port/gw/tender/isInvitationOfTender


POST数据格式：JSON

    {
        "app":{
            "appId":"zjhtwallet",
            "timeStamp":"TIMESTAMP", 
            "nonce":"NONCE",
            "signature":"SIGNATURE"
        },
        "body":
        {
            "token":"3w3454"
        }

    } 


参数|是否必须|说明
----|----|-----
appId|是|应用ID
timestamp|是|时间戳
nonce|是|随机数
signature|是|签名值,MD5(按值的字典顺序排列组合成字符串(appId,appKey,app.nonce,app.timeStamp))
token|是|用户令牌


2）返回说明

正常时的返回JSON数据包示例：
 
    {
        "errcode":0,"errmsg":"查询用户招标资质成功"
    }

错误时的JSON数据包示例：

    {
        "errcode":10001,"errmsg":"查询用户招标资质失败，其它错误"
    }


3）实现说明

检查是否认证过招标方;检查是否为会员;非会员的时候，检查是否发布过一次标的。


##查询未完成招标项目基础信息接口

本接口用来查询未完成的招标项目基础信息。


http请求方式: post

前置条件：用户必须先登录，用户有招标的权限

    http://ip:port/gw/tender/queryObjectBaseInfo


POST数据格式：JSON

    {
        "app":{
            "appId":"zjhtwallet",
            "timeStamp":"TIMESTAMP", 
            "nonce":"NONCE",
            "signature":"SIGNATURE"
        },        
        "body":
        {
    	    "token":"32456",
    	    "objectId":"BH2015082135656"
	    }
    }

参数|是否必须|说明
----|----|-----
appId|是|应用ID
timestamp|是|时间戳
nonce|是|随机数
signature|是|签名值,MD5(按值的字典顺序排列组合成字符串(appId,appKey,app.nonce,app.timeStamp))
token|是|用户令牌
objectId|是|token|是|用户令牌
招标项目内部编号


2）返回说明

正常时的返回JSON数据包示例：
 
    {
        "errcode":0,"errmsg":"查询未完成招标基础信息成功",
    	"baseInfo":{
    		"objectName":"土石购买招标",
            "biddingNo":"23009751",
            "objectScope":"招标项目范围",
            "biddeeCompanyPrincipal":"张三",
            "biddeeCompanyTelephone":"0755-56432117",
            "currency":"采用币种",
    		"contractType":"承包方式",
            "evaluationAmount":"300000"
    	}
    }

错误时的JSON数据包示例：

    {
        "errcode":10000,"errmsg":"查询未完成招标项目基础信息失败，其它错误"
    }

参数|是否必须|说明
----|----|-----
objectName|是|招标项目名称
biddingNo|是|招标项目编号
objectScope|是|招标项目范围
biddeeCompanyPrincipal|是|招标经办人
biddeeCompanyTelephone|招标办公电话
currency|是|采用币种
contractType|是|承包方式
evaluationAmount|是|工程标的估价

##保存招标项目基础信息接口

本接口用于保存招标时的项目基本信息。


http请求方式: post

前置条件：用户必须先登录，用户有招标的权限

    http://ip:port/gw/tender/saveObjectBaseInfo


POST数据格式：JSON

    {
        "app":{
            "appId":"zjhtwallet",
            "timeStamp":"TIMESTAMP", 
            "nonce":"NONCE",
            "signature":"SIGNATURE"
        },        
        "body":
        {
    	    "token":"435647",
    	    "objectId":"BH2015082135656",
    	    "objectName":"土石购买招标",
            "industryId":5,
            "biddingNo":"23009751",
            "objectScope":"招标项目范围",
            "biddeeCompanyPrincipal":"张三",
            "biddeeCompanyTelephone":"0755-56432117",
            "currency":"采用币种",
            "contractType":"承包方式",
            "evaluationAmount":"300000"
            
	    }
    }

参数|是否必须|说明
----|----|-----
appId|是|应用ID
timestamp|是|时间戳
nonce|是|随机数
signature|是|签名值,MD5(按值的字典顺序排列组合成字符串(appId,appKey,app.nonce,app.timeStamp))
token|是|用户令牌
objectId|是|招标项目名称
objectName|是|招标项目名称
industryId|是|工程类别编号
biddingNo|是|招标项目编号
objectScope|是|招标项目范围
biddeeCompanyPrincipal|是|招标经办人
biddeeCompanyTelephone|招标办公电话
currency|是|采用币种
contractType|是|承包方式
evaluationAmount|是|工程标的估价

2）返回说明

正常时的返回JSON数据包示例：
 
    {
        "errcode":0,"errmsg":"保存招标基础信息成功","objectId":"BH2015082135656"
    }

错误时的JSON数据包示例：

    {
        "errcode":10000,"errmsg":"保存招标基础信息失败，其它错误"
    }

参数|是否必须|说明
----|----|-----
objectId|是|招标项目内部编号


##查询未完成招标项目工程信息接口

本接口用于查询未完成招标项目的工程信息。


http请求方式: post

前置条件：用户必须先登录，用户有招标的权限

    http://ip:port/gw/tender/queryObjectProjectInfo


POST数据格式：JSON

    {
        "app":{
            "appId":"zjhtwallet",
            "timeStamp":"TIMESTAMP", 
            "nonce":"NONCE",
            "signature":"SIGNATURE"
        },        
        "body":{
    	    "token":"87875dfs542",
    	    "objectId":"BH2015082135656"
    	 }
     }

参数|是否必须|说明
----|----|-----
appId|是|应用ID
timestamp|是|时间戳
nonce|是|随机数
signature|是|签名值,MD5(按值的字典顺序排列组合成字符串(appId,appKey,app.nonce,app.timeStamp))
token|是|用户令牌
objectId|是|招标项目内部编号


2）返回说明

正常时的返回JSON数据包示例：
 
    {
        "errcode":0,"errmsg":"查询未完成招标项目工程信息成功",
    	"projectInfo":{
            
    		"projectName":"金域华府3期工程开发",
    		"projectSite":"深圳市龙岗区杨美",
            "projectScale":"工程规模及特征",
            "projectExpectInvestment":"300万",
            "employer":"XX建设单位",
            "employerPrincipal":"张三",
            "employerTelephone":"0755-06978654"
    	}

    }

错误时的JSON数据包示例：

    {
        "errcode":10000,"errmsg":"查询未完成招标项目工程信息失败，其它错误"
    }

参数|是否必须|说明
----|----|-----
projectName|是|工程名称
projectSite|是|工程地点
projectScale|是|工程规模及特征
projectExpectInvestment|否|工程计划总投资
employer|否|建设单位
employerPrincipal|否|建设单位经办人
employerTelephone|否|建设单位联系电话

##保存招标项目工程信息接口

本接口用于保存招标时的工程信息。


http请求方式: post

前置条件：用户必须先登录，用户有招标的权限

    http://ip:port/gw/tender/saveObjectProjectInfo


POST数据格式：JSON

    {
        "app":{
            "appId":"zjhtwallet",
            "timeStamp":"TIMESTAMP", 
            "nonce":"NONCE",
            "signature":"SIGNATURE"
        },        
        "body":
        {
    	    "token":"45678u5",
    	    "objectId":"BH2015082135656",
    	    "projectName":"金域华府3期工程开发",
            "projectSite":"工程地点",
            "projectScale":"工程规模及特征",
            "projectExpectInvestment":"工程计划总投资",
            "employer":"建设单位",
            "employerPrincipal":"建设单位经办人",
            "employerTelephone":"建设单位办公电话"
	 }
     }

参数|是否必须|说明
----|----|-----
appId|是|应用ID
timestamp|是|时间戳
nonce|是|随机数
signature|是|签名值,MD5(按值的字典顺序排列组合成字符串(appId,appKey,app.nonce,app.timeStamp))
token|是|用户令牌
objectId|是|招标项目内部编号
projectName|是|工程名称
projectSite|是|工程地点
projectScale|是|工程规模及特征
projectExpectInvestment|否|工程计划总投资
employer|否|建设单位
employerPrincipal|否|建设单位经办人
employerTelephone|否|建设单位联系电话


2）返回说明

正常时的返回JSON数据包示例：
 
    {
        "errcode":0,"errmsg":"保存招标项目工程信息成功"
    }

错误时的JSON数据包示例：

    {
        "errcode":10000,"errmsg":"保存招标项目工程信息失败，其它错误"
    }


##查询未完成招标项目工程施工证明接口

本接口用于查询未完成招标项目的工程施工证明信息。


http请求方式: post

前置条件：用户必须先登录，用户有招标的权限

    http://ip:port/gw/tender/queryObjectConstructionInfo


POST数据格式：JSON

    {
        "app":{
            "appId":"zjhtwallet",
            "timeStamp":"TIMESTAMP", 
            "nonce":"NONCE",
            "signature":"SIGNATURE"
        },        
        "body":{
            "token":"87875dfs542",
            "objectId":"BH2015082135656"
         }
     }

参数|是否必须|说明
----|----|-----
appId|是|应用ID
timestamp|是|时间戳
nonce|是|随机数
signature|是|签名值,MD5(按值的字典顺序排列组合成字符串(appId,appKey,app.nonce,app.timeStamp))
token|是|用户令牌
objectId|是|招标项目内部编号


2）返回说明

正常时的返回JSON数据包示例：
 
    {
        "errcode":0,"errmsg":"查询未完成招标项目工程施工证明成功",
        "ConstructionInfo":{
            "constructionProveType":"施工证明类型",
            "landUseCertificateNo":"BH2015110100123",
            "landUseCertificateEndDate":"2015-03-28",
            "landUseCertificateUrl":"URL",
            "constructionLandUsePermitNo":"BH2015110200564",
            "constructionLandUsePermitEndDate":"2015-03-28",
            "constructionLandUsePermitUrl":"URL",
            "buildingPermitNo":"BH2015091800267",
            "buildingPermitEndDate":"2015-03-28",
            "buildingPermitUrl":"URL",
            "letterOfAcceptanceUrl":"URL",
            "buildingConstructPermitNo":"BH2015080400897",
            "buildingConstructPermitEndDate":"2015-03-28",
            "buildingConstructPermitUrl":"URL"
        }

    }

错误时的JSON数据包示例：

    {
        "errcode":10000,"errmsg":"查询未完成招标项目工程施工证明失败，其它错误"
    }

参数|是否必须|说明
----|----|-----
constructionProveType|是|施工证明类型,BCP 有施工许可,KFS开发商(必须有国有地址使用证), ZCB 总承包(必须带有中标通知书,国有地址使用证)
landUseCertificateNo|否|国有土地使用证编号
landUseCertificateEndDate|否|国有土地使用证有效期
landUseCertificateUrl|否|国有土地使用证上传地址
constructionLandUsePermitNo|否|建设用地规划许可证编号
constructionLandUsePermitEndDate|否|建设用地规划许可证有效期
constructionLandUsePermitUrl|否|建设用地规划许可证上传地址
buildingPermitNo|否|建设工程规划许可证编号
buildingPermitEndDate|否|建设工程规划许可证有效期
buildingPermitUrl|否|建设工程规划许可证上传地址
letterOfAcceptanceUrl|否|中标通知书上传地址
buildingConstructPermitNo|否|建设工程施工许可证编号
buildingConstructPermitEndDate|否|建设工程施工许可证有效期
buildingConstructPermitUrl|否|建设工程施工许可证上传地址

##保存招标项目工程施工证明接口

本接口用于保存招标时的工程施工证明信息。


http请求方式: post

前置条件：用户必须先登录，用户有招标的权限

    http://ip:port/gw/tender/saveObjectConstructionInfo


POST数据格式：JSON

    {
        "app":{
            "appId":"zjhtwallet",
            "timeStamp":"TIMESTAMP", 
            "nonce":"NONCE",
            "signature":"SIGNATURE"
        },        
        "body":
        {
            "token":"45678u5",
            "objectId":"BH2015082135656",
            "constructionProveType":"施工证明类型",
            "landUseCertificateNo":"BH2015110100123",
            "landUseCertificateEndDate":"2015-03-28",
            "landUseCertificateUrl":"URL",
            "constructionLandUsePermitNo":"BH2015110200564",
            "constructionLandUsePermitEndDate":"2015-03-28",
            "constructionLandUsePermitUrl":"URL",
            "buildingPermitNo":"BH2015091800267",
            "buildingPermitEndDate":"2015-03-28",
            "buildingPermitUrl":"URL",
            "letterOfAcceptanceUrl":"URL",
            "buildingConstructPermitNo":"BH2015080400897",
            "buildingConstructPermitEndDate":"2015-03-28",
            "buildingConstructPermitUrl":"URL"
        }
    }

参数|是否必须|说明
----|----|-----
appId|是|应用ID
timestamp|是|时间戳
nonce|是|随机数
signature|是|签名值,MD5(按值的字典顺序排列组合成字符串(appId,appKey,app.nonce,app.timeStamp))
token|是|用户令牌
objectId|是|招标项目内部编号
constructionProveType|是|施工证明类型
landUseCertificateNo|否|国有土地使用证编号
landUseCertificateEndDate|否|国有土地使用证有效期
landUseCertificateUrl|否|国有土地使用证上传地址
constructionLandUsePermitNo|否|建设用地规划许可证编号
constructionLandUsePermitEndDate|否|建设用地规划许可证有效期
constructionLandUsePermitUrl|否|建设用地规划许可证上传地址
buildingPermitNo|否|建设工程规划许可证编号
buildingPermitEndDate|否|建设工程规划许可证有效期
buildingPermitPicUrl|否|建设工程规划许可证上传地址
letterOfAcceptanceUrl|否|中标通知书上传地址
buildingConstructPermitNo|否|建设工程施工许可证编号
buildingConstructPermitEndDate|否|建设工程施工许可证有效期
buildingConstructPermitUrl|否|建设工程施工许可证上传地址


2）返回说明

正常时的返回JSON数据包示例：
 
    {
        "errcode":0,"errmsg":"保存招标项目工程施工证明成功"
    }

错误时的JSON数据包示例：

    {
        "errcode":10000,"errmsg":"保存招标项目工程施工证明失败，其它错误"
    }


##查询未完成招标项目工程要求接口

本接口用于查询未完成招标项目的工程要求信息。


http请求方式: post

前置条件：用户必须先登录，用户有招标的权限

    http://ip:port/gw/tender/queryProjectRequirementInfo


POST数据格式：JSON

    {
        "app":{
            "appId":"zjhtwallet",
            "timeStamp":"TIMESTAMP", 
            "nonce":"NONCE",
            "signature":"SIGNATURE"
        },        
        "body":{
            "token":"87875dfs542",
            "objectId":"BH2015082135656"
         }
     }

参数|是否必须|说明
----|----|-----
appId|是|应用ID
timestamp|是|时间戳
nonce|是|随机数
signature|是|签名值,MD5(按值的字典顺序排列组合成字符串(appId,appKey,app.nonce,app.timeStamp))
token|是|用户令牌
objectId|是|招标项目内部编号


2）返回说明

正常时的返回JSON数据包示例：
 
    {
        "errcode":0,"errmsg":"查询未完成招标项目工程要求成功",
        "requirementInfo":{
            "projectExpectStartDate":"2015-12-30",
            "projectExpectPeriod":300
        }

    }

错误时的JSON数据包示例：

    {
        "errcode":10000,"errmsg":"查询未完成招标项目工程要求失败，其它错误"
    }

参数|是否必须|说明
----|----|-----
projectExpectStartDate|是|计划开工日期
projectExpectPeriod|是|标准工期

##保存招标项目工程施工证明接口

本接口用于保存招标时的工程施工证明信息。


http请求方式: post

前置条件：用户必须先登录，用户有招标的权限

    http://ip:port/gw/tender/saveProjectRequirementInfo


POST数据格式：JSON

    {
        "app":{
            "appId":"zjhtwallet",
            "timeStamp":"TIMESTAMP", 
            "nonce":"NONCE",
            "signature":"SIGNATURE"
        },        
        "body":
        {
            "token":"45678u5",
            "objectId":"BH2015082135656",
            "projectExpectStartDate":"计划开工日期",
            "projectExpectPeriod":300
        }
    }

参数|是否必须|说明
----|----|-----
appId|是|应用ID
timestamp|是|时间戳
nonce|是|随机数
signature|是|签名值,MD5(按值的字典顺序排列组合成字符串(appId,appKey,app.nonce,app.timeStamp))
token|是|用户令牌
objectId|是|招标项目内部编号
projectExpectStartDate|是|计划开工日期
projectExpectPeriod|是|标准工期


2）返回说明

正常时的返回JSON数据包示例：
 
    {
        "errcode":0,"errmsg":"保存招标项目工程施工证明成功"
    }

错误时的JSON数据包示例：

    {
        "errcode":10000,"errmsg":"保存招标项目工程施工证明失败，其它错误"
    }



##查询资质证书类型列表接口

本接口查询系统中所有的资质证书类型。


http请求方式: post

前置条件：无

    http://ip:port/gw/tender/queryCertificateList


POST数据格式：JSON

    {
        "app":{
            "appId":"zjhtwallet",
            "timeStamp":"TIMESTAMP", 
            "nonce":"NONCE",
            "signature":"SIGNATURE"
        },
	"body":{
		
	}
    }

参数|是否必须|说明
----|----|-----
appId|是|应用ID
timestamp|是|时间戳
nonce|是|随机数
signature|是|签名值,MD5(按值的字典顺序排列组合成字符串(appId,appKey,app.nonce,app.timeStamp))



2）返回说明

正常时的返回JSON数据包示例：
 
    {
        "errcode":0,"errmsg":"查询证书列表成功",
    	"list":[{
    	    "industryId":5,
    	    "industryName":"土石方",
            "certificateList":[{
                "certificateId":1,
                "certificateName":"一级建造师"
            },{
                "certificateId":2,
                "certificateName":"二级建造师"
            }]
    	}]
    }

错误时的JSON数据包示例：

    {
        "errcode":10000,"errmsg":"查询证书列表失败，其它错误"
    }

参数|是否必须|说明
----|----|-----
industryId|是|工程类别编号
industryName|是|工程类别名称
certificateId|是|证书编号
certificateName|是|证书名称（包含级别）

##查询未完成招标项目资质要求接口

本接口用于查询未完成招标项目资质要求信息。


http请求方式: post

前置条件：用户必须先登录，用户有招标的权限

    http://ip:port/gw/tender/queryObjectCertificationInfo


POST数据格式：JSON

    {
        "app":{
            "appId":"zjhtwallet",
            "timeStamp":"TIMESTAMP", 
            "nonce":"NONCE",
            "signature":"SIGNATURE"
        },        
        "body":
        {
	       "token":"erwet5",
	       "objectId":"BH20151102035656"
	    }
    }

参数|是否必须|说明
----|----|-----
appId|是|应用ID
timestamp|是|时间戳
nonce|是|随机数
signature|是|签名值,MD5(按值的字典顺序排列组合成字符串(appId,appKey,app.nonce,app.timeStamp))
token|是|用户令牌
objectId|是|招标项目内部编号


2）返回说明

正常时的返回JSON数据包示例：
 
    {
        "errcode":0,"errmsg":"查询未完成招标项目资质要求成功",
    	"certificationInfo":{
    		"bidderCertification":[{
                "certificateId":1,
                "certificateName":"一级建造师",
		"industryId":1
            },{
                "certificateId":2,
                "certificateName":"二级建造师",
		"industryId":2
            }],
    		"needPmCertification":"YES",
            "needConstructorCertification":"YES",
            "needSafetyPermit":"YES",
            "needPmSafetyCertification":"YES"
    	}
    }

错误时的JSON数据包示例：

    {
        "errcode":10000,"errmsg":"查询未完成招标项目资质要求失败，其它错误"
    }

参数|是否必须|说明
----|----|-----
industryId|是|工程类别编号
industryName|是|工程类别名称
certificateId|是|证书编号
certificateName|是|证书名称（包含级别）
needPmCertification|否|需要投标人项目经理,YES,是.NO#,否
needConstructorCertification|否|需要投标人建造师.YES,是，NO#,否
needSafetyPermit|否|需要安全生产许可证,YES,是.NO#,否
needPmSafetyCertification|否|需要项目经理安全生产考核合格证.YES,是.NO#,否


##保存招标项目资质要求接口

本接口用于保存招标项目资质要求信息。


http请求方式: post

前置条件：用户必须先登录，用户有招标的权限

    http://ip:port/gw/tender/saveObjectCertificationInfo


POST数据格式：JSON

    {
        "app":{
            "appId":"zjhtwallet",
            "timeStamp":"TIMESTAMP", 
            "nonce":"NONCE",
            "signature":"SIGNATURE"
        },        
        "body":
        {
	        "token":"55890",
	        "objectId":"BH2015082135656",
	        "bidderCertification":[{
                "industryId":1,"certificateId":3
            },{
                "industryId":2,"certificateId":4
            }],
            "needPmCertification":"YES",
            "needConstructorCertification":"YES",
            "needSafetyPermit":"YES",
            "needPmSafetyCertification":"YES"
	    }
    }

参数|是否必须|说明
----|----|-----
appId|是|应用ID
timestamp|是|时间戳
nonce|是|随机数
signature|是|签名值,MD5(按值的字典顺序排列组合成字符串(appId,appKey,app.nonce,app.timeStamp))
token|是|用户令牌
token|是|用户令牌
objectId|是|招标项目内部编号
industryId|是|工程类别编号
certificateId|是|证书编号
needPmCertification|否|需要投标人项目经理,YES,是.NO#,否
needConstructorCertification|否|需要投标人建造师.YES,是，NO#,否
needSafetyPermit|否|需要安全生产许可证,YES,是.NO#,否
needPmSafetyCertification|否|需要项目经理安全生产考核合格证.YES,是.NO#,否


2）返回说明

正常时的返回JSON数据包示例：
 
    {
        "errcode":0,"errmsg":"保存招标项目资质要求成功"
    }

错误时的JSON数据包示例：

    {
        "errcode":10000,"errmsg":"保存招标项目资质要求失败，其它错误"
    }


##查询未完成招标项目保证金接口

本接口用于查询未完成招标的项目保证金信息。

1）请求说明

http请求方式: post

前置条件：用户先调用保存招标信息接口

    http://ip:port/gw/tender/queryObjectBondInfo


POST数据格式：JSON

    {
        "app":{
            "appId":"zjhtwallet",
            "timeStamp":"TIMESTAMP", 
            "nonce":"NONCE",
            "signature":"SIGNATURE"
        },        
        "body":
        {
            "objectId":"BH2015082135656",
            "token":"56435475"
        }
    } 


参数|是否必须|说明
----|----|-----
appId|是|应用ID
timestamp|是|时间戳
nonce|是|随机数
signature|是|签名值,MD5(按值的字典顺序排列组合成字符串(appId,appKey,app.nonce,app.timeStamp))
token|是|用户令牌
token|是|用户令牌
objectId|是|招标项目内部编号

2）返回说明

正常时的返回JSON数据包示例：
 
    {
        "errcode":0,"errmsg":"查询未完成招标项目保证金成功",
        "bondInfo":{
            "bidBondAmount":"50000"
        }
    }


错误时的JSON数据包示例：

    {
        "errcode":10000,"errmsg":"查询未完成招标项目保证金失败"
    }

参数|是否必须|说明
----|----|-----
bidBondAmount|是|投标担保金额


##保存招标项目保证金接口

本接口用于保存招标项目的投标担保金额信息。


http请求方式: post

前置条件：用户必须先登录，用户有招标的权限

    http://ip:port/gw/tender/saveObjectBondInfo


POST数据格式：JSON

    {
        "app":{
            "appId":"zjhtwallet",
            "timeStamp":"TIMESTAMP", 
            "nonce":"NONCE",
            "signature":"SIGNATURE"
        },        
        "body":
        {
            "objectId":"BH2015082135656",
            "token":"356578",
            "bidBondAmount":50000
         }
     }

参数|是否必须|说明
----|----|-----
appId|是|应用ID
timestamp|是|时间戳
nonce|是|随机数
signature|是|签名值,MD5(按值的字典顺序排列组合成字符串(appId,appKey,app.nonce,app.timeStamp))
tenderBond|是|投标保证金
token|是|用户令牌
token|是|用户令牌
objectId|是|招标项目内部编号
bidBondAmount|是|投标担保金额

2）返回说明

正常时的返回JSON数据包示例：
 
    {
        "errcode":0,"errmsg":"保存招标项目保证金成功"
    }

错误时的JSON数据包示例：

    {
        "errcode":10000,"errmsg":"保存招标项目保证金失败，其它错误"
    }



##查询未完成招标项目投标文件接口

本接口用于查询未完成招标项目设置的投标文件类型信息。


http请求方式: post

前置条件：用户必须先登录，用户有招标的权限

    http://ip:port/gw/tender/queryBidFileTypeInfo


POST数据格式：JSON

    {
        "app":{
            "appId":"zjhtwallet",
            "timeStamp":"TIMESTAMP", 
            "nonce":"NONCE",
            "signature":"SIGNATURE"
        },        
        "body":
        {
    	    "token":"546785",
    	    "objectId":"BH2015082135656"
	    }
    }

参数|是否必须|说明
----|----|-----
appId|是|应用ID
timestamp|是|时间戳
nonce|是|随机数
signature|是|签名值,MD5(按值的字典顺序排列组合成字符串(appId,appKey,app.nonce,app.timeStamp))
token|是|用户令牌
objectId|是|招标项目内部编号


2）返回说明

正常时的返回JSON数据包示例：
 
    {
        "errcode":0,"errmsg":"查询未完成招标项目投标文件成功",
	    "bidFileTypeInfo":{
            "needBusinessStandard":"YES",
            "needTechnicalStandard":"YES",
            "needCertificationCheckupFile":"YES"
        }
	
    }

错误时的JSON数据包示例：

    {
        "errcode":10000,"errmsg":"查询未完成招标项目投标文件失败，其它错误"
    }

参数|是否必须|说明
----|----|-----
needBusinessStandard|是|投标方是否需要上传商务标书，YES，是。NO#，否。
needTechnicalStandard|是|投标方是否需要上传技术标书，YES，是。NO#，否。
needCertificationCheckupFile|是|投标方是否需要上传资格审查文件，YES，是。NO#，否。


##保存招标项目投标文件接口

本接口用于保存招标项目投标文件


http请求方式: post

前置条件：用户必须先登录，用户有招标的权限

    http://ip:port/gw/tender/saveBidFileTypeInfo


POST数据格式：JSON

    {
        "app":{
            "appId":"zjhtwallet",
            "timeStamp":"TIMESTAMP", 
            "nonce":"NONCE",
            "signature":"SIGNATURE"
        },        
        "body":
        {
            "objectId":"BH2015082135656",
            "token":"356578",
	    "needBusinessStandard":"YES",
            "needTechnicalStandard":"YES",
            "needCertificationCheckupFile":"YES"
	}
    }

参数|是否必须|说明
----|----|-----
appId|是|应用ID
timestamp|是|时间戳
nonce|是|随机数
signature|是|签名值,MD5(按值的字典顺序排列组合成字符串(appId,appKey,app.nonce,app.timeStamp))
token|是|用户令牌
token|是|用户令牌
objectId|是|招标项目内部编号
needBusinessStandard|是|投标方是否需要上传商务标书，YES，是。NO#，否。
needTechnicalStandard|是|投标方是否需要上传技术标书，YES，是。NO#，否。
needCertificationCheckupFile|是|投标方是否需要上传资格审查文件，YES，是。NO#，否。


2）返回说明

正常时的返回JSON数据包示例：
 
    {
        "errcode":0,"errmsg":"保存招标项目投标文件成功"
    }

错误时的JSON数据包示例：

    {
        "errcode":10000,"errmsg":"保存招标项目投标文件失败，其它错误"
    }

##查询投标方列表接口

本接口用于查询所有的投标方,用于邀请投标时的投标人下拉框显示。


http请求方式: post

前置条件：用户必须先登录，用户有招标的权限

    http://ip:port/gw/tender/queryBidderList


POST数据格式：JSON

    {
        "app":{
            "appId":"zjhtwallet",
            "timeStamp":"TIMESTAMP", 
            "nonce":"NONCE",
            "signature":"SIGNATURE"
        }
    }

参数|是否必须|说明
----|----|-----
appId|是|应用ID
timestamp|是|时间戳
nonce|是|随机数
signature|是|签名值,MD5(按值的字典顺序排列组合成字符串(appId,appKey,app.nonce,app.timeStamp))


2）返回说明

正常时的返回JSON数据包示例：
 
    {
        "errcode":0,"errmsg":"查询投标方列表成功",
        "bidderList":[{
            "bidderName":"蜂鸟娱乐（点点）"
            "bidderId":2
        },{
            "bidderName":"麦圈互动（胖子）"
            "bidderId":3
        }]
    
    }

错误时的JSON数据包示例：

    {
        "errcode":10000,"errmsg":"查询投标方列表失败，其它错误"
    }

参数|是否必须|说明
----|----|-----
list.bidderName|是|邀请投标人姓名
list.bidderId|是|邀请投标人Id


##查询未完成招标方式接口

本接口用于查询未完成招标项目的招标方式设置信息。


http请求方式: post

前置条件：用户必须先登录，用户有招标的权限

    http://ip:port/gw/tender/queryObjectMethodInfo


POST数据格式：JSON

    {
        "app":{
            "appId":"zjhtwallet",
            "timeStamp":"TIMESTAMP", 
            "nonce":"NONCE",
            "signature":"SIGNATURE"
        },        
        "body":
        {
    	    "token":"58960",
    	    "objectId":"BH2015082135656"
    	}
    }

参数|是否必须|说明
----|----|-----
appId|是|应用ID
timestamp|是|时间戳
nonce|是|随机数
signature|是|签名值,MD5(按值的字典顺序排列组合成字符串(appId,appKey,app.nonce,app.timeStamp))
token|是|用户令牌
objectId|是|招标项目内部编号


2）返回说明

正常时的返回JSON数据包示例：
 
    {
        "errcode":0,"errmsg":查询未完成招标方式成功",
        "objectMethodInfo":{
        	"objectMethod":"INV",
        	"inviteTender":[{
                "bidderName":"蜂鸟娱乐（点点）"
                "bidderId":2
            },{
                "bidderName":"麦圈互动（胖子）"
                "bidderId":3
            }]
        }
    }

错误时的JSON数据包示例：

    {
        "errcode":10000,"errmsg":"查询未完成招标方式失败，其它错误"
    }

参数|是否必须|说明
----|----|-----
objectMethod|是|招标方式,"PUB",公开招标。"INV",邀请投标。
inviteTender.bidderName|否|邀请投标人(公司名+昵称)
inviteTender.bidderId|否|邀请投标人Id


##保存未完成招标方式接口

本接口用于保存招标项目的招标方式设置信息。


http请求方式: post

前置条件：用户必须先登录，用户有招标的权限

    http://ip:port/gw/tender/saveObjectMethodInfo


POST数据格式：JSON

    {
        "app":{
            "appId":"zjhtwallet",
            "timeStamp":"TIMESTAMP", 
            "nonce":"NONCE",
            "signature":"SIGNATURE"
        },        
        "body":{
	        "token":"58960",
            "objectId":"BH2015082135656",
            "objectMethod":"INV",
            "inviteTender":[{
                "bidderName":"蜂鸟娱乐（点点）",
                "bidderId":2
                },{
                "bidderName":"麦圈互动（胖子）",
                "bidderId":3
            }]
	    }
    }

参数|是否必须|说明
----|----|-----
appId|是|应用ID
timestamp|是|时间戳
nonce|是|随机数
signature|是|签名值,MD5(按值的字典顺序排列组合成字符串(appId,appKey,app.nonce,app.timeStamp))
token|是|用户令牌
objectId|是|招标项目内部编号
objectMethod|是|招标方式,"PUB",公开招标。"INV",邀请投标。
inviteTender.bidderName|否|邀请投标人(公司名+昵称)
inviteTender.bidderId|否|邀请投标人Id


2）返回说明

正常时的返回JSON数据包示例：
 
    {
        "errcode":0,"errmsg":"保存招标方式成功"
    }

错误时的JSON数据包示例：

    {
        "errcode":10000,"errmsg":"保存招标方式失败，其它错误"
    }

##查询未完成招标答疑方式接口

本接口用于查询未完成招标答疑方式信息。


http请求方式: post

前置条件：用户必须先登录，用户有招标的权限

    http://ip:port/gw/tender/queryAnswerMethodInfo


POST数据格式：JSON

    {
        "app":{
            "appId":"zjhtwallet",
            "timeStamp":"TIMESTAMP", 
            "nonce":"NONCE",
            "signature":"SIGNATURE"
        },        
        "body":
        {
            "token":"674895",
            "objectId":"BH2015082135656"
        }
    }

参数|是否必须|说明
----|----|-----
appId|是|应用ID
timestamp|是|时间戳
nonce|是|随机数
signature|是|签名值,MD5(按值的字典顺序排列组合成字符串(appId,appKey,app.nonce,app.timeStamp))
token|是|用户令牌
objectId|是|招标项目内部编号


2）返回说明

正常时的返回JSON数据包示例：
 
    {
        "errcode":0,"errmsg":查询未完成招标答疑方式成功",
        "answerQuestion":{
            "startTime":"2015-05-23",
            "endTime":"2015-05-26",
            "QQ":"4658703",
            "QQtoken":"XXX标的答疑",
            "email":"maoxian@126.com",
            "address":"地王大厦3栋5楼402",
            "addressAnswerTime":"12:00-16:30",
            "addressAnswerDate":"2015-05-24",
            "telephone":"1387654",
	    "addressAnswerDate"
        }
        
    }

错误时的JSON数据包示例：

    {
        "errcode":10000,"errmsg":"查询未完成招标答疑方式失败，其它错误"
    }

参数|是否必须|说明
----|----|-----
QQ|否|答疑qq群
QQtoken|否|qq群加入口令
email|否|答疑邮件
address|否|答疑地址
addressAnswerTime|否|答疑时间
addressAnswerDate|否|答疑日期
telephone|否|答疑电话
endTime|否|答疑截止时间
startTime|否|答疑开始时间

##保存招标答疑方式接口

保存招标答疑方式


http请求方式: post

前置条件：用户必须先登录，用户有招标的权限

    http://ip:port/gw/tender/saveAnswerMethodInfo


POST数据格式：JSON

    {
        "app":{
            "appId":"zjhtwallet",
            "timeStamp":"TIMESTAMP", 
            "nonce":"NONCE",
            "signature":"SIGNATURE"
        },        
        "body":
        {
            "token":"674895",
            "objectId":"35656",
            "startTime":"2015-05-23",
            "endTime":"2015-05-26",
            "QQ":"4658703",
            "QQtoken":"XXX标的答疑",
            "email":"maoxian@126.com",
            "address":"地王大厦3栋5楼402",
            "addressAnswerTime":"12:00-16:30",
            "addressAnswerDate":"2015-05-24",
            "telephone":"1387654"
        }
    }

参数|是否必须|说明
----|----|-----
appId|是|应用ID
timestamp|是|时间戳
nonce|是|随机数
signature|是|签名值,MD5(按值的字典顺序排列组合成字符串(appId,appKey,app.nonce,app.timeStamp))
token|是|用户令牌
objectId|是|招标项目内部编号
QQ|否|答疑qq群
QQtoken|否|qq群加入口令
email|否|答疑邮件
address|否|答疑地址
addressAnswerTime|否|答疑时间
addressAnswerDate|否|答疑日期
telephone|否|答疑电话
endTime|否|答疑截止时间
atartTime|否|答疑开始时间


2）返回说明

正常时的返回JSON数据包示例：
 
    {
        "errcode":0,"errmsg":"保存招标答疑方式成功"
    }

错误时的JSON数据包示例：

    {
        "errcode":10000,"errmsg":"保存招标答疑方式失败，其它错误"
    }


##查询未完成招标时间要求接口

本接口用于查询未完成招标项目的招标时间要求设置信息。


http请求方式: post

前置条件：用户必须先登录，用户有招标的权限

    http://ip:port/gw/tender/queryDateRequirementInfo


POST数据格式：JSON

    {
        "app":{
            "appId":"zjhtwallet",
            "timeStamp":"TIMESTAMP", 
            "nonce":"NONCE",
            "signature":"SIGNATURE"
        },        
        "body":
        {
    	    "token":"09fdjg85",
    	    "objectId":"BH2015082135656"
    	}
    }

参数|是否必须|说明
----|----|-----
appId|是|应用ID
timestamp|是|时间戳
nonce|是|随机数
signature|是|签名值,MD5(按值的字典顺序排列组合成字符串(appId,appKey,app.nonce,app.timeStamp))
token|是|用户令牌
objectId|是|招标项目内部编号


2）返回说明

正常时的返回JSON数据包示例：
 
    {
        "errcode":0,"errmsg":查询未完成招标时间要求成功",
        "dateRequirementInfo":{
            "announcementBeginTime":"2015-04-10",
    	    "announcementEndTime":"2015-04-25",
    	    "biddingEndTime":"2015-04-25",
    	    "bidOpenDate":"2015-04-30"
	    }
    }

错误时的JSON数据包示例：

    {
        "errcode":10000,"errmsg":"查询未完成招标时间要求失败，其它错误"
    }

参数|是否必须|说明
----|----|-----
announcementBeginTime|是|公告开始时间
announcementEndTime|是|公告结束时间
biddingEndTime|是|投标截止时间
bidOpenDate|是|开标时间

##保存招标时间要求接口

本接口用于保存招标项目的招标时间设置信息。


http请求方式: post

前置条件：用户必须先登录，用户有招标的权限

    http://ip:port/gw/tender/saveDateRequirementInfo


POST数据格式：JSON

    {
        "app":{
            "appId":"zjhtwallet",
            "timeStamp":"TIMESTAMP", 
            "nonce":"NONCE",
            "signature":"SIGNATURE"
        },        
        "body":
        {
            "token":"09fdjg85",
            "objectId":"BH2015082135656",
    	    "announcementBeginTime":"2015-04-10",
            "announcementEndTime":"2015-04-25",
            "biddingEndTime":"2015-04-25",
            "bidOpenDate":"2015-04-30"
    	 }
     }

参数|是否必须|说明
----|----|-----
appId|是|应用ID
timestamp|是|时间戳
nonce|是|随机数
signature|是|签名值,MD5(按值的字典顺序排列组合成字符串(appId,appKey,app.nonce,app.timeStamp))
token|是|用户令牌
objectId|是|招标项目内部编号
announcementBeginTime|是|公告开始时间
announcementEndTime|是|公告结束时间
biddingEndTime|是|投标截止时间
bidOpenDate|是|开标时间


2）返回说明

正常时的返回JSON数据包示例：
 
    {
        "errcode":0,"errmsg":"保存招标时间要求成功"
    }

错误时的JSON数据包示例：

    {
        "errcode":10000,"errmsg":"保存招标时间要求失败，其它错误"
    }



##查询未完成招标评标方式接口

本接口用于查询未完成招标项目的评标方式设置信息。


http请求方式: post

前置条件：用户必须先登录，用户有招标的权限

    http://ip:port/gw/tender/queryBidEvaluationTypeInfo


POST数据格式：JSON

    {
        "app":{
            "appId":"zjhtwallet",
            "timeStamp":"TIMESTAMP", 
            "nonce":"NONCE",
            "signature":"SIGNATURE"
        },        
        "body":{
            "token":"09fdjg85",
            "objectId":"BH2015082135656"
        }
    }

参数|是否必须|说明
----|----|-----
appId|是|应用ID
timestamp|是|时间戳
nonce|是|随机数
signature|是|签名值,MD5(按值的字典顺序排列组合成字符串(appId,appKey,app.nonce,app.timeStamp))
token|是|用户令牌
objectId|是|招标项目内部编号


2）返回说明

正常时的返回JSON数据包示例：
 
    {
        "errcode":0,"errmsg":查询未完成招标时间要求成功",
        "bidEvaluationTypeInfo":{
            "bidEvaluationType":"QLT",
            "bidEvaluationSite":"技术标评标地点",
            "bidWinnerDetermineWay":"ORV",
            "voteWinWay":"SMP"
        }
    }

错误时的JSON数据包示例：

    {
        "errcode":10000,"errmsg":"查询未完成招标时间要求失败，其它错误"
    }

参数|是否必须|说明
----|----|-----
bidEvaluationType|是|评标方法及标准,QLT,定性.CRE,信用商户评价.OVE,综合评估
bidEvaluationSite|是|技术标评标地点
bidWinnerDetermineWay|是|中标人的确定方法.ORV,直接票决定标.MRV 逐轮票决定标,VDM 票决筹钱定标
voteWinWay|是|票决方式,SMP,简单铎书法。CPN,对比胜出法


##保存招标评标方式接口

本接口用于保存招标项目的评标方式设置信息。


http请求方式: post

前置条件：用户必须先登录，用户有招标的权限

    http://ip:port/gw/tender/saveBidEvaluationTypeInfo


POST数据格式：JSON

    {
        "app":{
            "appId":"zjhtwallet",
            "timeStamp":"TIMESTAMP", 
            "nonce":"NONCE",
            "signature":"SIGNATURE"
        },        
        "body":
        {
            "token":"09fdjg85",
            "objectId":"BH2015082135656",
            "bidEvaluationType":"QLT",
            "bidEvaluationSite":"技术标评标地点",
            "bidWinnerDetermineWay":"ORV",
            "voteWinWay":"SMP"
         }
     }

参数|是否必须|说明
----|----|-----
appId|是|应用ID
timestamp|是|时间戳
nonce|是|随机数
signature|是|签名值,MD5(按值的字典顺序排列组合成字符串(appId,appKey,app.nonce,app.timeStamp))
token|是|用户令牌
objectId|是|招标项目内部编号
bidEvaluationType|是|评标方法及标准,QLT,定性.CRE,信用商户评价.OVE,综合评估
bidEvaluationSite|是|技术标评标地点
bidWinnerDetermineWay|是|中标人的确定方法.ORV,直接票决定标.MRV 逐轮票决定标,VDM 票决筹钱定标
voteWinWay|是|票决方式,SMP,简单铎书法。CPN,对比胜出法


2）返回说明

正常时的返回JSON数据包示例：
 
    {
        "errcode":0,"errmsg":"保存招标评标方式成功"
    }

错误时的JSON数据包示例：

    {
        "errcode":10000,"errmsg":"保存招标评标方式失败，其它错误"
    }


##发布标的接口

本接口用于用户在填写完招标项目信息后发布标的信息。


http请求方式: post

前置条件：用户必须先登录

    http://ip:port/gw/tender/submitObject


POST数据格式：JSON

    {
        "app":{
            "appId":"zjhtwallet",
            "timeStamp":"TIMESTAMP", 
            "nonce":"NONCE",
            "signature":"SIGNATURE"
        },        
        "body":
        {
    	    "token":"34543566dc6",	
    	    "objectId":"BH2015012303454"
        }
    } 


参数|是否必须|说明
----|----|-----
appId|是|应用ID
timestamp|是|时间戳
nonce|是|随机数
signature|是|签名值,MD5(按值的字典顺序排列组合成字符串(appId,appKey,app.nonce,app.timeStamp))
token|是|用户令牌
objectId|是|招标项目内部编号

2）返回说明

正常时的返回JSON数据包示例：
 
    {
        "errcode":0,"errmsg":"发布标的成功"
    }

错误时的JSON数据包示例：

    {
        "errcode":10000,"errmsg":"发布标的失败"
    }


##查询我的招标概况接口

查询用户所有标的的总概况

http请求方式: post

    http://ip:port/gw/tender/queryMyObjectSurvey


POST数据格式：JSON

    {
        "app":{
            "appId":"zjhtwallet",
            "timeStamp":"TIMESTAMP", 
            "nonce":"NONCE",
            "signature":"SIGNATURE"
        }，
        "body":{
            "token":"547689"
        }
    } 


参数|是否必须|说明
----|----|-----
appId|是|应用ID
timestamp|是|时间戳
nonce|是|随机数
signature|是|签名值,MD5(按值的字典顺序排列组合成字符串(appId,appKey,app.nonce,app.timeStamp))
token|是|用户令牌


2）返回说明

正常时的返回JSON数据包示例：
 
    {
        "errcode":0,"errmsg":"查询我的招标概况查询接口成功",
        "bidingNum":3,
        "doingNum":3,
        "doneNum":2
    }


错误时的JSON数据包示例：

    {
        "errcode":10000,"errmsg":"查询我的标的数量失败，其它错误"
    }


参数|是否必须|说明
----|----|-----
bidingNum|是|招标中的数量
doingNum|是|实施中的数量
doneNum|是|已完成的数量


##查询我的招标项目列表接口

本接口用于查询我的招标中的项目列表信息。

http请求方式: post

    http://ip:port/gw/tender/queryMyTenderObject


POST数据格式：JSON

    {
        "app":{
            "appId":"zjhtwallet",
            "timeStamp":"TIMESTAMP", 
            "nonce":"NONCE",
            "signature":"SIGNATURE"
        }
        "body":{
            "token":"USER_TOKEN",
            "pageIndex":0,
            "pageSize":10
        }
    } 


参数|是否必须|说明
----|----|-----
appId|是|应用ID
timestamp|是|时间戳
nonce|是|随机数
signature|是|签名值,MD5(按值的字典顺序排列组合成字符串(appId,appKey,app.nonce,app.timeStamp))
token|是|用户令牌
status|是|查询列表状态（发布中的，实施中，已结束）


2）返回说明

正常时的返回JSON数据包示例：
 
    {
        "errcode":0,"errmsg":"查询我的招标项目列表成功","pageSize":10,"pageIndex":0,"total":100,
        "list":[{
            "industryId":3,
            "objectId":"32456",
            "objectName":"7665",
            "evaluationAmount":"30000000",
            "projectExpectStartDate":"2015-06-12",
            "projectExpectPeriod":300,
            "biddingEndTime":"2015-04-25"
        }]
    }


错误时的JSON数据包示例：

    {
        "errcode":10000,"errmsg":"查询我的招标项目列表失败，其它错误"
    }


参数|是否必须|说明
----|----|-----
industryId|是|工程类别
objectId|是|招标项目内部编号
objectName|是|标的名称
evaluationAmount|是|标的估价
projectExpectStartDate|是|计划开工日期
projectExpectPeriod|是|标准工期
biddingEndTime|是|投标截止时间


##查询我的施工项目列表接口

本接口用于查询我的施工中的项目列表信息。

http请求方式: post

    http://ip:port/gw/tender/queryMyBuildingObject


POST数据格式：JSON

    {
        "app":{
            "appId":"zjhtwallet",
            "timeStamp":"TIMESTAMP", 
            "nonce":"NONCE",
            "signature":"SIGNATURE"
        }
        "body":{
            "token":"USER_TOKEN",
            "pageIndex":0,
            "pageSize":10
        }
    } 


参数|是否必须|说明
----|----|-----
appId|是|应用ID
timestamp|是|时间戳
nonce|是|随机数
signature|是|签名值,MD5(按值的字典顺序排列组合成字符串(appId,appKey,app.nonce,app.timeStamp))
token|是|用户令牌


2）返回说明

正常时的返回JSON数据包示例：
 
    {
        "errcode":0,"errmsg":"查询我的施工项目列表成功","pageSize":10,"pageIndex":0,"total":100,
        "list":[{
            "objectId":"32456",
            "objectName":"7665",
            "winBidAmount":"30000000",
            "winBidder":"麦圈互动",
            "receivedAmount":"3000000",
            "willReceiveAmount":"20020000",
            "projectExpectStartDate":"2015-06-12",
            "projectExpectPeriod":300
        }]
    }


错误时的JSON数据包示例：

    {
        "errcode":10000,"errmsg":"查询实施中的招标列表失败，其它错误"
    }


参数|是否必须|说明
----|----|-----
objectId|是|招标项目内部编号
objectName|是|标的名称
winBidAmount|是|中标金额
winBidder|是|中标人
receivedAmount|是|已收款
willReceiveAmount|是|待收款
projectExpectStartDate|是|计划开工日期
projectExpectPeriod|是|标准工期


##查询我的已结束项目列表接口

本接口用于查询用户已结束的项目列表信息。

http请求方式: post

    http://ip:port/gw/tender/queryMyEndedObject


POST数据格式：JSON

    {
        "app":{
            "appId":"zjhtwallet",
            "timeStamp":"TIMESTAMP", 
            "nonce":"NONCE",
            "signature":"SIGNATURE"
        }
        "body":{
            "token":"USER_TOKEN",
            "pageIndex":0,
            "pageSize":10
        }
    } 


参数|是否必须|说明
----|----|-----
appId|是|应用ID
timestamp|是|时间戳
nonce|是|随机数
signature|是|签名值,MD5(按值的字典顺序排列组合成字符串(appId,appKey,app.nonce,app.timeStamp))
token|是|用户令牌


2）返回说明

正常时的返回JSON数据包示例：
 
    {
        "errcode":0,"errmsg":"查询我的已结束项目列表成功","pageSize":10,"pageIndex":0,"total":100,
        "list":[{
            "industryId":3,
            "objectId":"32456",
            "objectName":"7665",
            "winBidAmount":"30000000",
            "winBidder":"麦圈互动"
        }]
    }


错误时的JSON数据包示例：

    {
        "errcode":10000,"errmsg":"查询我的已结束的招标列表失败，其它错误"
    }


参数|是否必须|说明
----|----|-----
industryId|是|工程类别编号
objectId|是|招标项目内部编号
objectName|是|标的名称
winBidAmount|是|中标金额
winBidder|是|中标人
