package com.hummingbird.capital.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.ObjectUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.NumberUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hummingbird.capital.entity.AppLog;
import com.hummingbird.capital.entity.PlatformBankcard;
import com.hummingbird.capital.entity.ProjectAccount;
import com.hummingbird.capital.entity.ProjectAccountOrder;
import com.hummingbird.capital.entity.RechargeApply;
import com.hummingbird.capital.entity.User;
import com.hummingbird.capital.entity.WithdrawApply;
import com.hummingbird.capital.exception.MaAccountException;
import com.hummingbird.capital.mapper.AppLogMapper;
import com.hummingbird.capital.mapper.PlatformBankcardMapper;
import com.hummingbird.capital.mapper.ProjectAccountMapper;
import com.hummingbird.capital.services.CapitalManageService;
import com.hummingbird.capital.services.OrderService;
import com.hummingbird.capital.services.UserService;
import com.hummingbird.capital.util.MoneyUtil;
import com.hummingbird.capital.vo.ApplyListReturnVO;
import com.hummingbird.capital.vo.CapitalSurveyReturnVO;
import com.hummingbird.capital.vo.CheckRechargeApplyBodyVO;
import com.hummingbird.capital.vo.CheckWithdrawalBodyVO;
import com.hummingbird.capital.vo.FailWithdrawalsBodyVO;
import com.hummingbird.capital.vo.FreezeBondBodyVO;
import com.hummingbird.capital.vo.FreezeBondReturnVO;
import com.hummingbird.capital.vo.FreezeBondVO;
import com.hummingbird.capital.vo.FreezeWithdrawalsBodyVO;
import com.hummingbird.capital.vo.FreezeWithdrawalsVO;
import com.hummingbird.capital.vo.GetPlatformBankcardReturnVO;
import com.hummingbird.capital.vo.MobileBodyVO;
import com.hummingbird.capital.vo.QueryProjectAccountReturnVO;
import com.hummingbird.capital.vo.RechargeApplyBodyVO;
import com.hummingbird.capital.vo.RechargeApplyReturnVO;
import com.hummingbird.capital.vo.SuccessRechargeBodyVO;
import com.hummingbird.capital.vo.SuccessWithdrawalsBodyVO;
import com.hummingbird.capital.vo.TokenBodyVO;
import com.hummingbird.capital.vo.TokenQueryVO;
import com.hummingbird.capital.vo.TokenVO;
import com.hummingbird.capital.vo.TransactionRecordsReturnVO;
import com.hummingbird.capital.vo.UnfreezeBondVO;
import com.hummingbird.capital.vo.UnfreezeVO;
import com.hummingbird.capital.vo.UserBodyVO;
import com.hummingbird.capital.vo.WithdrawalsApplyBodyVO;
import com.hummingbird.capital.vo.WithdrawalsApplyListReturnVO;
import com.hummingbird.capital.vo.WithdrawalsApplyVO;
import com.hummingbird.common.controller.BaseController;
import com.hummingbird.common.exception.ValidateException;
import com.hummingbird.common.ext.AccessRequered;
import com.hummingbird.common.face.AbstractAppLog;
import com.hummingbird.common.face.Pagingnation;
import com.hummingbird.common.util.DESUtil;
import com.hummingbird.common.util.DateUtil;
import com.hummingbird.common.util.Md5Util;
import com.hummingbird.common.util.PropertiesUtil;
import com.hummingbird.common.util.RequestUtil;
import com.hummingbird.common.util.StrUtil;
import com.hummingbird.common.util.ValidateUtil;
import com.hummingbird.common.vo.ResultModel;
import com.hummingbird.common.vo.ValidateResult;
import com.hummingbird.commonbiz.service.IAuthenticationService;
import com.hummingbird.commonbiz.vo.BaseTransVO;
import com.hummingbird.capital.face.Account;
import com.hummingbird.capital.util.AccountFactory;

@Controller

@RequestMapping("/capitalManage")
public class CapitalManageController extends BaseController{
	@Autowired 
	UserService userSer;
	@Autowired
	CapitalManageService capitalManageSer;
	@Autowired
	OrderService orderSer;
	@Autowired
	IAuthenticationService authService;
	@Autowired
	AppLogMapper applogDao;
	
	@Autowired
	PlatformBankcardMapper platformBankcardDao;
	@Autowired
	private ProjectAccountMapper proActDao;
	
