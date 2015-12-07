package com.hummingbird.paas.vo;

import java.util.Date;

public class MyObjectPaymentBodyVO {
	private String token;
	private String objectId;
	private Date transferTime;
	private String bankName;
	private String voucherNo;
	private Long amount;
	private String voucherFileUrl;
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public String getObjectId() {
		return objectId;
	}
	public void setObjectId(String objectId) {
		this.objectId = objectId;
	}
	public Date getTransferTime() {
		return transferTime;
	}
	public void setTransferTime(Date transferTime) {
		this.transferTime = transferTime;
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
	public Long getAmount() {
		return amount;
	}
	public void setAmount(Long amount) {
		this.amount = amount;
	}
	public String getVoucherFileUrl() {
		return voucherFileUrl;
	}
	public void setVoucherFileUrl(String voucherFileUrl) {
		this.voucherFileUrl = voucherFileUrl;
	}
	
	
}
