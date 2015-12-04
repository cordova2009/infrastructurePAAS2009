package com.hummingbird.paas.entity;

import java.util.Date;

/**
 * 信息评论表,对用户发布的信息进行评论
 */
public class UserInformationComment {
    private Integer id;

    /**
     * 信息id
     */
    private Integer informationId;

    /**
     * 回复人
     */
    private Integer replier;

    /**
     * 回复时间
     */
    private Date replyTime;

    /**
     * 状态,OK# 正常, DIS 禁用
     */
    private String status;

    /**
     * 回复内容
     */
    private String replyContent;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return 信息id
     */
    public Integer getInformationId() {
        return informationId;
    }

    /**
     * @param informationId 
	 *            信息id
     */
    public void setInformationId(Integer informationId) {
        this.informationId = informationId;
    }

    /**
     * @return 回复人
     */
    public Integer getReplier() {
        return replier;
    }

    /**
     * @param replier 
	 *            回复人
     */
    public void setReplier(Integer replier) {
        this.replier = replier;
    }

    /**
     * @return 回复时间
     */
    public Date getReplyTime() {
        return replyTime;
    }

    /**
     * @param replyTime 
	 *            回复时间
     */
    public void setReplyTime(Date replyTime) {
        this.replyTime = replyTime;
    }

    /**
     * @return 状态,OK# 正常, DIS 禁用
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status 
	 *            状态,OK# 正常, DIS 禁用
     */
    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    /**
     * @return 回复内容
     */
    public String getReplyContent() {
        return replyContent;
    }

    /**
     * @param replyContent 
	 *            回复内容
     */
    public void setReplyContent(String replyContent) {
        this.replyContent = replyContent == null ? null : replyContent.trim();
    }
}