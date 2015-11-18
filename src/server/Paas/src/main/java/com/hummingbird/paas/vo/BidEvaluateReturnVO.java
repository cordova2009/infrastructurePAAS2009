package com.hummingbird.paas.vo;

import java.util.Date;
import java.util.List;

public class BidEvaluateReturnVO {
//	"biddeeId":5,
//    "biddeeCompanyName":"蜂鸟娱乐",
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
	private String biddeeId;
	private String biddeeCompanyName;
	private String objectId;
	private String objectName;
	private String winBidTime;
	private String winBidAmount;
	private String companyEvaluateScore;
	private String companyEvaluateNum;
	private String   startTime;
	private String   endTime;
	private List tag;
	/**
	 * @return the biddeeId
	 */
	public String getBiddeeId() {
		return biddeeId;
	}
	/**
	 * @return the biddeeCompanyName
	 */
	public String getBiddeeCompanyName() {
		return biddeeCompanyName;
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
	public List getTag() {
		return tag;
	}
	/**
	 * @param biddeeId the biddeeId to set
	 */
	public void setBiddeeId(String biddeeId) {
		this.biddeeId = biddeeId;
	}
	/**
	 * @param biddeeCompanyName the biddeeCompanyName to set
	 */
	public void setBiddeeCompanyName(String biddeeCompanyName) {
		this.biddeeCompanyName = biddeeCompanyName;
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
	public void setTag(List tag) {
		this.tag = tag;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "BidEvaluateReturnVO [biddeeId=" + biddeeId + ", biddeeCompanyName=" + biddeeCompanyName + ", objectId="
				+ objectId + ", objectName=" + objectName + ", winBidTime=" + winBidTime + ", winBidAmount="
				+ winBidAmount + ", companyEvaluateScore=" + companyEvaluateScore + ", companyEvaluateNum="
				+ companyEvaluateNum + ", startTime=" + startTime + ", endTime=" + endTime + ", tag=" + tag + "]";
	}
	
	
	
}
