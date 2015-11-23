package com.hummingbird.paas.vo;

public class QueryObjectDetailBondInfo {
	private String bidBondAmount;

	public String getBidBondAmount() {
		return bidBondAmount;
	}

	public void setBidBondAmount(String bidBondAmount) {
		this.bidBondAmount = bidBondAmount;
	}

	@Override
	public String toString() {
		return "QueryObjectDetailBondInfo [bidBondAmount=" + bidBondAmount + "]";
	}

}
