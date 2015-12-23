package com.hummingbird.paas.vo;

/**
 * @author john huang
 * 2015年12月19日 下午11:15:52
 * 本类主要做为 首页查询投标人列表
 */
public class QueryBidderListHomepageResultVO extends QueryBidderListResultVO {
	/**
	 * 信用等级
	 */
	private String creditLevel;

	/**
	 * 信用等级 
	 */
	public String getCreditLevel() {
		return creditLevel;
	}

	/**
	 * 信用等级 
	 */
	public void setCreditLevel(String creditLevel) {
		this.creditLevel = creditLevel;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "QueryBidderListHomepageResultVO [creditLevel=" + creditLevel + ", bidderName=" + bidderName
				+ ", userName=" + userName + ", bidderId=" + bidderId + "]";
	}
	
	



}
