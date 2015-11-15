package com.hummingbird.paas.vo;

public class QueryObjectDetailBidEvaluationTypeInfo {
	private String bidEvalutionType;
	private String bidEvalutionSite;
	private String bidWinnerDatemineWay;
	private String voteWinWay;

	public String getBidEvalutionType() {
		return bidEvalutionType;
	}

	public void setBidEvalutionType(String bidEvalutionType) {
		this.bidEvalutionType = bidEvalutionType;
	}

	public String getBidEvalutionSite() {
		return bidEvalutionSite;
	}

	public void setBidEvalutionSite(String bidEvalutionSite) {
		this.bidEvalutionSite = bidEvalutionSite;
	}

	public String getBidWinnerDatemineWay() {
		return bidWinnerDatemineWay;
	}

	public void setBidWinnerDatemineWay(String bidWinnerDatemineWay) {
		this.bidWinnerDatemineWay = bidWinnerDatemineWay;
	}

	public String getVoteWinWay() {
		return voteWinWay;
	}

	public void setVoteWinWay(String voteWinWay) {
		this.voteWinWay = voteWinWay;
	}

	@Override
	public String toString() {
		return "QueryObjectDetailBidEvaluationTypeInfo [bidEvalutionType=" + bidEvalutionType + ", bidEvalutionSite="
				+ bidEvalutionSite + ", bidWinnerDatemineWay=" + bidWinnerDatemineWay + ", voteWinWay=" + voteWinWay
				+ "]";
	}
	
}
