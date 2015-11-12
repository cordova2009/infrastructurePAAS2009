package com.hummingbird.paas.vo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.ObjectUtils;

import com.hummingbird.common.util.ValidateUtil;
import com.hummingbird.common.vo.PainttextAble;

/**
 * 保存招标项目资质要求接口 在body VO
 */
public class SaveObjectCertificationInfo 
implements PainttextAble {
    
	    	/**
	     * 用户令牌
	     */
	    protected String token;
	    	/**
	     * 招标项目内部编号
	     */
	    protected String objectId;
	    	/**
	     * 
	     */
	    protected List<Map> bidderCertification;
	    	/**
	     * 需要投标人项目经理,YES,是.NO#,否
	     */
	    protected String needPmCertification;
	    	/**
	     * 需要投标人建造师.YES,是，NO#,否
	     */
	    protected String needConstructorCertification;
	    	/**
	     * 需要安全生产许可证,YES,是.NO#,否
	     */
	    protected String needSafetyPermit;
	    	/**
	     * 需要项目经理安全生产考核合格证.YES,是.NO#,否
	     */
	    protected String needPmSafetyCertification;
	
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
	     * @return 
	     */
	    public List<Map>	    getBidderCertification() {
	        return bidderCertification;
	    }
	
	    /**
	     * @param 
	     */
	    public void setBidderCertification(List<Map> bidderCertification) {
	        this.bidderCertification = bidderCertification;
	    }
	    	/**
	     * @return 需要投标人项目经理,YES,是.NO#,否
	     */
	    public String getNeedPmCertification() {
	        return needPmCertification;
	    }
	
	    /**
	     * @param 需要投标人项目经理,YES,是.NO#,否
	     */
	    public void setNeedPmCertification(String needPmCertification) {
	        this.needPmCertification = needPmCertification;
	    }
	    	/**
	     * @return 需要投标人建造师.YES,是，NO#,否
	     */
	    public String getNeedConstructorCertification() {
	        return needConstructorCertification;
	    }
	
	    /**
	     * @param 需要投标人建造师.YES,是，NO#,否
	     */
	    public void setNeedConstructorCertification(String needConstructorCertification) {
	        this.needConstructorCertification = needConstructorCertification;
	    }
	    	/**
	     * @return 需要安全生产许可证,YES,是.NO#,否
	     */
	    public String getNeedSafetyPermit() {
	        return needSafetyPermit;
	    }
	
	    /**
	     * @param 需要安全生产许可证,YES,是.NO#,否
	     */
	    public void setNeedSafetyPermit(String needSafetyPermit) {
	        this.needSafetyPermit = needSafetyPermit;
	    }
	    	/**
	     * @return 需要项目经理安全生产考核合格证.YES,是.NO#,否
	     */
	    public String getNeedPmSafetyCertification() {
	        return needPmSafetyCertification;
	    }
	
	    /**
	     * @param 需要项目经理安全生产考核合格证.YES,是.NO#,否
	     */
	    public void setNeedPmSafetyCertification(String needPmSafetyCertification) {
	        this.needPmSafetyCertification = needPmSafetyCertification;
	    }
		
	/**
	 * 生成文本组装内容
	 * @return
	 */
	public String getPaintText(){
		String pt = ValidateUtil.sortbyValues(
					ObjectUtils.toString(token) , 					ObjectUtils.toString(objectId) , 					ObjectUtils.toString(bidderCertification) , 					ObjectUtils.toString(needPmCertification) , 					ObjectUtils.toString(needConstructorCertification) , 					ObjectUtils.toString(needSafetyPermit) , 					ObjectUtils.toString(needPmSafetyCertification) 				);
		return pt;
	}
	

    public String toString() {
		return org.apache.commons.lang.builder.ToStringBuilder.reflectionToString(this);
	}

    

}