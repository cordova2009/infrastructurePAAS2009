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
public class QueryBidRequirementInfoBodyVOResult_1
{
    	    	/**
	     * 
	     */
	    protected String safetyPermitNo;
	    	/**
	     * 
	     */
	    protected String safetyPermitEndDate;
	    	/**
	     * 
	     */
	    protected String safetyPermitUrl;
	    	/**
	     * 
	     */
	    protected String pmSafetyCertificationNo;
	    	/**
	     * 
	     */
	    protected String pmSafetyCertificationEndDate;
	    	/**
	     * 
	     */
	    protected String pmSafetyCertificationUrl;
	
	    	/**
	     * @return 
	     */
	    public String getSafetyPermitNo() {
	        return safetyPermitNo;
	    }
	
	    /**
	     * @param 
	     */
	    public void setSafetyPermitNo(String safetyPermitNo) {
	        this.safetyPermitNo = safetyPermitNo;
	    }
	    	/**
	     * @return 
	     */
	    public String getSafetyPermitEndDate() {
	        return safetyPermitEndDate;
	    }
	
	    /**
	     * @param 
	     */
	    public void setSafetyPermitEndDate(String safetyPermitEndDate) {
	        this.safetyPermitEndDate = safetyPermitEndDate;
	    }
	    	/**
	     * @return 
	     */
	    public String getSafetyPermitUrl() {
	        return safetyPermitUrl;
	    }
	
	    /**
	     * @param 
	     */
	    public void setSafetyPermitUrl(String safetyPermitUrl) {
	        this.safetyPermitUrl = safetyPermitUrl;
	    }
	    	/**
	     * @return 
	     */
	    public String getPmSafetyCertificationNo() {
	        return pmSafetyCertificationNo;
	    }
	
	    /**
	     * @param 
	     */
	    public void setPmSafetyCertificationNo(String pmSafetyCertificationNo) {
	        this.pmSafetyCertificationNo = pmSafetyCertificationNo;
	    }
	    	/**
	     * @return 
	     */
	    public String getPmSafetyCertificationEndDate() {
	        return pmSafetyCertificationEndDate;
	    }
	
	    /**
	     * @param 
	     */
	    public void setPmSafetyCertificationEndDate(String pmSafetyCertificationEndDate) {
	        this.pmSafetyCertificationEndDate = pmSafetyCertificationEndDate;
	    }
	    	/**
	     * @return 
	     */
	    public String getPmSafetyCertificationUrl() {
	        return pmSafetyCertificationUrl;
	    }
	
	    /**
	     * @param 
	     */
	    public void setPmSafetyCertificationUrl(String pmSafetyCertificationUrl) {
	        this.pmSafetyCertificationUrl = pmSafetyCertificationUrl;
	    }
	
    public String toString() {
		return org.apache.commons.lang.builder.ToStringBuilder.reflectionToString(this);
	}

    

}