package com.hummingbird.paas.vo;

import java.util.List;

import com.hummingbird.commonbiz.vo.PagingnationVO;

public class QueryCertificateListBodyVO extends PagingnationVO {
  
	/**
	 * 搜索的投标人名称
	 */
	private String bidderName;
	
	/**
	 * 关键字
	 */
	private List<String> keywords;

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

	/**
	 * 关键字 
	 */
	public List<String> getKeywords() {
		return keywords;
	}

	/**
	 * 关键字 
	 */
	public void setKeywords(List<String> keywords) {
		this.keywords = keywords;
	}
	
}
