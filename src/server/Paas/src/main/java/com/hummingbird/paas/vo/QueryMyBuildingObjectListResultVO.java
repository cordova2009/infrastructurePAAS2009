package com.hummingbird.paas.vo;

import java.util.Date;

import org.codehaus.jackson.map.annotate.JsonSerialize;

import com.hummingbird.common.util.convertor.JacksonDateSerializer;

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
	private Long winBidAmount;
	private Long receivedAmount;
	private Long willReceiveAmount;
	private String projectExpectStartDate;
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
	public Long getWinBidAmount() {
		return winBidAmount;
	}
	/**
	 * @return the receivedAmount
	 */
	public Long getReceivedAmount() {
		return receivedAmount;
	}
	/**
	 * @return the willReceiveAmount
	 */
	public Long getWillReceiveAmount() {
		return willReceiveAmount;
	}
	/**
	 * @return the projectExpectStartDate
	 */
	public String getProjectExpectStartDate() {
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
	public void setWinBidAmount(Long winBidAmount) {
		this.winBidAmount = winBidAmount;
	}
	/**
	 * @param receivedAmount the receivedAmount to set
	 */
	public void setReceivedAmount(Long receivedAmount) {
		this.receivedAmount = receivedAmount;
	}
	/**
	 * @param willReceiveAmount the willReceiveAmount to set
	 */
	public void setWillReceiveAmount(Long willReceiveAmount) {
		this.willReceiveAmount = willReceiveAmount;
	}
	/**
	 * @param projectExpectStartDate the projectExpectStartDate to set
	 */
	public void setProjectExpectStartDate(String projectExpectStartDate) {
		this.projectExpectStartDate = projectExpectStartDate;
	}
	/**
	 * @param projectExpectPeriod the projectExpectPeriod to set
	 */
	public void setProjectExpectPeriod(Integer projectExpectPeriod) {
		this.projectExpectPeriod = projectExpectPeriod;
	}
	
	

	
}
