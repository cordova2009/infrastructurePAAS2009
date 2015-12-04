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
    private Integer bidderId;

    /**
     * 会员级别，STD标准会员，ADV高级会员
     */
    private String memberLevel;

    /**
     * 会员开始时间
     */
    private Date startTime;

    /**
     * 会员结束时间
     */
    private Date endTime;

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
    public Integer getBidderId() {
        return bidderId;
    }

    /**
     * @param bidderId 
	 *            承包商id
     */
    public void setBidderId(Integer bidderId) {
        this.bidderId = bidderId;
    }

    /**
     * @return 会员级别，STD标准会员，ADV高级会员
     */
    public String getMemberLevel() {
        return memberLevel;
    }

    /**
     * @param memberLevel 
	 *            会员级别，STD标准会员，ADV高级会员
     */
    public void setMemberLevel(String memberLevel) {
        this.memberLevel = memberLevel == null ? null : memberLevel.trim();
    }

    /**
     * @return 会员开始时间
     */
    public Date getStartTime() {
        return startTime;
    }

    /**
     * @param startTime 
	 *            会员开始时间
     */
    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    /**
     * @return 会员结束时间
     */
    public Date getEndTime() {
        return endTime;
    }

    /**
     * @param endTime 
	 *            会员结束时间
     */
    public void setEndTime(Date endTime) {
        this.endTime = endTime;
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
            && (this.getBidderId() == null ? other.getBidderId() == null : this.getBidderId().equals(other.getBidderId()))
            && (this.getMemberLevel() == null ? other.getMemberLevel() == null : this.getMemberLevel().equals(other.getMemberLevel()))
            && (this.getStartTime() == null ? other.getStartTime() == null : this.getStartTime().equals(other.getStartTime()))
            && (this.getEndTime() == null ? other.getEndTime() == null : this.getEndTime().equals(other.getEndTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getBidderId() == null) ? 0 : getBidderId().hashCode());
        result = prime * result + ((getMemberLevel() == null) ? 0 : getMemberLevel().hashCode());
        result = prime * result + ((getStartTime() == null) ? 0 : getStartTime().hashCode());
        result = prime * result + ((getEndTime() == null) ? 0 : getEndTime().hashCode());
        return result;
    }
    /**
     * 是否过期
     * @return
     */
    public boolean isOvertime(){
    	return getEndTime()!=null?getEndTime().before(new Date()):false;
    }
}