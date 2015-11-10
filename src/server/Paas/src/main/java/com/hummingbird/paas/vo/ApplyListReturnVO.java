package com.hummingbird.paas.vo;

import java.util.Date;

public class ApplyListReturnVO {
	/*"list":{
    "createTime":"2015-10-10 10:00:00",
    "amount":"2000.00",
    "status":"DON",
    "remark":"已经收到款项，谢谢",
    "rechargeTime":"2015-10-12 10:00:00",
    "voucherNo":"VOUCHER_NO"
}*/
	private Date createTime;
	private String amount;
	private String status;
	private String remark;
	private String voucherNo;
	private Date rechargeTime;
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getVoucherNo() {
		return voucherNo;
	}
	public void setVoucherNo(String voucherNo) {
		this.voucherNo = voucherNo;
	}
	public Date getRechargeTime() {
		return rechargeTime;
	}
	public void setRechargeTime(Date rechargeTime) {
		this.rechargeTime = rechargeTime;
	}
	
	
	
}
