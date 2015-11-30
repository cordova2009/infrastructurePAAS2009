package com.hummingbird.paas.entity;

public class QueryAlipayGateway {
	/**
	 * 支付宝支付单号
	 */
	private String alipayOrderId;
	/**
	 * 应用订单号
	 */
	private String orderId;
	/**
	 * 状态,OK# 支付成功,FLS 支付失败, NON 无记录,OTH 其它状态
	 */
	private String status;
	/**
	 * 支付时间
	 */
	private String payTime;
	/**
	 * 备注,如失败可以放一些失败的原因等
	 */
	private String remark;
	public String getAlipayOrderId() {
		return alipayOrderId;
	}
	public void setAlipayOrderId(String alipayOrderId) {
		this.alipayOrderId = alipayOrderId;
	}
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getPayTime() {
		return payTime;
	}
	public void setPayTime(String payTime) {
		this.payTime = payTime;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	
}
