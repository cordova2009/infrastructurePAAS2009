package com.hummingbird.paas.vo;

import java.util.Date;

import com.hummingbird.commonbiz.vo.PagingnationVO;

/**
 * 消息详细
 * @author YJY  
 * @since 2015年11月11日22:12:08
 * */
public class TenderMyEndedObjectVO extends PagingnationVO {
//	"list":[{
//        "industryId":3,
//        "objectId":"32456",
//        "objectName":"7665",
//        "winBidAmount":"30000000",
//        "winBidder":"麦圈互动"
//    }]
	private String objectId;
	private String objectName;
	private String winBidAmount;
	private String winBidder;
	private String industryId;
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
	 * @return the winBidAmount
	 */
	public String getWinBidAmount() {
		return winBidAmount;
	}
	/**
	 * @return the winBidder
	 */
	public String getWinBidder() {
		return winBidder;
	}
	/**
	 * @return the industryId
	 */
	public String getIndustryId() {
		return industryId;
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
	 * @param winBidAmount the winBidAmount to set
	 */
	public void setWinBidAmount(String winBidAmount) {
		this.winBidAmount = winBidAmount;
	}
	/**
	 * @param winBidder the winBidder to set
	 */
	public void setWinBidder(String winBidder) {
		this.winBidder = winBidder;
	}
	/**
	 * @param industryId the industryId to set
	 */
	public void setIndustryId(String industryId) {
		this.industryId = industryId;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "TenderMyEndedObjectVO [objectId=" + objectId + ", objectName=" + objectName + ", winBidAmount="
				+ winBidAmount + ", winBidder=" + winBidder + ", industryId=" + industryId + "]";
	}
	



}
