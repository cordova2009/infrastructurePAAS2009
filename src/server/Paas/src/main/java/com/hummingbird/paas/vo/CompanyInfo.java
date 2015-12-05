package com.hummingbird.paas.vo;

import java.util.Date;
import java.util.List;

/**
 * 公司信息  
 * @author YJY  
 * @since 2015年12月4日15:28:30
 * @see 用于规范json
 * */

//"survey":{
//    "logoUrl":"URL",
//    "companyName":"蜂鸟娱乐",
//    "creditRating":"A##",
//    "creditScore":532,
//    "evaluationRating":3,
//    "evaluationScore":80
//}
public class CompanyInfo {
	
	private CompanySurvey  survey;
	private CompanyBaseInfo  baseInfo;
	private List<CompanyCerticateInfo>  certicate;
	private CompanyBidInfo  bidInfo;
	private CompanyEvaluationInfo  evaluationInfo;
	/**
	 * @return the survey
	 */
	public CompanySurvey getSurvey() {
		return survey;
	}
	/**
	 * @return the baseInfo
	 */
	public CompanyBaseInfo getBaseInfo() {
		return baseInfo;
	}
	/**
	 * @return the certicate
	 */
	public List<CompanyCerticateInfo> getCerticate() {
		return certicate;
	}
	/**
	 * @return the bidInfo
	 */
	public CompanyBidInfo getBidInfo() {
		return bidInfo;
	}
	/**
	 * @return the evaluationInfo
	 */
	public CompanyEvaluationInfo getEvaluationInfo() {
		return evaluationInfo;
	}
	/**
	 * @param survey the survey to set
	 */
	public void setSurvey(CompanySurvey survey) {
		this.survey = survey;
	}
	/**
	 * @param baseInfo the baseInfo to set
	 */
	public void setBaseInfo(CompanyBaseInfo baseInfo) {
		this.baseInfo = baseInfo;
	}
	/**
	 * @param certicate the certicate to set
	 */
	public void setCerticate(List<CompanyCerticateInfo> certicate) {
		this.certicate = certicate;
	}
	/**
	 * @param bidInfo the bidInfo to set
	 */
	public void setBidInfo(CompanyBidInfo bidInfo) {
		this.bidInfo = bidInfo;
	}
	/**
	 * @param evaluationInfo the evaluationInfo to set
	 */
	public void setEvaluationInfo(CompanyEvaluationInfo evaluationInfo) {
		this.evaluationInfo = evaluationInfo;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "CompanyInfo [survey=" + survey + ", baseInfo=" + baseInfo + ", certicate=" + certicate + ", bidInfo="
				+ bidInfo + ", evaluationInfo=" + evaluationInfo + "]";
	}

	
}
