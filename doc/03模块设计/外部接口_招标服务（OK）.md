###我的招标列表接口

我的》招标管理》工程标的管理的界面显示的内容

http请求方式: post

    http://ip:port/if/tender/queryMyObject


POST数据格式：JSON

    {
        "app":{
            "appId":"zjhtwallet",
            "timeStamp":"TIMESTAMP", 
            "nonce":"NONCE",
            "signature":"SIGNATURE"
        }
	"body":{
	    "token":"2134356",
	    "status":"",
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
 
    {"errcode":0,"errmsg":"查询我的招标列表成功","pageSize":10,"pageIndex":0,"total":100,
    "list":[{
	"projectCategoryId":3,
	"objectId":"32456",
	"objectName":"7665",
	"objcetOffer":"30000000",
	"objectEvaluate":"30000000",
	"winBidCompany":"XXX公司",
	"isEvaluate":"OK#",
	"isOpenBid":"OK#"}]
    }


错误时的JSON数据包示例：

    {"errcode":10000,"errmsg":"查询招标列表失败，其它错误"}


参数|是否必须|说明
----|----|-----
projectCategoryId|是|工程类别
objectName|是|标的名称
objcetOffer|是|中标价格
objectEvaluate|是|标的估价
objectId|是|标的编号
winBidCompany|是|中标公司
isEvaluate|否|是否可以评价
isOpenBid|否|是否可以开标


###我的招标概况查询接口

查询用户所有标的的总概况

http请求方式: post

    http://ip:port/if/tender/queryMyObjectSurvey


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
 
    {"errcode":0,"errmsg":"查询我的招标概况查询接口成功",
	"publishedNum":3,
	"constructNum":3,
	"doneNum":2
    }


错误时的JSON数据包示例：

    {"errcode":10000,"errmsg":"查询我的标的数量失败，其它错误"}


参数|是否必须|说明
----|----|-----
publishedNum|是|发布中的数量
constructNum|是|实施中的数量
doneNum|是|已完成的数量


###我的招标投标列表接口

查询工程投标列表

http请求方式: post

    http://ip:port/if/tender/queryMyObjectTenderList


POST数据格式：JSON

    {
        "app":{
            "appId":"zjhtwallet",
            "timeStamp":"TIMESTAMP", 
            "nonce":"NONCE",
            "signature":"SIGNATURE"
        },
	"body":{
	    "token":"455678",
	    "pageSize":3,
	    "pageIndex":5,
	    "objectId":"32456"
	    }
    } 


参数|是否必须|说明
----|----|-----
token|是|用户令牌
objectId|是|标的编号

2）返回说明

正常时的返回JSON数据包示例：
 
    {"errcode":0,"errmsg":"查询我的招标投标列表接口成功！",
     "list":[{
	     "bidId":"4535264477",
	     "biderCompany":"投标公司",
	     "biderId":"4536789",
	     "bidDate":"2015-06-25 11:35:23",
	     "objectOffer":"5000000",
	     "fileUrl":"URL"}]
    }


错误时的JSON数据包示例：

    {"errcode":10000,"errmsg":查询我的招标投标列表接口失败，其他错误！"}


参数|是否必须|说明
----|----|-----
list.bidId|是|投标承包商ID
list.biderCompany|是|投标公司
list.biderId|是|投标公司Id
list.bidDate|是|投标日期
list.objectOffer|是|投标金额
list.fileUrl|是|投标文件下载地址

###我的招标评标概况接口

查询我的招标评标概况列表

http请求方式: post

    http://ip:port/if/tender/queryMyObjectTenderSurvey


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
token|是|
objectId|是|标的编号

2）返回说明

正常时的返回JSON数据包示例：
 
    {"errcode":0,"errmsg":"查询我的招标投标概况接口成功！",
     "survey":{
	"tenderNum":6,
	"objectName":"标的名称"
     }
    }


错误时的JSON数据包示例：

    {"errcode":10000,"errmsg":查询我的招标投标列表接口失败，其他错误！"}


参数|是否必须|说明
----|----|-----
tenderNum|是|参与投标数量
objectName|否|标的名称


###招标方给投标方评价接口

招投标完成后,招标方给投标方打分和评价

1）请求说明

http请求方式: post

    http://ip:port/if/tender/evaluateTender


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
            "token":"467",
	    "bidId":"zb90887",
	    "star":5,
	    "tags":["速度够快","质量很高"],
	    "content":"合作愉快，期待下次继续！"
        }
    } 


参数|是否必须|说明
----|----|-----
token|是|用户令牌 
bidId|是|投标记录Id 
star|是|评星数量，1-5 
tags|是|标签，以","分隔
content|是|评价内容


2）返回说明

正常时的返回JSON数据包示例：
 
    {"errcode":0,"errmsg":"评价成功"}


错误时的JSON数据包示例：

    {"errcode":10000,"errmsg":"评价失败，请重新再试！"}


###查看我的招标项目详情接口

查看我的招标项目详情


http请求方式: post

    http://ip:port/if/tender/queryMyObjectDetail


POST数据格式：JSON

    {
        "app":{
            "appId":"zjhtwallet",
            "timeStamp":"TIMESTAMP", 
            "nonce":"NONCE",
            "signature":"SIGNATURE"
        },
	"body":{
	    "token":"456789"
	    "objectId":"sdfghjh"
	}

    } 


参数|是否必须|说明
----|----|-----
appId|是|应用ID
timestamp|是|时间戳
nonce|是|随机数
signature|是|签名值,MD5(按值的字典顺序排列组合成字符串(appId,appKey,app.nonce,app.timeStamp))
objectId|是|招标记录Id
token|是|用户令牌


2）返回说明

正常时的返回JSON数据包示例：
 
    {"errcode":0,"errmsg":"查询招标信息成功",
     "info":
        {
	    "objectId":"36544789",
	    "status":"",
            "projectCategoryId":3,
	    "projectName":"金域华府3期工程开发",
	    "projectNum":"ZF9767575645",
	    "objectName":"土石购买招标",
	    "objectEvaluate":"300000000",
	    "predictTotalInvestment":"800000000000",
	    "objectContent":"购买5吨水泥",
	    "projectAddress":"深圳龙华区民塘路",
	    "bidEvaluationMethod":"评标方法",
	    "picketageMethod":"定标方法",
	    "tenderBond":"50000",
	    "projectIntroduce":"工程项目概况",
	    "enterpriseQualification":[{"certificateId":2,"certificateNum":4},{"certificateId":3,"certificateNum":2}],
	    "objectPrincipalDemand":"项目负责人要求",
	    "performanceDemand":["jhaskfjg","sdghj"],
	    "importantNotification":"重要提示",
	    "objectPredictStartTime":"2015-05-23",
	    "objectPredictEndTime":"2015-06-24",
	    "objectMethod":"公开招标",
	    "inviteTender":[1,2],
	    "noticeStartTime":"2015-04-10",
	    "noticeEndTime":"2015-04-25",
	    "tenderEndTime":"2015-04-25",
	    "openTime":"2015-04-30",
	    "projectCompany":"建设单位",
	    "projectCompanyAgent":"建设单位经办人",
	    "projectCompanyPhone":"1234523456",
	    "objectCompany":"招标方公司名称",
	    "objectCompanyAgent":"招标方单位经办人",
	    "objectCompanyPhone":"1234523456",
	    "attachments":[{"attachmentNme":"标书","attachmentUrl":"http://www.baidu.com"}],
	    "answer":{
		"QQ":"",
		"email":"",
		"address":"",
		"answerTime":"",
		"telPhone":"1387654"
	    },
	    "answerEndTime":"2015-05-23",
	    "payType":"",
	    "payPeriod":12
	    "payList":[{"period":1,"intervalTime":60,"paySum":"45465"}]
	    
        }
    } 
    }


错误时的JSON数据包示例：

    {"errcode":10000,"errmsg":"查询招标信息失败，其它错误"}


参数|是否必须|说明
----|----|-----
objectId|是|招标Id
status|是|状态
projectCategoryId|是|工程类别
projectName|是|工程名称
projectNum|是|工程编号
objectName|是|标的名称
objectEvaluate|是|标的估价
predictTotalInvestment|是|计划总投资
objectContent|是|标的内容
projectAddress|是|工程地址
bidEvaluationMethod|是|评标方法
picketageMethod|是|定标方法
tenderBond|是|投标保证金
projectIntroduce|是|工程项目概况
enterpriseQualification|是|企业资质要求
objectPrincipalDemand|是|项目负责人要求
performanceDemand|是|业绩要求
importantNotification|是|重要提示
objectPredictStartTime|是|工程计划开始时间
objectPredictEndTime|是|工程计划完成时间
objectMethod|是|招标方式
inviteTender|是|邀请招标的公司
noticeStartTime|是|公告开始时间
noticeEndTime|是|公告结束时间
tenderEndTime|是|投标截止时间
openTime|是|开标时间
projectCompany|否|建设单位
projectCompanyAgent|否|建设单位经办人
projectCompanyPhone|否|建设单位联系电话
objectCompany|否|招标方公司名称
objectCompanyAgent|否|招标方单位经办人
objectCompanyPhone|否|招标方单位联系电话
attachments.attachmentNme|是|附件名称
attachments.attachmentUrl|是|附件地址
answer.QQ|否|答疑qq
answer.email|否|答疑邮件
answer.address|否|答疑地址
answer.answerTime|否|答疑时间
answer.telPhone|否|答疑电话
answerEndTime|否|答疑截止时间
payPeriod|是|付款期数
payList.period|是|付款期数
payList.intervalTime|是|间隔下期付款天数
payList.paySum|是|付款金额


###查询招标资质接口

用户招标前，前端网页通过该接口查询该用户是否有招标权限

1）请求说明

http请求方式: post

前置条件：用户必须先登录，

    http://ip:port/if/tender/queryObjectOfInvitation


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
 
    {"errcode":0,"errmsg":"查询用户招标资质成功",
     "info":{
	"isInvitation":"FLS",
	"remark":"非会员只能发布一次招标。"
	}
    }

错误时的JSON数据包示例：

    {"errcode":10000,"errmsg":"查询用户招标资质失败，其它错误"}

参数|是否必须|说明
----|----|-----
isInvitation|是|是否具有资质
remark|否|备注，没有权限说明原因


3）实现说明

检查是否认证过招标方;检查是否为会员;非会员的时候，检查是否发布过一次标的。

###查询未完成招标基础信息接口

查询未完成招标基础信息


http请求方式: post

前置条件：用户必须先登录，用户有招标的权限

    http://ip:port/if/tender/queryObjectBaseInfo


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
	     "objectId":"35656"
	 }
     }

