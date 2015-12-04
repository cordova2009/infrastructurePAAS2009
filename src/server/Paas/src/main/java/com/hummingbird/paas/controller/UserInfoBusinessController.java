
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
import com.hummingbird.paas.services.UserInfoService;
import com.hummingbird.paas.vo.UserInformationBodyVO;
import com.hummingbird.paas.vo.UserInformationDetailBodyVO;
import com.hummingbird.paas.vo.UserInformationDetailReturnVO;
import com.hummingbird.paas.vo.UserInformationDetailWithCommentsReturnVO;
import com.hummingbird.paas.vo.UserInformationPageBodyVO;
import com.hummingbird.paas.vo.UserInformationPageReturnVO;
import com.hummingbird.paas.vo.UserInformationReplyBodyVO;

/**
 * @author YJY
 * @date 2015-12-2 16:20:50
 * @version 1.0
 * 用户信息业务 
 */
@Controller
@RequestMapping(value = "userInformation", method = RequestMethod.POST)
public class UserInfoBusinessController extends BaseController {
	@Autowired
	TokenService tokenSrv;
	@Autowired
	UserInfoService  uiService;
	
	
	@Autowired(required = true)
	protected AppLogMapper applogDao;

	/**
	 * 提交用户信息接口
	 * 
	 * @return
	 */
	@RequestMapping(value = "/submitUserInformation", method = RequestMethod.POST)
	@AccessRequered(methodName = "提交用户信息接口", isJson = true, codebase = 230100, className = "com.hummingbird.commonbiz.vo.BaseTransVO", genericClassName = "com.hummingbird.paas.vo.UserInformationBodyVO", appLog = true)
	public @ResponseBody ResultModel submitUserInformation(HttpServletRequest request,
			HttpServletResponse response) {
		ResultModel rm = super.getResultModel();
		BaseTransVO<UserInformationBodyVO> transorder = (BaseTransVO<UserInformationBodyVO>) super.getParameterObject();
		String messagebase = "提交用户信息接口";

		RequestEvent qe = null; // 业务请求事件,当实现一些关键的业务时,需要生成该请求

		try {
			// 业务数据必填等校验
				Token token = tokenSrv.getToken(transorder.getBody().getToken(), transorder.getApp().getAppId());
				if (token == null) {
					log.error(String.format("token[%s]验证失败,或已过期,请重新登录", transorder.getBody().getToken()));
					throw new TokenException("token验证失败,或已过期,请重新登录");
				}
				int i= 0;
				
				i= uiService.submitUserInformation(transorder.getApp().getAppId(), transorder.getBody(),token);
	
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
	 * 查看我的发布信息详情接口
	 * 
	 * @return
	 */
	@RequestMapping(value = "/getUserInformationDetail", method = RequestMethod.POST)
	@AccessRequered(methodName = "查看我的发布信息详情接口", isJson = true, codebase = 241900, className = "com.hummingbird.commonbiz.vo.BaseTransVO", genericClassName = "com.hummingbird.paas.vo.UserInformationDetailBodyVO", appLog = true)
	public @ResponseBody ResultModel getUserInformationDetail(HttpServletRequest request, HttpServletResponse response) {
		ResultModel rm = super.getResultModel();
		BaseTransVO<UserInformationDetailBodyVO> transorder = (BaseTransVO<UserInformationDetailBodyVO>) super.getParameterObject();
		String messagebase = "查看我的发布信息详情接口";

		RequestEvent qe = null; // 业务请求事件,当实现一些关键的业务时,需要生成该请求

		try {
			// 业务数据必填等校验
			Token token = tokenSrv.getToken(transorder.getBody().getToken(), transorder.getApp().getAppId());
			if (token == null) {
				log.error(String.format("token[%s]验证失败,或已过期,请重新登录", transorder.getBody().getToken()));
				throw new TokenException("token验证失败,或已过期,请重新登录");
			}
	
			
			// 业务数据逻辑校验
			if (log.isDebugEnabled()) {
				log.debug("检验通过，获取请求");
			}
			UserInformationDetailReturnVO queryUserInformationDetail = uiService.getUserInformationDetail(transorder.getApp().getAppId(), transorder.getBody(),token);
			if (queryUserInformationDetail == null) {
				rm.setErr(rm.getBaseerrcode() + PaasException.ERR_USER_INFO_EXCEPTION, "没有相关数据");
			} else {

				rm.put("result", queryUserInformationDetail);
			}
			// tokenSrv.renewToken(token);

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
	 * 查看我的发布信息详情接口
	 * 
	 * @return
	 */
	@RequestMapping(value = "/getUserInformationDetailWithComments", method = RequestMethod.POST)
	@AccessRequered(methodName = "查看我的发布信息详情接口", isJson = true, codebase = 241900, className = "com.hummingbird.commonbiz.vo.BaseTransVO", genericClassName = "com.hummingbird.paas.vo.UserInformationDetailBodyVO", appLog = true)
	public @ResponseBody ResultModel getUserInformationDetailWithComments(HttpServletRequest request, HttpServletResponse response) {
		ResultModel rm = super.getResultModel();
		BaseTransVO<UserInformationDetailBodyVO> transorder = (BaseTransVO<UserInformationDetailBodyVO>) super.getParameterObject();
		String messagebase = "查看我的发布信息详情接口";

		RequestEvent qe = null; // 业务请求事件,当实现一些关键的业务时,需要生成该请求

		try {
			// 业务数据必填等校验
			Token token = tokenSrv.getToken(transorder.getBody().getToken(), transorder.getApp().getAppId());
			if (token == null) {
				log.error(String.format("token[%s]验证失败,或已过期,请重新登录", transorder.getBody().getToken()));
				throw new TokenException("token验证失败,或已过期,请重新登录");
			}
			
			// 业务数据逻辑校验
			if (log.isDebugEnabled()) {
				log.debug("检验通过，获取请求");
			}
			UserInformationDetailWithCommentsReturnVO quidwc = uiService.getUserInformationDetailWithComments(transorder.getApp().getAppId(), transorder.getBody(),token);
			if (quidwc == null) {
				rm.setErr(rm.getBaseerrcode() + PaasException.ERR_USER_INFO_EXCEPTION, "没有相关数据");
			} else {

				rm.put("result", quidwc);
			}
			// tokenSrv.renewToken(token);

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
	 * 查询发布信息列表接口
	 * @return  queryMyEndedObject
	 */
	@RequestMapping(value="/queryUserInformationPage",method=RequestMethod.POST)
	@AccessRequered(methodName = "查询发布信息列表",isJson=true,codebase=242300,className="com.hummingbird.commonbiz.vo.BaseTransVO",genericClassName="com.hummingbird.paas.vo.UserInformationPageBodyVO",appLog=true)
	public @ResponseBody ResultModel queryUserInformationPage(HttpServletRequest request,HttpServletResponse response) {
		ResultModel rm = super.getResultModel();
		BaseTransVO<UserInformationPageBodyVO> transorder = (BaseTransVO<UserInformationPageBodyVO>) super.getParameterObject();
		String messagebase = "查询发布信息列表"; 
		RequestEvent qe=null ; 
		List<UserInformationPageReturnVO> liq = null;
		try {
			// 业务数据必填等校验
			Token token = tokenSrv.getToken(transorder.getBody().getToken(), transorder.getApp().getAppId());
			if (token == null) {
				log.error(String.format("token[%s]验证失败,或已过期,请重新登录", transorder.getBody().getToken()));
				throw new TokenException("token验证失败,或已过期,请重新登录");
			}
			if(log.isDebugEnabled()){
				log.debug("检验通过，获取请求");
			}
			Integer pageIndex =transorder.getBody().getPageIndex();
			Integer pageSize =transorder.getBody().getPageSize();
			if(pageIndex==null||pageSize==null||pageIndex<=0||pageSize<=0){log.error(String.format(messagebase + "失败"));
			rm.setErrmsg("参数错误");
			return rm;
			}
			liq = uiService.queryUserInformationPage(transorder.getApp().getAppId(), transorder.getBody(),token);
	        rm.put("list",liq);
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
	
	/**
	 * 回复用户信息接口
	 * 
	 * @return
	 */
	@RequestMapping(value = "/replyUserInformation", method = RequestMethod.POST)
	@AccessRequered(methodName = "回复用户信息接口", isJson = true, codebase = 230100, className = "com.hummingbird.commonbiz.vo.BaseTransVO", genericClassName = "com.hummingbird.paas.vo.UserInformationReplyBodyVO", appLog = true)
	public @ResponseBody ResultModel replyUserInformation(HttpServletRequest request,
			HttpServletResponse response) {
		ResultModel rm = super.getResultModel();
		BaseTransVO<UserInformationReplyBodyVO> transorder = (BaseTransVO<UserInformationReplyBodyVO>) super.getParameterObject();
		String messagebase = "回复用户信息接口";

		RequestEvent qe = null; // 业务请求事件,当实现一些关键的业务时,需要生成该请求

		try {
			// 业务数据必填等校验
				Token token = tokenSrv.getToken(transorder.getBody().getToken(), transorder.getApp().getAppId());
				if (token == null) {
					log.error(String.format("token[%s]验证失败,或已过期,请重新登录", transorder.getBody().getToken()));
					throw new TokenException("token验证失败,或已过期,请重新登录");
				}
				int i= 0;
				
				i= uiService.replyUserInformation(transorder.getApp().getAppId(), transorder.getBody(),token);
	
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
