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
	
	private AuditInfo  bank_name;
	private AuditInfo  account_no;
	private AuditInfo  account_name;
	/**
	 * 电话
	 */
	private AuditInfo  telephone;
	/**
	 * 税号
	 */
	private AuditInfo  tax_no;
	/**
	 * 地址
	 */
	private AuditInfo  address;
	
	/**
	 * @return the bank_name
	 */
	public AuditInfo getBank_name() {
		return bank_name;
	}
	/**
	 * @return the account_no
	 */
	public AuditInfo getAccount_no() {
		return account_no;
	}
	/**
	 * @return the account_name
	 */
	public AuditInfo getAccount_name() {
		return account_name;
	}
	/**
	 * @param bank_name the bank_name to set
	 */
	public void setBank_name(AuditInfo bank_name) {
		this.bank_name = bank_name;
	}
	/**
	 * @param account_no the account_no to set
	 */
	public void setAccount_no(AuditInfo account_no) {
		this.account_no = account_no;
	}
	/**
	 * @param account_name the account_name to set
	 */
	public void setAccount_name(AuditInfo account_name) {
		this.account_name = account_name;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "BidderBankInfoCheck [bank_name=" + bank_name + ", account_no=" + account_no + ", account_name="
				+ account_name + ", telephone=" + telephone + ", tax_no=" + tax_no + ", address=" + address + "]";
	}
	/**
	 * 电话 
	 */
	public AuditInfo getTelephone() {
		return telephone;
	}
	/**
	 * 电话 
	 */
	public void setTelephone(AuditInfo telephone) {
		this.telephone = telephone;
	}
	/**
	 * 税号 
	 */
	public AuditInfo getTax_no() {
		return tax_no;
	}
	/**
	 * 税号 
	 */
	public void setTax_no(AuditInfo tax_no) {
		this.tax_no = tax_no;
	}
	/**
	 * 地址 
	 */
	public AuditInfo getAddress() {
		return address;
	}
	/**
	 * 地址 
	 */
	public void setAddress(AuditInfo address) {
		this.address = address;
	}
	
	
}
