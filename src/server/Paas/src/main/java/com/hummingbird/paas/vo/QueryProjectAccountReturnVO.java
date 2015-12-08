package com.hummingbird.paas.vo;

public class QueryProjectAccountReturnVO {
	/*"account":{
	    "accountId":"210029328478272",
	    "remainingSum":2000,
	    "frozenSum":2000,
	    "status":"OK#"
	}*/
	private String accountId;
	private Long remainingSum;
	private Long frozenSum;
	private String status;
	
	@Override
	public String toString() {
		return "QueryProjectAccountReturnVO [accountId=" + accountId + ", remainingSum=" + remainingSum +
				",frozenSum=" + frozenSum +",status="+status+"]";
	}
	
	public String getAccountId() {
		return accountId;
	}
	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}
	
	
	public Long getRemainingSum() {
		return remainingSum;
	}

	public void setRemainingSum(Long remainingSum) {
		this.remainingSum = remainingSum;
	}

	public Long getFrozenSum() {
		return frozenSum;
	}

	public void setFrozenSum(Long frozenSum) {
		this.frozenSum = frozenSum;
	}

	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
}
