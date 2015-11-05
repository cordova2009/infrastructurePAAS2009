package com.hummingbird.paas.entity;

import java.util.Date;

/**
 * 通知原始请求表
 */
public class RawNotifyRecords {
    /**
     * id
     */
    private Integer id;

    /**
     * 新增时间
     */
    private Date insert_time;

    /**
     * 应用id
     */
    private String app_id;

    /**
     * 状态,OK#接受请求,FLS拒绝请求
     */
    private String status;

    /**
     * 数据
     */
    private String data;

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
     * @return 应用id
     */
    public String getApp_id() {
        return app_id;
    }

    /**
     * @param appId 
	 *            应用id
     */
    public void setApp_id(String app_id) {
        this.app_id = app_id == null ? null : app_id.trim();
    }

    /**
     * @return 状态,OK#接受请求,FLS拒绝请求
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status 
	 *            状态,OK#接受请求,FLS拒绝请求
     */
    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    /**
     * @return 数据
     */
    public String getData() {
        return data;
    }

    /**
     * @param data 
	 *            数据
     */
    public void setData(String data) {
        this.data = data == null ? null : data.trim();
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
        RawNotifyRecords other = (RawNotifyRecords) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getInsert_time() == null ? other.getInsert_time() == null : this.getInsert_time().equals(other.getInsert_time()))
            && (this.getApp_id() == null ? other.getApp_id() == null : this.getApp_id().equals(other.getApp_id()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getData() == null ? other.getData() == null : this.getData().equals(other.getData()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getInsert_time() == null) ? 0 : getInsert_time().hashCode());
        result = prime * result + ((getApp_id() == null) ? 0 : getApp_id().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getData() == null) ? 0 : getData().hashCode());
        return result;
    }
}