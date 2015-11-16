package com.hummingbird.usercenter.vo;

public class UpdateUserInfoBodyVO {
	/*"body":{
	    "token":"USER_TOKEN",
	    "nickname":"zhangsan",
	    "address":"",
	    "email":""
	}*/
	private String token;
	private String nickname;
	private String address;
	private String email;
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
}
