package com.hummingbird.paas.vo;

public class QueryObjectDetailBaseVO {
    private String objectName;
    private String industryId;
    private String biddingNo;
    private String objectScope;
    private String biddeeCompanyPrincipal;
    private String biddeeCompanyTelephone;
    private String currency;
    private String contractType;
    private String evaluationAmount;
	public String getObjectName() {
		return objectName;
	}
	public void setObjectName(String objectName) {
		this.objectName = objectName;
	}
	public String getIndustryId() {
		return industryId;
	}
	public void setIndustryId(String industryId) {
		this.industryId = industryId;
	}
	public String getBiddingNo() {
		return biddingNo;
	}
	public void setBiddingNo(String biddingNo) {
		this.biddingNo = biddingNo;
	}
	public String getObjectScope() {
		return objectScope;
	}
	public void setObjectScope(String objectScope) {
		this.objectScope = objectScope;
	}
	public String getBiddeeCompanyPrincipal() {
		return biddeeCompanyPrincipal;
	}
	public void setBiddeeCompanyPrincipal(String biddeeCompanyPrincipal) {
		this.biddeeCompanyPrincipal = biddeeCompanyPrincipal;
	}
	public String getBiddeeCompanyTelephone() {
		return biddeeCompanyTelephone;
	}
	public void setBiddeeCompanyTelephone(String biddeeCompanyTelephone) {
		this.biddeeCompanyTelephone = biddeeCompanyTelephone;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public String getContractType() {
		return contractType;
	}
	public void setContractType(String contractType) {
		this.contractType = contractType;
	}
	public String getEvaluationAmount() {
		return evaluationAmount;
	}
	public void setEvaluationAmount(String evaluationAmount) {
		this.evaluationAmount = evaluationAmount;
	}
	@Override
	public String toString() {
		return "QueryObjectDetailBaseVO [objectName=" + objectName + ", industryId=" + industryId + ", biddingNo="
				+ biddingNo + ", objectScope=" + objectScope + ", biddeeCompanyPrincipal=" + biddeeCompanyPrincipal
				+ ", biddeeCompanyTelephone=" + biddeeCompanyTelephone + ", currency=" + currency + ", contractType="
				+ contractType + ", evaluationAmount=" + evaluationAmount + "]";
	}
    
}
