package com.hummingbird.usercenter.entity;

import java.util.Date;

/**
 * 用户通知信息表
 */
public class UserNotices {
    /**
     * id
     */
    private Integer id;

    /**
     * 通知标题
     */
    private String noticeTitle;

    /**
     * 通知内容
     */
    private String noticeText;

    /**
     * 通知类型
     */
    private String noticeType;

    /**
     * 状态
     */
    private String status;

    /**
     * 有效期
     */
    private Integer expiryDate;

    /**
     * 接收方
     */
    private Integer pkuser;

    /**
     * 创建时间
     */
    private Date insertTime;

    /**
     * 修改时间
     */
    private Date updateTime;

    /**
     * 发送消息方（创建者）
     */
    private Integer creator;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id 
	 *            id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return 通知标题
     */
    public String getNoticeTitle() {
        return noticeTitle;
    }

    /**
     * @param noticeTitle 
	 *            通知标题
     */
    public void setNoticeTitle(String noticeTitle) {
        this.noticeTitle = noticeTitle == null ? null : noticeTitle.trim();
    }

    /**
     * @return 通知内容
     */
    public String getNoticeText() {
        return noticeText;
    }

    /**
     * @param noticeText 
	 *            通知内容
     */
    public void setNoticeText(String noticeText) {
        this.noticeText = noticeText == null ? null : noticeText.trim();
    }

    /**
     * @return 通知类型
     */
    public String getNoticeType() {
        return noticeType;
    }

    /**
     * @param noticeType 
	 *            通知类型
     */
    public void setNoticeType(String noticeType) {
        this.noticeType = noticeType == null ? null : noticeType.trim();
    }

    /**
     * @return 状态
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status 
	 *            状态
     */
    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    /**
     * @return 有效期
     */
    public Integer getExpiryDate() {
        return expiryDate;
    }

    /**
     * @param expiryDate 
	 *            有效期
     */
    public void setExpiryDate(Integer expiryDate) {
        this.expiryDate = expiryDate;
    }

    /**
     * @return 接收方
     */
    public Integer getPkuser() {
        return pkuser;
    }

    /**
     * @param pkuser 
	 *            接收方
     */
    public void setPkuser(Integer pkuser) {
        this.pkuser = pkuser;
    }

    /**
     * @return 创建时间
     */
    public Date getInsertTime() {
        return insertTime;
    }

    /**
     * @param insertTime 
	 *            创建时间
     */
    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }

    /**
     * @return 修改时间
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * @param updateTime 
	 *            修改时间
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * @return 发送消息方（创建者）
     */
    public Integer getCreator() {
        return creator;
    }

    /**
     * @param creator 
	 *            发送消息方（创建者）
     */
    public void setCreator(Integer creator) {
        this.creator = creator;
    }
}