package com.hummingbird.paas.entity;

import java.util.Date;

/**
 * 承包商会员升级记录表
 */
public class BidderUpgrade {
    /**
     * 记录id
     */
    private Integer id;

    /**
     * 承包商id
     */
    private Integer bidder_id;

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
     * @return 承包商id
     */
    public Integer getBidder_id() {
        return bidder_id;
    }

    /**
     * @param bidderId 
	 *            承包商id
     */
    public void setBidder_id(Integer bidder_id) {
        this.bidder_id = bidder_id;
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
        BidderUpgrade other = (BidderUpgrade) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getBidder_id() == null ? other.getBidder_id() == null : this.getBidder_id().equals(other.getBidder_id()))
            && (this.getMember_level() == null ? other.getMember_level() == null : this.getMember_level().equals(other.getMember_level()))
            && (this.getInsert_time() == null ? other.getInsert_time() == null : this.getInsert_time().equals(other.getInsert_time()))
            && (this.getAmount() == null ? other.getAmount() == null : this.getAmount().equals(other.getAmount()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getBidder_id() == null) ? 0 : getBidder_id().hashCode());
        result = prime * result + ((getMember_level() == null) ? 0 : getMember_level().hashCode());
        result = prime * result + ((getInsert_time() == null) ? 0 : getInsert_time().hashCode());
        result = prime * result + ((getAmount() == null) ? 0 : getAmount().hashCode());
        return result;
    }
}