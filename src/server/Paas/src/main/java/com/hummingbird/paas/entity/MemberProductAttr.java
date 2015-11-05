package com.hummingbird.paas.entity;

/**
 * 会员产品属性表
 */
public class MemberProductAttr {
    /**
     * 产品id
     */
    private String product_id;

    /**
     * 产品名称
     */
    private String product_name;

    /**
     * 产品有效期,单位为天
     */
    private Integer product_expire_length;

    /**
     * 会员对象,TEE招标，TER投标
     */
    private String member_type;

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
     * @return 产品有效期,单位为天
     */
    public Integer getProduct_expire_length() {
        return product_expire_length;
    }

    /**
     * @param productExpireLength 
	 *            产品有效期,单位为天
     */
    public void setProduct_expire_length(Integer product_expire_length) {
        this.product_expire_length = product_expire_length;
    }

    /**
     * @return 会员对象,TEE招标，TER投标
     */
    public String getMember_type() {
        return member_type;
    }

    /**
     * @param memberType 
	 *            会员对象,TEE招标，TER投标
     */
    public void setMember_type(String member_type) {
        this.member_type = member_type == null ? null : member_type.trim();
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
        MemberProductAttr other = (MemberProductAttr) that;
        return (this.getProduct_id() == null ? other.getProduct_id() == null : this.getProduct_id().equals(other.getProduct_id()))
            && (this.getProduct_name() == null ? other.getProduct_name() == null : this.getProduct_name().equals(other.getProduct_name()))
            && (this.getProduct_expire_length() == null ? other.getProduct_expire_length() == null : this.getProduct_expire_length().equals(other.getProduct_expire_length()))
            && (this.getMember_type() == null ? other.getMember_type() == null : this.getMember_type().equals(other.getMember_type()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getProduct_id() == null) ? 0 : getProduct_id().hashCode());
        result = prime * result + ((getProduct_name() == null) ? 0 : getProduct_name().hashCode());
        result = prime * result + ((getProduct_expire_length() == null) ? 0 : getProduct_expire_length().hashCode());
        result = prime * result + ((getMember_type() == null) ? 0 : getMember_type().hashCode());
        return result;
    }
}