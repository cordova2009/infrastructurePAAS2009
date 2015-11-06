package com.hummingbird.paas.entity;

/**
 * 投标资质表
 */
public class BidCertification {
    /**
     * 主键
     */
    private Integer id;

    /**
     * 投标id
     */
    private Integer bidId;

    /**
     * 资质id
     */
    private Integer certificationId;

    /**
     * 资质内容
     */
    private String certificationPic;

    /**
     * 资质名称
     */
    private String certificationName;

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
     * @return 投标id
     */
    public Integer getBidId() {
        return bidId;
    }

    /**
     * @param bidId 
	 *            投标id
     */
    public void setBidId(Integer bidId) {
        this.bidId = bidId;
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
     * @return 资质内容
     */
    public String getCertificationPic() {
        return certificationPic;
    }

    /**
     * @param certificationPic 
	 *            资质内容
     */
    public void setCertificationPic(String certificationPic) {
        this.certificationPic = certificationPic == null ? null : certificationPic.trim();
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
        BidCertification other = (BidCertification) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getBidId() == null ? other.getBidId() == null : this.getBidId().equals(other.getBidId()))
            && (this.getCertificationId() == null ? other.getCertificationId() == null : this.getCertificationId().equals(other.getCertificationId()))
            && (this.getCertificationPic() == null ? other.getCertificationPic() == null : this.getCertificationPic().equals(other.getCertificationPic()))
            && (this.getCertificationName() == null ? other.getCertificationName() == null : this.getCertificationName().equals(other.getCertificationName()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getBidId() == null) ? 0 : getBidId().hashCode());
        result = prime * result + ((getCertificationId() == null) ? 0 : getCertificationId().hashCode());
        result = prime * result + ((getCertificationPic() == null) ? 0 : getCertificationPic().hashCode());
        result = prime * result + ((getCertificationName() == null) ? 0 : getCertificationName().hashCode());
        return result;
    }
}