package com.hummingbird.paas.vo;

import java.util.Date;

import com.hummingbird.commonbiz.vo.PagingnationVO;

/**
 * 消息详细
 * @author YJY  
 * @since 2015年11月11日22:12:08
 * */
public class TenderMyBuildingObjectVO extends PagingnationVO {
//	 "list":[{
//	        "objectId":"32456",
//	        "objectName":"7665",
//	        "winBidAmount":"30000000",
//	        "winBidder":"麦圈互动",
//	        "receivedAmount":"3000000",
//	        "willReceiveAmount":"20020000",
//	        "projectExpectStartDate":"2015-06-12",
//	        "projectExpectPeriod":300
//	    }]
	private String objectId;
	private String objectName;
	private Long winBidAmount;
	private String winBidder;
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
	 * @return the objectName
	 */
	public String getObjectName() {
		return objectName;
	}
	/**
	 * @return the winBidAmount
	 */
	public Long getWinBidAmount() {
		return winBidAmount;
	}
	/**
	 * @return the winBidder
	 */
	public String getWinBidder() {
		return winBidder;
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
	 * @param objectName the objectName to set
	 */
	public void setObjectName(String objectName) {
		this.objectName = objectName;
	}
	/**
	 * @param winBidAmount the winBidAmount to set
	 */
	public void setWinBidAmount(Long winBidAmount) {
		this.winBidAmount = winBidAmount;
	}
	/**
	 * @param winBidder the winBidder to set
	 */
	public void setWinBidder(String winBidder) {
		this.winBidder = winBidder;
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
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "TenderMyBuildingObjectVO [objectId=" + objectId + ", objectName=" + objectName + ", winBidAmount="
				+ winBidAmount + ", winBidder=" + winBidder + ", receivedAmount=" + receivedAmount
				+ ", willReceiveAmount=" + willReceiveAmount + ", projectExpectStartDate=" + projectExpectStartDate
				+ ", projectExpectPeriod=" + projectExpectPeriod + "]";
	}
	
	
	

}
