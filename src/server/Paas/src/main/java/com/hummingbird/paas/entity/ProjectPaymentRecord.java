package com.hummingbird.paas.entity;

import java.util.Date;

/**
 * 工程收付款记录表
 */
public class ProjectPaymentRecord {
    /**
     * 主键
     */
    private Integer id;

    /**
     * 标的id
     */
    private String objectId;

    /**
     * 期数
     */
    private Integer currentPeriod;

    /**
     * 金额
     */
    private Integer amount;

    /**
     * 时间
     */
    private Date payTime;

    /**
     * 类型，PAY支付工程款，REV接收工程款
     */
    private String type;

    /**
     * 认证招投标类型，TER发包商，BIR承包商
     */
    private Integer companyType;

    /**
     * 认证提出方id
     */
    private Integer companyId;

    /**
     * @return 主键
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id 
	 *            主键
     */
    public void setId(Integer id) {
        this.id = id;
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
     * @return 期数
     */
    public Integer getCurrentPeriod() {
        return currentPeriod;
    }

    /**
     * @param currentPeriod 
	 *            期数
     */
    public void setCurrentPeriod(Integer currentPeriod) {
        this.currentPeriod = currentPeriod;
    }

    /**
     * @return 金额
     */
    public Integer getAmount() {
        return amount;
    }

    /**
     * @param amount 
	 *            金额
     */
    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    /**
     * @return 时间
     */
    public Date getPayTime() {
        return payTime;
    }

    /**
     * @param payTime 
	 *            时间
     */
    public void setPayTime(Date payTime) {
        this.payTime = payTime;
    }

    /**
     * @return 类型，PAY支付工程款，REV接收工程款
     */
    public String getType() {
        return type;
    }

    /**
     * @param type 
	 *            类型，PAY支付工程款，REV接收工程款
     */
    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    /**
     * @return 认证招投标类型，TER发包商，BIR承包商
     */
    public Integer getCompanyType() {
        return companyType;
    }

    /**
     * @param companyType 
	 *            认证招投标类型，TER发包商，BIR承包商
     */
    public void setCompanyType(Integer companyType) {
        this.companyType = companyType;
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
        ProjectPaymentRecord other = (ProjectPaymentRecord) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getObjectId() == null ? other.getObjectId() == null : this.getObjectId().equals(other.getObjectId()))
            && (this.getCurrentPeriod() == null ? other.getCurrentPeriod() == null : this.getCurrentPeriod().equals(other.getCurrentPeriod()))
            && (this.getAmount() == null ? other.getAmount() == null : this.getAmount().equals(other.getAmount()))
            && (this.getPayTime() == null ? other.getPayTime() == null : this.getPayTime().equals(other.getPayTime()))
            && (this.getType() == null ? other.getType() == null : this.getType().equals(other.getType()))
            && (this.getCompanyType() == null ? other.getCompanyType() == null : this.getCompanyType().equals(other.getCompanyType()))
            && (this.getCompanyId() == null ? other.getCompanyId() == null : this.getCompanyId().equals(other.getCompanyId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getObjectId() == null) ? 0 : getObjectId().hashCode());
        result = prime * result + ((getCurrentPeriod() == null) ? 0 : getCurrentPeriod().hashCode());
        result = prime * result + ((getAmount() == null) ? 0 : getAmount().hashCode());
        result = prime * result + ((getPayTime() == null) ? 0 : getPayTime().hashCode());
        result = prime * result + ((getType() == null) ? 0 : getType().hashCode());
        result = prime * result + ((getCompanyType() == null) ? 0 : getCompanyType().hashCode());
        result = prime * result + ((getCompanyId() == null) ? 0 : getCompanyId().hashCode());
        return result;
    }
}