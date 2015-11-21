package com.hummingbird.paas.vo;

public class QueryProjectAccountReturnVO {
	/*"account":{
	    "accountId":"210029328478272",
	    "remainingSum":2000,
	    "frozenSum":2000,
	    "status":"OK#"
	}*/
	private String accountId;
	private Double remainingSum;
	private Double frozenSum;
	private String status;
	public String getAccountId() {
		return accountId;
	}
	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}
	
	public Double getRemainingSum() {
		return remainingSum;
	}
	public void setRemainingSum(Double remainingSum) {
		this.remainingSum = remainingSum;
	}
	public Double getFrozenSum() {
		return frozenSum;
	}
	public void setFrozenSum(Double frozenSum) {
		this.frozenSum = frozenSum;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
}
