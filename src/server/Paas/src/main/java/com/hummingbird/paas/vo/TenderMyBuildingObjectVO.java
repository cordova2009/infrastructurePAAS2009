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
	private String winBidAmount;
	private String winBidder;
	private String receivedAmount;
	private String willReceiveAmount;
	
	private Date projectExpectStartDate;
	private String projectExpectPeriod;
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
	public String getProjectExpectPeriod() {
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
	public void setProjectExpectPeriod(String projectExpectPeriod) {
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
