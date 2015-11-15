package com.hummingbird.paas.vo;

public class QueryObjectDetailBidderBidderCertification {
    private Integer certificateId;
    private String certificateName;
	public Integer getCertificateId() {
		return certificateId;
	}
	public void setCertificateId(Integer certificateId) {
		this.certificateId = certificateId;
	}
	public String getCertificateName() {
		return certificateName;
	}
	public void setCertificateName(String certificateName) {
		this.certificateName = certificateName;
	}
	@Override
	public String toString() {
		return "QueryObjectDetailBidderBidderCertification [certificateId=" + certificateId + ", certificateName="
				+ certificateName + "]";
	}
    
}
