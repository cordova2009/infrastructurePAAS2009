package com.hummingbird.paas.vo;

import java.util.Date;

/**
 * 回复用户信息接口 
 * @author YJY  
 * @since 2015年11月10日16:21:54
 * @see 用于规范json
 * */

//"token":"12345",
//"informationId":1,
//"replyContent":"我可以试试"
public class UserInformationReplyBodyVO{
	
	private String   token;
	private Integer  informationId;
	private String   replyContent;
	/**
	 * @return the token
	 */
	public String getToken() {
		return token;
	}
	/**
	 * @return the informationId
	 */
	public Integer getInformationId() {
		return informationId;
	}
	/**
	 * @return the replyContent
	 */
	public String getReplyContent() {
		return replyContent;
	}
	/**
	 * @param token the token to set
	 */
	public void setToken(String token) {
		this.token = token;
	}
	/**
	 * @param informationId the informationId to set
	 */
	public void setInformationId(Integer informationId) {
		this.informationId = informationId;
	}
	/**
	 * @param replyContent the replyContent to set
	 */
	public void setReplyContent(String replyContent) {
		this.replyContent = replyContent;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "UserInformationReplyBodyVO [token=" + token + ", informationId=" + informationId + ", replyContent="
				+ replyContent + "]";
	}
	
	
}
