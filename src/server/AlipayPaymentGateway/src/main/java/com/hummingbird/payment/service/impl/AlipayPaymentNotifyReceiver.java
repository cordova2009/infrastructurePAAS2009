/**
 * 
 * MMPaymentNotifyReceiver.java
 * 版本所有 深圳市蜂鸟娱乐有限公司 2013-2014
 */
package com.hummingbird.payment.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.hummingbird.common.constant.CommonStatusConst;
import com.hummingbird.common.exception.DataInvalidException;
import com.hummingbird.commonbiz.face.Notification;
import com.hummingbird.commonbiz.face.NotificationResponse;
import com.hummingbird.commonbiz.face.PaymentNotification;
import com.hummingbird.commonbiz.util.NotifyUtil;
import com.hummingbird.fnbilling.constant.PayConst;
import com.hummingbird.fnbilling.entity.Order;
import com.hummingbird.fnbilling.entity.PaymentAlipay;
import com.hummingbird.fnbilling.mapper.PaymentAlipayMapper;
import com.hummingbird.fnbilling.service.DeviceService;
import com.hummingbird.fnbilling.service.OrderService;
import com.hummingbird.fnbilling.service.PaymentNotifyReceiver;
import com.hummingbird.fnbilling.vo.PaymentBillingVO;
import com.hummingbird.payment.vo.AlipayNotificationResponse;
import com.hummingbird.payment.vo.AlipayPayNotification;


/**
 * @author john huang
 * 2015年3月29日 上午10:38:37
 * 本类主要做为 支付宝支付通知接收器
 */
@Service("alipayPaymentNotifyReceiver")
public class AlipayPaymentNotifyReceiver  implements PaymentNotifyReceiver {

	org.apache.commons.logging.Log log = org.apache.commons.logging.LogFactory
			.getLog(this.getClass());
	
	@Autowired
	OrderService orderSrv;
	@Autowired
	DeviceService deviceSrv;
	@Autowired
	PaymentAlipayMapper paymentDao;
	
	
	/**
	 * 接收通知
	 * @param notity
	 * @throws DataInvalidException 
	 */
	@Transactional(propagation=Propagation.REQUIRED,rollbackFor=Exception.class,value="txManager")
	public NotificationResponse receive(Notification notity) throws DataInvalidException
	{
		AlipayNotificationResponse response = new AlipayNotificationResponse();
		if (notity instanceof PaymentNotification) {
			PaymentNotification paymentnotify = (PaymentNotification) notity;
			//计费订单号
			String orderid = paymentnotify.getOrderId();
			//查找订单
			Order order = orderSrv.getOrderByAppOrderId(orderid);
			if(order==null)
			{
				if (log.isDebugEnabled()) {
					log.debug(String.format("根据sdk订单号[%s]查询不到订单",orderid));
				}
				response.setSuccessed(false);
				return  response;
			}
//			//检查订单状态
//			if(!CommonStatusConst.STATUS_CREATE.equals(order.getStatus())){
//				if (log.isDebugEnabled()) {
//					log.debug(String.format("订单[%s]的状态不为已创建%s",orderid,order.getStatus()));
//				}
//				response.setSuccessed(false);
//				return  response;
//			}
			
//			//更新订单结果
//			order.setStatus(CommonStatusConst.STATUS_OK);
//			order.setFinalCommand(getBillingCommand());
//			order.setErrmsg("支付成功");
//			order.setPayTime(paymentnotify.getPaytime());
//			orderSrv.updateOrder(order);
			//保存支付信息
			PaymentAlipay pay = savePayment(paymentnotify,order);
			//通知计费网关
			if(log.isDebugEnabled())
			{
				log.debug("向fnbilling发送支付请求");
			}
			PaymentBillingVO pb = new PaymentBillingVO();
			pb.setBillingCommand(getBillingCommand());
			pb.setErrcode(paymentnotify.isPaySuccessed()?0:1000);
			pb.setErrmsg("支付成功");
			pb.setPayTimeByDate(paymentnotify.getPaytime());
			pb.setOrderId(pay.getOrderId());
			NotifyUtil.asynNotify(pb);
		}
		else{
			if (log.isDebugEnabled()) {
				log.debug(String.format("通知对象类型%s并非支付通知，不能操作",notity));
			}
			response.setSuccessed(false);
			return  response;
		}
		return response;
	}

	/**
	 * @param paymentnotify
	 * @return 
	 */
	@Transactional(propagation=Propagation.REQUIRED,rollbackFor=Exception.class,value="txManager")
	public PaymentAlipay savePayment(PaymentNotification paymentnotify,Order order) {
		
		PaymentAlipay payment = new PaymentAlipay();
		payment.setOrderId(order.getOrderId());
		payment.setPayTime(paymentnotify.getPaytime());
		payment.setCreateTime(new Date());
		payment.setMobileNum(order.getMobileNum());
		payment.setSdkOrderId(order.getSdkOrderId());
		payment.setSum(paymentnotify.getSum());
		payment.setBuyerId(order.getBuyerId());
		payment.setBuyerType(order.getBuyerType());
		payment.setAppId(order.getAppId());
		
		
		if (paymentnotify instanceof AlipayPayNotification) {
			AlipayPayNotification req = (AlipayPayNotification) paymentnotify;
			payment.setTransId(req.getTransId());
			
//			payment.setAppId(order.getAppId());
//			payment.setAppId_mm_sdk(req.getAppID());
		}
		if (log.isDebugEnabled()) {
			log.debug(String.format("保存支付数据%s",payment));
		}
		paymentDao.insert(payment);
		return payment;
	}

	/**
	 * @return
	 */
	private String getBillingCommand() {
		return PayConst.TYPE_ALI;
	}

}
