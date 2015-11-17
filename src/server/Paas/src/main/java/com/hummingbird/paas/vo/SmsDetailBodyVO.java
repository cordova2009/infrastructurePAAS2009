package com.hummingbird.paas.vo;

import java.util.Date;

/**
 * 消息详细
 * */
public class SmsDetailBodyVO {
	private String token;
	private Integer smsId;
	

	public Integer getSmsId() {
		return smsId;
	}

	public void setSmsId(Integer smsId) {
		this.smsId = smsId;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

   
    
   /* 
	@Override
	public String toString() {
		return " ActivityJoinBodyVO [activityId=" + activityId + ", unionId=" + unionId +"]";
	}*/
}
