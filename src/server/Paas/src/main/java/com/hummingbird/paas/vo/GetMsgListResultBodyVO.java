package com.hummingbird.paas.vo;

public class GetMsgListResultBodyVO {
    private Integer msgId;
    private String msgType;
    private String msgIcon;
    private String msgTitle;
    private String msgContent;
    private String createTime;
    private String isRead;
    private String msgSender;
	public Integer getMsgId() {
		return msgId;
	}
	public void setMsgId(Integer msgId) {
		this.msgId = msgId;
	}
	public String getMsgType() {
		return msgType;
	}
	public void setMsgType(String msgType) {
		this.msgType = msgType;
	}
	public String getMsgIcon() {
		return msgIcon;
	}
	public void setMsgIcon(String msgIcon) {
		this.msgIcon = msgIcon;
	}
	public String getMsgTitle() {
		return msgTitle;
	}
	public void setMsgTitle(String msgTitl) {
		this.msgTitle = msgTitl;
	}
	public String getMsgContent() {
		return msgContent;
	}
	public void setMsgContent(String msgContent) {
		this.msgContent = msgContent;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	public String getIsRead() {
		return isRead;
	}
	public void setIsRead(String isRead) {
		this.isRead = isRead;
	}
	public String getMsgSender() {
		return msgSender;
	}
	public void setMsgSender(String msgSender) {
		this.msgSender = msgSender;
	}
	@Override
	public String toString() {
		return "GetMsgListResultBodyVO [msgId=" + msgId + ", msgType=" + msgType + ", msgIcon=" + msgIcon + ", msgTitle="
				+ msgTitle + ", msgContent=" + msgContent + ", createTime=" + createTime + ", isRead=" + isRead
				+ ", msgSender=" + msgSender + "]";
	}
    
}
