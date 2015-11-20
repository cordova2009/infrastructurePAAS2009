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
    private String certificationGroupname;

    /**
     * 资质证书级别，分0,1，2,3，0为特级
     */
    private Integer certificationLevel;

    /**
     * 资质证书名称
     */
    private String certificationName;

    /**
     * 可否认证,CAN 必须认证，NON不要认证，NKN不知道要不要认证
     */
    private String canVerify;

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
    public String getCertificationGroupname() {
        return certificationGroupname;
    }

    /**
     * @param certificationGroupname 
	 *            资质证书组别,一级证书，二级证书等标识归在一组
     */
    public void setCertificationGroupname(String certificationGroupname) {
        this.certificationGroupname = certificationGroupname == null ? null : certificationGroupname.trim();
    }

    /**
     * @return 资质证书级别，分0,1，2,3，0为特级
     */
    public Integer getCertificationLevel() {
        return certificationLevel;
    }

    /**
     * @param certificationLevel 
	 *            资质证书级别，分0,1，2,3，0为特级
     */
    public void setCertificationLevel(Integer certificationLevel) {
        this.certificationLevel = certificationLevel;
    }

    /**
     * @return 资质证书名称
     */
    public String getCertificationName() {
        return certificationName;
    }

    /**
     * @param certificationName 
	 *            资质证书名称
     */
    public void setCertificationName(String certificationName) {
        this.certificationName = certificationName == null ? null : certificationName.trim();
    }

    /**
     * @return 可否认证,CAN 必须认证，NON不要认证，NKN不知道要不要认证
     */
    public String getCanVerify() {
        return canVerify;
    }

    /**
     * @param canVerify 
	 *            可否认证,CAN 必须认证，NON不要认证，NKN不知道要不要认证
     */
    public void setCanVerify(String canVerify) {
        this.canVerify = canVerify == null ? null : canVerify.trim();
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
            && (this.getCertificationGroupname() == null ? other.getCertificationGroupname() == null : this.getCertificationGroupname().equals(other.getCertificationGroupname()))
            && (this.getCertificationLevel() == null ? other.getCertificationLevel() == null : this.getCertificationLevel().equals(other.getCertificationLevel()))
            && (this.getCertificationName() == null ? other.getCertificationName() == null : this.getCertificationName().equals(other.getCertificationName()))
            && (this.getCanVerify() == null ? other.getCanVerify() == null : this.getCanVerify().equals(other.getCanVerify()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getCertificationGroupname() == null) ? 0 : getCertificationGroupname().hashCode());
        result = prime * result + ((getCertificationLevel() == null) ? 0 : getCertificationLevel().hashCode());
        result = prime * result + ((getCertificationName() == null) ? 0 : getCertificationName().hashCode());
        result = prime * result + ((getCanVerify() == null) ? 0 : getCanVerify().hashCode());
        return result;
    }

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "CertificationType [id=" + id + ", certificationGroupname=" + certificationGroupname
				+ ", certificationLevel=" + certificationLevel + ", certificationName=" + certificationName + "]";
	}
}