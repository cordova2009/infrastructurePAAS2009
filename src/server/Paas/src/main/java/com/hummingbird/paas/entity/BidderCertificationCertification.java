package com.hummingbird.paas.entity;

import java.util.Date;

/**
 * 承包商资质证书认证申请表
 */
public class BidderCertificationCertification {
    /**
     * 主键
     */
    private Integer id;

    /**
     * 承包商
     */
    private Integer bidder_id;

    /**
     * 资质类别
     */
    private Integer certification_id;

    /**
     * 资质名称
     */
    private String certification_name;

    /**
     * 资质内容
     */
    private String certification_content;

    /**
     * 有效期
     */
    private Date expire_time;

    /**
     * 适用区域
     */
    private String applicable_region;

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
     * @return 承包商
     */
    public Integer getBidder_id() {
        return bidder_id;
    }

    /**
     * @param bidderId 
	 *            承包商
     */
    public void setBidder_id(Integer bidder_id) {
        this.bidder_id = bidder_id;
    }

    /**
     * @return 资质类别
     */
    public Integer getCertification_id() {
        return certification_id;
    }

    /**
     * @param certificationId 
	 *            资质类别
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
     * @return 资质内容
     */
    public String getCertification_content() {
        return certification_content;
    }

    /**
     * @param certificationContent 
	 *            资质内容
     */
    public void setCertification_content(String certification_content) {
        this.certification_content = certification_content == null ? null : certification_content.trim();
    }

    /**
     * @return 有效期
     */
    public Date getExpire_time() {
        return expire_time;
    }

    /**
     * @param expireTime 
	 *            有效期
     */
    public void setExpire_time(Date expire_time) {
        this.expire_time = expire_time;
    }

    /**
     * @return 适用区域
     */
    public String getApplicable_region() {
        return applicable_region;
    }

    /**
     * @param applicableRegion 
	 *            适用区域
     */
    public void setApplicable_region(String applicable_region) {
        this.applicable_region = applicable_region == null ? null : applicable_region.trim();
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
        BidderCertificationCertification other = (BidderCertificationCertification) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getBidder_id() == null ? other.getBidder_id() == null : this.getBidder_id().equals(other.getBidder_id()))
            && (this.getCertification_id() == null ? other.getCertification_id() == null : this.getCertification_id().equals(other.getCertification_id()))
            && (this.getCertification_name() == null ? other.getCertification_name() == null : this.getCertification_name().equals(other.getCertification_name()))
            && (this.getCertification_content() == null ? other.getCertification_content() == null : this.getCertification_content().equals(other.getCertification_content()))
            && (this.getExpire_time() == null ? other.getExpire_time() == null : this.getExpire_time().equals(other.getExpire_time()))
            && (this.getApplicable_region() == null ? other.getApplicable_region() == null : this.getApplicable_region().equals(other.getApplicable_region()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getBidder_id() == null) ? 0 : getBidder_id().hashCode());
        result = prime * result + ((getCertification_id() == null) ? 0 : getCertification_id().hashCode());
        result = prime * result + ((getCertification_name() == null) ? 0 : getCertification_name().hashCode());
        result = prime * result + ((getCertification_content() == null) ? 0 : getCertification_content().hashCode());
        result = prime * result + ((getExpire_time() == null) ? 0 : getExpire_time().hashCode());
        result = prime * result + ((getApplicable_region() == null) ? 0 : getApplicable_region().hashCode());
        return result;
    }
}