package com.hummingbird.capital.entity;

import java.util.Date;

import com.hummingbird.capital.face.Account;

/**
 * 工程款帐户表，平台方用于登记收和发的工程款
 */
public class ProjectPaymentAccount implements Account {
    /**
     * 帐户id
     */
    private String accountId;

    /**
     * 用户
     */
    private Integer userId;

    /**
     * 帐户签名，按id，余额，备注，状态 进行md5加密
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
     * 状态,OK#正常，FLS失败
     */
    private String status;

    /**
     * 帐户可用余额,单位为分
     */
    private Long remainingSum;

    /**
     * 冻结余额，单位为分
     */
    private Long frozenSum;

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
     * @return 用户
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * @param userId 
	 *            用户
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
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

    /**
     * @return 帐户可用余额,单位为分
     */
    public Long getRemainingSum() {
        return remainingSum;
    }

    /**
     * @param remainingSum 
	 *            帐户可用余额,单位为分
     */
    public void setRemainingSum(Long remainingSum) {
        this.remainingSum = remainingSum;
    }

    /**
     * @return 冻结余额，单位为分
     */
    public Long getFrozenSum() {
        return frozenSum;
    }

    /**
     * @param frozenSum 
	 *            冻结余额，单位为分
     */
    public void setFrozenSum(Long frozenSum) {
        this.frozenSum = frozenSum;
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
        ProjectPaymentAccount other = (ProjectPaymentAccount) that;
        return (this.getAccountId() == null ? other.getAccountId() == null : this.getAccountId().equals(other.getAccountId()))
            && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getSignature() == null ? other.getSignature() == null : this.getSignature().equals(other.getSignature()))
            && (this.getInsertTime() == null ? other.getInsertTime() == null : this.getInsertTime().equals(other.getInsertTime()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()))
            && (this.getRemark() == null ? other.getRemark() == null : this.getRemark().equals(other.getRemark()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getRemainingSum() == null ? other.getRemainingSum() == null : this.getRemainingSum().equals(other.getRemainingSum()))
            && (this.getFrozenSum() == null ? other.getFrozenSum() == null : this.getFrozenSum().equals(other.getFrozenSum()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getAccountId() == null) ? 0 : getAccountId().hashCode());
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getSignature() == null) ? 0 : getSignature().hashCode());
        result = prime * result + ((getInsertTime() == null) ? 0 : getInsertTime().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        result = prime * result + ((getRemark() == null) ? 0 : getRemark().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getRemainingSum() == null) ? 0 : getRemainingSum().hashCode());
        result = prime * result + ((getFrozenSum() == null) ? 0 : getFrozenSum().hashCode());
        return result;
    }

	/* (non-Javadoc)
	 * @see com.hummingbird.capital.face.Account#getAccountCode()
	 */
	@Override
	public String getAccountCode() {
		return Account.ACCOUNT_PROJECT_PAYMENT;
	}

	/* (non-Javadoc)
	 * @see com.hummingbird.capital.face.Account#getAccountName()
	 */
	@Override
	public String getAccountName() {
		return "工程款帐户";
	}

	@Override
	public boolean isEnabled() {
		return "OK".equalsIgnoreCase(status);
	}

	
	@Override
	public boolean checkBalanceLimit(long limit) {
		return getRemainingSum()>=limit;
	}

	/* (non-Javadoc)
	 * @see com.hummingbird.capital.face.Account#isVirtualAccount()
	 */
	@Override
	public boolean isVirtualAccount() {
		return false;
	}

	/* (non-Javadoc)
	 * @see com.hummingbird.capital.face.Account#getBalanceValidateString()
	 */
	@Override
	public String getBalanceValidateString() {
		return "PP#"+userId+accountId+remainingSum+frozenSum+status;
	}
}