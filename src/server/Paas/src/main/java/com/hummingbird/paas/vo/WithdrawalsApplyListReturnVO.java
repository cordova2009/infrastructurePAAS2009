package com.hummingbird.paas.vo;

import java.util.Date;

public class WithdrawalsApplyListReturnVO {
	/*"list":[{
    "createTime":"2015-10-10 10:00:00",
    "amount":"2000.00",
    "handingCharge":"20.00",
    "status":"DON",
    "remark":"已经银行转账，预计10月12日到账",
    "withdrawalsTime":"2015-10-12 10:00:00",
    "withdrawalsNo":"WITHDRAWAL_NO"
}]*/
	private Date createTime;
	private Date withdrawalsTime;
	private String amount;
	private String handingCharge;
	private String status;
	private String remark;
	private String withdrawalsNo;
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Date getWithdrawalsTime() {
		return withdrawalsTime;
	}
	public void setWithdrawalsTime(Date withdrawalsTime) {
		this.withdrawalsTime = withdrawalsTime;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	public String getHandingCharge() {
		return handingCharge;
	}
	public void setHandingCharge(String handingCharge) {
		this.handingCharge = handingCharge;
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
	public String getWithdrawalsNo() {
		return withdrawalsNo;
	}
	public void setWithdrawalsNo(String withdrawalsNo) {
		this.withdrawalsNo = withdrawalsNo;
	}
}
