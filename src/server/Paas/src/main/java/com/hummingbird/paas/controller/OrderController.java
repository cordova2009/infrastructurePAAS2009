package com.hummingbird.paas.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hummingbird.common.controller.BaseController;
import com.hummingbird.common.event.EventListenerContainer;
import com.hummingbird.common.event.RequestEvent;
import com.hummingbird.common.ext.AccessRequered;
import com.hummingbird.common.vo.ResultModel;
import com.hummingbird.commonbiz.exception.TokenException;
import com.hummingbird.commonbiz.vo.BaseTransVO;
import com.hummingbird.commonbiz.vo.BaseTransVO;
import com.hummingbird.commonbiz.vo.BaseTransVO;
import com.hummingbird.paas.entity.Token;
import com.hummingbird.paas.services.OrderService;
import com.hummingbird.paas.vo.PayNotifyBodyVO;
import com.hummingbird.paas.vo.PayNotifyBodyVO;


/**
 * @author 
 * @date 2015-12-02
 * @version 1.0
 *  
 */
@Controller
@RequestMapping(value="order",method=RequestMethod.POST)
public class OrderController extends BaseController {
	@Autowired(required = true)
	protected OrderService orderService;

		
	/**
	 * 支付宝网关支付通知
	 * @return
	 */
	@RequestMapping(value="/payNotify",method=RequestMethod.POST)
	@AccessRequered(methodName = "支付宝网关支付通知",isJson=true,codebase=290100,className="com.hummingbird.commonbiz.vo.BaseTransVO",genericClassName="com.hummingbird.paas.vo.PayNotifyBodyVO",appLog=true)
	public @ResponseBody ResultModel payNotify(HttpServletRequest request,HttpServletResponse response) {
		ResultModel rm = super.getResultModel();
		BaseTransVO<PayNotifyBodyVO> transorder = (BaseTransVO<PayNotifyBodyVO>) super.getParameterObject();
		String messagebase = "支付宝网关支付通知"; 
	
		RequestEvent qe=null ; //业务请求事件,当实现一些关键的业务时,需要生成该请求
		
		try {
			//业务数据必填等校验
			//业务数据逻辑校验
			if(log.isDebugEnabled()){
				log.debug("检验通过，获取请求");
			}
			orderService.payNotify(transorder.getApp().getAppId(),transorder.getBody());
		}catch (Exception e1) {
			log.error(String.format(messagebase + "失败"), e1);
			rm.mergeException(e1);
			if(qe!=null)
				qe.setSuccessed(false);
		} finally {
			if(qe!=null)
				EventListenerContainer.getInstance().fireEvent(qe);
		}
		return rm;
		
	}
	
	
    }
