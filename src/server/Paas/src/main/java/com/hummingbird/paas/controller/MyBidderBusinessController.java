package com.hummingbird.paas.controller;
/**
 * @author YJY 
 * @since 2015年11月10日16:24:23
 * 投标人业务
 * */

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang.ObjectUtils;
import org.apache.commons.lang.StringUtils;
import org.bouncycastle.jce.provider.JCEMac.MD5;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.hummingbird.common.controller.BaseController;
import com.hummingbird.common.event.EventListenerContainer;
import com.hummingbird.common.event.RequestEvent;
import com.hummingbird.common.exception.DataInvalidException;
import com.hummingbird.common.exception.ValidateException;
import com.hummingbird.common.ext.AccessRequered;
import com.hummingbird.common.face.AbstractAppLog;
import com.hummingbird.common.util.CollectionTools;
import com.hummingbird.common.util.DateUtil;
import com.hummingbird.common.util.JsonUtil;
import com.hummingbird.common.util.Md5Util;
import com.hummingbird.common.util.PropertiesUtil;
import com.hummingbird.common.util.RequestUtil;
import com.hummingbird.common.util.ValidateUtil;
import com.hummingbird.common.vo.ResultModel;
import com.hummingbird.commonbiz.exception.TokenException;
import com.hummingbird.commonbiz.vo.BaseTransVO;

import com.hummingbird.paas.entity.AppLog;
import com.hummingbird.paas.entity.BidderBankAduit;
import com.hummingbird.paas.entity.BidderCerticate;
import com.hummingbird.paas.entity.BidderCertificateAduit;
import com.hummingbird.paas.entity.BidderCredit;
import com.hummingbird.paas.entity.ScoreLevel;
import com.hummingbird.paas.entity.Token;
import com.hummingbird.paas.entity.UserBankcard;
import com.hummingbird.paas.mapper.AppLogMapper;
import com.hummingbird.paas.mapper.BidderBankAduitMapper;
import com.hummingbird.paas.mapper.BidderCertificateAduitMapper;
import com.hummingbird.paas.mapper.BidderCreditMapper;
import com.hummingbird.paas.mapper.ScoreLevelMapper;
import com.hummingbird.paas.mapper.UserBankcardMapper;
import com.hummingbird.paas.services.MyBidderService;
import com.hummingbird.paas.services.TokenService;
import com.hummingbird.paas.vo.BidderAuditInfoVO;
import com.hummingbird.paas.vo.BidderBaseInfoCheck;
import com.hummingbird.paas.vo.BidderAuditInfoVO;
import com.hummingbird.paas.vo.BidderAuthInfo;
import com.hummingbird.paas.vo.BidderBankInfo;
import com.hummingbird.paas.vo.BidderBaseInfo;
import com.hummingbird.paas.vo.BidderCerticateSaveInfoVO;
import com.hummingbird.paas.vo.BidderEqInfo;
import com.hummingbird.paas.vo.BidderLegalPerson;
import com.hummingbird.paas.vo.BidderRegisteredInfo;
import com.hummingbird.paas.vo.MyBidderAuthInfoApplyVO;
import com.hummingbird.paas.vo.MyBidderAuthInfoBodyVO;
@Controller
@RequestMapping(value="/myBidder/authInfo"
		 ,method=RequestMethod.POST)
@JsonIgnoreProperties(ignoreUnknown = true)
public class MyBidderBusinessController extends BaseController  {
	@Autowired
	protected MyBidderService myBidderService;
	@Autowired
	protected BidderCertificateAduitMapper bidderCertificateAduitDao;
	@Autowired
	protected BidderCreditMapper bidderCreditDao;
	@Autowired
	protected BidderBankAduitMapper bidderBankAduitDao;
	@Autowired
	protected ScoreLevelMapper scoreLevelDao;
	@Autowired
	TokenService tokenSrv;
	@Autowired(required = true)
	protected AppLogMapper applogDao;
	
