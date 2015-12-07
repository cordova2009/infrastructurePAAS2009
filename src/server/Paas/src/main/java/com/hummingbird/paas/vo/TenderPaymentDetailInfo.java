package com.hummingbird.paas.vo;

import java.util.Date;

import org.codehaus.jackson.map.annotate.JsonSerialize;

import com.hummingbird.common.util.convertor.JacksonDateSerializer;

/**
 * 工程付款 详细信息  
 * @author YJY  
 * @since 2015年11月12日14:08:52
 * @see 用于规范json
 * */

//"paymentInfo":{
//    "payType":"CUM",
//    "payPeriod":12
//    "payList":[{"period":1,"payDate":"2015-06-12","paySum":50000}]
//}
public class TenderPaymentDetailInfo {
	
	private Integer  period;
	private Date  payDate;
	private Long  paySum;
	/**
	 * @return the period
	 */
	public Integer getPeriod() {
		return period;
	}
	/**
	 * @return the payDate
	 */
	@JsonSerialize(using = JacksonDateSerializer.class)
	public Date getPayDate() {
		return payDate;
	}
	/**
	 * @return the paySum
	 */
	public Long getPaySum() {
		return paySum;
	}
	/**
	 * @param period the period to set
	 */
	public void setPeriod(Integer period) {
		this.period = period;
	}
	/**
	 * @param payDate the payDate to set
	 */
	public void setPayDate(Date payDate) {
		this.payDate = payDate;
	}
	/**
	 * @param paySum the paySum to set
	 */
	public void setPaySum(Long paySum) {
		this.paySum = paySum;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "TenderPaymentDetailInfo [period=" + period + ", payDate=" + payDate + ", paySum=" + paySum + "]";
	}


	

}
