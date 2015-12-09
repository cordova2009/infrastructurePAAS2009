package com.hummingbird.paas.vo;

public class QueryProjectAccountVO {
	private Integer errcode;
	private String errmsg;
	private QueryProjectAccountReturnVO account;
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
	public QueryProjectAccountReturnVO getAccount() {
		return account;
	}
	public void setAccount(QueryProjectAccountReturnVO account) {
		this.account = account;
	}
	
}
