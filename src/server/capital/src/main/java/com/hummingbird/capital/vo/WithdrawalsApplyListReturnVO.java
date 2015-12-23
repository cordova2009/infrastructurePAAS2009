package com.hummingbird.capital.vo;

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
	private String createTime;
	/**
	 * 提现申请金额
	 */
	private String withdrawalsTime;
	private String amount;
	/**
	 * 手续费
	 */
	private String handingCharge;
	/**
	 * 转帐状态
	 */
	private String status;
	private String remark;
	private String withdrawalsNo;
	/**
	 * 真正提现金额
	 */
	private String realWithdrawalsAmount;
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "WithdrawalsApplyListReturnVO [createTime=" + createTime + ", withdrawalsTime=" + withdrawalsTime
				+ ", amount=" + amount + ", handingCharge=" + handingCharge + ", status=" + status + ", remark="
				+ remark + ", withdrawalsNo=" + withdrawalsNo + ", realWithdrawalsAmount=" + realWithdrawalsAmount
				+ "]";
	}
	
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	public String getWithdrawalsTime() {
		return withdrawalsTime;
	}
	public void setWithdrawalsTime(String withdrawalsTime) {
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

	/**
	 * 真正提现金额 
	 */
	public String getRealWithdrawalsAmount() {
		return realWithdrawalsAmount;
	}

	/**
	 * 真正提现金额 
	 */
	public void setRealWithdrawalsAmount(String realWithdrawalsAmount) {
		this.realWithdrawalsAmount = realWithdrawalsAmount;
	}
}
