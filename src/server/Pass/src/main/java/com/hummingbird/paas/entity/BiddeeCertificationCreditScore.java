package com.hummingbird.paas.entity;

/**
 * 发包方资质信息积分明细表
 */
public class BiddeeCertificationCreditScore {
    /**
     * 发包方id
     */
    private Integer tenderer_id;

    /**
     * 资质类别id
     */
    private Integer certification_id;

    /**
     * 积分
     */
    private Integer score;

    /**
     * 资质名称
     */
    private String certification_name;

    /**
     * 资质id
     */
    private String certificate_record_id;

    /**
     * @return 发包方id
     */
    public Integer getTenderer_id() {
        return tenderer_id;
    }

    /**
     * @param tendererId 
	 *            发包方id
     */
    public void setTenderer_id(Integer tenderer_id) {
        this.tenderer_id = tenderer_id;
    }

    /**
     * @return 资质类别id
     */
    public Integer getCertification_id() {
        return certification_id;
    }

    /**
     * @param certificationId 
	 *            资质类别id
     */
    public void setCertification_id(Integer certification_id) {
        this.certification_id = certification_id;
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
     * @return 资质id
     */
    public String getCertificate_record_id() {
        return certificate_record_id;
    }

    /**
     * @param certificateRecordId 
	 *            资质id
     */
    public void setCertificate_record_id(String certificate_record_id) {
        this.certificate_record_id = certificate_record_id == null ? null : certificate_record_id.trim();
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
        return (this.getTenderer_id() == null ? other.getTenderer_id() == null : this.getTenderer_id().equals(other.getTenderer_id()))
            && (this.getCertification_id() == null ? other.getCertification_id() == null : this.getCertification_id().equals(other.getCertification_id()))
            && (this.getScore() == null ? other.getScore() == null : this.getScore().equals(other.getScore()))
            && (this.getCertification_name() == null ? other.getCertification_name() == null : this.getCertification_name().equals(other.getCertification_name()))
            && (this.getCertificate_record_id() == null ? other.getCertificate_record_id() == null : this.getCertificate_record_id().equals(other.getCertificate_record_id()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getTenderer_id() == null) ? 0 : getTenderer_id().hashCode());
        result = prime * result + ((getCertification_id() == null) ? 0 : getCertification_id().hashCode());
        result = prime * result + ((getScore() == null) ? 0 : getScore().hashCode());
        result = prime * result + ((getCertification_name() == null) ? 0 : getCertification_name().hashCode());
        result = prime * result + ((getCertificate_record_id() == null) ? 0 : getCertificate_record_id().hashCode());
        return result;
    }
}