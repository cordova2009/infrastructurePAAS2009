package com.hummingbird.paas.vo;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;
import org.apache.commons.lang.ObjectUtils;

import com.hummingbird.common.util.ValidateUtil;
import com.hummingbird.common.vo.PainttextAble;

/**
 * 提交撮合投标保证金信息接口 在body VO
 */
public class SaveMakeMatchBidderBondBodyVO
implements PainttextAble {

    	    	/**
	     * 
	     */
	    protected String token;
	    	/**
	     * 投标记录编号
	     */
	    protected Integer bidId;
	    	/**
	     * 招标项目内部编号
	     */
	    protected String objectId;
	    	/**
	     * 撮合保证金,单位分
	     */
	    protected Integer makeMatchBidderBondAmount;
	
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
	     * @return 投标记录编号
	     */
	    public Integer getBidId() {
	        return bidId;
	    }
	
	    /**
	     * @param 投标记录编号
	     */
	    public void setBidId(Integer bidId) {
	        this.bidId = bidId;
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
	     * @return 撮合保证金,单位分
	     */
	    public Integer getMakeMatchBidderBondAmount() {
	        return makeMatchBidderBondAmount;
	    }
	
	    /**
	     * @param 撮合保证金,单位分
	     */
	    public void setMakeMatchBidderBondAmount(Integer makeMatchBidderBondAmount) {
	        this.makeMatchBidderBondAmount = makeMatchBidderBondAmount;
	    }
		
	/**
	 * 生成文本组装内容
	 * @return
	 */
	public String getPaintText(){
		String pt = ValidateUtil.sortbyValues(
				   
							ObjectUtils.toString(token) ,
							   
							ObjectUtils.toString(bidId) ,
							   
							ObjectUtils.toString(objectId) ,
							   
							ObjectUtils.toString(makeMatchBidderBondAmount) 
							);
		return pt;
	}
	

    public String toString() {
		return org.apache.commons.lang.builder.ToStringBuilder.reflectionToString(this);
	}

    

}