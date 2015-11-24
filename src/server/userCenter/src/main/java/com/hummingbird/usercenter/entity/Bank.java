package com.hummingbird.usercenter.entity;

/**
 * 银行表
 */
public class Bank {
    /**
     * 银行id，ICBC 工行 等
     */
    private String bankId;

    /**
     * 银行名称
     */
    private String bankName;

    /**
     * @return 银行id，ICBC 工行 等
     */
    public String getBankId() {
        return bankId;
    }

    /**
     * @param bankId 
	 *            银行id，ICBC 工行 等
     */
    public void setBankId(String bankId) {
        this.bankId = bankId == null ? null : bankId.trim();
    }

    /**
     * @return 银行名称
     */
    public String getBankName() {
        return bankName;
    }

    /**
     * @param bankName 
	 *            银行名称
     */
    public void setBankName(String bankName) {
        this.bankName = bankName == null ? null : bankName.trim();
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
        Bank other = (Bank) that;
        return (this.getBankId() == null ? other.getBankId() == null : this.getBankId().equals(other.getBankId()))
            && (this.getBankName() == null ? other.getBankName() == null : this.getBankName().equals(other.getBankName()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getBankId() == null) ? 0 : getBankId().hashCode());
        result = prime * result + ((getBankName() == null) ? 0 : getBankName().hashCode());
        return result;
    }
}