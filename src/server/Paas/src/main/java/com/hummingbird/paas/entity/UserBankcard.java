package com.hummingbird.paas.entity;

/**
 * 银行卡表
 */
public class UserBankcard {
    /**
     * id
     */
    private Integer id;

    /**
     * 认证招投标类型，TER发包商，BIR承包商
     */
    private String user;

    /**
     * 用户id
     */
    private Integer userId;

    /**
     * 银行名称
     */
    private String bankName;

    /**
     * 支行名称
     */
    private String bankBranchName;

    /**
     * 银行帐号
     */
    private String accountNo;

    /**
     * 省份-存中文
     */
    private String province;

    /**
     * 城市-存中文
     */
    private String city;

    /**
     * 开户人名称
     */
    private String accountName;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id 
	 *            id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return 认证招投标类型，TER发包商，BIR承包商
     */
    public String getUser() {
        return user;
    }

    /**
     * @param user 
	 *            认证招投标类型，TER发包商，BIR承包商
     */
    public void setUser(String user) {
        this.user = user == null ? null : user.trim();
    }

    /**
     * @return 用户id
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * @param userId 
	 *            用户id
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
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

    /**
     * @return 支行名称
     */
    public String getBankBranchName() {
        return bankBranchName;
    }

    /**
     * @param bankBranchName 
	 *            支行名称
     */
    public void setBankBranchName(String bankBranchName) {
        this.bankBranchName = bankBranchName == null ? null : bankBranchName.trim();
    }

    /**
     * @return 银行帐号
     */
    public String getAccountNo() {
        return accountNo;
    }

    /**
     * @param accountNo 
	 *            银行帐号
     */
    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo == null ? null : accountNo.trim();
    }

    /**
     * @return 省份-存中文
     */
    public String getProvince() {
        return province;
    }

    /**
     * @param province 
	 *            省份-存中文
     */
    public void setProvince(String province) {
        this.province = province == null ? null : province.trim();
    }

    /**
     * @return 城市-存中文
     */
    public String getCity() {
        return city;
    }

    /**
     * @param city 
	 *            城市-存中文
     */
    public void setCity(String city) {
        this.city = city == null ? null : city.trim();
    }

    /**
     * @return 开户人名称
     */
    public String getAccountName() {
        return accountName;
    }

    /**
     * @param accountName 
	 *            开户人名称
     */
    public void setAccountName(String accountName) {
        this.accountName = accountName == null ? null : accountName.trim();
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
        UserBankcard other = (UserBankcard) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getUser() == null ? other.getUser() == null : this.getUser().equals(other.getUser()))
            && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getBankName() == null ? other.getBankName() == null : this.getBankName().equals(other.getBankName()))
            && (this.getBankBranchName() == null ? other.getBankBranchName() == null : this.getBankBranchName().equals(other.getBankBranchName()))
            && (this.getAccountNo() == null ? other.getAccountNo() == null : this.getAccountNo().equals(other.getAccountNo()))
            && (this.getProvince() == null ? other.getProvince() == null : this.getProvince().equals(other.getProvince()))
            && (this.getCity() == null ? other.getCity() == null : this.getCity().equals(other.getCity()))
            && (this.getAccountName() == null ? other.getAccountName() == null : this.getAccountName().equals(other.getAccountName()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getUser() == null) ? 0 : getUser().hashCode());
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getBankName() == null) ? 0 : getBankName().hashCode());
        result = prime * result + ((getBankBranchName() == null) ? 0 : getBankBranchName().hashCode());
        result = prime * result + ((getAccountNo() == null) ? 0 : getAccountNo().hashCode());
        result = prime * result + ((getProvince() == null) ? 0 : getProvince().hashCode());
        result = prime * result + ((getCity() == null) ? 0 : getCity().hashCode());
        result = prime * result + ((getAccountName() == null) ? 0 : getAccountName().hashCode());
        return result;
    }
}