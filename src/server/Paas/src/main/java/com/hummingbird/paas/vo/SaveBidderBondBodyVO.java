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
 * 保存投标保证金接口 在body VO
 */
public class SaveBidderBondBodyVO
implements PainttextAble {

    	    	/**
	     * 
	     */
	    protected String token;
	    	/**
	     * 投标记录编号
	     */
	    protected Integer bidId;
	    	/**
	     * 招标项目内部编号
	     */
	    protected String objectId;
	    	/**
	     * 保函编号
	     */
	    protected String bankGuaranteeNo;
	    	/**
	     * 保函附件
	     */
	    protected String bankGuaranteeUrl;
	    	/**
	     * 保函金额
	     */
	    protected Integer bankGuaranteeAmount;
	
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
	     * @return 投标记录编号
	     */
	    public Integer getBidId() {
	        return bidId;
	    }
	
	    /**
	     * @param 投标记录编号
	     */
	    public void setBidId(Integer bidId) {
	        this.bidId = bidId;
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
	     * @return 保函编号
	     */
	    public String getBankGuaranteeNo() {
	        return bankGuaranteeNo;
	    }
	
	    /**
	     * @param 保函编号
	     */
	    public void setBankGuaranteeNo(String bankGuaranteeNo) {
	        this.bankGuaranteeNo = bankGuaranteeNo;
	    }
	    	/**
	     * @return 保函附件
	     */
	    public String getBankGuaranteeUrl() {
	        return bankGuaranteeUrl;
	    }
	
	    /**
	     * @param 保函附件
	     */
	    public void setBankGuaranteeUrl(String bankGuaranteeUrl) {
	        this.bankGuaranteeUrl = bankGuaranteeUrl;
	    }
	    	/**
	     * @return 保函金额
	     */
	    public Integer getBankGuaranteeAmount() {
	        return bankGuaranteeAmount;
	    }
	
	    /**
	     * @param 保函金额
	     */
	    public void setBankGuaranteeAmount(Integer bankGuaranteeAmount) {
	        this.bankGuaranteeAmount = bankGuaranteeAmount;
	    }
		
	/**
	 * 生成文本组装内容
	 * @return
	 */
	public String getPaintText(){
		String pt = ValidateUtil.sortbyValues(
				   
							ObjectUtils.toString(token) ,
							   
							ObjectUtils.toString(bidId) ,
							   
							ObjectUtils.toString(objectId) ,
							   
							ObjectUtils.toString(bankGuaranteeNo) ,
							   
							ObjectUtils.toString(bankGuaranteeUrl) ,
							   
							ObjectUtils.toString(bankGuaranteeAmount) 
							);
		return pt;
	}
	

    public String toString() {
		return org.apache.commons.lang.builder.ToStringBuilder.reflectionToString(this);
	}

    

}