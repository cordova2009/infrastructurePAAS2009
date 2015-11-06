package com.hummingbird.paas.entity;

import java.util.Date;

/**
 * 工程付款表
 */
public class ProjectPaymentPay {
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
     * 金额,单位分
     */
    private Integer amount;

    /**
     * 应支付时间
     */
    private Date shouldPayTime;

    /**
     * 支付时间
     */
    private Date payTime;

    /**
     * 状态,CRT待支付,OK#已支付,FLS支付失败
     */
    private String status;

    /**
     * 总金额
     */
    private Integer totalAmount;

    /**
     * 剩余期数
     */
    private Integer leftPeriod;

    /**
     * 剩余金额,单位分
     */
    private Integer leftAmount;

    /**
     * 总期数
     */
    private Integer totalPeriod;

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
     * 转帐日期
     */
    private Date transferDate;

    /**
     * 订单号
     */
    private String orderId;

    /**
     * 银行id
     */
    private String bankId;

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
    public Date getShouldPayTime() {
        return shouldPayTime;
    }

    /**
     * @param shouldPayTime 
	 *            应支付时间
     */
    public void setShouldPayTime(Date shouldPayTime) {
        this.shouldPayTime = shouldPayTime;
    }

    /**
     * @return 支付时间
     */
    public Date getPayTime() {
        return payTime;
    }

    /**
     * @param payTime 
	 *            支付时间
     */
    public void setPayTime(Date payTime) {
        this.payTime = payTime;
    }

    /**
     * @return 状态,CRT待支付,OK#已支付,FLS支付失败
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status 
	 *            状态,CRT待支付,OK#已支付,FLS支付失败
     */
    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    /**
     * @return 总金额
     */
    public Integer getTotalAmount() {
        return totalAmount;
    }

    /**
     * @param totalAmount 
	 *            总金额
     */
    public void setTotalAmount(Integer totalAmount) {
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
    public Integer getLeftAmount() {
        return leftAmount;
    }

    /**
     * @param leftAmount 
	 *            剩余金额,单位分
     */
    public void setLeftAmount(Integer leftAmount) {
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
     * @return 转帐日期
     */
    public Date getTransferDate() {
        return transferDate;
    }

    /**
     * @param transferDate 
	 *            转帐日期
     */
    public void setTransferDate(Date transferDate) {
        this.transferDate = transferDate;
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
        ProjectPaymentPay other = (ProjectPaymentPay) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getObjectId() == null ? other.getObjectId() == null : this.getObjectId().equals(other.getObjectId()))
            && (this.getCurrentPeriod() == null ? other.getCurrentPeriod() == null : this.getCurrentPeriod().equals(other.getCurrentPeriod()))
            && (this.getAmount() == null ? other.getAmount() == null : this.getAmount().equals(other.getAmount()))
            && (this.getShouldPayTime() == null ? other.getShouldPayTime() == null : this.getShouldPayTime().equals(other.getShouldPayTime()))
            && (this.getPayTime() == null ? other.getPayTime() == null : this.getPayTime().equals(other.getPayTime()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getTotalAmount() == null ? other.getTotalAmount() == null : this.getTotalAmount().equals(other.getTotalAmount()))
            && (this.getLeftPeriod() == null ? other.getLeftPeriod() == null : this.getLeftPeriod().equals(other.getLeftPeriod()))
            && (this.getLeftAmount() == null ? other.getLeftAmount() == null : this.getLeftAmount().equals(other.getLeftAmount()))
            && (this.getTotalPeriod() == null ? other.getTotalPeriod() == null : this.getTotalPeriod().equals(other.getTotalPeriod()))
            && (this.getBank() == null ? other.getBank() == null : this.getBank().equals(other.getBank()))
            && (this.getVoucher() == null ? other.getVoucher() == null : this.getVoucher().equals(other.getVoucher()))
            && (this.getVoucherPic() == null ? other.getVoucherPic() == null : this.getVoucherPic().equals(other.getVoucherPic()))
            && (this.getTransferDate() == null ? other.getTransferDate() == null : this.getTransferDate().equals(other.getTransferDate()))
            && (this.getOrderId() == null ? other.getOrderId() == null : this.getOrderId().equals(other.getOrderId()))
            && (this.getBankId() == null ? other.getBankId() == null : this.getBankId().equals(other.getBankId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getObjectId() == null) ? 0 : getObjectId().hashCode());
        result = prime * result + ((getCurrentPeriod() == null) ? 0 : getCurrentPeriod().hashCode());
        result = prime * result + ((getAmount() == null) ? 0 : getAmount().hashCode());
        result = prime * result + ((getShouldPayTime() == null) ? 0 : getShouldPayTime().hashCode());
        result = prime * result + ((getPayTime() == null) ? 0 : getPayTime().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getTotalAmount() == null) ? 0 : getTotalAmount().hashCode());
        result = prime * result + ((getLeftPeriod() == null) ? 0 : getLeftPeriod().hashCode());
        result = prime * result + ((getLeftAmount() == null) ? 0 : getLeftAmount().hashCode());
        result = prime * result + ((getTotalPeriod() == null) ? 0 : getTotalPeriod().hashCode());
        result = prime * result + ((getBank() == null) ? 0 : getBank().hashCode());
        result = prime * result + ((getVoucher() == null) ? 0 : getVoucher().hashCode());
        result = prime * result + ((getVoucherPic() == null) ? 0 : getVoucherPic().hashCode());
        result = prime * result + ((getTransferDate() == null) ? 0 : getTransferDate().hashCode());
        result = prime * result + ((getOrderId() == null) ? 0 : getOrderId().hashCode());
        result = prime * result + ((getBankId() == null) ? 0 : getBankId().hashCode());
        return result;
    }
}