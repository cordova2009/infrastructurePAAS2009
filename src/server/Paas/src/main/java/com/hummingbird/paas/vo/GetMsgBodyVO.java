/**
 * 
 * GetMsgBodyVO.java
 * 版本所有 深圳市蜂鸟娱乐有限公司 2013-2014
 */
package com.hummingbird.paas.vo;

/**
 * @author john huang
 * 2015年12月1日 下午3:38:16
 * 本类主要做为 查询消息详情vo
 */
public class GetMsgBodyVO {

	/**
	 * 用户令牌
	 */
	private String token;
	
	/**
	 * 消息id
	 */
	private Integer msgId;

	/**
	 * 用户令牌 
	 */
	public String getToken() {
		return token;
	}

	/**
	 * 用户令牌 
	 */
	public void setToken(String token) {
		this.token = token;
	}

	/**
	 * 消息id 
	 */
	public Integer getMsgId() {
		return msgId;
	}

	/**
	 * 消息id 
	 */
	public void setMsgId(Integer msgId) {
		this.msgId = msgId;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "GetMsgBodyVO [token=" + token + ", msgId=" + msgId + "]";
	}
	
}
