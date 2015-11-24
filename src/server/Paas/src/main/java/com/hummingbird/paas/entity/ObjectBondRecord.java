package com.hummingbird.paas.entity;

import java.util.Date;

/**
 * 标的保证金缴还历史表
 */
public class ObjectBondRecord {
    /**
     * 订单id,BZ00时间戳+随机数组成
     */
    private String orderId;

    /**
     * 标的id
     */
    private String objectId;

    /**
     * 金额，单位为分
     */
    private Long bondAmount;

    /**
     * 收缴类型，FOZ冻结（帐户内的钱），PAY缴（保证金，中标后），REV收保证金
     */
    private String type;

    /**
     * 处理时间
     */
    private Date insertTime;

    /**
     * 认证招投标类型，TER发包商，BIR承包商
     */
    private String companyType;

    /**
     * 认证提出方id,记录承包商id或发包方id
     */
    private Integer companyId;

    /**
     * 保证金类型,BID投标保证金, WIN中标后交纳的保证金
     */
    private String bondType;

    /**
     * 投标id
     */
    private Integer bidId;

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
     * @return 收缴类型，FOZ冻结（帐户内的钱），PAY缴（保证金，中标后），REV收保证金
     */
    public String getType() {
        return type;
    }

    /**
     * @param type 
	 *            收缴类型，FOZ冻结（帐户内的钱），PAY缴（保证金，中标后），REV收保证金
     */
    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    /**
     * @return 处理时间
     */
    public Date getInsertTime() {
        return insertTime;
    }

    /**
     * @param insertTime 
	 *            处理时间
     */
    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }

    /**
     * @return 认证招投标类型，TER发包商，BIR承包商
     */
    public String getCompanyType() {
        return companyType;
    }

    /**
     * @param companyType 
	 *            认证招投标类型，TER发包商，BIR承包商
     */
    public void setCompanyType(String companyType) {
        this.companyType = companyType == null ? null : companyType.trim();
    }

    /**
     * @return 认证提出方id,记录承包商id或发包方id
     */
    public Integer getCompanyId() {
        return companyId;
    }

    /**
     * @param companyId 
	 *            认证提出方id,记录承包商id或发包方id
     */
    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    /**
     * @return 保证金类型,BID投标保证金, WIN中标后交纳的保证金
     */
    public String getBondType() {
        return bondType;
    }

    /**
     * @param bondType 
	 *            保证金类型,BID投标保证金, WIN中标后交纳的保证金
     */
    public void setBondType(String bondType) {
        this.bondType = bondType == null ? null : bondType.trim();
    }

    /**
     * @return 投标id
     */
    public Integer getBidId() {
        return bidId;
    }

    /**
     * @param bidId 
	 *            投标id
     */
    public void setBidId(Integer bidId) {
        this.bidId = bidId;
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
        ObjectBondRecord other = (ObjectBondRecord) that;
        return (this.getOrderId() == null ? other.getOrderId() == null : this.getOrderId().equals(other.getOrderId()))
            && (this.getObjectId() == null ? other.getObjectId() == null : this.getObjectId().equals(other.getObjectId()))
            && (this.getBondAmount() == null ? other.getBondAmount() == null : this.getBondAmount().equals(other.getBondAmount()))
            && (this.getType() == null ? other.getType() == null : this.getType().equals(other.getType()))
            && (this.getInsertTime() == null ? other.getInsertTime() == null : this.getInsertTime().equals(other.getInsertTime()))
            && (this.getCompanyType() == null ? other.getCompanyType() == null : this.getCompanyType().equals(other.getCompanyType()))
            && (this.getCompanyId() == null ? other.getCompanyId() == null : this.getCompanyId().equals(other.getCompanyId()))
            && (this.getBondType() == null ? other.getBondType() == null : this.getBondType().equals(other.getBondType()))
            && (this.getBidId() == null ? other.getBidId() == null : this.getBidId().equals(other.getBidId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getOrderId() == null) ? 0 : getOrderId().hashCode());
        result = prime * result + ((getObjectId() == null) ? 0 : getObjectId().hashCode());
        result = prime * result + ((getBondAmount() == null) ? 0 : getBondAmount().hashCode());
        result = prime * result + ((getType() == null) ? 0 : getType().hashCode());
        result = prime * result + ((getInsertTime() == null) ? 0 : getInsertTime().hashCode());
        result = prime * result + ((getCompanyType() == null) ? 0 : getCompanyType().hashCode());
        result = prime * result + ((getCompanyId() == null) ? 0 : getCompanyId().hashCode());
        result = prime * result + ((getBondType() == null) ? 0 : getBondType().hashCode());
        result = prime * result + ((getBidId() == null) ? 0 : getBidId().hashCode());
        return result;
    }
}