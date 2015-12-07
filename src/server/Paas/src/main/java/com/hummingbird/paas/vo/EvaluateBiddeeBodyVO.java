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
 * 投标方给招标方评价接口 在body VO
 */
public class EvaluateBiddeeBodyVO
implements PainttextAble {

    	    	/**
	     * 
	     */
	    protected String token;
	    	/**
	     * 项目内部编号
	     */
	    protected String objectId;
	    	/**
	     * 评价分数
	     */
	    protected Integer evaluateScore;
	    	/**
	     * 评价标签
	     */
	    protected List<String> tags;
	    	/**
	     * 评价内容
	     */
	    protected String evaluateContent;
	
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
	     * @return 项目内部编号
	     */
	    public String getObjectId() {
	        return objectId;
	    }
	
	    /**
	     * @param 项目内部编号
	     */
	    public void setObjectId(String objectId) {
	        this.objectId = objectId;
	    }
	    	/**
	     * @return 评价分数
	     */
	    public Integer getEvaluateScore() {
	        return evaluateScore;
	    }
	
	    /**
	     * @param 评价分数
	     */
	    public void setEvaluateScore(Integer evaluateScore) {
	        this.evaluateScore = evaluateScore;
	    }
	    	/**
	     * @return 评价标签
	     */
	    public List<String> getTags() {
	        return tags;
	    }
	
	    /**
	     * @param 评价标签
	     */
	    public void setTags(List<String> tags) {
	        this.tags = tags;
	    }
	    	/**
	     * @return 评价内容
	     */
	    public String getEvaluateContent() {
	        return evaluateContent;
	    }
	
	    /**
	     * @param 评价内容
	     */
	    public void setEvaluateContent(String evaluateContent) {
	        this.evaluateContent = evaluateContent;
	    }
		
	/**
	 * 生成文本组装内容
	 * @return
	 */
	public String getPaintText(){
		String pt = ValidateUtil.sortbyValues(
				   
							ObjectUtils.toString(token) ,
							   
							ObjectUtils.toString(objectId) ,
							   
							ObjectUtils.toString(evaluateScore) ,
							   
							ObjectUtils.toString(tags) ,
							   
							ObjectUtils.toString(evaluateContent) 
							);
		return pt;
	}
	

    public String toString() {
		return org.apache.commons.lang.builder.ToStringBuilder.reflectionToString(this);
	}

    

}