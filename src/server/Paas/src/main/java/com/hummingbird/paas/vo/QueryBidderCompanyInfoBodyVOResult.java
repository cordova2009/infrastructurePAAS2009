package com.hummingbird.paas.vo;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;
import org.apache.commons.lang.ObjectUtils;


/**
 * 查询投标人基础信息接口 结果输出 VO
 */
public class QueryBidderCompanyInfoBodyVOResult
{
    	    	/**
	     * 营业执照类型,OLD,三证不合一，NEW，三证合一
	     */
	    protected String businessLicenseType;
	    	/**
	     * 
	     */
	    protected String companyName;
	    	/**
	     * 三合一执照号
	     */
	    protected String newBusinessLicenseNum;
	    	/**
	     * 三合一执照上传Id
	     */
	    protected String newBusinessLicenseUrl;
	    	/**
	     * 营业执照号
	     */
	    protected String businessLicenseNum;
	    	/**
	     * 营业执照上传地址
	     */
	    protected String businessLicenseUrl;
	    	/**
	     * 税务证书编号
	     */
	    protected String taxRegistrationNum;
	    	/**
	     * 税务证书上传地址
	     */
	    protected String taxRegistrationUrl;
	    	/**
	     * 组织机构代码
	     */
	    protected String organizationCodeNum;
	    	/**
	     * 组织机构代码证上传地址
	     */
	    protected String organizationCodeUrl;
	
	    	/**
	     * @return 营业执照类型,OLD,三证不合一，NEW，三证合一
	     */
	    public String getBusinessLicenseType() {
	        return businessLicenseType;
	    }
	
	    /**
	     * @param 营业执照类型,OLD,三证不合一，NEW，三证合一
	     */
	    public void setBusinessLicenseType(String businessLicenseType) {
	        this.businessLicenseType = businessLicenseType;
	    }
	    	/**
	     * @return 
	     */
	    public String getCompanyName() {
	        return companyName;
	    }
	
	    /**
	     * @param 
	     */
	    public void setCompanyName(String companyName) {
	        this.companyName = companyName;
	    }
	    	/**
	     * @return 三合一执照号
	     */
	    public String getNewBusinessLicenseNum() {
	        return newBusinessLicenseNum;
	    }
	
	    /**
	     * @param 三合一执照号
	     */
	    public void setNewBusinessLicenseNum(String newBusinessLicenseNum) {
	        this.newBusinessLicenseNum = newBusinessLicenseNum;
	    }
	    	/**
	     * @return 三合一执照上传Id
	     */
	    public String getNewBusinessLicenseUrl() {
	        return newBusinessLicenseUrl;
	    }
	
	    /**
	     * @param 三合一执照上传Id
	     */
	    public void setNewBusinessLicenseUrl(String newBusinessLicenseUrl) {
	        this.newBusinessLicenseUrl = newBusinessLicenseUrl;
	    }
	    	/**
	     * @return 营业执照号
	     */
	    public String getBusinessLicenseNum() {
	        return businessLicenseNum;
	    }
	
	    /**
	     * @param 营业执照号
	     */
	    public void setBusinessLicenseNum(String businessLicenseNum) {
	        this.businessLicenseNum = businessLicenseNum;
	    }
	    	/**
	     * @return 营业执照上传地址
	     */
	    public String getBusinessLicenseUrl() {
	        return businessLicenseUrl;
	    }
	
	    /**
	     * @param 营业执照上传地址
	     */
	    public void setBusinessLicenseUrl(String businessLicenseUrl) {
	        this.businessLicenseUrl = businessLicenseUrl;
	    }
	    	/**
	     * @return 税务证书编号
	     */
	    public String getTaxRegistrationNum() {
	        return taxRegistrationNum;
	    }
	
	    /**
	     * @param 税务证书编号
	     */
	    public void setTaxRegistrationNum(String taxRegistrationNum) {
	        this.taxRegistrationNum = taxRegistrationNum;
	    }
	    	/**
	     * @return 税务证书上传地址
	     */
	    public String getTaxRegistrationUrl() {
	        return taxRegistrationUrl;
	    }
	
	    /**
	     * @param 税务证书上传地址
	     */
	    public void setTaxRegistrationUrl(String taxRegistrationUrl) {
	        this.taxRegistrationUrl = taxRegistrationUrl;
	    }
	    	/**
	     * @return 组织机构代码
	     */
	    public String getOrganizationCodeNum() {
	        return organizationCodeNum;
	    }
	
	    /**
	     * @param 组织机构代码
	     */
	    public void setOrganizationCodeNum(String organizationCodeNum) {
	        this.organizationCodeNum = organizationCodeNum;
	    }
	    	/**
	     * @return 组织机构代码证上传地址
	     */
	    public String getOrganizationCodeUrl() {
	        return organizationCodeUrl;
	    }
	
	    /**
	     * @param 组织机构代码证上传地址
	     */
	    public void setOrganizationCodeUrl(String organizationCodeUrl) {
	        this.organizationCodeUrl = organizationCodeUrl;
	    }
	
    public String toString() {
		return org.apache.commons.lang.builder.ToStringBuilder.reflectionToString(this);
	}

    

}