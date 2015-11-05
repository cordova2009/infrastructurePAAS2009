package com.hummingbird.paas.entity;

import java.util.Date;

/**
 * 订单表
 */
public class Order {
    /**
     * 订单号
     */
    private Integer order_id;

    /**
     * 创建时间
     */
    private Date insert_time;

    /**
     * 产品id
     */
    private String product_id;

    /**
     * 数量
     */
    private Integer product_count;

    /**
     * 单价，单位为分
     */
    private Integer product_price;

    /**
     * 总价，单位为分
     */
    private Integer amount;

    /**
     * 更新时间
     */
    private Date update_time;

    /**
     * 创建人,用户id
     */
    private String create_by;

    /**
     * 支付类型,ALI支付宝，AAC平台帐户
     */
    private String pay_type;

    /**
     * 产品描述
     */
    private String product_desc;

    /**
     * 支付状态,CRT待支付，OK#已支付，FLS支付失败
     */
    private String pay_status;

    /**
     * 应用id
     */
    private String app_id;

    /**
     * 产品折扣
     */
    private Integer discount;

    /**
     * 折后价格
     */
    private Integer real_amount;

    /**
     * @return 订单号
     */
    public Integer getOrder_id() {
        return order_id;
    }

    /**
     * @param orderId 
	 *            订单号
     */
    public void setOrder_id(Integer order_id) {
        this.order_id = order_id;
    }

    /**
     * @return 创建时间
     */
    public Date getInsert_time() {
        return insert_time;
    }

    /**
     * @param insertTime 
	 *            创建时间
     */
    public void setInsert_time(Date insert_time) {
        this.insert_time = insert_time;
    }

    /**
     * @return 产品id
     */
    public String getProduct_id() {
        return product_id;
    }

    /**
     * @param productId 
	 *            产品id
     */
    public void setProduct_id(String product_id) {
        this.product_id = product_id == null ? null : product_id.trim();
    }

    /**
     * @return 数量
     */
    public Integer getProduct_count() {
        return product_count;
    }

    /**
     * @param productCount 
	 *            数量
     */
    public void setProduct_count(Integer product_count) {
        this.product_count = product_count;
    }

    /**
     * @return 单价，单位为分
     */
    public Integer getProduct_price() {
        return product_price;
    }

    /**
     * @param productPrice 
	 *            单价，单位为分
     */
    public void setProduct_price(Integer product_price) {
        this.product_price = product_price;
    }

    /**
     * @return 总价，单位为分
     */
    public Integer getAmount() {
        return amount;
    }

    /**
     * @param amount 
	 *            总价，单位为分
     */
    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    /**
     * @return 更新时间
     */
    public Date getUpdate_time() {
        return update_time;
    }

    /**
     * @param updateTime 
	 *            更新时间
     */
    public void setUpdate_time(Date update_time) {
        this.update_time = update_time;
    }

    /**
     * @return 创建人,用户id
     */
    public String getCreate_by() {
        return create_by;
    }

    /**
     * @param createBy 
	 *            创建人,用户id
     */
    public void setCreate_by(String create_by) {
        this.create_by = create_by == null ? null : create_by.trim();
    }

    /**
     * @return 支付类型,ALI支付宝，AAC平台帐户
     */
    public String getPay_type() {
        return pay_type;
    }

    /**
     * @param payType 
	 *            支付类型,ALI支付宝，AAC平台帐户
     */
    public void setPay_type(String pay_type) {
        this.pay_type = pay_type == null ? null : pay_type.trim();
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
     * @return 产品折扣
     */
    public Integer getDiscount() {
        return discount;
    }

    /**
     * @param discount 
	 *            产品折扣
     */
    public void setDiscount(Integer discount) {
        this.discount = discount;
    }

    /**
     * @return 折后价格
     */
    public Integer getReal_amount() {
        return real_amount;
    }

    /**
     * @param realAmount 
	 *            折后价格
     */
    public void setReal_amount(Integer real_amount) {
        this.real_amount = real_amount;
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
        Order other = (Order) that;
        return (this.getOrder_id() == null ? other.getOrder_id() == null : this.getOrder_id().equals(other.getOrder_id()))
            && (this.getInsert_time() == null ? other.getInsert_time() == null : this.getInsert_time().equals(other.getInsert_time()))
            && (this.getProduct_id() == null ? other.getProduct_id() == null : this.getProduct_id().equals(other.getProduct_id()))
            && (this.getProduct_count() == null ? other.getProduct_count() == null : this.getProduct_count().equals(other.getProduct_count()))
            && (this.getProduct_price() == null ? other.getProduct_price() == null : this.getProduct_price().equals(other.getProduct_price()))
            && (this.getAmount() == null ? other.getAmount() == null : this.getAmount().equals(other.getAmount()))
            && (this.getUpdate_time() == null ? other.getUpdate_time() == null : this.getUpdate_time().equals(other.getUpdate_time()))
            && (this.getCreate_by() == null ? other.getCreate_by() == null : this.getCreate_by().equals(other.getCreate_by()))
            && (this.getPay_type() == null ? other.getPay_type() == null : this.getPay_type().equals(other.getPay_type()))
            && (this.getProduct_desc() == null ? other.getProduct_desc() == null : this.getProduct_desc().equals(other.getProduct_desc()))
            && (this.getPay_status() == null ? other.getPay_status() == null : this.getPay_status().equals(other.getPay_status()))
            && (this.getApp_id() == null ? other.getApp_id() == null : this.getApp_id().equals(other.getApp_id()))
            && (this.getDiscount() == null ? other.getDiscount() == null : this.getDiscount().equals(other.getDiscount()))
            && (this.getReal_amount() == null ? other.getReal_amount() == null : this.getReal_amount().equals(other.getReal_amount()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getOrder_id() == null) ? 0 : getOrder_id().hashCode());
        result = prime * result + ((getInsert_time() == null) ? 0 : getInsert_time().hashCode());
        result = prime * result + ((getProduct_id() == null) ? 0 : getProduct_id().hashCode());
        result = prime * result + ((getProduct_count() == null) ? 0 : getProduct_count().hashCode());
        result = prime * result + ((getProduct_price() == null) ? 0 : getProduct_price().hashCode());
        result = prime * result + ((getAmount() == null) ? 0 : getAmount().hashCode());
        result = prime * result + ((getUpdate_time() == null) ? 0 : getUpdate_time().hashCode());
        result = prime * result + ((getCreate_by() == null) ? 0 : getCreate_by().hashCode());
        result = prime * result + ((getPay_type() == null) ? 0 : getPay_type().hashCode());
        result = prime * result + ((getProduct_desc() == null) ? 0 : getProduct_desc().hashCode());
        result = prime * result + ((getPay_status() == null) ? 0 : getPay_status().hashCode());
        result = prime * result + ((getApp_id() == null) ? 0 : getApp_id().hashCode());
        result = prime * result + ((getDiscount() == null) ? 0 : getDiscount().hashCode());
        result = prime * result + ((getReal_amount() == null) ? 0 : getReal_amount().hashCode());
        return result;
    }
}