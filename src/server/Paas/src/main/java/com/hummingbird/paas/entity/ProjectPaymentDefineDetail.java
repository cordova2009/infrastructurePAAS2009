package com.hummingbird.paas.entity;

import java.util.Date;

/**
 * 工程付款定义明细表
 */
public class ProjectPaymentDefineDetail {
    /**
     * id
     */
    private Integer id;

    /**
     * 付款定义id
     */
    private Integer projectPaymentDefineId;

    /**
     * 期数，从第1期开始
     */
    private Integer period;

    /**
     * 支付日期
     */
    private Date payTime;

    /**
     * 支付金额，单位为分
     */
    private Integer paySum;

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
     * @return 支付日期
     */
    public Date getPayTime() {
        return payTime;
    }

    /**
     * @param payTime 
	 *            支付日期
     */
    public void setPayTime(Date payTime) {
        this.payTime = payTime;
    }

    /**
     * @return 支付金额，单位为分
     */
    public Integer getPaySum() {
        return paySum;
    }

    /**
     * @param paySum 
	 *            支付金额，单位为分
     */
    public void setPaySum(Integer paySum) {
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
            && (this.getPayTime() == null ? other.getPayTime() == null : this.getPayTime().equals(other.getPayTime()))
            && (this.getPaySum() == null ? other.getPaySum() == null : this.getPaySum().equals(other.getPaySum()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getProjectPaymentDefineId() == null) ? 0 : getProjectPaymentDefineId().hashCode());
        result = prime * result + ((getPeriod() == null) ? 0 : getPeriod().hashCode());
        result = prime * result + ((getPayTime() == null) ? 0 : getPayTime().hashCode());
        result = prime * result + ((getPaySum() == null) ? 0 : getPaySum().hashCode());
        return result;
    }
}