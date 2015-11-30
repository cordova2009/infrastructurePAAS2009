package com.hummingbird.paas.vo;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.ObjectUtils;

import com.hummingbird.common.util.ValidateUtil;
import com.hummingbird.common.vo.PainttextAble;

/**
 * 查询投标类在body VO
 */
public class QueryVIPBodyVO 
implements PainttextAble {

    	/**
	     * 
	     */
	    protected String token;
	
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
	 * 生成文本组装内容
	 * @return
	 */
	public String getPaintText(){
		String pt = ValidateUtil.sortbyValues(ObjectUtils.toString(token));
		return pt;
	}
	

    public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

    

}