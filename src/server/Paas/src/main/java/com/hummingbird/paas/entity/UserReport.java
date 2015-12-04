package com.hummingbird.paas.entity;

import java.util.Date;

/**
 * 用户举报表,主要是用户举报信息有问题<br>
	 * 
 */
public class UserReport {
    private Integer id;

    /**
     * 用户id
     */
    private Integer userId;

    /**
     * 举报信息类别,TER 招标
     */
    private String refType;

    /**
     * 举报信息id
     */
    private String refId;

    /**
     * 举报内容类别,UTT 虚假招标信息
     */
    private String reportType;

    /**
     * 举报内容
     */
    private String reportContent;

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
     * @return 举报信息类别,TER 招标
     */
    public String getRefType() {
        return refType;
    }

    /**
     * @param refType 
	 *            举报信息类别,TER 招标
     */
    public void setRefType(String refType) {
        this.refType = refType == null ? null : refType.trim();
    }

    /**
     * @return 举报信息id
     */
    public String getRefId() {
        return refId;
    }

    /**
     * @param refId 
	 *            举报信息id
     */
    public void setRefId(String refId) {
        this.refId = refId == null ? null : refId.trim();
    }

    /**
     * @return 举报内容类别,UTT 虚假招标信息
     */
    public String getReportType() {
        return reportType;
    }

    /**
     * @param reportType 
	 *            举报内容类别,UTT 虚假招标信息
     */
    public void setReportType(String reportType) {
        this.reportType = reportType == null ? null : reportType.trim();
    }

    /**
     * @return 举报内容
     */
    public String getReportContent() {
        return reportContent;
    }

    /**
     * @param reportContent 
	 *            举报内容
     */
    public void setReportContent(String reportContent) {
        this.reportContent = reportContent == null ? null : reportContent.trim();
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