package com.hummingbird.capital.vo;

import com.hummingbird.commonbiz.vo.PagingnationVO;

public class TokenQueryVO extends PagingnationVO{
	private String token;

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
}
