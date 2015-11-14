package com.hummingbird.paas.controller;

import java.util.ArrayList;
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
import com.hummingbird.paas.exception.TenderException;
import com.hummingbird.paas.services.TenderService;
import com.hummingbird.paas.services.TokenService;
import com.hummingbird.paas.vo.GetMsgListBodyVO;
import com.hummingbird.paas.vo.MyObjectTenderSurveyBodyVO;
import com.hummingbird.paas.vo.MyObjectTenderSurveyBodyVOResult;
import com.hummingbird.paas.vo.QueryBidderListResultVO;
import com.hummingbird.paas.vo.QueryCertificateListResultVO;
import com.hummingbird.paas.vo.QueryObjectBaseInfoBodyVOResult;
import com.hummingbird.paas.vo.QueryObjectBodyVO;
import com.hummingbird.paas.vo.QueryObjectListResultVO;
import com.hummingbird.paas.vo.QueryObjectProjectInfoResult;
import com.hummingbird.paas.vo.SaveObjectBaseInfo;
import com.hummingbird.paas.vo.SaveObjectProjectInfoBodyVO;
import com.hummingbird.paas.vo.SaveObjectProjectInfoBodyVOResult;
import com.hummingbird.paas.vo.SaveProjectRequirementInfoBodyVO;

/**
 * @author
 * @date 2015-11-08
 * @version 1.0
 * 
 */
@Controller
@RequestMapping(value = "tender", method = RequestMethod.POST)
public class TenderController extends BaseController {
	@Autowired(required = true)
	protected TenderService tenderService;
	@Autowired
	TokenService tokenSrv;

