package com.hummingbird.paas.vo;

import java.util.List;

public class QueryMemberProductResultVO {
	private List<QueryMemberProductResultBodyVO> results;
	private String teeMember;
	private String teeMemberExpireTime;
	private String terMember;
	@Override
	public String toString() {
		return "QueryMemberProductResultVO [qmrps=" + results + ", teeMember=" + teeMember + ", teeMemberExpireTime="
				+ teeMemberExpireTime + ", terMember=" + terMember + ", terMemberExpireTime=" + terMemberExpireTime
				+ "]";
	}

	private String terMemberExpireTime;

	

	public List<QueryMemberProductResultBodyVO> getResults() {
		return results;
	}

	public void setResults(List<QueryMemberProductResultBodyVO> results) {
		this.results = results;
	}

	public String getTeeMember() {
		return teeMember;
	}

	public void setTeeMember(String teeMember) {
		this.teeMember = teeMember;
	}

	public String getTeeMemberExpireTime() {
		return teeMemberExpireTime;
	}

	public void setTeeMemberExpireTime(String teeMemberExpireTime) {
		this.teeMemberExpireTime = teeMemberExpireTime;
	}

	public String getTerMember() {
		return terMember;
	}

	public void setTerMember(String terMember) {
		this.terMember = terMember;
	}

	public String getTerMemberExpireTime() {
		return terMemberExpireTime;
	}

	public void setTerMemberExpireTime(String terMemberExpireTime) {
		this.terMemberExpireTime = terMemberExpireTime;
	}

}
