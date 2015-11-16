package com.hummingbird.paas.entity;

import java.util.Date;

/**
 * 投标表
 */
public class BidRecord {
	
	/**
	 * 招标信息
	 */
	private BidObject bo;
	
    /**
     * 主键
     */
    private Integer id;

    /**
     * 标的id
     */
    private String objectId;

    /**
     * 承包商id
     */
    private Integer bidderId;

    /**
     * 项目报价，单位分
     */
    private Integer bidAmount;

    /**
     * 插入时间
     */
    private Date insertTime;

    /**
     * 状态，OK#正常，FLS失败,CRT编制中
     */
    private String status;

    /**
     * 审核时间
     */
    private Date auditTime;

    /**
     * 认证状态,CRT待认证,OK#已认证,FLS认证失败
     */
    private String auditStatus;

    /**
     * 审核人
     */
    private Integer auditor;

    /**
     * 投标状态,CRT 待定，WIN中标，LOS不中标
     */
    private String bidStatus;

    /**
     * 工程计划时间
     */
    private Date projectStartTime;

    /**
     * 方案简介
     */
    private String projectDescription;

    /**
     * 工程计划结束时间
     */
    private Date projectEndTime;

    /**
     * 投标人项目经理
     */
    private String pmCertificationNo;

    /**
     * 投标人建造师
     */
    private String constructorCertificationNo;

    /**
     * 安全生产许可证
     */
    private String safetyPermitNo;

    /**
     * 项目经理安全生产考核合格证
     */
    private String pmSafetyCertificationNo;

    /**
     * 投标人项目经理附件
     */
    private String pmCertificationUrl;

    /**
     * 投标人建造师附件
     */
    private String constructorCertificationUrl;

    /**
     * 安全生产许可证附件
     */
    private String safetyPermitUrl;

    /**
     * 项目经理安全生产考核合格证附件
     */
    private String pmSafetyCertificationUrl;

    /**
     * 投标人项目经理有效期
     */
    private Date pmCertificationEndtime;

    /**
     * 投标人建造师有效期
     */
    private Date constructorCertificationEndtime;

    /**
     * 安全生产许可证有效期
     */
    private Date safetyPermitEndtime;

    /**
     * 项目经理安全生产考核合格证有效期
     */
    private Date pmSafetyCertificationEndtime;

    /**
     * 保函编号
     */
    private String bankGuaranteeNo;

    /**
     * 保函附件
     */
    private String bankGuaranteeUrl;

    /**
     * 保函金额,单位为分
     */
    private Integer bankGuaranteeAmount;

    /**
     * 项目报价表
     */
    private String projectQuotationUrl;

    /**
     * 施工承诺函
     */
    private String constructionCommitmentUrl;

    /**
     * 施工完成时间
     */
    private String constructionEndDate;

    /**
     * 施工开始时间
     */
    private String constructionStartDate;

    /**
     * 技术标附件
     */
    private String technicalStandardUrl;

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
     * @return 标的id
     */
    public String getObjectId() {
        return objectId;
    }

    /**
     * @param objectId 
	 *            标的id
     */
    public void setObjectId(String objectId) {
        this.objectId = objectId == null ? null : objectId.trim();
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
     * @return 项目报价，单位分
     */
    public Integer getBidAmount() {
        return bidAmount;
    }

    /**
     * @param bidAmount 
	 *            项目报价，单位分
     */
    public void setBidAmount(Integer bidAmount) {
        this.bidAmount = bidAmount;
    }

    /**
     * @return 插入时间
     */
    public Date getInsertTime() {
        return insertTime;
    }

    /**
     * @param insertTime 
	 *            插入时间
     */
    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }

    /**
     * @return 状态，OK#正常，FLS失败,CRT编制中
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status 
	 *            状态，OK#正常，FLS失败,CRT编制中
     */
    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    /**
     * @return 审核时间
     */
    public Date getAuditTime() {
        return auditTime;
    }

