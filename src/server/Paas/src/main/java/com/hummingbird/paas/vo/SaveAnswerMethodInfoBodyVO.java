package com.hummingbird.paas.vo;

import java.util.Date;
import org.apache.commons.lang.ObjectUtils;
import org.codehaus.jackson.annotate.JsonProperty;

import com.hummingbird.common.util.ValidateUtil;
import com.hummingbird.common.vo.PainttextAble;

/**
 * 保存招标答疑方式接口 在body VO
 */
public class SaveAnswerMethodInfoBodyVO 
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
	     * 
	     */
	    protected String startTime;
	    	/**
	     * 答疑截止时间
	     */
	    protected String endTime;
	    	/**
	     * 答疑qq群
	     */
	    @JsonProperty("QQ")
	    protected String QQ;
	    	/**
	     * qq群加入口令
	     */
	    @JsonProperty("QQtoken")
	    protected String QQtoken;
	    	/**
	     * 答疑邮件
	     */
	    protected String email;
	    	/**
	     * 答疑地址
	     */
	    protected String address;
	    	/**
	     * 答疑时间
	     */
	    protected String addressAnswerTime;
	    /**
	     * 答疑日期
	     */
	    protected String addressAnswerDate;
	    	/**
	     * 答疑电话
	     */
	    protected String telephone;
	
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
	     * @return 
	     */
	    public String getStartTime() {
	        return startTime;
	    }
	
	    /**
	     * @param 
	     */
	    public void setStartTime(String startTime) {
	        this.startTime = startTime;
	    }
	    	/**
	     * @return 答疑截止时间
	     */
	    public String getEndTime() {
	        return endTime;
	    }
	
	    /**
	     * @param 答疑截止时间
	     */
	    public void setEndTime(String endTime) {
	        this.endTime = endTime;
	    }
	    	/**
	     * @return 答疑qq群
	     */
	    public String getQQ() {
	        return QQ;
	    }
	
	    /**
	     * @param 答疑qq群
	     */
	    public void setQQ(String QQ) {
	        this.QQ = QQ;
	    }
	    	/**
	     * @return qq群加入口令
	     */
	    public String getQQtoken() {
	        return QQtoken;
	    }
	
	    /**
	     * @param qq群加入口令
	     */
	    public void setQQtoken(String QQtoken) {
	        this.QQtoken = QQtoken;
	    }
	    	/**
	     * @return 答疑邮件
	     */
	    public String getEmail() {
	        return email;
	    }
	
	    /**
	     * @param 答疑邮件
	     */
	    public void setEmail(String email) {
	        this.email = email;
	    }
	    	/**
	     * @return 答疑地址
	     */
	    public String getAddress() {
	        return address;
	    }
	
	    /**
	     * @param 答疑地址
	     */
	    public void setAddress(String address) {
	        this.address = address;
	    }

	    	/**
	     * @return 答疑电话
	     */
	    public String getTelephone() {
	        return telephone;
	    }
	
	    /**
	     * @param 答疑电话
	     */
	    public void setTelephone(String telephone) {
	        this.telephone = telephone;
	    }
		
	/**
	 * 生成文本组装内容
	 * @return
	 */
	public String getPaintText(){
		String pt = ValidateUtil.sortbyValues(
					ObjectUtils.toString(token) ,
					ObjectUtils.toString(objectId) , 
					ObjectUtils.toString(startTime) , 
					ObjectUtils.toString(endTime) , 	
					ObjectUtils.toString(QQ) , 		
					ObjectUtils.toString(QQtoken) , 
					ObjectUtils.toString(email) , 
					ObjectUtils.toString(address) , 
					ObjectUtils.toString(addressAnswerTime) , 	
					ObjectUtils.toString(addressAnswerDate) , 	
					ObjectUtils.toString(telephone) 				);
		return pt;
	}
	

    public String toString() {
		return org.apache.commons.lang.builder.ToStringBuilder.reflectionToString(this);
	}

	/**
	 * 答疑时间 
	 */
	public String getAddressAnswerTime() {
		return addressAnswerTime;
	}

	/**
	 * 答疑时间 
	 */
	public void setAddressAnswerTime(String addressAnswerTime) {
		this.addressAnswerTime = addressAnswerTime;
	}

	/**
	 * 答疑日期 
	 */
	public String getAddressAnswerDate() {
		return addressAnswerDate;
	}

	/**
	 * 答疑日期 
	 */
	public void setAddressAnswerDate(String addressAnswerDate) {
		this.addressAnswerDate = addressAnswerDate;
	}

    

}