package com.hummingbird.paas.entity;

/**
 * 订单产品表
 */
public class OrderProduct {
    /**
     * id
     */
    private String id;

    /**
     * 产品名称
     */
    private String product_name;

    /**
     * 产品状态，OK# 正常，OFF下线
     */
    private String status;

    /**
     * 产品分类
     */
    private Integer product_category_id;

    /**
     * 产品单价,单位为分
     */
    private String price;

    /**
     * 产品描述
     */
    private String product_description;

    /**
     * @return id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id 
	 *            id
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * @return 产品名称
     */
    public String getProduct_name() {
        return product_name;
    }

    /**
     * @param productName 
	 *            产品名称
     */
    public void setProduct_name(String product_name) {
        this.product_name = product_name == null ? null : product_name.trim();
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
    public Integer getProduct_category_id() {
        return product_category_id;
    }

    /**
     * @param productCategoryId 
	 *            产品分类
     */
    public void setProduct_category_id(Integer product_category_id) {
        this.product_category_id = product_category_id;
    }

    /**
     * @return 产品单价,单位为分
     */
    public String getPrice() {
        return price;
    }

    /**
     * @param price 
	 *            产品单价,单位为分
     */
    public void setPrice(String price) {
        this.price = price == null ? null : price.trim();
    }

    /**
     * @return 产品描述
     */
    public String getProduct_description() {
        return product_description;
    }

    /**
     * @param productDescription 
	 *            产品描述
     */
    public void setProduct_description(String product_description) {
        this.product_description = product_description == null ? null : product_description.trim();
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
            && (this.getProduct_name() == null ? other.getProduct_name() == null : this.getProduct_name().equals(other.getProduct_name()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getProduct_category_id() == null ? other.getProduct_category_id() == null : this.getProduct_category_id().equals(other.getProduct_category_id()))
            && (this.getPrice() == null ? other.getPrice() == null : this.getPrice().equals(other.getPrice()))
            && (this.getProduct_description() == null ? other.getProduct_description() == null : this.getProduct_description().equals(other.getProduct_description()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getProduct_name() == null) ? 0 : getProduct_name().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getProduct_category_id() == null) ? 0 : getProduct_category_id().hashCode());
        result = prime * result + ((getPrice() == null) ? 0 : getPrice().hashCode());
        result = prime * result + ((getProduct_description() == null) ? 0 : getProduct_description().hashCode());
        return result;
    }
}