    /**
     * @param auditTime 
	 *            审核时间
     */
    public void setAuditTime(Date auditTime) {
        this.auditTime = auditTime;
    }

    /**
     * @return 认证状态,CRT待认证,OK#已认证,FLS认证失败
     */
    public String getAuditStatus() {
        return auditStatus;
    }

    /**
     * @param auditStatus 
	 *            认证状态,CRT待认证,OK#已认证,FLS认证失败
     */
    public void setAuditStatus(String auditStatus) {
        this.auditStatus = auditStatus == null ? null : auditStatus.trim();
    }

    /**
     * @return 审核人
     */
    public Integer getAuditor() {
        return auditor;
    }

    /**
     * @param auditor 
	 *            审核人
     */
    public void setAuditor(Integer auditor) {
        this.auditor = auditor;
    }

    /**
     * @return 投标状态,CRT 待定，WIN中标，LOS不中标
     */
    public String getBidStatus() {
        return bidStatus;
    }

    /**
     * @param bidStatus 
	 *            投标状态,CRT 待定，WIN中标，LOS不中标
     */
    public void setBidStatus(String bidStatus) {
        this.bidStatus = bidStatus == null ? null : bidStatus.trim();
    }

    /**
     * @return 工程计划时间
     */
    public Date getProjectStartTime() {
        return projectStartTime;
    }

    /**
     * @param projectStartTime 
	 *            工程计划时间
     */
    public void setProjectStartTime(Date projectStartTime) {
        this.projectStartTime = projectStartTime;
    }

    /**
     * @return 方案简介
     */
    public String getProjectDescription() {
        return projectDescription;
    }

    /**
     * @param projectDescription 
	 *            方案简介
     */
    public void setProjectDescription(String projectDescription) {
        this.projectDescription = projectDescription == null ? null : projectDescription.trim();
    }

    /**
     * @return 工程计划结束时间
     */
    public Date getProjectEndTime() {
        return projectEndTime;
    }

    /**
     * @param projectEndTime 
	 *            工程计划结束时间
     */
    public void setProjectEndTime(Date projectEndTime) {
        this.projectEndTime = projectEndTime;
    }

    /**
     * @return 投标人项目经理
     */
    public String getPmCertificationNo() {
        return pmCertificationNo;
    }

    /**
     * @param pmCertificationNo 
	 *            投标人项目经理
     */
    public void setPmCertificationNo(String pmCertificationNo) {
        this.pmCertificationNo = pmCertificationNo == null ? null : pmCertificationNo.trim();
    }

    /**
     * @return 投标人建造师
     */
    public String getConstructorCertificationNo() {
        return constructorCertificationNo;
    }

    /**
     * @param constructorCertificationNo 
	 *            投标人建造师
     */
    public void setConstructorCertificationNo(String constructorCertificationNo) {
        this.constructorCertificationNo = constructorCertificationNo == null ? null : constructorCertificationNo.trim();
    }

    /**
     * @return 安全生产许可证
     */
    public String getSafetyPermitNo() {
        return safetyPermitNo;
    }

    /**
     * @param safetyPermitNo 
	 *            安全生产许可证
     */
    public void setSafetyPermitNo(String safetyPermitNo) {
        this.safetyPermitNo = safetyPermitNo == null ? null : safetyPermitNo.trim();
    }

    /**
     * @return 项目经理安全生产考核合格证
     */
    public String getPmSafetyCertificationNo() {
        return pmSafetyCertificationNo;
    }

    /**
     * @param pmSafetyCertificationNo 
	 *            项目经理安全生产考核合格证
     */
    public void setPmSafetyCertificationNo(String pmSafetyCertificationNo) {
        this.pmSafetyCertificationNo = pmSafetyCertificationNo == null ? null : pmSafetyCertificationNo.trim();
    }

