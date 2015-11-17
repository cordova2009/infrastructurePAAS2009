package com.hummingbird.paas.vo;

import java.util.Date;
import java.util.List;

/**
 * 
 * @author YJY  
 * @since 2015年11月10日16:22:21
 * */
public class BidderCerticateSaveInfoBodyVO {
	
	private String token;
	private BidderBaseInfo baseInfo;
	private BidderLegalPerson legalPerson;
	private BidderRegisteredInfo registeredInfo;
	private BidderBankInfo bankInfo;
	private List<BidderEqInfo> eqInfo;
	/**
	 * @return the token
	 */
	public String getToken() {
		return token;
	}
	/**
	 * @return the baseInfo
	 */
	public BidderBaseInfo getBaseInfo() {
		return baseInfo;
	}
	/**
	 * @return the legalPerson
	 */
	public BidderLegalPerson getLegalPerson() {
		return legalPerson;
	}
	/**
	 * @return the registeredInfo
	 */
	public BidderRegisteredInfo getRegisteredInfo() {
		return registeredInfo;
	}
	/**
	 * @return the bankInfo
	 */
	public BidderBankInfo getBankInfo() {
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
	public void setBaseInfo(BidderBaseInfo baseInfo) {
		this.baseInfo = baseInfo;
	}
	/**
	 * @param legalPerson the legalPerson to set
	 */
	public void setLegalPerson(BidderLegalPerson legalPerson) {
		this.legalPerson = legalPerson;
	}
	/**
	 * @param registeredInfo the registeredInfo to set
	 */
	public void setRegisteredInfo(BidderRegisteredInfo registeredInfo) {
		this.registeredInfo = registeredInfo;
	}
	/**
	 * @param bankInfo the bankInfo to set
	 */
	public void setBankInfo(BidderBankInfo bankInfo) {
		this.bankInfo = bankInfo;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	/**
	 * @return the eqInfo
	 */
	public List<BidderEqInfo> getEqInfo() {
		return eqInfo;
	}
	/**
	 * @param eqInfo the eqInfo to set
	 */
	public void setEqInfo(List<BidderEqInfo> eqInfo) {
		this.eqInfo = eqInfo;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "BidderCerticateSaveInfoBodyVO [token=" + token + ", baseInfo=" + baseInfo + ", legalPerson="
				+ legalPerson + ", registeredInfo=" + registeredInfo + ", bankInfo=" + bankInfo + ", eqInfo=" + eqInfo
				+ "]";
	}
	
	
	
	
}
