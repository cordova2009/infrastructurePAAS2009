package com.hummingbird.paas.vo;

public class QueryMyIncomeListReturnVO {
	 /*"list":[{
         "objectId":"OBJECT_ID",
         "objectName":"星河地产地基项目",
         "winBidAmount":"30000000.00",
         "receivedAmount":"100000.00",
         "willReceiveAmount":"20000.00",
         "nextPeriodReceiveAmount":"3000.00",
         "nextPeriodReceiveTime":"2015-12-12 12:00:00",
     }]	*/
	private String objectId;
	private String objectName;
	private String winBidAmount;
	private String receivedAmount;
	private String willReceiveAmount;
	private String nextPeriodReceiveAmount;
	private String nextPeriodReceiveTime;
	public String getObjectId() {
		return objectId;
	}
	public void setObjectId(String objectId) {
		this.objectId = objectId;
	}
	public String getObjectName() {
		return objectName;
	}
	public void setObjectName(String objectName) {
		this.objectName = objectName;
	}
	public String getWinBidAmount() {
		return winBidAmount;
	}
	public void setWinBidAmount(String winBidAmount) {
		this.winBidAmount = winBidAmount;
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
	public String getNextPeriodReceiveTime() {
		return nextPeriodReceiveTime;
	}
	public void setNextPeriodReceiveTime(String nextPeriodReceiveTime) {
		this.nextPeriodReceiveTime = nextPeriodReceiveTime;
	}
	
}
