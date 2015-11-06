package com.hummingbird.paas.entity;

/**
 * 发包方资质信息积分明细表
 */
public class BiddeeCertificationCreditScore {
    /**
     * 发包方id
     */
    private Integer tendererId;

    /**
     * 资质类别id
     */
    private Integer certificationId;

    /**
     * 积分
     */
    private Integer score;

    /**
     * 资质名称
     */
    private String certificationName;

    /**
     * 资质id
     */
    private String certificateRecordId;

    /**
     * @return 发包方id
     */
    public Integer getTendererId() {
        return tendererId;
    }

    /**
     * @param tendererId 
	 *            发包方id
     */
    public void setTendererId(Integer tendererId) {
        this.tendererId = tendererId;
    }

    /**
     * @return 资质类别id
     */
    public Integer getCertificationId() {
        return certificationId;
    }

    /**
     * @param certificationId 
	 *            资质类别id
     */
    public void setCertificationId(Integer certificationId) {
        this.certificationId = certificationId;
    }

    /**
     * @return 积分
     */
    public Integer getScore() {
        return score;
    }

    /**
     * @param score 
	 *            积分
     */
    public void setScore(Integer score) {
        this.score = score;
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
     * @return 资质id
     */
    public String getCertificateRecordId() {
        return certificateRecordId;
    }

    /**
     * @param certificateRecordId 
	 *            资质id
     */
    public void setCertificateRecordId(String certificateRecordId) {
        this.certificateRecordId = certificateRecordId == null ? null : certificateRecordId.trim();
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
        BiddeeCertificationCreditScore other = (BiddeeCertificationCreditScore) that;
        return (this.getTendererId() == null ? other.getTendererId() == null : this.getTendererId().equals(other.getTendererId()))
            && (this.getCertificationId() == null ? other.getCertificationId() == null : this.getCertificationId().equals(other.getCertificationId()))
            && (this.getScore() == null ? other.getScore() == null : this.getScore().equals(other.getScore()))
            && (this.getCertificationName() == null ? other.getCertificationName() == null : this.getCertificationName().equals(other.getCertificationName()))
            && (this.getCertificateRecordId() == null ? other.getCertificateRecordId() == null : this.getCertificateRecordId().equals(other.getCertificateRecordId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getTendererId() == null) ? 0 : getTendererId().hashCode());
        result = prime * result + ((getCertificationId() == null) ? 0 : getCertificationId().hashCode());
        result = prime * result + ((getScore() == null) ? 0 : getScore().hashCode());
        result = prime * result + ((getCertificationName() == null) ? 0 : getCertificationName().hashCode());
        result = prime * result + ((getCertificateRecordId() == null) ? 0 : getCertificateRecordId().hashCode());
        return result;
    }
}