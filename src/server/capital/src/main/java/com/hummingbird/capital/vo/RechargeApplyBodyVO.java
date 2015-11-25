package com.hummingbird.capital.vo;

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
	private Date transferTime;
	private String bankName;
	private String voucherNo;
	private Long amount;
	private String voucherFileUrl;
	
	@Override
	public String toString() {
		return "RechargeApplyBodyVO [token=" + token + ", transferTime=" + transferTime + 
				",bankName=" + bankName +",voucherNo="+voucherNo+ 
				",amount="+amount+",voucherFileUrl+"+voucherFileUrl+"]";
	}
	
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
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
