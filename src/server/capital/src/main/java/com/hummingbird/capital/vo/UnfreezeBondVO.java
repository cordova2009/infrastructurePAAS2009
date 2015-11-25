package com.hummingbird.capital.vo;

public class UnfreezeBondVO {
	 /*"token":"USER_TOKEN",
     "orderId":"FREEZEBOND_ORDER_ID"*/
	private String token;
	private String orderId;
	private String objectId;
	private String remark;
	
	@Override
	public String toString() {
		return "UnfreezeBondVO [token=" + token + ", orderId=" + orderId + 
				",objectId=" + objectId +",remark="+remark+ "]";
	}
	
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getObjectId() {
		return objectId;
	}
	public void setObjectId(String objectId) {
		this.objectId = objectId;
	}
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
	
}
