package com.hummingbird.paas.vo;

import java.util.Date;
import java.util.List;

import org.codehaus.jackson.map.annotate.JsonSerialize;

import com.hummingbird.common.util.convertor.JacksonDateTimeSerializer;

/**
 * 评论信息  
 * @author YJY  
 * @since 2015年12月4日15:28:30
 * @see 用于规范json
 * */

//"evaluationInfo":{
//    "companyEvaluateScore":7,
//    "companyEvaluateNum":8,
//    list:[{
//        "evaluationCompanyId":5,
//        "evaluationCompanyType":"BEE",
//        "evaluationCompanyName":"蜂鸟娱乐",
//        "evaluationCompanyContent":"质量很好，下次继续合作",
//        "evaluationCompanyTime":"2015-09-12 22:22:22",
//        "objectId":"BH2015029371",
//        "objectName":"万科金域华府2期开发"
//    }]
//    "tag":[{
//        "tagName":"质量好啊","tagNum":3
//    },{
//        "tagName":"速度很快","tagNum":4
//    }]
//}
public class CompanyEvaluationDetailInfo {
	
	private Integer  evaluationCompanyId;
	private String  evaluationCompanyType;
	private String  evaluationCompanyName;
	private String  evaluationCompanyContent;
	private Date  evaluationCompanyTime;
	private String  objectId;
	private String  objectName;
	/**
	 * @return the evaluationCompanyId
	 */
	public Integer getEvaluationCompanyId() {
		return evaluationCompanyId;
	}
	/**
	 * @return the evaluationCompanyType
	 */
	public String getEvaluationCompanyType() {
		return evaluationCompanyType;
	}
	/**
	 * @return the evaluationCompanyName
	 */
	public String getEvaluationCompanyName() {
		return evaluationCompanyName;
	}
	/**
	 * @return the evaluationCompanyContent
	 */
	public String getEvaluationCompanyContent() {
		return evaluationCompanyContent;
	}
	/**
	 * @return the evaluationCompanyTime
	 */
	@JsonSerialize(using =JacksonDateTimeSerializer.class)
	public Date getEvaluationCompanyTime() {
		return evaluationCompanyTime;
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
	 * @param evaluationCompanyId the evaluationCompanyId to set
	 */
	public void setEvaluationCompanyId(Integer evaluationCompanyId) {
		this.evaluationCompanyId = evaluationCompanyId;
	}
	/**
	 * @param evaluationCompanyType the evaluationCompanyType to set
	 */
	public void setEvaluationCompanyType(String evaluationCompanyType) {
		this.evaluationCompanyType = evaluationCompanyType;
	}
	/**
	 * @param evaluationCompanyName the evaluationCompanyName to set
	 */
	public void setEvaluationCompanyName(String evaluationCompanyName) {
		this.evaluationCompanyName = evaluationCompanyName;
	}
	/**
	 * @param evaluationCompanyContent the evaluationCompanyContent to set
	 */
	public void setEvaluationCompanyContent(String evaluationCompanyContent) {
		this.evaluationCompanyContent = evaluationCompanyContent;
	}
	/**
	 * @param evaluationCompanyTime the evaluationCompanyTime to set
	 */
	public void setEvaluationCompanyTime(Date evaluationCompanyTime) {
		this.evaluationCompanyTime = evaluationCompanyTime;
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
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "CompanyEvaluationDetailInfo [evaluationCompanyId=" + evaluationCompanyId + ", evaluationCompanyType="
				+ evaluationCompanyType + ", evaluationCompanyName=" + evaluationCompanyName
				+ ", evaluationCompanyContent=" + evaluationCompanyContent + ", evaluationCompanyTime="
				+ evaluationCompanyTime + ", objectId=" + objectId + ", objectName=" + objectName + "]";
	}

	

}
