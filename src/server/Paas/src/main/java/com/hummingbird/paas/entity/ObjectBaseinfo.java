package com.hummingbird.paas.entity;

import java.util.Date;

/**
 * 标的基本信息表,记录招标的一些基本信息
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

    private String objectDescription;

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
            && (this.getObjectDescription() == null ? other.getObjectDescription() == null : this.getObjectDescription().equals(other.getObjectDescription()));
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
        return result;
    }
}