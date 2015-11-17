package com.hummingbird.usercenter.entity;

/**
 * 身份认证表
 */
public class UserAuth {
    /**
     * 用户id
     */
    private Integer userId;

    /**
     * 真实姓名
     */
    private String realName;

    /**
     * 身份证号
     */
    private String identityNo;

    /**
     * 认证结果,OK# 认证通过，FLS认证不通过，CRT 待认证
     */
    private String realNameVerify;

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
     * @return 真实姓名
     */
    public String getRealName() {
        return realName;
    }

    /**
     * @param realName 
	 *            真实姓名
     */
    public void setRealName(String realName) {
        this.realName = realName == null ? null : realName.trim();
    }

    /**
     * @return 身份证号
     */
    public String getIdentityNo() {
        return identityNo;
    }

    /**
     * @param identityNo 
	 *            身份证号
     */
    public void setIdentityNo(String identityNo) {
        this.identityNo = identityNo == null ? null : identityNo.trim();
    }

    /**
     * @return 认证结果,OK# 认证通过，FLS认证不通过，CRT 待认证
     */
    public String getRealNameVerify() {
        return realNameVerify;
    }

    /**
     * @param realNameVerify 
	 *            认证结果,OK# 认证通过，FLS认证不通过，CRT 待认证
     */
    public void setRealNameVerify(String realNameVerify) {
        this.realNameVerify = realNameVerify == null ? null : realNameVerify.trim();
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
        return (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getRealName() == null ? other.getRealName() == null : this.getRealName().equals(other.getRealName()))
            && (this.getIdentityNo() == null ? other.getIdentityNo() == null : this.getIdentityNo().equals(other.getIdentityNo()))
            && (this.getRealNameVerify() == null ? other.getRealNameVerify() == null : this.getRealNameVerify().equals(other.getRealNameVerify()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getRealName() == null) ? 0 : getRealName().hashCode());
        result = prime * result + ((getIdentityNo() == null) ? 0 : getIdentityNo().hashCode());
        result = prime * result + ((getRealNameVerify() == null) ? 0 : getRealNameVerify().hashCode());
        return result;
    }
}