/**
 * 
 * BidSelectedEvent.java
 * 版本所有 深圳市蜂鸟娱乐有限公司 2013-2014
 */
package com.hummingbird.paas.event;

import java.util.List;

import com.hummingbird.common.event.BusinessEvent;
import com.hummingbird.common.exception.BusinessException;

/**
 * @author YJY
 * 2015年12月19日17:37:33
 * 本类主要做为邀标事件
 */
public class InvBidEvent implements BusinessEvent {

	/**
	 * 邀标标的
	 */
	private String objectId;
	/**
	 * 被邀标人
	 */
	private List<Integer> bidderIds;

	/**
	 * 构造函数
	 * @param objectId 邀标标的
	 * @param bidderId 被邀标人
	 */
	public InvBidEvent(String objectId, List<Integer> bidderIds) {
		this.objectId = objectId;
		// TODO Auto-generated constructor stub
		this.bidderIds = bidderIds;
	}

	/**
	 * 邀标标的 
	 */
	public String getObjectId() {
		return objectId;
	}

	/**
	 * 邀标标的 
	 */
	public void setObjectId(String objectId) {
		this.objectId = objectId;
	}

	/**
	 * 被邀标人 
	 */
	public List<Integer> getBidderIds() {
		return bidderIds;
	}

	/**
	 * 被邀标人 
	 */
	public void setBidderIds(List<Integer> bidderIds) {
		this.bidderIds = bidderIds;
	}

	
	

	
	
	
	
	
}
