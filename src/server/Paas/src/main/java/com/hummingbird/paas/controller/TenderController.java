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
import com.hummingbird.paas.entity.Biddee;
import com.hummingbird.paas.entity.Token;
import com.hummingbird.paas.exception.PaasException;
import com.hummingbird.paas.mapper.BiddeeMapper;
import com.hummingbird.paas.services.TenderService;
import com.hummingbird.paas.services.TokenService;
import com.hummingbird.paas.vo.MyObjectTenderSurveyBodyVO;
import com.hummingbird.paas.vo.MyObjectTenderSurveyBodyVOResult;
import com.hummingbird.paas.vo.QueryObjectBaseInfoBodyVOResult;
import com.hummingbird.paas.vo.QueryObjectBodyVO;
import com.hummingbird.paas.vo.QueryObjectBondInfoResult;
import com.hummingbird.paas.vo.QueryObjectCertificationInfoResult;
import com.hummingbird.paas.vo.QueryObjectConstructionInfoResult;
import com.hummingbird.paas.vo.QueryObjectProjectInfoResult;
import com.hummingbird.paas.vo.SaveBidFileTypeInfo;
import com.hummingbird.paas.vo.SaveObjectBaseInfo;
import com.hummingbird.paas.vo.SaveObjectBondInfo;
import com.hummingbird.paas.vo.SaveObjectCertificationInfo;
import com.hummingbird.paas.vo.SaveObjectConstructionInfo;
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
	@Autowired
	BiddeeMapper biddeeDao;

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
			Token token = tokenSrv.getToken(transorder.getBody().getToken(), transorder.getApp().getAppId());
			if (token == null) {
				log.error(String.format("token[%s]验证失败,或已过期,请重新登录", transorder.getBody().getToken()));
				throw new TokenException("token验证失败,或已过期,请重新登录");
			}
			Biddee biddee = biddeeDao.selectByUserId(token.getUserId());
			if(biddee==null)
			{
				log.error(String.format("用户%s查找不到招标方信息,可能未进行资格认证", token.getUserId()));
				throw new PaasException(PaasException.ERR_BIDDEE_INFO_EXCEPTION,"您没有招标方资质认证,请先进行认证");
			}
			// 业务数据逻辑校验
			if (log.isDebugEnabled()) {
				log.debug("检验通过，获取请求");
			}
			MyObjectTenderSurveyBodyVOResult queryMyObjectTenderSurvey = tenderService
					.queryMyObjectTenderSurvey(transorder.getApp().getAppId(), transorder.getBody(),biddee);
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
	@AccessRequered(methodName = "查询未完成招标项目基础信息接口", isJson = true, codebase = 241900, className = "com.hummingbird.commonbiz.vo.BaseTransVO", genericClassName = "com.hummingbird.paas.vo.QueryObjectBodyVO", appLog = true)
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
			Biddee biddee = biddeeDao.selectByUserId(token.getUserId());
			if(biddee==null)
			{
				log.error(String.format("用户%s查找不到招标方信息,可能未进行资格认证", token.getUserId()));
				throw new PaasException(PaasException.ERR_BIDDEE_INFO_EXCEPTION,"您没有招标方资质认证,请先进行认证");
			}
			// 业务数据逻辑校验
			if (log.isDebugEnabled()) {
				log.debug("检验通过，获取请求");
			}
			QueryObjectBaseInfoBodyVOResult queryObjectBaseInfo = tenderService
					.queryObjectBaseInfo(transorder.getApp().getAppId(), transorder.getBody(),biddee);
//			if (queryObjectBaseInfo == null) {
//				rm.setErr(rm.getBaseerrcode() + TenderException.ERR_TENDER_INFO_EXCEPTION, "没有相关数据");
//			} else {

				rm.put("baseInfo", queryObjectBaseInfo);
