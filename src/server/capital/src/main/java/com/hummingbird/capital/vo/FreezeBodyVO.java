package com.hummingbird.capital.vo;

/**
 * @author john huang
 * 2015年12月18日 下午9:02:14
 * 本类主要做为 冻结的相关内容
 */
public class FreezeBodyVO {
	private String token;
	private String type;
	private Long amount;
	private String appOrderId;
	private String objectId;
	private String remark;
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "FreezeBodyVO [token=" + token + ", type=" + type + ", amount=" + amount + ", appOrderId=" + appOrderId
				+ ", objectId=" + objectId + ", remark=" + remark + "]";
	}
	

	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getObjectId() {
		return objectId;
	}
	public void setObjectId(String objectId) {
		this.objectId = objectId;
	}
	
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	
	public Long getAmount() {
		return amount;
	}
	public void setAmount(Long amount) {
		this.amount = amount;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getAppOrderId() {
		return appOrderId;
	}

	public void setAppOrderId(String appOrderId) {
		this.appOrderId = appOrderId;
	}
	
}
