package com.hummingbird.paas.vo;

import java.util.Date;
import org.apache.commons.lang.ObjectUtils;


/**
 * 查询未完成招标项目工程施工证明接口 结果输出 VO
 */
public class QueryObjectConstructionInfoResult
{
    
	    	/**
	     * 施工证明类型,BCP 有施工许可,KFS开发商(必须有国有地址使用证), ZCB 总承包(必须带有中标通知书,国有地址使用证)
	     */
	    protected String constructionProveType;
	    	/**
	     * 国有土地使用证编号
	     */
	    protected String landUseCertificateNo;
	    	/**
	     * 国有土地使用证有效期
	     */
	    protected String landUseCertificateEndDate;
	    	/**
	     * 国有土地使用证上传地址
	     */
	    protected String landUseCertificateUrl;
	    	/**
	     * 建设用地规划许可证编号
	     */
	    protected String constructionLandUsePermitNo;
	    	/**
	     * 建设用地规划许可证有效期
	     */
	    protected String constructionLandUsePermitEndDate;
	    	/**
	     * 建设用地规划许可证上传地址
	     */
	    protected String constructionLandUsePermitUrl;
	    	/**
	     * 建设工程规划许可证编号
	     */
	    protected String buildingPermitNo;
	    	/**
	     * 建设工程规划许可证有效期
	     */
	    protected String buildingPermitEndDate;
	    	/**
	     * 建设工程规划许可证上传地址
	     */
	    protected String buildingPermitUrl;
	    	/**
	     * 中标通知书上传地址
	     */
	    protected String letterOfAcceptanceUrl;
	    	/**
	     * 建设工程施工许可证编号
	     */
	    protected String buildingConstructPermitNo;
	    	/**
	     * 建设工程施工许可证有效期
	     */
	    protected String buildingConstructPermitEndDate;
	    	/**
	     * 建设工程施工许可证上传地址
	     */
	    protected String buildingConstructPermitUrl;
	
	    	/**
	    	 * 施工证明类型,BCP 有施工许可,KFS开发商(必须有国有地址使用证), ZCB 总承包(必须带有中标通知书,国有地址使用证)
	     * @return 
	     */
	    public String getConstructionProveType() {
	        return constructionProveType;
	    }
	
	    /**
	     * 施工证明类型,BCP 有施工许可,KFS开发商(必须有国有地址使用证), ZCB 总承包(必须带有中标通知书,国有地址使用证)
	     * @param 
	     */
	    public void setConstructionProveType(String constructionProveType) {
	        this.constructionProveType = constructionProveType;
	    }
	    	/**
	     * @return 国有土地使用证编号
	     */
	    public String getLandUseCertificateNo() {
	        return landUseCertificateNo;
	    }
	
	    /**
	     * @param 国有土地使用证编号
	     */
	    public void setLandUseCertificateNo(String landUseCertificateNo) {
	        this.landUseCertificateNo = landUseCertificateNo;
	    }
	    	/**
	     * @return 国有土地使用证有效期
	     */
	    public String getLandUseCertificateEndDate() {
	        return landUseCertificateEndDate;
	    }
	
	    /**
	     * @param 国有土地使用证有效期
	     */
	    public void setLandUseCertificateEndDate(String landUseCertificateEndDate) {
	        this.landUseCertificateEndDate = landUseCertificateEndDate;
	    }
	    	/**
	     * @return 国有土地使用证上传地址
	     */
	    public String getLandUseCertificateUrl() {
	        return landUseCertificateUrl;
	    }
	
	    /**
	     * @param 国有土地使用证上传地址
	     */
	    public void setLandUseCertificateUrl(String landUseCertificateUrl) {
	        this.landUseCertificateUrl = landUseCertificateUrl;
	    }
	    	/**
	     * @return 建设用地规划许可证编号
	     */
	    public String getConstructionLandUsePermitNo() {
	        return constructionLandUsePermitNo;
	    }
	
