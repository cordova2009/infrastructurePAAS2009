package com.hummingbird.paas.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
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
import com.hummingbird.common.vo.ResultModel;
import com.hummingbird.commonbiz.service.IAuthenticationService;
import com.hummingbird.commonbiz.vo.BaseTransVO;
import com.hummingbird.commonbiz.vo.UserToken;
import com.hummingbird.paas.entity.User;
import com.hummingbird.paas.entity.UserAuth;
import com.hummingbird.paas.entity.UserBankcard;
import com.hummingbird.paas.entity.UserPassword;
import com.hummingbird.paas.entity.UserSmscode;
import com.hummingbird.paas.exception.MaAccountException;
import com.hummingbird.paas.mapper.UserSmscodeMapper;
import com.hummingbird.paas.services.GeneralService;
import com.hummingbird.paas.services.TokenService;
import com.hummingbird.paas.services.UserService;
import com.hummingbird.paas.vo.BankInfoReturnDetailVO;
import com.hummingbird.paas.vo.LoginReturnVO;
import com.hummingbird.paas.vo.LoginVO;
import com.hummingbird.paas.vo.MobileVO;
import com.hummingbird.paas.vo.RegisterBodyVO;
import com.hummingbird.paas.vo.RegisterVO;
import com.hummingbird.paas.vo.TokenBodyVO;
import com.hummingbird.paas.vo.TokenQueryVO;
import com.hummingbird.paas.vo.TokenVO;
import com.hummingbird.paas.vo.UpdateHeadImageBodyVO;
import com.hummingbird.paas.vo.UpdateUserInfoBodyVO;
import com.hummingbird.paas.vo.UserBaseInfoVO;

@Controller
@RequestMapping("/userCenter")
public class UserCenterController extends BaseController{

