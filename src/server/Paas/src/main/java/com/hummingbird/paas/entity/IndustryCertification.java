package com.hummingbird.paas.entity;

/**
 * 行业资质证书表,记录某个行业需要什么证书
 */
public class IndustryCertification {
    /**
     * id
     */
    private Integer id;

    /**
     * 行业id
     */
    private String industryId;

    /**
     * 资质证书id
     */
    private Integer certificationId;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id 
	 *            id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return 行业id
     */
    public String getIndustryId() {
        return industryId;
    }

    /**
     * @param industryId 
	 *            行业id
     */
    public void setIndustryId(String industryId) {
        this.industryId = industryId == null ? null : industryId.trim();
    }

    /**
     * @return 资质证书id
     */
    public Integer getCertificationId() {
        return certificationId;
    }

    /**
     * @param certificationId 
	 *            资质证书id
     */
    public void setCertificationId(Integer certificationId) {
        this.certificationId = certificationId;
    }
}