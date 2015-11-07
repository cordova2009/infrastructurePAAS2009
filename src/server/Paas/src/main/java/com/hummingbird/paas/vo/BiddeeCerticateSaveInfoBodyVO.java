package com.hummingbird.paas.vo;

import java.util.Date;

/**
 * 
 * @author YJY  
 * @since 2015年11月7日12:12:1
 * */
public class BiddeeCerticateSaveInfoBodyVO {
	
	private String token;
	private BiddeeBaseInfo baseInfo;
	private BiddeeLegalPerson legalPerson;
	private BiddeeRegisteredInfo registeredInfo;
	private BiddeeBankInfo bankInfo;
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
	 * @return the legalPerson
	 */
	public BiddeeLegalPerson getLegalPerson() {
		return legalPerson;
	}
	/**
	 * @return the registeredInfo
	 */
	public BiddeeRegisteredInfo getRegisteredInfo() {
		return registeredInfo;
	}
	/**
	 * @return the bankInfo
	 */
	public BiddeeBankInfo getBankInfo() {
		return bankInfo;
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
	/**
	 * @param legalPerson the legalPerson to set
	 */
	public void setLegalPerson(BiddeeLegalPerson legalPerson) {
		this.legalPerson = legalPerson;
	}
	/**
	 * @param registeredInfo the registeredInfo to set
	 */
	public void setRegisteredInfo(BiddeeRegisteredInfo registeredInfo) {
		this.registeredInfo = registeredInfo;
	}
	/**
	 * @param bankInfo the bankInfo to set
	 */
	public void setBankInfo(BiddeeBankInfo bankInfo) {
		this.bankInfo = bankInfo;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "BiddeeCerticateSaveInfoBodyVO [token=" + token + ", baseInfo=" + baseInfo + ", legalPerson="
				+ legalPerson + ", registeredInfo=" + registeredInfo + ", bankInfo=" + bankInfo + "]";
	}
	
	
	
}