	/**
	 * 我的招标评标概况接口
	 * 
	 * @return
	 */
	@RequestMapping(value = "/queryMyObjectTenderSurvey", method = RequestMethod.POST)
	@AccessRequered(methodName = "我的招标评标概况接口", isJson = true, codebase = 230100, className = "com.hummingbird.commonbiz.vo.BaseTransVO", genericClassName = "com.hummingbird.paas.vo.MyObjectTenderSurveyBodyVO", appLog = true)
	public @ResponseBody ResultModel queryMyObjectTenderSurvey(HttpServletRequest request,
			HttpServletResponse response) {
		ResultModel rm = super.getResultModel();
		BaseTransVO<MyObjectTenderSurveyBodyVO> transorder = (BaseTransVO<MyObjectTenderSurveyBodyVO>) super.getParameterObject();
		String messagebase = "我的招标评标概况接口";

		RequestEvent qe = null; // 业务请求事件,当实现一些关键的业务时,需要生成该请求

		try {
			// 业务数据必填等校验

			// 业务数据逻辑校验
			if (log.isDebugEnabled()) {
				log.debug("检验通过，获取请求");
			}
			MyObjectTenderSurveyBodyVOResult queryMyObjectTenderSurvey = tenderService
					.queryMyObjectTenderSurvey(transorder.getApp().getAppId(), transorder.getBody());
			rm.put("survey", queryMyObjectTenderSurvey);

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
	@RequestMapping(value = "/queryObjectBaseInfo", method = RequestMethod.POST)
	@AccessRequered(methodName = "查询未完成招标项目基础信息接口", isJson = true, codebase = 241900, className = "com.hummingbird.commonbiz.vo.BaseTransVO", genericClassName = "com.hummingbird.paas.vo.QueryObjectBaseInfoBodyVO", appLog = true)
	public @ResponseBody ResultModel queryObjectBaseInfo(HttpServletRequest request, HttpServletResponse response) {
		ResultModel rm = super.getResultModel();
		BaseTransVO<QueryObjectBodyVO> transorder = (BaseTransVO<QueryObjectBodyVO>) super.getParameterObject();
		String messagebase = "查询未完成招标项目基础信息接口";

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
			QueryObjectBaseInfoBodyVOResult queryObjectBaseInfo = tenderService
					.queryObjectBaseInfo(transorder.getApp().getAppId(), transorder.getBody());
			if (queryObjectBaseInfo == null) {
				rm.setErr(rm.getBaseerrcode() + TenderException.ERR_TENDER_INFO_EXCEPTION, "没有相关数据");
			} else {

				rm.put("baseInfo", queryObjectBaseInfo);
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
	 * 保存招标项目基础信息接口
	 * 
	 * @return
	 */
	@RequestMapping(value = "/saveObjectBaseInfo", method = RequestMethod.POST)
	@AccessRequered(methodName = "保存招标项目基础信息接口", isJson = true, codebase = 242000, className = "com.hummingbird.commonbiz.vo.BaseTransVO", genericClassName = "com.hummingbird.paas.vo.SaveObjectBaseInfo", appLog = true)
	public @ResponseBody ResultModel saveObjectBaseInfo(HttpServletRequest request, HttpServletResponse response) {
		ResultModel rm = super.getResultModel();
		BaseTransVO<SaveObjectBaseInfo> transorder = (BaseTransVO<SaveObjectBaseInfo>) super.getParameterObject();
		String messagebase = "保存招标项目基础信息接口";

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
			String objectId = tenderService.saveObjectBaseInfo(transorder.getApp().getAppId(), transorder.getBody(),
					token.getUserId());
			rm.put("objectId", objectId);

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
	 * 查询未完成招标项目工程信息接口
	 * 
	 * @return
	 */
	@RequestMapping(value = "/queryObjectProjectInfo", method = RequestMethod.POST)
	@AccessRequered(methodName = "查询未完成招标项目工程信息接口", isJson = true, codebase = 242100, className = "com.hummingbird.commonbiz.vo.BaseTransVO", genericClassName = "com.hummingbird.paas.vo.QueryObjectBodyVO", appLog = true)
	public @ResponseBody ResultModel queryObjectProjectInfo(HttpServletRequest request, HttpServletResponse response) {
		ResultModel rm = super.getResultModel();
		BaseTransVO<QueryObjectBodyVO> transorder = (BaseTransVO<QueryObjectBodyVO>) super.getParameterObject();
		String messagebase = "查询未完成招标项目工程信息接口";

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
			QueryObjectProjectInfoResult queryObjectProjectInfo = tenderService
					.queryObjectProjectInfo(transorder.getApp().getAppId(), transorder.getBody());
			if (queryObjectProjectInfo == null) {
				rm.setErr(rm.getBaseerrcode() + TenderException.ERR_TENDER_INFO_EXCEPTION, "没有相关数据");
			} else {

				rm.put("projectInfo", queryObjectProjectInfo);
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
	 * 保存招标项目工程信息接口
	 * 
	 * @return
	 */
	@RequestMapping(value = "/saveObjectProjectInfo", method = RequestMethod.POST)
	@AccessRequered(methodName = "保存招标项目工程信息接口", isJson = true, codebase = 242200, className = "com.hummingbird.commonbiz.vo.BaseTransVO", genericClassName = "com.hummingbird.paas.vo.SaveObjectProjectInfoBodyVO", appLog = true)
	public @ResponseBody ResultModel saveObjectProjectInfo(HttpServletRequest request, HttpServletResponse response) {
		ResultModel rm = super.getResultModel();
		BaseTransVO<SaveObjectProjectInfoBodyVO> transorder = (BaseTransVO<SaveObjectProjectInfoBodyVO>) super.getParameterObject();
		String messagebase = "保存招标项目工程信息接口";

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
			tenderService.saveObjectProjectInfo(transorder.getApp().getAppId(),token.getUserId(), transorder.getBody());

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
	 * 查询未完成招标项目工程要求接口
	 * @return
	 */
	@RequestMapping(value="/queryProjectRequirementInfo",method=RequestMethod.POST)
	@AccessRequered(methodName = "查询未完成招标项目工程要求接口",isJson=true,codebase=242500,className="com.hummingbird.commonbiz.vo.BaseTransVO",genericClassName="com.hummingbird.paas.vo.SaveObjectProjectInfoBodyVO",appLog=true)
	public @ResponseBody ResultModel queryProjectRequirementInfo(HttpServletRequest request,HttpServletResponse response) {
		ResultModel rm = super.getResultModel();
		BaseTransVO<QueryObjectBodyVO> transorder = (BaseTransVO<QueryObjectBodyVO>) super.getParameterObject();
		String messagebase = "查询未完成招标项目工程要求接口"; 
	
		RequestEvent qe=null ; //业务请求事件,当实现一些关键的业务时,需要生成该请求
		
		try {
			//业务数据必填等校验
			Token token = tokenSrv.getToken(transorder.getBody().getToken(), transorder.getApp().getAppId());
			if (token == null) {
				log.error(String.format("token[%s]验证失败,或已过期,请重新登录", transorder.getBody().getToken()));
				throw new TokenException("token验证失败,或已过期,请重新登录");
			}
			Integer userId = token.getUserId();
			//业务数据逻辑校验
			if(log.isDebugEnabled()){
				log.debug("检验通过，获取请求");
			}
			SaveObjectProjectInfoBodyVOResult result = tenderService.queryProjectRequirementInfo(transorder.getApp().getAppId(),transorder.getBody());
			rm.put("requirementInfo", result);
		
			tokenSrv.postponeToken(token);
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
	 * 保存招标项目工程施工证明接口
	 * @return
	 */
	@RequestMapping(value="/saveProjectRequirementInfo",method=RequestMethod.POST)
	@AccessRequered(methodName = "保存招标项目工程施工证明接口",isJson=true,codebase=242600,className="com.hummingbird.commonbiz.vo.BaseTransVO",genericClassName="com.hummingbird.paas.vo.SaveProjectRequirementInfoBodyVO",appLog=true)
	public @ResponseBody ResultModel saveProjectRequirementInfo(HttpServletRequest request,HttpServletResponse response) {
		ResultModel rm = super.getResultModel();
		BaseTransVO<SaveProjectRequirementInfoBodyVO> transorder = (BaseTransVO<SaveProjectRequirementInfoBodyVO>) super.getParameterObject();
		String messagebase = "保存招标项目工程施工证明接口"; 
	
		RequestEvent qe=null ; //业务请求事件,当实现一些关键的业务时,需要生成该请求
		
		try {
			//业务数据必填等校验
			
			//业务数据逻辑校验
			if(log.isDebugEnabled()){
				log.debug("检验通过，获取请求");
			}
			tenderService.saveProjectRequirementInfo(transorder.getApp().getAppId(),transorder.getBody());
		
			
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
	 * 查询未完成招标项目工程施工证明接口
	 * @return
	 */
	@RequestMapping(value="/queryObjectConstructionInfo",method=RequestMethod.POST)
	@AccessRequered(methodName = "查询未完成招标项目工程施工证明接口",isJson=true,codebase=242300,className="com.hummingbird.commonbiz.vo.BaseTransVO",genericClassName="com.hummingbird.paas.vo.QueryObjectConstructionInfo",appLog=true)
	public @ResponseBody ResultModel queryObjectConstructionInfo(HttpServletRequest request,HttpServletResponse response) {
		ResultModel rm = super.getResultModel();
		BaseTransVO<QueryObjectBodyVO> transorder = (BaseTransVO<QueryObjectBodyVO>) super.getParameterObject();
		String messagebase = "查询未完成招标项目工程施工证明接口"; 
	
		RequestEvent qe=null ; //业务请求事件,当实现一些关键的业务时,需要生成该请求
		
		try {
			//业务数据必填等校验
			
			//业务数据逻辑校验
			if(log.isDebugEnabled()){
				log.debug("检验通过，获取请求");
			}
			tenderService.queryObjectConstructionInfo(transorder.getApp().getAppId(),transorder.getBody());
		    
			
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
	 * 查询未完成招标项目工程施工证明接口
	 * @return
	 */
	@RequestMapping(value="/queryCertificateList",method=RequestMethod.POST)
	@AccessRequered(methodName = "查询资质证书类型列表接口",isJson=true,codebase=242300,className="com.hummingbird.commonbiz.vo.BaseTransVO",genericClassName="com.hummingbird.paas.vo.QueryCertificateListBodyVO",appLog=true)
	public @ResponseBody ResultModel queryCertificateList(HttpServletRequest request,HttpServletResponse response) {
		ResultModel rm = super.getResultModel();
		BaseTransVO<QueryObjectBodyVO> transorder = (BaseTransVO<QueryObjectBodyVO>) super.getParameterObject();
		String messagebase = "查询资质证书类型列表接口"; 
		RequestEvent qe=null ; 
		List<QueryCertificateListResultVO> liq = new ArrayList<QueryCertificateListResultVO>();
		try {
			if(log.isDebugEnabled()){
				log.debug("检验通过，获取请求");
			}
			liq = tenderService.queryCertificateList();
			rm.put("certificateList", liq);
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
	 * 查询未完成招标项目工程施工证明接口
	 * @return  queryObjectList
	 */
/*	@RequestMapping(value="/queryObjectList",method=RequestMethod.POST)
	@AccessRequered(methodName = "查询招标公告列表接口",isJson=true,codebase=242300,className="com.hummingbird.commonbiz.vo.BaseTransVO",genericClassName="com.hummingbird.paas.vo.QueryObjectBodyVO",appLog=true)
	public @ResponseBody ResultModel queryObjectList(HttpServletRequest request,HttpServletResponse response) {
		ResultModel rm = super.getResultModel();
		BaseTransVO<QueryObjectBodyVO> transorder = (BaseTransVO<QueryObjectBodyVO>) super.getParameterObject();
		String messagebase = "查询投标方列表接口"; 
		RequestEvent qe=null ; 
		List<QueryBidderListResultVO> liq = null;
		try {
			if(log.isDebugEnabled()){
				log.debug("检验通过，获取请求");
			}
			liq = tenderService.queryObjectList(pageIndex, pageSize)
	        rm.put("bidderList",liq);
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
		
	}*/
	
	
	/**
	 * 查询未完成招标项目工程施工证明接口
	 * @return  queryObjectList
	 */
	@RequestMapping(value="/queryBidderList",method=RequestMethod.POST)
	@AccessRequered(methodName = "查询投标方列表接口",isJson=true,codebase=242300,className="com.hummingbird.commonbiz.vo.BaseTransVO",genericClassName="com.hummingbird.paas.vo.GetMsgListBodyVO",appLog=true)
	public @ResponseBody ResultModel queryBidderList(HttpServletRequest request,HttpServletResponse response) {
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
			liq = tenderService.queryObjectList((pageIndex-1)*pageSize,pageSize);
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
