package com.hummingbird.paas.vo;

import java.util.Date;
import org.apache.commons.lang.ObjectUtils;

import com.hummingbird.common.util.ValidateUtil;
import com.hummingbird.common.vo.PainttextAble;

/**
 * 保存招标时间要求 在body VO
 */
public class SaveDateRequirementInfoBodyVO 
implements PainttextAble {
    
	    	/**
	     * 
	     */
	    protected String token;
	    	/**
	     * 招标项目内部编号
	     */
	    protected String objectId;
	    	/**
	     * 公告开始时间
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
	    public String getToken() {
	        return token;
	    }
	
	    /**
	     * @param 
	     */
	    public void setToken(String token) {
	        this.token = token;
	    }
	    	/**
	     * @return 招标项目内部编号
	     */
	    public String getObjectId() {
	        return objectId;
	    }
	
	    /**
	     * @param 招标项目内部编号
	     */
	    public void setObjectId(String objectId) {
	        this.objectId = objectId;
	    }
	    	/**
	     * @return 公告开始时间
	     */
	    public String getAnnouncementBeginTime() {
	        return announcementBeginTime;
	    }
	
	    /**
	     * @param 公告开始时间
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
		
	/**
	 * 生成文本组装内容
	 * @return
	 */
	public String getPaintText(){
		String pt = ValidateUtil.sortbyValues(
					ObjectUtils.toString(token) , 					ObjectUtils.toString(objectId) , 					ObjectUtils.toString(announcementBeginTime) , 					ObjectUtils.toString(announcementEndTime) , 					ObjectUtils.toString(biddingEndTime) , 					ObjectUtils.toString(bidOpenDate) 				);
		return pt;
	}
	

    public String toString() {
		return org.apache.commons.lang.builder.ToStringBuilder.reflectionToString(this);
	}

    

}