package com.hummingbird.paas.entity;

/**
 * 记录发包方的信用积分情况
 */
public class BiddeeCredit {
    /**
     * 发包方id
     */
    private Integer tendererId;

    /**
     * 信用积分,它=个人信息信用积分+资质信用积分+招标信用积分
     */
    private Integer creditScore;

    /**
     * 个人信息信用积分
     */
    private Integer baseinfoCreditScore;

    /**
     * @return 发包方id
     */
    public Integer getTendererId() {
        return tendererId;
    }

    /**
     * @param tendererId 
	 *            发包方id
     */
    public void setTendererId(Integer tendererId) {
        this.tendererId = tendererId;
    }

    /**
     * @return 信用积分,它=个人信息信用积分+资质信用积分+招标信用积分
     */
    public Integer getCreditScore() {
        return creditScore;
    }

    /**
     * @param creditScore 
	 *            信用积分,它=个人信息信用积分+资质信用积分+招标信用积分
     */
    public void setCreditScore(Integer creditScore) {
        this.creditScore = creditScore;
    }

    /**
     * @return 个人信息信用积分
     */
    public Integer getBaseinfoCreditScore() {
        return baseinfoCreditScore;
    }

    /**
     * @param baseinfoCreditScore 
	 *            个人信息信用积分
     */
    public void setBaseinfoCreditScore(Integer baseinfoCreditScore) {
        this.baseinfoCreditScore = baseinfoCreditScore;
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
        BiddeeCredit other = (BiddeeCredit) that;
        return (this.getTendererId() == null ? other.getTendererId() == null : this.getTendererId().equals(other.getTendererId()))
            && (this.getCreditScore() == null ? other.getCreditScore() == null : this.getCreditScore().equals(other.getCreditScore()))
            && (this.getBaseinfoCreditScore() == null ? other.getBaseinfoCreditScore() == null : this.getBaseinfoCreditScore().equals(other.getBaseinfoCreditScore()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getTendererId() == null) ? 0 : getTendererId().hashCode());
        result = prime * result + ((getCreditScore() == null) ? 0 : getCreditScore().hashCode());
        result = prime * result + ((getBaseinfoCreditScore() == null) ? 0 : getBaseinfoCreditScore().hashCode());
        return result;
    }
}