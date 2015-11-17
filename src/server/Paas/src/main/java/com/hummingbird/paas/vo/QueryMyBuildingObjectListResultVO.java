package com.hummingbird.paas.vo;

import java.util.Date;

public class QueryMyBuildingObjectListResultVO {
//	"objectId":"32456",
//    "objectName":"7665",
//    "winBidAmount":"30000000",
//    "receivedAmount":"3000000",
//    "willReceiveAmount":"20020000",
//    "projectExpectStartDate":"2015-06-12",
//    "projectExpectPeriod":300
	private String objectId;
	private String objetName;
	private String winBidAmount;
	private String receivedAmount;
	private String willReceiveAmount;
	private Date projectExpectStartDate;
	private Integer projectExpectPeriod;
	/**
	 * @return the objectId
	 */
	public String getObjectId() {
		return objectId;
	}
	/**
	 * @return the objetName
	 */
	public String getObjetName() {
		return objetName;
	}
	/**
	 * @return the winBidAmount
	 */
	public String getWinBidAmount() {
		return winBidAmount;
	}
	/**
	 * @return the receivedAmount
	 */
	public String getReceivedAmount() {
		return receivedAmount;
	}
	/**
	 * @return the willReceiveAmount
	 */
	public String getWillReceiveAmount() {
		return willReceiveAmount;
	}
	/**
	 * @return the projectExpectStartDate
	 */
	public Date getProjectExpectStartDate() {
		return projectExpectStartDate;
	}
	/**
	 * @return the projectExpectPeriod
	 */
	public Integer getProjectExpectPeriod() {
		return projectExpectPeriod;
	}
	/**
	 * @param objectId the objectId to set
	 */
	public void setObjectId(String objectId) {
		this.objectId = objectId;
	}
	/**
	 * @param objetName the objetName to set
	 */
	public void setObjetName(String objetName) {
		this.objetName = objetName;
	}
	/**
	 * @param winBidAmount the winBidAmount to set
	 */
	public void setWinBidAmount(String winBidAmount) {
		this.winBidAmount = winBidAmount;
	}
	/**
	 * @param receivedAmount the receivedAmount to set
	 */
	public void setReceivedAmount(String receivedAmount) {
		this.receivedAmount = receivedAmount;
	}
	/**
	 * @param willReceiveAmount the willReceiveAmount to set
	 */
	public void setWillReceiveAmount(String willReceiveAmount) {
		this.willReceiveAmount = willReceiveAmount;
	}
	/**
	 * @param projectExpectStartDate the projectExpectStartDate to set
	 */
	public void setProjectExpectStartDate(Date projectExpectStartDate) {
		this.projectExpectStartDate = projectExpectStartDate;
	}
	/**
	 * @param projectExpectPeriod the projectExpectPeriod to set
	 */
	public void setProjectExpectPeriod(Integer projectExpectPeriod) {
		this.projectExpectPeriod = projectExpectPeriod;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "QueryMyBuildingObjectListResultVO [objectId=" + objectId + ", objetName=" + objetName
				+ ", winBidAmount=" + winBidAmount + ", receivedAmount=" + receivedAmount + ", willReceiveAmount="
				+ willReceiveAmount + ", projectExpectStartDate=" + projectExpectStartDate + ", projectExpectPeriod="
				+ projectExpectPeriod + "]";
	}
	

}
