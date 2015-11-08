package com.hummingbird.paas.entity;

/**
 * 会员特权表
 */
public class MemberProductPrivilege {
    /**
     * id
     */
    private Integer id;

    /**
     * 会员产品id
     */
    private Integer productId;

    /**
     * 特权
     */
    private String privilege;

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
     * @return 会员产品id
     */
    public Integer getProductId() {
        return productId;
    }

    /**
     * @param productId 
	 *            会员产品id
     */
    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    /**
     * @return 特权
     */
    public String getPrivilege() {
        return privilege;
    }

    /**
     * @param privilege 
	 *            特权
     */
    public void setPrivilege(String privilege) {
        this.privilege = privilege == null ? null : privilege.trim();
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
        MemberProductPrivilege other = (MemberProductPrivilege) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getProductId() == null ? other.getProductId() == null : this.getProductId().equals(other.getProductId()))
            && (this.getPrivilege() == null ? other.getPrivilege() == null : this.getPrivilege().equals(other.getPrivilege()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getProductId() == null) ? 0 : getProductId().hashCode());
        result = prime * result + ((getPrivilege() == null) ? 0 : getPrivilege().hashCode());
        return result;
    }
}