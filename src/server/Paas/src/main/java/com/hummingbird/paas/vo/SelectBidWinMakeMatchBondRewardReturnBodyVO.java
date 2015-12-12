/**
 * 
 * SelectBidWinMakeMatchBondRewardReturnVO.java
 * 版本所有 深圳市蜂鸟娱乐有限公司 2013-2014
 */
package com.hummingbird.paas.vo;

import java.util.List;

/**
 * @author john huang
 * 2015年12月11日 下午1:40:56
 * 本类主要做为 定标时资金帐户 撮合保证金处理后返回的结果
 */

public class SelectBidWinMakeMatchBondRewardReturnBodyVO  {

	/**
	 * 中标的资金帐户订单号
	 */
	protected String appOrderId;
	/**
	 * 传入去的token
	 */
	protected String token;
	
	/**
	 * 中标的资金帐户订单号
	 */
	protected String orderId;
	
	/**
	 * 不中标的处理结果
	 */
	List<CapitalOrderReturnVO> lose;

	/**
	 * 中标的资金帐户订单号 
	 */
	public String getAppOrderId() {
		return appOrderId;
	}

	/**
	 * 中标的资金帐户订单号 
	 */
	public void setAppOrderId(String appOrderId) {
		this.appOrderId = appOrderId;
	}

	/**
	 * 中标的资金帐户订单号 
	 */
	public String getOrderId() {
		return orderId;
	}

	/**
	 * 中标的资金帐户订单号 
	 */
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	/**
	 * 不中标的处理结果 
	 */
	public List<CapitalOrderReturnVO> getLose() {
		return lose;
	}

	/**
	 * 不中标的处理结果 
	 */
	public void setLose(List<CapitalOrderReturnVO> lose) {
		this.lose = lose;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "SelectBidWinMakeMatchBondRewardReturnBodyVO [appOrderId=" + appOrderId + ", orderId=" + orderId
				+ ", lose=" + lose + "]";
	}

	/**
	 * 传入去的token 
	 */
	public String getToken() {
		return token;
	}

	/**
	 * 传入去的token 
	 */
	public void setToken(String token) {
		this.token = token;
	}
	
	

	
}