	@Autowired
	UserService userSer;
	@Autowired
	GeneralService genSer;
	@Autowired
	IAuthenticationService authService;
	@Autowired
	TokenService tokenSrv;
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public @ResponseBody Object register(HttpServletRequest request) {
		
		RegisterVO transorder;
		ResultModel rm = new ResultModel();
		try {
			String jsonstr = RequestUtil.getRequestPostData(request);
			request.setAttribute("rawjson", jsonstr);
			transorder = RequestUtil.convertJson2Obj(jsonstr, RegisterVO.class);
		} catch (Exception e) {
			log.error(String.format("获取订单参数出错"),e);
			rm.mergeException(ValidateException.ERROR_PARAM_FORMAT_ERROR.cloneAndAppend(null, "订单参数"));
			return rm;
		}
		
		String messagebase = "用户注册";
		rm.setBaseErrorCode(210300);
		rm.setErrmsg(messagebase+"成功");
		try {
			//获取url以作为method的内容
			String requestURI = request.getRequestURI();
			requestURI=requestURI.replace(request.getContextPath(), "");
			Map validateAuth = (Map) authService.validateAuth(transorder);
			String appkey = ObjectUtils.toString(validateAuth.get("appKey"));
			//备注字段必填
			PropertiesUtil pu = new PropertiesUtil();
			RegisterBodyVO body=transorder.getBody();
			
			
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
			if(user!=null){
				if (log.isDebugEnabled()) {
					log.debug(String.format("手机号[%s]已注册",body.getMobileNum()));
				}
				throw new MaAccountException(MaAccountException.ERR_USER_EXCEPTION,"该手机号已注册，请直接登录！");
			}
			
			if (log.isDebugEnabled()) {
				log.debug(String.format("校验通过，现在为手机号码%s创建帐户",
						body.getMobileNum()));
			}
			if (user == null) {
				// 注册
				userSer.saveUser(body, transorder.getApp().getAppId(),appkey);
			}
			
			
			
		} catch (Exception e1) {
			log.error(String.format(messagebase+"失败"),e1);
			rm.mergeException(e1);
			rm.setErrmsg(messagebase+"失败,"+rm.getErrmsg());
		}
		
		
		return rm;
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public @ResponseBody Object login(HttpServletRequest request) {
		
		final BaseTransVO<LoginVO> transorder;
		ResultModel rm = new ResultModel();
		try {
			String jsonstr = RequestUtil.getRequestPostData(request);
			request.setAttribute("rawjson", jsonstr);
			transorder = RequestUtil.convertJson2Obj(jsonstr,BaseTransVO.class, LoginVO.class);
		} catch (Exception e) {
			log.error(String.format("获取订单参数出错"),e);
			rm.mergeException(ValidateException.ERROR_PARAM_FORMAT_ERROR.cloneAndAppend(null, "订单参数"));
			return rm;
		}
		
		String messagebase = "用户登录";
		rm.setBaseErrorCode(210400);
		rm.setErrmsg(messagebase+"成功");
		try {
			//获取url以作为method的内容
			String requestURI = request.getRequestURI();
			Map validateAuth = (Map) authService.validateAuth(transorder);
			String appkey = ObjectUtils.toString(validateAuth.get("appKey"));
			requestURI=requestURI.replace(request.getContextPath(), "");
			//备注字段必填
			PropertiesUtil pu = new PropertiesUtil();
			LoginVO body=transorder.getBody();
			
			
			if(log.isDebugEnabled()){
				log.debug("检验通过，获取请求");
			}
			
			User user=userSer.queryUserByMobile(body.getMobileNum());
			if(user==null){
				if (log.isDebugEnabled()) {
					log.debug(String.format("手机号码%s未注册",body.getMobileNum()));
				}
				throw ValidateException.ERROR_EXISTING_USER_NOT_EXISTS;
			}
			UserPassword userPassword=userSer.queryUserPassword(user.getId());
			if(userPassword==null){
				if (log.isDebugEnabled()) {
					log.debug(String.format("手机号【%s】密码查询失败或未设置",body.getMobileNum()));
				}
				throw ValidateException.ERROR_MATCH_PASSWORD;
			}
			String loginPassword=null;
			if(StringUtils.isNotBlank(body.getLoginPassword())){
				try {
					loginPassword = DESUtil.decodeDES(body.getLoginPassword(), appkey);
					
				} catch (Exception e) {
					log.error(String.format("登录密码des解密出错"),e);
					throw ValidateException.ERROR_PARAM_FORMAT_ERROR.clone(e,"登录密码des解密出错");
					
				}
			}
			if(!userPassword.getPassword().equals(loginPassword)){
				if (log.isDebugEnabled()) {
					log.debug(String.format("登录密码不正确"));
				}
				throw ValidateException.ERROR_MATCH_PASSWORD;
				
			}
			UserToken selectToken = tokenSrv.getOrCreateToken(transorder.getApp()
					.getAppId(), user.getId());
			LoginReturnVO userInfo=new LoginReturnVO();
			userInfo.setToken(selectToken.getToken());
			userInfo.setHeadImageUrl(user.getHeadImage());
			userInfo.setMobileNum(user.getMobileNum());
			userInfo.setNickname(user.getNickName());
			userInfo.setExpireIn(selectToken.getExpirein());
			rm.put("user", userInfo);
			
			
			
		} catch (Exception e1) {
			log.error(String.format(messagebase+"失败"),e1);
			rm.mergeException(e1);
			rm.setErrmsg(messagebase+"失败,"+rm.getErrmsg());
		}
		
		
		return rm;
	}
	
	@RequestMapping(value = "/getUserBaseInfo", method = RequestMethod.POST)
	public @ResponseBody Object getUserBaseInfo(HttpServletRequest request) {
		
		TokenVO transorder;
		ResultModel rm = new ResultModel();
		try {
			String jsonstr = RequestUtil.getRequestPostData(request);
			request.setAttribute("rawjson", jsonstr);
			transorder = RequestUtil.convertJson2Obj(jsonstr,TokenVO.class);
		} catch (Exception e) {
			log.error(String.format("获取订单参数出错"),e);
			rm.mergeException(ValidateException.ERROR_PARAM_FORMAT_ERROR.cloneAndAppend(null, "订单参数"));
			return rm;
		}
		
		String messagebase = "查看帐户基础信息";
		rm.setBaseErrorCode(210600);
		rm.setErrmsg(messagebase+"成功");
		try {
			//获取url以作为method的内容
			String requestURI = request.getRequestURI();
			Map validateAuth = (Map) authService.validateAuth(transorder);
			String appkey = ObjectUtils.toString(validateAuth.get("appKey"));
			requestURI=requestURI.replace(request.getContextPath(), "");
			//备注字段必填
			PropertiesUtil pu = new PropertiesUtil();
			TokenBodyVO body=transorder.getBody();
			
			
			if(log.isDebugEnabled()){
				log.debug("检验通过，获取请求");
			}
			
			User user=userSer.queryUserByToken(body.getToken());
			UserBaseInfoVO userInfo=new UserBaseInfoVO();
			userInfo.setAddress(user.getAddress());
			userInfo.setEmail(user.getEmail());
			userInfo.setHeadImageUrl(user.getEmail());
			userInfo.setMobileNum(user.getMobileNum());
			userInfo.setNickname(user.getNickName());
			UserAuth userAuth=userSer.queryUserAuth(user.getId());
			userInfo.setCardID(userAuth.getIdentityNo());
			userInfo.setRealName(userAuth.getRealName());
			rm.put("user", userInfo);
			
			
			
		} catch (Exception e1) {
			log.error(String.format(messagebase+"失败"),e1);
			rm.mergeException(e1);
			rm.setErrmsg(messagebase+"失败,"+rm.getErrmsg());
		}
		
		
		return rm;
	}
	@RequestMapping(value = "/getMyBankInfo", method = RequestMethod.POST)
	public @ResponseBody Object getMyBankInfo(HttpServletRequest request) {
		
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
		
		String messagebase = "查询我的银行账号信息";
		rm.setBaseErrorCode(211100);
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
			List<BankInfoReturnDetailVO> Beelist=new ArrayList<BankInfoReturnDetailVO>();
			List<BankInfoReturnDetailVO> Berlist=new ArrayList<BankInfoReturnDetailVO>();
			if(user!=null){
				List<UserBankcard> bankcards=userSer.queryBankListByUserId(user.getId());
				for(UserBankcard ba:bankcards){
					BankInfoReturnDetailVO bank=new BankInfoReturnDetailVO();
					bank.setBankId(ba.getId());
					bank.setAccountName(ba.getAccountName());
					bank.setBank(ba.getBankName());
					bank.setAccountId(ba.getAccountNo());
					if(StringUtils.equals(ba.getUser(),"BEE")){
						Beelist.add(bank);
					}else if(StringUtils.equals(ba.getUser(),"BER")){
						Berlist.add(bank);
					}
					
				}
			}
			rm.put("BeebankInfo", Beelist);
			rm.put("BerbankInfo", Berlist);
			
		} catch (Exception e1) {
			log.error(String.format(messagebase+"失败"),e1);
			rm.mergeException(e1);
			rm.setErrmsg(messagebase+"失败,"+rm.getErrmsg());
		}
		return rm;
	}
	@RequestMapping(value = "/getUserStatus", method = RequestMethod.POST)
	public @ResponseBody Object getUserStatus(HttpServletRequest request) {
		
		final BaseTransVO<MobileVO> transorder;
		ResultModel rm = new ResultModel();
		try {
			String jsonstr = RequestUtil.getRequestPostData(request);
			request.setAttribute("rawjson", jsonstr);
			transorder = RequestUtil.convertJson2Obj(jsonstr,BaseTransVO.class,MobileVO.class);
		} catch (Exception e) {
			log.error(String.format("获取订单参数出错"),e);
			rm.mergeException(ValidateException.ERROR_PARAM_FORMAT_ERROR.cloneAndAppend(null, "订单参数"));
			return rm;
		}
		
		String messagebase = "查询用户状态";
		rm.setBaseErrorCode(210500);
		rm.setErrmsg(messagebase+"成功");
		try {
			//获取url以作为method的内容
			String requestURI = request.getRequestURI();
			Map validateAuth = (Map) authService.validateAuth(transorder);
			String appkey = ObjectUtils.toString(validateAuth.get("appKey"));
			requestURI=requestURI.replace(request.getContextPath(), "");
			//备注字段必填
			PropertiesUtil pu = new PropertiesUtil();
			MobileVO body=transorder.getBody();
			
			
			if(log.isDebugEnabled()){
				log.debug("检验通过，获取请求");
			}
			
			User user=userSer.queryUserByMobile(body.getMobileNum());
			if(user==null){
				rm.put("status", "FLS");
			}else{
				rm.put("status", "OK#");
			}
			
		} catch (Exception e1) {
			log.error(String.format(messagebase+"失败"),e1);
			rm.mergeException(e1);
			rm.setErrmsg(messagebase+"失败,"+rm.getErrmsg());
		}
		
		
		return rm;
	}
	
