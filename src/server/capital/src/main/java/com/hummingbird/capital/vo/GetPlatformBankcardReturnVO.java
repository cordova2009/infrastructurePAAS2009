package com.hummingbird.capital.vo;

public class GetPlatformBankcardReturnVO {
	/*"bankInfo":{
	    "accountId":"ACCOUNTID",
		"accountName":"账户名称",
		"bankName":"银行名称"
	}*/
	private String accountId;
	private String accountName;
	private String bankName;
	public String getAccountId() {
		return accountId;
	}
	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}
	public String getAccountName() {
		return accountName;
	}
	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	
}
