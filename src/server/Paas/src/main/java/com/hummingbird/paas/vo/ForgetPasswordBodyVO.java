package com.hummingbird.paas.vo;

public class ForgetPasswordBodyVO {
	/*"body":{
	    "smsCode":"324545",
	    "mobileNum":"13912345678",
	    "loginPassword":"LOGIN_PASSWORD"
	}*/
	private String smsCode;
	private String mobileNum;
	private String loginPassword;
	public String getSmsCode() {
		return smsCode;
	}
	public void setSmsCode(String smsCode) {
		this.smsCode = smsCode;
	}
	public String getMobileNum() {
		return mobileNum;
	}
	public void setMobileNum(String mobileNum) {
		this.mobileNum = mobileNum;
	}
	public String getLoginPassword() {
		return loginPassword;
	}
	public void setLoginPassword(String loginPassword) {
		this.loginPassword = loginPassword;
	}
	
}