	@RequestMapping(value = "/updateHeadImage", method = RequestMethod.POST)
	public @ResponseBody Object updateHeadImage(HttpServletRequest request) {
		
		final BaseTransVO<UpdateHeadImageBodyVO> transorder;
		ResultModel rm = new ResultModel();
		try {
			String jsonstr = RequestUtil.getRequestPostData(request);
			request.setAttribute("rawjson", jsonstr);
			transorder = RequestUtil.convertJson2Obj(jsonstr,BaseTransVO.class,UpdateHeadImageBodyVO.class);
		} catch (Exception e) {
			log.error(String.format("获取订单参数出错"),e);
			rm.mergeException(ValidateException.ERROR_PARAM_FORMAT_ERROR.cloneAndAppend(null, "订单参数"));
			return rm;
		}
		
		String messagebase = "修改用户头像";
		rm.setBaseErrorCode(211200);
		rm.setErrmsg(messagebase+"成功");
		try {
			//获取url以作为method的内容
			String requestURI = request.getRequestURI();
			requestURI=requestURI.replace(request.getContextPath(), "");
			//备注字段必填
			PropertiesUtil pu = new PropertiesUtil();
			UpdateHeadImageBodyVO body=transorder.getBody();
			
			
			if(log.isDebugEnabled()){
				log.debug("检验通过，获取请求");
			}
			

			User user=userSer.queryUserByToken(body.getToken());
			user.setHeadImage(body.getHeadImageUrl());
			userSer.updateUser(user);
			
		} catch (Exception e1) {
			log.error(String.format(messagebase+"失败"),e1);
			rm.mergeException(e1);
			rm.setErrmsg(messagebase+"失败,"+rm.getErrmsg());
		}		
		return rm;
	}
	
