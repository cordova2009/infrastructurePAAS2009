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
	
}
