package com.hummingbird.paas.vo;

/**
 * 审核用户发布的信息
 * @author panda
 * @since 2015年12月22日10:21:54s
 * @see 用于规范json
 * */

public class UserInformationAuditBodyVO{
	
	private String   token;
	private Integer   informationId;
	private String   auditStatus;
	
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
	
	public String getAuditStatus() {
		return auditStatus;
	}
	public void setAuditStatus(String auditStatus) {
		this.auditStatus = auditStatus;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "UserInformationAuditReturnVO [token=" + token + ", informationId=" + informationId + ", auditStatus=" + auditStatus + "]";
	}


}