	@RequestMapping(value = "/queryMyCapitalSurvey", method = RequestMethod.POST)
	public @ResponseBody Object queryMyCapitalSurvey(HttpServletRequest request) {
		
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
		
		String messagebase = "查询我的资金账户概况";
		rm.setBaseErrorCode(251100);
		rm.setErrmsg(messagebase+"成功");
		try {
			//获取url以作为method的内容
			String requestURI = request.getRequestURI();
			requestURI=requestURI.replace(request.getContextPath(), "");
			
			TokenBodyVO body=transorder.getBody();
			
			if(log.isDebugEnabled()){
				log.debug("检验通过，获取请求");
			}
			
			User user=userSer.queryUserByToken(body.getToken());
			CapitalSurveyReturnVO survey=new CapitalSurveyReturnVO();
			if(user!=null){
				ProjectAccount proActInfo=capitalManageSer.queryAccountInfo(user.getId());
				if(proActInfo!=null){
					survey.setBalance(MoneyUtil.getMoneyStringDecimal4yuan(proActInfo.getRemainingSum()));
					survey.setFreezeAmount(MoneyUtil.getMoneyStringDecimal4yuan(proActInfo.getFrozenSum()));
					survey.setIncome(MoneyUtil.getMoneyStringDecimal4yuan(capitalManageSer.getAccountIncome(proActInfo.getAccountId())));
					survey.setOutlay(MoneyUtil.getMoneyStringDecimal4yuan(capitalManageSer.getAccountOutlay(proActInfo.getAccountId())));					
				}
			}
			
			rm.put("myCapitalInfo",survey);
		} catch (Exception e1) {
			log.error(String.format(messagebase+"失败"),e1);
			rm.mergeException(e1);
			rm.setErrmsg(messagebase+"失败,"+rm.getErrmsg());
		}
		return rm;
	}
	
	@RequestMapping(value = "/queryTransactionRecords", method = RequestMethod.POST)
	public @ResponseBody Object queryTransactionRecords(HttpServletRequest request) {
		
		final BaseTransVO<TokenQueryVO> transorder;
		ResultModel rm = new ResultModel();
		try {
			String jsonstr = RequestUtil.getRequestPostData(request);
			request.setAttribute("rawjson", jsonstr);
			transorder = RequestUtil.convertJson2Obj(jsonstr, BaseTransVO.class,TokenQueryVO.class);
		} catch (Exception e) {
			log.error(String.format("获取订单参数出错"),e);
			rm.mergeException(ValidateException.ERROR_PARAM_FORMAT_ERROR.cloneAndAppend(null, "订单参数"));
			return rm;
		}
		
		String messagebase = "查询我的资金账户流水";
		rm.setBaseErrorCode(251200);
		rm.setErrmsg(messagebase+"成功");
		try {
			//获取url以作为method的内容
			String requestURI = request.getRequestURI();
			requestURI=requestURI.replace(request.getContextPath(), "");
			
			PropertiesUtil pu = new PropertiesUtil();
			TokenQueryVO body=transorder.getBody();
			Pagingnation page=body.toPagingnation();
			if(log.isDebugEnabled()){
				log.debug("检验通过，获取请求");
			}
			
			User user=userSer.queryUserByToken(body.getToken());
			List<TransactionRecordsReturnVO> list=new ArrayList<TransactionRecordsReturnVO>();
			if(user!=null){
				ProjectAccount proActInfo=capitalManageSer.queryAccountInfo(user.getId());
				if(proActInfo!=null){
					List<ProjectAccountOrder> records=capitalManageSer.queryAccountRecordsByAccountId(proActInfo.getAccountId(),page);
					for(ProjectAccountOrder order:records){
						TransactionRecordsReturnVO record=new TransactionRecordsReturnVO();
						record.setBalance(MoneyUtil.getMoneyStringDecimal4yuan(order.getBalance()));
						record.setTime(DateUtil.formatCommonDateorNull(order.getInsertTime()));
						record.setRemark(order.getRemark());
						record.setType(order.getType());
						if(StringUtils.equals(order.getFlowDirection(),"IN#")){
							record.setIncome(MoneyUtil.getMoneyStringDecimal4yuan(order.getSum()));
							record.setOutlay("0");
						}else if(StringUtils.equals(order.getFlowDirection(),"OUT")){
							record.setOutlay(MoneyUtil.getMoneyStringDecimal4yuan(order.getSum()));
							record.setIncome("0");
						}
						list.add(record);
					}
					
					rm.put("list",list);
					rm.put("pageSize", page.getPageSize());
					rm.put("pageIndex", page.getCurrPage());
					rm.put("total", page.getTotalCount());
				}
			}
			
			
		} catch (Exception e1) {
			log.error(String.format(messagebase+"失败"),e1);
			rm.mergeException(e1);
			rm.setErrmsg(messagebase+"失败,"+rm.getErrmsg());
		}
		return rm;
	}
	@RequestMapping(value = "/freezeBond", method = RequestMethod.POST)
	public @ResponseBody Object freezeBond(HttpServletRequest request) {
		
		FreezeBondVO transorder;
		ResultModel rm = new ResultModel();
		try {
			String jsonstr = RequestUtil.getRequestPostData(request);
			request.setAttribute("rawjson", jsonstr);
			transorder = RequestUtil.convertJson2Obj(jsonstr,FreezeBondVO.class);
		} catch (Exception e) {
			log.error(String.format("获取订单参数出错"),e);
			rm.mergeException(ValidateException.ERROR_PARAM_FORMAT_ERROR.cloneAndAppend(null, "订单参数"));
			return rm;
		}
		
		String messagebase = "冻结撮合担保金";
		rm.setBaseErrorCode(251300);
		rm.setErrmsg(messagebase+"成功");
		try {
			//获取url以作为method的内容
			String requestURI = request.getRequestURI();
			requestURI=requestURI.replace(request.getContextPath(), "");
			Map validateAuth = (Map) authService.validateAuth(transorder);
			String appkey = ObjectUtils.toString(validateAuth.get("appKey"));
			PropertiesUtil pu = new PropertiesUtil();
			FreezeBondBodyVO body=transorder.getBody();
			//备注字段必填
			ValidateUtil.assertEmpty(body.getRemark(), "备注");
			
			if(log.isDebugEnabled()){
				log.debug("检验通过，获取请求");
			}
			
			User user=userSer.queryUserByToken(body.getToken());
			capitalManageSer.validatePaymentCode(body.getTradePassword(), user,appkey);
			FreezeBondReturnVO orderInfo=new FreezeBondReturnVO();
			if(user!=null){
				body.setType("JBZ");
				orderInfo=orderSer.freeze(body, user, requestURI);
			}
			rm.put("order", orderInfo);
		} catch (Exception e1) {
			log.error(String.format(messagebase+"失败"),e1);
			rm.mergeException(e1);
			rm.setErrmsg(messagebase+"失败,"+rm.getErrmsg());
		}
		return rm;
	}
	
