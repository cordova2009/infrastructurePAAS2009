package com.hummingbird.paas.util;

import org.apache.commons.lang.StringUtils;

import com.hummingbird.common.exception.BusinessException;

/**
 * Integer工具类,用于paas项目
 * @author YJY
 * 2015年11月28日18:04:53
 * 本类主要做为
 */
public class IntegerUtil {
	
	  /**
     * 规则化int数据
     * 如：<br>
     *     <code>str = null;</code><br>
     *     <code>return 0;</code>
     * @param str
     * @return
     */
    public Integer getRegulaInt(Integer str){
    	if(str != null){
    		 return str;
    	}
    	return 0;  
    }
    
    /**
     * 计算int数据和
     * 如：<br>
     *     <code>str = {1,2,null};</code><br>
     *     <code>return 3;</code>
     * @param str
     * @return
     */
    public Integer getSum(Integer... str){
    	Integer sum =0;
    	if(str != null && str.length>0){
    		for(Integer i : str){
    			if(i==null){
    				continue;
    			}
    			sum += i;
    		}
    	}
    	return sum;  
    }
	
}
