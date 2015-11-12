package com.hummingbird.paas.entity;

import java.util.Date;

/**
 * 信用评分记录历史表
 */
public class CreditScoreHistory {
    private Integer id;

    /**
     * 认证招投标类型，TER发包商，BIR承包商
     */
    private String companyType;

    /**
     * 认证提出方id
     */
    private Integer companyId;

    /**
     * 积分类型,BIS 基本信息，LPS 法人信息，CRS 公司注册信息，BKS 银行信息， CS# 资质信息积分，BID 招标信息积分
     */
    private String scoreType;

    /**
     * 分数
     */
    private Integer score;

    /**
     * 新增时间
     */
    private Date insertTime;

    /**
     * 新增人
     */
    private String creator;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return 认证招投标类型，TER发包商，BIR承包商
     */
    public String getCompanyType() {
        return companyType;
    }

    /**
     * @param companyType 
	 *            认证招投标类型，TER发包商，BIR承包商
     */
    public void setCompanyType(String companyType) {
        this.companyType = companyType == null ? null : companyType.trim();
    }

    /**
     * @return 认证提出方id
     */
    public Integer getCompanyId() {
        return companyId;
    }

    /**
     * @param companyId 
	 *            认证提出方id
     */
    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    /**
     * @return 积分类型,BIS 基本信息，LPS 法人信息，CRS 公司注册信息，BKS 银行信息， CS# 资质信息积分，BID 招标信息积分
     */
    public String getScoreType() {
        return scoreType;
    }

    /**
     * @param scoreType 
	 *            积分类型,BIS 基本信息，LPS 法人信息，CRS 公司注册信息，BKS 银行信息， CS# 资质信息积分，BID 招标信息积分
     */
    public void setScoreType(String scoreType) {
        this.scoreType = scoreType == null ? null : scoreType.trim();
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
     * @return 新增人
     */
    public String getCreator() {
        return creator;
    }

    /**
     * @param creator 
	 *            新增人
     */
    public void setCreator(String creator) {
        this.creator = creator == null ? null : creator.trim();
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
        CreditScoreHistory other = (CreditScoreHistory) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getCompanyType() == null ? other.getCompanyType() == null : this.getCompanyType().equals(other.getCompanyType()))
            && (this.getCompanyId() == null ? other.getCompanyId() == null : this.getCompanyId().equals(other.getCompanyId()))
            && (this.getScoreType() == null ? other.getScoreType() == null : this.getScoreType().equals(other.getScoreType()))
            && (this.getScore() == null ? other.getScore() == null : this.getScore().equals(other.getScore()))
            && (this.getInsertTime() == null ? other.getInsertTime() == null : this.getInsertTime().equals(other.getInsertTime()))
            && (this.getCreator() == null ? other.getCreator() == null : this.getCreator().equals(other.getCreator()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getCompanyType() == null) ? 0 : getCompanyType().hashCode());
        result = prime * result + ((getCompanyId() == null) ? 0 : getCompanyId().hashCode());
        result = prime * result + ((getScoreType() == null) ? 0 : getScoreType().hashCode());
        result = prime * result + ((getScore() == null) ? 0 : getScore().hashCode());
        result = prime * result + ((getInsertTime() == null) ? 0 : getInsertTime().hashCode());
        result = prime * result + ((getCreator() == null) ? 0 : getCreator().hashCode());
        return result;
    }
}