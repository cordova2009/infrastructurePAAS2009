package com.hummingbird.paas.entity;

import java.util.Date;

/**
 * 招标人资质认证申请审核表
 */
public class BiddeeCertificateAduit {
    /**
     * 主键
     */
    private Integer id;

    /**
     * 招标人资质认证历史表id
     */
    private Integer biddeeCerticateId;

    /**
     * 公司名称认证备注
     */
    private String companyNameMsg;

    /**
     * 法人名称认证备注
     */
    private String legalPersonMsg;

    /**
     * 企业成立时间认证备注
     */
    private String regTimeMsg;

    /**
     * 联系人认证备注
     */
    private String contactNameMsg;

    /**
     * 联系人手机号码认证备注
     */
    private String contactMobileNumMsg;

    /**
     * 营业执照认证备注
     */
    private String businessLicenseMsg;

    /**
     * 组织机构代码证认证备注
     */
    private String orgCodeCertificateMsg;

    /**
     * 税务登记证认证备注
     */
    private String taxRegistrationCertificateMsg;

    /**
     * 3合1证认证备注
     */
    private String newBusinessLicenseMsg;

    /**
     * 企业营业期限认证备注
     */
    private String businessLicenseExpireTimeMsg;

    /**
     * 企业电子邮箱认证备注
     */
    private String emailMsg;

    /**
     * 法人授权书认证备注
     */
    private String legalPersonAuthorityBookMsg;

    /**
     * 工程范围认证备注
     */
    private String projectScopeMsg;

    /**
     * 公司简介认证备注
     */
    private String descriptionMsg;

    /**
     * 公司网址认证备注
     */
    private String websiteMsg;

    /**
     * 公司logo,照片地址认证备注
     */
    private String logoMsg;

    /**
     * 公司简称认证备注
     */
    private String shortNameMsg;

    /**
     * 注册资本认证备注
     */
    private String registeredCapitalMsg;

    /**
     * 经营范围认证备注
     */
    private String businessScopeMsg;

    /**
     * 企业办公地址认证结果认证备注
     */
    private String addressMsg;

    /**
     * 法人身份证号认证备注
     */
    private String legalPersonIdcardMsg;

    /**
     * 法人身份证扫描件(正面)认证备注
     */
    private String legalPersonIdcardFrontUrlMsg;

    /**
     * 法人身份证扫描件(反面)认证备注
     */
    private String legalPersonIdcardBackUrlMsg;

    /**
     * 营业执照扫描件认证备注
     */
    private String businessLicenseUrlMsg;

    /**
     * 组织机构代码证扫描件认证备注
     */
    private String orgCodeCertificateUrlMsg;

    /**
     * 税务登记证扫描件认证备注
     */
    private String taxRegistrationCertificateUrlMsg;

    /**
     * 统一社会信用代码认证备注
     */
    private String unifiedSocialCreditCodeMsg;

    /**
     * 统一社会信用代码扫描件认证备注
     */
    private String unifiedSocialCreditCodeUrlMsg;

    /**
     * 公司名称认证备注
     */
    private String companyName;

    /**
     * 法人名称认证备注
     */
    private String legalPerson;

    /**
     * 企业成立时间认证备注
     */
    private String regTime;

    /**
     * 联系人认证备注
     */
    private String contactName;

    /**
     * 联系人手机号码认证备注
     */
    private String contactMobileNum;

    /**
     * 营业执照认证备注
     */
    private String businessLicense;

    /**
     * 组织机构代码证认证备注
     */
    private String orgCodeCertificate;

    /**
     * 税务登记证认证备注
     */
    private String taxRegistrationCertificate;

    /**
     * 3合1证认证备注
     */
    private String newBusinessLicense;

    /**
     * 企业营业期限认证备注
     */
    private String businessLicenseExpireTime;

    /**
     * 企业电子邮箱认证备注
     */
    private String email;

    /**
     * 法人授权书认证备注
     */
    private String legalPersonAuthorityBook;

    /**
     * 工程范围认证备注
     */
    private String projectScope;

    /**
     * 公司简介认证备注
     */
    private String description;

    /**
     * 公司网址认证备注
     */
    private String website;

    /**
     * 公司logo,照片地址认证备注
     */
    private String logo;

    /**
     * 公司简称认证备注
     */
    private String shortName;

    /**
     * 注册资本认证备注
     */
    private String registeredCapital;

    /**
     * 经营范围认证备注
     */
    private String businessScope;

    /**
     * 企业办公地址认证结果认证备注
     */
    private String address;

    /**
     * 法人身份证号认证备注
     */
    private String legalPersonIdcard;

    /**
     * 法人身份证扫描件(正面)认证备注
     */
    private String legalPersonIdcardFrontUrl;

    /**
     * 法人身份证扫描件(反面)认证备注
     */
    private String legalPersonIdcardBackUrl;

    /**
     * 营业执照扫描件认证备注
     */
    private String businessLicenseUrl;

    /**
     * 组织机构代码证扫描件认证备注
     */
    private String orgCodeCertificateUrl;

    /**
     * 税务登记证扫描件认证备注
     */
    private String taxRegistrationCertificateUrl;

    /**
     * 统一社会信用代码认证备注
     */
    private String unifiedSocialCreditCode;

    /**
     * 统一社会信用代码扫描件认证备注
     */
    private String unifiedSocialCreditCodeUrl;

    /**
     * 认证状态,CRT待认证,OK#已认证,FLS认证失败
     */
    private String auditStatus;

    /**
     * 插入时间
     */
    private Date insertTime;

    /**
     * 审核人
     */
    private Integer auditor;

    /**
     * 审核时间
     */
    private Date auditTime;

    /**
     * @return 主键
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id 
	 *            主键
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return 招标人资质认证历史表id
     */
    public Integer getBiddeeCerticateId() {
        return biddeeCerticateId;
    }

    /**
     * @param biddeeCerticateId 
	 *            招标人资质认证历史表id
     */
    public void setBiddeeCerticateId(Integer biddeeCerticateId) {
        this.biddeeCerticateId = biddeeCerticateId;
    }

