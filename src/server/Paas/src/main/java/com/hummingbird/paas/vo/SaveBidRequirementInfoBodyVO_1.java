package com.hummingbird.paas.vo;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;
import org.apache.commons.lang.ObjectUtils;

import com.hummingbird.common.util.ValidateUtil;
import com.hummingbird.common.vo.PainttextAble;

/**
 * 保存投标资格审查信息接口 在body VO
 */
public class SaveBidRequirementInfoBodyVO_1
implements PainttextAble {

    	    	/**
	     * 
	     */
	    protected String needSafetyPermitNo;
	    	/**
	     * 
	     */
	    protected String needSafetyPermitEndDate;
	    	/**
	     * 
	     */
	    protected String needSafetyPermitUrl;
	    	/**
	     * 
	     */
	    protected String needPmSafetyCertificationNo;
	    	/**
	     * 
	     */
	    protected String needPmSafetyCertificationEndDate;
	    	/**
	     * 
	     */
	    protected String needPmSafetyCertificationUrl;
	
	    	/**
	     * @return 
	     */
	    public String getNeedSafetyPermitNo() {
	        return needSafetyPermitNo;
	    }
	
	    /**
	     * @param 
	     */
	    public void setNeedSafetyPermitNo(String needSafetyPermitNo) {
	        this.needSafetyPermitNo = needSafetyPermitNo;
	    }
	    	/**
	     * @return 
	     */
	    public String getNeedSafetyPermitEndDate() {
	        return needSafetyPermitEndDate;
	    }
	
	    /**
	     * @param 
	     */
	    public void setNeedSafetyPermitEndDate(String needSafetyPermitEndDate) {
	        this.needSafetyPermitEndDate = needSafetyPermitEndDate;
	    }
	    	/**
	     * @return 
	     */
	    public String getNeedSafetyPermitUrl() {
	        return needSafetyPermitUrl;
	    }
	
	    /**
	     * @param 
	     */
	    public void setNeedSafetyPermitUrl(String needSafetyPermitUrl) {
	        this.needSafetyPermitUrl = needSafetyPermitUrl;
	    }
	    	/**
	     * @return 
	     */
	    public String getNeedPmSafetyCertificationNo() {
	        return needPmSafetyCertificationNo;
	    }
	
	    /**
	     * @param 
	     */
	    public void setNeedPmSafetyCertificationNo(String needPmSafetyCertificationNo) {
	        this.needPmSafetyCertificationNo = needPmSafetyCertificationNo;
	    }
	    	/**
	     * @return 
	     */
	    public String getNeedPmSafetyCertificationEndDate() {
	        return needPmSafetyCertificationEndDate;
	    }
	
	    /**
	     * @param 
	     */
	    public void setNeedPmSafetyCertificationEndDate(String needPmSafetyCertificationEndDate) {
	        this.needPmSafetyCertificationEndDate = needPmSafetyCertificationEndDate;
	    }
	    	/**
	     * @return 
	     */
	    public String getNeedPmSafetyCertificationUrl() {
	        return needPmSafetyCertificationUrl;
	    }
	
	    /**
	     * @param 
	     */
	    public void setNeedPmSafetyCertificationUrl(String needPmSafetyCertificationUrl) {
	        this.needPmSafetyCertificationUrl = needPmSafetyCertificationUrl;
	    }
		
	/**
	 * 生成文本组装内容
	 * @return
	 */
	public String getPaintText(){
		String pt = ValidateUtil.sortbyValues(
				   
							ObjectUtils.toString(needSafetyPermitNo) ,
							   
							ObjectUtils.toString(needSafetyPermitEndDate) ,
							   
							ObjectUtils.toString(needSafetyPermitUrl) ,
							   
							ObjectUtils.toString(needPmSafetyCertificationNo) ,
							   
							ObjectUtils.toString(needPmSafetyCertificationEndDate) ,
							   
							ObjectUtils.toString(needPmSafetyCertificationUrl) 
							);
		return pt;
	}
	

    public String toString() {
		return org.apache.commons.lang.builder.ToStringBuilder.reflectionToString(this);
	}

    

}