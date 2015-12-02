package com.hummingbird.paas.services;

import com.hummingbird.common.exception.BusinessException;
import com.hummingbird.paas.vo.PayNotifyBodyVO;


/**
 * @author 
 * @date 2015-12-02
 * @version 1.0
 *  service接口
 */
public interface OrderService  {

			/**
	 * 支付宝网关支付通知
	 * @param appId 应用id
	 * @param body 参数
	 * @return 
	 * @throws BusinessException 
	 */
	public void payNotify(String appId,PayNotifyBodyVO body) throws BusinessException;
	
	/**
	 * 查询支付结果
	 * @param orderId
	 * @return
	 */
	public Object queryPayResult(String orderId);
		
}