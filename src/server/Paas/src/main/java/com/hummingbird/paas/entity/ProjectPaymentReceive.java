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
     * 工程信息id
     */
    private String projectId;

    /**
     * 期数
     */
    private Integer currentPeriod;

    /**
     * 金额,单位分
     */
    private Long amount;

    /**
     * 应支付时间
     */
    private Date shouldReceiveTime;

    /**
     * 支付时间
     */
    private Date receiveTime;

    /**
     * 总金额
     */
    private Long totalAmount;

    /**
     * 剩余期数
     */
    private Integer leftPeriod;

    /**
     * 剩余金额,单位分
     */
    private Long leftAmount;

    /**
     * 总期数
     */
    private Integer totalPeriod;

    /**
     * 订单号
     */
    private String orderId;

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
     * @return 工程信息id
     */
    public String getProjectId() {
        return projectId;
    }

    /**
     * @param projectId 
	 *            工程信息id
     */
    public void setProjectId(String projectId) {
        this.projectId = projectId == null ? null : projectId.trim();
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
     * @return 金额,单位分
     */
    public Long getAmount() {
        return amount;
    }

    /**
     * @param amount 
	 *            金额,单位分
     */
    public void setAmount(Long amount) {
        this.amount = amount;
    }

    /**
     * @return 应支付时间
     */
    public Date getShouldReceiveTime() {
        return shouldReceiveTime;
    }

    /**
     * @param shouldReceiveTime 
	 *            应支付时间
     */
    public void setShouldReceiveTime(Date shouldReceiveTime) {
        this.shouldReceiveTime = shouldReceiveTime;
    }

    /**
     * @return 支付时间
     */
    public Date getReceiveTime() {
        return receiveTime;
    }

    /**
     * @param receiveTime 
	 *            支付时间
     */
    public void setReceiveTime(Date receiveTime) {
        this.receiveTime = receiveTime;
    }

    /**
     * @return 总金额
     */
    public Long getTotalAmount() {
        return totalAmount;
    }

    /**
     * @param totalAmount 
	 *            总金额
     */
    public void setTotalAmount(Long totalAmount) {
        this.totalAmount = totalAmount;
    }

    /**
     * @return 剩余期数
     */
    public Integer getLeftPeriod() {
        return leftPeriod;
    }

    /**
     * @param leftPeriod 
	 *            剩余期数
     */
    public void setLeftPeriod(Integer leftPeriod) {
        this.leftPeriod = leftPeriod;
    }

    /**
     * @return 剩余金额,单位分
     */
    public Long getLeftAmount() {
        return leftAmount;
    }

    /**
     * @param leftAmount 
	 *            剩余金额,单位分
     */
    public void setLeftAmount(Long leftAmount) {
        this.leftAmount = leftAmount;
    }

    /**
     * @return 总期数
     */
    public Integer getTotalPeriod() {
        return totalPeriod;
    }

    /**
     * @param totalPeriod 
	 *            总期数
     */
    public void setTotalPeriod(Integer totalPeriod) {
        this.totalPeriod = totalPeriod;
    }

    /**
     * @return 订单号
     */
    public String getOrderId() {
        return orderId;
    }

    /**
     * @param orderId 
	 *            订单号
     */
    public void setOrderId(String orderId) {
        this.orderId = orderId == null ? null : orderId.trim();
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
            && (this.getProjectId() == null ? other.getProjectId() == null : this.getProjectId().equals(other.getProjectId()))
            && (this.getCurrentPeriod() == null ? other.getCurrentPeriod() == null : this.getCurrentPeriod().equals(other.getCurrentPeriod()))
            && (this.getAmount() == null ? other.getAmount() == null : this.getAmount().equals(other.getAmount()))
            && (this.getShouldReceiveTime() == null ? other.getShouldReceiveTime() == null : this.getShouldReceiveTime().equals(other.getShouldReceiveTime()))
            && (this.getReceiveTime() == null ? other.getReceiveTime() == null : this.getReceiveTime().equals(other.getReceiveTime()))
            && (this.getTotalAmount() == null ? other.getTotalAmount() == null : this.getTotalAmount().equals(other.getTotalAmount()))
            && (this.getLeftPeriod() == null ? other.getLeftPeriod() == null : this.getLeftPeriod().equals(other.getLeftPeriod()))
            && (this.getLeftAmount() == null ? other.getLeftAmount() == null : this.getLeftAmount().equals(other.getLeftAmount()))
            && (this.getTotalPeriod() == null ? other.getTotalPeriod() == null : this.getTotalPeriod().equals(other.getTotalPeriod()))
            && (this.getOrderId() == null ? other.getOrderId() == null : this.getOrderId().equals(other.getOrderId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getProjectId() == null) ? 0 : getProjectId().hashCode());
        result = prime * result + ((getCurrentPeriod() == null) ? 0 : getCurrentPeriod().hashCode());
        result = prime * result + ((getAmount() == null) ? 0 : getAmount().hashCode());
        result = prime * result + ((getShouldReceiveTime() == null) ? 0 : getShouldReceiveTime().hashCode());
        result = prime * result + ((getReceiveTime() == null) ? 0 : getReceiveTime().hashCode());
        result = prime * result + ((getTotalAmount() == null) ? 0 : getTotalAmount().hashCode());
        result = prime * result + ((getLeftPeriod() == null) ? 0 : getLeftPeriod().hashCode());
        result = prime * result + ((getLeftAmount() == null) ? 0 : getLeftAmount().hashCode());
        result = prime * result + ((getTotalPeriod() == null) ? 0 : getTotalPeriod().hashCode());
        result = prime * result + ((getOrderId() == null) ? 0 : getOrderId().hashCode());
        return result;
    }
}