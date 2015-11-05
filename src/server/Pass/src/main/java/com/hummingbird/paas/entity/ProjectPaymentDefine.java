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
    private String object_id;

    /**
     * 付款类型，ONE一次性，MON按月，PID按期，CUM自定义
     */
    private String pay_type;

    /**
     * 付款期数，一次性时为1，按月时为月数，按周期为首付+尾款+周期数，自定义为所有定义的记录数
     */
    private Integer pay_period;

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
    public String getObject_id() {
        return object_id;
    }

    /**
     * @param objectId 
	 *            标的id
     */
    public void setObject_id(String object_id) {
        this.object_id = object_id == null ? null : object_id.trim();
    }

    /**
     * @return 付款类型，ONE一次性，MON按月，PID按期，CUM自定义
     */
    public String getPay_type() {
        return pay_type;
    }

    /**
     * @param payType 
	 *            付款类型，ONE一次性，MON按月，PID按期，CUM自定义
     */
    public void setPay_type(String pay_type) {
        this.pay_type = pay_type == null ? null : pay_type.trim();
    }

    /**
     * @return 付款期数，一次性时为1，按月时为月数，按周期为首付+尾款+周期数，自定义为所有定义的记录数
     */
    public Integer getPay_period() {
        return pay_period;
    }

    /**
     * @param payPeriod 
	 *            付款期数，一次性时为1，按月时为月数，按周期为首付+尾款+周期数，自定义为所有定义的记录数
     */
    public void setPay_period(Integer pay_period) {
        this.pay_period = pay_period;
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
            && (this.getObject_id() == null ? other.getObject_id() == null : this.getObject_id().equals(other.getObject_id()))
            && (this.getPay_type() == null ? other.getPay_type() == null : this.getPay_type().equals(other.getPay_type()))
            && (this.getPay_period() == null ? other.getPay_period() == null : this.getPay_period().equals(other.getPay_period()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getObject_id() == null) ? 0 : getObject_id().hashCode());
        result = prime * result + ((getPay_type() == null) ? 0 : getPay_type().hashCode());
        result = prime * result + ((getPay_period() == null) ? 0 : getPay_period().hashCode());
        return result;
    }
}