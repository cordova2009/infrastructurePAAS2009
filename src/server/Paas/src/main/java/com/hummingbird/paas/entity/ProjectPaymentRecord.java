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
    private String object_id;

    /**
     * 期数
     */
    private Integer current_period;

    /**
     * 金额
     */
    private Integer amount;

    /**
     * 时间
     */
    private Date pay_time;

    /**
     * 类型，PAY支付工程款，REV接收工程款
     */
    private String type;

    /**
     * 认证招投标类型，TER发包商，BIR承包商
     */
    private Integer company_type;

    /**
     * 认证提出方id
     */
    private Integer company_id;

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
    public String getObject_id() {
        return object_id;
    }

    /**
     * @param objectId 
	 *            标的id
     */
    public void setObject_id(String object_id) {
        this.object_id = object_id == null ? null : object_id.trim();
    }

    /**
     * @return 期数
     */
    public Integer getCurrent_period() {
        return current_period;
    }

    /**
     * @param currentPeriod 
	 *            期数
     */
    public void setCurrent_period(Integer current_period) {
        this.current_period = current_period;
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
    public Date getPay_time() {
        return pay_time;
    }

    /**
     * @param payTime 
	 *            时间
     */
    public void setPay_time(Date pay_time) {
        this.pay_time = pay_time;
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
    public Integer getCompany_type() {
        return company_type;
    }

    /**
     * @param companyType 
	 *            认证招投标类型，TER发包商，BIR承包商
     */
    public void setCompany_type(Integer company_type) {
        this.company_type = company_type;
    }

    /**
     * @return 认证提出方id
     */
    public Integer getCompany_id() {
        return company_id;
    }

    /**
     * @param companyId 
	 *            认证提出方id
     */
    public void setCompany_id(Integer company_id) {
        this.company_id = company_id;
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
            && (this.getObject_id() == null ? other.getObject_id() == null : this.getObject_id().equals(other.getObject_id()))
            && (this.getCurrent_period() == null ? other.getCurrent_period() == null : this.getCurrent_period().equals(other.getCurrent_period()))
            && (this.getAmount() == null ? other.getAmount() == null : this.getAmount().equals(other.getAmount()))
            && (this.getPay_time() == null ? other.getPay_time() == null : this.getPay_time().equals(other.getPay_time()))
            && (this.getType() == null ? other.getType() == null : this.getType().equals(other.getType()))
            && (this.getCompany_type() == null ? other.getCompany_type() == null : this.getCompany_type().equals(other.getCompany_type()))
            && (this.getCompany_id() == null ? other.getCompany_id() == null : this.getCompany_id().equals(other.getCompany_id()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getObject_id() == null) ? 0 : getObject_id().hashCode());
        result = prime * result + ((getCurrent_period() == null) ? 0 : getCurrent_period().hashCode());
        result = prime * result + ((getAmount() == null) ? 0 : getAmount().hashCode());
        result = prime * result + ((getPay_time() == null) ? 0 : getPay_time().hashCode());
        result = prime * result + ((getType() == null) ? 0 : getType().hashCode());
        result = prime * result + ((getCompany_type() == null) ? 0 : getCompany_type().hashCode());
        result = prime * result + ((getCompany_id() == null) ? 0 : getCompany_id().hashCode());
        return result;
    }
}