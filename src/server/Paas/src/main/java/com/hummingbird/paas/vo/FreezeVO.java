package com.hummingbird.paas.vo;

public class FreezeVO {
	private Integer errcode;
	private String errmsg;
	private FreezeBondReturnVO order;
	public Integer getErrcode() {
		return errcode;
	}
	public void setErrcode(Integer errcode) {
		this.errcode = errcode;
	}
	public String getErrmsg() {
		return errmsg;
	}
	public void setErrmsg(String errmsg) {
		this.errmsg = errmsg;
	}
	public FreezeBondReturnVO getOrder() {
		return order;
	}
	public void setOrder(FreezeBondReturnVO order) {
		this.order = order;
	}
	
}
