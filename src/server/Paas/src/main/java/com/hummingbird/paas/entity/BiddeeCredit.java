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
     * 法人信用积分
     */
    private Integer legalPersonInfo;

    /**
     * 公司注册信息信用积分
     */
    private Integer companyRegisteredInfo;

    /**
     * 银行信息信用积分
     */
    private Integer bankInfo;

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

    /**
     * @return 法人信用积分
     */
    public Integer getLegalPersonInfo() {
        return legalPersonInfo;
    }

    /**
     * @param legalPersonInfo 
	 *            法人信用积分
     */
    public void setLegalPersonInfo(Integer legalPersonInfo) {
        this.legalPersonInfo = legalPersonInfo;
    }

    /**
     * @return 公司注册信息信用积分
     */
    public Integer getCompanyRegisteredInfo() {
        return companyRegisteredInfo;
    }

    /**
     * @param companyRegisteredInfo 
	 *            公司注册信息信用积分
     */
    public void setCompanyRegisteredInfo(Integer companyRegisteredInfo) {
        this.companyRegisteredInfo = companyRegisteredInfo;
    }

    /**
     * @return 银行信息信用积分
     */
    public Integer getBankInfo() {
        return bankInfo;
    }

    /**
     * @param bankInfo 
	 *            银行信息信用积分
     */
    public void setBankInfo(Integer bankInfo) {
        this.bankInfo = bankInfo;
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
            && (this.getBaseinfoCreditScore() == null ? other.getBaseinfoCreditScore() == null : this.getBaseinfoCreditScore().equals(other.getBaseinfoCreditScore()))
            && (this.getLegalPersonInfo() == null ? other.getLegalPersonInfo() == null : this.getLegalPersonInfo().equals(other.getLegalPersonInfo()))
            && (this.getCompanyRegisteredInfo() == null ? other.getCompanyRegisteredInfo() == null : this.getCompanyRegisteredInfo().equals(other.getCompanyRegisteredInfo()))
            && (this.getBankInfo() == null ? other.getBankInfo() == null : this.getBankInfo().equals(other.getBankInfo()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getTendererId() == null) ? 0 : getTendererId().hashCode());
        result = prime * result + ((getCreditScore() == null) ? 0 : getCreditScore().hashCode());
        result = prime * result + ((getBaseinfoCreditScore() == null) ? 0 : getBaseinfoCreditScore().hashCode());
        result = prime * result + ((getLegalPersonInfo() == null) ? 0 : getLegalPersonInfo().hashCode());
        result = prime * result + ((getCompanyRegisteredInfo() == null) ? 0 : getCompanyRegisteredInfo().hashCode());
        result = prime * result + ((getBankInfo() == null) ? 0 : getBankInfo().hashCode());
        return result;
    }
}