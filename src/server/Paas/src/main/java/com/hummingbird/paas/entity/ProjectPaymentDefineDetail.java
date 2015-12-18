package com.hummingbird.paas.entity;

import java.util.Date;

/**
 * 工程付款定义明细表
 */
public class ProjectPaymentDefineDetail {
    /**
     * id
     */
    protected Integer id;

    /**
     * 付款定义id
     */
    protected Integer projectPaymentDefineId;

    /**
     * 期数，从第1期开始
     */
    protected Integer period;

    /**
     * 支付结束日期
     */
    protected Date payEndTime;

    /**
     * 支付开始日期
     */
    protected Date payStartTime;

    /**
     * 支付金额，单位为分
     */
    protected Long paySum;

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
     * @return 付款定义id
     */
    public Integer getProjectPaymentDefineId() {
        return projectPaymentDefineId;
    }

    /**
     * @param projectPaymentDefineId 
	 *            付款定义id
     */
    public void setProjectPaymentDefineId(Integer projectPaymentDefineId) {
        this.projectPaymentDefineId = projectPaymentDefineId;
    }

    /**
     * @return 期数，从第1期开始
     */
    public Integer getPeriod() {
        return period;
    }

    /**
     * @param period 
	 *            期数，从第1期开始
     */
    public void setPeriod(Integer period) {
        this.period = period;
    }

    /**
     * @return 支付结束日期
     */
    public Date getPayEndTime() {
        return payEndTime;
    }

    /**
     * @param payEndTime 
	 *            支付结束日期
     */
    public void setPayEndTime(Date payEndTime) {
        this.payEndTime = payEndTime;
    }

    /**
     * @return 支付开始日期
     */
    public Date getPayStartTime() {
        return payStartTime;
    }

    /**
     * @param payStartTime 
	 *            支付开始日期
     */
    public void setPayStartTime(Date payStartTime) {
        this.payStartTime = payStartTime;
    }

    /**
     * @return 支付金额，单位为分
     */
    public Long getPaySum() {
        return paySum;
    }

    /**
     * @param paySum 
	 *            支付金额，单位为分
     */
    public void setPaySum(Long paySum) {
        this.paySum = paySum;
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
        ProjectPaymentDefineDetail other = (ProjectPaymentDefineDetail) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getProjectPaymentDefineId() == null ? other.getProjectPaymentDefineId() == null : this.getProjectPaymentDefineId().equals(other.getProjectPaymentDefineId()))
            && (this.getPeriod() == null ? other.getPeriod() == null : this.getPeriod().equals(other.getPeriod()))
            && (this.getPayEndTime() == null ? other.getPayEndTime() == null : this.getPayEndTime().equals(other.getPayEndTime()))
            && (this.getPayStartTime() == null ? other.getPayStartTime() == null : this.getPayStartTime().equals(other.getPayStartTime()))
            && (this.getPaySum() == null ? other.getPaySum() == null : this.getPaySum().equals(other.getPaySum()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getProjectPaymentDefineId() == null) ? 0 : getProjectPaymentDefineId().hashCode());
        result = prime * result + ((getPeriod() == null) ? 0 : getPeriod().hashCode());
        result = prime * result + ((getPayEndTime() == null) ? 0 : getPayEndTime().hashCode());
        result = prime * result + ((getPayStartTime() == null) ? 0 : getPayStartTime().hashCode());
        result = prime * result + ((getPaySum() == null) ? 0 : getPaySum().hashCode());
        return result;
    }
}