package com.hummingbird.paas.vo;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;
import org.apache.commons.lang.ObjectUtils;


/**
 * 查询未完成投标的技术标信息接口 结果输出 VO
 */
public class QueryTechnicalStandardInfoBodyVOResult
{
    	    	/**
	     * 技术标书上传地址
	     */
	    protected String technicalStandardUrl;
	
	    	/**
	     * @return 技术标书上传地址
	     */
	    public String getTechnicalStandardUrl() {
	        return technicalStandardUrl;
	    }
	
	    /**
	     * @param 技术标书上传地址
	     */
	    public void setTechnicalStandardUrl(String technicalStandardUrl) {
	        this.technicalStandardUrl = technicalStandardUrl;
	    }
	
    public String toString() {
		return org.apache.commons.lang.builder.ToStringBuilder.reflectionToString(this);
	}

    

}