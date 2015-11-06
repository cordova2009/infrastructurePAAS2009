package com.hummingbird.paas.entity;

import java.util.Date;

/**
 * t_user_token
 */
public class UserToken {
    /**
     * 用户令牌
     */
    private String token;

    /**
     * 用户ID
     */
    private Long userid;

    /**
     * 有效时间长度（单位：秒）
     */
    private Integer expirein;

    /**
     * 应用ID
     */
    private String appid;

    /**
     * 创建时间（插入时间）
     */
    private Date inserttime;

    /**
     * 修改时间
     */
    private Date updatetime;

    /**
     * @return 用户令牌
     */
    public String getToken() {
        return token;
    }

    /**
     * @param token 
	 *            用户令牌
     */
    public void setToken(String token) {
        this.token = token == null ? null : token.trim();
    }

    /**
     * @return 用户ID
     */
    public Long getUserid() {
        return userid;
    }

    /**
     * @param userid 
	 *            用户ID
     */
    public void setUserid(Long userid) {
        this.userid = userid;
    }

    /**
     * @return 有效时间长度（单位：秒）
     */
    public Integer getExpirein() {
        return expirein;
    }

    /**
     * @param expirein 
	 *            有效时间长度（单位：秒）
     */
    public void setExpirein(Integer expirein) {
        this.expirein = expirein;
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

    /**
     * @return 创建时间（插入时间）
     */
    public Date getInserttime() {
        return inserttime;
    }

    /**
     * @param inserttime 
	 *            创建时间（插入时间）
     */
    public void setInserttime(Date inserttime) {
        this.inserttime = inserttime;
    }

    /**
     * @return 修改时间
     */
    public Date getUpdatetime() {
        return updatetime;
    }

    /**
     * @param updatetime 
	 *            修改时间
     */
    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
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
        UserToken other = (UserToken) that;
        return (this.getToken() == null ? other.getToken() == null : this.getToken().equals(other.getToken()))
            && (this.getUserid() == null ? other.getUserid() == null : this.getUserid().equals(other.getUserid()))
            && (this.getExpirein() == null ? other.getExpirein() == null : this.getExpirein().equals(other.getExpirein()))
            && (this.getAppid() == null ? other.getAppid() == null : this.getAppid().equals(other.getAppid()))
            && (this.getInserttime() == null ? other.getInserttime() == null : this.getInserttime().equals(other.getInserttime()))
            && (this.getUpdatetime() == null ? other.getUpdatetime() == null : this.getUpdatetime().equals(other.getUpdatetime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getToken() == null) ? 0 : getToken().hashCode());
        result = prime * result + ((getUserid() == null) ? 0 : getUserid().hashCode());
        result = prime * result + ((getExpirein() == null) ? 0 : getExpirein().hashCode());
        result = prime * result + ((getAppid() == null) ? 0 : getAppid().hashCode());
        result = prime * result + ((getInserttime() == null) ? 0 : getInserttime().hashCode());
        result = prime * result + ((getUpdatetime() == null) ? 0 : getUpdatetime().hashCode());
        return result;
    }
}