package com.hummingbird.paas.services;

import java.util.Date;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.hummingbird.common.constant.CommonStatusConst;
import com.hummingbird.common.exception.BusinessException;
import com.hummingbird.common.exception.DataInvalidException;
import com.hummingbird.paas.entity.Order;
import com.hummingbird.paas.util.ProductHandlerFactory;
import com.hummingbird.paas.vo.PayNotifyBodyVO;
import com.hummingbird.paas.vo.PayResult;


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
	public PayResult queryPayResult(String orderId, String payType);

	/**
	 * 支付成功处理
	 * @param order
	 * @throws BusinessException
	 */
	void paySuccess(Order order) throws BusinessException;
	
	/**
	 * 创建订单
	 * @param appId
	 * @param productId
	 * @param userId
	 * @param discount
	 * @return
	 * @throws DataInvalidException
	 */
	public Order createOrder(String appId,String productId,Integer userId,Integer discount) throws DataInvalidException;

		
}