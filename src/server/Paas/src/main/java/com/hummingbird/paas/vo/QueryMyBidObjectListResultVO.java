package com.hummingbird.paas.vo;

import java.util.Date;

public class QueryMyBidObjectListResultVO {
//	"industryId":3,
//    "objectId":"32456",
//    "objectName":"7665",
//    "bidAmount":"430000",
//    "bidOpenDate":"2015-05-14"
	private String objectId;
	private String objetName;
	private String industryId;
	private String bidAmount;
	private Date bidOpenDate;
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
	 * @return the bidAmount
	 */
	public String getBidAmount() {
		return bidAmount;
	}
	/**
	 * @return the bidOpenDate
	 */
	public Date getBidOpenDate() {
		return bidOpenDate;
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
	 * @param bidAmount the bidAmount to set
	 */
	public void setBidAmount(String bidAmount) {
		this.bidAmount = bidAmount;
	}
	/**
	 * @param bidOpenDate the bidOpenDate to set
	 */
	public void setBidOpenDate(Date bidOpenDate) {
		this.bidOpenDate = bidOpenDate;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "QueryMyBidObjectListResultVO [objectId=" + objectId + ", objetName=" + objetName + ", industryId="
				+ industryId + ", bidAmount=" + bidAmount + ", bidOpenDate=" + bidOpenDate + "]";
	}


}
