package com.hummingbird.paas.vo;

import java.util.Date;
import org.apache.commons.lang.ObjectUtils;

/**
 * 查询首页中标项目列表接口 结果输出 VO
 */
public class QueryBidIndexListResult {

	// "industryId":3,
	// "objectId":"32456",
	// "objectName":"7665",
	// "winBidAmount":"30000000",
	// "biddee":"麦圈互动"
	protected String objectId;
	protected String objectName;
	protected String industryId;
	protected String biddeeName;
	protected String bidderName;
	protected Long winBidAmount;
	/**
	 * 工程名称
	 */
	private String industryName;
	/**
	 * 工程图标
	 */
	private String industryIcon;

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
	 * @return the industryId
	 */
	public String getIndustryId() {
		return industryId;
	}

	/**
	 * @return the biddee
	 */
	public String getBiddeeName() {
		return biddeeName;
	}

	/**
	 * @return the winBidAmount
	 */
	public Long getWinBidAmount() {
		return winBidAmount;
	}

	/**
	 * @param objectId
	 *            the objectId to set
	 */
	public void setObjectId(String objectId) {
		this.objectId = objectId;
	}

	/**
	 * @param objectName
	 *            the objectName to set
	 */
	public void setObjectName(String objectName) {
		this.objectName = objectName;
	}

	/**
	 * @param industryId
	 *            the industryId to set
	 */
	public void setIndustryId(String industryId) {
		this.industryId = industryId;
	}

	/**
	 * @param biddee
	 *            the biddee to set
	 */
	public void setBiddeeName(String biddee) {
		this.biddeeName = biddee;
	}

	/**
	 * @param winBidAmount
	 *            the winBidAmount to set
	 */
	public void setWinBidAmount(Long winBidAmount) {
		this.winBidAmount = winBidAmount;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "QueryBidIndexListResult [objectId=" + objectId + ", objectName=" + objectName + ", industryId="
				+ industryId + ", biddeeName=" + biddeeName + ", bidderName=" + bidderName + ", winBidAmount="
				+ winBidAmount + ", industryName=" + industryName + ", industryIcon=" + industryIcon + "]";
	}

	/**
	 * #{bare_field_comment}
	 */
	public String getBidderName() {
		return bidderName;
	}

	/**
	 * #{bare_field_comment}
	 */
	public void setBidderName(String bidder) {
		this.bidderName = bidder;
	}

	/**
	 * 工程名称
	 */
	public String getIndustryName() {
		return industryName;
	}

	/**
	 * 工程名称
	 */
	public void setIndustryName(String industryName) {
		this.industryName = industryName;
	}

	/**
	 * 工程图标
	 */
	public String getIndustryIcon() {
		return industryIcon;
	}

	/**
	 * 工程图标
	 */
	public void setIndustryIcon(String industryIcon) {
		this.industryIcon = industryIcon;
	}

}