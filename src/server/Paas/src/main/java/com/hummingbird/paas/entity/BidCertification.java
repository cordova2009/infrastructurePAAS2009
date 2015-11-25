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
     * 招标资质要求id
     */
    private Integer objReqId;

    /**
     * 投标资质证书id
     */
    private String bidderCertificationId;

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
            && (this.getObjReqId() == null ? other.getObjReqId() == null : this.getObjReqId().equals(other.getObjReqId()))
            && (this.getBidderCertificationId() == null ? other.getBidderCertificationId() == null : this.getBidderCertificationId().equals(other.getBidderCertificationId()))
            && (this.getCertificationName() == null ? other.getCertificationName() == null : this.getCertificationName().equals(other.getCertificationName()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getBidId() == null) ? 0 : getBidId().hashCode());
        result = prime * result + ((getObjReqId() == null) ? 0 : getObjReqId().hashCode());
        result = prime * result + ((getBidderCertificationId() == null) ? 0 : getBidderCertificationId().hashCode());
        result = prime * result + ((getCertificationName() == null) ? 0 : getCertificationName().hashCode());
        return result;
    }

	/**
	 * 招标资质要求id 
	 */
	public Integer getObjReqId() {
		return objReqId;
	}

	/**
	 * 招标资质要求id 
	 */
	public void setObjReqId(Integer objReqId) {
		this.objReqId = objReqId;
	}

	/**
	 * 投标资质证书id 
	 */
	public String getBidderCertificationId() {
		return bidderCertificationId;
	}

	/**
	 * 投标资质证书id 
	 */
	public void setBidderCertificationId(String bidderCertificationId) {
		this.bidderCertificationId = bidderCertificationId;
	}
}