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
    private Integer certification_certicate_id;

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
    public Integer getCertification_certicate_id() {
        return certification_certicate_id;
    }

    /**
     * @param certificationCerticateId 
	 *            申请id
     */
    public void setCertification_certicate_id(Integer certification_certicate_id) {
        this.certification_certicate_id = certification_certicate_id;
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
            && (this.getCertification_certicate_id() == null ? other.getCertification_certicate_id() == null : this.getCertification_certicate_id().equals(other.getCertification_certicate_id()))
            && (this.getAudit_time() == null ? other.getAudit_time() == null : this.getAudit_time().equals(other.getAudit_time()))
            && (this.getAudit_status() == null ? other.getAudit_status() == null : this.getAudit_status().equals(other.getAudit_status()))
            && (this.getAuditor() == null ? other.getAuditor() == null : this.getAuditor().equals(other.getAuditor()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getCertification_certicate_id() == null) ? 0 : getCertification_certicate_id().hashCode());
        result = prime * result + ((getAudit_time() == null) ? 0 : getAudit_time().hashCode());
        result = prime * result + ((getAudit_status() == null) ? 0 : getAudit_status().hashCode());
        result = prime * result + ((getAuditor() == null) ? 0 : getAuditor().hashCode());
        return result;
    }
}