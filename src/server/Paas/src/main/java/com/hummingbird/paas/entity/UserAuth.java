package com.hummingbird.paas.entity;

/**
 * 身份认证表
 */
public class UserAuth {
    /**
     * 用户id
     */
    private Integer user_id;

    /**
     * 真实姓名
     */
    private String real_name;

    /**
     * 身份证号
     */
    private String identity_no;

    /**
     * 认证结果,OK# 认证通过，FLS认证不通过，CRT 待认证
     */
    private String real_name_verify;

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
     * @return 真实姓名
     */
    public String getReal_name() {
        return real_name;
    }

    /**
     * @param realName 
	 *            真实姓名
     */
    public void setReal_name(String real_name) {
        this.real_name = real_name == null ? null : real_name.trim();
    }

    /**
     * @return 身份证号
     */
    public String getIdentity_no() {
        return identity_no;
    }

    /**
     * @param identityNo 
	 *            身份证号
     */
    public void setIdentity_no(String identity_no) {
        this.identity_no = identity_no == null ? null : identity_no.trim();
    }

    /**
     * @return 认证结果,OK# 认证通过，FLS认证不通过，CRT 待认证
     */
    public String getReal_name_verify() {
        return real_name_verify;
    }

    /**
     * @param realNameVerify 
	 *            认证结果,OK# 认证通过，FLS认证不通过，CRT 待认证
     */
    public void setReal_name_verify(String real_name_verify) {
        this.real_name_verify = real_name_verify == null ? null : real_name_verify.trim();
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
        UserAuth other = (UserAuth) that;
        return (this.getUser_id() == null ? other.getUser_id() == null : this.getUser_id().equals(other.getUser_id()))
            && (this.getReal_name() == null ? other.getReal_name() == null : this.getReal_name().equals(other.getReal_name()))
            && (this.getIdentity_no() == null ? other.getIdentity_no() == null : this.getIdentity_no().equals(other.getIdentity_no()))
            && (this.getReal_name_verify() == null ? other.getReal_name_verify() == null : this.getReal_name_verify().equals(other.getReal_name_verify()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getUser_id() == null) ? 0 : getUser_id().hashCode());
        result = prime * result + ((getReal_name() == null) ? 0 : getReal_name().hashCode());
        result = prime * result + ((getIdentity_no() == null) ? 0 : getIdentity_no().hashCode());
        result = prime * result + ((getReal_name_verify() == null) ? 0 : getReal_name_verify().hashCode());
        return result;
    }
}