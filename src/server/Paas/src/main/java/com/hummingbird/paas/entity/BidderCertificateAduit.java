package com.hummingbird.paas.entity;

import java.util.Date;

/**
 * 承包商资质认证申请审核表  ，认证状态 CRT 待认证，OK# 已认证，FLS 认证不通过
 */
public class BidderCertificateAduit {
    /**
     * 主键
     */
    private Integer id;

    /**
     * 发包方资质认证历史表id
     */
    private Integer bidderCerticateId;

    /**
     * 公司名称认证结果,CRT待认证,OK#已认证,FLS认证失败
     */
    private String companyName;

    /**
     * 法人名称认证结果,CRT待认证,OK#已认证,FLS认证失败
     */
    private String legalPerson;

    /**
     * 企业成立时间认证结果,CRT待认证,OK#已认证,FLS认证失败
     */
    private String regTime;

    /**
     * 联系人认证结果,CRT待认证,OK#已认证,FLS认证失败
     */
    private String contactName;

    /**
     * 联系人手机号码认证结果,CRT待认证,OK#已认证,FLS认证失败
     */
    private String contactMobileNum;

    /**
     * 营业执照认证结果,CRT待认证,OK#已认证,FLS认证失败
     */
    private String businessLicense;

    /**
     * 组织机构代码证认证结果,CRT待认证,OK#已认证,FLS认证失败
     */
    private String orgCodeCertificate;

    /**
     * 税务登记证认证结果,CRT待认证,OK#已认证,FLS认证失败
     */
    private String taxRegistrationCertificate;

    /**
     * 3合1证认证结果,CRT待认证,OK#已认证,FLS认证失败
     */
    private String newBusinessLicense;

    /**
     * 企业营业期限认证结果,CRT待认证,OK#已认证,FLS认证失败
     */
    private String businessLicenseExpireTime;

    /**
     * 企业电子邮箱认证结果,CRT待认证,OK#已认证,FLS认证失败
     */
    private String email;

    /**
     * 法人授权书认证结果,CRT待认证,OK#已认证,FLS认证失败
     */
    private String legalPersonAuthorityBook;

    /**
     * 工程范围认证结果,CRT待认证,OK#已认证,FLS认证失败
     */
    private String projectScope;

    /**
     * 公司简介认证结果,CRT待认证,OK#已认证,FLS认证失败
     */
    private String description;

    /**
     * 公司网址认证结果,CRT待认证,OK#已认证,FLS认证失败
     */
    private String website;

    /**
     * 公司logo,照片地址认证结果,CRT待认证,OK#已认证,FLS认证失败
     */
    private String logo;

    /**
     * 公司简称认证结果,CRT待认证,OK#已认证,FLS认证失败
     */
    private String shortName;

    /**
     * 注册资本认证结果,CRT待认证,OK#已认证,FLS认证失败
     */
    private String registeredCapital;

    /**
     * 经营范围认证结果,CRT待认证,OK#已认证,FLS认证失败
     */
    private String businessScope;

    /**
     * 企业办公地址认证结果认证结果,CRT待认证,OK#已认证,FLS认证失败
     */
    private String address;

    /**
     * 法人身份证号认证结果,CRT待认证,OK#已认证,FLS认证失败
     */
    private String legalPersonIdcard;

    /**
     * 法人身份证扫描件(正面)认证结果,CRT待认证,OK#已认证,FLS认证失败
     */
    private String legalPersonIdcardFrontUrl;

    /**
     * 法人身份证扫描件(反面)认证结果,CRT待认证,OK#已认证,FLS认证失败
     */
    private String legalPersonIdcardBackUrl;

    /**
     * 营业执照扫描件认证结果,CRT待认证,OK#已认证,FLS认证失败
     */
    private String businessLicenseUrl;

    /**
     * 组织机构代码证扫描件认证结果,CRT待认证,OK#已认证,FLS认证失败
     */
    private String orgCodeCertificateUrl;

    /**
     * 税务登记证扫描件认证结果,CRT待认证,OK#已认证,FLS认证失败
     */
    private String taxRegistrationCertificateUrl;

    /**
     * 统一社会信用代码认证结果,CRT待认证,OK#已认证,FLS认证失败
     */
    private String unifiedSocialCreditCode;

    /**
     * 统一社会信用代码扫描件认证结果,CRT待认证,OK#已认证,FLS认证失败
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
     * @return 发包方资质认证历史表id
     */
    public Integer getBidderCerticateId() {
        return bidderCerticateId;
    }

