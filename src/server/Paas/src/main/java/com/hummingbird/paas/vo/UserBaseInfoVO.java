package com.hummingbird.paas.vo;

public class UserBaseInfoVO {
	/*"user":{
	    "nickname":"zhangsan",
	    "realName":"张三",
	    "cardID":"660100198108131211",
	    "mobileNum":"13657256722",
	    "email":"zhangsan@hang.com",
	    "address":"深圳市南山区万科金域华府",
	    "headImageUrl":"http://xxxx.xxx/head.jpg"
	}*/
	private String nickname;
	private String realName;
	private String cardID;
	private String mobileNum;
	private String email;
	private String address;
	private String headImageUrl;
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
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
	public String getMobileNum() {
		return mobileNum;
	}
	public void setMobileNum(String mobileNum) {
		this.mobileNum = mobileNum;
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
	public String getHeadImageUrl() {
		return headImageUrl;
	}
	public void setHeadImageUrl(String headImageUrl) {
		this.headImageUrl = headImageUrl;
	}
	
}
