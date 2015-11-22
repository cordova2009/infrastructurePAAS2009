package com.hummingbird.paas.vo;

import java.util.Date;

/**
 * 
 * @author YJY  
 * @since 2015年11月7日12:12:1
 * */
public class BiddeeCerticateSaveBaseInfoBodyVO {
	
	private String token;
	private BiddeeBaseInfo baseInfo;
	/**
	 * @return the token
	 */
	public String getToken() {
		return token;
	}
	/**
	 * @return the baseInfo
	 */
	public BiddeeBaseInfo getBaseInfo() {
		return baseInfo;
	}
	/**
	 * @param token the token to set
	 */
	public void setToken(String token) {
		this.token = token;
	}
	/**
	 * @param baseInfo the baseInfo to set
	 */
	public void setBaseInfo(BiddeeBaseInfo baseInfo) {
		this.baseInfo = baseInfo;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "BiddeeCerticateSaveBaseInfoBodyVO [token=" + token + ", baseInfo=" + baseInfo + "]";
	}
	
	
}
