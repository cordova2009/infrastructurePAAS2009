package com.hummingbird.paas.entity;

import java.util.Date;

/**
 * 承包商表
 */
public class Bidder {
    /**
     * 主键
     */
    private Integer id;

    /**
     * 用户id
     */
    private Integer user_id;

    /**
     * 公司名称
     */
    private String company_name;

    /**
     * 法人名称
     */
    private String legal_person;

    /**
     * 企业成立时间
     */
    private Date reg_time;

    /**
     * 联系人
     */
    private String contact_name;

    /**
     * 联系人手机号码
     */
    private String contact_mobile_num;

    /**
     * 营业执照
     */
    private String business_license;

    /**
     * 组织机构代码证
     */
    private String org_code_certificate;

    /**
     * 税务登记证
     */
    private String tax_registration_certificate;

    /**
     * 3合1证
     */
    private String new_business_license;

    /**
     * 营业执照类型,NEW3证合1证,OLD3证
     */
    private String business_license_type;

    /**
     * 企业营业期限
     */
    private String business_license_expire_time;

    /**
     * 企业电子邮箱
     */
    private String email;

    /**
     * 法人授权书
     */
    private String legal_person_authority_book;

    /**
     * 工程范围
     */
    private String project_scope;

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
    private Date certificate_time;

    /**
     * 认证状态,CRT待认证,OK#已认证,FLS认证失败
     */
    private String certificate_status;

    /**
     * 状态,OK#正常,DIS禁用
     */
    private String status;

    /**
     * 板块分类,来自行业版块表
     */
    private String industry_id;

    /**
     * 板块分类,来自行业版块表
     */
    private String sector_id;

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
    private String short_name;

    /**
     * 注册资本
     */
    private String registered_capital;

    /**
     * 经营范围
     */
    private String business_scope;

    /**
     * 法人身份证号
     */
    private String legal_person_idcard;

    /**
     * 法人身份证扫描件(正面)
     */
    private String legal_person_idcard_front_url;

    /**
     * 法人身份证扫描件(反面)
     */
    private String legal_person_idcard_back_url;

    /**
     * 营业执照扫描件
     */
    private String business_license_url;

    /**
     * 组织机构代码证扫描件
     */
    private String org_code_certificate_url;

    /**
     * 税务登记证扫描件
     */
    private String tax_registration_certificate_url;

    /**
     * 统一社会信用代码
     */
    private String unified_social_credit_code;

    /**
     * 统一社会信用代码扫描件
     */
    private String unified_social_credit_code_url;

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
    public Integer getUser_id() {
        return user_id;
    }

    /**
     * @param userId 
	 *            用户id
     */
    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    /**
     * @return 公司名称
     */
    public String getCompany_name() {
        return company_name;
    }

    /**
     * @param companyName 
	 *            公司名称
     */
    public void setCompany_name(String company_name) {
        this.company_name = company_name == null ? null : company_name.trim();
    }

    /**
     * @return 法人名称
     */
    public String getLegal_person() {
        return legal_person;
    }

    /**
     * @param legalPerson 
	 *            法人名称
     */
    public void setLegal_person(String legal_person) {
        this.legal_person = legal_person == null ? null : legal_person.trim();
    }

    /**
     * @return 企业成立时间
     */
    public Date getReg_time() {
        return reg_time;
    }

    /**
     * @param regTime 
	 *            企业成立时间
     */
    public void setReg_time(Date reg_time) {
        this.reg_time = reg_time;
    }

    /**
     * @return 联系人
     */
    public String getContact_name() {
        return contact_name;
    }

    /**
     * @param contactName 
	 *            联系人
     */
    public void setContact_name(String contact_name) {
        this.contact_name = contact_name == null ? null : contact_name.trim();
    }

    /**
     * @return 联系人手机号码
     */
    public String getContact_mobile_num() {
        return contact_mobile_num;
    }

    /**
     * @param contactMobileNum 
	 *            联系人手机号码
     */
    public void setContact_mobile_num(String contact_mobile_num) {
        this.contact_mobile_num = contact_mobile_num == null ? null : contact_mobile_num.trim();
    }

    /**
     * @return 营业执照
     */
    public String getBusiness_license() {
        return business_license;
    }

    /**
     * @param businessLicense 
	 *            营业执照
     */
    public void setBusiness_license(String business_license) {
        this.business_license = business_license == null ? null : business_license.trim();
    }

