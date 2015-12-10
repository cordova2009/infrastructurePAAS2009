
package com.hummingbird.paas.controller;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang.ObjectUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.hummingbird.common.controller.BaseController;
import com.hummingbird.common.event.EventListenerContainer;
import com.hummingbird.common.event.RequestEvent;
import com.hummingbird.common.exception.DataInvalidException;
import com.hummingbird.common.exception.ValidateException;
import com.hummingbird.common.ext.AccessRequered;
import com.hummingbird.common.face.AbstractAppLog;
import com.hummingbird.common.face.Pagingnation;
import com.hummingbird.common.util.CollectionTools;
import com.hummingbird.common.util.DateUtil;
import com.hummingbird.common.util.JsonUtil;
import com.hummingbird.common.util.RequestUtil;
import com.hummingbird.common.util.ValidateUtil;
import com.hummingbird.common.vo.ResultModel;
import com.hummingbird.commonbiz.exception.TokenException;
import com.hummingbird.commonbiz.vo.AppVO;
import com.hummingbird.commonbiz.vo.BaseTransVO;
import com.hummingbird.paas.entity.AppLog;
import com.hummingbird.paas.entity.Appinfo;
import com.hummingbird.paas.entity.BidObject;
import com.hummingbird.paas.entity.BidRecord;
import com.hummingbird.paas.entity.Biddee;
import com.hummingbird.paas.entity.Bidder;
import com.hummingbird.paas.entity.MemberBiddee;
import com.hummingbird.paas.entity.ProjectPaymentDefine;
import com.hummingbird.paas.entity.ProjectPaymentDefineDetail;
import com.hummingbird.paas.entity.ProjectStatus;
import com.hummingbird.paas.entity.Token;
import com.hummingbird.paas.entity.User;
import com.hummingbird.paas.exception.PaasException;
import com.hummingbird.paas.mapper.AppLogMapper;
import com.hummingbird.paas.mapper.AppinfoMapper;
import com.hummingbird.paas.mapper.BidObjectMapper;
import com.hummingbird.paas.mapper.BidRecordMapper;
import com.hummingbird.paas.mapper.BiddeeMapper;
import com.hummingbird.paas.mapper.BidderMapper;
import com.hummingbird.paas.mapper.MemberBiddeeMapper;
import com.hummingbird.paas.mapper.ProjectEvaluationBidderMapper;
import com.hummingbird.paas.mapper.ProjectPaymentDefineDetailMapper;
import com.hummingbird.paas.mapper.ProjectPaymentDefineMapper;
import com.hummingbird.paas.mapper.ProjectStatusMapper;
import com.hummingbird.paas.services.MyBiddeeService;
import com.hummingbird.paas.services.TenderService;
import com.hummingbird.paas.services.TokenService;
import com.hummingbird.paas.services.UserService;
import com.hummingbird.paas.util.CallInterfaceUtil;
import com.hummingbird.paas.vo.BaseBidObjectVO;
import com.hummingbird.paas.vo.BaseTenderObjectVO;
import com.hummingbird.paas.vo.CompanyInfo;
import com.hummingbird.paas.vo.EvaluateBidderBodyVO;
import com.hummingbird.paas.vo.GetIndustryDetailBodyVO;
import com.hummingbird.paas.vo.GetIndustryListBodyVOResult;
import com.hummingbird.paas.vo.JsonResult;
import com.hummingbird.paas.vo.JsonResultMsg;
import com.hummingbird.paas.vo.MyObjectTenderSurveyBodyVO;
import com.hummingbird.paas.vo.MyTenderObjectListVO;
import com.hummingbird.paas.vo.QueryAnswerMethodInfoBodyVOResult;
import com.hummingbird.paas.vo.QueryBidEvaluationTypeInfoBodyVOResult;
import com.hummingbird.paas.vo.QueryBidFileTypeInfoResult;
import com.hummingbird.paas.vo.QueryBidIndexListResult;
import com.hummingbird.paas.vo.QueryBidIndexSurveyResult;
import com.hummingbird.paas.vo.QueryBidderListResultVO;
import com.hummingbird.paas.vo.QueryCertificateListBodyVO;
import com.hummingbird.paas.vo.QueryCertificateListResultVO;
import com.hummingbird.paas.vo.QueryCompanyInfoBodyVO;
import com.hummingbird.paas.vo.QueryDateRequirementInfoBodyVOResult;
import com.hummingbird.paas.vo.QueryIndexBidListResultVO;
import com.hummingbird.paas.vo.QueryIndexObjectListResult;
import com.hummingbird.paas.vo.QueryObjectBaseInfoBodyVOResult;
import com.hummingbird.paas.vo.QueryObjectBodyVO;
import com.hummingbird.paas.vo.QueryObjectBondInfoResult;
import com.hummingbird.paas.vo.QueryObjectCertificationInfoResult;
import com.hummingbird.paas.vo.QueryObjectConstructionInfoResult;
import com.hummingbird.paas.vo.QueryObjectIndexSurveyResult;
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
import com.hummingbird.paas.vo.TagInfo;
import com.hummingbird.paas.vo.TenderBidEvaluationBodyVO;
import com.hummingbird.paas.vo.TenderMyBuildingObjectVO;
import com.hummingbird.paas.vo.TenderMyEndedObjectVO;
import com.hummingbird.paas.vo.TenderMyObjectBidReturnVO;
import com.hummingbird.paas.vo.TenderMyObjectSurveyBodyVO;
import com.hummingbird.paas.vo.TenderObjectBodyVO;
import com.hummingbird.paas.vo.TenderObjectListReturnVO;
import com.hummingbird.paas.vo.TenderPaymentDetailInfo;
import com.hummingbird.paas.vo.TenderPaymentInfo;
import com.hummingbird.paas.vo.TenderSurveyBodyVO;
import com.hummingbird.paas.vo.TenderSurveyReturnVO;
import com.hummingbird.paas.vo.TendererEvaluateReturnVO;

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
	MemberBiddeeMapper membiddeeDao;
	@Autowired
	BidObjectMapper objectDao;
	@Autowired
	protected MyBiddeeService myBiddeeService;
	@Autowired
	UserService userSer;
	@Autowired
	protected BidObjectMapper bidObjectDao;
	@Autowired
	protected BidRecordMapper bidRecordDao;
	@Autowired
	protected ProjectPaymentDefineMapper projectPaymentDefineDao;
	@Autowired
	protected ProjectEvaluationBidderMapper pebDao;
	@Autowired
	protected ProjectPaymentDefineDetailMapper projectPaymentDefineDetailDao;
	
	@Autowired
	BidderMapper  bidderDao;
	@Autowired
	ProjectStatusMapper  psDao;
	@Autowired
	AppinfoMapper  appDao;
	
	
	@Autowired(required = true)
	protected AppLogMapper applogDao;

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
			TenderSurveyReturnVO queryMyObjectTenderSurvey = tenderService
					.queryMyObjectTenderSurvey(transorder.getApp().getAppId(), transorder.getBody(),biddee);
			rm.put("survey", queryMyObjectTenderSurvey);
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
			MemberBiddee membiddee = membiddeeDao.selectByBiddeeId(biddee.getId());
			if(membiddee==null||membiddee.getEndTime().after(new Date()))
			{
				List<BidObject> selectbyBiddeeId = objectDao.selectbyBiddeeId(biddee.getId(), null);
				
				if(selectbyBiddeeId==null&&selectbyBiddeeId.size()>1){
					log.error(String.format("招标人%s还不是会员,不能发布多个招标", biddee.getId()));
					throw new PaasException(PaasException.ERR_BIDDEE_INFO_EXCEPTION,"您还不是会员,最多只能发布一个招标信息");
				}
			}
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
			AppVO app = transorder.getApp();
			Appinfo appinfo = appDao.selectByPrimaryKey(app.getAppId());
			ValidateUtil.assertNull(appinfo, "app");
			app.setAppId(appinfo.getAppkey());
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
	@RequestMapping(value="/queryBidderList",method=RequestMethod.POST)
	@AccessRequered(methodName = "查询投标方列表接口",isJson=true,codebase=242300,className="com.hummingbird.commonbiz.vo.BaseTransVO",genericClassName="com.hummingbird.paas.vo.QueryCertificateListBodyVO",appLog=true)
	public @ResponseBody ResultModel queryBidderList(HttpServletRequest request,HttpServletResponse response) {
		ResultModel rm = super.getResultModel();
		BaseTransVO<QueryCertificateListBodyVO> transorder = (BaseTransVO<QueryCertificateListBodyVO>) super.getParameterObject();
		String messagebase = "查询投标方列表接口"; 
		RequestEvent qe=null ; 
		List<QueryBidderListResultVO> liq = null;
		try {
			if(log.isDebugEnabled()){
				log.debug("检验通过，获取请求");
			}
			Pagingnation pagingnation = transorder.getBody().toPagingnation();
			liq = tenderService.queryBidderList(transorder.getBody(),pagingnation);
			mergeListOutput(rm, pagingnation, liq);
//	        rm.put("list",liq);
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
	
//	<--------------------------------------------------------------------------->
	
	/**
	 * 我的招标评标概况接口
	 * @author YJY
	 * @since 2015年11月12日16:07:24
	 * @return
	 */
//	@RequestMapping(value="/queryMyObjectTenderSurvey",method=RequestMethod.POST)
//	@AccessRequered(methodName = "我的招标评标概况")
//	// 框架的日志处理
//	public @ResponseBody ResultModel queryMyObjectTenderSurvey(HttpServletRequest request,
//			HttpServletResponse response) {
//		String messagebase = "我的招标评标概况";
//		int basecode = 0;
//		BaseTransVO<TenderSurveyBodyVO> transorder = null;
//		ResultModel rm = new ResultModel();
//		try {
//			String jsonstr = RequestUtil.getRequestPostData(request);
//			request.setAttribute("rawjson", jsonstr);
//			transorder = RequestUtil.convertJson2Obj(jsonstr, BaseTransVO.class,TenderSurveyBodyVO.class);
//		} catch (Exception e) {
//			log.error(String.format("获取%s参数出错",messagebase),e);
//			rm.mergeException(ValidateException.ERROR_PARAM_FORMAT_ERROR.cloneAndAppend(null, messagebase+"参数"));
//			return rm;
//		}
////		// 预设的一些信息
//		
////		rm.setBaseErrorCode(basecode);
//		rm.setErrmsg(messagebase + "成功");
//		RequestEvent qe=null ;
//		
//		
//		AppLog rnr = new AppLog();
//		rnr.setAppid(transorder.getApp().getAppId());
//		rnr.setRequest(ObjectUtils.toString(request.getAttribute("rawjson")));
//		rnr.setInserttime(new Date());
//		rnr.setMethod("/tender/queryMyObjectTenderSurvey");
//		
//		try {
//				TenderSurveyReturnVO tsr = bidRecordDao.selectByObjectId(transorder.getBody().getObjectId());
//			
//			
//				if(tsr!= null){
//					rm.put("survey", tsr);
//					
//				}
//			
//			
//		}catch (Exception e1) {
//			log.error(String.format(messagebase + "失败"), e1);
//			rm.mergeException(e1);
//			if(qe!=null)
//				qe.setSuccessed(false);
//		} finally {
//			try {
//				rnr.setRespone(StringUtils.substring(JsonUtil.convert2Json(rm),0,2000));
//				applogDao.insert(rnr);
//			} catch (DataInvalidException e) {
//				log.error(String.format("日志处理出错"),e);
//			}
//			
//			if(qe!=null)
//				EventListenerContainer.getInstance().fireEvent(qe);
//		}
//		return rm;
//		
//	}
	
	
	/**
	 * 定标接口
	 * @author YJY
	 * @since 2015年11月12日12:07:10
	 * @return
	 */
	@RequestMapping(value="/bidEvaluation",method=RequestMethod.POST)
	@Transactional(propagation=Propagation.REQUIRED,rollbackFor=Exception.class,value="txManager")
	public @ResponseBody ResultModel bidEvaluation(HttpServletRequest request,HttpServletResponse response) {
//		int basecode = 2341210;//待定
		String messagebase = "定标";
		BaseTransVO<TenderBidEvaluationBodyVO> transorder = null;
		ResultModel rm = new ResultModel();
//		rm.setBaseErrorCode(basecode);
		try {
			String jsonstr  = RequestUtil.getRequestPostData(request);
			request.setAttribute("rawjson", jsonstr);
			transorder = RequestUtil.convertJson2Obj(jsonstr,BaseTransVO.class, TenderBidEvaluationBodyVO.class);
		} catch (Exception e) {
			log.error(String.format("获取参数出错"),e);
			rm.mergeException(ValidateException.ERROR_PARAM_FORMAT_ERROR.cloneAndAppend(null, "参数异常"));
			return rm;
		}
		rm.setErrmsg(messagebase + "成功");
		RequestEvent qe=null ;		
		AppLog rnr = new AppLog();
		rnr.setAppid(transorder.getApp().getAppId());
		rnr.setRequest(ObjectUtils.toString(request.getAttribute("rawjson")));
		rnr.setInserttime(new Date());
		rnr.setMethod("/tender/bidEvaluation");
		
		
		try {
		String token =  transorder.getBody().getToken();
		String objectId =  transorder.getBody().getObjectId();
		Integer bidder_id = transorder.getBody().getWinBidId();

		int i= 0;
		if(StringUtils.isNotBlank(token)){
			BidObject  bid =bidObjectDao.selectByPrimaryKey(objectId);
			
			BidRecord bidr = bidRecordDao.selectByObjectIdAndBidderId(objectId, bidder_id);
			ProjectPaymentDefine ppd = new ProjectPaymentDefine();
			ProjectPaymentDefineDetail ppf = new ProjectPaymentDefineDetail();
			TenderPaymentInfo tp = transorder.getBody().getPaymentInfo();
			List<TenderPaymentDetailInfo> tpds= tp.getPayList();
			if(bid==null){
				rm.setErrmsg("未找到相应招标记录!");
				return rm;
				}else{
					//1.保存到招标表
					bid.setObjectStatus("SEL");;//修改状态为定标
					bid.setWinBidderId(transorder.getBody().getWinBidId());
					bid.setWinBidAmount(bidr.getBidAmount());
					i = bidObjectDao.updateByPrimaryKeySelective(bid);
					//2.保存到工程付款表
					UUID uid = UUID.randomUUID();
					Integer pid = uid.hashCode();
					ppd.setId(pid);
					ppd.setObjectId(objectId);
					ppd.setPayPeriod(tp.getPayPeriod());
					ppd.setPayType(tp.getPayType());
					projectPaymentDefineDao.insert(ppd); 
					for(TenderPaymentDetailInfo mm : tpds){
						ppf.setPaySum(mm.getPaySum());
						//ppf.setPayTime(mm.getPayDate());
						ppf.setPeriod(mm.getPeriod());
						ppf.setProjectPaymentDefineId(pid);
						projectPaymentDefineDetailDao.insert(ppf);
					}
					
					
				}
			}
	
		
		if(i<= 0){
			rm.setErrmsg("数据未修改！");
		}else{
			rm.setErrmsg(messagebase + "成功");
		}
//		activityService.JoinActivity(activityId,unionId,parentName,mobileNum,babyName,babySex,babyBirthday,city,district);
		} catch (Exception e1) {
			log.error(String.format(messagebase+"失败"),e1);
			rm.mergeException(e1);
			rm.setErrmsg(e1.getMessage());
		}
		return rm;
	}  
	
	/**
	 * 我的招标项目投标列表接口
	 * @author YJY
	 * @since 2015年11月12日16:44:56
	 * @return
	 */
	@RequestMapping(value="/queryMyObjectBidList",method=RequestMethod.POST)
	@AccessRequered(methodName = "我的招标项目投标列表")
	public @ResponseBody ResultModel queryMyObjectBidList(HttpServletRequest request,HttpServletResponse response) {
		int basecode = 2341200;//待定
		String messagebase = "查询我的招标项目投标列表";
		BaseTransVO<TenderSurveyBodyVO> transorder = null;
		ResultModel rm = new ResultModel();
//		rm.setBaseErrorCode(basecode);
		try {
			String jsonstr  = RequestUtil.getRequestPostData(request);
			request.setAttribute("rawjson", jsonstr);
			transorder = RequestUtil.convertJson2Obj(jsonstr,BaseTransVO.class, TenderSurveyBodyVO.class);
		} catch (Exception e) {
			log.error(String.format("获取参数出错"),e);
			rm.mergeException(ValidateException.ERROR_PARAM_FORMAT_ERROR.cloneAndAppend(null, "参数异常"));
			return rm;
		}
		rm.setErrmsg(messagebase + "成功");
		RequestEvent qe=null ;		
		AppLog rnr = new AppLog();
		rnr.setAppid(transorder.getApp().getAppId());
		rnr.setRequest(ObjectUtils.toString(request.getAttribute("rawjson")));
		rnr.setInserttime(new Date());
		rnr.setMethod("/tender/queryMyObjectBidList");
		
		List<TenderMyObjectBidReturnVO> list=new ArrayList<TenderMyObjectBidReturnVO>();
		try {
			// 业务数据必填等校验
			Token token = tokenSrv.getToken(transorder.getBody().getToken(), transorder.getApp().getAppId());
			if (token == null) {
				log.error(String.format("token[%s]验证失败,或已过期,请重新登录", transorder.getBody().getToken()));
				throw new TokenException("token验证失败,或已过期,请重新登录");
			}
			com.hummingbird.common.face.Pagingnation page = transorder.getBody().toPagingnation();
			
			list = tenderService.selectByObjectIdInValid(token.getUserId(),transorder.getBody().getObjectId(),page);
			List<Map> nos = CollectionTools.convertCollection(list, Map.class, new CollectionTools.CollectionElementConvertor<TenderMyObjectBidReturnVO, Map>() {

				@Override
				public Map convert(TenderMyObjectBidReturnVO ori) {
					
					try {
						Map row= BeanUtils.describe(ori);
//						row.put("bidTime", DateUtil.formatCommonDateorNull(ori.getBidTime()));
//						row.put("projectExpectStartDate", DateUtil.formatCommonDateorNull(ori.getProjectExpectStartDate()));
						
						row.remove("class");
						return row;
						
					} catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
						log.error(String.format("转换为map对象出错"),e);
						return null;
					}
				}
			});
			mergeListOutput(rm, page, nos);
			tokenSrv.postponeToken(token);
		}catch (Exception e1) {
			log.error(String.format(messagebase + "失败"), e1);
			rm.mergeException(e1);
			if(qe!=null)
				qe.setSuccessed(false);
		} finally {
			
			try {
				rnr.setRespone(StringUtils.substring(JsonUtil.convert2Json(rm),0,2000));
				applogDao.insert(rnr);
			} catch (DataInvalidException e) {
				log.error(String.format("日志处理出错"),e);
			}
			
			if(qe!=null)
				EventListenerContainer.getInstance().fireEvent(qe);
		}
		return rm;
	}  
	
	/**
	 * 查询投标人评价概况接口
	 * @author YJY
	 * @since 2015年11月13日16:25:54
	 * @return
	 */
	@RequestMapping(value="/queryTendererEvaluate",method=RequestMethod.POST)
	@AccessRequered(methodName = "查询投标人评价概况")
	// 框架的日志处理
	public @ResponseBody ResultModel queryTendererEvaluate(HttpServletRequest request,
			HttpServletResponse response) {
		String messagebase = "查询投标人评价概况";
		int basecode = 0;
		BaseTransVO<TenderSurveyBodyVO> transorder = null;
		ResultModel rm = new ResultModel();
		try {
			String jsonstr = RequestUtil.getRequestPostData(request);
			request.setAttribute("rawjson", jsonstr);
			transorder = RequestUtil.convertJson2Obj(jsonstr, BaseTransVO.class,TenderSurveyBodyVO.class);
		} catch (Exception e) {
			log.error(String.format("获取%s参数出错",messagebase),e);
			rm.mergeException(ValidateException.ERROR_PARAM_FORMAT_ERROR.cloneAndAppend(null, messagebase+"参数"));
			return rm;
		}
//		// 预设的一些信息
		
//		rm.setBaseErrorCode(basecode);
		rm.setErrmsg(messagebase + "成功");
		RequestEvent qe=null ;
		
		
		AppLog rnr = new AppLog();
		rnr.setAppid(transorder.getApp().getAppId());
		rnr.setRequest(ObjectUtils.toString(request.getAttribute("rawjson")));
		rnr.setInserttime(new Date());
		rnr.setMethod("/tender/queryTendererEvaluate");
		
		try {
			// 业务数据必填等校验
				Token token = tokenSrv.getToken(transorder.getBody().getToken(), transorder.getApp().getAppId());
				if (token == null) {
					log.error(String.format("token[%s]验证失败,或已过期,请重新登录", transorder.getBody().getToken()));
					throw new TokenException("token验证失败,或已过期,请重新登录");
				}
				TendererEvaluateReturnVO ter = new TendererEvaluateReturnVO();
				ProjectStatus ps  = psDao.selectByObjectIdAndUserId(transorder.getBody().getObjectId(),token.getUserId());
				BidObject bo = bidObjectDao.selectByPrimaryKey(transorder.getBody().getObjectId());
				
				if(ps!= null){
					int num = pebDao.countEvaluationNumByBidderId(ps.getBidderId());
					double score = pebDao.countEvaluationScoreByBidderId(ps.getBidderId());
					Bidder bid  = bidderDao.selectByPrimaryKey(ps.getBidderId());
					ter.setBidderId(ps.getBidderId().toString());
					ter.setBidderCompanyName(bid.getCompanyName());
					ter.setObjectId(ps.getObjectId());
					ter.setCompanyEvaluateScore(ObjectUtils.toString(score));
					ter.setCompanyEvaluateNum(String.valueOf(num));
					ter.setStartTime(DateUtil.formatCommonDateorNull(ps.getStartTime()));//开工时间
					ter.setEndTime(DateUtil.formatCommonDateorNull(ps.getEndTime()));
					ter.setObjectName(bo.getObjectName());
					ter.setWinBidAmount(ObjectUtils.toString(bo.getWinBidAmount()));
					ter.setWinBidTime(DateUtil.formatCommonDateorNull(bo.getWinBidTime()));
					//加载用户的id
					Integer userId = bid.getUserId();
					User user = userSer.loadUser(userId);
					ter.setLogo(user.getHeadImage());
//					{"tagGroupName":"biddee_manager","tagObjectCode":"t_qyzz_biddee","businessId":"1"}  
					
					String  tagJson = CallInterfaceUtil.searchTag("project_manager", "t_gcgl_project", ps.getProjectId());
					
					
					List<TagInfo> tagList = new ArrayList<TagInfo>();
//					---------------------------------------------------------------------
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
			
		}catch (Exception e1) {
			log.error(String.format(messagebase + "失败"), e1);
			rm.mergeException(e1);
			if(qe!=null)
				qe.setSuccessed(false);
		} finally {
			try {
				rnr.setRespone(StringUtils.substring(JsonUtil.convert2Json(rm),0,2000));
				applogDao.insert(rnr);
			} catch (DataInvalidException e) {
				log.error(String.format("日志处理出错"),e);
			}
			
			if(qe!=null)
				EventListenerContainer.getInstance().fireEvent(qe);
		}
		return rm;
		
	}
	

	/**
	 * 查询我的招标概况接口
	 * @author YJY
	 * @since 2015年11月12日16:07:24
	 * @return
	 */
	@RequestMapping(value="/queryMyObjectSurvey",method=RequestMethod.POST)
	@AccessRequered(methodName = "查询我的招标概况")
	public @ResponseBody ResultModel queryMyObjectSurvey(HttpServletRequest request,
			HttpServletResponse response) {
		String messagebase = "查询我的招标概况";
		int basecode = 0;
		BaseTransVO<TenderMyObjectSurveyBodyVO> transorder = null;
		ResultModel rm = new ResultModel();
		try {
			String jsonstr = RequestUtil.getRequestPostData(request);
			request.setAttribute("rawjson", jsonstr);
			transorder = RequestUtil.convertJson2Obj(jsonstr, BaseTransVO.class,TenderMyObjectSurveyBodyVO.class);
		} catch (Exception e) {
			log.error(String.format("获取%s参数出错",messagebase),e);
			rm.mergeException(ValidateException.ERROR_PARAM_FORMAT_ERROR.cloneAndAppend(null, messagebase+"参数"));
			return rm;
		}
//		// 预设的一些信息
		
//		rm.setBaseErrorCode(basecode);
		rm.setErrmsg(messagebase + "成功");
		RequestEvent qe=null ;
		
		
		AppLog rnr = new AppLog();
		rnr.setAppid(transorder.getApp().getAppId());
		rnr.setRequest(ObjectUtils.toString(request.getAttribute("rawjson")));
		rnr.setInserttime(new Date());
		rnr.setMethod("/tender/queryMyObjectSurvey");
		
		try {
			// 业务数据必填等校验
				Token token = tokenSrv.getToken(transorder.getBody().getToken(), transorder.getApp().getAppId());
				if (token == null) {
					log.error(String.format("token[%s]验证失败,或已过期,请重新登录", transorder.getBody().getToken()));
					throw new TokenException("token验证失败,或已过期,请重新登录");
				}
				int biddingNum = bidObjectDao.countTenderBidingNum(token.getUserId());
				int doingNum = bidObjectDao.countTenderDoingNum(token.getUserId());
				int doneNum = bidObjectDao.countTenderDoneNum(token.getUserId());
				
				rm.put("bidingNum", biddingNum);
				rm.put("doingNum", doingNum);
				rm.put("doneNum", doneNum);
				tokenSrv.postponeToken(token);
		}catch (Exception e1) {
			log.error(String.format(messagebase + "失败"), e1);
			rm.mergeException(e1);
			if(qe!=null)
				qe.setSuccessed(false);
		} finally {
			try {
				rnr.setRespone(StringUtils.substring(JsonUtil.convert2Json(rm),0,2000));
				applogDao.insert(rnr);
			} catch (DataInvalidException e) {
				log.error(String.format("日志处理出错"),e);
			}
			
			if(qe!=null)
				EventListenerContainer.getInstance().fireEvent(qe);
		}
		return rm;
		
	}
	/**
	 * 查询我的投标概况接口
	 * @author YJY
	 * @since 2015年11月16日16:24:01
	 * @return
	 */
	@RequestMapping(value="/queryMyBidSurvey",method=RequestMethod.POST)
	@AccessRequered(methodName = "查询我的投标概况")
	// 框架的日志处理
	public @ResponseBody ResultModel queryMyBidSurvey(HttpServletRequest request,
			HttpServletResponse response) {
		String messagebase = "查询我的投标概况";
		int basecode = 0;
		BaseTransVO<TenderMyObjectSurveyBodyVO> transorder = null;
		ResultModel rm = new ResultModel();
		try {
			String jsonstr = RequestUtil.getRequestPostData(request);
			request.setAttribute("rawjson", jsonstr);
			transorder = RequestUtil.convertJson2Obj(jsonstr, BaseTransVO.class,TenderMyObjectSurveyBodyVO.class);
		} catch (Exception e) {
			log.error(String.format("获取%s参数出错",messagebase),e);
			rm.mergeException(ValidateException.ERROR_PARAM_FORMAT_ERROR.cloneAndAppend(null, messagebase+"参数"));
			return rm;
		}
//		// 预设的一些信息
		
//		rm.setBaseErrorCode(basecode);
		rm.setErrmsg(messagebase + "成功");
		RequestEvent qe=null ;
		
		
		AppLog rnr = new AppLog();
		rnr.setAppid(transorder.getApp().getAppId());
		rnr.setRequest(ObjectUtils.toString(request.getAttribute("rawjson")));
		rnr.setInserttime(new Date());
		rnr.setMethod("/tender/queryMyBidSurvey");
		
		try {
			// 业务数据必填等校验
				Token token = tokenSrv.getToken(transorder.getBody().getToken(), transorder.getApp().getAppId());
				if (token == null) {
					log.error(String.format("token[%s]验证失败,或已过期,请重新登录", transorder.getBody().getToken()));
					throw new TokenException("token验证失败,或已过期,请重新登录");
				}
				int biddingNum = bidObjectDao.countBidingNum(token.getUserId());
				int doingNum = bidObjectDao.countDoingNum(token.getUserId());
				int doneNum = bidObjectDao.countDoneNum(token.getUserId());
				
				rm.put("bidingNum", biddingNum);
				rm.put("doingNum", doingNum);
				rm.put("doneNum", doneNum);
				tokenSrv.postponeToken(token);
		}catch (Exception e1) {
			log.error(String.format(messagebase + "失败"), e1);
			rm.mergeException(e1);
			if(qe!=null)
				qe.setSuccessed(false);
		} finally {
			try {
				rnr.setRespone(StringUtils.substring(JsonUtil.convert2Json(rm),0,2000));
				applogDao.insert(rnr);
			} catch (DataInvalidException e) {
				log.error(String.format("日志处理出错"),e);
			}
			
			if(qe!=null)
				EventListenerContainer.getInstance().fireEvent(qe);
		}
		return rm;
		
	}
	
	/**
	 * 查询我的招标项目列表接口
	 * @author YJY
	 * @since 2015年11月13日20:59:02
	 * @return
	 */
	@RequestMapping(value="/queryMyTenderObject",method=RequestMethod.POST)
	@AccessRequered(methodName = "查询我的招标项目列表")
	// 框架的日志处理
	public @ResponseBody ResultModel queryMyTenderObject(HttpServletRequest request,
			HttpServletResponse response) {
		String messagebase = "查询我的招标项目列表";
		int basecode = 0;
		BaseTransVO<TenderMyObjectSurveyBodyVO> transorder = null;
		ResultModel rm = new ResultModel();
		try {
			String jsonstr = RequestUtil.getRequestPostData(request);
			request.setAttribute("rawjson", jsonstr);
			transorder = RequestUtil.convertJson2Obj(jsonstr, BaseTransVO.class,TenderMyObjectSurveyBodyVO.class);
		} catch (Exception e) {
			log.error(String.format("获取%s参数出错",messagebase),e);
			rm.mergeException(ValidateException.ERROR_PARAM_FORMAT_ERROR.cloneAndAppend(null, messagebase+"参数"));
			return rm;
		}
//		// 预设的一些信息
		
//		rm.setBaseErrorCode(basecode);
		rm.setErrmsg(messagebase + "成功");
		RequestEvent qe=null ;
		
		
		AppLog rnr = new AppLog();
		rnr.setAppid(transorder.getApp().getAppId());
		rnr.setRequest(ObjectUtils.toString(request.getAttribute("rawjson")));
		rnr.setInserttime(new Date());
		rnr.setMethod("/tender/queryMyTenderObject");
		
		try {
			// 业务数据必填等校验
				Token token = tokenSrv.getToken(transorder.getBody().getToken(), transorder.getApp().getAppId());
				if (token == null) {
					log.error(String.format("token[%s]验证失败,或已过期,请重新登录", transorder.getBody().getToken()));
					throw new TokenException("token验证失败,或已过期,请重新登录");
				}
				com.hummingbird.common.face.Pagingnation page = transorder.getBody().toPagingnation();
				
				List<MyTenderObjectListVO> list=new ArrayList<MyTenderObjectListVO>();
//				list = announcementService.selectAnnouncementInValid(user_id, page);
					list = tenderService.getTenderObjectList(token.getUserId(), page);
				List<Map> nos = CollectionTools.convertCollection(list, Map.class, new CollectionTools.CollectionElementConvertor<MyTenderObjectListVO, Map>() {

					@Override
					public Map convert(MyTenderObjectListVO ori) {
						
						try {
							Map row= BeanUtils.describe(ori);
							
							row.remove("class");
							return row;
							
						} catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
							log.error(String.format("转换为map对象出错"),e);
							return null;
						}
					}
				});
				mergeListOutput(rm, page, nos);
				tokenSrv.postponeToken(token);
		}catch (Exception e1) {
			log.error(String.format(messagebase + "失败"), e1);
			rm.mergeException(e1);
			if(qe!=null)
				qe.setSuccessed(false);
		} finally {
			try {
				rnr.setRespone(StringUtils.substring(JsonUtil.convert2Json(rm),0,2000));
				applogDao.insert(rnr);
			} catch (DataInvalidException e) {
				log.error(String.format("日志处理出错"),e);
			}
			
			if(qe!=null)
				EventListenerContainer.getInstance().fireEvent(qe);
		}
		return rm;
		
	}
	
	/**
	 * 查询我的施工项目列表接口
	 * @author YJY
	 * @since 2015年11月13日20:59:02
	 * @return
	 */
	@RequestMapping(value="/queryMyBuildingObject",method=RequestMethod.POST)
	@AccessRequered(methodName = "查询我的施工项目列表接口")
	// 框架的日志处理
	public @ResponseBody ResultModel queryMyBuildingObject(HttpServletRequest request,
			HttpServletResponse response) {
		String messagebase = "查询我的施工项目列表";
		int basecode = 0;
		BaseTransVO<TenderMyObjectSurveyBodyVO> transorder = null;
		ResultModel rm = new ResultModel();
		try {
			String jsonstr = RequestUtil.getRequestPostData(request);
			request.setAttribute("rawjson", jsonstr);
			transorder = RequestUtil.convertJson2Obj(jsonstr, BaseTransVO.class,TenderMyObjectSurveyBodyVO.class);
		} catch (Exception e) {
			log.error(String.format("获取%s参数出错",messagebase),e);
			rm.mergeException(ValidateException.ERROR_PARAM_FORMAT_ERROR.cloneAndAppend(null, messagebase+"参数"));
			return rm;
		}
//		// 预设的一些信息
		
//		rm.setBaseErrorCode(basecode);
		rm.setErrmsg(messagebase + "成功");
		RequestEvent qe=null ;
		
		
		AppLog rnr = new AppLog();
		rnr.setAppid(transorder.getApp().getAppId());
		rnr.setRequest(ObjectUtils.toString(request.getAttribute("rawjson")));
		rnr.setInserttime(new Date());
		rnr.setMethod("/tender/queryMyBuildingObject");
		
		try {
			// 业务数据必填等校验
				Token token = tokenSrv.getToken(transorder.getBody().getToken(), transorder.getApp().getAppId());
				if (token == null) {
					log.error(String.format("token[%s]验证失败,或已过期,请重新登录", transorder.getBody().getToken()));
					throw new TokenException("token验证失败,或已过期,请重新登录");
				}
				com.hummingbird.common.face.Pagingnation page = transorder.getBody().toPagingnation();
				
				List<TenderMyBuildingObjectVO> list=new ArrayList<TenderMyBuildingObjectVO>();
//				list = announcementService.selectAnnouncementInValid(user_id, page);
					list = tenderService.getTenderBuildingObjectList(token.getUserId(), page);
				List<Map> nos = CollectionTools.convertCollection(list, Map.class, new CollectionTools.CollectionElementConvertor<TenderMyBuildingObjectVO, Map>() {

					@Override
					public Map convert(TenderMyBuildingObjectVO ori) {
						
						try {
							Map row= BeanUtils.describe(ori);
//							row.put("projectExpectStartDate", DateUtil.formatCommonDateorNull(ori.getProjectExpectStartDate()));
//							row.put("biddingEndTime", DateUtil.formatCommonDateorNull(ori.getBiddingEndTime()));
							row.remove("class");
							return row;
							
						} catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
							log.error(String.format("转换为map对象出错"),e);
							return null;
						}
					}
				});
				mergeListOutput(rm, page, nos);
				tokenSrv.postponeToken(token);
		}catch (Exception e1) {
			log.error(String.format(messagebase + "失败"), e1);
			rm.mergeException(e1);
			if(qe!=null)
				qe.setSuccessed(false);
		} finally {
			try {
				rnr.setRespone(StringUtils.substring(JsonUtil.convert2Json(rm),0,2000));
				applogDao.insert(rnr);
			} catch (DataInvalidException e) {
				log.error(String.format("日志处理出错"),e);
			}
			
			if(qe!=null)
				EventListenerContainer.getInstance().fireEvent(qe);
		}
		return rm;
		
	}
	
	/**
	 * 查询我的已结束招标项目列表接口
	 * @author YJY
	 * @since 2015年11月13日20:59:02
	 * @return
	 */
	@RequestMapping(value="/queryMyEndedObject",method=RequestMethod.POST)
	@AccessRequered(methodName = "查询我的已结束项目列表")
	// 框架的日志处理
	public @ResponseBody ResultModel queryMyEndedObject(HttpServletRequest request,
			HttpServletResponse response) {
		String messagebase = "查询我的已结束项目列表";
		int basecode = 0;
		BaseTransVO<TenderMyObjectSurveyBodyVO> transorder = null;
		ResultModel rm = new ResultModel();
		try {
			String jsonstr = RequestUtil.getRequestPostData(request);
			request.setAttribute("rawjson", jsonstr);
			transorder = RequestUtil.convertJson2Obj(jsonstr, BaseTransVO.class,TenderMyObjectSurveyBodyVO.class);
		} catch (Exception e) {
			log.error(String.format("获取%s参数出错",messagebase),e);
			rm.mergeException(ValidateException.ERROR_PARAM_FORMAT_ERROR.cloneAndAppend(null, messagebase+"参数"));
			return rm;
		}
//		// 预设的一些信息
		
//		rm.setBaseErrorCode(basecode);
		rm.setErrmsg(messagebase + "成功");
		RequestEvent qe=null ;
		
		
		AppLog rnr = new AppLog();
		rnr.setAppid(transorder.getApp().getAppId());
		rnr.setRequest(ObjectUtils.toString(request.getAttribute("rawjson")));
		rnr.setInserttime(new Date());
		rnr.setMethod("/tender/queryMyEndedObject");
		
		try {
			// 业务数据必填等校验
				Token token = tokenSrv.getToken(transorder.getBody().getToken(), transorder.getApp().getAppId());
				if (token == null) {
					log.error(String.format("token[%s]验证失败,或已过期,请重新登录", transorder.getBody().getToken()));
					throw new TokenException("token验证失败,或已过期,请重新登录");
				}
				com.hummingbird.common.face.Pagingnation page = transorder.getBody().toPagingnation();
				
				List<TenderMyEndedObjectVO> list=new ArrayList<TenderMyEndedObjectVO>();
//				list = announcementService.selectAnnouncementInValid(user_id, page);
					list = tenderService.getTenderEndedObjectList(token.getUserId(), page);
				List<Map> nos = CollectionTools.convertCollection(list, Map.class, new CollectionTools.CollectionElementConvertor<TenderMyEndedObjectVO, Map>() {

					@Override
					public Map convert(TenderMyEndedObjectVO ori) {
						
						try {
							Map row= BeanUtils.describe(ori);
							row.remove("class");
							return row;
							
						} catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
							log.error(String.format("转换为map对象出错"),e);
							return null;
						}
					}
				});
				mergeListOutput(rm, page, nos);
				tokenSrv.postponeToken(token);
		}catch (Exception e1) {
			log.error(String.format(messagebase + "失败"), e1);
			rm.mergeException(e1);
			if(qe!=null)
				qe.setSuccessed(false);
		} finally {
			try {
				rnr.setRespone(StringUtils.substring(JsonUtil.convert2Json(rm),0,2000));
				applogDao.insert(rnr);
			} catch (DataInvalidException e) {
				log.error(String.format("日志处理出错"),e);
			}
			
			if(qe!=null)
				EventListenerContainer.getInstance().fireEvent(qe);
		}
		return rm;
		
	}
	
	
	/**
	 * 查询招标项目接口   搜索。。。
	 * @author YJY
	 * @since 2015年11月14日19:30:17
	 * @return
	 */
	@RequestMapping(value="/queryObjectList_homepage",method=RequestMethod.POST)
	@AccessRequered(methodName = " 查询招标项目")
	// 框架的日志处理
	public @ResponseBody ResultModel queryObjectList_homepage(HttpServletRequest request,
			HttpServletResponse response) {
		String messagebase = " 查询招标项目";
		int basecode = 0;
		BaseTransVO<TenderObjectBodyVO> transorder = null;
		ResultModel rm = new ResultModel();
		try {
			String jsonstr = RequestUtil.getRequestPostData(request);
			request.setAttribute("rawjson", jsonstr);
			transorder = RequestUtil.convertJson2Obj(jsonstr, BaseTransVO.class,TenderObjectBodyVO.class);
		} catch (Exception e) {
			log.error(String.format("获取%s参数出错",messagebase),e);
			rm.mergeException(ValidateException.ERROR_PARAM_FORMAT_ERROR.cloneAndAppend(null, messagebase+"参数"));
			return rm;
		}
//		// 预设的一些信息
		
//		rm.setBaseErrorCode(basecode);
		rm.setErrmsg(messagebase + "成功");
		RequestEvent qe=null ;
		
		
		AppLog rnr = new AppLog();
		rnr.setAppid(transorder.getApp().getAppId());
		rnr.setRequest(ObjectUtils.toString(request.getAttribute("rawjson")));
		rnr.setInserttime(new Date());
		rnr.setMethod("/tender/queryObjectList_homepage");
		
		try {
			
				com.hummingbird.common.face.Pagingnation page = transorder.getBody().toPagingnation();
				
				List<TenderObjectListReturnVO> list=new ArrayList<TenderObjectListReturnVO>();
//				list = announcementService.selectAnnouncementInValid(user_id, page);
				String[] keywords = transorder.getBody().getKeywords();
				list = tenderService.getTenderObjectList(transorder.getBody().getKeywords(), page);
				List<Map> nos = CollectionTools.convertCollection(list, Map.class, new CollectionTools.CollectionElementConvertor<TenderObjectListReturnVO, Map>() {

					@Override
					public Map convert(TenderObjectListReturnVO ori) {
						
						try {
							Map row= BeanUtils.describe(ori);
							row.remove("class");
							return row;
							
						} catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
							log.error(String.format("转换为map对象出错"),e);
							return null;
						}
					}
				});
				mergeListOutput(rm, page, nos);
		}catch (Exception e1) {
			log.error(String.format(messagebase + "失败"), e1);
			rm.mergeException(e1);
			if(qe!=null)
				qe.setSuccessed(false);
		} finally {
			try {
				rnr.setRespone(StringUtils.substring(JsonUtil.convert2Json(rm),0,2000));
				applogDao.insert(rnr);
			} catch (DataInvalidException e) {
				log.error(String.format("日志处理出错"),e);
			}
			
			if(qe!=null)
				EventListenerContainer.getInstance().fireEvent(qe);
		}
		return rm;
		
	}
	
	/**
	 * 查询首页招标项目列表接口
	 * @author YJY
	 * @since 2015年11月14日19:30:17
	 * @return
//	 */
//	@RequestMapping(value="/queryIndexObjectList",method=RequestMethod.POST)
//	@AccessRequered(methodName = " 查询首页招标项目列表")
//	// 框架的日志处理
//	public @ResponseBody ResultModel queryIndexObjectList(HttpServletRequest request,
//			HttpServletResponse response) {
//		String messagebase = " 查询首页招标项目列表";
//		int basecode = 0;
//		BaseTransVO<BaseBidObjectVO> transorder = null;
//		ResultModel rm = new ResultModel();
//		try {
//			String jsonstr = RequestUtil.getRequestPostData(request);
//			request.setAttribute("rawjson", jsonstr);
//			transorder = (BaseTransVO<BaseBidObjectVO> )RequestUtil.convertJson2Obj(jsonstr, BaseTransVO.class,BaseBidObjectVO.class);
//		} catch (Exception e) {
//			log.error(String.format("获取%s参数出错",messagebase),e);
//			rm.mergeException(ValidateException.ERROR_PARAM_FORMAT_ERROR.cloneAndAppend(null, messagebase+"参数"));
//			return rm;
//		}
////		// 预设的一些信息
//		
////		rm.setBaseErrorCode(basecode);
//		rm.setErrmsg(messagebase + "成功");
//		RequestEvent qe=null ;
//		
//		
//		AppLog rnr = new AppLog();
//		rnr.setAppid(transorder.getApp().getAppId());
//		rnr.setRequest(ObjectUtils.toString(request.getAttribute("rawjson")));
//		rnr.setInserttime(new Date());
//		rnr.setMethod("/tender/queryIndexObjectList");
//		
//		try {
//			
////				com.hummingbird.common.face.Pagingnation page = transorder.getBody().toPagingnation();
//				
//				List<QueryIndexObjectListResult> list=new ArrayList<QueryIndexObjectListResult>();
////				list = announcementService.selectAnnouncementInValid(user_id, page);
////				list = tenderService.getIndexObjectList(page);
//				list = tenderService.getIndexObjectList();
//				List<Map> nos = CollectionTools.convertCollection(list, Map.class, new CollectionTools.CollectionElementConvertor<QueryIndexObjectListResult, Map>() {
//
//					@Override
//					public Map convert(QueryIndexObjectListResult ori) {
//						
//						try {
//							Map row= BeanUtils.describe(ori);
////							row.put(key, value);
//							row.remove("class");
//							return row;
//							
//						} catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
//							log.error(String.format("转换为map对象出错"),e);
//							return null;
//						}
//					}
//				});
//				rm.put("list", nos);
//		}catch (Exception e1) {
//			log.error(String.format(messagebase + "失败"), e1);
//			rm.mergeException(e1);
//			if(qe!=null)
//				qe.setSuccessed(false);
//		} finally {
//			try {
//				rnr.setRespone(StringUtils.substring(JsonUtil.convert2Json(rm),0,2000));
//				applogDao.insert(rnr);
//			} catch (DataInvalidException e) {
//				log.error(String.format("日志处理出错"),e);
//			}
//			
//			if(qe!=null)
//				EventListenerContainer.getInstance().fireEvent(qe);
//		}
//		return rm;
//		
//	}
	/**
	 * 查询首页招标项目列表接口
	 * @author YJY
	 * @since 2015年11月14日19:30:17
	 * @return
	 */
	@RequestMapping(value="/queryIndexObjectList",method=RequestMethod.POST)
	@AccessRequered(methodName = " 查询首页招标项目列表")
	// 框架的日志处理
	public @ResponseBody ResultModel queryIndexObjectList(HttpServletRequest request,
			HttpServletResponse response) {
		String messagebase = " 查询首页招标项目列表";
		int basecode = 0;
		BaseTransVO<BaseTenderObjectVO> transorder = null;
		ResultModel rm = new ResultModel();
		try {
			String jsonstr = RequestUtil.getRequestPostData(request);
			request.setAttribute("rawjson", jsonstr);
			transorder = (BaseTransVO<BaseTenderObjectVO> )RequestUtil.convertJson2Obj(jsonstr, BaseTransVO.class,BaseTenderObjectVO.class);
		} catch (Exception e) {
			log.error(String.format("获取%s参数出错",messagebase),e);
			rm.mergeException(ValidateException.ERROR_PARAM_FORMAT_ERROR.cloneAndAppend(null, messagebase+"参数"));
			return rm;
		}
//		// 预设的一些信息
		
//		rm.setBaseErrorCode(basecode);
		rm.setErrmsg(messagebase + "成功");
		RequestEvent qe=null ;
		
		
		AppLog rnr = new AppLog();
		rnr.setAppid(transorder.getApp().getAppId());
		rnr.setRequest(ObjectUtils.toString(request.getAttribute("rawjson")));
		rnr.setInserttime(new Date());
		rnr.setMethod("/tender/queryIndexObjectList");
		
		try {
			
				com.hummingbird.common.face.Pagingnation page = transorder.getBody().toPagingnation();
				
				List<QueryIndexObjectListResult> list=new ArrayList<QueryIndexObjectListResult>();
//				list = tenderService.getIndexObjectList(page);
				list = tenderService.getIndexObjectList(page);
				List<Map> nos = CollectionTools.convertCollection(list, Map.class, new CollectionTools.CollectionElementConvertor<QueryIndexObjectListResult, Map>() {

					@Override
					public Map convert(QueryIndexObjectListResult ori) {
						
						try {
							Map row= BeanUtils.describe(ori);
//							row.put(key, value);
							
							row.remove("class");
							return row;
							
						} catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
							log.error(String.format("转换为map对象出错"),e);
							return null;
						}
					}
				});
				mergeListOutput(rm, page, nos);
		}catch (Exception e1) {
			log.error(String.format(messagebase + "失败"), e1);
			rm.mergeException(e1);
			if(qe!=null)
				qe.setSuccessed(false);
		} finally {
			try {
				rnr.setRespone(StringUtils.substring(JsonUtil.convert2Json(rm),0,2000));
				applogDao.insert(rnr);
			} catch (DataInvalidException e) {
				log.error(String.format("日志处理出错"),e);
			}
			
			if(qe!=null)
				EventListenerContainer.getInstance().fireEvent(qe);
		}
		return rm;
		
	}
	
	/**
	 * 查询首页中标结果概况接口
	 * @author YJY
	 * @since 2015年11月14日19:30:17
	 * @return
	 */
	@RequestMapping(value="/queryBidIndexSurvey",method=RequestMethod.POST)
	@AccessRequered(methodName = " 查询首页中标结果概况")
	// 框架的日志处理
	public @ResponseBody ResultModel queryBidIndexSurvey(HttpServletRequest request,
			HttpServletResponse response) {
		String messagebase = " 查询首页中标结果概况";
		int basecode = 0;
		BaseTransVO transorder = null;
		ResultModel rm = new ResultModel();
		try {
			String jsonstr = RequestUtil.getRequestPostData(request);
			request.setAttribute("rawjson", jsonstr);
			transorder = RequestUtil.convertJson2Obj(jsonstr, BaseTransVO.class);

		} catch (Exception e) {
			log.error(String.format("获取%s参数出错",messagebase),e);
			rm.mergeException(ValidateException.ERROR_PARAM_FORMAT_ERROR.cloneAndAppend(null, messagebase+"参数"));
			return rm;
		}
//		// 预设的一些信息
		
//		rm.setBaseErrorCode(basecode);
		rm.setErrmsg(messagebase + "成功");
		RequestEvent qe=null ;
		
		
		AppLog rnr = new AppLog();
		rnr.setAppid(transorder.getApp().getAppId());
		rnr.setRequest(ObjectUtils.toString(request.getAttribute("rawjson")));
		rnr.setInserttime(new Date());
		rnr.setMethod("/tender/queryBidIndexSurvey");
		
		try {
			QueryBidIndexSurveyResult bis=new QueryBidIndexSurveyResult();
			bis = bidObjectDao.selectBidIndexSurvey();
			rm.put("info", bis);
				
		}catch (Exception e1) {
			log.error(String.format(messagebase + "失败"), e1);
			rm.mergeException(e1);
			if(qe!=null)
				qe.setSuccessed(false);
		} finally {
			try {
				rnr.setRespone(StringUtils.substring(JsonUtil.convert2Json(rm),0,2000));
				applogDao.insert(rnr);
			} catch (DataInvalidException e) {
				log.error(String.format("日志处理出错"),e);
			}
			
			if(qe!=null)
				EventListenerContainer.getInstance().fireEvent(qe);
		}
		return rm;
		
	}
	
	
	
	/**
	 * 查询首页中标项目列表接口
	 * @author YJY
	 * @since 2015年11月14日19:30:17
	 * @return
	 */
	@RequestMapping(value="/queryBidIndexList",method=RequestMethod.POST)
	@AccessRequered(methodName = " 查询首页中标项目列表")
	// 框架的日志处理
	public @ResponseBody ResultModel queryBidIndexList(HttpServletRequest request,
			HttpServletResponse response) {
		String messagebase = " 查询首页中标项目列表";
		int basecode = 0;
		BaseTransVO<BaseBidObjectVO> transorder = null;
		ResultModel rm = new ResultModel();
		try {
			String jsonstr = RequestUtil.getRequestPostData(request);
			request.setAttribute("rawjson", jsonstr);
			transorder = RequestUtil.convertJson2Obj(jsonstr, BaseTransVO.class,BaseBidObjectVO.class);
		} catch (Exception e) {
			log.error(String.format("获取%s参数出错",messagebase),e);
			rm.mergeException(ValidateException.ERROR_PARAM_FORMAT_ERROR.cloneAndAppend(null, messagebase+"参数"));
			return rm;
		}
//		// 预设的一些信息
		
//		rm.setBaseErrorCode(basecode);
		rm.setErrmsg(messagebase + "成功");
		RequestEvent qe=null ;
		
		
		AppLog rnr = new AppLog();
		rnr.setAppid(transorder.getApp().getAppId());
		rnr.setRequest(ObjectUtils.toString(request.getAttribute("rawjson")));
		rnr.setInserttime(new Date());
		rnr.setMethod("/tender/queryBidIndexList");
		
		try {
			
				com.hummingbird.common.face.Pagingnation page = transorder.getBody().toPagingnation();
				
				List<QueryBidIndexListResult> list=new ArrayList<QueryBidIndexListResult>();
//				list = announcementService.selectAnnouncementInValid(user_id, page);
//				list = tenderService.getBidIndexList(page);
				list = tenderService.getBidIndexList(page,transorder.getBody().getProjectName(),transorder.getBody().getPublishTime());
				List<Map> nos = CollectionTools.convertCollection(list, Map.class, new CollectionTools.CollectionElementConvertor<QueryBidIndexListResult, Map>() {

					@Override
					public Map convert(QueryBidIndexListResult ori) {
						
						try {
							Map row= BeanUtils.describe(ori);
							row.remove("class");
							return row;
							
						} catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
							log.error(String.format("转换为map对象出错"),e);
							return null;
						}
					}
				});
//				rm.put("list", nos);
				mergeListOutput(rm, page, nos);
		}catch (Exception e1) {
			log.error(String.format(messagebase + "失败"), e1);
			rm.mergeException(e1);
			if(qe!=null)
				qe.setSuccessed(false);
		} finally {
			try {
				rnr.setRespone(StringUtils.substring(JsonUtil.convert2Json(rm),0,2000));
				applogDao.insert(rnr);
			} catch (DataInvalidException e) {
				log.error(String.format("日志处理出错"),e);
			}
			
			if(qe!=null)
				EventListenerContainer.getInstance().fireEvent(qe);
		}
		return rm;
		
	}
	/**
	 * 查询首页投标人推荐列表接口
	 * @return  queryMyEndedObject
	 */
	@RequestMapping(value="/queryIndexBidList",method=RequestMethod.POST)
	@AccessRequered(methodName = "查询首页投标人推荐列表",isJson=true,codebase=242300,className="com.hummingbird.commonbiz.vo.BaseTransVO",genericClassName="",appLog=true)
	public @ResponseBody ResultModel queryIndexBidList(HttpServletRequest request,HttpServletResponse response) {
		ResultModel rm = super.getResultModel();
		BaseTransVO<BaseBidObjectVO> transorder = (BaseTransVO<BaseBidObjectVO>) super.getParameterObject();
		String messagebase = "查询首页投标人推荐列表"; 
		RequestEvent qe=null ; 
		List<QueryIndexBidListResultVO> liq = null;
		try {
		
			if(log.isDebugEnabled()){
				log.debug("检验通过，获取请求");
			}
			Integer pageIndex =1;
			Integer pageSize =20;
			if(pageIndex==null||pageSize==null||pageIndex<=0||pageSize<=0){log.error(String.format(messagebase + "失败"));
			rm.setErrmsg("参数错误");
			return rm;
			}
			liq = tenderService.queryIndexBidList(pageIndex, pageSize);
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
	 * 查询首页投标人概况接口
	 * @author YJY
	 * @since 2015年11月17日8:31:59
	 * @return
	 */
	@RequestMapping(value="/queryBidderIndexSurvey",method=RequestMethod.POST)
	@AccessRequered(methodName = "查询首页投标人概况",isJson=true,codebase=242300,className="com.hummingbird.commonbiz.vo.BaseTransVO",genericClassName="",appLog=true)
	public @ResponseBody ResultModel queryBidderIndexSurvey(HttpServletRequest request,HttpServletResponse response) {
		ResultModel rm = super.getResultModel();
		BaseTransVO transorder = (BaseTransVO) super.getParameterObject();
		String messagebase = "查询首页投标人概况"; 
		RequestEvent qe=null ; 
		int stairBiderNum = 0;
		int secondBiderNum = 0;
		try {
		
			if(log.isDebugEnabled()){
				log.debug("检验通过，获取请求");
			}
			stairBiderNum = bidderDao.countStairBiderNum();
			secondBiderNum = bidderDao.countSecondBiderNum();
			
	        rm.put("stairBiderNum", stairBiderNum);
	        rm.put("secondBiderNum", secondBiderNum);
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
	 * 查询首页招标项目概况接口
	 * @author YJY
	 * @since 2015年11月14日19:30:17(补充)
	 * @return
	 */
	@RequestMapping(value="/queryObjectIndexSurvey",method=RequestMethod.POST)
	@AccessRequered(methodName = "查询首页招标项目概况接口")
	// 框架的日志处理
	public @ResponseBody ResultModel queryObjectIndexSurvey(HttpServletRequest request,
			HttpServletResponse response) {
		String messagebase = "查询首页招标项目概况接口";
		int basecode = 0;
		BaseTransVO transorder = null;
		ResultModel rm = new ResultModel();
		try {
			String jsonstr = RequestUtil.getRequestPostData(request);
			request.setAttribute("rawjson", jsonstr);
			transorder = RequestUtil.convertJson2Obj(jsonstr, BaseTransVO.class);

		} catch (Exception e) {
			log.error(String.format("获取%s参数出错",messagebase),e);
			rm.mergeException(ValidateException.ERROR_PARAM_FORMAT_ERROR.cloneAndAppend(null, messagebase+"参数"));
			return rm;
		}
//		// 预设的一些信息
		
//		rm.setBaseErrorCode(basecode);
		rm.setErrmsg(messagebase + "成功");
		RequestEvent qe=null ;
		
		
		AppLog rnr = new AppLog();
		rnr.setAppid(transorder.getApp().getAppId());
		rnr.setRequest(ObjectUtils.toString(request.getAttribute("rawjson")));
		rnr.setInserttime(new Date());
		rnr.setMethod("/tender/queryObjectIndexSurvey");
		
		try {
			QueryObjectIndexSurveyResult bis=new QueryObjectIndexSurveyResult();
			bis = bidObjectDao.selectObjectIndexSurvey();
			rm.put("info", bis);
				
		}catch (Exception e1) {
			log.error(String.format(messagebase + "失败"), e1);
			rm.mergeException(e1);
			if(qe!=null)
				qe.setSuccessed(false);
		} finally {
			try {
				rnr.setRespone(StringUtils.substring(JsonUtil.convert2Json(rm),0,2000));
				applogDao.insert(rnr);
			} catch (DataInvalidException e) {
				log.error(String.format("日志处理出错"),e);
			}
			
			if(qe!=null)
				EventListenerContainer.getInstance().fireEvent(qe);
		}
		return rm;
		
	}
	
	/**
	 * 查询公司信息接口
	 * @author YJY
	 * @since 2015年12月4日16:09:52
	 * @return
	 */
	@RequestMapping(value = "/queryCompanyInfo", method = RequestMethod.POST)
	@AccessRequered(methodName = "查询公司信息接口", isJson = true, codebase = 241900, className = "com.hummingbird.commonbiz.vo.BaseTransVO", genericClassName = "com.hummingbird.paas.vo.QueryCompanyInfoBodyVO", appLog = true)
	public @ResponseBody ResultModel queryCompanyInfo(HttpServletRequest request, HttpServletResponse response) {
		ResultModel rm = super.getResultModel();
		BaseTransVO<QueryCompanyInfoBodyVO> transorder = (BaseTransVO<QueryCompanyInfoBodyVO>) super.getParameterObject();
		String messagebase = "查询公司信息接口";

		RequestEvent qe = null; // 业务请求事件,当实现一些关键的业务时,需要生成该请求

		try {
			CompanyInfo cc = new CompanyInfo();
			if("BEE".equals(transorder.getBody().getType())){//招标
				 cc = tenderService.queryTenderCompanyInfo(transorder.getApp().getAppId(), transorder.getBody());
			}else if("BER".equals(transorder.getBody().getType())){//投标 
				 cc = tenderService.queryBidderCompanyInfo(transorder.getApp().getAppId(), transorder.getBody());
			}
			

			rm.put("info", cc);

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
	

	@RequestMapping(value = "/evaluateBidder", method = RequestMethod.POST)
	@AccessRequered(methodName = "招标方给投标方评价接口", isJson = true, codebase = 242400, className = "com.hummingbird.commonbiz.vo.BaseTransVO", genericClassName = "com.hummingbird.paas.vo.EvaluateBidderBodyVO", appLog = true)
	public @ResponseBody Object evaluateBidder(HttpServletRequest request) {
		
		ResultModel rm = super.getResultModel();
		BaseTransVO<EvaluateBidderBodyVO> transorder = (BaseTransVO<EvaluateBidderBodyVO>) super.getParameterObject();
		String messagebase = "招标方给投标方评价接口"; 
		RequestEvent qe=null ; 
		List<QueryBidderListResultVO> liq = null;
		try {
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
			tenderService.evaluateBidder(transorder.getApp().getAppId(),transorder.getBody(),biddee);
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
	 * 查询工程类别列表
	 * @return
	 */
	@RequestMapping(value="/getIndustryList",method=RequestMethod.POST)
	@AccessRequered(methodName = "查询工程类别列表",isJson=true,codebase=247700,className="com.hummingbird.commonbiz.vo.BaseTransVO",genericClassName="java.util.Map",appLog=true)
	public @ResponseBody ResultModel getIndustryList(HttpServletRequest request,HttpServletResponse response) {
		ResultModel rm = super.getResultModel();
		BaseTransVO<Map> transorder = (BaseTransVO<Map>) super.getParameterObject();
		String messagebase = "查询工程类别列表"; 
	
		RequestEvent qe=null ; //业务请求事件,当实现一些关键的业务时,需要生成该请求
		
		try {
			//业务数据必填等校验
			//业务数据逻辑校验
			if(log.isDebugEnabled()){
				log.debug("检验通过，获取请求");
			}
			List<GetIndustryListBodyVOResult>  result = tenderService.getIndustryList(transorder.getApp().getAppId(),transorder.getBody());
			rm.put("list",result);
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
	 * 查询工程类别详情
	 * @return
	 */
	@RequestMapping(value="/getIndustryDetail",method=RequestMethod.POST)
	@AccessRequered(methodName = "查询工程类别详情",isJson=true,codebase=247800,className="com.hummingbird.commonbiz.vo.BaseTransVO",genericClassName="com.hummingbird.paas.vo.GetIndustryDetailBodyVO",appLog=true)
	public @ResponseBody ResultModel getIndustryDetail(HttpServletRequest request,HttpServletResponse response) {
		ResultModel rm = super.getResultModel();
		BaseTransVO<GetIndustryDetailBodyVO> transorder = (BaseTransVO<GetIndustryDetailBodyVO>) super.getParameterObject();
		String messagebase = "查询工程类别详情"; 
		
		RequestEvent qe=null ; //业务请求事件,当实现一些关键的业务时,需要生成该请求
		
		try {
			//业务数据必填等校验
			//业务数据逻辑校验
			if(log.isDebugEnabled()){
				log.debug("检验通过，获取请求");
			}
			GetIndustryListBodyVOResult  result = tenderService.getIndustryDetail(transorder.getApp().getAppId(),transorder.getBody());
			rm.put("result",result);
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
