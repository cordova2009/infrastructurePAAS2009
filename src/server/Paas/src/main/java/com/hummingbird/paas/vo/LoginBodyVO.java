package com.hummingbird.paas.vo;

public class LoginBodyVO {
	/*"body"{
        "mobileNum":"13692228034",
        "loginPassword":"LOGIN_PASSWORD"
    }*/
	private String mobileNum;
	private String loginPassword;
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
