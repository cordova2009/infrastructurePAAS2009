package com.hummingbird.paas.vo;

import java.util.Date;

/**
 * 基本信息  
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
public class CompanySurvey {
	
	private String  logoUrl;
	private String  companyName;
	private String  creditRating;
	private String  creditScore;
	private String  evaluationRating;
	private String  evaluationScore;
	/**
	 * 是否会员,OK# 是,FLS 否
	 */
	private String  isMember;
	/**
	 * @return the logoUrl
	 */
	public String getLogoUrl() {
		return logoUrl;
	}
	/**
	 * @return the companyName
	 */
	public String getCompanyName() {
		return companyName;
	}
	/**
	 * @return the creditRating
	 */
	public String getCreditRating() {
		return creditRating;
	}
	/**
	 * @return the creditScore
	 */
	public String getCreditScore() {
		return creditScore;
	}
	/**
	 * @return the evaluationRating
	 */
	public String getEvaluationRating() {
		return evaluationRating;
	}
	/**
	 * @return the evaluationScore
	 */
	public String getEvaluationScore() {
		return evaluationScore;
	}
	/**
	 * @param logoUrl the logoUrl to set
	 */
	public void setLogoUrl(String logoUrl) {
		this.logoUrl = logoUrl;
	}
	/**
	 * @param companyName the companyName to set
	 */
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	/**
	 * @param creditRating the creditRating to set
	 */
	public void setCreditRating(String creditRating) {
		this.creditRating = creditRating;
	}
	/**
	 * @param creditScore the creditScore to set
	 */
	public void setCreditScore(String creditScore) {
		this.creditScore = creditScore;
	}
	/**
	 * @param evaluationRating the evaluationRating to set
	 */
	public void setEvaluationRating(String evaluationRating) {
		this.evaluationRating = evaluationRating;
	}
	/**
	 * @param evaluationScore the evaluationScore to set
	 */
	public void setEvaluationScore(String evaluationScore) {
		this.evaluationScore = evaluationScore;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "CompanySurvey [logoUrl=" + logoUrl + ", companyName=" + companyName + ", creditRating=" + creditRating
				+ ", creditScore=" + creditScore + ", evaluationRating=" + evaluationRating + ", evaluationScore="
				+ evaluationScore + "]";
	}
	/**
	 * 是否会员OK# 是FLS 否 
	 */
	public String getIsMember() {
		return isMember;
	}
	/**
	 * 是否会员OK# 是FLS 否 
	 */
	public void setIsMember(String isMember) {
		this.isMember = isMember;
	}

	
}
