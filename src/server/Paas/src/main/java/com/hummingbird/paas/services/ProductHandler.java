/**
 * 
 * ProductHander.java
 * 版本所有 深圳市蜂鸟娱乐有限公司 2013-2014
 */
package com.hummingbird.paas.services;

import com.hummingbird.common.exception.BusinessException;
import com.hummingbird.paas.entity.Order;

/**
 * @author john huang
 * 2015年12月2日 下午5:35:01
 * 本类主要做为 订单支付后,产品的一些特殊处理
 */
public interface ProductHandler {

	/**
	 * 处理订单
	 * @param order
	 * @return
	 * @throws BusinessException
	 */
	public Object handle(Order order) throws BusinessException;
	
	
	
}
