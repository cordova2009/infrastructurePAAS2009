package com.hummingbird.paas.vo;

import java.util.Date;
import org.apache.commons.lang.ObjectUtils;


/**
 * 查询未完成招标项目保证金接口 结果输出 VO
 */
public class QueryObjectBondInfoResult
{
    
	    	/**
	     * 
	     */
	    protected String bidBondAmount;
	
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
		

	

    public String toString() {
		return org.apache.commons.lang.builder.ToStringBuilder.reflectionToString(this);
	}

    

}