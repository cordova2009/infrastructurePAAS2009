package com.hummingbird.paas.vo;

public class PaidAmountDetailReturnVO {
	/*"list":{
	    "fundName":"第六期",
	    "amount":"40,000.00",
	    "transferDate":"2015-12-12",
	    "bankName":"招商银行科兴支行",
	    "voucherNo":"1234561234567890",
	}*/
	private String fundName;
	private String amount;
	private String transferDate;
	private String bankName;
	private String voucherNo;
	/**
	 * 支付状态,,NON待支付,CRT 已支付待确认,OK# 支付确认,FLS 支付失败(确认失败)
	 */
	private String payStatus;
	
	
	
	public String getFundName() {
		return fundName;
	}
	public void setFundName(String fundName) {
		this.fundName = fundName;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	public String getTransferDate() {
		return transferDate;
	}
	public void setTransferDate(String transferDate) {
		this.transferDate = transferDate;
	}
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	public String getVoucherNo() {
		return voucherNo;
	}
	public void setVoucherNo(String voucherNo) {
		this.voucherNo = voucherNo;
	}
	/**
	 * 支付状态NON待支付CRT 已支付待确认OK# 支付确认FLS 支付失败(确认失败) 
	 */
	public String getPayStatus() {
		return payStatus;
	}
	/**
	 * 支付状态NON待支付CRT 已支付待确认OK# 支付确认FLS 支付失败(确认失败) 
	 */
	public void setPayStatus(String payStatus) {
		this.payStatus = payStatus;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "PaidAmountDetailReturnVO [fundName=" + fundName + ", amount=" + amount + ", transferDate="
				+ transferDate + ", bankName=" + bankName + ", voucherNo=" + voucherNo + ", payStatus=" + payStatus
				+ "]";
	}
	
}
