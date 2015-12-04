package com.hummingbird.paas.vo;

import java.util.Date;

/**
 * 提交举报接口 
 * @author YJY  
 * @since 2015年12月3日14:14:50
 * @see 用于规范json
 * */

//"body":{
//    "token":"12345",
//    "reportType":"UTT",
//    "refType":"TER",
//    "refId":"1",
//    "reportContent":"这条信息涉嫌诈骗"
//}
public class UserReportBodyVO{
	
	private String   token;
	private String   reportType;
	private String   refType;
	private String   refId;
	private String   reportContent;
	
	/**
	 * @return the token
	 */
	public String getToken() {
		return token;
	}
	/**
	 * @return the reportType
	 */
	public String getReportType() {
		return reportType;
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
	 * @return the reportContent
	 */
	public String getReportContent() {
		return reportContent;
	}
	/**
	 * @param token the token to set
	 */
	public void setToken(String token) {
		this.token = token;
	}
	/**
	 * @param reportType the reportType to set
	 */
	public void setReportType(String reportType) {
		this.reportType = reportType;
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
	 * @param reportContent the reportContent to set
	 */
	public void setReportContent(String reportContent) {
		this.reportContent = reportContent;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "UserReportBodyVO [token=" + token + ", reportType=" + reportType + ", refType=" + refType + ", refId="
				+ refId + ", reportContent=" + reportContent + "]";
	}
	

	


}