    /**
     * @return 投标人项目经理附件
     */
    public String getPmCertificationUrl() {
        return pmCertificationUrl;
    }

    /**
     * @param pmCertificationUrl 
	 *            投标人项目经理附件
     */
    public void setPmCertificationUrl(String pmCertificationUrl) {
        this.pmCertificationUrl = pmCertificationUrl == null ? null : pmCertificationUrl.trim();
    }

    /**
     * @return 投标人建造师附件
     */
    public String getConstructorCertificationUrl() {
        return constructorCertificationUrl;
    }

    /**
     * @param constructorCertificationUrl 
	 *            投标人建造师附件
     */
    public void setConstructorCertificationUrl(String constructorCertificationUrl) {
        this.constructorCertificationUrl = constructorCertificationUrl == null ? null : constructorCertificationUrl.trim();
    }

    /**
     * @return 安全生产许可证附件
     */
    public String getSafetyPermitUrl() {
        return safetyPermitUrl;
    }

    /**
     * @param safetyPermitUrl 
	 *            安全生产许可证附件
     */
    public void setSafetyPermitUrl(String safetyPermitUrl) {
        this.safetyPermitUrl = safetyPermitUrl == null ? null : safetyPermitUrl.trim();
    }

    /**
     * @return 项目经理安全生产考核合格证附件
     */
    public String getPmSafetyCertificationUrl() {
        return pmSafetyCertificationUrl;
    }

    /**
     * @param pmSafetyCertificationUrl 
	 *            项目经理安全生产考核合格证附件
     */
    public void setPmSafetyCertificationUrl(String pmSafetyCertificationUrl) {
        this.pmSafetyCertificationUrl = pmSafetyCertificationUrl == null ? null : pmSafetyCertificationUrl.trim();
    }

    /**
     * @return 投标人项目经理有效期
     */
    public Date getPmCertificationEndtime() {
        return pmCertificationEndtime;
    }

    /**
     * @param pmCertificationEndtime 
	 *            投标人项目经理有效期
     */
    public void setPmCertificationEndtime(Date pmCertificationEndtime) {
        this.pmCertificationEndtime = pmCertificationEndtime;
    }

    /**
     * @return 投标人建造师有效期
     */
    public Date getConstructorCertificationEndtime() {
        return constructorCertificationEndtime;
    }

    /**
     * @param constructorCertificationEndtime 
	 *            投标人建造师有效期
     */
    public void setConstructorCertificationEndtime(Date constructorCertificationEndtime) {
        this.constructorCertificationEndtime = constructorCertificationEndtime;
    }

    /**
     * @return 安全生产许可证有效期
     */
    public Date getSafetyPermitEndtime() {
        return safetyPermitEndtime;
    }

    /**
     * @param safetyPermitEndtime 
	 *            安全生产许可证有效期
     */
    public void setSafetyPermitEndtime(Date safetyPermitEndtime) {
        this.safetyPermitEndtime = safetyPermitEndtime;
    }

    /**
     * @return 项目经理安全生产考核合格证有效期
     */
    public Date getPmSafetyCertificationEndtime() {
        return pmSafetyCertificationEndtime;
    }

    /**
     * @param pmSafetyCertificationEndtime 
	 *            项目经理安全生产考核合格证有效期
     */
    public void setPmSafetyCertificationEndtime(Date pmSafetyCertificationEndtime) {
        this.pmSafetyCertificationEndtime = pmSafetyCertificationEndtime;
    }

    /**
     * @return 保函编号
     */
    public String getBankGuaranteeNo() {
        return bankGuaranteeNo;
    }

    /**
     * @param bankGuaranteeNo 
	 *            保函编号
     */
    public void setBankGuaranteeNo(String bankGuaranteeNo) {
        this.bankGuaranteeNo = bankGuaranteeNo == null ? null : bankGuaranteeNo.trim();
    }

