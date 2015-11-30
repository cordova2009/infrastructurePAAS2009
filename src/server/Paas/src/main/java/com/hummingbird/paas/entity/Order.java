package com.hummingbird.paas.entity;

import java.util.Date;

/**
 * 订单表
 */
public class Order {
    /**
     * 订单号
     */
    private String orderId;

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
    private Long productPrice;

    /**
     * 总价，单位为分
     */
    private Long amount;

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
    private Long realAmount;

    /**
     * 用户id
     */
    private Integer userId;

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
    public Long getProductPrice() {
        return productPrice;
    }

    /**
     * @param productPrice 
	 *            单价，单位为分
     */
    public void setProductPrice(Long productPrice) {
        this.productPrice = productPrice;
    }

    /**
     * @return 总价，单位为分
     */
    public Long getAmount() {
        return amount;
    }

    /**
     * @param amount 
	 *            总价，单位为分
     */
    public void setAmount(Long amount) {
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
    public Long getRealAmount() {
        return realAmount;
    }

    /**
     * @param realAmount 
	 *            折后价格
     */
    public void setRealAmount(Long realAmount) {
        this.realAmount = realAmount;
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
}