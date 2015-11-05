package com.hummingbird.paas.entity;

import java.util.Date;

/**
 * 通知模块的app输入
 */
public class Appinfo {
    /**
     * appId
     */
    private String appId;

    /**
     * appName
     */
    private String appName;

    /**
     * appKey
     */
    private String appKey;

    /**
     * appCert
     */
    private String appCert;

    /**
     * insertTime
     */
    private Date insertTime;

    /**
     * updateTime
     */
    private Date updateTime;

    /**
     * 状态,OK#正常，OFF 下线
     */
    private String status;

    /**
     * appPublicKey
     */
    private String appPublicKey;

    /**
     * @return appId
     */
    public String getAppId() {
        return appId;
    }

    /**
     * @param appid 
	 *            appId
     */
    public void setAppId(String appId) {
        this.appId = appId == null ? null : appId.trim();
    }

    /**
     * @return appName
     */
    public String getAppName() {
        return appName;
    }

    /**
     * @param appname 
	 *            appName
     */
    public void setAppName(String appName) {
        this.appName = appName == null ? null : appName.trim();
    }

    /**
     * @return appKey
     */
    public String getAppKey() {
        return appKey;
    }

    /**
     * @param appkey 
	 *            appKey
     */
    public void setAppKey(String appKey) {
        this.appKey = appKey == null ? null : appKey.trim();
    }

    /**
     * @return appCert
     */
    public String getAppCert() {
        return appCert;
    }

    /**
     * @param appcert 
	 *            appCert
     */
    public void setAppCert(String appCert) {
        this.appCert = appCert == null ? null : appCert.trim();
    }

    /**
     * @return insertTime
     */
    public Date getInsertTime() {
        return insertTime;
    }

    /**
     * @param inserttime 
	 *            insertTime
     */
    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }

    /**
     * @return updateTime
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * @param updatetime 
	 *            updateTime
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * @return 状态,OK#正常，OFF 下线
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status 
	 *            状态,OK#正常，OFF 下线
     */
    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    /**
     * @return appPublicKey
     */
    public String getAppPublicKey() {
        return appPublicKey;
    }

    /**
     * @param apppublickey 
	 *            appPublicKey
     */
    public void setAppPublicKey(String appPublicKey) {
        this.appPublicKey = appPublicKey == null ? null : appPublicKey.trim();
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
        Appinfo other = (Appinfo) that;
        return (this.getAppId() == null ? other.getAppId() == null : this.getAppId().equals(other.getAppId()))
            && (this.getAppName() == null ? other.getAppName() == null : this.getAppName().equals(other.getAppName()))
            && (this.getAppKey() == null ? other.getAppKey() == null : this.getAppKey().equals(other.getAppKey()))
            && (this.getAppCert() == null ? other.getAppCert() == null : this.getAppCert().equals(other.getAppCert()))
            && (this.getInsertTime() == null ? other.getInsertTime() == null : this.getInsertTime().equals(other.getInsertTime()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getAppPublicKey() == null ? other.getAppPublicKey() == null : this.getAppPublicKey().equals(other.getAppPublicKey()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getAppId() == null) ? 0 : getAppId().hashCode());
        result = prime * result + ((getAppName() == null) ? 0 : getAppName().hashCode());
        result = prime * result + ((getAppKey() == null) ? 0 : getAppKey().hashCode());
        result = prime * result + ((getAppCert() == null) ? 0 : getAppCert().hashCode());
        result = prime * result + ((getInsertTime() == null) ? 0 : getInsertTime().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getAppPublicKey() == null) ? 0 : getAppPublicKey().hashCode());
        return result;
    }
}