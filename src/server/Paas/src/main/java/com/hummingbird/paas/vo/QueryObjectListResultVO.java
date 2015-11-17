package com.hummingbird.paas.vo;

public class QueryObjectListResultVO {
	private String objectId;
	private String objetName;
	private String evaluationAmount;
	private String companyShortName;
	private String creditRating;
	private String objectPredictStartTime;
	private Integer projectExpectPeriod;

	public String getObjectId() {
		return objectId;
	}

	public void setObjectId(String objectId) {
		this.objectId = objectId;
	}

	public String getObjetName() {
		return objetName;
	}

	public void setObjetName(String objetName) {
		this.objetName = objetName;
	}

	public String getEvaluationAmount() {
		return evaluationAmount;
	}

	public void setEvaluationAmount(String evaluationAmount) {
		this.evaluationAmount = evaluationAmount;
	}

	public String getCompanyShortName() {
		return companyShortName;
	}

	public void setCompanyShortName(String companyShortName) {
		this.companyShortName = companyShortName;
	}

	public String getCreditRating() {
		return creditRating;
	}

	public void setCreditRating(String creditRating) {
		this.creditRating = creditRating;
	}

	public String getObjectPredictStartTime() {
		return objectPredictStartTime;
	}

	public void setObjectPredictStartTime(String objectPredictStartTime) {
		this.objectPredictStartTime = objectPredictStartTime;
	}

	public Integer getProjectExpectPeriod() {
		return projectExpectPeriod;
	}

	public void setProjectExpectPeriod(Integer projectExpectPeriod) {
		this.projectExpectPeriod = projectExpectPeriod;
	}

}
