package com.hummingbird.paas.vo;

public class FreezeBondBodyVO {
	private String token;
	private String type;
	private Integer amount;
	private String originalOrderId;
	private String originalTable;
	private String objectId;
	private String remark;
	private String tradePassword;
	
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
	public String getOriginalOrderId() {
		return originalOrderId;
	}
	public void setOriginalOrderId(String originalOrderId) {
		this.originalOrderId = originalOrderId;
	}
	public String getOriginalTable() {
		return originalTable;
	}
	public void setOriginalTable(String originalTable) {
		this.originalTable = originalTable;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	
	public Integer getAmount() {
		return amount;
	}
	public void setAmount(Integer amount) {
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
	
}
