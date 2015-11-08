package com.hummingbird.paas.entity;

import java.util.Date;

/**
 * 冲值申请表
 */
public class RechargeApply {
    /**
     * 订单id，RC00日期时间随机数
     */
    private String orderId;

    /**
     * 充值金额
     */
    private Integer amount;

    /**
     * 提出时间
     */
    private Date insertTime;

    /**
     * 用户id
     */
    private Integer userId;

    /**
     * 状态,CRT 充值待确定，OK# 充值成功，FLS充值失败
     */
    private String status;

    /**
     * 银行
     */
    private String bank;

    /**
     * 凭证号
     */
    private String voucher;

    /**
     * 凭证上传地址
     */
    private String voucherPic;

    /**
     * 银行id
     */
    private String bankId;

    /**
     * @return 订单id，RC00日期时间随机数
     */
    public String getOrderId() {
        return orderId;
    }

    /**
     * @param orderId 
	 *            订单id，RC00日期时间随机数
     */
    public void setOrderId(String orderId) {
        this.orderId = orderId == null ? null : orderId.trim();
    }

    /**
     * @return 充值金额
     */
    public Integer getAmount() {
        return amount;
    }

    /**
     * @param amount 
	 *            充值金额
     */
    public void setAmount(Integer amount) {
        this.amount = amount;
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
     * @return 状态,CRT 充值待确定，OK# 充值成功，FLS充值失败
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status 
	 *            状态,CRT 充值待确定，OK# 充值成功，FLS充值失败
     */
    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    /**
     * @return 银行
     */
    public String getBank() {
        return bank;
    }

    /**
     * @param bank 
	 *            银行
     */
    public void setBank(String bank) {
        this.bank = bank == null ? null : bank.trim();
    }

    /**
     * @return 凭证号
     */
    public String getVoucher() {
        return voucher;
    }

    /**
     * @param voucher 
	 *            凭证号
     */
    public void setVoucher(String voucher) {
        this.voucher = voucher == null ? null : voucher.trim();
    }

    /**
     * @return 凭证上传地址
     */
    public String getVoucherPic() {
        return voucherPic;
    }

    /**
     * @param voucherPic 
	 *            凭证上传地址
     */
    public void setVoucherPic(String voucherPic) {
        this.voucherPic = voucherPic == null ? null : voucherPic.trim();
    }

    /**
     * @return 银行id
     */
    public String getBankId() {
        return bankId;
    }

    /**
     * @param bankId 
	 *            银行id
     */
    public void setBankId(String bankId) {
        this.bankId = bankId == null ? null : bankId.trim();
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
        RechargeApply other = (RechargeApply) that;
        return (this.getOrderId() == null ? other.getOrderId() == null : this.getOrderId().equals(other.getOrderId()))
            && (this.getAmount() == null ? other.getAmount() == null : this.getAmount().equals(other.getAmount()))
            && (this.getInsertTime() == null ? other.getInsertTime() == null : this.getInsertTime().equals(other.getInsertTime()))
            && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getBank() == null ? other.getBank() == null : this.getBank().equals(other.getBank()))
            && (this.getVoucher() == null ? other.getVoucher() == null : this.getVoucher().equals(other.getVoucher()))
            && (this.getVoucherPic() == null ? other.getVoucherPic() == null : this.getVoucherPic().equals(other.getVoucherPic()))
            && (this.getBankId() == null ? other.getBankId() == null : this.getBankId().equals(other.getBankId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getOrderId() == null) ? 0 : getOrderId().hashCode());
        result = prime * result + ((getAmount() == null) ? 0 : getAmount().hashCode());
        result = prime * result + ((getInsertTime() == null) ? 0 : getInsertTime().hashCode());
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getBank() == null) ? 0 : getBank().hashCode());
        result = prime * result + ((getVoucher() == null) ? 0 : getVoucher().hashCode());
        result = prime * result + ((getVoucherPic() == null) ? 0 : getVoucherPic().hashCode());
        result = prime * result + ((getBankId() == null) ? 0 : getBankId().hashCode());
        return result;
    }
}