package com.hummingbird.paas.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.ObjectUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hummingbird.common.controller.BaseController;
import com.hummingbird.common.exception.ValidateException;
import com.hummingbird.common.util.DESUtil;
import com.hummingbird.common.util.PropertiesUtil;
import com.hummingbird.common.util.RequestUtil;
import com.hummingbird.common.util.SmsSenderUtil;
import com.hummingbird.common.util.ValidateUtil;
import com.hummingbird.common.vo.ResultModel;
import com.hummingbird.commonbiz.service.IAuthenticationService;
import com.hummingbird.commonbiz.service.ISmsCodeService;
import com.hummingbird.commonbiz.util.AuthCodeUtil;
import com.hummingbird.commonbiz.vo.BaseTransVO;
import com.hummingbird.commonbiz.vo.UserToken;
import com.hummingbird.paas.entity.ProjectAccount;
import com.hummingbird.paas.entity.User;
import com.hummingbird.paas.entity.UserAuth;
import com.hummingbird.paas.entity.UserPassword;
import com.hummingbird.paas.exception.MaAccountException;
import com.hummingbird.paas.services.GeneralService;
import com.hummingbird.paas.services.UserService;
import com.hummingbird.paas.util.IDCardUtil;
import com.hummingbird.paas.vo.CapitalSurveyReturnVO;
import com.hummingbird.paas.vo.ForgetPasswordBodyVO;
import com.hummingbird.paas.vo.ForgetPasswordVO;
import com.hummingbird.paas.vo.LoginReturnVO;
import com.hummingbird.paas.vo.LoginBodyVO;
import com.hummingbird.paas.vo.MobileNumVO;
import com.hummingbird.paas.vo.MobileVO;
import com.hummingbird.paas.vo.RealNameVO;
import com.hummingbird.paas.vo.TokenBodyVO;
import com.hummingbird.paas.vo.TokenVO;
import com.hummingbird.paas.vo.UpdateHeadImageBodyVO;
import com.hummingbird.paas.vo.UpdateLoginPasswordBodyVO;
import com.hummingbird.paas.vo.UpdateLoginPasswordVO;
import com.hummingbird.paas.vo.UpdateMobileNumBodyVO;
import com.hummingbird.paas.vo.UpdateMobileNumVO;
import com.hummingbird.paas.vo.UpdateTradePasswordBodyVO;
import com.hummingbird.paas.vo.UpdateTradePasswordVO;
import com.hummingbird.paas.vo.UpdateUserInfoBodyVO;
import com.hummingbird.paas.vo.UserSecurityDetailVO;
import com.hummingbird.paas.vo.UserSecurityInfoVO;
import com.hummingbird.paas.vo.VerifySmsCodeVO;

@Controller
@RequestMapping("/userSecurity")
public class UserSecurityController extends BaseController{
	@Autowired 
	UserService userSer;
	@Autowired
	GeneralService genSer;

	@Autowired
	IAuthenticationService authService;
	@Autowired(required = true)
	private ISmsCodeService smsService;

	@RequestMapping(value = "/isRealName", method = RequestMethod.POST)
	public @ResponseBody Object isRealName(HttpServletRequest request) {
		
		final BaseTransVO<RealNameVO> transorder;
		ResultModel rm = new ResultModel();
		try {
			String jsonstr = RequestUtil.getRequestPostData(request);
			request.setAttribute("rawjson", jsonstr);
			transorder = RequestUtil.convertJson2Obj(jsonstr,BaseTransVO.class, RealNameVO.class);
		} catch (Exception e) {
			log.error(String.format("获取订单参数出错"),e);
			rm.mergeException(ValidateException.ERROR_PARAM_FORMAT_ERROR.cloneAndAppend(null, "订单参数"));
			return rm;
		}
		
		String messagebase = "实名校验";
		rm.setBaseErrorCode(210200);
		rm.setErrmsg(messagebase+"成功");
		try {
			//获取url以作为method的内容
			String requestURI = request.getRequestURI();
			requestURI=requestURI.replace(request.getContextPath(), "");
			//备注字段必填
			PropertiesUtil pu = new PropertiesUtil();
			RealNameVO body=transorder.getBody();
			
			
			if(log.isDebugEnabled()){
				log.debug("检验通过，获取请求");
			}
			Boolean isRealName=IDCardUtil.IDCardValidate(body.getCardID());
			if(!isRealName){
				if (log.isDebugEnabled()) {
					log.debug(String.format("实名认证不通过,%s", body));
				}throw new ValidateException().appendMessage("实名认证不通过");
			}
		} catch (Exception e1) {
			log.error(String.format(messagebase+"失败"),e1);
			rm.mergeException(e1);
			rm.setErrmsg(messagebase+"失败,"+rm.getErrmsg());
		}
		
		
		return rm;
	}
	
