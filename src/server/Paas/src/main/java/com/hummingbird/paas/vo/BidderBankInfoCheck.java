package com.hummingbird.paas.vo;

import java.util.Date;

/**
 * 投标人认证审核接口 
 * @author YJY  
 * @since 2015年11月18日16:59:24
 * @see 用于规范json
 * */

//"bankInfoCheck":{ 
//    "bank":{"result":"OK#","msg":""},
//    "accountId":{"result":"OK#","msg":""},
//    "accountName":{"result":"OK#","msg":""}
//}
public class BidderBankInfoCheck {
	
	private AuditInfo  bank;
	private AuditInfo  accountId;
	private AuditInfo  accountName;
	/**
	 * @return the bank
	 */
	public AuditInfo getBank() {
		return bank;
	}
	/**
	 * @return the accountId
	 */
	public AuditInfo getAccountId() {
		return accountId;
	}
	/**
	 * @return the accountName
	 */
	public AuditInfo getAccountName() {
		return accountName;
	}
	/**
	 * @param bank the bank to set
	 */
	public void setBank(AuditInfo bank) {
		this.bank = bank;
	}
	/**
	 * @param accountId the accountId to set
	 */
	public void setAccountId(AuditInfo accountId) {
		this.accountId = accountId;
	}
	/**
	 * @param accountName the accountName to set
	 */
	public void setAccountName(AuditInfo accountName) {
		this.accountName = accountName;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "BiddeeBankInfoCheck [bank=" + bank + ", accountId=" + accountId + ", accountName=" + accountName + "]";
	}
	
}
