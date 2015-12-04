package com.hummingbird.paas.vo;

import java.util.Date;

/**
 * 提交用户信息接口 
 * @author YJY  
 * @since 2015年11月10日16:21:54
 * @see 用于规范json
 * */

//"body":{
//    "token":"12345",
//    "objectAmount":"3000万",
//    "informationId":1,
//    "district":"广州市",
//    "objectName":"项目名称",
//    "employer":"甲方xxxxxx",
//    "phase":"招标阶段",
//    "projectPeriod":"半年",
//    "projectSituation":"本项目主要是xxxx",
//    "address":"xx路666号"
//}
public class UserInformationCommonVO {
	

	private String   objectAmount;
	private Integer  informationId;
	private String   district;
	private String   objectName;
	private String   objectType;
	private String   employer;
	private String   phase;
	private String   projectPeriod;
	private String   projectSituation;
	private String   address;
	/**
	 * @return the objectAmount
	 */
	public String getObjectAmount() {
		return objectAmount;
	}
	/**
	 * @return the informationId
	 */
	public Integer getInformationId() {
		return informationId;
	}
	/**
	 * @return the district
	 */
	public String getDistrict() {
		return district;
	}
	/**
	 * @return the objectName
	 */
	public String getObjectName() {
		return objectName;
	}
	/**
	 * @return the objectType
	 */
	public String getObjectType() {
		return objectType;
	}
	/**
	 * @return the employer
	 */
	public String getEmployer() {
		return employer;
	}
	/**
	 * @return the phase
	 */
	public String getPhase() {
		return phase;
	}
	/**
	 * @return the projectPeriod
	 */
	public String getProjectPeriod() {
		return projectPeriod;
	}
	/**
	 * @return the projectSituation
	 */
	public String getProjectSituation() {
		return projectSituation;
	}
	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}
	/**
	 * @param objectAmount the objectAmount to set
	 */
	public void setObjectAmount(String objectAmount) {
		this.objectAmount = objectAmount;
	}
	/**
	 * @param informationId the informationId to set
	 */
	public void setInformationId(Integer informationId) {
		this.informationId = informationId;
	}
	/**
	 * @param district the district to set
	 */
	public void setDistrict(String district) {
		this.district = district;
	}
	/**
	 * @param objectName the objectName to set
	 */
	public void setObjectName(String objectName) {
		this.objectName = objectName;
	}
	/**
	 * @param objectType the objectType to set
	 */
	public void setObjectType(String objectType) {
		this.objectType = objectType;
	}
	/**
	 * @param employer the employer to set
	 */
	public void setEmployer(String employer) {
		this.employer = employer;
	}
	/**
	 * @param phase the phase to set
	 */
	public void setPhase(String phase) {
		this.phase = phase;
	}
	/**
	 * @param projectPeriod the projectPeriod to set
	 */
	public void setProjectPeriod(String projectPeriod) {
		this.projectPeriod = projectPeriod;
	}
	/**
	 * @param projectSituation the projectSituation to set
	 */
	public void setProjectSituation(String projectSituation) {
		this.projectSituation = projectSituation;
	}
	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "UserInformationCommonVO [objectAmount=" + objectAmount + ", informationId=" + informationId
				+ ", district=" + district + ", objectName=" + objectName + ", objectType=" + objectType + ", employer="
				+ employer + ", phase=" + phase + ", projectPeriod=" + projectPeriod + ", projectSituation="
				+ projectSituation + ", address=" + address + "]";
	}
	



}
