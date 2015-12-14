/**
 * 
 * PaymentBodyVO.java
 * 版本所有 深圳市蜂鸟娱乐有限公司 2013-2014
 */
package com.hummingbird.paas.vo;

/**
 * @author john huang
 * 2015年12月13日 下午9:54:39
 * 本类主要做为 平台支付
 */
public class PlatformPaymentBodyVO {

	/**
	 * 收入
	 */
	private Long amount;
	
	/**
	 * 
	 * 第三方应用 
	 */
	private String appOrderId;

	/**
	 * 收入 
	 */
	public Long getAmount() {
		return amount;
	}

	/**
	 * 收入 
	 */
	public void setAmount(Long amount) {
		this.amount = amount;
	}

	/**
	 * 第三方应用 
	 */
	public String getAppOrderId() {
		return appOrderId;
	}

	/**
	 * 第三方应用 
	 */
	public void setAppOrderId(String appOrderId) {
		this.appOrderId = appOrderId;
	}
}
