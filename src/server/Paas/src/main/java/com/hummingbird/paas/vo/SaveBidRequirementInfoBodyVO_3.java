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
 * 保存投标资格审查信息接口 在body VO
 */
public class SaveBidRequirementInfoBodyVO_3
implements PainttextAble {

    	    	/**
	     * 
	     */
	    protected Integer bankGuaranteeAmount;
	    	/**
	     * 
	     */
	    protected String bankGuaranteeUrl;
	    	/**
	     * 
	     */
	    protected String bankGuaranteeNo;
	
	    	/**
	     * @return 
	     */
	    public Integer getBankGuaranteeAmount() {
	        return bankGuaranteeAmount;
	    }
	
	    /**
	     * @param 
	     */
	    public void setBankGuaranteeAmount(Integer bankGuaranteeAmount) {
	        this.bankGuaranteeAmount = bankGuaranteeAmount;
	    }
	    	/**
	     * @return 
	     */
	    public String getBankGuaranteeUrl() {
	        return bankGuaranteeUrl;
	    }
	
	    /**
	     * @param 
	     */
	    public void setBankGuaranteeUrl(String bankGuaranteeUrl) {
	        this.bankGuaranteeUrl = bankGuaranteeUrl;
	    }
	    	/**
	     * @return 
	     */
	    public String getBankGuaranteeNo() {
	        return bankGuaranteeNo;
	    }
	
	    /**
	     * @param 
	     */
	    public void setBankGuaranteeNo(String bankGuaranteeNo) {
	        this.bankGuaranteeNo = bankGuaranteeNo;
	    }
		
	/**
	 * 生成文本组装内容
	 * @return
	 */
	public String getPaintText(){
		String pt = ValidateUtil.sortbyValues(
				   
							ObjectUtils.toString(bankGuaranteeAmount) ,
							   
							ObjectUtils.toString(bankGuaranteeUrl) ,
							   
							ObjectUtils.toString(bankGuaranteeNo) 
							);
		return pt;
	}
	

    public String toString() {
		return org.apache.commons.lang.builder.ToStringBuilder.reflectionToString(this);
	}

    

}