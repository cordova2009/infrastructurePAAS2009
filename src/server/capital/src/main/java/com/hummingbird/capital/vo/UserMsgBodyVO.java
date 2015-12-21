package com.hummingbird.capital.vo;

import java.util.Date;

/**
 * 添加用户消息 
 * @author YJY  
 * @since 2015年12月19日10:52:32
 * @see 用于规范json
 * */

//"body":{
//    "userId":"erwd123",
//    "msgContent":"恭喜您在招标\"天宫一号\"项目中中标了",
//    "msgType":"PRI",
//    "msgTitle":"中标通知"
//}
public class UserMsgBodyVO{
	
	private Integer   userId;

	private String   msgContent;
	private String   msgType;
	private String   msgTitle;
	/**
	 * @return the userId
	 */
	public Integer getUserId() {
		return userId;
	}
	/**
	 * @return the msgContent
	 */
	public String getMsgContent() {
		return msgContent;
	}
	/**
	 * @return the msgType
	 */
	public String getMsgType() {
		return msgType;
	}
	/**
	 * @return the msgTitle
	 */
	public String getMsgTitle() {
		return msgTitle;
	}
	/**
	 * @param userId the userId to set
	 */
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	/**
	 * @param msgContent the msgContent to set
	 */
	public void setMsgContent(String msgContent) {
		this.msgContent = msgContent;
	}
	/**
	 * @param msgType the msgType to set
	 */
	public void setMsgType(String msgType) {
		this.msgType = msgType;
	}
	/**
	 * @param msgTitle the msgTitle to set
	 */
	public void setMsgTitle(String msgTitle) {
		this.msgTitle = msgTitle;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "UserMsgBodyVO [userId=" + userId + ", msgContent=" + msgContent + ", msgType=" + msgType + ", msgTitle="
				+ msgTitle + "]";
	}
	

}
