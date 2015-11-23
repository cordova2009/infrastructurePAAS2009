package com.hummingbird.paas.vo;

public class MyPaymentOverallReturnVO {

	/*"overall":{
	    "objectNum":7,
	    "allAmount":"5,000,000.00",
	    "paidAmount":"5,000.00",
	    "willPayAmount":"4,000.00",
	    "nextPeriodPayAmount":"3,000.00"
	}*/
	private Integer objectNum;
	private String allAmount;
	private String paidAmount;
	private String willPayAmount;
	private String nextPeriodPayAmount;
	public Integer getObjectNum() {
		return objectNum;
	}
	public void setObjectNum(Integer objectNum) {
		this.objectNum = objectNum;
	}
	public String getAllAmount() {
		return allAmount;
	}
	public void setAllAmount(String allAmount) {
		this.allAmount = allAmount;
	}
	public String getPaidAmount() {
		return paidAmount;
	}
	public void setPaidAmount(String paidAmount) {
		this.paidAmount = paidAmount;
	}
	public String getWillPayAmount() {
		return willPayAmount;
	}
	public void setWillPayAmount(String willPayAmount) {
		this.willPayAmount = willPayAmount;
	}
	public String getNextPeriodPayAmount() {
		return nextPeriodPayAmount;
	}
	public void setNextPeriodPayAmount(String nextPeriodPayAmount) {
		this.nextPeriodPayAmount = nextPeriodPayAmount;
	}
	
}
