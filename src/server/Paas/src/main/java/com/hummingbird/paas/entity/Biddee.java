package com.hummingbird.paas.entity;

import java.util.Date;

/**
 * 发包方表
 */
public class Biddee {
    /**
     * 主键
     */
    private Integer id;

    /**
     * 用户id
     */
    private Integer userId;

    /**
     * 公司名称
     */
    private String companyName;

    /**
     * 法人名称
     */
    private String legalPerson;

    /**
     * 企业成立时间
     */
    private Date regTime;

    /**
     * 联系人
     */
    private String contactName;

    /**
     * 联系方式
     */
    private String contactMobileNum;

    /**
     * 营业执照
     */
    private String businessLicense;

    /**
     * 组织机构代码证
     */
    private String orgCodeCertificate;

    /**
     * 税务登记证
     */
    private String taxRegistrationCertificate;

    /**
     * 3合1证
     */
    private String newBusinessLicense;

    /**
     * 营业执照类型,NEW3证合1证,OLD3证
     */
    private String businessLicenseType;

    /**
     * 企业营业期限
     */
    private String businessLicenseExpireTime;

    /**
     * 法人身份证号
     */
    private String legalPersonIdcard;

    /**
     * 法人身份证扫描件(正面)
     */
    private String legalPersonIdcardFrontUrl;

    /**
     * 企业电子邮箱
     */
    private String email;

    /**
     * 法人授权书
     */
    private String legalPersonAuthorityBook;

    /**
     * 工程范围
     */
    private String projectScope;

    /**
     * 公司简介
     */
    private String description;

    /**
     * 公司网址
     */
    private String website;

    /**
     * 企业办公地址
     */
    private String address;

    /**
     * 认证时间
     */
    private Date certificateTime;

    /**
     * 认证状态,CRT待认证,OK#已认证,FLS认证失败
     */
    private String certificateStatus;

    /**
     * 状态,OK#正常,DIS禁用
     */
    private String status;

    /**
     * 工程类别,来自行业版块表
     */
    private String industryId;

    /**
     * 板块分类,来自行业版块表
     */
    private String sectorId;

    /**
     * 省份分类,使用区域表id
     */
    private String province;

    /**
     * 地区分类，使用区域表id
     */
    private String district;

    /**
     * 公司logo,照片地址
     */
    private String logo;

    /**
     * 公司简称
     */
    private String shortName;

    /**
     * 注册资本
     */
    private String registeredCapital;

    /**
     * 经营范围
     */
    private String businessScope;

    /**
     * 法人身份证扫描件(反面)
     */
    private String legalPersonIdcardBackUrl;

    /**
     * 营业执照扫描件
     */
    private String businessLicenseUrl;

    /**
     * 组织机构代码证扫描件
     */
    private String orgCodeCertificateUrl;

    /**
     * 税务登记证扫描件
     */
    private String taxRegistrationCertificateUrl;

    /**
     * 统一社会信用代码
     */
    private String unifiedSocialCreditCode;

    /**
     * 统一社会信用代码扫描件
     */
    private String unifiedSocialCreditCodeUrl;

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
     * @return 用户id
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * @param userId 
	 *            用户id
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * @return 公司名称
     */
    public String getCompanyName() {
        return companyName;
    }

    /**
     * @param companyName 
	 *            公司名称
     */
    public void setCompanyName(String companyName) {
        this.companyName = companyName == null ? null : companyName.trim();
    }

    /**
     * @return 法人名称
     */
    public String getLegalPerson() {
        return legalPerson;
    }

    /**
     * @param legalPerson 
	 *            法人名称
     */
    public void setLegalPerson(String legalPerson) {
        this.legalPerson = legalPerson == null ? null : legalPerson.trim();
    }

    /**
     * @return 企业成立时间
     */
    public Date getRegTime() {
        return regTime;
    }

    /**
     * @param regTime 
	 *            企业成立时间
     */
    public void setRegTime(Date regTime) {
        this.regTime = regTime;
    }

    /**
     * @return 联系人
     */
    public String getContactName() {
        return contactName;
    }

