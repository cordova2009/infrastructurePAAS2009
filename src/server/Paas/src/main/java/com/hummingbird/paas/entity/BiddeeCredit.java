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
}