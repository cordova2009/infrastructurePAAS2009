package com.hummingbird.paas.vo;

import java.util.Date;

public class QueryMyLoseObjectListResultVO {
//	"industryId":3,
//    "objectId":"32456",
//    "objectName":"7665",
//    "bidAmount":"30000000",
//    "biddee":"麦圈互动"
	private String objectId;
	private String objetName;
	private String industryId;
	private String winBidAmount;
	private String biddee;
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
	 * @return the industryId
	 */
	public String getIndustryId() {
		return industryId;
	}
	/**
	 * @return the winBidAmount
	 */
	public String getWinBidAmount() {
		return winBidAmount;
	}
	/**
	 * @return the biddee
	 */
	public String getBiddee() {
		return biddee;
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
	 * @param industryId the industryId to set
	 */
	public void setIndustryId(String industryId) {
		this.industryId = industryId;
	}
	/**
	 * @param winBidAmount the winBidAmount to set
	 */
	public void setWinBidAmount(String winBidAmount) {
		this.winBidAmount = winBidAmount;
	}
	/**
	 * @param biddee the biddee to set
	 */
	public void setBiddee(String biddee) {
		this.biddee = biddee;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "QueryMyLoseObjectListResultVO [objectId=" + objectId + ", objetName=" + objetName + ", industryId="
				+ industryId + ", winBidAmount=" + winBidAmount + ", biddee=" + biddee + "]";
	}
	


}
