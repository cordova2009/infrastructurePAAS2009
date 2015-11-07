package com.hummingbird.paas.controller;
/**
 * @author YJY 
 * @since 2015年10月29日13:04:12
 * 招标人业务
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
import com.hummingbird.common.util.PropertiesUtil;
import com.hummingbird.common.util.RequestUtil;
import com.hummingbird.common.vo.ResultModel;
import com.hummingbird.commonbiz.vo.BaseTransVO;

import com.hummingbird.paas.entity.AppLog;
import com.hummingbird.paas.entity.BiddeeCerticate;
import com.hummingbird.paas.entity.UserBankcard;
import com.hummingbird.paas.mapper.AppLogMapper;
import com.hummingbird.paas.mapper.BiddeeCerticateMapper;
import com.hummingbird.paas.mapper.UserBankcardMapper;
import com.hummingbird.paas.services.MyBiddeeService;
import com.hummingbird.paas.vo.BiddeeBankInfo;
import com.hummingbird.paas.vo.BiddeeBaseInfo;
import com.hummingbird.paas.vo.BiddeeCerticateSaveInfoVO;
import com.hummingbird.paas.vo.BiddeeLegalPerson;
import com.hummingbird.paas.vo.BiddeeRegisteredInfo;
import com.hummingbird.paas.vo.MyBiddeeAuthInfoBodyVO;
@Controller
@RequestMapping(value="/myBiddee/authInfo"
		 ,method=RequestMethod.POST)
public class MyBiddeeBusinessController extends BaseController  {
	@Autowired
	protected MyBiddeeService myBiddeeService;
	@Autowired
	protected BiddeeCerticateMapper biddeeCerticateDao;
	@Autowired
	protected UserBankcardMapper userBankcardDao;
	@Autowired(required = true)
	protected AppLogMapper applogDao;
	
	/**
	 * 查询我的招标人认证信息接口
	 * @author cordova2009
	 * @since 2015年11月6日15:05:54
	 * @return
	 */
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
			BiddeeCerticate aa = biddeeCerticateDao.selectByUserId(transorder.getBody().getToken());
			Map overall= new HashMap();
			overall.put("creditRating", aa.getUnifiedSocialCreditCode());
			overall.put("creditRatingIcon", aa.getUnifiedSocialCreditCodeUrl());
			rm.put("overall", overall);
			
			
			Map row= BeanUtils.describe(aa);
			
			row.put("reg_time", DateUtil.formatCommonDateorNull(aa.getRegTime()));
			row.put("apply_time", DateUtil.formatCommonDateorNull(aa.getApplyTime()));
			row.put("business_license_expire_time", DateUtil.formatCommonDateorNull(aa.getBusinessLicenseExpireTime()));
			row.remove("class");
			rm.put("result", row);
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
	 * 查询保存的招标人基本信息接口
	 * @author cordova2009
	 * @since 2015年11月6日15:05:54
	 * @return
	 */
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
		
		try {
			BiddeeCerticate aa = biddeeCerticateDao.selectByUserId(transorder.getBody().getToken());
			Map baseInfo= new HashMap();
//			 "logoUrl":"LOGO_IMAGE_URL"
//		            "companyName":"深圳蜂鸟娱乐技术有限公司",
//		            "shortName":"蜂鸟娱乐",
//		            "description":"公司简介",
//		            "registeredCapital":"",
//		            "telephone":"",
//		            "email":""
			baseInfo.put("logoUrl", aa.getLogo());
			baseInfo.put("companyName", aa.getCompanyName());
			baseInfo.put("shortName", aa.getShortName());
			baseInfo.put("description", aa.getDescription());
			baseInfo.put("registeredCapital", aa.getRegisteredCapital());
			baseInfo.put("telephone", aa.getContactMobileNum());
			baseInfo.put("email", aa.getEmail());
			
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
	 * 查询保存的招标人法人信息接口
	 * @author cordova2009
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
		
		try {
			BiddeeCerticate aa = biddeeCerticateDao.selectByUserId(transorder.getBody().getToken());
			Map legalPerson= new HashMap();
//			"legalPerson":{
//		        "name":"张三",
//		        "idCard":"420923199205049230121",
//		        "idCardfrontUrl":"法人身份证正面地址",
//		        "idCardBackUrl":"法人身份证反面地址",
//		        "authorityBookUrl":""
//		    }
			legalPerson.put("name", aa.getLegalPerson());
			legalPerson.put("idCard", aa.getLegalPersonIdcard());
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
		
		try {
			BiddeeCerticate aa = biddeeCerticateDao.selectByUserId(transorder.getBody().getToken());
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
			registeredInfo.put("newBusinessLicenseUrl", aa.getBusinessLicenseUrl());
		
			
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
		
		try {
			List<UserBankcard> aa = userBankcardDao.selectByToken(transorder.getBody().getToken());
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
		String token = transorder.getBody().getToken();
		try {
			BiddeeCerticate aa = biddeeCerticateDao.selectByUserId(token);
			
			List<UserBankcard> bb = userBankcardDao.selectByToken(token);
			
			Map baseInfo= new HashMap();
			Map legalPerson= new HashMap();
			Map registeredInfo= new HashMap();
			Map bankInfo= new HashMap();
			
			
			baseInfo.put("logoUrl", aa.getLogo());
			baseInfo.put("companyName", aa.getCompanyName());
			baseInfo.put("shortName", aa.getShortName());
			baseInfo.put("description", aa.getDescription());
			baseInfo.put("registeredCapital", aa.getRegisteredCapital());
			baseInfo.put("telephone", aa.getContactMobileNum());
			baseInfo.put("email", aa.getEmail());
			
			
			legalPerson.put("name", aa.getLegalPerson());
			legalPerson.put("idCard", aa.getLegalPersonIdcard());
			legalPerson.put("idCardfrontUrl", aa.getLegalPersonIdcardFrontUrl());
			legalPerson.put("idCardBackUrl", aa.getLegalPersonIdcardBackUrl());
			legalPerson.put("authorityBookUrl", aa.getLegalPersonAuthorityBook());
			
		
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
			registeredInfo.put("newBusinessLicenseUrl", aa.getBusinessLicenseUrl());
			
			
//			"bankInfo":{ 
//		        "bank":"招商银行深圳支行",
//		        "accountId":"1234567812345678",
//		        "accountName":"深圳麦圈互动技术有限公司"
//		    }
			if(aa!=null&&bb.size()>0){
				bankInfo.put("bank", bb.get(0).getBankName());
				bankInfo.put("accountId", bb.get(0).getAccountNo());
				bankInfo.put("accountName", bb.get(0).getAccountName());
			}
			rm.put("baseInfo", baseInfo);
			rm.put("legalPerson", legalPerson);
			rm.put("registeredInfo", registeredInfo);			
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
		String token =  transorder.getBody().getToken();
		BiddeeBaseInfo baseInfo =  transorder.getBody().getBaseInfo();
		
		
		
		int i= 0;
		if(StringUtils.isNotBlank(token)){
			BiddeeCerticate biddee=biddeeCerticateDao.selectByUserId(token);
			if(biddee==null){
				biddee=new BiddeeCerticate();
				if(baseInfo!= null){
					String company_name = baseInfo.getCompanyName();
					String short_name = baseInfo.getShortName();
					String description = baseInfo.getDescription();
					String registered_capital = baseInfo.getRegisteredCapital();
					String telephone = baseInfo.getTelephone();
					String email = baseInfo.getEmail();
					biddee.setCompanyName(company_name);
					biddee.setShortName(short_name);
					biddee.setDescription(description);
					biddee.setRegisteredCapital(registered_capital);
					biddee.setContactMobileNum(telephone);
					biddee.setEmail(email);
					
				}
			
				
				i = biddeeCerticateDao.insertSelective(biddee);
			}else{
				if(baseInfo!= null){
					String company_name = baseInfo.getCompanyName();
					String short_name = baseInfo.getShortName();
					String description = baseInfo.getDescription();
					String registered_capital = baseInfo.getRegisteredCapital();
					String telephone = baseInfo.getTelephone();
					String email = baseInfo.getEmail();
					biddee.setCompanyName(company_name);
					biddee.setShortName(short_name);
					biddee.setDescription(description);
					biddee.setRegisteredCapital(registered_capital);
					biddee.setContactMobileNum(telephone);
					biddee.setEmail(email);
					
				}
				i = biddeeCerticateDao.updateByPrimaryKeySelective(biddee);
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
		String token =  transorder.getBody().getToken();
		BiddeeLegalPerson legalPerson =  transorder.getBody().getLegalPerson();
		
		
		
		int i= 0;
		if(StringUtils.isNotBlank(token)){
			BiddeeCerticate biddee=biddeeCerticateDao.selectByUserId(token);
			if(biddee==null){
				biddee=new BiddeeCerticate();
				if(legalPerson!= null){
					String name = legalPerson.getName();
					String idCard = legalPerson.getIdCard();
					String idCardfrontUrl = legalPerson.getIdCardfrontUrl();
					
					String idCardBackUrl = legalPerson.getIdCardBackUrl();
					String authorityBookUrl = legalPerson.getAuthorityBookUrl();
					
					
					biddee.setLegalPerson(name);
					biddee.setLegalPersonIdcard(idCard);
					biddee.setLegalPersonIdcardFrontUrl(idCardfrontUrl);
					biddee.setLegalPersonIdcardBackUrl(idCardBackUrl);
					
					biddee.setLegalPersonAuthorityBook(authorityBookUrl);
				}
			
				
				i = biddeeCerticateDao.insertSelective(biddee);
			}else{
				if(legalPerson!= null){
					String name = legalPerson.getName();
					String idCard = legalPerson.getIdCard();
					String idCardfrontUrl = legalPerson.getIdCardfrontUrl();
					
					String idCardBackUrl = legalPerson.getIdCardBackUrl();
					String authorityBookUrl = legalPerson.getAuthorityBookUrl();
					
					
					biddee.setLegalPerson(name);
					biddee.setLegalPersonIdcard(idCard);
					biddee.setLegalPersonIdcardFrontUrl(idCardfrontUrl);
					biddee.setLegalPersonIdcardBackUrl(idCardBackUrl);
					
					biddee.setLegalPersonAuthorityBook(authorityBookUrl);
				}
			
				i = biddeeCerticateDao.updateByPrimaryKeySelective(biddee);
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
		String token =  transorder.getBody().getToken();
		BiddeeRegisteredInfo registeredInfo =  transorder.getBody().getRegisteredInfo();
		
		
		
		int i= 0;
		if(StringUtils.isNotBlank(token)){
			BiddeeCerticate biddee=biddeeCerticateDao.selectByUserId(token);
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
				
				
				
				
				biddee.setBusinessLicenseType(businessLicenseType);
				biddee.setTaxRegistrationCertificate(taxRegistrationNum);
				biddee.setTaxRegistrationCertificateUrl(taxRegistrationUrl);
				biddee.setOrgCodeCertificate(organizationCodeNum);
				biddee.setOrgCodeCertificateUrl(organizationCodeUrl);
				if("NEW3".equalsIgnoreCase(businessLicenseType)){
					biddee.setNewBusinessLicense(newBusinessLicenseNum);
					biddee.setBusinessLicense(newBusinessLicenseNum);
					biddee.setBusinessLicenseUrl(newBusinessLicenseUrl);
				}else if("OLD3".equalsIgnoreCase(businessLicenseType)){
					biddee.setBusinessLicense(businessLicenseNum);
					biddee.setBusinessLicenseUrl(businessLicenseUrl);
				}
	
				biddee.setBusinessScope(businessScope);
				biddee.setAddress(address);
				
				biddee.setRegTime(DateUtil.parseDateToTimestamp(regTime, "yyyy-MM-dd HH:mm:ss"));
				biddee.setBusinessLicenseExpireTime(DateUtil.parseDateToTimestamp(businessLicenseExpireTime, "yyyy-MM-dd HH:mm:ss"));
			}
			if(biddee==null && biddee.getId()==null){
				//biddee=new BiddeeCerticate();
				i = biddeeCerticateDao.insertSelective(biddee);
			}else{
			
				i = biddeeCerticateDao.updateByPrimaryKeySelective(biddee);
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
	 * 保存招标人开户行信息接口
	 * @author YJY
	 * @since 2015年11月7日15:02:56
	 * @return
	 */
	@RequestMapping(value="/saveBankInfo_apply",method=RequestMethod.POST)
	@Transactional(propagation=Propagation.REQUIRED,rollbackFor=Exception.class,value="txManager")
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
		String token =  transorder.getBody().getToken();
		BiddeeBankInfo bankInfo =  transorder.getBody().getBankInfo();
		
		
		
		int i= 0;
		if(StringUtils.isNotBlank(token)){
			List<UserBankcard> banks=userBankcardDao.selectByToken(token);
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
}
