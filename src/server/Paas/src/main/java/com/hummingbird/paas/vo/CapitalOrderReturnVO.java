package com.hummingbird.paas.vo;

/**
 * @author john huang
 * 2015年12月11日 上午10:39:58
 * 本类主要做为 资金调用接口返回对象
 */
public class CapitalOrderReturnVO {
	/*"order":{
    "orderId":"ORDER_ID"
    "accountId":"1234123412341234",
    "type":"见数据库定义",
    "flowDirection":"OUT",
    "balance":"30000",
    "amount":"20000",
    "remark":"冻结30000元撮合担保金"
}*/
	private String orderId;
	private String accountId;
	private String type;
	private String flowDirection;
	private String balance;
	private String amount;
	private String remark;
	/**
	 * 应用订单号
	 */
	private String appOrderId;
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "CapitalOrderReturnVO [orderId=" + orderId + ", accountId=" + accountId + ", type=" + type
				+ ", flowDirection=" + flowDirection + ", balance=" + balance + ", amount=" + amount + ", remark="
				+ remark + ", appOrderId=" + appOrderId + "]";
	}
	
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
	
	
	public String getBalance() {
		return balance;
	}
	public void setBalance(String balance) {
		this.balance = balance;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}

	/**
	 * 应用订单号 
	 */
	public String getAppOrderId() {
		return appOrderId;
	}

	/**
	 * 应用订单号 
	 */
	public void setAppOrderId(String appOrderId) {
		this.appOrderId = appOrderId;
	}
	
}
