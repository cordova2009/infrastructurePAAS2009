package com.hummingbird.paas.entity;

/**
 * 用户密码表
 */
public class UserPassword {
    /**
     * 用户id
     */
    private Integer user_id;

    /**
     * 登录密码
     */
    private String password;

    /**
     * 交易密码
     */
    private String trade_password;

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
    public String getTrade_password() {
        return trade_password;
    }

    /**
     * @param tradePassword 
	 *            交易密码
     */
    public void setTrade_password(String trade_password) {
        this.trade_password = trade_password == null ? null : trade_password.trim();
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
        return (this.getUser_id() == null ? other.getUser_id() == null : this.getUser_id().equals(other.getUser_id()))
            && (this.getPassword() == null ? other.getPassword() == null : this.getPassword().equals(other.getPassword()))
            && (this.getTrade_password() == null ? other.getTrade_password() == null : this.getTrade_password().equals(other.getTrade_password()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getUser_id() == null) ? 0 : getUser_id().hashCode());
        result = prime * result + ((getPassword() == null) ? 0 : getPassword().hashCode());
        result = prime * result + ((getTrade_password() == null) ? 0 : getTrade_password().hashCode());
        return result;
    }
}