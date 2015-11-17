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
    private String receivedAmount;

    /**
     * dai收款
     */
    private String willReceiveAmount;

	/**
	 * @return the receivedAmount
	 */
	public String getReceivedAmount() {
		return receivedAmount;
	}

	/**
	 * @return the willReceiveAmount
	 */
	public String getWillReceiveAmount() {
		return willReceiveAmount;
	}

	/**
	 * @param receivedAmount the receivedAmount to set
	 */
	public void setReceivedAmount(String receivedAmount) {
		this.receivedAmount = receivedAmount;
	}

	/**
	 * @param willReceiveAmount the willReceiveAmount to set
	 */
	public void setWillReceiveAmount(String willReceiveAmount) {
		this.willReceiveAmount = willReceiveAmount;
	}

    
}