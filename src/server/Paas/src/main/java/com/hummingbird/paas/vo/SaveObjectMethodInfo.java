package com.hummingbird.paas.vo;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang.ObjectUtils;

import com.hummingbird.common.util.ValidateUtil;
import com.hummingbird.common.vo.PainttextAble;

/**
 * saveObjectMethodInfo 在body VO
 */
public class SaveObjectMethodInfo 
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
	     * 招标方式,"OPEN",公开招标。"INVI",邀请投标。
	     */
	    protected String objectMethod;
	    	/**
	     * 
	     */
	    protected List<InviteTenderVO> inviteTender;
	
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
	     * @return 招标方式,"OPEN",公开招标。"INVI",邀请投标。
	     */
	    public String getObjectMethod() {
	        return objectMethod;
	    }
	
	    /**
	     * @param 招标方式,"OPEN",公开招标。"INVI",邀请投标。
	     */
	    public void setObjectMethod(String objectMethod) {
	        this.objectMethod = objectMethod;
	    }
	    	/**
	     * @return 
	     */
	    public List<InviteTenderVO> getInviteTender() {
	        return inviteTender;
	    }
	
	    /**
	     * @param 
	     */
	    public void setInviteTender(List<InviteTenderVO> inviteTender) {
	        this.inviteTender = inviteTender;
	    }
		
	/**
	 * 生成文本组装内容
	 * @return
	 */
	public String getPaintText(){
		String pt = ValidateUtil.sortbyValues(
					ObjectUtils.toString(token) , 					ObjectUtils.toString(objectId) , 					ObjectUtils.toString(objectMethod) , 					ObjectUtils.toString(inviteTender) 				);
		return pt;
	}
	

    public String toString() {
		return org.apache.commons.lang.builder.ToStringBuilder.reflectionToString(this);
	}

    

}