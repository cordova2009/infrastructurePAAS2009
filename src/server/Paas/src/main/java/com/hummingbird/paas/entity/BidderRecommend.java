package com.hummingbird.paas.entity;

import java.util.Date;

/**
 * 投标推荐人,
 */
public class BidderRecommend {
    /**
     * 主键
     */
    private Integer id;

    /**
     * 投标人id
     */
    private Integer bidderId;

    /**
     * 排序号
     */
    private Integer sortNo;

    /**
     * 新增时间
     */
    private Date insertTime;

    /**
     * 创建人
     */
    private String creator;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 更新人
     */
    private String updator;

    /**
     * @return 主键
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id 
	 *            主键
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return 投标人id
     */
    public Integer getBidderId() {
        return bidderId;
    }

    /**
     * @param bidderId 
	 *            投标人id
     */
    public void setBidderId(Integer bidderId) {
        this.bidderId = bidderId;
    }

    /**
     * @return 排序号
     */
    public Integer getSortNo() {
        return sortNo;
    }

    /**
     * @param sortNo 
	 *            排序号
     */
    public void setSortNo(Integer sortNo) {
        this.sortNo = sortNo;
    }

    /**
     * @return 新增时间
     */
    public Date getInsertTime() {
        return insertTime;
    }

    /**
     * @param insertTime 
	 *            新增时间
     */
    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }

    /**
     * @return 创建人
     */
    public String getCreator() {
        return creator;
    }

    /**
     * @param creator 
	 *            创建人
     */
    public void setCreator(String creator) {
        this.creator = creator == null ? null : creator.trim();
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
     * @return 更新人
     */
    public String getUpdator() {
        return updator;
    }

    /**
     * @param updator 
	 *            更新人
     */
    public void setUpdator(String updator) {
        this.updator = updator == null ? null : updator.trim();
    }
}