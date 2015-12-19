/**
 * 
 * CertificationCheck.java
 * 版本所有 深圳市蜂鸟娱乐有限公司 2013-2014
 */
package com.hummingbird.paas.vo;

/**
 * @author john huang
 * 2015年12月18日 下午4:19:41
 * 本类主要做为 证书资质审核内容
 */
public class CertificationCheck {

	/**
	 * 资质证书id
	 */
	private Integer certificationApplyId;
	
	/**
	 * 审核内容
	 */
	private AuditInfo certificationApply;

	/**
	 * 资质证书id 
	 */
	public Integer getCertificationApplyId() {
		return certificationApplyId;
	}

	/**
	 * 资质证书id 
	 */
	public void setCertificationApplyId(Integer certificationApplyId) {
		this.certificationApplyId = certificationApplyId;
	}

	/**
	 * 审核内容 
	 */
	public AuditInfo getCertificationApply() {
		return certificationApply;
	}

	/**
	 * 审核内容 
	 */
	public void setCertificationApply(AuditInfo certificationApply) {
		this.certificationApply = certificationApply;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "CertificationCheck [certificationApplyId=" + certificationApplyId + ", certificationApply="
				+ certificationApply + "]";
	}
	
	
	
}
