###��ѯ�ҵ��б�����֤��Ϣ�ӿ�

�ýӿ����ڲ�ѯ������֤�����������������һ�ε�������֤����ȡ��Ϣ��

ǰ�ã��ȵ�¼

http����ʽ: post

    http://ip:port/if/verifyBidee/biddeeCertificateResult


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
 
    {"errcode":0,"errmsg":"��ѯ�б귽������֤����ɹ�",
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


����ʱ��JSON���ݰ�ʾ����

    {"errcode":10000,"errmsg":"��ѯ�б�������֤ʧ�ܣ���������"}


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


###��ѯδ��ɵ��б��˻�����Ϣ�ӿ�

��ѯ������б�����֤����ʱ�ĵ�һ��������Ϣ�Ľӿ�

http����ʽ: post

ǰ���������û������ȵ�¼

     http://ip:port/if/verifyBidee/queryBideeBaseInfo

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
 
    {"errcode":0,"errmsg":"��ѯδ��ɵ��б��˻�����Ϣ�ɹ�",
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

    {"errcode":10000,"errmsg":"��ѯδ��ɵ��б��˻�����Ϣʧ��"}
����|�Ƿ����|˵��
----|----|-----
companyName|��|��˾ȫ��
companyShortName|��|��˾���
description|��|description
registeredCapital|��|ע���ʱ�
telphone|��|�칫�绰
email|��|��˾����


###�����б��˻�����Ϣ�ӿ�

�����б�����֤����ʱ�ĵ�һ��������Ϣ�Ľӿ�

http����ʽ: post

ǰ���������û������ȵ�¼

     http://ip:port/if/verifyBidee/saveBideeBaseInfo

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
 
    {"errcode":0,"errmsg":"�����б��˻�����Ϣ�ɹ�"
    }

����ʱ��JSON���ݰ�ʾ����

    {"errcode":10000,"errmsg":"�����б��˻�����Ϣʧ��"}



###��ѯ�б��˷�����Ϣ�ӿ�

��֤�б��˵ڶ�������ѯ������б��˷�����Ϣ�ӿ�


http����ʽ: post

ǰ���������û������ȵ�¼

    http://ip:port/if/verifyBidee/queryBideeLegalnInfo


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
 
    {"errcode":0,"errmsg":"��ѯ�б��˷�����Ϣ�ɹ�",
	"legalnInfo":{
		"legalPersonName":"����",
		"legalPersonIdentityCardName":"420923199205049230121",
		"legalPersonIdCardProsUrl":"�������֤�����ַ",
		"legalPersonIdCardConsUrl":"�������֤�����ַ",
		"legalPersonAuthorizationUrl":""
	}
    }

����ʱ��JSON���ݰ�ʾ����

    {"errcode":10000,"errmsg":"��ѯ�б��˷�����Ϣʧ��"}

����|�Ƿ����|˵��
----|----|-----
token|��|�û�����
legalPersonName|��|��������
legalPersonIdentityCardName|��|�������֤��
legalPersonIdCardProsUrl|��|�������֤�����ϴ���ַ
legalPersonIdCardConsUrl|��|�������֤�����ϴ���ַ
legalPersonAuthorizationUrl|��|������Ȩ���ϴ���ַ


###�����б��˷�����Ϣ�ӿ�

��֤�б��˵ڶ����������б��˷�����Ϣ�ӿ�


http����ʽ: post

ǰ���������û������ȵ�¼

    http://ip:port/if/verifyBidee/saveBideeLegalnInfo


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
	    "token":"36552",	
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
 
    {"errcode":0,"errmsg":"�����б��˷�����Ϣ�ɹ�"
    }

����ʱ��JSON���ݰ�ʾ����

    {"errcode":10000,"errmsg":"�����б��˷�����Ϣʧ��"}


###��ѯδ��ɵ��б��˹�˾ע����Ϣ�ӿ�

��ѯδ��ɵ��б��˹�˾ע����Ϣ


http����ʽ: post

ǰ���������û������ȵ�¼

    http://ip:port/if/verifyBidee/queryBideeCompanyInfo


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
     "errcode":0,"errmsg":"��ѯδ��ɵ��б��˹�˾ע����Ϣ�ɹ�",
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

    {"errcode":10000,"errmsg":"��ѯδ��ɵ��б��˹�˾ע����Ϣʧ��"}

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


###�����б��˹�˾ע����Ϣ�ӿ�

�����б��˹�˾ע����Ϣ�ӿ�


http����ʽ: post

ǰ���������û������ȵ�¼

    http://ip:port/if/verifyBidee/saveBideeCompanyInfo


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
 
    {"errcode":0,"errmsg":"�����б��˹�˾ע����Ϣ�ɹ�"
    }

����ʱ��JSON���ݰ�ʾ����

    {"errcode":10000,"errmsg":"�����б��˹�˾ע����Ϣʧ��"}


###��ѯδ��ɵ��б��˿�������Ϣ�ӿ�

��ѯδ��ɵ��б��˿�������Ϣ�ӿ�


http����ʽ: post

ǰ���������û������ȵ�¼

    http://ip:port/if/verifyBidee/queryBideeBankInfo


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
 
    {"errcode":0,"errmsg":"�б귽��֤��Ϣ����ɹ�",	
	"bankInfo":{ 
	    "bank":"��������",
	    "subBranch":"֧��",
	    "bankCardNum":"256478968",
	    "accountName":"�˻�����"
	    }
    }

����ʱ��JSON���ݰ�ʾ����

    {"errcode":10000,"errmsg":"�б귽��֤��Ϣ����ʧ��"}

����|�Ƿ����|˵��
----|----|-----
bank|��|��������
subBranch|��|����֧��
bankCardNum|��|�����˻�
accountName|��|�˻�����


###�����б��˿�������Ϣ�ӿ�

ǰ��ҳ��ͨ���ýӿ���֤�б귽��Ϣ


http����ʽ: post

ǰ���������û������ȵ�¼

    http://ip:port/if/verifyBidee/saveBideeBankInfo


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
	    "token":"26789",	
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
 
    {"errcode":0,"errmsg":"�����б��˿�������Ϣ�ɹ�"
    }

����ʱ��JSON���ݰ�ʾ����

    {"errcode":10000,"errmsg":"�����б��˿�������Ϣʧ��"}

###��ѯδ��ɵ��б�����ҵ���ʽӿ�

ǰ��ҳ��ͨ���ýӿ���֤�б귽��Ϣ


http����ʽ: post

ǰ���������û������ȵ�¼

    http://ip:port/if/verifyBidee/queryBideeCertificateInfo


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
 
    {"errcode":0,"errmsg":"��ѯ�б�����ҵ���ʳɹ�",
	"certificateInfo":{ 
	   "projectCategoryId":[1,3,5],
	   "enterpriseQualification":[{
	       "certificationCertId":1,
	       "certificationId":12,
	       "certificationName":"׮����һ������",
	       "certificationContent":"http://wxe.com/fdsfeirn",
	       "expiryDate":"2016-09-12"
	   }],
	 }  
    }

����ʱ��JSON���ݰ�ʾ����

    {"errcode":10000,"errmsg":"��ѯ�б�����ҵ����ʧ��"}

����|�Ƿ����|˵��
----|----|-----
projectCategoryId|��|�������
enterpriseQualification.certificateId|��|����֤��Id
enterpriseQualification.certificationCertId|��|��¼Id
enterpriseQualification.certificationContent|��|֤���ϴ���ַ
enterpriseQualification.expiryDate|��|��Ч��

###�����б�����ҵ���ʽӿ�

ǰ��ҳ��ͨ���ýӿڱ����б�����ҵ����


http����ʽ: post

ǰ���������û������ȵ�¼

    http://ip:port/if/verifyBidee/saveBideeCertificateInfo


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
	    "token":"98762",	
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
 
    {"errcode":0,"errmsg":"�����б�����ҵ���ʳɹ�"
    }

����ʱ��JSON���ݰ�ʾ����

    {"errcode":10000,"errmsg":"�����б�����ҵ����ʧ��"}



###�ύ�б�����֤����ӿ�

ǰ��ҳ��ͨ���ýӿ���֤�б귽��Ϣ,�˽ӿ�Ҫ�ж������Ƿ���ȫ��״̬�Ƿ�Ϊ��������ͨ��


http����ʽ: post

ǰ���������û������ȵ�¼

    http://ip:port/if/verifyBidee/submitBideeApplication


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
	    "token":"25678"
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
 
    {"errcode":0,"errmsg":"�ύ�б�����֤����ɹ�"
    }

����ʱ��JSON���ݰ�ʾ����

    {"errcode":10000,"errmsg":"�ύ�б�����֤����ʧ��"}
