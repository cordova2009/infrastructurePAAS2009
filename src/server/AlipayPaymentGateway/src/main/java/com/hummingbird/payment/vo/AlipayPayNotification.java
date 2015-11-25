/**
 * 
 * AlipayPayNotification.java
 * 版本所有 深圳市蜂鸟娱乐有限公司 2013-2014
 */
package com.hummingbird.payment.vo;

import java.util.Date;

import com.hummingbird.commonbiz.face.PaymentNotification;

/**
 * @author john huang
 * 2015年3月30日 下午10:52:16
 * 本类主要做为
 */
public class AlipayPayNotification implements PaymentNotification{

	private boolean paysuccessed;
	private String orderId;
	private Date paytime;
	private Integer sum;
	private String transId;

	/* (non-Javadoc)
	 * @see com.hummingbird.commonbiz.face.PaymentNotification#getOrderId()
	 */
	@Override
	public String getOrderId() {
		return orderId;
	}

	/* (non-Javadoc)
	 * @see com.hummingbird.commonbiz.face.PaymentNotification#getPaytime()
	 */
	@Override
	public Date getPaytime() {
		return paytime;
	}

	/* (non-Javadoc)
	 * @see com.hummingbird.commonbiz.face.PaymentNotification#isPaySuccessed()
	 */
	@Override
	public boolean isPaySuccessed() {
		return paysuccessed;
	}

	/**
	 * @return the paysuccessed
	 */
	public boolean isPaysuccessed() {
		return paysuccessed;
	}

	/**
	 * @param paysuccessed the paysuccessed to set
	 */
	public void setPaysuccessed(boolean paysuccessed) {
		this.paysuccessed = paysuccessed;
	}

	/**
	 * @param orderId the orderId to set
	 */
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	/**
	 * @param paytime the paytime to set
	 */
	public void setPaytime(Date paytime) {
		this.paytime = paytime;
	}

	/* (non-Javadoc)
	 * @see com.hummingbird.commonbiz.face.PaymentNotification#getSum()
	 */
	@Override
	public Integer getSum() {
		return sum;
	}

	/**
	 * @param sum the sum to set
	 */
	public void setSum(Integer sum) {
		this.sum = sum;
	}

	/**
	 * @return
	 */
	public String getTransId() {
		return this.transId;
	}

	/**
	 * @param transId the transId to set
	 */
	public void setTransId(String transId) {
		this.transId = transId;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "AlipayPayNotification [paysuccessed=" + paysuccessed
				+ ", orderId=" + orderId + ", paytime=" + paytime + ", sum="
				+ sum + ", transId=" + transId + "]";
	}

}
