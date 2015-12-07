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
import com.hummingbird.paas.entity.Biddee;
import com.hummingbird.paas.entity.Bidder;
import com.hummingbird.paas.entity.ObjectProjectInfo;
import com.hummingbird.paas.entity.ProjectInfo;
import com.hummingbird.paas.entity.Token;
import com.hummingbird.paas.entity.User;
import com.hummingbird.paas.exception.MaAccountException;
import com.hummingbird.paas.exception.PaasException;
import com.hummingbird.paas.mapper.AppLogMapper;
import com.hummingbird.paas.mapper.BidObjectMapper;
import com.hummingbird.paas.mapper.BiddeeMapper;
import com.hummingbird.paas.mapper.ObjectProjectInfoMapper;
import com.hummingbird.paas.services.ProjectService;
import com.hummingbird.paas.services.TokenService;
import com.hummingbird.paas.services.UserService;
import com.hummingbird.paas.vo.ObjectBodyVO;
import com.hummingbird.paas.vo.ObjectVO;
import com.hummingbird.paas.vo.TokenBodyVO;
import com.hummingbird.paas.vo.TokenVO;

@Controller
@RequestMapping(value = "myPayment", method = RequestMethod.POST)
public class TenderProjectController extends BaseController{
	@Autowired 
	UserService userSer;
	@Autowired
	ProjectService projectSer;
	@Autowired
	AppLogMapper applogDao;
	@Autowired
	TokenService tokenSrv;
	@Autowired
	BiddeeMapper biddeeDao;
	@Autowired
	BidObjectMapper objectDao;
	@Autowired
	ObjectProjectInfoMapper objectprojectDao;
	
	/**
	 * 查询我的招标项目付款情况
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/queryMyPaymentList", method = RequestMethod.POST)
	@AccessRequered(methodName = "查询我的招标项目付款情况",  appLog = true)
	public @ResponseBody Object queryMyPaymentList(HttpServletRequest request) {
		
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
		
		String messagebase = "查询我的招标项目付款情况";
		rm.setBaseErrorCode(250100);
		rm.setErrmsg(messagebase+"成功");
		try {
			if(log.isDebugEnabled()){
				log.debug("检验通过，获取请求");
			}
			
			Token token = tokenSrv.getToken(transorder.getBody().getToken(), transorder.getApp().getAppId());
			if (token == null) {
				log.error(String.format("token[%s]验证失败,或已过期,请重新登录", transorder.getBody().getToken()));
				throw new TokenException("token验证失败,或已过期,请重新登录");
			}
			Biddee biddee = validateWithBusiness(transorder.getBody().getToken(), transorder.getApp().getAppId(),token);
			rm.put("list", projectSer.queryMyPaymentList(biddee.getId()));
			tokenSrv.postponeToken(token);
		} catch (Exception e1) {
			log.error(String.format(messagebase+"失败"),e1);
			rm.mergeException(e1);
			rm.setErrmsg(messagebase+"失败,"+rm.getErrmsg());
		}
		return rm;
	}
	
	/**
	 * @param token
	 * @param appId
	 * @param token2
	 * @return
	 * @throws PaasException 
	 */
	private Biddee validateWithBusiness(String tokenStr, String appId, Token token) throws PaasException {
		Biddee biddee = biddeeDao.selectByUserId(token.getUserId());
		if (biddee == null) {
			log.error(String.format("用户%s查找不到招标方信息,可能未进行资格认证", token.getUserId()));
			throw new PaasException(PaasException.ERR_BIDDEE_INFO_EXCEPTION, "您没有招标方资质认证,请先进行认证");
		}
		return biddee;
	}

	/**
	 * 查询我的招标项目付款概况
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/getMyPaymentOverall", method = RequestMethod.POST)
	@AccessRequered(methodName = "查询我的招标项目付款概况",  appLog = true)
	public @ResponseBody Object getMyPaymentOverall(HttpServletRequest request) {
		
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
		
		String messagebase = "查询我的招标项目付款概况";
		rm.setBaseErrorCode(250200);
		rm.setErrmsg(messagebase+"成功");
		try {
			if(log.isDebugEnabled()){
				log.debug("检验通过，获取请求");
			}
			
			Token token = tokenSrv.getToken(transorder.getBody().getToken(), transorder.getApp().getAppId());
			if (token == null) {
				log.error(String.format("token[%s]验证失败,或已过期,请重新登录", transorder.getBody().getToken()));
				throw new TokenException("token验证失败,或已过期,请重新登录");
			}
			Biddee biddee = validateWithBusiness(transorder.getBody().getToken(), transorder.getApp().getAppId(),token);
			rm.put("overall", projectSer.getMyPaymentOverall(biddee.getId()));
			tokenSrv.postponeToken(token);
		} catch (Exception e1) {
			log.error(String.format(messagebase+"失败"),e1);
			rm.mergeException(e1);
			rm.setErrmsg(messagebase+"失败,"+rm.getErrmsg());
		}
		return rm;
	}
	
	/**
	 * 查询项目应付款详情
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/queryWillPayAmountDetail", method = RequestMethod.POST)
	@AccessRequered(methodName = "查询项目应付款详情",  appLog = true)
	public @ResponseBody Object queryWillPayAmountDetail(HttpServletRequest request) {
		
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
		
		String messagebase = "查询项目应付款详情";
		rm.setBaseErrorCode(250300);
		rm.setErrmsg(messagebase+"成功");
		try {
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
			rm.put("list", projectSer.queryWillPayAmountDetail(body.getObjectId()));
			tokenSrv.postponeToken(token);
		} catch (Exception e1) {
			log.error(String.format(messagebase+"失败"),e1);
			rm.mergeException(e1);
			rm.setErrmsg(messagebase+"失败,"+rm.getErrmsg());
		}
		return rm;
	}
	
	/**
	 * 查询项目已付款详情
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/queryPaidAmountDetail", method = RequestMethod.POST)
	@AccessRequered(methodName = "查询项目已付款详情",  appLog = true)
	public @ResponseBody Object queryPaidAmountDetail(HttpServletRequest request) {
		
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
		String messagebase = "查询项目已付款详情";
		rm.setBaseErrorCode(250400);
		rm.setErrmsg(messagebase+"成功");
		try {
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
			rm.put("list", projectSer.queryPaidAmountDetail(body.getObjectId()));
			tokenSrv.postponeToken(token);
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
