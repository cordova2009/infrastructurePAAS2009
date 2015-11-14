package com.hummingbird.paas.vo;

import java.util.Date;
import org.apache.commons.lang.ObjectUtils;

import com.hummingbird.common.util.ValidateUtil;
import com.hummingbird.common.vo.PainttextAble;

/**
 * 保存招标项目工程施工证明接口 在body VO
 */
public class SaveObjectConstructionInfo 
implements PainttextAble {
    
	    	/**
	     * 
	     */
	    protected String token;
	    	/**
	     * 招标项目内部编号
	     */
	    protected String objectId;
	    	/**
	     * 施工证明类型
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
	     * 
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
	     * 
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
	     * 
	     */
	    protected String buildingPermitUrl;
	    	/**
	     * 
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
	     * 
	     */
	    protected String buildingConstructPermitUrl;
	
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
	     * @return 施工证明类型
	     */
	    public String getConstructionProveType() {
	        return constructionProveType;
	    }
	
	    /**
	     * @param 施工证明类型
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
	     * @return 
	     */
	    public String getLandUseCertificateUrl() {
	        return landUseCertificateUrl;
	    }
	
	    /**
	     * @param 
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
	     * @return 
	     */
	    public String getConstructionLandUsePermitUrl() {
	        return constructionLandUsePermitUrl;
	    }
	
	    /**
	     * @param 
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
	     * @return 
	     */
	    public String getBuildingPermitUrl() {
	        return buildingPermitUrl;
	    }
	
	    /**
	     * @param 
	     */
	    public void setBuildingPermitUrl(String buildingPermitUrl) {
	        this.buildingPermitUrl = buildingPermitUrl;
	    }
	    	/**
	     * @return 
	     */
	    public String getLetterOfAcceptanceUrl() {
	        return letterOfAcceptanceUrl;
	    }
	
	    /**
	     * @param 
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
	     * @return 
	     */
	    public String getBuildingConstructPermitUrl() {
	        return buildingConstructPermitUrl;
	    }
	
	    /**
	     * @param 
	     */
	    public void setBuildingConstructPermitUrl(String buildingConstructPermitUrl) {
	        this.buildingConstructPermitUrl = buildingConstructPermitUrl;
	    }
		
	/**
	 * 生成文本组装内容
	 * @return
	 */
	public String getPaintText(){
		String pt = ValidateUtil.sortbyValues(
					ObjectUtils.toString(token) , 					ObjectUtils.toString(objectId) , 					ObjectUtils.toString(constructionProveType) , 					ObjectUtils.toString(landUseCertificateNo) , 					ObjectUtils.toString(landUseCertificateEndDate) , 					ObjectUtils.toString(landUseCertificateUrl) , 					ObjectUtils.toString(constructionLandUsePermitNo) , 					ObjectUtils.toString(constructionLandUsePermitEndDate) , 					ObjectUtils.toString(constructionLandUsePermitUrl) , 					ObjectUtils.toString(buildingPermitNo) , 					ObjectUtils.toString(buildingPermitEndDate) , 					ObjectUtils.toString(buildingPermitUrl) , 					ObjectUtils.toString(letterOfAcceptanceUrl) , 					ObjectUtils.toString(buildingConstructPermitNo) , 					ObjectUtils.toString(buildingConstructPermitEndDate) , 					ObjectUtils.toString(buildingConstructPermitUrl) 				);
		return pt;
	}
	

    public String toString() {
		return org.apache.commons.lang.builder.ToStringBuilder.reflectionToString(this);
	}

    

}