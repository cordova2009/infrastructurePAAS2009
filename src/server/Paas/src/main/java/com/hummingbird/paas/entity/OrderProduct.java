package com.hummingbird.paas.entity;

/**
 * 订单产品表
 */
public class OrderProduct {
    private String id;

    /**
     * 产品名称
     */
    private String productName;

    /**
     * 产品状态，OK# 正常，OFF下线
     */
    private String status;

    /**
     * 产品分类
     */
    private Integer productCategoryId;

    /**
     * 产品单价,单位为分
     */
    private Long price;

    /**
     * 产品描述
     */
    private String productDescription;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * @return 产品名称
     */
    public String getProductName() {
        return productName;
    }

    /**
     * @param productName 
	 *            产品名称
     */
    public void setProductName(String productName) {
        this.productName = productName == null ? null : productName.trim();
    }

    /**
     * @return 产品状态，OK# 正常，OFF下线
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status 
	 *            产品状态，OK# 正常，OFF下线
     */
    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    /**
     * @return 产品分类
     */
    public Integer getProductCategoryId() {
        return productCategoryId;
    }

    /**
     * @param productCategoryId 
	 *            产品分类
     */
    public void setProductCategoryId(Integer productCategoryId) {
        this.productCategoryId = productCategoryId;
    }

    /**
     * @return 产品单价,单位为分
     */
    public Long getPrice() {
        return price;
    }

    /**
     * @param price 
	 *            产品单价,单位为分
     */
    public void setPrice(Long price) {
        this.price = price;
    }

    /**
     * @return 产品描述
     */
    public String getProductDescription() {
        return productDescription;
    }

    /**
     * @param productDescription 
	 *            产品描述
     */
    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription == null ? null : productDescription.trim();
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
        OrderProduct other = (OrderProduct) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getProductName() == null ? other.getProductName() == null : this.getProductName().equals(other.getProductName()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getProductCategoryId() == null ? other.getProductCategoryId() == null : this.getProductCategoryId().equals(other.getProductCategoryId()))
            && (this.getPrice() == null ? other.getPrice() == null : this.getPrice().equals(other.getPrice()))
            && (this.getProductDescription() == null ? other.getProductDescription() == null : this.getProductDescription().equals(other.getProductDescription()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getProductName() == null) ? 0 : getProductName().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getProductCategoryId() == null) ? 0 : getProductCategoryId().hashCode());
        result = prime * result + ((getPrice() == null) ? 0 : getPrice().hashCode());
        result = prime * result + ((getProductDescription() == null) ? 0 : getProductDescription().hashCode());
        return result;
    }
}