package com.hummingbird.paas.vo;

import java.util.Date;

import org.codehaus.jackson.map.annotate.JsonDeserialize;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import com.hummingbird.common.util.convertor.JacksonDateSerializer;
import com.hummingbird.common.util.convertor.JacksonDateTimeSerializer;
import com.hummingbird.paas.util.JacksonDateDeserializer;

/**
 * 投标人资质信息
 * 
 * @author YJY
 * @since 2015年11月10日16:22:07
 * @see 用于规范json
 */

// "baseInfo":{
// "companyName":"深圳蜂鸟娱乐技术有限公司",
// "shortName":"蜂鸟娱乐",
// "description":"公司简介",
// "registeredCapital":"",
// "telephone":"",
// "email":"",
// "logoUrl":"LOGO_IMAGE_URL"
// }
public class BidderEqInfo {

	private String projectType;
	/**
	 * 工程类别名称
	 */
	private String projectTypeName;
	private String eqName;
	private String eqRating;
	private Integer eqId;
	private String certificationContent;
	private String applicableRegion;
	private String certificationNo;   
	private Integer certificationId;   
	
	private Date expiryDate;

	/**
	 * @return the projectType
	 */
	public String getProjectType() {
		return projectType;
	}

	/**
	 * @return the projectTypeName
	 */
	public String getProjectTypeName() {
		return projectTypeName;
	}

	/**
	 * @return the eqName
	 */
	public String getEqName() {
		return eqName;
	}

	/**
	 * @return the eqRating
	 */
	public String getEqRating() {
		return eqRating;
	}

	/**
	 * @return the eqId
	 */
	public Integer getEqId() {
		return eqId;
	}

	/**
	 * @return the certificationContent
	 */
	public String getCertificationContent() {
		return certificationContent;
	}

	/**
	 * @return the applicableRegion
	 */
	public String getApplicableRegion() {
		return applicableRegion;
	}

	/**
	 * @return the certificationNo
	 */
	public String getCertificationNo() {
		return certificationNo;
	}

	/**
	 * @return the expiryDate
	 */
	@JsonSerialize(using = JacksonDateSerializer.class)
	public Date getExpiryDate() {
		return expiryDate;
	}

	/**
	 * @param projectType the projectType to set
	 */
	
	public void setProjectType(String projectType) {
		this.projectType = projectType;
	}

	/**
	 * @param projectTypeName the projectTypeName to set
	 */
	public void setProjectTypeName(String projectTypeName) {
		this.projectTypeName = projectTypeName;
	}

	/**
	 * @param eqName the eqName to set
	 */
	public void setEqName(String eqName) {
		this.eqName = eqName;
	}

	/**
	 * @param eqRating the eqRating to set
	 */
	public void setEqRating(String eqRating) {
		this.eqRating = eqRating;
	}

	/**
	 * @param eqId the eqId to set
	 */
	public void setEqId(Integer eqId) {
		this.eqId = eqId;
	}

	/**
	 * @param certificationContent the certificationContent to set
	 */
	public void setCertificationContent(String certificationContent) {
		this.certificationContent = certificationContent;
	}

	/**
	 * @param applicableRegion the applicableRegion to set
	 */
	public void setApplicableRegion(String applicableRegion) {
		this.applicableRegion = applicableRegion;
	}

	/**
	 * @param certificationNo the certificationNo to set
	 */
	public void setCertificationNo(String certificationNo) {
		this.certificationNo = certificationNo;
	}

	/**
	 * @param expiryDate the expiryDate to set
	 */
	@JsonDeserialize(using = JacksonDateDeserializer.class)
	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "BidderEqInfo [projectType=" + projectType + ", projectTypeName=" + projectTypeName + ", eqName="
				+ eqName + ", eqRating=" + eqRating + ", eqId=" + eqId + ", certificationContent="
				+ certificationContent + ", applicableRegion=" + applicableRegion + ", certificationNo="
				+ certificationNo + ", expiryDate=" + expiryDate + "]";
	}

	/**
	 * @return the certificationId
	 */
	public Integer getCertificationId() {
		return certificationId;
	}

	/**
	 * @param certificationId the certificationId to set
	 */
	public void setCertificationId(Integer certificationId) {
		this.certificationId = certificationId;
	}

	

	
}
