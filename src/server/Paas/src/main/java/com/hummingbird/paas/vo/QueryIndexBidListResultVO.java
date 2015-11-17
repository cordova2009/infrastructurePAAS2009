package com.hummingbird.paas.vo;

import java.util.Date;

public class QueryIndexBidListResultVO {
//	"biderId":3,
//    "shortName":"稳健基础",
//    "companyLogo":"LOGO_URL",
	private Integer biderId;
	private String shortName;
	private String companyLogo;
	/**
	 * @return the biderId
	 */
	public Integer getBiderId() {
		return biderId;
	}
	/**
	 * @return the shortName
	 */
	public String getShortName() {
		return shortName;
	}
	/**
	 * @return the companyLogo
	 */
	public String getCompanyLogo() {
		return companyLogo;
	}
	/**
	 * @param biderId the biderId to set
	 */
	public void setBiderId(Integer biderId) {
		this.biderId = biderId;
	}
	/**
	 * @param shortName the shortName to set
	 */
	public void setShortName(String shortName) {
		this.shortName = shortName;
	}
	/**
	 * @param companyLogo the companyLogo to set
	 */
	public void setCompanyLogo(String companyLogo) {
		this.companyLogo = companyLogo;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "QueryIndexBidListResultVO [biderId=" + biderId + ", shortName=" + shortName + ", companyLogo="
				+ companyLogo + "]";
	}
	


}
