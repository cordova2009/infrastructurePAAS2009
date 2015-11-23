package com.hummingbird.paas.vo;

public class QueryObjectDetailDateRequirementInfo {
      private String announcementBeginTime;
      private String announcementEndTime;
      private String biddingEndTime;
      private String bidOpenDate;
	public String getAnnouncementBeginTime() {
		return announcementBeginTime;
	}
	public void setAnnouncementBeginTime(String announcementBeginTime) {
		this.announcementBeginTime = announcementBeginTime;
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
	public String getBidOpenDate() {
		return bidOpenDate;
	}
	public void setBidOpenDate(String bidOpenDate) {
		this.bidOpenDate = bidOpenDate;
	}
	@Override
	public String toString() {
		return "QueryObjectDetailDateRequirementInfo [announcementBeginTime=" + announcementBeginTime
				+ ", announcementEndTime=" + announcementEndTime + ", biddingEndTime=" + biddingEndTime
				+ ", bidOpenDate=" + bidOpenDate + "]";
	}
      
}
