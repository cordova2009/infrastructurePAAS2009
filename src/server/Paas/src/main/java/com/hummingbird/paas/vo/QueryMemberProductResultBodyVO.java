package com.hummingbird.paas.vo;

public class QueryMemberProductResultBodyVO {
	private String productName;
	private String memberType;
	private String productPrice;
	private String productDesc;
	private String productId;

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getMemberType() {
		return memberType;
	}

	public void setMemberType(String memberType) {
		this.memberType = memberType;
	}

	public String getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(String productPrice) {
		this.productPrice = productPrice;
	}

	public String getProductDesc() {
		return productDesc;
	}

	public void setProductDesc(String productDesc) {
		this.productDesc = productDesc;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	@Override
	public String toString() {
		return "QueryMemberProductResultBodyVO [productName=" + productName + ", memberType=" + memberType
				+ ", productPrice=" + productPrice + ", productDesc=" + productDesc + ", productId=" + productId + "]";
	}
    
}
