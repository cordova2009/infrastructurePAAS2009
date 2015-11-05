package com.hummingbird.paas.entity;

/**
 * 银行表
 */
public class Bank {
    /**
     * 银行id，ICBC 工行 等
     */
    private String bank_id;

    /**
     * 银行名称
     */
    private String bank_name;

    /**
     * @return 银行id，ICBC 工行 等
     */
    public String getBank_id() {
        return bank_id;
    }

    /**
     * @param bankId 
	 *            银行id，ICBC 工行 等
     */
    public void setBank_id(String bank_id) {
        this.bank_id = bank_id == null ? null : bank_id.trim();
    }

    /**
     * @return 银行名称
     */
    public String getBank_name() {
        return bank_name;
    }

    /**
     * @param bankName 
	 *            银行名称
     */
    public void setBank_name(String bank_name) {
        this.bank_name = bank_name == null ? null : bank_name.trim();
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
        return (this.getBank_id() == null ? other.getBank_id() == null : this.getBank_id().equals(other.getBank_id()))
            && (this.getBank_name() == null ? other.getBank_name() == null : this.getBank_name().equals(other.getBank_name()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getBank_id() == null) ? 0 : getBank_id().hashCode());
        result = prime * result + ((getBank_name() == null) ? 0 : getBank_name().hashCode());
        return result;
    }
}