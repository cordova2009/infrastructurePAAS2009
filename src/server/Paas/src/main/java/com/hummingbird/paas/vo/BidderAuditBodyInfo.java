package com.hummingbird.paas.vo;

import java.util.Date;
import java.util.List;

/**
 * 投标人认证审核接口 
 * @author YJY  
 * @since 2015年11月18日17:12:20
 * @see 用于规范json
 * */

//"baseInfoCheck":{
//    "biddeeId":999,
//    "companyName":{"result":"FLS","msg":"公司名称与工商注册名称不一致"},
//    "shortName":{"result":"OK#","msg":""},
//    "description":{"result":"OK#","msg":""},
//    "registeredCapital":{"result":"OK#","msg":""},
//    "telephone":{"result":"OK#","msg":""},
//    "email":{"result":"OK#","msg":""},
//    "logoUrl":{"result":"OK#","msg":""}
//}
public class BidderAuditBodyInfo {
	
	private BidderBaseInfoCheck  baseInfoCheck;
	private BidderLegalPersonCheck  legalPersonCheck;
	private BidderRegisteredInfoCheck  registeredInfoCheck;
	private BidderBankInfoCheck  bankInfoCheck;
	/**
	 * 证书审核列表
	 */
	private List<CertificationCheck>  certificationsCheck;
	/**
	 * @return the baseInfoCheck
	 */
	public BidderBaseInfoCheck getBaseInfoCheck() {
		return baseInfoCheck;
	}
	/**
	 * @return the legalPersonCheck
	 */
	public BidderLegalPersonCheck getLegalPersonCheck() {
		return legalPersonCheck;
	}
	/**
	 * @return the registeredInfoCheck
	 */
	public BidderRegisteredInfoCheck getRegisteredInfoCheck() {
		return registeredInfoCheck;
	}
	/**
	 * @return the bankInfoCheck
	 */
	public BidderBankInfoCheck getBankInfoCheck() {
		return bankInfoCheck;
	}
	/**
	 * @param baseInfoCheck the baseInfoCheck to set
	 */
	public void setBaseInfoCheck(BidderBaseInfoCheck baseInfoCheck) {
		this.baseInfoCheck = baseInfoCheck;
	}
	/**
	 * @param legalPersonCheck the legalPersonCheck to set
	 */
	public void setLegalPersonCheck(BidderLegalPersonCheck legalPersonCheck) {
		this.legalPersonCheck = legalPersonCheck;
	}
	/**
	 * @param registeredInfoCheck the registeredInfoCheck to set
	 */
	public void setRegisteredInfoCheck(BidderRegisteredInfoCheck registeredInfoCheck) {
		this.registeredInfoCheck = registeredInfoCheck;
	}
	/**
	 * @param bankInfoCheck the bankInfoCheck to set
	 */
	public void setBankInfoCheck(BidderBankInfoCheck bankInfoCheck) {
		this.bankInfoCheck = bankInfoCheck;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "BidderAuditBodyInfo [baseInfoCheck=" + baseInfoCheck + ", legalPersonCheck=" + legalPersonCheck
				+ ", registeredInfoCheck=" + registeredInfoCheck + ", bankInfoCheck=" + bankInfoCheck
				+ ", certificationsCheck=" + certificationsCheck + "]";
	}
	/**
	 * 证书审核列表
	 */
	public List<CertificationCheck> getCertificationsCheck() {
		return certificationsCheck;
	}
	/**
	 * 证书审核列表
	 */
	public void setCertificationsCheck(List<CertificationCheck> certificationsCheck) {
		this.certificationsCheck = certificationsCheck;
	}
	
	
}
