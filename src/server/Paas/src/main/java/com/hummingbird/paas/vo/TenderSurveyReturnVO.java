package com.hummingbird.paas.vo;

import java.util.Date;

/**
 * 消息详细
 * @author YJY  
 * @since 2015年11月11日22:12:08
 * */
public class TenderSurveyReturnVO {
//	"survey":{
//    "bidderNum":6,
//    "objectName":"标的名称",
//    "maxBidAmount":"2300000",
//    "minBidAmount":"2000000"
//}
	private Integer bidderNum;
	private String  objectName;
	private Integer maxBidAmount;
	private Integer minBidAmount;
	/**
	 * @return the bidderNum
	 */
	public Integer getBidderNum() {
		return bidderNum;
	}
	/**
	 * @return the objectName
	 */
	public String getObjectName() {
		return objectName;
	}
	/**
	 * @return the maxBidAmount
	 */
	public Integer getMaxBidAmount() {
		return maxBidAmount;
	}
	/**
	 * @return the minBidAmount
	 */
	public Integer getMinBidAmount() {
		return minBidAmount;
	}
	/**
	 * @param bidderNum the bidderNum to set
	 */
	public void setBidderNum(Integer bidderNum) {
		this.bidderNum = bidderNum;
	}
	/**
	 * @param objectName the objectName to set
	 */
	public void setObjectName(String objectName) {
		this.objectName = objectName;
	}
	/**
	 * @param maxBidAmount the maxBidAmount to set
	 */
	public void setMaxBidAmount(Integer maxBidAmount) {
		this.maxBidAmount = maxBidAmount;
	}
	/**
	 * @param minBidAmount the minBidAmount to set
	 */
	public void setMinBidAmount(Integer minBidAmount) {
		this.minBidAmount = minBidAmount;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "TenderSurveyReturnVO [bidderNum=" + bidderNum + ", objectName=" + objectName + ", maxBidAmount="
				+ maxBidAmount + ", minBidAmount=" + minBidAmount + "]";
	}
	


}
