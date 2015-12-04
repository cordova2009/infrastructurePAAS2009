package com.hummingbird.payment.vo;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;
import org.apache.commons.lang.ObjectUtils;

import com.hummingbird.common.exception.DataInvalidException;
import com.hummingbird.common.util.JsonUtil;
import com.hummingbird.common.util.PropertiesUtil;
import com.hummingbird.common.util.ValidateUtil;
import com.hummingbird.common.util.json.JSONException;
import com.hummingbird.common.vo.PainttextAble;
import com.hummingbird.commonbiz.vo.Notifiable;

/**
 * 支付宝网关支付通知 在body VO
 */
public class PaymentBodyVO
implements PainttextAble, Notifiable {

    	    	/**
	     * 支付结果，0-成功，1-失败
	     */
	    protected Integer errcode;
	    	/**
	     * 支付信息
	     */
	    protected String errmsg;
	    	/**
	     * 
	     */
	    protected String orderId;
	    	/**
	     * 支付时间(字符串格式) yyyy-MM-dd HH:mm:ss
	     */
	    protected String payTime;
	
	    	/**
	     * @return 支付结果，0-成功，1-失败
	     */
	    public Integer getErrcode() {
	        return errcode;
	    }
	
	    /**
	     * @param 支付结果，0-成功，1-失败
	     */
	    public void setErrcode(Integer errcode) {
	        this.errcode = errcode;
	    }
	    	/**
	     * @return 支付信息
	     */
	    public String getErrmsg() {
	        return errmsg;
	    }
	
	    /**
	     * @param 支付信息
	     */
	    public void setErrmsg(String errmsg) {
	        this.errmsg = errmsg;
	    }
	    	/**
	     * @return 
	     */
	    public String getOrderId() {
	        return orderId;
	    }
	
	    /**
	     * @param 
	     */
	    public void setOrderId(String orderId) {
	        this.orderId = orderId;
	    }
	    	/**
	     * @return 支付时间(字符串格式) yyyy-MM-dd HH:mm:ss
	     */
	    public String getPayTime() {
	        return payTime;
	    }
	
	    /**
	     * @param 支付时间(字符串格式) yyyy-MM-dd HH:mm:ss
	     */
	    public void setPayTime(String payTime) {
	        this.payTime = payTime;
	    }
		
	/**
	 * 生成文本组装内容
	 * @return
	 */
	public String getPaintText(){
		String pt = ValidateUtil.sortbyValues(
				   
							ObjectUtils.toString(errcode) ,
							   
							ObjectUtils.toString(errmsg) ,
							   
							ObjectUtils.toString(orderId) ,
							   
							ObjectUtils.toString(payTime) 
							);
		return pt;
	}
	

    public String toString() {
		return org.apache.commons.lang.builder.ToStringBuilder.reflectionToString(this);
	}

	/* (non-Javadoc)
	 * @see com.hummingbird.commonbiz.vo.Notifiable#toJson()
	 */
	@Override
	public String toJson() throws JSONException {
		try {
			return JsonUtil.convert2Json(this);
		} catch (DataInvalidException e) {
			throw new JSONException("转换出错",e);
		}
	}

	/* (non-Javadoc)
	 * @see com.hummingbird.commonbiz.vo.Notifiable#getNotifyUrl()
	 */
	@Override
	public String getNotifyUrl() {
		PropertiesUtil pu = new PropertiesUtil();
		return pu.getProperty("notify.url");
	}

	/* (non-Javadoc)
	 * @see com.hummingbird.commonbiz.vo.Notifiable#getDesc()
	 */
	@Override
	public String getDesc() {
		return "支付宝通知";
	}

    

}