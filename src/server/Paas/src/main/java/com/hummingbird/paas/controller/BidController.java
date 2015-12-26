package com.hummingbird.paas.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.hummingbird.common.controller.BaseController;
import com.hummingbird.common.event.EventListenerContainer;
import com.hummingbird.common.event.RequestEvent;
import com.hummingbird.common.exception.ValidateException;
import com.hummingbird.common.ext.AccessRequered;
import com.hummingbird.common.face.AbstractAppLog;
import com.hummingbird.common.face.Pagingnation;
import com.hummingbird.common.util.DateUtil;
import com.hummingbird.common.util.PropertiesUtil;
import com.hummingbird.common.util.RequestUtil;
import com.hummingbird.common.vo.ResultModel;
import com.hummingbird.commonbiz.exception.TokenException;
import com.hummingbird.commonbiz.vo.BaseTransVO;
import com.hummingbird.commonbiz.vo.BaseTransVO;
import com.hummingbird.commonbiz.vo.BaseTransVO;
import com.hummingbird.paas.entity.AppLog;
import com.hummingbird.paas.entity.BidObject;
import com.hummingbird.paas.entity.BidRecord;
import com.hummingbird.paas.entity.Biddee;
import com.hummingbird.paas.entity.Bidder;
import com.hummingbird.paas.entity.ProjectStatus;
import com.hummingbird.paas.entity.Token;
import com.hummingbird.paas.entity.User;
import com.hummingbird.paas.exception.MaAccountException;
import com.hummingbird.paas.exception.PaasException;
import com.hummingbird.paas.mapper.AppLogMapper;
import com.hummingbird.paas.mapper.BidObjectMapper;
import com.hummingbird.paas.mapper.BiddeeMapper;
import com.hummingbird.paas.mapper.BidderMapper;
import com.hummingbird.paas.mapper.MemberBiddeeMapper;
import com.hummingbird.paas.mapper.ObjectProjectMapper;
import com.hummingbird.paas.mapper.ProjectEvaluationBiddeeMapper;
import com.hummingbird.paas.mapper.ProjectStatusMapper;
import com.hummingbird.paas.services.BidService;
import com.hummingbird.paas.services.BiddeeServiceService;
import com.hummingbird.paas.services.TokenService;
import com.hummingbird.paas.services.UserService;
import com.hummingbird.paas.util.CallInterfaceUtil;
import com.hummingbird.paas.vo.AbstractBidFileTypeInfo;
import com.hummingbird.paas.vo.BidEvaluateReturnVO;
import com.hummingbird.paas.vo.EvaluateBiddeeBodyVO;
import com.hummingbird.paas.vo.FreezeBondReturnVO;
import com.hummingbird.paas.vo.GetMsgListBodyVO;
import com.hummingbird.paas.vo.JsonResult;
import com.hummingbird.paas.vo.JsonResultMsg;
import com.hummingbird.paas.vo.MyObjectTenderSurveyBodyVO;
import com.hummingbird.paas.vo.QueryBidBodyVO;
import com.hummingbird.paas.vo.QueryBidRequirementInfoBodyVOResult;
import com.hummingbird.paas.vo.QueryBidderBondBodyVOResult;
import com.hummingbird.paas.vo.QueryBidderCompanyInfoBodyVOResult;
import com.hummingbird.paas.vo.QueryBusinessStandardInfoBodyVOResult;
import com.hummingbird.paas.vo.QueryMakeMatchBidderBondBodyVOResult;
import com.hummingbird.paas.vo.QueryMyBidObjectListResultVO;
import com.hummingbird.paas.vo.QueryMyBuildingObjectListResultVO;
import com.hummingbird.paas.vo.QueryMyEndedObjectListResultVO;
import com.hummingbird.paas.vo.QueryMyLoseObjectListResultVO;
import com.hummingbird.paas.vo.QueryObjectBodyVO;
import com.hummingbird.paas.vo.QueryObjectCertificationInfoResult;
import com.hummingbird.paas.vo.QueryObjectDetailResultVO;
import com.hummingbird.paas.vo.QueryObjectListResultVO;
import com.hummingbird.paas.vo.QueryTechnicalStandardInfoBodyVOResult;
import com.hummingbird.paas.vo.SaveBidRequirementInfoBodyVO;
import com.hummingbird.paas.vo.SaveBidderBondBodyVO;
import com.hummingbird.paas.vo.SaveBusinessStandardInfoBodyVO;
import com.hummingbird.paas.vo.SaveMakeMatchBidderBondBodyVO;
import com.hummingbird.paas.vo.SaveTechnicalStandardInfoBodyVO;
import com.hummingbird.paas.vo.SubmitBidBodyVO;
import com.hummingbird.paas.vo.TagInfo;
import com.hummingbird.paas.vo.UnfreezeBondVO;

/**
 * @author
 * @date 2015-11-13
 * @version 1.0
 * 
 */
@Controller
@RequestMapping(value = "bid", method = RequestMethod.POST)
public class BidController extends BaseController {
	@Autowired(required = true)
	protected BidService bidService;
	@Autowired
	TokenService tokenSrv;
	@Autowired
	BidderMapper bidderDao;
	@Autowired
	BiddeeMapper biddeeDao;
	@Autowired
	MemberBiddeeMapper membiddeeDao;
	@Autowired
	BidObjectMapper objectDao;
	@Autowired 
	UserService userSer;
	@Autowired(required = true)
	protected AppLogMapper applogDao;
	
	@Autowired
	BiddeeServiceService beeServiceSer;
	@Autowired
	ProjectStatusMapper psDao;
	@Autowired
	BidObjectMapper  bidObjectDao;
	@Autowired
	protected ProjectEvaluationBiddeeMapper pebDao;
	@Autowired
	ObjectProjectMapper obDao;

