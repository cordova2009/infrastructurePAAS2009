package com.hummingbird.paas.vo;

import java.util.List;

import org.apache.commons.lang.ObjectUtils;

import com.hummingbird.common.util.ValidateUtil;
import com.hummingbird.common.vo.PainttextAble;

/**
 * 保存投标资格审查信息接口 在body VO
 */
public class SaveBidRequirementInfoBodyVO 
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
	     * 投标记录编号
	     */
	    protected Integer bidId;
	    /**
	     * 投标方选择提交的证书,投标方证书记录编号
	     */
	    protected List<SaveBidRequirementInfoBodyVO_4> certificationList;
	    	/**
	     * 
	     */
	    protected SaveBidRequirementInfoBodyVO_1 bidSafetyInfo;
	    	/**
	     * 
	     */
	    protected SaveBidRequirementInfoBodyVO_2 bidPeopleRequirement;
	    	/**
	     * 
	     */
	    protected SaveBidRequirementInfoBodyVO_3 bankGuarantee;
	
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
	     * @return 投标方选择提交的证书,投标方证书记录编号
	     */
	    public List<SaveBidRequirementInfoBodyVO_4> getCertificationList() {
	        return certificationList;
	    }
	
	    /**
	     * @param 投标方选择提交的证书,投标方证书记录编号
	     */
	    public void setCertificationList(List<SaveBidRequirementInfoBodyVO_4> certificationList) {
	        this.certificationList = certificationList;
	    }
	    	/**
	     * @return 
	     */
	    public SaveBidRequirementInfoBodyVO_1 getBidSafetyInfo() {
	        return bidSafetyInfo;
	    }
	
	    /**
	     * @param 
	     */
	    public void setBidSafetyInfo(SaveBidRequirementInfoBodyVO_1 bidSafetyInfo) {
	        this.bidSafetyInfo = bidSafetyInfo;
	    }
	    	/**
	     * @return 
	     */
	    public SaveBidRequirementInfoBodyVO_2 getBidPeopleRequirement() {
	        return bidPeopleRequirement;
	    }
	
	    /**
	     * @param 
	     */
	    public void setBidPeopleRequirement(SaveBidRequirementInfoBodyVO_2 bidPeopleRequirement) {
	        this.bidPeopleRequirement = bidPeopleRequirement;
	    }
	    	/**
	     * @return 
	     */
	    public SaveBidRequirementInfoBodyVO_3 getBankGuarantee() {
	        return bankGuarantee;
	    }
	
	    /**
	     * @param 
	     */
	    public void setBankGuarantee(SaveBidRequirementInfoBodyVO_3 bankGuarantee) {
	        this.bankGuarantee = bankGuarantee;
	    }
		
	/**
	 * 生成文本组装内容
	 * @return
	 */
	public String getPaintText(){
		String pt = ValidateUtil.sortbyValues(
				   
							ObjectUtils.toString(token) ,
							   
							ObjectUtils.toString(objectId) ,
							   
							ObjectUtils.toString(bidId) ,
							   
							ObjectUtils.toString(certificationList) ,
							   
							ObjectUtils.toString(bidSafetyInfo) ,
							   
							ObjectUtils.toString(bidPeopleRequirement) ,
							   
							ObjectUtils.toString(bankGuarantee) 
							);
		return pt;
	}
	

    public String toString() {
		return org.apache.commons.lang.builder.ToStringBuilder.reflectionToString(this);
	}

    

}