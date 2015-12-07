package com.hummingbird.paas.vo;

import java.util.Date;

import com.hummingbird.paas.entity.ObjectProject;

/**
 * 标的工程表
 */
public class MyEndedObjectProject extends ObjectProject{
	
    /**
     * 招标人名称
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

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "MyEndedObjectProject [biddee=" + biddee + "]";
	}
	
    

    
}