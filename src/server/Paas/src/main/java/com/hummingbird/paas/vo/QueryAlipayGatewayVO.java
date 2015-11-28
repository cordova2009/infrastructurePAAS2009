package com.hummingbird.paas.vo;

import com.hummingbird.paas.entity.QueryAlipayGateway;

public class QueryAlipayGatewayVO {
	/**
	 * 错误代码
	 */
	private String errcode;
	/**
	 * 错误消息
	 */
	private String errmsg;
	/**
	 * 支付宝网关支付查询
	 */
	private QueryAlipayGateway result;
	
	/**
	 * 错误代码
	 */
	public String getErrcode() {
		return errcode;
	}
	public void setErrcode(String errcode) {
		this.errcode = errcode;
	}
	public String getErrmsg() {
		return errmsg;
	}
	public void setErrmsg(String errmsg) {
		this.errmsg = errmsg;
	}
	public QueryAlipayGateway getResult() {
		return result;
	}
	public void setResult(QueryAlipayGateway result) {
		this.result = result;
	}
	
}