参数|是否必须|说明
----|----|-----
appId|是|应用ID
timestamp|是|时间戳
nonce|是|随机数
signature|是|签名值,MD5(按值的字典顺序排列组合成字符串(appId,appKey,app.nonce,app.timeStamp))
token|是|用户令牌
objectId|是|标的Id


2）返回说明

正常时的返回JSON数据包示例：
 
    {"errcode":0,"errmsg":"查询未完成招标基础信息成功",
	"info":{
		"projectCategoryId":3,//工程类别,
		"objectName":"土石购买招标",
		"objectContent":"购买5吨水泥",
		"objectPredictStartTime":"2015-05-23",
		"objectPredictEndTime":"2015-06-24",
		"objectCompanyAgent":"招标方单位经办人",
		"objectCompanyPhone":"1234523456"
	}
    }

错误时的JSON数据包示例：

    {"errcode":10000,"errmsg":"查询未完成招标基础信息失败，其它错误"}

参数|是否必须|说明
----|----|-----
projectCategoryId|是|工程类别编号
objectName|是|标的名称
objectContent|是|标的内容
objectPredictStartTime|是|工程计划开始时间
objectPredictEndTime|是|工程计划完成时间
objectCompanyAgent|否|建设单位经办人
objectCompanyPhone|否|建设单位联系电话


