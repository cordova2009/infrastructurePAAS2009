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
import com.hummingbird.paas.services.ProjectPaymentService;
import com.hummingbird.paas.vo.ProjectPaymentConfirmBodyVO;
import com.hummingbird.paas.vo.ProjectPaymentConfirmBodyVO;


/**
 * @author 
 * @date 2015-12-13
 * @version 1.0
 *  
 */
@Controller
@RequestMapping(value="projectPayment",method=RequestMethod.POST)
public class ProjectPaymentController extends BaseController {
	@Autowired(required = true)
	protected ProjectPaymentService projectPaymentService;

		
	/**
	 * 确认工程付款
	 * @return
	 */
	@RequestMapping(value="/confirmPayment",method=RequestMethod.POST)
	@AccessRequered(methodName = "确认工程付款",isJson=true,codebase=249000,className="com.hummingbird.commonbiz.vo.BaseTransVO",genericClassName="com.hummingbird.paas.vo.ProjectPaymentConfirmBodyVO",appLog=true)
	public @ResponseBody ResultModel confirmPayment(HttpServletRequest request,HttpServletResponse response) {
		ResultModel rm = super.getResultModel();
		BaseTransVO<ProjectPaymentConfirmBodyVO> transorder = (BaseTransVO<ProjectPaymentConfirmBodyVO>) super.getParameterObject();
		String messagebase = "确认工程付款"; 
	
		RequestEvent qe=null ; //业务请求事件,当实现一些关键的业务时,需要生成该请求
		
		try {
			if(log.isDebugEnabled()){
				log.debug("检验通过，获取请求");
			}
			projectPaymentService.confirmPayment(transorder.getApp().getAppId(),transorder.getBody());
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
