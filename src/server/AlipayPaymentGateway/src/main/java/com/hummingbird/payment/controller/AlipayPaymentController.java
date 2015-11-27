/**
 * 
 * CMCCMMPaymentController.java
 * 版本所有 深圳市蜂鸟娱乐有限公司 2013-2014
 */
package com.hummingbird.payment.controller;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.ObjectUtils;
import org.apache.commons.lang.math.NumberUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hummingbird.common.controller.BaseController;
import com.hummingbird.common.util.DateUtil;
import com.hummingbird.common.util.RequestUtil;
import com.hummingbird.commonbiz.face.NotificationResponse;
import com.hummingbird.commonbiz.vo.HttpResponseWapper;
import com.hummingbird.fnbilling.service.OrderService;
import com.hummingbird.fnbilling.service.PaymentNotifyReceiver;
import com.hummingbird.payment.util.AlipayNotify;
import com.hummingbird.payment.vo.AlipayPayNotification;

/**
 * @author john huang
 * 2015年3月28日 下午10:35:18
 * 本类主要做为移动mm支付通知处理类
 */
@Controller
@RequestMapping("/alipay")
public class AlipayPaymentController extends BaseController{

	
	@Autowired
	OrderService orderSrv;
	@Autowired
	PaymentNotifyReceiver receiver;
	
	
	/**
	 * 啊里计费订单结果通知接口
	 * 
	 * @author kimi
	 * @dateTime 2012-6-18 下午8:21:33
	 * @param result
	 * @param request
	 * @param response
	 * @param model
	 * @return ，只接收成功的
	 * @throws Exception
	 */
	@RequestMapping(value = "/alipay_payment_notify", method = RequestMethod.POST)
	protected void paymentNotify(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		if (log.isDebugEnabled()) {
			log.debug(String.format("接收到啊里的支付成功通知%s",RequestUtil.geturl(request)));
		}
		//获取内容
		//获取支付宝POST过来反馈信息
		Map<String,String> params = new HashMap<String,String>();
		Map requestParams = request.getParameterMap();
		for (Iterator iter = requestParams.keySet().iterator(); iter.hasNext();) {
			String name = (String) iter.next();
			String[] values = (String[]) requestParams.get(name);
			String valueStr = "";
			for (int i = 0; i < values.length; i++) {
				valueStr = (i == values.length - 1) ? valueStr + values[i]
						: valueStr + values[i] + ",";
			}
			//乱码解决，这段代码在出现乱码时使用。如果mysign和sign不相等也可以使用这段代码转化
			//valueStr = new String(valueStr.getBytes("ISO-8859-1"), "gbk");
			params.put(name, valueStr);
		}
		boolean skipverify = false;
		if("1".equals(params.get("fnbillingtest"))||"true".equalsIgnoreCase(params.get("fnbillingtest"))){
			skipverify=true;
			params.remove("fnbillingtest");
		}
		
		//获取支付宝的通知返回参数，可参考技术文档中页面跳转同步通知参数列表(以下仅供参考)//
		//商户订单号
		String out_trade_no = new String(request.getParameter("out_trade_no").getBytes("ISO-8859-1"),"UTF-8");
		//支付宝交易号
		String trade_no = new String(request.getParameter("trade_no").getBytes("ISO-8859-1"),"UTF-8");
		//交易状态
		String trade_status = new String(request.getParameter("trade_status").getBytes("ISO-8859-1"),"UTF-8");
		String paytime =   params.get("notify_time");
		float total_fee =  NumberUtils.toFloat(ObjectUtils.toString( params.get("total_fee")),0);
		
		AlipayPayNotification notification = new AlipayPayNotification();
		notification.setOrderId(out_trade_no);
		notification.setPaytime(DateUtil.parse(paytime).getTime());
		notification.setTransId(trade_no);
		notification.setSum((int)(total_fee*100));
		
		if(skipverify||AlipayNotify.verify(params)){//验证成功
			if (log.isDebugEnabled()) {
				log.debug(String.format("通知验证成功"+(skipverify?",参数中要求使用测试模式":"")+",当前交易状态为:%s",trade_status));
			}
		
			//请在这里加上商户的业务逻辑程序代码
			//——请根据您的业务逻辑来编写程序（以下代码仅作参考）——
			if(trade_status.equals("TRADE_FINISHED")){
				//判断该笔订单是否在商户网站中已经做过处理
					//如果没有做过处理，根据订单号（out_trade_no）在商户网站的订单系统中查到该笔订单的详细，并执行商户的业务程序
					//如果有做过处理，不执行商户的业务程序
				if (log.isDebugEnabled()) {
					log.debug(String.format("交易订单状态是交易完成，执行余下的处理"));
				}
				notification.setPaysuccessed(true);	
				NotificationResponse receive = receiver.receive(notification);
				receive.doReply(new HttpResponseWapper(response));
				//注意：
				//该种交易状态只在两种情况下出现
				//1、开通了普通即时到账，买家付款成功后。
				//2、开通了高级即时到账，从该笔交易成功时间算起，过了签约时的可退款时限（如：三个月以内可退款、一年以内可退款等）后。
			} else if (trade_status.equals("TRADE_SUCCESS")){
				if (log.isDebugEnabled()) {
					log.debug(String.format("交易订单状态是交易成功，执行余下的处理"));
				}
				//判断该笔订单是否在商户网站中已经做过处理
					//如果没有做过处理，根据订单号（out_trade_no）在商户网站的订单系统中查到该笔订单的详细，并执行商户的业务程序
					//如果有做过处理，不执行商户的业务程序
				notification.setPaysuccessed(true);	
				NotificationResponse receive = receiver.receive(notification);
				receive.doReply(new HttpResponseWapper(response));
				
				//注意：
				//该种交易状态只在一种情况下出现——开通了高级即时到账，买家付款成功后。
			}
			else  if (trade_status.equals("WAIT_BUYER_PAY")){
				if (log.isDebugEnabled()) {
					log.debug(String.format("目前交易状态是等待支付,不处理"));
				}
			}
			else{
				if (log.isDebugEnabled()) {
					log.debug(String.format("目前交易状态并非是交易成功,不处理"));
				}
				
			}
		
		}
	}
	
}