    /**
     * @return 保函附件
     */
    public String getBankGuaranteeUrl() {
        return bankGuaranteeUrl;
    }

    /**
     * @param bankGuaranteeUrl 
	 *            保函附件
     */
    public void setBankGuaranteeUrl(String bankGuaranteeUrl) {
        this.bankGuaranteeUrl = bankGuaranteeUrl == null ? null : bankGuaranteeUrl.trim();
    }

    /**
     * @return 保函金额,单位为分
     */
    public Integer getBankGuaranteeAmount() {
        return bankGuaranteeAmount;
    }

    /**
     * @param bankGuaranteeAmount 
	 *            保函金额,单位为分
     */
    public void setBankGuaranteeAmount(Integer bankGuaranteeAmount) {
        this.bankGuaranteeAmount = bankGuaranteeAmount;
    }

    /**
     * @return 项目报价表
     */
    public String getProjectQuotationUrl() {
        return projectQuotationUrl;
    }

    /**
     * @param projectQuotationUrl 
	 *            项目报价表
     */
    public void setProjectQuotationUrl(String projectQuotationUrl) {
        this.projectQuotationUrl = projectQuotationUrl == null ? null : projectQuotationUrl.trim();
    }

    /**
     * @return 施工承诺函
     */
    public String getConstructionCommitmentUrl() {
        return constructionCommitmentUrl;
    }

    /**
     * @param constructionCommitmentUrl 
	 *            施工承诺函
     */
    public void setConstructionCommitmentUrl(String constructionCommitmentUrl) {
        this.constructionCommitmentUrl = constructionCommitmentUrl == null ? null : constructionCommitmentUrl.trim();
    }

    /**
     * @return 施工完成时间
     */
    public String getConstructionEndDate() {
        return constructionEndDate;
    }

    /**
     * @param constructionEndDate 
	 *            施工完成时间
     */
    public void setConstructionEndDate(String constructionEndDate) {
        this.constructionEndDate = constructionEndDate == null ? null : constructionEndDate.trim();
    }

    /**
     * @return 施工开始时间
     */
    public String getConstructionStartDate() {
        return constructionStartDate;
    }

    /**
     * @param constructionStartDate 
	 *            施工开始时间
     */
    public void setConstructionStartDate(String constructionStartDate) {
        this.constructionStartDate = constructionStartDate == null ? null : constructionStartDate.trim();
    }

    /**
     * @return 技术标附件
     */
    public String getTechnicalStandardUrl() {
        return technicalStandardUrl;
    }

