###��ѯ�ҵ�Ͷ������֤��Ϣ�ӿ�

�ýӿ����ڲ�ѯ������֤�����������������һ�ε�������֤����ȡ��Ϣ��

ǰ�ã��ȵ�¼

http����ʽ: post

    http://ip:port/if/verifyBider/bidderCertificateResult


POST���ݸ�ʽ��JSON

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


����|�Ƿ����|˵��
----|----|-----
appId|��|Ӧ��ID
timestamp|��|ʱ���
nonce|��|�����
signature|��|ǩ��ֵ,MD5(��ֵ���ֵ�˳��������ϳ��ַ���(appId,appKey,app.nonce,app.timeStamp))
token|��|�û�����


2������˵��

����ʱ�ķ���JSON���ݰ�ʾ����
 
    {"errcode":0,"errmsg":"��ѯͶ�귽������֤����ɹ�",
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
            "address":"xxx"
            ,certifications:[
            {"certificationCertId":1,"certificationId":12,"certificationContent":"http://wxe.com/fdsfeirn"},
            {"certificationCertId":2,"certificationId":22,"certificationContent":"http://wxe.com/fdsfei3rn"}
            ]
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


����ʱ��JSON���ݰ�ʾ����

    {"errcode":10000,"errmsg":"��ѯͶ��������֤���ʧ�ܣ���������"}


����|�Ƿ����|˵��
----|----|-----
companyName|��|��˾������֤��� 
legalPerson|��|��˾������֤��� 
regTime|��|��ҵ����ʱ����֤���
contactName|��|��ϵ����֤���
contactMobileNum|��|  ��ϵ���ֻ�������֤���
businessLicense|��|Ӫҵִ����֤���
orgCodeCertificate|��|��֯��������֤��֤���
taxRegistrationCertificate|��|˰��Ǽ�֤��֤���
newBusinessLicense|��|3��1֤��֤���
businessLicenseExpireTime|��|��ҵӪҵ������֤���
legalPersonIdentity|��|�������֤����֤���
legalPersonIdentityPic|��|�������֤ɨ�����֤���
email|��|��ҵ����������֤���
legalPersonAuthorityBook|��|������Ȩ����֤���
projectCcope|��|���̷�Χ��֤���
description|��|��˾�����֤���
website|��|��˾��ַ��֤���
address|��|��ҵ�칫��ַ��֤���
certificationCertId|��|֤���¼id
certificationId|��|֤�����id
certificationContent|��|֤������


###��ѯδ��ɵ�Ͷ���˻�����Ϣ�ӿ�

��ѯ�����Ͷ������֤����ʱ�ĵ�һ��������Ϣ�Ľӿ�

http����ʽ: post

ǰ���������û������ȵ�¼

     http://ip:port/if/verifyBider/queryBiderBaseInfo

POST���ݸ�ʽ��JSON

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

����|�Ƿ����|˵��
----|----|-----
appId|��|Ӧ��ID
timestamp|��|ʱ���
nonce|��|�����
signature|��|ǩ��ֵ,MD5(��ֵ���ֵ�˳��������ϳ��ַ���(appId,appKey,app.nonce,app.timeStamp))
token|��|�û�����

2������˵��

����ʱ�ķ���JSON���ݰ�ʾ����
 
    {"errcode":0,"errmsg":"��ѯδ��ɵ�Ͷ���˻�����Ϣ�ɹ�",
	"baseInfo":{
		"companyName":"���ڷ������ּ������޹�˾",
		"companyShortName":"��������",
		"description":"��˾���",
		"registeredCapital":"",
		"telphone":"",
		"email":""
	}
    }

����ʱ��JSON���ݰ�ʾ����

    {"errcode":10000,"errmsg":"��ѯδ��ɵ�Ͷ���˻�����Ϣʧ��"}
����|�Ƿ����|˵��
----|----|-----
companyName|��|��˾ȫ��
companyShortName|��|��˾���
description|��|description
registeredCapital|��|ע���ʱ�
telphone|��|�칫�绰
email|��|��˾����


###����Ͷ���˻�����Ϣ�ӿ�

����Ͷ������֤����ʱ�ĵ�һ��������Ϣ�Ľӿ�

http����ʽ: post

ǰ���������û������ȵ�¼

     http://ip:port/if/verifyBider/saveBiderBaseInfo

POST���ݸ�ʽ��JSON

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
	    "companyName":"���ڷ������ּ������޹�˾",
	    "companyShortName":"��������",
	    "description":"��˾���",
	    "registeredCapital":"",
	    "telphone":"",
	    "email":""
        }
    } 

