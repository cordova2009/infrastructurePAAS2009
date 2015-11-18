package com.hummingbird.paas.entity;

import java.util.Date;

/**
 * 公告信息表
 */
public class Announcement {
    /**
     * id
     */
    private Integer id;

    /**
     * 公告类型
     */
    private String type;

    /**
     * 公告标题
     */
    private String title;

    /**
     * 状态
     */
    private String status;

    /**
     * 有效期
     */
    private Integer expiryDate;

    /**
     * 创建者
     */
    private Integer creator;

    /**
     * 创建时间
     */
    private Date insertTime;

    /**
     * 修改时间
     */
    private Date updateTime;

    /**
     * 配图
     */
    private String imgurl;

    /**
     * 公告内容
     */
    private String content;

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
     * @return 公告类型
     */
    public String getType() {
        return type;
    }

    /**
     * @param type 
	 *            公告类型
     */
    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    /**
     * @return 公告标题
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title 
	 *            公告标题
     */
    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
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
     * @return 创建者
     */
    public Integer getCreator() {
        return creator;
    }

    /**
     * @param creator 
	 *            创建者
     */
    public void setCreator(Integer creator) {
        this.creator = creator;
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
     * @return 配图
     */
    public String getImgurl() {
        return imgurl;
    }

    /**
     * @param imgurl 
	 *            配图
     */
    public void setImgurl(String imgurl) {
        this.imgurl = imgurl == null ? null : imgurl.trim();
    }

    /**
     * @return 公告内容
     */
    public String getContent() {
        return content;
    }

    /**
     * @param content 
	 *            公告内容
     */
    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }
}