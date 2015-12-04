package com.hummingbird.paas.entity;

import java.util.Date;

/**
 * 资讯管理,信息发布表,主要是用户发布信息使用
 */
public class UserInformation {
    /**
     * 信息主键
     */
    private Integer id;

    /**
     * 发布人,用userid,需要先验证资质
     */
    private Integer userId;

    /**
     * 地址
     */
    private String address;

    /**
     * 状态,CRT 编写,OK# 发布,DIS 禁用
     */
    private String status;

    /**
     * 新增时间
     */
    private Date insertTime;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 更新人
     */
    private String updator;

    /**
     * 造价
     */
    private String objectAmount;

    /**
     * 地区,直接显示
     */
    private String district;

    /**
     * 工期
     */
    private String projectPeriod;

    /**
     * 概况
     */
    private String projectSituation;

    /**
     * 甲方
     */
    private String employer;

    /**
     * 类型
     */
    private String objectType;

    /**
     * 项目名称
     */
    private String objectName;

    /**
     * 阶段
     */
    private String phase;

    /**
     * 审核状态,CRT 待审核,OK# 审核通过,FLS 审核不通过
     */
    private String auditStatus;

    /**
     * 审核人
     */
    private String auditor;

    /**
     * 审核时间
     */
    private String auditTime;

    /**
     * @return 信息主键
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id 
	 *            信息主键
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return 发布人,用userid,需要先验证资质
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * @param userId 
	 *            发布人,用userid,需要先验证资质
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * @return 地址
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address 
	 *            地址
     */
    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    /**
     * @return 状态,CRT 编写,OK# 发布,DIS 禁用
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status 
	 *            状态,CRT 编写,OK# 发布,DIS 禁用
     */
    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
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

    /**
     * @return 造价
     */
    public String getObjectAmount() {
        return objectAmount;
    }

    /**
     * @param objectAmount 
	 *            造价
     */
    public void setObjectAmount(String objectAmount) {
        this.objectAmount = objectAmount == null ? null : objectAmount.trim();
    }

    /**
     * @return 地区,直接显示
     */
    public String getDistrict() {
        return district;
    }

    /**
     * @param district 
	 *            地区,直接显示
     */
    public void setDistrict(String district) {
        this.district = district == null ? null : district.trim();
    }

    /**
     * @return 工期
     */
    public String getProjectPeriod() {
        return projectPeriod;
    }

    /**
     * @param projectPeriod 
	 *            工期
     */
    public void setProjectPeriod(String projectPeriod) {
        this.projectPeriod = projectPeriod == null ? null : projectPeriod.trim();
    }

    /**
     * @return 概况
     */
    public String getProjectSituation() {
        return projectSituation;
    }

    /**
     * @param projectSituation 
	 *            概况
     */
    public void setProjectSituation(String projectSituation) {
        this.projectSituation = projectSituation == null ? null : projectSituation.trim();
    }

    /**
     * @return 甲方
     */
    public String getEmployer() {
        return employer;
    }

    /**
     * @param employer 
	 *            甲方
     */
    public void setEmployer(String employer) {
        this.employer = employer == null ? null : employer.trim();
    }

    /**
     * @return 类型
     */
    public String getObjectType() {
        return objectType;
    }

    /**
     * @param objectType 
	 *            类型
     */
    public void setObjectType(String objectType) {
        this.objectType = objectType == null ? null : objectType.trim();
    }

    /**
     * @return 项目名称
     */
    public String getObjectName() {
        return objectName;
    }

    /**
     * @param objectName 
	 *            项目名称
     */
    public void setObjectName(String objectName) {
        this.objectName = objectName == null ? null : objectName.trim();
    }

    /**
     * @return 阶段
     */
    public String getPhase() {
        return phase;
    }

    /**
     * @param phase 
	 *            阶段
     */
    public void setPhase(String phase) {
        this.phase = phase == null ? null : phase.trim();
    }

    /**
     * @return 审核状态,CRT 待审核,OK# 审核通过,FLS 审核不通过
     */
    public String getAuditStatus() {
        return auditStatus;
    }

    /**
     * @param auditStatus 
	 *            审核状态,CRT 待审核,OK# 审核通过,FLS 审核不通过
     */
    public void setAuditStatus(String auditStatus) {
        this.auditStatus = auditStatus == null ? null : auditStatus.trim();
    }

    /**
     * @return 审核人
     */
    public String getAuditor() {
        return auditor;
    }

    /**
     * @param auditor 
	 *            审核人
     */
    public void setAuditor(String auditor) {
        this.auditor = auditor == null ? null : auditor.trim();
    }

    /**
     * @return 审核时间
     */
    public String getAuditTime() {
        return auditTime;
    }

    /**
     * @param auditTime 
	 *            审核时间
     */
    public void setAuditTime(String auditTime) {
        this.auditTime = auditTime == null ? null : auditTime.trim();
    }
}