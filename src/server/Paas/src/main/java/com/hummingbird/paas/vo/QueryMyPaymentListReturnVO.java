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
	/**
	 * 下一期期数
	 */
	private Integer nextPeriod;
	/**
     * 状态,CRT待支付,OK#已支付,FLS支付失败,CFM 待确认
     */
    private String status;
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
	/**
	 * 状态CRT待支付OK#已支付FLS支付失败 ,CFM 待确认
	 */
	public String getStatus() {
		return status;
	}
	/**
	 * 状态CRT待支付OK#已支付FLS支付失败 ,CFM 待确认
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "QueryMyPaymentListReturnVO [objectId=" + objectId + ", objectName=" + objectName + ", winBidAmount="
				+ winBidAmount + ", paidAmount=" + paidAmount + ", willPayAmount=" + willPayAmount
				+ ", nextPeriodPayAmount=" + nextPeriodPayAmount + ", nextPeriodPayTime=" + nextPeriodPayTime
				+ ", nextPeriod=" + nextPeriod + ", status=" + status + "]";
	}
	/**
	 * 下一期期数 
	 */
	public Integer getNextPeriod() {
		return nextPeriod;
	}
	/**
	 * 下一期期数 
	 */
	public void setNextPeriod(Integer nextPeriod) {
		this.nextPeriod = nextPeriod;
	}
	
}
