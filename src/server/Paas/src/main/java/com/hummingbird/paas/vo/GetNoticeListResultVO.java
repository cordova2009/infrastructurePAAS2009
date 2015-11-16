package com.hummingbird.paas.vo;

import java.util.List;

public class GetNoticeListResultVO {
	private List<GetSiteNewsListResultVO> list;
	private Integer total;

	public List<GetSiteNewsListResultVO> getList() {
		return list;
	}

	public void setList(List<GetSiteNewsListResultVO> list) {
		this.list = list;
	}

	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}

	@Override
	public String toString() {
		return "GetNoticeListResultVO [list=" + list + ", total=" + total + "]";
	}
}
