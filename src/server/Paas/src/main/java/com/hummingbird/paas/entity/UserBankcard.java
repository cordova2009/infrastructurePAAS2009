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
    private Integer user_id;

    /**
     * 银行名称
     */
    private String bank_name;

    /**
     * 支行名称
     */
    private String bank_branch_name;

    /**
     * 银行帐号
     */
    private String account_no;

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
    private String account_name;

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
    public Integer getUser_id() {
        return user_id;
    }

    /**
     * @param userId 
	 *            用户id
     */
    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
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

    /**
     * @return 支行名称
     */
    public String getBank_branch_name() {
        return bank_branch_name;
    }

    /**
     * @param bankBranchName 
	 *            支行名称
     */
    public void setBank_branch_name(String bank_branch_name) {
        this.bank_branch_name = bank_branch_name == null ? null : bank_branch_name.trim();
    }

    /**
     * @return 银行帐号
     */
    public String getAccount_no() {
        return account_no;
    }

    /**
     * @param accountNo 
	 *            银行帐号
     */
    public void setAccount_no(String account_no) {
        this.account_no = account_no == null ? null : account_no.trim();
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
    public String getAccount_name() {
        return account_name;
    }

    /**
     * @param accountName 
	 *            开户人名称
     */
    public void setAccount_name(String account_name) {
        this.account_name = account_name == null ? null : account_name.trim();
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
            && (this.getUser_id() == null ? other.getUser_id() == null : this.getUser_id().equals(other.getUser_id()))
            && (this.getBank_name() == null ? other.getBank_name() == null : this.getBank_name().equals(other.getBank_name()))
            && (this.getBank_branch_name() == null ? other.getBank_branch_name() == null : this.getBank_branch_name().equals(other.getBank_branch_name()))
            && (this.getAccount_no() == null ? other.getAccount_no() == null : this.getAccount_no().equals(other.getAccount_no()))
            && (this.getProvince() == null ? other.getProvince() == null : this.getProvince().equals(other.getProvince()))
            && (this.getCity() == null ? other.getCity() == null : this.getCity().equals(other.getCity()))
            && (this.getAccount_name() == null ? other.getAccount_name() == null : this.getAccount_name().equals(other.getAccount_name()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getUser() == null) ? 0 : getUser().hashCode());
        result = prime * result + ((getUser_id() == null) ? 0 : getUser_id().hashCode());
        result = prime * result + ((getBank_name() == null) ? 0 : getBank_name().hashCode());
        result = prime * result + ((getBank_branch_name() == null) ? 0 : getBank_branch_name().hashCode());
        result = prime * result + ((getAccount_no() == null) ? 0 : getAccount_no().hashCode());
        result = prime * result + ((getProvince() == null) ? 0 : getProvince().hashCode());
        result = prime * result + ((getCity() == null) ? 0 : getCity().hashCode());
        result = prime * result + ((getAccount_name() == null) ? 0 : getAccount_name().hashCode());
        return result;
    }
}