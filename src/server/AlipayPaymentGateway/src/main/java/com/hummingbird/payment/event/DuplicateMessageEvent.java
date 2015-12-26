/**
 * 
 * DuplicateMessageEvent.java
 * 版本所有 深圳市蜂鸟娱乐有限公司 2013-2014
 */
package com.hummingbird.payment.event;

import com.hummingbird.common.event.BusinessEvent;
import com.hummingbird.common.exception.BusinessException;

/**
 * @author john huang
 * 2015年12月26日 下午12:35:04
 * 本类主要做为 消息复制事件
 */
public class DuplicateMessageEvent implements BusinessEvent {

	/**
	 * url的查询字符串
	 */
	private String queryString;

	/**
	 * 构造函数
	 * @param qs
	 */
	public DuplicateMessageEvent(String qs) {
		this.queryString = qs;
	}

	/**
	 * url的查询字符串 
	 */
	public String getQueryString() {
		return queryString;
	}

	/**
	 * url的查询字符串 
	 */
	public void setQueryString(String queryString) {
		this.queryString = queryString;
	}

}
