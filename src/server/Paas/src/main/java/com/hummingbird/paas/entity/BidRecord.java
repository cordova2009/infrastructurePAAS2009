package com.hummingbird.paas.entity;

import java.util.Date;

/**
 * 投标表
 */
public class BidRecord {
    /**
     * 主键
     */
    private Integer id;

    /**
     * 标的id
     */
    private String object_id;

    /**
     * 承包商id
     */
    private Integer bidder_id;

    /**
     * 项目报价，单位分
     */
    private Integer bid_amount;

    /**
     * 插入时间
     */
    private Date insert_time;

    /**
     * 状态，OK#正常，FLS失败,CRT编制中
     */
    private String status;

    /**
     * 审核时间
     */
    private Date audit_time;

    /**
     * 认证状态,CRT待认证,OK#已认证,FLS认证失败
     */
    private String audit_status;

    /**
     * 审核人
     */
    private Integer auditor;

    /**
     * 投标状态,CRT 待定，WIN中标，LOS不中标
     */
    private String bid_status;

    /**
     * 工程计划时间
     */
    private Date project_start_time;

    /**
     * 方案简介
     */
    private String project_description;

    /**
     * 工程计划结束时间
     */
    private Date project_end_time;

    /**
     * 投标人项目经理
     */
    private String pm_certification_No;

    /**
     * 投标人建造师
     */
    private String constructor_certification_No;

    /**
     * 安全生产许可证
     */
    private String safety_permit_No;

    /**
     * 项目经理安全生产考核合格证
     */
    private String pm_safety_certification_No;

    /**
     * 投标人项目经理附件
     */
    private String pm_certification_url;

    /**
     * 投标人建造师附件
     */
    private String constructor_certification_url;

    /**
     * 安全生产许可证附件
     */
    private String safety_permit_url;

    /**
     * 项目经理安全生产考核合格证附件
     */
    private String pm_safety_certification_url;

    /**
     * 投标人项目经理有效期
     */
    private Date pm_certification_endtime;

    /**
     * 投标人建造师有效期
     */
    private Date constructor_certification_endtime;

    /**
     * 安全生产许可证有效期
     */
    private Date safety_permit_endtime;

    /**
     * 项目经理安全生产考核合格证有效期
     */
    private Date pm_safety_certification_endtime;

    /**
     * 保函编号
     */
    private String bank_guarantee_No;

    /**
     * 保函附件
     */
    private String bank_guarantee_url;

    /**
     * 保函金额,单位为分
     */
    private Integer bank_guarantee_amount;

    /**
     * 项目报价表
     */
    private String project_quotation_url;

    /**
     * 施工承诺函
     */
    private String construction_commitment_url;

    /**
     * 施工完成时间
     */
    private String construction_end_date;

    /**
     * 施工开始时间
     */
    private String construction_start_date;

    /**
     * 技术标附件
     */
    private String technical_standard_url;

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
    public String getObject_id() {
        return object_id;
    }

    /**
     * @param objectId 
	 *            标的id
     */
    public void setObject_id(String object_id) {
        this.object_id = object_id == null ? null : object_id.trim();
    }

    /**
     * @return 承包商id
     */
    public Integer getBidder_id() {
        return bidder_id;
    }

    /**
     * @param bidderId 
	 *            承包商id
     */
    public void setBidder_id(Integer bidder_id) {
        this.bidder_id = bidder_id;
    }

    /**
     * @return 项目报价，单位分
     */
    public Integer getBid_amount() {
        return bid_amount;
    }

    /**
     * @param bidAmount 
	 *            项目报价，单位分
     */
    public void setBid_amount(Integer bid_amount) {
        this.bid_amount = bid_amount;
    }

    /**
     * @return 插入时间
     */
    public Date getInsert_time() {
        return insert_time;
    }