	@RequestMapping(value = "/unfreezeBond", method = RequestMethod.POST)
	public @ResponseBody Object unfreezeBond(HttpServletRequest request) {
		
		final BaseTransVO<UnfreezeBondVO> transorder;
		ResultModel rm = new ResultModel();
		try {
			String jsonstr = RequestUtil.getRequestPostData(request);
			request.setAttribute("rawjson", jsonstr);
			transorder = RequestUtil.convertJson2Obj(jsonstr,BaseTransVO.class, UnfreezeBondVO.class);
		} catch (Exception e) {
			log.error(String.format("获取订单参数出错"),e);
			rm.mergeException(ValidateException.ERROR_PARAM_FORMAT_ERROR.cloneAndAppend(null, "订单参数"));
			return rm;
		}
		
		String messagebase = "解冻撮合担保金";
		rm.setBaseErrorCode(251400);
		rm.setErrmsg(messagebase+"成功");
		try {
			//获取url以作为method的内容
			String requestURI = request.getRequestURI();
			requestURI=requestURI.replace(request.getContextPath(), "");
			PropertiesUtil pu = new PropertiesUtil();
			UnfreezeBondVO body=transorder.getBody();
			if(log.isDebugEnabled()){
				log.debug("检验通过，获取请求");
			}
			
			User user=userSer.queryUserByToken(body.getToken());
			
			FreezeBondReturnVO orderInfo=new FreezeBondReturnVO();
			if(user!=null){
				UnfreezeVO unfreeze=new UnfreezeVO();
				unfreeze.setAppOrderId(body.getOrderId());
				unfreeze.setObjectId(body.getObjectId());
				unfreeze.setOrignalTable("t_project_account_order");
				unfreeze.setOrignalOrderId(body.getOrderId());
				unfreeze.setRemark(body.getRemark());
				unfreeze.setType("SBZ");
				orderInfo=orderSer.unfreeze(unfreeze, user.getId(), requestURI);
			}
			rm.put("order", orderInfo);
		} catch (Exception e1) {
			log.error(String.format(messagebase+"失败"),e1);
			rm.mergeException(e1);
			rm.setErrmsg(messagebase+"失败,"+rm.getErrmsg());
		}
		return rm;
	}
	
	
	
