package com.hummingbird.paas.vo;

public class UnfreezeVO {
	private String objectId;
	private String type;
	private String appOrderId;
	private String orignalOrderId;
	private String orignalTable;
	private Long sum;
	private String remark;
	
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
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
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
	public String getOrignalTable() {
		return orignalTable;
	}
	public void setOrignalTable(String orignalTable) {
		this.orignalTable = orignalTable;
	}
	public Long getSum() {
		return sum;
	}
	public void setSum(Long sum) {
		this.sum = sum;
	}
	
}