	/**
	 * 查询投标要求基础信息接口
	 * 
	 * @return
	 */
	@RequestMapping(value = "/queryObjectRequirementInfo", method = RequestMethod.POST)
	@AccessRequered(methodName = "查询投标要求基础信息接口", isJson = true, codebase = 245900, className = "com.hummingbird.commonbiz.vo.BaseTransVO", genericClassName = "com.hummingbird.paas.vo.QueryBidBodyVO", appLog = true)
	public @ResponseBody ResultModel queryObjectRequirementInfo(HttpServletRequest request, HttpServletResponse response) {
		ResultModel rm = super.getResultModel();
		BaseTransVO<QueryBidBodyVO> transorder = (BaseTransVO<QueryBidBodyVO>) super.getParameterObject();
		String messagebase = "查询投标要求基础信息接口";

		RequestEvent qe = null; // 业务请求事件,当实现一些关键的业务时,需要生成该请求

		try {
			// 业务数据必填等校验
			// 业务数据逻辑校验
			if (log.isDebugEnabled()) {
				log.debug("检验通过，获取请求");
			}
			QueryObjectCertificationInfoResult result = bidService
					.queryObjectRequirementInfo(transorder.getApp().getAppId(), transorder.getBody());
			Map bidSafetyInfo=new HashMap<>();
			rm.put("bidSafetyInfo", bidSafetyInfo);
			Map bidPeopleRequirement=new HashMap<>();
			rm.put("bidPeopleRequirement", bidPeopleRequirement);
			
			bidSafetyInfo.put("needSafetyPermit", result==null?null:result.getNeedSafetyPermit());
			bidSafetyInfo.put("needPmSafetyCertification", result==null?null:result.getNeedPmSafetyCertification());
			bidPeopleRequirement.put("needPmCertification", result==null?null:result.getNeedPmCertification());
			bidPeopleRequirement.put("needConstructorCertification",result==null?null: result.getNeedConstructorCertification());
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
	 * 查询未完成的投标资格审查信息接口
	 * 
	 * @return
	 */
	@RequestMapping(value = "/queryBidRequirementInfo", method = RequestMethod.POST)
	@AccessRequered(methodName = "查询未完成的投标资格审查信息接口", isJson = true, codebase = 246000, className = "com.hummingbird.commonbiz.vo.BaseTransVO", genericClassName = "com.hummingbird.paas.vo.QueryBidBodyVO", appLog = true)
	public @ResponseBody ResultModel queryBidRequirementInfo(HttpServletRequest request, HttpServletResponse response) {
		ResultModel rm = super.getResultModel();
		BaseTransVO<QueryBidBodyVO> transorder = (BaseTransVO<QueryBidBodyVO>) super.getParameterObject();
		String messagebase = "查询未完成的投标资格审查信息接口";
		
		RequestEvent qe = null; // 业务请求事件,当实现一些关键的业务时,需要生成该请求
		
		try {
			// 业务数据必填等校验
			Token token = tokenSrv.getToken(transorder.getBody().getToken(), transorder.getApp().getAppId());
			if (token == null) {
				log.error(String.format("token[%s]验证失败,或已过期,请重新登录", transorder.getBody().getToken()));
				throw new TokenException("token验证失败,或已过期,请重新登录");
			}
			Bidder bidder = bidderDao.selectByUserId(token.getUserId());
			if (bidder == null) {
				log.error(String.format("用户%s查找不到投标方信息,可能未进行资格认证", token.getUserId()));
				throw new PaasException(PaasException.ERR_BIDDER_INFO_EXCEPTION, "您没有投标方资质认证,请先进行认证");
			}
			// 业务数据逻辑校验
			if (log.isDebugEnabled()) {
				log.debug("检验通过，获取请求");
			}
			QueryBidRequirementInfoBodyVOResult result = bidService
					.queryBidRequirementInfo(transorder.getApp().getAppId(), transorder.getBody(), bidder.getId());
			rm.put("bidRequirementInfo", result);
			
			tokenSrv.postponeToken(token);
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
	 * 保存投标资格审查信息接口
	 * 
	 * @return
	 */
	@RequestMapping(value = "/saveBidRequirementInfo", method = RequestMethod.POST)
	@AccessRequered(methodName = "保存投标资格审查信息接口", isJson = true, codebase = 246100, className = "com.hummingbird.commonbiz.vo.BaseTransVO", genericClassName = "com.hummingbird.paas.vo.SaveBidRequirementInfoBodyVO", appLog = true)
	public @ResponseBody ResultModel saveBidRequirementInfo(HttpServletRequest request, HttpServletResponse response) {
		ResultModel rm = super.getResultModel();
		BaseTransVO<SaveBidRequirementInfoBodyVO> transorder = (BaseTransVO<SaveBidRequirementInfoBodyVO>) super.getParameterObject();
		String messagebase = "保存投标资格审查信息接口";

		RequestEvent qe = null; // 业务请求事件,当实现一些关键的业务时,需要生成该请求

		try {
			// 业务数据必填等校验
			Token token = tokenSrv.getToken(transorder.getBody().getToken(), transorder.getApp().getAppId());
			if (token == null) {
				log.error(String.format("token[%s]验证失败,或已过期,请重新登录", transorder.getBody().getToken()));
				throw new TokenException("token验证失败,或已过期,请重新登录");
			}
			Bidder bidder = bidderDao.selectByUserId(token.getUserId());
			if (bidder == null) {
				log.error(String.format("用户%s查找不到投标方信息,可能未进行资格认证", token.getUserId()));
				throw new PaasException(PaasException.ERR_BIDDER_INFO_EXCEPTION, "您没有投标方资质认证,请先进行认证");
			}
			// 业务数据逻辑校验
			if (log.isDebugEnabled()) {
				log.debug("检验通过，获取请求");
			}
			BidRecord bid = bidService.saveBidRequirementInfo(transorder.getApp().getAppId(), transorder.getBody(), bidder.getId());
			rm.put("bidId", bid.getId());
			tokenSrv.postponeToken(token);
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
	 * 查询未完成投标的商务标信息接口
	 * 
	 * @return
	 */
	@RequestMapping(value = "/queryBusinessStandardInfo", method = RequestMethod.POST)
	@AccessRequered(methodName = "查询未完成投标的商务标信息接口", isJson = true, codebase = 246200, className = "com.hummingbird.commonbiz.vo.BaseTransVO", genericClassName = "com.hummingbird.paas.vo.QueryBidBodyVO", appLog = true)
	public @ResponseBody ResultModel queryBusinessStandardInfo(HttpServletRequest request,
			HttpServletResponse response) {
		ResultModel rm = super.getResultModel();
		BaseTransVO<QueryBidBodyVO> transorder = (BaseTransVO<QueryBidBodyVO>) super.getParameterObject();
		String messagebase = "查询未完成投标的商务标信息接口";

		RequestEvent qe = null; // 业务请求事件,当实现一些关键的业务时,需要生成该请求

		try {
			// 业务数据必填等校验
			Token token = tokenSrv.getToken(transorder.getBody().getToken(), transorder.getApp().getAppId());
			if (token == null) {
				log.error(String.format("token[%s]验证失败,或已过期,请重新登录", transorder.getBody().getToken()));
				throw new TokenException("token验证失败,或已过期,请重新登录");
			}
			Bidder bidder = validateWithBusiness(transorder.getBody().getToken(), transorder.getApp().getAppId(), token);
			// 业务数据逻辑校验
			if (log.isDebugEnabled()) {
				log.debug("检验通过，获取请求");
			}
			QueryBusinessStandardInfoBodyVOResult result = bidService
					.queryBusinessStandardInfo(transorder.getApp().getAppId(), transorder.getBody(),bidder.getId());
			rm.put("businessStandardInfo", result);
			tokenSrv.postponeToken(token);
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
	 * @param token
	 * @param appId
	 * @param token2
	 * @return 
	 * @throws PaasException 
	 */
	private Bidder validateWithBusiness(String tokenstr, String appId, Token token) throws PaasException {
		Bidder bidder = bidderDao.selectByUserId(token.getUserId());
		if (bidder == null) {
			log.error(String.format("用户%s查找不到投标方信息,可能未进行资格认证", token.getUserId()));
			throw new PaasException(PaasException.ERR_BIDDER_INFO_EXCEPTION, "您没有投标方资质认证,请先进行认证");
		}
		return bidder;
		
	}
	
	/**
	 * 保存投标的商务标信息接口
	 * @return
	 */
	@RequestMapping(value="/saveBusinessStandardInfo",method=RequestMethod.POST)
	@AccessRequered(methodName = "保存投标的商务标信息接口",isJson=true,codebase=246300,className="com.hummingbird.commonbiz.vo.BaseTransVO",genericClassName="com.hummingbird.paas.vo.SaveBusinessStandardInfoBodyVO",appLog=true)
	public @ResponseBody ResultModel saveBusinessStandardInfo(HttpServletRequest request,HttpServletResponse response) {
		ResultModel rm = super.getResultModel();
		BaseTransVO<SaveBusinessStandardInfoBodyVO> transorder = (BaseTransVO<SaveBusinessStandardInfoBodyVO>) super.getParameterObject();
		String messagebase = "保存投标的商务标信息接口"; 
	
		RequestEvent qe=null ; //业务请求事件,当实现一些关键的业务时,需要生成该请求
		
		try {
			//业务数据必填等校验
			Token token = tokenSrv.getToken(transorder.getBody().getToken(), transorder.getApp().getAppId());
			if (token == null) {
				log.error(String.format("token[%s]验证失败,或已过期,请重新登录", transorder.getBody().getToken()));
				throw new TokenException("token验证失败,或已过期,请重新登录");
			}
			Bidder bidder = validateWithBusiness(transorder.getBody().getToken(), transorder.getApp().getAppId(),token);
			//业务数据逻辑校验
			if(log.isDebugEnabled()){
				log.debug("检验通过，获取请求");
			}
			bidService.saveBusinessStandardInfo(transorder.getApp().getAppId(),transorder.getBody(),bidder.getId());
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
	 * 查询未完成投标的技术标信息接口
	 * @return
	 */
	@RequestMapping(value="/queryTechnicalStandardInfo",method=RequestMethod.POST)
	@AccessRequered(methodName = "查询未完成投标的技术标信息接口",isJson=true,codebase=246400,className="com.hummingbird.commonbiz.vo.BaseTransVO",genericClassName="com.hummingbird.paas.vo.QueryBidBodyVO",appLog=true)
	public @ResponseBody ResultModel queryTechnicalStandardInfo(HttpServletRequest request,HttpServletResponse response) {
		ResultModel rm = super.getResultModel();
		BaseTransVO<QueryBidBodyVO> transorder = (BaseTransVO<QueryBidBodyVO>) super.getParameterObject();
		String messagebase = "查询未完成投标的技术标信息接口"; 
	
		RequestEvent qe=null ; //业务请求事件,当实现一些关键的业务时,需要生成该请求
		
		try {
			//业务数据必填等校验
			Token token = tokenSrv.getToken(transorder.getBody().getToken(), transorder.getApp().getAppId());
			if (token == null) {
				log.error(String.format("token[%s]验证失败,或已过期,请重新登录", transorder.getBody().getToken()));
				throw new TokenException("token验证失败,或已过期,请重新登录");
			}
			Bidder bidder = validateWithBusiness(transorder.getBody().getToken(), transorder.getApp().getAppId(),token);
			//业务数据逻辑校验
			if(log.isDebugEnabled()){
				log.debug("检验通过，获取请求");
			}
			QueryTechnicalStandardInfoBodyVOResult  result = bidService.queryTechnicalStandardInfo(transorder.getApp().getAppId(),transorder.getBody(),bidder.getId());
			rm.put("technicalStandardInfo",result);
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
	 * 保存投标的技术标信息接口
	 * @return
	 */
	@RequestMapping(value="/saveTechnicalStandardInfo",method=RequestMethod.POST)
	@AccessRequered(methodName = "保存投标的技术标信息接口",isJson=true,codebase=246500,className="com.hummingbird.commonbiz.vo.BaseTransVO",genericClassName="com.hummingbird.paas.vo.SaveTechnicalStandardInfoBodyVO",appLog=true)
	public @ResponseBody ResultModel saveTechnicalStandardInfo(HttpServletRequest request,HttpServletResponse response) {
		ResultModel rm = super.getResultModel();
		BaseTransVO<SaveTechnicalStandardInfoBodyVO> transorder = (BaseTransVO<SaveTechnicalStandardInfoBodyVO>) super.getParameterObject();
		String messagebase = "保存投标的技术标信息接口"; 
	
		RequestEvent qe=null ; //业务请求事件,当实现一些关键的业务时,需要生成该请求
		
		try {
			//业务数据必填等校验
			Token token = tokenSrv.getToken(transorder.getBody().getToken(), transorder.getApp().getAppId());
			if (token == null) {
				log.error(String.format("token[%s]验证失败,或已过期,请重新登录", transorder.getBody().getToken()));
				throw new TokenException("token验证失败,或已过期,请重新登录");
			}
			Bidder bidder = validateWithBusiness(transorder.getBody().getToken(), transorder.getApp().getAppId(),token);
			//业务数据逻辑校验
			if(log.isDebugEnabled()){
				log.debug("检验通过，获取请求");
			}
						bidService.saveTechnicalStandardInfo(transorder.getApp().getAppId(),transorder.getBody(),bidder.getId());
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
	 * 查询投标保证金信息接口
	 * @return
	 */
	@RequestMapping(value="/queryBidderBond",method=RequestMethod.POST)
	@AccessRequered(methodName = "查询投标保证金信息接口",isJson=true,codebase=246600,className="com.hummingbird.commonbiz.vo.BaseTransVO",genericClassName="com.hummingbird.paas.vo.QueryBidBodyVO",appLog=true)
	public @ResponseBody ResultModel queryBidderBond(HttpServletRequest request,HttpServletResponse response) {
		ResultModel rm = super.getResultModel();
		BaseTransVO<QueryBidBodyVO> transorder = (BaseTransVO<QueryBidBodyVO>) super.getParameterObject();
		String messagebase = "查询投标保证金信息接口"; 
	
		RequestEvent qe=null ; //业务请求事件,当实现一些关键的业务时,需要生成该请求
		
		try {
			//业务数据必填等校验
			Token token = tokenSrv.getToken(transorder.getBody().getToken(), transorder.getApp().getAppId());
			if (token == null) {
				log.error(String.format("token[%s]验证失败,或已过期,请重新登录", transorder.getBody().getToken()));
				throw new TokenException("token验证失败,或已过期,请重新登录");
			}
			Bidder bidder = validateWithBusiness(transorder.getBody().getToken(), transorder.getApp().getAppId(),token);
			//业务数据逻辑校验
			if(log.isDebugEnabled()){
				log.debug("检验通过，获取请求");
			}
			QueryBidderBondBodyVOResult  result = bidService.queryBidderBond(transorder.getApp().getAppId(),transorder.getBody(),bidder.getId());
			rm.put("bond",result);
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
	 * 保存投标保证金接口
	 * @return
	 */
	@RequestMapping(value="/saveBidderBond",method=RequestMethod.POST)
	@AccessRequered(methodName = "保存投标保证金接口",isJson=true,codebase=246700,className="com.hummingbird.commonbiz.vo.BaseTransVO",genericClassName="com.hummingbird.paas.vo.SaveBidderBondBodyVO",appLog=true)
	public @ResponseBody ResultModel saveBidderBond(HttpServletRequest request,HttpServletResponse response) {
		ResultModel rm = super.getResultModel();
		BaseTransVO<SaveBidderBondBodyVO> transorder = (BaseTransVO<SaveBidderBondBodyVO>) super.getParameterObject();
		String messagebase = "保存投标保证金接口"; 
	
		RequestEvent qe=null ; //业务请求事件,当实现一些关键的业务时,需要生成该请求
		
		try {
			//业务数据必填等校验
			Token token = tokenSrv.getToken(transorder.getBody().getToken(), transorder.getApp().getAppId());
			if (token == null) {
				log.error(String.format("token[%s]验证失败,或已过期,请重新登录", transorder.getBody().getToken()));
				throw new TokenException("token验证失败,或已过期,请重新登录");
			}
			Bidder bidder = validateWithBusiness(transorder.getBody().getToken(), transorder.getApp().getAppId(),token);
			//业务数据逻辑校验
			if(log.isDebugEnabled()){
				log.debug("检验通过，获取请求");
			}
			bidService.saveBidderBond(transorder.getApp().getAppId(),transorder.getBody(),bidder.getId());
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
	 * 查询投标人资质证书接口
	 * 
	 * @return
	 */
	@RequestMapping(value = "/queryBidderCertificationInfo", method = RequestMethod.POST)
	@AccessRequered(methodName = "查询投标人资质证书接口", isJson = true, codebase = 247300, className = "com.hummingbird.commonbiz.vo.BaseTransVO", genericClassName = "com.hummingbird.paas.vo.QueryBidBodyVO", appLog = true)
	public @ResponseBody ResultModel queryBidderCertificationInfo(HttpServletRequest request, HttpServletResponse response) {
		ResultModel rm = super.getResultModel();
		BaseTransVO<QueryBidBodyVO> transorder = (BaseTransVO<QueryBidBodyVO>) super.getParameterObject();
		String messagebase = "查询投标人资质证书接口";
		RequestEvent qe = null; // 业务请求事件,当实现一些关键的业务时,需要生成该请求

		try {
			// 业务数据必填等校验
			Token token = tokenSrv.getToken(transorder.getBody().getToken(), transorder.getApp().getAppId());
			if (token == null) {
				log.error(String.format("token[%s]验证失败,或已过期,请重新登录", transorder.getBody().getToken()));
				throw new TokenException("token验证失败,或已过期,请重新登录");
			}
			Bidder bidder = bidderDao.selectByUserId(token.getUserId());
			if (bidder == null) {
				log.error(String.format("用户%s查找不到投标方信息,可能未进行资格认证", token.getUserId()));
				throw new PaasException(PaasException.ERR_BIDDER_INFO_EXCEPTION, "您没有投标方资质认证,请先进行认证");
			}
			// 业务数据逻辑校验
			if (log.isDebugEnabled()) {
				log.debug("检验通过，获取请求");
			}
			Map certs = bidService.queryBidderCertificationInfo(transorder.getBody(),bidder.getId());
			Map result = new HashMap<>();
			rm.put("certificationInfo", certs);
			tokenSrv.postponeToken(token);
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
	@AccessRequered(methodName = "查询用户是否具有投标的资质", isJson = true, codebase = 247400, className = "com.hummingbird.commonbiz.vo.BaseTransVO", genericClassName = "com.hummingbird.paas.vo.QueryObjectBodyVO", appLog = true)
	public @ResponseBody ResultModel isInvitationOfBid(HttpServletRequest request, HttpServletResponse response) {
		ResultModel rm = super.getResultModel();
		BaseTransVO<QueryObjectBodyVO> transorder = (BaseTransVO<QueryObjectBodyVO>) super.getParameterObject();
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
			bidService.hadQualify2bid(transorder.getBody(),token.getUserId());
//			Boolean flag = bidService.queryTender(transorder.getBody(),token.getUserId());
//			if(!flag){
//				rm.setErrmsg("查询用户不具有投标的资质");
//				return rm;
//			}else{
//				rm.setErrmsg("该用户具有投标的资质");
//			}
			tokenSrv.postponeToken(token);
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
	 * 查询招标公告列表接口
	 * @return  queryObjectList
	 */
	@RequestMapping(value="/queryObjectList",method=RequestMethod.POST)
	@AccessRequered(methodName = "查询招标公告列表接口",isJson=true,codebase=242300,className="com.hummingbird.commonbiz.vo.BaseTransVO",genericClassName="com.hummingbird.paas.vo.GetMsgListBodyVO",appLog=true)
	public @ResponseBody ResultModel queryObjectList(HttpServletRequest request,HttpServletResponse response) {
		ResultModel rm = super.getResultModel();
		BaseTransVO<GetMsgListBodyVO> transorder = (BaseTransVO<GetMsgListBodyVO>) super.getParameterObject();
		String messagebase = "查询招标公告列表接口"; 
		RequestEvent qe=null ; 
		List<QueryObjectListResultVO> liq = null;
		try {
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
			if(pageIndex==null||pageSize==null||pageIndex<=0||pageSize<=0){
				log.error(String.format(messagebase + "失败"));
				rm.setErrmsg("参数错误");
				return rm;
			}
			Pagingnation pagingnation = transorder.getBody().toPagingnation();
			liq = bidService.queryObjectList(pagingnation,token.getUserId());
	        super.mergeListOutput(rm, pagingnation, liq);
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
	 * 查询撮合投标保证金接口
	 * @return
	 */
	@RequestMapping(value="/queryMakeMatchBidderBond",method=RequestMethod.POST)
	@AccessRequered(methodName = "查询撮合投标保证金接口",isJson=true,codebase=246800,className="com.hummingbird.commonbiz.vo.BaseTransVO",genericClassName="com.hummingbird.paas.vo.QueryBidBodyVO",appLog=true)
	public @ResponseBody ResultModel queryMakeMatchBidderBond(HttpServletRequest request,HttpServletResponse response) {
		ResultModel rm = super.getResultModel();
		BaseTransVO<QueryBidBodyVO> transorder = (BaseTransVO<QueryBidBodyVO>) super.getParameterObject();
		String messagebase = "查询撮合投标保证金接口"; 
	
		RequestEvent qe=null ; //业务请求事件,当实现一些关键的业务时,需要生成该请求
		
		try {
			//业务数据必填等校验
			Token token = tokenSrv.getToken(transorder.getBody().getToken(), transorder.getApp().getAppId());
			if (token == null) {
				log.error(String.format("token[%s]验证失败,或已过期,请重新登录", transorder.getBody().getToken()));
				throw new TokenException("token验证失败,或已过期,请重新登录");
			}
			Bidder bidder=validateWithBusiness(transorder.getBody().getToken(), transorder.getApp().getAppId(),token);
			//业务数据逻辑校验
			if(log.isDebugEnabled()){
				log.debug("检验通过，获取请求");
			}
			QueryMakeMatchBidderBondBodyVOResult  result = bidService.queryMakeMatchBidderBond(transorder.getApp().getAppId(),transorder.getBody(),bidder.getId());
			rm.put("bond",result);
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
	 * 提交撮合投标保证金信息接口
	 * @return
	 */
	@RequestMapping(value="/saveMakeMatchBidderBond",method=RequestMethod.POST)
	@AccessRequered(methodName = "提交撮合投标保证金信息接口",isJson=true,codebase=246900,className="com.hummingbird.commonbiz.vo.BaseTransVO",genericClassName="com.hummingbird.paas.vo.SaveMakeMatchBidderBondBodyVO",appLog=true)
	public @ResponseBody ResultModel saveMakeMatchBidderBond(HttpServletRequest request,HttpServletResponse response) {
		ResultModel rm = super.getResultModel();
		BaseTransVO<SaveMakeMatchBidderBondBodyVO> transorder = (BaseTransVO<SaveMakeMatchBidderBondBodyVO>) super.getParameterObject();
		String messagebase = "提交撮合投标保证金信息接口"; 
	
		RequestEvent qe=null ; //业务请求事件,当实现一些关键的业务时,需要生成该请求
		
		try {
			//业务数据必填等校验
			Token token = tokenSrv.getToken(transorder.getBody().getToken(), transorder.getApp().getAppId());
			if (token == null) {
				log.error(String.format("token[%s]验证失败,或已过期,请重新登录", transorder.getBody().getToken()));
				throw new TokenException("token验证失败,或已过期,请重新登录");
			}
			Bidder bidder=validateWithBusiness(transorder.getBody().getToken(), transorder.getApp().getAppId(),token);
			//业务数据逻辑校验
			if(log.isDebugEnabled()){
				log.debug("检验通过，获取请求");
			}
			bidService.saveMakeMatchBidderBond(transorder.getApp().getAppId(),transorder.getBody(),bidder);
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
	 * 撮合担保金退还接口
	 * @return
	 */
	@RequestMapping(value="/unfreezeBond",method=RequestMethod.POST)
	@AccessRequered(methodName = "撮合担保金退还接口",isJson=true,codebase=247000,className="com.hummingbird.commonbiz.vo.BaseTransVO",genericClassName="com.hummingbird.paas.vo.SaveMakeMatchBidderBondBodyVO",appLog=true)
	public @ResponseBody ResultModel unfreezeBond(HttpServletRequest request,HttpServletResponse response) {

		final BaseTransVO<UnfreezeBondVO> transorder;
		ResultModel rm = new ResultModel();
		try {
			String jsonstr = RequestUtil.getRequestPostData(request);
			request.setAttribute("rawjson", jsonstr);
			transorder = RequestUtil.convertJson2Obj(jsonstr,BaseTransVO.class, UnfreezeBondVO.class);
		} catch (Exception e) {
			log.error(String.format("获取订单参数出错"),e);
			rm.mergeException(ValidateException.ERROR_PARAM_FORMAT_ERROR.cloneAndAppend(null, "订单参数"));
			return rm;
		}
		
		String messagebase = "解冻撮合担保金";
		rm.setBaseErrorCode(247100);
		rm.setErrmsg(messagebase+"成功");
		try {
			//获取url以作为method的内容
			String requestURI = request.getRequestURI();
			requestURI=requestURI.replace(request.getContextPath(), "");
			PropertiesUtil pu = new PropertiesUtil();
			UnfreezeBondVO body=transorder.getBody();
			
			
			if(log.isDebugEnabled()){
				log.debug("检验通过，获取请求");
			}
			//业务数据必填等校验
			Token token = tokenSrv.getToken(transorder.getBody().getToken(), transorder.getApp().getAppId());
			if (token == null) {
				log.error(String.format("token[%s]验证失败,或已过期,请重新登录", transorder.getBody().getToken()));
				throw new TokenException("token验证失败,或已过期,请重新登录");
			}
			User user=userSer.queryUserByToken(body.getToken());
			
			FreezeBondReturnVO orderInfo=new FreezeBondReturnVO();
			if(user!=null){
				Bidder bidder=userSer.queryBidderByUserId(user.getId());
				if(bidder==null){
					if (log.isDebugEnabled()) {
						log.debug(String.format("用户【%s】未认证投标人或被禁用",user.getMobileNum()));
					}
					throw new MaAccountException(MaAccountException.ERR_ACCOUNT_EXCEPTION,String.format("用户【%s】未认证投标人或被禁用",user.getMobileNum()));
					
				}
				orderInfo=bidService.unfreezeMakeMatchBidderBond(body, bidder, requestURI);
				tokenSrv.postponeToken(token);
			}
			rm.put("order", orderInfo);
			tokenSrv.postponeToken(token);
		} catch (Exception e1) {
			log.error(String.format(messagebase+"失败"),e1);
			rm.mergeException(e1);
			rm.setErrmsg(messagebase+"失败,"+rm.getErrmsg());
		}
		return rm;
		
	}
	
	/**
	 * 查询未完成的投标附件
	 * @return
	 */
	@RequestMapping(value="/queryBidFile4Submit",method=RequestMethod.POST)
	@AccessRequered(methodName = "查询未完成的投标附件",isJson=true,codebase=247600,className="com.hummingbird.commonbiz.vo.BaseTransVO",genericClassName="com.hummingbird.paas.vo.QueryBidBodyVO",appLog=true)
	public @ResponseBody ResultModel queryBidFile4Submit(HttpServletRequest request,HttpServletResponse response) {
		ResultModel rm = super.getResultModel();
		BaseTransVO<QueryBidBodyVO> transorder = (BaseTransVO<QueryBidBodyVO>) super.getParameterObject();
		String messagebase = "查询未完成的投标附件"; 
	
		RequestEvent qe=null ; //业务请求事件,当实现一些关键的业务时,需要生成该请求
		
		try {
			//业务数据必填等校验
			Token token = tokenSrv.getToken(transorder.getBody().getToken(), transorder.getApp().getAppId());
			if (token == null) {
				log.error(String.format("token[%s]验证失败,或已过期,请重新登录", transorder.getBody().getToken()));
				throw new TokenException("token验证失败,或已过期,请重新登录");
			}
			Bidder bidder = validateWithBusiness(transorder.getBody().getToken(), transorder.getApp().getAppId(),token);
			//业务数据逻辑校验
			if(log.isDebugEnabled()){
				log.debug("检验通过，获取请求");
			}
			SubmitBidBodyVO  result = bidService.queryBidSubmit(transorder.getApp().getAppId(),transorder.getBody(),bidder.getId());
			rm.put("result",result);
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
	 * 提交投标接口
	 * @return
	 */
	@RequestMapping(value="/submitBid",method=RequestMethod.POST)
	@AccessRequered(methodName = "提交投标接口",isJson=true,codebase=247100,className="com.hummingbird.commonbiz.vo.BaseTransVO",genericClassName="com.hummingbird.paas.vo.SubmitBidBodyVO",appLog=true)
	public @ResponseBody ResultModel submitBid(HttpServletRequest request,HttpServletResponse response) {
		ResultModel rm = super.getResultModel();
		BaseTransVO<SubmitBidBodyVO> transorder = (BaseTransVO<SubmitBidBodyVO>) super.getParameterObject();
		String messagebase = "提交投标接口"; 
	
		RequestEvent qe=null ; //业务请求事件,当实现一些关键的业务时,需要生成该请求
		
		try {
			//业务数据必填等校验
			Token token = tokenSrv.getToken(transorder.getBody().getToken(), transorder.getApp().getAppId());
			if (token == null) {
				log.error(String.format("token[%s]验证失败,或已过期,请重新登录", transorder.getBody().getToken()));
				throw new TokenException("token验证失败,或已过期,请重新登录");
			}
			Bidder bidder = validateWithBusiness(transorder.getBody().getToken(), transorder.getApp().getAppId(),token);
			//业务数据逻辑校验
			if(log.isDebugEnabled()){
				log.debug("检验通过，获取请求");
			}
			bidService.submitBid(transorder.getApp().getAppId(),transorder.getBody(),bidder);
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
	 * 查询标的详情接口 
	 * @return
	 */
	@RequestMapping(value="queryObjectDetail",method=RequestMethod.POST)
	@AccessRequered(methodName = "查询标的详情接口 ",isJson=true,codebase=247200,className="com.hummingbird.commonbiz.vo.BaseTransVO",genericClassName="com.hummingbird.paas.vo.QueryBidBodyVO",appLog=true)
	public @ResponseBody ResultModel queryObjectDetail(HttpServletRequest request,HttpServletResponse response) {
		ResultModel rm = super.getResultModel();
		BaseTransVO<QueryBidBodyVO> transorder = (BaseTransVO<QueryBidBodyVO>) super.getParameterObject();
		String messagebase = "查询投标保证金信息接口"; 
	
		RequestEvent qe=null ; //业务请求事件,当实现一些关键的业务时,需要生成该请求
		
		try {
			//业务数据必填等校验
			Token token = tokenSrv.getToken(transorder.getBody().getToken(), transorder.getApp().getAppId());
			if (token == null) {
				log.error(String.format("token[%s]验证失败,或已过期,请重新登录", transorder.getBody().getToken()));
				throw new TokenException("token验证失败,或已过期,请重新登录");
			}
//			Bidder bidder = validateWithBusiness(transorder.getBody().getToken(), transorder.getApp().getAppId(),token);
			//业务数据逻辑校验
			if(log.isDebugEnabled()){
				log.debug("检验通过，获取请求");
			}
			QueryObjectDetailResultVO  result = bidService.queryObjectDetail(transorder.getApp().getAppId(),transorder.getBody(),null);
			rm.put("body",result);
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
	 * 写日志,需要由子类实现
	 * @param applog
	 */
	protected void writeAppLog(AbstractAppLog applog) {
		if(applog!=null){
			applogDao.insert(new AppLog(applog));
		}
	}
	
	
	/**
	 * 查询投标人基础信息接口
	 * @return
	 */
	@RequestMapping(value="/queryBidderCompanyInfo",method=RequestMethod.POST)
	@AccessRequered(methodName = "查询投标人基础信息接口",isJson=true,codebase=247500,className="com.hummingbird.commonbiz.vo.BaseTransVO",genericClassName="com.hummingbird.paas.vo.QueryBidBodyVO",appLog=true)
	public @ResponseBody ResultModel queryBidderCompanyInfo(HttpServletRequest request,HttpServletResponse response) {
		ResultModel rm = super.getResultModel();
		BaseTransVO<QueryBidBodyVO> transorder = (BaseTransVO<QueryBidBodyVO>) super.getParameterObject();
		String messagebase = "查询投标人基础信息接口"; 
	
		RequestEvent qe=null ; //业务请求事件,当实现一些关键的业务时,需要生成该请求
		
		try {
			//业务数据必填等校验
			Token token = tokenSrv.getToken(transorder.getBody().getToken(), transorder.getApp().getAppId());
			if (token == null) {
				log.error(String.format("token[%s]验证失败,或已过期,请重新登录", transorder.getBody().getToken()));
				throw new TokenException("token验证失败,或已过期,请重新登录");
			}
			Bidder bidder = validateWithBusiness(transorder.getBody().getToken(), transorder.getApp().getAppId(),token);
			//业务数据逻辑校验
			if(log.isDebugEnabled()){
				log.debug("检验通过，获取请求");
			}
			QueryBidderCompanyInfoBodyVOResult  result = bidService.queryBidderCompanyInfo(transorder.getApp().getAppId(),transorder.getBody(),bidder);
			rm.put("bidderInfo",result);
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
	 * 查询我的投标中项目列表接口
	 * @return  queryMyBidObject
	 */
	@RequestMapping(value="/queryMyBidObject",method=RequestMethod.POST)
	@AccessRequered(methodName = "查询我的投标中项目列表接口",isJson=true,codebase=242300,className="com.hummingbird.commonbiz.vo.BaseTransVO",genericClassName="com.hummingbird.paas.vo.GetMsgListBodyVO",appLog=true)
	public @ResponseBody ResultModel queryMyBidObject(HttpServletRequest request,HttpServletResponse response) {
		ResultModel rm = super.getResultModel();
		BaseTransVO<GetMsgListBodyVO> transorder = (BaseTransVO<GetMsgListBodyVO>) super.getParameterObject();
		String messagebase = "查询我的投标中项目列表接口"; 
		RequestEvent qe=null ; 
		List<QueryMyBidObjectListResultVO> liq = null;
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
			
			Pagingnation page=transorder.getBody().toPagingnation();
			
			liq = beeServiceSer.queryMyBidObjectList(token.getUserId(), page);
			
			rm.put("pageSize", page.getPageSize());
			rm.put("pageIndex", page.getCurrPage());
			rm.put("total", page.getTotalCount());
	        rm.put("list",liq);
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
	 * 查询我的投标中项目列表接口【页面是项目竣工日期？】
	 * @return  queryMyBuildingObject
	 */
	@RequestMapping(value="/queryMyBuildingObject",method=RequestMethod.POST)
	@AccessRequered(methodName = "查询施工中项目列表",isJson=true,codebase=242300,className="com.hummingbird.commonbiz.vo.BaseTransVO",genericClassName="com.hummingbird.paas.vo.GetMsgListBodyVO",appLog=true)
	public @ResponseBody ResultModel queryMyBuildingObject(HttpServletRequest request,HttpServletResponse response) {
		ResultModel rm = super.getResultModel();
		BaseTransVO<GetMsgListBodyVO> transorder = (BaseTransVO<GetMsgListBodyVO>) super.getParameterObject();
		String messagebase = "查询施工中项目列表"; 
		RequestEvent qe=null ; 
		List<QueryMyBuildingObjectListResultVO> liq = null;
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
			Pagingnation pagingnation = transorder.getBody().toPagingnation();
			liq = beeServiceSer.queryMyBuildingObjectPage(token.getUserId(),pagingnation);
			super.mergeListOutput(rm, pagingnation, liq);
			
//			Integer pageIndex =transorder.getBody().getPageIndex();
//			Integer pageSize =transorder.getBody().getPageSize();
//			if(pageIndex==null||pageSize==null||pageIndex<=0||pageSize<=0){
//				log.error(String.format(messagebase + "失败"));
//				rm.setErrmsg("参数错误");
//				return rm;
//			}
//			liq = beeServiceSer.queryMyBuildingObjectList(token.getUserId(), pageIndex, pageSize);
//			int total = obDao.getMyBuildingObjectProjectCount(token.getUserId());
//			rm.put("total", total);
//			rm.put("pageIndex", pageIndex);
//			rm.put("pageSize", pageSize);
//	        rm.put("list",liq);
			
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
	 * 查询我的已结束项目列表接口
	 * @return  queryMyEndedObject
	 */
	@RequestMapping(value="/queryMyEndedObject",method=RequestMethod.POST)
	@AccessRequered(methodName = "查询我的已结束项目列表",isJson=true,codebase=242300,className="com.hummingbird.commonbiz.vo.BaseTransVO",genericClassName="com.hummingbird.paas.vo.GetMsgListBodyVO",appLog=true)
	public @ResponseBody ResultModel queryMyEndedObject(HttpServletRequest request,HttpServletResponse response) {
		ResultModel rm = super.getResultModel();
		BaseTransVO<GetMsgListBodyVO> transorder = (BaseTransVO<GetMsgListBodyVO>) super.getParameterObject();
		String messagebase = "查询我的已结束项目列表"; 
		RequestEvent qe=null ; 
		List<QueryMyEndedObjectListResultVO> liq = null;
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
			if(pageIndex==null||pageSize==null||pageIndex<=0||pageSize<=0){
				log.error(String.format(messagebase + "失败"));
				rm.setErrmsg("参数错误");
				return rm;
			}
			liq = beeServiceSer.queryMyEndedObjectList(token.getUserId(), pageIndex, pageSize);
			int total = obDao.getMyEndedObjectProjectCount(token.getUserId());
			rm.put("total", total);
			rm.put("pageIndex", pageIndex);
			rm.put("pageSize", pageSize);
	        rm.put("list",liq);
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
	 * 查询我的未中标项目接口
	 * @return  queryMyEndedObject
	 */
	@RequestMapping(value="/queryMyLoseObject",method=RequestMethod.POST)
	@AccessRequered(methodName = "查询我的未中标项目",isJson=true,codebase=242300,className="com.hummingbird.commonbiz.vo.BaseTransVO",genericClassName="com.hummingbird.paas.vo.GetMsgListBodyVO",appLog=true)
	public @ResponseBody ResultModel queryMyLoseObject(HttpServletRequest request,HttpServletResponse response) {
		ResultModel rm = super.getResultModel();
		BaseTransVO<GetMsgListBodyVO> transorder = (BaseTransVO<GetMsgListBodyVO>) super.getParameterObject();
		String messagebase = "查询我的未中标项目"; 
		RequestEvent qe=null ; 
		List<QueryMyLoseObjectListResultVO> liq = null;
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
			liq = beeServiceSer.queryMyLoseObjectList(token.getUserId(), pageIndex, pageSize);
			int total = obDao.getMyLoseObjectProjectCount(token.getUserId());
			rm.put("total", total);
			rm.put("pageIndex", pageIndex);
			rm.put("pageSize", pageSize);
	        rm.put("list",liq);
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
	 * 查询招标人评价概况接口
	 * 
	 * @return
	 */
	@RequestMapping(value = "/queryMyObjectTenderSurvey", method = RequestMethod.POST)
	@AccessRequered(methodName = "查询招标人评价概况", isJson = true, codebase = 230100, className = "com.hummingbird.commonbiz.vo.BaseTransVO", genericClassName = "com.hummingbird.paas.vo.MyObjectTenderSurveyBodyVO", appLog = true)
	public @ResponseBody ResultModel queryMyObjectTenderSurvey(HttpServletRequest request,
			HttpServletResponse response) {
		ResultModel rm = super.getResultModel();
		BaseTransVO<MyObjectTenderSurveyBodyVO> transorder = (BaseTransVO<MyObjectTenderSurveyBodyVO>) super.getParameterObject();
		String messagebase = "查询招标人评价概况";

		RequestEvent qe = null; // 业务请求事件,当实现一些关键的业务时,需要生成该请求

		try {
			// 业务数据必填等校验
			Token token = tokenSrv.getToken(transorder.getBody().getToken(), transorder.getApp().getAppId());
			if (token == null) {
				log.error(String.format("token[%s]验证失败,或已过期,请重新登录", transorder.getBody().getToken()));
				throw new TokenException("token验证失败,或已过期,请重新登录");
			}
			BidEvaluateReturnVO ter = new BidEvaluateReturnVO();
			ProjectStatus ps  = psDao.selectByObjectIdAndUserId(transorder.getBody().getObjectId(),token.getUserId());
			BidObject bo = bidObjectDao.selectByPrimaryKey(transorder.getBody().getObjectId());
			
			if(ps!= null){
				int num = pebDao.countEvaluationNumByBiddeeId(ps.getBidderId());
				double score = pebDao.countEvaluationScoreByBiddeeId(ps.getBidderId());
				Biddee bid  = biddeeDao.selectByPrimaryKey(ps.getBidderId());
				ter.setBiddeeId(ps.getBiddeeId().toString());
				ter.setBiddeeCompanyName(bid.getCompanyName());
				ter.setObjectId(ps.getObjectId());
				ter.setCompanyEvaluateScore(ObjectUtils.toString(score));
				ter.setCompanyEvaluateNum(String.valueOf(num));
				ter.setStartTime(DateUtil.formatCommonDateorNull(ps.getStartTime()));//开工时间
				ter.setEndTime(DateUtil.formatCommonDateorNull(ps.getEndTime()));
				ter.setObjectName(bo.getObjectName());
				ter.setWinBidAmount(ObjectUtils.toString(bo.getWinBidAmount()));
				ter.setWinBidTime(DateUtil.formatCommonDateorNull(bo.getWinBidTime()));
				String  tagJson = CallInterfaceUtil.searchTag("project_manager", "t_gcgl_project", ps.getProjectId());
				
				
				List<TagInfo> tagList = new ArrayList<TagInfo>();
//				---------------------------------------------------------------------
				Gson ss = new Gson();
				try{
					JsonResult str = ss.fromJson(tagJson, JsonResult.class);

					if(str!= null&&"0".equals(str.getErrcode())){
						for(JsonResultMsg msg : str.getErrmsg()){
							TagInfo aa =new TagInfo();
							aa.setTagName(msg.getTagName());
							aa.setTagNum(msg.getTabUseNum());
							tagList.add(aa);
						}
						
					}
				}catch(JsonSyntaxException e){
					log.error(e.getMessage());
				}
				
				ter.setTag(tagList);
			
			}		
			
		
			rm.put("evaluateInfo", ter);
			tokenSrv.postponeToken(token);
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
	 * 投标方给招标方评价接口
	 * @return
	 */
	@RequestMapping(value="/evaluateBiddee",method=RequestMethod.POST)
	@AccessRequered(methodName = "投标方给招标方评价接口",isJson=true,codebase=247600,className="com.hummingbird.commonbiz.vo.BaseTransVO",genericClassName="com.hummingbird.paas.vo.EvaluateBiddeeBodyVO",appLog=true)
	public @ResponseBody ResultModel evaluateBiddee(HttpServletRequest request,HttpServletResponse response) {
		ResultModel rm = super.getResultModel();
		BaseTransVO<EvaluateBiddeeBodyVO> transorder = (BaseTransVO<EvaluateBiddeeBodyVO>) super.getParameterObject();
		String messagebase = "投标方给招标方评价接口"; 
	
		RequestEvent qe=null ; //业务请求事件,当实现一些关键的业务时,需要生成该请求
		
		try {
			//业务数据必填等校验
			Token token = tokenSrv.getToken(transorder.getBody().getToken(), transorder.getApp().getAppId());
			if (token == null) {
				log.error(String.format("token[%s]验证失败,或已过期,请重新登录", transorder.getBody().getToken()));
				throw new TokenException("token验证失败,或已过期,请重新登录");
			}
			Bidder bidder = validateWithBusiness(transorder.getBody().getToken(), transorder.getApp().getAppId(),token);
			//业务数据逻辑校验
			if(log.isDebugEnabled()){
				log.debug("检验通过，获取请求");
			}
			bidService.evaluateBiddee(transorder.getApp().getAppId(),transorder.getBody(),bidder);
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
	 * 查询招标中的招投标文件要求
	 * @return
	 */
	@RequestMapping(value="/queryObjectFileTypeRequirementInfo",method=RequestMethod.POST)
	@AccessRequered(methodName = "查询招标中的招投标文件要求",isJson=true,codebase=247700,className="com.hummingbird.commonbiz.vo.BaseTransVO",genericClassName="com.hummingbird.paas.vo.QueryObjectBodyVO",appLog=true)
	public @ResponseBody ResultModel queryBidFileTypeInfo(HttpServletRequest request,HttpServletResponse response) {
		ResultModel rm = super.getResultModel();
		BaseTransVO<QueryObjectBodyVO> transorder = (BaseTransVO<QueryObjectBodyVO>) super.getParameterObject();
		String messagebase = "查询招标中的招投标文件要求"; 
	
		RequestEvent qe=null ; //业务请求事件,当实现一些关键的业务时,需要生成该请求
		
		try {
			//业务数据必填等校验

			//业务数据逻辑校验
			if(log.isDebugEnabled()){
				log.debug("检验通过，获取请求");
			}
			AbstractBidFileTypeInfo queryBidFileTypeInfo = bidService.queryBidFileTypeInfo(transorder.getApp().getAppId(),transorder.getBody());
			rm.put("bidFileTypeInfo", queryBidFileTypeInfo);
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
