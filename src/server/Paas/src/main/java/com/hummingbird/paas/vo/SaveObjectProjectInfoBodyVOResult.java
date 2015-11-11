package com.hummingbird.paas.vo;

import java.util.Date;
import org.apache.commons.lang.ObjectUtils;


/**
 * 查询未完成招标项目工程要求接口 结果输出 VO
 */
public class SaveObjectProjectInfoBodyVOResult
{
    
	    	/**
	     * 计划开工日期
	     */
	    protected String projectExpectStartDate;
	    	/**
	     * 标准工期
	     */
	    protected Integer projectExpectPeriod;
	
	    	/**
	     * @return 计划开工日期
	     */
	    public String getProjectExpectStartDate() {
	        return projectExpectStartDate;
	    }
	
	    /**
	     * @param 计划开工日期
	     */
	    public void setProjectExpectStartDate(String projectExpectStartDate) {
	        this.projectExpectStartDate = projectExpectStartDate;
	    }
	    	/**
	     * @return 标准工期
	     */
	    public Integer getProjectExpectPeriod() {
	        return projectExpectPeriod;
	    }
	
	    /**
	     * @param 标准工期
	     */
	    public void setProjectExpectPeriod(Integer projectExpectPeriod) {
	        this.projectExpectPeriod = projectExpectPeriod;
	    }
		

	

    public String toString() {
		return org.apache.commons.lang.builder.ToStringBuilder.reflectionToString(this);
	}

    

}