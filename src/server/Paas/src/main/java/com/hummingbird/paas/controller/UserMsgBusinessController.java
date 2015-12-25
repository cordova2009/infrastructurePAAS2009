
package com.hummingbird.paas.controller;

import java.util.List;

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
import com.hummingbird.common.face.AbstractAppLog;
import com.hummingbird.common.vo.ResultModel;
import com.hummingbird.commonbiz.exception.TokenException;
import com.hummingbird.commonbiz.vo.BaseTransVO;
import com.hummingbird.paas.entity.AppLog;
import com.hummingbird.paas.entity.Token;
import com.hummingbird.paas.exception.PaasException;
import com.hummingbird.paas.mapper.AppLogMapper;
import com.hummingbird.paas.services.TokenService;
import com.hummingbird.paas.services.UserComplainService;
import com.hummingbird.paas.services.UserInfoService;
import com.hummingbird.paas.services.UserMsgService;
import com.hummingbird.paas.vo.UserComplainBodyVO;
import com.hummingbird.paas.vo.UserInformationBodyVO;
import com.hummingbird.paas.vo.UserInformationDetailBodyVO;
import com.hummingbird.paas.vo.UserInformationDetailReturnVO;
import com.hummingbird.paas.vo.UserInformationDetailWithCommentsReturnVO;
import com.hummingbird.paas.vo.UserInformationPageBodyVO;
import com.hummingbird.paas.vo.UserInformationPageReturnVO;
import com.hummingbird.paas.vo.UserInformationReplyBodyVO;
import com.hummingbird.paas.vo.UserMsgBodyVO;
import com.hummingbird.paas.vo.UserReportBodyVO;

/**
 * @author YJY
 * @date 2015年12月19日10:45:55
 * @version 1.0
 * 发送通知接口
 */
@Controller
@RequestMapping(value = "userMsg", method = RequestMethod.POST)
public class UserMsgBusinessController extends BaseController {
	@Autowired
	TokenService tokenSrv;
	@Autowired
	UserMsgService  umService;
	
	
	@Autowired(required = true)
	protected AppLogMapper applogDao;

	
	/**
	 * 添加用户消息
	 * 
	 * @return
	 */
	@RequestMapping(value = "/addMsg", method = RequestMethod.POST)
	@AccessRequered(methodName = "添加用户消息", isJson = true, codebase = 230100, className = "com.hummingbird.commonbiz.vo.BaseTransVO", genericClassName = "com.hummingbird.paas.vo.UserMsgBodyVO", appLog = true)
	public @ResponseBody ResultModel replyUserInformation(HttpServletRequest request,
			HttpServletResponse response) {
		ResultModel rm = super.getResultModel();
		BaseTransVO<UserMsgBodyVO> transorder = (BaseTransVO<UserMsgBodyVO>) super.getParameterObject();
		String messagebase = "添加用户消息";

		RequestEvent qe = null; // 业务请求事件,当实现一些关键的业务时,需要生成该请求

		try {
			
				int i= 0;
				
				i= umService.addMsg(transorder.getBody());
	
				if(i<= 0){
					rm.setErrmsg("数据未修改！");
				}else{
					rm.setErrmsg(messagebase + "成功");
				}
		} catch (Exception e1) {
			log.error(String.format(messagebase + "失败"), e1);
			rm.mergeException(e1);
			if (qe != null)
				qe.setSuccessed(false);
		} finally {
			if (qe != null)
				EventListenerContainer.getInstance().fireEvent(qe);
		}
		return rm;

	}
	
	
	
	/**
	 * 写日志,需要由子类实现
	 * @param applog
	 */
	protected void writeAppLog(AbstractAppLog applog) {
		if(applog!=null){
			applogDao.insert(new AppLog(applog));
		}
	}
	
}
