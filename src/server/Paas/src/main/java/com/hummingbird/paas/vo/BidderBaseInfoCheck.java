package com.hummingbird.paas.vo;

import java.util.Date;

/**
 * 投标人认证审核接口 
 * @author YJY  
 * @since 2015年11月18日17:00:06
 * @see 用于规范json
 * */

//"legalPerson":{
//    "name":{"result":"OK#","msg":""},
//    "idCard":{"result":"OK#","msg":""},
//    "idCardfrontUrl":{"result":"OK#","msg":""},
//    "idCardBackUrl{"result":"OK#","msg":""},
//    "authorityBookUrl":{"result":"OK#","msg":""}
//}
public class BidderBaseInfoCheck {
	
	private Integer  bidder_id;
	private AuditInfo  company_name;
	private AuditInfo  short_name;
	private AuditInfo  description;
	private AuditInfo  registered_capital;
	private AuditInfo  contact_mobile_num;
	private AuditInfo  email;
	private AuditInfo  logo;
	/**
	 * @return the bidder_id
	 */
	public Integer getBidder_id() {
		return bidder_id;
	}
	/**
	 * @return the company_name
	 */
	public AuditInfo getCompany_name() {
		return company_name;
	}
	/**
	 * @return the short_name
	 */
	public AuditInfo getShort_name() {
		return short_name;
	}
	/**
	 * @return the description
	 */
	public AuditInfo getDescription() {
		return description;
	}
	/**
	 * @return the registered_capital
	 */
	public AuditInfo getRegistered_capital() {
		return registered_capital;
	}
	/**
	 * @return the contact_mobile_num
	 */
	public AuditInfo getContact_mobile_num() {
		return contact_mobile_num;
	}
	/**
	 * @return the email
	 */
	public AuditInfo getEmail() {
		return email;
	}
	/**
	 * @return the logo
	 */
	public AuditInfo getLogo() {
		return logo;
	}
	/**
	 * @param bidder_id the bidder_id to set
	 */
	public void setBidder_id(Integer bidder_id) {
		this.bidder_id = bidder_id;
	}
	/**
	 * @param company_name the company_name to set
	 */
	public void setCompany_name(AuditInfo company_name) {
		this.company_name = company_name;
	}
	/**
	 * @param short_name the short_name to set
	 */
	public void setShort_name(AuditInfo short_name) {
		this.short_name = short_name;
	}
	/**
	 * @param description the description to set
	 */
	public void setDescription(AuditInfo description) {
		this.description = description;
	}
	/**
	 * @param registered_capital the registered_capital to set
	 */
	public void setRegistered_capital(AuditInfo registered_capital) {
		this.registered_capital = registered_capital;
	}
	/**
	 * @param contact_mobile_num the contact_mobile_num to set
	 */
	public void setContact_mobile_num(AuditInfo contact_mobile_num) {
		this.contact_mobile_num = contact_mobile_num;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(AuditInfo email) {
		this.email = email;
	}
	/**
	 * @param logo the logo to set
	 */
	public void setLogo(AuditInfo logo) {
		this.logo = logo;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "BidderBaseInfoCheck [bidder_id=" + bidder_id + ", company_name=" + company_name + ", short_name="
				+ short_name + ", description=" + description + ", registered_capital=" + registered_capital
				+ ", contact_mobile_num=" + contact_mobile_num + ", email=" + email + ", logo=" + logo + "]";
	}
	

	
}
