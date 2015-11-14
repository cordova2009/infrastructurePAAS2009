package com.hummingbird.paas.vo;

public class QueryObjectDetailBidFilTypeInfo {
       private String needBusinessStandard;
       private String needTechnicalStandard;
       private String needCertificationCheckupFile;
	public String getNeedBusinessStandard() {
		return needBusinessStandard;
	}
	public void setNeedBusinessStandard(String needBusinessStandard) {
		this.needBusinessStandard = needBusinessStandard;
	}
	public String getNeedTechnicalStandard() {
		return needTechnicalStandard;
	}
	public void setNeedTechnicalStandard(String needTechnicalStandard) {
		this.needTechnicalStandard = needTechnicalStandard;
	}
	public String getNeedCertificationCheckupFile() {
		return needCertificationCheckupFile;
	}
	public void setNeedCertificationCheckupFile(String needCertificationCheckupFile) {
		this.needCertificationCheckupFile = needCertificationCheckupFile;
	}
	@Override
	public String toString() {
		return "QueryObjectDetailBidFilTypeInfo [needBusinessStandard=" + needBusinessStandard
				+ ", needTechnicalStandard=" + needTechnicalStandard + ", needCertificationCheckupFile="
				+ needCertificationCheckupFile + "]";
	}
    
}
