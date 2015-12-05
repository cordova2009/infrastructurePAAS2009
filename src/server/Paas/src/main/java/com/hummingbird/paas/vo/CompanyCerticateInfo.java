package com.hummingbird.paas.vo;

import java.util.Date;

/**
 * 证书信息  
 * @author YJY  
 * @since 2015年12月4日15:28:30
 * @see 用于规范json
 * */

//"certicateName":"一级建造师",
//"certicateNum":8,
//"certicateUrl":"URL"
public class CompanyCerticateInfo {
	
	private String  certicateName;
//	private Integer  certicateNum;
	private String  certicateUrl;
	/**
	 * @return the certicateName
	 */
	public String getCerticateName() {
		return certicateName;
	}
	/**
	 * @return the certicateUrl
	 */
	public String getCerticateUrl() {
		return certicateUrl;
	}
	/**
	 * @param certicateName the certicateName to set
	 */
	public void setCerticateName(String certicateName) {
		this.certicateName = certicateName;
	}
	/**
	 * @param certicateUrl the certicateUrl to set
	 */
	public void setCerticateUrl(String certicateUrl) {
		this.certicateUrl = certicateUrl;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "CompanyCerticateInfo [certicateName=" + certicateName + ", certicateUrl=" + certicateUrl + "]";
	}
	
	
	

	

}
