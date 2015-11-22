package com.hummingbird.paas.vo;

import java.util.Date;

public class CheckWithdrawalBodyVO {
	/*"body":{
		"orderId":"ORDER_ID",
		"transferTime":"2015-10-12",
	    "voucherNo":"20150101215522",
	    "amount":100000
	    "voucherFileUrl":"VOCHER_FILE_URL"
		"checkResult":"OK#",
		"remark":"完成提现申请审核，转账10000元",
	    "operator":1
	}*/
	private String orderId;
	private Date transferTime;
	private String voucherNo;
	private String voucherFileUrl;
	private String checkResult;
	private String remark;
	private Integer operator;
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public Date getTransferTime() {
		return transferTime;
	}
	public void setTransferTime(Date transferTime) {
		this.transferTime = transferTime;
	}
	public String getVoucherNo() {
		return voucherNo;
	}
	public void setVoucherNo(String voucherNo) {
		this.voucherNo = voucherNo;
	}
	public String getVoucherFileUrl() {
		return voucherFileUrl;
	}
	public void setVoucherFileUrl(String voucherFileUrl) {
		this.voucherFileUrl = voucherFileUrl;
	}
	public String getCheckResult() {
		return checkResult;
	}
	public void setCheckResult(String checkResult) {
		this.checkResult = checkResult;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public Integer getOperator() {
		return operator;
	}
	public void setOperator(Integer operator) {
		this.operator = operator;
	}
	
	
}
