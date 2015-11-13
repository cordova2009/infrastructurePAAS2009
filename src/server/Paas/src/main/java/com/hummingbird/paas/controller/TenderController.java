package com.hummingbird.paas.controller;

import java.util.Date;
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
import com.hummingbird.paas.entity.BidObject;
import com.hummingbird.paas.entity.Biddee;
import com.hummingbird.paas.entity.MembeBiddee;
import com.hummingbird.paas.entity.Token;
import com.hummingbird.paas.exception.PaasException;
import com.hummingbird.paas.mapper.BidObjectMapper;
import com.hummingbird.paas.mapper.BiddeeMapper;
import com.hummingbird.paas.mapper.MembeBiddeeMapper;
import com.hummingbird.paas.services.TenderService;
import com.hummingbird.paas.services.TokenService;
import com.hummingbird.paas.vo.MyObjectTenderSurveyBodyVO;
import com.hummingbird.paas.vo.MyObjectTenderSurveyBodyVOResult;
import com.hummingbird.paas.vo.QueryAnswerMethodInfoBodyVOResult;
import com.hummingbird.paas.vo.QueryBidEvaluationTypeInfoBodyVOResult;
import com.hummingbird.paas.vo.QueryBidFileTypeInfoResult;
import com.hummingbird.paas.vo.QueryDateRequirementInfoBodyVOResult;
import com.hummingbird.paas.vo.QueryObjectBaseInfoBodyVOResult;
import com.hummingbird.paas.vo.QueryObjectBodyVO;
import com.hummingbird.paas.vo.QueryObjectBondInfoResult;
import com.hummingbird.paas.vo.QueryObjectCertificationInfoResult;
import com.hummingbird.paas.vo.QueryObjectConstructionInfoResult;
import com.hummingbird.paas.vo.QueryObjectMethodInfoResult;
import com.hummingbird.paas.vo.QueryObjectProjectInfoResult;
import com.hummingbird.paas.vo.SaveAnswerMethodInfoBodyVO;
import com.hummingbird.paas.vo.SaveBidEvaluationTypeInfoBodyVO;
import com.hummingbird.paas.vo.SaveBidFileTypeInfo;
import com.hummingbird.paas.vo.SaveDateRequirementInfoBodyVO;
import com.hummingbird.paas.vo.SaveObjectBaseInfo;
import com.hummingbird.paas.vo.SaveObjectBondInfo;
import com.hummingbird.paas.vo.SaveObjectCertificationInfo;
import com.hummingbird.paas.vo.SaveObjectConstructionInfo;
import com.hummingbird.paas.vo.SaveObjectMethodInfo;
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
	@Autowired
	MembeBiddeeMapper membiddeeDao;
	@Autowired
	BidObjectMapper objectDao;

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
	 * 我的招标评标概况接口
	 * 
	 * @return
	 */
	@RequestMapping(value = "/isInvitationOfTender", method = RequestMethod.POST)
	@AccessRequered(methodName = "查询招标资质接口", isJson = true, codebase = 230100, className = "com.hummingbird.commonbiz.vo.BaseTransVO", genericClassName = "com.hummingbird.paas.vo.QueryObjectBodyVO", appLog = true)
	public @ResponseBody ResultModel isInvitationOfTender(HttpServletRequest request,
			HttpServletResponse response) {
		ResultModel rm = super.getResultModel();
		BaseTransVO<QueryObjectBodyVO> transorder = (BaseTransVO<QueryObjectBodyVO>) super.getParameterObject();
		String messagebase = "查询招标资质接口";
		
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
			//检查是否会员,非会员只能发布一次
			MembeBiddee membiddee = membiddeeDao.selectByBiddeeId(biddee.getId());
			if(membiddee==null||membiddee.getEndTime().after(new Date()))
			{
				List<BidObject> selectbyBiddeeId = objectDao.selectbyBiddeeId(biddee.getId(), null);
				
				if(selectbyBiddeeId==null&&selectbyBiddeeId.size()>1){
					log.error(String.format("招标人%s还不是会员,不能发布多个招标", biddee.getId()));
					throw new PaasException(PaasException.ERR_BIDDEE_INFO_EXCEPTION,"您还不是会员,最多只能发布一个招标信息");
				}
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
			rm.put("bondInfo", result);
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
			QueryBidFileTypeInfoResult queryBidFileTypeInfo = tenderService.queryBidFileTypeInfo(transorder.getApp().getAppId(),transorder.getBody(),biddee.getId());
			rm.put("bidFileTypeInfo", queryBidFileTypeInfo);
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
	 * 查询未完成招标方式接口
	 * @return
	 */
	@RequestMapping(value="/queryObjectMethodInfo",method=RequestMethod.POST)
	@AccessRequered(methodName = "查询未完成招标方式接口",isJson=true,codebase=243200,className="com.hummingbird.commonbiz.vo.BaseTransVO",genericClassName="com.hummingbird.paas.vo.QueryObjectBodyVO",appLog=true)
	public @ResponseBody ResultModel queryObjectMethodInfo(HttpServletRequest request,HttpServletResponse response) {
		ResultModel rm = super.getResultModel();
		BaseTransVO<QueryObjectBodyVO> transorder = (BaseTransVO<QueryObjectBodyVO>) super.getParameterObject();
		String messagebase = "查询未完成招标方式接口"; 
	
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
			QueryObjectMethodInfoResult result = tenderService.queryObjectMethodInfo(transorder.getApp().getAppId(),transorder.getBody(),biddee.getId());
			rm.put("objectMethodInfo", result);
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
	 * saveObjectMethodInfo
	 * @return
	 */
	@RequestMapping(value="/saveObjectMethodInfo",method=RequestMethod.POST)
	@AccessRequered(methodName = "保存未完成招标方式接口",isJson=true,codebase=243300,className="com.hummingbird.commonbiz.vo.BaseTransVO",genericClassName="com.hummingbird.paas.vo.SaveObjectMethodInfo",appLog=true)
	public @ResponseBody ResultModel saveObjectMethodInfo(HttpServletRequest request,HttpServletResponse response) {
		ResultModel rm = super.getResultModel();
		BaseTransVO<SaveObjectMethodInfo> transorder = (BaseTransVO<SaveObjectMethodInfo>) super.getParameterObject();
		String messagebase = "保存未完成招标方式接口"; 
	
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
			tenderService.saveObjectMethodInfo(transorder.getApp().getAppId(),transorder.getBody(),biddee.getId());
		
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
	 * 查询未完成招标答疑方式接口
	 * @return
	 */
	@RequestMapping(value="/queryAnswerMethodInfo",method=RequestMethod.POST)
	@AccessRequered(methodName = "查询未完成招标答疑方式接口",isJson=true,codebase=243400,className="com.hummingbird.commonbiz.vo.BaseTransVO",genericClassName="com.hummingbird.paas.vo.QueryObjectBodyVO",appLog=true)
	public @ResponseBody ResultModel queryAnswerMethodInfo(HttpServletRequest request,HttpServletResponse response) {
		ResultModel rm = super.getResultModel();
		BaseTransVO<QueryObjectBodyVO> transorder = (BaseTransVO<QueryObjectBodyVO>) super.getParameterObject();
		String messagebase = "查询未完成招标答疑方式接口"; 
	
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
			QueryAnswerMethodInfoBodyVOResult result = tenderService.queryAnswerMethodInfo(transorder.getApp().getAppId(),transorder.getBody(),biddee.getId());
			rm.put("answerQuestion", result);
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
	 * 保存招标答疑方式接口
	 * @return
	 */
	@RequestMapping(value="/saveAnswerMethodInfo",method=RequestMethod.POST)
	@AccessRequered(methodName = "保存招标答疑方式接口",isJson=true,codebase=243500,className="com.hummingbird.commonbiz.vo.BaseTransVO",genericClassName="com.hummingbird.paas.vo.SaveAnswerMethodInfoBodyVO",appLog=true)
	public @ResponseBody ResultModel saveAnswerMethodInfo(HttpServletRequest request,HttpServletResponse response) {
		ResultModel rm = super.getResultModel();
		BaseTransVO<SaveAnswerMethodInfoBodyVO> transorder = (BaseTransVO<SaveAnswerMethodInfoBodyVO>) super.getParameterObject();
		String messagebase = "保存招标答疑方式接口"; 
	
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
			tenderService.saveAnswerMethodInfo(transorder.getApp().getAppId(),transorder.getBody());
		
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
	 * 查询未完成招标时间要求接口
	 * @return
	 */
	@RequestMapping(value="/queryDateRequirementInfo",method=RequestMethod.POST)
	@AccessRequered(methodName = "查询未完成招标时间要求接口",isJson=true,codebase=243600,className="com.hummingbird.commonbiz.vo.BaseTransVO",genericClassName="com.hummingbird.paas.vo.QueryObjectBodyVO",appLog=true)
	public @ResponseBody ResultModel queryDateRequirementInfo(HttpServletRequest request,HttpServletResponse response) {
		ResultModel rm = super.getResultModel();
		BaseTransVO<QueryObjectBodyVO> transorder = (BaseTransVO<QueryObjectBodyVO>) super.getParameterObject();
		String messagebase = "查询未完成招标时间要求接口"; 
	
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
			QueryDateRequirementInfoBodyVOResult result = tenderService.queryDateRequirementInfo(transorder.getApp().getAppId(),transorder.getBody(),biddee.getId());
			rm.put("dateRequirementInfo", result);
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
	 * 保存招标时间要求
	 * @return
	 */
	@RequestMapping(value="/saveDateRequirementInfo",method=RequestMethod.POST)
	@AccessRequered(methodName = "保存招标时间要求",isJson=true,codebase=243700,className="com.hummingbird.commonbiz.vo.BaseTransVO",genericClassName="com.hummingbird.paas.vo.SaveDateRequirementInfoBodyVO",appLog=true)
	public @ResponseBody ResultModel saveDateRequirementInfo(HttpServletRequest request,HttpServletResponse response) {
		ResultModel rm = super.getResultModel();
		BaseTransVO<SaveDateRequirementInfoBodyVO> transorder = (BaseTransVO<SaveDateRequirementInfoBodyVO>) super.getParameterObject();
		String messagebase = "保存招标时间要求"; 
	
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
			tenderService.saveDateRequirementInfo(transorder.getApp().getAppId(),transorder.getBody());
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
	 * 查询未完成招标评标方式接口
	 * @return
	 */
	@RequestMapping(value="/queryBidEvaluationTypeInfo",method=RequestMethod.POST)
	@AccessRequered(methodName = "查询未完成招标评标方式接口",isJson=true,codebase=243800,className="com.hummingbird.commonbiz.vo.BaseTransVO",genericClassName="com.hummingbird.paas.vo.QueryObjectBodyVO",appLog=true)
	public @ResponseBody ResultModel queryBidEvaluationTypeInfo(HttpServletRequest request,HttpServletResponse response) {
		ResultModel rm = super.getResultModel();
		BaseTransVO<QueryObjectBodyVO> transorder = (BaseTransVO<QueryObjectBodyVO>) super.getParameterObject();
		String messagebase = "查询未完成招标评标方式接口"; 
	
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
			QueryBidEvaluationTypeInfoBodyVOResult result = tenderService.queryBidEvaluationTypeInfo(transorder.getApp().getAppId(),transorder.getBody(),biddee.getId());
			rm.put("bidEvaluationTypeInfo", result);
		
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
	 * 保存招标评标方式接口
	 * @return
	 */
	@RequestMapping(value="/saveBidEvaluationTypeInfo",method=RequestMethod.POST)
	@AccessRequered(methodName = "保存招标评标方式接口",isJson=true,codebase=243900,className="com.hummingbird.commonbiz.vo.BaseTransVO",genericClassName="com.hummingbird.paas.vo.SaveBidEvaluationTypeInfoBodyVO",appLog=true)
	public @ResponseBody ResultModel saveBidEvaluationTypeInfo(HttpServletRequest request,HttpServletResponse response) {
		ResultModel rm = super.getResultModel();
		BaseTransVO<SaveBidEvaluationTypeInfoBodyVO> transorder = (BaseTransVO<SaveBidEvaluationTypeInfoBodyVO>) super.getParameterObject();
		String messagebase = "保存招标评标方式接口"; 
	
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
			tenderService.saveBidEvaluationTypeInfo(transorder.getApp().getAppId(),transorder.getBody());
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
	 * 发布标的接口
	 * @return
	 */
	@RequestMapping(value="/submitObject",method=RequestMethod.POST)
	@AccessRequered(methodName = "发布标的接口",isJson=true,codebase=244000,className="com.hummingbird.commonbiz.vo.BaseTransVO",genericClassName="com.hummingbird.paas.vo.QueryObjectBodyVO",appLog=true)
	public @ResponseBody ResultModel submitObject(HttpServletRequest request,HttpServletResponse response) {
		ResultModel rm = super.getResultModel();
		BaseTransVO<QueryObjectBodyVO> transorder = (BaseTransVO<QueryObjectBodyVO>) super.getParameterObject();
		String messagebase = "发布标的接口"; 
	
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
			tenderService.submitObject(transorder.getApp().getAppId(),transorder.getBody(),biddee.getId());
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
	
	
}
