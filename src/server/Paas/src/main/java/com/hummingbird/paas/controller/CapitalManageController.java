package com.hummingbird.paas.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hummingbird.common.controller.BaseController;
import com.hummingbird.common.exception.ValidateException;
import com.hummingbird.common.face.Pagingnation;
import com.hummingbird.common.util.PropertiesUtil;
import com.hummingbird.common.util.RequestUtil;
import com.hummingbird.common.util.ValidateUtil;
import com.hummingbird.common.vo.ResultModel;
import com.hummingbird.commonbiz.vo.BaseTransVO;
import com.hummingbird.paas.entity.Bidder;
import com.hummingbird.paas.entity.ProjectAccount;
import com.hummingbird.paas.entity.ProjectAccountOrder;
import com.hummingbird.paas.entity.RechargeApply;
import com.hummingbird.paas.entity.User;
import com.hummingbird.paas.entity.UserBankcard;
import com.hummingbird.paas.entity.WithdrawApply;
import com.hummingbird.paas.exception.MaAccountException;
import com.hummingbird.paas.services.CapitalManageService;
import com.hummingbird.paas.services.GeneralService;
import com.hummingbird.paas.services.OrderService;
import com.hummingbird.paas.services.UserService;
import com.hummingbird.paas.vo.ApplyListReturnVO;
import com.hummingbird.paas.vo.BankInfoReturnDetailVO;
import com.hummingbird.paas.vo.CapitalSurveyReturnVO;
import com.hummingbird.paas.vo.CheckRechargeApplyBodyVO;
import com.hummingbird.paas.vo.CheckWithdrawalBodyVO;
import com.hummingbird.paas.vo.FailWithdrawalsBodyVO;
import com.hummingbird.paas.vo.FreezeBondBodyVO;
import com.hummingbird.paas.vo.FreezeBondReturnVO;
import com.hummingbird.paas.vo.FreezeWithdrawalsBodyVO;
import com.hummingbird.paas.vo.QueryProjectAccountReturnVO;
import com.hummingbird.paas.vo.RechargeApplyBodyVO;
import com.hummingbird.paas.vo.RechargeApplyReturnVO;
import com.hummingbird.paas.vo.SuccessRechargeBodyVO;
import com.hummingbird.paas.vo.SuccessWithdrawalsBodyVO;
import com.hummingbird.paas.vo.TokenQueryVO;
import com.hummingbird.paas.vo.TokenVO;
import com.hummingbird.paas.vo.RegisterBodyVO;
import com.hummingbird.paas.vo.RegisterVO;
import com.hummingbird.paas.vo.TokenBodyVO;
import com.hummingbird.paas.vo.TransactionRecordsReturnVO;
import com.hummingbird.paas.vo.UnfreezeBondVO;
import com.hummingbird.paas.vo.UnfreezeVO;
import com.hummingbird.paas.vo.WithdrawalsApplyBodyVO;
import com.hummingbird.paas.vo.WithdrawalsApplyListReturnVO;

@Controller

@RequestMapping("/capitalManage")
public class CapitalManageController extends BaseController{
	@Autowired 
	UserService userSer;
	@Autowired
	CapitalManageService capitalManageSer;
	@Autowired
	OrderService orderSer;

	
	
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
			
			PropertiesUtil pu = new PropertiesUtil();
			TokenBodyVO body=transorder.getBody();
			
			if(log.isDebugEnabled()){
				log.debug("检验通过，获取请求");
			}
			
