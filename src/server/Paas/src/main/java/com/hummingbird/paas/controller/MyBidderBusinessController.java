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
import com.hummingbird.common.util.CollectionTools;
import com.hummingbird.common.util.DateUtil;
import com.hummingbird.common.util.JsonUtil;
import com.hummingbird.common.util.Md5Util;
import com.hummingbird.common.util.PropertiesUtil;
import com.hummingbird.common.util.RequestUtil;
import com.hummingbird.common.vo.ResultModel;
import com.hummingbird.commonbiz.vo.BaseTransVO;

import com.hummingbird.paas.entity.AppLog;
import com.hummingbird.paas.entity.BidderBankAduit;
import com.hummingbird.paas.entity.BidderCerticate;
import com.hummingbird.paas.entity.BidderCertificateAduit;
import com.hummingbird.paas.entity.BidderCertificationCertification;
import com.hummingbird.paas.entity.BidderCompanyCertification;
import com.hummingbird.paas.entity.BidderCredit;
import com.hummingbird.paas.entity.ScoreLevel;
import com.hummingbird.paas.entity.UserBankcard;
import com.hummingbird.paas.mapper.AppLogMapper;
import com.hummingbird.paas.mapper.BidderBankAduitMapper;
import com.hummingbird.paas.mapper.BidderBidCreditScoreMapper;
import com.hummingbird.paas.mapper.BidderCerticateMapper;
import com.hummingbird.paas.mapper.BidderCertificateAduitMapper;
import com.hummingbird.paas.mapper.BidderCertificationCertificationMapper;
import com.hummingbird.paas.mapper.BidderCompanyCertificationMapper;
import com.hummingbird.paas.mapper.BidderCreditMapper;
import com.hummingbird.paas.mapper.ScoreLevelMapper;
import com.hummingbird.paas.mapper.UserBankcardMapper;
import com.hummingbird.paas.services.MyBidderService;
import com.hummingbird.paas.vo.BiddeeBankInfo;
import com.hummingbird.paas.vo.BiddeeBaseInfo;
import com.hummingbird.paas.vo.BiddeeLegalPerson;
import com.hummingbird.paas.vo.BiddeeRegisteredInfo;
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
public class MyBidderBusinessController extends BaseController  {
	@Autowired
	protected MyBidderService myBidderService;
	@Autowired
	protected BidderCerticateMapper bidderCerticateDao;
	@Autowired
	protected BidderCertificateAduitMapper bidderCertificateAduitDao;
	@Autowired
	protected UserBankcardMapper userBankcardDao;
	@Autowired
	protected BidderCreditMapper bidderCreditDao;
	@Autowired
	protected BidderBidCreditScoreMapper bidderBidCreditScoreDao;
	@Autowired
	protected BidderBankAduitMapper bidderBankAduitDao;
	@Autowired
	protected BidderCertificationCertificationMapper bidderCertificationCertificationDao;
	@Autowired
	protected ScoreLevelMapper scoreLevelDao;
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
			ScoreLevel bb = scoreLevelDao.countLevelByScore(aa.getCreditScore()!=null?aa.getCreditScore():0);
			Map overall= new HashMap();//积分和信用等级信息
			Map detail= new HashMap();//详细信息
			Map baseInof= new HashMap();//基础信息
			Map tradeInfo= new HashMap();//交易信息
			Map myBidderInfo= new HashMap();//企业信息
			BidderAuthInfo ba = new BidderAuthInfo();
			
			BidderCertificateAduit p = bidderCertificateAduitDao.selectPersonalInfo(aa.getBidderId());
			BidderCertificateAduit bi = bidderCertificateAduitDao.selectBaseInfo(aa.getBidderId());
			BidderCertificateAduit lp = bidderCertificateAduitDao.selectLegalPersonInfo(aa.getBidderId());
			BidderCertificateAduit cr = bidderCertificateAduitDao.selectCompanyRegisteredInfo(aa.getBidderId());
			BidderBankAduit bba = bidderBankAduitDao.selectByBcId(aa.getBidderId());
			
			
			overall.put("creditRating", bb.getLevelName());
			overall.put("creditRatingIcon", bb.getIcon());
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
		
