package com.hummingbird.usercenter.vo;

public class LoginReturnVO {
	/*"user":{
	    "token":"USER_TOKEN",
	    "mobileNum":"13912345678", 
	    "nickname":"zhangsan",
	    "headImageUrl":"HEADIMAGE_URL"
	}*/
	private String token;
	private String mobileNum;
	private String nickname;
	private String headImageUrl;
	private Integer expireIn;
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public String getMobileNum() {
		return mobileNum;
	}
	public void setMobileNum(String mobileNum) {
		this.mobileNum = mobileNum;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getHeadImageUrl() {
		return headImageUrl;
	}
	public void setHeadImageUrl(String headImageUrl) {
		this.headImageUrl = headImageUrl;
	}
	public Integer getExpireIn() {
		return expireIn;
	}
	public void setExpireIn(Integer expireIn) {
		this.expireIn = expireIn;
	}
	
}
