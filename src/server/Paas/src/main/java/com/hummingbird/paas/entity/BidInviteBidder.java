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
    private Integer bidderId;

    /**
     * 标的id
     */
    private String objectId;
    
    /**
     * 投标人名称 
     */
    private String bidderName;

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
    public Integer getBidderId() {
        return bidderId;
    }

    /**
     * @param bidderId 
	 *            投标人
     */
    public void setBidderId(Integer bidderId) {
        this.bidderId = bidderId;
    }

    /**
     * @return 标的id
     */
    public String getObjectId() {
        return objectId;
    }

    /**
     * @param objectId 
	 *            标的id
     */
    public void setObjectId(String objectId) {
        this.objectId = objectId == null ? null : objectId.trim();
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
            && (this.getBidderId() == null ? other.getBidderId() == null : this.getBidderId().equals(other.getBidderId()))
            && (this.getObjectId() == null ? other.getObjectId() == null : this.getObjectId().equals(other.getObjectId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getBidderId() == null) ? 0 : getBidderId().hashCode());
        result = prime * result + ((getObjectId() == null) ? 0 : getObjectId().hashCode());
        return result;
    }

	/**
	 * 投标人名称 
	 */
	public String getBidderName() {
		return bidderName;
	}

	/**
	 * 投标人名称 
	 */
	public void setBidderName(String bidderName) {
		this.bidderName = bidderName;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "BidInviteBidder [id=" + id + ", bidderId=" + bidderId + ", objectId=" + objectId + ", bidderName="
				+ bidderName + "]";
	}
}