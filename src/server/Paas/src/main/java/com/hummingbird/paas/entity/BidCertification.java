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
    private Integer bid_id;

    /**
     * 资质id
     */
    private Integer certification_id;

    /**
     * 资质内容
     */
    private String certification_pic;

    /**
     * 资质名称
     */
    private String certification_name;

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
    public Integer getBid_id() {
        return bid_id;
    }

    /**
     * @param bidId 
	 *            投标id
     */
    public void setBid_id(Integer bid_id) {
        this.bid_id = bid_id;
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
     * @return 资质内容
     */
    public String getCertification_pic() {
        return certification_pic;
    }

    /**
     * @param certificationPic 
	 *            资质内容
     */
    public void setCertification_pic(String certification_pic) {
        this.certification_pic = certification_pic == null ? null : certification_pic.trim();
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
            && (this.getBid_id() == null ? other.getBid_id() == null : this.getBid_id().equals(other.getBid_id()))
            && (this.getCertification_id() == null ? other.getCertification_id() == null : this.getCertification_id().equals(other.getCertification_id()))
            && (this.getCertification_pic() == null ? other.getCertification_pic() == null : this.getCertification_pic().equals(other.getCertification_pic()))
            && (this.getCertification_name() == null ? other.getCertification_name() == null : this.getCertification_name().equals(other.getCertification_name()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getBid_id() == null) ? 0 : getBid_id().hashCode());
        result = prime * result + ((getCertification_id() == null) ? 0 : getCertification_id().hashCode());
        result = prime * result + ((getCertification_pic() == null) ? 0 : getCertification_pic().hashCode());
        result = prime * result + ((getCertification_name() == null) ? 0 : getCertification_name().hashCode());
        return result;
    }
}