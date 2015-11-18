package com.hummingbird.paas.vo;

import java.util.Date;

/**
 * 投标人开户行信息  
 * @author YJY  
 * @since 2015年11月10日16:21:54
 * @see 用于规范json
 * */

//"bankInfo":{ 
//    "bank":"招商银行深圳支行",
//    "accountId":"1234567812345678",
//    "accountName":"深圳麦圈互动技术有限公司"
//}
public class BidderBankInfo {
	
	private String  bank;
	private String  accountId;
	private String  accountName;


	/**
	 * @return the bank
	 */
	public String getBank() {
		return bank;
	}



	/**
	 * @return the accountId
	 */
	public String getAccountId() {
		return accountId;
	}



	/**
	 * @return the accountName
	 */
	public String getAccountName() {
		return accountName;
	}



	/**
	 * @param bank the bank to set
	 */
	public void setBank(String bank) {
		this.bank = bank;
	}



	/**
	 * @param accountId the accountId to set
	 */
	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}



	/**
	 * @param accountName the accountName to set
	 */
	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}



	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "BiddeeBankInfo [bank=" + bank + ", accountId=" + accountId + ", accountName=" + accountName + "]";
	}

}
