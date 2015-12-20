package com.hummingbird.paas.vo;

public class QueryBidderListResultVO {
	/**
	 * 公司名
	 */
	protected String bidderName;
	/**
	 * 用户名
	 */
	protected String userName;
	/**
	 * 投标人id
	 */
	protected Integer bidderId;

	public String getBidderName() {
		return bidderName;
	}

	public void setBidderName(String bidderName) {
		this.bidderName = bidderName;
	}

	public Integer getBidderId() {
		return bidderId;
	}

	public void setBidderId(Integer bidderId) {
		this.bidderId = bidderId;
	}

	/**
	 * 用户名 
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * 用户名 
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "QueryBidderListResultVO [bidderName=" + bidderName + ", userName=" + userName + ", bidderId=" + bidderId
				+ "]";
	}



}