����|�Ƿ����|˵��
----|----|-----
appId|��|Ӧ��ID
timestamp|��|ʱ���
nonce|��|�����
signature|��|ǩ��ֵ,MD5(��ֵ���ֵ�˳��������ϳ��ַ���(appId,appKey,app.nonce,app.timeStamp))
token|��|�û�����
companyLogoUrl|��|��˾Logo
companyName|��|��˾ȫ��
companyShortName|��|��˾���
description|��|��˾���
registeredCapital|��|ע���ʱ�
telphone|��|�칫�绰
email|��|��˾����

2������˵��

����ʱ�ķ���JSON���ݰ�ʾ����
 
    {"errcode":0,"errmsg":"����Ͷ���˻�����Ϣ�ɹ�"
    }

����ʱ��JSON���ݰ�ʾ����

    {"errcode":10000,"errmsg":"����Ͷ���˻�����Ϣʧ��"}



###��ѯδ��ɵ�Ͷ���˻�����Ϣ�ӿ�

��֤Ͷ���˵ڶ�������ѯ�����Ͷ���˷�����Ϣ�ӿ�


http����ʽ: post

ǰ���������û������ȵ�¼

    http://ip:port/if/verifyBider/queryBiderLegalnInfo


POST���ݸ�ʽ��JSON

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


����|�Ƿ����|˵��
----|----|-----
appId|��|Ӧ��ID
timestamp|��|ʱ���
nonce|��|�����
signature|��|ǩ��ֵ,MD5(��ֵ���ֵ�˳��������ϳ��ַ���(appId,appKey,app.nonce,app.timeStamp))
token|��|�û�����

2������˵��

����ʱ�ķ���JSON���ݰ�ʾ����
 
    {"errcode":0,"errmsg":"��ѯͶ���˷�����Ϣ�ɹ�",
	"legalnInfo":{
		"legalPersonName":"����",
		"legalPersonIdentityCardName":"420923199205049230121",
		"legalPersonIdCardProsUrl":"�������֤�����ַ",
		"legalPersonIdCardConsUrl":"�������֤�����ַ",
		"legalPersonAuthorizationUrl":""
	}
    }

����ʱ��JSON���ݰ�ʾ����

    {"errcode":10000,"errmsg":"��ѯͶ���˷�����Ϣʧ��"}

����|�Ƿ����|˵��
----|----|-----
token|��|�û�����
legalPersonName|��|��������
legalPersonIdentityCardName|��|�������֤��
legalPersonIdCardProsUrl|��|�������֤�����ϴ���ַ
legalPersonIdCardConsUrl|��|�������֤�����ϴ���ַ
legalPersonAuthorizationUrl|��|������Ȩ���ϴ���ַ


###����Ͷ���˷�����Ϣ�ӿ�

��֤Ͷ���˵ڶ���������Ͷ���˷�����Ϣ�ӿ�


http����ʽ: post

ǰ���������û������ȵ�¼

    http://ip:port/if/verifyBider/saveBiderLegalnInfo


POST���ݸ�ʽ��JSON

    {
        "app":{
            "appId":"zjhtwallet",
            "timeStamp":"TIMESTAMP", 
            "nonce":"NONCE",
            "signature":"SIGNATURE"
        },        
        "body":
        {
	    "token":"2",	
	    "legalPersonName":"����",
	    "legalPersonIdCardNum":"420923199205049230121"
            "legalPersonIdCardProsUrl":"�������֤�����ַ",
	    "legalPersonIdCardConsUrl":"�������֤�����ַ",
	    "legalPersonAuthorizationUrl":""

        }
    } 


����|�Ƿ����|˵��
----|----|-----
appId|��|Ӧ��ID
timestamp|��|ʱ���
nonce|��|�����
signature|��|ǩ��ֵ,MD5(��ֵ���ֵ�˳��������ϳ��ַ���(appId,appKey,app.nonce,app.timeStamp))
token|��|�û�����
legalPersonName|��|��������
legalPersonIdCardNum|��|�������֤��
legalPersonIdCardProsUrl|��|�������֤�����ϴ���ַ
legalPersonIdCardConsUrl|��|�������֤�����ϴ���ַ
legalPersonAuthorizationUrl|��|������Ȩ���ϴ���ַ

