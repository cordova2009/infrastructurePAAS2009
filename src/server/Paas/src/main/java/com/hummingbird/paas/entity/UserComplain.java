package com.hummingbird.paas.entity;

import java.util.Date;

/**
 * 用户投诉表
 */
public class UserComplain {
    private Integer id;

    /**
     * 用户id
     */
    private Integer userId;

    /**
     * 投诉信息类别,TER 招标,PPP 工程付款
     */
    private String refType;

    /**
     * 投诉信息id
     */
    private String refId;

    /**
     * 投诉内容类别,TER 招标,PPP 工程付款
     */
    private String complainType;

    /**
     * 投诉内容
     */
    private String complainContent;

    /**
     * 处理状态,CRT 待处理,OK# 已处理,NON不处理
     */
    private String dealStatus;

    /**
     * 处理结果
     */
    private String dealResult;

    /**
     * 处理人
     */
    private String handler;

    /**
     * 新增时间
     */
    private Date insertTime;

    /**
     * 更新时间
     */
    private Date updateTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    /**
     * @return 投诉信息类别,TER 招标,PPP 工程付款
     */
    public String getRefType() {
        return refType;
    }

    /**
     * @param refType 
	 *            投诉信息类别,TER 招标,PPP 工程付款
     */
    public void setRefType(String refType) {
        this.refType = refType == null ? null : refType.trim();
    }

    /**
     * @return 投诉信息id
     */
    public String getRefId() {
        return refId;
    }

    /**
     * @param refId 
	 *            投诉信息id
     */
    public void setRefId(String refId) {
        this.refId = refId == null ? null : refId.trim();
    }

    /**
     * @return 投诉内容类别,TER 招标,PPP 工程付款
     */
    public String getComplainType() {
        return complainType;
    }

    /**
     * @param complainType 
	 *            投诉内容类别,TER 招标,PPP 工程付款
     */
    public void setComplainType(String complainType) {
        this.complainType = complainType == null ? null : complainType.trim();
    }

    /**
     * @return 投诉内容
     */
    public String getComplainContent() {
        return complainContent;
    }

    /**
     * @param complainContent 
	 *            投诉内容
     */
    public void setComplainContent(String complainContent) {
        this.complainContent = complainContent == null ? null : complainContent.trim();
    }

    /**
     * @return 处理状态,CRT 待处理,OK# 已处理,NON不处理
     */
    public String getDealStatus() {
        return dealStatus;
    }

    /**
     * @param dealStatus 
	 *            处理状态,CRT 待处理,OK# 已处理,NON不处理
     */
    public void setDealStatus(String dealStatus) {
        this.dealStatus = dealStatus == null ? null : dealStatus.trim();
    }

    /**
     * @return 处理结果
     */
    public String getDealResult() {
        return dealResult;
    }

    /**
     * @param dealResult 
	 *            处理结果
     */
    public void setDealResult(String dealResult) {
        this.dealResult = dealResult == null ? null : dealResult.trim();
    }

    /**
     * @return 处理人
     */
    public String getHandler() {
        return handler;
    }

    /**
     * @param handler 
	 *            处理人
     */
    public void setHandler(String handler) {
        this.handler = handler == null ? null : handler.trim();
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
}