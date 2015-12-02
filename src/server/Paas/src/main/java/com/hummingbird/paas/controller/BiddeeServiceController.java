package com.hummingbird.paas.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.ObjectUtils;
import org.apache.commons.lang.StringUtils;
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
import com.hummingbird.common.exception.DataInvalidException;
import com.hummingbird.common.exception.ValidateException;
import com.hummingbird.common.ext.AccessRequered;
import com.hummingbird.common.face.AbstractAppLog;
import com.hummingbird.common.util.DateUtil;
import com.hummingbird.common.util.JsonUtil;
import com.hummingbird.common.util.RequestUtil;
import com.hummingbird.common.vo.ResultModel;
import com.hummingbird.commonbiz.exception.TokenException;
import com.hummingbird.commonbiz.vo.BaseTransVO;
import com.hummingbird.paas.entity.AppLog;
import com.hummingbird.paas.entity.BidObject;
import com.hummingbird.paas.entity.Biddee;
import com.hummingbird.paas.entity.Bidder;
import com.hummingbird.paas.entity.ProjectStatus;
import com.hummingbird.paas.entity.Token;
import com.hummingbird.paas.mapper.AppLogMapper;
import com.hummingbird.paas.mapper.BidObjectMapper;
import com.hummingbird.paas.mapper.BiddeeMapper;
import com.hummingbird.paas.mapper.BidderMapper;
import com.hummingbird.paas.mapper.ProjectEvaluationBiddeeMapper;
import com.hummingbird.paas.mapper.ProjectStatusMapper;
import com.hummingbird.paas.services.BiddeeServiceService;
import com.hummingbird.paas.services.TokenService;
import com.hummingbird.paas.util.CallInterfaceUtil;
import com.hummingbird.paas.util.MoneyUtil;
import com.hummingbird.paas.vo.BidEvaluateReturnVO;
import com.hummingbird.paas.vo.GetMsgListBodyVO;
import com.hummingbird.paas.vo.JsonResult;
import com.hummingbird.paas.vo.JsonResultMsg;
import com.hummingbird.paas.vo.MyObjectTenderSurveyBodyVO;
import com.hummingbird.paas.vo.QueryMyBidObjectListResultVO;
import com.hummingbird.paas.vo.QueryMyBuildingObjectListResultVO;
import com.hummingbird.paas.vo.QueryMyEndedObjectListResultVO;
import com.hummingbird.paas.vo.QueryMyLoseObjectListResultVO;
import com.hummingbird.paas.vo.QueryObjectDetailBodyVO;
import com.hummingbird.paas.vo.QueryObjectListResultVO;
import com.hummingbird.paas.vo.TagInfo;
import com.hummingbird.paas.vo.TenderSurveyBodyVO;
import com.hummingbird.paas.vo.TendererEvaluateReturnVO;
import com.hummingbird.paas.vo.TokenBodyVO;
@Controller
@RequestMapping(value = "/gw/bid", method = RequestMethod.POST)
public class BiddeeServiceController extends BaseController{
	@Autowired
	BiddeeServiceService beeServiceSer;
	@Autowired
	TokenService tokenSrv;
	@Autowired
	ProjectStatusMapper psDao;
	@Autowired
	BidObjectMapper  bidObjectDao;
	@Autowired
	BiddeeMapper  biddeeDao;
	@Autowired(required = true)
	protected AppLogMapper applogDao;
	
	@Autowired
	protected ProjectEvaluationBiddeeMapper pebDao;
	
	@Autowired
	BidderMapper  bidderDao;
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
			liq = beeServiceSer.queryObjectList(pageIndex,pageSize);
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
			Integer pageIndex =transorder.getBody().getPageIndex();
			Integer pageSize =transorder.getBody().getPageSize();
			if(pageIndex==null||pageSize==null||pageIndex<=0||pageSize<=0){
				log.error(String.format(messagebase + "失败"));
				rm.setErrmsg("参数错误");
				return rm;
			}
			liq = beeServiceSer.queryMyBidObjectList(token.getUserId(), pageIndex, pageSize);
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
	 * 查询我的投标中项目列表接口【页面是项目竣工日期？】
	 * @return  queryMyBuildingObject
	 */
	@RequestMapping(value="/queryMyBuildingObject",method=RequestMethod.POST)
	@AccessRequered(methodName = "查询我的投标中项目列表",isJson=true,codebase=242300,className="com.hummingbird.commonbiz.vo.BaseTransVO",genericClassName="com.hummingbird.paas.vo.GetMsgListBodyVO",appLog=true)
	public @ResponseBody ResultModel queryMyBuildingObject(HttpServletRequest request,HttpServletResponse response) {
		ResultModel rm = super.getResultModel();
		BaseTransVO<GetMsgListBodyVO> transorder = (BaseTransVO<GetMsgListBodyVO>) super.getParameterObject();
		String messagebase = "查询我的投标中项目列表"; 
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
			Integer pageIndex =transorder.getBody().getPageIndex();
			Integer pageSize =transorder.getBody().getPageSize();
			if(pageIndex==null||pageSize==null||pageIndex<=0||pageSize<=0){
				log.error(String.format(messagebase + "失败"));
				rm.setErrmsg("参数错误");
				return rm;
			}
			liq = beeServiceSer.queryMyBuildingObjectList(token.getUserId(), pageIndex, pageSize);
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
				ter.setWinBidAmount(MoneyUtil.getMoneyStringDecimal4yuan(bo.getWinBidAmount()));
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
