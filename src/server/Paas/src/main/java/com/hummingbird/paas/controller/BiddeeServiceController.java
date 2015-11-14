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
import com.hummingbird.common.vo.ResultModel;
import com.hummingbird.commonbiz.exception.TokenException;
import com.hummingbird.commonbiz.vo.BaseTransVO;
import com.hummingbird.paas.entity.Token;
import com.hummingbird.paas.services.BiddeeServiceService;
import com.hummingbird.paas.services.TokenService;
import com.hummingbird.paas.vo.GetMsgListBodyVO;
import com.hummingbird.paas.vo.QueryObjectDetailBodyVO;
import com.hummingbird.paas.vo.QueryObjectListResultVO;
import com.hummingbird.paas.vo.TokenBodyVO;
@Controller
@RequestMapping(value = "/gw/bid", method = RequestMethod.POST)
public class BiddeeServiceController extends BaseController{
	@Autowired
	BiddeeServiceService beeServiceSer;
	@Autowired
	TokenService tokenSrv;
	/**
	 * 查询未完成招标项目基础信息接口
	 * 
	 * @return
	 */
	@RequestMapping(value = "/queryBidderCertificationInfo", method = RequestMethod.POST)
	@AccessRequered(methodName = "查询用户是否具有投标的资质", isJson = true, codebase = 244000, className = "com.hummingbird.commonbiz.vo.BaseTransVO", genericClassName = "com.hummingbird.paas.vo.TokenBodyVO", appLog = true)
	public @ResponseBody ResultModel queryBidderCertificationInfo(HttpServletRequest request, HttpServletResponse response) {
		ResultModel rm = super.getResultModel();
		BaseTransVO<TokenBodyVO> transorder = (BaseTransVO<TokenBodyVO>) super.getParameterObject();
		String messagebase = "查询用户是否具有投标的资质接口";
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
			Boolean flag = beeServiceSer.queryTender(token);
			if(!flag){
				rm.setErrcode(2440001);
				rm.setErrmsg("查询用户是否具有投标的资质");
				return rm;
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
	 * 查询未完成招标项目基础信息接口
	 * 
	 * @return
	 */
	@RequestMapping(value = "/isInvitationOfBid", method = RequestMethod.POST)
	@AccessRequered(methodName = "查询用户是否具有投标的资质", isJson = true, codebase = 244000, className = "com.hummingbird.commonbiz.vo.BaseTransVO", genericClassName = "com.hummingbird.paas.vo.QueryObjectDetailBodyVO", appLog = true)
	public @ResponseBody ResultModel queryObjectDetail(HttpServletRequest request, HttpServletResponse response) {
		ResultModel rm = super.getResultModel();
		BaseTransVO<QueryObjectDetailBodyVO> transorder = (BaseTransVO<QueryObjectDetailBodyVO>) super.getParameterObject();
		String messagebase = "查询用户是否具有投标的资质接口";
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
			Boolean flag = beeServiceSer.queryTender(token);
			if(!flag){
				rm.setErrmsg("查询用户不具有投标的资质");
				return rm;
			}else{
				rm.setErrmsg("该用户具有投标的资质");
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
	 * 查询未完成招标项目工程施工证明接口
	 * @return  queryObjectList
	 */
	@RequestMapping(value="/queryObjectList",method=RequestMethod.POST)
	@AccessRequered(methodName = "查询投标方列表接口",isJson=true,codebase=242300,className="com.hummingbird.commonbiz.vo.BaseTransVO",genericClassName="com.hummingbird.paas.vo.GetMsgListBodyVO",appLog=true)
	public @ResponseBody ResultModel queryObjectList(HttpServletRequest request,HttpServletResponse response) {
		ResultModel rm = super.getResultModel();
		BaseTransVO<GetMsgListBodyVO> transorder = (BaseTransVO<GetMsgListBodyVO>) super.getParameterObject();
		String messagebase = "查询投标方列表接口"; 
		RequestEvent qe=null ; 
		List<QueryObjectListResultVO> liq = null;
		try {
			if(log.isDebugEnabled()){
				log.debug("检验通过，获取请求");
			}
			Integer pageIndex =transorder.getBody().getPageIndex();
			Integer pageSize =transorder.getBody().getPageSize();
			if(pageIndex==null||pageSize==null||pageIndex<=0||pageSize<=0){
				log.error(String.format(messagebase + "失败"));
				rm.setErrmsg("参数错误");
				return rm;
			}
			liq = beeServiceSer.queryObjectList((pageIndex-1)*pageSize,pageSize);
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
}
