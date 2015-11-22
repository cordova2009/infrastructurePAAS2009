package com.hummingbird.paas.vo;

public class UserSecurityInfoVO {
	/*"user":{
	    "nickname":"zhangsan",
	    "mobileNum":"136****6768",
	    "email":"zhangsna@126.com",
	    "realName":{
	        "name":"*三",
	        "cardID":"55****19880910****",
	        "isRealName":"TRU"
	    }
	}*/
	private String nickname;
	private String mobileNum;
	private String email;
	private UserSecurityDetailVO realname;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public UserSecurityDetailVO getRealname() {
		return realname;
	}
	public void setRealname(UserSecurityDetailVO realname) {
		this.realname = realname;
	}
	
}
