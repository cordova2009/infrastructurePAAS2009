package com.hummingbird.paas.vo;

/**
 * 投标资质表
 */
public class SaveBidRequirementInfoBodyVO_4 {

    /**
     * 投标id
     */
    private Integer bidId;

    /**
     * 招标资质要求id
     */
    private Integer objReqId;

    /**
     * 投标资质证书id
     */
    private Integer bidderCertificationId;


    /**
     * @return 投标id
     */
    public Integer getBidId() {
        return bidId;
    }

    /**
     * @param bidId 
	 *            投标id
     */
    public void setBidId(Integer bidId) {
        this.bidId = bidId;
    }


    


	/**
	 * 招标资质要求id 
	 */
	public Integer getObjReqId() {
		return objReqId;
	}

	/**
	 * 招标资质要求id 
	 */
	public void setObjReqId(Integer objReqId) {
		this.objReqId = objReqId;
	}

	/**
	 * 投标资质证书id 
	 */
	public Integer getBidderCertificationId() {
		return bidderCertificationId;
	}

	/**
	 * 投标资质证书id 
	 */
	public void setBidderCertificationId(Integer bidderCertificationId) {
		this.bidderCertificationId = bidderCertificationId;
	}
}