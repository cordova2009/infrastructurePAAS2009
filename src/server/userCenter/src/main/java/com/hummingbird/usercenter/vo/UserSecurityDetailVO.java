package com.hummingbird.usercenter.vo;

public class UserSecurityDetailVO {
	 /*"realName":{
	    "name":"*三",
	    "cardID":"55****19880910****",
	    "isRealName":"TRU"
	}*/
	private String name;
	private String cardID;
	private String isRealName;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCardID() {
		return cardID;
	}
	public void setCardID(String cardID) {
		this.cardID = cardID;
	}
	public String getIsRealName() {
		return isRealName;
	}
	public void setIsRealName(String isRealName) {
		this.isRealName = isRealName;
	}
	
}
