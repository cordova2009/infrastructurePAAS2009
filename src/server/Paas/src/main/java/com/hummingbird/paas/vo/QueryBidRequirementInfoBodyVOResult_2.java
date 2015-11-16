package com.hummingbird.paas.vo;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;
import org.apache.commons.lang.ObjectUtils;


/**
 * 查询未完成的投标资格审查信息接口 结果输出 VO
 */
public class QueryBidRequirementInfoBodyVOResult_2
{
    	    	/**
	     * 
	     */
	    protected String pmCertificationNo;
	    	/**
	     * 
	     */
	    protected String pmCertificationEndDate;
	    	/**
	     * 
	     */
	    protected String pmCertificationUrl;
	    	/**
	     * 
	     */
	    protected String constructorCertificationNo;
	    	/**
	     * 
	     */
	    protected String constructorCertificationEndDate;
	    	/**
	     * 
	     */
	    protected String constructorCertificationUrl;
	
	    	/**
	     * @return 
	     */
	    public String getPmCertificationNo() {
	        return pmCertificationNo;
	    }
	
	    /**
	     * @param 
	     */
	    public void setPmCertificationNo(String pmCertificationNo) {
	        this.pmCertificationNo = pmCertificationNo;
	    }
	    	/**
	     * @return 
	     */
	    public String getPmCertificationEndDate() {
	        return pmCertificationEndDate;
	    }
	
	    /**
	     * @param 
	     */
	    public void setPmCertificationEndDate(String pmCertificationEndDate) {
	        this.pmCertificationEndDate = pmCertificationEndDate;
	    }
	    	/**
	     * @return 
	     */
	    public String getPmCertificationUrl() {
	        return pmCertificationUrl;
	    }
	
	    /**
	     * @param 
	     */
	    public void setPmCertificationUrl(String pmCertificationUrl) {
	        this.pmCertificationUrl = pmCertificationUrl;
	    }
	    	/**
	     * @return 
	     */
	    public String getConstructorCertificationNo() {
	        return constructorCertificationNo;
	    }
	
	    /**
	     * @param 
	     */
	    public void setConstructorCertificationNo(String constructorCertificationNo) {
	        this.constructorCertificationNo = constructorCertificationNo;
	    }
	    	/**
	     * @return 
	     */
	    public String getConstructorCertificationEndDate() {
	        return constructorCertificationEndDate;
	    }
	
	    /**
	     * @param 
	     */
	    public void setConstructorCertificationEndDate(String constructorCertificationEndDate) {
	        this.constructorCertificationEndDate = constructorCertificationEndDate;
	    }
	    	/**
	     * @return 
	     */
	    public String getConstructorCertificationUrl() {
	        return constructorCertificationUrl;
	    }
	
	    /**
	     * @param 
	     */
	    public void setConstructorCertificationUrl(String constructorCertificationUrl) {
	        this.constructorCertificationUrl = constructorCertificationUrl;
	    }
	
    public String toString() {
		return org.apache.commons.lang.builder.ToStringBuilder.reflectionToString(this);
	}

    

}