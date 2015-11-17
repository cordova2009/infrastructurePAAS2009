package com.hummingbird.paas.vo;

import java.util.Date;

import com.hummingbird.paas.entity.ObjectProject;

/**
 * 标的工程表
 */
public class MyLoseObjectProject extends ObjectProject{
	 /**
     * 招标人
     */
    private String biddee;

	/**
	 * @return the biddee
	 */
	public String getBiddee() {
		return biddee;
	}

	/**
	 * @param biddee the biddee to set
	 */
	public void setBiddee(String biddee) {
		this.biddee = biddee;
	}

    
}