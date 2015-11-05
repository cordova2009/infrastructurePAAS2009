package com.hummingbird.paas.entity;

import java.util.Date;

/**
 * 发包方会员升级记录表
 */
public class TendererUpgrade {
    /**
     * 记录id
     */
    private Integer id;

    /**
     * 发包方id
     */
    private Integer tenderer_id;

    /**
     * 会员级别，STD标准会员，ADV高级会员
     */
    private String member_level;

    /**
     * 升级时间
     */
    private Date insert_time;

    /**
     * 升级价格，单位为分
     */
    private Integer amount;

    /**
     * @return 记录id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id 
	 *            记录id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return 发包方id
     */
    public Integer getTenderer_id() {
        return tenderer_id;
    }

    /**
     * @param tendererId 
	 *            发包方id
     */
    public void setTenderer_id(Integer tenderer_id) {
        this.tenderer_id = tenderer_id;
    }

    /**
     * @return 会员级别，STD标准会员，ADV高级会员
     */
    public String getMember_level() {
        return member_level;
    }

    /**
     * @param memberLevel 
	 *            会员级别，STD标准会员，ADV高级会员
     */
    public void setMember_level(String member_level) {
        this.member_level = member_level == null ? null : member_level.trim();
    }

    /**
     * @return 升级时间
     */
    public Date getInsert_time() {
        return insert_time;
    }

    /**
     * @param insertTime 
	 *            升级时间
     */
    public void setInsert_time(Date insert_time) {
        this.insert_time = insert_time;
    }

    /**
     * @return 升级价格，单位为分
     */
    public Integer getAmount() {
        return amount;
    }

    /**
     * @param amount 
	 *            升级价格，单位为分
     */
    public void setAmount(Integer amount) {
        this.amount = amount;
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
        TendererUpgrade other = (TendererUpgrade) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getTenderer_id() == null ? other.getTenderer_id() == null : this.getTenderer_id().equals(other.getTenderer_id()))
            && (this.getMember_level() == null ? other.getMember_level() == null : this.getMember_level().equals(other.getMember_level()))
            && (this.getInsert_time() == null ? other.getInsert_time() == null : this.getInsert_time().equals(other.getInsert_time()))
            && (this.getAmount() == null ? other.getAmount() == null : this.getAmount().equals(other.getAmount()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getTenderer_id() == null) ? 0 : getTenderer_id().hashCode());
        result = prime * result + ((getMember_level() == null) ? 0 : getMember_level().hashCode());
        result = prime * result + ((getInsert_time() == null) ? 0 : getInsert_time().hashCode());
        result = prime * result + ((getAmount() == null) ? 0 : getAmount().hashCode());
        return result;
    }
}