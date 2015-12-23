package com.hummingbird.paas.entity;

import java.util.Date;

/**
 * 工程付款定义明细表
 */
public class ProjectPaymentDefineDetailAndPay extends ProjectPaymentDefineDetail {
    
	/**
     * 支付时间
     */
    private Date payTime;

    /**
     * 状态,CRT待支付,OK#已支付,FLS支付失败
     */
    private String status;

	/**
	 * 支付时间 
	 */
	public Date getPayTime() {
		return payTime;
	}

	/**
	 * 支付时间 
	 */
	public void setPayTime(Date payTime) {
		this.payTime = payTime;
	}

	/**
	 * 状态CRT待支付OK#已支付FLS支付失败 
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * 状态CRT待支付OK#已支付FLS支付失败 
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ProjectPaymentDefineDetailAndPay [payTime=" + payTime + ", status=" + status + ", id=" + id
				+ ", projectPaymentDefineId=" + projectPaymentDefineId + ", period=" + period + ", payEndTime="
				+ payEndTime + ", payStartTime=" + payStartTime + ", paySum=" + paySum + "]";
	}
    
    
	
	
}