###查询我的招标人认证信息接口

该接口用于查询资质认证结果，还可以用于下一次的资质认证，获取信息。

前置：先登录

http请求方式: post

    http://ip:port/if/verifyBidee/biddeeCertificateResult


POST数据格式：JSON

    {
        "app":{
            "appId":"zjhtwallet",
            "timeStamp":"TIMESTAMP", 
            "nonce":"NONCE",
            "signature":"SIGNATURE"
        },
	    "body":{
	       "token":"eworew8rw3hfre"
	    
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
 
    {"errcode":0,"errmsg":"查询招标方资质认证结果成功",
        "apply":{
            "companyName":"xxx",
            "legalPerson":"xxx",
            "regTime":"xxx",
            "contactName":"xxx",
            "contactMobileNum":"xxx",
            "businessLicense":"xxx",
            "orgCodeCertificate":"xxx",
            "taxRegistrationCertificate":"xxx",
            "newBusinessLicense":"xxx",
            "businessLicenseType":"xxx",
            "businessLicenseExpireTime":"xxx",
            "legalPersonIdentity":"xxx",
            "legalPersonIdentityPic":"xxx",
            "email":"xxx",
            "legalPersonAuthorityBook":"xxx",
            "projectCcope":"xxx",
            "description":"xxx",
            "website":"xxx",
            "address":"xxx",
	    "certifications":[{
	        "certificationCertId":1,
	        "certificationId":12,
	        "certificationContent":"http://wxe.com/fdsfeirn"
	    }]
            },
        "audit":{
            "companyName":"OK#",
            "legalPerson":"OK#",
            "regTime":"OK#",
            "contactName":"OK#",
            "contactMobileNum":"OK#",
            "businessLicense":"OK#",
            "orgCodeCertificate":"OK#",
            "taxRegistrationCertificate":"OK#",
            "newBusinessLicense":"OK#",
            "businessLicenseExpireTime":"OK#",
            "legalPersonIdentity":"OK#",
            "legalPersonIdentityPic":"OK#",
            "email":"OK#",
            "legalPersonAuthorityBook":"OK#",
            "projectScope":"OK#",
            "description":"OK#",
            "website":"OK#",
            "address":"OK#"
            ,certifications:[
            {"certificationCertId":1,"auditStatus":"OK#"}, 
            {"certificationCertId":2,"auditStatus":"FLS"},
            ]
            },
        "auditStatus":"FLS",
        "auditTime":"2015-11-22 23:23:23"
    }


错误时的JSON数据包示例：

    {"errcode":10000,"errmsg":"查询招标资质认证失败，其它错误"}


参数|是否必须|说明
----|----|-----
companyName|是|公司名称认证结果 
legalPerson|是|公司法人认证结果 
regTime|是|企业成立时间认证结果
contactName|是|联系人认证结果
contactMobileNum|是|  联系人手机号码认证结果
businessLicense|是|营业执照认证结果
orgCodeCertificate|是|组织机构代码证认证结果
taxRegistrationCertificate|是|税务登记证认证结果
newBusinessLicense|是|3合1证认证结果
businessLicenseExpireTime|是|企业营业期限认证结果
legalPersonIdentity|是|法人身份证号认证结果
legalPersonIdentityPic|是|法人身份证扫描件认证结果
email|是|企业电子邮箱认证结果
legalPersonAuthorityBook|是|法人授权书认证结果
projectCcope|是|工程范围认证结果
description|是|公司简介认证结果
website|是|公司网址认证结果
address|是|企业办公地址认证结果
certificationCertId|是|证书记录id
certificationId|是|证书类别id
certificationContent|是|证书内容


###查询未完成的招标人基本信息接口

查询保存的招标人认证申请时的第一步基本信息的接口

http请求方式: post

前置条件：用户必须先登录

     http://ip:port/if/verifyBidee/queryBideeBaseInfo

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
	    "token":"3567"
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
 
    {"errcode":0,"errmsg":"查询未完成的招标人基本信息成功",
	"baseInfo":{
		"companyName":"深圳蜂鸟娱乐技术有限公司",
		"companyShortName":"蜂鸟娱乐",
		"description":"公司简介",
		"registeredCapital":"",
		"telphone":"",
		"email":""
	}
    }

错误时的JSON数据包示例：

    {"errcode":10000,"errmsg":"查询未完成的招标人基本信息失败"}
参数|是否必须|说明
----|----|-----
companyName|是|公司全称
companyShortName|是|公司简称
description|是|description
registeredCapital|是|注册资本
telphone|是|办公电话
email|是|公司邮箱


###保存招标人基本信息接口

保存招标人认证申请时的第一步基本信息的接口

http请求方式: post

前置条件：用户必须先登录

     http://ip:port/if/verifyBidee/saveBideeBaseInfo

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
	    "token":"342567",
	    "companyLogoUrl":""
	    "companyName":"深圳蜂鸟娱乐技术有限公司",
	    "companyShortName":"蜂鸟娱乐",
	    "description":"公司简介",
	    "registeredCapital":"",
	    "telphone":"",
	    "email":""
        }
    } 

