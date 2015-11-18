package com.hummingbird.paas.vo;

import java.util.Date;

import com.hummingbird.commonbiz.vo.PagingnationVO;

/**
 * 消息详细
 * @author YJY  
 * @since 2015年11月11日22:12:08
 * */
public class TenderSurveyBodyVO extends PagingnationVO {
	private String token;
	private String objectId;
	/**
	 * @return the token
	 */
	public String getToken() {
		return token;
	}
	/**
	 * @return the objectId
	 */
	public String getObjectId() {
		return objectId;
	}
	/**
	 * @param token the token to set
	 */
	public void setToken(String token) {
		this.token = token;
	}
	/**
	 * @param objectId the objectId to set
	 */
	public void setObjectId(String objectId) {
		this.objectId = objectId;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "TenderSurveyBodyVO [token=" + token + ", objectId=" + objectId + "]";
	}


}
