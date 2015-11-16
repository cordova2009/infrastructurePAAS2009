package com.hummingbird.paas.vo;

import java.util.List;

public class GetMsgListResultVO {
	private List<GetMsgListResultBodyVO> data;
	private Integer total;

	public List<GetMsgListResultBodyVO> getData() {
		return data;
	}

	public void setData(List<GetMsgListResultBodyVO> data) {
		this.data = data;
	}

	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}

	@Override
	public String toString() {
		return "GetMsgListResultVO [data=" + data + ", total=" + total + "]";
	}
}