参数|是否必须|说明
----|----|-----
appId|是|应用ID
timestamp|是|时间戳
nonce|是|随机数
signature|是|签名值,MD5(按值的字典顺序排列组合成字符串(appId,appKey,app.nonce,app.timeStamp))
token|是|用户令牌
companyLogoUrl|是|公司Logo
companyName|是|公司全称
companyShortName|是|公司简称
description|是|公司简介
registeredCapital|是|注册资本
telphone|是|办公电话
email|是|公司邮箱

2）返回说明

正常时的返回JSON数据包示例：
 
    {"errcode":0,"errmsg":"保存招标人基本信息成功"
    }

错误时的JSON数据包示例：

    {"errcode":10000,"errmsg":"保存招标人基本信息失败"}



###查询招标人法人信息接口

认证招标人第二步，查询保存的招标人法人信息接口


http请求方式: post

前置条件：用户必须先登录

    http://ip:port/if/verifyBidee/queryBideeLegalnInfo


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
	    "token":"53647589"
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
 
    {"errcode":0,"errmsg":"查询招标人法人信息成功",
	"legalnInfo":{
		"legalPersonName":"张三",
		"legalPersonIdentityCardName":"420923199205049230121",
		"legalPersonIdCardProsUrl":"法人身份证正面地址",
		"legalPersonIdCardConsUrl":"法人身份证反面地址",
		"legalPersonAuthorizationUrl":""
	}
    }

错误时的JSON数据包示例：

    {"errcode":10000,"errmsg":"查询招标人法人信息失败"}

参数|是否必须|说明
----|----|-----
token|是|用户令牌
legalPersonName|是|法人姓名
legalPersonIdentityCardName|是|法人身份证号
legalPersonIdCardProsUrl|是|法人身份证正面上传地址
legalPersonIdCardConsUrl|是|法人身份证反面上传地址
legalPersonAuthorizationUrl|否|法人授权书上传地址


###保存招标人法人信息接口

认证招标人第二步，保存招标人法人信息接口


http请求方式: post

前置条件：用户必须先登录

    http://ip:port/if/verifyBidee/saveBideeLegalnInfo


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
	    "token":"36552",	
	    "legalPersonName":"张三",
	    "legalPersonIdCardNum":"420923199205049230121"
            "legalPersonIdCardProsUrl":"法人身份证正面地址",
	    "legalPersonIdCardConsUrl":"法人身份证反面地址",
	    "legalPersonAuthorizationUrl":""

        }
    } 


参数|是否必须|说明
----|----|-----
appId|是|应用ID
timestamp|是|时间戳
nonce|是|随机数
signature|是|签名值,MD5(按值的字典顺序排列组合成字符串(appId,appKey,app.nonce,app.timeStamp))
token|是|用户令牌
legalPersonName|是|法人姓名
legalPersonIdCardNum|是|法人身份证号
legalPersonIdCardProsUrl|是|法人身份证正面上传地址
legalPersonIdCardConsUrl|是|法人身份证反面上传地址
legalPersonAuthorizationUrl|否|法人授权书上传地址

2）返回说明

正常时的返回JSON数据包示例：
 
    {"errcode":0,"errmsg":"保存招标人法人信息成功"
    }

错误时的JSON数据包示例：

    {"errcode":10000,"errmsg":"保存招标人法人信息失败"}


###查询未完成的招标人公司注册信息接口

查询未完成的招标人公司注册信息


http请求方式: post

