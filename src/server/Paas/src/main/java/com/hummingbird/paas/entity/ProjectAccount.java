package com.hummingbird.paas.entity;

import java.util.Date;

/**
 * 这个是发包方或承包商的帐户
 */
public class ProjectAccount {
    /**
     * 帐户id
     */
    private String account_id;

    /**
     * 帐户可用余额,单位为分
     */
    private Integer remaining_sum;

    /**
     * 帐户的签名
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
     * 状态
     */
    private String status;

    /**
     * 冻结余额，单位为分
     */
    private Integer frozen_sum;

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
     * @return 帐户可用余额,单位为分
     */
    public Integer getRemaining_sum() {
        return remaining_sum;
    }

    /**
     * @param remainingSum 
	 *            帐户可用余额,单位为分
     */
    public void setRemaining_sum(Integer remaining_sum) {
        this.remaining_sum = remaining_sum;
    }

    /**
     * @return 帐户的签名
     */
    public String getSignature() {
        return signature;
    }

    /**
     * @param signature 
	 *            帐户的签名
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
     * @return 状态
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status 
	 *            状态
     */
    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    /**
     * @return 冻结余额，单位为分
     */
    public Integer getFrozen_sum() {
        return frozen_sum;
    }

    /**
     * @param frozenSum 
	 *            冻结余额，单位为分
     */
    public void setFrozen_sum(Integer frozen_sum) {
        this.frozen_sum = frozen_sum;
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
        ProjectAccount other = (ProjectAccount) that;
        return (this.getAccount_id() == null ? other.getAccount_id() == null : this.getAccount_id().equals(other.getAccount_id()))
            && (this.getRemaining_sum() == null ? other.getRemaining_sum() == null : this.getRemaining_sum().equals(other.getRemaining_sum()))
            && (this.getSignature() == null ? other.getSignature() == null : this.getSignature().equals(other.getSignature()))
            && (this.getInsert_time() == null ? other.getInsert_time() == null : this.getInsert_time().equals(other.getInsert_time()))
            && (this.getUpdate_time() == null ? other.getUpdate_time() == null : this.getUpdate_time().equals(other.getUpdate_time()))
            && (this.getRemark() == null ? other.getRemark() == null : this.getRemark().equals(other.getRemark()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getFrozen_sum() == null ? other.getFrozen_sum() == null : this.getFrozen_sum().equals(other.getFrozen_sum()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getAccount_id() == null) ? 0 : getAccount_id().hashCode());
        result = prime * result + ((getRemaining_sum() == null) ? 0 : getRemaining_sum().hashCode());
        result = prime * result + ((getSignature() == null) ? 0 : getSignature().hashCode());
        result = prime * result + ((getInsert_time() == null) ? 0 : getInsert_time().hashCode());
        result = prime * result + ((getUpdate_time() == null) ? 0 : getUpdate_time().hashCode());
        result = prime * result + ((getRemark() == null) ? 0 : getRemark().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getFrozen_sum() == null) ? 0 : getFrozen_sum().hashCode());
        return result;
    }
}