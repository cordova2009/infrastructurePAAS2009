package com.hummingbird.paas.vo;

public class FreezeWithdrawalsBodyVO {
	/*"body":{
	    "orderId":"ORDER_ID",
	    "mobileNum":"13714770857",
	    "tradePassword":"TRADE_PASSWORD",
	    "peerAccountUnit":"中国银行",
	    "peerAccountId":"20150101215522",
	    "amount":100000,
	    "remark":"完成提现申请审核，转账10000元"
	}*/
	private String orderId;
	private String mobileNum;
	private String tradePassword;
	private String peerAccountUnit;
	private String peerAccountId;
	private Long amount;
	private String remark;
	
	public String getMobileNum() {
		return mobileNum;
	}
	public void setMobileNum(String mobileNum) {
		this.mobileNum = mobileNum;
	}
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public String getTradePassword() {
		return tradePassword;
	}
	public void setTradePassword(String tradePassword) {
		this.tradePassword = tradePassword;
	}
	public String getPeerAccountUnit() {
		return peerAccountUnit;
	}
	public void setPeerAccountUnit(String peerAccountUnit) {
		this.peerAccountUnit = peerAccountUnit;
	}
	public String getPeerAccountId() {
		return peerAccountId;
	}
	public void setPeerAccountId(String peerAccountId) {
		this.peerAccountId = peerAccountId;
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
	
	
	
}
