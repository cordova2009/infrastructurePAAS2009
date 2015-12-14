/**
 * 
 * AlipayOrderResultQueryBodyVO.java
 * 版本所有 深圳市蜂鸟娱乐有限公司 2013-2014
 */
package com.hummingbird.payment.vo;

/**
 * @author john huang
 * 2015年12月8日 下午11:47:24
 * 本类主要做为 订单查询的内容
 */
public class AlipayOrderResultQueryBodyVO {

	private String orderId;

	/**
	 * #{bare_field_comment} 
	 */
	public String getOrderId() {
		return orderId;
	}

	/**
	 * #{bare_field_comment} 
	 */
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "AlipayOrderResultQueryBodyVO [orderId=" + orderId + "]";
	}
	
	
}
