package com.hummingbird.paas.vo;

import java.util.Date;

/**
 * 招标人基本信息  
 * @author YJY  
 * @since 2015年11月7日11:06:3
 * @see 用于规范json
 * */

//"baseInfo":{
//    "companyName":"深圳蜂鸟娱乐技术有限公司",
//    "shortName":"蜂鸟娱乐",
//    "description":"公司简介",
//    "registeredCapital":"",
//    "telephone":"",
//    "email":"",
//    "logoUrl":"LOGO_IMAGE_URL"
//}
public class BiddeeBaseInfo {
	
	private String  companyName;
	private String  shortName;
	private String  description;
	private String  registeredCapital;
	private String  telephone;
	private String  email;
	private String  logoUrl;

	

	/**
	 * @return the companyName
	 */
	public String getCompanyName() {
		return companyName;
	}



	/**
	 * @return the shortName
	 */
	public String getShortName() {
		return shortName;
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
	 * @return the telephone
	 */
	public String getTelephone() {
		return telephone;
	}



	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}



	/**
	 * @return the logoUrl
	 */
	public String getLogoUrl() {
		return logoUrl;
	}



	/**
	 * @param companyName the companyName to set
	 */
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}



	/**
	 * @param shortName the shortName to set
	 */
	public void setShortName(String shortName) {
		this.shortName = shortName;
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
	 * @param telephone the telephone to set
	 */
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}



	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}



	/**
	 * @param logoUrl the logoUrl to set
	 */
	public void setLogoUrl(String logoUrl) {
		this.logoUrl = logoUrl;
	}



	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "BiddeeBaseInfo [companyName=" + companyName + ", shortName=" + shortName + ", description="
				+ description + ", registeredCapital=" + registeredCapital + ", telephone=" + telephone + ", email="
				+ email + ", logoUrl=" + logoUrl + "]";
	}
}
