package com.hummingbird.paas.vo;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;
import org.apache.commons.lang.ObjectUtils;


/**
 * 查询撮合投标保证金接口 结果输出 VO
 */
public class QueryMakeMatchBidderBondBodyVOResult
{
    	    	/**
	     * 
	     */
	    protected String makeMatchBidderBondAmount;
	    	/**
	     * 保证金状态,PAY 已缴纳, "ENH" 未缴纳,且帐户余额足够，"NEN"未缴纳,且帐户余额不足
	     */
	    protected String satisfy;
	
	    	/**
	     * @return 
	     */
	    public String getMakeMatchBidderBondAmount() {
	        return makeMatchBidderBondAmount;
	    }
	
	    /**
	     * 
	     * @param 
	     */
	    public void setMakeMatchBidderBondAmount(String makeMatchBidderBondAmount) {
	        this.makeMatchBidderBondAmount = makeMatchBidderBondAmount;
	    }
	    	/**
	     * @return 保证金状态,PAY 已缴纳, "ENH" 未缴纳,且帐户余额足够，"NEN"未缴纳,且帐户余额不足
	     */
	    public String getSatisfy() {
	        return satisfy;
	    }
	
	    /**
	     * @param 保证金状态,PAY 已缴纳, "ENH" 未缴纳,且帐户余额足够，"NEN"未缴纳,且帐户余额不足
	     */
	    public void setSatisfy(String satisfy) {
	        this.satisfy = satisfy;
	    }
	
    public String toString() {
		return org.apache.commons.lang.builder.ToStringBuilder.reflectionToString(this);
	}

    

}