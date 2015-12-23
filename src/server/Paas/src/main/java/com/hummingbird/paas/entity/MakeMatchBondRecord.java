package com.hummingbird.paas.entity;

import java.util.Date;

/**
 * 标的撮合保证金缴还表
 */
public class MakeMatchBondRecord {
    /**
     * 订单id,BZ00时间戳+随机数组成
     */
    private String orderId;

    /**
     * 标的id
     */
    private String objectId;

    /**
     * 投标id,
     */
    private Integer bidId;

    /**
     * 金额，单位为分
     */
    private Long bondAmount;

    /**
     * 状态，FOZ冻结（帐户内的钱），PAY缴（保证金，中标后），REV收保证金
     */
    private String status;

    /**
     * 新增时间
     */
    private Date insertTime;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 创建人
     */
    private String creator;

    /**
     * 更新人
     */
    private String updator;

    /**
     * 资金订单id
     */
    private String capitalOrderId;

    /**
     * @return 订单id,BZ00时间戳+随机数组成
     */
    public String getOrderId() {
        return orderId;
    }

    /**
     * @param orderId 
	 *            订单id,BZ00时间戳+随机数组成
     */
    public void setOrderId(String orderId) {
        this.orderId = orderId == null ? null : orderId.trim();
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
     * @return 投标id,
     */
    public Integer getBidId() {
        return bidId;
    }

    /**
     * @param bidId 
	 *            投标id,
     */
    public void setBidId(Integer bidId) {
        this.bidId = bidId;
    }

    /**
     * @return 金额，单位为分
     */
    public Long getBondAmount() {
        return bondAmount;
    }

    /**
     * @param bondAmount 
	 *            金额，单位为分
     */
    public void setBondAmount(Long bondAmount) {
        this.bondAmount = bondAmount;
    }

    /**
     * @return 状态，FOZ冻结（帐户内的钱），PAY缴（保证金，中标后），REV收保证金
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status 
	 *            状态，FOZ冻结（帐户内的钱），PAY缴（保证金，中标后），REV收保证金
     */
    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    /**
     * @return 新增时间
     */
    public Date getInsertTime() {
        return insertTime;
    }

    /**
     * @param insertTime 
	 *            新增时间
     */
    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }

    /**
     * @return 更新时间
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * @param updateTime 
	 *            更新时间
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * @return 创建人
     */
    public String getCreator() {
        return creator;
    }

    /**
     * @param creator 
	 *            创建人
     */
    public void setCreator(String creator) {
        this.creator = creator == null ? null : creator.trim();
    }

    /**
     * @return 更新人
     */
    public String getUpdator() {
        return updator;
    }

    /**
     * @param updator 
	 *            更新人
     */
    public void setUpdator(String updator) {
        this.updator = updator == null ? null : updator.trim();
    }

    /**
     * @return 资金订单id
     */
    public String getCapitalOrderId() {
        return capitalOrderId;
    }

    /**
     * @param capitalOrderId 
	 *            资金订单id
     */
    public void setCapitalOrderId(String capitalOrderId) {
        this.capitalOrderId = capitalOrderId == null ? null : capitalOrderId.trim();
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
        MakeMatchBondRecord other = (MakeMatchBondRecord) that;
        return (this.getOrderId() == null ? other.getOrderId() == null : this.getOrderId().equals(other.getOrderId()))
            && (this.getObjectId() == null ? other.getObjectId() == null : this.getObjectId().equals(other.getObjectId()))
            && (this.getBidId() == null ? other.getBidId() == null : this.getBidId().equals(other.getBidId()))
            && (this.getBondAmount() == null ? other.getBondAmount() == null : this.getBondAmount().equals(other.getBondAmount()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getInsertTime() == null ? other.getInsertTime() == null : this.getInsertTime().equals(other.getInsertTime()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()))
            && (this.getCreator() == null ? other.getCreator() == null : this.getCreator().equals(other.getCreator()))
            && (this.getUpdator() == null ? other.getUpdator() == null : this.getUpdator().equals(other.getUpdator()))
            && (this.getCapitalOrderId() == null ? other.getCapitalOrderId() == null : this.getCapitalOrderId().equals(other.getCapitalOrderId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getOrderId() == null) ? 0 : getOrderId().hashCode());
        result = prime * result + ((getObjectId() == null) ? 0 : getObjectId().hashCode());
        result = prime * result + ((getBidId() == null) ? 0 : getBidId().hashCode());
        result = prime * result + ((getBondAmount() == null) ? 0 : getBondAmount().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getInsertTime() == null) ? 0 : getInsertTime().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        result = prime * result + ((getCreator() == null) ? 0 : getCreator().hashCode());
        result = prime * result + ((getUpdator() == null) ? 0 : getUpdator().hashCode());
        result = prime * result + ((getCapitalOrderId() == null) ? 0 : getCapitalOrderId().hashCode());
        return result;
    }
}