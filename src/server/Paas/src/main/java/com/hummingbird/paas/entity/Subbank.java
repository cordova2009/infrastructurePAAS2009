package com.hummingbird.paas.entity;

/**
 * 银行支行表
 */
public class Subbank {
    /**
     * 支行id
     */
    private String subbankId;

    /**
     * 银行id
     */
    private String bankId;

    /**
     * 支行名称
     */
    private String subbankName;

    /**
     * 省份,由区域表id表示
     */
    private String province;

    /**
     * 城市,由区域表id表表
     */
    private String city;

    /**
     * 状态,OK# 正常,FLS 不使用
     */
    private String status;

    /**
     * @return 支行id
     */
    public String getSubbankId() {
        return subbankId;
    }

    /**
     * @param subbankId 
	 *            支行id
     */
    public void setSubbankId(String subbankId) {
        this.subbankId = subbankId == null ? null : subbankId.trim();
    }

    /**
     * @return 银行id
     */
    public String getBankId() {
        return bankId;
    }

    /**
     * @param bankId 
	 *            银行id
     */
    public void setBankId(String bankId) {
        this.bankId = bankId == null ? null : bankId.trim();
    }

    /**
     * @return 支行名称
     */
    public String getSubbankName() {
        return subbankName;
    }

    /**
     * @param subbankName 
	 *            支行名称
     */
    public void setSubbankName(String subbankName) {
        this.subbankName = subbankName == null ? null : subbankName.trim();
    }

    /**
     * @return 省份,由区域表id表示
     */
    public String getProvince() {
        return province;
    }

    /**
     * @param province 
	 *            省份,由区域表id表示
     */
    public void setProvince(String province) {
        this.province = province == null ? null : province.trim();
    }

    /**
     * @return 城市,由区域表id表表
     */
    public String getCity() {
        return city;
    }

    /**
     * @param city 
	 *            城市,由区域表id表表
     */
    public void setCity(String city) {
        this.city = city == null ? null : city.trim();
    }

    /**
     * @return 状态,OK# 正常,FLS 不使用
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status 
	 *            状态,OK# 正常,FLS 不使用
     */
    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
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
        Subbank other = (Subbank) that;
        return (this.getSubbankId() == null ? other.getSubbankId() == null : this.getSubbankId().equals(other.getSubbankId()))
            && (this.getBankId() == null ? other.getBankId() == null : this.getBankId().equals(other.getBankId()))
            && (this.getSubbankName() == null ? other.getSubbankName() == null : this.getSubbankName().equals(other.getSubbankName()))
            && (this.getProvince() == null ? other.getProvince() == null : this.getProvince().equals(other.getProvince()))
            && (this.getCity() == null ? other.getCity() == null : this.getCity().equals(other.getCity()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getSubbankId() == null) ? 0 : getSubbankId().hashCode());
        result = prime * result + ((getBankId() == null) ? 0 : getBankId().hashCode());
        result = prime * result + ((getSubbankName() == null) ? 0 : getSubbankName().hashCode());
        result = prime * result + ((getProvince() == null) ? 0 : getProvince().hashCode());
        result = prime * result + ((getCity() == null) ? 0 : getCity().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        return result;
    }
}