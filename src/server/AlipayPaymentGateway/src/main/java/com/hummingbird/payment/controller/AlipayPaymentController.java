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
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.NumberUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hummingbird.common.constant.CommonStatusConst;
import com.hummingbird.common.controller.BaseController;
import com.hummingbird.common.event.EventListenerContainer;
import com.hummingbird.common.ext.AccessRequered;
import com.hummingbird.common.util.DateUtil;
import com.hummingbird.common.util.PropertiesUtil;
import com.hummingbird.common.util.RequestUtil;
import com.hummingbird.common.util.http.HttpRequester;
import com.hummingbird.common.vo.ResultModel;
import com.hummingbird.commonbiz.face.NotificationResponse;
import com.hummingbird.commonbiz.vo.BaseTransVO;
import com.hummingbird.commonbiz.vo.HttpResponseWapper;
import com.hummingbird.payment.event.DuplicateMessageEvent;
import com.hummingbird.payment.service.PaymentNotifyReceiver;
import com.hummingbird.payment.util.AlipayNotify;
import com.hummingbird.payment.util.Payment;
import com.hummingbird.payment.util.XmlBeanConvertUtil;
import com.hummingbird.payment.util.dom4j;
import com.hummingbird.payment.vo.AlipayNotificationResponse;
import com.hummingbird.payment.vo.AlipayOrderResultQueryBodyVO;
import com.hummingbird.payment.vo.AlipayOrderResultResultVO;
import com.hummingbird.payment.vo.AlipayOrderResultVO;
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
	PaymentNotifyReceiver receiver;
	
	static Map<String, String> errorcodemap = new HashMap<>();
	
	static{
		errorcodemap.put("EXPARTNER_INFO_UNCORRECT","传入外部商户接口信息不正确");
		errorcodemap.put("TRADE_BUYER_NOT_MATCH","买家账户与交易中不一致");
		errorcodemap.put("TRADE_SELLER_NOT_MATCH","卖家账户与交易中不一致");
		errorcodemap.put("TRADE_DATA_NOT_MATCH","请求数据与交易中不一致");
		errorcodemap.put("SELLER_NOT_IN_SPECIFIED_SELLERS","卖家不在指定的商户限制卖家中");
		errorcodemap.put("ILLEGAL_SIGN","签名验证出错");
		errorcodemap.put("ILLEGAL_ARGUMENT","输入参数有错误");
		errorcodemap.put("HASH_NO_PRIVILEGE","没有权限访问该服务");
		errorcodemap.put("ILLEGAL_SERVICE","service参数不正确");
		errorcodemap.put("ILLEGAL_PARTNER","合作身份者ID不正确");
		errorcodemap.put("HAS_NO_PUBLICKEY","没有上传公钥");
		errorcodemap.put("USER_NOT_EXIST","会员不存在");
		errorcodemap.put("OUT_TRADE_NO_EXIST","外部交易号已经存在");
		errorcodemap.put("TRADE_NOT_EXIST","交易不存在");
		errorcodemap.put("ILLEGAL_PAYMENT_TYPE","无效支付类型");
		errorcodemap.put("BUYER_NOT_EXIST","买家不存在");
		errorcodemap.put("SELLER_NOT_EXIST","卖家不存在");
		errorcodemap.put("BUYER_SELLER_EQUAL","买家、卖家是同一帐户");
		errorcodemap.put("ILLEGAL_SIGN_TYPE","签名类型不正确");
		errorcodemap.put("COMMISION_ID_NOT_EXIST","佣金收取帐户不存在");
		errorcodemap.put("COMMISION_SELLER_DUPLICATE","收取佣金帐户和卖家是同一帐户");
		errorcodemap.put("COMMISION_FEE_OUT_OF_RANGE","佣金金额超出范围");
		errorcodemap.put("ILLEGAL_LOGISTICS_FORMAT","无效物流格式");
		errorcodemap.put("TOTAL_FEE_LESSEQUAL_ZERO","交易总金额小于等于0");
		errorcodemap.put("TOTAL_FEE_OUT_OF_RANGE","交易总金额超出范围");
		errorcodemap.put("ILLEGAL_FEE_PARAM","非法交易金额格式（参考单价、总价、数量三个组合规则");
		errorcodemap.put("DONATE_GREATER_THAN_MAX","小额捐赠总金额超出最大值限制");
		errorcodemap.put("DIRECT_PAY_AMOUNT_OUT_OF_RANGE","快速付款交易总金额超出最大值限制");
		errorcodemap.put("DIGITAL_FEE_GREATER_THAN_MAX","虚拟物品交易总金额超出最大值限制");
		errorcodemap.put("SELF_TIMEOUT_NOT_SUPPORT","不支持自定义超时");
		errorcodemap.put("COMMISION_NOT_SUPPORT","不支持佣金");
		errorcodemap.put("VIRTUAL_NOT_SUPPORT","不支持虚拟収货方式");
		errorcodemap.put("ILLEGAL_DYN_MD5_KEY","动态密钥信息错误");
		errorcodemap.put("ILLEGAL_ENCRYPT","加密不正确");
		errorcodemap.put("ILLEGAL_USER","用户ID不正确");
		errorcodemap.put("ILLEGAL_EXTERFACE","接口配置不正确");
		errorcodemap.put("ILLEGAL_PARTNER_EXTERFACE","合作伙伴接口信息不正确");
		errorcodemap.put("ILLEGAL_SECURITY_PROFILE","未找到匹配的密钥配置");
		errorcodemap.put("ILLEGAL_AGENT","代理ID不正确");
		errorcodemap.put("ILLEGAL_CHARSET","字符集不合法");
		errorcodemap.put("ILLEGAL_CLIENT_IP","客户端IP地址无权访问服务");
		errorcodemap.put("SYSTEM_ERROR","支付宝系统错误");
		errorcodemap.put("SESSION_TIMEOUT","session超时");
		errorcodemap.put("ILLEGAL_DIGEST_TYPE","摘要类型不正确");
		errorcodemap.put("ILLEGAL_DIGEST","文件摘要不正确");
		errorcodemap.put("ILLEGAL_FILE_FORMAT","文件格式不正确");
		errorcodemap.put("ILLEGAL_TARGET_SERVICE","错误的target_service");
		errorcodemap.put("ILLEGAL_ACCESS_SWITCH_SYSTEM","partner不允许访问该类型的系统");
		errorcodemap.put("ILLEGAL_SWITCH_SYSTEM","切换系统异常");
		errorcodemap.put("ILLEGAL_ENCODING","不支持该编码类型");
		errorcodemap.put("EXTERFACE_IS_CLOSED","外部接口已关闭");
		errorcodemap.put("ILLEGAL_REQUEST_REFERER","防钓鱼检查不支持该请求来源");
		errorcodemap.put("ILLEGAL_ANTI_PHISHING_KEY","防钓鱼检查非法时间戳参数");
		errorcodemap.put("ANTI_PHISHING_KEY_TIMEOUT","防钓鱼检查时间戳超时");
		errorcodemap.put("ILLEGAL_EXTER_INVOKE_IP","防钓鱼检查非法外部调用IP");
	}
	
	
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
		try {
			
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
			boolean validateed = true;
			if(!skipverify){
				try {
					validateed =AlipayNotify.verify(params);
				} catch (Exception e) {
					log.error(String.format("签名验证失败,不执行后续处理"),e);
					AlipayNotificationResponse receive = new AlipayNotificationResponse();
					receive.setSuccessed(true);
					receive.doReply(new HttpResponseWapper(response));
					return;
				}
			}
			
			if(validateed){//验证成功
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
				
				String qs = request.getQueryString();
				DuplicateMessageEvent event = new DuplicateMessageEvent(qs);
				EventListenerContainer.getInstance().fireEvent(event);
			}
			else{
				log.error(String.format("签名验证失败,不执行后续处理"));
				AlipayNotificationResponse receive = new AlipayNotificationResponse();
				receive.setSuccessed(true);
				receive.doReply(new HttpResponseWapper(response));
				return;
			}
		} catch (Exception e) {
			log.error("处理失败",e);
			AlipayNotificationResponse receive = new AlipayNotificationResponse();
			receive.setSuccessed(false);
			receive.doReply(new HttpResponseWapper(response));
		}
	}
	
	/**
	 * 查询支付结果
	 * 
	 * @author kimi
	 * @dateTime 2012-6-18 下午8:21:33
	 * @param result
	 * @param request
	 * @param response
	 * @param model
	 * @return 
	 * @return ，只接收成功的
	 * @throws Exception
	 */
	@RequestMapping(value = "/queryPayResult", method = RequestMethod.POST)
	@AccessRequered(methodName = "查询支付结果",isJson=true,codebase=200100,className="com.hummingbird.commonbiz.vo.BaseTransVO",genericClassName="com.hummingbird.payment.vo.AlipayOrderResultQueryBodyVO",appLog=true)
	protected @ResponseBody ResultModel queryPayResult(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		if (log.isDebugEnabled()) {
			log.debug(String.format("查询支付结果%s",RequestUtil.geturl(request)));
		}
		ResultModel rm = this.getResultModel();
		BaseTransVO<AlipayOrderResultQueryBodyVO> transOrder =(BaseTransVO<AlipayOrderResultQueryBodyVO>) this.getParameterObject();
		
		PropertiesUtil pu = new PropertiesUtil();
		//获取内容
		String paygateway = "https://www.alipay.com/cooperate/gateway.do?"; //支付接口(不可修改)
		String service = "single_trade_query";//支付宝查询服务--单笔查询服务(不可修改)
		String sign_type = "MD5";//加密机制(不可修改)
		String out_trade_no = transOrder.getBody().getOrderId();	//商户网站订单（也就是外部订单号，是通过客户网站传给支付宝，不可以重复）
//		out_trade_no = "SD001511119897575658";
		String input_charset = pu.getProperty("input_charset");   //页面编码(不可修改)
		//partner和key提取方法：登陆签约支付宝账户--->点击“商家服务”就可以看到
		String partner = pu.getProperty("partner"); //支付宝合作伙伴id (账户内提取)
		String key = pu.getProperty("key"); //支付宝安全校验码(账户内提取)
		//查询地址,返回的是xml
		String ItemUrl = Payment.CreateUrl(paygateway, service, partner, sign_type,
				out_trade_no, key, input_charset);
		String aliresult = new HttpRequester().sendGet(ItemUrl, new HashMap<>());
		AlipayOrderResultVO orderResult = XmlBeanConvertUtil.xml2bean(aliresult,new AlipayOrderResultVO());
		//解析结果
		boolean isSuccess = StringUtils.equals(orderResult.getIsSuccess(),"T");//是否成功,T,F 否
		AlipayOrderResultResultVO result = new AlipayOrderResultResultVO();
		result.setPayType("ALIPAY");
		if(isSuccess){
			//解析其它
			if (log.isDebugEnabled()) {
				log.debug(String.format("支付宝返回订单查询操作成功"));
			}
			result.setTradeId(orderResult.getResponse().getTrade().getTradeNo());
			result.setOrderId(orderResult.getResponse().getTrade().getOutTradeNo());
			switch (orderResult.getResponse().getTrade().getTradeStatus()) {
			case "TRADE_SUCCESS":
				//交易完成
				result.setPayResult(CommonStatusConst.STATUS_OK);
				result.setPayResultRemark("支付成功");
				rm.put("payTime", orderResult.getResponse().getTrade().getGmtPayment());
				break;
			case "TRADE_FINISHED":
				//交易完成
				result.setPayResult(CommonStatusConst.STATUS_OK);
				result.setPayResultRemark("支付成功");
				rm.put("payTime", orderResult.getResponse().getTrade().getGmtPayment());
				break;

			default:
				result.setPayResult(CommonStatusConst.STATUS_FAIL);
				result.setPayResultRemark("支付失败:"+orderResult.getResponse().getTrade().getTradeStatus());
				break;
			}
		}
		else{
			if (log.isDebugEnabled()) {
				log.debug(String.format("支付宝返回订单查询操作失败"));
			}
			String error = orderResult.getError();
			if("TRADE_NOT_EXIST".equals(error)){
				result.setPayResult("NON");
				result.setPayResultRemark("记录不存在");
				result.setOrderId(out_trade_no);
			}
			else{
				result.setPayResult(CommonStatusConst.STATUS_FAIL);
				String errormsg = errorcodemap.getOrDefault(orderResult.getError(),"支付宝异常");
				result.setPayResultRemark("支付失败:"+errormsg);
			}
		}
		rm.put("result", result);
		return rm;	
		
	}
	
}
