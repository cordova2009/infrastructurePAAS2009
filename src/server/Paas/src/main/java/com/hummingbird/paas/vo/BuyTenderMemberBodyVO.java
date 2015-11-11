package com.hummingbird.paas.vo;

public class BuyTenderMemberBodyVO {
     private String token;
     private String memberType;
     private Integer memberDuration;
     private String payMethod;
     private Integer payAmount;
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public String getMemberType() {
		return memberType;
	}
	public void setMemberType(String memberType) {
		this.memberType = memberType;
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
	public Integer getPayAmount() {
		return payAmount;
	}
	public void setPayAmount(Integer payAmount) {
		this.payAmount = payAmount;
	}
	@Override
	public String toString() {
		return "BuyTenderMemberBodyVO [token=" + token + ", memberType=" + memberType + ", memberDuration="
				+ memberDuration + ", payMethod=" + payMethod + ", payAmount=" + payAmount + "]";
	}
     
}
