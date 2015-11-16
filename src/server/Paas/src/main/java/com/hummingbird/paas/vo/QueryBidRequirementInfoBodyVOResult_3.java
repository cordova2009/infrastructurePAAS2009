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
public class QueryBidRequirementInfoBodyVOResult_3
{
    	    	/**
	     * 
	     */
	    protected String bankGuaranteeAmount;
	    	/**
	     * 
	     */
	    protected String bankGuaranteeUrl;
	    	/**
	     * 
	     */
	    protected String bankGuaranteeNo;
	
	    	/**
	     * @return 
	     */
	    public String getBankGuaranteeAmount() {
	        return bankGuaranteeAmount;
	    }
	
	    /**
	     * @param 
	     */
	    public void setBankGuaranteeAmount(String bankGuaranteeAmount) {
	        this.bankGuaranteeAmount = bankGuaranteeAmount;
	    }
	    	/**
	     * @return 
	     */
	    public String getBankGuaranteeUrl() {
	        return bankGuaranteeUrl;
	    }
	
	    /**
	     * @param 
	     */
	    public void setBankGuaranteeUrl(String bankGuaranteeUrl) {
	        this.bankGuaranteeUrl = bankGuaranteeUrl;
	    }
	    	/**
	     * @return 
	     */
	    public String getBankGuaranteeNo() {
	        return bankGuaranteeNo;
	    }
	
	    /**
	     * @param 
	     */
	    public void setBankGuaranteeNo(String bankGuaranteeNo) {
	        this.bankGuaranteeNo = bankGuaranteeNo;
	    }
	
    public String toString() {
		return org.apache.commons.lang.builder.ToStringBuilder.reflectionToString(this);
	}

    

}