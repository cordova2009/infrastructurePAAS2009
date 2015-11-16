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
public class QueryBidRequirementInfoBodyVOResult
{
    	    	/**
	     * 
	     */
	    protected List<Integer> certificationList;
	    	/**
	     * 
	     */
	    protected QueryBidRequirementInfoBodyVOResult_1 bidSafetyInfo;
	    	/**
	     * 
	     */
	    protected QueryBidRequirementInfoBodyVOResult_2 bidPeopleRequirement;
	    	/**
	     * 
	     */
	    protected QueryBidRequirementInfoBodyVOResult_3 bankGuarantee;
	
	    	/**
	     * @return 
	     */
	    public List<Integer> getCertificationList() {
	        return certificationList;
	    }
	
	    /**
	     * @param 
	     */
	    public void setCertificationList(List<Integer> certificationList) {
	        this.certificationList = certificationList;
	    }
	    	/**
	     * @return 
	     */
	    public QueryBidRequirementInfoBodyVOResult_1 getBidSafetyInfo() {
	        return bidSafetyInfo;
	    }
	
	    /**
	     * @param 
	     */
	    public void setBidSafetyInfo(QueryBidRequirementInfoBodyVOResult_1 bidSafetyInfo) {
	        this.bidSafetyInfo = bidSafetyInfo;
	    }
	    	/**
	     * @return 
	     */
	    public QueryBidRequirementInfoBodyVOResult_2 getBidPeopleRequirement() {
	        return bidPeopleRequirement;
	    }
	
	    /**
	     * @param 
	     */
	    public void setBidPeopleRequirement(QueryBidRequirementInfoBodyVOResult_2 bidPeopleRequirement) {
	        this.bidPeopleRequirement = bidPeopleRequirement;
	    }
	    	/**
	     * @return 
	     */
	    public QueryBidRequirementInfoBodyVOResult_3 getBankGuarantee() {
	        return bankGuarantee;
	    }
	
	    /**
	     * @param 
	     */
	    public void setBankGuarantee(QueryBidRequirementInfoBodyVOResult_3 bankGuarantee) {
	        this.bankGuarantee = bankGuarantee;
	    }
	
    public String toString() {
		return org.apache.commons.lang.builder.ToStringBuilder.reflectionToString(this);
	}

    

}