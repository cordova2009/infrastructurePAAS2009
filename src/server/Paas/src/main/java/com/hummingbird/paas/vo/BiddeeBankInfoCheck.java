package com.hummingbird.paas.vo;

import java.util.Date;

/**
 * 招标人认证审核接口 
 * @author YJY  
 * @since 2015年11月7日11:06:3
 * @see 用于规范json
 * */

//"bankInfoCheck":{ 
//    "bank":{"result":"OK#","msg":""},
//    "accountId":{"result":"OK#","msg":""},
//    "accountName":{"result":"OK#","msg":""}
//}
public class BiddeeBankInfoCheck {
	
	private AuditInfo  bank_name;
	private AuditInfo  account_no;
	private AuditInfo  account_name;
	
	private AuditInfo  telephone;
	private AuditInfo  tax_no;
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
	/**
	 * @return the telephone
	 */
	public AuditInfo getTelephone() {
		return telephone;
	}
	/**
	 * @return the tax_no
	 */
	public AuditInfo getTax_no() {
		return tax_no;
	}
	/**
	 * @return the address
	 */
	public AuditInfo getAddress() {
		return address;
	}
	/**
	 * @param telephone the telephone to set
	 */
	public void setTelephone(AuditInfo telephone) {
		this.telephone = telephone;
	}
	/**
	 * @param tax_no the tax_no to set
	 */
	public void setTax_no(AuditInfo tax_no) {
		this.tax_no = tax_no;
	}
	/**
	 * @param address the address to set
	 */
	public void setAddress(AuditInfo address) {
		this.address = address;
	}
	
}
