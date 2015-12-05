package com.hummingbird.paas.vo;

import java.util.Date;
import java.util.List;

import com.hummingbird.paas.entity.Tag;

public class TendererEvaluateReturnVO {
//	 "evaluateInfo":{
//    "bidderId":5,
//    "bidderCompanyName":"蜂鸟娱乐",
//    "objectId":"BH2015029371",
//    "objectName":"万科金域华府2期开发",
//    "winBidAmount":"50000",
//    "companyEvaluateScore":7,
//    "companyEvaluateNum":8,
//    "tag":[{
//        "tagName":"质量好啊","tagNum":3
//    },{
//        "tagName":"速度很快","tagNum":4
//    }]
//}
	private String bidderId;
	private String bidderCompanyName;
	private String objectId;
	private String objectName;
	private String winBidTime;
	private String winBidAmount;
	private String companyEvaluateScore;
	private String companyEvaluateNum;
	private String startTime;
	private String endTime;
	/**
	 * 公司投标
	 */
	private String logo;
	private List<TagInfo> tag;
	/**
	 * @return the bidderId
	 */
	public String getBidderId() {
		return bidderId;
	}
	/**
	 * @return the bidderCompanyName
	 */
	public String getBidderCompanyName() {
		return bidderCompanyName;
	}
	/**
	 * @return the objectId
	 */
	public String getObjectId() {
		return objectId;
	}
	/**
	 * @return the objectName
	 */
	public String getObjectName() {
		return objectName;
	}
	/**
	 * @return the winBidTime
	 */
	public String getWinBidTime() {
		return winBidTime;
	}
	/**
	 * @return the winBidAmount
	 */
	public String getWinBidAmount() {
		return winBidAmount;
	}
	/**
	 * @return the companyEvaluateScore
	 */
	public String getCompanyEvaluateScore() {
		return companyEvaluateScore;
	}
	/**
	 * @return the companyEvaluateNum
	 */
	public String getCompanyEvaluateNum() {
		return companyEvaluateNum;
	}
	/**
	 * @return the startTime
	 */
	public String getStartTime() {
		return startTime;
	}
	/**
	 * @return the endTime
	 */
	public String getEndTime() {
		return endTime;
	}
	/**
	 * @return the tag
	 */
	public List<TagInfo> getTag() {
		return tag;
	}
	/**
	 * @param bidderId the bidderId to set
	 */
	public void setBidderId(String bidderId) {
		this.bidderId = bidderId;
	}
	/**
	 * @param bidderCompanyName the bidderCompanyName to set
	 */
	public void setBidderCompanyName(String bidderCompanyName) {
		this.bidderCompanyName = bidderCompanyName;
	}
	/**
	 * @param objectId the objectId to set
	 */
	public void setObjectId(String objectId) {
		this.objectId = objectId;
	}
	/**
	 * @param objectName the objectName to set
	 */
	public void setObjectName(String objectName) {
		this.objectName = objectName;
	}
	/**
	 * @param winBidTime the winBidTime to set
	 */
	public void setWinBidTime(String winBidTime) {
		this.winBidTime = winBidTime;
	}
	/**
	 * @param winBidAmount the winBidAmount to set
	 */
	public void setWinBidAmount(String winBidAmount) {
		this.winBidAmount = winBidAmount;
	}
	/**
	 * @param companyEvaluateScore the companyEvaluateScore to set
	 */
	public void setCompanyEvaluateScore(String companyEvaluateScore) {
		this.companyEvaluateScore = companyEvaluateScore;
	}
	/**
	 * @param companyEvaluateNum the companyEvaluateNum to set
	 */
	public void setCompanyEvaluateNum(String companyEvaluateNum) {
		this.companyEvaluateNum = companyEvaluateNum;
	}
	/**
	 * @param startTime the startTime to set
	 */
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	/**
	 * @param endTime the endTime to set
	 */
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	/**
	 * @param tag the tag to set
	 */
	public void setTag(List<TagInfo> tag) {
		this.tag = tag;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "TendererEvaluateReturnVO [bidderId=" + bidderId + ", bidderCompanyName=" + bidderCompanyName
				+ ", objectId=" + objectId + ", objectName=" + objectName + ", winBidTime=" + winBidTime
				+ ", winBidAmount=" + winBidAmount + ", companyEvaluateScore=" + companyEvaluateScore
				+ ", companyEvaluateNum=" + companyEvaluateNum + ", startTime=" + startTime + ", endTime=" + endTime
				+ ", logo=" + logo + ", tag=" + tag + "]";
	}
	/**
	 * 公司投标 
	 */
	public String getLogo() {
		return logo;
	}
	/**
	 * 公司投标 
	 */
	public void setLogo(String logo) {
		this.logo = logo;
	}
	
	
}
