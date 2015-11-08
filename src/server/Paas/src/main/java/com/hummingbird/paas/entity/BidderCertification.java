package com.hummingbird.paas.entity;

import java.util.Date;

/**
 * 承包商资质证书表
 */
public class BidderCertification {
    /**
     * 主键
     */
    private Integer id;

    /**
     * 承包商id
     */
    private Integer bidderId;

    /**
     * 资质类别
     */
    private Integer certificationId;

    /**
     * 资质名称
     */
    private String certificationName;

    /**
     * 资质内容
     */
    private String certificationContent;

    /**
     * 有效期
     */
    private Date expireTime;

    /**
     * 适用区域
     */
    private String applicableRegion;

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
     * @return 承包商id
     */
    public Integer getBidderId() {
        return bidderId;
    }

    /**
     * @param bidderId 
	 *            承包商id
     */
    public void setBidderId(Integer bidderId) {
        this.bidderId = bidderId;
    }

    /**
     * @return 资质类别
     */
    public Integer getCertificationId() {
        return certificationId;
    }

    /**
     * @param certificationId 
	 *            资质类别
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
     * @return 资质内容
     */
    public String getCertificationContent() {
        return certificationContent;
    }

    /**
     * @param certificationContent 
	 *            资质内容
     */
    public void setCertificationContent(String certificationContent) {
        this.certificationContent = certificationContent == null ? null : certificationContent.trim();
    }

    /**
     * @return 有效期
     */
    public Date getExpireTime() {
        return expireTime;
    }

    /**
     * @param expireTime 
	 *            有效期
     */
    public void setExpireTime(Date expireTime) {
        this.expireTime = expireTime;
    }

    /**
     * @return 适用区域
     */
    public String getApplicableRegion() {
        return applicableRegion;
    }

    /**
     * @param applicableRegion 
	 *            适用区域
     */
    public void setApplicableRegion(String applicableRegion) {
        this.applicableRegion = applicableRegion == null ? null : applicableRegion.trim();
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
        BidderCertification other = (BidderCertification) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getBidderId() == null ? other.getBidderId() == null : this.getBidderId().equals(other.getBidderId()))
            && (this.getCertificationId() == null ? other.getCertificationId() == null : this.getCertificationId().equals(other.getCertificationId()))
            && (this.getCertificationName() == null ? other.getCertificationName() == null : this.getCertificationName().equals(other.getCertificationName()))
            && (this.getCertificationContent() == null ? other.getCertificationContent() == null : this.getCertificationContent().equals(other.getCertificationContent()))
            && (this.getExpireTime() == null ? other.getExpireTime() == null : this.getExpireTime().equals(other.getExpireTime()))
            && (this.getApplicableRegion() == null ? other.getApplicableRegion() == null : this.getApplicableRegion().equals(other.getApplicableRegion()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getBidderId() == null) ? 0 : getBidderId().hashCode());
        result = prime * result + ((getCertificationId() == null) ? 0 : getCertificationId().hashCode());
        result = prime * result + ((getCertificationName() == null) ? 0 : getCertificationName().hashCode());
        result = prime * result + ((getCertificationContent() == null) ? 0 : getCertificationContent().hashCode());
        result = prime * result + ((getExpireTime() == null) ? 0 : getExpireTime().hashCode());
        result = prime * result + ((getApplicableRegion() == null) ? 0 : getApplicableRegion().hashCode());
        return result;
    }
}