package com.hummingbird.paas.entity;

import java.util.Date;

/**
 * 这里的保证金指的是中标时承包商交纳的保证金
 */
public class BondAccount {
    /**
     * 帐户id
     */
    private String account_id;

    /**
     * 帐户余额
     */
    private Integer balance;

    /**
     * 帐户签名，按id，余额，备注，状态 进行md5加密
     */
    private String signature;

    /**
     * 插入时间
     */
    private Date insert_time;

    /**
     * 更新时间
     */
    private Date update_time;

    /**
     * 备注
     */
    private String remark;

    /**
     * 状态,OK#正常，FLS失败
     */
    private String status;

    /**
     * @return 帐户id
     */
    public String getAccount_id() {
        return account_id;
    }

    /**
     * @param accountId 
	 *            帐户id
     */
    public void setAccount_id(String account_id) {
        this.account_id = account_id == null ? null : account_id.trim();
    }

    /**
     * @return 帐户余额
     */
    public Integer getBalance() {
        return balance;
    }

    /**
     * @param balance 
	 *            帐户余额
     */
    public void setBalance(Integer balance) {
        this.balance = balance;
    }

    /**
     * @return 帐户签名，按id，余额，备注，状态 进行md5加密
     */
    public String getSignature() {
        return signature;
    }

    /**
     * @param signature 
	 *            帐户签名，按id，余额，备注，状态 进行md5加密
     */
    public void setSignature(String signature) {
        this.signature = signature == null ? null : signature.trim();
    }

    /**
     * @return 插入时间
     */
    public Date getInsert_time() {
        return insert_time;
    }

    /**
     * @param insertTime 
	 *            插入时间
     */
    public void setInsert_time(Date insert_time) {
        this.insert_time = insert_time;
    }

    /**
     * @return 更新时间
     */
    public Date getUpdate_time() {
        return update_time;
    }

    /**
     * @param updateTime 
	 *            更新时间
     */
    public void setUpdate_time(Date update_time) {
        this.update_time = update_time;
    }

    /**
     * @return 备注
     */
    public String getRemark() {
        return remark;
    }

    /**
     * @param remark 
	 *            备注
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    /**
     * @return 状态,OK#正常，FLS失败
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status 
	 *            状态,OK#正常，FLS失败
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
        BondAccount other = (BondAccount) that;
        return (this.getAccount_id() == null ? other.getAccount_id() == null : this.getAccount_id().equals(other.getAccount_id()))
            && (this.getBalance() == null ? other.getBalance() == null : this.getBalance().equals(other.getBalance()))
            && (this.getSignature() == null ? other.getSignature() == null : this.getSignature().equals(other.getSignature()))
            && (this.getInsert_time() == null ? other.getInsert_time() == null : this.getInsert_time().equals(other.getInsert_time()))
            && (this.getUpdate_time() == null ? other.getUpdate_time() == null : this.getUpdate_time().equals(other.getUpdate_time()))
            && (this.getRemark() == null ? other.getRemark() == null : this.getRemark().equals(other.getRemark()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getAccount_id() == null) ? 0 : getAccount_id().hashCode());
        result = prime * result + ((getBalance() == null) ? 0 : getBalance().hashCode());
        result = prime * result + ((getSignature() == null) ? 0 : getSignature().hashCode());
        result = prime * result + ((getInsert_time() == null) ? 0 : getInsert_time().hashCode());
        result = prime * result + ((getUpdate_time() == null) ? 0 : getUpdate_time().hashCode());
        result = prime * result + ((getRemark() == null) ? 0 : getRemark().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        return result;
    }
}