    /**
     * @return 公司名称认证备注
     */
    public String getCompanyNameMsg() {
        return companyNameMsg;
    }

    /**
     * @param companyNameMsg 
	 *            公司名称认证备注
     */
    public void setCompanyNameMsg(String companyNameMsg) {
        this.companyNameMsg = companyNameMsg == null ? null : companyNameMsg.trim();
    }

    /**
     * @return 法人名称认证备注
     */
    public String getLegalPersonMsg() {
        return legalPersonMsg;
    }

    /**
     * @param legalPersonMsg 
	 *            法人名称认证备注
     */
    public void setLegalPersonMsg(String legalPersonMsg) {
        this.legalPersonMsg = legalPersonMsg == null ? null : legalPersonMsg.trim();
    }

    /**
     * @return 企业成立时间认证备注
     */
    public String getRegTimeMsg() {
        return regTimeMsg;
    }

    /**
     * @param regTimeMsg 
	 *            企业成立时间认证备注
     */
    public void setRegTimeMsg(String regTimeMsg) {
        this.regTimeMsg = regTimeMsg == null ? null : regTimeMsg.trim();
    }

    /**
     * @return 联系人认证备注
     */
    public String getContactNameMsg() {
        return contactNameMsg;
    }

    /**
     * @param contactNameMsg 
	 *            联系人认证备注
     */
    public void setContactNameMsg(String contactNameMsg) {
        this.contactNameMsg = contactNameMsg == null ? null : contactNameMsg.trim();
    }

    /**
     * @return 联系人手机号码认证备注
     */
    public String getContactMobileNumMsg() {
        return contactMobileNumMsg;
    }

    /**
     * @param contactMobileNumMsg 
	 *            联系人手机号码认证备注
     */
    public void setContactMobileNumMsg(String contactMobileNumMsg) {
        this.contactMobileNumMsg = contactMobileNumMsg == null ? null : contactMobileNumMsg.trim();
    }

    /**
     * @return 营业执照认证备注
     */
    public String getBusinessLicenseMsg() {
        return businessLicenseMsg;
    }

    /**
     * @param businessLicenseMsg 
	 *            营业执照认证备注
     */
    public void setBusinessLicenseMsg(String businessLicenseMsg) {
        this.businessLicenseMsg = businessLicenseMsg == null ? null : businessLicenseMsg.trim();
    }

    /**
     * @return 组织机构代码证认证备注
     */
    public String getOrgCodeCertificateMsg() {
        return orgCodeCertificateMsg;
    }

    /**
     * @param orgCodeCertificateMsg 
	 *            组织机构代码证认证备注
     */
    public void setOrgCodeCertificateMsg(String orgCodeCertificateMsg) {
        this.orgCodeCertificateMsg = orgCodeCertificateMsg == null ? null : orgCodeCertificateMsg.trim();
    }

    /**
     * @return 税务登记证认证备注
     */
    public String getTaxRegistrationCertificateMsg() {
        return taxRegistrationCertificateMsg;
    }

    /**
     * @param taxRegistrationCertificateMsg 
	 *            税务登记证认证备注
     */
    public void setTaxRegistrationCertificateMsg(String taxRegistrationCertificateMsg) {
        this.taxRegistrationCertificateMsg = taxRegistrationCertificateMsg == null ? null : taxRegistrationCertificateMsg.trim();
    }

    /**
     * @return 3合1证认证备注
     */
    public String getNewBusinessLicenseMsg() {
        return newBusinessLicenseMsg;
    }

    /**
     * @param newBusinessLicenseMsg 
	 *            3合1证认证备注
     */
    public void setNewBusinessLicenseMsg(String newBusinessLicenseMsg) {
        this.newBusinessLicenseMsg = newBusinessLicenseMsg == null ? null : newBusinessLicenseMsg.trim();
    }

    /**
     * @return 企业营业期限认证备注
     */
    public String getBusinessLicenseExpireTimeMsg() {
        return businessLicenseExpireTimeMsg;
    }

    /**
     * @param businessLicenseExpireTimeMsg 
	 *            企业营业期限认证备注
     */
    public void setBusinessLicenseExpireTimeMsg(String businessLicenseExpireTimeMsg) {
        this.businessLicenseExpireTimeMsg = businessLicenseExpireTimeMsg == null ? null : businessLicenseExpireTimeMsg.trim();
    }

    /**
     * @return 企业电子邮箱认证备注
     */
    public String getEmailMsg() {
        return emailMsg;
    }

    /**
     * @param emailMsg 
	 *            企业电子邮箱认证备注
     */
    public void setEmailMsg(String emailMsg) {
        this.emailMsg = emailMsg == null ? null : emailMsg.trim();
    }

    /**
     * @return 法人授权书认证备注
     */
    public String getLegalPersonAuthorityBookMsg() {
        return legalPersonAuthorityBookMsg;
    }

    /**
     * @param legalPersonAuthorityBookMsg 
	 *            法人授权书认证备注
     */
    public void setLegalPersonAuthorityBookMsg(String legalPersonAuthorityBookMsg) {
        this.legalPersonAuthorityBookMsg = legalPersonAuthorityBookMsg == null ? null : legalPersonAuthorityBookMsg.trim();
    }

    /**
     * @return 工程范围认证备注
     */
    public String getProjectScopeMsg() {
        return projectScopeMsg;
    }

    /**
     * @param projectScopeMsg 
	 *            工程范围认证备注
     */
    public void setProjectScopeMsg(String projectScopeMsg) {
        this.projectScopeMsg = projectScopeMsg == null ? null : projectScopeMsg.trim();
    }

    /**
     * @return 公司简介认证备注
     */
    public String getDescriptionMsg() {
        return descriptionMsg;
    }

    /**
     * @param descriptionMsg 
	 *            公司简介认证备注
     */
    public void setDescriptionMsg(String descriptionMsg) {
        this.descriptionMsg = descriptionMsg == null ? null : descriptionMsg.trim();
    }

    /**
     * @return 公司网址认证备注
     */
    public String getWebsiteMsg() {
        return websiteMsg;
    }

