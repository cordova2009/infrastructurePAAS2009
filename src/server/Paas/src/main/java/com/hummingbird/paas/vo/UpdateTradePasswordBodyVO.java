package com.hummingbird.paas.vo;

public class UpdateTradePasswordBodyVO {
	/*"body":{
            "token":"USER_TOKEN",
	        "smsCode":"324545",
            "oldTradePassword":"OLD_TRADE_PASSWORD",
	        "newTradePassword":"NEW_TRADE_PASSWORD"
    	}*/
	private String token;
	private String smsCode;
	private String oldTradePassword;
	private String newTradePassword;
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
	public String getOldTradePassword() {
		return oldTradePassword;
	}
	public void setOldTradePassword(String oldTradePassword) {
		this.oldTradePassword = oldTradePassword;
	}
	public String getNewTradePassword() {
		return newTradePassword;
	}
	public void setNewTradePassword(String newTradePassword) {
		this.newTradePassword = newTradePassword;
	}
	
	
}