2������˵��

����ʱ�ķ���JSON���ݰ�ʾ����
 
    {"errcode":0,"errmsg":"����Ͷ���˷�����Ϣ�ɹ�"
    }

����ʱ��JSON���ݰ�ʾ����

    {"errcode":10000,"errmsg":"����Ͷ���˷�����Ϣʧ��"}


###��ѯδ��ɵ�Ͷ���˹�˾ע����Ϣ�ӿ�

��ѯδ��ɵ�Ͷ���˹�˾ע����Ϣ


http����ʽ: post

ǰ���������û������ȵ�¼

    http://ip:port/if/verifyBider/queryBiderCompanyInfo


POST���ݸ�ʽ��JSON

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


����|�Ƿ����|˵��
----|----|-----
appId|��|Ӧ��ID
timestamp|��|ʱ���
nonce|��|�����
signature|��|ǩ��ֵ,MD5(��ֵ���ֵ�˳��������ϳ��ַ���(appId,appKey,app.nonce,app.timeStamp))
token|��|�û�����

2������˵��

����ʱ�ķ���JSON���ݰ�ʾ����
 
    {
     "errcode":0,"errmsg":"��ѯδ��ɵ�Ͷ���˹�˾ע����Ϣ�ɹ�",
     "companyInfo":{
	     "businessScope":"��Ӫ��Χ",
	     "regTime":"2014-04-05",
	     "operationPeriod":"��˾Ӫҵ����",
	     "address":"",
	     "businessLicenseType":"",
	     "newBusinessLicenseNum":"",
	     "newBusinessLicenseUrl":"",
	     "businessLicenseNum":"36544789",
	     "businessLicenseUrl":"Ӫҵִ���ϴ���ַ",
	     "taxRegistrationNum":"2434567",
	     "taxRegistrationUrl":"˰��֤���ϴ���ַ",
	     "organizationCodeNum":"3w3454676",
	     "organizationCodeUrl":"��֯��������֤�ϴ���ַ"
     }
    }

����ʱ��JSON���ݰ�ʾ����

    {"errcode":10000,"errmsg":"��ѯδ��ɵ�Ͷ���˹�˾ע����Ϣʧ��"}

����|�Ƿ����|˵��
----|----|-----
businessScope|��|��Ӫ��Χ
regTime|��|ע��ʱ��
operationPeriod|��|��˾Ӫҵ����
address|��|��˾��ַ
businessLicenseType|��|Ӫҵִ������,OLD,��֤����һ��NEW����֤��һ
newBusinessLicenseNum|��|����һִ�պ�
newBusinessLicenseUrl|��|����һִ���ϴ�Id
businessLicenseNum|��|Ӫҵִ�պ�
businessLicenseUrl|��|Ӫҵִ���ϴ���ַ
taxRegistrationNum|��|˰��֤����
taxRegistrationUrl|��|˰��֤���ϴ���ַ
organizationCodeNum|��|��֯��������
organizationCodeUrl|��|��֯��������֤�ϴ���ַ


###����Ͷ���˹�˾ע����Ϣ�ӿ�

����Ͷ���˹�˾ע����Ϣ�ӿ�


http����ʽ: post

ǰ���������û������ȵ�¼

    http://ip:port/if/verifyBider/saveBiderCompanyInfo


POST���ݸ�ʽ��JSON

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
	    "businessScope":"��Ӫ��Χ",
	    "regTime":"2014-04-05",
	    "operationPeriod":"��˾Ӫҵ����",
	    "address":"",
	    "businessLicenseType":"",
	    "newBusinessLicenseNum":"",
	    "newBusinessLicenseUrl":"",
	    "businessLicenseNum":"36544789",
	    "businessLicenseUrl":"Ӫҵִ���ϴ���ַ",
	    "taxRegistrationNum":"2434567",
	    "taxRegistrationUrl":"˰��֤���ϴ���ַ",
	    "organizationCodeNum":"3w3454676",
	    "organizationCodeUrl":"��֯��������֤�ϴ���ַ",
	   

        }
    } 


