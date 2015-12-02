package com.hummingbird.capital.entity;

import java.util.Date;

public class Product {
    /**
     * 产品编码
     */
    private String productId;

    /**
     * 产品价格，单位：分<br>
	 * 
     */
    private Integer productPrice;

    /**
     * 产品公开面额（即价格），单位分
     */
    private Integer productAmount;

    /**
     * 产品名称
     */
    private String productName;

    /**
     * 产品简称，6个汉字长度
     */
    private String productShortName;

    /**
     * 产品链接
     */
    private String productUrl;

    /**
     * 创建时间
     */
    private Date insertTime;

    /**
     * 修改时间
     */
    private Date updateTime;

    /**
     * 账户类型，CA#-现金账户，IA#-投资账户，OCA-分期卡账户
     */
    private String accountType;

    /**
     * OK#-正常，OFF-下线，TBP-to be published 待发布
     */
    private String status;

    /**
     * @return 产品编码
     */
    public String getProductId() {
        return productId;
    }

    /**
     * @param productid 
	 *            产品编码
     */
    public void setProductId(String productId) {
        this.productId = productId == null ? null : productId.trim();
    }

    /**
     * @return 产品价格，单位：分<br>
	 * 
     */
    public Integer getProductPrice() {
        return productPrice;
    }

    /**
     * @param productprice 
	 *            产品价格，单位：分<br>
	 * 
     */
    public void setProductPrice(Integer productPrice) {
        this.productPrice = productPrice;
    }

    /**
     * @return 产品公开面额（即价格），单位分
     */
    public Integer getProductAmount() {
        return productAmount;
    }

    /**
     * @param productamount 
	 *            产品公开面额（即价格），单位分
     */
    public void setProductAmount(Integer productAmount) {
        this.productAmount = productAmount;
    }

    /**
     * @return 产品名称
     */
    public String getProductName() {
        return productName;
    }

    /**
     * @param productname 
	 *            产品名称
     */
    public void setProductName(String productName) {
        this.productName = productName == null ? null : productName.trim();
    }

    /**
     * @return 产品简称，6个汉字长度
     */
    public String getProductShortName() {
        return productShortName;
    }

    /**
     * @param productshortname 
	 *            产品简称，6个汉字长度
     */
    public void setProductShortName(String productShortName) {
        this.productShortName = productShortName == null ? null : productShortName.trim();
    }

    /**
     * @return 产品链接
     */
    public String getProductUrl() {
        return productUrl;
    }

    /**
     * @param producturl 
	 *            产品链接
     */
    public void setProductUrl(String productUrl) {
        this.productUrl = productUrl == null ? null : productUrl.trim();
    }

    /**
     * @return 创建时间
     */
    public Date getInsertTime() {
        return insertTime;
    }

    /**
     * @param inserttime 
	 *            创建时间
     */
    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }

    /**
     * @return 修改时间
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * @param updatetime 
	 *            修改时间
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * @return 账户类型，CA#-现金账户，IA#-投资账户，OCA-分期卡账户
     */
    public String getAccountType() {
        return accountType;
    }

    /**
     * @param accounttype 
	 *            账户类型，CA#-现金账户，IA#-投资账户，OCA-分期卡账户
     */
    public void setAccountType(String accountType) {
        this.accountType = accountType == null ? null : accountType.trim();
    }

    /**
     * @return OK#-正常，OFF-下线，TBP-to be published 待发布
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status 
	 *            OK#-正常，OFF-下线，TBP-to be published 待发布
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
        Product other = (Product) that;
        return (this.getProductId() == null ? other.getProductId() == null : this.getProductId().equals(other.getProductId()))
            && (this.getProductPrice() == null ? other.getProductPrice() == null : this.getProductPrice().equals(other.getProductPrice()))
            && (this.getProductAmount() == null ? other.getProductAmount() == null : this.getProductAmount().equals(other.getProductAmount()))
            && (this.getProductName() == null ? other.getProductName() == null : this.getProductName().equals(other.getProductName()))
            && (this.getProductShortName() == null ? other.getProductShortName() == null : this.getProductShortName().equals(other.getProductShortName()))
            && (this.getProductUrl() == null ? other.getProductUrl() == null : this.getProductUrl().equals(other.getProductUrl()))
            && (this.getInsertTime() == null ? other.getInsertTime() == null : this.getInsertTime().equals(other.getInsertTime()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()))
            && (this.getAccountType() == null ? other.getAccountType() == null : this.getAccountType().equals(other.getAccountType()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getProductId() == null) ? 0 : getProductId().hashCode());
        result = prime * result + ((getProductPrice() == null) ? 0 : getProductPrice().hashCode());
        result = prime * result + ((getProductAmount() == null) ? 0 : getProductAmount().hashCode());
        result = prime * result + ((getProductName() == null) ? 0 : getProductName().hashCode());
        result = prime * result + ((getProductShortName() == null) ? 0 : getProductShortName().hashCode());
        result = prime * result + ((getProductUrl() == null) ? 0 : getProductUrl().hashCode());
        result = prime * result + ((getInsertTime() == null) ? 0 : getInsertTime().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        result = prime * result + ((getAccountType() == null) ? 0 : getAccountType().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        return result;
    }
}