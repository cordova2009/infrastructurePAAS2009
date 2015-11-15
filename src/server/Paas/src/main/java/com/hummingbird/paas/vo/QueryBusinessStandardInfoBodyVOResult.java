package com.hummingbird.paas.vo;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;
import org.apache.commons.lang.ObjectUtils;


/**
 * 查询未完成投标的商务标信息接口 结果输出 VO
 */
public class QueryBusinessStandardInfoBodyVOResult
{
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
	
    public String toString() {
		return org.apache.commons.lang.builder.ToStringBuilder.reflectionToString(this);
	}

    

}