    /**
     * @param websiteMsg 
	 *            公司网址认证备注
     */
    public void setWebsiteMsg(String websiteMsg) {
        this.websiteMsg = websiteMsg == null ? null : websiteMsg.trim();
    }

    /**
     * @return 公司logo,照片地址认证备注
     */
    public String getLogoMsg() {
        return logoMsg;
    }

    /**
     * @param logoMsg 
	 *            公司logo,照片地址认证备注
     */
    public void setLogoMsg(String logoMsg) {
        this.logoMsg = logoMsg == null ? null : logoMsg.trim();
    }

    /**
     * @return 公司简称认证备注
     */
    public String getShortNameMsg() {
        return shortNameMsg;
    }

    /**
     * @param shortNameMsg 
	 *            公司简称认证备注
     */
    public void setShortNameMsg(String shortNameMsg) {
        this.shortNameMsg = shortNameMsg == null ? null : shortNameMsg.trim();
    }

    /**
     * @return 注册资本认证备注
     */
    public String getRegisteredCapitalMsg() {
        return registeredCapitalMsg;
    }

    /**
     * @param registeredCapitalMsg 
	 *            注册资本认证备注
     */
    public void setRegisteredCapitalMsg(String registeredCapitalMsg) {
        this.registeredCapitalMsg = registeredCapitalMsg == null ? null : registeredCapitalMsg.trim();
    }

    /**
     * @return 经营范围认证备注
     */
    public String getBusinessScopeMsg() {
        return businessScopeMsg;
    }

    /**
     * @param businessScopeMsg 
	 *            经营范围认证备注
     */
    public void setBusinessScopeMsg(String businessScopeMsg) {
        this.businessScopeMsg = businessScopeMsg == null ? null : businessScopeMsg.trim();
    }

    /**
     * @return 企业办公地址认证结果认证备注
     */
    public String getAddressMsg() {
        return addressMsg;
    }

    /**
     * @param addressMsg 
	 *            企业办公地址认证结果认证备注
     */
    public void setAddressMsg(String addressMsg) {
        this.addressMsg = addressMsg == null ? null : addressMsg.trim();
    }

    /**
     * @return 法人身份证号认证备注
     */
    public String getLegalPersonIdcardMsg() {
        return legalPersonIdcardMsg;
    }

    /**
     * @param legalPersonIdcardMsg 
	 *            法人身份证号认证备注
     */
    public void setLegalPersonIdcardMsg(String legalPersonIdcardMsg) {
        this.legalPersonIdcardMsg = legalPersonIdcardMsg == null ? null : legalPersonIdcardMsg.trim();
    }

    /**
     * @return 法人身份证扫描件(正面)认证备注
     */
    public String getLegalPersonIdcardFrontUrlMsg() {
        return legalPersonIdcardFrontUrlMsg;
    }

    /**
     * @param legalPersonIdcardFrontUrlMsg 
	 *            法人身份证扫描件(正面)认证备注
     */
    public void setLegalPersonIdcardFrontUrlMsg(String legalPersonIdcardFrontUrlMsg) {
        this.legalPersonIdcardFrontUrlMsg = legalPersonIdcardFrontUrlMsg == null ? null : legalPersonIdcardFrontUrlMsg.trim();
    }

    /**
     * @return 法人身份证扫描件(反面)认证备注
     */
    public String getLegalPersonIdcardBackUrlMsg() {
        return legalPersonIdcardBackUrlMsg;
    }

    /**
     * @param legalPersonIdcardBackUrlMsg 
	 *            法人身份证扫描件(反面)认证备注
     */
    public void setLegalPersonIdcardBackUrlMsg(String legalPersonIdcardBackUrlMsg) {
        this.legalPersonIdcardBackUrlMsg = legalPersonIdcardBackUrlMsg == null ? null : legalPersonIdcardBackUrlMsg.trim();
    }

    /**
     * @return 营业执照扫描件认证备注
     */
    public String getBusinessLicenseUrlMsg() {
        return businessLicenseUrlMsg;
    }

    /**
     * @param businessLicenseUrlMsg 
	 *            营业执照扫描件认证备注
     */
    public void setBusinessLicenseUrlMsg(String businessLicenseUrlMsg) {
        this.businessLicenseUrlMsg = businessLicenseUrlMsg == null ? null : businessLicenseUrlMsg.trim();
    }

    /**
     * @return 组织机构代码证扫描件认证备注
     */
    public String getOrgCodeCertificateUrlMsg() {
        return orgCodeCertificateUrlMsg;
    }

    /**
     * @param orgCodeCertificateUrlMsg 
	 *            组织机构代码证扫描件认证备注
     */
    public void setOrgCodeCertificateUrlMsg(String orgCodeCertificateUrlMsg) {
        this.orgCodeCertificateUrlMsg = orgCodeCertificateUrlMsg == null ? null : orgCodeCertificateUrlMsg.trim();
    }

    /**
     * @return 税务登记证扫描件认证备注
     */
    public String getTaxRegistrationCertificateUrlMsg() {
        return taxRegistrationCertificateUrlMsg;
    }

    /**
     * @param taxRegistrationCertificateUrlMsg 
	 *            税务登记证扫描件认证备注
     */
    public void setTaxRegistrationCertificateUrlMsg(String taxRegistrationCertificateUrlMsg) {
        this.taxRegistrationCertificateUrlMsg = taxRegistrationCertificateUrlMsg == null ? null : taxRegistrationCertificateUrlMsg.trim();
    }

    /**
     * @return 统一社会信用代码认证备注
     */
    public String getUnifiedSocialCreditCodeMsg() {
        return unifiedSocialCreditCodeMsg;
    }

    /**
     * @param unifiedSocialCreditCodeMsg 
	 *            统一社会信用代码认证备注
     */
    public void setUnifiedSocialCreditCodeMsg(String unifiedSocialCreditCodeMsg) {
        this.unifiedSocialCreditCodeMsg = unifiedSocialCreditCodeMsg == null ? null : unifiedSocialCreditCodeMsg.trim();
    }

