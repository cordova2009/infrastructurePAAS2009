package com.hummingbird.paas.vo;

public class MyIncomeOverallReturnVO {
	/*"overall":{
    "objectNum":7,
    "allAmount":"5,000,000.00",
    "receivedAmount":"5,000.00",
    "willReceiveAmount":"4,000.00",
    "nextPeriodReceiveAmount":"3,000.00"
}*/
	private Integer objectNum;
	private String allAmount;
	private String receivedAmount;
	private String willReceiveAmount;
	private String nextPeriodReceiveAmount;
	
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
	public String getReceivedAmount() {
		return receivedAmount;
	}
	public void setReceivedAmount(String receivedAmount) {
		this.receivedAmount = receivedAmount;
	}
	public String getWillReceiveAmount() {
		return willReceiveAmount;
	}
	public void setWillReceiveAmount(String willReceiveAmount) {
		this.willReceiveAmount = willReceiveAmount;
	}
	public String getNextPeriodReceiveAmount() {
		return nextPeriodReceiveAmount;
	}
	public void setNextPeriodReceiveAmount(String nextPeriodReceiveAmount) {
		this.nextPeriodReceiveAmount = nextPeriodReceiveAmount;
	}
	
}
