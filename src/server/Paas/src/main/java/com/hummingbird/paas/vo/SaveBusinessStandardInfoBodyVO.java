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
 * 保存投标的商务标信息接口 在body VO
 */
public class SaveBusinessStandardInfoBodyVO
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
	     * 
	     */
	    protected String bidAmount;
	    	/**
	     * 项目报价表附件地址
	     */
	    protected String projectQuotationUrl;
	    	/**
	     * 施工承诺函开始时间
	     */
	    protected String constructionStartDate;
	    	/**
	     * 施工承诺函结束时间
	     */
	    protected String constructionEndDate;
	    	/**
	     * 施工承诺函扫描件地址
	     */
	    protected String constructionCommitmentUrl;
	
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
	     * @return 
	     */
	    public String getBidAmount() {
	        return bidAmount;
	    }
	
	    /**
	     * @param 
	     */
	    public void setBidAmount(String bidAmount) {
	        this.bidAmount = bidAmount;
	    }
	    	/**
	     * @return 项目报价表附件地址
	     */
	    public String getProjectQuotationUrl() {
	        return projectQuotationUrl;
	    }
	
	    /**
	     * @param 项目报价表附件地址
	     */
	    public void setProjectQuotationUrl(String projectQuotationUrl) {
	        this.projectQuotationUrl = projectQuotationUrl;
	    }
	    	/**
	     * @return 施工承诺函开始时间
	     */
	    public String getConstructionStartDate() {
	        return constructionStartDate;
	    }
	
	    /**
	     * @param 施工承诺函开始时间
	     */
	    public void setConstructionStartDate(String constructionStartDate) {
	        this.constructionStartDate = constructionStartDate;
	    }
	    	/**
	     * @return 施工承诺函结束时间
	     */
	    public String getConstructionEndDate() {
	        return constructionEndDate;
	    }
	
	    /**
	     * @param 施工承诺函结束时间
	     */
	    public void setConstructionEndDate(String constructionEndDate) {
	        this.constructionEndDate = constructionEndDate;
	    }
	    	/**
	     * @return 施工承诺函扫描件地址
	     */
	    public String getConstructionCommitmentUrl() {
	        return constructionCommitmentUrl;
	    }
	
	    /**
	     * @param 施工承诺函扫描件地址
	     */
	    public void setConstructionCommitmentUrl(String constructionCommitmentUrl) {
	        this.constructionCommitmentUrl = constructionCommitmentUrl;
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
							   
							ObjectUtils.toString(bidAmount) ,
							   
							ObjectUtils.toString(projectQuotationUrl) ,
							   
							ObjectUtils.toString(constructionStartDate) ,
							   
							ObjectUtils.toString(constructionEndDate) ,
							   
							ObjectUtils.toString(constructionCommitmentUrl) 
							);
		return pt;
	}
	

    public String toString() {
		return org.apache.commons.lang.builder.ToStringBuilder.reflectionToString(this);
	}

    

}