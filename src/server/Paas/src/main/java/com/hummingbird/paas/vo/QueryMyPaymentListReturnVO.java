package com.hummingbird.paas.vo;

public class QueryMyPaymentListReturnVO {
	/*"list":[{
        "objectId":"OBJECT_ID",
        "objectName":"星河地产地基项目",
        "winBidAmount":"30000000.00",
        "paidAmount":"100000.00",
        "willPayAmount":"20000.00",
        "nextPeriodPayAmount":"3000.00",
        "nextPeriodPayTime":"2015-12-12 12:00:00",
    }]*/
	private String objectId;
	private String objectName;
	private String winBidAmount;
	private String paidAmount;
	private String willPayAmount;
	private String nextPeriodPayAmount;
	private String nextPeriodPayTime;
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
	public String getNextPeriodPayTime() {
		return nextPeriodPayTime;
	}
	public void setNextPeriodPayTime(String nextPeriodPayTime) {
		this.nextPeriodPayTime = nextPeriodPayTime;
	}
	
}
