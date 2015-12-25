package com.hummingbird.capital.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
import com.hummingbird.capital.entity.ProjectPaymentAccount;
import com.hummingbird.capital.entity.ProjectPaymentWithdrawApply;
import com.hummingbird.capital.entity.Token;
import com.hummingbird.capital.entity.User;
import com.hummingbird.capital.event.DrawalsEvent;
import com.hummingbird.capital.event.RechargeEvent;
import com.hummingbird.capital.exception.MaAccountException;
import com.hummingbird.capital.face.Account;
import com.hummingbird.capital.mapper.AppLogMapper;
import com.hummingbird.capital.mapper.PlatformBankcardMapper;
import com.hummingbird.capital.mapper.ProjectAccountMapper;
import com.hummingbird.capital.mapper.ProjectPaymentAccountMapper;
import com.hummingbird.capital.services.CapitalManageService;
import com.hummingbird.capital.services.OrderService;
import com.hummingbird.capital.services.TokenService;
import com.hummingbird.capital.services.UserService;
import com.hummingbird.capital.util.AccountFactory;
import com.hummingbird.capital.util.MoneyUtil;
import com.hummingbird.capital.vo.ApplyListReturnVO;
import com.hummingbird.capital.vo.CapitalSurveyReturnVO;
import com.hummingbird.capital.vo.CheckRechargeApplyBodyVO;
import com.hummingbird.capital.vo.CheckWithdrawalBodyVO;
import com.hummingbird.capital.vo.FreezeBondBodyVO;
import com.hummingbird.capital.vo.FreezeBondReturnVO;
import com.hummingbird.capital.vo.FreezeBondVO;
import com.hummingbird.capital.vo.GetPlatformBankcardReturnVO;
import com.hummingbird.capital.vo.MobileBodyVO;
import com.hummingbird.capital.vo.PayMatchHandingChargeVO;
import com.hummingbird.capital.vo.ProjectPaymentBodyVO;
import com.hummingbird.capital.vo.QueryProjectAccountReturnVO;
import com.hummingbird.capital.vo.QueryWithdrawalsFeeVO;
import com.hummingbird.capital.vo.RechargeApplyBodyVO;
import com.hummingbird.capital.vo.RechargeApplyReturnVO;
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
import com.hummingbird.common.event.EventListenerContainer;
import com.hummingbird.common.event.RequestEvent;
import com.hummingbird.common.exception.ValidateException;
import com.hummingbird.common.ext.AccessRequered;
import com.hummingbird.common.face.AbstractAppLog;
import com.hummingbird.common.face.Pagingnation;
import com.hummingbird.common.util.CollectionTools;
import com.hummingbird.common.util.DateUtil;
import com.hummingbird.common.util.PropertiesUtil;
import com.hummingbird.common.util.RequestUtil;
import com.hummingbird.common.util.ValidateUtil;
import com.hummingbird.common.vo.ResultModel;
import com.hummingbird.commonbiz.exception.TokenException;
import com.hummingbird.commonbiz.service.IAuthenticationService;
import com.hummingbird.commonbiz.vo.BaseTransVO;

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
	TokenService tokenSrv;
	@Autowired
	PlatformBankcardMapper platformBankcardDao;
	@Autowired
	private ProjectAccountMapper proActDao;
	@Autowired
	private ProjectPaymentAccountMapper proPaymentActDao;
	
	@RequestMapping(value = "/queryMyCapitalSurvey", method = RequestMethod.POST)
	@AccessRequered(methodName = "查询我的资金账户概况",isJson=false,codebase=251100,appLog=true,convert2javabean=false)
	public @ResponseBody Object queryMyCapitalSurvey(HttpServletRequest request) {
		
		TokenVO transorder;
		ResultModel rm = super.getResultModel();
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
			
			if(log.isDebugEnabled()){
				log.debug("检验通过，获取请求");
			}
			Token token = tokenSrv.getToken(transorder.getBody().getToken(), transorder.getApp().getAppId());
			if (token == null) {
				log.error(String.format("token[%s]验证失败,或已过期,请重新登录", transorder.getBody().getToken()));
				throw new TokenException("token验证失败,或已过期,请重新登录");
			}
			User user=userSer.getUser(token.getUserId());
			CapitalSurveyReturnVO survey=new CapitalSurveyReturnVO();
			if(user!=null){
				ProjectAccount proActInfo=(ProjectAccount)getAccount(user.getMobileNum());
				if(proActInfo!=null){
					survey.setBalance(proActInfo.getRemainingSum().toString());
					survey.setFreezeAmount(proActInfo.getFrozenSum().toString());
					survey.setIncome(capitalManageSer.getAccountIncome(proActInfo.getAccountId()).toString());
					survey.setOutlay(capitalManageSer.getAccountOutlay(proActInfo.getAccountId()).toString());					
				}
			}
			
			rm.put("myCapitalInfo",survey);
			tokenSrv.postponeToken(token);
		} catch (Exception e1) {
			log.error(String.format(messagebase+"失败"),e1);
			rm.mergeException(e1);
			rm.setErrmsg(messagebase+"失败,"+rm.getErrmsg());
		}
		return rm;
	}
	
	@RequestMapping(value = "/queryTransactionRecords", method = RequestMethod.POST)
	@AccessRequered(methodName = "查询我的资金账户流水",isJson=false,codebase=251200,appLog=true,convert2javabean=false)
	public @ResponseBody Object queryTransactionRecords(HttpServletRequest request) {
		
		final BaseTransVO<TokenQueryVO> transorder;
		ResultModel rm = super.getResultModel();
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
			Token token = tokenSrv.getToken(transorder.getBody().getToken(), transorder.getApp().getAppId());
			if (token == null) {
				log.error(String.format("token[%s]验证失败,或已过期,请重新登录", transorder.getBody().getToken()));
				throw new TokenException("token验证失败,或已过期,请重新登录");
			}
			User user=userSer.getUser(token.getUserId());
			List<TransactionRecordsReturnVO> list=new ArrayList<TransactionRecordsReturnVO>();
			if(user!=null){
				Account proActInfo=getAccount(user.getMobileNum());//capitalManageSer.queryAccountInfo(user.getId());
				
				if(proActInfo!=null){
					List<ProjectAccountOrder> records=capitalManageSer.queryAccountRecordsByAccountId(proActInfo.getAccountId(),page);
					for(ProjectAccountOrder order:records){
						TransactionRecordsReturnVO record=new TransactionRecordsReturnVO();
						record.setBalance(order.getBalance().toString());
						record.setTime(DateUtil.formatCommonDateorNull(order.getInsertTime()));
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
					tokenSrv.postponeToken(token);
				}else{
					if (log.isDebugEnabled()) {
						log.debug(String.format("根据用户id[%s]查找不到用户资金账户",user.getId()));
					}
					throw new MaAccountException(MaAccountException.ERR_ACCOUNT_EXCEPTION,String.format("根据用户id[%s]查找不到用户资金账户",user.getId()));
					
				}
			}

			tokenSrv.postponeToken(token);
			
		} catch (Exception e1) {
			log.error(String.format(messagebase+"失败"),e1);
			rm.mergeException(e1);
			rm.setErrmsg(messagebase+"失败,"+rm.getErrmsg());
		}
		return rm;
	}
	@RequestMapping(value = "/freezeBond", method = RequestMethod.POST)
	@AccessRequered(methodName = "冻结撮合担保金",isJson=false,codebase=251300,appLog=true,convert2javabean=false)
	public @ResponseBody Object freezeBond(HttpServletRequest request) {
		
		FreezeBondVO transorder;
		ResultModel rm = super.getResultModel();
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
			Token token = tokenSrv.getToken(transorder.getBody().getToken(), transorder.getApp().getAppId());
			if (token == null) {
				log.error(String.format("token[%s]验证失败,或已过期,请重新登录", transorder.getBody().getToken()));
				throw new TokenException("token验证失败,或已过期,请重新登录");
			}
			User user=userSer.getUser(token.getUserId());
			if(body.getIsVerityPassword()){
				capitalManageSer.validatePaymentCode(body.getTradePassword(), user,appkey);
			}
			FreezeBondReturnVO orderInfo=new FreezeBondReturnVO();
			if(user!=null){
				body.setType("JBZ");
				orderInfo=orderSer.freeze(body, user, requestURI);
			}
			rm.put("order", orderInfo);
			tokenSrv.postponeToken(token);
		} catch (Exception e1) {
			log.error(String.format(messagebase+"失败"),e1);
			rm.mergeException(e1);
			rm.setErrmsg(messagebase+"失败,"+rm.getErrmsg());
		}
		return rm;
	}
	
	@RequestMapping(value = "/unfreezeBond", method = RequestMethod.POST)
	@AccessRequered(methodName = "解冻撮合担保金",isJson=false,codebase=251400,appLog=true,convert2javabean=false)
	public @ResponseBody Object unfreezeBond(HttpServletRequest request) {
		
		final BaseTransVO<UnfreezeBondVO> transorder;
		ResultModel rm = super.getResultModel();
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
			
			UnfreezeBondVO body=transorder.getBody();
			if(log.isDebugEnabled()){
				log.debug("检验通过，获取请求");
			}
			Token token = tokenSrv.getToken(transorder.getBody().getToken(), transorder.getApp().getAppId());
			if (token == null) {
				log.error(String.format("token[%s]验证失败,或已过期,请重新登录", transorder.getBody().getToken()));
				throw new TokenException("token验证失败,或已过期,请重新登录");
			}
			User user=userSer.getUser(token.getUserId());
			
			FreezeBondReturnVO orderInfo=new FreezeBondReturnVO();
			if(user!=null){
				UnfreezeVO unfreeze=new UnfreezeVO();
				unfreeze.setAppOrderId(body.getAppOrderId());
				unfreeze.setObjectId(body.getObjectId());
				unfreeze.setOrignalOrderId(body.getOrignalOrderId());
				unfreeze.setRemark(body.getRemark());
				unfreeze.setType("SBZ");
				orderInfo=orderSer.unfreeze(unfreeze, requestURI);
			}
			rm.put("order", orderInfo);
			tokenSrv.postponeToken(token);
		} catch (Exception e1) {
			log.error(String.format(messagebase+"失败"),e1);
			rm.mergeException(e1);
			rm.setErrmsg(messagebase+"失败,"+rm.getErrmsg());
		}
		return rm;
	}
	
	@RequestMapping(value = "/payMatchHandingCharge", method = RequestMethod.POST)
	@AccessRequered(methodName = "支付撮合手续费",isJson=false,codebase=251800,appLog=true,convert2javabean=false)
	public @ResponseBody Object payMatchHandingCharge(HttpServletRequest request) {
		
		final BaseTransVO<PayMatchHandingChargeVO> transorder;
		ResultModel rm = super.getResultModel();
		try {
			String jsonstr = RequestUtil.getRequestPostData(request);
			request.setAttribute("rawjson", jsonstr);
			transorder = RequestUtil.convertJson2Obj(jsonstr,BaseTransVO.class, PayMatchHandingChargeVO.class);
		} catch (Exception e) {
			log.error(String.format("获取订单参数出错"),e);
			rm.mergeException(ValidateException.ERROR_PARAM_FORMAT_ERROR.cloneAndAppend(null, "订单参数"));
			return rm;
		}
		
		String messagebase = "支付撮合手续费";
		rm.setBaseErrorCode(251800);
		rm.setErrmsg(messagebase+"成功");
		try {
			//获取url以作为method的内容
			String requestURI = request.getRequestURI();
			requestURI=requestURI.replace(request.getContextPath(), "");
			PayMatchHandingChargeVO body=transorder.getBody();
			if(log.isDebugEnabled()){
				log.debug("检验通过，获取请求");
			}
			
			
			rm.put("result", orderSer.payMatchHandingCharge(body,requestURI));
		} catch (Exception e1) {
			log.error(String.format(messagebase+"失败"),e1);
			rm.mergeException(e1);
			rm.setErrmsg(messagebase+"失败,"+rm.getErrmsg());
		}
		return rm;
	}
	
	
	
	@RequestMapping(value = "/queryRechargeApplyList", method = RequestMethod.POST)
	@AccessRequered(methodName = "查询充值申请记录",isJson=false,codebase=251500,appLog=true,convert2javabean=false)
	public @ResponseBody Object queryRechargeApplyList(HttpServletRequest request) {
		
		final BaseTransVO<TokenBodyVO> transorder;
		ResultModel rm = super.getResultModel();
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
			Token token = tokenSrv.getToken(transorder.getBody().getToken(), transorder.getApp().getAppId());
			if (token == null) {
				log.error(String.format("token[%s]验证失败,或已过期,请重新登录", transorder.getBody().getToken()));
				throw new TokenException("token验证失败,或已过期,请重新登录");
			}
			User user=userSer.getUser(token.getUserId());
			
			List<ApplyListReturnVO> list=new ArrayList<ApplyListReturnVO>();
			if(user!=null){
				
				list=orderSer.queryRechargeApplyList(user);
			}
			rm.put("list", list);
			tokenSrv.postponeToken(token);
		} catch (Exception e1) {
			log.error(String.format(messagebase+"失败"),e1);
			rm.mergeException(e1);
			rm.setErrmsg(messagebase+"失败,"+rm.getErrmsg());
		}
		return rm;
	}
	
	@RequestMapping(value = "/withdrawalsApply", method = RequestMethod.POST)
	@AccessRequered(methodName = "提现申请",isJson=false,codebase=251600,appLog=true,convert2javabean=false)
	public @ResponseBody Object withdrawalsApply(HttpServletRequest request) {
		
		WithdrawalsApplyVO transorder;
		ResultModel rm = super.getResultModel();
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
			Token token = tokenSrv.getToken(transorder.getBody().getToken(), transorder.getApp().getAppId());
			if (token == null) {
				log.error(String.format("token[%s]验证失败,或已过期,请重新登录", transorder.getBody().getToken()));
				throw new TokenException("token验证失败,或已过期,请重新登录");
			}
			User user=userSer.getUser(token.getUserId());
			capitalManageSer.validatePaymentCode(body.getTradePassword(), user,appkey);
			RechargeApplyReturnVO order=new RechargeApplyReturnVO();
			if(user!=null){
				order.setOrderId(orderSer.withdrawalsApply(body, user,requestURI));
			}
			rm.put("order", order);
			DrawalsEvent de =new DrawalsEvent(user.getId(), MoneyUtil.getMoneyStringDecimal4yuan(body.getAmount()), "STA");
			EventListenerContainer.getInstance().fireEvent(de);
			tokenSrv.postponeToken(token);
		} catch (Exception e1) {
			log.error(String.format(messagebase+"失败"),e1);
			rm.mergeException(e1);
			rm.setErrmsg(messagebase+"失败,"+rm.getErrmsg());
		}
		return rm;
	}
	
	@RequestMapping(value = "/projectPaymentWithdrawalsApply", method = RequestMethod.POST)
	@AccessRequered(methodName = "工程款提现申请",isJson=false,codebase=252800,appLog=true,convert2javabean=false)
	public @ResponseBody Object projectPaymentWithdrawalsApply(HttpServletRequest request) {
		
		WithdrawalsApplyVO transorder;
		ResultModel rm = super.getResultModel();
		try {
			String jsonstr = RequestUtil.getRequestPostData(request);
			request.setAttribute("rawjson", jsonstr);
			transorder = RequestUtil.convertJson2Obj(jsonstr,WithdrawalsApplyVO.class);
		} catch (Exception e) {
			log.error(String.format("获取订单参数出错"),e);
			rm.mergeException(ValidateException.ERROR_PARAM_FORMAT_ERROR.cloneAndAppend(null, "订单参数"));
			return rm;
		}
		
		String messagebase = "工程款提现申请";
		
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
			Token token = tokenSrv.getToken(transorder.getBody().getToken(), transorder.getApp().getAppId());
			if (token == null) {
				log.error(String.format("token[%s]验证失败,或已过期,请重新登录", transorder.getBody().getToken()));
				throw new TokenException("token验证失败,或已过期,请重新登录");
			}
			User user=userSer.getUser(token.getUserId());
			ValidateUtil.assertNullnoappend(user, "用户不存在");
			capitalManageSer.validatePaymentCode(body.getTradePassword(), user,appkey);
			RechargeApplyReturnVO order=new RechargeApplyReturnVO();
			order.setOrderId(orderSer.projectPaymentWithdrawalsApply(body, user,requestURI));
			rm.put("order", order);
			tokenSrv.postponeToken(token);
		} catch (Exception e1) {
			log.error(String.format(messagebase+"失败"),e1);
			rm.mergeException(e1);
			rm.setErrmsg(messagebase+"失败,"+rm.getErrmsg());
		}
		return rm;
	}
	
	
	
	@RequestMapping(value = "/checkWithdrawalsApply", method = RequestMethod.POST)
	@AccessRequered(methodName = "提现申请审核",isJson=false,codebase=251700,appLog=true,convert2javabean=false)
	public @ResponseBody Object checkWithdrawalsApply(HttpServletRequest request) {
		
		final BaseTransVO<CheckWithdrawalBodyVO> transorder;
		ResultModel rm = super.getResultModel();
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
		rm.setBaseErrorCode(251700);
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
	
	@RequestMapping(value = "/queryWithdrawalsFee", method = RequestMethod.POST)
	@AccessRequered(methodName = "查询提现手续费",isJson=false,codebase=251900,appLog=true,convert2javabean=false)
	public @ResponseBody Object queryWithdrawalsFee(HttpServletRequest request) {
		
		final BaseTransVO<QueryWithdrawalsFeeVO> transorder;
		ResultModel rm = super.getResultModel();
		try {
			String jsonstr = RequestUtil.getRequestPostData(request);
			request.setAttribute("rawjson", jsonstr);
			transorder = RequestUtil.convertJson2Obj(jsonstr,BaseTransVO.class, QueryWithdrawalsFeeVO.class);
		} catch (Exception e) {
			log.error(String.format("获取订单参数出错"),e);
			rm.mergeException(ValidateException.ERROR_PARAM_FORMAT_ERROR.cloneAndAppend(null, "订单参数"));
			return rm;
		}
		
		String messagebase = "查询提现手续费";
		rm.setBaseErrorCode(251900);
		rm.setErrmsg(messagebase+"成功");
		try {
			//获取url以作为method的内容
			PropertiesUtil pu = new PropertiesUtil();
			String requestURI = request.getRequestURI();
			requestURI=requestURI.replace(request.getContextPath(), "");
			QueryWithdrawalsFeeVO body=transorder.getBody();
			if(log.isDebugEnabled()){
				log.debug("检验通过，获取请求");
			}
			rm.put("feeAmount", orderSer.queryWithdrawalsFee(body.getAmount()));
		} catch (Exception e1) {
			log.error(String.format(messagebase+"失败"),e1);
			rm.mergeException(e1);
			rm.setErrmsg(messagebase+"失败,"+rm.getErrmsg());
		}
		return rm;
	}
	
	@RequestMapping(value = "/queryWithdrawalsApplyList", method = RequestMethod.POST)
	@AccessRequered(methodName = "查询申请提现记录",isJson=false,codebase=252100,appLog=true,convert2javabean=false)
	public @ResponseBody Object queryWithdrawalsApplyList(HttpServletRequest request) {
		
		final BaseTransVO<TokenBodyVO> transorder;
		ResultModel rm = super.getResultModel();
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
			Token token = tokenSrv.getToken(transorder.getBody().getToken(), transorder.getApp().getAppId());
			if (token == null) {
				log.error(String.format("token[%s]验证失败,或已过期,请重新登录", transorder.getBody().getToken()));
				throw new TokenException("token验证失败,或已过期,请重新登录");
			}
			User user=userSer.getUser(token.getUserId());
			
			List<WithdrawalsApplyListReturnVO> list=new ArrayList<WithdrawalsApplyListReturnVO>();
			if(user!=null){
				list=orderSer.queryWithdrawalsApplyList(user);
			}
			rm.put("list", list);
			tokenSrv.postponeToken(token);
		} catch (Exception e1) {
			log.error(String.format(messagebase+"失败"),e1);
			rm.mergeException(e1);
			rm.setErrmsg(messagebase+"失败,"+rm.getErrmsg());
		}
		return rm;
	}
	@RequestMapping(value = "/rechargeApply", method = RequestMethod.POST)
	@AccessRequered(methodName = "充值申请",isJson=false,codebase=252200,appLog=true,convert2javabean=false)
	public @ResponseBody Object rechargeApply(HttpServletRequest request) {
		
		final BaseTransVO<RechargeApplyBodyVO> transorder;
		ResultModel rm = super.getResultModel();
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
			Token token = tokenSrv.getToken(transorder.getBody().getToken(), transorder.getApp().getAppId());
			if (token == null) {
				log.error(String.format("token[%s]验证失败,或已过期,请重新登录", transorder.getBody().getToken()));
				throw new TokenException("token验证失败,或已过期,请重新登录");
			}
			User user=userSer.getUser(token.getUserId());
			
			RechargeApplyReturnVO order=new RechargeApplyReturnVO();
			if(user!=null){
				order.setOrderId(orderSer.rechargeApply(body, user));
			}
			rm.put("order", order);
			RechargeEvent re =new RechargeEvent(user.getId(), MoneyUtil.getMoneyStringDecimal4yuan(body.getAmount()), "STA");
			EventListenerContainer.getInstance().fireEvent(re);
			tokenSrv.postponeToken(token);
		} catch (Exception e1) {
			log.error(String.format(messagebase+"失败"),e1);
			rm.mergeException(e1);
			rm.setErrmsg(messagebase+"失败,"+rm.getErrmsg());
		}
		return rm;
	}
	@RequestMapping(value = "/checkRechargeApply", method = RequestMethod.POST)
	@AccessRequered(methodName = "充值申请审核",isJson=false,codebase=252300,appLog=true,convert2javabean=false)
	public @ResponseBody Object checkRechargeApply(HttpServletRequest request) {
		
		final BaseTransVO<CheckRechargeApplyBodyVO> transorder;
		ResultModel rm = super.getResultModel();
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
	
	
	@RequestMapping(value = "/queryProjectAccount", method = RequestMethod.POST)
	@AccessRequered(methodName = "查询用户帐户详情",isJson=false,codebase=252500,appLog=true,convert2javabean=false)
	public @ResponseBody Object queryProjectAccount(HttpServletRequest request) {
		
		TokenVO transorder;
		ResultModel rm = super.getResultModel();
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
			Token token = tokenSrv.getToken(transorder.getBody().getToken(), transorder.getApp().getAppId());
			if (token == null) {
				log.error(String.format("token[%s]验证失败,或已过期,请重新登录", transorder.getBody().getToken()));
				throw new TokenException("token验证失败,或已过期,请重新登录");
			}
			User user=userSer.getUser(token.getUserId());
			QueryProjectAccountReturnVO account=new QueryProjectAccountReturnVO();
			if(user!=null){
				ProjectAccount proActInfo=capitalManageSer.queryAccountInfo(user.getId());
				if(proActInfo!=null){
					account.setRemainingSum(proActInfo.getRemainingSum());
					account.setFrozenSum(proActInfo.getFrozenSum());
					account.setAccountId(proActInfo.getAccountId());
					account.setStatus(proActInfo.getStatus());
				}
			}
			
			rm.put("account",account);
			tokenSrv.postponeToken(token);
		} catch (Exception e1) {
			log.error(String.format(messagebase+"失败"),e1);
			rm.mergeException(e1);
			rm.setErrmsg(messagebase+"失败,"+rm.getErrmsg());
		}
		return rm;
	}
	
	@RequestMapping(value = "/queryProjectPaymentAccount", method = RequestMethod.POST)
	@AccessRequered(methodName = "查询用户工程款帐户详情",isJson=false,codebase=253000,appLog=true,convert2javabean=false)
	public @ResponseBody Object queryProjectPaymentAccount(HttpServletRequest request) {
		
		TokenVO transorder;
		ResultModel rm = super.getResultModel();
		try {
			String jsonstr = RequestUtil.getRequestPostData(request);
			request.setAttribute("rawjson", jsonstr);
			transorder = RequestUtil.convertJson2Obj(jsonstr, TokenVO.class);
		} catch (Exception e) {
			log.error(String.format("获取订单参数出错"),e);
			rm.mergeException(ValidateException.ERROR_PARAM_FORMAT_ERROR.cloneAndAppend(null, "订单参数"));
			return rm;
		}
		
		String messagebase = "查询用户工程款帐户详情";
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
			User user=userSer.getUser(token.getUserId());
			QueryProjectAccountReturnVO account=new QueryProjectAccountReturnVO();
			if(user!=null){
				ProjectPaymentAccount proActInfo=capitalManageSer.queryProjectPaymentAccountInfo(user.getId());
				if(proActInfo!=null){
					account.setRemainingSum(proActInfo.getRemainingSum());
					account.setFrozenSum(proActInfo.getFrozenSum());
					account.setAccountId(proActInfo.getAccountId());
					account.setStatus(proActInfo.getStatus());
				}
			}
			
			rm.put("account",account);
			tokenSrv.postponeToken(token);
		} catch (Exception e1) {
			log.error(String.format(messagebase+"失败"),e1);
			rm.mergeException(e1);
			rm.setErrmsg(messagebase+"失败,"+rm.getErrmsg());
		}
		return rm;
	}
	
	@RequestMapping(value = "/getPlatformBankcard", method = RequestMethod.POST)
	@AccessRequered(methodName = "获取平台方银行账户",isJson=false,codebase=252000,appLog=true,convert2javabean=false)
	public @ResponseBody Object getPlatformBankcard(HttpServletRequest request) {
		
		final BaseTransVO<TokenBodyVO> transorder;
		ResultModel rm = super.getResultModel();
		try {
			String jsonstr = RequestUtil.getRequestPostData(request);
			request.setAttribute("rawjson", jsonstr);
			transorder = RequestUtil.convertJson2Obj(jsonstr, BaseTransVO.class,TokenBodyVO.class);
		} catch (Exception e) {
			log.error(String.format("获取订单参数出错"),e);
			rm.mergeException(ValidateException.ERROR_PARAM_FORMAT_ERROR.cloneAndAppend(null, "订单参数"));
			return rm;
		}
		
		String messagebase = "获取平台方银行账户";
		rm.setBaseErrorCode(252000);
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
			User user=userSer.getUser(token.getUserId());
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
			tokenSrv.postponeToken(token);
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
	@AccessRequered(methodName = "资金账户开通",isJson=false,codebase=252400,appLog=true,convert2javabean=false)
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
		
		ResultModel rm = super.getResultModel();
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
		rm.setBaseErrorCode(252400);
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
			
//			ProjectAccount projectAccount=new ProjectAccount();
//			String mobileNum = body.getMobileNum();
			if(user==null){
				if (log.isDebugEnabled()) {
					log.debug(String.format("手机号码%s没有注册",body.getMobileNum()));
				}
				throw new MaAccountException(MaAccountException.ERR_ACCOUNT_EXCEPTION,String.format("手机号码%s没有注册",body.getMobileNum()));		
				
			}
			else{


				//				projectAccount=proActDao.queryAccountInfo(user.getId());
//				//现金账户不存在，就创建，并重新获取账户信息
//				if(projectAccount==null){
//					capitalManageSer.createAccount(user.getId());
//					projectAccount=(ProjectAccount) AccountFactory.getAccount(Account.ACCOUNT_PROJECT,body.getMobileNum());
//					if(log.isDebugEnabled()){
//						log.debug("现金账户不存在，创建现金账户");
//					}
//				}
				Integer userId = user.getId();
				Account pa = capitalManageSer.createAccount(userId);
				Account ppa = capitalManageSer.createAccount(userId);
				rm.put("accountId", pa.getAccountId());
				rm.put("projectPaymentAccountId", ppa.getAccountId());
				
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
	 * 现金账户开通接口，根据userId开通
	 * 
	 * @param getsmsvo
	 * @return
	 */
	@RequestMapping("/open")
	@AccessRequered(methodName = "用户相关账户开通",isJson=false,codebase=252600,appLog=true,convert2javabean=false)
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
		
		ResultModel rm = super.getResultModel();
		try {
			String jsonstr = RequestUtil.getRequestPostData(request);
			request.setAttribute("rawjson", jsonstr);
			transorder = RequestUtil.convertJson2Obj(jsonstr, BaseTransVO.class,UserBodyVO.class);
		} catch (Exception e) {
			log.error(String.format("获取订单查询参数出错"),e);
			rm.mergeException(ValidateException.ERROR_PARAM_FORMAT_ERROR.cloneAndAppend(null, "订单查询参数"));
			return rm;
		}
		
		String messagebase = "用户相关账户开通";
		rm.setBaseErrorCode(252600);
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
			
			Integer userId = body.getUserId();
			ValidateUtil.assertNullnoappend(userId, "用户标识不存在");
//			projectAccount=proActDao.queryAccountInfo(userId);
//			//现金账户不存在，就创建，并重新获取账户信息
//			if(projectAccount==null){
//				if(log.isDebugEnabled()){
//					log.debug("现金账户不存在，创建现金账户");
//				}
//			}
			capitalManageSer.createAccount(userId);
			capitalManageSer.createProjectPaymentAccount(userId);
		
			
		}
		catch (Exception e1) {
			log.error(String.format(messagebase+"失败"),e1);
			rm.mergeException(e1);
			rm.setErrmsg(messagebase+"失败，"+rm.getErrmsg());
		}
		
		return rm;
	}
	
	/**
	 * 根据手机号码获取本类指定的帐户信息
	 * @param mobile
	 * @return
	 * @throws MaAccountException
	 */
	protected  Account getAccount(String mobile) throws MaAccountException {
		Account acc=AccountFactory.getAccount(Account.ACCOUNT_PROJECT,mobile);
		return acc;
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
	
//	/**
//	 * 平台方支出接口
//	 * @return
//	 */
//	@RequestMapping(value="/platformPay",method=RequestMethod.POST)
//	@AccessRequered(methodName = "平台方支出",isJson=true,codebase=249000,className="com.hummingbird.commonbiz.vo.BaseTransVO",genericClassName="com.hummingbird.capital.vo.PlatformPaymentBodyVO",appLog=true)
//	public @ResponseBody ResultModel platformPay(HttpServletRequest request,HttpServletResponse response) {
//		ResultModel rm = super.getResultModel();
//		BaseTransVO<PlatformPaymentBodyVO> transorder = (BaseTransVO<PlatformPaymentBodyVO>) super.getParameterObject();
//		String messagebase = "平台方支出"; 
//	
//		RequestEvent qe=null ; //业务请求事件,当实现一些关键的业务时,需要生成该请求
//		
//		try {
//			//业务数据必填等校验
//			//业务数据逻辑校验
//			if(log.isDebugEnabled()){
//				log.debug("检验通过，获取请求");
//			}
//			Integer platformuserId = 0;
//			ProjectAccount pa = capitalManageSer.queryAccountInfo(platformuserId);
//			if(pa.getRemainingSum()>transorder.getBody().getAmount()){
//				throw new MaAccountException("平台方余额不足以扣款");
//			}
//			pa.setRemainingSum(pa.getRemainingSum()-transorder.getBody().getAmount());
//			proActDao.updateByPrimaryKey(pa);
//		}catch (Exception e1) {
//			log.error(String.format(messagebase + "失败"), e1);
//			rm.mergeException(e1);
//			if(qe!=null)
//				qe.setSuccessed(false);
//		} finally {
//			if(qe!=null)
//				EventListenerContainer.getInstance().fireEvent(qe);
//		}
//		return rm;
//		
//	}
	
//	/**
//	 * 平台方收入接口
//	 * @return
//	 */
//	@RequestMapping(value="/platformIncome",method=RequestMethod.POST)
//	@AccessRequered(methodName = "平台方收入",isJson=true,codebase=249000,className="com.hummingbird.commonbiz.vo.BaseTransVO",genericClassName="com.hummingbird.capital.vo.PlatformPaymentBodyVO",appLog=true)
//	public @ResponseBody ResultModel platformIncome(HttpServletRequest request,HttpServletResponse response) {
//		ResultModel rm = super.getResultModel();
//		BaseTransVO<PlatformPaymentBodyVO> transorder = (BaseTransVO<PlatformPaymentBodyVO>) super.getParameterObject();
//		String messagebase = "平台方收入"; 
//		
//		RequestEvent qe=null ; //业务请求事件,当实现一些关键的业务时,需要生成该请求
//		
//		try {
//			//业务数据必填等校验
//			//业务数据逻辑校验
//			if(log.isDebugEnabled()){
//				log.debug("检验通过，获取请求");
//			}
//			Integer platformuserId = 0;
//			ProjectAccount pa = capitalManageSer.queryAccountInfo(platformuserId);
//			pa.setRemainingSum(pa.getRemainingSum()+transorder.getBody().getAmount());
//			proActDao.updateByPrimaryKey(pa);
//		}catch (Exception e1) {
//			log.error(String.format(messagebase + "失败"), e1);
//			rm.mergeException(e1);
//			if(qe!=null)
//				qe.setSuccessed(false);
//		} finally {
//			if(qe!=null)
//				EventListenerContainer.getInstance().fireEvent(qe);
//		}
//		return rm;
//		
//	}
	
	/**
	 * 用户工程款帐户资金收入接口
	 * @return
	 */
	@RequestMapping(value="/userProjectPaymentAccountIncome",method=RequestMethod.POST)
	@AccessRequered(methodName = "用户工程款帐户资金收入",isJson=true,codebase=252700,className="com.hummingbird.commonbiz.vo.BaseTransVO",genericClassName="com.hummingbird.capital.vo.ProjectPaymentBodyVO",appLog=true)
	public @ResponseBody ResultModel UserAccountIncome(HttpServletRequest request,HttpServletResponse response) {
		ResultModel rm = super.getResultModel();
		BaseTransVO<ProjectPaymentBodyVO> transorder = (BaseTransVO<ProjectPaymentBodyVO>) super.getParameterObject();
		String messagebase = "用户工程款帐户资金收入接口"; 
		
		RequestEvent qe=null ; //业务请求事件,当实现一些关键的业务时,需要生成该请求
		
		try {
			//业务数据必填等校验
			//业务数据逻辑校验
			if(log.isDebugEnabled()){
				log.debug("检验通过，获取请求");
			}
			Integer platformuserId =NumberUtils.toInt( transorder.getBody().getUserId());
			capitalManageSer.incomeProjectPayment(platformuserId,transorder.getBody().getAmount(),transorder.getBody().getAppOrderId(),transorder.getBody().getRemark());
			
		}catch (Exception e1) {
			log.error(String.format(messagebase + "失败"), e1);
			rm.mergeException(e1);
			if(qe!=null)
				qe.setSuccessed(false);
		} finally {
			if(qe!=null)
				EventListenerContainer.getInstance().fireEvent(qe);
		}
		return rm;
		
	}
	
	@RequestMapping(value = "/queryProjectPaymentWithdrawalsApplyList", method = RequestMethod.POST)
	@AccessRequered(methodName = "查询工程款提现申请记录",isJson=false,codebase=252800,appLog=true,convert2javabean=false)
	public @ResponseBody Object queryProjectPaymentWithdrawalsApplyList(HttpServletRequest request) {
		
		final BaseTransVO<TokenQueryVO> transorder;
		ResultModel rm = super.getResultModel();
		try {
			String jsonstr = RequestUtil.getRequestPostData(request);
			request.setAttribute("rawjson", jsonstr);
			transorder = RequestUtil.convertJson2Obj(jsonstr,BaseTransVO.class, TokenQueryVO.class);
		} catch (Exception e) {
			log.error(String.format("获取订单参数出错"),e);
			rm.mergeException(ValidateException.ERROR_PARAM_FORMAT_ERROR.cloneAndAppend(null, "订单参数"));
			return rm;
		}
		
		String messagebase = "查询工程款提现申请记录";
		try {
			//获取url以作为method的内容
			String requestURI = request.getRequestURI();
			requestURI=requestURI.replace(request.getContextPath(), "");
			PropertiesUtil pu = new PropertiesUtil();
			TokenQueryVO body=transorder.getBody();
			
			
			if(log.isDebugEnabled()){
				log.debug("检验通过，获取请求");
			}
			Token token = tokenSrv.getToken(transorder.getBody().getToken(), transorder.getApp().getAppId());
			if (token == null) {
				log.error(String.format("token[%s]验证失败,或已过期,请重新登录", transorder.getBody().getToken()));
				throw new TokenException("token验证失败,或已过期,请重新登录");
			}
			Pagingnation pagingnation = body.toPagingnation();
			List<ProjectPaymentWithdrawApply> returnresult = orderSer.queryProjectPaymentWithdrawalsApplyList(token.getUserId(),pagingnation);
			List<WithdrawalsApplyListReturnVO> list = CollectionTools.convertCollection(returnresult, WithdrawalsApplyListReturnVO.class, new CollectionTools.CollectionElementConvertor<ProjectPaymentWithdrawApply, WithdrawalsApplyListReturnVO>() {

				@Override
				public WithdrawalsApplyListReturnVO convert(ProjectPaymentWithdrawApply apply) {
					WithdrawalsApplyListReturnVO returnvo=new WithdrawalsApplyListReturnVO();
					returnvo.setAmount(apply.getWithdrawAmount().toString());
					returnvo.setCreateTime(DateUtil.formatCommonDateorNull(apply.getInsertTime()));
					returnvo.setHandingCharge(apply.getCommissionFees().toString());
					returnvo.setRemark(apply.getRemark());
					returnvo.setStatus(apply.getStatus());
					returnvo.setWithdrawalsNo(apply.getVoucher());
					returnvo.setWithdrawalsTime(DateUtil.formatCommonDateorNull(apply.getTransportTime()));
					returnvo.setRealWithdrawalsAmount(ObjectUtils.toString(apply.getRealWithdrawAmount()));
					return returnvo;
				}

				
			});
			super.mergeListOutput(rm, pagingnation, list);
			tokenSrv.postponeToken(token);
		} catch (Exception e1) {
			log.error(String.format(messagebase+"失败"),e1);
			rm.mergeException(e1);
			rm.setErrmsg(messagebase+"失败,"+rm.getErrmsg());
		}
		return rm;
	}
	
	@RequestMapping(value = "/checkProjectPaymentWithdrawalsApply", method = RequestMethod.POST)
	@AccessRequered(methodName = "工程款提现申请审核",isJson=false,codebase=252900,appLog=true,convert2javabean=false)
	public @ResponseBody Object checkProjectPaymentWithdrawalsApply(HttpServletRequest request) {
		
		final BaseTransVO<CheckWithdrawalBodyVO> transorder;
		ResultModel rm = super.getResultModel();
		try {
			String jsonstr = RequestUtil.getRequestPostData(request);
			request.setAttribute("rawjson", jsonstr);
			transorder = RequestUtil.convertJson2Obj(jsonstr,BaseTransVO.class, CheckWithdrawalBodyVO.class);
		} catch (Exception e) {
			log.error(String.format("获取订单参数出错"),e);
			rm.mergeException(ValidateException.ERROR_PARAM_FORMAT_ERROR.cloneAndAppend(null, "订单参数"));
			return rm;
		}
		
		String messagebase = "工程款提现申请审核";
		try {
			//获取url以作为method的内容
			PropertiesUtil pu = new PropertiesUtil();
			String requestURI = request.getRequestURI();
			requestURI=requestURI.replace(request.getContextPath(), "");
			CheckWithdrawalBodyVO body=transorder.getBody();
			if(log.isDebugEnabled()){
				log.debug("检验通过，获取请求");
			}
			orderSer.checkProjectPaymentWithdrawalApply(body,requestURI);
		} catch (Exception e1) {
			log.error(String.format(messagebase+"失败"),e1);
			rm.mergeException(e1);
			rm.setErrmsg(messagebase+"失败,"+rm.getErrmsg());
		}
		return rm;
	}
	
}
