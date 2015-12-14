/**
 * 
 * AlipayOrderResultResultVO.java
 * 版本所有 深圳市蜂鸟娱乐有限公司 2013-2014
 */
package com.hummingbird.payment.vo;

/**
 * @author john huang
 * 2015年12月9日 上午8:42:16
 * 本类主要做为 支付结果返回对象
 */
public class AlipayOrderResultResultVO {

	/**
	 * 支付时间
	 */
	String payTime;
	
	/**
	 * 支付结果,OK# 支付成功 ,FLS 支付失败,CRT 待支付,NON 不存在
	 */
	String payResult;
	/**
	 * 支付结果描述
	 */
	String payResultRemark;
	
	/**
	 * 支付平台订单号
	 */
	String tradeId;
	
	/**
	 * 第三方订单号
	 */
	String orderId;
	
	/**
	 * 支付类型
	 */
	String payType;

	/**
	 * 支付时间 
	 */
	public String getPayTime() {
		return payTime;
	}

	/**
	 * 支付时间 
	 */
	public void setPayTime(String payTime) {
		this.payTime = payTime;
	}

	/**
	 * 支付结果OK# 支付成功 FLS 支付失败CRT 待支付NON 不存在 
	 */
	public String getPayResult() {
		return payResult;
	}

	/**
	 * 支付结果OK# 支付成功 FLS 支付失败CRT 待支付NON 不存在 
	 */
	public void setPayResult(String payResult) {
		this.payResult = payResult;
	}

	/**
	 * 支付结果描述 
	 */
	public String getPayResultRemark() {
		return payResultRemark;
	}

	/**
	 * 支付结果描述 
	 */
	public void setPayResultRemark(String payResultRemark) {
		this.payResultRemark = payResultRemark;
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
	 * 第三方订单号 
	 */
	public String getOrderId() {
		return orderId;
	}

	/**
	 * 第三方订单号 
	 */
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	/**
	 * 支付类型 
	 */
	public String getPayType() {
		return payType;
	}

	/**
	 * 支付类型 
	 */
	public void setPayType(String payType) {
		this.payType = payType;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "AlipayOrderResultResultVO [payTime=" + payTime + ", payResult=" + payResult + ", payResultRemark="
				+ payResultRemark + ", tradeId=" + tradeId + ", orderId=" + orderId + ", payType=" + payType + "]";
	}
	
	
}