    /**
     * @return 组织机构代码证
     */
    public String getOrg_code_certificate() {
        return org_code_certificate;
    }

    /**
     * @param orgCodeCertificate 
	 *            组织机构代码证
     */
    public void setOrg_code_certificate(String org_code_certificate) {
        this.org_code_certificate = org_code_certificate == null ? null : org_code_certificate.trim();
    }

    /**
     * @return 税务登记证
     */
    public String getTax_registration_certificate() {
        return tax_registration_certificate;
    }

    /**
     * @param taxRegistrationCertificate 
	 *            税务登记证
     */
    public void setTax_registration_certificate(String tax_registration_certificate) {
        this.tax_registration_certificate = tax_registration_certificate == null ? null : tax_registration_certificate.trim();
    }

    /**
     * @return 3合1证
     */
    public String getNew_business_license() {
        return new_business_license;
    }

    /**
     * @param newBusinessLicense 
	 *            3合1证
     */
    public void setNew_business_license(String new_business_license) {
        this.new_business_license = new_business_license == null ? null : new_business_license.trim();
    }

    /**
     * @return 营业执照类型,NEW3证合1证,OLD3证
     */
    public String getBusiness_license_type() {
        return business_license_type;
    }

    /**
     * @param businessLicenseType 
	 *            营业执照类型,NEW3证合1证,OLD3证
     */
    public void setBusiness_license_type(String business_license_type) {
        this.business_license_type = business_license_type == null ? null : business_license_type.trim();
    }

    /**
     * @return 企业营业期限
     */
    public String getBusiness_license_expire_time() {
        return business_license_expire_time;
    }

