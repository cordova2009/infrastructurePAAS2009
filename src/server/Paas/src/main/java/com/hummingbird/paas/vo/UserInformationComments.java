package com.hummingbird.paas.vo;

import java.util.Date;

import org.codehaus.jackson.map.annotate.JsonSerialize;

import com.hummingbird.common.util.convertor.JacksonDateSerializer;
import com.hummingbird.common.util.convertor.JacksonDateTimeSerializer;

/**
 * 查看发布信息详情接口 
 * @author YJY  
 * @since 2015年11月10日16:21:54
 * @see 用于规范json
 * */

//{"replier":12,"replierName":"王大力","replierLogo":"URL","isMember":"true","replyContent:"好","replyTime":"2015-01-01 01:01:01"},
public class UserInformationComments{
	
	private Integer   replier;
	private String   replierName;
	private String   replyContent;
//	private String   replierLogo;
//	private String   isMember;
	private Date   replyTime;
	/**
	 * @return the replier
	 */
	public Integer getReplier() {
		return replier;
	}
	/**
	 * @return the replierName
	 */
	public String getReplierName() {
		return replierName;
	}
	/**
	 * @return the replyContent
	 */
	public String getReplyContent() {
		return replyContent;
	}
	/**
	 * @return the replyTime
	 */
	@JsonSerialize(using = JacksonDateTimeSerializer.class)
	public Date getReplyTime() {
		return replyTime;
	}
	/**
	 * @param replier the replier to set
	 */
	public void setReplier(Integer replier) {
		this.replier = replier;
	}
	/**
	 * @param replierName the replierName to set
	 */
	public void setReplierName(String replierName) {
		this.replierName = replierName;
	}
	/**
	 * @param replyContent the replyContent to set
	 */
	public void setReplyContent(String replyContent) {
		this.replyContent = replyContent;
	}
	/**
	 * @param replyTime the replyTime to set
	 */
	public void setReplyTime(Date replyTime) {
		this.replyTime = replyTime;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "UserInformationCommentsVO [replier=" + replier + ", replierName=" + replierName + ", replyContent="
				+ replyContent + ", replyTime=" + replyTime + "]";
	}



}
