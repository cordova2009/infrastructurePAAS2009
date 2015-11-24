package com.hummingbird.usercenter.vo;

public class SurveyVO {
     private String objectId;
     private String status;
     private String evalutionAmount;
     private String projectExpectPeriod;
     private String announcementEndTime;
     private String biddingEndTime;
     private String projectSite;
     private Integer bidderNum;
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
	public String getEvalutionAmount() {
		return evalutionAmount;
	}
	public void setEvalutionAmount(String evalutionAmount) {
		this.evalutionAmount = evalutionAmount;
	}
	public String getProjectExpectPeriod() {
		return projectExpectPeriod;
	}
	public void setProjectExpectPeriod(String projectExpectPeriod) {
		this.projectExpectPeriod = projectExpectPeriod;
	}
	public String getAnnouncementEndTime() {
		return announcementEndTime;
	}
	public void setAnnouncementEndTime(String announcementEndTime) {
		this.announcementEndTime = announcementEndTime;
	}
	public String getBiddingEndTime() {
		return biddingEndTime;
	}
	public void setBiddingEndTime(String biddingEndTime) {
		this.biddingEndTime = biddingEndTime;
	}
	public String getProjectSite() {
		return projectSite;
	}
	public void setProjectSite(String projectSite) {
		this.projectSite = projectSite;
	}
	public Integer getBidderNum() {
		return bidderNum;
	}
	public void setBidderNum(Integer bidderNum) {
		this.bidderNum = bidderNum;
	}
	@Override
	public String toString() {
		return "SurveyVO [objectId=" + objectId + ", status=" + status + ", evalutionAmount=" + evalutionAmount
				+ ", projectExpectPeriod=" + projectExpectPeriod + ", announcementEndTime=" + announcementEndTime
				+ ", biddingEndTime=" + biddingEndTime + ", projectSite=" + projectSite + ", bidderNum=" + bidderNum
				+ "]";
	}
     
}
