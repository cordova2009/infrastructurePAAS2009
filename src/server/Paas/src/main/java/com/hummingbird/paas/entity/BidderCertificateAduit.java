package com.hummingbird.paas.entity;

import java.util.Date;

/**
 * 投标人资质认证申请审核表  ，认证状态 CRT 待认证，OK# 已认证，FLS 认证不通过
 */
public class BidderCertificateAduit {
    /**
     * 主键
     */
    private Integer id;

    /**
     * 招标人资质认证历史表id
     */
    private Integer bidderCerticateId;

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
    public Integer getBidderCerticateId() {
        return bidderCerticateId;
    }

    /**
     * @param bidderCerticateId 
	 *            招标人资质认证历史表id
     */
    public void setBidderCerticateId(Integer bidderCerticateId) {
        this.bidderCerticateId = bidderCerticateId;
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
}