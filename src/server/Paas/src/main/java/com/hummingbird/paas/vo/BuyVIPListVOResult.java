package com.hummingbird.paas.vo;

public class BuyVIPListVOResult {

	/**
	 * 产品名称
	 */
	private String productName;
	/**
	 * 会员类型，TEE招标方会员，TER投标方会员
	 */
	private String memberType;
	/**
	 * 产品单价，单位为分
	 */
	private String productPrice;
	/**
	 * 产品描述
	 */
	private String productDesc;
	/**
	 * 产品id
	 */
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

}
