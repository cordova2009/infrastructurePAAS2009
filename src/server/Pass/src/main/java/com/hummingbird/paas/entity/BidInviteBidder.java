package com.hummingbird.paas.entity;

/**
 * 邀请招标表,记录邀请招标时的投标方
 */
public class BidInviteBidder {
    /**
     * id
     */
    private Integer id;

    /**
     * 投标人
     */
    private Integer bidder_id;

    /**
     * 标的id
     */
    private String object_id;

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
     * @return 投标人
     */
    public Integer getBidder_id() {
        return bidder_id;
    }

    /**
     * @param bidderId 
	 *            投标人
     */
    public void setBidder_id(Integer bidder_id) {
        this.bidder_id = bidder_id;
    }

    /**
     * @return 标的id
     */
    public String getObject_id() {
        return object_id;
    }

    /**
     * @param objectId 
	 *            标的id
     */
    public void setObject_id(String object_id) {
        this.object_id = object_id == null ? null : object_id.trim();
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
        BidInviteBidder other = (BidInviteBidder) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getBidder_id() == null ? other.getBidder_id() == null : this.getBidder_id().equals(other.getBidder_id()))
            && (this.getObject_id() == null ? other.getObject_id() == null : this.getObject_id().equals(other.getObject_id()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getBidder_id() == null) ? 0 : getBidder_id().hashCode());
        result = prime * result + ((getObject_id() == null) ? 0 : getObject_id().hashCode());
        return result;
    }
}