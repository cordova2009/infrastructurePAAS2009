package com.hummingbird.paas.vo;

import java.util.Date;
import org.apache.commons.lang.ObjectUtils;


/**
 * 查询未完成招标项目工程信息接口 结果输出 VO
 */
public class QueryIndexObjectListResult
{
    
//	"list":[{
//  "objectId":"OBJECT_ID",
//  "objectName":"金域华府2期工程开发",
//  "evaluationAmount":"3000000.00",
//  "companyShortName":"稳健地基",
//  "creditRating":"A##",
//  "objectPredictStartTime":"2015-09-12",
//  "projectExpectPeriod":20
//}]
  protected String objectId;
  protected String objectName;
  protected Long evaluationAmount;
  protected String companyShortName;
  protected String creditRating;
  protected String objectPredictStartTime;
  protected Integer projectExpectPeriod;
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
 * @return the companyShortName
 */
public String getCompanyShortName() {
	return companyShortName;
}
/**
 * @return the creditRating
 */
public String getCreditRating() {
	return creditRating;
}
/**
 * @return the objectPredictStartTime
 */
public String getObjectPredictStartTime() {
	return objectPredictStartTime;
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
 * @param evaluationAmount the evaluationAmount to set
 */
public void setEvaluationAmount(Long evaluationAmount) {
	this.evaluationAmount = evaluationAmount;
}
/**
 * @param companyShortName the companyShortName to set
 */
public void setCompanyShortName(String companyShortName) {
	this.companyShortName = companyShortName;
}
/**
 * @param creditRating the creditRating to set
 */
public void setCreditRating(String creditRating) {
	this.creditRating = creditRating;
}
/**
 * @param objectPredictStartTime the objectPredictStartTime to set
 */
public void setObjectPredictStartTime(String objectPredictStartTime) {
	this.objectPredictStartTime = objectPredictStartTime;
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
	return "QueryIndexObjectListResult [objectId=" + objectId + ", objectName=" + objectName + ", evaluationAmount="
			+ evaluationAmount + ", companyShortName=" + companyShortName + ", creditRating=" + creditRating
			+ ", objectPredictStartTime=" + objectPredictStartTime + ", projectExpectPeriod=" + projectExpectPeriod
			+ "]";
}
	
    

}