package com.hummingbird.paas.vo;

import java.util.List;

public class QueryObjectDetailObjectMethondInfo {
	private String objectMethodInfo;
	private List<QueryObjectDetailInviteTender> inviteTender;

	public String getObjectMethodInfo() {
		return objectMethodInfo;
	}

	public void setObjectMethodInfo(String objectMethodInfo) {
		this.objectMethodInfo = objectMethodInfo;
	}

	public List<QueryObjectDetailInviteTender> getInviteTender() {
		return inviteTender;
	}

	public void setInviteTender(List<QueryObjectDetailInviteTender> inviteTender) {
		this.inviteTender = inviteTender;
	}

	@Override
	public String toString() {
		return "QueryObjectDetailObjectMethondInfo [objectMethodInfo=" + objectMethodInfo + "]";
	}

}
