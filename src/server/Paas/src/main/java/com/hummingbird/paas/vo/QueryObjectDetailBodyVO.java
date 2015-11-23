package com.hummingbird.paas.vo;

public class QueryObjectDetailBodyVO {
	private String token;
	private String objectId;

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getObjectId() {
		return objectId;
	}

	public void setObjectId(String objectId) {
		this.objectId = objectId;
	}

	@Override
	public String toString() {
		return "QueryObjectDetailBodyVO [token=" + token + ", objectId=" + objectId + "]";
	}
}
