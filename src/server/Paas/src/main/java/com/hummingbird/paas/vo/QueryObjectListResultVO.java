package com.hummingbird.paas.vo;

public class QueryObjectListResultVO {
	private String objectId;
	private String objectName;
	private String evaluationAmount;
	private String companyShortName;
	private String creditRating;
	private String objectPredictStartTime;
	private Integer projectExpectPeriod;
	/**
	 * @return the objectId
	 */
	public String getObjectId() {
		return objectId;
	}
	/**
	 * @return the objectName
	 */
	public String getObjectName() {
		return objectName;
	}
	/**
	 * @return the evaluationAmount
	 */
	public String getEvaluationAmount() {
		return evaluationAmount;
	}
	/**
	 * @return the companyShortName
	 */
	public String getCompanyShortName() {
		return companyShortName;
	}
	/**
	 * @return the creditRating
	 */
	public String getCreditRating() {
		return creditRating;
	}
	/**
	 * @return the objectPredictStartTime
	 */
	public String getObjectPredictStartTime() {
		return objectPredictStartTime;
	}
	/**
	 * @return the projectExpectPeriod
	 */
	public Integer getProjectExpectPeriod() {
		return projectExpectPeriod;
	}
	/**
	 * @param objectId the objectId to set
	 */
	public void setObjectId(String objectId) {
		this.objectId = objectId;
	}
	/**
	 * @param objectName the objectName to set
	 */
	public void setObjectName(String objectName) {
		this.objectName = objectName;
	}
	/**
	 * @param evaluationAmount the evaluationAmount to set
	 */
	public void setEvaluationAmount(String evaluationAmount) {
		this.evaluationAmount = evaluationAmount;
	}
	/**
	 * @param companyShortName the companyShortName to set
	 */
	public void setCompanyShortName(String companyShortName) {
		this.companyShortName = companyShortName;
	}
	/**
	 * @param creditRating the creditRating to set
	 */
	public void setCreditRating(String creditRating) {
		this.creditRating = creditRating;
	}
	/**
	 * @param objectPredictStartTime the objectPredictStartTime to set
	 */
	public void setObjectPredictStartTime(String objectPredictStartTime) {
		this.objectPredictStartTime = objectPredictStartTime;
	}
	/**
	 * @param projectExpectPeriod the projectExpectPeriod to set
	 */
	public void setProjectExpectPeriod(Integer projectExpectPeriod) {
		this.projectExpectPeriod = projectExpectPeriod;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "QueryObjectListResultVO [objectId=" + objectId + ", objectName=" + objectName + ", evaluationAmount="
				+ evaluationAmount + ", companyShortName=" + companyShortName + ", creditRating=" + creditRating
				+ ", objectPredictStartTime=" + objectPredictStartTime + ", projectExpectPeriod=" + projectExpectPeriod
				+ "]";
	}

	
}
