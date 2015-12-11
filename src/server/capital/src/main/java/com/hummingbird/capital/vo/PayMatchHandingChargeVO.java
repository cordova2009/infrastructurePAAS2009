package com.hummingbird.capital.vo;

import java.util.List;

public class PayMatchHandingChargeVO {
	/*"body":{
	    "token":"USER_TOKEN",
	    "orderId":"ORDER_ID",
	    "appOrderId":"APP_ORDER_ID",
	    "lose":[{"orderId":"ORDER_ID","appOrderId":"APP_ORDER_ID"}]
	}*/
	private String token;
	private String orderId;
	private String appOrderId;
	private List<LoseVO> lose;
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public String getAppOrderId() {
		return appOrderId;
	}
	public void setAppOrderId(String appOrderId) {
		this.appOrderId = appOrderId;
	}
	public List<LoseVO> getLose() {
		return lose;
	}
	public void setLose(List<LoseVO> lose) {
		this.lose = lose;
	}
	
}