###保存招标基础信息接口

保存招标基础信息


http请求方式: post

前置条件：用户必须先登录，用户有招标的权限

    http://ip:port/if/tender/saveObjectBaseInfo


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
	     "objectId":"35656",
	     "projectCategoryId":3,//工程类别,
	     "objectName":"土石购买招标",
	     "objectContent":"购买5吨水泥",
	     "objectPredictStartTime":"2015-05-23",
	     "objectPredictEndTime":"2015-06-24",
	     "objectCompanyAgent":"招标方单位经办人",
	     "objectCompanyPhone":"1234523456"2015/10/22
	 }
     }

参数|是否必须|说明
----|----|-----
appId|是|应用ID
timestamp|是|时间戳
nonce|是|随机数
signature|是|签名值,MD5(按值的字典顺序排列组合成字符串(appId,appKey,app.nonce,app.timeStamp))
token|是|用户令牌
objectId|是|招标Id
projectNum|是|工程编号
objectName|是|标的名称
objectContent|是|标的内容
objectPredictStartTime|是|工程计划开始时间
objectPredictEndTime|是|工程计划完成时间
projectCompanyAgent|否|建设单位经办人
projectCompanyPhone|否|建设单位联系电话


2）返回说明

正常时的返回JSON数据包示例：
 
    {"errcode":0,"errmsg":"保存招标基础信息成功", "objectId":"35656"
    }

