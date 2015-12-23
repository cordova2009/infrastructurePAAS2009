package com.hummingbird.paas.services;

import com.hummingbird.common.exception.BusinessException;
import com.hummingbird.paas.vo.ProjectPaymentConfirmBodyVO;


/**
 * @author 
 * @date 2015-12-13
 * @version 1.0
 *  service接口
 */
public interface ProjectPaymentService  {

			/**
	 * 确认工程付款
	 * @param appId 应用id
	 * @param body 参数
	 * @return 
	 * @throws BusinessException 
	 */
	public void confirmPayment(String appId,ProjectPaymentConfirmBodyVO body) throws BusinessException;
	
		
		
	}