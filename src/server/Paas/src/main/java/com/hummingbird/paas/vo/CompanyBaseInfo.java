package com.hummingbird.paas.vo;

import java.util.Date;

import org.codehaus.jackson.map.annotate.JsonSerialize;

import com.hummingbird.common.util.convertor.JacksonDateSerializer;
import com.hummingbird.common.util.convertor.JacksonDateTimeSerializer;

/**
 * 基本信息  
 * @author YJY  
 * @since 2015年12月4日15:28:30
 * @see 用于规范json
 * */

//"baseInfo":{
//    "companyName":"蜂鸟娱乐",
//    "contactName":"联系人",
//    "registeredCapital":"注册资本",
//    "contactMobileNum":"联系方式",
//    "businessScope":"经营范围",
//    "address":"公司地址",
//    "email":"公司邮箱",
//    "description":"公司简介",
//    "regTime":"公司成立时间"
//}
public class CompanyBaseInfo {
	
	private String  companyName;
	private String  contactName;
	private String  description;
	private String  registeredCapital;
	private String  contactMobileNum;
	private String  email;
	private String  businessScope;
	
	private String  address;
	private Date  regTime;
	
	/**
	 * @return the companyName
	 */
	public String getCompanyName() {
		return companyName;
	}
	/**
	 * @return the contactName
	 */
	public String getContactName() {
		return contactName;
	}
	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * @return the registeredCapital
	 */
	public String getRegisteredCapital() {
		return registeredCapital;
	}
	/**
	 * @return the contactMobileNum
	 */
	public String getContactMobileNum() {
		return contactMobileNum;
	}
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @return the businessScope
	 */
	public String getBusinessScope() {
		return businessScope;
	}
	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}
	/**
	 * @return the regTime
	 */
	@JsonSerialize(using = JacksonDateTimeSerializer.class)
	public Date getRegTime() {
		return regTime;
	}
	/**
	 * @param companyName the companyName to set
	 */
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	/**
	 * @param contactName the contactName to set
	 */
	public void setContactName(String contactName) {
		this.contactName = contactName;
	}
	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	/**
	 * @param registeredCapital the registeredCapital to set
	 */
	public void setRegisteredCapital(String registeredCapital) {
		this.registeredCapital = registeredCapital;
	}
	/**
	 * @param contactMobileNum the contactMobileNum to set
	 */
	public void setContactMobileNum(String contactMobileNum) {
		this.contactMobileNum = contactMobileNum;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * @param businessScope the businessScope to set
	 */
	public void setBusinessScope(String businessScope) {
		this.businessScope = businessScope;
	}
	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	/**
	 * @param regTime the regTime to set
	 */
	public void setRegTime(Date regTime) {
		this.regTime = regTime;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "CompanyBaseInfo [companyName=" + companyName + ", contactName=" + contactName + ", description="
				+ description + ", registeredCapital=" + registeredCapital + ", contactMobileNum=" + contactMobileNum
				+ ", email=" + email + ", businessScope=" + businessScope + ", address=" + address + ", regTime="
				+ regTime + "]";
	}

	

}
