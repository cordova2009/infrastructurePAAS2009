package com.hummingbird.paas.vo;

public class QueryObjectDetailAnswerQuestion {
     private String startTime;
     private String endTime;
     private String QQ;
     private String QQToken;
     private String email;
     private String address;
     private String answerTime;
     private String telephone;
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	public String getQQ() {
		return QQ;
	}
	public void setQQ(String qQ) {
		QQ = qQ;
	}
	public String getQQToken() {
		return QQToken;
	}
	public void setQQToken(String qQToken) {
		QQToken = qQToken;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getAnswerTime() {
		return answerTime;
	}
	public void setAnswerTime(String answerTime) {
		this.answerTime = answerTime;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	@Override
	public String toString() {
		return "QueryObjectDetailAnswerQuestion [startTime=" + startTime + ", endTime=" + endTime + ", QQ=" + QQ
				+ ", QQToken=" + QQToken + ", email=" + email + ", address=" + address + ", answerTime=" + answerTime
				+ ", telephone=" + telephone + "]";
	}
     
}
