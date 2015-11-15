package com.hummingbird.paas.vo;

import java.util.List;

import com.hummingbird.paas.entity.BidderCertification;

public class QueryObjectDetailBidderCertificationInfo {
     private List<QueryObjectDetailBidderBidderCertification> bidderCertification;
     private String needPmCertification;
     private String needConstructorCertification;
     private String needSafetyPermit;
     private String needPmSafetyCertification;
	public List<QueryObjectDetailBidderBidderCertification> getBidderCertification() {
		return bidderCertification;
	}

	public void setBidderCertification(List<QueryObjectDetailBidderBidderCertification> bidderCertification) {
		this.bidderCertification = bidderCertification;
	}

	public String getNeedPmCertification() {
		return needPmCertification;
	}

	public void setNeedPmCertification(String needPmCertification) {
		this.needPmCertification = needPmCertification;
	}

	public String getNeedConstructorCertification() {
		return needConstructorCertification;
	}

	public void setNeedConstructorCertification(String needConstructorCertification) {
		this.needConstructorCertification = needConstructorCertification;
	}

	public String getNeedSafetyPermit() {
		return needSafetyPermit;
	}

	public void setNeedSafetyPermit(String needSafetyPermit) {
		this.needSafetyPermit = needSafetyPermit;
	}

	public String getNeedPmSafetyCertification() {
		return needPmSafetyCertification;
	}

	public void setNeedPmSafetyCertification(String needPmSafetyCertification) {
		this.needPmSafetyCertification = needPmSafetyCertification;
	}

	@Override
	public String toString() {
		return "QueryObjectDetailBidderCertificationInfo [bidderCertification=" + bidderCertification
				+ ", needPmCertification=" + needPmCertification + ", needConstructorCertification="
				+ needConstructorCertification + ", needSafetyPermit=" + needSafetyPermit
				+ ", needPmSafetyCertification=" + needPmSafetyCertification + "]";
	}

	
	

     
}
