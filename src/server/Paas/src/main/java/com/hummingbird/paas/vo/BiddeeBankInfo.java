package com.hummingbird.paas.vo;

import java.util.Date;

/**
 * 招标人开户行信息  
 * @author YJY  
 * @since 2015年11月7日11:06:3
 * @see 用于规范json
 * */

//"bankInfo":{ 
//    "bank":"招商银行深圳支行",
//    "accountId":"1234567812345678",
//    "accountName":"深圳麦圈互动技术有限公司"
//}
public class BiddeeBankInfo {
	
	private String  bank;
	private String  accountId;
	/**
     * 开户人名称
     */
    private String accountName;

    /**
     * 税号
     */
    private String taxNo;

    /**
     * 公司地址
     */
    private String address;

    /**
     * 电话
     */
    private String telephone;


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
		return "BiddeeBankInfo [bank=" + bank + ", accountId=" + accountId + ", accountName=" + accountName + ", taxNo="
				+ taxNo + ", address=" + address + ", telephone=" + telephone + "]";
	}



	/**
	 * 税号 
	 */
	public String getTaxNo() {
		return taxNo;
	}



	/**
	 * 税号 
	 */
	public void setTaxNo(String taxNo) {
		this.taxNo = taxNo;
	}



	/**
	 * 公司地址 
	 */
	public String getAddress() {
		return address;
	}



	/**
	 * 公司地址 
	 */
	public void setAddress(String address) {
		this.address = address;
	}



	/**
	 * 电话 
	 */
	public String getTelephone() {
		return telephone;
	}



	/**
	 * 电话 
	 */
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

}
