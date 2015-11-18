package com.hummingbird.paas.vo;

import java.util.Date;

/**
 * 消息详细
 * @author YJY  
 * @since 2015年10月29日15:00:01
 * */
public class AnnouncementUpdateBodyVO {
	
	private Integer noticeId;
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
     * 配图
     */
    private String imgurl;

    /**
     * 公告内容
     */
    private String content;
    
	public Integer getNoticeId() {
		return noticeId;
	}

	public void setNoticeId(Integer noticeId) {
		this.noticeId = noticeId;
	}

  
	@Override
	public String toString() {
		return " AnnouncementDetailBodyVO [noticeId=" + noticeId+"]";
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Integer getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(Integer expiryDate) {
		this.expiryDate = expiryDate;
	}

	public String getImgurl() {
		return imgurl;
	}

	public void setImgurl(String imgurl) {
		this.imgurl = imgurl;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
}
