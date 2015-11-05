package com.hummingbird.paas.entity;

import java.util.Date;

/**
 * 冲值申请表
 */
public class RechargeApply {
    /**
     * 订单id，RC00日期时间随机数
     */
    private String order_id;

    /**
     * 充值金额
     */
    private Integer amount;

    /**
     * 提出时间
     */
    private Date insert_time;

    /**
     * 用户id
     */
    private Integer user_id;

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
    private String voucher_pic;

    /**
     * 银行id
     */
    private String bank_id;

    /**
     * @return 订单id，RC00日期时间随机数
     */
    public String getOrder_id() {
        return order_id;
    }

    /**
     * @param orderId 
	 *            订单id，RC00日期时间随机数
     */
    public void setOrder_id(String order_id) {
        this.order_id = order_id == null ? null : order_id.trim();
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
    public String getVoucher_pic() {
        return voucher_pic;
    }

    /**
     * @param voucherPic 
	 *            凭证上传地址
     */
    public void setVoucher_pic(String voucher_pic) {
        this.voucher_pic = voucher_pic == null ? null : voucher_pic.trim();
    }

    /**
     * @return 银行id
     */
    public String getBank_id() {
        return bank_id;
    }

    /**
     * @param bankId 
	 *            银行id
     */
    public void setBank_id(String bank_id) {
        this.bank_id = bank_id == null ? null : bank_id.trim();
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
        return (this.getOrder_id() == null ? other.getOrder_id() == null : this.getOrder_id().equals(other.getOrder_id()))
            && (this.getAmount() == null ? other.getAmount() == null : this.getAmount().equals(other.getAmount()))
            && (this.getInsert_time() == null ? other.getInsert_time() == null : this.getInsert_time().equals(other.getInsert_time()))
            && (this.getUser_id() == null ? other.getUser_id() == null : this.getUser_id().equals(other.getUser_id()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getBank() == null ? other.getBank() == null : this.getBank().equals(other.getBank()))
            && (this.getVoucher() == null ? other.getVoucher() == null : this.getVoucher().equals(other.getVoucher()))
            && (this.getVoucher_pic() == null ? other.getVoucher_pic() == null : this.getVoucher_pic().equals(other.getVoucher_pic()))
            && (this.getBank_id() == null ? other.getBank_id() == null : this.getBank_id().equals(other.getBank_id()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getOrder_id() == null) ? 0 : getOrder_id().hashCode());
        result = prime * result + ((getAmount() == null) ? 0 : getAmount().hashCode());
        result = prime * result + ((getInsert_time() == null) ? 0 : getInsert_time().hashCode());
        result = prime * result + ((getUser_id() == null) ? 0 : getUser_id().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getBank() == null) ? 0 : getBank().hashCode());
        result = prime * result + ((getVoucher() == null) ? 0 : getVoucher().hashCode());
        result = prime * result + ((getVoucher_pic() == null) ? 0 : getVoucher_pic().hashCode());
        result = prime * result + ((getBank_id() == null) ? 0 : getBank_id().hashCode());
        return result;
    }
}