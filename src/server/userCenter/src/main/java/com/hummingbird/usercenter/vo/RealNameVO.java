package com.hummingbird.usercenter.vo;

public class RealNameVO {
	/*"body":{
    	"realName":"王亚锋",
        "cardID":"610522222222222838"
	}*/
	private String realName;
	private String cardID;
	
	@Override
	public String toString() {
		return "RealNameVO [realName=" + realName + ", cardID=" + cardID +"]";
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
	
}
