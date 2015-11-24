package com.hummingbird.paas.entity;

import java.util.Date;

/**
 * 承包商会员升级记录表
 */
public class MemberBidderUpgrade {
    /**
     * 记录id
     */
    private Integer id;

    /**
     * 承包商id
     */
    private Integer bidderId;

    /**
     * 会员级别，STD标准会员，ADV高级会员
     */
    private String memberLevel;

    /**
     * 升级时间
     */
    private Date insertTime;

    /**
     * 升级价格，单位为分
     */
    private Integer amount;

    /**
     * 产品id
     */
    private String productId;

    /**
     * @return 记录id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id 
	 *            记录id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return 承包商id
     */
    public Integer getBidderId() {
        return bidderId;
    }

    /**
     * @param bidderId 
	 *            承包商id
     */
    public void setBidderId(Integer bidderId) {
        this.bidderId = bidderId;
    }

    /**
     * @return 会员级别，STD标准会员，ADV高级会员
     */
    public String getMemberLevel() {
        return memberLevel;
    }

    /**
     * @param memberLevel 
	 *            会员级别，STD标准会员，ADV高级会员
     */
    public void setMemberLevel(String memberLevel) {
        this.memberLevel = memberLevel == null ? null : memberLevel.trim();
    }

    /**
     * @return 升级时间
     */
    public Date getInsertTime() {
        return insertTime;
    }

    /**
     * @param insertTime 
	 *            升级时间
     */
    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }

    /**
     * @return 升级价格，单位为分
     */
    public Integer getAmount() {
        return amount;
    }

    /**
     * @param amount 
	 *            升级价格，单位为分
     */
    public void setAmount(Integer amount) {
        this.amount = amount;
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
        MemberBidderUpgrade other = (MemberBidderUpgrade) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getBidderId() == null ? other.getBidderId() == null : this.getBidderId().equals(other.getBidderId()))
            && (this.getMemberLevel() == null ? other.getMemberLevel() == null : this.getMemberLevel().equals(other.getMemberLevel()))
            && (this.getInsertTime() == null ? other.getInsertTime() == null : this.getInsertTime().equals(other.getInsertTime()))
            && (this.getAmount() == null ? other.getAmount() == null : this.getAmount().equals(other.getAmount()))
            && (this.getProductId() == null ? other.getProductId() == null : this.getProductId().equals(other.getProductId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getBidderId() == null) ? 0 : getBidderId().hashCode());
        result = prime * result + ((getMemberLevel() == null) ? 0 : getMemberLevel().hashCode());
        result = prime * result + ((getInsertTime() == null) ? 0 : getInsertTime().hashCode());
        result = prime * result + ((getAmount() == null) ? 0 : getAmount().hashCode());
        result = prime * result + ((getProductId() == null) ? 0 : getProductId().hashCode());
        return result;
    }
}