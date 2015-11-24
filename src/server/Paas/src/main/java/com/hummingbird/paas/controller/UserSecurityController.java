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
import com.hummingbird.common.vo.ResultModel;
import com.hummingbird.commonbiz.vo.BaseTransVO;
import com.hummingbird.commonbiz.vo.UserToken;
import com.hummingbird.paas.entity.ProjectAccount;
import com.hummingbird.paas.entity.User;
import com.hummingbird.paas.entity.UserPassword;
import com.hummingbird.paas.services.UserService;
import com.hummingbird.paas.util.IDCardUtil;
import com.hummingbird.paas.vo.CapitalSurveyReturnVO;
import com.hummingbird.paas.vo.LoginReturnVO;
import com.hummingbird.paas.vo.LoginVO;
import com.hummingbird.paas.vo.RealNameVO;
import com.hummingbird.paas.vo.TokenBodyVO;
import com.hummingbird.paas.vo.TokenVO;

@Controller
@RequestMapping("/userSecurity")
public class UserSecurityController extends BaseController{
	@Autowired 
	UserService userSer;

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
				}throw new ValidateException().ERROR_MATCH_USER;
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
			CapitalSurveyReturnVO survey=new CapitalSurveyReturnVO();
			/*if(user!=null){
				ProjectAccount proActInfo=capitalManageSer.queryAccountInfo(user.getId());
				if(proActInfo!=null){
					survey.setBalance(proActInfo.getRemainingSum().toString());
					survey.setFreezeAmount(proActInfo.getFrozenSum().toString());
					survey.setIncome(capitalManageSer.getAccountIncome(proActInfo.getAccountId()).toString());
					survey.setOutlay(capitalManageSer.getAccountOutlay(proActInfo.getAccountId()).toString());					
				}
			}*/
			
			rm.put("myCapitalInfo",survey);
		} catch (Exception e1) {
			log.error(String.format(messagebase+"失败"),e1);
			rm.mergeException(e1);
			rm.setErrmsg(messagebase+"失败,"+rm.getErrmsg());
		}
		return rm;
	}
	
}
