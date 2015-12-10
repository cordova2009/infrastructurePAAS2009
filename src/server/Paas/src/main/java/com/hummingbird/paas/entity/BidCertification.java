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
     * 投标资质要求id
     */
    private Integer objReqId;

    /**
     * 投标id
     */
    private Integer bidId;

    /**
     * 资质证书id
     */
    private Integer bidderCertificationId;

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
     * @return 投标资质要求id
     */
    public Integer getObjReqId() {
        return objReqId;
    }

    /**
     * @param objReqId 
	 *            投标资质要求id
     */
    public void setObjReqId(Integer objReqId) {
        this.objReqId = objReqId;
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
     * @return 资质证书id
     */
    public Integer getBidderCertificationId() {
        return bidderCertificationId;
    }

    /**
     * @param bidderCertificationId 
	 *            资质证书id
     */
    public void setBidderCertificationId(Integer bidderCertificationId) {
        this.bidderCertificationId = bidderCertificationId;
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
}