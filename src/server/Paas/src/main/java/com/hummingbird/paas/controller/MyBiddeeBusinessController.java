package com.hummingbird.paas.controller;
/**
 * @author YJY 
 * @since 2015年10月29日13:04:12
 * 招标人业务
 * */

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.ObjectUtils;
import org.apache.commons.lang.StringUtils;
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
import com.hummingbird.common.util.JsonUtil;
import com.hummingbird.common.util.RequestUtil;
import com.hummingbird.common.util.ValidateUtil;
import com.hummingbird.common.vo.ResultModel;
import com.hummingbird.commonbiz.exception.TokenException;
import com.hummingbird.commonbiz.vo.BaseTransVO;
import com.hummingbird.commonbiz.vo.UserToken;
import com.hummingbird.paas.entity.AppLog;
import com.hummingbird.paas.entity.BiddeeBankAduit;
import com.hummingbird.paas.entity.BiddeeCerticate;
import com.hummingbird.paas.entity.BiddeeCertificateAduit;
import com.hummingbird.paas.entity.BiddeeCredit;
import com.hummingbird.paas.entity.ScoreLevel;
import com.hummingbird.paas.entity.Token;
import com.hummingbird.paas.mapper.AppLogMapper;
import com.hummingbird.paas.mapper.BidObjectMapper;
import com.hummingbird.paas.mapper.BiddeeBankAduitMapper;
import com.hummingbird.paas.mapper.BiddeeBidCreditScoreMapper;
import com.hummingbird.paas.mapper.BiddeeCerticateMapper;
import com.hummingbird.paas.mapper.BiddeeCertificateAduitMapper;
import com.hummingbird.paas.mapper.BiddeeCreditMapper;
import com.hummingbird.paas.mapper.ScoreLevelMapper;
import com.hummingbird.paas.services.MyBiddeeService;
import com.hummingbird.paas.services.TokenService;
import com.hummingbird.paas.vo.BiddeeAuditInfoVO;
import com.hummingbird.paas.vo.BiddeeAuthInfo;
import com.hummingbird.paas.vo.BiddeeBankInfo;
import com.hummingbird.paas.vo.BiddeeBaseInfo;
import com.hummingbird.paas.vo.BiddeeBaseInfoCheck;
import com.hummingbird.paas.vo.BiddeeCerticateSaveInfoVO;
import com.hummingbird.paas.vo.BiddeeLegalPerson;
import com.hummingbird.paas.vo.BiddeeRegisteredInfo;
import com.hummingbird.paas.vo.MyBiddeeAuthInfoApplyVO;
import com.hummingbird.paas.vo.MyBiddeeAuthInfoBodyVO;
import com.hummingbird.paas.vo.QueryObjectIndexSurveyResult;
@Controller
@RequestMapping(value="/myBiddee/authInfo"
		 ,method=RequestMethod.POST)
