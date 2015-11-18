package com.hummingbird.paas.vo;

import java.util.Date;

/**
 * 消息详细
 * @author YJY  
 * @since 2015年11月12日14:01:46
 * */
public class TenderBidEvaluationBodyVO {
//	 "token":"4356576",
//     "objectId":"BH201302140056",
//     "winBidId":"BH23108721334",
//     "paymentInfo":{
//         "payType":"CUM",
//         "payPeriod":12
//         "payList":[{"period":1,"payDate":"2015-06-12","paySum":50000}]
//     }
	private String token;
	private String objectId;
	private Integer winBidId;
	private TenderPaymentInfo paymentInfo;
	/**
	 * @return the token
	 */
	public String getToken() {
		return token;
	}
	/**
	 * @return the objectId
	 */
	public String getObjectId() {
		return objectId;
	}
	/**
	 * @return the winBidId
	 */
	public Integer getWinBidId() {
		return winBidId;
	}
	/**
	 * @return the paymentInfo
	 */
	public TenderPaymentInfo getPaymentInfo() {
		return paymentInfo;
	}
	/**
	 * @param token the token to set
	 */
	public void setToken(String token) {
		this.token = token;
	}
	/**
	 * @param objectId the objectId to set
	 */
	public void setObjectId(String objectId) {
		this.objectId = objectId;
	}
	/**
	 * @param winBidId the winBidId to set
	 */
	public void setWinBidId(Integer winBidId) {
		this.winBidId = winBidId;
	}
	/**
	 * @param paymentInfo the paymentInfo to set
	 */
	public void setPaymentInfo(TenderPaymentInfo paymentInfo) {
		this.paymentInfo = paymentInfo;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "TenderBidEvaluationBodyVO [token=" + token + ", objectId=" + objectId + ", winBidId=" + winBidId
				+ ", paymentInfo=" + paymentInfo + "]";
	}

}
