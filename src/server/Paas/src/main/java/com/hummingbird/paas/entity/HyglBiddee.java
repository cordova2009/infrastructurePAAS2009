package com.hummingbird.paas.entity;

import java.util.Date;

/**
 * 发包方会员表
 */
public class HyglBiddee {
    /**
     * 会员id
     */
    private Integer id;

    /**
     * 发包方id
     */
    private Integer biddeeId;

    /**
     * 会员级别，STD标准会员，ADV高级会员
     */
    private String memberLevel;

    /**
     * 会员开始时间
     */
    private Date startTime;

    /**
     * 会员结束时间
     */
    private Date endTime;

    private Integer productId;

    /**
     * @return 会员id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id 
	 *            会员id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return 发包方id
     */
    public Integer getBiddeeId() {
        return biddeeId;
    }

    /**
     * @param biddeeId 
	 *            发包方id
     */
    public void setBiddeeId(Integer biddeeId) {
        this.biddeeId = biddeeId;
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
     * @return 会员开始时间
     */
    public Date getStartTime() {
        return startTime;
    }

    /**
     * @param startTime 
	 *            会员开始时间
     */
    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    /**
     * @return 会员结束时间
     */
    public Date getEndTime() {
        return endTime;
    }

    /**
     * @param endTime 
	 *            会员结束时间
     */
    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }
}