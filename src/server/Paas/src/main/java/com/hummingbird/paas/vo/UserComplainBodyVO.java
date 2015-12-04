package com.hummingbird.paas.vo;

import java.util.Date;

/**
 * 提交投诉接口 
 * @author YJY  
 * @since 2015年11月10日16:21:54
 * @see 用于规范json
 * */

//"body":{
//    "token":"12345",
//    "complainType":"PPP",
//    "refType":"PPP",
//    "refId":"1",
//    "complainContent":"付款很慢"
//}
public class UserComplainBodyVO{
	
	private String   token;

	private String   complainType;
	private String   refType;
	private String   refId;
	private String   complainContent;
	/**
	 * @return the token
	 */
	public String getToken() {
		return token;
	}
	/**
	 * @return the complainType
	 */
	public String getComplainType() {
		return complainType;
	}
	/**
	 * @return the refType
	 */
	public String getRefType() {
		return refType;
	}
	/**
	 * @return the refId
	 */
	public String getRefId() {
		return refId;
	}
	/**
	 * @return the complainContent
	 */
	public String getComplainContent() {
		return complainContent;
	}
	/**
	 * @param token the token to set
	 */
	public void setToken(String token) {
		this.token = token;
	}
	/**
	 * @param complainType the complainType to set
	 */
	public void setComplainType(String complainType) {
		this.complainType = complainType;
	}
	/**
	 * @param refType the refType to set
	 */
	public void setRefType(String refType) {
		this.refType = refType;
	}
	/**
	 * @param refId the refId to set
	 */
	public void setRefId(String refId) {
		this.refId = refId;
	}
	/**
	 * @param complainContent the complainContent to set
	 */
	public void setComplainContent(String complainContent) {
		this.complainContent = complainContent;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "UserComplainBodyVO [token=" + token + ", complainType=" + complainType + ", refType=" + refType
				+ ", refId=" + refId + ", complainContent=" + complainContent + "]";
	}
	
	
	



}
