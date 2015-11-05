package com.hummingbird.paas.entity;

/**
 * 工程信息表,工程由标的中标后转化而来
 */
public class ProjectStatus {
    /**
     * 工程编号,使用 GC00日期时间随机数
     */
    private String project_id;

    /**
     * 标的id
     */
    private String object_id;

    /**
     * 承包商id
     */
    private Integer bidder_id;

    /**
     * 工程状态,OK# 施工中,END 完结,FLS 终止
     */
    private String staus;

    /**
     * 发包方id
     */
    private Integer biddee_id;

    /**
     * @return 工程编号,使用 GC00日期时间随机数
     */
    public String getProject_id() {
        return project_id;
    }

    /**
     * @param projectId 
	 *            工程编号,使用 GC00日期时间随机数
     */
    public void setProject_id(String project_id) {
        this.project_id = project_id == null ? null : project_id.trim();
    }

    /**
     * @return 标的id
     */
    public String getObject_id() {
        return object_id;
    }

    /**
     * @param objectId 
	 *            标的id
     */
    public void setObject_id(String object_id) {
        this.object_id = object_id == null ? null : object_id.trim();
    }

    /**
     * @return 承包商id
     */
    public Integer getBidder_id() {
        return bidder_id;
    }

    /**
     * @param bidderId 
	 *            承包商id
     */
    public void setBidder_id(Integer bidder_id) {
        this.bidder_id = bidder_id;
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
    public Integer getBiddee_id() {
        return biddee_id;
    }

    /**
     * @param biddeeId 
	 *            发包方id
     */
    public void setBiddee_id(Integer biddee_id) {
        this.biddee_id = biddee_id;
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
        ProjectStatus other = (ProjectStatus) that;
        return (this.getProject_id() == null ? other.getProject_id() == null : this.getProject_id().equals(other.getProject_id()))
            && (this.getObject_id() == null ? other.getObject_id() == null : this.getObject_id().equals(other.getObject_id()))
            && (this.getBidder_id() == null ? other.getBidder_id() == null : this.getBidder_id().equals(other.getBidder_id()))
            && (this.getStaus() == null ? other.getStaus() == null : this.getStaus().equals(other.getStaus()))
            && (this.getBiddee_id() == null ? other.getBiddee_id() == null : this.getBiddee_id().equals(other.getBiddee_id()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getProject_id() == null) ? 0 : getProject_id().hashCode());
        result = prime * result + ((getObject_id() == null) ? 0 : getObject_id().hashCode());
        result = prime * result + ((getBidder_id() == null) ? 0 : getBidder_id().hashCode());
        result = prime * result + ((getStaus() == null) ? 0 : getStaus().hashCode());
        result = prime * result + ((getBiddee_id() == null) ? 0 : getBiddee_id().hashCode());
        return result;
    }
}