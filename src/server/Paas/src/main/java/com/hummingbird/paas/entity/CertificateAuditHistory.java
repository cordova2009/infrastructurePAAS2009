package com.hummingbird.paas.entity;

import java.util.Date;

/**
 * 资质认证审核历史记录表
 */
public class CertificateAuditHistory {
    /**
     * id
     */
    private Integer id;

    /**
     * 认证招投标类型，TER发包商，BIR承包商
     */
    private String companyType;

    /**
     * 认证提出方id
     */
    private Integer companyId;

    /**
     * 认证提出时间
     */
    private Date applyTime;

    /**
     * 认证审核时间
     */
    private Date auditTime;

    /**
     * 认证状态,CRT待认证,OK#已认证,FLS认证失败
     */
    private String auditStatus;

    /**
     * 认证审核人
     */
    private String auditor;

    /**
     * 认证申请摘要
     */
    private String applyDesc;

    /**
     * 认证审核结果备注
     */
    private String auditDesc;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id 
	 *            id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return 认证招投标类型，TER发包商，BIR承包商
     */
    public String getCompanyType() {
        return companyType;
    }

    /**
     * @param companyType 
	 *            认证招投标类型，TER发包商，BIR承包商
     */
    public void setCompanyType(String companyType) {
        this.companyType = companyType == null ? null : companyType.trim();
    }

    /**
     * @return 认证提出方id
     */
    public Integer getCompanyId() {
        return companyId;
    }

    /**
     * @param companyId 
	 *            认证提出方id
     */
    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    /**
     * @return 认证提出时间
     */
    public Date getApplyTime() {
        return applyTime;
    }

    /**
     * @param applyTime 
	 *            认证提出时间
     */
    public void setApplyTime(Date applyTime) {
        this.applyTime = applyTime;
    }

    /**
     * @return 认证审核时间
     */
    public Date getAuditTime() {
        return auditTime;
    }

    /**
     * @param auditTime 
	 *            认证审核时间
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
     * @return 认证审核人
     */
    public String getAuditor() {
        return auditor;
    }

    /**
     * @param auditor 
	 *            认证审核人
     */
    public void setAuditor(String auditor) {
        this.auditor = auditor == null ? null : auditor.trim();
    }

    /**
     * @return 认证申请摘要
     */
    public String getApplyDesc() {
        return applyDesc;
    }

    /**
     * @param applyDesc 
	 *            认证申请摘要
     */
    public void setApplyDesc(String applyDesc) {
        this.applyDesc = applyDesc == null ? null : applyDesc.trim();
    }

    /**
     * @return 认证审核结果备注
     */
    public String getAuditDesc() {
        return auditDesc;
    }

    /**
     * @param auditDesc 
	 *            认证审核结果备注
     */
    public void setAuditDesc(String auditDesc) {
        this.auditDesc = auditDesc == null ? null : auditDesc.trim();
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
        CertificateAuditHistory other = (CertificateAuditHistory) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getCompanyType() == null ? other.getCompanyType() == null : this.getCompanyType().equals(other.getCompanyType()))
            && (this.getCompanyId() == null ? other.getCompanyId() == null : this.getCompanyId().equals(other.getCompanyId()))
            && (this.getApplyTime() == null ? other.getApplyTime() == null : this.getApplyTime().equals(other.getApplyTime()))
            && (this.getAuditTime() == null ? other.getAuditTime() == null : this.getAuditTime().equals(other.getAuditTime()))
            && (this.getAuditStatus() == null ? other.getAuditStatus() == null : this.getAuditStatus().equals(other.getAuditStatus()))
            && (this.getAuditor() == null ? other.getAuditor() == null : this.getAuditor().equals(other.getAuditor()))
            && (this.getApplyDesc() == null ? other.getApplyDesc() == null : this.getApplyDesc().equals(other.getApplyDesc()))
            && (this.getAuditDesc() == null ? other.getAuditDesc() == null : this.getAuditDesc().equals(other.getAuditDesc()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getCompanyType() == null) ? 0 : getCompanyType().hashCode());
        result = prime * result + ((getCompanyId() == null) ? 0 : getCompanyId().hashCode());
        result = prime * result + ((getApplyTime() == null) ? 0 : getApplyTime().hashCode());
        result = prime * result + ((getAuditTime() == null) ? 0 : getAuditTime().hashCode());
        result = prime * result + ((getAuditStatus() == null) ? 0 : getAuditStatus().hashCode());
        result = prime * result + ((getAuditor() == null) ? 0 : getAuditor().hashCode());
        result = prime * result + ((getApplyDesc() == null) ? 0 : getApplyDesc().hashCode());
        result = prime * result + ((getAuditDesc() == null) ? 0 : getAuditDesc().hashCode());
        return result;
    }
}