	@RequestMapping(value = "/getUserSecurityInfo", method = RequestMethod.POST)
	public @ResponseBody Object getUserSecurityInfo(HttpServletRequest request) {
		
		TokenVO transorder;
		ResultModel rm = new ResultModel();
		try {
			String jsonstr = RequestUtil.getRequestPostData(request);
			request.setAttribute("rawjson", jsonstr);
			transorder = RequestUtil.convertJson2Obj(jsonstr, TokenVO.class);
		} catch (Exception e) {
			log.error(String.format("获取订单参数出错"),e);
			rm.mergeException(ValidateException.ERROR_PARAM_FORMAT_ERROR.cloneAndAppend(null, "订单参数"));
			return rm;
		}
		
		String messagebase = "查询用户安全信息";
		rm.setBaseErrorCode(210700);
		rm.setErrmsg(messagebase+"成功");
		try {
			//获取url以作为method的内容
			String requestURI = request.getRequestURI();
			requestURI=requestURI.replace(request.getContextPath(), "");
			
			PropertiesUtil pu = new PropertiesUtil();
			TokenBodyVO body=transorder.getBody();
			
			if(log.isDebugEnabled()){
				log.debug("检验通过，获取请求");
			}
			
			User user=userSer.queryUserByToken(body.getToken());
			UserAuth userAuth=new UserAuth();
			userAuth=userSer.queryUserAuth(user.getId());
			UserSecurityInfoVO userInfo=new UserSecurityInfoVO();
			userInfo.setEmail(user.getEmail());
			userInfo.setMobileNum(user.getMobileNum());
			userInfo.setNickname(user.getNickName());
			UserSecurityDetailVO realname=new UserSecurityDetailVO();
			realname.setCardID(userAuth.getIdentityNo());
			realname.setName(userAuth.getRealName());
			realname.setIsRealName(userAuth.getRealNameVerify());
			userInfo.setRealname(realname);
			
			rm.put("user",userInfo);
		} catch (Exception e1) {
			log.error(String.format(messagebase+"失败"),e1);
			rm.mergeException(e1);
			rm.setErrmsg(messagebase+"失败,"+rm.getErrmsg());
		}
		return rm;
	}
	
	@RequestMapping(value = "/forgetPassword", method = RequestMethod.POST)
	public @ResponseBody Object forgetPassword(HttpServletRequest request) {
		
		ForgetPasswordVO transorder;
		ResultModel rm = new ResultModel();
		try {
			String jsonstr = RequestUtil.getRequestPostData(request);
			request.setAttribute("rawjson", jsonstr);
			transorder = RequestUtil.convertJson2Obj(jsonstr,ForgetPasswordVO.class);
		} catch (Exception e) {
			log.error(String.format("获取订单参数出错"),e);
			rm.mergeException(ValidateException.ERROR_PARAM_FORMAT_ERROR.cloneAndAppend(null, "订单参数"));
			return rm;
		}
		
		String messagebase = "重置登录密码";
		rm.setBaseErrorCode(211500);
		rm.setErrmsg(messagebase+"成功");
		try {
			//获取url以作为method的内容
			String requestURI = request.getRequestURI();
			requestURI=requestURI.replace(request.getContextPath(), "");
			Map validateAuth = (Map) authService.validateAuth(transorder);
			String appkey = ObjectUtils.toString(validateAuth.get("appKey"));
			//备注字段必填
			PropertiesUtil pu = new PropertiesUtil();
			ForgetPasswordBodyVO body=transorder.getBody();
			ValidateUtil.validateMobile(body.getMobileNum());
			ValidateUtil.assertNull(body.getLoginPassword(), "新登录密码不能为空");
			if(log.isDebugEnabled()){
				log.debug("检验通过，获取请求");
			}
			boolean authCodeSuccess = genSer.validateSMSCode(transorder.getApp()
					.getAppId(), body.getMobileNum(), body.getSmsCode(),true);
			if (!authCodeSuccess) {
				if (log.isDebugEnabled()) {
					log.debug(String.format("验证码不正确,%s", body));
				}
				rm.mergeException(ValidateException.ERROR_MATCH_SMSCODE);
				return rm;
			}
			
			User user=userSer.queryUserByMobile(body.getMobileNum());
			if(user==null){
				if (log.isDebugEnabled()) {
					log.debug(String.format("手机号[%s]未注册",body.getMobileNum()));
				}
				throw new MaAccountException(MaAccountException.ERR_USER_EXCEPTION,"该手机号未注册！");
			}
			UserPassword password=userSer.queryUserPassword(user.getId());
			//尝试进行解密
			if(StringUtils.isNotBlank(body.getLoginPassword())){
				try {
					String tradePassword = DESUtil.decodeDES(body.getLoginPassword(), appkey);
					password.setPassword(tradePassword);
					userSer.updateUserPassword(password);
				} catch (Exception e) {
					log.error(String.format("支付密码des解密出错"),e);
					throw ValidateException.ERROR_PARAM_FORMAT_ERROR.clone(e,"支付密码des解密出错");
					
				}
			}
			
			
			
		} catch (Exception e1) {
			log.error(String.format(messagebase+"失败"),e1);
			rm.mergeException(e1);
			rm.setErrmsg(messagebase+"失败,"+rm.getErrmsg());
		}		
		return rm;
	}
	
