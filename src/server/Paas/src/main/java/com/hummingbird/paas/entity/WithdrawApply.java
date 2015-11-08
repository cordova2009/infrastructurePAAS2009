package com.hummingbird.paas.entity;

import java.util.Date;

/**
 * 提现申请表
 */
public class WithdrawApply {
    /**
     * 订单id
     */
    private String orderId;

    /**
     * 提现金额
     */
    private Integer withdrawAmount;

    /**
     * 手续费
     */
    private Integer commissionFees;

    /**
     * 提出时间
     */
    private Date insertTime;

    /**
     * 银行卡
     */
    private Integer userBankcardId;

    /**
     * 用户id
     */
    private Integer userId;

    /**
     * 状态,CRT 申请，OK# 提现成功，FLS提现失败
     */
    private String status;

    /**
     * @return 订单id
     */
    public String getOrderId() {
        return orderId;
    }

    /**
     * @param orderId 
	 *            订单id
     */
    public void setOrderId(String orderId) {
        this.orderId = orderId == null ? null : orderId.trim();
    }

    /**
     * @return 提现金额
     */
    public Integer getWithdrawAmount() {
        return withdrawAmount;
    }

    /**
     * @param withdrawAmount 
	 *            提现金额
     */
    public void setWithdrawAmount(Integer withdrawAmount) {
        this.withdrawAmount = withdrawAmount;
    }

    /**
     * @return 手续费
     */
    public Integer getCommissionFees() {
        return commissionFees;
    }

    /**
     * @param commissionFees 
	 *            手续费
     */
    public void setCommissionFees(Integer commissionFees) {
        this.commissionFees = commissionFees;
    }

    /**
     * @return 提出时间
     */
    public Date getInsertTime() {
        return insertTime;
    }

    /**
     * @param insertTime 
	 *            提出时间
     */
    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }

    /**
     * @return 银行卡
     */
    public Integer getUserBankcardId() {
        return userBankcardId;
    }

    /**
     * @param userBankcardId 
	 *            银行卡
     */
    public void setUserBankcardId(Integer userBankcardId) {
        this.userBankcardId = userBankcardId;
    }

    /**
     * @return 用户id
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * @param userId 
	 *            用户id
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * @return 状态,CRT 申请，OK# 提现成功，FLS提现失败
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status 
	 *            状态,CRT 申请，OK# 提现成功，FLS提现失败
     */
    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
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
        WithdrawApply other = (WithdrawApply) that;
        return (this.getOrderId() == null ? other.getOrderId() == null : this.getOrderId().equals(other.getOrderId()))
            && (this.getWithdrawAmount() == null ? other.getWithdrawAmount() == null : this.getWithdrawAmount().equals(other.getWithdrawAmount()))
            && (this.getCommissionFees() == null ? other.getCommissionFees() == null : this.getCommissionFees().equals(other.getCommissionFees()))
            && (this.getInsertTime() == null ? other.getInsertTime() == null : this.getInsertTime().equals(other.getInsertTime()))
            && (this.getUserBankcardId() == null ? other.getUserBankcardId() == null : this.getUserBankcardId().equals(other.getUserBankcardId()))
            && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getOrderId() == null) ? 0 : getOrderId().hashCode());
        result = prime * result + ((getWithdrawAmount() == null) ? 0 : getWithdrawAmount().hashCode());
        result = prime * result + ((getCommissionFees() == null) ? 0 : getCommissionFees().hashCode());
        result = prime * result + ((getInsertTime() == null) ? 0 : getInsertTime().hashCode());
        result = prime * result + ((getUserBankcardId() == null) ? 0 : getUserBankcardId().hashCode());
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        return result;
    }
}