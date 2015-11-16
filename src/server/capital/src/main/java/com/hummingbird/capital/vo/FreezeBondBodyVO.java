package com.hummingbird.capital.vo;

public class FreezeBondBodyVO {
	 /*"token":"USER_TOKEN",
     "objectId":"BH20150201321123",
     "remark":"冻结50000元施工保证金",
     "tradePassword":"TRADE_PASSWORD"*/
	private String token;
	private String objectId;
	private String remark;
	private String tradePassword;
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
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getTradePassword() {
		return tradePassword;
	}
	public void setTradePassword(String tradePassword) {
		this.tradePassword = tradePassword;
	}
	
}
