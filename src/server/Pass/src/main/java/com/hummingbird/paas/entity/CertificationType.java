package com.hummingbird.paas.entity;

/**
 * 资质证书分类表
 */
public class CertificationType {
    /**
     * 资质证书id
     */
    private Integer id;

    /**
     * 资质证书组别,一级证书，二级证书等标识归在一组
     */
    private String certification_groupname;

    /**
     * 资质证书级别，分0,1，2,3，0为特级
     */
    private Integer certification_level;

    /**
     * 资质证书名称
     */
    private String certification_name;

    /**
     * 可否认证,CAN 必须认证，NON不要认证，NKN不知道要不要认证
     */
    private String can_verify;

    /**
     * @return 资质证书id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id 
	 *            资质证书id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return 资质证书组别,一级证书，二级证书等标识归在一组
     */
    public String getCertification_groupname() {
        return certification_groupname;
    }

    /**
     * @param certificationGroupname 
	 *            资质证书组别,一级证书，二级证书等标识归在一组
     */
    public void setCertification_groupname(String certification_groupname) {
        this.certification_groupname = certification_groupname == null ? null : certification_groupname.trim();
    }

    /**
     * @return 资质证书级别，分0,1，2,3，0为特级
     */
    public Integer getCertification_level() {
        return certification_level;
    }

    /**
     * @param certificationLevel 
	 *            资质证书级别，分0,1，2,3，0为特级
     */
    public void setCertification_level(Integer certification_level) {
        this.certification_level = certification_level;
    }

    /**
     * @return 资质证书名称
     */
    public String getCertification_name() {
        return certification_name;
    }

    /**
     * @param certificationName 
	 *            资质证书名称
     */
    public void setCertification_name(String certification_name) {
        this.certification_name = certification_name == null ? null : certification_name.trim();
    }

    /**
     * @return 可否认证,CAN 必须认证，NON不要认证，NKN不知道要不要认证
     */
    public String getCan_verify() {
        return can_verify;
    }

    /**
     * @param canVerify 
	 *            可否认证,CAN 必须认证，NON不要认证，NKN不知道要不要认证
     */
    public void setCan_verify(String can_verify) {
        this.can_verify = can_verify == null ? null : can_verify.trim();
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
        CertificationType other = (CertificationType) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getCertification_groupname() == null ? other.getCertification_groupname() == null : this.getCertification_groupname().equals(other.getCertification_groupname()))
            && (this.getCertification_level() == null ? other.getCertification_level() == null : this.getCertification_level().equals(other.getCertification_level()))
            && (this.getCertification_name() == null ? other.getCertification_name() == null : this.getCertification_name().equals(other.getCertification_name()))
            && (this.getCan_verify() == null ? other.getCan_verify() == null : this.getCan_verify().equals(other.getCan_verify()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getCertification_groupname() == null) ? 0 : getCertification_groupname().hashCode());
        result = prime * result + ((getCertification_level() == null) ? 0 : getCertification_level().hashCode());
        result = prime * result + ((getCertification_name() == null) ? 0 : getCertification_name().hashCode());
        result = prime * result + ((getCan_verify() == null) ? 0 : getCan_verify().hashCode());
        return result;
    }
}