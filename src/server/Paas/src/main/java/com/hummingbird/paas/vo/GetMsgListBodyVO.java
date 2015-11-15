package com.hummingbird.paas.vo;

public class GetMsgListBodyVO {
    private String token;
    private Integer pageIndex;
    private Integer pageSize;
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public Integer getPageIndex() {
		return pageIndex;
	}
	public void setPageIndex(Integer pageIndex) {
		this.pageIndex = pageIndex;
	}
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	@Override
	public String toString() {
		return "GetMsgListBodyVO [token=" + token + ", pageIndex=" + pageIndex + ", pageSize=" + pageSize + "]";
	}
}
