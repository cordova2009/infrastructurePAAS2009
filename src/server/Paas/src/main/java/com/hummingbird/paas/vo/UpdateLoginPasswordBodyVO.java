package com.hummingbird.paas.vo;

public class UpdateLoginPasswordBodyVO {
	/*"body":{   
	    "token":"USER_TOKEN",
	    "smsCode":"324545",
	    "oldLoginPassword":"OLD_LOGIN_PASSWORD",
	    "newLoginPassword":"NEW_LOGIN_PASSWORD"
	}*/
	private String token;
	private String smsCode;
	private String oldLoginPassword;
	private String newLoginPassword;
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public String getSmsCode() {
		return smsCode;
	}
	public void setSmsCode(String smsCode) {
		this.smsCode = smsCode;
	}
	public String getOldLoginPassword() {
		return oldLoginPassword;
	}
	public void setOldLoginPassword(String oldLoginPassword) {
		this.oldLoginPassword = oldLoginPassword;
	}
	public String getNewLoginPassword() {
		return newLoginPassword;
	}
	public void setNewLoginPassword(String newLoginPassword) {
		this.newLoginPassword = newLoginPassword;
	}
	
}