	@RequestMapping(value = "/updateUserInfo", method = RequestMethod.POST)
	public @ResponseBody Object updateUserInfo(HttpServletRequest request) {
		
		final BaseTransVO<UpdateUserInfoBodyVO> transorder;
		ResultModel rm = new ResultModel();
		try {
			String jsonstr = RequestUtil.getRequestPostData(request);
			request.setAttribute("rawjson", jsonstr);
			transorder = RequestUtil.convertJson2Obj(jsonstr,BaseTransVO.class,UpdateUserInfoBodyVO.class);
		} catch (Exception e) {
			log.error(String.format("获取订单参数出错"),e);
			rm.mergeException(ValidateException.ERROR_PARAM_FORMAT_ERROR.cloneAndAppend(null, "订单参数"));
			return rm;
		}
		
		String messagebase = "修改帐户基础信息";
		rm.setBaseErrorCode(211300);
		rm.setErrmsg(messagebase+"成功");
		try {
			//获取url以作为method的内容
			String requestURI = request.getRequestURI();
			requestURI=requestURI.replace(request.getContextPath(), "");
			//备注字段必填
			PropertiesUtil pu = new PropertiesUtil();
			UpdateUserInfoBodyVO body=transorder.getBody();
			
			
			if(log.isDebugEnabled()){
				log.debug("检验通过，获取请求");
			}
			

			User user=userSer.queryUserByToken(body.getToken());
			if(StringUtils.isBlank(body.getAddress())){
				user.setAddress(body.getAddress());
			}
			if(StringUtils.isBlank(body.getNickname())){
				user.setNickName(body.getNickname());
			}
			if(StringUtils.isBlank(body.getEmail())){
				user.setEmail(body.getEmail());
			}
			userSer.updateUser(user);
			
		} catch (Exception e1) {
			log.error(String.format(messagebase+"失败"),e1);
			rm.mergeException(e1);
			rm.setErrmsg(messagebase+"失败,"+rm.getErrmsg());
		}		
		return rm;
	}
	
}
