/**
 * 
 * BidSelectedEvent.java
 * 版本所有 深圳市蜂鸟娱乐有限公司 2013-2014
 */
package com.hummingbird.capital.event;

import com.hummingbird.common.event.BusinessEvent;
import com.hummingbird.common.exception.BusinessException;

/**
 * @author YJY
 * 2015年12月20日11:05:44
 * 本类主要做为 确认付款事件
 */
public class ConfirmPayEvent implements BusinessEvent {

	/**
	 * 付款工程
	 */
	private String projectId;
	/**
	 * 付款状态
	 */
	private String payStatus;
	/**
	 * 付款人
	 */
	private Integer biddeeId;
	
	/**
	 * 收款人
	 */
	private Integer bidderId;

	/**
	 * 构造函数
	 * @param projectId 中标标的
	 * @param  biddeeId 付款人
	 * @param bidderId 收款人
	 */

	public ConfirmPayEvent(String projectId, Integer biddeeId, Integer bidderId) {
		this.projectId = projectId;
		this.biddeeId = biddeeId;
		this.bidderId = bidderId;
	}
	
	/**
	 * 构造函数
	 * @param projectId 中标标的
	 * @param  biddeeId 付款人
	 * @param payStatus 付款状态
	 */

	public ConfirmPayEvent(String projectId, Integer biddeeId,String payStatus) {
		this.projectId = projectId;
		this.biddeeId = biddeeId;
		this.payStatus = payStatus;
	}

	/**
	 * @return the projectId
	 */
	public String getProjectId() {
		return projectId;
	}

	/**
	 * @return the biddeeId
	 */
	public Integer getBiddeeId() {
		return biddeeId;
	}

	/**
	 * @return the bidderId
	 */
	public Integer getBidderId() {
		return bidderId;
	}

	/**
	 * @param projectId the projectId to set
	 */
	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}

	/**
	 * @param biddeeId the biddeeId to set
	 */
	public void setBiddeeId(Integer biddeeId) {
		this.biddeeId = biddeeId;
	}

	/**
	 * @param bidderId the bidderId to set
	 */
	public void setBidderId(Integer bidderId) {
		this.bidderId = bidderId;
	}

	/**
	 * @return the payStatus
	 */
	public String getPayStatus() {
		return payStatus;
	}

	/**
	 * @param payStatus the payStatus to set
	 */
	public void setPayStatus(String payStatus) {
		this.payStatus = payStatus;
	}

	
	
	
	
	
	
}
