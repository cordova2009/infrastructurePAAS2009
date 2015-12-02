package com.hummingbird.capital.entity;

public class AccountIdPrefix {
    /**
     * 自增序号
     */
    private Integer id;

    /**
     * 类型，CA#-现金账户，IA#-投资账户，OCA-分期卡账户
     */
    private String accountType;

    /**
     * 卡号前2位数字
     */
    private String prefix;

    /**
     * 名称
     */
    private String name;

    /**
     * @return 自增序号
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id 
	 *            自增序号
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return 类型，CA#-现金账户，IA#-投资账户，OCA-分期卡账户
     */
    public String getAccountType() {
        return accountType;
    }

    /**
     * @param accounttype 
	 *            类型，CA#-现金账户，IA#-投资账户，OCA-分期卡账户
     */
    public void setAccountType(String accountType) {
        this.accountType = accountType == null ? null : accountType.trim();
    }

    /**
     * @return 卡号前2位数字
     */
    public String getPrefix() {
        return prefix;
    }

    /**
     * @param prefix 
	 *            卡号前2位数字
     */
    public void setPrefix(String prefix) {
        this.prefix = prefix == null ? null : prefix.trim();
    }

    /**
     * @return 名称
     */
    public String getName() {
        return name;
    }

    /**
     * @param name 
	 *            名称
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
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
        AccountIdPrefix other = (AccountIdPrefix) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getAccountType() == null ? other.getAccountType() == null : this.getAccountType().equals(other.getAccountType()))
            && (this.getPrefix() == null ? other.getPrefix() == null : this.getPrefix().equals(other.getPrefix()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getAccountType() == null) ? 0 : getAccountType().hashCode());
        result = prime * result + ((getPrefix() == null) ? 0 : getPrefix().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        return result;
    }
}