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
 * 查询投标类在body VO
 */
public class SubmitBidBodyVO 
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
	     * 投标文件
	     */
	    protected String bidFile;
	
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
	 * 生成文本组装内容
	 * @return
	 */
	public String getPaintText(){
		String pt = ValidateUtil.sortbyValues(
				   
							ObjectUtils.toString(token) ,
							   
							ObjectUtils.toString(bidId) ,
							ObjectUtils.toString(bidFile) ,
							   
							ObjectUtils.toString(objectId) 
							);
		return pt;
	}
	

    public String toString() {
		return org.apache.commons.lang.builder.ToStringBuilder.reflectionToString(this);
	}

	/**
	 * 投标文件 
	 */
	public String getBidFile() {
		return bidFile;
	}

	/**
	 * 投标文件 
	 */
	public void setBidFile(String bidFile) {
		this.bidFile = bidFile;
	}

    

}