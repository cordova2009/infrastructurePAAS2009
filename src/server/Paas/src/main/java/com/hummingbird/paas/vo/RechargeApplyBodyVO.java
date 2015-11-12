package com.hummingbird.paas.vo;

import java.util.Date;

public class RechargeApplyBodyVO {
	/*"body":{
	    "token":"USER_TOKEN",
	    "transferTime":"2015-10-12",
	    "bankName":"中国银行",
	    "voucherNo":"20150101215522",
	    "amount":100000
	    "voucherFileUrl":"VOCHER_FILE_URL"
	}*/
	private String token;
	private String transferTime;
	private String bankName;
	private String voucherNo;
	private Integer amount;
	private String voucherFileUrl;
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public String getTransferTime() {
		return transferTime;
	}
	public void setTransferTime(String transferTime) {
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
	
	public Integer getAmount() {
		return amount;
	}
	public void setAmount(Integer amount) {
		this.amount = amount;
	}
	public String getVoucherFileUrl() {
		return voucherFileUrl;
	}
	public void setVoucherFileUrl(String voucherFileUrl) {
		this.voucherFileUrl = voucherFileUrl;
	}
	
}