错误时的JSON数据包示例：

    {"errcode":10000,"errmsg":"保存招标基础信息失败，其它错误"}

参数|是否必须|说明
----|----|-----
objectId|是|招标Id


###查询未完成招标详细信息接口

查询未完成招标详细信息


http请求方式: post

前置条件：用户必须先登录，用户有招标的权限

    http://ip:port/if/tender/queryObjectDetailInfo


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
	     "token":"87875",
	     "objectId":"35656"
	 }
     }

参数|是否必须|说明
----|----|-----
appId|是|应用ID
timestamp|是|时间戳
nonce|是|随机数
signature|是|签名值,MD5(按值的字典顺序排列组合成字符串(appId,appKey,app.nonce,app.timeStamp))
token|是|用户令牌
objectId|是|招标Id


2）返回说明

正常时的返回JSON数据包示例：
 
    {"errcode":0,"errmsg":"查询未完成招标基础信息成功",
	"info":{
		"projectName":"金域华府3期工程开发",
		"projectNum":"ZF9767575645",
		"projectIntroduce":"工程项目概况",
		"predictTotalInvestment":"800000000000",
		"projectCompany":"建设单位",
		"projectCompanyAgent":"建设单位经办人",
		"projectCompanyPhone":"1234523456"
	}

    }

错误时的JSON数据包示例：

    {"errcode":10000,"errmsg":"查询未完成招标基础信息失败，其它错误"}

参数|是否必须|说明
----|----|-----
projectName|是|工程名称
projectNum|是|工程编号
projectIntroduce|是|工程项目概况
predictTotalInvestment|是|计划总投资
projectCompany|否|建设单位
projectCompanyAgent|否|建设单位经办人
projectCompanyPhone|否|建设单位联系电话

###保存招标详细信息接口

保存招标详细信息


http请求方式: post

前置条件：用户必须先登录，用户有招标的权限

    http://ip:port/if/tender/saveObjectDetailInfo


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
	     "objectId":"35656",
	     "projectName":"金域华府3期工程开发",
	     "projectNum":"ZF9767575645",
	     "projectIntroduce":"工程项目概况",
	     "predictTotalInvestment":800000000000,
	     "projectCompany":"建设单位",
	     "projectCompanyAgent":"建设单位经办人",
	     "projectCompanyPhone":"1234523456"
	 }
     }

参数|是否必须|说明
----|----|-----
appId|是|应用ID
timestamp|是|时间戳
nonce|是|随机数
signature|是|签名值,MD5(按值的字典顺序排列组合成字符串(appId,appKey,app.nonce,app.timeStamp))
token|是|用户令牌
objectId|是|招标Id
projectName|是|工程名称
projectNum|是|工程编号
projectIntroduce|是|工程项目概况
predictTotalInvestment|是|计划总投资
projectCompany|否|建设单位
projectCompanyAgent|否|建设单位经办人
projectCompanyPhone|否|建设单位联系电话


