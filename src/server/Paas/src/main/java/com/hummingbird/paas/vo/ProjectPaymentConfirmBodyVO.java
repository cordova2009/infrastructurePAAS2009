package com.hummingbird.paas.vo;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;
import org.apache.commons.lang.ObjectUtils;

import com.hummingbird.common.util.ValidateUtil;
import com.hummingbird.common.vo.PainttextAble;

/**
 * 确认工程付款 在body VO
 */
public class ProjectPaymentConfirmBodyVO
implements PainttextAble {

    	    	/**
	     * 
	     */
	    protected String orderId;
	    	/**
	     * 确认状态,OK# 确认收到付款,FLS 付款失败
	     */
	    protected String confirmStatus;
	    	/**
	     * 备注
	     */
	    protected String remark;
	    	/**
	     * 操作人
	     */
	    protected String operator;
	
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
	     * @return 确认状态,OK# 确认收到付款,FLS 付款失败
	     */
	    public String getConfirmStatus() {
	        return confirmStatus;
	    }
	
	    /**
	     * @param 确认状态,OK# 确认收到付款,FLS 付款失败
	     */
	    public void setConfirmStatus(String confirmStatus) {
	        this.confirmStatus = confirmStatus;
	    }
	    	/**
	     * @return 备注
	     */
	    public String getRemark() {
	        return remark;
	    }
	
	    /**
	     * @param 备注
	     */
	    public void setRemark(String remark) {
	        this.remark = remark;
	    }
	    	/**
	     * @return 操作人
	     */
	    public String getOperator() {
	        return operator;
	    }
	
	    /**
	     * @param 操作人
	     */
	    public void setOperator(String operator) {
	        this.operator = operator;
	    }
		
	/**
	 * 生成文本组装内容
	 * @return
	 */
	public String getPaintText(){
		String pt = ValidateUtil.sortbyValues(
				   
							ObjectUtils.toString(orderId) ,
							   
							ObjectUtils.toString(confirmStatus) ,
							   
							ObjectUtils.toString(remark) ,
							   
							ObjectUtils.toString(operator) 
							);
		return pt;
	}
	

    public String toString() {
		return org.apache.commons.lang.builder.ToStringBuilder.reflectionToString(this);
	}

    

}