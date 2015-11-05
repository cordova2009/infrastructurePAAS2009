package com.hummingbird.paas.entity;

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
    private String order_id;

    /**
     * 支付宝订单号
     */
    private String trade_id;

    /**
     * 支付状态,CRT待支付，OK#已支付，FLS支付失败
     */
    private String pay_status;

    /**
     * 新增时间
     */
    private Date insert_time;

    /**
     * 应用id
     */
    private String app_id;

    /**
     * 产品描述
     */
    private String product_desc;

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
     * @return 支付宝订单号
     */
    public String getTrade_id() {
        return trade_id;
    }

    /**
     * @param tradeId 
	 *            支付宝订单号
     */
    public void setTrade_id(String trade_id) {
        this.trade_id = trade_id == null ? null : trade_id.trim();
    }

    /**
     * @return 支付状态,CRT待支付，OK#已支付，FLS支付失败
     */
    public String getPay_status() {
        return pay_status;
    }

    /**
     * @param payStatus 
	 *            支付状态,CRT待支付，OK#已支付，FLS支付失败
     */
    public void setPay_status(String pay_status) {
        this.pay_status = pay_status == null ? null : pay_status.trim();
    }

    /**
     * @return 新增时间
     */
    public Date getInsert_time() {
        return insert_time;
    }

    /**
     * @param insertTime 
	 *            新增时间
     */
    public void setInsert_time(Date insert_time) {
        this.insert_time = insert_time;
    }

    /**
     * @return 应用id
     */
    public String getApp_id() {
        return app_id;
    }

    /**
     * @param appId 
	 *            应用id
     */
    public void setApp_id(String app_id) {
        this.app_id = app_id == null ? null : app_id.trim();
    }

    /**
     * @return 产品描述
     */
    public String getProduct_desc() {
        return product_desc;
    }

    /**
     * @param productDesc 
	 *            产品描述
     */
    public void setProduct_desc(String product_desc) {
        this.product_desc = product_desc == null ? null : product_desc.trim();
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
            && (this.getOrder_id() == null ? other.getOrder_id() == null : this.getOrder_id().equals(other.getOrder_id()))
            && (this.getTrade_id() == null ? other.getTrade_id() == null : this.getTrade_id().equals(other.getTrade_id()))
            && (this.getPay_status() == null ? other.getPay_status() == null : this.getPay_status().equals(other.getPay_status()))
            && (this.getInsert_time() == null ? other.getInsert_time() == null : this.getInsert_time().equals(other.getInsert_time()))
            && (this.getApp_id() == null ? other.getApp_id() == null : this.getApp_id().equals(other.getApp_id()))
            && (this.getProduct_desc() == null ? other.getProduct_desc() == null : this.getProduct_desc().equals(other.getProduct_desc()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getOrder_id() == null) ? 0 : getOrder_id().hashCode());
        result = prime * result + ((getTrade_id() == null) ? 0 : getTrade_id().hashCode());
        result = prime * result + ((getPay_status() == null) ? 0 : getPay_status().hashCode());
        result = prime * result + ((getInsert_time() == null) ? 0 : getInsert_time().hashCode());
        result = prime * result + ((getApp_id() == null) ? 0 : getApp_id().hashCode());
        result = prime * result + ((getProduct_desc() == null) ? 0 : getProduct_desc().hashCode());
        return result;
    }
}