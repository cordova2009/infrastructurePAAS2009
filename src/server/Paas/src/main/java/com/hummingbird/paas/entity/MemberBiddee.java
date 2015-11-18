package com.hummingbird.paas.entity;

import java.util.Date;

/**
 * 发包方会员表
 */
public class MemberBiddee {
    /**
     * 会员id
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
        MemberBiddee other = (MemberBiddee) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getTenderer_id() == null ? other.getTenderer_id() == null : this.getTenderer_id().equals(other.getTenderer_id()))
            && (this.getMember_level() == null ? other.getMember_level() == null : this.getMember_level().equals(other.getMember_level()))
            && (this.getStart_time() == null ? other.getStart_time() == null : this.getStart_time().equals(other.getStart_time()))
            && (this.getEnd_time() == null ? other.getEnd_time() == null : this.getEnd_time().equals(other.getEnd_time()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getTenderer_id() == null) ? 0 : getTenderer_id().hashCode());
        result = prime * result + ((getMember_level() == null) ? 0 : getMember_level().hashCode());
        result = prime * result + ((getStart_time() == null) ? 0 : getStart_time().hashCode());
        result = prime * result + ((getEnd_time() == null) ? 0 : getEnd_time().hashCode());
        return result;
    }
}