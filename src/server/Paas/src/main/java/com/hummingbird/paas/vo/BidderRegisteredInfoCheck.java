package com.hummingbird.paas.vo;

import java.util.Date;

/**
 * 投标人认证审核接口 
 * @author YJY  
 * @since 2015年11月18日17:02:12
 * @see 用于规范json
 * */

//"registeredInfoCheck":{
//    "businessLicenseNum":{"result":"OK#","msg":""},
//    "businessLicenseUrl":{"result":"OK#","msg":""},
//    "taxRegistrationNum":{"result":"OK#","msg":""},
//    "taxRegistrationUrl":{"result":"OK#","msg":""},
//    "organizationCodeNum":{"result":"OK#","msg":""},
//    "organizationCodeUrl":{"result":"OK#","msg":""},
//    "businessScope":{"result":"OK#","msg":""},
//    "regTime":{"result":"OK#","msg":""},
//    "businessLicenseExpireTime":{"result":"OK#","msg":""},
//    "address":{"result":"OK#","msg":""},
//    "businessLicenseType":{"result":"OK#","msg":""},
//    "newBusinessLicenseNum":{"result":"OK#","msg":""},
//    "newBusinessLicenseUrl":{"result":"OK#","msg":""}
//}
public class BidderRegisteredInfoCheck {
	
	private AuditInfo  business_license_num;
	private AuditInfo  business_license_url;
	private AuditInfo  tax_registration_certificate;
	private AuditInfo  tax_registration_certificate_url;
	private AuditInfo  org_code_certificate;
	private AuditInfo  org_code_certificate_url;
	private AuditInfo  business_scope;
	private AuditInfo  reg_time;
	private AuditInfo  business_license_expire_time;
	private AuditInfo  address;
//	private AuditInfo  business_license_type;
	private AuditInfo  unified_social_credit_code;
	private AuditInfo  unified_social_credit_code_url;
	/**
	 * @return the business_license_num
	 */
	public AuditInfo getBusiness_license_num() {
		return business_license_num;
	}
	/**
	 * @return the business_license_url
	 */
	public AuditInfo getBusiness_license_url() {
		return business_license_url;
	}
	/**
	 * @return the tax_registration_certificate
	 */
	public AuditInfo getTax_registration_certificate() {
		return tax_registration_certificate;
	}
	/**
	 * @return the tax_registration_certificate_url
	 */
	public AuditInfo getTax_registration_certificate_url() {
		return tax_registration_certificate_url;
	}
	/**
	 * @return the org_code_certificate
	 */
	public AuditInfo getOrg_code_certificate() {
		return org_code_certificate;
	}
	/**
	 * @return the org_code_certificate_url
	 */
	public AuditInfo getOrg_code_certificate_url() {
		return org_code_certificate_url;
	}
	/**
	 * @return the business_scope
	 */
	public AuditInfo getBusiness_scope() {
		return business_scope;
	}
	/**
	 * @return the reg_time
	 */
	public AuditInfo getReg_time() {
		return reg_time;
	}
	/**
	 * @return the business_license_expire_time
	 */
	public AuditInfo getBusiness_license_expire_time() {
		return business_license_expire_time;
	}
	/**
	 * @return the address
	 */
	public AuditInfo getAddress() {
		return address;
	}
	/**
	 * @return the unified_social_credit_code
	 */
	public AuditInfo getUnified_social_credit_code() {
		return unified_social_credit_code;
	}
	/**
	 * @return the unified_social_credit_code_url
	 */
	public AuditInfo getUnified_social_credit_code_url() {
		return unified_social_credit_code_url;
	}
	/**
	 * @param business_license_num the business_license_num to set
	 */
	public void setBusiness_license_num(AuditInfo business_license_num) {
		this.business_license_num = business_license_num;
	}
	/**
	 * @param business_license_url the business_license_url to set
	 */
	public void setBusiness_license_url(AuditInfo business_license_url) {
		this.business_license_url = business_license_url;
	}
	/**
	 * @param tax_registration_certificate the tax_registration_certificate to set
	 */
	public void setTax_registration_certificate(AuditInfo tax_registration_certificate) {
		this.tax_registration_certificate = tax_registration_certificate;
	}
	/**
	 * @param tax_registration_certificate_url the tax_registration_certificate_url to set
	 */
	public void setTax_registration_certificate_url(AuditInfo tax_registration_certificate_url) {
		this.tax_registration_certificate_url = tax_registration_certificate_url;
	}
	/**
	 * @param org_code_certificate the org_code_certificate to set
	 */
	public void setOrg_code_certificate(AuditInfo org_code_certificate) {
		this.org_code_certificate = org_code_certificate;
	}
	/**
	 * @param org_code_certificate_url the org_code_certificate_url to set
	 */
	public void setOrg_code_certificate_url(AuditInfo org_code_certificate_url) {
		this.org_code_certificate_url = org_code_certificate_url;
	}
	/**
	 * @param business_scope the business_scope to set
	 */
	public void setBusiness_scope(AuditInfo business_scope) {
		this.business_scope = business_scope;
	}
	/**
	 * @param reg_time the reg_time to set
	 */
	public void setReg_time(AuditInfo reg_time) {
		this.reg_time = reg_time;
	}
	/**
	 * @param business_license_expire_time the business_license_expire_time to set
	 */
	public void setBusiness_license_expire_time(AuditInfo business_license_expire_time) {
		this.business_license_expire_time = business_license_expire_time;
	}
	/**
	 * @param address the address to set
	 */
	public void setAddress(AuditInfo address) {
		this.address = address;
	}
	/**
	 * @param unified_social_credit_code the unified_social_credit_code to set
	 */
	public void setUnified_social_credit_code(AuditInfo unified_social_credit_code) {
		this.unified_social_credit_code = unified_social_credit_code;
	}
	/**
	 * @param unified_social_credit_code_url the unified_social_credit_code_url to set
	 */
	public void setUnified_social_credit_code_url(AuditInfo unified_social_credit_code_url) {
		this.unified_social_credit_code_url = unified_social_credit_code_url;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "BiddeeRegisteredInfoCheck [business_license_num=" + business_license_num + ", business_license_url="
				+ business_license_url + ", tax_registration_certificate=" + tax_registration_certificate
				+ ", tax_registration_certificate_url=" + tax_registration_certificate_url + ", org_code_certificate="
				+ org_code_certificate + ", org_code_certificate_url=" + org_code_certificate_url + ", business_scope="
				+ business_scope + ", reg_time=" + reg_time + ", business_license_expire_time="
				+ business_license_expire_time + ", address=" + address + ", unified_social_credit_code="
				+ unified_social_credit_code + ", unified_social_credit_code_url=" + unified_social_credit_code_url
				+ "]";
	}

	
}
