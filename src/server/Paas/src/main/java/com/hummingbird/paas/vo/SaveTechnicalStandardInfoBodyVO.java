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
 * 保存投标的技术标信息接口 在body VO
 */
public class SaveTechnicalStandardInfoBodyVO
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
	     * 投标记录编号
	     */
	    protected Integer bidId;
	    	/**
	     * 技术标书上传地址
	     */
	    protected String technicalStandardUrl;
	
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
	     * @return 技术标书上传地址
	     */
	    public String getTechnicalStandardUrl() {
	        return technicalStandardUrl;
	    }
	
	    /**
	     * @param 技术标书上传地址
	     */
	    public void setTechnicalStandardUrl(String technicalStandardUrl) {
	        this.technicalStandardUrl = technicalStandardUrl;
	    }
		
	/**
	 * 生成文本组装内容
	 * @return
	 */
	public String getPaintText(){
		String pt = ValidateUtil.sortbyValues(
				   
							ObjectUtils.toString(token) ,
							   
							ObjectUtils.toString(objectId) ,
							   
							ObjectUtils.toString(bidId) ,
							   
							ObjectUtils.toString(technicalStandardUrl) 
							);
		return pt;
	}
	

    public String toString() {
		return org.apache.commons.lang.builder.ToStringBuilder.reflectionToString(this);
	}

    

}