			User user=userSer.queryUserByToken(body.getToken());
			CapitalSurveyReturnVO survey=new CapitalSurveyReturnVO();
			if(user!=null){
				ProjectAccount proActInfo=capitalManageSer.queryAccountInfo(user.getId());
				if(proActInfo!=null){
					survey.setBalance(String.valueOf(proActInfo.getRemainingSum()/100));
					survey.setFreezeAmount(String.valueOf(proActInfo.getFrozenSum()/100));
					survey.setIncome(String.valueOf(capitalManageSer.getAccountIncome(proActInfo.getAccountId())/100));
					survey.setOutlay(String.valueOf(capitalManageSer.getAccountOutlay(proActInfo.getAccountId())/100));					
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
					List<ProjectAccountOrder> records=capitalManageSer.queryAccountRecordsByAccountId(proActInfo.getAccountId(),body.toPagingnation());
					for(ProjectAccountOrder order:records){
						TransactionRecordsReturnVO record=new TransactionRecordsReturnVO();
						record.setBalance(String.valueOf(order.getBalance()/100));
						record.setRemark(order.getRemark());
						record.setType(order.getType());
						if(StringUtils.equals(order.getFlowDirection(),"IN#")){
							record.setIncome(order.getSum().toString());
							record.setOutlay("0");
						}else if(StringUtils.equals(order.getFlowDirection(),"OUT")){
							record.setOutlay(order.getSum().toString());
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
		
		final BaseTransVO<FreezeBondBodyVO> transorder;
		ResultModel rm = new ResultModel();
		try {
			String jsonstr = RequestUtil.getRequestPostData(request);
			request.setAttribute("rawjson", jsonstr);
			transorder = RequestUtil.convertJson2Obj(jsonstr,BaseTransVO.class, FreezeBondBodyVO.class);
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
			PropertiesUtil pu = new PropertiesUtil();
			FreezeBondBodyVO body=transorder.getBody();
			//备注字段必填
			ValidateUtil.assertEmpty(body.getRemark(), "备注");
			
			if(log.isDebugEnabled()){
				log.debug("检验通过，获取请求");
			}
			
			User user=userSer.queryUserByToken(body.getToken());
			capitalManageSer.validatePaymentCode(body.getTradePassword(), user);
			FreezeBondReturnVO orderInfo=new FreezeBondReturnVO();
			if(user!=null){
				
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
				unfreeze.setOrignalOrderId(body.getOrderId());
				unfreeze.setOrignalTable("t_ztgl_object_makematch_bond_record");
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
		
		final BaseTransVO<WithdrawalsApplyBodyVO> transorder;
		ResultModel rm = new ResultModel();
		try {
			String jsonstr = RequestUtil.getRequestPostData(request);
			request.setAttribute("rawjson", jsonstr);
			transorder = RequestUtil.convertJson2Obj(jsonstr,BaseTransVO.class, WithdrawalsApplyBodyVO.class);
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
			WithdrawalsApplyBodyVO body=transorder.getBody();
			if(log.isDebugEnabled()){
				log.debug("检验通过，获取请求");
			}
			User user=userSer.queryUserByToken(body.getToken());
			capitalManageSer.validatePaymentCode(body.getTradePassword(), user);
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
		
		final BaseTransVO<FreezeWithdrawalsBodyVO> transorder;
		ResultModel rm = new ResultModel();
		try {
			String jsonstr = RequestUtil.getRequestPostData(request);
			request.setAttribute("rawjson", jsonstr);
			transorder = RequestUtil.convertJson2Obj(jsonstr,BaseTransVO.class, FreezeWithdrawalsBodyVO.class);
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
			FreezeWithdrawalsBodyVO body=transorder.getBody();
			if(log.isDebugEnabled()){
				log.debug("检验通过，获取请求");
			}
			//查询用户信息
			User user=userSer.queryUserByMobile(body.getMobileNum());
			capitalManageSer.validatePaymentCode(body.getTradePassword(), user);
			FreezeBondBodyVO freezeBody=new FreezeBondBodyVO();
			freezeBody.setOriginalOrderId(body.getOrderId());
			freezeBody.setRemark(body.getRemark());
			freezeBody.setSum(body.getAmount());
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
			String requestURI = request.getRequestURI();
			requestURI=requestURI.replace(request.getContextPath(), "");
			CheckWithdrawalBodyVO body=transorder.getBody();
			if(log.isDebugEnabled()){
				log.debug("检验通过，获取请求");
			}
			orderSer.CheckWithdrawalApply(body);
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
			orderSer.CheckRechargeApply(body);
			
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
					account.setRemainingSum(Double.valueOf(proActInfo.getRemainingSum()/100));
					account.setFrozenSum(Double.valueOf(proActInfo.getFrozenSum()/100));
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
}