    /**
     * @return 统一社会信用代码扫描件认证备注
     */
    public String getUnifiedSocialCreditCodeUrlMsg() {
        return unifiedSocialCreditCodeUrlMsg;
    }

    /**
     * @param unifiedSocialCreditCodeUrlMsg 
	 *            统一社会信用代码扫描件认证备注
     */
    public void setUnifiedSocialCreditCodeUrlMsg(String unifiedSocialCreditCodeUrlMsg) {
        this.unifiedSocialCreditCodeUrlMsg = unifiedSocialCreditCodeUrlMsg == null ? null : unifiedSocialCreditCodeUrlMsg.trim();
    }

    /**
     * @return 公司名称认证备注
     */
    public String getCompanyName() {
        return companyName;
    }

    /**
     * @param companyName 
	 *            公司名称认证备注
     */
    public void setCompanyName(String companyName) {
        this.companyName = companyName == null ? null : companyName.trim();
    }

    /**
     * @return 法人名称认证备注
     */
    public String getLegalPerson() {
        return legalPerson;
    }

    /**
     * @param legalPerson 
	 *            法人名称认证备注
     */
    public void setLegalPerson(String legalPerson) {
        this.legalPerson = legalPerson == null ? null : legalPerson.trim();
    }

    /**
     * @return 企业成立时间认证备注
     */
    public String getRegTime() {
        return regTime;
    }

    /**
     * @param regTime 
	 *            企业成立时间认证备注
     */
    public void setRegTime(String regTime) {
        this.regTime = regTime == null ? null : regTime.trim();
    }

    /**
     * @return 联系人认证备注
     */
    public String getContactName() {
        return contactName;
    }

    /**
     * @param contactName 
	 *            联系人认证备注
     */
    public void setContactName(String contactName) {
        this.contactName = contactName == null ? null : contactName.trim();
    }

    /**
     * @return 联系人手机号码认证备注
     */
    public String getContactMobileNum() {
        return contactMobileNum;
    }

    /**
     * @param contactMobileNum 
	 *            联系人手机号码认证备注
     */
    public void setContactMobileNum(String contactMobileNum) {
        this.contactMobileNum = contactMobileNum == null ? null : contactMobileNum.trim();
    }

    /**
     * @return 营业执照认证备注
     */
    public String getBusinessLicense() {
        return businessLicense;
    }

    /**
     * @param businessLicense 
	 *            营业执照认证备注
     */
    public void setBusinessLicense(String businessLicense) {
        this.businessLicense = businessLicense == null ? null : businessLicense.trim();
    }

    /**
     * @return 组织机构代码证认证备注
     */
    public String getOrgCodeCertificate() {
        return orgCodeCertificate;
    }

    /**
     * @param orgCodeCertificate 
	 *            组织机构代码证认证备注
     */
    public void setOrgCodeCertificate(String orgCodeCertificate) {
        this.orgCodeCertificate = orgCodeCertificate == null ? null : orgCodeCertificate.trim();
    }

    /**
     * @return 税务登记证认证备注
     */
    public String getTaxRegistrationCertificate() {
        return taxRegistrationCertificate;
    }

    /**
     * @param taxRegistrationCertificate 
	 *            税务登记证认证备注
     */
    public void setTaxRegistrationCertificate(String taxRegistrationCertificate) {
        this.taxRegistrationCertificate = taxRegistrationCertificate == null ? null : taxRegistrationCertificate.trim();
    }

    /**
     * @return 3合1证认证备注
     */
    public String getNewBusinessLicense() {
        return newBusinessLicense;
    }

    /**
     * @param newBusinessLicense 
	 *            3合1证认证备注
     */
    public void setNewBusinessLicense(String newBusinessLicense) {
        this.newBusinessLicense = newBusinessLicense == null ? null : newBusinessLicense.trim();
    }

    /**
     * @return 企业营业期限认证备注
     */
    public String getBusinessLicenseExpireTime() {
        return businessLicenseExpireTime;
    }

    /**
     * @param businessLicenseExpireTime 
	 *            企业营业期限认证备注
     */
    public void setBusinessLicenseExpireTime(String businessLicenseExpireTime) {
        this.businessLicenseExpireTime = businessLicenseExpireTime == null ? null : businessLicenseExpireTime.trim();
    }

    /**
     * @return 企业电子邮箱认证备注
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email 
	 *            企业电子邮箱认证备注
     */
    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    /**
     * @return 法人授权书认证备注
     */
    public String getLegalPersonAuthorityBook() {
        return legalPersonAuthorityBook;
    }

    /**
     * @param legalPersonAuthorityBook 
	 *            法人授权书认证备注
     */
    public void setLegalPersonAuthorityBook(String legalPersonAuthorityBook) {
        this.legalPersonAuthorityBook = legalPersonAuthorityBook == null ? null : legalPersonAuthorityBook.trim();
    }

    /**
     * @return 工程范围认证备注
     */
    public String getProjectScope() {
        return projectScope;
    }

    /**
     * @param projectScope 
	 *            工程范围认证备注
     */
    public void setProjectScope(String projectScope) {
        this.projectScope = projectScope == null ? null : projectScope.trim();
    }

    /**
     * @return 公司简介认证备注
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description 
	 *            公司简介认证备注
     */
    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    /**
     * @return 公司网址认证备注
     */
    public String getWebsite() {
        return website;
    }

    /**
     * @param website 
	 *            公司网址认证备注
     */
    public void setWebsite(String website) {
        this.website = website == null ? null : website.trim();
    }

    /**
     * @return 公司logo,照片地址认证备注
     */
    public String getLogo() {
        return logo;
    }

    /**
     * @param logo 
	 *            公司logo,照片地址认证备注
     */
    public void setLogo(String logo) {
        this.logo = logo == null ? null : logo.trim();
    }

    /**
     * @return 公司简称认证备注
     */
    public String getShortName() {
        return shortName;
    }

    /**
     * @param shortName 
	 *            公司简称认证备注
     */
    public void setShortName(String shortName) {
        this.shortName = shortName == null ? null : shortName.trim();
    }

