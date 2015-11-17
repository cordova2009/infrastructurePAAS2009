package com.hummingbird.paas.vo;

import java.util.Date;

/**
 * 消息详细
 * */
public class SmsUpdateBodyVO {
	private String token;
	private Integer smsId;
	/**
     * 通知标题
     */
    private String noticeTitle;

    /**
     * 通知内容
     */
    private String noticeText;

    /**
     * 通知类型
     */
    private String noticeType;

    /**
     * 状态
     */
    private String status;

    /**
     * 有效期
     */
    private Integer expiryDate;

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

	public String getNoticeTitle() {
		return noticeTitle;
	}

	public void setNoticeTitle(String noticeTitle) {
		this.noticeTitle = noticeTitle;
	}

	public String getNoticeText() {
		return noticeText;
	}

	public void setNoticeText(String noticeText) {
		this.noticeText = noticeText;
	}

	public String getNoticeType() {
		return noticeType;
	}

	public void setNoticeType(String noticeType) {
		this.noticeType = noticeType;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Integer getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(Integer expiryDate) {
		this.expiryDate = expiryDate;
	}

   
    
    
	/*@Override
	public String toString() {
		return " ActivityJoinBodyVO [activityId=" + activityId + ", unionId=" + unionId +"]";
	}*/
}