    /**
     * @param contactName 
	 *            联系人
     */
    public void setContactName(String contactName) {
        this.contactName = contactName == null ? null : contactName.trim();
    }

    /**
     * @return 联系方式
     */
    public String getContactMobileNum() {
        return contactMobileNum;
    }

    /**
     * @param contactMobileNum 
	 *            联系方式
     */
    public void setContactMobileNum(String contactMobileNum) {
        this.contactMobileNum = contactMobileNum == null ? null : contactMobileNum.trim();
    }

    /**
     * @return 营业执照
     */
    public String getBusinessLicense() {
        return businessLicense;
    }

    /**
     * @param businessLicense 
	 *            营业执照
     */
    public void setBusinessLicense(String businessLicense) {
        this.businessLicense = businessLicense == null ? null : businessLicense.trim();
    }

    /**
     * @return 组织机构代码证
     */
    public String getOrgCodeCertificate() {
        return orgCodeCertificate;
    }

    /**
     * @param orgCodeCertificate 
	 *            组织机构代码证
     */
    public void setOrgCodeCertificate(String orgCodeCertificate) {
        this.orgCodeCertificate = orgCodeCertificate == null ? null : orgCodeCertificate.trim();
    }

    /**
     * @return 税务登记证
     */
    public String getTaxRegistrationCertificate() {
        return taxRegistrationCertificate;
    }

    /**
     * @param taxRegistrationCertificate 
	 *            税务登记证
     */
    public void setTaxRegistrationCertificate(String taxRegistrationCertificate) {
        this.taxRegistrationCertificate = taxRegistrationCertificate == null ? null : taxRegistrationCertificate.trim();
    }

    /**
     * @return 3合1证
     */
    public String getNewBusinessLicense() {
        return newBusinessLicense;
    }

    /**
     * @param newBusinessLicense 
	 *            3合1证
     */
    public void setNewBusinessLicense(String newBusinessLicense) {
        this.newBusinessLicense = newBusinessLicense == null ? null : newBusinessLicense.trim();
    }

    /**
     * @return 营业执照类型,NEW3证合1证,OLD3证
     */
    public String getBusinessLicenseType() {
        return businessLicenseType;
    }

    /**
     * @param businessLicenseType 
	 *            营业执照类型,NEW3证合1证,OLD3证
     */
    public void setBusinessLicenseType(String businessLicenseType) {
        this.businessLicenseType = businessLicenseType == null ? null : businessLicenseType.trim();
    }

    /**
     * @return 企业营业期限
     */
    public String getBusinessLicenseExpireTime() {
        return businessLicenseExpireTime;
    }

    /**
     * @param businessLicenseExpireTime 
	 *            企业营业期限
     */
    public void setBusinessLicenseExpireTime(String businessLicenseExpireTime) {
        this.businessLicenseExpireTime = businessLicenseExpireTime == null ? null : businessLicenseExpireTime.trim();
    }

    /**
     * @return 法人身份证号
     */
    public String getLegalPersonIdcard() {
        return legalPersonIdcard;
    }

    /**
     * @param legalPersonIdcard 
	 *            法人身份证号
     */
    public void setLegalPersonIdcard(String legalPersonIdcard) {
        this.legalPersonIdcard = legalPersonIdcard == null ? null : legalPersonIdcard.trim();
    }

    /**
     * @return 法人身份证扫描件(正面)
     */
    public String getLegalPersonIdcardFrontUrl() {
        return legalPersonIdcardFrontUrl;
    }

    /**
     * @param legalPersonIdcardFrontUrl 
	 *            法人身份证扫描件(正面)
     */
    public void setLegalPersonIdcardFrontUrl(String legalPersonIdcardFrontUrl) {
        this.legalPersonIdcardFrontUrl = legalPersonIdcardFrontUrl == null ? null : legalPersonIdcardFrontUrl.trim();
    }

    /**
     * @return 企业电子邮箱
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email 
	 *            企业电子邮箱
     */
    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    /**
     * @return 法人授权书
     */
    public String getLegalPersonAuthorityBook() {
        return legalPersonAuthorityBook;
    }

