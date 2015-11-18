package com.hummingbird.paas.vo;

import java.util.Date;

/**
 * 消息详细
 * @author YJY  
 * @since 2015年10月29日15:00:01
 * */
public class AnnouncementDetailBodyVO {
	private Integer noticeId;

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
}
