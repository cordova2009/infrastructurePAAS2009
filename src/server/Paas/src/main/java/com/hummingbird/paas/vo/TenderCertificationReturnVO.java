package com.hummingbird.paas.vo;

import java.util.Date;

/**
 * 证书详细
 * @author YJY  
 * @since 2015年11月12日17:22:21
 * */
public class TenderCertificationReturnVO {
//	"certificationList":[{
//        "certificationId":1,
//        "certificationName":"一级建造师"
//    }]
	private Integer certificationId;
	private String  certificationName;
	/**
	 * @return the certificationId
	 */
	public Integer getCertificationId() {
		return certificationId;
	}
	/**
	 * @return the certificationName
	 */
	public String getCertificationName() {
		return certificationName;
	}
	/**
	 * @param certificationId the certificationId to set
	 */
	public void setCertificationId(Integer certificationId) {
		this.certificationId = certificationId;
	}
	/**
	 * @param certificationName the certificationName to set
	 */
	public void setCertificationName(String certificationName) {
		this.certificationName = certificationName;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "TenderCertificationReturnVO [certificationId=" + certificationId + ", certificationName="
				+ certificationName + "]";
	}
	
	


}