	@RequestMapping(value = "/updateLoginPassword", method = RequestMethod.POST)
	public @ResponseBody Object updateLoginPassword(HttpServletRequest request) {
		
		UpdateLoginPasswordVO transorder;
		ResultModel rm = new ResultModel();
		try {
			String jsonstr = RequestUtil.getRequestPostData(request);
			request.setAttribute("rawjson", jsonstr);
			transorder = RequestUtil.convertJson2Obj(jsonstr,UpdateLoginPasswordVO.class);
		} catch (Exception e) {
			log.error(String.format("获取订单参数出错"),e);
			rm.mergeException(ValidateException.ERROR_PARAM_FORMAT_ERROR.cloneAndAppend(null, "订单参数"));
			return rm;
		}
		
		String messagebase = "修改登录密码";
		rm.setBaseErrorCode(210800);
		rm.setErrmsg(messagebase+"成功");
		try {
			//获取url以作为method的内容
			String requestURI = request.getRequestURI();
			requestURI=requestURI.replace(request.getContextPath(), "");
			Map validateAuth = (Map) authService.validateAuth(transorder);
			String appkey = ObjectUtils.toString(validateAuth.get("appKey"));
			//备注字段必填
			PropertiesUtil pu = new PropertiesUtil();
			UpdateLoginPasswordBodyVO body=transorder.getBody();
			ValidateUtil.assertNull(body.getOldLoginPassword(), "新登录密码不能为空");
			if(log.isDebugEnabled()){
				log.debug("检验通过，获取请求");
			}

			User user=userSer.queryUserByToken(body.getToken());
			boolean authCodeSuccess = genSer.validateSMSCode(transorder.getApp()
					.getAppId(), user.getMobileNum(), body.getSmsCode(),true);
			if (!authCodeSuccess) {
				if (log.isDebugEnabled()) {
					log.debug(String.format("验证码不正确,%s", body));
				}
				rm.mergeException(ValidateException.ERROR_MATCH_SMSCODE);
				return rm;
			}
			UserPassword userPassword=userSer.queryUserPassword(user.getId());
			String oldLoginPassword=null;
			if(StringUtils.isNotBlank(body.getOldLoginPassword())){
				try {
					oldLoginPassword= DESUtil.decodeDES(body.getOldLoginPassword(), appkey);
					
				} catch (Exception e) {
					log.error(String.format("登录密码des解密出错"),e);
					throw ValidateException.ERROR_PARAM_FORMAT_ERROR.clone(e,"登录密码des解密出错");
					
				}
			}
			if(!StringUtils.equals(oldLoginPassword, userPassword.getPassword())){
				if (log.isDebugEnabled()) {
					log.debug("原登录密码错误");
				}
				throw new MaAccountException(MaAccountException.ERR_ACCOUNT_EXCEPTION,"原登录密码错误");
				
			}
			if(StringUtils.isNotBlank(body.getNewLoginPassword())){
				try {
					String newLoginPassword = DESUtil.decodeDES(body.getNewLoginPassword(), appkey);
					userPassword.setPassword(newLoginPassword);
					userSer.updateUserPassword(userPassword);
				} catch (Exception e) {
					log.error(String.format("登录密码des解密出错"),e);
					throw ValidateException.ERROR_PARAM_FORMAT_ERROR.clone(e,"登录密码des解密出错");
					
				}
			}
			
			
		} catch (Exception e1) {
			log.error(String.format(messagebase+"失败"),e1);
			rm.mergeException(e1);
			rm.setErrmsg(messagebase+"失败,"+rm.getErrmsg());
		}		
		return rm;
	}
	
	
	@RequestMapping(value = "/updateTradePassword", method = RequestMethod.POST)
	public @ResponseBody Object updateTradePassword(HttpServletRequest request) {
		
		UpdateTradePasswordVO transorder;
		ResultModel rm = new ResultModel();
		try {
			String jsonstr = RequestUtil.getRequestPostData(request);
			request.setAttribute("rawjson", jsonstr);
			transorder = RequestUtil.convertJson2Obj(jsonstr,UpdateTradePasswordVO.class);
		} catch (Exception e) {
			log.error(String.format("获取订单参数出错"),e);
			rm.mergeException(ValidateException.ERROR_PARAM_FORMAT_ERROR.cloneAndAppend(null, "订单参数"));
			return rm;
		}
		
		String messagebase = "修改交易密码";
		rm.setBaseErrorCode(210900);
		rm.setErrmsg(messagebase+"成功");
		try {
			//获取url以作为method的内容
			String requestURI = request.getRequestURI();
			requestURI=requestURI.replace(request.getContextPath(), "");
			Map validateAuth = (Map) authService.validateAuth(transorder);
			String appkey = ObjectUtils.toString(validateAuth.get("appKey"));
			//备注字段必填
			PropertiesUtil pu = new PropertiesUtil();
			UpdateTradePasswordBodyVO body=transorder.getBody();
			ValidateUtil.assertNull(body.getOldTradePassword(), "新交易密码不能为空");
			if(log.isDebugEnabled()){
				log.debug("检验通过，获取请求");
			}

			User user=userSer.queryUserByToken(body.getToken());
			boolean authCodeSuccess = genSer.validateSMSCode(transorder.getApp()
					.getAppId(), user.getMobileNum(), body.getSmsCode(),true);
			if (!authCodeSuccess) {
				if (log.isDebugEnabled()) {
					log.debug(String.format("验证码不正确,%s", body));
				}
				rm.mergeException(ValidateException.ERROR_MATCH_SMSCODE);
				return rm;
			}
			UserPassword userPassword=userSer.queryUserPassword(user.getId());
			String tradePassword =null;
			if(StringUtils.isNotBlank(body.getOldTradePassword())){
				try {
					tradePassword = DESUtil.decodeDES(body.getOldTradePassword(), appkey);
					
				} catch (Exception e) {
					log.error(String.format("支付密码des解密出错"),e);
					throw ValidateException.ERROR_PARAM_FORMAT_ERROR.clone(e,"支付密码des解密出错");
					
				}
			}
			if(!StringUtils.equals(tradePassword, userPassword.getTradePassword())){
				if (log.isDebugEnabled()) {
					log.debug("原交易密码错误");
				}
				throw new MaAccountException(MaAccountException.ERR_ACCOUNT_EXCEPTION,"原交易密码错误");
				
			}
			if(StringUtils.isNotBlank(body.getNewTradePassword())){
				try {
					String newtradePassword = DESUtil.decodeDES(body.getNewTradePassword(), appkey);
					userPassword.setTradePassword(newtradePassword);
					userSer.updateUserPassword(userPassword);
				} catch (Exception e) {
					log.error(String.format("支付密码des解密出错"),e);
					throw ValidateException.ERROR_PARAM_FORMAT_ERROR.clone(e,"支付密码des解密出错");
					
				}
			}
			
			
		} catch (Exception e1) {
			log.error(String.format(messagebase+"失败"),e1);
			rm.mergeException(e1);
			rm.setErrmsg(messagebase+"失败,"+rm.getErrmsg());
		}		
		return rm;
	}
	@RequestMapping(value = "/updateMobileNum", method = RequestMethod.POST)
	public @ResponseBody Object updateMobileNum(HttpServletRequest request) {
		
		UpdateMobileNumVO transorder;
		ResultModel rm = new ResultModel();
		try {
			String jsonstr = RequestUtil.getRequestPostData(request);
			request.setAttribute("rawjson", jsonstr);
			transorder = RequestUtil.convertJson2Obj(jsonstr,UpdateMobileNumVO.class);
		} catch (Exception e) {
			log.error(String.format("获取订单参数出错"),e);
			rm.mergeException(ValidateException.ERROR_PARAM_FORMAT_ERROR.cloneAndAppend(null, "订单参数"));
			return rm;
		}
		
		String messagebase = "修改绑定手机号码";
		rm.setBaseErrorCode(211000);
		rm.setErrmsg(messagebase+"成功");
		try {
			//获取url以作为method的内容
			String requestURI = request.getRequestURI();
			requestURI=requestURI.replace(request.getContextPath(), "");
			Map validateAuth = (Map) authService.validateAuth(transorder);
			String appkey = ObjectUtils.toString(validateAuth.get("appKey"));
			//备注字段必填
			UpdateMobileNumBodyVO body=transorder.getBody();
			ValidateUtil.validateMobile(body.getOldMobileNum());
			ValidateUtil.validateMobile(body.getNewMobileNum());
			ValidateUtil.assertEmpty(body.getLoginPassword(),"登录密码不能为空");
			if(log.isDebugEnabled()){
				log.debug("检验通过，获取请求");
			}

			User user=userSer.queryUserByToken(body.getToken());
			boolean authOldCodeSuccess = genSer.validateSMSCode(transorder.getApp()
					.getAppId(),body.getOldMobileNum(), body.getFirstSmsCode(),true);
			if (!authOldCodeSuccess) {
				if (log.isDebugEnabled()) {
					log.debug(String.format("旧手机号【%s】验证码不正确", body.getOldMobileNum()));
				}
				rm.mergeException(ValidateException.ERROR_MATCH_SMSCODE);
				return rm;
			}
			boolean authNewCodeSuccess = genSer.validateSMSCode(transorder.getApp()
					.getAppId(),body.getNewMobileNum(), body.getSecondSmsCode(),true);
			if (!authNewCodeSuccess) {
				if (log.isDebugEnabled()) {
					log.debug(String.format("新手机号【%s】验证码不正确", body.getNewMobileNum()));
				}
				rm.mergeException(ValidateException.ERROR_MATCH_SMSCODE);
				return rm;
			}
			UserPassword userPassword=userSer.queryUserPassword(user.getId());
			String oldLoginPassword=null;
			if(StringUtils.isNotBlank(body.getLoginPassword())){
				try {
					oldLoginPassword= DESUtil.decodeDES(body.getLoginPassword(), appkey);
					
				} catch (Exception e) {
					log.error(String.format("登录密码des解密出错"),e);
					throw ValidateException.ERROR_PARAM_FORMAT_ERROR.clone(e,"登录密码des解密出错");
					
				}
			}
			if(!StringUtils.equals(oldLoginPassword, userPassword.getPassword())){
				if (log.isDebugEnabled()) {
					log.debug("登录密码错误");
				}
				throw new MaAccountException(MaAccountException.ERR_ACCOUNT_EXCEPTION,"登录密码错误");
				
			}
			user.setMobileNum(body.getNewMobileNum());
			userSer.updateUser(user);
			
		} catch (Exception e1) {
			log.error(String.format(messagebase+"失败"),e1);
			rm.mergeException(e1);
			rm.setErrmsg(messagebase+"失败,"+rm.getErrmsg());
		}		
		return rm;
	}
	
