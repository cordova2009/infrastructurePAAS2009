package com.hummingbird.usercenter.entity;

import java.util.Date;

/**
 * t_user_accountcode
 */
public class UserAccountcode {
    /**
     * idt_user_accountcode
     */
    private Long idtUserAccountcode;

    /**
     * mobileNum
     */
    private String mobilenum;

    /**
     * userId
     */
    private Long userid;

    /**
     * smsCode
     */
    private String smscode;

    /**
     * 有效时间长度，单位：秒
     */
    private Integer expirein;

    /**
     * 短信验证码发送时间
     */
    private Date sendtime;

    /**
     * 应用ID
     */
    private String appid;

    /**
     * @return idt_user_accountcode
     */
    public Long getIdtUserAccountcode() {
        return idtUserAccountcode;
    }

    /**
     * @param idtUserAccountcode 
	 *            idt_user_accountcode
     */
    public void setIdtUserAccountcode(Long idtUserAccountcode) {
        this.idtUserAccountcode = idtUserAccountcode;
    }

    /**
     * @return mobileNum
     */
    public String getMobilenum() {
        return mobilenum;
    }

    /**
     * @param mobilenum 
	 *            mobileNum
     */
    public void setMobilenum(String mobilenum) {
        this.mobilenum = mobilenum == null ? null : mobilenum.trim();
    }

    /**
     * @return userId
     */
    public Long getUserid() {
        return userid;
    }

    /**
     * @param userid 
	 *            userId
     */
    public void setUserid(Long userid) {
        this.userid = userid;
    }

    /**
     * @return smsCode
     */
    public String getSmscode() {
        return smscode;
    }

    /**
     * @param smscode 
	 *            smsCode
     */
    public void setSmscode(String smscode) {
        this.smscode = smscode == null ? null : smscode.trim();
    }

    /**
     * @return 有效时间长度，单位：秒
     */
    public Integer getExpirein() {
        return expirein;
    }

    /**
     * @param expirein 
	 *            有效时间长度，单位：秒
     */
    public void setExpirein(Integer expirein) {
        this.expirein = expirein;
    }

    /**
     * @return 短信验证码发送时间
     */
    public Date getSendtime() {
        return sendtime;
    }

    /**
     * @param sendtime 
	 *            短信验证码发送时间
     */
    public void setSendtime(Date sendtime) {
        this.sendtime = sendtime;
    }

    /**
     * @return 应用ID
     */
    public String getAppid() {
        return appid;
    }

    /**
     * @param appid 
	 *            应用ID
     */
    public void setAppid(String appid) {
        this.appid = appid == null ? null : appid.trim();
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
        return (this.getIdtUserAccountcode() == null ? other.getIdtUserAccountcode() == null : this.getIdtUserAccountcode().equals(other.getIdtUserAccountcode()))
            && (this.getMobilenum() == null ? other.getMobilenum() == null : this.getMobilenum().equals(other.getMobilenum()))
            && (this.getUserid() == null ? other.getUserid() == null : this.getUserid().equals(other.getUserid()))
            && (this.getSmscode() == null ? other.getSmscode() == null : this.getSmscode().equals(other.getSmscode()))
            && (this.getExpirein() == null ? other.getExpirein() == null : this.getExpirein().equals(other.getExpirein()))
            && (this.getSendtime() == null ? other.getSendtime() == null : this.getSendtime().equals(other.getSendtime()))
            && (this.getAppid() == null ? other.getAppid() == null : this.getAppid().equals(other.getAppid()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getIdtUserAccountcode() == null) ? 0 : getIdtUserAccountcode().hashCode());
        result = prime * result + ((getMobilenum() == null) ? 0 : getMobilenum().hashCode());
        result = prime * result + ((getUserid() == null) ? 0 : getUserid().hashCode());
        result = prime * result + ((getSmscode() == null) ? 0 : getSmscode().hashCode());
        result = prime * result + ((getExpirein() == null) ? 0 : getExpirein().hashCode());
        result = prime * result + ((getSendtime() == null) ? 0 : getSendtime().hashCode());
        result = prime * result + ((getAppid() == null) ? 0 : getAppid().hashCode());
        return result;
    }
}