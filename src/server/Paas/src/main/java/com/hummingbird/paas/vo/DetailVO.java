package com.hummingbird.paas.vo;

public class DetailVO {
    private QueryObjectDetailBaseVO baseInfo;
    private QueryObjectDetailProjectInfo projectInfo;
    private QueryObjectDetailConstructionInfo constructionInfo;
    private QueryObjectDetailProjectRequirementInfo projectRequirementInfo;
    private QueryObjectDetailBidderCertificationInfo bidderCertificationInfo;
    private QueryObjectDetailBondInfo bondInfo;
    private QueryObjectDetailBidFilTypeInfo bidFileTypeInfo;
    private QueryObjectDetailObjectMethondInfo objectMethodInfo;
    private QueryObjectDetailAnswerQuestion answerQuestion;
    private QueryObjectDetailDateRequirementInfo dateRequirementInfo;
    private QueryObjectDetailBidEvaluationTypeInfo bidEvaluationTypeInfo;
	public QueryObjectDetailBaseVO getBaseInfo() {
		return baseInfo;
	}
	public void setBaseInfo(QueryObjectDetailBaseVO baseInfo) {
		this.baseInfo = baseInfo;
	}
	public QueryObjectDetailProjectInfo getProjectInfo() {
		return projectInfo;
	}
	public void setProjectInfo(QueryObjectDetailProjectInfo projectInfo) {
		this.projectInfo = projectInfo;
	}
	public QueryObjectDetailConstructionInfo getConstructionInfo() {
		return constructionInfo;
	}
	public void setConstructionInfo(QueryObjectDetailConstructionInfo constructionInfo) {
		this.constructionInfo = constructionInfo;
	}
	public QueryObjectDetailProjectRequirementInfo getProjectRequirementInfo() {
		return projectRequirementInfo;
	}
	public void setProjectRequirementInfo(QueryObjectDetailProjectRequirementInfo projectRequirementInfo) {
		this.projectRequirementInfo = projectRequirementInfo;
	}
	public QueryObjectDetailBidderCertificationInfo getBidderCertificationInfo() {
		return bidderCertificationInfo;
	}
	public void setBidderCertificationInfo(QueryObjectDetailBidderCertificationInfo bidderCertificationInfo) {
		this.bidderCertificationInfo = bidderCertificationInfo;
	}
	public QueryObjectDetailBondInfo getBondInfo() {
		return bondInfo;
	}
	public void setBondInfo(QueryObjectDetailBondInfo bondInfo) {
		this.bondInfo = bondInfo;
	}
	public QueryObjectDetailBidFilTypeInfo getBidFileTypeInfo() {
		return bidFileTypeInfo;
	}
	public void setBidFileTypeInfo(QueryObjectDetailBidFilTypeInfo bidFileTypeInfo) {
		this.bidFileTypeInfo = bidFileTypeInfo;
	}
	public QueryObjectDetailObjectMethondInfo getObjectMethodInfo() {
		return objectMethodInfo;
	}
	public void setObjectMethodInfo(QueryObjectDetailObjectMethondInfo objectMethodInfo) {
		this.objectMethodInfo = objectMethodInfo;
	}
	public QueryObjectDetailAnswerQuestion getAnswerQuestion() {
		return answerQuestion;
	}
	public void setAnswerQuestion(QueryObjectDetailAnswerQuestion answerQuestion) {
		this.answerQuestion = answerQuestion;
	}
	public QueryObjectDetailDateRequirementInfo getDateRequirementInfo() {
		return dateRequirementInfo;
	}
	public void setDateRequirementInfo(QueryObjectDetailDateRequirementInfo dateRequirementInfo) {
		this.dateRequirementInfo = dateRequirementInfo;
	}
	public QueryObjectDetailBidEvaluationTypeInfo getBidEvaluationTypeInfo() {
		return bidEvaluationTypeInfo;
	}
	public void setBidEvaluationTypeInfo(QueryObjectDetailBidEvaluationTypeInfo bidEvaluationTypeInfo) {
		this.bidEvaluationTypeInfo = bidEvaluationTypeInfo;
	}
	@Override
	public String toString() {
		return "DetailVO [getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}
	
}
