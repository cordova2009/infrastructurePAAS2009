package com.hummingbird.paas.entity;

/**
 * 承包商信用积分表
 */
public class BidderCredit {
    /**
     * 承包商id
     */
    private Integer bidder_id;

    /**
     * 信用积分，它=个人信息信用积分+资质信用积分+招标信用积分
     */
    private Integer credit_score;

    /**
     * 个人信息信用积分
     */
    private Integer baseinfo_credit_score;

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
     * @return 信用积分，它=个人信息信用积分+资质信用积分+招标信用积分
     */
    public Integer getCredit_score() {
        return credit_score;
    }

    /**
     * @param creditScore 
	 *            信用积分，它=个人信息信用积分+资质信用积分+招标信用积分
     */
    public void setCredit_score(Integer credit_score) {
        this.credit_score = credit_score;
    }

    /**
     * @return 个人信息信用积分
     */
    public Integer getBaseinfo_credit_score() {
        return baseinfo_credit_score;
    }

    /**
     * @param baseinfoCreditScore 
	 *            个人信息信用积分
     */
    public void setBaseinfo_credit_score(Integer baseinfo_credit_score) {
        this.baseinfo_credit_score = baseinfo_credit_score;
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
        BidderCredit other = (BidderCredit) that;
        return (this.getBidder_id() == null ? other.getBidder_id() == null : this.getBidder_id().equals(other.getBidder_id()))
            && (this.getCredit_score() == null ? other.getCredit_score() == null : this.getCredit_score().equals(other.getCredit_score()))
            && (this.getBaseinfo_credit_score() == null ? other.getBaseinfo_credit_score() == null : this.getBaseinfo_credit_score().equals(other.getBaseinfo_credit_score()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getBidder_id() == null) ? 0 : getBidder_id().hashCode());
        result = prime * result + ((getCredit_score() == null) ? 0 : getCredit_score().hashCode());
        result = prime * result + ((getBaseinfo_credit_score() == null) ? 0 : getBaseinfo_credit_score().hashCode());
        return result;
    }
}