����|�Ƿ����|˵��
----|----|-----
appId|��|Ӧ��ID
timestamp|��|ʱ���
nonce|��|�����
signature|��|ǩ��ֵ,MD5(��ֵ���ֵ�˳��������ϳ��ַ���(appId,appKey,app.nonce,app.timeStamp))
token|��|�û�����
businessScope|��|��Ӫ��Χ
regTime|��|ע��ʱ��
operationPeriod|��|��˾Ӫҵ����
address|��|��˾��ַ
registeredCapital|��|ע���ʱ�
businessLicenseType|��|Ӫҵִ������
newBusinessLicenseNum|��|����һִ�պ�
newBusinessLicenseUrl|��|����һִ���ϴ�Id
businessLicenseNum|��|Ӫҵִ�պ�
businessLicenseUrl|��|Ӫҵִ���ϴ���ַ
taxRegistrationNum|��|˰��֤����
taxRegistrationUrl|��|˰��֤���ϴ���ַ
organizationCodeNum|��|��֯��������
organizationCodeUrl|��|��֯��������֤�ϴ���ַ


2������˵��

����ʱ�ķ���JSON���ݰ�ʾ����
 
    {"errcode":0,"errmsg":"����Ͷ���˹�˾ע����Ϣ�ɹ�"
    }

����ʱ��JSON���ݰ�ʾ����

    {"errcode":10000,"errmsg":"����Ͷ���˹�˾ע����Ϣʧ��"}


###��ѯδ��ɵ�Ͷ���˿�������Ϣ�ӿ�

��ѯδ��ɵ�Ͷ���˿�������Ϣ�ӿ�


http����ʽ: post

ǰ���������û������ȵ�¼

    http://ip:port/if/verifyBider/queryBiderBankInfo


POST���ݸ�ʽ��JSON

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


����|�Ƿ����|˵��
----|----|-----
appId|��|Ӧ��ID
timestamp|��|ʱ���
nonce|��|�����
signature|��|ǩ��ֵ,MD5(��ֵ���ֵ�˳��������ϳ��ַ���(appId,appKey,app.nonce,app.timeStamp))
token|��|�û�����

2������˵��

����ʱ�ķ���JSON���ݰ�ʾ����
 
    {"errcode":0,"errmsg":"Ͷ�귽��֤��Ϣ����ɹ�",	
	"bankInfo":{ 
	    "bank":"��������",
	    "subBranch":"֧��",
	    "bankCardNum":"256478968",
	    "accountName":"�˻�����"
	    }
    }

����ʱ��JSON���ݰ�ʾ����

    {"errcode":10000,"errmsg":"Ͷ�귽��֤��Ϣ����ʧ��"}

����|�Ƿ����|˵��
----|----|-----
bank|��|��������
subBranch|��|����֧��
bankCardNum|��|�����˻�
accountName|��|�˻�����


###����Ͷ���˿�������Ϣ�ӿ�

ǰ��ҳ��ͨ���ýӿ���֤Ͷ�귽��Ϣ


http����ʽ: post

ǰ���������û������ȵ�¼

    http://ip:port/if/verifyBider/saveBiderBankInfo


POST���ݸ�ʽ��JSON

    {
        "app":{
            "appId":"zjhtwallet",
            "timeStamp":"TIMESTAMP", 
            "nonce":"NONCE",
            "signature":"SIGNATURE"
        },        
        "body":
        {
	    "token":2,	
	    "bank":"��������",
	    "subBranch":"֧��",
	    "bankCardNum":"",
	    "accountName":"�˻�����",

        }
    } 


����|�Ƿ����|˵��
----|----|-----
appId|��|Ӧ��ID
timestamp|��|ʱ���
nonce|��|�����
signature|��|ǩ��ֵ,MD5(��ֵ���ֵ�˳��������ϳ��ַ���(appId,appKey,app.nonce,app.timeStamp))
token|��|�û�����
bank|��|��������
subBranch|��|����֧��
bankCardNum|��|�����˻�
accountName|��|�˻�����

2������˵��

����ʱ�ķ���JSON���ݰ�ʾ����
 
    {"errcode":0,"errmsg":"����Ͷ���˿�������Ϣ�ɹ�"
    }

����ʱ��JSON���ݰ�ʾ����

    {"errcode":10000,"errmsg":"����Ͷ���˿�������Ϣʧ��"}

###��ѯδ��ɵ�Ͷ������ҵ���ʽӿ�

ǰ��ҳ��ͨ���ýӿ���֤Ͷ�귽��Ϣ


http����ʽ: post

ǰ���������û������ȵ�¼

    http://ip:port/if/verifyBider/queryBiderCertificateInfo


POST���ݸ�ʽ��JSON

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


