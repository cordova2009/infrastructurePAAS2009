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
    private Date should_pay_time;

    /**
     * 支付时间
     */
    private Date pay_time;

    /**
     * 状态,CRT待支付,OK#已支付,FLS支付失败
     */
    private String status;

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
     * 转帐日期
     */
    private Date transfer_date;

    /**
     * 订单号
     */
    private String order_id;

    /**
     * 银行id
     */
    private String bank_id;

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
    public Date getShould_pay_time() {
        return should_pay_time;
    }

    /**
     * @param shouldPayTime 
	 *            应支付时间
     */
    public void setShould_pay_time(Date should_pay_time) {
        this.should_pay_time = should_pay_time;
    }

    /**
     * @return 支付时间
     */
    public Date getPay_time() {
        return pay_time;
    }

    /**
     * @param payTime 
	 *            支付时间
     */
    public void setPay_time(Date pay_time) {
        this.pay_time = pay_time;
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
     * @return 转帐日期
     */
    public Date getTransfer_date() {
        return transfer_date;
    }

    /**
     * @param transferDate 
	 *            转帐日期
     */
    public void setTransfer_date(Date transfer_date) {
        this.transfer_date = transfer_date;
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
        ProjectPaymentPay other = (ProjectPaymentPay) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getObject_id() == null ? other.getObject_id() == null : this.getObject_id().equals(other.getObject_id()))
            && (this.getCurrent_period() == null ? other.getCurrent_period() == null : this.getCurrent_period().equals(other.getCurrent_period()))
            && (this.getAmount() == null ? other.getAmount() == null : this.getAmount().equals(other.getAmount()))
            && (this.getShould_pay_time() == null ? other.getShould_pay_time() == null : this.getShould_pay_time().equals(other.getShould_pay_time()))
            && (this.getPay_time() == null ? other.getPay_time() == null : this.getPay_time().equals(other.getPay_time()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getTotal_amount() == null ? other.getTotal_amount() == null : this.getTotal_amount().equals(other.getTotal_amount()))
            && (this.getLeft_period() == null ? other.getLeft_period() == null : this.getLeft_period().equals(other.getLeft_period()))
            && (this.getLeft_amount() == null ? other.getLeft_amount() == null : this.getLeft_amount().equals(other.getLeft_amount()))
            && (this.getTotal_period() == null ? other.getTotal_period() == null : this.getTotal_period().equals(other.getTotal_period()))
            && (this.getBank() == null ? other.getBank() == null : this.getBank().equals(other.getBank()))
            && (this.getVoucher() == null ? other.getVoucher() == null : this.getVoucher().equals(other.getVoucher()))
            && (this.getVoucher_pic() == null ? other.getVoucher_pic() == null : this.getVoucher_pic().equals(other.getVoucher_pic()))
            && (this.getTransfer_date() == null ? other.getTransfer_date() == null : this.getTransfer_date().equals(other.getTransfer_date()))
            && (this.getOrder_id() == null ? other.getOrder_id() == null : this.getOrder_id().equals(other.getOrder_id()))
            && (this.getBank_id() == null ? other.getBank_id() == null : this.getBank_id().equals(other.getBank_id()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getObject_id() == null) ? 0 : getObject_id().hashCode());
        result = prime * result + ((getCurrent_period() == null) ? 0 : getCurrent_period().hashCode());
        result = prime * result + ((getAmount() == null) ? 0 : getAmount().hashCode());
        result = prime * result + ((getShould_pay_time() == null) ? 0 : getShould_pay_time().hashCode());
        result = prime * result + ((getPay_time() == null) ? 0 : getPay_time().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getTotal_amount() == null) ? 0 : getTotal_amount().hashCode());
        result = prime * result + ((getLeft_period() == null) ? 0 : getLeft_period().hashCode());
        result = prime * result + ((getLeft_amount() == null) ? 0 : getLeft_amount().hashCode());
        result = prime * result + ((getTotal_period() == null) ? 0 : getTotal_period().hashCode());
        result = prime * result + ((getBank() == null) ? 0 : getBank().hashCode());
        result = prime * result + ((getVoucher() == null) ? 0 : getVoucher().hashCode());
        result = prime * result + ((getVoucher_pic() == null) ? 0 : getVoucher_pic().hashCode());
        result = prime * result + ((getTransfer_date() == null) ? 0 : getTransfer_date().hashCode());
        result = prime * result + ((getOrder_id() == null) ? 0 : getOrder_id().hashCode());
        result = prime * result + ((getBank_id() == null) ? 0 : getBank_id().hashCode());
        return result;
    }
}