    /**
     * @param legalPersonAuthorityBook 
	 *            法人授权书
     */
    public void setLegalPersonAuthorityBook(String legalPersonAuthorityBook) {
        this.legalPersonAuthorityBook = legalPersonAuthorityBook == null ? null : legalPersonAuthorityBook.trim();
    }

    /**
     * @return 工程范围
     */
    public String getProjectScope() {
        return projectScope;
    }

    /**
     * @param projectScope 
	 *            工程范围
     */
    public void setProjectScope(String projectScope) {
        this.projectScope = projectScope == null ? null : projectScope.trim();
    }

    /**
     * @return 公司简介
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description 
	 *            公司简介
     */
    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    /**
     * @return 公司网址
     */
    public String getWebsite() {
        return website;
    }

    /**
     * @param website 
	 *            公司网址
     */
    public void setWebsite(String website) {
        this.website = website == null ? null : website.trim();
    }

    /**
     * @return 企业办公地址
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address 
	 *            企业办公地址
     */
    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    /**
     * @return 认证时间
     */
    public Date getCertificateTime() {
        return certificateTime;
    }

    /**
     * @param certificateTime 
	 *            认证时间
     */
    public void setCertificateTime(Date certificateTime) {
        this.certificateTime = certificateTime;
    }

    /**
     * @return 认证状态,CRT待认证,OK#已认证,FLS认证失败
     */
    public String getCertificateStatus() {
        return certificateStatus;
    }

    /**
     * @param certificateStatus 
	 *            认证状态,CRT待认证,OK#已认证,FLS认证失败
     */
    public void setCertificateStatus(String certificateStatus) {
        this.certificateStatus = certificateStatus == null ? null : certificateStatus.trim();
    }

    /**
     * @return 状态,OK#正常,DIS禁用
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status 
	 *            状态,OK#正常,DIS禁用
     */
    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    /**
     * @return 工程类别,来自行业版块表
     */
    public String getIndustryId() {
        return industryId;
    }

    /**
     * @param industryId 
	 *            工程类别,来自行业版块表
     */
    public void setIndustryId(String industryId) {
        this.industryId = industryId == null ? null : industryId.trim();
    }

    /**
     * @return 板块分类,来自行业版块表
     */
    public String getSectorId() {
        return sectorId;
    }

    /**
     * @param sectorId 
	 *            板块分类,来自行业版块表
     */
    public void setSectorId(String sectorId) {
        this.sectorId = sectorId == null ? null : sectorId.trim();
    }

    /**
     * @return 省份分类,使用区域表id
     */
    public String getProvince() {
        return province;
    }

    /**
     * @param province 
	 *            省份分类,使用区域表id
     */
    public void setProvince(String province) {
        this.province = province == null ? null : province.trim();
    }

    /**
     * @return 地区分类，使用区域表id
     */
    public String getDistrict() {
        return district;
    }

    /**
     * @param district 
	 *            地区分类，使用区域表id
     */
    public void setDistrict(String district) {
        this.district = district == null ? null : district.trim();
    }

    /**
     * @return 公司logo,照片地址
     */
    public String getLogo() {
        return logo;
    }

    /**
     * @param logo 
	 *            公司logo,照片地址
     */
    public void setLogo(String logo) {
        this.logo = logo == null ? null : logo.trim();
    }

    /**
     * @return 公司简称
     */
    public String getShortName() {
        return shortName;
    }

    /**
     * @param shortName 
	 *            公司简称
     */
    public void setShortName(String shortName) {
        this.shortName = shortName == null ? null : shortName.trim();
    }

    /**
     * @return 注册资本
     */
    public String getRegisteredCapital() {
        return registeredCapital;
    }

    /**
     * @param registeredCapital 
	 *            注册资本
     */
    public void setRegisteredCapital(String registeredCapital) {
        this.registeredCapital = registeredCapital == null ? null : registeredCapital.trim();
    }

    /**
     * @return 经营范围
     */
    public String getBusinessScope() {
        return businessScope;
    }

    /**
     * @param businessScope 
	 *            经营范围
     */
    public void setBusinessScope(String businessScope) {
        this.businessScope = businessScope == null ? null : businessScope.trim();
    }