2）返回说明

正常时的返回JSON数据包示例：
 
    {"errcode":0,"errmsg":"保存招标详细信息成功"
    }

错误时的JSON数据包示例：

    {"errcode":10000,"errmsg":"保存招标详细信息失败，其它错误"}


###查询证书列表接口

用于选择证书时的下拉框显示


http请求方式: post

前置条件：无

    http://ip:port/if/tender/queryCertificate


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
 
    {"errcode":0,"errmsg":"查询证书列表成功",
	"list":[{
	    "certificateId":5,
	    "certificateName":""
	}]
    }

错误时的JSON数据包示例：

    {"errcode":10000,"errmsg":"查询证书列表失败，其它错误"}

参数|是否必须|说明
----|----|-----
enterpriseQualification|是|企业资质要求
certificateId|是|证书Id
certificateName|是|证书名称（包含级别）

###查询未完成招标项目要求信息接口

查询未完成招标项目要求信息


http请求方式: post

前置条件：用户必须先登录，用户有招标的权限

    http://ip:port/if/tender/queryObjectDemandInfo


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
	     "objectId":"35656"
	 }
     }

参数|是否必须|说明
----|----|-----
appId|是|应用ID
timestamp|是|时间戳
nonce|是|随机数
signature|是|签名值,MD5(按值的字典顺序排列组合成字符串(appId,appKey,app.nonce,app.timeStamp))
token|是|用户令牌
objectId|是|招标Id


2）返回说明

正常时的返回JSON数据包示例：
 
    {"errcode":0,"errmsg":"查询未完成招标项目要求信息成功",
	"info":{
		"enterpriseQualification":[{"certificateId":2,"certificateNum":4}],
		"objectPrincipalDemand":"项目负责人要求",
		"performanceDemand":[{"performanceName":"jhaskfjg","performanceNum":"sdghj"}],
		"otherDemand":"dcvg"
	}
	   

    }

错误时的JSON数据包示例：

    {"errcode":10000,"errmsg":"查询未完成招标项目要求信息失败，其它错误"}

参数|是否必须|说明
----|----|-----
enterpriseQualification|是|企业资质要求
certificateId|是|证书Id
certificateNum|是|要求数量
performanceDemand|是|业绩要求
performanceName|是|业绩名称
performanceNum|是|业绩数量
objectPrincipalDemand|是|项目负责人要求
otherDemand|是|其他要求

###保存招标项目要求信息接口

保存未完成招标基础信息


http请求方式: post

前置条件：用户必须先登录，用户有招标的权限

    http://ip:port/if/tender/saveObjectDetailInfo


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
	     "objectId":"35656",
	     "enterpriseQualification":[{"certificateId":2,"certificateNum":4}],
	     "objectPrincipalDemand":"项目负责人要求",
	     "performanceDemand":[{"performanceName":"jhaskfjg","performanceNum":"sdghj"}],
	     "otherDemand":""
	 }
     }

参数|是否必须|说明
----|----|-----
appId|是|应用ID
timestamp|是|时间戳
nonce|是|随机数
signature|是|签名值,MD5(按值的字典顺序排列组合成字符串(appId,appKey,app.nonce,app.timeStamp))
token|是|用户令牌
objectId|是|招标Id
enterpriseQualification|是|企业资质要求
certificateId|是|证书Id
certificateNum|是|要求数量
performanceDemand|是|业绩要求
performanceName|是|业绩名称
performanceNum|是|业绩名称
objectPrincipalDemand|是|项目负责人要求
otherDemand|是|其他要求


2）返回说明

正常时的返回JSON数据包示例：
 
    {"errcode":0,"errmsg":"保存招标项目要求信息成功"
    }

错误时的JSON数据包示例：

    {"errcode":10000,"errmsg":"保存招标项目要求信息失败，其它错误"}

###查询未完成招标附件接口

查询未完成招标附件


http请求方式: post

前置条件：用户必须先登录，用户有招标的权限

    http://ip:port/if/tender/queryObjectFileInfo


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
	     "objectId":"35656"
	 }
     }

