package com.hummingbird.paas.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hummingbird.common.controller.BaseController;
import com.hummingbird.common.exception.ValidateException;
import com.hummingbird.common.face.AbstractAppLog;
import com.hummingbird.common.util.PropertiesUtil;
import com.hummingbird.common.util.RequestUtil;
import com.hummingbird.common.vo.ResultModel;
import com.hummingbird.paas.entity.AppLog;
import com.hummingbird.paas.entity.Bidder;
import com.hummingbird.paas.entity.User;
import com.hummingbird.paas.exception.MaAccountException;
import com.hummingbird.paas.mapper.AppLogMapper;
import com.hummingbird.paas.services.ProjectService;
import com.hummingbird.paas.services.UserService;
import com.hummingbird.paas.vo.ObjectBodyVO;
import com.hummingbird.paas.vo.ObjectVO;
import com.hummingbird.paas.vo.TokenBodyVO;
import com.hummingbird.paas.vo.TokenVO;

@Controller
@RequestMapping(value = "myIncome", method = RequestMethod.POST)
public class BidderProjectController extends BaseController{

	@Autowired 
	UserService userSer;
	@Autowired
	ProjectService projectSer;
	@Autowired(required = true)
	protected AppLogMapper applogDao;
	
	@RequestMapping(value = "/queryMyIncomeList", method = RequestMethod.POST)
	public @ResponseBody Object queryMyIncomeList(HttpServletRequest request) {
		
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
		
		String messagebase = "查询我的中标项目收款情况 ";
		rm.setBaseErrorCode(260100);
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
			Bidder bidder=userSer.queryBidderByUserId(user.getId());
			if(bidder!=null){
				rm.put("list", projectSer.queryMyIncomeList(bidder.getId()));
			}else{
				if (log.isDebugEnabled()) {
					log.debug(String.format("根据用户手机号[%s]查找不到投标人",user.getMobileNum()));
				}
				throw new MaAccountException(MaAccountException.ERR_ACCOUNT_EXCEPTION,String.format("根据用户手机号[%s]查找不到投标人",user.getMobileNum()));
				
			}
		} catch (Exception e1) {
			log.error(String.format(messagebase+"失败"),e1);
			rm.mergeException(e1);
			rm.setErrmsg(messagebase+"失败,"+rm.getErrmsg());
		}
		return rm;
	}
	
	@RequestMapping(value = "/getMyIncomeOverall", method = RequestMethod.POST)
	public @ResponseBody Object getMyIncomeOverall(HttpServletRequest request) {
		
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
		
		String messagebase = "查询我的中标项目收款概况";
		rm.setBaseErrorCode(260200);
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
			Bidder bidder=userSer.queryBidderByUserId(user.getId());
			if(bidder!=null){
				rm.put("overall", projectSer.getMyIncomeOverall(bidder.getId()));
			}else{
				if (log.isDebugEnabled()) {
					log.debug(String.format("根据用户手机号[%s]查找不到投标人",user.getMobileNum()));
				}
				throw new MaAccountException(MaAccountException.ERR_ACCOUNT_EXCEPTION,String.format("根据用户手机号[%s]查找不到投标人",user.getMobileNum()));
				
			}
		} catch (Exception e1) {
			log.error(String.format(messagebase+"失败"),e1);
			rm.mergeException(e1);
			rm.setErrmsg(messagebase+"失败,"+rm.getErrmsg());
		}
		return rm;
	}
	
	@RequestMapping(value = "/queryWillReceiveAmountDetail", method = RequestMethod.POST)
	public @ResponseBody Object queryWillReceiveAmountDetail(HttpServletRequest request) {
		
		ObjectVO transorder;
		ResultModel rm = new ResultModel();
		try {
			String jsonstr = RequestUtil.getRequestPostData(request);
			request.setAttribute("rawjson", jsonstr);
			transorder = RequestUtil.convertJson2Obj(jsonstr, ObjectVO.class);
		} catch (Exception e) {
			log.error(String.format("获取订单参数出错"),e);
			rm.mergeException(ValidateException.ERROR_PARAM_FORMAT_ERROR.cloneAndAppend(null, "订单参数"));
			return rm;
		}
		
		String messagebase = "查询项目待收款款详情";
		rm.setBaseErrorCode(260300);
		rm.setErrmsg(messagebase+"成功");
		try {
			//获取url以作为method的内容
			String requestURI = request.getRequestURI();
			requestURI=requestURI.replace(request.getContextPath(), "");
			
			PropertiesUtil pu = new PropertiesUtil();
			ObjectBodyVO body=transorder.getBody();
			
			if(log.isDebugEnabled()){
				log.debug("检验通过，获取请求");
			}
			
			User user=userSer.queryUserByToken(body.getToken());
			if(user!=null){
				rm.put("list", projectSer.queryWillReceiveAmountDetail(body.getObjectId()));
			}else{
				if (log.isDebugEnabled()) {
					log.debug(String.format("根据用户手机号[%s]查找不到用户",user.getMobileNum()));
				}
				throw new MaAccountException(MaAccountException.ERR_ACCOUNT_EXCEPTION,String.format("根据用户手机号[%s]查找不到用户",user.getMobileNum()));
				
			}
		} catch (Exception e1) {
			log.error(String.format(messagebase+"失败"),e1);
			rm.mergeException(e1);
			rm.setErrmsg(messagebase+"失败,"+rm.getErrmsg());
		}
		return rm;
	}
	
	@RequestMapping(value = "/queryReceivedAmountDetail", method = RequestMethod.POST)
	public @ResponseBody Object queryReceivedAmountDetail(HttpServletRequest request) {
		
		ObjectVO transorder;
		ResultModel rm = new ResultModel();
		try {
			String jsonstr = RequestUtil.getRequestPostData(request);
			request.setAttribute("rawjson", jsonstr);
			transorder = RequestUtil.convertJson2Obj(jsonstr, ObjectVO.class);
		} catch (Exception e) {
			log.error(String.format("获取订单参数出错"),e);
			rm.mergeException(ValidateException.ERROR_PARAM_FORMAT_ERROR.cloneAndAppend(null, "订单参数"));
			return rm;
		}
		
		String messagebase = "查询项目收款详情";
		rm.setBaseErrorCode(260400);
		rm.setErrmsg(messagebase+"成功");
		try {
			//获取url以作为method的内容
			String requestURI = request.getRequestURI();
			requestURI=requestURI.replace(request.getContextPath(), "");
			
			PropertiesUtil pu = new PropertiesUtil();
			ObjectBodyVO body=transorder.getBody();
			
			if(log.isDebugEnabled()){
				log.debug("检验通过，获取请求");
			}
			
			User user=userSer.queryUserByToken(body.getToken());
			if(user!=null){
				rm.put("list", projectSer.queryReceivedAmountDetail(body.getObjectId()));
			}else{
				if (log.isDebugEnabled()){
					log.debug(String.format("根据用户手机号[%s]查找不到用户",user.getMobileNum()));
				}
				throw new MaAccountException(MaAccountException.ERR_ACCOUNT_EXCEPTION,String.format("根据用户手机号[%s]查找不到用户",user.getMobileNum()));
				
			}
		} catch (Exception e1) {
			log.error(String.format(messagebase+"失败"),e1);
			rm.mergeException(e1);
			rm.setErrmsg(messagebase+"失败,"+rm.getErrmsg());
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
