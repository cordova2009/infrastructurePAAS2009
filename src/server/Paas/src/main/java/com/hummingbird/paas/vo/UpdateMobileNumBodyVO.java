package com.hummingbird.paas.vo;

public class UpdateMobileNumBodyVO {
	/* "body":{
	    "token":"USER_TOKEN",
	    "firstSmsCode":"324545",
	    "secondSmsCode":"435674",
	    "loginPassword":"LOGIN_PASSWORD",
	    "oldMobileNum":"13512345678",
	    "newMobileNum":"13687654321"
	}*/
	
	private String token;
	private String firstSmsCode;
	private String secondSmsCode;
	private String loginPassword;
	private String oldMobileNum;
	private String newMobileNum;
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public String getFirstSmsCode() {
		return firstSmsCode;
	}
	public void setFirstSmsCode(String firstSmsCode) {
		this.firstSmsCode = firstSmsCode;
	}
	public String getSecondSmsCode() {
		return secondSmsCode;
	}
	public void setSecondSmsCode(String secondSmsCode) {
		this.secondSmsCode = secondSmsCode;
	}
	public String getLoginPassword() {
		return loginPassword;
	}
	public void setLoginPassword(String loginPassword) {
		this.loginPassword = loginPassword;
	}
	public String getOldMobileNum() {
		return oldMobileNum;
	}
	public void setOldMobileNum(String oldMobileNum) {
		this.oldMobileNum = oldMobileNum;
	}
	public String getNewMobileNum() {
		return newMobileNum;
	}
	public void setNewMobileNum(String newMobileNum) {
		this.newMobileNum = newMobileNum;
	}
	
	
}
