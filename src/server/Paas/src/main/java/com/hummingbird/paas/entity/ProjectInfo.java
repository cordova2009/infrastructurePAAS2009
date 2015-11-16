package com.hummingbird.paas.entity;

import java.util.Date;

/**
 * 工程信息表,工程由标的中标后转化而来
 */
public class ProjectInfo {
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
    private String staus;

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
    public String getStaus() {
        return staus;
    }

    /**
     * @param staus 
	 *            工程状态,OK# 施工中,END 完结,FLS 终止
     */
    public void setStaus(String staus) {
        this.staus = staus == null ? null : staus.trim();
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
        ProjectInfo other = (ProjectInfo) that;
        return (this.getProjectId() == null ? other.getProjectId() == null : this.getProjectId().equals(other.getProjectId()))
            && (this.getObjectId() == null ? other.getObjectId() == null : this.getObjectId().equals(other.getObjectId()))
            && (this.getBidderId() == null ? other.getBidderId() == null : this.getBidderId().equals(other.getBidderId()))
            && (this.getStaus() == null ? other.getStaus() == null : this.getStaus().equals(other.getStaus()))
            && (this.getBiddeeId() == null ? other.getBiddeeId() == null : this.getBiddeeId().equals(other.getBiddeeId()))
            && (this.getStartTime() == null ? other.getStartTime() == null : this.getStartTime().equals(other.getStartTime()))
            && (this.getEndTime() == null ? other.getEndTime() == null : this.getEndTime().equals(other.getEndTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getProjectId() == null) ? 0 : getProjectId().hashCode());
        result = prime * result + ((getObjectId() == null) ? 0 : getObjectId().hashCode());
        result = prime * result + ((getBidderId() == null) ? 0 : getBidderId().hashCode());
        result = prime * result + ((getStaus() == null) ? 0 : getStaus().hashCode());
        result = prime * result + ((getBiddeeId() == null) ? 0 : getBiddeeId().hashCode());
        result = prime * result + ((getStartTime() == null) ? 0 : getStartTime().hashCode());
        result = prime * result + ((getEndTime() == null) ? 0 : getEndTime().hashCode());
        return result;
    }
}