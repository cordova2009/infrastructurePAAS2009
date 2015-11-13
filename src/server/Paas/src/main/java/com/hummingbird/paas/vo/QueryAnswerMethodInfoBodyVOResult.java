package com.hummingbird.paas.vo;

import java.util.Date;
import org.apache.commons.lang.ObjectUtils;


/**
 * 查询未完成招标答疑方式接口 结果输出 VO
 */
public class QueryAnswerMethodInfoBodyVOResult
{
    
	    /**
	     * 
	     */
	    protected String startTime;
	    	/**
	     * 答疑截止时间
	     */
	    protected String endTime;
	    	/**
	     * 
	     */
	    protected String QQ;
	    	/**
	     * qq群加入口令
	     */
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
	     * 现场答疑时间
	     */
	    protected String addressAnswerTime;
	    /**
	     * 现场答疑时间
	     */
	    protected String addressAnswerDate;
	    
	    
	    	/**
	     * 答疑电话
	     */
	    protected String telephone;
	
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
	     * @return 
	     */
	    public String getQQ() {
	        return QQ;
	    }
	
	    /**
	     * @param 
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
		

	

    public String toString() {
		return org.apache.commons.lang.builder.ToStringBuilder.reflectionToString(this);
	}

	/**
	 * 现场答疑时间 
	 */
	public String getAddressAnswerTime() {
		return addressAnswerTime;
	}

	/**
	 * 现场答疑时间 
	 */
	public void setAddressAnswerTime(String addressAnswerTime) {
		this.addressAnswerTime = addressAnswerTime;
	}

	/**
	 * 现场答疑时间 
	 */
	public String getAddressAnswerDate() {
		return addressAnswerDate;
	}

	/**
	 * 现场答疑时间 
	 */
	public void setAddressAnswerDate(String addressAnswerDate) {
		this.addressAnswerDate = addressAnswerDate;
	}

    

}