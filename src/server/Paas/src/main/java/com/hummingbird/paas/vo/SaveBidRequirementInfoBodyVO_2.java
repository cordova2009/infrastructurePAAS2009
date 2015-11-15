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
public class SaveBidRequirementInfoBodyVO_2
implements PainttextAble {

    	    	/**
	     * 
	     */
	    protected String needPmCertificationNo;
	    	/**
	     * 
	     */
	    protected String needPmCertificationEndDate;
	    	/**
	     * 
	     */
	    protected String needPmCertificationUrl;
	    	/**
	     * 
	     */
	    protected String needConstructorCertificationNo;
	    	/**
	     * 
	     */
	    protected String needConstructorCertificationEndDate;
	    	/**
	     * 
	     */
	    protected String needConstructorCertificationUrl;
	
	    	/**
	     * @return 
	     */
	    public String getNeedPmCertificationNo() {
	        return needPmCertificationNo;
	    }
	
	    /**
	     * @param 
	     */
	    public void setNeedPmCertificationNo(String needPmCertificationNo) {
	        this.needPmCertificationNo = needPmCertificationNo;
	    }
	    	/**
	     * @return 
	     */
	    public String getNeedPmCertificationEndDate() {
	        return needPmCertificationEndDate;
	    }
	
	    /**
	     * @param 
	     */
	    public void setNeedPmCertificationEndDate(String needPmCertificationEndDate) {
	        this.needPmCertificationEndDate = needPmCertificationEndDate;
	    }
	    	/**
	     * @return 
	     */
	    public String getNeedPmCertificationUrl() {
	        return needPmCertificationUrl;
	    }
	
	    /**
	     * @param 
	     */
	    public void setNeedPmCertificationUrl(String needPmCertificationUrl) {
	        this.needPmCertificationUrl = needPmCertificationUrl;
	    }
	    	/**
	     * @return 
	     */
	    public String getNeedConstructorCertificationNo() {
	        return needConstructorCertificationNo;
	    }
	
	    /**
	     * @param 
	     */
	    public void setNeedConstructorCertificationNo(String needConstructorCertificationNo) {
	        this.needConstructorCertificationNo = needConstructorCertificationNo;
	    }
	    	/**
	     * @return 
	     */
	    public String getNeedConstructorCertificationEndDate() {
	        return needConstructorCertificationEndDate;
	    }
	
	    /**
	     * @param 
	     */
	    public void setNeedConstructorCertificationEndDate(String needConstructorCertificationEndDate) {
	        this.needConstructorCertificationEndDate = needConstructorCertificationEndDate;
	    }
	    	/**
	     * @return 
	     */
	    public String getNeedConstructorCertificationUrl() {
	        return needConstructorCertificationUrl;
	    }
	
	    /**
	     * @param 
	     */
	    public void setNeedConstructorCertificationUrl(String needConstructorCertificationUrl) {
	        this.needConstructorCertificationUrl = needConstructorCertificationUrl;
	    }
		
	/**
	 * 生成文本组装内容
	 * @return
	 */
	public String getPaintText(){
		String pt = ValidateUtil.sortbyValues(
				   
							ObjectUtils.toString(needPmCertificationNo) ,
							   
							ObjectUtils.toString(needPmCertificationEndDate) ,
							   
							ObjectUtils.toString(needPmCertificationUrl) ,
							   
							ObjectUtils.toString(needConstructorCertificationNo) ,
							   
							ObjectUtils.toString(needConstructorCertificationEndDate) ,
							   
							ObjectUtils.toString(needConstructorCertificationUrl) 
							);
		return pt;
	}
	

    public String toString() {
		return org.apache.commons.lang.builder.ToStringBuilder.reflectionToString(this);
	}

    

}