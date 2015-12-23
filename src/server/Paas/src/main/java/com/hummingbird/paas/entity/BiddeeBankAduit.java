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
     * 税号认证备注
     */
    private String taxNoCertificateMsg;

    /**
     * 公司地址认证备注
     */
    private String addressCertificateMsg;

    /**
     * 电话认证备注
     */
    private String telephoneCertificateMsg;

    /**
     * 税号认证结果,CRT待认证,OK#已认证,FLS认证不通过
     */
    private String taxNoCertificateResult;

    /**
     * 公司地址认证结果,CRT待认证,OK#已认证,FLS认证不通过
     */
    private String addressCertificateResult;

    /**
     * 电话认证结果,CRT待认证,OK#已认证,FLS认证不通过
     */
    private String telephoneCertificateResult;

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

    /**
     * @return 税号认证备注
     */
    public String getTaxNoCertificateMsg() {
        return taxNoCertificateMsg;
    }

    /**
     * @param taxNoCertificateMsg 
	 *            税号认证备注
     */
    public void setTaxNoCertificateMsg(String taxNoCertificateMsg) {
        this.taxNoCertificateMsg = taxNoCertificateMsg == null ? null : taxNoCertificateMsg.trim();
    }

    /**
     * @return 公司地址认证备注
     */
    public String getAddressCertificateMsg() {
        return addressCertificateMsg;
    }

    /**
     * @param addressCertificateMsg 
	 *            公司地址认证备注
     */
    public void setAddressCertificateMsg(String addressCertificateMsg) {
        this.addressCertificateMsg = addressCertificateMsg == null ? null : addressCertificateMsg.trim();
    }

    /**
     * @return 电话认证备注
     */
    public String getTelephoneCertificateMsg() {
        return telephoneCertificateMsg;
    }

    /**
     * @param telephoneCertificateMsg 
	 *            电话认证备注
     */
    public void setTelephoneCertificateMsg(String telephoneCertificateMsg) {
        this.telephoneCertificateMsg = telephoneCertificateMsg == null ? null : telephoneCertificateMsg.trim();
    }

    /**
     * @return 税号认证结果,CRT待认证,OK#已认证,FLS认证不通过
     */
    public String getTaxNoCertificateResult() {
        return taxNoCertificateResult;
    }

    /**
     * @param taxNoCertificateResult 
	 *            税号认证结果,CRT待认证,OK#已认证,FLS认证不通过
     */
    public void setTaxNoCertificateResult(String taxNoCertificateResult) {
        this.taxNoCertificateResult = taxNoCertificateResult == null ? null : taxNoCertificateResult.trim();
    }

    /**
     * @return 公司地址认证结果,CRT待认证,OK#已认证,FLS认证不通过
     */
    public String getAddressCertificateResult() {
        return addressCertificateResult;
    }

    /**
     * @param addressCertificateResult 
	 *            公司地址认证结果,CRT待认证,OK#已认证,FLS认证不通过
     */
    public void setAddressCertificateResult(String addressCertificateResult) {
        this.addressCertificateResult = addressCertificateResult == null ? null : addressCertificateResult.trim();
    }

    /**
     * @return 电话认证结果,CRT待认证,OK#已认证,FLS认证不通过
     */
    public String getTelephoneCertificateResult() {
        return telephoneCertificateResult;
    }

    /**
     * @param telephoneCertificateResult 
	 *            电话认证结果,CRT待认证,OK#已认证,FLS认证不通过
     */
    public void setTelephoneCertificateResult(String telephoneCertificateResult) {
        this.telephoneCertificateResult = telephoneCertificateResult == null ? null : telephoneCertificateResult.trim();
    }
}