//			}
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
			Biddee biddee = biddeeDao.selectByUserId(token.getUserId());
			if(biddee==null)
			{
				log.error(String.format("用户%s查找不到招标方信息,可能未进行资格认证", token.getUserId()));
				throw new PaasException(PaasException.ERR_BIDDEE_INFO_EXCEPTION,"您没有招标方资质认证,请先进行认证");
			}
			// 业务数据逻辑校验
			if (log.isDebugEnabled()) {
				log.debug("检验通过，获取请求");
			}
			String objectId = tenderService.saveObjectBaseInfo(transorder.getApp().getAppId(), transorder.getBody(),
					biddee.getId());
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
			Biddee biddee = biddeeDao.selectByUserId(token.getUserId());
			if(biddee==null)
			{
				log.error(String.format("用户%s查找不到招标方信息,可能未进行资格认证", token.getUserId()));
				throw new PaasException(PaasException.ERR_BIDDEE_INFO_EXCEPTION,"您没有招标方资质认证,请先进行认证");
			}
			// 业务数据逻辑校验
			if (log.isDebugEnabled()) {
				log.debug("检验通过，获取请求");
			}
			QueryObjectProjectInfoResult queryObjectProjectInfo = tenderService
					.queryObjectProjectInfo(transorder.getApp().getAppId(), transorder.getBody(),biddee.getId());
//			if (queryObjectProjectInfo == null) {
//				rm.setErr(rm.getBaseerrcode() + TenderException.ERR_TENDER_INFO_EXCEPTION, "没有相关数据");
//			} else {

				rm.put("projectInfo", queryObjectProjectInfo);
