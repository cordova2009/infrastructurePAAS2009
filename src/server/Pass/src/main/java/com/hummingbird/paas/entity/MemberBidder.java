package com.hummingbird.paas.entity;

import java.util.Date;

/**
 * 承包商会员表
 */
public class MemberBidder {
    /**
     * 会员id
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
     * 会员开始时间
     */
    private Date start_time;

    /**
     * 会员结束时间
     */
    private Date end_time;

    /**
     * @return 会员id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id 
	 *            会员id
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
     * @return 会员开始时间
     */
    public Date getStart_time() {
        return start_time;
    }

    /**
     * @param startTime 
	 *            会员开始时间
     */
    public void setStart_time(Date start_time) {
        this.start_time = start_time;
    }

    /**
     * @return 会员结束时间
     */
    public Date getEnd_time() {
        return end_time;
    }

    /**
     * @param endTime 
	 *            会员结束时间
     */
    public void setEnd_time(Date end_time) {
        this.end_time = end_time;
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
        MemberBidder other = (MemberBidder) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getBidder_id() == null ? other.getBidder_id() == null : this.getBidder_id().equals(other.getBidder_id()))
            && (this.getMember_level() == null ? other.getMember_level() == null : this.getMember_level().equals(other.getMember_level()))
            && (this.getStart_time() == null ? other.getStart_time() == null : this.getStart_time().equals(other.getStart_time()))
            && (this.getEnd_time() == null ? other.getEnd_time() == null : this.getEnd_time().equals(other.getEnd_time()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getBidder_id() == null) ? 0 : getBidder_id().hashCode());
        result = prime * result + ((getMember_level() == null) ? 0 : getMember_level().hashCode());
        result = prime * result + ((getStart_time() == null) ? 0 : getStart_time().hashCode());
        result = prime * result + ((getEnd_time() == null) ? 0 : getEnd_time().hashCode());
        return result;
    }
}