package com.hummingbird.paas.vo;

public class GetNoticeListBodyVO {

	private Integer pageIndex;
	private Integer pageSize;

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
		return "GetNoticeListBodyVO [pageIndex=" + pageIndex + ", pageSize=" + pageSize +  "]";
	}
}