    /**
     * @return 注册资本认证备注
     */
    public String getRegisteredCapital() {
        return registeredCapital;
    }

    /**
     * @param registeredCapital 
	 *            注册资本认证备注
     */
    public void setRegisteredCapital(String registeredCapital) {
        this.registeredCapital = registeredCapital == null ? null : registeredCapital.trim();
    }

    /**
     * @return 经营范围认证备注
     */
    public String getBusinessScope() {
        return businessScope;
    }

    /**
     * @param businessScope 
	 *            经营范围认证备注
     */
    public void setBusinessScope(String businessScope) {
        this.businessScope = businessScope == null ? null : businessScope.trim();
    }

    /**
     * @return 企业办公地址认证结果认证备注
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address 
	 *            企业办公地址认证结果认证备注
     */
    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    /**
     * @return 法人身份证号认证备注
     */
    public String getLegalPersonIdcard() {
        return legalPersonIdcard;
    }

    /**
     * @param legalPersonIdcard 
	 *            法人身份证号认证备注
     */
    public void setLegalPersonIdcard(String legalPersonIdcard) {
        this.legalPersonIdcard = legalPersonIdcard == null ? null : legalPersonIdcard.trim();
    }

    /**
     * @return 法人身份证扫描件(正面)认证备注
     */
    public String getLegalPersonIdcardFrontUrl() {
        return legalPersonIdcardFrontUrl;
    }

    /**
     * @param legalPersonIdcardFrontUrl 
	 *            法人身份证扫描件(正面)认证备注
     */
    public void setLegalPersonIdcardFrontUrl(String legalPersonIdcardFrontUrl) {
        this.legalPersonIdcardFrontUrl = legalPersonIdcardFrontUrl == null ? null : legalPersonIdcardFrontUrl.trim();
    }

    /**
     * @return 法人身份证扫描件(反面)认证备注
     */
    public String getLegalPersonIdcardBackUrl() {
        return legalPersonIdcardBackUrl;
    }

    /**
     * @param legalPersonIdcardBackUrl 
	 *            法人身份证扫描件(反面)认证备注
     */
    public void setLegalPersonIdcardBackUrl(String legalPersonIdcardBackUrl) {
        this.legalPersonIdcardBackUrl = legalPersonIdcardBackUrl == null ? null : legalPersonIdcardBackUrl.trim();
    }

    /**
     * @return 营业执照扫描件认证备注
     */
    public String getBusinessLicenseUrl() {
        return businessLicenseUrl;
    }

    /**
     * @param businessLicenseUrl 
	 *            营业执照扫描件认证备注
     */
    public void setBusinessLicenseUrl(String businessLicenseUrl) {
        this.businessLicenseUrl = businessLicenseUrl == null ? null : businessLicenseUrl.trim();
    }

    /**
     * @return 组织机构代码证扫描件认证备注
     */
    public String getOrgCodeCertificateUrl() {
        return orgCodeCertificateUrl;
    }

    /**
     * @param orgCodeCertificateUrl 
	 *            组织机构代码证扫描件认证备注
     */
    public void setOrgCodeCertificateUrl(String orgCodeCertificateUrl) {
        this.orgCodeCertificateUrl = orgCodeCertificateUrl == null ? null : orgCodeCertificateUrl.trim();
    }

    /**
     * @return 税务登记证扫描件认证备注
     */
    public String getTaxRegistrationCertificateUrl() {
        return taxRegistrationCertificateUrl;
    }

    /**
     * @param taxRegistrationCertificateUrl 
	 *            税务登记证扫描件认证备注
     */
    public void setTaxRegistrationCertificateUrl(String taxRegistrationCertificateUrl) {
        this.taxRegistrationCertificateUrl = taxRegistrationCertificateUrl == null ? null : taxRegistrationCertificateUrl.trim();
    }

    /**
     * @return 统一社会信用代码认证备注
     */
    public String getUnifiedSocialCreditCode() {
        return unifiedSocialCreditCode;
    }

    /**
     * @param unifiedSocialCreditCode 
	 *            统一社会信用代码认证备注
     */
    public void setUnifiedSocialCreditCode(String unifiedSocialCreditCode) {
        this.unifiedSocialCreditCode = unifiedSocialCreditCode == null ? null : unifiedSocialCreditCode.trim();
    }

    /**
     * @return 统一社会信用代码扫描件认证备注
     */
    public String getUnifiedSocialCreditCodeUrl() {
        return unifiedSocialCreditCodeUrl;
    }

    /**
     * @param unifiedSocialCreditCodeUrl 
	 *            统一社会信用代码扫描件认证备注
     */
    public void setUnifiedSocialCreditCodeUrl(String unifiedSocialCreditCodeUrl) {
        this.unifiedSocialCreditCodeUrl = unifiedSocialCreditCodeUrl == null ? null : unifiedSocialCreditCodeUrl.trim();
    }

    /**
     * @return 认证状态,CRT待认证,OK#已认证,FLS认证失败
     */
    public String getAuditStatus() {
        return auditStatus;
    }

    /**
     * @param auditStatus 
	 *            认证状态,CRT待认证,OK#已认证,FLS认证失败
     */
    public void setAuditStatus(String auditStatus) {
        this.auditStatus = auditStatus == null ? null : auditStatus.trim();
    }

    /**
     * @return 插入时间
     */
    public Date getInsertTime() {
        return insertTime;
    }