	/**
	 * 向服务器请求下发验证码
	 * 
	 * @param getsmsvo
	 * @return
	 */
	@RequestMapping("/getSmsCode")
	public @ResponseBody Object getSmsCode(HttpServletRequest request) {

		MobileNumVO transorder;
		ResultModel rm = new ResultModel();
		try {
			String jsonstr = RequestUtil.getRequestPostData(request);
			request.setAttribute("rawjson", jsonstr);
			transorder = RequestUtil.convertJson2Obj(jsonstr,MobileNumVO.class);
		} catch (Exception e) {
			log.error(String.format("获取订单参数出错"),e);
			rm.mergeException(ValidateException.ERROR_PARAM_FORMAT_ERROR.cloneAndAppend(null, "订单参数"));
			return rm;
		}
		if (log.isDebugEnabled()) {
			log.debug("向服务器请求下发验证码：" + transorder);
		}
		// 捕捉所有异常,不要由于有异常而不返回信息
		int baseerrcode = 211400;
		rm.setBaseErrorCode(baseerrcode);
		rm.setErrmsg("发送短信验证码成功");
		
//		GetSmsVo getsmsvo
		try {
			MobileVO body=transorder.getBody();
			ValidateUtil.validateMobile(body.getMobileNum());
			// 校验token
			Object validateAuth = authService.validateAuth(transorder);
			if (log.isDebugEnabled()) {
				log.debug("检验通过，发送验证码");
			}
			// 检查手机
			// User user = userDao.selectByMobile(getsmsvo.getMobileNum());
			// ValidateUtil.assertNull(user, "手机号码未注册", 4111);
			
			UserToken createToken = smsService.createToken(transorder.getApp()
					.getAppId(), body.getMobileNum(), 4);
			String content = AuthCodeUtil.getAuthCodeByTemplate(
					createToken.getToken(), "sms.authcode");
			// 调用webservice 发送模板
			if (log.isDebugEnabled()) {
				log.debug("发送手机验证码请求:" + content);
			}

			try {
				PropertiesUtil pu = new PropertiesUtil();
				boolean deleteaftervalidate = pu.getBoolean("smscode.fortest");
				if(deleteaftervalidate){
					if (log.isDebugEnabled()) {
						log.debug(String.format("测试开启，不发送验证码到手机"));
					}
				}
				else{
					SmsSenderUtil.sendSms(body.getMobileNum(), content);
					
					if (log.isDebugEnabled()) {
						log.debug("验证码发送成功");
					}
				}

			} catch (Exception e) {
				log.error("发送验证码出错:", e);
				rm.mergeException(e);
			}

		} catch (Exception e1) {
			log.error(String.format("发送短信验证码[%s]，处理失败", transorder), e1);
			rm.mergeException(e1);
		} finally {
			if (log.isDebugEnabled()) {
				log.debug("向服务器请求下发验证码完成");
			}
		}
		return rm;
	}
	
