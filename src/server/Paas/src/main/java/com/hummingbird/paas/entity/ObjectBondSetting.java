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
    private String objectId;

    /**
     * 招标方保证金
     */
    private Long biddeeBond;

    /**
     * 投标方保证金
     */
    private Long bidderBidBond;

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

    /**
     * @return 招标方保证金
     */
    public Long getBiddeeBond() {
        return biddeeBond;
    }

    /**
     * @param biddeeBond 
	 *            招标方保证金
     */
    public void setBiddeeBond(Long biddeeBond) {
        this.biddeeBond = biddeeBond;
    }

    /**
     * @return 投标方保证金
     */
    public Long getBidderBidBond() {
        return bidderBidBond;
    }

    /**
     * @param bidderBidBond 
	 *            投标方保证金
     */
    public void setBidderBidBond(Long bidderBidBond) {
        this.bidderBidBond = bidderBidBond;
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
            && (this.getObjectId() == null ? other.getObjectId() == null : this.getObjectId().equals(other.getObjectId()))
            && (this.getBiddeeBond() == null ? other.getBiddeeBond() == null : this.getBiddeeBond().equals(other.getBiddeeBond()))
            && (this.getBidderBidBond() == null ? other.getBidderBidBond() == null : this.getBidderBidBond().equals(other.getBidderBidBond()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getObjectId() == null) ? 0 : getObjectId().hashCode());
        result = prime * result + ((getBiddeeBond() == null) ? 0 : getBiddeeBond().hashCode());
        result = prime * result + ((getBidderBidBond() == null) ? 0 : getBidderBidBond().hashCode());
        return result;
    }
}