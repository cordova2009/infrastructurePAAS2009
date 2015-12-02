package com.hummingbird.paas.vo;

import java.util.Date;

import org.codehaus.jackson.map.annotate.JsonSerialize;

import com.hummingbird.common.util.convertor.JacksonDateSerializer;

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
	private String eqDesc;
	
	private Date expiryDate;

	/**
	 * @return the projectType
	 */
	public String getProjectType() {
		return projectType;
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
	 * @return the eqDesc
	 */
	public String getEqDesc() {
		return eqDesc;
	}

	/**
	 * @return the expiryDate
	 */
	@JsonSerialize(using = JacksonDateSerializer.class)
	public Date getExpiryDate() {
		return expiryDate;
	}

	/**
	 * @param projectType
	 *            the projectType to set
	 */
	public void setProjectType(String projectType) {
		this.projectType = projectType;
	}

	/**
	 * @param eqName
	 *            the eqName to set
	 */
	public void setEqName(String eqName) {
		this.eqName = eqName;
	}

	/**
	 * @param eqRating
	 *            the eqRating to set
	 */
	public void setEqRating(String eqRating) {
		this.eqRating = eqRating;
	}

	/**
	 * @param eqId
	 *            the eqId to set
	 */
	public void setEqId(Integer eqId) {
		this.eqId = eqId;
	}

	/**
	 * @param eqDesc
	 *            the eqDesc to set
	 */
	public void setEqDesc(String eqDesc) {
		this.eqDesc = eqDesc;
	}

	/**
	 * @param expiryDate
	 *            the expiryDate to set
	 */
	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "BidderEqInfo [projectType=" + projectType + ", projectTypeName=" + projectTypeName + ", eqName="
				+ eqName + ", eqRating=" + eqRating + ", eqId=" + eqId + ", eqDesc=" + eqDesc + ", expiryDate="
				+ expiryDate + "]";
	}

	/**
	 * 工程类别名称
	 */
	public String getProjectTypeName() {
		return projectTypeName;
	}

	/**
	 * 工程类别名称
	 */
	public void setProjectTypeName(String projectTypeName) {
		this.projectTypeName = projectTypeName;
	}

}
