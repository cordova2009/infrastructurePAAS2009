/**
 * 
 * PaymentNotifyReceive.java
 * 版本所有 深圳市蜂鸟娱乐有限公司 2013-2014
 */
package com.hummingbird.payment.service;

import com.hummingbird.common.exception.DataInvalidException;
import com.hummingbird.commonbiz.face.Notification;
import com.hummingbird.commonbiz.face.NotificationResponse;

/**
 * @author huangjiej_2
 * 2015年1月26日 上午11:25:12
 * 本类主要做为 支付通知接收器
 */
public interface PaymentNotifyReceiver {

	/**
	 * 接收通知
	 * @param notity
	 * @throws DataInvalidException 
	 */
	public NotificationResponse receive(Notification notity) throws DataInvalidException;
	
	
	
	
}