参数|是否必须|说明
----|----|-----
appId|是|应用ID
timestamp|是|时间戳
nonce|是|随机数
signature|是|签名值,MD5(按值的字典顺序排列组合成字符串(appId,appKey,app.nonce,app.timeStamp))
token|是|用户令牌
objectId|是|招标Id


2）返回说明

正常时的返回JSON数据包示例：
 
    {"errcode":0,"errmsg":"查询未完成招标附件成功",
	"attachments":[{"attachmentNme":"标书","attachmentUrl":"http://www.baidu.com"}],
	
    }

错误时的JSON数据包示例：

    {"errcode":10000,"errmsg":"查询未完成招标附件失败，其它错误"}

参数|是否必须|说明
----|----|-----
attachments.attachmentNme|是|附件名称
attachments.attachmentUrl|是|附件地址

###保存招标附件接口

保存招标附件


http请求方式: post

前置条件：用户必须先登录，用户有招标的权限

    http://ip:port/if/tender/saveObjectFileInfo


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
	    "attachments":[{"attachmentNme":"标书","attachmentUrl":"http://www.baidu.com"}]
	
	 }
     }

参数|是否必须|说明
----|----|-----
appId|是|应用ID
timestamp|是|时间戳
nonce|是|随机数
signature|是|签名值,MD5(按值的字典顺序排列组合成字符串(appId,appKey,app.nonce,app.timeStamp))
token|是|用户令牌
objectId|是|招标Id
attachments.attachmentNme|是|附件名称
attachments.attachmentUrl|是|附件地址


2）返回说明

正常时的返回JSON数据包示例：
 
    {"errcode":0,"errmsg":"保存招标附件成功"
    }

错误时的JSON数据包示例：

    {"errcode":10000,"errmsg":"保存招标附件失败，其它错误"}

###查询未完成招标方式接口

查询未完成招标方式


http请求方式: post

前置条件：用户必须先登录，用户有招标的权限

    http://ip:port/if/tender/queryObjectMethodInfo


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
	     "objectId":"35656"
	 }
     }

参数|是否必须|说明
----|----|-----
appId|是|应用ID
timestamp|是|时间戳
nonce|是|随机数
signature|是|签名值,MD5(按值的字典顺序排列组合成字符串(appId,appKey,app.nonce,app.timeStamp))
token|是|用户令牌
objectId|是|招标Id


2）返回说明

正常时的返回JSON数据包示例：
 
    {"errcode":0,"errmsg":查询未完成招标方式成功",
      "info":{
	 "objectMethod":"公开招标",
	 "inviteTender":[{"name":"","bidId":2}]
	}
    }

错误时的JSON数据包示例：

    {"errcode":10000,"errmsg":"查询未完成招标方式失败，其它错误"}

参数|是否必须|说明
----|----|-----
objectMethod|是|招标方式
inviteTender.name|否|邀请投标人姓名
inviteTender.bidId|否|邀请投标人Id

###保存招标附件接口

保存招标附件


http请求方式: post

前置条件：用户必须先登录，用户有招标的权限

    http://ip:port/if/tender/saveObjectFileInfo


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
	    "objectMethod":"公开招标",
            "inviteTender":[{"name":"","bidId":2}],//邀请投标
	 }
     }

参数|是否必须|说明
----|----|-----
appId|是|应用ID
timestamp|是|时间戳
nonce|是|随机数
signature|是|签名值,MD5(按值的字典顺序排列组合成字符串(appId,appKey,app.nonce,app.timeStamp))
token|是|用户令牌
objectId|是|招标Id
objectMethod|是|招标方式
inviteTender.name|否|邀请投标人姓名
inviteTender.bidId|否|邀请投标人Id


2）返回说明

正常时的返回JSON数据包示例：
 
    {"errcode":0,"errmsg":"保存招标附件成功"
    }

错误时的JSON数据包示例：

    {"errcode":10000,"errmsg":"保存招标附件失败，其它错误"}



###查询所有投标方接口

查询所有投标方


http请求方式: post

