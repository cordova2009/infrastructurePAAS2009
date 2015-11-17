package com.hummingbird.usercenter.vo;

public class BankInfoReturnDetailVO {
	/*{
        "bankId":"BANK_ID", 
        "bank":"招商银行深圳支行",
        "accountId":"1234567812345678",
        "accountName":"深圳麦圈互动技术有限公司"
    },*/
	private Integer bankId;
	private String bank;
	private String accountId;
	private String accountName;
	public Integer getBankId() {
		return bankId;
	}
	public void setBankId(Integer bankId) {
		this.bankId = bankId;
	}
	public String getBank() {
		return bank;
	}
	public void setBank(String bank) {
		this.bank = bank;
	}
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
	
}
