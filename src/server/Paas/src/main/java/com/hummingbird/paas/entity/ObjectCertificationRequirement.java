package com.hummingbird.paas.entity;

/**
 * 标的资质证书要求表
 */
public class ObjectCertificationRequirement {
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

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        ObjectCertificationRequirement other = (ObjectCertificationRequirement) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getObjectId() == null ? other.getObjectId() == null : this.getObjectId().equals(other.getObjectId()))
            && (this.getCertificationId() == null ? other.getCertificationId() == null : this.getCertificationId().equals(other.getCertificationId()))
            && (this.getCertificationName() == null ? other.getCertificationName() == null : this.getCertificationName().equals(other.getCertificationName()))
            && (this.getIndustryId() == null ? other.getIndustryId() == null : this.getIndustryId().equals(other.getIndustryId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getObjectId() == null) ? 0 : getObjectId().hashCode());
        result = prime * result + ((getCertificationId() == null) ? 0 : getCertificationId().hashCode());
        result = prime * result + ((getCertificationName() == null) ? 0 : getCertificationName().hashCode());
        result = prime * result + ((getIndustryId() == null) ? 0 : getIndustryId().hashCode());
        return result;
    }
}