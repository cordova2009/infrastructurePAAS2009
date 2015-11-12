package com.hummingbird.paas.entity;

/**
 * 手续费费率表
 */
public class FeeRate {
    /**
     * id
     */
    private Integer id;

    /**
     * 费率,万分比
     */
    private Integer feeRate;

    /**
     * 最小金额，单位分，在此等级的金额应该大于等于此值
     */
    private Integer minAmount;

    /**
     * 最大金额，单位分，在此等级的金额应该小于等于此值
     */
    private Integer maxAmount;

    /**
     * 封顶手续费,当金额大于某个值时，会有封顶的手续费，这里设置费率为0，封顶手续费字段有值，如果有费率的情况下，这个封顶手续费应该为0，单位分
     */
    private Integer maxFee;

    /**
     * 类型,BZJ 撮合保证金,TX# 提现手续费
     */
    private String type;

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
     * @return 费率,万分比
     */
    public Integer getFeeRate() {
        return feeRate;
    }

    /**
     * @param feeRate 
	 *            费率,万分比
     */
    public void setFeeRate(Integer feeRate) {
        this.feeRate = feeRate;
    }

    /**
     * @return 最小金额，单位分，在此等级的金额应该大于等于此值
     */
    public Integer getMinAmount() {
        return minAmount;
    }

    /**
     * @param minAmount 
	 *            最小金额，单位分，在此等级的金额应该大于等于此值
     */
    public void setMinAmount(Integer minAmount) {
        this.minAmount = minAmount;
    }

    /**
     * @return 最大金额，单位分，在此等级的金额应该小于等于此值
     */
    public Integer getMaxAmount() {
        return maxAmount;
    }

    /**
     * @param maxAmount 
	 *            最大金额，单位分，在此等级的金额应该小于等于此值
     */
    public void setMaxAmount(Integer maxAmount) {
        this.maxAmount = maxAmount;
    }

    /**
     * @return 封顶手续费,当金额大于某个值时，会有封顶的手续费，这里设置费率为0，封顶手续费字段有值，如果有费率的情况下，这个封顶手续费应该为0，单位分
     */
    public Integer getMaxFee() {
        return maxFee;
    }

    /**
     * @param maxFee 
	 *            封顶手续费,当金额大于某个值时，会有封顶的手续费，这里设置费率为0，封顶手续费字段有值，如果有费率的情况下，这个封顶手续费应该为0，单位分
     */
    public void setMaxFee(Integer maxFee) {
        this.maxFee = maxFee;
    }

    /**
     * @return 类型,BZJ 撮合保证金,TX# 提现手续费
     */
    public String getType() {
        return type;
    }

    /**
     * @param type 
	 *            类型,BZJ 撮合保证金,TX# 提现手续费
     */
    public void setType(String type) {
        this.type = type == null ? null : type.trim();
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
        FeeRate other = (FeeRate) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getFeeRate() == null ? other.getFeeRate() == null : this.getFeeRate().equals(other.getFeeRate()))
            && (this.getMinAmount() == null ? other.getMinAmount() == null : this.getMinAmount().equals(other.getMinAmount()))
            && (this.getMaxAmount() == null ? other.getMaxAmount() == null : this.getMaxAmount().equals(other.getMaxAmount()))
            && (this.getMaxFee() == null ? other.getMaxFee() == null : this.getMaxFee().equals(other.getMaxFee()))
            && (this.getType() == null ? other.getType() == null : this.getType().equals(other.getType()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getFeeRate() == null) ? 0 : getFeeRate().hashCode());
        result = prime * result + ((getMinAmount() == null) ? 0 : getMinAmount().hashCode());
        result = prime * result + ((getMaxAmount() == null) ? 0 : getMaxAmount().hashCode());
        result = prime * result + ((getMaxFee() == null) ? 0 : getMaxFee().hashCode());
        result = prime * result + ((getType() == null) ? 0 : getType().hashCode());
        return result;
    }
}