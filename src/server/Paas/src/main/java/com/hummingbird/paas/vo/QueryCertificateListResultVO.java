package com.hummingbird.paas.vo;

import java.util.List;

public class QueryCertificateListResultVO {
    private String industryId;
    private String industryName;
    private List<QueryCertificateListResultBodyVO> certificateList;

	public String getIndustryId() {
		return industryId;
	}
	public void setIndustryId(String industryId) {
		this.industryId = industryId;
	}
	public String getIndustryName() {
		return industryName;
	}
	public void setIndustryName(String industryName) {
		this.industryName = industryName;
	}
	public List<QueryCertificateListResultBodyVO> getCertificateList() {
		return certificateList;
	}
	public void setCertificateList(List<QueryCertificateListResultBodyVO> certificateList) {
		this.certificateList = certificateList;
	}
	@Override
	public String toString() {
		return "QueryCertificateListResultVO [industryId=" + industryId + ", industryName=" + industryName
				+ ", certificateList=" + certificateList + "]";
	}
    
}
