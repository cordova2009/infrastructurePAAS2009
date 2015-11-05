package com.hummingbird.paas.entity;

import java.util.Date;

/**
 * 发包方资质认证申请审核表
 */
public class BiddeeCertificateAduit {
    /**
     * 主键
     */
    private Integer id;

    /**
     * 发包方资质认证历史表id
     */
    private Integer biddee_certicate_id;

    /**
     * 公司名称认证结果,CRT待认证,OK#已认证,FLS认证失败
     */
    private String company_name;

    /**
     * 法人名称认证结果,CRT待认证,OK#已认证,FLS认证失败
     */
    private String legal_person;

    /**
     * 企业成立时间认证结果,CRT待认证,OK#已认证,FLS认证失败
     */
    private String reg_time;

    /**
     * 联系人认证结果,CRT待认证,OK#已认证,FLS认证失败
     */
    private String contact_name;

    /**
     * 联系人手机号码认证结果,CRT待认证,OK#已认证,FLS认证失败
     */
    private String contact_mobile_num;

    /**
     * 营业执照认证结果,CRT待认证,OK#已认证,FLS认证失败
     */
    private String business_license;

    /**
     * 组织机构代码证认证结果,CRT待认证,OK#已认证,FLS认证失败
     */
    private String org_code_certificate;

    /**
     * 税务登记证认证结果,CRT待认证,OK#已认证,FLS认证失败
     */
    private String tax_registration_certificate;

    /**
     * 3合1证认证结果,CRT待认证,OK#已认证,FLS认证失败
     */
    private String new_business_license;

    /**
     * 企业营业期限认证结果,CRT待认证,OK#已认证,FLS认证失败
     */
    private String business_license_expire_time;

    /**
     * 企业电子邮箱认证结果,CRT待认证,OK#已认证,FLS认证失败
     */
    private String email;

    /**
     * 法人授权书认证结果,CRT待认证,OK#已认证,FLS认证失败
     */
    private String legal_person_authority_book;

    /**
     * 工程范围认证结果,CRT待认证,OK#已认证,FLS认证失败
     */
    private String project_scope;

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
    private String short_name;

    /**
     * 注册资本认证结果,CRT待认证,OK#已认证,FLS认证失败
     */
    private String registered_capital;

    /**
     * 经营范围认证结果,CRT待认证,OK#已认证,FLS认证失败
     */
    private String business_scope;

    /**
     * 企业办公地址认证结果认证结果,CRT待认证,OK#已认证,FLS认证失败
     */
    private String address;

    /**
     * 法人身份证号认证结果,CRT待认证,OK#已认证,FLS认证失败
     */
    private String legal_person_idcard;

    /**
     * 法人身份证扫描件(正面)认证结果,CRT待认证,OK#已认证,FLS认证失败
     */
    private String legal_person_idcard_front_url;

    /**
     * 法人身份证扫描件(反面)认证结果,CRT待认证,OK#已认证,FLS认证失败
     */
    private String legal_person_idcard_back_url;

    /**
     * 营业执照扫描件认证结果,CRT待认证,OK#已认证,FLS认证失败
     */
    private String business_license_url;

    /**
     * 组织机构代码证扫描件认证结果,CRT待认证,OK#已认证,FLS认证失败
     */
    private String org_code_certificate_url;

    /**
     * 税务登记证扫描件认证结果,CRT待认证,OK#已认证,FLS认证失败
     */
    private String tax_registration_certificate_url;

    /**
     * 统一社会信用代码认证结果,CRT待认证,OK#已认证,FLS认证失败
     */
    private String unified_social_credit_code;

    /**
     * 统一社会信用代码扫描件认证结果,CRT待认证,OK#已认证,FLS认证失败
     */
    private String unified_social_credit_code_url;

    /**
     * 认证状态,CRT待认证,OK#已认证,FLS认证失败
     */
    private String audit_status;

    /**
     * 插入时间
     */
    private Date insert_time;

    /**
     * 审核人
     */
    private Integer auditor;

    /**
     * 审核时间
     */
    private Date audit_time;

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
    public Integer getBiddee_certicate_id() {
        return biddee_certicate_id;
    }

