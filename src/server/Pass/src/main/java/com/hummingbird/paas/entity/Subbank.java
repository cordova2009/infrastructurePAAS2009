package com.hummingbird.paas.entity;

/**
 * 银行支行表
 */
public class Subbank {
    /**
     * 支行id
     */
    private String subbank_id;

    /**
     * 银行id
     */
    private String bank_id;

    /**
     * 支行名称
     */
    private String subbank_name;

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
    public String getSubbank_id() {
        return subbank_id;
    }

    /**
     * @param subbankId 
	 *            支行id
     */
    public void setSubbank_id(String subbank_id) {
        this.subbank_id = subbank_id == null ? null : subbank_id.trim();
    }

    /**
     * @return 银行id
     */
    public String getBank_id() {
        return bank_id;
    }

    /**
     * @param bankId 
	 *            银行id
     */
    public void setBank_id(String bank_id) {
        this.bank_id = bank_id == null ? null : bank_id.trim();
    }

    /**
     * @return 支行名称
     */
    public String getSubbank_name() {
        return subbank_name;
    }

    /**
     * @param subbankName 
	 *            支行名称
     */
    public void setSubbank_name(String subbank_name) {
        this.subbank_name = subbank_name == null ? null : subbank_name.trim();
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
        return (this.getSubbank_id() == null ? other.getSubbank_id() == null : this.getSubbank_id().equals(other.getSubbank_id()))
            && (this.getBank_id() == null ? other.getBank_id() == null : this.getBank_id().equals(other.getBank_id()))
            && (this.getSubbank_name() == null ? other.getSubbank_name() == null : this.getSubbank_name().equals(other.getSubbank_name()))
            && (this.getProvince() == null ? other.getProvince() == null : this.getProvince().equals(other.getProvince()))
            && (this.getCity() == null ? other.getCity() == null : this.getCity().equals(other.getCity()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getSubbank_id() == null) ? 0 : getSubbank_id().hashCode());
        result = prime * result + ((getBank_id() == null) ? 0 : getBank_id().hashCode());
        result = prime * result + ((getSubbank_name() == null) ? 0 : getSubbank_name().hashCode());
        result = prime * result + ((getProvince() == null) ? 0 : getProvince().hashCode());
        result = prime * result + ((getCity() == null) ? 0 : getCity().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        return result;
    }
}