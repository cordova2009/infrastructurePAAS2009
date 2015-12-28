/**
 * 
 * CertificationInfo.java
 * 版本所有 深圳市蜂鸟娱乐有限公司 2013-2014
 */
package com.hummingbird.paas.vo;

//"certificationInfo":[{
//    "name":"一级资质证书",
//            "status":"未认证",
//            "creditScore":"10分"
//        }]
public class CertificationInfo {

	/**
	 * 资质证书名称
	 */
	private String name;
	/**
	 * 资质证书审核状态
	 */
	private String status;
	/**
	 * 资质证书积分
	 */
	private Integer creditScore;
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}
	/**
	 * @return the creditScore
	 */
	public Integer getCreditScore() {
		return creditScore;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	/**
	 * @param creditScore the creditScore to set
	 */
	public void setCreditScore(Integer creditScore) {
		this.creditScore = creditScore;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "CertificationInfo [name=" + name + ", status=" + status + ", creditScore=" + creditScore + "]";
	}
	
	
	
	
}
