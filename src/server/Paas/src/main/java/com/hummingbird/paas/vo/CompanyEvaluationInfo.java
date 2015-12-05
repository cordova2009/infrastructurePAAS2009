package com.hummingbird.paas.vo;

import java.util.Date;
import java.util.List;

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
public class CompanyEvaluationInfo {
	
	private Double  companyEvaluateScore;
	private Integer  companyEvaluateNum;
	private List<CompanyEvaluationDetailInfo> list;
	private List<TagInfo> tag;
	/**
	 * @return the companyEvaluateScore
	 */
	public Double getCompanyEvaluateScore() {
		return companyEvaluateScore;
	}
	/**
	 * @return the companyEvaluateNum
	 */
	public Integer getCompanyEvaluateNum() {
		return companyEvaluateNum;
	}
	/**
	 * @return the list
	 */
	public List<CompanyEvaluationDetailInfo> getList() {
		return list;
	}
	/**
	 * @return the tag
	 */
	public List<TagInfo> getTag() {
		return tag;
	}
	/**
	 * @param companyEvaluateScore the companyEvaluateScore to set
	 */
	public void setCompanyEvaluateScore(Double companyEvaluateScore) {
		this.companyEvaluateScore = companyEvaluateScore;
	}
	/**
	 * @param companyEvaluateNum the companyEvaluateNum to set
	 */
	public void setCompanyEvaluateNum(Integer companyEvaluateNum) {
		this.companyEvaluateNum = companyEvaluateNum;
	}
	/**
	 * @param list the list to set
	 */
	public void setList(List<CompanyEvaluationDetailInfo> list) {
		this.list = list;
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
		return "CompanyEvaluationInfo [companyEvaluateScore=" + companyEvaluateScore + ", companyEvaluateNum="
				+ companyEvaluateNum + ", list=" + list + ", tag=" + tag + "]";
	}
	
	
	

}
