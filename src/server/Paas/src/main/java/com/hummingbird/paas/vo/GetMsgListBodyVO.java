package com.hummingbird.paas.vo;

import com.hummingbird.common.face.Pagingnation;
import com.hummingbird.commonbiz.vo.PagingnationVO;

public class GetMsgListBodyVO  extends PagingnationVO{
    private String token;
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	
	@Override
	public String toString() {
		return "GetMsgListBodyVO [token=" + token + ", pageIndex=" + pageIndex + ", pageSize=" + pageSize + "]";
	}
}
