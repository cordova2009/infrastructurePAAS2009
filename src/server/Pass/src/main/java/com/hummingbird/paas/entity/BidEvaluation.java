package com.hummingbird.paas.entity;

import java.util.Date;

/**
 * 投标评标表
 */
public class BidEvaluation {
    /**
     * id
     */
    private Integer id;

    /**
     * 标的id
     */
    private String object_id;

    /**
     * 投标id
     */
    private Integer bid_id;

    /**
     * 评标状态,WIN中标，LOS不中标
     */
    private String bid_status;

    /**
     * 插入时间
     */
    private Date insert_time;

    /**
     * 备注
     */
    private String remark;

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
     * @return 投标id
     */
    public Integer getBid_id() {
        return bid_id;
    }

    /**
     * @param bidId 
	 *            投标id
     */
    public void setBid_id(Integer bid_id) {
        this.bid_id = bid_id;
    }

    /**
     * @return 评标状态,WIN中标，LOS不中标
     */
    public String getBid_status() {
        return bid_status;
    }

    /**
     * @param bidStatus 
	 *            评标状态,WIN中标，LOS不中标
     */
    public void setBid_status(String bid_status) {
        this.bid_status = bid_status == null ? null : bid_status.trim();
    }

    /**
     * @return 插入时间
     */
    public Date getInsert_time() {
        return insert_time;
    }

    /**
     * @param insertTime 
	 *            插入时间
     */
    public void setInsert_time(Date insert_time) {
        this.insert_time = insert_time;
    }

    /**
     * @return 备注
     */
    public String getRemark() {
        return remark;
    }

    /**
     * @param remark 
	 *            备注
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
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
        BidEvaluation other = (BidEvaluation) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getObject_id() == null ? other.getObject_id() == null : this.getObject_id().equals(other.getObject_id()))
            && (this.getBid_id() == null ? other.getBid_id() == null : this.getBid_id().equals(other.getBid_id()))
            && (this.getBid_status() == null ? other.getBid_status() == null : this.getBid_status().equals(other.getBid_status()))
            && (this.getInsert_time() == null ? other.getInsert_time() == null : this.getInsert_time().equals(other.getInsert_time()))
            && (this.getRemark() == null ? other.getRemark() == null : this.getRemark().equals(other.getRemark()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getObject_id() == null) ? 0 : getObject_id().hashCode());
        result = prime * result + ((getBid_id() == null) ? 0 : getBid_id().hashCode());
        result = prime * result + ((getBid_status() == null) ? 0 : getBid_status().hashCode());
        result = prime * result + ((getInsert_time() == null) ? 0 : getInsert_time().hashCode());
        result = prime * result + ((getRemark() == null) ? 0 : getRemark().hashCode());
        return result;
    }
}