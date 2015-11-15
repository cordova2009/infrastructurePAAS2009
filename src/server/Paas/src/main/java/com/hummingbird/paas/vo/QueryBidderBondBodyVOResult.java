package com.hummingbird.paas.vo;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;
import org.apache.commons.lang.ObjectUtils;


/**
 * 查询投标保证金信息接口 结果输出 VO
 */
public class QueryBidderBondBodyVOResult
{
    	    	/**
	     * 
	     */
	    protected String bidBondAmount;
	    	/**
	     * 保函编号
	     */
	    protected String bankGuaranteeNo;
	    	/**
	     * 保函附件
	     */
	    protected String bankGuaranteeUrl;
	    	/**
	     * 保函金额
	     */
	    protected String bankGuaranteeAmount;
	
	    	/**
	     * @return 
	     */
	    public String getBidBondAmount() {
	        return bidBondAmount;
	    }
	
	    /**
	     * @param 
	     */
	    public void setBidBondAmount(String bidBondAmount) {
	        this.bidBondAmount = bidBondAmount;
	    }
	    	/**
	     * @return 保函编号
	     */
	    public String getBankGuaranteeNo() {
	        return bankGuaranteeNo;
	    }
	
	    /**
	     * @param 保函编号
	     */
	    public void setBankGuaranteeNo(String bankGuaranteeNo) {
	        this.bankGuaranteeNo = bankGuaranteeNo;
	    }
	    	/**
	     * @return 保函附件
	     */
	    public String getBankGuaranteeUrl() {
	        return bankGuaranteeUrl;
	    }
	
	    /**
	     * @param 保函附件
	     */
	    public void setBankGuaranteeUrl(String bankGuaranteeUrl) {
	        this.bankGuaranteeUrl = bankGuaranteeUrl;
	    }
	    	/**
	     * @return 保函金额
	     */
	    public String getBankGuaranteeAmount() {
	        return bankGuaranteeAmount;
	    }
	
	    /**
	     * @param 保函金额
	     */
	    public void setBankGuaranteeAmount(String bankGuaranteeAmount) {
	        this.bankGuaranteeAmount = bankGuaranteeAmount;
	    }
	
    public String toString() {
		return org.apache.commons.lang.builder.ToStringBuilder.reflectionToString(this);
	}

    

}