    /**
     * @param insertTime 
	 *            插入时间
     */
    public void setInsert_time(Date insert_time) {
        this.insert_time = insert_time;
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
    public Date getAudit_time() {
        return audit_time;
    }

    /**
     * @param auditTime 
	 *            审核时间
     */
    public void setAudit_time(Date audit_time) {
        this.audit_time = audit_time;
    }

    /**
     * @return 认证状态,CRT待认证,OK#已认证,FLS认证失败
     */
    public String getAudit_status() {
        return audit_status;
    }

    /**
     * @param auditStatus 
	 *            认证状态,CRT待认证,OK#已认证,FLS认证失败
     */
    public void setAudit_status(String audit_status) {
        this.audit_status = audit_status == null ? null : audit_status.trim();
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
    public String getBid_status() {
        return bid_status;
    }

    /**
     * @param bidStatus 
	 *            投标状态,CRT 待定，WIN中标，LOS不中标
     */
    public void setBid_status(String bid_status) {
        this.bid_status = bid_status == null ? null : bid_status.trim();
    }

    /**
     * @return 工程计划时间
     */
    public Date getProject_start_time() {
        return project_start_time;
    }

    /**
     * @param projectStartTime 
	 *            工程计划时间
     */
    public void setProject_start_time(Date project_start_time) {
        this.project_start_time = project_start_time;
    }

    /**
     * @return 方案简介
     */
    public String getProject_description() {
        return project_description;
    }

    /**
     * @param projectDescription 
	 *            方案简介
     */
    public void setProject_description(String project_description) {
        this.project_description = project_description == null ? null : project_description.trim();
    }

    /**
     * @return 工程计划结束时间
     */
    public Date getProject_end_time() {
        return project_end_time;
    }

    /**
     * @param projectEndTime 
	 *            工程计划结束时间
     */
    public void setProject_end_time(Date project_end_time) {
        this.project_end_time = project_end_time;
    }

    /**
     * @return 投标人项目经理
     */
    public String getPm_certification_No() {
        return pm_certification_No;
    }

    /**
     * @param pmCertificationNo 
	 *            投标人项目经理
     */
    public void setPm_certification_No(String pm_certification_No) {
        this.pm_certification_No = pm_certification_No == null ? null : pm_certification_No.trim();
    }

    /**
     * @return 投标人建造师
     */
    public String getConstructor_certification_No() {
        return constructor_certification_No;
    }

    /**
     * @param constructorCertificationNo 
	 *            投标人建造师
     */
    public void setConstructor_certification_No(String constructor_certification_No) {
        this.constructor_certification_No = constructor_certification_No == null ? null : constructor_certification_No.trim();
    }

    /**
     * @return 安全生产许可证
     */
    public String getSafety_permit_No() {
        return safety_permit_No;
    }

    /**
     * @param safetyPermitNo 
	 *            安全生产许可证
     */
    public void setSafety_permit_No(String safety_permit_No) {
        this.safety_permit_No = safety_permit_No == null ? null : safety_permit_No.trim();
    }

    /**
     * @return 项目经理安全生产考核合格证
     */
    public String getPm_safety_certification_No() {
        return pm_safety_certification_No;
    }

    /**
     * @param pmSafetyCertificationNo 
	 *            项目经理安全生产考核合格证
     */
    public void setPm_safety_certification_No(String pm_safety_certification_No) {
        this.pm_safety_certification_No = pm_safety_certification_No == null ? null : pm_safety_certification_No.trim();
    }

    /**
     * @return 投标人项目经理附件
     */
    public String getPm_certification_url() {
        return pm_certification_url;
    }

    /**
     * @param pmCertificationUrl 
	 *            投标人项目经理附件
     */
    public void setPm_certification_url(String pm_certification_url) {
        this.pm_certification_url = pm_certification_url == null ? null : pm_certification_url.trim();
    }

    /**
     * @return 投标人建造师附件
     */
    public String getConstructor_certification_url() {
        return constructor_certification_url;
    }

    /**
     * @param constructorCertificationUrl 
	 *            投标人建造师附件
     */
    public void setConstructor_certification_url(String constructor_certification_url) {
        this.constructor_certification_url = constructor_certification_url == null ? null : constructor_certification_url.trim();
    }

    /**
     * @return 安全生产许可证附件
     */
    public String getSafety_permit_url() {
        return safety_permit_url;
    }

    /**
     * @param safetyPermitUrl 
	 *            安全生产许可证附件
     */
    public void setSafety_permit_url(String safety_permit_url) {
        this.safety_permit_url = safety_permit_url == null ? null : safety_permit_url.trim();
    }

    /**
     * @return 项目经理安全生产考核合格证附件
     */
    public String getPm_safety_certification_url() {
        return pm_safety_certification_url;
    }

    /**
     * @param pmSafetyCertificationUrl 
	 *            项目经理安全生产考核合格证附件
     */
    public void setPm_safety_certification_url(String pm_safety_certification_url) {
        this.pm_safety_certification_url = pm_safety_certification_url == null ? null : pm_safety_certification_url.trim();
    }

    /**
     * @return 投标人项目经理有效期
     */
    public Date getPm_certification_endtime() {
        return pm_certification_endtime;
    }

    /**
     * @param pmCertificationEndtime 
	 *            投标人项目经理有效期
     */
    public void setPm_certification_endtime(Date pm_certification_endtime) {
        this.pm_certification_endtime = pm_certification_endtime;
    }

    /**
     * @return 投标人建造师有效期
     */
    public Date getConstructor_certification_endtime() {
        return constructor_certification_endtime;
    }

    /**
     * @param constructorCertificationEndtime 
	 *            投标人建造师有效期
     */
    public void setConstructor_certification_endtime(Date constructor_certification_endtime) {
        this.constructor_certification_endtime = constructor_certification_endtime;
    }

    /**
     * @return 安全生产许可证有效期
     */
    public Date getSafety_permit_endtime() {
        return safety_permit_endtime;
    }

    /**
     * @param safetyPermitEndtime 
	 *            安全生产许可证有效期
     */
    public void setSafety_permit_endtime(Date safety_permit_endtime) {
        this.safety_permit_endtime = safety_permit_endtime;
    }

    /**
     * @return 项目经理安全生产考核合格证有效期
     */
    public Date getPm_safety_certification_endtime() {
        return pm_safety_certification_endtime;
    }

    /**
     * @param pmSafetyCertificationEndtime 
	 *            项目经理安全生产考核合格证有效期
     */
    public void setPm_safety_certification_endtime(Date pm_safety_certification_endtime) {
        this.pm_safety_certification_endtime = pm_safety_certification_endtime;
    }

    /**
     * @return 保函编号
     */
    public String getBank_guarantee_No() {
        return bank_guarantee_No;
    }

    /**
     * @param bankGuaranteeNo 
	 *            保函编号
     */
    public void setBank_guarantee_No(String bank_guarantee_No) {
        this.bank_guarantee_No = bank_guarantee_No == null ? null : bank_guarantee_No.trim();
    }

    /**
     * @return 保函附件
     */
    public String getBank_guarantee_url() {
        return bank_guarantee_url;
    }

    /**
     * @param bankGuaranteeUrl 
	 *            保函附件
     */
    public void setBank_guarantee_url(String bank_guarantee_url) {
        this.bank_guarantee_url = bank_guarantee_url == null ? null : bank_guarantee_url.trim();
    }

    /**
     * @return 保函金额,单位为分
     */
    public Integer getBank_guarantee_amount() {
        return bank_guarantee_amount;
    }

    /**
     * @param bankGuaranteeAmount 
	 *            保函金额,单位为分
     */
    public void setBank_guarantee_amount(Integer bank_guarantee_amount) {
        this.bank_guarantee_amount = bank_guarantee_amount;
    }

    /**
     * @return 项目报价表
     */
    public String getProject_quotation_url() {
        return project_quotation_url;
    }

    /**
     * @param projectQuotationUrl 
	 *            项目报价表
     */
    public void setProject_quotation_url(String project_quotation_url) {
        this.project_quotation_url = project_quotation_url == null ? null : project_quotation_url.trim();
    }

    /**
     * @return 施工承诺函
     */
    public String getConstruction_commitment_url() {
        return construction_commitment_url;
    }

    /**
     * @param constructionCommitmentUrl 
	 *            施工承诺函
     */
    public void setConstruction_commitment_url(String construction_commitment_url) {
        this.construction_commitment_url = construction_commitment_url == null ? null : construction_commitment_url.trim();
    }

    /**
     * @return 施工完成时间
     */
    public String getConstruction_end_date() {
        return construction_end_date;
    }

    /**
     * @param constructionEndDate 
	 *            施工完成时间
     */
    public void setConstruction_end_date(String construction_end_date) {
        this.construction_end_date = construction_end_date == null ? null : construction_end_date.trim();
    }

    /**
     * @return 施工开始时间
     */
    public String getConstruction_start_date() {
        return construction_start_date;
    }

    /**
     * @param constructionStartDate 
	 *            施工开始时间
     */
    public void setConstruction_start_date(String construction_start_date) {
        this.construction_start_date = construction_start_date == null ? null : construction_start_date.trim();
    }

    /**
     * @return 技术标附件
     */
    public String getTechnical_standard_url() {
        return technical_standard_url;
    }

    /**
     * @param technicalStandardUrl 
	 *            技术标附件
     */
    public void setTechnical_standard_url(String technical_standard_url) {
        this.technical_standard_url = technical_standard_url == null ? null : technical_standard_url.trim();
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
            && (this.getObject_id() == null ? other.getObject_id() == null : this.getObject_id().equals(other.getObject_id()))
            && (this.getBidder_id() == null ? other.getBidder_id() == null : this.getBidder_id().equals(other.getBidder_id()))
            && (this.getBid_amount() == null ? other.getBid_amount() == null : this.getBid_amount().equals(other.getBid_amount()))
            && (this.getInsert_time() == null ? other.getInsert_time() == null : this.getInsert_time().equals(other.getInsert_time()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getAudit_time() == null ? other.getAudit_time() == null : this.getAudit_time().equals(other.getAudit_time()))
            && (this.getAudit_status() == null ? other.getAudit_status() == null : this.getAudit_status().equals(other.getAudit_status()))
            && (this.getAuditor() == null ? other.getAuditor() == null : this.getAuditor().equals(other.getAuditor()))
            && (this.getBid_status() == null ? other.getBid_status() == null : this.getBid_status().equals(other.getBid_status()))
            && (this.getProject_start_time() == null ? other.getProject_start_time() == null : this.getProject_start_time().equals(other.getProject_start_time()))
            && (this.getProject_description() == null ? other.getProject_description() == null : this.getProject_description().equals(other.getProject_description()))
            && (this.getProject_end_time() == null ? other.getProject_end_time() == null : this.getProject_end_time().equals(other.getProject_end_time()))
            && (this.getPm_certification_No() == null ? other.getPm_certification_No() == null : this.getPm_certification_No().equals(other.getPm_certification_No()))
            && (this.getConstructor_certification_No() == null ? other.getConstructor_certification_No() == null : this.getConstructor_certification_No().equals(other.getConstructor_certification_No()))
            && (this.getSafety_permit_No() == null ? other.getSafety_permit_No() == null : this.getSafety_permit_No().equals(other.getSafety_permit_No()))
            && (this.getPm_safety_certification_No() == null ? other.getPm_safety_certification_No() == null : this.getPm_safety_certification_No().equals(other.getPm_safety_certification_No()))
            && (this.getPm_certification_url() == null ? other.getPm_certification_url() == null : this.getPm_certification_url().equals(other.getPm_certification_url()))
            && (this.getConstructor_certification_url() == null ? other.getConstructor_certification_url() == null : this.getConstructor_certification_url().equals(other.getConstructor_certification_url()))
            && (this.getSafety_permit_url() == null ? other.getSafety_permit_url() == null : this.getSafety_permit_url().equals(other.getSafety_permit_url()))
            && (this.getPm_safety_certification_url() == null ? other.getPm_safety_certification_url() == null : this.getPm_safety_certification_url().equals(other.getPm_safety_certification_url()))
            && (this.getPm_certification_endtime() == null ? other.getPm_certification_endtime() == null : this.getPm_certification_endtime().equals(other.getPm_certification_endtime()))
            && (this.getConstructor_certification_endtime() == null ? other.getConstructor_certification_endtime() == null : this.getConstructor_certification_endtime().equals(other.getConstructor_certification_endtime()))
            && (this.getSafety_permit_endtime() == null ? other.getSafety_permit_endtime() == null : this.getSafety_permit_endtime().equals(other.getSafety_permit_endtime()))
            && (this.getPm_safety_certification_endtime() == null ? other.getPm_safety_certification_endtime() == null : this.getPm_safety_certification_endtime().equals(other.getPm_safety_certification_endtime()))
            && (this.getBank_guarantee_No() == null ? other.getBank_guarantee_No() == null : this.getBank_guarantee_No().equals(other.getBank_guarantee_No()))
            && (this.getBank_guarantee_url() == null ? other.getBank_guarantee_url() == null : this.getBank_guarantee_url().equals(other.getBank_guarantee_url()))
            && (this.getBank_guarantee_amount() == null ? other.getBank_guarantee_amount() == null : this.getBank_guarantee_amount().equals(other.getBank_guarantee_amount()))
            && (this.getProject_quotation_url() == null ? other.getProject_quotation_url() == null : this.getProject_quotation_url().equals(other.getProject_quotation_url()))
            && (this.getConstruction_commitment_url() == null ? other.getConstruction_commitment_url() == null : this.getConstruction_commitment_url().equals(other.getConstruction_commitment_url()))
            && (this.getConstruction_end_date() == null ? other.getConstruction_end_date() == null : this.getConstruction_end_date().equals(other.getConstruction_end_date()))
            && (this.getConstruction_start_date() == null ? other.getConstruction_start_date() == null : this.getConstruction_start_date().equals(other.getConstruction_start_date()))
            && (this.getTechnical_standard_url() == null ? other.getTechnical_standard_url() == null : this.getTechnical_standard_url().equals(other.getTechnical_standard_url()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getObject_id() == null) ? 0 : getObject_id().hashCode());
        result = prime * result + ((getBidder_id() == null) ? 0 : getBidder_id().hashCode());
        result = prime * result + ((getBid_amount() == null) ? 0 : getBid_amount().hashCode());
        result = prime * result + ((getInsert_time() == null) ? 0 : getInsert_time().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getAudit_time() == null) ? 0 : getAudit_time().hashCode());
        result = prime * result + ((getAudit_status() == null) ? 0 : getAudit_status().hashCode());
        result = prime * result + ((getAuditor() == null) ? 0 : getAuditor().hashCode());
        result = prime * result + ((getBid_status() == null) ? 0 : getBid_status().hashCode());
        result = prime * result + ((getProject_start_time() == null) ? 0 : getProject_start_time().hashCode());
        result = prime * result + ((getProject_description() == null) ? 0 : getProject_description().hashCode());
        result = prime * result + ((getProject_end_time() == null) ? 0 : getProject_end_time().hashCode());
        result = prime * result + ((getPm_certification_No() == null) ? 0 : getPm_certification_No().hashCode());
        result = prime * result + ((getConstructor_certification_No() == null) ? 0 : getConstructor_certification_No().hashCode());
        result = prime * result + ((getSafety_permit_No() == null) ? 0 : getSafety_permit_No().hashCode());
        result = prime * result + ((getPm_safety_certification_No() == null) ? 0 : getPm_safety_certification_No().hashCode());
        result = prime * result + ((getPm_certification_url() == null) ? 0 : getPm_certification_url().hashCode());
        result = prime * result + ((getConstructor_certification_url() == null) ? 0 : getConstructor_certification_url().hashCode());
        result = prime * result + ((getSafety_permit_url() == null) ? 0 : getSafety_permit_url().hashCode());
        result = prime * result + ((getPm_safety_certification_url() == null) ? 0 : getPm_safety_certification_url().hashCode());
        result = prime * result + ((getPm_certification_endtime() == null) ? 0 : getPm_certification_endtime().hashCode());
        result = prime * result + ((getConstructor_certification_endtime() == null) ? 0 : getConstructor_certification_endtime().hashCode());
        result = prime * result + ((getSafety_permit_endtime() == null) ? 0 : getSafety_permit_endtime().hashCode());
        result = prime * result + ((getPm_safety_certification_endtime() == null) ? 0 : getPm_safety_certification_endtime().hashCode());
        result = prime * result + ((getBank_guarantee_No() == null) ? 0 : getBank_guarantee_No().hashCode());
        result = prime * result + ((getBank_guarantee_url() == null) ? 0 : getBank_guarantee_url().hashCode());
        result = prime * result + ((getBank_guarantee_amount() == null) ? 0 : getBank_guarantee_amount().hashCode());
        result = prime * result + ((getProject_quotation_url() == null) ? 0 : getProject_quotation_url().hashCode());
        result = prime * result + ((getConstruction_commitment_url() == null) ? 0 : getConstruction_commitment_url().hashCode());
        result = prime * result + ((getConstruction_end_date() == null) ? 0 : getConstruction_end_date().hashCode());
        result = prime * result + ((getConstruction_start_date() == null) ? 0 : getConstruction_start_date().hashCode());
        result = prime * result + ((getTechnical_standard_url() == null) ? 0 : getTechnical_standard_url().hashCode());
        return result;
    }
}