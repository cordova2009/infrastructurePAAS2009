package com.hummingbird.paas.vo;

import java.util.Date;
import org.apache.commons.lang.ObjectUtils;


/**
 * 查询未完成招标项目投标文件接口 结果输出 VO
 */
public class QueryBidFileTypeInfoResult
{
    
	    	/**
	     * 
	     */
	    protected String needBusinessStandard;
	    	/**
	     * 投标方是否需要上传技术标书，YES，是。NO#，否。
	     */
	    protected String needTechnicalStandard;
	    	/**
	     * 投标方是否需要上传资格审查文件，YES，是。NO#，否。
	     */
	    protected String needCertificationCheckupFile;
	
	    	/**
	     * @return 
	     */
	    public String getNeedBusinessStandard() {
	        return needBusinessStandard;
	    }
	
	    /**
	     * @param 
	     */
	    public void setNeedBusinessStandard(String needBusinessStandard) {
	        this.needBusinessStandard = needBusinessStandard;
	    }
	    	/**
	     * @return 投标方是否需要上传技术标书，YES，是。NO#，否。
	     */
	    public String getNeedTechnicalStandard() {
	        return needTechnicalStandard;
	    }
	
	    /**
	     * @param 投标方是否需要上传技术标书，YES，是。NO#，否。
	     */
	    public void setNeedTechnicalStandard(String needTechnicalStandard) {
	        this.needTechnicalStandard = needTechnicalStandard;
	    }
	    	/**
	     * @return 投标方是否需要上传资格审查文件，YES，是。NO#，否。
	     */
	    public String getNeedCertificationCheckupFile() {
	        return needCertificationCheckupFile;
	    }
	
	    /**
	     * @param 投标方是否需要上传资格审查文件，YES，是。NO#，否。
	     */
	    public void setNeedCertificationCheckupFile(String needCertificationCheckupFile) {
	        this.needCertificationCheckupFile = needCertificationCheckupFile;
	    }
		

	

    public String toString() {
		return org.apache.commons.lang.builder.ToStringBuilder.reflectionToString(this);
	}

    

}