package com.hummingbird.paas.entity;

import java.util.Date;

/**
 * 通知请求表
 */
public class NotifyRecords {
    /**
     * id
     */
    private Integer id;

    /**
     * app_id
     */
    private String app_id;

    /**
     * 新增时间
     */
    private Date insert_time;

    /**
     * 更新时间
     */
    private Date update_time;

    /**
     * 状态,CRT待通知，OK#已通知，FLS通知失败
     */
    private String status;

    /**
     * 通知类型,EMAIL# 邮件,SMS### 短信,WECHAT 微信
     */
    private String notify_type;

    /**
     * 通知参数
     */
    private String notify_data;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id 
	 *            id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return app_id
     */
    public String getApp_id() {
        return app_id;
    }

    /**
     * @param appId 
	 *            app_id
     */
    public void setApp_id(String app_id) {
        this.app_id = app_id == null ? null : app_id.trim();
    }

    /**
     * @return 新增时间
     */
    public Date getInsert_time() {
        return insert_time;
    }

    /**
     * @param insertTime 
	 *            新增时间
     */
    public void setInsert_time(Date insert_time) {
        this.insert_time = insert_time;
    }

    /**
     * @return 更新时间
     */
    public Date getUpdate_time() {
        return update_time;
    }

    /**
     * @param updateTime 
	 *            更新时间
     */
    public void setUpdate_time(Date update_time) {
        this.update_time = update_time;
    }

    /**
     * @return 状态,CRT待通知，OK#已通知，FLS通知失败
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status 
	 *            状态,CRT待通知，OK#已通知，FLS通知失败
     */
    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    /**
     * @return 通知类型,EMAIL# 邮件,SMS### 短信,WECHAT 微信
     */
    public String getNotify_type() {
        return notify_type;
    }

    /**
     * @param notifyType 
	 *            通知类型,EMAIL# 邮件,SMS### 短信,WECHAT 微信
     */
    public void setNotify_type(String notify_type) {
        this.notify_type = notify_type == null ? null : notify_type.trim();
    }

    /**
     * @return 通知参数
     */
    public String getNotify_data() {
        return notify_data;
    }

    /**
     * @param notifyData 
	 *            通知参数
     */
    public void setNotify_data(String notify_data) {
        this.notify_data = notify_data == null ? null : notify_data.trim();
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
        NotifyRecords other = (NotifyRecords) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getApp_id() == null ? other.getApp_id() == null : this.getApp_id().equals(other.getApp_id()))
            && (this.getInsert_time() == null ? other.getInsert_time() == null : this.getInsert_time().equals(other.getInsert_time()))
            && (this.getUpdate_time() == null ? other.getUpdate_time() == null : this.getUpdate_time().equals(other.getUpdate_time()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getNotify_type() == null ? other.getNotify_type() == null : this.getNotify_type().equals(other.getNotify_type()))
            && (this.getNotify_data() == null ? other.getNotify_data() == null : this.getNotify_data().equals(other.getNotify_data()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getApp_id() == null) ? 0 : getApp_id().hashCode());
        result = prime * result + ((getInsert_time() == null) ? 0 : getInsert_time().hashCode());
        result = prime * result + ((getUpdate_time() == null) ? 0 : getUpdate_time().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getNotify_type() == null) ? 0 : getNotify_type().hashCode());
        result = prime * result + ((getNotify_data() == null) ? 0 : getNotify_data().hashCode());
        return result;
    }
}