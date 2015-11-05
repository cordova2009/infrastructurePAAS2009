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
    private Long userId;

    /**
     * 有效时间长度（单位：秒）
     */
    private Integer expireIn;

    /**
     * 应用ID
     */
    private String appId;

    /**
     * 创建时间（插入时间）
     */
    private Date insertTime;

    /**
     * 修改时间
     */
    private Date updateTime;

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
    public Long getUserId() {
        return userId;
    }

    /**
     * @param userid 
	 *            用户ID
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * @return 有效时间长度（单位：秒）
     */
    public Integer getExpireIn() {
        return expireIn;
    }

    /**
     * @param expirein 
	 *            有效时间长度（单位：秒）
     */
    public void setExpireIn(Integer expireIn) {
        this.expireIn = expireIn;
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

    /**
     * @return 创建时间（插入时间）
     */
    public Date getInsertTime() {
        return insertTime;
    }

    /**
     * @param inserttime 
	 *            创建时间（插入时间）
     */
    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }

    /**
     * @return 修改时间
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * @param updatetime 
	 *            修改时间
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
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
            && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getExpireIn() == null ? other.getExpireIn() == null : this.getExpireIn().equals(other.getExpireIn()))
            && (this.getAppId() == null ? other.getAppId() == null : this.getAppId().equals(other.getAppId()))
            && (this.getInsertTime() == null ? other.getInsertTime() == null : this.getInsertTime().equals(other.getInsertTime()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getToken() == null) ? 0 : getToken().hashCode());
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getExpireIn() == null) ? 0 : getExpireIn().hashCode());
        result = prime * result + ((getAppId() == null) ? 0 : getAppId().hashCode());
        result = prime * result + ((getInsertTime() == null) ? 0 : getInsertTime().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        return result;
    }
}