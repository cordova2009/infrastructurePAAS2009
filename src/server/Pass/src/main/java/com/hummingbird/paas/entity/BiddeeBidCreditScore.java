package com.hummingbird.paas.entity;

import java.util.Date;

/**
 * 发包方招标信用积分明细
 */
public class BiddeeBidCreditScore {
    /**
     * id
     */
    private Integer id;

    /**
     * 发包方id
     */
    private Integer tenderer_id;

    /**
     * 记录时间
     */
    private Date insert_time;

    /**
     * 标的id
     */
    private Integer object_id;

    /**
     * 分数
     */
    private Integer score;

    /**
     * 承包商id,哪个承包商评价的
     */
    private Integer bidder_id;

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
     * @return 发包方id
     */
    public Integer getTenderer_id() {
        return tenderer_id;
    }

    /**
     * @param tendererId 
	 *            发包方id
     */
    public void setTenderer_id(Integer tenderer_id) {
        this.tenderer_id = tenderer_id;
    }

    /**
     * @return 记录时间
     */
    public Date getInsert_time() {
        return insert_time;
    }

    /**
     * @param insertTime 
	 *            记录时间
     */
    public void setInsert_time(Date insert_time) {
        this.insert_time = insert_time;
    }

    /**
     * @return 标的id
     */
    public Integer getObject_id() {
        return object_id;
    }

    /**
     * @param objectId 
	 *            标的id
     */
    public void setObject_id(Integer object_id) {
        this.object_id = object_id;
    }

    /**
     * @return 分数
     */
    public Integer getScore() {
        return score;
    }

    /**
     * @param score 
	 *            分数
     */
    public void setScore(Integer score) {
        this.score = score;
    }

    /**
     * @return 承包商id,哪个承包商评价的
     */
    public Integer getBidder_id() {
        return bidder_id;
    }

    /**
     * @param bidderId 
	 *            承包商id,哪个承包商评价的
     */
    public void setBidder_id(Integer bidder_id) {
        this.bidder_id = bidder_id;
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
        BiddeeBidCreditScore other = (BiddeeBidCreditScore) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getTenderer_id() == null ? other.getTenderer_id() == null : this.getTenderer_id().equals(other.getTenderer_id()))
            && (this.getInsert_time() == null ? other.getInsert_time() == null : this.getInsert_time().equals(other.getInsert_time()))
            && (this.getObject_id() == null ? other.getObject_id() == null : this.getObject_id().equals(other.getObject_id()))
            && (this.getScore() == null ? other.getScore() == null : this.getScore().equals(other.getScore()))
            && (this.getBidder_id() == null ? other.getBidder_id() == null : this.getBidder_id().equals(other.getBidder_id()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getTenderer_id() == null) ? 0 : getTenderer_id().hashCode());
        result = prime * result + ((getInsert_time() == null) ? 0 : getInsert_time().hashCode());
        result = prime * result + ((getObject_id() == null) ? 0 : getObject_id().hashCode());
        result = prime * result + ((getScore() == null) ? 0 : getScore().hashCode());
        result = prime * result + ((getBidder_id() == null) ? 0 : getBidder_id().hashCode());
        return result;
    }
}