    /**
     * @param bidderCerticateId 
	 *            发包方资质认证历史表id
     */
    public void setBidderCerticateId(Integer bidderCerticateId) {
        this.bidderCerticateId = bidderCerticateId;
    }

    /**
     * @return 公司名称认证结果,CRT待认证,OK#已认证,FLS认证失败
     */
    public String getCompanyName() {
        return companyName;
    }

    /**
     * @param companyName 
	 *            公司名称认证结果,CRT待认证,OK#已认证,FLS认证失败
     */
    public void setCompanyName(String companyName) {
        this.companyName = companyName == null ? null : companyName.trim();
    }

    /**
     * @return 法人名称认证结果,CRT待认证,OK#已认证,FLS认证失败
     */
    public String getLegalPerson() {
        return legalPerson;
    }

    /**
     * @param legalPerson 
	 *            法人名称认证结果,CRT待认证,OK#已认证,FLS认证失败
     */
    public void setLegalPerson(String legalPerson) {
        this.legalPerson = legalPerson == null ? null : legalPerson.trim();
    }

    /**
     * @return 企业成立时间认证结果,CRT待认证,OK#已认证,FLS认证失败
     */
    public String getRegTime() {
        return regTime;
    }

    /**
     * @param regTime 
	 *            企业成立时间认证结果,CRT待认证,OK#已认证,FLS认证失败
     */
    public void setRegTime(String regTime) {
        this.regTime = regTime == null ? null : regTime.trim();
    }

    /**
     * @return 联系人认证结果,CRT待认证,OK#已认证,FLS认证失败
     */
    public String getContactName() {
        return contactName;
    }

    /**
     * @param contactName 
	 *            联系人认证结果,CRT待认证,OK#已认证,FLS认证失败
     */
    public void setContactName(String contactName) {
        this.contactName = contactName == null ? null : contactName.trim();
    }

    /**
     * @return 联系人手机号码认证结果,CRT待认证,OK#已认证,FLS认证失败
     */
    public String getContactMobileNum() {
        return contactMobileNum;
    }

    /**
     * @param contactMobileNum 
	 *            联系人手机号码认证结果,CRT待认证,OK#已认证,FLS认证失败
     */
    public void setContactMobileNum(String contactMobileNum) {
        this.contactMobileNum = contactMobileNum == null ? null : contactMobileNum.trim();
    }

    /**
     * @return 营业执照认证结果,CRT待认证,OK#已认证,FLS认证失败
     */
    public String getBusinessLicense() {
        return businessLicense;
    }

    /**
     * @param businessLicense 
	 *            营业执照认证结果,CRT待认证,OK#已认证,FLS认证失败
     */
    public void setBusinessLicense(String businessLicense) {
        this.businessLicense = businessLicense == null ? null : businessLicense.trim();
    }

    /**
     * @return 组织机构代码证认证结果,CRT待认证,OK#已认证,FLS认证失败
     */
    public String getOrgCodeCertificate() {
        return orgCodeCertificate;
    }

    /**
     * @param orgCodeCertificate 
	 *            组织机构代码证认证结果,CRT待认证,OK#已认证,FLS认证失败
     */
    public void setOrgCodeCertificate(String orgCodeCertificate) {
        this.orgCodeCertificate = orgCodeCertificate == null ? null : orgCodeCertificate.trim();
    }

    /**
     * @return 税务登记证认证结果,CRT待认证,OK#已认证,FLS认证失败
     */
    public String getTaxRegistrationCertificate() {
        return taxRegistrationCertificate;
    }

    /**
     * @param taxRegistrationCertificate 
	 *            税务登记证认证结果,CRT待认证,OK#已认证,FLS认证失败
     */
    public void setTaxRegistrationCertificate(String taxRegistrationCertificate) {
        this.taxRegistrationCertificate = taxRegistrationCertificate == null ? null : taxRegistrationCertificate.trim();
    }

    /**
     * @return 3合1证认证结果,CRT待认证,OK#已认证,FLS认证失败
     */
    public String getNewBusinessLicense() {
        return newBusinessLicense;
    }

    /**
     * @param newBusinessLicense 
	 *            3合1证认证结果,CRT待认证,OK#已认证,FLS认证失败
     */
    public void setNewBusinessLicense(String newBusinessLicense) {
        this.newBusinessLicense = newBusinessLicense == null ? null : newBusinessLicense.trim();
    }

    /**
     * @return 企业营业期限认证结果,CRT待认证,OK#已认证,FLS认证失败
     */
    public String getBusinessLicenseExpireTime() {
        return businessLicenseExpireTime;
    }

