package com.hummingbird.paas.vo;

public class FreezeBondReturnVO {
	/*"order":{
    "orderId":"ORDER_ID"
    "accountId":"1234123412341234",
    "type":"见数据库定义",
    "flowDirection":"OUT",
    "balance":30000,
    "amount":20000,
    "remark":"冻结30000元撮合担保金"
}*/
	private String orderId;
	private String accountId;
	private String type;
	private String flowDirection;
	private Integer balance;
	private Integer amount;
	private String remark;
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public String getAccountId() {
		return accountId;
	}
	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getFlowDirection() {
		return flowDirection;
	}
	public void setFlowDirection(String flowDirection) {
		this.flowDirection = flowDirection;
	}
	
	public Integer getBalance() {
		return balance;
	}
	public void setBalance(Integer balance) {
		this.balance = balance;
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
	
}
