package com.hummingbird.capital.vo;

public class FailWithdrawalsBodyVO {
	/*"body":{
	    "orderId":"ORDER_ID",            
	    "appOrderId":"审核id",            
	    "remark":"提现申请审核不通过，帐号不正确"
	}*/
	private String orderId;
	private String appOrderId;
	private String remark;
	
	@Override
	public String toString() {
		return "FailWithdrawalsBodyVO [orderId=" + orderId + ", appOrderId=" + appOrderId + 
				",remark="+remark+"]";
	}
	
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public String getAppOrderId() {
		return appOrderId;
	}
	public void setAppOrderId(String appOrderId) {
		this.appOrderId = appOrderId;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
}