	@RequestMapping(value = "/queryRechargeApplyList", method = RequestMethod.POST)
	public @ResponseBody Object queryRechargeApplyList(HttpServletRequest request) {
		
		final BaseTransVO<TokenBodyVO> transorder;
		ResultModel rm = new ResultModel();
		try {
			String jsonstr = RequestUtil.getRequestPostData(request);
			request.setAttribute("rawjson", jsonstr);
			transorder = RequestUtil.convertJson2Obj(jsonstr,BaseTransVO.class, TokenBodyVO.class);
		} catch (Exception e) {
			log.error(String.format("获取订单参数出错"),e);
			rm.mergeException(ValidateException.ERROR_PARAM_FORMAT_ERROR.cloneAndAppend(null, "订单参数"));
			return rm;
		}
		
		String messagebase = "查询充值申请记录";
		rm.setBaseErrorCode(251500);
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
			
			List<ApplyListReturnVO> list=new ArrayList<ApplyListReturnVO>();
			if(user!=null){
				list=orderSer.queryRechargeApplyList(user);
			}
			rm.put("list", list);
		} catch (Exception e1) {
			log.error(String.format(messagebase+"失败"),e1);
			rm.mergeException(e1);
			rm.setErrmsg(messagebase+"失败,"+rm.getErrmsg());
		}
		return rm;
	}
	
	@RequestMapping(value = "/withdrawalsApply", method = RequestMethod.POST)
	public @ResponseBody Object withdrawalsApply(HttpServletRequest request) {
		
		WithdrawalsApplyVO transorder;
		ResultModel rm = new ResultModel();
		try {
			String jsonstr = RequestUtil.getRequestPostData(request);
			request.setAttribute("rawjson", jsonstr);
			transorder = RequestUtil.convertJson2Obj(jsonstr,WithdrawalsApplyVO.class);
		} catch (Exception e) {
			log.error(String.format("获取订单参数出错"),e);
			rm.mergeException(ValidateException.ERROR_PARAM_FORMAT_ERROR.cloneAndAppend(null, "订单参数"));
			return rm;
		}
		
		String messagebase = "提现申请";
		rm.setBaseErrorCode(251600);
		rm.setErrmsg(messagebase+"成功");
		try {
			//获取url以作为method的内容
			String requestURI = request.getRequestURI();
			requestURI=requestURI.replace(request.getContextPath(), "");
			Map validateAuth = (Map) authService.validateAuth(transorder);
			String appkey = ObjectUtils.toString(validateAuth.get("appKey"));
			WithdrawalsApplyBodyVO body=transorder.getBody();
			if(log.isDebugEnabled()){
				log.debug("检验通过，获取请求");
			}
			User user=userSer.queryUserByToken(body.getToken());
			capitalManageSer.validatePaymentCode(body.getTradePassword(), user,appkey);
			RechargeApplyReturnVO order=new RechargeApplyReturnVO();
			if(user!=null){
				order.setOrderId(orderSer.withdrawalsApply(body, user,requestURI));
			}
			rm.put("order", order);
		} catch (Exception e1) {
			log.error(String.format(messagebase+"失败"),e1);
			rm.mergeException(e1);
			rm.setErrmsg(messagebase+"失败,"+rm.getErrmsg());
		}
		return rm;
	}
	
	@RequestMapping(value = "/freezeWithdrawals", method = RequestMethod.POST)
	public @ResponseBody Object freezeWithdrawals(HttpServletRequest request) {
		
		FreezeWithdrawalsVO transorder;
		ResultModel rm = new ResultModel();
		try {
			String jsonstr = RequestUtil.getRequestPostData(request);
			request.setAttribute("rawjson", jsonstr);
			transorder = RequestUtil.convertJson2Obj(jsonstr,FreezeWithdrawalsVO.class);
		} catch (Exception e) {
			log.error(String.format("获取订单参数出错"),e);
			rm.mergeException(ValidateException.ERROR_PARAM_FORMAT_ERROR.cloneAndAppend(null, "订单参数"));
			return rm;
		}
		
		String messagebase = "冻结提现";
		rm.setBaseErrorCode(251700);
		rm.setErrmsg(messagebase+"成功");
		try {
			//获取url以作为method的内容
			String requestURI = request.getRequestURI();
			requestURI=requestURI.replace(request.getContextPath(), "");
			Map validateAuth = (Map) authService.validateAuth(transorder);
			String appkey = ObjectUtils.toString(validateAuth.get("appKey"));
			FreezeWithdrawalsBodyVO body=transorder.getBody();
			if(log.isDebugEnabled()){
				log.debug("检验通过，获取请求");
			}
			//查询用户信息
			User user=userSer.queryUserByMobile(body.getMobileNum());
			capitalManageSer.validatePaymentCode(body.getTradePassword(), user,appkey);
			FreezeBondBodyVO freezeBody=new FreezeBondBodyVO();
			freezeBody.setOriginalOrderId(body.getOrderId());
			freezeBody.setRemark(body.getRemark());
			freezeBody.setAmount(body.getAmount());
			freezeBody.setType("FRZ");
			FreezeBondReturnVO order=orderSer.freeze(freezeBody,user,requestURI);
			
			rm.put("orderId", order.getOrderId());
		} catch (Exception e1) {
			log.error(String.format(messagebase+"失败"),e1);
			rm.mergeException(e1);
			rm.setErrmsg(messagebase+"失败,"+rm.getErrmsg());
		}
		return rm;
	}
	
	@RequestMapping(value = "/checkWithdrawalsApply", method = RequestMethod.POST)
	public @ResponseBody Object checkWithdrawalsApply(HttpServletRequest request) {
		
		final BaseTransVO<CheckWithdrawalBodyVO> transorder;
		ResultModel rm = new ResultModel();
		try {
			String jsonstr = RequestUtil.getRequestPostData(request);
			request.setAttribute("rawjson", jsonstr);
			transorder = RequestUtil.convertJson2Obj(jsonstr,BaseTransVO.class, CheckWithdrawalBodyVO.class);
		} catch (Exception e) {
			log.error(String.format("获取订单参数出错"),e);
			rm.mergeException(ValidateException.ERROR_PARAM_FORMAT_ERROR.cloneAndAppend(null, "订单参数"));
			return rm;
		}
		
		String messagebase = "提现申请审核";
		rm.setBaseErrorCode(251800);
		rm.setErrmsg(messagebase+"成功");
		try {
			//获取url以作为method的内容
			PropertiesUtil pu = new PropertiesUtil();
			String requestURI = request.getRequestURI();
			requestURI=requestURI.replace(request.getContextPath(), "");
			CheckWithdrawalBodyVO body=transorder.getBody();
			if(log.isDebugEnabled()){
				log.debug("检验通过，获取请求");
			}
			orderSer.checkWithdrawalApply(body,requestURI);
		} catch (Exception e1) {
			log.error(String.format(messagebase+"失败"),e1);
			rm.mergeException(e1);
			rm.setErrmsg(messagebase+"失败,"+rm.getErrmsg());
		}
		return rm;
	}
	@RequestMapping(value = "/failWithdrawals", method = RequestMethod.POST)
	public @ResponseBody Object failWithdrawals(HttpServletRequest request) {
		
		final BaseTransVO<FailWithdrawalsBodyVO> transorder;
		ResultModel rm = new ResultModel();
		try {
			String jsonstr = RequestUtil.getRequestPostData(request);
			request.setAttribute("rawjson", jsonstr);
			transorder = RequestUtil.convertJson2Obj(jsonstr,BaseTransVO.class, FailWithdrawalsBodyVO.class);
		} catch (Exception e) {
			log.error(String.format("获取订单参数出错"),e);
			rm.mergeException(ValidateException.ERROR_PARAM_FORMAT_ERROR.cloneAndAppend(null, "订单参数"));
			return rm;
		}
		
		String messagebase = "提现失败接口";
		rm.setBaseErrorCode(251900);
		rm.setErrmsg(messagebase+"成功");
		try {
			//获取url以作为method的内容
			String requestURI = request.getRequestURI();
			requestURI=requestURI.replace(request.getContextPath(), "");
			FailWithdrawalsBodyVO body=transorder.getBody();
			if(log.isDebugEnabled()){
				log.debug("检验通过，获取请求");
			}
			WithdrawApply apply=orderSer.queryWithdrawalByOrderId(body.getOrderId());
			if(apply==null){
				if (log.isDebugEnabled()) {
					log.debug(String.format("账户订单号【%s】查询不到提现申请记录",body.getOrderId()));
				}
				throw new MaAccountException(MaAccountException.ERR_ORDER_EXCEPTION,String.format("账户订单号【%s】查询不到提现申请记录",body.getOrderId()));		
			
			}
			//查询用户信息
			UnfreezeVO unfreezeBody=new UnfreezeVO();
			unfreezeBody.setAppOrderId(body.getAppOrderId());
			unfreezeBody.setOrignalOrderId(body.getOrderId());
			unfreezeBody.setOrignalTable("t_ddgl_withdraw_apply");
			unfreezeBody.setRemark(body.getRemark());
			unfreezeBody.setSum(apply.getWithdrawAmount());
			unfreezeBody.setType("UFZ");
			orderSer.unfreeze(unfreezeBody, apply.getUserId(), requestURI);
		} catch (Exception e1) {
			log.error(String.format(messagebase+"失败"),e1);
			rm.mergeException(e1);
			rm.setErrmsg(messagebase+"失败,"+rm.getErrmsg());
		}
		return rm;
	}
	@RequestMapping(value = "/successWithdrawals", method = RequestMethod.POST)
	public @ResponseBody Object successWithdrawals(HttpServletRequest request) {
		
		final BaseTransVO<SuccessWithdrawalsBodyVO> transorder;
		ResultModel rm = new ResultModel();
		try {
			String jsonstr = RequestUtil.getRequestPostData(request);
			request.setAttribute("rawjson", jsonstr);
			transorder = RequestUtil.convertJson2Obj(jsonstr,BaseTransVO.class, SuccessWithdrawalsBodyVO.class);
		} catch (Exception e) {
			log.error(String.format("获取订单参数出错"),e);
			rm.mergeException(ValidateException.ERROR_PARAM_FORMAT_ERROR.cloneAndAppend(null, "订单参数"));
			return rm;
		}
		
		String messagebase = "提现成功接口";
		rm.setBaseErrorCode(252000);
		rm.setErrmsg(messagebase+"成功");
		try {
			//获取url以作为method的内容
			String requestURI = request.getRequestURI();
			requestURI=requestURI.replace(request.getContextPath(), "");
			SuccessWithdrawalsBodyVO body=transorder.getBody();
			if(log.isDebugEnabled()){
				log.debug("检验通过，获取请求");
			}
			WithdrawApply apply=orderSer.queryWithdrawalByOrderId(body.getOrderId());
			if(apply==null){
				if (log.isDebugEnabled()) {
					log.debug(String.format("账户订单号【%s】查询不到提现申请记录",body.getOrderId()));
				}
				throw new MaAccountException(MaAccountException.ERR_ORDER_EXCEPTION,String.format("账户订单号【%s】查询不到提现申请记录",body.getOrderId()));		
			
			}
			//查询用户信息
			UnfreezeVO unfreezeBody=new UnfreezeVO();
			unfreezeBody.setAppOrderId(body.getAppOrderId());
			unfreezeBody.setOrignalOrderId(body.getOrderId());
			unfreezeBody.setOrignalTable("t_ddgl_withdraw_apply");
			unfreezeBody.setRemark(body.getRemark());
			unfreezeBody.setSum(apply.getWithdrawAmount());
			unfreezeBody.setType("TX#");
			String orderId=orderSer.withdrawals(unfreezeBody, apply.getUserId(), requestURI);
			rm.put("orderId", orderId);
		} catch (Exception e1) {
			log.error(String.format(messagebase+"失败"),e1);
			rm.mergeException(e1);
			rm.setErrmsg(messagebase+"失败,"+rm.getErrmsg());
		}
		return rm;
	}
	@RequestMapping(value = "/queryWithdrawalsApplyList", method = RequestMethod.POST)
	public @ResponseBody Object queryWithdrawalsApplyList(HttpServletRequest request) {
		
		final BaseTransVO<TokenBodyVO> transorder;
		ResultModel rm = new ResultModel();
		try {
			String jsonstr = RequestUtil.getRequestPostData(request);
			request.setAttribute("rawjson", jsonstr);
			transorder = RequestUtil.convertJson2Obj(jsonstr,BaseTransVO.class, TokenBodyVO.class);
		} catch (Exception e) {
			log.error(String.format("获取订单参数出错"),e);
			rm.mergeException(ValidateException.ERROR_PARAM_FORMAT_ERROR.cloneAndAppend(null, "订单参数"));
			return rm;
		}
		
		String messagebase = "查询申请提现记录";
		rm.setBaseErrorCode(252100);
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
			
			List<WithdrawalsApplyListReturnVO> list=new ArrayList<WithdrawalsApplyListReturnVO>();
			if(user!=null){
				list=orderSer.queryWithdrawalsApplyList(user);
			}
			rm.put("list", list);
		} catch (Exception e1) {
			log.error(String.format(messagebase+"失败"),e1);
			rm.mergeException(e1);
			rm.setErrmsg(messagebase+"失败,"+rm.getErrmsg());
		}
		return rm;
	}
	@RequestMapping(value = "/rechargeApply", method = RequestMethod.POST)
	public @ResponseBody Object rechargeApply(HttpServletRequest request) {
		
		final BaseTransVO<RechargeApplyBodyVO> transorder;
		ResultModel rm = new ResultModel();
		try {
			String jsonstr = RequestUtil.getRequestPostData(request);
			request.setAttribute("rawjson", jsonstr);
			transorder = RequestUtil.convertJson2Obj(jsonstr,BaseTransVO.class, RechargeApplyBodyVO.class);
		} catch (Exception e) {
			log.error(String.format("获取订单参数出错"),e);
			rm.mergeException(ValidateException.ERROR_PARAM_FORMAT_ERROR.cloneAndAppend(null, "订单参数"));
			return rm;
		}
		
		String messagebase = "充值申请";
		rm.setBaseErrorCode(252200);
		rm.setErrmsg(messagebase+"成功");
		try {
			//获取url以作为method的内容
			String requestURI = request.getRequestURI();
			requestURI=requestURI.replace(request.getContextPath(), "");
			PropertiesUtil pu = new PropertiesUtil();
			RechargeApplyBodyVO body=transorder.getBody();
			
			
			if(log.isDebugEnabled()){
				log.debug("检验通过，获取请求");
			}
			
			User user=userSer.queryUserByToken(body.getToken());
			
			RechargeApplyReturnVO order=new RechargeApplyReturnVO();
			if(user!=null){
				order.setOrderId(orderSer.rechargeApply(body, user));
			}
			rm.put("order", order);
		} catch (Exception e1) {
			log.error(String.format(messagebase+"失败"),e1);
			rm.mergeException(e1);
			rm.setErrmsg(messagebase+"失败,"+rm.getErrmsg());
		}
		return rm;
	}
	@RequestMapping(value = "/checkRechargeApply", method = RequestMethod.POST)
	public @ResponseBody Object checkRechargeApply(HttpServletRequest request) {
		
		final BaseTransVO<CheckRechargeApplyBodyVO> transorder;
		ResultModel rm = new ResultModel();
		try {
			String jsonstr = RequestUtil.getRequestPostData(request);
			request.setAttribute("rawjson", jsonstr);
			transorder = RequestUtil.convertJson2Obj(jsonstr,BaseTransVO.class, CheckRechargeApplyBodyVO.class);
		} catch (Exception e) {
			log.error(String.format("获取订单参数出错"),e);
			rm.mergeException(ValidateException.ERROR_PARAM_FORMAT_ERROR.cloneAndAppend(null, "订单参数"));
			return rm;
		}
		
		String messagebase = "充值申请审核接口";
		rm.setBaseErrorCode(252300);
		rm.setErrmsg(messagebase+"成功");
		try {
			//获取url以作为method的内容
			String requestURI = request.getRequestURI();
			requestURI=requestURI.replace(request.getContextPath(), "");
			PropertiesUtil pu = new PropertiesUtil();
			CheckRechargeApplyBodyVO body=transorder.getBody();
			
			
			if(log.isDebugEnabled()){
				log.debug("检验通过，获取请求");
			}
			orderSer.checkRechargeApply(body,requestURI);
			
		} catch (Exception e1) {
			log.error(String.format(messagebase+"失败"),e1);
			rm.mergeException(e1);
			rm.setErrmsg(messagebase+"失败,"+rm.getErrmsg());
		}
		return rm;
	}
	@RequestMapping(value = "/successRecharge", method = RequestMethod.POST)
	public @ResponseBody Object successRecharge(HttpServletRequest request) {
		
		final BaseTransVO<SuccessRechargeBodyVO> transorder;
		ResultModel rm = new ResultModel();
		try {
			String jsonstr = RequestUtil.getRequestPostData(request);
			request.setAttribute("rawjson", jsonstr);
			transorder = RequestUtil.convertJson2Obj(jsonstr,BaseTransVO.class, SuccessRechargeBodyVO.class);
		} catch (Exception e) {
			log.error(String.format("获取订单参数出错"),e);
			rm.mergeException(ValidateException.ERROR_PARAM_FORMAT_ERROR.cloneAndAppend(null, "订单参数"));
			return rm;
		}
		
		String messagebase = "充值成功接口";
		rm.setBaseErrorCode(252400);
		rm.setErrmsg(messagebase+"成功");
		try {
			//获取url以作为method的内容
			String requestURI = request.getRequestURI();
			requestURI=requestURI.replace(request.getContextPath(), "");
			PropertiesUtil pu = new PropertiesUtil();
			SuccessRechargeBodyVO body=transorder.getBody();
			
			
			if(log.isDebugEnabled()){
				log.debug("检验通过，获取请求");
			}
			RechargeApply apply=orderSer.queryRechargeByOrderId(body.getOrderId());
			if(apply==null){
				if (log.isDebugEnabled()) {
					log.debug(String.format("账户订单号【%s】查询不到充值申请记录",body.getOrderId()));
				}
				throw new MaAccountException(MaAccountException.ERR_ORDER_EXCEPTION,String.format("账户订单号【%s】查询不到充值申请记录",body.getOrderId()));		
			
			}
			UnfreezeVO unfreezeBody=new UnfreezeVO();
			unfreezeBody.setAppOrderId(body.getAppOrderId());
			unfreezeBody.setOrignalOrderId(body.getOrderId());
			unfreezeBody.setOrignalTable("t_ddgl_recharge_apply");
			unfreezeBody.setRemark(body.getRemark());
			unfreezeBody.setSum(apply.getAmount());
			unfreezeBody.setType("CZ#");
			rm.put("orderId", orderSer.recharge(unfreezeBody, apply.getUserId(), requestURI));
		} catch (Exception e1) {
			log.error(String.format(messagebase+"失败"),e1);
			rm.mergeException(e1);
			rm.setErrmsg(messagebase+"失败,"+rm.getErrmsg());
		}
		return rm;
	}
	
	@RequestMapping(value = "/queryProjectAccount", method = RequestMethod.POST)
	public @ResponseBody Object queryProjectAccount(HttpServletRequest request) {
		
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
		
		String messagebase = "查询用户帐户详情";
		rm.setBaseErrorCode(252500);
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
			QueryProjectAccountReturnVO account=new QueryProjectAccountReturnVO();
			if(user!=null){
				ProjectAccount proActInfo=capitalManageSer.queryAccountInfo(user.getId());
				if(proActInfo!=null){
					account.setRemainingSum(proActInfo.getRemainingSum()/(Double.valueOf(100)));
					account.setFrozenSum(proActInfo.getFrozenSum()/(Double.valueOf(100)));
					account.setAccountId(proActInfo.getAccountId());
					account.setStatus(proActInfo.getStatus());
				}
			}
			
			rm.put("account",account);
		} catch (Exception e1) {
			log.error(String.format(messagebase+"失败"),e1);
			rm.mergeException(e1);
			rm.setErrmsg(messagebase+"失败,"+rm.getErrmsg());
		}
		return rm;
	}
	
	@RequestMapping(value = "/getPlatformBankcard", method = RequestMethod.POST)
	public @ResponseBody Object getPlatformBankcard(HttpServletRequest request) {
		
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
		
		String messagebase = "获取平台方银行账户";
		rm.setBaseErrorCode(252500);
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
			GetPlatformBankcardReturnVO bankInfo=new GetPlatformBankcardReturnVO();
			if(user!=null){
				PlatformBankcard proActInfo=platformBankcardDao.getPlatformBankcard()==null?null:platformBankcardDao.getPlatformBankcard().get(0);
				if(proActInfo!=null){
					bankInfo.setAccountId(proActInfo.getAccountNo());
					bankInfo.setAccountName(proActInfo.getAccountName());
					bankInfo.setBankName(proActInfo.getBankName()+proActInfo.getBankBranchName());
				}
			}
			
			rm.put("bankInfo",bankInfo);
		} catch (Exception e1) {
			log.error(String.format(messagebase+"失败"),e1);
			rm.mergeException(e1);
			rm.setErrmsg(messagebase+"失败,"+rm.getErrmsg());
		}
		return rm;
	}
	
	
	/**
	 * 根据电话号码开通，现金账户开通接口
	 * 
	 * @param getsmsvo
	 * @return
	 */
	@RequestMapping("/openByMobileNum")
	@AccessRequered(methodName="现金账户开通")
	public @ResponseBody Object openCashAccountByMobile(HttpServletRequest request) {
		/*{
		    "app":{
		        "appId":"zjhtwallet","timeStamp":"TIMESTAMP", "nonce":"NONCE","signature":"SIGNATURE"
		    },
		    "open":{
		        "mobileNum":"13912345678"
		    }
		}  */ 
		final BaseTransVO<MobileBodyVO> transorder;
		
		ResultModel rm = new ResultModel();
		try {
			String jsonstr = RequestUtil.getRequestPostData(request);
			request.setAttribute("rawjson", jsonstr);
			transorder = RequestUtil.convertJson2Obj(jsonstr, BaseTransVO.class,MobileBodyVO.class);
		} catch (Exception e) {
			log.error(String.format("获取订单查询参数出错"),e);
			rm.mergeException(ValidateException.ERROR_PARAM_FORMAT_ERROR.cloneAndAppend(null, "订单查询参数"));
			return rm;
		}
		
		String messagebase = "资金账户开通";
		rm.setBaseErrorCode(27000);
		rm.setErrmsg(messagebase+"成功");
		try {
			//获取url以作为method的内容
			String requestURI = request.getRequestURI();
			requestURI=requestURI.replace(request.getContextPath(), "");
			
			PropertiesUtil pu = new PropertiesUtil();
			MobileBodyVO body=transorder.getBody();
			//检查mobileNum
			ValidateUtil.validateMobile(body.getMobileNum());
			User user= userSer.queryUserByMobile(body.getMobileNum());
			
			ProjectAccount projectAccount=new ProjectAccount();
			String mobileNum = body.getMobileNum();
			if(user==null){
				if (log.isDebugEnabled()) {
					log.debug(String.format("手机号码%s没有注册",body.getMobileNum()));
				}
				throw new MaAccountException(MaAccountException.ERR_ACCOUNT_EXCEPTION,String.format("手机号码%s没有注册",body.getMobileNum()));		
				
			}
			else{

				projectAccount=proActDao.queryAccountInfo(user.getId());
				//现金账户不存在，就创建，并重新获取账户信息
				if(projectAccount==null){
					capitalManageSer.createAccount(user.getId());
					projectAccount=(ProjectAccount) AccountFactory.getAccount(Account.ACCOUNT_PROJECT,body.getMobileNum());
					if(log.isDebugEnabled()){
						log.debug("现金账户不存在，创建现金账户");
					}
				}
				
				
			}
			
			
			
			rm.put("accountId", projectAccount.getAccountId());
			
		}
		catch (Exception e1) {
			log.error(String.format(messagebase+"失败"),e1);
			rm.mergeException(e1);
			rm.setErrmsg(messagebase+"失败，"+rm.getErrmsg());
		}
		
		return rm;
	}
	/**
	 * 现金账户开通接口，根据userId开通
	 * 
	 * @param getsmsvo
	 * @return
	 */
	@RequestMapping("/open")
	@AccessRequered(methodName="现金账户开通")
	public @ResponseBody Object openCashAccount(HttpServletRequest request) {
		/*{
		    "app":{
		        "appId":"zjhtwallet","timeStamp":"TIMESTAMP", "nonce":"NONCE","signature":"SIGNATURE"
		    },
		    "open":{
		        "userId":1
		    }
		}  */ 
		final BaseTransVO<UserBodyVO> transorder;
		
		ResultModel rm = new ResultModel();
		try {
			String jsonstr = RequestUtil.getRequestPostData(request);
			request.setAttribute("rawjson", jsonstr);
			transorder = RequestUtil.convertJson2Obj(jsonstr, BaseTransVO.class,UserBodyVO.class);
		} catch (Exception e) {
			log.error(String.format("获取订单查询参数出错"),e);
			rm.mergeException(ValidateException.ERROR_PARAM_FORMAT_ERROR.cloneAndAppend(null, "订单查询参数"));
			return rm;
		}
		
		String messagebase = "资金账户开通";
		rm.setBaseErrorCode(27000);
		rm.setErrmsg(messagebase+"成功");
		try {
			//获取url以作为method的内容
			String requestURI = request.getRequestURI();
			requestURI=requestURI.replace(request.getContextPath(), "");
			
			PropertiesUtil pu = new PropertiesUtil();
			UserBodyVO body=transorder.getBody();
			//检查mobileNum
			ValidateUtil.validateMobile(body.getMobileNum());
			ProjectAccount projectAccount=new ProjectAccount();
			

			projectAccount=proActDao.queryAccountInfo(body.getUserId());
			//现金账户不存在，就创建，并重新获取账户信息
			if(projectAccount==null){
				capitalManageSer.createAccount(body.getUserId());
				if(log.isDebugEnabled()){
					log.debug("现金账户不存在，创建现金账户");
				}
			}
			
		
			
		}
		catch (Exception e1) {
			log.error(String.format(messagebase+"失败"),e1);
			rm.mergeException(e1);
			rm.setErrmsg(messagebase+"失败，"+rm.getErrmsg());
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
