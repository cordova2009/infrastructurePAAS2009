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
    private Integer project_payment_define_id;

    /**
     * 期数，从第1期开始
     */
    private Integer period;

    /**
     * 支付日期
     */
    private Date pay_time;

    /**
     * 支付金额，单位为分
     */
    private Integer pay_sum;

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
    public Integer getProject_payment_define_id() {
        return project_payment_define_id;
    }

    /**
     * @param projectPaymentDefineId 
	 *            付款定义id
     */
    public void setProject_payment_define_id(Integer project_payment_define_id) {
        this.project_payment_define_id = project_payment_define_id;
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
    public Date getPay_time() {
        return pay_time;
    }

    /**
     * @param payTime 
	 *            支付日期
     */
    public void setPay_time(Date pay_time) {
        this.pay_time = pay_time;
    }

    /**
     * @return 支付金额，单位为分
     */
    public Integer getPay_sum() {
        return pay_sum;
    }

    /**
     * @param paySum 
	 *            支付金额，单位为分
     */
    public void setPay_sum(Integer pay_sum) {
        this.pay_sum = pay_sum;
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
            && (this.getProject_payment_define_id() == null ? other.getProject_payment_define_id() == null : this.getProject_payment_define_id().equals(other.getProject_payment_define_id()))
            && (this.getPeriod() == null ? other.getPeriod() == null : this.getPeriod().equals(other.getPeriod()))
            && (this.getPay_time() == null ? other.getPay_time() == null : this.getPay_time().equals(other.getPay_time()))
            && (this.getPay_sum() == null ? other.getPay_sum() == null : this.getPay_sum().equals(other.getPay_sum()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getProject_payment_define_id() == null) ? 0 : getProject_payment_define_id().hashCode());
        result = prime * result + ((getPeriod() == null) ? 0 : getPeriod().hashCode());
        result = prime * result + ((getPay_time() == null) ? 0 : getPay_time().hashCode());
        result = prime * result + ((getPay_sum() == null) ? 0 : getPay_sum().hashCode());
        return result;
    }
}