前置条件：用户必须先登录，用户有招标的权限

    http://ip:port/if/tender/queryAllBider


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
 
    {"errcode":0,"errmsg":"查询证书列表成功",
	"list":[{
	    "name":"",
	    "bidId":5
	    }]
	
    }

错误时的JSON数据包示例：

    {"errcode":10000,"errmsg":"查询证书列表失败，其它错误"}

参数|是否必须|说明
----|----|-----
list.name|是|邀请投标人姓名
list.bidId|是|邀请投标人Id


###查询未完成招标时间要求接口

查询未完成招标时间要求


http请求方式: post

前置条件：用户必须先登录，用户有招标的权限

    http://ip:port/if/tender/queryObjectMethodInfo


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
	     "token":"0985",
	     "objectId":"35656"
	 }
     }

参数|是否必须|说明
----|----|-----
appId|是|应用ID
timestamp|是|时间戳
nonce|是|随机数
signature|是|签名值,MD5(按值的字典顺序排列组合成字符串(appId,appKey,app.nonce,app.timeStamp))
token|是|用户令牌
objectId|是|招标Id


2）返回说明

正常时的返回JSON数据包示例：
 
    {"errcode":0,"errmsg":查询未完成招标时间要求成功",
       "info":{
            "noticeStartTime":"2015-04-10",
	    "noticeEndTime":"2015-04-25",
	    "tenderEndTime":"2015-04-25",
	    "openTime":"2015-04-30"
	    }
    }

错误时的JSON数据包示例：

    {"errcode":10000,"errmsg":"查询未完成招标方式失败，其它错误"}

参数|是否必须|说明
----|----|-----
noticeStartTime|是|公告开始时间
noticeEndTime|是|公告结束时间
tenderEndTime|是|投标截止时间
openTime|是|开标时间

###保存招标时间要求接口

保存招标时间要求


http请求方式: post

前置条件：用户必须先登录，用户有招标的权限

    http://ip:port/if/tender/saveObjectFileInfo


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
	    "noticeStartTime":"2015-04-10",
	    "noticeEndTime":"2015-04-25",
	    "tenderEndTime":"2015-04-25",
	    "openTime":"2015-04-30"
	 }
     }

参数|是否必须|说明
----|----|-----
appId|是|应用ID
timestamp|是|时间戳
nonce|是|随机数
signature|是|签名值,MD5(按值的字典顺序排列组合成字符串(appId,appKey,app.nonce,app.timeStamp))
token|是|用户令牌
objectId|是|招标Id
noticeStartTime|是|公告开始时间
noticeEndTime|是|公告结束时间
tenderEndTime|是|投标截止时间
openTime|是|开标时间


2）返回说明

正常时的返回JSON数据包示例：
 
    {"errcode":0,"errmsg":"保存招标时间要求成功"
    }

错误时的JSON数据包示例：

    {"errcode":10000,"errmsg":"保存招标时间要求失败，其它错误"}


###查询未完成招标答疑方式接口

查询未完成招标答疑方式


http请求方式: post

前置条件：用户必须先登录，用户有招标的权限

    http://ip:port/if/tender/queryObjectMethodInfo


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
	     "objectId":"35656"
	 }
     }

参数|是否必须|说明
----|----|-----
appId|是|应用ID
timestamp|是|时间戳
nonce|是|随机数
signature|是|签名值,MD5(按值的字典顺序排列组合成字符串(appId,appKey,app.nonce,app.timeStamp))
token|是|用户令牌
objectId|是|招标Id


2）返回说明

正常时的返回JSON数据包示例：
 
    {"errcode":0,"errmsg":查询未完成招标答疑方式成功",
      "answer":{
		"answerStartTime":"2015-05-23",
	        "answerEndTime":"2015-05-23",
		"QQ":"",
		"QQtoken":"QQ口令",
		"email":"",
		"address":"",
		"answerTime":"",
		"telPhone":"1387654"
	    }
	    
    }

错误时的JSON数据包示例：

    {"errcode":10000,"errmsg":"查询未完成招标答疑方式失败，其它错误"}