	@RequestMapping(value = "/verifySmsCodeOnly", method = RequestMethod.POST)
	public @ResponseBody Object verifySmsCodeOnly(HttpServletRequest request) {
		
		final BaseTransVO<VerifySmsCodeVO> transorder;
		ResultModel rm = new ResultModel();
		try {
			String jsonstr = RequestUtil.getRequestPostData(request);
			request.setAttribute("rawjson", jsonstr);
			transorder = RequestUtil.convertJson2Obj(jsonstr,BaseTransVO.class,VerifySmsCodeVO.class);
		} catch (Exception e) {
			log.error(String.format("获取订单参数出错"),e);
			rm.mergeException(ValidateException.ERROR_PARAM_FORMAT_ERROR.cloneAndAppend(null, "订单参数"));
			return rm;
		}
		
		String messagebase = "校验验证码";
		rm.setBaseErrorCode(220200);
		rm.setErrmsg(messagebase+"成功");
		try {
			//获取url以作为method的内容
			String requestURI = request.getRequestURI();
			requestURI=requestURI.replace(request.getContextPath(), "");
			
			//备注字段必填
			PropertiesUtil pu = new PropertiesUtil();
			VerifySmsCodeVO body=transorder.getBody();
			ValidateUtil.validateMobile(body.getMobileNum());
			if(log.isDebugEnabled()){
				log.debug("检验通过，获取请求");
			}

			boolean authCodeSuccess = genSer.validateSMSCode(transorder.getApp()
					.getAppId(), body.getMobileNum(), body.getSmsCode(),false);
			if (!authCodeSuccess) {
				if (log.isDebugEnabled()) {
					log.debug(String.format("验证码不正确,%s", body));
				}
				rm.mergeException(ValidateException.ERROR_MATCH_SMSCODE);
				return rm;
			}
			
			
		} catch (Exception e1) {
			log.error(String.format(messagebase+"失败"),e1);
			rm.mergeException(e1);
			rm.setErrmsg(messagebase+"失败,"+rm.getErrmsg());
		}		
		return rm;
	}
}
