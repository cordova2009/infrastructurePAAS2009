package com.hummingbird.paas.entity;

/**
 * 招标设定保证金, 它会设定投标时的保证金,而中标后的保证金由系统判断
 */
public class ObjectBondSetting {
    /**
     * id
     */
    private Integer id;

    /**
     * 标的id
     */
    private String object_id;

    /**
     * 招标方保证金
     */
    private Integer biddee_bond;

    /**
     * 投标方保证金
     */
    private Integer bidder_bid_bond;

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

    /**
     * @return 招标方保证金
     */
    public Integer getBiddee_bond() {
        return biddee_bond;
    }

    /**
     * @param biddeeBond 
	 *            招标方保证金
     */
    public void setBiddee_bond(Integer biddee_bond) {
        this.biddee_bond = biddee_bond;
    }

    /**
     * @return 投标方保证金
     */
    public Integer getBidder_bid_bond() {
        return bidder_bid_bond;
    }

    /**
     * @param bidderBidBond 
	 *            投标方保证金
     */
    public void setBidder_bid_bond(Integer bidder_bid_bond) {
        this.bidder_bid_bond = bidder_bid_bond;
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
        ObjectBondSetting other = (ObjectBondSetting) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getObject_id() == null ? other.getObject_id() == null : this.getObject_id().equals(other.getObject_id()))
            && (this.getBiddee_bond() == null ? other.getBiddee_bond() == null : this.getBiddee_bond().equals(other.getBiddee_bond()))
            && (this.getBidder_bid_bond() == null ? other.getBidder_bid_bond() == null : this.getBidder_bid_bond().equals(other.getBidder_bid_bond()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getObject_id() == null) ? 0 : getObject_id().hashCode());
        result = prime * result + ((getBiddee_bond() == null) ? 0 : getBiddee_bond().hashCode());
        result = prime * result + ((getBidder_bid_bond() == null) ? 0 : getBidder_bid_bond().hashCode());
        return result;
    }
}