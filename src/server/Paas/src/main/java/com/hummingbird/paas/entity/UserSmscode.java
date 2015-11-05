package com.hummingbird.paas.entity;

import java.util.Date;

/**
 * t_user_smscode
 */
public class UserSmscode {
    /**
     * idt_user_smscode
     */
    private Integer idt_user_smscode;

    /**
     * mobileNum
     */
    private String mobileNum;

    /**
     * userId
     */
    private Long userId;

    /**
     * smsCode
     */
    private String smsCode;

    /**
     * 有效时间长度，单位：秒
     */
    private Integer expireIn;

    /**
     * 短信验证码发送时间
     */
    private Date sendTime;

    /**
     * 应用ID
     */
    private String appId;

    /**
     * @return idt_user_smscode
     */
    public Integer getIdt_user_smscode() {
        return idt_user_smscode;
    }

    /**
     * @param idtUserSmscode 
	 *            idt_user_smscode
     */
    public void setIdt_user_smscode(Integer idt_user_smscode) {
        this.idt_user_smscode = idt_user_smscode;
    }

    /**
     * @return mobileNum
     */
    public String getMobileNum() {
        return mobileNum;
    }

    /**
     * @param mobilenum 
	 *            mobileNum
     */
    public void setMobileNum(String mobileNum) {
        this.mobileNum = mobileNum == null ? null : mobileNum.trim();
    }

    /**
     * @return userId
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * @param userid 
	 *            userId
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * @return smsCode
     */
    public String getSmsCode() {
        return smsCode;
    }

    /**
     * @param smscode 
	 *            smsCode
     */
    public void setSmsCode(String smsCode) {
        this.smsCode = smsCode == null ? null : smsCode.trim();
    }

    /**
     * @return 有效时间长度，单位：秒
     */
    public Integer getExpireIn() {
        return expireIn;
    }

    /**
     * @param expirein 
	 *            有效时间长度，单位：秒
     */
    public void setExpireIn(Integer expireIn) {
        this.expireIn = expireIn;
    }

    /**
     * @return 短信验证码发送时间
     */
    public Date getSendTime() {
        return sendTime;
    }

    /**
     * @param sendtime 
	 *            短信验证码发送时间
     */
    public void setSendTime(Date sendTime) {
        this.sendTime = sendTime;
    }

    /**
     * @return 应用ID
     */
    public String getAppId() {
        return appId;
    }

    /**
     * @param appid 
	 *            应用ID
     */
    public void setAppId(String appId) {
        this.appId = appId == null ? null : appId.trim();
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        UserSmscode other = (UserSmscode) that;
        return (this.getIdt_user_smscode() == null ? other.getIdt_user_smscode() == null : this.getIdt_user_smscode().equals(other.getIdt_user_smscode()))
            && (this.getMobileNum() == null ? other.getMobileNum() == null : this.getMobileNum().equals(other.getMobileNum()))
            && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getSmsCode() == null ? other.getSmsCode() == null : this.getSmsCode().equals(other.getSmsCode()))
            && (this.getExpireIn() == null ? other.getExpireIn() == null : this.getExpireIn().equals(other.getExpireIn()))
            && (this.getSendTime() == null ? other.getSendTime() == null : this.getSendTime().equals(other.getSendTime()))
            && (this.getAppId() == null ? other.getAppId() == null : this.getAppId().equals(other.getAppId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getIdt_user_smscode() == null) ? 0 : getIdt_user_smscode().hashCode());
        result = prime * result + ((getMobileNum() == null) ? 0 : getMobileNum().hashCode());
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getSmsCode() == null) ? 0 : getSmsCode().hashCode());
        result = prime * result + ((getExpireIn() == null) ? 0 : getExpireIn().hashCode());
        result = prime * result + ((getSendTime() == null) ? 0 : getSendTime().hashCode());
        result = prime * result + ((getAppId() == null) ? 0 : getAppId().hashCode());
        return result;
    }
}