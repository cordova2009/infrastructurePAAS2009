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
    private String object_id;

    /**
     * 资质id
     */
    private Integer certification_id;

    /**
     * 资质名称
     */
    private String certification_name;

    /**
     * 资质数量
     */
    private Integer certification_count;

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
    public String getObject_id() {
        return object_id;
    }

    /**
     * @param objectId 
	 *            标的id
     */
    public void setObject_id(String object_id) {
        this.object_id = object_id == null ? null : object_id.trim();
    }

    /**
     * @return 资质id
     */
    public Integer getCertification_id() {
        return certification_id;
    }

    /**
     * @param certificationId 
	 *            资质id
     */
    public void setCertification_id(Integer certification_id) {
        this.certification_id = certification_id;
    }

    /**
     * @return 资质名称
     */
    public String getCertification_name() {
        return certification_name;
    }

    /**
     * @param certificationName 
	 *            资质名称
     */
    public void setCertification_name(String certification_name) {
        this.certification_name = certification_name == null ? null : certification_name.trim();
    }

    /**
     * @return 资质数量
     */
    public Integer getCertification_count() {
        return certification_count;
    }

    /**
     * @param certificationCount 
	 *            资质数量
     */
    public void setCertification_count(Integer certification_count) {
        this.certification_count = certification_count;
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
            && (this.getObject_id() == null ? other.getObject_id() == null : this.getObject_id().equals(other.getObject_id()))
            && (this.getCertification_id() == null ? other.getCertification_id() == null : this.getCertification_id().equals(other.getCertification_id()))
            && (this.getCertification_name() == null ? other.getCertification_name() == null : this.getCertification_name().equals(other.getCertification_name()))
            && (this.getCertification_count() == null ? other.getCertification_count() == null : this.getCertification_count().equals(other.getCertification_count()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getObject_id() == null) ? 0 : getObject_id().hashCode());
        result = prime * result + ((getCertification_id() == null) ? 0 : getCertification_id().hashCode());
        result = prime * result + ((getCertification_name() == null) ? 0 : getCertification_name().hashCode());
        result = prime * result + ((getCertification_count() == null) ? 0 : getCertification_count().hashCode());
        return result;
    }
}