//			}

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
			Biddee biddee = biddeeDao.selectByUserId(token.getUserId());
			if(biddee==null)
			{
				log.error(String.format("用户%s查找不到招标方信息,可能未进行资格认证", token.getUserId()));
				throw new PaasException(PaasException.ERR_BIDDEE_INFO_EXCEPTION,"您没有招标方资质认证,请先进行认证");
			}
			// 业务数据逻辑校验
			if (log.isDebugEnabled()) {
				log.debug("检验通过，获取请求");
			}
			tenderService.saveObjectProjectInfo(transorder.getApp().getAppId(),token.getUserId(), transorder.getBody(),biddee.getId());

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
	@AccessRequered(methodName = "查询未完成招标项目工程要求接口",isJson=true,codebase=242500,className="com.hummingbird.commonbiz.vo.BaseTransVO",genericClassName="com.hummingbird.paas.vo.QueryObjectBodyVO",appLog=true)
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
			Biddee biddee = biddeeDao.selectByUserId(token.getUserId());
			if(biddee==null)
			{
				log.error(String.format("用户%s查找不到招标方信息,可能未进行资格认证", token.getUserId()));
				throw new PaasException(PaasException.ERR_BIDDEE_INFO_EXCEPTION,"您没有招标方资质认证,请先进行认证");
			}
			Integer userId = token.getUserId();
			//业务数据逻辑校验
			if(log.isDebugEnabled()){
				log.debug("检验通过，获取请求");
			}
			SaveObjectProjectInfoBodyVOResult result = tenderService.queryProjectRequirementInfo(transorder.getApp().getAppId(),transorder.getBody(),biddee.getId());
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
			Token token = tokenSrv.getToken(transorder.getBody().getToken(), transorder.getApp().getAppId());
			if (token == null) {
				log.error(String.format("token[%s]验证失败,或已过期,请重新登录", transorder.getBody().getToken()));
				throw new TokenException("token验证失败,或已过期,请重新登录");
			}
			Biddee biddee = biddeeDao.selectByUserId(token.getUserId());
			if(biddee==null)
			{
				log.error(String.format("用户%s查找不到招标方信息,可能未进行资格认证", token.getUserId()));
				throw new PaasException(PaasException.ERR_BIDDEE_INFO_EXCEPTION,"您没有招标方资质认证,请先进行认证");
			}
			//业务数据逻辑校验
			if(log.isDebugEnabled()){
				log.debug("检验通过，获取请求");
			}
			tenderService.saveProjectRequirementInfo(transorder.getApp().getAppId(),transorder.getBody(),biddee.getId());
		
			
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
	@AccessRequered(methodName = "查询未完成招标项目工程施工证明接口",isJson=true,codebase=242300,className="com.hummingbird.commonbiz.vo.BaseTransVO",genericClassName="com.hummingbird.paas.vo.QueryObjectBodyVO",appLog=true)
	public @ResponseBody ResultModel queryObjectConstructionInfo(HttpServletRequest request,HttpServletResponse response) {
		ResultModel rm = super.getResultModel();
		BaseTransVO<QueryObjectBodyVO> transorder = (BaseTransVO<QueryObjectBodyVO>) super.getParameterObject();
		String messagebase = "查询未完成招标项目工程施工证明接口"; 
	
		RequestEvent qe=null ; //业务请求事件,当实现一些关键的业务时,需要生成该请求
		
		try {
			//业务数据必填等校验
			Token token = tokenSrv.getToken(transorder.getBody().getToken(), transorder.getApp().getAppId());
			if (token == null) {
				log.error(String.format("token[%s]验证失败,或已过期,请重新登录", transorder.getBody().getToken()));
				throw new TokenException("token验证失败,或已过期,请重新登录");
			}
			Biddee biddee = biddeeDao.selectByUserId(token.getUserId());
			if(biddee==null)
			{
				log.error(String.format("用户%s查找不到招标方信息,可能未进行资格认证", token.getUserId()));
				throw new PaasException(PaasException.ERR_BIDDEE_INFO_EXCEPTION,"您没有招标方资质认证,请先进行认证");
			}
			//业务数据逻辑校验
			if(log.isDebugEnabled()){
				log.debug("检验通过，获取请求");
			}
			QueryObjectConstructionInfoResult queryObjectConstructionInfo = tenderService.queryObjectConstructionInfo(transorder.getApp().getAppId(),transorder.getBody(),biddee.getId());
			rm.put("ConstructionInfo", queryObjectConstructionInfo);
			
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
	@RequestMapping(value="/saveObjectConstructionInfo",method=RequestMethod.POST)
	@AccessRequered(methodName = "保存招标项目工程施工证明接口",isJson=true,codebase=242400,className="com.hummingbird.commonbiz.vo.BaseTransVO",genericClassName="com.hummingbird.paas.vo.SaveObjectConstructionInfo",appLog=true)
	public @ResponseBody ResultModel saveObjectConstructionInfo(HttpServletRequest request,HttpServletResponse response) {
		ResultModel rm = super.getResultModel();
		BaseTransVO<SaveObjectConstructionInfo> transorder = (BaseTransVO<SaveObjectConstructionInfo>) super.getParameterObject();
		String messagebase = "保存招标项目工程施工证明接口"; 
	
		RequestEvent qe=null ; //业务请求事件,当实现一些关键的业务时,需要生成该请求
		
		try {
			//业务数据必填等校验
			Token token = tokenSrv.getToken(transorder.getBody().getToken(), transorder.getApp().getAppId());
			if (token == null) {
				log.error(String.format("token[%s]验证失败,或已过期,请重新登录", transorder.getBody().getToken()));
				throw new TokenException("token验证失败,或已过期,请重新登录");
			}
			Biddee biddee = biddeeDao.selectByUserId(token.getUserId());
			if(biddee==null)
			{
				log.error(String.format("用户%s查找不到招标方信息,可能未进行资格认证", token.getUserId()));
				throw new PaasException(PaasException.ERR_BIDDEE_INFO_EXCEPTION,"您没有招标方资质认证,请先进行认证");
			}
			//业务数据逻辑校验
			if(log.isDebugEnabled()){
				log.debug("检验通过，获取请求");
			}
			tenderService.saveObjectConstructionInfo(transorder.getApp().getAppId(),transorder.getBody(),biddee.getId());
		
			
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
	 * 查询未完成招标项目资质要求接口
	 * @return
	 */
	@RequestMapping(value="/queryObjectCertificationInfo",method=RequestMethod.POST)
	@AccessRequered(methodName = "查询未完成招标项目资质要求接口",isJson=true,codebase=242700,className="com.hummingbird.commonbiz.vo.BaseTransVO",genericClassName="com.hummingbird.paas.vo.QueryObjectBodyVO",appLog=true)
	public @ResponseBody ResultModel queryObjectCertificationInfo(HttpServletRequest request,HttpServletResponse response) {
		ResultModel rm = super.getResultModel();
		BaseTransVO<QueryObjectBodyVO> transorder = (BaseTransVO<QueryObjectBodyVO>) super.getParameterObject();
		String messagebase = "查询未完成招标项目资质要求接口"; 
	
		RequestEvent qe=null ; //业务请求事件,当实现一些关键的业务时,需要生成该请求
		
		try {
			//业务数据必填等校验
			Token token = tokenSrv.getToken(transorder.getBody().getToken(), transorder.getApp().getAppId());
			if (token == null) {
				log.error(String.format("token[%s]验证失败,或已过期,请重新登录", transorder.getBody().getToken()));
				throw new TokenException("token验证失败,或已过期,请重新登录");
			}
			Biddee biddee = biddeeDao.selectByUserId(token.getUserId());
			if(biddee==null)
			{
				log.error(String.format("用户%s查找不到招标方信息,可能未进行资格认证", token.getUserId()));
				throw new PaasException(PaasException.ERR_BIDDEE_INFO_EXCEPTION,"您没有招标方资质认证,请先进行认证");
			}
			//业务数据逻辑校验
			if(log.isDebugEnabled()){
				log.debug("检验通过，获取请求");
			}
			QueryObjectCertificationInfoResult result = tenderService.queryObjectCertificationInfo(transorder.getApp().getAppId(),transorder.getBody(),biddee.getId());
			rm.put("certificationInfo", result);
			
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
	 * 保存招标项目资质要求接口
	 * @return
	 */
	@RequestMapping(value="/saveObjectCertificationInfo",method=RequestMethod.POST)
	@AccessRequered(methodName = "保存招标项目资质要求接口",isJson=true,codebase=242800,className="com.hummingbird.commonbiz.vo.BaseTransVO",genericClassName="com.hummingbird.paas.vo.SaveObjectCertificationInfo",appLog=true)
	public @ResponseBody ResultModel saveObjectCertificationInfo(HttpServletRequest request,HttpServletResponse response) {
		ResultModel rm = super.getResultModel();
		BaseTransVO<SaveObjectCertificationInfo> transorder = (BaseTransVO<SaveObjectCertificationInfo>) super.getParameterObject();
		String messagebase = "保存招标项目资质要求接口"; 
	
		RequestEvent qe=null ; //业务请求事件,当实现一些关键的业务时,需要生成该请求
		
		try {
			//业务数据必填等校验
			Token token = tokenSrv.getToken(transorder.getBody().getToken(), transorder.getApp().getAppId());
			if (token == null) {
				log.error(String.format("token[%s]验证失败,或已过期,请重新登录", transorder.getBody().getToken()));
				throw new TokenException("token验证失败,或已过期,请重新登录");
			}
			Biddee biddee = biddeeDao.selectByUserId(token.getUserId());
			if(biddee==null)
			{
				log.error(String.format("用户%s查找不到招标方信息,可能未进行资格认证", token.getUserId()));
				throw new PaasException(PaasException.ERR_BIDDEE_INFO_EXCEPTION,"您没有招标方资质认证,请先进行认证");
			}
			//业务数据逻辑校验
			if(log.isDebugEnabled()){
				log.debug("检验通过，获取请求");
			}
			tenderService.saveObjectCertificationInfo(transorder.getApp().getAppId(),transorder.getBody(),biddee.getId());
		
			
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
	 * 查询未完成招标项目保证金接口
	 * @return
	 */
	@RequestMapping(value="/queryObjectBondInfo",method=RequestMethod.POST)
	@AccessRequered(methodName = "查询未完成招标项目保证金接口",isJson=true,codebase=242900,className="com.hummingbird.commonbiz.vo.BaseTransVO",genericClassName="com.hummingbird.paas.vo.QueryObjectBodyVO",appLog=true)
	public @ResponseBody ResultModel queryObjectBondInfo(HttpServletRequest request,HttpServletResponse response) {
		ResultModel rm = super.getResultModel();
		BaseTransVO<QueryObjectBodyVO> transorder = (BaseTransVO<QueryObjectBodyVO>) super.getParameterObject();
		String messagebase = "查询未完成招标项目保证金接口"; 
	
		RequestEvent qe=null ; //业务请求事件,当实现一些关键的业务时,需要生成该请求
		
		try {
			//业务数据必填等校验
			Token token = tokenSrv.getToken(transorder.getBody().getToken(), transorder.getApp().getAppId());
			if (token == null) {
				log.error(String.format("token[%s]验证失败,或已过期,请重新登录", transorder.getBody().getToken()));
				throw new TokenException("token验证失败,或已过期,请重新登录");
			}
			Biddee biddee = biddeeDao.selectByUserId(token.getUserId());
			if(biddee==null)
			{
				log.error(String.format("用户%s查找不到招标方信息,可能未进行资格认证", token.getUserId()));
				throw new PaasException(PaasException.ERR_BIDDEE_INFO_EXCEPTION,"您没有招标方资质认证,请先进行认证");
			}
			//业务数据逻辑校验
			if(log.isDebugEnabled()){
				log.debug("检验通过，获取请求");
			}
			QueryObjectBondInfoResult result = tenderService.queryObjectBondInfo(transorder.getApp().getAppId(),transorder.getBody(),biddee.getId());
			rm.put("", result);
			
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
	 * 保存招标项目保证金接口
	 * @return
	 */
	@RequestMapping(value="/saveObjectBondInfo",method=RequestMethod.POST)
	@AccessRequered(methodName = "保存招标项目保证金接口",isJson=true,codebase=242900,className="com.hummingbird.commonbiz.vo.BaseTransVO",genericClassName="com.hummingbird.paas.vo.SaveObjectBondInfo",appLog=true)
	public @ResponseBody ResultModel saveObjectBondInfo(HttpServletRequest request,HttpServletResponse response) {
		ResultModel rm = super.getResultModel();
		BaseTransVO<SaveObjectBondInfo> transorder = (BaseTransVO<SaveObjectBondInfo>) super.getParameterObject();
		String messagebase = "保存招标项目保证金接口"; 
	
		RequestEvent qe=null ; //业务请求事件,当实现一些关键的业务时,需要生成该请求
		
		try {
			//业务数据必填等校验
			Token token = tokenSrv.getToken(transorder.getBody().getToken(), transorder.getApp().getAppId());
			if (token == null) {
				log.error(String.format("token[%s]验证失败,或已过期,请重新登录", transorder.getBody().getToken()));
				throw new TokenException("token验证失败,或已过期,请重新登录");
			}
			Biddee biddee = biddeeDao.selectByUserId(token.getUserId());
			if(biddee==null)
			{
				log.error(String.format("用户%s查找不到招标方信息,可能未进行资格认证", token.getUserId()));
				throw new PaasException(PaasException.ERR_BIDDEE_INFO_EXCEPTION,"您没有招标方资质认证,请先进行认证");
			}
			//业务数据逻辑校验
			if(log.isDebugEnabled()){
				log.debug("检验通过，获取请求");
			}
			tenderService.saveObjectBondInfo(transorder.getApp().getAppId(),transorder.getBody(),biddee.getId());
		
			
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
	 * 查询未完成招标项目投标文件接口
	 * @return
	 */
	@RequestMapping(value="/queryBidFileTypeInfo",method=RequestMethod.POST)
	@AccessRequered(methodName = "查询未完成招标项目投标文件接口",isJson=true,codebase=243000,className="com.hummingbird.commonbiz.vo.BaseTransVO",genericClassName="com.hummingbird.paas.vo.QueryObjectBodyVO",appLog=true)
	public @ResponseBody ResultModel queryBidFileTypeInfo(HttpServletRequest request,HttpServletResponse response) {
		ResultModel rm = super.getResultModel();
		BaseTransVO<QueryObjectBodyVO> transorder = (BaseTransVO<QueryObjectBodyVO>) super.getParameterObject();
		String messagebase = "查询未完成招标项目投标文件接口"; 
	
		RequestEvent qe=null ; //业务请求事件,当实现一些关键的业务时,需要生成该请求
		
		try {
			//业务数据必填等校验
			Token token = tokenSrv.getToken(transorder.getBody().getToken(), transorder.getApp().getAppId());
			if (token == null) {
				log.error(String.format("token[%s]验证失败,或已过期,请重新登录", transorder.getBody().getToken()));
				throw new TokenException("token验证失败,或已过期,请重新登录");
			}
			Biddee biddee = biddeeDao.selectByUserId(token.getUserId());
			if(biddee==null)
			{
				log.error(String.format("用户%s查找不到招标方信息,可能未进行资格认证", token.getUserId()));
				throw new PaasException(PaasException.ERR_BIDDEE_INFO_EXCEPTION,"您没有招标方资质认证,请先进行认证");
			}
			//业务数据逻辑校验
			if(log.isDebugEnabled()){
				log.debug("检验通过，获取请求");
			}
			tenderService.queryBidFileTypeInfo(transorder.getApp().getAppId(),transorder.getBody(),biddee.getId());
		
			
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
	 * 保存招标项目投标文件接口
	 * @return
	 */
	@RequestMapping(value="/saveBidFileTypeInfo",method=RequestMethod.POST)
	@AccessRequered(methodName = "保存招标项目投标文件接口",isJson=true,codebase=243100,className="com.hummingbird.commonbiz.vo.BaseTransVO",genericClassName="com.hummingbird.paas.vo.SaveBidFileTypeInfo",appLog=true)
	public @ResponseBody ResultModel saveBidFileTypeInfo(HttpServletRequest request,HttpServletResponse response) {
		ResultModel rm = super.getResultModel();
		BaseTransVO<SaveBidFileTypeInfo> transorder = (BaseTransVO<SaveBidFileTypeInfo>) super.getParameterObject();
		String messagebase = "保存招标项目投标文件接口"; 
	
		RequestEvent qe=null ; //业务请求事件,当实现一些关键的业务时,需要生成该请求
		
		try {
			//业务数据必填等校验
			Token token = tokenSrv.getToken(transorder.getBody().getToken(), transorder.getApp().getAppId());
			if (token == null) {
				log.error(String.format("token[%s]验证失败,或已过期,请重新登录", transorder.getBody().getToken()));
				throw new TokenException("token验证失败,或已过期,请重新登录");
			}
			Biddee biddee = biddeeDao.selectByUserId(token.getUserId());
			if(biddee==null)
			{
				log.error(String.format("用户%s查找不到招标方信息,可能未进行资格认证", token.getUserId()));
				throw new PaasException(PaasException.ERR_BIDDEE_INFO_EXCEPTION,"您没有招标方资质认证,请先进行认证");
			}
			//业务数据逻辑校验
			if(log.isDebugEnabled()){
				log.debug("检验通过，获取请求");
			}
			tenderService.saveBidFileTypeInfo(transorder.getApp().getAppId(),transorder.getBody(),biddee.getId());
		
			
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
