package com.hummingbird.paas.entity;

import java.util.Date;

/**
 * 提现申请表
 */
public class WithdrawApply {
    /**
     * 订单id
     */
    private String order_id;

    /**
     * 提现金额
     */
    private Integer withdraw_amount;

    /**
     * 手续费
     */
    private Integer commission_fees;

    /**
     * 提出时间
     */
    private Date insert_time;

    /**
     * 银行卡
     */
    private Integer user_bankcard_id;

    /**
     * 用户id
     */
    private Integer user_id;

    /**
     * 状态,CRT 申请，OK# 提现成功，FLS提现失败
     */
    private String status;

    /**
     * @return 订单id
     */
    public String getOrder_id() {
        return order_id;
    }

    /**
     * @param orderId 
	 *            订单id
     */
    public void setOrder_id(String order_id) {
        this.order_id = order_id == null ? null : order_id.trim();
    }

    /**
     * @return 提现金额
     */
    public Integer getWithdraw_amount() {
        return withdraw_amount;
    }

    /**
     * @param withdrawAmount 
	 *            提现金额
     */
    public void setWithdraw_amount(Integer withdraw_amount) {
        this.withdraw_amount = withdraw_amount;
    }

    /**
     * @return 手续费
     */
    public Integer getCommission_fees() {
        return commission_fees;
    }

    /**
     * @param commissionFees 
	 *            手续费
     */
    public void setCommission_fees(Integer commission_fees) {
        this.commission_fees = commission_fees;
    }

    /**
     * @return 提出时间
     */
    public Date getInsert_time() {
        return insert_time;
    }

    /**
     * @param insertTime 
	 *            提出时间
     */
    public void setInsert_time(Date insert_time) {
        this.insert_time = insert_time;
    }

    /**
     * @return 银行卡
     */
    public Integer getUser_bankcard_id() {
        return user_bankcard_id;
    }

    /**
     * @param userBankcardId 
	 *            银行卡
     */
    public void setUser_bankcard_id(Integer user_bankcard_id) {
        this.user_bankcard_id = user_bankcard_id;
    }

    /**
     * @return 用户id
     */
    public Integer getUser_id() {
        return user_id;
    }

    /**
     * @param userId 
	 *            用户id
     */
    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
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
        return (this.getOrder_id() == null ? other.getOrder_id() == null : this.getOrder_id().equals(other.getOrder_id()))
            && (this.getWithdraw_amount() == null ? other.getWithdraw_amount() == null : this.getWithdraw_amount().equals(other.getWithdraw_amount()))
            && (this.getCommission_fees() == null ? other.getCommission_fees() == null : this.getCommission_fees().equals(other.getCommission_fees()))
            && (this.getInsert_time() == null ? other.getInsert_time() == null : this.getInsert_time().equals(other.getInsert_time()))
            && (this.getUser_bankcard_id() == null ? other.getUser_bankcard_id() == null : this.getUser_bankcard_id().equals(other.getUser_bankcard_id()))
            && (this.getUser_id() == null ? other.getUser_id() == null : this.getUser_id().equals(other.getUser_id()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getOrder_id() == null) ? 0 : getOrder_id().hashCode());
        result = prime * result + ((getWithdraw_amount() == null) ? 0 : getWithdraw_amount().hashCode());
        result = prime * result + ((getCommission_fees() == null) ? 0 : getCommission_fees().hashCode());
        result = prime * result + ((getInsert_time() == null) ? 0 : getInsert_time().hashCode());
        result = prime * result + ((getUser_bankcard_id() == null) ? 0 : getUser_bankcard_id().hashCode());
        result = prime * result + ((getUser_id() == null) ? 0 : getUser_id().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        return result;
    }
}