参数|是否必须|说明
----|----|-----
answer.QQ|否|答疑qq
answer.email|否|答疑邮件
answer.address|否|答疑地址
answer.answerTime|否|答疑时间
answer.telPhone|否|答疑电话
answer.answerEndTime|否|答疑截止时间
answer.answerStartTime|否|答疑开始时间

###保存招标答疑方式接口

保存招标答疑方式


http请求方式: post

前置条件：用户必须先登录，用户有招标的权限

    http://ip:port/if/tender/saveObjectFileInfo


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
	     "answer":{
	        "answerStartTime":"2015-05-23",
	        "answerEndTime":"2015-05-23",
		"QQ":"",
		"email":"",
		"address":"",
		"answerTime":"",
		"telPhone":"1387654"
	    }
	     
	 }
     }

参数|是否必须|说明
----|----|-----
appId|是|应用ID
timestamp|是|时间戳
nonce|是|随机数
signature|是|签名值,MD5(按值的字典顺序排列组合成字符串(appId,appKey,app.nonce,app.timeStamp))
token|是|用户令牌
objectId|是|招标Id
answer.QQ|否|答疑qq
answer.email|否|答疑邮件
answer.address|否|答疑地址
answer.answerTime|否|答疑时间
answer.telPhone|否|答疑电话
answerEndTime|否|答疑截止时间
answerStartTime|否|答疑开始时间


2）返回说明

正常时的返回JSON数据包示例：
 
    {"errcode":0,"errmsg":"保存招标答疑方式成功"
    }

错误时的JSON数据包示例：

    {"errcode":10000,"errmsg":"保存招标答疑方式失败，其它错误"}


###查询未完成的保证金信息接口

查询未完成的保证金信息

1）请求说明

http请求方式: post

前置条件：用户先调用保存招标信息接口

    http://ip:port/if/tender/queryObjectBond


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
	    "objectId":"576348",
	    "token":"56435475",
	    
        }
    } 


参数|是否必须|说明
----|----|-----
appId|是|应用ID
timestamp|是|时间戳
nonce|是|随机数
signature|是|签名值,MD5(按值的字典顺序排列组合成字符串(appId,appKey,app.nonce,app.timeStamp))
token|是|用户令牌
objectId|是|招标Id

2）返回说明

正常时的返回JSON数据包示例：
 
    {"errcode":0,"errmsg":"保证金查询成功",
     "info":{
	"satisfy":"YES",
	"bidBond":"50000",
	"tenderBond":"50000"
        }
    }


错误时的JSON数据包示例：

    {"errcode":10000,"errmsg":"保证金查询失败"}

参数|是否必须|说明
----|----|-----
satisfy|是|账户余额是否足够YES,足够，NO#，不够
bidBond|是|招标保证金
tenderBond|是|投标保证金

###保存保证金信息接口

保存保证金信息


http请求方式: post

前置条件：用户必须先登录，用户有招标的权限

    http://ip:port/if/tender/saveObjectBondInfo


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
	     "objectId":"546758980",
	     "token":"356578",
	     "tenderBond":50000
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
objectId|是|招标Id

2）返回说明

正常时的返回JSON数据包示例：
 
    {"errcode":0,"errmsg":"保存保证金信息成功"
    }

错误时的JSON数据包示例：

    {"errcode":10000,"errmsg":"保存保证金信息失败，其它错误"}



###发布标的接口

发布标的


http请求方式: post

前置条件：用户必须先登录

    http://ip:port/if/tender/submitObject


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
	    "token":"3456",	
	    "objectId":"3454",
	    "bidBond":60000
        }
    } 


参数|是否必须|说明
----|----|-----
appId|是|应用ID
timestamp|是|时间戳
nonce|是|随机数
signature|是|签名值,MD5(按值的字典顺序排列组合成字符串(appId,appKey,app.nonce,app.timeStamp))
token|是|用户令牌
priviligeId|是|标的Id
bidBond|是|招标保证金

2）返回说明

正常时的返回JSON数据包示例：
 
    {"errcode":0,"errmsg":"发布标的成功"}

错误时的JSON数据包示例：

    {"errcode":10000,"errmsg":"发布标的失败"}


