package com.hummingbird.paas.vo;

import java.util.Date;
import org.apache.commons.lang.ObjectUtils;

import com.hummingbird.common.util.ValidateUtil;
import com.hummingbird.common.vo.PainttextAble;

/**
 * 保存招标项目基础信息接口 在body VO
 */
public class SaveObjectBaseInfo 
implements PainttextAble {
    
	    	/**
	     * 用户令牌
	     */
	    protected String token;
	    	/**
	     * 招标项目名称
	     */
	    protected String objectId;
	    	/**
	     * 招标项目名称
	     */
	    protected String objectName;
	    /**
	     * 工程类别编号
	     */
	    protected String industryId;
	    	/**
	     * 招标项目编号
	     */
	    protected String biddingNo;
	    	/**
	     * 招标项目范围
	     */
	    protected String objectScope;
	    	/**
	     * 招标经办人
	     */
	    protected String biddeeCompanyPrincipal;
	    	/**
	     * 
	     */
	    protected String biddeeCompanyTelephone;
	    	/**
	     * 采用币种
	     */
	    protected String currency;
	    	/**
	     * 承包方式
	     */
	    protected String contractType;
	    	/**
	     * 工程标的估价
	     */
	    protected Long evaluationAmount;
	
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
	     * @return 招标项目名称
	     */
	    public String getObjectId() {
	        return objectId;
	    }
	
	    /**
	     * @param 招标项目名称
	     */
	    public void setObjectId(String objectId) {
	        this.objectId = objectId;
	    }
	    	/**
	     * @return 招标项目名称
	     */
	    public String getObjectName() {
	        return objectName;
	    }
	
	    /**
	     * @param 招标项目名称
	     */
	    public void setObjectName(String objectName) {
	        this.objectName = objectName;
	    }
	    	/**
	     * @return 工程类别编号
	     */
	    public String getIndustryId() {
	        return industryId;
	    }
	
	    /**
	     * @param 工程类别编号
	     */
	    public void setIndustryId(String industryId) {
	        this.industryId = industryId;
	    }
	    	/**
	     * @return 招标项目编号
	     */
	    public String getBiddingNo() {
	        return biddingNo;
	    }
	
	    /**
	     * @param 招标项目编号
	     */
	    public void setBiddingNo(String biddingNo) {
	        this.biddingNo = biddingNo;
	    }
	    	/**
	     * @return 招标项目范围
	     */
	    public String getObjectScope() {
	        return objectScope;
	    }
	
	    /**
	     * @param 招标项目范围
	     */
	    public void setObjectScope(String objectScope) {
	        this.objectScope = objectScope;
	    }
	    	/**
	     * @return 招标经办人
	     */
	    public String getBiddeeCompanyPrincipal() {
	        return biddeeCompanyPrincipal;
	    }
	
	    /**
	     * @param 招标经办人
	     */
	    public void setBiddeeCompanyPrincipal(String biddeeCompanyPrincipal) {
	        this.biddeeCompanyPrincipal = biddeeCompanyPrincipal;
	    }
	    	/**
	     * @return 
	     */
	    public String getBiddeeCompanyTelephone() {
	        return biddeeCompanyTelephone;
	    }
	
	    /**
	     * @param 
	     */
	    public void setBiddeeCompanyTelephone(String biddeeCompanyTelephone) {
	        this.biddeeCompanyTelephone = biddeeCompanyTelephone;
	    }
	    	/**
	     * @return 采用币种
	     */
	    public String getCurrency() {
	        return currency;
	    }
	
	    /**
	     * @param 采用币种
	     */
	    public void setCurrency(String currency) {
	        this.currency = currency;
	    }
	    	/**
	     * @return 承包方式
	     */
	    public String getContractType() {
	        return contractType;
	    }
	
	    /**
	     * @param 承包方式
	     */
	    public void setContractType(String contractType) {
	        this.contractType = contractType;
	    }
	    	/**
	     * @return 工程标的估价
	     */
	    public Long getEvaluationAmount() {
	        return evaluationAmount;
	    }
	
	    /**
	     * @param 工程标的估价
	     */
	    public void setEvaluationAmount(Long evaluationAmount) {
	        this.evaluationAmount = evaluationAmount;
	    }
		
	/**
	 * 生成文本组装内容
	 * @return
	 */
	public String getPaintText(){
		String pt = ValidateUtil.sortbyValues(
					ObjectUtils.toString(token) , 					ObjectUtils.toString(objectId) , 					ObjectUtils.toString(objectName) , 					ObjectUtils.toString(industryId) , 					ObjectUtils.toString(biddingNo) , 					ObjectUtils.toString(objectScope) , 					ObjectUtils.toString(biddeeCompanyPrincipal) , 					ObjectUtils.toString(biddeeCompanyTelephone) , 					ObjectUtils.toString(currency) , 					ObjectUtils.toString(contractType) , 					ObjectUtils.toString(evaluationAmount) 				);
		return pt;
	}
	

    public String toString() {
		return org.apache.commons.lang.builder.ToStringBuilder.reflectionToString(this);
	}

    

}