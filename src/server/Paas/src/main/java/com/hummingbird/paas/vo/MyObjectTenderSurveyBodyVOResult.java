package com.hummingbird.paas.vo;

import java.util.Date;
import org.apache.commons.lang.ObjectUtils;


/**
 * 我的招标评标概况接口 结果输出 VO
 */
public class MyObjectTenderSurveyBodyVOResult
{
    
	    	/**
	     * 
	     */
	    protected Integer bidderNum;
	    	/**
	     * 标的名称
	     */
	    protected String objectName;
	    	/**
	     * 最高投标金额
	     */
	    protected String maxBidAmount;
	    	/**
	     * 最低投标金额
	     */
	    protected String minBidAmount;
	
	    	/**
	     * @return 
	     */
	    public Integer getBidderNum() {
	        return bidderNum;
	    }
	
	    /**
	     * @param 
	     */
	    public void setBidderNum(Integer bidderNum) {
	        this.bidderNum = bidderNum;
	    }
	    	/**
	     * @return 标的名称
	     */
	    public String getObjectName() {
	        return objectName;
	    }
	
	    /**
	     * @param 标的名称
	     */
	    public void setObjectName(String objectName) {
	        this.objectName = objectName;
	    }
	    	/**
	     * @return 最高投标金额
	     */
	    public String getMaxBidAmount() {
	        return maxBidAmount;
	    }
	
	    /**
	     * @param 最高投标金额
	     */
	    public void setMaxBidAmount(String maxBidAmount) {
	        this.maxBidAmount = maxBidAmount;
	    }
	    	/**
	     * @return 最低投标金额
	     */
	    public String getMinBidAmount() {
	        return minBidAmount;
	    }
	
	    /**
	     * @param 最低投标金额
	     */
	    public void setMinBidAmount(String minBidAmount) {
	        this.minBidAmount = minBidAmount;
	    }
		

	

    public String toString() {
		return org.apache.commons.lang.builder.ToStringBuilder.reflectionToString(this);
	}

    

}