    /**
     * @return 法人身份证扫描件(反面)
     */
    public String getLegalPersonIdcardBackUrl() {
        return legalPersonIdcardBackUrl;
    }

    /**
     * @param legalPersonIdcardBackUrl 
	 *            法人身份证扫描件(反面)
     */
    public void setLegalPersonIdcardBackUrl(String legalPersonIdcardBackUrl) {
        this.legalPersonIdcardBackUrl = legalPersonIdcardBackUrl == null ? null : legalPersonIdcardBackUrl.trim();
    }

    /**
     * @return 营业执照扫描件
     */
    public String getBusinessLicenseUrl() {
        return businessLicenseUrl;
    }

    /**
     * @param businessLicenseUrl 
	 *            营业执照扫描件
     */
    public void setBusinessLicenseUrl(String businessLicenseUrl) {
        this.businessLicenseUrl = businessLicenseUrl == null ? null : businessLicenseUrl.trim();
    }

    /**
     * @return 组织机构代码证扫描件
     */
    public String getOrgCodeCertificateUrl() {
        return orgCodeCertificateUrl;
    }

    /**
     * @param orgCodeCertificateUrl 
	 *            组织机构代码证扫描件
     */
    public void setOrgCodeCertificateUrl(String orgCodeCertificateUrl) {
        this.orgCodeCertificateUrl = orgCodeCertificateUrl == null ? null : orgCodeCertificateUrl.trim();
    }

    /**
     * @return 税务登记证扫描件
     */
    public String getTaxRegistrationCertificateUrl() {
        return taxRegistrationCertificateUrl;
    }

    /**
     * @param taxRegistrationCertificateUrl 
	 *            税务登记证扫描件
     */
    public void setTaxRegistrationCertificateUrl(String taxRegistrationCertificateUrl) {
        this.taxRegistrationCertificateUrl = taxRegistrationCertificateUrl == null ? null : taxRegistrationCertificateUrl.trim();
    }

    /**
     * @return 统一社会信用代码
     */
    public String getUnifiedSocialCreditCode() {
        return unifiedSocialCreditCode;
    }

    /**
     * @param unifiedSocialCreditCode 
	 *            统一社会信用代码
     */
    public void setUnifiedSocialCreditCode(String unifiedSocialCreditCode) {
        this.unifiedSocialCreditCode = unifiedSocialCreditCode == null ? null : unifiedSocialCreditCode.trim();
    }

    /**
     * @return 统一社会信用代码扫描件
     */
    public String getUnifiedSocialCreditCodeUrl() {
        return unifiedSocialCreditCodeUrl;
    }

