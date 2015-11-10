package com.hummingbird.paas.entity;

/**
 * 会员产品属性表
 */
public class MemberProductAttr {
    /**
     * 产品id
     */
    private String productId;

    /**
     * 产品名称
     */
    private String productName;

    /**
     * 产品有效期,单位为天
     */
    private Integer productExpireLength;

    /**
     * 会员对象,TEE招标，TER投标
     */
    private String memberType;

    /**
     * 会员级别，STD标准会员，ADV高级会员
     */
    private String level;

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
     * @return 产品有效期,单位为天
     */
    public Integer getProductExpireLength() {
        return productExpireLength;
    }

    /**
     * @param productExpireLength 
	 *            产品有效期,单位为天
     */
    public void setProductExpireLength(Integer productExpireLength) {
        this.productExpireLength = productExpireLength;
    }

    /**
     * @return 会员对象,TEE招标，TER投标
     */
    public String getMemberType() {
        return memberType;
    }

    /**
     * @param memberType 
	 *            会员对象,TEE招标，TER投标
     */
    public void setMemberType(String memberType) {
        this.memberType = memberType == null ? null : memberType.trim();
    }

    /**
     * @return 会员级别，STD标准会员，ADV高级会员
     */
    public String getLevel() {
        return level;
    }

    /**
     * @param level 
	 *            会员级别，STD标准会员，ADV高级会员
     */
    public void setLevel(String level) {
        this.level = level == null ? null : level.trim();
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
        return (this.getProductId() == null ? other.getProductId() == null : this.getProductId().equals(other.getProductId()))
            && (this.getProductName() == null ? other.getProductName() == null : this.getProductName().equals(other.getProductName()))
            && (this.getProductExpireLength() == null ? other.getProductExpireLength() == null : this.getProductExpireLength().equals(other.getProductExpireLength()))
            && (this.getMemberType() == null ? other.getMemberType() == null : this.getMemberType().equals(other.getMemberType()))
            && (this.getLevel() == null ? other.getLevel() == null : this.getLevel().equals(other.getLevel()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getProductId() == null) ? 0 : getProductId().hashCode());
        result = prime * result + ((getProductName() == null) ? 0 : getProductName().hashCode());
        result = prime * result + ((getProductExpireLength() == null) ? 0 : getProductExpireLength().hashCode());
        result = prime * result + ((getMemberType() == null) ? 0 : getMemberType().hashCode());
        result = prime * result + ((getLevel() == null) ? 0 : getLevel().hashCode());
        return result;
    }
}