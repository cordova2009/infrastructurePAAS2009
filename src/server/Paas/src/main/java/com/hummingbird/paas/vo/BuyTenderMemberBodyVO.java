package com.hummingbird.paas.vo;

public class BuyTenderMemberBodyVO {
     private String token;
     private String productId;
     private Integer memberDuration;
     private String payMethod;
     private Long payAmount;
	 public String getToken() {
		return token;
	 }
	 public void setToken(String token) {
		this.token = token;
	 }
	
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public Integer getMemberDuration() {
		return memberDuration;
	}
	public void setMemberDuration(Integer memberDuration) {
		this.memberDuration = memberDuration;
	}
	public String getPayMethod() {
		return payMethod;
	}
	public void setPayMethod(String payMethod) {
		this.payMethod = payMethod;
	}
	public Long getPayAmount() {
		return payAmount;
	}
	public void setPayAmount(Long payAmount) {
		this.payAmount = payAmount;
	}
	@Override
	public String toString() {
		return "BuyTenderMemberBodyVO [token=" + token + ", productId=" + productId + ", memberDuration="
				+ memberDuration + ", payMethod=" + payMethod + ", payAmount=" + payAmount + "]";
	}
     
}
