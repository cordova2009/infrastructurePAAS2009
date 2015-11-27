package com.hummingbird.usercenter.vo;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;
import org.apache.commons.lang.ObjectUtils;

import com.hummingbird.common.util.ValidateUtil;
import com.hummingbird.common.vo.PainttextAble;

/**
 * 重置登录密码接口 在body VO
 */
public class PlatformResetPasswordBodyVO
implements PainttextAble {

    	    	/**
	     * 
	     */
	    protected String realName;
	    	/**
	     * 身份证(需要DES CBC模式加密)
	     */
	    protected String cardID;
	    	/**
	     * 手机号(需要DES CBC模式加密)
	     */
	    protected String mobileNum;
	    	/**
	     * 操作员id
	     */
	    protected Integer operator;
	
	    	/**
	     * @return 
	     */
	    public String getRealName() {
	        return realName;
	    }
	
	    /**
	     * @param 
	     */
	    public void setRealName(String realName) {
	        this.realName = realName;
	    }
	    	/**
	     * @return 身份证(需要DES CBC模式加密)
	     */
	    public String getCardID() {
	        return cardID;
	    }
	
	    /**
	     * @param 身份证(需要DES CBC模式加密)
	     */
	    public void setCardID(String cardID) {
	        this.cardID = cardID;
	    }
	    	/**
	     * @return 手机号(需要DES CBC模式加密)
	     */
	    public String getMobileNum() {
	        return mobileNum;
	    }
	
	    /**
	     * @param 手机号(需要DES CBC模式加密)
	     */
	    public void setMobileNum(String mobileNum) {
	        this.mobileNum = mobileNum;
	    }
	    	/**
	     * @return 操作员id
	     */
	    public Integer getOperator() {
	        return operator;
	    }
	
	    /**
	     * @param 操作员id
	     */
	    public void setOperator(Integer operator) {
	        this.operator = operator;
	    }
		
	/**
	 * 生成文本组装内容
	 * @return
	 */
	public String getPaintText(){
		String pt = ValidateUtil.sortbyValues(
				   
							ObjectUtils.toString(realName) ,
							   
							ObjectUtils.toString(cardID) ,
							   
							ObjectUtils.toString(mobileNum) ,
							   
							ObjectUtils.toString(operator) 
							);
		return pt;
	}
	

    public String toString() {
		return org.apache.commons.lang.builder.ToStringBuilder.reflectionToString(this);
	}

    

}