	    /**
	     * @param 建设用地规划许可证编号
	     */
	    public void setConstructionLandUsePermitNo(String constructionLandUsePermitNo) {
	        this.constructionLandUsePermitNo = constructionLandUsePermitNo;
	    }
	    	/**
	     * @return 建设用地规划许可证有效期
	     */
	    public String getConstructionLandUsePermitEndDate() {
	        return constructionLandUsePermitEndDate;
	    }
	
	    /**
	     * @param 建设用地规划许可证有效期
	     */
	    public void setConstructionLandUsePermitEndDate(String constructionLandUsePermitEndDate) {
	        this.constructionLandUsePermitEndDate = constructionLandUsePermitEndDate;
	    }
	    	/**
	     * @return 建设用地规划许可证上传地址
	     */
	    public String getConstructionLandUsePermitUrl() {
	        return constructionLandUsePermitUrl;
	    }
	
	    /**
	     * @param 建设用地规划许可证上传地址
	     */
	    public void setConstructionLandUsePermitUrl(String constructionLandUsePermitUrl) {
	        this.constructionLandUsePermitUrl = constructionLandUsePermitUrl;
	    }
	    	/**
	     * @return 建设工程规划许可证编号
	     */
	    public String getBuildingPermitNo() {
	        return buildingPermitNo;
	    }
	
	    /**
	     * @param 建设工程规划许可证编号
	     */
	    public void setBuildingPermitNo(String buildingPermitNo) {
	        this.buildingPermitNo = buildingPermitNo;
	    }
	    	/**
	     * @return 建设工程规划许可证有效期
	     */
	    public String getBuildingPermitEndDate() {
	        return buildingPermitEndDate;
	    }
	
	    /**
	     * @param 建设工程规划许可证有效期
	     */
	    public void setBuildingPermitEndDate(String buildingPermitEndDate) {
	        this.buildingPermitEndDate = buildingPermitEndDate;
	    }
	    	/**
	     * @return 建设工程规划许可证上传地址
	     */
	    public String getBuildingPermitUrl() {
	        return buildingPermitUrl;
	    }
	
	    /**
	     * @param 建设工程规划许可证上传地址
	     */
	    public void setBuildingPermitUrl(String buildingPermitUrl) {
	        this.buildingPermitUrl = buildingPermitUrl;
	    }
	    	/**
	     * @return 中标通知书上传地址
	     */
	    public String getLetterOfAcceptanceUrl() {
	        return letterOfAcceptanceUrl;
	    }
	
	    /**
	     * @param 中标通知书上传地址
	     */
	    public void setLetterOfAcceptanceUrl(String letterOfAcceptanceUrl) {
	        this.letterOfAcceptanceUrl = letterOfAcceptanceUrl;
	    }
	    	/**
	     * @return 建设工程施工许可证编号
	     */
	    public String getBuildingConstructPermitNo() {
	        return buildingConstructPermitNo;
	    }
	
	    /**
	     * @param 建设工程施工许可证编号
	     */
	    public void setBuildingConstructPermitNo(String buildingConstructPermitNo) {
	        this.buildingConstructPermitNo = buildingConstructPermitNo;
	    }
	    	/**
	     * @return 建设工程施工许可证有效期
	     */
	    public String getBuildingConstructPermitEndDate() {
	        return buildingConstructPermitEndDate;
	    }
	
	    /**
	     * @param 建设工程施工许可证有效期
	     */
	    public void setBuildingConstructPermitEndDate(String buildingConstructPermitEndDate) {
	        this.buildingConstructPermitEndDate = buildingConstructPermitEndDate;
	    }
	    	/**
	     * @return 建设工程施工许可证上传地址
	     */
	    public String getBuildingConstructPermitUrl() {
	        return buildingConstructPermitUrl;
	    }
	
	    /**
	     * @param 建设工程施工许可证上传地址
	     */
	    public void setBuildingConstructPermitUrl(String buildingConstructPermitUrl) {
	        this.buildingConstructPermitUrl = buildingConstructPermitUrl;
	    }
		

	

    public String toString() {
		return org.apache.commons.lang.builder.ToStringBuilder.reflectionToString(this);
	}

    

}