    /**
     * @param biddeeCerticateId 
	 *            发包方资质认证历史表id
     */
    public void setBiddee_certicate_id(Integer biddee_certicate_id) {
        this.biddee_certicate_id = biddee_certicate_id;
    }

    /**
     * @return 公司名称认证结果,CRT待认证,OK#已认证,FLS认证失败
     */
    public String getCompany_name() {
        return company_name;
    }

    /**
     * @param companyName 
	 *            公司名称认证结果,CRT待认证,OK#已认证,FLS认证失败
     */
    public void setCompany_name(String company_name) {
        this.company_name = company_name == null ? null : company_name.trim();
    }

    /**
     * @return 法人名称认证结果,CRT待认证,OK#已认证,FLS认证失败
     */
    public String getLegal_person() {
        return legal_person;
    }

    /**
     * @param legalPerson 
	 *            法人名称认证结果,CRT待认证,OK#已认证,FLS认证失败
     */
    public void setLegal_person(String legal_person) {
        this.legal_person = legal_person == null ? null : legal_person.trim();
    }

    /**
     * @return 企业成立时间认证结果,CRT待认证,OK#已认证,FLS认证失败
     */
    public String getReg_time() {
        return reg_time;
    }

    /**
     * @param regTime 
	 *            企业成立时间认证结果,CRT待认证,OK#已认证,FLS认证失败
     */
    public void setReg_time(String reg_time) {
        this.reg_time = reg_time == null ? null : reg_time.trim();
    }

    /**
     * @return 联系人认证结果,CRT待认证,OK#已认证,FLS认证失败
     */
    public String getContact_name() {
        return contact_name;
    }

    /**
     * @param contactName 
	 *            联系人认证结果,CRT待认证,OK#已认证,FLS认证失败
     */
    public void setContact_name(String contact_name) {
        this.contact_name = contact_name == null ? null : contact_name.trim();
    }

    /**
     * @return 联系人手机号码认证结果,CRT待认证,OK#已认证,FLS认证失败
     */
    public String getContact_mobile_num() {
        return contact_mobile_num;
    }

    /**
     * @param contactMobileNum 
	 *            联系人手机号码认证结果,CRT待认证,OK#已认证,FLS认证失败
     */
    public void setContact_mobile_num(String contact_mobile_num) {
        this.contact_mobile_num = contact_mobile_num == null ? null : contact_mobile_num.trim();
    }

    /**
     * @return 营业执照认证结果,CRT待认证,OK#已认证,FLS认证失败
     */
    public String getBusiness_license() {
        return business_license;
    }

    /**
     * @param businessLicense 
	 *            营业执照认证结果,CRT待认证,OK#已认证,FLS认证失败
     */
    public void setBusiness_license(String business_license) {
        this.business_license = business_license == null ? null : business_license.trim();
    }

    /**
     * @return 组织机构代码证认证结果,CRT待认证,OK#已认证,FLS认证失败
     */
    public String getOrg_code_certificate() {
        return org_code_certificate;
    }

    /**
     * @param orgCodeCertificate 
	 *            组织机构代码证认证结果,CRT待认证,OK#已认证,FLS认证失败
     */
    public void setOrg_code_certificate(String org_code_certificate) {
        this.org_code_certificate = org_code_certificate == null ? null : org_code_certificate.trim();
    }

    /**
     * @return 税务登记证认证结果,CRT待认证,OK#已认证,FLS认证失败
     */
    public String getTax_registration_certificate() {
        return tax_registration_certificate;
    }

    /**
     * @param taxRegistrationCertificate 
	 *            税务登记证认证结果,CRT待认证,OK#已认证,FLS认证失败
     */
    public void setTax_registration_certificate(String tax_registration_certificate) {
        this.tax_registration_certificate = tax_registration_certificate == null ? null : tax_registration_certificate.trim();
    }

    /**
     * @return 3合1证认证结果,CRT待认证,OK#已认证,FLS认证失败
     */
    public String getNew_business_license() {
        return new_business_license;
    }

