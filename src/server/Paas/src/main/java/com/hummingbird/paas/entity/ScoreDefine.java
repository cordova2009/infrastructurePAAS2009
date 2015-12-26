package com.hummingbird.paas.entity;

import java.util.Date;

/**
 * 信用积分配置表,记录信用积分的相关配置,注意此表只有一条记录,请保持id=1
 */
public class ScoreDefine {
    /**
     * id
     */
    private Integer id;

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
     * 招标次数基础积分
     */
    private Integer tenderInfo;

    /**
     * 投标次数基础积分
     */
    private Integer bidInfo;

    /**
     * 中标次数基础积分
     */
    private Integer winInfo;

    /**
     * 新增时间
     */
    private Date insertTime;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 创建人
     */
    private String creator;

    /**
     * 更新人
     */
    private String updator;

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

    /**
     * @return 招标次数基础积分
     */
    public Integer getTenderInfo() {
        return tenderInfo;
    }

    /**
     * @param tenderInfo 
	 *            招标次数基础积分
     */
    public void setTenderInfo(Integer tenderInfo) {
        this.tenderInfo = tenderInfo;
    }

    /**
     * @return 投标次数基础积分
     */
    public Integer getBidInfo() {
        return bidInfo;
    }

    /**
     * @param bidInfo 
	 *            投标次数基础积分
     */
    public void setBidInfo(Integer bidInfo) {
        this.bidInfo = bidInfo;
    }

    /**
     * @return 中标次数基础积分
     */
    public Integer getWinInfo() {
        return winInfo;
    }

    /**
     * @param winInfo 
	 *            中标次数基础积分
     */
    public void setWinInfo(Integer winInfo) {
        this.winInfo = winInfo;
    }

    /**
     * @return 新增时间
     */
    public Date getInsertTime() {
        return insertTime;
    }

    /**
     * @param insertTime 
	 *            新增时间
     */
    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }

    /**
     * @return 更新时间
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * @param updateTime 
	 *            更新时间
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * @return 创建人
     */
    public String getCreator() {
        return creator;
    }

    /**
     * @param creator 
	 *            创建人
     */
    public void setCreator(String creator) {
        this.creator = creator == null ? null : creator.trim();
    }

    /**
     * @return 更新人
     */
    public String getUpdator() {
        return updator;
    }

    /**
     * @param updator 
	 *            更新人
     */
    public void setUpdator(String updator) {
        this.updator = updator == null ? null : updator.trim();
    }
}