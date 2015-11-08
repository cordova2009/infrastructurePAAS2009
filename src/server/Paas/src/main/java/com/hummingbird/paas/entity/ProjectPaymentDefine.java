package com.hummingbird.paas.entity;

/**
 * 工程付款定义表
 */
public class ProjectPaymentDefine {
    /**
     * id
     */
    private Integer id;

    /**
     * 标的id
     */
    private String objectId;

    /**
     * 付款类型，ONE一次性，MON按月，PID按期，CUM自定义
     */
    private String payType;

    /**
     * 付款期数，一次性时为1，按月时为月数，按周期为首付+尾款+周期数，自定义为所有定义的记录数
     */
    private Integer payPeriod;

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
     * @return 标的id
     */
    public String getObjectId() {
        return objectId;
    }

    /**
     * @param objectId 
	 *            标的id
     */
    public void setObjectId(String objectId) {
        this.objectId = objectId == null ? null : objectId.trim();
    }

    /**
     * @return 付款类型，ONE一次性，MON按月，PID按期，CUM自定义
     */
    public String getPayType() {
        return payType;
    }

    /**
     * @param payType 
	 *            付款类型，ONE一次性，MON按月，PID按期，CUM自定义
     */
    public void setPayType(String payType) {
        this.payType = payType == null ? null : payType.trim();
    }

    /**
     * @return 付款期数，一次性时为1，按月时为月数，按周期为首付+尾款+周期数，自定义为所有定义的记录数
     */
    public Integer getPayPeriod() {
        return payPeriod;
    }

    /**
     * @param payPeriod 
	 *            付款期数，一次性时为1，按月时为月数，按周期为首付+尾款+周期数，自定义为所有定义的记录数
     */
    public void setPayPeriod(Integer payPeriod) {
        this.payPeriod = payPeriod;
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
        ProjectPaymentDefine other = (ProjectPaymentDefine) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getObjectId() == null ? other.getObjectId() == null : this.getObjectId().equals(other.getObjectId()))
            && (this.getPayType() == null ? other.getPayType() == null : this.getPayType().equals(other.getPayType()))
            && (this.getPayPeriod() == null ? other.getPayPeriod() == null : this.getPayPeriod().equals(other.getPayPeriod()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getObjectId() == null) ? 0 : getObjectId().hashCode());
        result = prime * result + ((getPayType() == null) ? 0 : getPayType().hashCode());
        result = prime * result + ((getPayPeriod() == null) ? 0 : getPayPeriod().hashCode());
        return result;
    }
}