    /**
     * @param newBusinessLicense 
	 *            3合1证认证结果,CRT待认证,OK#已认证,FLS认证失败
     */
    public void setNew_business_license(String new_business_license) {
        this.new_business_license = new_business_license == null ? null : new_business_license.trim();
    }

    /**
     * @return 企业营业期限认证结果,CRT待认证,OK#已认证,FLS认证失败
     */
    public String getBusiness_license_expire_time() {
        return business_license_expire_time;
    }

    /**
     * @param businessLicenseExpireTime 
	 *            企业营业期限认证结果,CRT待认证,OK#已认证,FLS认证失败
     */
    public void setBusiness_license_expire_time(String business_license_expire_time) {
        this.business_license_expire_time = business_license_expire_time == null ? null : business_license_expire_time.trim();
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
    public String getLegal_person_authority_book() {
        return legal_person_authority_book;
    }

    /**
     * @param legalPersonAuthorityBook 
	 *            法人授权书认证结果,CRT待认证,OK#已认证,FLS认证失败
     */
    public void setLegal_person_authority_book(String legal_person_authority_book) {
        this.legal_person_authority_book = legal_person_authority_book == null ? null : legal_person_authority_book.trim();
    }

    /**
     * @return 工程范围认证结果,CRT待认证,OK#已认证,FLS认证失败
     */
    public String getProject_scope() {
        return project_scope;
    }

    /**
     * @param projectScope 
	 *            工程范围认证结果,CRT待认证,OK#已认证,FLS认证失败
     */
    public void setProject_scope(String project_scope) {
        this.project_scope = project_scope == null ? null : project_scope.trim();
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
    public String getShort_name() {
        return short_name;
    }

    /**
     * @param shortName 
	 *            公司简称认证结果,CRT待认证,OK#已认证,FLS认证失败
     */
    public void setShort_name(String short_name) {
        this.short_name = short_name == null ? null : short_name.trim();
    }

    /**
     * @return 注册资本认证结果,CRT待认证,OK#已认证,FLS认证失败
     */
    public String getRegistered_capital() {
        return registered_capital;
    }

    /**
     * @param registeredCapital 
	 *            注册资本认证结果,CRT待认证,OK#已认证,FLS认证失败
     */
    public void setRegistered_capital(String registered_capital) {
        this.registered_capital = registered_capital == null ? null : registered_capital.trim();
    }

    /**
     * @return 经营范围认证结果,CRT待认证,OK#已认证,FLS认证失败
     */
    public String getBusiness_scope() {
        return business_scope;
    }

    /**
     * @param businessScope 
	 *            经营范围认证结果,CRT待认证,OK#已认证,FLS认证失败
     */
    public void setBusiness_scope(String business_scope) {
        this.business_scope = business_scope == null ? null : business_scope.trim();
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
    public String getLegal_person_idcard() {
        return legal_person_idcard;
    }

    /**
     * @param legalPersonIdcard 
	 *            法人身份证号认证结果,CRT待认证,OK#已认证,FLS认证失败
     */
    public void setLegal_person_idcard(String legal_person_idcard) {
        this.legal_person_idcard = legal_person_idcard == null ? null : legal_person_idcard.trim();
    }

    /**
     * @return 法人身份证扫描件(正面)认证结果,CRT待认证,OK#已认证,FLS认证失败
     */
    public String getLegal_person_idcard_front_url() {
        return legal_person_idcard_front_url;
    }

    /**
     * @param legalPersonIdcardFrontUrl 
	 *            法人身份证扫描件(正面)认证结果,CRT待认证,OK#已认证,FLS认证失败
     */
    public void setLegal_person_idcard_front_url(String legal_person_idcard_front_url) {
        this.legal_person_idcard_front_url = legal_person_idcard_front_url == null ? null : legal_person_idcard_front_url.trim();
    }

    /**
     * @return 法人身份证扫描件(反面)认证结果,CRT待认证,OK#已认证,FLS认证失败
     */
    public String getLegal_person_idcard_back_url() {
        return legal_person_idcard_back_url;
    }

    /**
     * @param legalPersonIdcardBackUrl 
	 *            法人身份证扫描件(反面)认证结果,CRT待认证,OK#已认证,FLS认证失败
     */
    public void setLegal_person_idcard_back_url(String legal_person_idcard_back_url) {
        this.legal_person_idcard_back_url = legal_person_idcard_back_url == null ? null : legal_person_idcard_back_url.trim();
    }

    /**
     * @return 营业执照扫描件认证结果,CRT待认证,OK#已认证,FLS认证失败
     */
    public String getBusiness_license_url() {
        return business_license_url;
    }

    /**
     * @param businessLicenseUrl 
	 *            营业执照扫描件认证结果,CRT待认证,OK#已认证,FLS认证失败
     */
    public void setBusiness_license_url(String business_license_url) {
        this.business_license_url = business_license_url == null ? null : business_license_url.trim();
    }

    /**
     * @return 组织机构代码证扫描件认证结果,CRT待认证,OK#已认证,FLS认证失败
     */
    public String getOrg_code_certificate_url() {
        return org_code_certificate_url;
    }

    /**
     * @param orgCodeCertificateUrl 
	 *            组织机构代码证扫描件认证结果,CRT待认证,OK#已认证,FLS认证失败
     */
    public void setOrg_code_certificate_url(String org_code_certificate_url) {
        this.org_code_certificate_url = org_code_certificate_url == null ? null : org_code_certificate_url.trim();
    }

    /**
     * @return 税务登记证扫描件认证结果,CRT待认证,OK#已认证,FLS认证失败
     */
    public String getTax_registration_certificate_url() {
        return tax_registration_certificate_url;
    }

    /**
     * @param taxRegistrationCertificateUrl 
	 *            税务登记证扫描件认证结果,CRT待认证,OK#已认证,FLS认证失败
     */
    public void setTax_registration_certificate_url(String tax_registration_certificate_url) {
        this.tax_registration_certificate_url = tax_registration_certificate_url == null ? null : tax_registration_certificate_url.trim();
    }

    /**
     * @return 统一社会信用代码认证结果,CRT待认证,OK#已认证,FLS认证失败
     */
    public String getUnified_social_credit_code() {
        return unified_social_credit_code;
    }

    /**
     * @param unifiedSocialCreditCode 
	 *            统一社会信用代码认证结果,CRT待认证,OK#已认证,FLS认证失败
     */
    public void setUnified_social_credit_code(String unified_social_credit_code) {
        this.unified_social_credit_code = unified_social_credit_code == null ? null : unified_social_credit_code.trim();
    }

    /**
     * @return 统一社会信用代码扫描件认证结果,CRT待认证,OK#已认证,FLS认证失败
     */
    public String getUnified_social_credit_code_url() {
        return unified_social_credit_code_url;
    }

    /**
     * @param unifiedSocialCreditCodeUrl 
	 *            统一社会信用代码扫描件认证结果,CRT待认证,OK#已认证,FLS认证失败
     */
    public void setUnified_social_credit_code_url(String unified_social_credit_code_url) {
        this.unified_social_credit_code_url = unified_social_credit_code_url == null ? null : unified_social_credit_code_url.trim();
    }

    /**
     * @return 认证状态,CRT待认证,OK#已认证,FLS认证失败
     */
    public String getAudit_status() {
        return audit_status;
    }

    /**
     * @param auditStatus 
	 *            认证状态,CRT待认证,OK#已认证,FLS认证失败
     */
    public void setAudit_status(String audit_status) {
        this.audit_status = audit_status == null ? null : audit_status.trim();
    }

    /**
     * @return 插入时间
     */
    public Date getInsert_time() {
        return insert_time;
    }

    /**
     * @param insertTime 
	 *            插入时间
     */
    public void setInsert_time(Date insert_time) {
        this.insert_time = insert_time;
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
    public Date getAudit_time() {
        return audit_time;
    }

    /**
     * @param auditTime 
	 *            审核时间
     */
    public void setAudit_time(Date audit_time) {
        this.audit_time = audit_time;
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
            && (this.getBiddee_certicate_id() == null ? other.getBiddee_certicate_id() == null : this.getBiddee_certicate_id().equals(other.getBiddee_certicate_id()))
            && (this.getCompany_name() == null ? other.getCompany_name() == null : this.getCompany_name().equals(other.getCompany_name()))
            && (this.getLegal_person() == null ? other.getLegal_person() == null : this.getLegal_person().equals(other.getLegal_person()))
            && (this.getReg_time() == null ? other.getReg_time() == null : this.getReg_time().equals(other.getReg_time()))
            && (this.getContact_name() == null ? other.getContact_name() == null : this.getContact_name().equals(other.getContact_name()))
            && (this.getContact_mobile_num() == null ? other.getContact_mobile_num() == null : this.getContact_mobile_num().equals(other.getContact_mobile_num()))
            && (this.getBusiness_license() == null ? other.getBusiness_license() == null : this.getBusiness_license().equals(other.getBusiness_license()))
            && (this.getOrg_code_certificate() == null ? other.getOrg_code_certificate() == null : this.getOrg_code_certificate().equals(other.getOrg_code_certificate()))
            && (this.getTax_registration_certificate() == null ? other.getTax_registration_certificate() == null : this.getTax_registration_certificate().equals(other.getTax_registration_certificate()))
            && (this.getNew_business_license() == null ? other.getNew_business_license() == null : this.getNew_business_license().equals(other.getNew_business_license()))
            && (this.getBusiness_license_expire_time() == null ? other.getBusiness_license_expire_time() == null : this.getBusiness_license_expire_time().equals(other.getBusiness_license_expire_time()))
            && (this.getEmail() == null ? other.getEmail() == null : this.getEmail().equals(other.getEmail()))
            && (this.getLegal_person_authority_book() == null ? other.getLegal_person_authority_book() == null : this.getLegal_person_authority_book().equals(other.getLegal_person_authority_book()))
            && (this.getProject_scope() == null ? other.getProject_scope() == null : this.getProject_scope().equals(other.getProject_scope()))
            && (this.getDescription() == null ? other.getDescription() == null : this.getDescription().equals(other.getDescription()))
            && (this.getWebsite() == null ? other.getWebsite() == null : this.getWebsite().equals(other.getWebsite()))
            && (this.getLogo() == null ? other.getLogo() == null : this.getLogo().equals(other.getLogo()))
            && (this.getShort_name() == null ? other.getShort_name() == null : this.getShort_name().equals(other.getShort_name()))
            && (this.getRegistered_capital() == null ? other.getRegistered_capital() == null : this.getRegistered_capital().equals(other.getRegistered_capital()))
            && (this.getBusiness_scope() == null ? other.getBusiness_scope() == null : this.getBusiness_scope().equals(other.getBusiness_scope()))
            && (this.getAddress() == null ? other.getAddress() == null : this.getAddress().equals(other.getAddress()))
            && (this.getLegal_person_idcard() == null ? other.getLegal_person_idcard() == null : this.getLegal_person_idcard().equals(other.getLegal_person_idcard()))
            && (this.getLegal_person_idcard_front_url() == null ? other.getLegal_person_idcard_front_url() == null : this.getLegal_person_idcard_front_url().equals(other.getLegal_person_idcard_front_url()))
            && (this.getLegal_person_idcard_back_url() == null ? other.getLegal_person_idcard_back_url() == null : this.getLegal_person_idcard_back_url().equals(other.getLegal_person_idcard_back_url()))
            && (this.getBusiness_license_url() == null ? other.getBusiness_license_url() == null : this.getBusiness_license_url().equals(other.getBusiness_license_url()))
            && (this.getOrg_code_certificate_url() == null ? other.getOrg_code_certificate_url() == null : this.getOrg_code_certificate_url().equals(other.getOrg_code_certificate_url()))
            && (this.getTax_registration_certificate_url() == null ? other.getTax_registration_certificate_url() == null : this.getTax_registration_certificate_url().equals(other.getTax_registration_certificate_url()))
            && (this.getUnified_social_credit_code() == null ? other.getUnified_social_credit_code() == null : this.getUnified_social_credit_code().equals(other.getUnified_social_credit_code()))
            && (this.getUnified_social_credit_code_url() == null ? other.getUnified_social_credit_code_url() == null : this.getUnified_social_credit_code_url().equals(other.getUnified_social_credit_code_url()))
            && (this.getAudit_status() == null ? other.getAudit_status() == null : this.getAudit_status().equals(other.getAudit_status()))
            && (this.getInsert_time() == null ? other.getInsert_time() == null : this.getInsert_time().equals(other.getInsert_time()))
            && (this.getAuditor() == null ? other.getAuditor() == null : this.getAuditor().equals(other.getAuditor()))
            && (this.getAudit_time() == null ? other.getAudit_time() == null : this.getAudit_time().equals(other.getAudit_time()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getBiddee_certicate_id() == null) ? 0 : getBiddee_certicate_id().hashCode());
        result = prime * result + ((getCompany_name() == null) ? 0 : getCompany_name().hashCode());
        result = prime * result + ((getLegal_person() == null) ? 0 : getLegal_person().hashCode());
        result = prime * result + ((getReg_time() == null) ? 0 : getReg_time().hashCode());
        result = prime * result + ((getContact_name() == null) ? 0 : getContact_name().hashCode());
        result = prime * result + ((getContact_mobile_num() == null) ? 0 : getContact_mobile_num().hashCode());
        result = prime * result + ((getBusiness_license() == null) ? 0 : getBusiness_license().hashCode());
        result = prime * result + ((getOrg_code_certificate() == null) ? 0 : getOrg_code_certificate().hashCode());
        result = prime * result + ((getTax_registration_certificate() == null) ? 0 : getTax_registration_certificate().hashCode());
        result = prime * result + ((getNew_business_license() == null) ? 0 : getNew_business_license().hashCode());
        result = prime * result + ((getBusiness_license_expire_time() == null) ? 0 : getBusiness_license_expire_time().hashCode());
        result = prime * result + ((getEmail() == null) ? 0 : getEmail().hashCode());
        result = prime * result + ((getLegal_person_authority_book() == null) ? 0 : getLegal_person_authority_book().hashCode());
        result = prime * result + ((getProject_scope() == null) ? 0 : getProject_scope().hashCode());
        result = prime * result + ((getDescription() == null) ? 0 : getDescription().hashCode());
        result = prime * result + ((getWebsite() == null) ? 0 : getWebsite().hashCode());
        result = prime * result + ((getLogo() == null) ? 0 : getLogo().hashCode());
        result = prime * result + ((getShort_name() == null) ? 0 : getShort_name().hashCode());
        result = prime * result + ((getRegistered_capital() == null) ? 0 : getRegistered_capital().hashCode());
        result = prime * result + ((getBusiness_scope() == null) ? 0 : getBusiness_scope().hashCode());
        result = prime * result + ((getAddress() == null) ? 0 : getAddress().hashCode());
        result = prime * result + ((getLegal_person_idcard() == null) ? 0 : getLegal_person_idcard().hashCode());
        result = prime * result + ((getLegal_person_idcard_front_url() == null) ? 0 : getLegal_person_idcard_front_url().hashCode());
        result = prime * result + ((getLegal_person_idcard_back_url() == null) ? 0 : getLegal_person_idcard_back_url().hashCode());
        result = prime * result + ((getBusiness_license_url() == null) ? 0 : getBusiness_license_url().hashCode());
        result = prime * result + ((getOrg_code_certificate_url() == null) ? 0 : getOrg_code_certificate_url().hashCode());
        result = prime * result + ((getTax_registration_certificate_url() == null) ? 0 : getTax_registration_certificate_url().hashCode());
        result = prime * result + ((getUnified_social_credit_code() == null) ? 0 : getUnified_social_credit_code().hashCode());
        result = prime * result + ((getUnified_social_credit_code_url() == null) ? 0 : getUnified_social_credit_code_url().hashCode());
        result = prime * result + ((getAudit_status() == null) ? 0 : getAudit_status().hashCode());
        result = prime * result + ((getInsert_time() == null) ? 0 : getInsert_time().hashCode());
        result = prime * result + ((getAuditor() == null) ? 0 : getAuditor().hashCode());
        result = prime * result + ((getAudit_time() == null) ? 0 : getAudit_time().hashCode());
        return result;
    }
}