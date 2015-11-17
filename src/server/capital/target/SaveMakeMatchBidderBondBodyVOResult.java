package com.hummingbird.paas.vo;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;
import org.apache.commons.lang.ObjectUtils;


/**
 * 提交撮合投标保证金信息接口 结果输出 VO
 */
public class SaveMakeMatchBidderBondBodyVOResult
{
    	    	/**
	     * 
	     */
	    protected String makeMatchBidderBondAmount;
	    	/**
	     * 账户余额是否足够，"YES"足够，"NO#"不够
	     */
	    protected String satisfy;
	
	    	/**
	     * @return 
	     */
	    public String getMakeMatchBidderBondAmount() {
	        return makeMatchBidderBondAmount;
	    }
	
	    /**
	     * @param 
	     */
	    public void setMakeMatchBidderBondAmount(String makeMatchBidderBondAmount) {
	        this.makeMatchBidderBondAmount = makeMatchBidderBondAmount;
	    }
	    	/**
	     * @return 账户余额是否足够，"YES"足够，"NO#"不够
	     */
	    public String getSatisfy() {
	        return satisfy;
	    }
	
	    /**
	     * @param 账户余额是否足够，"YES"足够，"NO#"不够
	     */
	    public void setSatisfy(String satisfy) {
	        this.satisfy = satisfy;
	    }
	
    public String toString() {
		return org.apache.commons.lang.builder.ToStringBuilder.reflectionToString(this);
	}

    

}