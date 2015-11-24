package com.hummingbird.paas.vo;

import java.util.Date;
import org.apache.commons.lang.ObjectUtils;

import com.hummingbird.common.util.ValidateUtil;
import com.hummingbird.common.vo.PainttextAble;

/**
 * 保存招标项目保证金接口 在body VO
 */
public class SaveObjectBondInfo 
implements PainttextAble {
    
	    	/**
	     * 招标项目内部编号
	     */
	    protected String objectId;
	    	/**
	     * 用户令牌
	     */
	    protected String token;
	    	/**
	     * 投标担保金额
	     */
	    protected Long bidBondAmount;
	
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
	     * @return 用户令牌
	     */
	    public String getToken() {
	        return token;
	    }
	
	    /**
	     * @param 用户令牌
	     */
	    public void setToken(String token) {
	        this.token = token;
	    }
	    	/**
	     * @return 投标担保金额
	     */
	    public Long getBidBondAmount() {
	        return bidBondAmount;
	    }
	
	    /**
	     * @param 投标担保金额
	     */
	    public void setBidBondAmount(Long bidBondAmount) {
	        this.bidBondAmount = bidBondAmount;
	    }
		
	/**
	 * 生成文本组装内容
	 * @return
	 */
	public String getPaintText(){
		String pt = ValidateUtil.sortbyValues(
					ObjectUtils.toString(objectId) , 					ObjectUtils.toString(token) , 					ObjectUtils.toString(bidBondAmount) 				);
		return pt;
	}
	

    public String toString() {
		return org.apache.commons.lang.builder.ToStringBuilder.reflectionToString(this);
	}

    

}