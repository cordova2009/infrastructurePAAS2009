package com.hummingbird.paas.entity;

/**
 * 标的资质证书要求表
 */
public class CertificationRequirement {
    /**
     * 主键
     */
    private Integer id;

    /**
     * 标的id
     */
    private String objectId;

    /**
     * 资质id
     */
    private Integer certificationId;

    /**
     * 资质名称
     */
    private String certificationName;

    /**
     * 板块分类,来自行业版块表
     */
    private String industryId;

    /**
     * @return 主键
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id 
	 *            主键
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return 标的id
     */
    public String getObjectId() {
        return objectId;
    }

    /**
     * @param objectId 
	 *            标的id
     */
    public void setObjectId(String objectId) {
        this.objectId = objectId == null ? null : objectId.trim();
    }

    /**
     * @return 资质id
     */
    public Integer getCertificationId() {
        return certificationId;
    }

    /**
     * @param certificationId 
	 *            资质id
     */
    public void setCertificationId(Integer certificationId) {
        this.certificationId = certificationId;
    }

    /**
     * @return 资质名称
     */
    public String getCertificationName() {
        return certificationName;
    }

    /**
     * @param certificationName 
	 *            资质名称
     */
    public void setCertificationName(String certificationName) {
        this.certificationName = certificationName == null ? null : certificationName.trim();
    }

    /**
     * @return 板块分类,来自行业版块表
     */
    public String getIndustryId() {
        return industryId;
    }

    /**
     * @param industryId 
	 *            板块分类,来自行业版块表
     */
    public void setIndustryId(String industryId) {
        this.industryId = industryId == null ? null : industryId.trim();
    }

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "CertificationRequirement [id=" + id + ", objectId=" + objectId + ", certificationId=" + certificationId
				+ ", certificationName=" + certificationName + ", industryId=" + industryId + "]";
	}
}