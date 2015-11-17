package com.hummingbird.paas.vo;

import java.util.Date;

import com.hummingbird.commonbiz.vo.PagingnationVO;

/**
 * 消息列表
 * */
public class SmsListBodyVO extends PagingnationVO{
	
	public SmsListBodyVO() {
		
	}
	private String token;
    private String status;
    private Date startTime;
    private Date endTime;
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public Date getStartTime() {
		return startTime;
	}
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	public Date getEndTime() {
		return endTime;
	}
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
    
    
	@Override
	public String toString() {
		return " SmsListBodyVO [token=" + token + ", status=" + status + ", startTime=" + startTime + ", endTime=" + endTime +"]";
	}
}
