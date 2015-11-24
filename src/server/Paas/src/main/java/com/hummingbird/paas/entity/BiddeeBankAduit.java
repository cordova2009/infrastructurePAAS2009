package com.hummingbird.paas.entity;

import java.util.Date;

/**
 * 招标人开户行认证表
 */
public class BiddeeBankAduit {
    /**
     * id
     */
    private Integer id;

    /**
     * 招标人资质认证id
     */
    private Integer biddeeCerticateId;

    /**
     * 银行卡认证备注
     */
    private String bankcardCertificateMsg;

    /**
     * 银行开户行认证备注
     */
    private String bankCertificateMsg;

    /**
     * 银行持卡人认证备注
     */
    private String acccountNameCertificateMsg;

    /**
     * 银行卡认证结果,CRT待认证,OK#已认证,FLS认证不通过
     */
    private String bankcardCertificateResult;

    /**
     * 银行开户行认证结果,CRT待认证,OK#已认证,FLS认证不通过
     */
    private String bankCertificateResult;

    /**
     * 银行持卡人认证结果,CRT待认证,OK#已认证,FLS认证不通过
     */
    private String acccountNameCertificateResult;

    /**
     * 审核人
     */
    private Integer auditor;

    /**
     * 审核时间
     */
    private Date auditTime;

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
     * @return 招标人资质认证id
     */
    public Integer getBiddeeCerticateId() {
        return biddeeCerticateId;
    }

    /**
     * @param biddeeCerticateId 
	 *            招标人资质认证id
     */
    public void setBiddeeCerticateId(Integer biddeeCerticateId) {
        this.biddeeCerticateId = biddeeCerticateId;
    }

    /**
     * @return 银行卡认证备注
     */
    public String getBankcardCertificateMsg() {
        return bankcardCertificateMsg;
    }

    /**
     * @param bankcardCertificateMsg 
	 *            银行卡认证备注
     */
    public void setBankcardCertificateMsg(String bankcardCertificateMsg) {
        this.bankcardCertificateMsg = bankcardCertificateMsg == null ? null : bankcardCertificateMsg.trim();
    }

    /**
     * @return 银行开户行认证备注
     */
    public String getBankCertificateMsg() {
        return bankCertificateMsg;
    }

    /**
     * @param bankCertificateMsg 
	 *            银行开户行认证备注
     */
    public void setBankCertificateMsg(String bankCertificateMsg) {
        this.bankCertificateMsg = bankCertificateMsg == null ? null : bankCertificateMsg.trim();
    }

    /**
     * @return 银行持卡人认证备注
     */
    public String getAcccountNameCertificateMsg() {
        return acccountNameCertificateMsg;
    }

    /**
     * @param acccountNameCertificateMsg 
	 *            银行持卡人认证备注
     */
    public void setAcccountNameCertificateMsg(String acccountNameCertificateMsg) {
        this.acccountNameCertificateMsg = acccountNameCertificateMsg == null ? null : acccountNameCertificateMsg.trim();
    }

    /**
     * @return 银行卡认证结果,CRT待认证,OK#已认证,FLS认证不通过
     */
    public String getBankcardCertificateResult() {
        return bankcardCertificateResult;
    }

    /**
     * @param bankcardCertificateResult 
	 *            银行卡认证结果,CRT待认证,OK#已认证,FLS认证不通过
     */
    public void setBankcardCertificateResult(String bankcardCertificateResult) {
        this.bankcardCertificateResult = bankcardCertificateResult == null ? null : bankcardCertificateResult.trim();
    }

    /**
     * @return 银行开户行认证结果,CRT待认证,OK#已认证,FLS认证不通过
     */
    public String getBankCertificateResult() {
        return bankCertificateResult;
    }

    /**
     * @param bankCertificateResult 
	 *            银行开户行认证结果,CRT待认证,OK#已认证,FLS认证不通过
     */
    public void setBankCertificateResult(String bankCertificateResult) {
        this.bankCertificateResult = bankCertificateResult == null ? null : bankCertificateResult.trim();
    }

    /**
     * @return 银行持卡人认证结果,CRT待认证,OK#已认证,FLS认证不通过
     */
    public String getAcccountNameCertificateResult() {
        return acccountNameCertificateResult;
    }

    /**
     * @param acccountNameCertificateResult 
	 *            银行持卡人认证结果,CRT待认证,OK#已认证,FLS认证不通过
     */
    public void setAcccountNameCertificateResult(String acccountNameCertificateResult) {
        this.acccountNameCertificateResult = acccountNameCertificateResult == null ? null : acccountNameCertificateResult.trim();
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
        BiddeeBankAduit other = (BiddeeBankAduit) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getBiddeeCerticateId() == null ? other.getBiddeeCerticateId() == null : this.getBiddeeCerticateId().equals(other.getBiddeeCerticateId()))
            && (this.getBankcardCertificateMsg() == null ? other.getBankcardCertificateMsg() == null : this.getBankcardCertificateMsg().equals(other.getBankcardCertificateMsg()))
            && (this.getBankCertificateMsg() == null ? other.getBankCertificateMsg() == null : this.getBankCertificateMsg().equals(other.getBankCertificateMsg()))
            && (this.getAcccountNameCertificateMsg() == null ? other.getAcccountNameCertificateMsg() == null : this.getAcccountNameCertificateMsg().equals(other.getAcccountNameCertificateMsg()))
            && (this.getBankcardCertificateResult() == null ? other.getBankcardCertificateResult() == null : this.getBankcardCertificateResult().equals(other.getBankcardCertificateResult()))
            && (this.getBankCertificateResult() == null ? other.getBankCertificateResult() == null : this.getBankCertificateResult().equals(other.getBankCertificateResult()))
            && (this.getAcccountNameCertificateResult() == null ? other.getAcccountNameCertificateResult() == null : this.getAcccountNameCertificateResult().equals(other.getAcccountNameCertificateResult()))
            && (this.getAuditor() == null ? other.getAuditor() == null : this.getAuditor().equals(other.getAuditor()))
            && (this.getAuditTime() == null ? other.getAuditTime() == null : this.getAuditTime().equals(other.getAuditTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getBiddeeCerticateId() == null) ? 0 : getBiddeeCerticateId().hashCode());
        result = prime * result + ((getBankcardCertificateMsg() == null) ? 0 : getBankcardCertificateMsg().hashCode());
        result = prime * result + ((getBankCertificateMsg() == null) ? 0 : getBankCertificateMsg().hashCode());
        result = prime * result + ((getAcccountNameCertificateMsg() == null) ? 0 : getAcccountNameCertificateMsg().hashCode());
        result = prime * result + ((getBankcardCertificateResult() == null) ? 0 : getBankcardCertificateResult().hashCode());
        result = prime * result + ((getBankCertificateResult() == null) ? 0 : getBankCertificateResult().hashCode());
        result = prime * result + ((getAcccountNameCertificateResult() == null) ? 0 : getAcccountNameCertificateResult().hashCode());
        result = prime * result + ((getAuditor() == null) ? 0 : getAuditor().hashCode());
        result = prime * result + ((getAuditTime() == null) ? 0 : getAuditTime().hashCode());
        return result;
    }
}