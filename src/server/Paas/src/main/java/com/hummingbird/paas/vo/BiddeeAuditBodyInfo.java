package com.hummingbird.paas.vo;

import java.util.Date;

/**
 * 招标人认证审核接口 
 * @author YJY  
 * @since 2015年11月7日11:06:3
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
public class BiddeeAuditBodyInfo {
	
	private BiddeeBaseInfoCheck  baseInfoCheck;
	private BiddeeLegalPersonCheck  legalPersonCheck;
	private BiddeeRegisteredInfoCheck  registeredInfoCheck;
	private BiddeeBankInfoCheck  bankInfoCheck;
	/**
	 * @return the baseInfoCheck
	 */
	public BiddeeBaseInfoCheck getBaseInfoCheck() {
		return baseInfoCheck;
	}
	/**
	 * @return the legalPersonCheck
	 */
	public BiddeeLegalPersonCheck getLegalPersonCheck() {
		return legalPersonCheck;
	}
	/**
	 * @return the registeredInfoCheck
	 */
	public BiddeeRegisteredInfoCheck getRegisteredInfoCheck() {
		return registeredInfoCheck;
	}
	/**
	 * @return the bankInfoCheck
	 */
	public BiddeeBankInfoCheck getBankInfoCheck() {
		return bankInfoCheck;
	}
	/**
	 * @param baseInfoCheck the baseInfoCheck to set
	 */
	public void setBaseInfoCheck(BiddeeBaseInfoCheck baseInfoCheck) {
		this.baseInfoCheck = baseInfoCheck;
	}
	/**
	 * @param legalPersonCheck the legalPersonCheck to set
	 */
	public void setLegalPersonCheck(BiddeeLegalPersonCheck legalPersonCheck) {
		this.legalPersonCheck = legalPersonCheck;
	}
	/**
	 * @param registeredInfoCheck the registeredInfoCheck to set
	 */
	public void setRegisteredInfoCheck(BiddeeRegisteredInfoCheck registeredInfoCheck) {
		this.registeredInfoCheck = registeredInfoCheck;
	}
	/**
	 * @param bankInfoCheck the bankInfoCheck to set
	 */
	public void setBankInfoCheck(BiddeeBankInfoCheck bankInfoCheck) {
		this.bankInfoCheck = bankInfoCheck;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "BiddeeAuditBodyInfo [baseInfoCheck=" + baseInfoCheck + ", legalPersonCheck=" + legalPersonCheck
				+ ", registeredInfoCheck=" + registeredInfoCheck + ", bankInfoCheck=" + bankInfoCheck + "]";
	}

	
}
