package com.hummingbird.paas.vo;

import java.util.Date;

import org.codehaus.jackson.annotate.JsonIgnore;

import com.hummingbird.commonbiz.vo.PagingnationVO;

/**
 * 消息详细
 * @author YJY  
 * @since 2015年11月12日14:01:46
 * */
public class MyTenderObjectListVO extends PagingnationVO{
	
	private String industryId;
	private String objectId;
	private String objectName;
	private Long evaluationAmount;
	private String projectExpectStartDate;
	private Integer projectExpectPeriod;
	private String biddingEndTime;
	/**
	 * 工程标的估价可见,ENB 可见, DIS 不可见
	 */
	private String evaluationAmountVisiable;
	/**
	 * @return the industryId
	 */
	public String getIndustryId() {
		return industryId;
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
	 * @return the evaluationAmount
	 */
	public Long getEvaluationAmount() {
		return evaluationAmount;
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
	 * @return the biddingEndTime
	 */
	public String getBiddingEndTime() {
		return biddingEndTime;
	}
	/**
	 * @param industryId the industryId to set
	 */
	public void setIndustryId(String industryId) {
		this.industryId = industryId;
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
	 * @param evaluationAmount the evaluationAmount to set
	 */
	public void setEvaluationAmount(Long evaluationAmount) {
		this.evaluationAmount = evaluationAmount;
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
	/**
	 * @param biddingEndTime the biddingEndTime to set
	 */
	public void setBiddingEndTime(String biddingEndTime) {
		this.biddingEndTime = biddingEndTime;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "MyTenderObjectListVO [industryId=" + industryId + ", objectId=" + objectId + ", objectName="
				+ objectName + ", evaluationAmount=" + evaluationAmount + ", projectExpectStartDate="
				+ projectExpectStartDate + ", projectExpectPeriod=" + projectExpectPeriod + ", biddingEndTime="
				+ biddingEndTime + ", evaluationAmountVisiable=" + evaluationAmountVisiable + "]";
	}
	/**
	 * 工程标的估价可见ENB 可见 DIS 不可见 
	 */
	@JsonIgnore
	public String getEvaluationAmountVisiable() {
		return evaluationAmountVisiable;
	}
	/**
	 * 工程标的估价可见ENB 可见 DIS 不可见 
	 */
	public void setEvaluationAmountVisiable(String evaluationAmountVisiable) {
		this.evaluationAmountVisiable = evaluationAmountVisiable;
	}
	

}
