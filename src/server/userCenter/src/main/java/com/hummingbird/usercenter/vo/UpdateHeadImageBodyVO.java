package com.hummingbird.usercenter.vo;

public class UpdateHeadImageBodyVO {
	/*"body":{
	    "token":"USER_TOKEN",
	    "headImageUrl":"HEAD_IMAGE_URL",
	}*/
	private String token;
	private String headImageUrl;
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public String getHeadImageUrl() {
		return headImageUrl;
	}
	public void setHeadImageUrl(String headImageUrl) {
		this.headImageUrl = headImageUrl;
	}
	
}
