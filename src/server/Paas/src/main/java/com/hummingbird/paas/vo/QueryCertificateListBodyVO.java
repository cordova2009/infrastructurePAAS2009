package com.hummingbird.paas.vo;

import com.hummingbird.commonbiz.vo.PagingnationVO;

public class QueryCertificateListBodyVO extends PagingnationVO {
  
	/**
	 * 搜索的投标人名称
	 */
	private String bidderName;

	/**
	 * 搜索的投标人名称 
	 */
	public String getBidderName() {
		return bidderName;
	}

	/**
	 * 搜索的投标人名称 
	 */
	public void setBidderName(String bidderName) {
		this.bidderName = bidderName;
	}
	
}
