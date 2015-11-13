package com.hummingbird.paas.vo;

import java.util.Date;
import org.apache.commons.lang.ObjectUtils;


/**
 * 查询未完成招标时间要求接口 结果输出 VO
 */
public class QueryDateRequirementInfoBodyVOResult
{
    
	    	/**
	     * 
	     */
	    protected String announcementBeginTime;
	    	/**
	     * 公告结束时间
	     */
	    protected String announcementEndTime;
	    	/**
	     * 投标截止时间
	     */
	    protected String biddingEndTime;
	    	/**
	     * 开标时间
	     */
	    protected String bidOpenDate;
	
	    	/**
	     * @return 
	     */
	    public String getAnnouncementBeginTime() {
	        return announcementBeginTime;
	    }
	
	    /**
	     * @param 
	     */
	    public void setAnnouncementBeginTime(String announcementBeginTime) {
	        this.announcementBeginTime = announcementBeginTime;
	    }
	    	/**
	     * @return 公告结束时间
	     */
	    public String getAnnouncementEndTime() {
	        return announcementEndTime;
	    }
	
	    /**
	     * @param 公告结束时间
	     */
	    public void setAnnouncementEndTime(String announcementEndTime) {
	        this.announcementEndTime = announcementEndTime;
	    }
	    	/**
	     * @return 投标截止时间
	     */
	    public String getBiddingEndTime() {
	        return biddingEndTime;
	    }
	
	    /**
	     * @param 投标截止时间
	     */
	    public void setBiddingEndTime(String biddingEndTime) {
	        this.biddingEndTime = biddingEndTime;
	    }
	    	/**
	     * @return 开标时间
	     */
	    public String getBidOpenDate() {
	        return bidOpenDate;
	    }
	
	    /**
	     * @param 开标时间
	     */
	    public void setBidOpenDate(String bidOpenDate) {
	        this.bidOpenDate = bidOpenDate;
	    }
		

	

    public String toString() {
		return org.apache.commons.lang.builder.ToStringBuilder.reflectionToString(this);
	}

    

}