package com.hummingbird.paas.entity;

import java.util.Date;

/**
 * 订单表
 */
public class Order {
    /**
     * 订单号
     */
    private Integer orderId;

    /**
     * 创建时间
     */
    private Date insertTime;

    /**
     * 产品id
     */
    private String productId;

    /**
     * 数量
     */
    private Integer productCount;

    /**
     * 单价，单位为分
     */
    private Integer productPrice;

    /**
     * 总价，单位为分
     */
    private Integer amount;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 创建人,用户id
     */
    private String createBy;

    /**
     * 支付类型,ALI支付宝，AAC平台帐户
     */
    private String payType;

    /**
     * 产品描述
     */
    private String productDesc;

    /**
     * 支付状态,CRT待支付，OK#已支付，FLS支付失败
     */
    private String payStatus;

    /**
     * 应用id
     */
    private String appId;

    /**
     * 产品折扣
     */
    private Integer discount;

    /**
     * 折后价格
     */
    private Integer realAmount;

    /**
     * @return 订单号
     */
    public Integer getOrderId() {
        return orderId;
    }

    /**
     * @param orderId 
	 *            订单号
     */
    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    /**
     * @return 创建时间
     */
    public Date getInsertTime() {
        return insertTime;
    }

    /**
     * @param insertTime 
	 *            创建时间
     */
    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }

    /**
     * @return 产品id
     */
    public String getProductId() {
        return productId;
    }

    /**
     * @param productId 
	 *            产品id
     */
    public void setProductId(String productId) {
        this.productId = productId == null ? null : productId.trim();
    }

    /**
     * @return 数量
     */
    public Integer getProductCount() {
        return productCount;
    }

    /**
     * @param productCount 
	 *            数量
     */
    public void setProductCount(Integer productCount) {
        this.productCount = productCount;
    }

    /**
     * @return 单价，单位为分
     */
    public Integer getProductPrice() {
        return productPrice;
    }

    /**
     * @param productPrice 
	 *            单价，单位为分
     */
    public void setProductPrice(Integer productPrice) {
        this.productPrice = productPrice;
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
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * @param updateTime 
	 *            更新时间
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * @return 创建人,用户id
     */
    public String getCreateBy() {
        return createBy;
    }

    /**
     * @param createBy 
	 *            创建人,用户id
     */
    public void setCreateBy(String createBy) {
        this.createBy = createBy == null ? null : createBy.trim();
    }

    /**
     * @return 支付类型,ALI支付宝，AAC平台帐户
     */
    public String getPayType() {
        return payType;
    }

    /**
     * @param payType 
	 *            支付类型,ALI支付宝，AAC平台帐户
     */
    public void setPayType(String payType) {
        this.payType = payType == null ? null : payType.trim();
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
    public Integer getRealAmount() {
        return realAmount;
    }

    /**
     * @param realAmount 
	 *            折后价格
     */
    public void setRealAmount(Integer realAmount) {
        this.realAmount = realAmount;
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
        return (this.getOrderId() == null ? other.getOrderId() == null : this.getOrderId().equals(other.getOrderId()))
            && (this.getInsertTime() == null ? other.getInsertTime() == null : this.getInsertTime().equals(other.getInsertTime()))
            && (this.getProductId() == null ? other.getProductId() == null : this.getProductId().equals(other.getProductId()))
            && (this.getProductCount() == null ? other.getProductCount() == null : this.getProductCount().equals(other.getProductCount()))
            && (this.getProductPrice() == null ? other.getProductPrice() == null : this.getProductPrice().equals(other.getProductPrice()))
            && (this.getAmount() == null ? other.getAmount() == null : this.getAmount().equals(other.getAmount()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()))
            && (this.getCreateBy() == null ? other.getCreateBy() == null : this.getCreateBy().equals(other.getCreateBy()))
            && (this.getPayType() == null ? other.getPayType() == null : this.getPayType().equals(other.getPayType()))
            && (this.getProductDesc() == null ? other.getProductDesc() == null : this.getProductDesc().equals(other.getProductDesc()))
            && (this.getPayStatus() == null ? other.getPayStatus() == null : this.getPayStatus().equals(other.getPayStatus()))
            && (this.getAppId() == null ? other.getAppId() == null : this.getAppId().equals(other.getAppId()))
            && (this.getDiscount() == null ? other.getDiscount() == null : this.getDiscount().equals(other.getDiscount()))
            && (this.getRealAmount() == null ? other.getRealAmount() == null : this.getRealAmount().equals(other.getRealAmount()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getOrderId() == null) ? 0 : getOrderId().hashCode());
        result = prime * result + ((getInsertTime() == null) ? 0 : getInsertTime().hashCode());
        result = prime * result + ((getProductId() == null) ? 0 : getProductId().hashCode());
        result = prime * result + ((getProductCount() == null) ? 0 : getProductCount().hashCode());
        result = prime * result + ((getProductPrice() == null) ? 0 : getProductPrice().hashCode());
        result = prime * result + ((getAmount() == null) ? 0 : getAmount().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        result = prime * result + ((getCreateBy() == null) ? 0 : getCreateBy().hashCode());
        result = prime * result + ((getPayType() == null) ? 0 : getPayType().hashCode());
        result = prime * result + ((getProductDesc() == null) ? 0 : getProductDesc().hashCode());
        result = prime * result + ((getPayStatus() == null) ? 0 : getPayStatus().hashCode());
        result = prime * result + ((getAppId() == null) ? 0 : getAppId().hashCode());
        result = prime * result + ((getDiscount() == null) ? 0 : getDiscount().hashCode());
        result = prime * result + ((getRealAmount() == null) ? 0 : getRealAmount().hashCode());
        return result;
    }
}