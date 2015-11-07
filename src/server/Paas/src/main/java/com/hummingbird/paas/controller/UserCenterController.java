package com.hummingbird.paas.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hummingbird.common.controller.BaseController;
import com.hummingbird.common.exception.ValidateException;
import com.hummingbird.common.util.PropertiesUtil;
import com.hummingbird.common.util.RequestUtil;
import com.hummingbird.common.vo.ResultModel;
import com.hummingbird.commonbiz.vo.UserToken;
import com.hummingbird.paas.entity.User;
import com.hummingbird.paas.entity.UserSmscode;
import com.hummingbird.paas.exception.MaAccountException;
import com.hummingbird.paas.mapper.UserSmscodeMapper;
import com.hummingbird.paas.services.GeneralService;
import com.hummingbird.paas.services.UserService;
import com.hummingbird.paas.vo.RegisterBodyVO;
import com.hummingbird.paas.vo.RegisterVO;

@Controller
@RequestMapping("/userCenter")
public class UserCenterController extends BaseController{

	@Autowired
	UserService userSer;
	@Autowired
	GeneralService genSer;
	
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
				userSer.saveUser(body, transorder.getApp().getAppId());
			}
			
			
			
		} catch (Exception e1) {
			log.error(String.format(messagebase+"失败"),e1);
			rm.mergeException(e1);
			rm.setErrmsg(messagebase+"失败,"+rm.getErrmsg());
		}
		
		
		return rm;
	}
	
	
}
