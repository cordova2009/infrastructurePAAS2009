package com.hummingbird.paas.entity;

import java.util.Date;

/**
 * 标的基本信息表
 */
public class ObjectBaseinfo {
    /**
     * 标的id
     */
    private String objectId;

    /**
     * 公告发布开始时间
     */
    private Date announcementBeginTime;

    /**
     * 公告发布结束时间
     */
    private Date announcementEndTime;

    /**
     * 质疑截止时间
     */
    private Date questionEndTime;

    /**
     * 答疑开始时间
     */
    private Date answerQuestionStartTime;

    /**
     * 答疑截止时间
     */
    private Date answerQuestionEndTime;

    /**
     * 递交投标文件截止时间
     */
    private Date biddingEndTime;

    /**
     * 招标文件/资格预审文件获取方式
     */
    private Date biddingDocumentFetchStartTime;

    /**
     * 招标编号
     */
    private String biddingNo;

    /**
     * 标的内容
     */
    private String objectDescription;

    /**
     * 资格审查方式,SYS 投标人资质等级系统自动匹配审查,
     */
    private String certificationCheckupType;

    /**
     * 评标方法,QLT 定性，CRE 信用商户评价，OVE综合评估
     */
    private String bidEvaluationType;

    /**
     * 技术评标地点
     */
    private String bidEvaluationSite;

    /**
     * 中标人确定方式,ORV 直接票决定标，MRV 逐轮票决定标，VDM 票决筹钱定标
     */
    private String bidWinnerDetermineWay;

    /**
     * 票决方式, SMP 简单铎书法，CPN 对比胜出法
     */
    private String voteWinWay;

    /**
     * @return 标的id
     */
    public String getObjectId() {
        return objectId;
    }

    /**
     * @param objectId 
	 *            标的id
     */
    public void setObjectId(String objectId) {
        this.objectId = objectId == null ? null : objectId.trim();
    }

    /**
     * @return 公告发布开始时间
     */
    public Date getAnnouncementBeginTime() {
        return announcementBeginTime;
    }

    /**
     * @param announcementBeginTime 
	 *            公告发布开始时间
     */
    public void setAnnouncementBeginTime(Date announcementBeginTime) {
        this.announcementBeginTime = announcementBeginTime;
    }

    /**
     * @return 公告发布结束时间
     */
    public Date getAnnouncementEndTime() {
        return announcementEndTime;
    }

    /**
     * @param announcementEndTime 
	 *            公告发布结束时间
     */
    public void setAnnouncementEndTime(Date announcementEndTime) {
        this.announcementEndTime = announcementEndTime;
    }

    /**
     * @return 质疑截止时间
     */
    public Date getQuestionEndTime() {
        return questionEndTime;
    }

    /**
     * @param questionEndTime 
	 *            质疑截止时间
     */
    public void setQuestionEndTime(Date questionEndTime) {
        this.questionEndTime = questionEndTime;
    }

    /**
     * @return 答疑开始时间
     */
    public Date getAnswerQuestionStartTime() {
        return answerQuestionStartTime;
    }

    /**
     * @param answerQuestionStartTime 
	 *            答疑开始时间
     */
    public void setAnswerQuestionStartTime(Date answerQuestionStartTime) {
        this.answerQuestionStartTime = answerQuestionStartTime;
    }

    /**
     * @return 答疑截止时间
     */
    public Date getAnswerQuestionEndTime() {
        return answerQuestionEndTime;
    }

    /**
     * @param answerQuestionEndTime 
	 *            答疑截止时间
     */
    public void setAnswerQuestionEndTime(Date answerQuestionEndTime) {
        this.answerQuestionEndTime = answerQuestionEndTime;
    }

    /**
     * @return 递交投标文件截止时间
     */
    public Date getBiddingEndTime() {
        return biddingEndTime;
    }

    /**
     * @param biddingEndTime 
	 *            递交投标文件截止时间
     */
    public void setBiddingEndTime(Date biddingEndTime) {
        this.biddingEndTime = biddingEndTime;
    }

