package com.hummingbird.paas.vo;

import java.util.Date;

/**
 * 投标人法人信息  
 * @author YJY  
 * @since 2015年11月10日16:22:45
 * @see 用于规范json
 * */

//"legalPerson":{ 
//    "name":"张三",
//    "idCard":"420923199205049230121",
//    "idCardfrontUrl":"法人身份证正面地址",
//    "idCardBackUrl":"法人身份证反面地址",
//    "authorityBookUrl":""
//}
public class BidderLegalPerson {
	
	private String  name;
	private String  idCard;
	private String  idCardfrontUrl;
	private String  idCardBackUrl;
	private String  authorityBookUrl;


	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}



	/**
	 * @return the idCard
	 */
	public String getIdCard() {
		return idCard;
	}



	/**
	 * @return the idCardfrontUrl
	 */
	public String getIdCardfrontUrl() {
		return idCardfrontUrl;
	}



	/**
	 * @return the idCardBackUrl
	 */
	public String getIdCardBackUrl() {
		return idCardBackUrl;
	}



	/**
	 * @return the authorityBookUrl
	 */
	public String getAuthorityBookUrl() {
		return authorityBookUrl;
	}



	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}



	/**
	 * @param idCard the idCard to set
	 */
	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}



	/**
	 * @param idCardfrontUrl the idCardfrontUrl to set
	 */
	public void setIdCardfrontUrl(String idCardfrontUrl) {
		this.idCardfrontUrl = idCardfrontUrl;
	}



	/**
	 * @param idCardBackUrl the idCardBackUrl to set
	 */
	public void setIdCardBackUrl(String idCardBackUrl) {
		this.idCardBackUrl = idCardBackUrl;
	}



	/**
	 * @param authorityBookUrl the authorityBookUrl to set
	 */
	public void setAuthorityBookUrl(String authorityBookUrl) {
		this.authorityBookUrl = authorityBookUrl;
	}

	@Override
	public String toString() {
		return " BiddeeLegalPerson [name=" + name+"idCard=" + idCard+"idCardfrontUrl=" + idCardfrontUrl+"idCardBackUrl=" + idCardBackUrl+"authorityBookUrl=" + authorityBookUrl+"]";
	}


}