前置条件：用户必须先登录

    http://ip:port/if/verifyBidee/queryBideeCompanyInfo


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
	     "token":"4567"

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
     "errcode":0,"errmsg":"查询未完成的招标人公司注册信息成功",
     "companyInfo":{
	     "businessScope":"经营范围",
	     "regTime":"2014-04-05",
	     "operationPeriod":"公司营业期限",
	     "address":"",
	     "businessLicenseType":"",
	     "newBusinessLicenseNum":"",
	     "newBusinessLicenseUrl":"",
	     "businessLicenseNum":"36544789",
	     "businessLicenseUrl":"营业执照上传地址",
	     "taxRegistrationNum":"2434567",
	     "taxRegistrationUrl":"税务证书上传地址",
	     "organizationCodeNum":"3w3454676",
	     "organizationCodeUrl":"组织机构代码证上传地址"
        }
    }

错误时的JSON数据包示例：

    {"errcode":10000,"errmsg":"查询未完成的招标人公司注册信息失败"}

参数|是否必须|说明
----|----|-----
businessScope|是|经营范围
regTime|是|注册时间
operationPeriod|是|公司营业期限
address|是|公司地址
businessLicenseType|是|营业执照类型,OLD,三证不合一，NEW，三证合一
newBusinessLicenseNum|是|三合一执照号
newBusinessLicenseUrl|是|三合一执照上传Id
businessLicenseNum|是|营业执照号
businessLicenseUrl|是|营业执照上传地址
taxRegistrationNum|是|税务证书编号
taxRegistrationUrl|是|税务证书上传地址
organizationCodeNum|是|组织机构代码
organizationCodeUrl|是|组织机构代码证上传地址


###保存招标人公司注册信息接口

保存招标人公司注册信息接口


http请求方式: post

前置条件：用户必须先登录

    http://ip:port/if/verifyBidee/saveBideeCompanyInfo


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
	    "token":"53645768",	
	    "businessScope":"经营范围",
	    "regTime":"2014-04-05",
	    "operationPeriod":"公司营业期限",
	    "address":"",
	    "businessLicenseType":"",
	    "newBusinessLicenseNum":"",
	    "newBusinessLicenseUrl":"",
	    "businessLicenseNum":"36544789",
	    "businessLicenseUrl":"营业执照上传地址",
	    "taxRegistrationNum":"2434567",
	    "taxRegistrationUrl":"税务证书上传地址",
	    "organizationCodeNum":"3w3454676",
	    "organizationCodeUrl":"组织机构代码证上传地址",
	   

        }
    } 


参数|是否必须|说明
----|----|-----
appId|是|应用ID
timestamp|是|时间戳
nonce|是|随机数
signature|是|签名值,MD5(按值的字典顺序排列组合成字符串(appId,appKey,app.nonce,app.timeStamp))
token|是|用户令牌
businessScope|是|经营范围
regTime|是|注册时间
operationPeriod|是|公司营业期限
address|是|公司地址
registeredCapital|是|注册资本
businessLicenseType|是|营业执照类型
newBusinessLicenseNum|是|三合一执照号
newBusinessLicenseUrl|是|三合一执照上传Id
businessLicenseNum|是|营业执照号
businessLicenseUrl|是|营业执照上传地址
taxRegistrationNum|是|税务证书编号
taxRegistrationUrl|是|税务证书上传地址
organizationCodeNum|是|组织机构代码
organizationCodeUrl|是|组织机构代码证上传地址


2）返回说明

正常时的返回JSON数据包示例：
 
    {"errcode":0,"errmsg":"保存招标人公司注册信息成功"
    }

错误时的JSON数据包示例：

    {"errcode":10000,"errmsg":"保存招标人公司注册信息失败"}


###查询未完成的招标人开户行信息接口

查询未完成的招标人开户行信息接口


http请求方式: post

前置条件：用户必须先登录

    http://ip:port/if/verifyBidee/queryBideeBankInfo


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
	    "token":"45467487"

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
 
    {"errcode":0,"errmsg":"招标方认证信息保存成功",	
	"bankInfo":{ 
	    "bank":"招商银行",
	    "subBranch":"支行",
	    "bankCardNum":"256478968",
	    "accountName":"账户名称"
	    }
    }

错误时的JSON数据包示例：

    {"errcode":10000,"errmsg":"招标方认证信息保存失败"}

