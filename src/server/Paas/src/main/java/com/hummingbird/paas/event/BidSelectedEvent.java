/**
 * 
 * BidSelectedEvent.java
 * 版本所有 深圳市蜂鸟娱乐有限公司 2013-2014
 */
package com.hummingbird.paas.event;

import com.hummingbird.common.event.BusinessEvent;
import com.hummingbird.common.exception.BusinessException;

/**
 * @author john huang
 * 2015年12月11日 下午6:05:34
 * 本类主要做为 定标事件
 */
public class BidSelectedEvent implements BusinessEvent {

	/**
	 * 中标标的
	 */
	private String objectId;
	/**
	 * 中标投标人
	 */
	private Integer bidderId;

	/**
	 * 构造函数
	 * @param objectId 中标标的
	 * @param bidderId 中标投标人
	 */
	public BidSelectedEvent(String objectId, Integer bidderId) {
		this.objectId = objectId;
		// TODO Auto-generated constructor stub
		this.bidderId = bidderId;
	}

	/**
	 * 中标标的 
	 */
	public String getObjectId() {
		return objectId;
	}

	/**
	 * 中标标的 
	 */
	public void setObjectId(String objectId) {
		this.objectId = objectId;
	}

	/**
	 * 中标投标人 
	 */
	public Integer getBidderId() {
		return bidderId;
	}

	/**
	 * 中标投标人 
	 */
	public void setBidderId(Integer bidderId) {
		this.bidderId = bidderId;
	}

	
	
	
	
	
}
