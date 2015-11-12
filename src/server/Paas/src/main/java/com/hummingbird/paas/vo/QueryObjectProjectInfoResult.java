package com.hummingbird.paas.vo;

import java.util.Date;
import org.apache.commons.lang.ObjectUtils;


/**
 * 查询未完成招标项目工程信息接口 结果输出 VO
 */
public class QueryObjectProjectInfoResult
{
    
	    	/**
	     * 
	     */
	    protected String projectName;
	    	/**
	     * 工程地点
	     */
	    protected String projectSite;
	    	/**
	     * 工程规模及特征
	     */
	    protected String projectScale;
	    	/**
	     * 工程计划总投资
	     */
	    protected String projectExpectInvestment;
	    	/**
	     * 建设单位
	     */
	    protected String employer;
	    	/**
	     * 建设单位经办人
	     */
	    protected String employerPrincipal;
	    	/**
	     * 建设单位联系电话
	     */
	    protected String employerTelephone;
	
	    	/**
	     * @return 
	     */
	    public String getProjectName() {
	        return projectName;
	    }
	
	    /**
	     * @param 
	     */
	    public void setProjectName(String projectName) {
	        this.projectName = projectName;
	    }
	    	/**
	     * @return 工程地点
	     */
	    public String getProjectSite() {
	        return projectSite;
	    }
	
	    /**
	     * @param 工程地点
	     */
	    public void setProjectSite(String projectSite) {
	        this.projectSite = projectSite;
	    }
	    	/**
	     * @return 工程规模及特征
	     */
	    public String getProjectScale() {
	        return projectScale;
	    }
	
	    /**
	     * @param 工程规模及特征
	     */
	    public void setProjectScale(String projectScale) {
	        this.projectScale = projectScale;
	    }
	    	/**
	     * @return 工程计划总投资
	     */
	    public String getProjectExpectInvestment() {
	        return projectExpectInvestment;
	    }
	
	    /**
	     * @param 工程计划总投资
	     */
	    public void setProjectExpectInvestment(String projectExpectInvestment) {
	        this.projectExpectInvestment = projectExpectInvestment;
	    }
	    	/**
	     * @return 建设单位
	     */
	    public String getEmployer() {
	        return employer;
	    }
	
	    /**
	     * @param 建设单位
	     */
	    public void setEmployer(String employer) {
	        this.employer = employer;
	    }
	    	/**
	     * @return 建设单位经办人
	     */
	    public String getEmployerPrincipal() {
	        return employerPrincipal;
	    }
	
	    /**
	     * @param 建设单位经办人
	     */
	    public void setEmployerPrincipal(String employerPrincipal) {
	        this.employerPrincipal = employerPrincipal;
	    }
	    	/**
	     * @return 建设单位联系电话
	     */
	    public String getEmployerTelephone() {
	        return employerTelephone;
	    }
	
	    /**
	     * @param 建设单位联系电话
	     */
	    public void setEmployerTelephone(String employerTelephone) {
	        this.employerTelephone = employerTelephone;
	    }
		

	

    public String toString() {
		return org.apache.commons.lang.builder.ToStringBuilder.reflectionToString(this);
	}

    

}