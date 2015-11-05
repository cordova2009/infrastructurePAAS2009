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
    private String company_type;

    /**
     * 认证提出方id
     */
    private Integer company_id;

    /**
     * 认证提出时间
     */
    private Date apply_time;

    /**
     * 认证审核时间
     */
    private Date audit_time;

    /**
     * 认证状态,CRT待认证,OK#已认证,FLS认证失败
     */
    private String audit_status;

    /**
     * 认证审核人
     */
    private String auditor;

    /**
     * 认证申请摘要
     */
    private String apply_desc;

    /**
     * 认证审核结果备注
     */
    private String audit_desc;

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
    public String getCompany_type() {
        return company_type;
    }

    /**
     * @param companyType 
	 *            认证招投标类型，TER发包商，BIR承包商
     */
    public void setCompany_type(String company_type) {
        this.company_type = company_type == null ? null : company_type.trim();
    }

    /**
     * @return 认证提出方id
     */
    public Integer getCompany_id() {
        return company_id;
    }

    /**
     * @param companyId 
	 *            认证提出方id
     */
    public void setCompany_id(Integer company_id) {
        this.company_id = company_id;
    }

    /**
     * @return 认证提出时间
     */
    public Date getApply_time() {
        return apply_time;
    }

    /**
     * @param applyTime 
	 *            认证提出时间
     */
    public void setApply_time(Date apply_time) {
        this.apply_time = apply_time;
    }

    /**
     * @return 认证审核时间
     */
    public Date getAudit_time() {
        return audit_time;
    }

    /**
     * @param auditTime 
	 *            认证审核时间
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
    public String getApply_desc() {
        return apply_desc;
    }

    /**
     * @param applyDesc 
	 *            认证申请摘要
     */
    public void setApply_desc(String apply_desc) {
        this.apply_desc = apply_desc == null ? null : apply_desc.trim();
    }

    /**
     * @return 认证审核结果备注
     */
    public String getAudit_desc() {
        return audit_desc;
    }

    /**
     * @param auditDesc 
	 *            认证审核结果备注
     */
    public void setAudit_desc(String audit_desc) {
        this.audit_desc = audit_desc == null ? null : audit_desc.trim();
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
            && (this.getCompany_type() == null ? other.getCompany_type() == null : this.getCompany_type().equals(other.getCompany_type()))
            && (this.getCompany_id() == null ? other.getCompany_id() == null : this.getCompany_id().equals(other.getCompany_id()))
            && (this.getApply_time() == null ? other.getApply_time() == null : this.getApply_time().equals(other.getApply_time()))
            && (this.getAudit_time() == null ? other.getAudit_time() == null : this.getAudit_time().equals(other.getAudit_time()))
            && (this.getAudit_status() == null ? other.getAudit_status() == null : this.getAudit_status().equals(other.getAudit_status()))
            && (this.getAuditor() == null ? other.getAuditor() == null : this.getAuditor().equals(other.getAuditor()))
            && (this.getApply_desc() == null ? other.getApply_desc() == null : this.getApply_desc().equals(other.getApply_desc()))
            && (this.getAudit_desc() == null ? other.getAudit_desc() == null : this.getAudit_desc().equals(other.getAudit_desc()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getCompany_type() == null) ? 0 : getCompany_type().hashCode());
        result = prime * result + ((getCompany_id() == null) ? 0 : getCompany_id().hashCode());
        result = prime * result + ((getApply_time() == null) ? 0 : getApply_time().hashCode());
        result = prime * result + ((getAudit_time() == null) ? 0 : getAudit_time().hashCode());
        result = prime * result + ((getAudit_status() == null) ? 0 : getAudit_status().hashCode());
        result = prime * result + ((getAuditor() == null) ? 0 : getAuditor().hashCode());
        result = prime * result + ((getApply_desc() == null) ? 0 : getApply_desc().hashCode());
        result = prime * result + ((getAudit_desc() == null) ? 0 : getAudit_desc().hashCode());
        return result;
    }
}