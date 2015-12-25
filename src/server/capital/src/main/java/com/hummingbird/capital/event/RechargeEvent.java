/**
 * 
 * BidSelectedEvent.java
 * 版本所有 深圳市蜂鸟娱乐有限公司 2013-2014
 */
package com.hummingbird.capital.event;

import java.util.List;

import com.hummingbird.common.event.BusinessEvent;
import com.hummingbird.common.exception.BusinessException;

/**
 * @author YJY
 * 2015年12月19日17:37:33
 * 本类主要做为用户充值事件
 */
public class RechargeEvent implements BusinessEvent {

	/**
	 * 充值人
	 */
	private Integer userId;
	/**
	 * 充值金额
	 */
	private String amount;
	/**
	 * 充值状态
	 */
	private String status;
	/**
	 * @return the userId
	 */
	public Integer getUserId() {
		return userId;
	}
	/**
	 * @return the amount
	 */
	public String getAmount() {
		return amount;
	}
	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}
	/**
	 * @param userId the userId to set
	 */
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	/**
	 * @param amount the amount to set
	 */
	public void setAmount(String amount) {
		this.amount = amount;
	}
	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	public RechargeEvent(Integer userId, String amount, String status) {
		this.userId = userId;
		this.amount = amount;
		this.status = status;
	}
	

	
	
	
	
	
}
