package com.hummingbird.paas.entity;

import java.util.Date;

/**
 * 工程信息表,工程由标的中标后转化而来
 */
public class ProjectStatus {
    /**
     * 工程编号,使用 GC00日期时间随机数
     */
    private String projectId;

    /**
     * 标的id
     */
    private String objectId;

    /**
     * 承包商id
     */
    private Integer bidderId;

    /**
     * 工程状态,OK# 施工中,END 完结,FLS 终止
     */
    private String status;

    /**
     * 发包方id
     */
    private Integer biddeeId;

    /**
     * 开工时间
     */
    private Date startTime;

    /**
     * 结束时间
     */
    private Date endTime;

    /**
     * @return 工程编号,使用 GC00日期时间随机数
     */
    public String getProjectId() {
        return projectId;
    }

    /**
     * @param projectId 
	 *            工程编号,使用 GC00日期时间随机数
     */
    public void setProjectId(String projectId) {
        this.projectId = projectId == null ? null : projectId.trim();
    }

    /**
     * @return 标的id
     */
    public String getObjectId() {
        return objectId;
    }

    /**
     * @param objectId 
	 *            标的id
     */
    public void setObjectId(String objectId) {
        this.objectId = objectId == null ? null : objectId.trim();
    }

    /**
     * @return 承包商id
     */
    public Integer getBidderId() {
        return bidderId;
    }

    /**
     * @param bidderId 
	 *            承包商id
     */
    public void setBidderId(Integer bidderId) {
        this.bidderId = bidderId;
    }

    /**
     * @return 工程状态,OK# 施工中,END 完结,FLS 终止
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status 
	 *            工程状态,OK# 施工中,END 完结,FLS 终止
     */
    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    /**
     * @return 发包方id
     */
    public Integer getBiddeeId() {
        return biddeeId;
    }

    /**
     * @param biddeeId 
	 *            发包方id
     */
    public void setBiddeeId(Integer biddeeId) {
        this.biddeeId = biddeeId;
    }

    /**
     * @return 开工时间
     */
    public Date getStartTime() {
        return startTime;
    }

    /**
     * @param startTime 
	 *            开工时间
     */
    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    /**
     * @return 结束时间
     */
    public Date getEndTime() {
        return endTime;
    }

    /**
     * @param endTime 
	 *            结束时间
     */
    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }
}