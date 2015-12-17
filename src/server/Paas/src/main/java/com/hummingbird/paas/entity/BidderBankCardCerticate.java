package com.hummingbird.paas.entity;

/**
 * 投标人资质银行卡认证申请表
 */
public class BidderBankCardCerticate {
    /**
     * id
     */
    private Integer id;

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
     * 税号
     */
    private String taxNo;

    /**
     * 公司地址
     */
    private String address;

    /**
     * 电话
     */
    private String telephone;

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

    /**
     * @return 税号
     */
    public String getTaxNo() {
        return taxNo;
    }

    /**
     * @param taxNo 
	 *            税号
     */
    public void setTaxNo(String taxNo) {
        this.taxNo = taxNo == null ? null : taxNo.trim();
    }

    /**
     * @return 公司地址
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address 
	 *            公司地址
     */
    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    /**
     * @return 电话
     */
    public String getTelephone() {
        return telephone;
    }

    /**
     * @param telephone 
	 *            电话
     */
    public void setTelephone(String telephone) {
        this.telephone = telephone == null ? null : telephone.trim();
    }
}