    /**
     * @param businessLicenseExpireTime 
	 *            企业营业期限
     */
    public void setBusiness_license_expire_time(String business_license_expire_time) {
        this.business_license_expire_time = business_license_expire_time == null ? null : business_license_expire_time.trim();
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
    public String getLegal_person_authority_book() {
        return legal_person_authority_book;
    }

    /**
     * @param legalPersonAuthorityBook 
	 *            法人授权书
     */
    public void setLegal_person_authority_book(String legal_person_authority_book) {
        this.legal_person_authority_book = legal_person_authority_book == null ? null : legal_person_authority_book.trim();
    }

    /**
     * @return 工程范围
     */
    public String getProject_scope() {
        return project_scope;
    }

    /**
     * @param projectScope 
	 *            工程范围
     */
    public void setProject_scope(String project_scope) {
        this.project_scope = project_scope == null ? null : project_scope.trim();
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
    public Date getCertificate_time() {
        return certificate_time;
    }

    /**
     * @param certificateTime 
	 *            认证时间
     */
    public void setCertificate_time(Date certificate_time) {
        this.certificate_time = certificate_time;
    }

    /**
     * @return 认证状态,CRT待认证,OK#已认证,FLS认证失败
     */
    public String getCertificate_status() {
        return certificate_status;
    }

    /**
     * @param certificateStatus 
	 *            认证状态,CRT待认证,OK#已认证,FLS认证失败
     */
    public void setCertificate_status(String certificate_status) {
        this.certificate_status = certificate_status == null ? null : certificate_status.trim();
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
     * @return 板块分类,来自行业版块表
     */
    public String getIndustry_id() {
        return industry_id;
    }

    /**
     * @param industryId 
	 *            板块分类,来自行业版块表
     */
    public void setIndustry_id(String industry_id) {
        this.industry_id = industry_id == null ? null : industry_id.trim();
    }

    /**
     * @return 板块分类,来自行业版块表
     */
    public String getSector_id() {
        return sector_id;
    }

    /**
     * @param sectorId 
	 *            板块分类,来自行业版块表
     */
    public void setSector_id(String sector_id) {
        this.sector_id = sector_id == null ? null : sector_id.trim();
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
    public String getShort_name() {
        return short_name;
    }

    /**
     * @param shortName 
	 *            公司简称
     */
    public void setShort_name(String short_name) {
        this.short_name = short_name == null ? null : short_name.trim();
    }

    /**
     * @return 注册资本
     */
    public String getRegistered_capital() {
        return registered_capital;
    }

    /**
     * @param registeredCapital 
	 *            注册资本
     */
    public void setRegistered_capital(String registered_capital) {
        this.registered_capital = registered_capital == null ? null : registered_capital.trim();
    }

    /**
     * @return 经营范围
     */
    public String getBusiness_scope() {
        return business_scope;
    }

    /**
     * @param businessScope 
	 *            经营范围
     */
    public void setBusiness_scope(String business_scope) {
        this.business_scope = business_scope == null ? null : business_scope.trim();
    }

    /**
     * @return 法人身份证号
     */
    public String getLegal_person_idcard() {
        return legal_person_idcard;
    }

    /**
     * @param legalPersonIdcard 
	 *            法人身份证号
     */
    public void setLegal_person_idcard(String legal_person_idcard) {
        this.legal_person_idcard = legal_person_idcard == null ? null : legal_person_idcard.trim();
    }

    /**
     * @return 法人身份证扫描件(正面)
     */
    public String getLegal_person_idcard_front_url() {
        return legal_person_idcard_front_url;
    }

    /**
     * @param legalPersonIdcardFrontUrl 
	 *            法人身份证扫描件(正面)
     */
    public void setLegal_person_idcard_front_url(String legal_person_idcard_front_url) {
        this.legal_person_idcard_front_url = legal_person_idcard_front_url == null ? null : legal_person_idcard_front_url.trim();
    }

    /**
     * @return 法人身份证扫描件(反面)
     */
    public String getLegal_person_idcard_back_url() {
        return legal_person_idcard_back_url;
    }

    /**
     * @param legalPersonIdcardBackUrl 
	 *            法人身份证扫描件(反面)
     */
    public void setLegal_person_idcard_back_url(String legal_person_idcard_back_url) {
        this.legal_person_idcard_back_url = legal_person_idcard_back_url == null ? null : legal_person_idcard_back_url.trim();
    }

    /**
     * @return 营业执照扫描件
     */
    public String getBusiness_license_url() {
        return business_license_url;
    }

    /**
     * @param businessLicenseUrl 
	 *            营业执照扫描件
     */
    public void setBusiness_license_url(String business_license_url) {
        this.business_license_url = business_license_url == null ? null : business_license_url.trim();
    }

    /**
     * @return 组织机构代码证扫描件
     */
    public String getOrg_code_certificate_url() {
        return org_code_certificate_url;
    }

    /**
     * @param orgCodeCertificateUrl 
	 *            组织机构代码证扫描件
     */
    public void setOrg_code_certificate_url(String org_code_certificate_url) {
        this.org_code_certificate_url = org_code_certificate_url == null ? null : org_code_certificate_url.trim();
    }

    /**
     * @return 税务登记证扫描件
     */
    public String getTax_registration_certificate_url() {
        return tax_registration_certificate_url;
    }

    /**
     * @param taxRegistrationCertificateUrl 
	 *            税务登记证扫描件
     */
    public void setTax_registration_certificate_url(String tax_registration_certificate_url) {
        this.tax_registration_certificate_url = tax_registration_certificate_url == null ? null : tax_registration_certificate_url.trim();
    }

    /**
     * @return 统一社会信用代码
     */
    public String getUnified_social_credit_code() {
        return unified_social_credit_code;
    }

    /**
     * @param unifiedSocialCreditCode 
	 *            统一社会信用代码
     */
    public void setUnified_social_credit_code(String unified_social_credit_code) {
        this.unified_social_credit_code = unified_social_credit_code == null ? null : unified_social_credit_code.trim();
    }

    /**
     * @return 统一社会信用代码扫描件
     */
    public String getUnified_social_credit_code_url() {
        return unified_social_credit_code_url;
    }

    /**
     * @param unifiedSocialCreditCodeUrl 
	 *            统一社会信用代码扫描件
     */
    public void setUnified_social_credit_code_url(String unified_social_credit_code_url) {
        this.unified_social_credit_code_url = unified_social_credit_code_url == null ? null : unified_social_credit_code_url.trim();
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
        Bidder other = (Bidder) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getUser_id() == null ? other.getUser_id() == null : this.getUser_id().equals(other.getUser_id()))
            && (this.getCompany_name() == null ? other.getCompany_name() == null : this.getCompany_name().equals(other.getCompany_name()))
            && (this.getLegal_person() == null ? other.getLegal_person() == null : this.getLegal_person().equals(other.getLegal_person()))
            && (this.getReg_time() == null ? other.getReg_time() == null : this.getReg_time().equals(other.getReg_time()))
            && (this.getContact_name() == null ? other.getContact_name() == null : this.getContact_name().equals(other.getContact_name()))
            && (this.getContact_mobile_num() == null ? other.getContact_mobile_num() == null : this.getContact_mobile_num().equals(other.getContact_mobile_num()))
            && (this.getBusiness_license() == null ? other.getBusiness_license() == null : this.getBusiness_license().equals(other.getBusiness_license()))
            && (this.getOrg_code_certificate() == null ? other.getOrg_code_certificate() == null : this.getOrg_code_certificate().equals(other.getOrg_code_certificate()))
            && (this.getTax_registration_certificate() == null ? other.getTax_registration_certificate() == null : this.getTax_registration_certificate().equals(other.getTax_registration_certificate()))
            && (this.getNew_business_license() == null ? other.getNew_business_license() == null : this.getNew_business_license().equals(other.getNew_business_license()))
            && (this.getBusiness_license_type() == null ? other.getBusiness_license_type() == null : this.getBusiness_license_type().equals(other.getBusiness_license_type()))
            && (this.getBusiness_license_expire_time() == null ? other.getBusiness_license_expire_time() == null : this.getBusiness_license_expire_time().equals(other.getBusiness_license_expire_time()))
            && (this.getEmail() == null ? other.getEmail() == null : this.getEmail().equals(other.getEmail()))
            && (this.getLegal_person_authority_book() == null ? other.getLegal_person_authority_book() == null : this.getLegal_person_authority_book().equals(other.getLegal_person_authority_book()))
            && (this.getProject_scope() == null ? other.getProject_scope() == null : this.getProject_scope().equals(other.getProject_scope()))
            && (this.getDescription() == null ? other.getDescription() == null : this.getDescription().equals(other.getDescription()))
            && (this.getWebsite() == null ? other.getWebsite() == null : this.getWebsite().equals(other.getWebsite()))
            && (this.getAddress() == null ? other.getAddress() == null : this.getAddress().equals(other.getAddress()))
            && (this.getCertificate_time() == null ? other.getCertificate_time() == null : this.getCertificate_time().equals(other.getCertificate_time()))
            && (this.getCertificate_status() == null ? other.getCertificate_status() == null : this.getCertificate_status().equals(other.getCertificate_status()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getIndustry_id() == null ? other.getIndustry_id() == null : this.getIndustry_id().equals(other.getIndustry_id()))
            && (this.getSector_id() == null ? other.getSector_id() == null : this.getSector_id().equals(other.getSector_id()))
            && (this.getProvince() == null ? other.getProvince() == null : this.getProvince().equals(other.getProvince()))
            && (this.getDistrict() == null ? other.getDistrict() == null : this.getDistrict().equals(other.getDistrict()))
            && (this.getLogo() == null ? other.getLogo() == null : this.getLogo().equals(other.getLogo()))
            && (this.getShort_name() == null ? other.getShort_name() == null : this.getShort_name().equals(other.getShort_name()))
            && (this.getRegistered_capital() == null ? other.getRegistered_capital() == null : this.getRegistered_capital().equals(other.getRegistered_capital()))
            && (this.getBusiness_scope() == null ? other.getBusiness_scope() == null : this.getBusiness_scope().equals(other.getBusiness_scope()))
            && (this.getLegal_person_idcard() == null ? other.getLegal_person_idcard() == null : this.getLegal_person_idcard().equals(other.getLegal_person_idcard()))
            && (this.getLegal_person_idcard_front_url() == null ? other.getLegal_person_idcard_front_url() == null : this.getLegal_person_idcard_front_url().equals(other.getLegal_person_idcard_front_url()))
            && (this.getLegal_person_idcard_back_url() == null ? other.getLegal_person_idcard_back_url() == null : this.getLegal_person_idcard_back_url().equals(other.getLegal_person_idcard_back_url()))
            && (this.getBusiness_license_url() == null ? other.getBusiness_license_url() == null : this.getBusiness_license_url().equals(other.getBusiness_license_url()))
            && (this.getOrg_code_certificate_url() == null ? other.getOrg_code_certificate_url() == null : this.getOrg_code_certificate_url().equals(other.getOrg_code_certificate_url()))
            && (this.getTax_registration_certificate_url() == null ? other.getTax_registration_certificate_url() == null : this.getTax_registration_certificate_url().equals(other.getTax_registration_certificate_url()))
            && (this.getUnified_social_credit_code() == null ? other.getUnified_social_credit_code() == null : this.getUnified_social_credit_code().equals(other.getUnified_social_credit_code()))
            && (this.getUnified_social_credit_code_url() == null ? other.getUnified_social_credit_code_url() == null : this.getUnified_social_credit_code_url().equals(other.getUnified_social_credit_code_url()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getUser_id() == null) ? 0 : getUser_id().hashCode());
        result = prime * result + ((getCompany_name() == null) ? 0 : getCompany_name().hashCode());
        result = prime * result + ((getLegal_person() == null) ? 0 : getLegal_person().hashCode());
        result = prime * result + ((getReg_time() == null) ? 0 : getReg_time().hashCode());
        result = prime * result + ((getContact_name() == null) ? 0 : getContact_name().hashCode());
        result = prime * result + ((getContact_mobile_num() == null) ? 0 : getContact_mobile_num().hashCode());
        result = prime * result + ((getBusiness_license() == null) ? 0 : getBusiness_license().hashCode());
        result = prime * result + ((getOrg_code_certificate() == null) ? 0 : getOrg_code_certificate().hashCode());
        result = prime * result + ((getTax_registration_certificate() == null) ? 0 : getTax_registration_certificate().hashCode());
        result = prime * result + ((getNew_business_license() == null) ? 0 : getNew_business_license().hashCode());
        result = prime * result + ((getBusiness_license_type() == null) ? 0 : getBusiness_license_type().hashCode());
        result = prime * result + ((getBusiness_license_expire_time() == null) ? 0 : getBusiness_license_expire_time().hashCode());
        result = prime * result + ((getEmail() == null) ? 0 : getEmail().hashCode());
        result = prime * result + ((getLegal_person_authority_book() == null) ? 0 : getLegal_person_authority_book().hashCode());
        result = prime * result + ((getProject_scope() == null) ? 0 : getProject_scope().hashCode());
        result = prime * result + ((getDescription() == null) ? 0 : getDescription().hashCode());
        result = prime * result + ((getWebsite() == null) ? 0 : getWebsite().hashCode());
        result = prime * result + ((getAddress() == null) ? 0 : getAddress().hashCode());
        result = prime * result + ((getCertificate_time() == null) ? 0 : getCertificate_time().hashCode());
        result = prime * result + ((getCertificate_status() == null) ? 0 : getCertificate_status().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getIndustry_id() == null) ? 0 : getIndustry_id().hashCode());
        result = prime * result + ((getSector_id() == null) ? 0 : getSector_id().hashCode());
        result = prime * result + ((getProvince() == null) ? 0 : getProvince().hashCode());
        result = prime * result + ((getDistrict() == null) ? 0 : getDistrict().hashCode());
        result = prime * result + ((getLogo() == null) ? 0 : getLogo().hashCode());
        result = prime * result + ((getShort_name() == null) ? 0 : getShort_name().hashCode());
        result = prime * result + ((getRegistered_capital() == null) ? 0 : getRegistered_capital().hashCode());
        result = prime * result + ((getBusiness_scope() == null) ? 0 : getBusiness_scope().hashCode());
        result = prime * result + ((getLegal_person_idcard() == null) ? 0 : getLegal_person_idcard().hashCode());
        result = prime * result + ((getLegal_person_idcard_front_url() == null) ? 0 : getLegal_person_idcard_front_url().hashCode());
        result = prime * result + ((getLegal_person_idcard_back_url() == null) ? 0 : getLegal_person_idcard_back_url().hashCode());
        result = prime * result + ((getBusiness_license_url() == null) ? 0 : getBusiness_license_url().hashCode());
        result = prime * result + ((getOrg_code_certificate_url() == null) ? 0 : getOrg_code_certificate_url().hashCode());
        result = prime * result + ((getTax_registration_certificate_url() == null) ? 0 : getTax_registration_certificate_url().hashCode());
        result = prime * result + ((getUnified_social_credit_code() == null) ? 0 : getUnified_social_credit_code().hashCode());
        result = prime * result + ((getUnified_social_credit_code_url() == null) ? 0 : getUnified_social_credit_code_url().hashCode());
        return result;
    }
}