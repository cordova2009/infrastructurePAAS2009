package com.hummingbird.paas.entity;

import java.util.Date;

/**
 * 标的基本信息表,记录招标的一些基本信息
 */
public class ObjectBaseinfo {
    /**
     * 标的id
     */
    private String object_id;

    /**
     * 公告发布开始时间
     */
    private Date announcement_begin_time;

    /**
     * 公告发布结束时间
     */
    private Date announcement_end_time;

    /**
     * 质疑截止时间
     */
    private Date question_end_time;

    /**
     * 答疑开始时间
     */
    private Date answer_question_start_time;

    /**
     * 答疑截止时间
     */
    private Date answer_question_end_time;

    /**
     * 递交投标文件截止时间
     */
    private Date bidding_end_time;

    /**
     * 招标文件/资格预审文件获取方式
     */
    private Date bidding_document_fetch_start_time;

    /**
     * 招标编号
     */
    private String bidding_no;

    /**
     * 招标项目范围
     */
    private String object_scope;

    /**
     * 标的内容
     */
    private String object_description;

    /**
     * @return 标的id
     */
    public String getObject_id() {
        return object_id;
    }

    /**
     * @param objectId 
	 *            标的id
     */
    public void setObject_id(String object_id) {
        this.object_id = object_id == null ? null : object_id.trim();
    }

    /**
     * @return 公告发布开始时间
     */
    public Date getAnnouncement_begin_time() {
        return announcement_begin_time;
    }

    /**
     * @param announcementBeginTime 
	 *            公告发布开始时间
     */
    public void setAnnouncement_begin_time(Date announcement_begin_time) {
        this.announcement_begin_time = announcement_begin_time;
    }

    /**
     * @return 公告发布结束时间
     */
    public Date getAnnouncement_end_time() {
        return announcement_end_time;
    }

    /**
     * @param announcementEndTime 
	 *            公告发布结束时间
     */
    public void setAnnouncement_end_time(Date announcement_end_time) {
        this.announcement_end_time = announcement_end_time;
    }

    /**
     * @return 质疑截止时间
     */
    public Date getQuestion_end_time() {
        return question_end_time;
    }

    /**
     * @param questionEndTime 
	 *            质疑截止时间
     */
    public void setQuestion_end_time(Date question_end_time) {
        this.question_end_time = question_end_time;
    }

    /**
     * @return 答疑开始时间
     */
    public Date getAnswer_question_start_time() {
        return answer_question_start_time;
    }

    /**
     * @param answerQuestionStartTime 
	 *            答疑开始时间
     */
    public void setAnswer_question_start_time(Date answer_question_start_time) {
        this.answer_question_start_time = answer_question_start_time;
    }

    /**
     * @return 答疑截止时间
     */
    public Date getAnswer_question_end_time() {
        return answer_question_end_time;
    }

    /**
     * @param answerQuestionEndTime 
	 *            答疑截止时间
     */
    public void setAnswer_question_end_time(Date answer_question_end_time) {
        this.answer_question_end_time = answer_question_end_time;
    }

    /**
     * @return 递交投标文件截止时间
     */
    public Date getBidding_end_time() {
        return bidding_end_time;
    }

    /**
     * @param biddingEndTime 
	 *            递交投标文件截止时间
     */
    public void setBidding_end_time(Date bidding_end_time) {
        this.bidding_end_time = bidding_end_time;
    }

    /**
     * @return 招标文件/资格预审文件获取方式
     */
    public Date getBidding_document_fetch_start_time() {
        return bidding_document_fetch_start_time;
    }

    /**
     * @param biddingDocumentFetchStartTime 
	 *            招标文件/资格预审文件获取方式
     */
    public void setBidding_document_fetch_start_time(Date bidding_document_fetch_start_time) {
        this.bidding_document_fetch_start_time = bidding_document_fetch_start_time;
    }

    /**
     * @return 招标编号
     */
    public String getBidding_no() {
        return bidding_no;
    }

    /**
     * @param biddingNo 
	 *            招标编号
     */
    public void setBidding_no(String bidding_no) {
        this.bidding_no = bidding_no == null ? null : bidding_no.trim();
    }

    /**
     * @return 招标项目范围
     */
    public String getObject_scope() {
        return object_scope;
    }

    /**
     * @param objectScope 
	 *            招标项目范围
     */
    public void setObject_scope(String object_scope) {
        this.object_scope = object_scope == null ? null : object_scope.trim();
    }

    /**
     * @return 标的内容
     */
    public String getObject_description() {
        return object_description;
    }

    /**
     * @param objectDescription 
	 *            标的内容
     */
    public void setObject_description(String object_description) {
        this.object_description = object_description == null ? null : object_description.trim();
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
        return (this.getObject_id() == null ? other.getObject_id() == null : this.getObject_id().equals(other.getObject_id()))
            && (this.getAnnouncement_begin_time() == null ? other.getAnnouncement_begin_time() == null : this.getAnnouncement_begin_time().equals(other.getAnnouncement_begin_time()))
            && (this.getAnnouncement_end_time() == null ? other.getAnnouncement_end_time() == null : this.getAnnouncement_end_time().equals(other.getAnnouncement_end_time()))
            && (this.getQuestion_end_time() == null ? other.getQuestion_end_time() == null : this.getQuestion_end_time().equals(other.getQuestion_end_time()))
            && (this.getAnswer_question_start_time() == null ? other.getAnswer_question_start_time() == null : this.getAnswer_question_start_time().equals(other.getAnswer_question_start_time()))
            && (this.getAnswer_question_end_time() == null ? other.getAnswer_question_end_time() == null : this.getAnswer_question_end_time().equals(other.getAnswer_question_end_time()))
            && (this.getBidding_end_time() == null ? other.getBidding_end_time() == null : this.getBidding_end_time().equals(other.getBidding_end_time()))
            && (this.getBidding_document_fetch_start_time() == null ? other.getBidding_document_fetch_start_time() == null : this.getBidding_document_fetch_start_time().equals(other.getBidding_document_fetch_start_time()))
            && (this.getBidding_no() == null ? other.getBidding_no() == null : this.getBidding_no().equals(other.getBidding_no()))
            && (this.getObject_scope() == null ? other.getObject_scope() == null : this.getObject_scope().equals(other.getObject_scope()))
            && (this.getObject_description() == null ? other.getObject_description() == null : this.getObject_description().equals(other.getObject_description()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getObject_id() == null) ? 0 : getObject_id().hashCode());
        result = prime * result + ((getAnnouncement_begin_time() == null) ? 0 : getAnnouncement_begin_time().hashCode());
        result = prime * result + ((getAnnouncement_end_time() == null) ? 0 : getAnnouncement_end_time().hashCode());
        result = prime * result + ((getQuestion_end_time() == null) ? 0 : getQuestion_end_time().hashCode());
        result = prime * result + ((getAnswer_question_start_time() == null) ? 0 : getAnswer_question_start_time().hashCode());
        result = prime * result + ((getAnswer_question_end_time() == null) ? 0 : getAnswer_question_end_time().hashCode());
        result = prime * result + ((getBidding_end_time() == null) ? 0 : getBidding_end_time().hashCode());
        result = prime * result + ((getBidding_document_fetch_start_time() == null) ? 0 : getBidding_document_fetch_start_time().hashCode());
        result = prime * result + ((getBidding_no() == null) ? 0 : getBidding_no().hashCode());
        result = prime * result + ((getObject_scope() == null) ? 0 : getObject_scope().hashCode());
        result = prime * result + ((getObject_description() == null) ? 0 : getObject_description().hashCode());
        return result;
    }
}