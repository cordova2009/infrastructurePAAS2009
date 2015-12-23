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
 * 本类主要做为工程款提现事件
 */
public class projectPaymentWithdrawalsApplyEvent implements BusinessEvent {

	/**
	 * 提现订单号
	 */
	private String orderId;
	/**
	 * 提现人
	 */
	private Integer bidderId;
	/**
	 * 提现金额
	 */
	private Long amount;
	/**
	 * 提现状态
	 */
	private String status;
	/**
	 * @return the orderId
	 */
	
	public String getOrderId() {
		return orderId;
	}
	/**
	 * @return the bidderId
	 */
	public Integer getBidderId() {
		return bidderId;
	}
	/**
	 * @return the amount
	 */
	public Long getAmount() {
		return amount;
	}
	/**
	 * @param orderId the orderId to set
	 */
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	/**
	 * @param bidderId the bidderId to set
	 */
	public void setBidderId(Integer bidderId) {
		this.bidderId = bidderId;
	}
	/**
	 * @param amount the amount to set
	 */
	public void setAmount(Long amount) {
		this.amount = amount;
	}
	public projectPaymentWithdrawalsApplyEvent(String orderId, Integer bidderId, Long amount, String status) {
		this.orderId = orderId;
		this.bidderId = bidderId;
		this.amount = amount;
		this.status = status;
	}
	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}
	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	
	
	

	
	
	
	
	
}
