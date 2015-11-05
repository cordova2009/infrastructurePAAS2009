package com.hummingbird.paas.entity;

import java.util.Date;

/**
 * t_user_accountcode
 */
public class UserAccountcode {
    /**
     * idt_user_accountcode
     */
    private Long idt_user_accountcode;

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
     * @return idt_user_accountcode
     */
    public Long getIdt_user_accountcode() {
        return idt_user_accountcode;
    }

    /**
     * @param idtUserAccountcode 
	 *            idt_user_accountcode
     */
    public void setIdt_user_accountcode(Long idt_user_accountcode) {
        this.idt_user_accountcode = idt_user_accountcode;
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
        UserAccountcode other = (UserAccountcode) that;
        return (this.getIdt_user_accountcode() == null ? other.getIdt_user_accountcode() == null : this.getIdt_user_accountcode().equals(other.getIdt_user_accountcode()))
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
        result = prime * result + ((getIdt_user_accountcode() == null) ? 0 : getIdt_user_accountcode().hashCode());
        result = prime * result + ((getMobileNum() == null) ? 0 : getMobileNum().hashCode());
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getSmsCode() == null) ? 0 : getSmsCode().hashCode());
        result = prime * result + ((getExpireIn() == null) ? 0 : getExpireIn().hashCode());
        result = prime * result + ((getSendTime() == null) ? 0 : getSendTime().hashCode());
        result = prime * result + ((getAppId() == null) ? 0 : getAppId().hashCode());
        return result;
    }
}