����|�Ƿ����|˵��
----|----|-----
appId|��|Ӧ��ID
timestamp|��|ʱ���
nonce|��|�����
signature|��|ǩ��ֵ,MD5(��ֵ���ֵ�˳��������ϳ��ַ���(appId,appKey,app.nonce,app.timeStamp))
token|��|�û�����


2������˵��

����ʱ�ķ���JSON���ݰ�ʾ����
 
    {"errcode":0,"errmsg":"��ѯͶ������ҵ���ʳɹ�",
	"certificateInfo":{ 
	   "projectCategoryId":[1,3,5],
	   "enterpriseQualification":[{"certificationCertId":1,"certificationId":12,"certificationName":"׮����һ������","certificationContent":"http://wxe.com/fdsfeirn","expiryDate":"2016-09-12"}],
	 }  
    }

����ʱ��JSON���ݰ�ʾ����

    {"errcode":10000,"errmsg":"��ѯͶ������ҵ����ʧ��"}

����|�Ƿ����|˵��
----|----|-----
projectCategoryId|��|�������
enterpriseQualification.certificateId|��|����֤��Id
enterpriseQualification.certificationCertId|��|��¼Id
enterpriseQualification.certificationContent|��|֤���ϴ���ַ
enterpriseQualification.expiryDate|��|��Ч��

###����Ͷ������ҵ���ʽӿ�

ǰ��ҳ��ͨ���ýӿڱ���Ͷ������ҵ����


http����ʽ: post

ǰ���������û������ȵ�¼

    http://ip:port/if/verifyBider/saveBiderCertificateInfo


POST���ݸ�ʽ��JSON

    {
        "app":{
            "appId":"zjhtwallet",
            "timeStamp":"TIMESTAMP", 
            "nonce":"NONCE",
            "signature":"SIGNATURE"
        },        
        "body":
        {
	    "token":2,	
	    "projectCategoryId":[1,3,5],
	    "enterpriseQualification":
		    [{"certificateId":2,"certificateUrl":"","action":"ADD","certificationCertId":1},
		    {"certificateId":3,"certificateUrl":"","action":"DEL","certificationCertId":1}]
	   
        }
    } 


����|�Ƿ����|˵��
----|----|-----
appId|��|Ӧ��ID
timestamp|��|ʱ���
nonce|��|�����
signature|��|ǩ��ֵ,MD5(��ֵ���ֵ�˳��������ϳ��ַ���(appId,appKey,app.nonce,app.timeStamp))
token|��|�û�����
projectCategoryId|��|�������
enterpriseQualification.certificateId|��|����֤��Id
enterpriseQualification.certificateUrl|��|����֤���ϴ���ַ
enterpriseQualification.action|��|ҳ��״̬ "ADD""DEL""UPT"
enterpriseQualification.certificationCertId|��|ԭ֤���¼Id

2������˵��

����ʱ�ķ���JSON���ݰ�ʾ����
 
    {"errcode":0,"errmsg":"����Ͷ������ҵ���ʳɹ�"
    }

����ʱ��JSON���ݰ�ʾ����

    {"errcode":10000,"errmsg":"����Ͷ������ҵ����ʧ��"}



###�ύͶ������֤����ӿ�

ǰ��ҳ��ͨ���ýӿ���֤Ͷ�귽��Ϣ,�˽ӿ�Ҫ�ж������Ƿ���ȫ��״̬�Ƿ�Ϊ��������ͨ��


http����ʽ: post

ǰ���������û������ȵ�¼

    http://ip:port/if/verifyBider/submitBiderApplication


POST���ݸ�ʽ��JSON

    {
        "app":{
            "appId":"zjhtwallet",
            "timeStamp":"TIMESTAMP", 
            "nonce":"NONCE",
            "signature":"SIGNATURE"
        },        
        "body":
        {
	    "token":"2"
        }
    } 


����|�Ƿ����|˵��
----|----|-----
appId|��|Ӧ��ID
timestamp|��|ʱ���
nonce|��|�����
signature|��|ǩ��ֵ,MD5(��ֵ���ֵ�˳��������ϳ��ַ���(appId,appKey,app.nonce,app.timeStamp))
token|��|�û�����

2������˵��

����ʱ�ķ���JSON���ݰ�ʾ����
 
    {"errcode":0,"errmsg":"�ύͶ������֤����ɹ�"
    }

����ʱ��JSON���ݰ�ʾ����

    {"errcode":10000,"errmsg":"�ύͶ������֤����ʧ��"}