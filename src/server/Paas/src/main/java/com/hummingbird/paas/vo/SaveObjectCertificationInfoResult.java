package com.hummingbird.paas.vo;

import java.util.ArrayList;
import java.util.List;


/**
 * 保存招标项目资质要求接口 结果输出 VO
 */
public class SaveObjectCertificationInfoResult
{
    
	    	/**
	     * 
	     */
	    protected List bidderCertification;
	    	/**
	     * 需要投标人项目经理,YES,是.NO#,否
	     */
	    protected String needPmCertification;
	    	/**
	     * 需要投标人建造师.YES,是，NO#,否
	     */
	    protected String needConstructorCertification;
	    	/**
	     * 需要安全生产许可证,YES,是.NO#,否
	     */
	    protected String needSafetyPermit;
	    	/**
	     * 需要项目经理安全生产考核合格证.YES,是.NO#,否
	     */
	    protected String needPmSafetyCertification;
	
	    	/**
	     * @return 
	     */
	    public List getBidderCertification() {
	        return bidderCertification;
	    }
	
	    /**
	     * @param 
	     */
	    public void setBidderCertification(ArrayList bidderCertification) {
	        this.bidderCertification = bidderCertification;
	    }
	    	/**
	     * @return 需要投标人项目经理,YES,是.NO#,否
	     */
	    public String getNeedPmCertification() {
	        return needPmCertification;
	    }
	
	    /**
	     * @param 需要投标人项目经理,YES,是.NO#,否
	     */
	    public void setNeedPmCertification(String needPmCertification) {
	        this.needPmCertification = needPmCertification;
	    }
	    	/**
	     * @return 需要投标人建造师.YES,是，NO#,否
	     */
	    public String getNeedConstructorCertification() {
	        return needConstructorCertification;
	    }
	
	    /**
	     * @param 需要投标人建造师.YES,是，NO#,否
	     */
	    public void setNeedConstructorCertification(String needConstructorCertification) {
	        this.needConstructorCertification = needConstructorCertification;
	    }
	    	/**
	     * @return 需要安全生产许可证,YES,是.NO#,否
	     */
	    public String getNeedSafetyPermit() {
	        return needSafetyPermit;
	    }
	
	    /**
	     * @param 需要安全生产许可证,YES,是.NO#,否
	     */
	    public void setNeedSafetyPermit(String needSafetyPermit) {
	        this.needSafetyPermit = needSafetyPermit;
	    }
	    	/**
	     * @return 需要项目经理安全生产考核合格证.YES,是.NO#,否
	     */
	    public String getNeedPmSafetyCertification() {
	        return needPmSafetyCertification;
	    }
	
	    /**
	     * @param 需要项目经理安全生产考核合格证.YES,是.NO#,否
	     */
	    public void setNeedPmSafetyCertification(String needPmSafetyCertification) {
	        this.needPmSafetyCertification = needPmSafetyCertification;
	    }
		

	

    public String toString() {
		return org.apache.commons.lang.builder.ToStringBuilder.reflectionToString(this);
	}

    

}