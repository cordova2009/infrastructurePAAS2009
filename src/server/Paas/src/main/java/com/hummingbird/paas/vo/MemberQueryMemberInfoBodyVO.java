package com.hummingbird.paas.vo;

public class MemberQueryMemberInfoBodyVO {
	private String token;

	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}

	@Override
	public String toString() {
		return "MemberQueryMemberInfoBodyVO [token=" + token + "]";
	}

}