    /**
     * @param insertTime 
	 *            插入时间
     */
    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }

    /**
     * @return 审核人
     */
    public Integer getAuditor() {
        return auditor;
    }

    /**
     * @param auditor 
	 *            审核人
     */
    public void setAuditor(Integer auditor) {
        this.auditor = auditor;
    }

    /**
     * @return 审核时间
     */
    public Date getAuditTime() {
        return auditTime;
    }

    /**
     * @param auditTime 
	 *            审核时间
     */
    public void setAuditTime(Date auditTime) {
        this.auditTime = auditTime;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        BiddeeCertificateAduit other = (BiddeeCertificateAduit) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getBiddeeCerticateId() == null ? other.getBiddeeCerticateId() == null : this.getBiddeeCerticateId().equals(other.getBiddeeCerticateId()))
            && (this.getCompanyNameMsg() == null ? other.getCompanyNameMsg() == null : this.getCompanyNameMsg().equals(other.getCompanyNameMsg()))
            && (this.getLegalPersonMsg() == null ? other.getLegalPersonMsg() == null : this.getLegalPersonMsg().equals(other.getLegalPersonMsg()))
            && (this.getRegTimeMsg() == null ? other.getRegTimeMsg() == null : this.getRegTimeMsg().equals(other.getRegTimeMsg()))
            && (this.getContactNameMsg() == null ? other.getContactNameMsg() == null : this.getContactNameMsg().equals(other.getContactNameMsg()))
            && (this.getContactMobileNumMsg() == null ? other.getContactMobileNumMsg() == null : this.getContactMobileNumMsg().equals(other.getContactMobileNumMsg()))
            && (this.getBusinessLicenseMsg() == null ? other.getBusinessLicenseMsg() == null : this.getBusinessLicenseMsg().equals(other.getBusinessLicenseMsg()))
            && (this.getOrgCodeCertificateMsg() == null ? other.getOrgCodeCertificateMsg() == null : this.getOrgCodeCertificateMsg().equals(other.getOrgCodeCertificateMsg()))
            && (this.getTaxRegistrationCertificateMsg() == null ? other.getTaxRegistrationCertificateMsg() == null : this.getTaxRegistrationCertificateMsg().equals(other.getTaxRegistrationCertificateMsg()))
            && (this.getNewBusinessLicenseMsg() == null ? other.getNewBusinessLicenseMsg() == null : this.getNewBusinessLicenseMsg().equals(other.getNewBusinessLicenseMsg()))
            && (this.getBusinessLicenseExpireTimeMsg() == null ? other.getBusinessLicenseExpireTimeMsg() == null : this.getBusinessLicenseExpireTimeMsg().equals(other.getBusinessLicenseExpireTimeMsg()))
            && (this.getEmailMsg() == null ? other.getEmailMsg() == null : this.getEmailMsg().equals(other.getEmailMsg()))
            && (this.getLegalPersonAuthorityBookMsg() == null ? other.getLegalPersonAuthorityBookMsg() == null : this.getLegalPersonAuthorityBookMsg().equals(other.getLegalPersonAuthorityBookMsg()))
            && (this.getProjectScopeMsg() == null ? other.getProjectScopeMsg() == null : this.getProjectScopeMsg().equals(other.getProjectScopeMsg()))
            && (this.getDescriptionMsg() == null ? other.getDescriptionMsg() == null : this.getDescriptionMsg().equals(other.getDescriptionMsg()))
            && (this.getWebsiteMsg() == null ? other.getWebsiteMsg() == null : this.getWebsiteMsg().equals(other.getWebsiteMsg()))
            && (this.getLogoMsg() == null ? other.getLogoMsg() == null : this.getLogoMsg().equals(other.getLogoMsg()))
            && (this.getShortNameMsg() == null ? other.getShortNameMsg() == null : this.getShortNameMsg().equals(other.getShortNameMsg()))
            && (this.getRegisteredCapitalMsg() == null ? other.getRegisteredCapitalMsg() == null : this.getRegisteredCapitalMsg().equals(other.getRegisteredCapitalMsg()))
            && (this.getBusinessScopeMsg() == null ? other.getBusinessScopeMsg() == null : this.getBusinessScopeMsg().equals(other.getBusinessScopeMsg()))
            && (this.getAddressMsg() == null ? other.getAddressMsg() == null : this.getAddressMsg().equals(other.getAddressMsg()))
            && (this.getLegalPersonIdcardMsg() == null ? other.getLegalPersonIdcardMsg() == null : this.getLegalPersonIdcardMsg().equals(other.getLegalPersonIdcardMsg()))
            && (this.getLegalPersonIdcardFrontUrlMsg() == null ? other.getLegalPersonIdcardFrontUrlMsg() == null : this.getLegalPersonIdcardFrontUrlMsg().equals(other.getLegalPersonIdcardFrontUrlMsg()))
            && (this.getLegalPersonIdcardBackUrlMsg() == null ? other.getLegalPersonIdcardBackUrlMsg() == null : this.getLegalPersonIdcardBackUrlMsg().equals(other.getLegalPersonIdcardBackUrlMsg()))
            && (this.getBusinessLicenseUrlMsg() == null ? other.getBusinessLicenseUrlMsg() == null : this.getBusinessLicenseUrlMsg().equals(other.getBusinessLicenseUrlMsg()))
            && (this.getOrgCodeCertificateUrlMsg() == null ? other.getOrgCodeCertificateUrlMsg() == null : this.getOrgCodeCertificateUrlMsg().equals(other.getOrgCodeCertificateUrlMsg()))
            && (this.getTaxRegistrationCertificateUrlMsg() == null ? other.getTaxRegistrationCertificateUrlMsg() == null : this.getTaxRegistrationCertificateUrlMsg().equals(other.getTaxRegistrationCertificateUrlMsg()))
            && (this.getUnifiedSocialCreditCodeMsg() == null ? other.getUnifiedSocialCreditCodeMsg() == null : this.getUnifiedSocialCreditCodeMsg().equals(other.getUnifiedSocialCreditCodeMsg()))
            && (this.getUnifiedSocialCreditCodeUrlMsg() == null ? other.getUnifiedSocialCreditCodeUrlMsg() == null : this.getUnifiedSocialCreditCodeUrlMsg().equals(other.getUnifiedSocialCreditCodeUrlMsg()))
            && (this.getCompanyName() == null ? other.getCompanyName() == null : this.getCompanyName().equals(other.getCompanyName()))
            && (this.getLegalPerson() == null ? other.getLegalPerson() == null : this.getLegalPerson().equals(other.getLegalPerson()))
            && (this.getRegTime() == null ? other.getRegTime() == null : this.getRegTime().equals(other.getRegTime()))
            && (this.getContactName() == null ? other.getContactName() == null : this.getContactName().equals(other.getContactName()))
            && (this.getContactMobileNum() == null ? other.getContactMobileNum() == null : this.getContactMobileNum().equals(other.getContactMobileNum()))
            && (this.getBusinessLicense() == null ? other.getBusinessLicense() == null : this.getBusinessLicense().equals(other.getBusinessLicense()))
            && (this.getOrgCodeCertificate() == null ? other.getOrgCodeCertificate() == null : this.getOrgCodeCertificate().equals(other.getOrgCodeCertificate()))
            && (this.getTaxRegistrationCertificate() == null ? other.getTaxRegistrationCertificate() == null : this.getTaxRegistrationCertificate().equals(other.getTaxRegistrationCertificate()))
            && (this.getNewBusinessLicense() == null ? other.getNewBusinessLicense() == null : this.getNewBusinessLicense().equals(other.getNewBusinessLicense()))
            && (this.getBusinessLicenseExpireTime() == null ? other.getBusinessLicenseExpireTime() == null : this.getBusinessLicenseExpireTime().equals(other.getBusinessLicenseExpireTime()))
            && (this.getEmail() == null ? other.getEmail() == null : this.getEmail().equals(other.getEmail()))
            && (this.getLegalPersonAuthorityBook() == null ? other.getLegalPersonAuthorityBook() == null : this.getLegalPersonAuthorityBook().equals(other.getLegalPersonAuthorityBook()))
            && (this.getProjectScope() == null ? other.getProjectScope() == null : this.getProjectScope().equals(other.getProjectScope()))
            && (this.getDescription() == null ? other.getDescription() == null : this.getDescription().equals(other.getDescription()))
            && (this.getWebsite() == null ? other.getWebsite() == null : this.getWebsite().equals(other.getWebsite()))
            && (this.getLogo() == null ? other.getLogo() == null : this.getLogo().equals(other.getLogo()))
            && (this.getShortName() == null ? other.getShortName() == null : this.getShortName().equals(other.getShortName()))
            && (this.getRegisteredCapital() == null ? other.getRegisteredCapital() == null : this.getRegisteredCapital().equals(other.getRegisteredCapital()))
            && (this.getBusinessScope() == null ? other.getBusinessScope() == null : this.getBusinessScope().equals(other.getBusinessScope()))
            && (this.getAddress() == null ? other.getAddress() == null : this.getAddress().equals(other.getAddress()))
            && (this.getLegalPersonIdcard() == null ? other.getLegalPersonIdcard() == null : this.getLegalPersonIdcard().equals(other.getLegalPersonIdcard()))
            && (this.getLegalPersonIdcardFrontUrl() == null ? other.getLegalPersonIdcardFrontUrl() == null : this.getLegalPersonIdcardFrontUrl().equals(other.getLegalPersonIdcardFrontUrl()))
            && (this.getLegalPersonIdcardBackUrl() == null ? other.getLegalPersonIdcardBackUrl() == null : this.getLegalPersonIdcardBackUrl().equals(other.getLegalPersonIdcardBackUrl()))
            && (this.getBusinessLicenseUrl() == null ? other.getBusinessLicenseUrl() == null : this.getBusinessLicenseUrl().equals(other.getBusinessLicenseUrl()))
            && (this.getOrgCodeCertificateUrl() == null ? other.getOrgCodeCertificateUrl() == null : this.getOrgCodeCertificateUrl().equals(other.getOrgCodeCertificateUrl()))
            && (this.getTaxRegistrationCertificateUrl() == null ? other.getTaxRegistrationCertificateUrl() == null : this.getTaxRegistrationCertificateUrl().equals(other.getTaxRegistrationCertificateUrl()))
            && (this.getUnifiedSocialCreditCode() == null ? other.getUnifiedSocialCreditCode() == null : this.getUnifiedSocialCreditCode().equals(other.getUnifiedSocialCreditCode()))
            && (this.getUnifiedSocialCreditCodeUrl() == null ? other.getUnifiedSocialCreditCodeUrl() == null : this.getUnifiedSocialCreditCodeUrl().equals(other.getUnifiedSocialCreditCodeUrl()))
            && (this.getAuditStatus() == null ? other.getAuditStatus() == null : this.getAuditStatus().equals(other.getAuditStatus()))
            && (this.getInsertTime() == null ? other.getInsertTime() == null : this.getInsertTime().equals(other.getInsertTime()))
            && (this.getAuditor() == null ? other.getAuditor() == null : this.getAuditor().equals(other.getAuditor()))
            && (this.getAuditTime() == null ? other.getAuditTime() == null : this.getAuditTime().equals(other.getAuditTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getBiddeeCerticateId() == null) ? 0 : getBiddeeCerticateId().hashCode());
        result = prime * result + ((getCompanyNameMsg() == null) ? 0 : getCompanyNameMsg().hashCode());
        result = prime * result + ((getLegalPersonMsg() == null) ? 0 : getLegalPersonMsg().hashCode());
        result = prime * result + ((getRegTimeMsg() == null) ? 0 : getRegTimeMsg().hashCode());
        result = prime * result + ((getContactNameMsg() == null) ? 0 : getContactNameMsg().hashCode());
        result = prime * result + ((getContactMobileNumMsg() == null) ? 0 : getContactMobileNumMsg().hashCode());
        result = prime * result + ((getBusinessLicenseMsg() == null) ? 0 : getBusinessLicenseMsg().hashCode());
        result = prime * result + ((getOrgCodeCertificateMsg() == null) ? 0 : getOrgCodeCertificateMsg().hashCode());
        result = prime * result + ((getTaxRegistrationCertificateMsg() == null) ? 0 : getTaxRegistrationCertificateMsg().hashCode());
        result = prime * result + ((getNewBusinessLicenseMsg() == null) ? 0 : getNewBusinessLicenseMsg().hashCode());
        result = prime * result + ((getBusinessLicenseExpireTimeMsg() == null) ? 0 : getBusinessLicenseExpireTimeMsg().hashCode());
        result = prime * result + ((getEmailMsg() == null) ? 0 : getEmailMsg().hashCode());
        result = prime * result + ((getLegalPersonAuthorityBookMsg() == null) ? 0 : getLegalPersonAuthorityBookMsg().hashCode());
        result = prime * result + ((getProjectScopeMsg() == null) ? 0 : getProjectScopeMsg().hashCode());
        result = prime * result + ((getDescriptionMsg() == null) ? 0 : getDescriptionMsg().hashCode());
        result = prime * result + ((getWebsiteMsg() == null) ? 0 : getWebsiteMsg().hashCode());
        result = prime * result + ((getLogoMsg() == null) ? 0 : getLogoMsg().hashCode());
        result = prime * result + ((getShortNameMsg() == null) ? 0 : getShortNameMsg().hashCode());
        result = prime * result + ((getRegisteredCapitalMsg() == null) ? 0 : getRegisteredCapitalMsg().hashCode());
        result = prime * result + ((getBusinessScopeMsg() == null) ? 0 : getBusinessScopeMsg().hashCode());
        result = prime * result + ((getAddressMsg() == null) ? 0 : getAddressMsg().hashCode());
        result = prime * result + ((getLegalPersonIdcardMsg() == null) ? 0 : getLegalPersonIdcardMsg().hashCode());
        result = prime * result + ((getLegalPersonIdcardFrontUrlMsg() == null) ? 0 : getLegalPersonIdcardFrontUrlMsg().hashCode());
        result = prime * result + ((getLegalPersonIdcardBackUrlMsg() == null) ? 0 : getLegalPersonIdcardBackUrlMsg().hashCode());
        result = prime * result + ((getBusinessLicenseUrlMsg() == null) ? 0 : getBusinessLicenseUrlMsg().hashCode());
        result = prime * result + ((getOrgCodeCertificateUrlMsg() == null) ? 0 : getOrgCodeCertificateUrlMsg().hashCode());
        result = prime * result + ((getTaxRegistrationCertificateUrlMsg() == null) ? 0 : getTaxRegistrationCertificateUrlMsg().hashCode());
        result = prime * result + ((getUnifiedSocialCreditCodeMsg() == null) ? 0 : getUnifiedSocialCreditCodeMsg().hashCode());
        result = prime * result + ((getUnifiedSocialCreditCodeUrlMsg() == null) ? 0 : getUnifiedSocialCreditCodeUrlMsg().hashCode());
        result = prime * result + ((getCompanyName() == null) ? 0 : getCompanyName().hashCode());
        result = prime * result + ((getLegalPerson() == null) ? 0 : getLegalPerson().hashCode());
        result = prime * result + ((getRegTime() == null) ? 0 : getRegTime().hashCode());
        result = prime * result + ((getContactName() == null) ? 0 : getContactName().hashCode());
        result = prime * result + ((getContactMobileNum() == null) ? 0 : getContactMobileNum().hashCode());
        result = prime * result + ((getBusinessLicense() == null) ? 0 : getBusinessLicense().hashCode());
        result = prime * result + ((getOrgCodeCertificate() == null) ? 0 : getOrgCodeCertificate().hashCode());
        result = prime * result + ((getTaxRegistrationCertificate() == null) ? 0 : getTaxRegistrationCertificate().hashCode());
        result = prime * result + ((getNewBusinessLicense() == null) ? 0 : getNewBusinessLicense().hashCode());
        result = prime * result + ((getBusinessLicenseExpireTime() == null) ? 0 : getBusinessLicenseExpireTime().hashCode());
        result = prime * result + ((getEmail() == null) ? 0 : getEmail().hashCode());
        result = prime * result + ((getLegalPersonAuthorityBook() == null) ? 0 : getLegalPersonAuthorityBook().hashCode());
        result = prime * result + ((getProjectScope() == null) ? 0 : getProjectScope().hashCode());
        result = prime * result + ((getDescription() == null) ? 0 : getDescription().hashCode());
        result = prime * result + ((getWebsite() == null) ? 0 : getWebsite().hashCode());
        result = prime * result + ((getLogo() == null) ? 0 : getLogo().hashCode());
        result = prime * result + ((getShortName() == null) ? 0 : getShortName().hashCode());
        result = prime * result + ((getRegisteredCapital() == null) ? 0 : getRegisteredCapital().hashCode());
        result = prime * result + ((getBusinessScope() == null) ? 0 : getBusinessScope().hashCode());
        result = prime * result + ((getAddress() == null) ? 0 : getAddress().hashCode());
        result = prime * result + ((getLegalPersonIdcard() == null) ? 0 : getLegalPersonIdcard().hashCode());
        result = prime * result + ((getLegalPersonIdcardFrontUrl() == null) ? 0 : getLegalPersonIdcardFrontUrl().hashCode());
        result = prime * result + ((getLegalPersonIdcardBackUrl() == null) ? 0 : getLegalPersonIdcardBackUrl().hashCode());
        result = prime * result + ((getBusinessLicenseUrl() == null) ? 0 : getBusinessLicenseUrl().hashCode());
        result = prime * result + ((getOrgCodeCertificateUrl() == null) ? 0 : getOrgCodeCertificateUrl().hashCode());
        result = prime * result + ((getTaxRegistrationCertificateUrl() == null) ? 0 : getTaxRegistrationCertificateUrl().hashCode());
        result = prime * result + ((getUnifiedSocialCreditCode() == null) ? 0 : getUnifiedSocialCreditCode().hashCode());
        result = prime * result + ((getUnifiedSocialCreditCodeUrl() == null) ? 0 : getUnifiedSocialCreditCodeUrl().hashCode());
        result = prime * result + ((getAuditStatus() == null) ? 0 : getAuditStatus().hashCode());
        result = prime * result + ((getInsertTime() == null) ? 0 : getInsertTime().hashCode());
        result = prime * result + ((getAuditor() == null) ? 0 : getAuditor().hashCode());
        result = prime * result + ((getAuditTime() == null) ? 0 : getAuditTime().hashCode());
        return result;
    }
}