package com.hummingbird.paas.vo;

import java.util.Date;

/**
 * 投标人认证信息  
 * @author YJY  
 * @since 2015年11月10日16:21:25
 * @see 用于规范json
 * */

public class BidderAuthInfo {
	
	private String  status;
	private Integer  creditScore;
	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}
	/**
	 * @return the creditScore
	 */
	public Integer getCreditScore() {
		return creditScore;
	}
	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	/**
	 * @param creditScore the creditScore to set
	 */
	public void setCreditScore(Integer creditScore) {
		this.creditScore = creditScore;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "BiddeeAuthInfo [status=" + status + ", creditScore=" + creditScore + "]";
	}
	
	
}
