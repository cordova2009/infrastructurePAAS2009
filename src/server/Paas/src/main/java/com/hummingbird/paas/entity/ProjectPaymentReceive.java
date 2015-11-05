package com.hummingbird.paas.entity;

import java.util.Date;

/**
 * 工程收款表
 */
public class ProjectPaymentReceive {
    /**
     * 主键
     */
    private Integer id;

    /**
     * 状态,CRT待收款,OK#已收款,FLS收款失败
     */
    private String status;

    /**
     * 标的id
     */
    private String object_id;

    /**
     * 期数
     */
    private Integer current_period;

    /**
     * 金额,单位分
     */
    private Integer amount;

    /**
     * 应支付时间
     */
    private Date should_receive_time;

    /**
     * 支付时间
     */
    private Date receive_time;

    /**
     * 总金额
     */
    private Integer total_amount;

    /**
     * 剩余期数
     */
    private Integer left_period;

    /**
     * 剩余金额,单位分
     */
    private Integer left_amount;

    /**
     * 总期数
     */
    private Integer total_period;

    /**
     * 订单号
     */
    private String order_id;

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
     * @return 状态,CRT待收款,OK#已收款,FLS收款失败
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status 
	 *            状态,CRT待收款,OK#已收款,FLS收款失败
     */
    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
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
     * @return 金额,单位分
     */
    public Integer getAmount() {
        return amount;
    }

    /**
     * @param amount 
	 *            金额,单位分
     */
    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    /**
     * @return 应支付时间
     */
    public Date getShould_receive_time() {
        return should_receive_time;
    }

    /**
     * @param shouldReceiveTime 
	 *            应支付时间
     */
    public void setShould_receive_time(Date should_receive_time) {
        this.should_receive_time = should_receive_time;
    }

    /**
     * @return 支付时间
     */
    public Date getReceive_time() {
        return receive_time;
    }

    /**
     * @param receiveTime 
	 *            支付时间
     */
    public void setReceive_time(Date receive_time) {
        this.receive_time = receive_time;
    }

    /**
     * @return 总金额
     */
    public Integer getTotal_amount() {
        return total_amount;
    }

    /**
     * @param totalAmount 
	 *            总金额
     */
    public void setTotal_amount(Integer total_amount) {
        this.total_amount = total_amount;
    }

    /**
     * @return 剩余期数
     */
    public Integer getLeft_period() {
        return left_period;
    }

    /**
     * @param leftPeriod 
	 *            剩余期数
     */
    public void setLeft_period(Integer left_period) {
        this.left_period = left_period;
    }

    /**
     * @return 剩余金额,单位分
     */
    public Integer getLeft_amount() {
        return left_amount;
    }

    /**
     * @param leftAmount 
	 *            剩余金额,单位分
     */
    public void setLeft_amount(Integer left_amount) {
        this.left_amount = left_amount;
    }

    /**
     * @return 总期数
     */
    public Integer getTotal_period() {
        return total_period;
    }

    /**
     * @param totalPeriod 
	 *            总期数
     */
    public void setTotal_period(Integer total_period) {
        this.total_period = total_period;
    }

    /**
     * @return 订单号
     */
    public String getOrder_id() {
        return order_id;
    }

    /**
     * @param orderId 
	 *            订单号
     */
    public void setOrder_id(String order_id) {
        this.order_id = order_id == null ? null : order_id.trim();
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
        ProjectPaymentReceive other = (ProjectPaymentReceive) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getObject_id() == null ? other.getObject_id() == null : this.getObject_id().equals(other.getObject_id()))
            && (this.getCurrent_period() == null ? other.getCurrent_period() == null : this.getCurrent_period().equals(other.getCurrent_period()))
            && (this.getAmount() == null ? other.getAmount() == null : this.getAmount().equals(other.getAmount()))
            && (this.getShould_receive_time() == null ? other.getShould_receive_time() == null : this.getShould_receive_time().equals(other.getShould_receive_time()))
            && (this.getReceive_time() == null ? other.getReceive_time() == null : this.getReceive_time().equals(other.getReceive_time()))
            && (this.getTotal_amount() == null ? other.getTotal_amount() == null : this.getTotal_amount().equals(other.getTotal_amount()))
            && (this.getLeft_period() == null ? other.getLeft_period() == null : this.getLeft_period().equals(other.getLeft_period()))
            && (this.getLeft_amount() == null ? other.getLeft_amount() == null : this.getLeft_amount().equals(other.getLeft_amount()))
            && (this.getTotal_period() == null ? other.getTotal_period() == null : this.getTotal_period().equals(other.getTotal_period()))
            && (this.getOrder_id() == null ? other.getOrder_id() == null : this.getOrder_id().equals(other.getOrder_id()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getObject_id() == null) ? 0 : getObject_id().hashCode());
        result = prime * result + ((getCurrent_period() == null) ? 0 : getCurrent_period().hashCode());
        result = prime * result + ((getAmount() == null) ? 0 : getAmount().hashCode());
        result = prime * result + ((getShould_receive_time() == null) ? 0 : getShould_receive_time().hashCode());
        result = prime * result + ((getReceive_time() == null) ? 0 : getReceive_time().hashCode());
        result = prime * result + ((getTotal_amount() == null) ? 0 : getTotal_amount().hashCode());
        result = prime * result + ((getLeft_period() == null) ? 0 : getLeft_period().hashCode());
        result = prime * result + ((getLeft_amount() == null) ? 0 : getLeft_amount().hashCode());
        result = prime * result + ((getTotal_period() == null) ? 0 : getTotal_period().hashCode());
        result = prime * result + ((getOrder_id() == null) ? 0 : getOrder_id().hashCode());
        return result;
    }
}