@JsonIgnoreProperties(ignoreUnknown = true)
public class MyBiddeeBusinessController extends BaseController  {
	@Autowired
	protected MyBiddeeService myBiddeeService;
	@Autowired
	protected BiddeeCerticateMapper biddeeCerticateDao;
	@Autowired
	protected BiddeeCertificateAduitMapper biddeeCertificateAduitDao;
	@Autowired
	protected BiddeeCreditMapper biddeeCreditDao;
	@Autowired
	protected BiddeeBidCreditScoreMapper biddeeBidCreditScoreDao;
	@Autowired
	protected BiddeeBankAduitMapper biddeeBankAduitDao;
	@Autowired
	protected BidObjectMapper bidObjectDao;
	@Autowired
	protected ScoreLevelMapper scoreLevelDao;
	@Autowired
	TokenService tokenSrv;
	@Autowired(required = true)
	protected AppLogMapper applogDao;
	
	
	@RequestMapping(value="/getAuthInfo",method=RequestMethod.POST)
	@AccessRequered(methodName = "查询我的招标人认证信息")
	// 框架的日志处理
	public @ResponseBody ResultModel getAuthInfo(HttpServletRequest request,
			HttpServletResponse response) {
		String messagebase = "查询我的招标人认证信息";
		int basecode = 0;
		BaseTransVO<MyBiddeeAuthInfoBodyVO> transorder = null;
		ResultModel rm = new ResultModel();
		try {
			String jsonstr = RequestUtil.getRequestPostData(request);
			request.setAttribute("rawjson", jsonstr);
			transorder = RequestUtil.convertJson2Obj(jsonstr, BaseTransVO.class,MyBiddeeAuthInfoBodyVO.class);
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
		rnr.setMethod("/myBiddee/authInfo/getAuthInfo");
		
		try {
			// 业务数据必填等校验
			Token token = tokenSrv.getToken(transorder.getBody().getToken(), transorder.getApp().getAppId());
			if (token == null) {
				log.error(String.format("token[%s]验证失败,或已过期,请重新登录", transorder.getBody().getToken()));
				throw new TokenException("token验证失败,或已过期,请重新登录");
			}
				BiddeeCerticate   biddee = biddeeCerticateDao.selectByUserId(token.getUserId());
				
				Map overall= new HashMap();//积分和信用等级信息
				Map detail= new HashMap();//详细信息
				Map baseInof= new HashMap();//基础信息
				Map tradeInfo= new HashMap();//交易信息
				Map myBiddeeInfo= new HashMap();//企业信息
				BiddeeAuthInfo personalInfo = new BiddeeAuthInfo();
				BiddeeAuthInfo baseInfo = new BiddeeAuthInfo();
				BiddeeAuthInfo legalPersonInfo = new BiddeeAuthInfo();
				BiddeeAuthInfo companyRegisteredInfo = new BiddeeAuthInfo();
				BiddeeAuthInfo bankInfo = new BiddeeAuthInfo();
				BiddeeAuthInfo biddeeNum = new BiddeeAuthInfo();
				BiddeeAuthInfo tradeAmount = new BiddeeAuthInfo();
				BiddeeAuthInfo ba = new BiddeeAuthInfo();
				BiddeeAuthInfo baa = new BiddeeAuthInfo();
				
				BiddeeCertificateAduit p = new BiddeeCertificateAduit();
				BiddeeCertificateAduit bi = new BiddeeCertificateAduit();
				BiddeeCertificateAduit lp = new BiddeeCertificateAduit();
				BiddeeCertificateAduit cr = new BiddeeCertificateAduit();
				BiddeeBankAduit bba = new BiddeeBankAduit();
				ScoreLevel bb  = new ScoreLevel();
			
			if(biddee != null){
				BiddeeCredit aa = biddeeCreditDao.selectByUserId(biddee.getId());
//				 bb = scoreLevelDao.countLevelByScore(aa.getCreditScore()!=null?aa.getCreditScore():0);
				
					 bb = scoreLevelDao.countLevelByScore(aa==null?0:(aa.getCreditScore()!=null?aa.getCreditScore():0));
					 p = biddeeCertificateAduitDao.selectPersonalInfo(biddee.getId());
					 bi = biddeeCertificateAduitDao.selectBaseInfo(biddee.getId());
					 lp = biddeeCertificateAduitDao.selectLegalPersonInfo(biddee.getId());
					 cr = biddeeCertificateAduitDao.selectCompanyRegisteredInfo(biddee.getId());
					 bba = biddeeBankAduitDao.selectByBcId(biddee.getId());
					 
					//1.个人状态、积分信息
					 personalInfo.setCreditScore(aa==null?0:(aa.getCreditScore()!=null?aa.getCreditScore():0));
					 if("APY".equalsIgnoreCase(biddee.getStatus())){
						 personalInfo.setStatus("待审核");
					 }else if("OK#".equalsIgnoreCase(biddee.getStatus())){
								personalInfo.setStatus("已认证");
					 }else if("FLS".equalsIgnoreCase(biddee.getStatus())){
						 if(p!=null){
								personalInfo.setStatus("已认证");
							}else{
								personalInfo.setStatus("认证不通过");
							}
					 }
						
						baseInof.put("personalInfo", personalInfo);
						detail.put("baseInof", baseInof);
//						baseInof.clear();
						baseInfo.setCreditScore(aa==null?0:(aa.getBaseinfoCreditScore()!=null?aa.getBaseinfoCreditScore():0));
						//2.基本状态、积分信息
						if("APY".equalsIgnoreCase(biddee.getStatus())){
							baseInfo.setStatus("待审核");
						 }else if("OK#".equalsIgnoreCase(biddee.getStatus())){
									baseInfo.setStatus("已认证");
						 }else if("FLS".equalsIgnoreCase(biddee.getStatus())){
							 if(bi!=null){
								 baseInfo.setStatus("已认证");
								}else{
									baseInfo.setStatus("认证不通过");
								}
						 }
						
						myBiddeeInfo.put("baseInfo", baseInfo);
						//3.法人状态、积分信息
						if("APY".equalsIgnoreCase(biddee.getStatus())){
							legalPersonInfo.setStatus("待审核");
						 }else if("OK#".equalsIgnoreCase(biddee.getStatus())){
									legalPersonInfo.setStatus("已认证");
						 }else if("FLS".equalsIgnoreCase(biddee.getStatus())){
							 if(lp!=null){
								 legalPersonInfo.setStatus("已认证");
								}else{
									legalPersonInfo.setStatus("认证不通过");
								}
						 }
						
						legalPersonInfo.setCreditScore(aa==null?0:(aa.getLegalPersonInfo()!=null?aa.getLegalPersonInfo():0));
						myBiddeeInfo.put("legalPersonInfo", legalPersonInfo);
						//4.公司注册状态、积分信息
						if("APY".equalsIgnoreCase(biddee.getStatus())){
							companyRegisteredInfo.setStatus("待审核");
						 }else if("OK#".equalsIgnoreCase(biddee.getStatus())){
									companyRegisteredInfo.setStatus("已认证");
						 }else if("FLS".equalsIgnoreCase(biddee.getStatus())){
							 if(cr!=null){
								 companyRegisteredInfo.setStatus("已认证");
								}else{
									companyRegisteredInfo.setStatus("认证不通过");
								}
						 }
						
						companyRegisteredInfo.setCreditScore(aa==null?0:(aa.getCompanyRegisteredInfo()!=null?aa.getCompanyRegisteredInfo():0));
						myBiddeeInfo.put("companyRegisteredInfo", companyRegisteredInfo);
						//5.开户行 状态、积分信息
						if("APY".equalsIgnoreCase(biddee.getStatus())){
							bankInfo.setStatus("待审核");
						 }else if("OK#".equalsIgnoreCase(biddee.getStatus())){
							 if(bba!=null&&"OK#".equalsIgnoreCase(bba.getBankcardCertificateResult())){
									bankInfo.setStatus("已认证");
								}else if(bba!=null&&"FLS".equalsIgnoreCase(bba.getBankcardCertificateResult())){
									bankInfo.setStatus("认证不通过");
								}else{
									bankInfo.setStatus("认证中");
								}
						 }else if("FLS".equalsIgnoreCase(biddee.getStatus())){
							 if(bba!=null&&"OK#".equalsIgnoreCase(bba.getBankcardCertificateResult())){
									bankInfo.setStatus("已认证");
								}else if(bba!=null&&"FLS".equalsIgnoreCase(bba.getBankcardCertificateResult())){
									bankInfo.setStatus("认证不通过");
								}else{
									bankInfo.setStatus("认证中");
								}
						 }
						
						bankInfo.setCreditScore(aa==null?0:(aa.getBankInfo()!=null?aa.getBankInfo():0));
						myBiddeeInfo.put("bankInfo", bankInfo);
						QueryObjectIndexSurveyResult bis = bidObjectDao.selectObjectIndexSurvey();
						if(bis != null){
							biddeeNum.setStatus(ObjectUtils.toString(bis.getObjectNum()));
							biddeeNum.setCreditScore(bis.getObjectNum()*10);//按照次数乘以10
							tradeAmount.setStatus(ObjectUtils.toString(bis.getAmount()));
							tradeAmount.setCreditScore(20);
						}else{
							biddeeNum.setStatus("0");
							biddeeNum.setCreditScore(0);//按照次数乘以10
							tradeAmount.setStatus("0");
							tradeAmount.setCreditScore(0);
						}
						
						tradeInfo.put("biddeeNum", biddeeNum);
//						Long amount = bidObjectDao.countAmountByBid(biddee.getId(),null);
						
						tradeInfo.put("tradeAmount", tradeAmount);
						detail.put("myBiddeeInfo", myBiddeeInfo);
						detail.put("tradeInfo", tradeInfo);
					
					overall.put("creditScore", aa==null?0:(aa.getCreditScore()!=null?aa.getCreditScore():0));
					
				if(bb!= null){
					overall.put("creditRating", StringUtils.defaultIfEmpty(bb.getLevelName(), "A"));
					overall.put("creditRatingIcon", bb.getIcon());
				}else{
					overall.put("creditRating", "A");
					overall.put("creditRatingIcon", null);
				}
				
				
				rm.put("overall", overall);
				rm.put("detail", detail);
			}else{
				//1.个人状态、积分信息
				ba.setCreditScore(0);
				
				ba.setStatus("未认证");
				
				baseInof.put("personalInfo", ba);
				detail.put("baseInof", baseInof);
//				baseInof.clear();
				
				myBiddeeInfo.put("baseInfo", ba);
				
				myBiddeeInfo.put("legalPersonInfo", ba);
				//4.公司注册状态、积分信息
				
				myBiddeeInfo.put("companyRegisteredInfo", ba);
				
				myBiddeeInfo.put("bankInfo", ba);
//				int num = biddeeBidCreditScoreDao.countNumByBid(aa.getTendererId());
				QueryObjectIndexSurveyResult bis = bidObjectDao.selectObjectIndexSurvey();
				if(bis != null){
					biddeeNum.setStatus(ObjectUtils.toString(bis.getObjectNum()));
					biddeeNum.setCreditScore(bis.getObjectNum()*10);//按照次数乘以10
					tradeAmount.setStatus(ObjectUtils.toString(bis.getAmount()));
					tradeAmount.setCreditScore(bis.getAmount()==0?0:20);
				}else{
					biddeeNum.setStatus("0");
					biddeeNum.setCreditScore(0);//按照次数乘以10
					tradeAmount.setStatus("0");
					tradeAmount.setCreditScore(0);
				}
				
				tradeInfo.put("biddeeNum", biddeeNum);
				
				tradeInfo.put("tradeAmount", tradeAmount);
				detail.put("myBiddeeInfo", myBiddeeInfo);
				detail.put("tradeInfo", tradeInfo);
				
				overall.put("creditScore", 0);
				overall.put("creditRating", "A");
				overall.put("creditRatingIcon", "");
				
				rm.put("overall", overall);
				rm.put("detail", detail);
			}
			
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
	

	@RequestMapping(value="/getBaseInfo_apply",method=RequestMethod.POST)
	@AccessRequered(methodName = "查询保存的招标人基本信息")
	// 框架的日志处理
	public @ResponseBody ResultModel getBaseInfo_apply(HttpServletRequest request,
			HttpServletResponse response) {
		String messagebase = "查询保存的招标人基本信息";
		int basecode = 0;
		BaseTransVO<MyBiddeeAuthInfoBodyVO> transorder = null;
		ResultModel rm = new ResultModel();
		try {
			String jsonstr = RequestUtil.getRequestPostData(request);
			request.setAttribute("rawjson", jsonstr);
			transorder = RequestUtil.convertJson2Obj(jsonstr, BaseTransVO.class,MyBiddeeAuthInfoBodyVO.class);
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
		rnr.setMethod("/myBiddee/authInfo/getBaseInfo_apply");
		BiddeeBaseInfo baseInfo = new BiddeeBaseInfo();
		try {
			// 业务数据必填等校验
//			UserToken token = tokenSrv.getOrCreateToken(transorder.getApp().getAppId(),46);
			Token token = tokenSrv.getToken(transorder.getBody().getToken(), transorder.getApp().getAppId());
			if (token == null) {
				log.error(String.format("token[%s]验证失败,或已过期,请重新登录", transorder.getBody().getToken()));
				throw new TokenException("token验证失败,或已过期,请重新登录");
			}
			
			baseInfo = myBiddeeService.getBaseInfo_apply(token);
			
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
	 * 查询保存的招标人法人信息接口
	 * @author YJY
	 * @since 2015年11月6日15:05:54
	 * @return
	 */
	@RequestMapping(value="/getLegalPersonInfo_apply",method=RequestMethod.POST)
	@AccessRequered(methodName = "查询保存的招标人法人信息")
	// 框架的日志处理
	public @ResponseBody ResultModel getLegalPersonInfo_apply(HttpServletRequest request,
			HttpServletResponse response) {
		String messagebase = "查询保存的招标人法人信息";
		int basecode = 0;
		BaseTransVO<MyBiddeeAuthInfoBodyVO> transorder = null;
		ResultModel rm = new ResultModel();
		try {
			String jsonstr = RequestUtil.getRequestPostData(request);
			request.setAttribute("rawjson", jsonstr);
			transorder = RequestUtil.convertJson2Obj(jsonstr, BaseTransVO.class,MyBiddeeAuthInfoBodyVO.class);
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
		rnr.setMethod("/myBiddee/authInfo/getLegalPersonInfo_apply");
		BiddeeLegalPerson legalPerson = new BiddeeLegalPerson();
		try {
			// 业务数据必填等校验
			Token token = tokenSrv.getToken(transorder.getBody().getToken(), transorder.getApp().getAppId());
			if (token == null) {
				log.error(String.format("token[%s]验证失败,或已过期,请重新登录", transorder.getBody().getToken()));
				throw new TokenException("token验证失败,或已过期,请重新登录");
			}
			
			legalPerson = myBiddeeService.getLegalPersonInfo_apply(token);
			
//						baseInfo.put("creditRatingIcon", aa.getUnified_social_credit_code_url());
//			rm.put("legalPerson", JsonUtil.convert2Json(legalPerson));
	
			rm.put("legalPerson", legalPerson);
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
	 * 查询保存的招标人公司注册信息接口
	 * @author YJY
	 * @since 2015年11月6日15:05:54
	 * @return
	 */
	@RequestMapping(value="/getRegisteredInfo_apply",method=RequestMethod.POST)
	@AccessRequered(methodName = "查询保存的招标人公司注册信息")
	// 框架的日志处理
	public @ResponseBody ResultModel getRegisteredInfo_apply(HttpServletRequest request,
			HttpServletResponse response) {
		String messagebase = "查询保存的招标人公司注册信息";
		int basecode = 0;
		BaseTransVO<MyBiddeeAuthInfoBodyVO> transorder = null;
		ResultModel rm = new ResultModel();
		try {
			String jsonstr = RequestUtil.getRequestPostData(request);
			request.setAttribute("rawjson", jsonstr);
			transorder = RequestUtil.convertJson2Obj(jsonstr, BaseTransVO.class,MyBiddeeAuthInfoBodyVO.class);
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
		rnr.setMethod("/myBiddee/authInfo/getRegisteredInfo_apply");
		BiddeeRegisteredInfo registeredInfo = new BiddeeRegisteredInfo();
		try {
			// 业务数据必填等校验
			Token token = tokenSrv.getToken(transorder.getBody().getToken(), transorder.getApp().getAppId());
			if (token == null) {
				log.error(String.format("token[%s]验证失败,或已过期,请重新登录", transorder.getBody().getToken()));
				throw new TokenException("token验证失败,或已过期,请重新登录");
			}
			
			registeredInfo = myBiddeeService.getRegisteredInfo_apply(token);	
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
	 * 查询保存的招标人开户行信息接口
	 * @author YJY
	 * @since 2015年11月6日15:05:54
	 * @return
	 */
	@RequestMapping(value="/getBankInfo_apply",method=RequestMethod.POST)
	@AccessRequered(methodName = "查询保存的招标人开户行信息")
	// 框架的日志处理
	public @ResponseBody ResultModel getBankInfo_apply(HttpServletRequest request,
			HttpServletResponse response) {
		String messagebase = "查询保存的招标人开户行信息";
		int basecode = 0;
		BaseTransVO<MyBiddeeAuthInfoBodyVO> transorder = null;
		ResultModel rm = new ResultModel();
		try {
			String jsonstr = RequestUtil.getRequestPostData(request);
			request.setAttribute("rawjson", jsonstr);
			transorder = RequestUtil.convertJson2Obj(jsonstr, BaseTransVO.class,MyBiddeeAuthInfoBodyVO.class);
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
		rnr.setMethod("/myBiddee/authInfo/getBankInfo_apply");
		BiddeeBankInfo bankInfo = new BiddeeBankInfo();
		try {
			// 业务数据必填等校验
			Token token = tokenSrv.getToken(transorder.getBody().getToken(), transorder.getApp().getAppId());
			if (token == null) {
				log.error(String.format("token[%s]验证失败,或已过期,请重新登录", transorder.getBody().getToken()));
				throw new TokenException("token验证失败,或已过期,请重新登录");
			}
			
			bankInfo = myBiddeeService.getBankInfo_apply(token);
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
	 * 查询招标人认证申请详情接口
	 * @author YJY
	 * @since 2015年11月6日15:05:54
	 * @return
	 */
	@RequestMapping(value="/getApplication",method=RequestMethod.POST)
	@AccessRequered(methodName = "查询招标人认证申请详情")
	// 框架的日志处理
	public @ResponseBody ResultModel getApplication(HttpServletRequest request,
			HttpServletResponse response) {
		String messagebase = "查询招标人认证申请详情";
		int basecode = 0;
		BaseTransVO<MyBiddeeAuthInfoBodyVO> transorder = null;
		ResultModel rm = new ResultModel();
		try {
			String jsonstr = RequestUtil.getRequestPostData(request);
			request.setAttribute("rawjson", jsonstr);
			transorder = RequestUtil.convertJson2Obj(jsonstr, BaseTransVO.class,MyBiddeeAuthInfoBodyVO.class);
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
		rnr.setMethod("/myBiddee/authInfo/getApplication");
//		String token = transorder.getBody().getToken();
		try {
			// 业务数据必填等校验
			Token token = tokenSrv.getToken(transorder.getBody().getToken(), transorder.getApp().getAppId());
			if (token == null) {
				log.error(String.format("token[%s]验证失败,或已过期,请重新登录", transorder.getBody().getToken()));
				throw new TokenException("token验证失败,或已过期,请重新登录");
			}
			BiddeeBaseInfo baseInfo = new BiddeeBaseInfo();
			BiddeeLegalPerson legalPerson = new BiddeeLegalPerson();
			BiddeeRegisteredInfo registeredInfo = new BiddeeRegisteredInfo();
			BiddeeBankInfo bankInfo = new BiddeeBankInfo();
			
			baseInfo = myBiddeeService.getBaseInfo_apply(token);
			legalPerson = myBiddeeService.getLegalPersonInfo_apply(token);
			registeredInfo = myBiddeeService.getRegisteredInfo_apply(token);
			bankInfo = myBiddeeService.getBankInfo_apply(token);

			
			rm.put("baseInfo", baseInfo);
			rm.put("legalPerson", legalPerson);
			rm.put("registeredInfo", registeredInfo);			
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
	 * 保存招标人基本信息接口
	 * @author YJY
	 * @since 2015年11月7日11:00:21
	 * @return
	 */
	@RequestMapping(value="/saveBaseInfo_apply",method=RequestMethod.POST)
	@Transactional(propagation=Propagation.REQUIRED,rollbackFor=Exception.class,value="txManager")
	public @ResponseBody ResultModel saveBaseInfo_apply(HttpServletRequest request,HttpServletResponse response) {
//		int basecode = 2341210;//待定
		String messagebase = "保存招标人基本信息";
		BiddeeCerticateSaveInfoVO transorder = null;
		ResultModel rm = new ResultModel();
//		rm.setBaseErrorCode(basecode);
		try {
			String jsonstr  = RequestUtil.getRequestPostData(request);
			request.setAttribute("rawjson", jsonstr);
			transorder = RequestUtil.convertJson2Obj(jsonstr, BiddeeCerticateSaveInfoVO.class);
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
		rnr.setMethod("/myBiddee/authInfo/saveBaseInfo_apply");
		
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
			
			i= myBiddeeService.saveBaseInfo_apply(transorder.getApp().getAppId(), transorder.getBody().getBaseInfo(), token);

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
	 * 保存招标人法人信息接口
	 * @author YJY
	 * @since 2015年11月7日13:01:08
	 * @return
	 */
	@RequestMapping(value="/saveLegalPersonInfo_apply",method=RequestMethod.POST)
	@Transactional(propagation=Propagation.REQUIRED,rollbackFor=Exception.class,value="txManager")
	public @ResponseBody ResultModel saveLegalPersonInfo_apply(HttpServletRequest request,HttpServletResponse response) {
//		int basecode = 2341210;//待定
		String messagebase = "保存招标人法人信息";
		BiddeeCerticateSaveInfoVO transorder = null;
		ResultModel rm = new ResultModel();
//		rm.setBaseErrorCode(basecode);
		try {
			String jsonstr  = RequestUtil.getRequestPostData(request);
			request.setAttribute("rawjson", jsonstr);
			transorder = RequestUtil.convertJson2Obj(jsonstr, BiddeeCerticateSaveInfoVO.class);
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
		rnr.setMethod("/myBiddee/authInfo/saveLegalPersonInfo_apply");
		
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
			
			i= myBiddeeService.saveLegalPersonInfo_apply(transorder.getApp().getAppId(), transorder.getBody().getLegalPerson(), token);
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
	 * 保存招标人注册信息接口
	 * @author YJY
	 * @since 2015年11月7日14:02:02
	 * @return
	 */
	@RequestMapping(value="/saveRegisteredInfo_apply",method=RequestMethod.POST)
	@Transactional(propagation=Propagation.REQUIRED,rollbackFor=Exception.class,value="txManager")
	public @ResponseBody ResultModel saveRegisteredInfo_apply(HttpServletRequest request,HttpServletResponse response) {
//		int basecode = 2341210;//待定
		String messagebase = "保存招标人公司注册信息";
		BiddeeCerticateSaveInfoVO transorder = null;
		ResultModel rm = new ResultModel();
//		rm.setBaseErrorCode(basecode);
		try {
			String jsonstr  = RequestUtil.getRequestPostData(request);
			request.setAttribute("rawjson", jsonstr);
			transorder = RequestUtil.convertJson2Obj(jsonstr, BiddeeCerticateSaveInfoVO.class);
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
		rnr.setMethod("/myBiddee/authInfo/saveRegisteredInfo_apply");
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
		
		try {
			// 业务数据必填等校验
				Token token = tokenSrv.getToken(transorder.getBody().getToken(), transorder.getApp().getAppId());
				if (token == null) {
					log.error(String.format("token[%s]验证失败,或已过期,请重新登录", transorder.getBody().getToken()));
					throw new TokenException("token验证失败,或已过期,请重新登录");
				}
				int i= 0;
				
				i= myBiddeeService.saveRegisteredInfo(transorder.getApp().getAppId(), transorder.getBody().getRegisteredInfo(), token);
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
	 * 保存招标人开户行信息接口
	 * @author YJY
	 * @since 2015年11月7日15:02:56
	 * @return
	 */
	@RequestMapping(value="/saveBankInfo",method=RequestMethod.POST)
	public @ResponseBody ResultModel saveBankInfo_apply(HttpServletRequest request,HttpServletResponse response) {
//		int basecode = 2341210;//待定
		String messagebase = "保存招标人开户行信息";
		BiddeeCerticateSaveInfoVO transorder = null;
		ResultModel rm = new ResultModel();
//		rm.setBaseErrorCode(basecode);
		try {
			String jsonstr  = RequestUtil.getRequestPostData(request);
			request.setAttribute("rawjson", jsonstr);
			transorder = RequestUtil.convertJson2Obj(jsonstr, BiddeeCerticateSaveInfoVO.class);
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
		rnr.setMethod("/myBiddee/authInfo/saveBankInfo_apply");
//		"bankInfo":{ 
//            "bank":"招商银行深圳支行",
//            "accountId":"1234567812345678",
//            "accountName":"深圳麦圈互动技术有限公司"
//        }
		
		try {
		
			// 业务数据必填等校验
			Token token = tokenSrv.getToken(transorder.getBody().getToken(), transorder.getApp().getAppId());
			if (token == null) {
				log.error(String.format("token[%s]验证失败,或已过期,请重新登录", transorder.getBody().getToken()));
				throw new TokenException("token验证失败,或已过期,请重新登录");
			}
			int i= 0;
			
			i= myBiddeeService.saveBankInfo(transorder.getApp().getAppId(), transorder.getBody().getBankInfo(), token);
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
	 * @since 2015年11月7日13:01:08
	 * @return
	 */
	@RequestMapping(value="/applay",method=RequestMethod.POST)
	@Transactional(propagation=Propagation.REQUIRED,rollbackFor=Exception.class,value="txManager")
	public @ResponseBody ResultModel applay(HttpServletRequest request,HttpServletResponse response) {
//		int basecode = 2341210;//待定
		String messagebase = "提交招标人认证申请";
		MyBiddeeAuthInfoApplyVO transorder = null;
		ResultModel rm = new ResultModel();
//		rm.setBaseErrorCode(basecode);
		try {
			String jsonstr  = RequestUtil.getRequestPostData(request);
			request.setAttribute("rawjson", jsonstr);
			transorder = RequestUtil.convertJson2Obj(jsonstr, MyBiddeeAuthInfoApplyVO.class);
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
		rnr.setMethod("/myBiddee/authInfo/applay");
		
		
		try {
		
		
			// 业务数据必填等校验
				Token token = tokenSrv.getToken(transorder.getBody().getToken(), transorder.getApp().getAppId());
				if (token == null) {
					log.error(String.format("token[%s]验证失败,或已过期,请重新登录", transorder.getBody().getToken()));
					throw new TokenException("token验证失败,或已过期,请重新登录");
				}
				int i= 0;
				
				i= myBiddeeService.applay(transorder.getApp().getAppId(), token);
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
	 * 招标人认证审核接口
	 * @author YJY
	 * @since 2015-11-18 16:48:09
	 * @return
	 */
	@RequestMapping(value="/checkApplication",method=RequestMethod.POST)
	@Transactional(propagation=Propagation.REQUIRED,rollbackFor=Exception.class,value="txManager")
	public @ResponseBody ResultModel checkApplication(HttpServletRequest request,HttpServletResponse response) {
//		int basecode = 2341210;//待定
		String messagebase = "提交招标人认证审核结果";
		BiddeeAuditInfoVO transorder = null;
		ResultModel rm = new ResultModel();
//		rm.setBaseErrorCode(basecode);
		try {
			String jsonstr  = RequestUtil.getRequestPostData(request);
			request.setAttribute("rawjson", jsonstr);
			transorder = RequestUtil.convertJson2Obj(jsonstr, BiddeeAuditInfoVO.class);
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
		rnr.setMethod("/myBiddee/authInfo/checkApplication");
		
		
		try {
			boolean flag = false;
			BiddeeBaseInfoCheck bic = transorder.getBody().getBaseInfoCheck();
			
			ValidateUtil.assertNull(bic, "参数baseInfoCheck不能为空!");
			ValidateUtil.assertNull(bic.getBiddee_id(), "参数bidder_id不能为空!");
			
			flag = myBiddeeService.checkApplication(transorder.getApp().getAppId(), transorder.getBody(), transorder.getBody().getBaseInfoCheck().getBiddee_id());
				
//				int i= 0;
//				
//				i= myBiddeeService.applay(transorder.getApp().getAppId(), token);
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
