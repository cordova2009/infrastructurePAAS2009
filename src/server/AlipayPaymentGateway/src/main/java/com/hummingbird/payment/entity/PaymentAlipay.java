package com.hummingbird.payment.entity;

import java.util.Date;

/**
 * 支付宝支付记录表
 */
public class PaymentAlipay {
    /**
     * id
     */
    private Integer id;

    /**
     * 订单号
     */
    private String orderId;

    /**
     * 支付宝订单号
     */
    private String tradeId;

    /**
     * 支付状态,CRT待支付，OK#已支付，FLS支付失败
     */
    private String payStatus;

    /**
     * 新增时间
     */
    private Date insertTime;

    /**
     * 应用id
     */
    private String appId;

    /**
     * 产品描述
     */
    private String productDesc;

    /**
     * 支付金额,单位分
     */
    private Integer sum;

    /**
     * 支付时间
     */
    private Date payTime;

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
     * @return 支付宝订单号
     */
    public String getTradeId() {
        return tradeId;
    }

    /**
     * @param tradeId 
	 *            支付宝订单号
     */
    public void setTradeId(String tradeId) {
        this.tradeId = tradeId == null ? null : tradeId.trim();
    }

    /**
     * @return 支付状态,CRT待支付，OK#已支付，FLS支付失败
     */
    public String getPayStatus() {
        return payStatus;
    }

    /**
     * @param payStatus 
	 *            支付状态,CRT待支付，OK#已支付，FLS支付失败
     */
    public void setPayStatus(String payStatus) {
        this.payStatus = payStatus == null ? null : payStatus.trim();
    }

    /**
     * @return 新增时间
     */
    public Date getInsertTime() {
        return insertTime;
    }

    /**
     * @param insertTime 
	 *            新增时间
     */
    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }

    /**
     * @return 应用id
     */
    public String getAppId() {
        return appId;
    }

    /**
     * @param appId 
	 *            应用id
     */
    public void setAppId(String appId) {
        this.appId = appId == null ? null : appId.trim();
    }

    /**
     * @return 产品描述
     */
    public String getProductDesc() {
        return productDesc;
    }

    /**
     * @param productDesc 
	 *            产品描述
     */
    public void setProductDesc(String productDesc) {
        this.productDesc = productDesc == null ? null : productDesc.trim();
    }

    /**
     * @return 支付金额,单位分
     */
    public Integer getSum() {
        return sum;
    }

    /**
     * @param sum 
	 *            支付金额,单位分
     */
    public void setSum(Integer sum) {
        this.sum = sum;
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
        PaymentAlipay other = (PaymentAlipay) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getOrderId() == null ? other.getOrderId() == null : this.getOrderId().equals(other.getOrderId()))
            && (this.getTradeId() == null ? other.getTradeId() == null : this.getTradeId().equals(other.getTradeId()))
            && (this.getPayStatus() == null ? other.getPayStatus() == null : this.getPayStatus().equals(other.getPayStatus()))
            && (this.getInsertTime() == null ? other.getInsertTime() == null : this.getInsertTime().equals(other.getInsertTime()))
            && (this.getAppId() == null ? other.getAppId() == null : this.getAppId().equals(other.getAppId()))
            && (this.getProductDesc() == null ? other.getProductDesc() == null : this.getProductDesc().equals(other.getProductDesc()))
            && (this.getSum() == null ? other.getSum() == null : this.getSum().equals(other.getSum()))
            && (this.getPayTime() == null ? other.getPayTime() == null : this.getPayTime().equals(other.getPayTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getOrderId() == null) ? 0 : getOrderId().hashCode());
        result = prime * result + ((getTradeId() == null) ? 0 : getTradeId().hashCode());
        result = prime * result + ((getPayStatus() == null) ? 0 : getPayStatus().hashCode());
        result = prime * result + ((getInsertTime() == null) ? 0 : getInsertTime().hashCode());
        result = prime * result + ((getAppId() == null) ? 0 : getAppId().hashCode());
        result = prime * result + ((getProductDesc() == null) ? 0 : getProductDesc().hashCode());
        result = prime * result + ((getSum() == null) ? 0 : getSum().hashCode());
        result = prime * result + ((getPayTime() == null) ? 0 : getPayTime().hashCode());
        return result;
    }
}