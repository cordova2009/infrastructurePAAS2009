package com.hummingbird.paas.vo;

import java.util.Arrays;
import java.util.Date;

import com.hummingbird.commonbiz.vo.PagingnationVO;

/**
 * 查询招标项目接口
 * @author YJY  
 * @since 2015年11月14日19:21:15
 * */
public class TenderObjectListReturnVO extends PagingnationVO {
//	"list":[{
//        "objectId":"BH1245677899",
//        "objectName":"深圳湾体育馆工程",
//        "biddee":"稳健地基公司",
//        "creditRating":"A##",
//        "evaluationAmount":"40,000.00",
//        "projectExpectStartDate":"2015-12-12",
//        "projectExpectPeriod":"90"
//    }]
	private String objectId;
	private String objectName;
	private String biddee;
	
	private String creditRating;
	private Long evaluationAmount;
	private String projectExpectStartDate;
	private String projectExpectEndDate;
	private Integer projectExpectPeriod;
	/**
	 * 工程标的估价可见,ENB 可见, DIS 不可见
	 */
	private String evaluationAmountVisiable;
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
	 * @return the biddee
	 */
	public String getBiddee() {
		return biddee;
	}
	/**
	 * @return the creditRating
	 */
	public String getCreditRating() {
		return creditRating;
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
	 * @return the projectExpectEndDate
	 */
	public String getProjectExpectEndDate() {
		return projectExpectEndDate;
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
	 * @param biddee the biddee to set
	 */
	public void setBiddee(String biddee) {
		this.biddee = biddee;
	}
	/**
	 * @param creditRating the creditRating to set
	 */
	public void setCreditRating(String creditRating) {
		this.creditRating = creditRating;
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
	 * @param projectExpectEndDate the projectExpectEndDate to set
	 */
	public void setProjectExpectEndDate(String projectExpectEndDate) {
		this.projectExpectEndDate = projectExpectEndDate;
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
		return "TenderObjectListReturnVO [objectId=" + objectId + ", objectName=" + objectName + ", biddee=" + biddee
				+ ", creditRating=" + creditRating + ", evaluationAmount=" + evaluationAmount
				+ ", projectExpectStartDate=" + projectExpectStartDate + ", projectExpectEndDate="
				+ projectExpectEndDate + ", projectExpectPeriod=" + projectExpectPeriod + ", evaluationAmountVisiable="
				+ evaluationAmountVisiable + "]";
	}
	/**
	 * 工程标的估价可见ENB 可见 DIS 不可见 
	 */
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
