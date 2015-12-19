package com.hummingbird.paas.entity;

import java.util.Date;

/**
 * 承包商资质证书认证申请审核表
 */
public class BidderCertificationAudit {
    /**
     * 主键
     */
    private Integer id;

    /**
     * 申请id
     */
    private Integer certificationCerticateId;

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
     * 审核备注
     */
    private String auditReason;

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
     * @return 申请id
     */
    public Integer getCertificationCerticateId() {
        return certificationCerticateId;
    }

    /**
     * @param certificationCerticateId 
	 *            申请id
     */
    public void setCertificationCerticateId(Integer certificationCerticateId) {
        this.certificationCerticateId = certificationCerticateId;
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
     * @return 审核备注
     */
    public String getAuditReason() {
        return auditReason;
    }

    /**
     * @param auditReason 
	 *            审核备注
     */
    public void setAuditReason(String auditReason) {
        this.auditReason = auditReason == null ? null : auditReason.trim();
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
        BidderCertificationAudit other = (BidderCertificationAudit) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getCertificationCerticateId() == null ? other.getCertificationCerticateId() == null : this.getCertificationCerticateId().equals(other.getCertificationCerticateId()))
            && (this.getAuditTime() == null ? other.getAuditTime() == null : this.getAuditTime().equals(other.getAuditTime()))
            && (this.getAuditStatus() == null ? other.getAuditStatus() == null : this.getAuditStatus().equals(other.getAuditStatus()))
            && (this.getAuditor() == null ? other.getAuditor() == null : this.getAuditor().equals(other.getAuditor()))
            && (this.getAuditReason() == null ? other.getAuditReason() == null : this.getAuditReason().equals(other.getAuditReason()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getCertificationCerticateId() == null) ? 0 : getCertificationCerticateId().hashCode());
        result = prime * result + ((getAuditTime() == null) ? 0 : getAuditTime().hashCode());
        result = prime * result + ((getAuditStatus() == null) ? 0 : getAuditStatus().hashCode());
        result = prime * result + ((getAuditor() == null) ? 0 : getAuditor().hashCode());
        result = prime * result + ((getAuditReason() == null) ? 0 : getAuditReason().hashCode());
        return result;
    }
}