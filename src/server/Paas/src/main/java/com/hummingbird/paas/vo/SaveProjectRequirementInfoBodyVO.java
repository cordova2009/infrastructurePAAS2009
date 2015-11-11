package com.hummingbird.paas.vo;

import java.util.Date;
import org.apache.commons.lang.ObjectUtils;

import com.hummingbird.common.util.ValidateUtil;
import com.hummingbird.common.vo.PainttextAble;

/**
 * 保存招标项目工程施工证明接口 在body VO
 */
public class SaveProjectRequirementInfoBodyVO 
implements PainttextAble {
    
	    	/**
	     * 
	     */
	    protected String token;
	    	/**
	     * 招标项目内部编号
	     */
	    protected String objectId;
	    	/**
	     * 计划开工日期
	     */
	    protected String projectExpectStartDate;
	    	/**
	     * 标准工期
	     */
	    protected Integer projectExpectPeriod;
	
	    	/**
	     * @return 
	     */
	    public String getToken() {
	        return token;
	    }
	
	    /**
	     * @param 
	     */
	    public void setToken(String token) {
	        this.token = token;
	    }
	    	/**
	     * @return 招标项目内部编号
	     */
	    public String getObjectId() {
	        return objectId;
	    }
	
	    /**
	     * @param 招标项目内部编号
	     */
	    public void setObjectId(String objectId) {
	        this.objectId = objectId;
	    }
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
		
	/**
	 * 生成文本组装内容
	 * @return
	 */
	public String getPaintText(){
		String pt = ValidateUtil.sortbyValues(
					ObjectUtils.toString(token) , 					ObjectUtils.toString(objectId) , 					ObjectUtils.toString(projectExpectStartDate) , 					ObjectUtils.toString(projectExpectPeriod) 				);
		return pt;
	}
	

    public String toString() {
		return org.apache.commons.lang.builder.ToStringBuilder.reflectionToString(this);
	}

    

}