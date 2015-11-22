/**
 * 
 * CertificationMatchVO.java
 * 版本所有 深圳市蜂鸟娱乐有限公司 2013-2014
 */
package com.hummingbird.paas.vo;

/**
 * @author john huang
 * 2015年11月19日 下午10:54:29
 * 本类主要做为 资质匹配结果
 */
public class CertificationMatchVO {

	/**
	 * 投标人资质证书记录id
	 */
	Integer bidderCertificationId;
	
	/**
	 * 资质证书id
	 */
	Integer certificationTypeId;
	
	/**
	 * 是否匹配
	 */
	boolean match;
	
	/**
	 * 不匹配原因
	 */
	String reason;

	/**
	 * 投标人资质证书记录id 
	 */
	public Integer getBidderCertificationId() {
		return bidderCertificationId;
	}

	/**
	 * 投标人资质证书记录id 
	 */
	public void setBidderCertificationId(Integer bidderCertificationId) {
		this.bidderCertificationId = bidderCertificationId;
	}

	/**
	 * 资质证书id 
	 */
	public Integer getCertificationTypeId() {
		return certificationTypeId;
	}

	/**
	 * 资质证书id 
	 */
	public void setCertificationTypeId(Integer certificationTypeId) {
		this.certificationTypeId = certificationTypeId;
	}

	/**
	 * 是否匹配 
	 */
	public boolean isMatch() {
		return match;
	}

	/**
	 * 是否匹配 
	 */
	public void setMatch(boolean match) {
		this.match = match;
	}

	/**
	 * 不匹配原因 
	 */
	public String getReason() {
		return reason;
	}

	/**
	 * 不匹配原因 
	 */
	public void setReason(String reason) {
		this.reason = reason;
	}
	
	
	
	
}
