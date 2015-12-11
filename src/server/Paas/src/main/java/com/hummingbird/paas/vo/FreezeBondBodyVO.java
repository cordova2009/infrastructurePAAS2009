package com.hummingbird.paas.vo;

public class FreezeBondBodyVO {
	private String token;
	private String type;
	private Long amount;
	private String appOrderId;
	private String objectId;
	private String remark;
	private String tradePassword;
	private Boolean isVerityPassword=true;
	@Override
	public String toString() {
		return "FreezeBondBodyVO [token=" + token + ", type=" + type +
				",amount=" + amount +",objectId+"+objectId+
				",remark="+remark+",tradePassword="+tradePassword+"]";
	}
	
	public Boolean getIsVerityPassword() {
		return isVerityPassword;
	}

	public void setIsVerityPassword(Boolean isVerityPassword) {
		this.isVerityPassword = isVerityPassword;
	}

	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
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
	
	public Long getAmount() {
		return amount;
	}
	public void setAmount(Long amount) {
		this.amount = amount;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getTradePassword() {
		return tradePassword;
	}
	public void setTradePassword(String tradePassword) {
		this.tradePassword = tradePassword;
	}

	public String getAppOrderId() {
		return appOrderId;
	}

	public void setAppOrderId(String appOrderId) {
		this.appOrderId = appOrderId;
	}
	
}
