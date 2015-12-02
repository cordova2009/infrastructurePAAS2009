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

import com.hummingbird.common.exception.DataInvalidException;
import com.hummingbird.common.exception.SignatureException;
import com.hummingbird.common.util.DateUtil;
import com.hummingbird.common.util.JsonUtil;
import com.hummingbird.common.util.PropertiesUtil;
import com.hummingbird.common.util.http.HttpRequester;
import com.hummingbird.common.util.json.JSONException;
import com.hummingbird.commonbiz.face.Notification;
import com.hummingbird.commonbiz.face.NotificationResponse;
import com.hummingbird.commonbiz.face.PaymentNotification;
import com.hummingbird.commonbiz.util.NotifyUtil;
import com.hummingbird.commonbiz.util.TransOrderBuilder;
import com.hummingbird.commonbiz.vo.BaseTransVO;
import com.hummingbird.payment.entity.PaymentAlipay;
import com.hummingbird.payment.mapper.PaymentAlipayMapper;
import com.hummingbird.payment.service.PaymentNotifyReceiver;
import com.hummingbird.payment.vo.AlipayNotificationResponse;
import com.hummingbird.payment.vo.AlipayPayNotification;
import com.hummingbird.payment.vo.PaymentBodyVO;


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
			//保存支付信息
			PaymentAlipay pay = savePayment(paymentnotify);
			//通知计费网关
			if(log.isDebugEnabled())
			{
				log.debug("向paas发送支付通知");
			}
			
			PaymentBodyVO pb = new PaymentBodyVO();
			pb.setErrcode(paymentnotify.isPaySuccessed()?0:1);
			pb.setErrmsg(paymentnotify.isPaySuccessed()?"支付成功":"支付失败");
			pb.setPayTime(DateUtil.formatCommonDateorNull(paymentnotify.getPaytime()));
			pb.setOrderId(pay.getOrderId());
			try {
				BaseTransVO<PaymentBodyVO> buildBaseTrans = TransOrderBuilder.buildBaseTrans("alipayment", "alipayment", pb, false, false);
				HttpRequester httpreq = new HttpRequester();// 同步URL，向该URL发起同步请求；
				PropertiesUtil pu = new PropertiesUtil();
				String url =  pu.getProperty("notify.url");
				String postJson;
				postJson = JsonUtil.convert2Json(buildBaseTrans);
				if(log.isDebugEnabled()){
					log.debug(String.format("%s,url=%s,postJson=%s", "支付宝通知",url,postJson));
				}
				boolean flag = httpreq.isCallBackSuccessByStream(url, postJson);
				if (!flag) {// 尝试第二次
					flag = httpreq.isCallBackSuccessByStream(url, postJson);
				}
				if(log.isDebugEnabled()){
					log.debug("通知第三方平台是否成功....success=" + flag);
				}
			} catch (SignatureException e) {
				log.error(String.format("生成签名出错"),e);
			}
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
	public PaymentAlipay savePayment(PaymentNotification paymentnotify) {
		PaymentAlipay payment = new PaymentAlipay();
		payment.setOrderId(paymentnotify.getOrderId());
		payment.setPayTime(paymentnotify.getPaytime());
		payment.setInsertTime(new Date());
		payment.setSum(paymentnotify.getSum());
		if (paymentnotify instanceof AlipayPayNotification) {
			AlipayPayNotification alipaymentnotify = (AlipayPayNotification) paymentnotify;
			payment.setTradeId(alipaymentnotify.getTransId());
		}
//		payment.setAppId(order.getAppId());
		if (log.isDebugEnabled()) {
			log.debug(String.format("保存支付数据%s",payment));
		}
		paymentDao.insert(payment);
		return payment;
	}


}