    /**
     * @param businessLicenseExpireTime 
	 *            企业营业期限认证结果,CRT待认证,OK#已认证,FLS认证失败
     */
    public void setBusinessLicenseExpireTime(String businessLicenseExpireTime) {
        this.businessLicenseExpireTime = businessLicenseExpireTime == null ? null : businessLicenseExpireTime.trim();
    }

    /**
     * @return 企业电子邮箱认证结果,CRT待认证,OK#已认证,FLS认证失败
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email 
	 *            企业电子邮箱认证结果,CRT待认证,OK#已认证,FLS认证失败
     */
    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    /**
     * @return 法人授权书认证结果,CRT待认证,OK#已认证,FLS认证失败
     */
    public String getLegalPersonAuthorityBook() {
        return legalPersonAuthorityBook;
    }

    /**
     * @param legalPersonAuthorityBook 
	 *            法人授权书认证结果,CRT待认证,OK#已认证,FLS认证失败
     */
    public void setLegalPersonAuthorityBook(String legalPersonAuthorityBook) {
        this.legalPersonAuthorityBook = legalPersonAuthorityBook == null ? null : legalPersonAuthorityBook.trim();
    }

    /**
     * @return 工程范围认证结果,CRT待认证,OK#已认证,FLS认证失败
     */
    public String getProjectScope() {
        return projectScope;
    }

    /**
     * @param projectScope 
	 *            工程范围认证结果,CRT待认证,OK#已认证,FLS认证失败
     */
    public void setProjectScope(String projectScope) {
        this.projectScope = projectScope == null ? null : projectScope.trim();
    }

    /**
     * @return 公司简介认证结果,CRT待认证,OK#已认证,FLS认证失败
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description 
	 *            公司简介认证结果,CRT待认证,OK#已认证,FLS认证失败
     */
    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    /**
     * @return 公司网址认证结果,CRT待认证,OK#已认证,FLS认证失败
     */
    public String getWebsite() {
        return website;
    }

    /**
     * @param website 
	 *            公司网址认证结果,CRT待认证,OK#已认证,FLS认证失败
     */
    public void setWebsite(String website) {
        this.website = website == null ? null : website.trim();
    }

    /**
     * @return 公司logo,照片地址认证结果,CRT待认证,OK#已认证,FLS认证失败
     */
    public String getLogo() {
        return logo;
    }

    /**
     * @param logo 
	 *            公司logo,照片地址认证结果,CRT待认证,OK#已认证,FLS认证失败
     */
    public void setLogo(String logo) {
        this.logo = logo == null ? null : logo.trim();
    }

    /**
     * @return 公司简称认证结果,CRT待认证,OK#已认证,FLS认证失败
     */
    public String getShortName() {
        return shortName;
    }

    /**
     * @param shortName 
	 *            公司简称认证结果,CRT待认证,OK#已认证,FLS认证失败
     */
    public void setShortName(String shortName) {
        this.shortName = shortName == null ? null : shortName.trim();
    }

    /**
     * @return 注册资本认证结果,CRT待认证,OK#已认证,FLS认证失败
     */
    public String getRegisteredCapital() {
        return registeredCapital;
    }

    /**
     * @param registeredCapital 
	 *            注册资本认证结果,CRT待认证,OK#已认证,FLS认证失败
     */
    public void setRegisteredCapital(String registeredCapital) {
        this.registeredCapital = registeredCapital == null ? null : registeredCapital.trim();
    }

    /**
     * @return 经营范围认证结果,CRT待认证,OK#已认证,FLS认证失败
     */
    public String getBusinessScope() {
        return businessScope;
    }

    /**
     * @param businessScope 
	 *            经营范围认证结果,CRT待认证,OK#已认证,FLS认证失败
     */
    public void setBusinessScope(String businessScope) {
        this.businessScope = businessScope == null ? null : businessScope.trim();
    }

    /**
     * @return 企业办公地址认证结果认证结果,CRT待认证,OK#已认证,FLS认证失败
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address 
	 *            企业办公地址认证结果认证结果,CRT待认证,OK#已认证,FLS认证失败
     */
    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    /**
     * @return 法人身份证号认证结果,CRT待认证,OK#已认证,FLS认证失败
     */
    public String getLegalPersonIdcard() {
        return legalPersonIdcard;
    }

    /**
     * @param legalPersonIdcard 
	 *            法人身份证号认证结果,CRT待认证,OK#已认证,FLS认证失败
     */
    public void setLegalPersonIdcard(String legalPersonIdcard) {
        this.legalPersonIdcard = legalPersonIdcard == null ? null : legalPersonIdcard.trim();
    }