    /**
     * @param technicalStandardUrl 
	 *            技术标附件
     */
    public void setTechnicalStandardUrl(String technicalStandardUrl) {
        this.technicalStandardUrl = technicalStandardUrl == null ? null : technicalStandardUrl.trim();
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
        BidRecord other = (BidRecord) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getObjectId() == null ? other.getObjectId() == null : this.getObjectId().equals(other.getObjectId()))
            && (this.getBidderId() == null ? other.getBidderId() == null : this.getBidderId().equals(other.getBidderId()))
            && (this.getBidAmount() == null ? other.getBidAmount() == null : this.getBidAmount().equals(other.getBidAmount()))
            && (this.getInsertTime() == null ? other.getInsertTime() == null : this.getInsertTime().equals(other.getInsertTime()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getAuditTime() == null ? other.getAuditTime() == null : this.getAuditTime().equals(other.getAuditTime()))
            && (this.getAuditStatus() == null ? other.getAuditStatus() == null : this.getAuditStatus().equals(other.getAuditStatus()))
            && (this.getAuditor() == null ? other.getAuditor() == null : this.getAuditor().equals(other.getAuditor()))
            && (this.getBidStatus() == null ? other.getBidStatus() == null : this.getBidStatus().equals(other.getBidStatus()))
            && (this.getProjectStartTime() == null ? other.getProjectStartTime() == null : this.getProjectStartTime().equals(other.getProjectStartTime()))
            && (this.getProjectDescription() == null ? other.getProjectDescription() == null : this.getProjectDescription().equals(other.getProjectDescription()))
            && (this.getProjectEndTime() == null ? other.getProjectEndTime() == null : this.getProjectEndTime().equals(other.getProjectEndTime()))
            && (this.getPmCertificationNo() == null ? other.getPmCertificationNo() == null : this.getPmCertificationNo().equals(other.getPmCertificationNo()))
            && (this.getConstructorCertificationNo() == null ? other.getConstructorCertificationNo() == null : this.getConstructorCertificationNo().equals(other.getConstructorCertificationNo()))
            && (this.getSafetyPermitNo() == null ? other.getSafetyPermitNo() == null : this.getSafetyPermitNo().equals(other.getSafetyPermitNo()))
            && (this.getPmSafetyCertificationNo() == null ? other.getPmSafetyCertificationNo() == null : this.getPmSafetyCertificationNo().equals(other.getPmSafetyCertificationNo()))
            && (this.getPmCertificationUrl() == null ? other.getPmCertificationUrl() == null : this.getPmCertificationUrl().equals(other.getPmCertificationUrl()))
            && (this.getConstructorCertificationUrl() == null ? other.getConstructorCertificationUrl() == null : this.getConstructorCertificationUrl().equals(other.getConstructorCertificationUrl()))
            && (this.getSafetyPermitUrl() == null ? other.getSafetyPermitUrl() == null : this.getSafetyPermitUrl().equals(other.getSafetyPermitUrl()))
            && (this.getPmSafetyCertificationUrl() == null ? other.getPmSafetyCertificationUrl() == null : this.getPmSafetyCertificationUrl().equals(other.getPmSafetyCertificationUrl()))
            && (this.getPmCertificationEndtime() == null ? other.getPmCertificationEndtime() == null : this.getPmCertificationEndtime().equals(other.getPmCertificationEndtime()))
            && (this.getConstructorCertificationEndtime() == null ? other.getConstructorCertificationEndtime() == null : this.getConstructorCertificationEndtime().equals(other.getConstructorCertificationEndtime()))
            && (this.getSafetyPermitEndtime() == null ? other.getSafetyPermitEndtime() == null : this.getSafetyPermitEndtime().equals(other.getSafetyPermitEndtime()))
            && (this.getPmSafetyCertificationEndtime() == null ? other.getPmSafetyCertificationEndtime() == null : this.getPmSafetyCertificationEndtime().equals(other.getPmSafetyCertificationEndtime()))
            && (this.getBankGuaranteeNo() == null ? other.getBankGuaranteeNo() == null : this.getBankGuaranteeNo().equals(other.getBankGuaranteeNo()))
            && (this.getBankGuaranteeUrl() == null ? other.getBankGuaranteeUrl() == null : this.getBankGuaranteeUrl().equals(other.getBankGuaranteeUrl()))
            && (this.getBankGuaranteeAmount() == null ? other.getBankGuaranteeAmount() == null : this.getBankGuaranteeAmount().equals(other.getBankGuaranteeAmount()))
            && (this.getProjectQuotationUrl() == null ? other.getProjectQuotationUrl() == null : this.getProjectQuotationUrl().equals(other.getProjectQuotationUrl()))
            && (this.getConstructionCommitmentUrl() == null ? other.getConstructionCommitmentUrl() == null : this.getConstructionCommitmentUrl().equals(other.getConstructionCommitmentUrl()))
            && (this.getConstructionEndDate() == null ? other.getConstructionEndDate() == null : this.getConstructionEndDate().equals(other.getConstructionEndDate()))
            && (this.getConstructionStartDate() == null ? other.getConstructionStartDate() == null : this.getConstructionStartDate().equals(other.getConstructionStartDate()))
            && (this.getTechnicalStandardUrl() == null ? other.getTechnicalStandardUrl() == null : this.getTechnicalStandardUrl().equals(other.getTechnicalStandardUrl()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getObjectId() == null) ? 0 : getObjectId().hashCode());
        result = prime * result + ((getBidderId() == null) ? 0 : getBidderId().hashCode());
        result = prime * result + ((getBidAmount() == null) ? 0 : getBidAmount().hashCode());
        result = prime * result + ((getInsertTime() == null) ? 0 : getInsertTime().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getAuditTime() == null) ? 0 : getAuditTime().hashCode());
        result = prime * result + ((getAuditStatus() == null) ? 0 : getAuditStatus().hashCode());
        result = prime * result + ((getAuditor() == null) ? 0 : getAuditor().hashCode());
        result = prime * result + ((getBidStatus() == null) ? 0 : getBidStatus().hashCode());
        result = prime * result + ((getProjectStartTime() == null) ? 0 : getProjectStartTime().hashCode());
        result = prime * result + ((getProjectDescription() == null) ? 0 : getProjectDescription().hashCode());
        result = prime * result + ((getProjectEndTime() == null) ? 0 : getProjectEndTime().hashCode());
        result = prime * result + ((getPmCertificationNo() == null) ? 0 : getPmCertificationNo().hashCode());
        result = prime * result + ((getConstructorCertificationNo() == null) ? 0 : getConstructorCertificationNo().hashCode());
        result = prime * result + ((getSafetyPermitNo() == null) ? 0 : getSafetyPermitNo().hashCode());
        result = prime * result + ((getPmSafetyCertificationNo() == null) ? 0 : getPmSafetyCertificationNo().hashCode());
        result = prime * result + ((getPmCertificationUrl() == null) ? 0 : getPmCertificationUrl().hashCode());
        result = prime * result + ((getConstructorCertificationUrl() == null) ? 0 : getConstructorCertificationUrl().hashCode());
        result = prime * result + ((getSafetyPermitUrl() == null) ? 0 : getSafetyPermitUrl().hashCode());
        result = prime * result + ((getPmSafetyCertificationUrl() == null) ? 0 : getPmSafetyCertificationUrl().hashCode());
        result = prime * result + ((getPmCertificationEndtime() == null) ? 0 : getPmCertificationEndtime().hashCode());
        result = prime * result + ((getConstructorCertificationEndtime() == null) ? 0 : getConstructorCertificationEndtime().hashCode());
        result = prime * result + ((getSafetyPermitEndtime() == null) ? 0 : getSafetyPermitEndtime().hashCode());
        result = prime * result + ((getPmSafetyCertificationEndtime() == null) ? 0 : getPmSafetyCertificationEndtime().hashCode());
        result = prime * result + ((getBankGuaranteeNo() == null) ? 0 : getBankGuaranteeNo().hashCode());
        result = prime * result + ((getBankGuaranteeUrl() == null) ? 0 : getBankGuaranteeUrl().hashCode());
        result = prime * result + ((getBankGuaranteeAmount() == null) ? 0 : getBankGuaranteeAmount().hashCode());
        result = prime * result + ((getProjectQuotationUrl() == null) ? 0 : getProjectQuotationUrl().hashCode());
        result = prime * result + ((getConstructionCommitmentUrl() == null) ? 0 : getConstructionCommitmentUrl().hashCode());
        result = prime * result + ((getConstructionEndDate() == null) ? 0 : getConstructionEndDate().hashCode());
        result = prime * result + ((getConstructionStartDate() == null) ? 0 : getConstructionStartDate().hashCode());
        result = prime * result + ((getTechnicalStandardUrl() == null) ? 0 : getTechnicalStandardUrl().hashCode());
        return result;
    }

	/**
	 * 招标信息 
	 */
	public BidObject getBo() {
		return bo;
	}

	/**
	 * 招标信息 
	 */
	public void setBo(BidObject bo) {
		this.bo = bo;
	}
}