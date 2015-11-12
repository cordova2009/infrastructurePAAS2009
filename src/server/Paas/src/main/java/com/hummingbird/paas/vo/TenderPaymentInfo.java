package com.hummingbird.paas.vo;

import java.util.Date;
import java.util.List;

/**
 * 工程付款信息  
 * @author YJY  
 * @since 2015年11月12日14:08:52
 * @see 用于规范json
 * */

//"paymentInfo":{
//    "payType":"CUM",
//    "payPeriod":12
//    "payList":[{"period":1,"payDate":"2015-06-12","paySum":50000}]
//}
public class TenderPaymentInfo {
	
	private String  payType;
	private Integer  payPeriod;
	private List<TenderPaymentDetailInfo>  payList;
	/**
	 * @return the payType
	 */
	public String getPayType() {
		return payType;
	}
	/**
	 * @return the payPeriod
	 */
	public Integer getPayPeriod() {
		return payPeriod;
	}
	/**
	 * @return the payList
	 */
	public List<TenderPaymentDetailInfo> getPayList() {
		return payList;
	}
	/**
	 * @param payType the payType to set
	 */
	public void setPayType(String payType) {
		this.payType = payType;
	}
	/**
	 * @param payPeriod the payPeriod to set
	 */
	public void setPayPeriod(Integer payPeriod) {
		this.payPeriod = payPeriod;
	}
	/**
	 * @param payList the payList to set
	 */
	public void setPayList(List<TenderPaymentDetailInfo> payList) {
		this.payList = payList;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "TenderPaymentInfo [payType=" + payType + ", payPeriod=" + payPeriod + ", payList=" + payList + "]";
	}


	

}