    /**
     * @param unifiedSocialCreditCodeUrl 
	 *            统一社会信用代码扫描件
     */
    public void setUnifiedSocialCreditCodeUrl(String unifiedSocialCreditCodeUrl) {
        this.unifiedSocialCreditCodeUrl = unifiedSocialCreditCodeUrl == null ? null : unifiedSocialCreditCodeUrl.trim();
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
        Biddee other = (Biddee) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getCompanyName() == null ? other.getCompanyName() == null : this.getCompanyName().equals(other.getCompanyName()))
            && (this.getLegalPerson() == null ? other.getLegalPerson() == null : this.getLegalPerson().equals(other.getLegalPerson()))
            && (this.getRegTime() == null ? other.getRegTime() == null : this.getRegTime().equals(other.getRegTime()))
            && (this.getContactName() == null ? other.getContactName() == null : this.getContactName().equals(other.getContactName()))
            && (this.getContactMobileNum() == null ? other.getContactMobileNum() == null : this.getContactMobileNum().equals(other.getContactMobileNum()))
            && (this.getBusinessLicense() == null ? other.getBusinessLicense() == null : this.getBusinessLicense().equals(other.getBusinessLicense()))
            && (this.getOrgCodeCertificate() == null ? other.getOrgCodeCertificate() == null : this.getOrgCodeCertificate().equals(other.getOrgCodeCertificate()))
            && (this.getTaxRegistrationCertificate() == null ? other.getTaxRegistrationCertificate() == null : this.getTaxRegistrationCertificate().equals(other.getTaxRegistrationCertificate()))
            && (this.getNewBusinessLicense() == null ? other.getNewBusinessLicense() == null : this.getNewBusinessLicense().equals(other.getNewBusinessLicense()))
            && (this.getBusinessLicenseType() == null ? other.getBusinessLicenseType() == null : this.getBusinessLicenseType().equals(other.getBusinessLicenseType()))
            && (this.getBusinessLicenseExpireTime() == null ? other.getBusinessLicenseExpireTime() == null : this.getBusinessLicenseExpireTime().equals(other.getBusinessLicenseExpireTime()))
            && (this.getLegalPersonIdcard() == null ? other.getLegalPersonIdcard() == null : this.getLegalPersonIdcard().equals(other.getLegalPersonIdcard()))
            && (this.getLegalPersonIdcardFrontUrl() == null ? other.getLegalPersonIdcardFrontUrl() == null : this.getLegalPersonIdcardFrontUrl().equals(other.getLegalPersonIdcardFrontUrl()))
            && (this.getEmail() == null ? other.getEmail() == null : this.getEmail().equals(other.getEmail()))
            && (this.getLegalPersonAuthorityBook() == null ? other.getLegalPersonAuthorityBook() == null : this.getLegalPersonAuthorityBook().equals(other.getLegalPersonAuthorityBook()))
            && (this.getProjectScope() == null ? other.getProjectScope() == null : this.getProjectScope().equals(other.getProjectScope()))
            && (this.getDescription() == null ? other.getDescription() == null : this.getDescription().equals(other.getDescription()))
            && (this.getWebsite() == null ? other.getWebsite() == null : this.getWebsite().equals(other.getWebsite()))
            && (this.getAddress() == null ? other.getAddress() == null : this.getAddress().equals(other.getAddress()))
            && (this.getCertificateTime() == null ? other.getCertificateTime() == null : this.getCertificateTime().equals(other.getCertificateTime()))
            && (this.getCertificateStatus() == null ? other.getCertificateStatus() == null : this.getCertificateStatus().equals(other.getCertificateStatus()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getIndustryId() == null ? other.getIndustryId() == null : this.getIndustryId().equals(other.getIndustryId()))
            && (this.getSectorId() == null ? other.getSectorId() == null : this.getSectorId().equals(other.getSectorId()))
            && (this.getProvince() == null ? other.getProvince() == null : this.getProvince().equals(other.getProvince()))
            && (this.getDistrict() == null ? other.getDistrict() == null : this.getDistrict().equals(other.getDistrict()))
            && (this.getLogo() == null ? other.getLogo() == null : this.getLogo().equals(other.getLogo()))
            && (this.getShortName() == null ? other.getShortName() == null : this.getShortName().equals(other.getShortName()))
            && (this.getRegisteredCapital() == null ? other.getRegisteredCapital() == null : this.getRegisteredCapital().equals(other.getRegisteredCapital()))
            && (this.getBusinessScope() == null ? other.getBusinessScope() == null : this.getBusinessScope().equals(other.getBusinessScope()))
            && (this.getLegalPersonIdcardBackUrl() == null ? other.getLegalPersonIdcardBackUrl() == null : this.getLegalPersonIdcardBackUrl().equals(other.getLegalPersonIdcardBackUrl()))
            && (this.getBusinessLicenseUrl() == null ? other.getBusinessLicenseUrl() == null : this.getBusinessLicenseUrl().equals(other.getBusinessLicenseUrl()))
            && (this.getOrgCodeCertificateUrl() == null ? other.getOrgCodeCertificateUrl() == null : this.getOrgCodeCertificateUrl().equals(other.getOrgCodeCertificateUrl()))
            && (this.getTaxRegistrationCertificateUrl() == null ? other.getTaxRegistrationCertificateUrl() == null : this.getTaxRegistrationCertificateUrl().equals(other.getTaxRegistrationCertificateUrl()))
            && (this.getUnifiedSocialCreditCode() == null ? other.getUnifiedSocialCreditCode() == null : this.getUnifiedSocialCreditCode().equals(other.getUnifiedSocialCreditCode()))
            && (this.getUnifiedSocialCreditCodeUrl() == null ? other.getUnifiedSocialCreditCodeUrl() == null : this.getUnifiedSocialCreditCodeUrl().equals(other.getUnifiedSocialCreditCodeUrl()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getCompanyName() == null) ? 0 : getCompanyName().hashCode());
        result = prime * result + ((getLegalPerson() == null) ? 0 : getLegalPerson().hashCode());
        result = prime * result + ((getRegTime() == null) ? 0 : getRegTime().hashCode());
        result = prime * result + ((getContactName() == null) ? 0 : getContactName().hashCode());
        result = prime * result + ((getContactMobileNum() == null) ? 0 : getContactMobileNum().hashCode());
        result = prime * result + ((getBusinessLicense() == null) ? 0 : getBusinessLicense().hashCode());
        result = prime * result + ((getOrgCodeCertificate() == null) ? 0 : getOrgCodeCertificate().hashCode());
        result = prime * result + ((getTaxRegistrationCertificate() == null) ? 0 : getTaxRegistrationCertificate().hashCode());
        result = prime * result + ((getNewBusinessLicense() == null) ? 0 : getNewBusinessLicense().hashCode());
        result = prime * result + ((getBusinessLicenseType() == null) ? 0 : getBusinessLicenseType().hashCode());
        result = prime * result + ((getBusinessLicenseExpireTime() == null) ? 0 : getBusinessLicenseExpireTime().hashCode());
        result = prime * result + ((getLegalPersonIdcard() == null) ? 0 : getLegalPersonIdcard().hashCode());
        result = prime * result + ((getLegalPersonIdcardFrontUrl() == null) ? 0 : getLegalPersonIdcardFrontUrl().hashCode());
        result = prime * result + ((getEmail() == null) ? 0 : getEmail().hashCode());
        result = prime * result + ((getLegalPersonAuthorityBook() == null) ? 0 : getLegalPersonAuthorityBook().hashCode());
        result = prime * result + ((getProjectScope() == null) ? 0 : getProjectScope().hashCode());
        result = prime * result + ((getDescription() == null) ? 0 : getDescription().hashCode());
        result = prime * result + ((getWebsite() == null) ? 0 : getWebsite().hashCode());
        result = prime * result + ((getAddress() == null) ? 0 : getAddress().hashCode());
        result = prime * result + ((getCertificateTime() == null) ? 0 : getCertificateTime().hashCode());
        result = prime * result + ((getCertificateStatus() == null) ? 0 : getCertificateStatus().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getIndustryId() == null) ? 0 : getIndustryId().hashCode());
        result = prime * result + ((getSectorId() == null) ? 0 : getSectorId().hashCode());
        result = prime * result + ((getProvince() == null) ? 0 : getProvince().hashCode());
        result = prime * result + ((getDistrict() == null) ? 0 : getDistrict().hashCode());
        result = prime * result + ((getLogo() == null) ? 0 : getLogo().hashCode());
        result = prime * result + ((getShortName() == null) ? 0 : getShortName().hashCode());
        result = prime * result + ((getRegisteredCapital() == null) ? 0 : getRegisteredCapital().hashCode());
        result = prime * result + ((getBusinessScope() == null) ? 0 : getBusinessScope().hashCode());
        result = prime * result + ((getLegalPersonIdcardBackUrl() == null) ? 0 : getLegalPersonIdcardBackUrl().hashCode());
        result = prime * result + ((getBusinessLicenseUrl() == null) ? 0 : getBusinessLicenseUrl().hashCode());
        result = prime * result + ((getOrgCodeCertificateUrl() == null) ? 0 : getOrgCodeCertificateUrl().hashCode());
        result = prime * result + ((getTaxRegistrationCertificateUrl() == null) ? 0 : getTaxRegistrationCertificateUrl().hashCode());
        result = prime * result + ((getUnifiedSocialCreditCode() == null) ? 0 : getUnifiedSocialCreditCode().hashCode());
        result = prime * result + ((getUnifiedSocialCreditCodeUrl() == null) ? 0 : getUnifiedSocialCreditCodeUrl().hashCode());
        return result;
    }
}