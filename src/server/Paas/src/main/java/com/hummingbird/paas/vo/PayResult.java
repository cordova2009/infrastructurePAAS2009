/**
 * 
 * PayResult.java
 * 版本所有 深圳市蜂鸟娱乐有限公司 2013-2014
 */
package com.hummingbird.paas.vo;

import java.util.Date;

/**
 * @author john huang
 * 2015年12月3日 上午9:18:28
 * 本类主要做为 支付结果
 */
public class PayResult {

	/**
	 * 订单号
	 */
	private String orderId;
	
	/**
	 * 支付平台订单号
	 */
	private String tradeId;
	
	/**
	 * 支付状态,CRT 待支付,OK# 已支付,FLS 支付失败,CAL 取消,NON 不存在
	 */
	private String payStatus;
	
	/**
	 * 支付时间 
	 */
	private Date payTime;
	
	/**
	 * 支付方式,ALI 支付宝,AAC 平台支付
	 */
	private String payType;

	/**
	 * 订单号 
	 */
	public String getOrderId() {
		return orderId;
	}

	/**
	 * 订单号 
	 */
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	/**
	 * 支付平台订单号 
	 */
	public String getTradeId() {
		return tradeId;
	}

	/**
	 * 支付平台订单号 
	 */
	public void setTradeId(String tradeId) {
		this.tradeId = tradeId;
	}

	/**
	 * 支付状态CRT 待支付OK# 已支付FLS 支付失败CAL 取消 ,NON 不存在
	 */
	public String getPayStatus() {
		return payStatus;
	}

	/**
	 * 支付状态CRT 待支付OK# 已支付FLS 支付失败CAL 取消 ,NON 不存在
	 */
	public void setPayStatus(String payStatus) {
		this.payStatus = payStatus;
	}

	/**
	 * 支付时间 
	 */
	public Date getPayTime() {
		return payTime;
	}

	/**
	 * 支付时间 
	 */
	public void setPayTime(Date payTime) {
		this.payTime = payTime;
	}

	/**
	 * 支付方式ALI 支付宝AAC 平台支付 
	 */
	public String getPayType() {
		return payType;
	}

	/**
	 * 支付方式ALI 支付宝AAC 平台支付 
	 */
	public void setPayType(String payType) {
		this.payType = payType;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "PayResult [orderId=" + orderId + ", tradeId=" + tradeId + ", payStatus=" + payStatus + ", payTime="
				+ payTime + ", payType=" + payType + "]";
	}
	
}
