package com.hummingbird.paas.vo;

public class QueryObjectDetailResultVO {
     private String objectId;
     private String status;
     private SurveyVO survey;
     private DetailVO detail;
     private String tenderFile;
	public String getObjectId() {
		return objectId;
	}
	public void setObjectId(String objectId) {
		this.objectId = objectId;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	public SurveyVO getSurvey() {
		return survey;
	}
	public void setSurvey(SurveyVO survey) {
		this.survey = survey;
	}
	public DetailVO getDetail() {
		return detail;
	}
	public void setDetail(DetailVO detail) {
		this.detail = detail;
	}
	public String getTenderFile() {
		return tenderFile;
	}
	public void setTenderFile(String tenderFile) {
		this.tenderFile = tenderFile;
	}
	@Override
	public String toString() {
		return "QueryObjectDetailResultVO [objectId=" + objectId + ", status=" + status 
				+ ", tenderFile=" + tenderFile+"]";
	}

	
}
