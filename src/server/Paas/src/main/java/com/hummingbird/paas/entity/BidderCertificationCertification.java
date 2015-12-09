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
     * 投标人资质申请id
     */
    private Integer bidderApplyId;

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
     * 编号
     */
    private String certificationNo;

    /**
     * 工程类别
     */
    private String industryId;

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
     * @return 投标人资质申请id
     */
    public Integer getBidderApplyId() {
        return bidderApplyId;
    }

    /**
     * @param bidderApplyId 
	 *            投标人资质申请id
     */
    public void setBidderApplyId(Integer bidderApplyId) {
        this.bidderApplyId = bidderApplyId;
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

    /**
     * @return 编号
     */
    public String getCertificationNo() {
        return certificationNo;
    }

    /**
     * @param certificationNo 
	 *            编号
     */
    public void setCertificationNo(String certificationNo) {
        this.certificationNo = certificationNo == null ? null : certificationNo.trim();
    }

    /**
     * @return 工程类别
     */
    public String getIndustryId() {
        return industryId;
    }

    /**
     * @param industryId 
	 *            工程类别
     */
    public void setIndustryId(String industryId) {
        this.industryId = industryId == null ? null : industryId.trim();
    }
}