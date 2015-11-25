package com.hummingbird.capital.vo;

public class CheckRechargeApplyBodyVO {
	/*"body":{
		"orderId":"ORDER_ID",
		"checkWithdrawalsNo":"CHECK_WITHDRAWALS_NO"
		"checkResult":"OK#",
		"remark":"完成充值申请审核，充值10000元",
	    "operator":1
	}*/
	private String orderId;
	private String checkWithdrawalsNo;
	private String checkResult;
	private String remark;
	private Integer operator;
	
	@Override
	public String toString() {
		return "CapitalSurveyReturnVO [orderId=" + orderId + ", checkWithdrawalsNo=" + checkWithdrawalsNo + 
				",checkResult=" + checkResult +",remark="+remark+ 
				",operator="+operator+"]";
	}
	
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public String getCheckWithdrawalsNo() {
		return checkWithdrawalsNo;
	}
	public void setCheckWithdrawalsNo(String checkWithdrawalsNo) {
		this.checkWithdrawalsNo = checkWithdrawalsNo;
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