		try {
			BidderCerticate aa = bidderCerticateDao.selectByToken(transorder.getBody().getToken());
			
//			 "logoUrl":"LOGO_IMAGE_URL"
//		            "companyName":"深圳蜂鸟娱乐技术有限公司",
//		            "shortName":"蜂鸟娱乐",
//		            "description":"公司简介",
//		            "registeredCapital":"",
//		            "telephone":"",
//		            "email":""
			
//			Map baseInfo= new HashMap();
//			baseInfo.put("logoUrl", aa.getLogo());
//			baseInfo.put("companyName", aa.getCompanyName());
//			baseInfo.put("shortName", aa.getShortName());
//			baseInfo.put("description", aa.getDescription());
//			baseInfo.put("registeredCapital", aa.getRegisteredCapital());
//			baseInfo.put("telephone", aa.getContactMobileNum());
//			baseInfo.put("email", aa.getEmail());
			BidderBaseInfo baseInfo = new BidderBaseInfo();
			baseInfo.setLogoUrl(aa.getLogo());
			baseInfo.setCompanyName(aa.getCompanyName());
			baseInfo.setShortName(aa.getShortName());
			baseInfo.setDescription(aa.getDescription());
			baseInfo.setRegisteredCapital(aa.getRegisteredCapital());
			baseInfo.setTelephone(aa.getContactMobileNum());
			baseInfo.setEmail(aa.getEmail());
			
			
//			baseInfo.put("creditRatingIcon", aa.getUnified_social_credit_code_url());
			rm.put("baseInfo", baseInfo);
			
			
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
		
		try {
			BidderCerticate aa = bidderCerticateDao.selectByToken(transorder.getBody().getToken());
			Map legalPerson= new HashMap();
//			"legalPerson":{
//		        "name":"张三",
//		        "idCard":"420923199205049230121",
//		        "idCardfrontUrl":"法人身份证正面地址",
//		        "idCardBackUrl":"法人身份证反面地址",
//		        "authorityBookUrl":""
//		    }
			legalPerson.put("name", Md5Util.Encrypt(aa.getLegalPerson())); 
			legalPerson.put("idCard", Md5Util.Encrypt(aa.getLegalPersonIdcard()));
			legalPerson.put("idCardfrontUrl", aa.getLegalPersonIdcardFrontUrl());
			legalPerson.put("idCardBackUrl", aa.getLegalPersonIdcardBackUrl());
			legalPerson.put("authorityBookUrl", aa.getLegalPersonAuthorityBook());
		
			
//			baseInfo.put("creditRatingIcon", aa.getUnified_social_credit_code_url());
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
		
		try {
			BidderCerticate aa = bidderCerticateDao.selectByToken(transorder.getBody().getToken());
			Map registeredInfo= new HashMap();
//			 "registeredInfo":{
//		         "businessLicenseNum":"BUSINESS_LICENSE_NUM",
//		         "":"BUSINESS_LICENSE_URL",
//		         "taxRegistrationNum":"TAX_REGISTRATION_NUM",
//		         "taxRegistrationUrl":"TAX_REGISTRATION_URL",
//		         "organizationCodeNum":"ORGANIZATION_CODE_NUM",
//		         "organizationCodeUrl":"ORGANIZATION_CODE_URL"
//		         "businessScope":"经营范围",
//		         "regTime":"2014-04-05",
//		         "businessLicenseExpireTime":"10年",
//		         "address":"",
//		         "businessLicenseType":"OLD",
//		         "newBusinessLicenseNum":"",
//		         "newBusinessLicenseUrl":"",
//		    }
			
			registeredInfo.put("businessLicenseNum", aa.getBusinessLicense());
			registeredInfo.put("businessLicenseUrl", aa.getBusinessLicenseUrl());
			registeredInfo.put("taxRegistrationNum", aa.getTaxRegistrationCertificate());
			registeredInfo.put("taxRegistrationUrl", aa.getTaxRegistrationCertificateUrl());
			registeredInfo.put("organizationCodeNum", aa.getOrgCodeCertificate());
			registeredInfo.put("organizationCodeUrl", aa.getOrgCodeCertificateUrl());
			registeredInfo.put("businessScope", aa.getBusinessScope());
			registeredInfo.put("regTime", aa.getRegTime());
			registeredInfo.put("businessLicenseExpireTime", aa.getBusinessLicenseExpireTime());
			
			registeredInfo.put("address", aa.getAddress());
			registeredInfo.put("businessLicenseType", aa.getBusinessLicenseType());
			registeredInfo.put("newBusinessLicenseNum", aa.getNewBusinessLicense());
			registeredInfo.put("newBusinessLicenseUrl", aa.getUnifiedSocialCreditCodeUrl());
		
			
			rm.put("registeredInfo", registeredInfo);
			
			
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
		
		try {
			List<UserBankcard> aa = userBankcardDao.selectBidderBankInfoByToken(transorder.getBody().getToken());
			Map bankInfo= new HashMap();
//			"bankInfo":{ 
//		        "bank":"招商银行深圳支行",
//		        "accountId":"1234567812345678",
//		        "accountName":"深圳麦圈互动技术有限公司"
//		    }
			if(aa!=null&&aa.size()>0){
				bankInfo.put("bank", aa.get(0).getBankName());
				bankInfo.put("accountId", aa.get(0).getAccountNo());
				bankInfo.put("accountName", aa.get(0).getAccountName());
			}
			
			rm.put("bankInfo", bankInfo);
			
			
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
			List<BidderEqInfo> aa = bidderCertificationCertificationDao.selectEqInfoByToken(transorder.getBody().getToken());

			if(aa==null){
				aa = new ArrayList<BidderEqInfo>();
			}
			
			rm.put("eqInfo", aa);
			
			
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
		String token = transorder.getBody().getToken();
		try {
			BidderCerticate aa = bidderCerticateDao.selectByToken(token);
			
			List<UserBankcard> bb = userBankcardDao.selectBidderBankInfoByToken(token);
			
			List<BidderEqInfo> cc = bidderCertificationCertificationDao.selectEqInfoByBidderId(aa.getId());
			
//			Map baseInfo= new HashMap();
//			Map legalPerson= new HashMap();
//			Map registeredInfo= new HashMap();
//			Map bankInfo= new HashMap();
//			
//			
//			baseInfo.put("logoUrl", aa.getLogo());
//			baseInfo.put("companyName", aa.getCompanyName());
//			baseInfo.put("shortName", aa.getShortName());
//			baseInfo.put("description", aa.getDescription());
//			baseInfo.put("registeredCapital", aa.getRegisteredCapital());
//			baseInfo.put("telephone", aa.getContactMobileNum());
//			baseInfo.put("email", aa.getEmail());
//			
//			
//			legalPerson.put("name", Md5Util.Encrypt(aa.getLegalPerson()));
//			legalPerson.put("idCard", Md5Util.Encrypt(aa.getLegalPersonIdcard()));
//			legalPerson.put("idCardfrontUrl", aa.getLegalPersonIdcardFrontUrl());
//			legalPerson.put("idCardBackUrl", aa.getLegalPersonIdcardBackUrl());
//			legalPerson.put("authorityBookUrl", aa.getLegalPersonAuthorityBook());
//			
//		
//			registeredInfo.put("businessLicenseNum", aa.getBusinessLicense());
//			registeredInfo.put("businessLicenseUrl", aa.getBusinessLicenseUrl());
//			registeredInfo.put("taxRegistrationNum", aa.getTaxRegistrationCertificate());
//			registeredInfo.put("taxRegistrationUrl", aa.getTaxRegistrationCertificateUrl());
//			registeredInfo.put("organizationCodeNum", aa.getOrgCodeCertificate());
//			registeredInfo.put("organizationCodeUrl", aa.getOrgCodeCertificateUrl());
//			registeredInfo.put("businessScope", aa.getBusinessScope());
//			registeredInfo.put("regTime", aa.getRegTime());
//			registeredInfo.put("businessLicenseExpireTime", aa.getBusinessLicenseExpireTime());
//			
//			registeredInfo.put("address", aa.getAddress());
//			registeredInfo.put("businessLicenseType", aa.getBusinessLicenseType());
//			registeredInfo.put("newBusinessLicenseNum", aa.getNewBusinessLicense());
//			registeredInfo.put("newBusinessLicenseUrl", aa.getUnifiedSocialCreditCodeUrl());
			
			
//			"bankInfo":{ 
//		        "bank":"招商银行深圳支行",
//		        "accountId":"1234567812345678",
//		        "accountName":"深圳麦圈互动技术有限公司"
//		    }
//			if(aa!=null&&bb.size()>0){
//				bankInfo.put("bank", bb.get(0).getBankName());
//				bankInfo.put("accountId", bb.get(0).getAccountNo());
//				bankInfo.put("accountName", bb.get(0).getAccountName());
//			}
			
			//基本信息
			BiddeeBaseInfo baseInfo = new BiddeeBaseInfo();
			baseInfo.setLogoUrl(aa.getLogo());
			baseInfo.setCompanyName(aa.getCompanyName());
			baseInfo.setShortName(aa.getShortName());
			baseInfo.setDescription(aa.getDescription());
			baseInfo.setRegisteredCapital(aa.getRegisteredCapital());
			baseInfo.setTelephone(aa.getContactMobileNum());
			baseInfo.setEmail(aa.getEmail());
			//法人信息
			BiddeeLegalPerson legalPerson = new BiddeeLegalPerson();
			legalPerson.setName(Md5Util.Encrypt(aa.getLegalPerson()));
			legalPerson.setIdCard(Md5Util.Encrypt(aa.getLegalPersonIdcard()));
			legalPerson.setIdCardfrontUrl(aa.getLegalPersonIdcardFrontUrl());
			legalPerson.setIdCardBackUrl(aa.getLegalPersonIdcardBackUrl());
			legalPerson.setAuthorityBookUrl(aa.getLegalPersonAuthorityBook());
			//公司注册信息
			BiddeeRegisteredInfo registeredInfo = new BiddeeRegisteredInfo();
			registeredInfo.setBusinessLicenseNum(aa.getBusinessLicense());
			registeredInfo.setBusinessLicenseUrl(aa.getBusinessLicenseUrl());
			registeredInfo.setTaxRegistrationNum(aa.getTaxRegistrationCertificate());
			registeredInfo.setTaxRegistrationUrl(aa.getTaxRegistrationCertificateUrl());
			registeredInfo.setOrganizationCodeNum(aa.getOrgCodeCertificate());
			registeredInfo.setOrganizationCodeUrl(aa.getOrgCodeCertificateUrl());
			registeredInfo.setBusinessScope(aa.getBusinessScope());
			registeredInfo.setRegTime(aa.getRegTime());
			registeredInfo.setBusinessLicenseExpireTime(aa.getBusinessLicenseExpireTime());
			registeredInfo.setAddress(aa.getAddress());
			registeredInfo.setBusinessLicenseType(aa.getBusinessLicenseType());
			registeredInfo.setNewBusinessLicenseNum(aa.getNewBusinessLicense());
			registeredInfo.setNewBusinessLicenseUrl(aa.getUnifiedSocialCreditCodeUrl());
			//开户行信息
			BiddeeBankInfo bankInfo = new BiddeeBankInfo();
			if(bb!=null&&bb.size()>0){
				bankInfo.setBank(bb.get(0).getBankName());
				bankInfo.setAccountId(bb.get(0).getAccountNo());
				bankInfo.setAccountName(bb.get(0).getAccountName());
			}
			
			List<BidderEqInfo> eqInfo = new ArrayList<BidderEqInfo>();
			if(cc!= null){
				eqInfo = cc;	
			}
			rm.put("baseInfo", baseInfo);
			rm.put("legalPerson", legalPerson);
			rm.put("registeredInfo", registeredInfo);			
			rm.put("bankInfo", bankInfo);
			rm.put("eqInfo", eqInfo);
			
			
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
		String token =  transorder.getBody().getToken();
		BidderBaseInfo baseInfo =  transorder.getBody().getBaseInfo();
		
		
		
		int i= 0;
		if(StringUtils.isNotBlank(token)){
			BidderCerticate bidder=bidderCerticateDao.selectByToken(token);
			if(bidder==null){
				bidder=new BidderCerticate();
				if(baseInfo!= null){
					String company_name = baseInfo.getCompanyName();
					String short_name = baseInfo.getShortName();
					String description = baseInfo.getDescription();
					String registered_capital = baseInfo.getRegisteredCapital();
					String telephone = baseInfo.getTelephone();
					String email = baseInfo.getEmail();
					bidder.setCompanyName(company_name);
					bidder.setShortName(short_name);
					bidder.setDescription(description);
					bidder.setRegisteredCapital(registered_capital);
					bidder.setContactMobileNum(telephone);
					bidder.setEmail(email);
					
				}
			
				
				i = bidderCerticateDao.insertSelective(bidder);
			}else{
				if(baseInfo!= null){
					String company_name = baseInfo.getCompanyName();
					String short_name = baseInfo.getShortName();
					String description = baseInfo.getDescription();
					String registered_capital = baseInfo.getRegisteredCapital();
					String telephone = baseInfo.getTelephone();
					String email = baseInfo.getEmail();
					bidder.setCompanyName(company_name);
					bidder.setShortName(short_name);
					bidder.setDescription(description);
					bidder.setRegisteredCapital(registered_capital);
					bidder.setContactMobileNum(telephone);
					bidder.setEmail(email);
					
				}
				i = bidderCerticateDao.updateByPrimaryKeySelective(bidder);
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
		String token =  transorder.getBody().getToken();
		BidderLegalPerson legalPerson =  transorder.getBody().getLegalPerson();
		
		
		
		int i= 0;
		if(StringUtils.isNotBlank(token)){
			BidderCerticate bidder=bidderCerticateDao.selectByToken(token);
			if(bidder==null){
				bidder=new BidderCerticate();
				if(legalPerson!= null){
					String name = legalPerson.getName();
					String idCard = legalPerson.getIdCard();
					String idCardfrontUrl = legalPerson.getIdCardfrontUrl();
					
					String idCardBackUrl = legalPerson.getIdCardBackUrl();
					String authorityBookUrl = legalPerson.getAuthorityBookUrl();
					
					
					bidder.setLegalPerson(name);
					bidder.setLegalPersonIdcard(idCard);
					bidder.setLegalPersonIdcardFrontUrl(idCardfrontUrl);
					bidder.setLegalPersonIdcardBackUrl(idCardBackUrl);
					
					bidder.setLegalPersonAuthorityBook(authorityBookUrl);
				}
			
				
				i = bidderCerticateDao.insertSelective(bidder);
			}else{
				if(legalPerson!= null){
					String name = legalPerson.getName();
					String idCard =legalPerson.getIdCard();
					String idCardfrontUrl = legalPerson.getIdCardfrontUrl();
					
					String idCardBackUrl = legalPerson.getIdCardBackUrl();
					String authorityBookUrl = legalPerson.getAuthorityBookUrl();
					
					
					bidder.setLegalPerson(name);
					bidder.setLegalPersonIdcard(idCard);
					bidder.setLegalPersonIdcardFrontUrl(idCardfrontUrl);
					bidder.setLegalPersonIdcardBackUrl(idCardBackUrl);
					
					bidder.setLegalPersonAuthorityBook(authorityBookUrl);
				}
			
				i = bidderCerticateDao.updateByPrimaryKeySelective(bidder);
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
		
		try {
		String token =  transorder.getBody().getToken();
		BidderRegisteredInfo registeredInfo =  transorder.getBody().getRegisteredInfo();
		
		
		
		int i= 0;
		if(StringUtils.isNotBlank(token)){
			BidderCerticate bidder=bidderCerticateDao.selectByToken(token);
			if(registeredInfo!= null){
				
				String businessLicenseNum = registeredInfo.getBusinessLicenseNum();
				String businessLicenseUrl = registeredInfo.getBusinessLicenseUrl();
				String businessLicenseType = registeredInfo.getBusinessLicenseType();
				String taxRegistrationNum = registeredInfo.getTaxRegistrationNum();
				String taxRegistrationUrl = registeredInfo.getTaxRegistrationUrl();
				String organizationCodeNum = registeredInfo.getOrganizationCodeNum();
				String organizationCodeUrl = registeredInfo.getOrganizationCodeUrl();
				
				
				String newBusinessLicenseNum = registeredInfo.getNewBusinessLicenseNum();
				String newBusinessLicenseUrl = registeredInfo.getNewBusinessLicenseUrl();
				String businessScope = registeredInfo.getBusinessScope();
				String address = registeredInfo.getAddress();
				Date regTime = registeredInfo.getRegTime();
				Date businessLicenseExpireTime = registeredInfo.getBusinessLicenseExpireTime();
				
				
				
				
				bidder.setBusinessLicenseType(businessLicenseType);
				
				if("NEW3".equalsIgnoreCase(businessLicenseType)){
					
					bidder.setUnifiedSocialCreditCode(newBusinessLicenseNum);
					bidder.setUnifiedSocialCreditCodeUrl(newBusinessLicenseUrl);
					bidder.setNewBusinessLicense(newBusinessLicenseNum);
					/*bidder.setBusinessLicense(newBusinessLicenseNum);
					bidder.setBusinessLicenseUrl(newBusinessLicenseUrl);*/
				}else if("OLD3".equalsIgnoreCase(businessLicenseType)){
					bidder.setBusinessLicense(businessLicenseNum);
					bidder.setBusinessLicenseUrl(businessLicenseUrl);
					bidder.setTaxRegistrationCertificate(taxRegistrationNum);
					bidder.setTaxRegistrationCertificateUrl(taxRegistrationUrl);
					bidder.setOrgCodeCertificate(organizationCodeNum);
					bidder.setOrgCodeCertificateUrl(organizationCodeUrl);
				}
	
				bidder.setBusinessScope(businessScope);
				bidder.setAddress(address);
				
				bidder.setRegTime(DateUtil.parseDateToTimestamp(regTime, "yyyy-MM-dd HH:mm:ss"));
				bidder.setBusinessLicenseExpireTime(DateUtil.parseDateToTimestamp(businessLicenseExpireTime, "yyyy-MM-dd HH:mm:ss"));
			}
			if(bidder==null && bidder.getId()==null){
				//bidder=new BidderCerticate();
				i = bidderCerticateDao.insertSelective(bidder);
			}else{
			
				i = bidderCerticateDao.updateByPrimaryKeySelective(bidder);
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
	 * 保存投标人开户行信息接口
	 * @author YJY
	 * @since 2015年11月10日16:26:42
	 * @return
	 */
	@RequestMapping(value="/saveBankInfo_apply",method=RequestMethod.POST)
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
		
		try {
		String token =  transorder.getBody().getToken();
		BidderBankInfo bankInfo =  transorder.getBody().getBankInfo();
		
		
		
		int i= 0;
		if(StringUtils.isNotBlank(token)){
			List<UserBankcard> banks=userBankcardDao.selectBidderBankInfoByToken(token);
			UserBankcard b =new UserBankcard();
			
			if(banks!= null && banks.size()>0){
				 b = banks.get(0);
				 if(bankInfo !=null){
						
					 b.setBankName(bankInfo.getBank());
					 b.setAccountNo(bankInfo.getAccountId());
					 b.setAccountName(bankInfo.getAccountName());
				 }
				
				i = userBankcardDao.updateByPrimaryKeySelective(b);

			}else{
				 if(bankInfo !=null){
						
					 b.setBankName(bankInfo.getBank());
					 b.setAccountNo(bankInfo.getAccountId());
					 b.setAccountName(bankInfo.getAccountName());
				 }
				i = userBankcardDao.insertSelective(b);
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
	 * 保存投标人企业资质接口
	 * @author YJY
	 * @since 2015年11月11日17:10:23
	 * @return
	 */
	@RequestMapping(value="/saveEnterpriseQualification",method=RequestMethod.POST)
	@Transactional(propagation=Propagation.REQUIRED,rollbackFor=Exception.class,value="txManager")
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
		String token =  transorder.getBody().getToken();
		List<BidderEqInfo>  eqInfo =  transorder.getBody().getEqInfo();
		
		
		
		int i= 0;
		if(StringUtils.isNotBlank(token)){
			List<BidderEqInfo> eqinfo=bidderCertificationCertificationDao.selectEqInfoByToken(token);
			BidderCertificationCertification b =new BidderCertificationCertification();
			
			if(eqinfo!= null && eqinfo.size()>0){
	
				for(BidderEqInfo be :  eqinfo){
					b.setExpireTime(be.getExpiryDate());
					b.setBidderId(be.getEqId());
					b.setCertificationContent(be.getEqDesc());
					b.setCertificationName(be.getEqName());
//					b.setApplicableRegion(applicableRegion);
					i = bidderCertificationCertificationDao.insert(b);
//					i = bidderCertificationCertificationDao.updateByPrimaryKeySelective(b);
				}
				
				

			}else{
				 
				i = bidderCertificationCertificationDao.insertSelective(b);
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
		String token =  transorder.getBody().getToken();
		

		int i= 0;
		if(StringUtils.isNotBlank(token)){
			BidderCerticate bidder=bidderCerticateDao.selectByToken(token);
			if(bidder==null){
				rm.setErrmsg("未找到相应记录 ,请先填写基本信息!");
				return rm;
				}else{
					bidder.setStatus("OK#");//修改状态为已认证
					i = bidderCerticateDao.updateByPrimaryKeySelective(bidder);
				}
			
				
				i = bidderCerticateDao.insertSelective(bidder);
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
	
	public String getStatus() throws Exception{
		
		return null;
	}
}
