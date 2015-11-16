package com.hummingbird.capital.entity;

/**
 * 用户密码表
 */
public class UserPassword {
    /**
     * 用户id
     */
    private Integer userId;

    /**
     * 登录密码
     */
    private String password;

    /**
     * 交易密码
     */
    private String tradePassword;

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
     * @return 登录密码
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password 
	 *            登录密码
     */
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    /**
     * @return 交易密码
     */
    public String getTradePassword() {
        return tradePassword;
    }

    /**
     * @param tradePassword 
	 *            交易密码
     */
    public void setTradePassword(String tradePassword) {
        this.tradePassword = tradePassword == null ? null : tradePassword.trim();
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
        UserPassword other = (UserPassword) that;
        return (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getPassword() == null ? other.getPassword() == null : this.getPassword().equals(other.getPassword()))
            && (this.getTradePassword() == null ? other.getTradePassword() == null : this.getTradePassword().equals(other.getTradePassword()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getPassword() == null) ? 0 : getPassword().hashCode());
        result = prime * result + ((getTradePassword() == null) ? 0 : getTradePassword().hashCode());
        return result;
    }
}