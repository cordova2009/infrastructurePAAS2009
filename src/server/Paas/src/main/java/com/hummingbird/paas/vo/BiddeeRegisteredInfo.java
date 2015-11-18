package com.hummingbird.paas.vo;

import java.util.Date;

/**
 * 招标人公司注册信息 
 * @author YJY  
 * @since 2015年11月7日11:06:3
 * @see 用于规范json
 * */

//"registeredInfo":{
//    "businessLicenseNum":"BUSINESS_LICENSE_NUM",
//    "businessLicenseUrl":"BUSINESS_LICENSE_URL",
//    "taxRegistrationNum":"TAX_REGISTRATION_NUM",
//    "taxRegistrationUrl":"TAX_REGISTRATION_URL",
//    "organizationCodeNum":"ORGANIZATION_CODE_NUM",
//    "organizationCodeUrl":"ORGANIZATION_CODE_URL"
//    "businessScope":"经营范围",
//    "regTime":"2014-04-05",
//    "businessLicenseExpireTime":"10年",
//    "address":"",
//    "businessLicenseType":"OLD",
//    "newBusinessLicenseNum":"",
//    "newBusinessLicenseUrl":"",
//}       
public class BiddeeRegisteredInfo {
	
	private String  businessLicenseNum;
	private String  businessLicenseUrl;
	private String  taxRegistrationNum;
	private String  taxRegistrationUrl;
	private String  organizationCodeNum;
	private String  organizationCodeUrl;
	private String  businessScope;
	
	private Date    regTime;
	private Date    businessLicenseExpireTime;
	private String  address;
	private String  businessLicenseType;
	private String  newBusinessLicenseNum;
	private String  newBusinessLicenseUrl;



	/**
	 * @return the businessLicenseNum
	 */
	public String getBusinessLicenseNum() {
		return businessLicenseNum;
	}




	/**
	 * @return the businessLicenseUrl
	 */
	public String getBusinessLicenseUrl() {
		return businessLicenseUrl;
	}




	/**
	 * @return the taxRegistrationNum
	 */
	public String getTaxRegistrationNum() {
		return taxRegistrationNum;
	}




	/**
	 * @return the taxRegistrationUrl
	 */
	public String getTaxRegistrationUrl() {
		return taxRegistrationUrl;
	}




	/**
	 * @return the organizationCodeNum
	 */
	public String getOrganizationCodeNum() {
		return organizationCodeNum;
	}




	/**
	 * @return the organizationCodeUrl
	 */
	public String getOrganizationCodeUrl() {
		return organizationCodeUrl;
	}




	/**
	 * @return the businessScope
	 */
	public String getBusinessScope() {
		return businessScope;
	}




	/**
	 * @return the regTime
	 */
	public Date getRegTime() {
		return regTime;
	}




	/**
	 * @return the businessLicenseExpireTime
	 */
	public Date getBusinessLicenseExpireTime() {
		return businessLicenseExpireTime;
	}




	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}




	/**
	 * @return the businessLicenseType
	 */
	public String getBusinessLicenseType() {
		return businessLicenseType;
	}




	/**
	 * @return the newBusinessLicenseNum
	 */
	public String getNewBusinessLicenseNum() {
		return newBusinessLicenseNum;
	}




	/**
	 * @return the newBusinessLicenseUrl
	 */
	public String getNewBusinessLicenseUrl() {
		return newBusinessLicenseUrl;
	}




	/**
	 * @param businessLicenseNum the businessLicenseNum to set
	 */
	public void setBusinessLicenseNum(String businessLicenseNum) {
		this.businessLicenseNum = businessLicenseNum;
	}




	/**
	 * @param businessLicenseUrl the businessLicenseUrl to set
	 */
	public void setBusinessLicenseUrl(String businessLicenseUrl) {
		this.businessLicenseUrl = businessLicenseUrl;
	}




	/**
	 * @param taxRegistrationNum the taxRegistrationNum to set
	 */
	public void setTaxRegistrationNum(String taxRegistrationNum) {
		this.taxRegistrationNum = taxRegistrationNum;
	}




	/**
	 * @param taxRegistrationUrl the taxRegistrationUrl to set
	 */
	public void setTaxRegistrationUrl(String taxRegistrationUrl) {
		this.taxRegistrationUrl = taxRegistrationUrl;
	}




	/**
	 * @param organizationCodeNum the organizationCodeNum to set
	 */
	public void setOrganizationCodeNum(String organizationCodeNum) {
		this.organizationCodeNum = organizationCodeNum;
	}




	/**
	 * @param organizationCodeUrl the organizationCodeUrl to set
	 */
	public void setOrganizationCodeUrl(String organizationCodeUrl) {
		this.organizationCodeUrl = organizationCodeUrl;
	}




	/**
	 * @param businessScope the businessScope to set
	 */
	public void setBusinessScope(String businessScope) {
		this.businessScope = businessScope;
	}




	/**
	 * @param regTime the regTime to set
	 */
	public void setRegTime(Date regTime) {
		this.regTime = regTime;
	}




	/**
	 * @param businessLicenseExpireTime the businessLicenseExpireTime to set
	 */
	public void setBusinessLicenseExpireTime(Date businessLicenseExpireTime) {
		this.businessLicenseExpireTime = businessLicenseExpireTime;
	}




	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}




	/**
	 * @param businessLicenseType the businessLicenseType to set
	 */
	public void setBusinessLicenseType(String businessLicenseType) {
		this.businessLicenseType = businessLicenseType;
	}




	/**
	 * @param newBusinessLicenseNum the newBusinessLicenseNum to set
	 */
	public void setNewBusinessLicenseNum(String newBusinessLicenseNum) {
		this.newBusinessLicenseNum = newBusinessLicenseNum;
	}




	/**
	 * @param newBusinessLicenseUrl the newBusinessLicenseUrl to set
	 */
	public void setNewBusinessLicenseUrl(String newBusinessLicenseUrl) {
		this.newBusinessLicenseUrl = newBusinessLicenseUrl;
	}




	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "BiddeeRegisteredInfo [businessLicenseNum=" + businessLicenseNum + ", businessLicenseUrl="
				+ businessLicenseUrl + ", taxRegistrationNum=" + taxRegistrationNum + ", taxRegistrationUrl="
				+ taxRegistrationUrl + ", organizationCodeNum=" + organizationCodeNum + ", organizationCodeUrl="
				+ organizationCodeUrl + ", businessScope=" + businessScope + ", regTime=" + regTime
				+ ", businessLicenseExpireTime=" + businessLicenseExpireTime + ", address=" + address
				+ ", businessLicenseType=" + businessLicenseType + ", newBusinessLicenseNum=" + newBusinessLicenseNum
				+ ", newBusinessLicenseUrl=" + newBusinessLicenseUrl + "]";
	}



}
