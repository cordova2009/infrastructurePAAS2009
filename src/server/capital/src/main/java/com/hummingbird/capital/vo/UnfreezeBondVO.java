package com.hummingbird.capital.vo;

public class UnfreezeBondVO {
	 /*"token":"USER_TOKEN",
     "orderId":"FREEZEBOND_ORDER_ID"*/
	private String token;
	private String appOrderId;
	private String orignalOrderId;
	private String objectId;
	private String remark;
	
	@Override
	public String toString() {
		return "UnfreezeBondVO [token=" + token + ", appOrderId=" + appOrderId + 
				",orignalOrderId="+orignalOrderId+",objectId=" + objectId +",remark="+remark+ "]";
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

	public String getAppOrderId() {
		return appOrderId;
	}

	public void setAppOrderId(String appOrderId) {
		this.appOrderId = appOrderId;
	}

	public String getOrignalOrderId() {
		return orignalOrderId;
	}

	public void setOrignalOrderId(String orignalOrderId) {
		this.orignalOrderId = orignalOrderId;
	}
	
	
}
