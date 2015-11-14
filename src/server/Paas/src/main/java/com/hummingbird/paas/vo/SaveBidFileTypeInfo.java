package com.hummingbird.paas.vo;

import java.util.Date;
import org.apache.commons.lang.ObjectUtils;

import com.hummingbird.common.util.ValidateUtil;
import com.hummingbird.common.vo.PainttextAble;

/**
 * 保存招标项目投标文件接口 在body VO
 */
public class SaveBidFileTypeInfo 
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
	     * 
	     */
	    protected String needBusinessStandard;
	    	/**
	     * 投标方是否需要上传技术标书，YES，是。NO#，否。
	     */
	    protected String needTechnicalStandard;
	    	/**
	     * 投标方是否需要上传资格审查文件，YES，是。NO#，否。
	     */
	    protected String needCertificationCheckupFile;
	
	    	/**
	     * @return 
	     */
	    public String getNeedBusinessStandard() {
	        return needBusinessStandard;
	    }
	
	    /**
	     * @param 
	     */
	    public void setNeedBusinessStandard(String needBusinessStandard) {
	        this.needBusinessStandard = needBusinessStandard;
	    }
	    	/**
	     * @return 投标方是否需要上传技术标书，YES，是。NO#，否。
	     */
	    public String getNeedTechnicalStandard() {
	        return needTechnicalStandard;
	    }
	
	    /**
	     * @param 投标方是否需要上传技术标书，YES，是。NO#，否。
	     */
	    public void setNeedTechnicalStandard(String needTechnicalStandard) {
	        this.needTechnicalStandard = needTechnicalStandard;
	    }
	    	/**
	     * @return 投标方是否需要上传资格审查文件，YES，是。NO#，否。
	     */
	    public String getNeedCertificationCheckupFile() {
	        return needCertificationCheckupFile;
	    }
	
	    /**
	     * @param 投标方是否需要上传资格审查文件，YES，是。NO#，否。
	     */
	    public void setNeedCertificationCheckupFile(String needCertificationCheckupFile) {
	        this.needCertificationCheckupFile = needCertificationCheckupFile;
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
	 * 生成文本组装内容
	 * @return
	 */
	public String getPaintText(){
		String pt = ValidateUtil.sortbyValues(
					ObjectUtils.toString(objectId) , ObjectUtils.toString(token) , 
					ObjectUtils.toString(needCertificationCheckupFile) 	,
					ObjectUtils.toString(needTechnicalStandard) 	,
					ObjectUtils.toString(needBusinessStandard) 	
					);
		return pt;
	}
	

    public String toString() {
		return org.apache.commons.lang.builder.ToStringBuilder.reflectionToString(this);
	}

    

}