package com.hummingbird.usercenter.vo;

public class RegisterBodyVO {
	/*"body":{
	    "smsCode":"123456"
	    "nickname":"dudu", 
	    "mobileNum":"13912345678",
	    "realName":"王亚锋",
	    "cardID":"610522222222222838",
	    "loginPassword":"LOGIN_PASSWORD",
	    "tradePassword":"TRADE_PASSWORD"
	}*/
	
	private String smsCode;
	private String nickname;
	private String mobileNum;
	private String realName;
	private String cardID;
	private String loginPassword;
	private String tradePassword;
	public String getSmsCode() {
		return smsCode;
	}
	public void setSmsCode(String smsCode) {
		this.smsCode = smsCode;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getMobileNum() {
		return mobileNum;
	}
	public void setMobileNum(String mobileNum) {
		this.mobileNum = mobileNum;
	}
	public String getRealName() {
		return realName;
	}
	public void setRealName(String realName) {
		this.realName = realName;
	}
	public String getCardID() {
		return cardID;
	}
	public void setCardID(String cardID) {
		this.cardID = cardID;
	}
	public String getLoginPassword() {
		return loginPassword;
	}
	public void setLoginPassword(String loginPassword) {
		this.loginPassword = loginPassword;
	}
	public String getTradePassword() {
		return tradePassword;
	}
	public void setTradePassword(String tradePassword) {
		this.tradePassword = tradePassword;
	}
	
	
	
}
