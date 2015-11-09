package com.hummingbird.paas.vo;

import java.util.Date;
import org.apache.commons.lang.ObjectUtils;


/**
 * 查询未完成招标项目基础信息接口 结果输出 VO
 */
public class QueryObjectBaseInfoBodyVOResult
{
    
	    	/**
	     * 项目名称 
	     */
	    protected String objectName;
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
	    protected String evaluationAmount;
	
	    	/**
	     * @return 项目名称 
	     */
	    public String getObjectName() {
	        return objectName;
	    }
	
	    /**
	     * @param 项目名称 
	     */
	    public void setObjectName(String objectName) {
	        this.objectName = objectName;
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
	    public String getEvaluationAmount() {
	        return evaluationAmount;
	    }
	
	    /**
	     * @param 工程标的估价
	     */
	    public void setEvaluationAmount(String evaluationAmount) {
	        this.evaluationAmount = evaluationAmount;
	    }
		

	

    public String toString() {
		return org.apache.commons.lang.builder.ToStringBuilder.reflectionToString(this);
	}

    

}