package com.hummingbird.paas.entity;

/**
 * 行业资质证书表,记录某个行业需要什么证书
 */
public class IndustryCertification {
    /**
     * id
     */
    private Integer id;

    /**
     * 行业id
     */
    private Integer industry_id;

    /**
     * 资质证书id
     */
    private Integer certification_id;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id 
	 *            id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return 行业id
     */
    public Integer getIndustry_id() {
        return industry_id;
    }

    /**
     * @param industryId 
	 *            行业id
     */
    public void setIndustry_id(Integer industry_id) {
        this.industry_id = industry_id;
    }

    /**
     * @return 资质证书id
     */
    public Integer getCertification_id() {
        return certification_id;
    }

    /**
     * @param certificationId 
	 *            资质证书id
     */
    public void setCertification_id(Integer certification_id) {
        this.certification_id = certification_id;
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
        IndustryCertification other = (IndustryCertification) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getIndustry_id() == null ? other.getIndustry_id() == null : this.getIndustry_id().equals(other.getIndustry_id()))
            && (this.getCertification_id() == null ? other.getCertification_id() == null : this.getCertification_id().equals(other.getCertification_id()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getIndustry_id() == null) ? 0 : getIndustry_id().hashCode());
        result = prime * result + ((getCertification_id() == null) ? 0 : getCertification_id().hashCode());
        return result;
    }
}