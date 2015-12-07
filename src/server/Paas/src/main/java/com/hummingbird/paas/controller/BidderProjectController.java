package com.hummingbird.paas.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hummingbird.common.controller.BaseController;
import com.hummingbird.common.exception.ValidateException;
import com.hummingbird.common.ext.AccessRequered;
import com.hummingbird.common.face.AbstractAppLog;
import com.hummingbird.common.util.PropertiesUtil;
import com.hummingbird.common.util.RequestUtil;
import com.hummingbird.common.vo.ResultModel;
import com.hummingbird.commonbiz.exception.TokenException;
import com.hummingbird.paas.entity.AppLog;
import com.hummingbird.paas.entity.BidObject;
import com.hummingbird.paas.entity.Bidder;
import com.hummingbird.paas.entity.ObjectProjectInfo;
import com.hummingbird.paas.entity.Token;
import com.hummingbird.paas.entity.User;
import com.hummingbird.paas.exception.MaAccountException;
import com.hummingbird.paas.exception.PaasException;
import com.hummingbird.paas.mapper.AppLogMapper;
import com.hummingbird.paas.mapper.BidObjectMapper;
import com.hummingbird.paas.mapper.BidderMapper;
import com.hummingbird.paas.mapper.ObjectProjectInfoMapper;
import com.hummingbird.paas.services.ProjectService;
import com.hummingbird.paas.services.TokenService;
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
	TokenService tokenSrv;
	@Autowired
	ProjectService projectSer;
	@Autowired
	BidderMapper bidderDao;
	@Autowired
	BidObjectMapper objectDao;
	@Autowired(required = true)
	protected AppLogMapper applogDao;
	@Autowired
	ObjectProjectInfoMapper objectprojectDao;
	
	/**
	 * 查询我的中标项目收款情况 
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/queryMyIncomeList", method = RequestMethod.POST)
	@AccessRequered(methodName = "查询我的中标项目收款情况",  appLog = true)
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
			Token token = tokenSrv.getToken(transorder.getBody().getToken(), transorder.getApp().getAppId());
			if (token == null) {
				log.error(String.format("token[%s]验证失败,或已过期,请重新登录", transorder.getBody().getToken()));
				throw new TokenException("token验证失败,或已过期,请重新登录");
			}
			Bidder bidder = validateWithBusiness(transorder.getBody().getToken(), transorder.getApp().getAppId(),token);
			rm.put("list", projectSer.queryMyIncomeList(bidder.getId()));
		} catch (Exception e1) {
			log.error(String.format(messagebase+"失败"),e1);
			rm.mergeException(e1);
			rm.setErrmsg(messagebase+"失败,"+rm.getErrmsg());
		}
		return rm;
	}
	
	/**
	 * 查询我的中标项目收款概况
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/getMyIncomeOverall", method = RequestMethod.POST)
	@AccessRequered(methodName = "查询我的中标项目收款概况",  appLog = true)
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
			Token token = tokenSrv.getToken(transorder.getBody().getToken(), transorder.getApp().getAppId());
			if (token == null) {
				log.error(String.format("token[%s]验证失败,或已过期,请重新登录", transorder.getBody().getToken()));
				throw new TokenException("token验证失败,或已过期,请重新登录");
			}
			Bidder bidder = validateWithBusiness(transorder.getBody().getToken(), transorder.getApp().getAppId(),token);

			rm.put("overall", projectSer.getMyIncomeOverall(bidder.getId()));
		} catch (Exception e1) {
			log.error(String.format(messagebase+"失败"),e1);
			rm.mergeException(e1);
			rm.setErrmsg(messagebase+"失败,"+rm.getErrmsg());
		}
		return rm;
	}
	
	/**
	 * 查询项目待收款款详情
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/queryWillReceiveAmountDetail", method = RequestMethod.POST)
	@AccessRequered(methodName = "查询项目待收款款详情",  appLog = true)
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
			Token token = tokenSrv.getToken(transorder.getBody().getToken(), transorder.getApp().getAppId());
			if (token == null) {
				log.error(String.format("token[%s]验证失败,或已过期,请重新登录", transorder.getBody().getToken()));
				throw new TokenException("token验证失败,或已过期,请重新登录");
			}
			ObjectProjectInfo objproject = objectprojectDao.selectByPrimaryKey(body.getObjectId());
			if(objproject==null)
			{
				log.error(String.format("标的工程%s不存在", body.getObjectId()));
			}
			rm.put("projectName", objproject.getProjectName());
			rm.put("list", projectSer.queryWillReceiveAmountDetail(body.getObjectId()));
			
		} catch (Exception e1) {
			log.error(String.format(messagebase+"失败"),e1);
			rm.mergeException(e1);
			rm.setErrmsg(messagebase+"失败,"+rm.getErrmsg());
		}
		return rm;
	}
	
	/**
	 * 查询项目收款详情
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/queryReceivedAmountDetail", method = RequestMethod.POST)
	@AccessRequered(methodName = "查询项目收款详情",  appLog = true)
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
			Token token = tokenSrv.getToken(transorder.getBody().getToken(), transorder.getApp().getAppId());
			if (token == null) {
				log.error(String.format("token[%s]验证失败,或已过期,请重新登录", transorder.getBody().getToken()));
				throw new TokenException("token验证失败,或已过期,请重新登录");
			}
			ObjectProjectInfo objproject = objectprojectDao.selectByPrimaryKey(body.getObjectId());
			if(objproject==null)
			{
				log.error(String.format("标的工程%s不存在", body.getObjectId()));
			}
			rm.put("projectName", objproject.getProjectName());
			rm.put("list", projectSer.queryReceivedAmountDetail(body.getObjectId()));
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
	
	/**
	 * @param token
	 * @param appId
	 * @param token2
	 * @return 
	 * @throws PaasException 
	 */
	private Bidder validateWithBusiness(String tokenstr, String appId, Token token) throws PaasException {
		Bidder bidder = bidderDao.selectByUserId(token.getUserId());
		if (bidder == null) {
			log.error(String.format("用户%s查找不到投标方信息,可能未进行资格认证", token.getUserId()));
			throw new PaasException(PaasException.ERR_BIDDER_INFO_EXCEPTION, "您没有投标方资质认证,请先进行认证");
		}
		return bidder;
		
	}
	
}