    /**
     * @return 招标文件/资格预审文件获取方式
     */
    public Date getBiddingDocumentFetchStartTime() {
        return biddingDocumentFetchStartTime;
    }

    /**
     * @param biddingDocumentFetchStartTime 
	 *            招标文件/资格预审文件获取方式
     */
    public void setBiddingDocumentFetchStartTime(Date biddingDocumentFetchStartTime) {
        this.biddingDocumentFetchStartTime = biddingDocumentFetchStartTime;
    }

    /**
     * @return 招标编号
     */
    public String getBiddingNo() {
        return biddingNo;
    }

    /**
     * @param biddingNo 
	 *            招标编号
     */
    public void setBiddingNo(String biddingNo) {
        this.biddingNo = biddingNo == null ? null : biddingNo.trim();
    }

    /**
     * @return 标的内容
     */
    public String getObjectDescription() {
        return objectDescription;
    }

    /**
     * @param objectDescription 
	 *            标的内容
     */
    public void setObjectDescription(String objectDescription) {
        this.objectDescription = objectDescription == null ? null : objectDescription.trim();
    }

    /**
     * @return 资格审查方式,SYS 投标人资质等级系统自动匹配审查,
     */
    public String getCertificationCheckupType() {
        return certificationCheckupType;
    }

    /**
     * @param certificationCheckupType 
	 *            资格审查方式,SYS 投标人资质等级系统自动匹配审查,
     */
    public void setCertificationCheckupType(String certificationCheckupType) {
        this.certificationCheckupType = certificationCheckupType == null ? null : certificationCheckupType.trim();
    }

    /**
     * @return 评标方法,QLT 定性，CRE 信用商户评价，OVE综合评估
     */
    public String getBidEvaluationType() {
        return bidEvaluationType;
    }

    /**
     * @param bidEvaluationType 
	 *            评标方法,QLT 定性，CRE 信用商户评价，OVE综合评估
     */
    public void setBidEvaluationType(String bidEvaluationType) {
        this.bidEvaluationType = bidEvaluationType == null ? null : bidEvaluationType.trim();
    }

    /**
     * @return 技术评标地点
     */
    public String getBidEvaluationSite() {
        return bidEvaluationSite;
    }

    /**
     * @param bidEvaluationSite 
	 *            技术评标地点
     */
    public void setBidEvaluationSite(String bidEvaluationSite) {
        this.bidEvaluationSite = bidEvaluationSite == null ? null : bidEvaluationSite.trim();
    }

    /**
     * @return 中标人确定方式,ORV 直接票决定标，MRV 逐轮票决定标，VDM 票决筹钱定标
     */
    public String getBidWinnerDetermineWay() {
        return bidWinnerDetermineWay;
    }

    /**
     * @param bidWinnerDetermineWay 
	 *            中标人确定方式,ORV 直接票决定标，MRV 逐轮票决定标，VDM 票决筹钱定标
     */
    public void setBidWinnerDetermineWay(String bidWinnerDetermineWay) {
        this.bidWinnerDetermineWay = bidWinnerDetermineWay == null ? null : bidWinnerDetermineWay.trim();
    }

    /**
     * @return 票决方式, SMP 简单铎书法，CPN 对比胜出法
     */
    public String getVoteWinWay() {
        return voteWinWay;
    }

