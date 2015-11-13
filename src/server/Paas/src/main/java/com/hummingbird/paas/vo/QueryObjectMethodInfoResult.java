package com.hummingbird.paas.vo;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang.ObjectUtils;


/**
 * 查询未完成招标方式接口 结果输出 VO
 */
public class QueryObjectMethodInfoResult
{
    
	    	/**
	     * 
	     */
	    protected String objectMethod;
	    	/**
	     * 
	     */
	    protected List inviteTender;
	
	    	/**
	     * @return 
	     */
	    public String getObjectMethod() {
	        return objectMethod;
	    }
	
	    /**
	     * @param 
	     */
	    public void setObjectMethod(String objectMethod) {
	        this.objectMethod = objectMethod;
	    }
	    	/**
	     * @return 
	     */
	    public List getInviteTender() {
	        return inviteTender;
	    }
	
	    /**
	     * @param 
	     */
	    public void setInviteTender(List inviteTender) {
	        this.inviteTender = inviteTender;
	    }
		

	

    public String toString() {
		return org.apache.commons.lang.builder.ToStringBuilder.reflectionToString(this);
	}

    

}