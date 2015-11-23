package com.hummingbird.paas.entity;

import java.util.Date;

import com.hummingbird.paas.face.Account;


/**
 * 这个是发包方或承包商的帐户
 */
public class ProjectAccount implements Account{
    /**
     * 帐户id
     */
    private String accountId;

    /**
     * 帐户可用余额,单位为分
     */
    private Integer remainingSum;

    /**
     * 帐户的签名
     */
    private String signature;

    /**
     * 插入时间
     */
    private Date insertTime;

    /**
     * 更新时间
     */
    private Date updateTime;

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
    private Integer frozenSum;

    private Integer userId;
    
    @Override
	public String getBalanceValidateString() {
		return "CA#"+userId+accountId+remainingSum+frozenSum+insertTime+updateTime+status;
	}

    /**
     * @return 帐户id
     */
    public String getAccountId() {
        return accountId;
    }

    /**
     * @param accountId 
	 *            帐户id
     */
    public void setAccountId(String accountId) {
        this.accountId = accountId == null ? null : accountId.trim();
    }

    /**
     * @return 帐户可用余额,单位为分
     */
    public Integer getRemainingSum() {
        return remainingSum;
    }

    /**
     * @param remainingSum 
	 *            帐户可用余额,单位为分
     */
    public void setRemainingSum(Integer remainingSum) {
        this.remainingSum = remainingSum;
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
    public Date getInsertTime() {
        return insertTime;
    }

    /**
     * @param insertTime 
	 *            插入时间
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
    public Integer getFrozenSum() {
        return frozenSum;
    }

    /**
     * @param frozenSum 
	 *            冻结余额，单位为分
     */
    public void setFrozenSum(Integer frozenSum) {
        this.frozenSum = frozenSum;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
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
        return (this.getAccountId() == null ? other.getAccountId() == null : this.getAccountId().equals(other.getAccountId()))
            && (this.getRemainingSum() == null ? other.getRemainingSum() == null : this.getRemainingSum().equals(other.getRemainingSum()))
            && (this.getSignature() == null ? other.getSignature() == null : this.getSignature().equals(other.getSignature()))
            && (this.getInsertTime() == null ? other.getInsertTime() == null : this.getInsertTime().equals(other.getInsertTime()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()))
            && (this.getRemark() == null ? other.getRemark() == null : this.getRemark().equals(other.getRemark()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getFrozenSum() == null ? other.getFrozenSum() == null : this.getFrozenSum().equals(other.getFrozenSum()))
            && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getAccountId() == null) ? 0 : getAccountId().hashCode());
        result = prime * result + ((getRemainingSum() == null) ? 0 : getRemainingSum().hashCode());
        result = prime * result + ((getSignature() == null) ? 0 : getSignature().hashCode());
        result = prime * result + ((getInsertTime() == null) ? 0 : getInsertTime().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        result = prime * result + ((getRemark() == null) ? 0 : getRemark().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getFrozenSum() == null) ? 0 : getFrozenSum().hashCode());
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        return result;
    }

	@Override
	public String getAccountCode() {
		
		return Account.ACCOUNT_PROJECT;
	}

	@Override
	public String getAccountName() {
		// TODO Auto-generated method stub
		return "资金账户";
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return "OK".equalsIgnoreCase(status);
	}

	
	@Override
	public boolean checkBalanceLimit(long limit) {
		// TODO Auto-generated method stub
		return getRemainingSum()>=limit;
	}

	@Override
	public boolean isVirtualAccount() {
		// TODO Auto-generated method stub
		return false;
	}

	
}