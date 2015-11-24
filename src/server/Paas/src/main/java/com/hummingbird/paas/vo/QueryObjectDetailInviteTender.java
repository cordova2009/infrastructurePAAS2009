package com.hummingbird.paas.vo;

public class QueryObjectDetailInviteTender {
	private String bidderName;
	private Integer bidderId;

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

	@Override
	public String toString() {
		return "QueryObjectDetailInviteTender [bidderName=" + bidderName + ", bidderId=" + bidderId + "]";
	}

}
