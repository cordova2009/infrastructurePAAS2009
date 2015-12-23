package com.hummingbird.paas.vo;

import java.util.Date;

import com.hummingbird.paas.entity.ObjectProject;

/**
 * 标的工程表
 */
public class MyBuildingObjectProject extends ObjectProject{
    /**
     * 已收款
     */
    private Long receivedAmount;

    /**
     * dai收款
     */
    private Long willReceiveAmount;

	/**
	 * @return the receivedAmount
	 */
	public Long getReceivedAmount() {
		return receivedAmount;
	}

	/**
	 * @return the willReceiveAmount
	 */
	public Long getWillReceiveAmount() {
		return willReceiveAmount;
	}

	/**
	 * @param receivedAmount the receivedAmount to set
	 */
	public void setReceivedAmount(Long receivedAmount) {
		this.receivedAmount = receivedAmount;
	}

	/**
	 * @param willReceiveAmount the willReceiveAmount to set
	 */
	public void setWillReceiveAmount(Long willReceiveAmount) {
		this.willReceiveAmount = willReceiveAmount;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "MyBuildingObjectProject [receivedAmount=" + receivedAmount + ", willReceiveAmount=" + willReceiveAmount
				+ "]";
	}

	
    
}