	/**
	 * 查询我的投标人认证信息接口
	 * @author YJY
	 * @since 2015年11月10日16:25:14
	 * @return
	 */
	@RequestMapping(value="/getAuthInfo",method=RequestMethod.POST)
	@AccessRequered(methodName = "查询我的投标人认证信息")
	// 框架的日志处理
	public @ResponseBody ResultModel getAuthInfo(HttpServletRequest request,
			HttpServletResponse response) {
		String messagebase = "查询我的投标人认证信息";
		int basecode = 0;
		BaseTransVO<MyBidderAuthInfoBodyVO> transorder = null;
		ResultModel rm = new ResultModel();
		try {
			String jsonstr = RequestUtil.getRequestPostData(request);
			request.setAttribute("rawjson", jsonstr);
			transorder = RequestUtil.convertJson2Obj(jsonstr, BaseTransVO.class,MyBidderAuthInfoBodyVO.class);
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
		rnr.setMethod("/myBidder/authInfo/getAuthInfo");
		
		try {
			BidderCredit aa = bidderCreditDao.selectByToken(transorder.getBody().getToken());
			ScoreLevel bb = new ScoreLevel();
			Map overall= new HashMap();//积分和信用等级信息
			Map detail= new HashMap();//详细信息
			Map baseInof= new HashMap();//基础信息
			Map tradeInfo= new HashMap();//交易信息
			Map myBidderInfo= new HashMap();//企业信息
			BidderAuthInfo ba = new BidderAuthInfo();
			BidderCertificateAduit p = new BidderCertificateAduit();
			BidderCertificateAduit bi = new BidderCertificateAduit();
			BidderCertificateAduit lp = new BidderCertificateAduit();
			BidderCertificateAduit cr = new BidderCertificateAduit();
			BidderBankAduit bba = new BidderBankAduit();
			if(aa != null){
				 bb = scoreLevelDao.countLevelByScore(aa.getCreditScore()!=null?aa.getCreditScore():0);
				 p = bidderCertificateAduitDao.selectPersonalInfo(aa.getBidderId());
				 bi = bidderCertificateAduitDao.selectBaseInfo(aa.getBidderId());
				 lp = bidderCertificateAduitDao.selectLegalPersonInfo(aa.getBidderId());
				 cr = bidderCertificateAduitDao.selectCompanyRegisteredInfo(aa.getBidderId());
				 bba = bidderBankAduitDao.selectByBcId(aa.getBidderId());
				 overall.put("creditScore", aa.getCreditScore());
				//1.个人状态、积分信息
				ba.setCreditScore(aa.getCreditScore());
				if(p!=null){
					ba.setStatus("已认证");
				}else{
					ba.setStatus("待认证");
				}
				baseInof.put("personalInfo", ba);
				detail.put("baseInof", baseInof);
				baseInof.clear();
				ba.setCreditScore(aa.getCreditScore());
				//2.基本状态、积分信息
				if(bi!=null){
					ba.setStatus("已认证");
				}else{
					ba.setStatus("待认证");
				}
				myBidderInfo.put("baseInfo", ba);
				//3.法人状态、积分信息
				if(lp!=null){
					ba.setStatus("已认证");
				}else{
					ba.setStatus("待认证");
				}
				ba.setCreditScore(aa.getLegalPersonInfo());
				myBidderInfo.put("legalPersonInfo", ba);
				//4.公司注册状态、积分信息
				if(cr!=null){
					ba.setStatus("已认证");
				}else{
					ba.setStatus("待认证");
				}
				ba.setCreditScore(aa.getCompanyRegisteredInfo());
				myBidderInfo.put("companyRegisteredInfo", ba);
				//5.开户行 状态、积分信息
				if(bba!=null&&"OK#".equalsIgnoreCase(bba.getBankcardCertificateResult())){
					ba.setStatus("已认证");
				}else if(bba!=null&&"FLS".equalsIgnoreCase(bba.getBankcardCertificateResult())){
					ba.setStatus("认证失败");
				}else{
					ba.setStatus("待认证");
				}
				ba.setCreditScore(aa.getBankInfo());
				myBidderInfo.put("bankInfo", ba);
			}else{
				overall.put("creditScore", "");
				
			}
			if(bb!= null){
				overall.put("creditRating", bb.getLevelName());
				overall.put("creditRatingIcon", bb.getIcon());
			}else{
				overall.put("creditRating", "");
				overall.put("creditRatingIcon", "");
			}
			
			
			
			detail.put("myBidderInfo", myBidderInfo);
			rm.put("overall", overall);
			
			
			
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
	 * 查询保存的投标人基本信息接口
	 * @author YJY
	 * @since 2015年11月10日16:25:24
	 * @return
	 */
	@RequestMapping(value="/getBaseInfo_apply",method=RequestMethod.POST)
	@AccessRequered(methodName = "查询保存的投标人基本信息")
	// 框架的日志处理
	public @ResponseBody ResultModel getBaseInfo_apply(HttpServletRequest request,
			HttpServletResponse response) {
		String messagebase = "查询保存的投标人基本信息";
		int basecode = 0;
		BaseTransVO<MyBidderAuthInfoBodyVO> transorder = null;
		ResultModel rm = new ResultModel();
		try {
			String jsonstr = RequestUtil.getRequestPostData(request);
			request.setAttribute("rawjson", jsonstr);
			transorder = RequestUtil.convertJson2Obj(jsonstr, BaseTransVO.class,MyBidderAuthInfoBodyVO.class);
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
		rnr.setMethod("/myBidder/authInfo/getBaseInfo_apply");
		BidderBaseInfo baseInfo = new BidderBaseInfo();
		try {
			// 业务数据必填等校验
			Token token = tokenSrv.getToken(transorder.getBody().getToken(), transorder.getApp().getAppId());
			if (token == null) {
				log.error(String.format("token[%s]验证失败,或已过期,请重新登录", transorder.getBody().getToken()));
				throw new TokenException("token验证失败,或已过期,请重新登录");
			}
			
			baseInfo = myBidderService.getBaseInfo_apply(token);
			
//			baseInfo.put("creditRatingIcon", aa.getUnified_social_credit_code_url());
			rm.put("baseInfo", baseInfo);
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
	 * 查询保存的投标人法人信息接口
	 * @author YJY
	 * @since 2015年11月10日16:25:32
	 * @return
	 */
	@RequestMapping(value="/getLegalPersonInfo_apply",method=RequestMethod.POST)
	@AccessRequered(methodName = "查询保存的投标人法人信息")
	// 框架的日志处理
	public @ResponseBody ResultModel getLegalPersonInfo_apply(HttpServletRequest request,
			HttpServletResponse response) {
		String messagebase = "查询保存的投标人法人信息";
		int basecode = 0;
		BaseTransVO<MyBidderAuthInfoBodyVO> transorder = null;
		ResultModel rm = new ResultModel();
		try {
			String jsonstr = RequestUtil.getRequestPostData(request);
			request.setAttribute("rawjson", jsonstr);
			transorder = RequestUtil.convertJson2Obj(jsonstr, BaseTransVO.class,MyBidderAuthInfoBodyVO.class);
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
		rnr.setMethod("/myBidder/authInfo/getLegalPersonInfo_apply");
		BidderLegalPerson legalPerson = new BidderLegalPerson();
		try {
			Token token = tokenSrv.getToken(transorder.getBody().getToken(), transorder.getApp().getAppId());
			if (token == null) {
				log.error(String.format("token[%s]验证失败,或已过期,请重新登录", transorder.getBody().getToken()));
				throw new TokenException("token验证失败,或已过期,请重新登录");
			}
			
			legalPerson = myBidderService.getLegalPersonInfo_apply(token);
			
//						baseInfo.put("creditRatingIcon", aa.getUnified_social_credit_code_url());
//			rm.put("legalPerson", JsonUtil.convert2Json(legalPerson));
	
			rm.put("legalPerson", legalPerson);
			
			
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
	 * 查询保存的投标人公司注册信息接口
	 * @author YJY
	 * @since 2015年11月10日16:25:40
	 * @return
	 */
	@RequestMapping(value="/getRegisteredInfo_apply",method=RequestMethod.POST)
	@AccessRequered(methodName = "查询保存的投标人公司注册信息")
	// 框架的日志处理
	public @ResponseBody ResultModel getRegisteredInfo_apply(HttpServletRequest request,
			HttpServletResponse response) {
		String messagebase = "查询保存的投标人公司注册信息";
		int basecode = 0;
		BaseTransVO<MyBidderAuthInfoBodyVO> transorder = null;
		ResultModel rm = new ResultModel();
		try {
			String jsonstr = RequestUtil.getRequestPostData(request);
			request.setAttribute("rawjson", jsonstr);
			transorder = RequestUtil.convertJson2Obj(jsonstr, BaseTransVO.class,MyBidderAuthInfoBodyVO.class);
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
		rnr.setMethod("/myBidder/authInfo/getRegisteredInfo_apply");
		BidderRegisteredInfo registeredInfo = new BidderRegisteredInfo();
		try {// 业务数据必填等校验
			Token token = tokenSrv.getToken(transorder.getBody().getToken(), transorder.getApp().getAppId());
			if (token == null) {
				log.error(String.format("token[%s]验证失败,或已过期,请重新登录", transorder.getBody().getToken()));
				throw new TokenException("token验证失败,或已过期,请重新登录");
			}
			
			registeredInfo = myBidderService.getRegisteredInfo_apply(token);	
			rm.put("registeredInfo", registeredInfo);
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
	 * 查询保存的投标人开户行信息接口
	 * @author YJY
	 * @since 2015年11月10日16:25:47
	 * @return
	 */
	@RequestMapping(value="/getBankInfo_apply",method=RequestMethod.POST)
	@AccessRequered(methodName = "查询保存的投标人开户行信息")
	// 框架的日志处理
	public @ResponseBody ResultModel getBankInfo_apply(HttpServletRequest request,
			HttpServletResponse response) {
		String messagebase = "查询保存的投标人开户行信息";
		int basecode = 0;
		BaseTransVO<MyBidderAuthInfoBodyVO> transorder = null;
		ResultModel rm = new ResultModel();
		try {
			String jsonstr = RequestUtil.getRequestPostData(request);
			request.setAttribute("rawjson", jsonstr);
			transorder = RequestUtil.convertJson2Obj(jsonstr, BaseTransVO.class,MyBidderAuthInfoBodyVO.class);
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
		rnr.setMethod("/myBidder/authInfo/getBankInfo_apply");
		
		BidderBankInfo bankInfo =new BidderBankInfo();
		try {// 业务数据必填等校验
			Token token = tokenSrv.getToken(transorder.getBody().getToken(), transorder.getApp().getAppId());
			if (token == null) {
				log.error(String.format("token[%s]验证失败,或已过期,请重新登录", transorder.getBody().getToken()));
				throw new TokenException("token验证失败,或已过期,请重新登录");
			}
			
			bankInfo = myBidderService.getBankInfo_apply(token);
			rm.put("bankInfo", bankInfo);
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
	 * 查询保存的投标人企业资质接口
	 * @author YJY
	 * @since 2015年11月10日16:25:47
	 * @return
	 */
	@RequestMapping(value="/getEnterpriseQualification",method=RequestMethod.POST)
	@AccessRequered(methodName = "查询保存的投标人企业资质")
	// 框架的日志处理
	public @ResponseBody ResultModel getEnterpriseQualification(HttpServletRequest request,
			HttpServletResponse response) {
		String messagebase = "查询保存的投标人企业资质";
		int basecode = 0;
		BaseTransVO<MyBidderAuthInfoBodyVO> transorder = null;
		ResultModel rm = new ResultModel();
		try {
			String jsonstr = RequestUtil.getRequestPostData(request);
			request.setAttribute("rawjson", jsonstr);
			transorder = RequestUtil.convertJson2Obj(jsonstr, BaseTransVO.class,MyBidderAuthInfoBodyVO.class);
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
		rnr.setMethod("/myBidder/authInfo/getEnterpriseQualification");
		
		try {
			// 业务数据必填等校验
			Token token = tokenSrv.getToken(transorder.getBody().getToken(), transorder.getApp().getAppId());
			if (token == null) {
				log.error(String.format("token[%s]验证失败,或已过期,请重新登录", transorder.getBody().getToken()));
				throw new TokenException("token验证失败,或已过期,请重新登录");
			}
			
			List<BidderEqInfo> aa = myBidderService.getEnterpriseQualification(token);

			rm.put("eqInfo", aa);
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
	 * 查询投标人认证申请详情接口
	 * @author YJY
	 * @since 2015年11月10日16:25:55 
	 * @return
	 */
	@RequestMapping(value="/getApplication",method=RequestMethod.POST)
	@AccessRequered(methodName = "查询投标人认证申请详情")
	// 框架的日志处理
	public @ResponseBody ResultModel getApplication(HttpServletRequest request,
			HttpServletResponse response) {
		String messagebase = "查询投标人认证申请详情";
		int basecode = 0;
		BaseTransVO<MyBidderAuthInfoBodyVO> transorder = null;
		ResultModel rm = new ResultModel();
		try {
			String jsonstr = RequestUtil.getRequestPostData(request);
			request.setAttribute("rawjson", jsonstr);
			transorder = RequestUtil.convertJson2Obj(jsonstr, BaseTransVO.class,MyBidderAuthInfoBodyVO.class);
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
		rnr.setMethod("/myBidder/authInfo/getApplication");
//		String token = transorder.getBody().getToken();
		try {
			// 业务数据必填等校验
			Token token = tokenSrv.getToken(transorder.getBody().getToken(), transorder.getApp().getAppId());
			if (token == null) {
				log.error(String.format("token[%s]验证失败,或已过期,请重新登录", transorder.getBody().getToken()));
				throw new TokenException("token验证失败,或已过期,请重新登录");
			}
			
			//基本信息
			BidderBaseInfo baseInfo = new BidderBaseInfo();
			baseInfo = myBidderService.getBaseInfo_apply(token);
			//法人信息
			BidderLegalPerson legalPerson = new BidderLegalPerson();
			legalPerson = myBidderService.getLegalPersonInfo_apply(token);
			//公司注册信息
			BidderRegisteredInfo registeredInfo = new BidderRegisteredInfo();
			registeredInfo = myBidderService.getRegisteredInfo_apply(token);
			//开户行信息
			BidderBankInfo bankInfo = new BidderBankInfo();
			bankInfo = myBidderService.getBankInfo_apply(token);
			
			List<BidderEqInfo> eqInfo = new ArrayList<BidderEqInfo>();
			eqInfo = myBidderService.getEnterpriseQualification(token);
			rm.put("baseInfo", baseInfo);
			rm.put("legalPerson", legalPerson);
			rm.put("registeredInfo", registeredInfo);			
			rm.put("bankInfo", bankInfo);
			rm.put("eqInfo", eqInfo);
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
	 * 保存投标人基本信息接口
	 * @author YJY
	 * @since 2015年11月10日16:26:14
	 * @return
	 */
	@RequestMapping(value="/saveBaseInfo_apply",method=RequestMethod.POST)
	@Transactional(propagation=Propagation.REQUIRED,rollbackFor=Exception.class,value="txManager")
	public @ResponseBody ResultModel saveBaseInfo_apply(HttpServletRequest request,HttpServletResponse response) {
//		int basecode = 2341210;//待定
		String messagebase = "保存投标人基本信息";
		BidderCerticateSaveInfoVO transorder = null;
		ResultModel rm = new ResultModel();
//		rm.setBaseErrorCode(basecode);
		try {
			String jsonstr  = RequestUtil.getRequestPostData(request);
			request.setAttribute("rawjson", jsonstr);
			transorder = RequestUtil.convertJson2Obj(jsonstr, BidderCerticateSaveInfoVO.class);
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
		rnr.setMethod("/myBidder/authInfo/saveBaseInfo_apply");
		
//	    "logoUrl":"LOGO_IMAGE_URL"
//            "companyName":"深圳蜂鸟娱乐技术有限公司",
//            "shortName":"蜂鸟娱乐",
//            "description":"公司简介",
//            "registeredCapital":"",
//            "telephone":"",
//            "email":""
		
		try {
		
		// 业务数据必填等校验
		Token token = tokenSrv.getToken(transorder.getBody().getToken(), transorder.getApp().getAppId());
		if (token == null) {
			log.error(String.format("token[%s]验证失败,或已过期,请重新登录", transorder.getBody().getToken()));
			throw new TokenException("token验证失败,或已过期,请重新登录");
		}
		int i= 0;
		
		i= myBidderService.saveBaseInfo_apply(transorder.getApp().getAppId(), transorder.getBody().getBaseInfo(), token);

		if(i<= 0){
			rm.setErrmsg("数据未修改！");
		}else{
			rm.setErrmsg(messagebase + "成功");
		}
		tokenSrv.postponeToken(token);
//		activityService.JoinActivity(activityId,unionId,parentName,mobileNum,babyName,babySex,babyBirthday,city,district);
		} catch (Exception e1) {
			log.error(String.format(messagebase+"失败"),e1);
			rm.mergeException(e1);
			rm.setErrmsg(e1.getMessage());
		}
		return rm;
	}  
	
	/**
	 * 保存投标人法人信息接口
	 * @author YJY
	 * @since 2015年11月10日16:26:23
	 * @return
	 */
	@RequestMapping(value="/saveLegalPersonInfo_apply",method=RequestMethod.POST)
	@Transactional(propagation=Propagation.REQUIRED,rollbackFor=Exception.class,value="txManager")
	public @ResponseBody ResultModel saveLegalPersonInfo_apply(HttpServletRequest request,HttpServletResponse response) {
//		int basecode = 2341210;//待定
		String messagebase = "保存投标人法人信息";
		BidderCerticateSaveInfoVO transorder = null;
		ResultModel rm = new ResultModel();
//		rm.setBaseErrorCode(basecode);
		try {
			String jsonstr  = RequestUtil.getRequestPostData(request);
			request.setAttribute("rawjson", jsonstr);
			transorder = RequestUtil.convertJson2Obj(jsonstr, BidderCerticateSaveInfoVO.class);
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
		rnr.setMethod("/myBidder/authInfo/saveLegalPersonInfo_apply");
		
//	    "logoUrl":"LOGO_IMAGE_URL"
//            "companyName":"深圳蜂鸟娱乐技术有限公司",
//            "shortName":"蜂鸟娱乐",
//            "description":"公司简介",
//            "registeredCapital":"",
//            "telephone":"",
//            "email":""
		
		try {
			// 业务数据必填等校验
			Token token = tokenSrv.getToken(transorder.getBody().getToken(), transorder.getApp().getAppId());
			if (token == null) {
				log.error(String.format("token[%s]验证失败,或已过期,请重新登录", transorder.getBody().getToken()));
				throw new TokenException("token验证失败,或已过期,请重新登录");
			}
			int i= 0;
			
			i= myBidderService.saveLegalPersonInfo_apply(transorder.getApp().getAppId(), transorder.getBody().getLegalPerson(), token);
			
	
		
			if(i<= 0){
				rm.setErrmsg("数据未修改！");
			}else{
				rm.setErrmsg(messagebase + "成功");
			}
			tokenSrv.postponeToken(token);
//		activityService.JoinActivity(activityId,unionId,parentName,mobileNum,babyName,babySex,babyBirthday,city,district);
		} catch (Exception e1) {
			log.error(String.format(messagebase+"失败"),e1);
			rm.mergeException(e1);
			rm.setErrmsg(e1.getMessage());
		}
		return rm;
	}  
	/**
	 * 保存投标人注册信息接口
	 * @author YJY
	 * @since 2015年11月10日16:26:33
	 * @return
	 */
	@RequestMapping(value="/saveRegisteredInfo_apply",method=RequestMethod.POST)
	@Transactional(propagation=Propagation.REQUIRED,rollbackFor=Exception.class,value="txManager")
	public @ResponseBody ResultModel saveRegisteredInfo_apply(HttpServletRequest request,HttpServletResponse response) {
//		int basecode = 2341210;//待定
		String messagebase = "保存投标人公司注册信息";
		BidderCerticateSaveInfoVO transorder = null;
		ResultModel rm = new ResultModel();
//		rm.setBaseErrorCode(basecode);
		try {
			String jsonstr  = RequestUtil.getRequestPostData(request);
			request.setAttribute("rawjson", jsonstr);
			transorder = RequestUtil.convertJson2Obj(jsonstr, BidderCerticateSaveInfoVO.class);
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
		rnr.setMethod("/myBidder/authInfo/saveRegisteredInfo_apply");
//		"registeredInfo":{
//            "businessLicenseNum":"BUSINESS_LICENSE_NUM",
//            "businessLicenseUrl":"BUSINESS_LICENSE_URL",
//            "taxRegistrationNum":"TAX_REGISTRATION_NUM",
//            "taxRegistrationUrl":"TAX_REGISTRATION_URL",
//            "organizationCodeNum":"ORGANIZATION_CODE_NUM",
//            "organizationCodeUrl":"ORGANIZATION_CODE_URL"
//            "businessScope":"经营范围",
//            "regTime":"2014-04-05",
//            "businessLicenseExpireTime":"10年",
//            "address":"",
//            "businessLicenseType":"OLD",
//            "newBusinessLicenseNum":"",
//            "newBusinessLicenseUrl":"",
//       }       
		
		try {// 业务数据必填等校验
			Token token = tokenSrv.getToken(transorder.getBody().getToken(), transorder.getApp().getAppId());
			if (token == null) {
				log.error(String.format("token[%s]验证失败,或已过期,请重新登录", transorder.getBody().getToken()));
				throw new TokenException("token验证失败,或已过期,请重新登录");
			}
			int i= 0;
			
			i= myBidderService.saveRegisteredInfo(transorder.getApp().getAppId(), transorder.getBody().getRegisteredInfo(), token);
			if(i<= 0){
				rm.setErrmsg("数据未修改！");
			}else{
				rm.setErrmsg(messagebase + "成功");
			}
			tokenSrv.postponeToken(token);
//		activityService.JoinActivity(activityId,unionId,parentName,mobileNum,babyName,babySex,babyBirthday,city,district);
		} catch (Exception e1) {
			log.error(String.format(messagebase+"失败"),e1);
			rm.mergeException(e1);
			rm.setErrmsg(e1.getMessage());
		}
		return rm;
	}  
	
	/**
	 * 保存投标人开户行信息接口
	 * @author YJY
	 * @since 2015年11月10日16:26:42
	 * @return
	 */
	@RequestMapping(value="/saveBankInfo",method=RequestMethod.POST)
	@Transactional(propagation=Propagation.REQUIRED,rollbackFor=Exception.class,value="txManager")
	public @ResponseBody ResultModel saveBankInfo_apply(HttpServletRequest request,HttpServletResponse response) {
//		int basecode = 2341210;//待定
		String messagebase = "保存投标人开户行信息";
		BidderCerticateSaveInfoVO transorder = null;
		ResultModel rm = new ResultModel();
//		rm.setBaseErrorCode(basecode);
		try {
			String jsonstr  = RequestUtil.getRequestPostData(request);
			request.setAttribute("rawjson", jsonstr);
			transorder = RequestUtil.convertJson2Obj(jsonstr, BidderCerticateSaveInfoVO.class);
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
		rnr.setMethod("/myBidder/authInfo/saveBankInfo_apply");
//		"bankInfo":{ 
//            "bank":"招商银行深圳支行",
//            "accountId":"1234567812345678",
//            "accountName":"深圳麦圈互动技术有限公司"
//        }
		
		try {// 业务数据必填等校验
			Token token = tokenSrv.getToken(transorder.getBody().getToken(), transorder.getApp().getAppId());
			if (token == null) {
				log.error(String.format("token[%s]验证失败,或已过期,请重新登录", transorder.getBody().getToken()));
				throw new TokenException("token验证失败,或已过期,请重新登录");
			}
			int i= 0;
			
			i= myBidderService.saveBankInfo(transorder.getApp().getAppId(), transorder.getBody().getBankInfo(), token);
			if(i<= 0){
				rm.setErrmsg("数据未修改！");
			}else{
				rm.setErrmsg(messagebase + "成功");
			}
			tokenSrv.postponeToken(token);
//		activityService.JoinActivity(activityId,unionId,parentName,mobileNum,babyName,babySex,babyBirthday,city,district);
		} catch (Exception e1) {
			log.error(String.format(messagebase+"失败"),e1);
			rm.mergeException(e1);
			rm.setErrmsg(e1.getMessage());
		}
		return rm;
	}  
	
	/**
	 * 保存投标人企业资质接口
	 * @author YJY
	 * @since 2015年11月11日17:10:23
	 * @return
	 */
	@RequestMapping(value="/saveEnterpriseQualification",method=RequestMethod.POST)
	public @ResponseBody ResultModel saveEnterpriseQualification(HttpServletRequest request,HttpServletResponse response) {
//		int basecode = 2341210;//待定
		String messagebase = "保存投标人企业资质";
		BidderCerticateSaveInfoVO transorder = null;
		ResultModel rm = new ResultModel();
//		rm.setBaseErrorCode(basecode);
		try {
			String jsonstr  = RequestUtil.getRequestPostData(request);
			request.setAttribute("rawjson", jsonstr);
			transorder = RequestUtil.convertJson2Obj(jsonstr, BidderCerticateSaveInfoVO.class);
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
		rnr.setMethod("/myBidder/authInfo/saveEnterpriseQualification");
/*		"eqInfo":[{
            "工程类别":"1##",
            "eqName":"桩工程一级资质",
            "eqRating":"1",
            "eqId":3,
            "eqDesc":"桩工程一级资质",
            "expiryDate":"2016-09-12"
        }]
*/
		
		try {
		List<BidderEqInfo>  eqInfos =  transorder.getBody().getEqInfo();
		// 业务数据必填等校验
			Token token = tokenSrv.getToken(transorder.getBody().getToken(), transorder.getApp().getAppId());
			if (token == null) {
				log.error(String.format("token[%s]验证失败,或已过期,请重新登录", transorder.getBody().getToken()));
				throw new TokenException("token验证失败,或已过期,请重新登录");
			}

		
			int i= 0;
			
			i = myBidderService.saveEnterpriseQualification(transorder.getApp().getAppId(), eqInfos, token);
			
			if(i<= 0){
				rm.setErrmsg("数据未修改！");
			}else{
				rm.setErrmsg(messagebase + "成功");
			}
			tokenSrv.postponeToken(token);
//		activityService.JoinActivity(activityId,unionId,parentName,mobileNum,babyName,babySex,babyBirthday,city,district);
		} catch (Exception e1) {
			log.error(String.format(messagebase+"失败"),e1);
			rm.mergeException(e1);
			rm.setErrmsg(e1.getMessage());
		}
		return rm;
		
	}  
	
	/**
	 * 提交投标人认证申请接口
	 * @author YJY
	 * @since 2015年11月10日16:26:49
	 * @return
	 */
	@RequestMapping(value="/applay",method=RequestMethod.POST)
	@Transactional(propagation=Propagation.REQUIRED,rollbackFor=Exception.class,value="txManager")
	public @ResponseBody ResultModel applay(HttpServletRequest request,HttpServletResponse response) {
//		int basecode = 2341210;//待定
		String messagebase = "提交投标人认证申请";
		MyBidderAuthInfoApplyVO transorder = null;
		ResultModel rm = new ResultModel();
//		rm.setBaseErrorCode(basecode);
		try {
			String jsonstr  = RequestUtil.getRequestPostData(request);
			request.setAttribute("rawjson", jsonstr);
			transorder = RequestUtil.convertJson2Obj(jsonstr, MyBidderAuthInfoApplyVO.class);
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
		rnr.setMethod("/myBidder/authInfo/applay");
		
		
		try {
			// 业务数据必填等校验
				Token token = tokenSrv.getToken(transorder.getBody().getToken(), transorder.getApp().getAppId());
				if (token == null) {
					log.error(String.format("token[%s]验证失败,或已过期,请重新登录", transorder.getBody().getToken()));
					throw new TokenException("token验证失败,或已过期,请重新登录");
				}
				int i= 0;
				
				i = myBidderService.applay(transorder.getApp().getAppId() , token);
				
				if(i<= 0){
					rm.setErrmsg("数据未修改！");
				}else{
					rm.setErrmsg(messagebase + "成功");
				}
				tokenSrv.postponeToken(token);
//		activityService.JoinActivity(activityId,unionId,parentName,mobileNum,babyName,babySex,babyBirthday,city,district);
		} catch (Exception e1) {
			log.error(String.format(messagebase+"失败"),e1);
			rm.mergeException(e1);
			rm.setErrmsg(e1.getMessage());
		}
		return rm;
	}  
	
	/**
	 * 投标人认证审核接口
	 * @author YJY
	 * @since 2015-11-18 16:48:09
	 * @return
	 */
	@RequestMapping(value="/checkApplication",method=RequestMethod.POST)
	@Transactional(propagation=Propagation.REQUIRED,rollbackFor=Exception.class,value="txManager")
	public @ResponseBody ResultModel checkApplication(HttpServletRequest request,HttpServletResponse response) {
//		int basecode = 2341210;//待定
		String messagebase = "提交投标人认证审核结果";
		BidderAuditInfoVO transorder = null;
		ResultModel rm = new ResultModel();
//		rm.setBaseErrorCode(basecode);
		try {
			String jsonstr  = RequestUtil.getRequestPostData(request);
			request.setAttribute("rawjson", jsonstr);
			transorder = RequestUtil.convertJson2Obj(jsonstr, BidderAuditInfoVO.class);
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
		rnr.setMethod("/myBidder/authInfo/checkApplication");
		
		
		try {
			boolean flag = false;
			BidderBaseInfoCheck bic = transorder.getBody().getBaseInfoCheck();
			
			ValidateUtil.assertNull(bic, "参数baseInfoCheck不能为空!");
			ValidateUtil.assertNull(bic.getBidder_id(), "参数bidder_id不能为空!");
			
			flag = myBidderService.checkApplication(transorder.getApp().getAppId(), transorder.getBody(), transorder.getBody().getBaseInfoCheck().getBidder_id());
				
		
//				int i= 0;
//				
//				i= myBidderService.applay(transorder.getApp().getAppId(), token);
//				if(i<= 0){
//					rm.setErrmsg("数据未修改！");
//				}else{
//					rm.setErrmsg(messagebase + "成功");
//				}
//		activityService.JoinActivity(activityId,unionId,parentName,mobileNum,babyName,babySex,babyBirthday,city,district);
		} catch (Exception e1) {
			log.error(String.format(messagebase+"失败"),e1);
			rm.mergeException(e1);
			rm.setErrmsg(e1.getMessage());
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
