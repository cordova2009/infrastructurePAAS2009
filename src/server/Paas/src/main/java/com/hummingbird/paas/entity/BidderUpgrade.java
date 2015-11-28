package com.hummingbird.paas.entity;

import java.util.Date;

/**
 * 承包商会员升级记录表
 */
public class BidderUpgrade {
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
}