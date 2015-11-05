package com.hummingbird.paas.entity;

import java.util.Date;

/**
 * 标的保证金缴还历史表
 */
public class ObjectBondRecord {
    /**
     * 主键
     */
    private Integer id;

    /**
     * 标的id
     */
    private String object_id;

    /**
     * 金额，单位为分
     */
    private Integer bond_amount;

    /**
     * 收缴类型，FOZ冻结（帐户内的钱），PAY缴（保证金，中标后），REV收保证金
     */
    private String type;

    /**
     * 处理时间
     */
    private Date insert_time;

    /**
     * 认证招投标类型，TER发包商，BIR承包商
     */
    private String company_type;

    /**
     * 认证提出方id,记录承包商id或发包方id
     */
    private String company_id;

    /**
     * 订单id
     */
    private String order_id;

    /**
     * 保证金类型,BID投标保证金, WIN中标后交纳的保证金
     */
    private String bond_type;

    /**
     * @return 主键
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id 
	 *            主键
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
     * @return 金额，单位为分
     */
    public Integer getBond_amount() {
        return bond_amount;
    }

    /**
     * @param bondAmount 
	 *            金额，单位为分
     */
    public void setBond_amount(Integer bond_amount) {
        this.bond_amount = bond_amount;
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
    public Date getInsert_time() {
        return insert_time;
    }

    /**
     * @param insertTime 
	 *            处理时间
     */
    public void setInsert_time(Date insert_time) {
        this.insert_time = insert_time;
    }

    /**
     * @return 认证招投标类型，TER发包商，BIR承包商
     */
    public String getCompany_type() {
        return company_type;
    }

    /**
     * @param companyType 
	 *            认证招投标类型，TER发包商，BIR承包商
     */
    public void setCompany_type(String company_type) {
        this.company_type = company_type == null ? null : company_type.trim();
    }

    /**
     * @return 认证提出方id,记录承包商id或发包方id
     */
    public String getCompany_id() {
        return company_id;
    }

    /**
     * @param companyId 
	 *            认证提出方id,记录承包商id或发包方id
     */
    public void setCompany_id(String company_id) {
        this.company_id = company_id == null ? null : company_id.trim();
    }

    /**
     * @return 订单id
     */
    public String getOrder_id() {
        return order_id;
    }

    /**
     * @param orderId 
	 *            订单id
     */
    public void setOrder_id(String order_id) {
        this.order_id = order_id == null ? null : order_id.trim();
    }

    /**
     * @return 保证金类型,BID投标保证金, WIN中标后交纳的保证金
     */
    public String getBond_type() {
        return bond_type;
    }

    /**
     * @param bondType 
	 *            保证金类型,BID投标保证金, WIN中标后交纳的保证金
     */
    public void setBond_type(String bond_type) {
        this.bond_type = bond_type == null ? null : bond_type.trim();
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
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getObject_id() == null ? other.getObject_id() == null : this.getObject_id().equals(other.getObject_id()))
            && (this.getBond_amount() == null ? other.getBond_amount() == null : this.getBond_amount().equals(other.getBond_amount()))
            && (this.getType() == null ? other.getType() == null : this.getType().equals(other.getType()))
            && (this.getInsert_time() == null ? other.getInsert_time() == null : this.getInsert_time().equals(other.getInsert_time()))
            && (this.getCompany_type() == null ? other.getCompany_type() == null : this.getCompany_type().equals(other.getCompany_type()))
            && (this.getCompany_id() == null ? other.getCompany_id() == null : this.getCompany_id().equals(other.getCompany_id()))
            && (this.getOrder_id() == null ? other.getOrder_id() == null : this.getOrder_id().equals(other.getOrder_id()))
            && (this.getBond_type() == null ? other.getBond_type() == null : this.getBond_type().equals(other.getBond_type()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getObject_id() == null) ? 0 : getObject_id().hashCode());
        result = prime * result + ((getBond_amount() == null) ? 0 : getBond_amount().hashCode());
        result = prime * result + ((getType() == null) ? 0 : getType().hashCode());
        result = prime * result + ((getInsert_time() == null) ? 0 : getInsert_time().hashCode());
        result = prime * result + ((getCompany_type() == null) ? 0 : getCompany_type().hashCode());
        result = prime * result + ((getCompany_id() == null) ? 0 : getCompany_id().hashCode());
        result = prime * result + ((getOrder_id() == null) ? 0 : getOrder_id().hashCode());
        result = prime * result + ((getBond_type() == null) ? 0 : getBond_type().hashCode());
        return result;
    }
}