    /**
     * @param voteWinWay 
	 *            票决方式, SMP 简单铎书法，CPN 对比胜出法
     */
    public void setVoteWinWay(String voteWinWay) {
        this.voteWinWay = voteWinWay == null ? null : voteWinWay.trim();
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        ObjectBaseinfo other = (ObjectBaseinfo) that;
        return (this.getObjectId() == null ? other.getObjectId() == null : this.getObjectId().equals(other.getObjectId()))
            && (this.getAnnouncementBeginTime() == null ? other.getAnnouncementBeginTime() == null : this.getAnnouncementBeginTime().equals(other.getAnnouncementBeginTime()))
            && (this.getAnnouncementEndTime() == null ? other.getAnnouncementEndTime() == null : this.getAnnouncementEndTime().equals(other.getAnnouncementEndTime()))
            && (this.getQuestionEndTime() == null ? other.getQuestionEndTime() == null : this.getQuestionEndTime().equals(other.getQuestionEndTime()))
            && (this.getAnswerQuestionStartTime() == null ? other.getAnswerQuestionStartTime() == null : this.getAnswerQuestionStartTime().equals(other.getAnswerQuestionStartTime()))
            && (this.getAnswerQuestionEndTime() == null ? other.getAnswerQuestionEndTime() == null : this.getAnswerQuestionEndTime().equals(other.getAnswerQuestionEndTime()))
            && (this.getBiddingEndTime() == null ? other.getBiddingEndTime() == null : this.getBiddingEndTime().equals(other.getBiddingEndTime()))
            && (this.getBiddingDocumentFetchStartTime() == null ? other.getBiddingDocumentFetchStartTime() == null : this.getBiddingDocumentFetchStartTime().equals(other.getBiddingDocumentFetchStartTime()))
            && (this.getBiddingNo() == null ? other.getBiddingNo() == null : this.getBiddingNo().equals(other.getBiddingNo()))
            && (this.getObjectDescription() == null ? other.getObjectDescription() == null : this.getObjectDescription().equals(other.getObjectDescription()))
            && (this.getCertificationCheckupType() == null ? other.getCertificationCheckupType() == null : this.getCertificationCheckupType().equals(other.getCertificationCheckupType()))
            && (this.getBidEvaluationType() == null ? other.getBidEvaluationType() == null : this.getBidEvaluationType().equals(other.getBidEvaluationType()))
            && (this.getBidEvaluationSite() == null ? other.getBidEvaluationSite() == null : this.getBidEvaluationSite().equals(other.getBidEvaluationSite()))
            && (this.getBidWinnerDetermineWay() == null ? other.getBidWinnerDetermineWay() == null : this.getBidWinnerDetermineWay().equals(other.getBidWinnerDetermineWay()))
            && (this.getVoteWinWay() == null ? other.getVoteWinWay() == null : this.getVoteWinWay().equals(other.getVoteWinWay()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getObjectId() == null) ? 0 : getObjectId().hashCode());
        result = prime * result + ((getAnnouncementBeginTime() == null) ? 0 : getAnnouncementBeginTime().hashCode());
        result = prime * result + ((getAnnouncementEndTime() == null) ? 0 : getAnnouncementEndTime().hashCode());
        result = prime * result + ((getQuestionEndTime() == null) ? 0 : getQuestionEndTime().hashCode());
        result = prime * result + ((getAnswerQuestionStartTime() == null) ? 0 : getAnswerQuestionStartTime().hashCode());
        result = prime * result + ((getAnswerQuestionEndTime() == null) ? 0 : getAnswerQuestionEndTime().hashCode());
        result = prime * result + ((getBiddingEndTime() == null) ? 0 : getBiddingEndTime().hashCode());
        result = prime * result + ((getBiddingDocumentFetchStartTime() == null) ? 0 : getBiddingDocumentFetchStartTime().hashCode());
        result = prime * result + ((getBiddingNo() == null) ? 0 : getBiddingNo().hashCode());
        result = prime * result + ((getObjectDescription() == null) ? 0 : getObjectDescription().hashCode());
        result = prime * result + ((getCertificationCheckupType() == null) ? 0 : getCertificationCheckupType().hashCode());
        result = prime * result + ((getBidEvaluationType() == null) ? 0 : getBidEvaluationType().hashCode());
        result = prime * result + ((getBidEvaluationSite() == null) ? 0 : getBidEvaluationSite().hashCode());
        result = prime * result + ((getBidWinnerDetermineWay() == null) ? 0 : getBidWinnerDetermineWay().hashCode());
        result = prime * result + ((getVoteWinWay() == null) ? 0 : getVoteWinWay().hashCode());
        return result;
    }
}