参数|是否必须|说明
----|----|-----
bank|是|开户银行
subBranch|是|开户支行
bankCardNum|是|银行账户
accountName|是|账户名称


###保存招标人开户行信息接口

前端页面通过该接口认证招标方信息


http请求方式: post

前置条件：用户必须先登录

    http://ip:port/if/verifyBidee/saveBideeBankInfo


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
	    "token":"26789",	
	    "bank":"招商银行",
	    "subBranch":"支行",
	    "bankCardNum":"",
	    "accountName":"账户名称",

        }
    } 


参数|是否必须|说明
----|----|-----
appId|是|应用ID
timestamp|是|时间戳
nonce|是|随机数
signature|是|签名值,MD5(按值的字典顺序排列组合成字符串(appId,appKey,app.nonce,app.timeStamp))
token|是|用户令牌
bank|是|开户银行
subBranch|是|开户支行
bankCardNum|是|银行账户
accountName|是|账户名称

2）返回说明

正常时的返回JSON数据包示例：
 
    {"errcode":0,"errmsg":"保存招标人开户行信息成功"
    }

错误时的JSON数据包示例：

    {"errcode":10000,"errmsg":"保存招标人开户行信息失败"}

###查询未完成的招标人行业资质接口

前端页面通过该接口认证招标方信息


http请求方式: post

前置条件：用户必须先登录

    http://ip:port/if/verifyBidee/queryBideeCertificateInfo


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
	    "token":"43565789"
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
 
    {"errcode":0,"errmsg":"查询招标人行业资质成功",
	"certificateInfo":{ 
	   "projectCategoryId":[1,3,5],
	   "enterpriseQualification":[{
	       "certificationCertId":1,
	       "certificationId":12,
	       "certificationName":"桩工程一级资质",
	       "certificationContent":"http://wxe.com/fdsfeirn",
	       "expiryDate":"2016-09-12"
	   }],
	 }  
    }

错误时的JSON数据包示例：

    {"errcode":10000,"errmsg":"查询招标人行业资质失败"}

参数|是否必须|说明
----|----|-----
projectCategoryId|是|工程类别
enterpriseQualification.certificateId|是|资质证书Id
enterpriseQualification.certificationCertId|是|记录Id
enterpriseQualification.certificationContent|是|证书上传地址
enterpriseQualification.expiryDate|是|有效期

###保存招标人行业资质接口

前端页面通过该接口保存招标人行业资质


http请求方式: post

前置条件：用户必须先登录

    http://ip:port/if/verifyBidee/saveBideeCertificateInfo


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
	    "token":"98762",	
	    "projectCategoryId":[1,3,5],
	    "enterpriseQualification":
		    [{"certificateId":2,"certificateUrl":"","action":"ADD","certificationCertId":1},
		    {"certificateId":3,"certificateUrl":"","action":"DEL","certificationCertId":1}]
	   
        }
    } 


参数|是否必须|说明
----|----|-----
appId|是|应用ID
timestamp|是|时间戳
nonce|是|随机数
signature|是|签名值,MD5(按值的字典顺序排列组合成字符串(appId,appKey,app.nonce,app.timeStamp))
token|是|用户令牌
projectCategoryId|是|工程类别
enterpriseQualification.certificateId|是|资质证书Id
enterpriseQualification.certificateUrl|是|资质证书上传地址
enterpriseQualification.action|是|页面状态 "ADD""DEL""UPT"
enterpriseQualification.certificationCertId|否|原证书记录Id

2）返回说明

正常时的返回JSON数据包示例：
 
    {"errcode":0,"errmsg":"保存招标人行业资质成功"
    }

错误时的JSON数据包示例：

    {"errcode":10000,"errmsg":"保存招标人行业资质失败"}



###提交招标人认证申请接口

前端页面通过该接口认证招标方信息,此接口要判断资料是否齐全，状态是否为新增，不通过


http请求方式: post

前置条件：用户必须先登录

    http://ip:port/if/verifyBidee/submitBideeApplication


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
	    "token":"25678"
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
 
    {"errcode":0,"errmsg":"提交招标人认证申请成功"
    }

错误时的JSON数据包示例：

    {"errcode":10000,"errmsg":"提交招标人认证申请失败"}