    /**
     * @return 法人身份证扫描件(正面)认证结果,CRT待认证,OK#已认证,FLS认证失败
     */
    public String getLegalPersonIdcardFrontUrl() {
        return legalPersonIdcardFrontUrl;
    }

    /**
     * @param legalPersonIdcardFrontUrl 
	 *            法人身份证扫描件(正面)认证结果,CRT待认证,OK#已认证,FLS认证失败
     */
    public void setLegalPersonIdcardFrontUrl(String legalPersonIdcardFrontUrl) {
        this.legalPersonIdcardFrontUrl = legalPersonIdcardFrontUrl == null ? null : legalPersonIdcardFrontUrl.trim();
    }

    /**
     * @return 法人身份证扫描件(反面)认证结果,CRT待认证,OK#已认证,FLS认证失败
     */
    public String getLegalPersonIdcardBackUrl() {
        return legalPersonIdcardBackUrl;
    }

    /**
     * @param legalPersonIdcardBackUrl 
	 *            法人身份证扫描件(反面)认证结果,CRT待认证,OK#已认证,FLS认证失败
     */
    public void setLegalPersonIdcardBackUrl(String legalPersonIdcardBackUrl) {
        this.legalPersonIdcardBackUrl = legalPersonIdcardBackUrl == null ? null : legalPersonIdcardBackUrl.trim();
    }

    /**
     * @return 营业执照扫描件认证结果,CRT待认证,OK#已认证,FLS认证失败
     */
    public String getBusinessLicenseUrl() {
        return businessLicenseUrl;
    }

    /**
     * @param businessLicenseUrl 
	 *            营业执照扫描件认证结果,CRT待认证,OK#已认证,FLS认证失败
     */
    public void setBusinessLicenseUrl(String businessLicenseUrl) {
        this.businessLicenseUrl = businessLicenseUrl == null ? null : businessLicenseUrl.trim();
    }

    /**
     * @return 组织机构代码证扫描件认证结果,CRT待认证,OK#已认证,FLS认证失败
     */
    public String getOrgCodeCertificateUrl() {
        return orgCodeCertificateUrl;
    }

    /**
     * @param orgCodeCertificateUrl 
	 *            组织机构代码证扫描件认证结果,CRT待认证,OK#已认证,FLS认证失败
     */
    public void setOrgCodeCertificateUrl(String orgCodeCertificateUrl) {
        this.orgCodeCertificateUrl = orgCodeCertificateUrl == null ? null : orgCodeCertificateUrl.trim();
    }

    /**
     * @return 税务登记证扫描件认证结果,CRT待认证,OK#已认证,FLS认证失败
     */
    public String getTaxRegistrationCertificateUrl() {
        return taxRegistrationCertificateUrl;
    }

    /**
     * @param taxRegistrationCertificateUrl 
	 *            税务登记证扫描件认证结果,CRT待认证,OK#已认证,FLS认证失败
     */
    public void setTaxRegistrationCertificateUrl(String taxRegistrationCertificateUrl) {
        this.taxRegistrationCertificateUrl = taxRegistrationCertificateUrl == null ? null : taxRegistrationCertificateUrl.trim();
    }

    /**
     * @return 统一社会信用代码认证结果,CRT待认证,OK#已认证,FLS认证失败
     */
    public String getUnifiedSocialCreditCode() {
        return unifiedSocialCreditCode;
    }

    /**
     * @param unifiedSocialCreditCode 
	 *            统一社会信用代码认证结果,CRT待认证,OK#已认证,FLS认证失败
     */
    public void setUnifiedSocialCreditCode(String unifiedSocialCreditCode) {
        this.unifiedSocialCreditCode = unifiedSocialCreditCode == null ? null : unifiedSocialCreditCode.trim();
    }

    /**
     * @return 统一社会信用代码扫描件认证结果,CRT待认证,OK#已认证,FLS认证失败
     */
    public String getUnifiedSocialCreditCodeUrl() {
        return unifiedSocialCreditCodeUrl;
    }

    /**
     * @param unifiedSocialCreditCodeUrl 
	 *            统一社会信用代码扫描件认证结果,CRT待认证,OK#已认证,FLS认证失败
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
        BidderCertificateAduit other = (BidderCertificateAduit) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getBidderCerticateId() == null ? other.getBidderCerticateId() == null : this.getBidderCerticateId().equals(other.getBidderCerticateId()))
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
        result = prime * result + ((getBidderCerticateId() == null) ? 0 : getBidderCerticateId().hashCode());
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