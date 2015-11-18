package com.hummingbird.paas.entity;

import java.util.Date;

/**
 * 招标方开户行认证表
 */
public class BiddeeBankAduit {
    private Integer id;

    /**
     * 招标方资质认证id
     */
    private Integer biddeeCerticateId;

    /**
     * 银行认证结果,CRT待认证,OK#已认证,FLS认证不通过
     */
    private String bankcardCertificateResult;

    /**
     * 审核人
     */
    private Integer auditor;

    /**
     * 审核时间
     */
    private Date auditTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return 招标方资质认证id
     */
    public Integer getBiddeeCerticateId() {
        return biddeeCerticateId;
    }

    /**
     * @param biddeeCerticateId 
	 *            招标方资质认证id
     */
    public void setBiddeeCerticateId(Integer biddeeCerticateId) {
        this.biddeeCerticateId = biddeeCerticateId;
    }

    /**
     * @return 银行认证结果,CRT待认证,OK#已认证,FLS认证不通过
     */
    public String getBankcardCertificateResult() {
        return bankcardCertificateResult;
    }

    /**
     * @param bankcardCertificateResult 
	 *            银行认证结果,CRT待认证,OK#已认证,FLS认证不通过
     */
    public void setBankcardCertificateResult(String bankcardCertificateResult) {
        this.bankcardCertificateResult = bankcardCertificateResult == null ? null : bankcardCertificateResult.trim();
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
}