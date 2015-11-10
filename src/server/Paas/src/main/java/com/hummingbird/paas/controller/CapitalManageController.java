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
import com.hummingbird.paas.entity.ProjectAccount;
import com.hummingbird.paas.entity.ProjectAccountOrder;
import com.hummingbird.paas.entity.User;
import com.hummingbird.paas.entity.UserBankcard;
import com.hummingbird.paas.exception.MaAccountException;
import com.hummingbird.paas.services.CapitalManageService;
import com.hummingbird.paas.services.GeneralService;
import com.hummingbird.paas.services.OrderService;
import com.hummingbird.paas.services.UserService;
import com.hummingbird.paas.vo.ApplyListReturnVO;
import com.hummingbird.paas.vo.BankInfoReturnDetailVO;
import com.hummingbird.paas.vo.CapitalSurveyReturnVO;
import com.hummingbird.paas.vo.FreezeBondBodyVO;
import com.hummingbird.paas.vo.FreezeBondReturnVO;
import com.hummingbird.paas.vo.RechargeApplyBodyVO;
import com.hummingbird.paas.vo.RechargeApplyReturnVO;
import com.hummingbird.paas.vo.TokenQueryVO;
import com.hummingbird.paas.vo.TokenVO;
import com.hummingbird.paas.vo.RegisterBodyVO;
import com.hummingbird.paas.vo.RegisterVO;
import com.hummingbird.paas.vo.TokenBodyVO;
import com.hummingbird.paas.vo.TransactionRecordsReturnVO;
import com.hummingbird.paas.vo.UnfreezeBondVO;
import com.hummingbird.paas.vo.WithdrawalsApplyBodyVO;
import com.hummingbird.paas.vo.WithdrawalsApplyListReturnVO;

@Controller
@RequestMapping("/userCenter")
public class CapitalManageController extends BaseController{
	@Autowired 
	UserService userSer;
	@Autowired
	CapitalManageService capitalManageSer;
	@Autowired
	OrderService orderSer;

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
				List<UserBankcard> bankcards=capitalManageSer.queryBankListByUserId(user.getId());
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
					survey.setBalance(proActInfo.getRemainingSum().toString());
					survey.setFreezeAmount(proActInfo.getFrozenSum().toString());
					survey.setIncome(capitalManageSer.getAccountIncome(proActInfo.getAccountId()).toString());
					survey.setOutlay(capitalManageSer.getAccountOutlay(proActInfo.getAccountId()).toString());					
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
						record.setBalance(order.getBalance().toString());
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
		rm.setBaseErrorCode(251800);
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
				orderInfo=orderSer.freezeBond(body, user, requestURI);
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
		rm.setBaseErrorCode(251900);
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
				orderInfo=orderSer.unfreezeBond(body, user, requestURI);
			}
			rm.put("order", orderInfo);
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
		rm.setBaseErrorCode(251300);
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
		rm.setBaseErrorCode(251500);
		rm.setErrmsg(messagebase+"成功");
		try {
			//获取url以作为method的内容
			String requestURI = request.getRequestURI();
			requestURI=requestURI.replace(request.getContextPath(), "");
			PropertiesUtil pu = new PropertiesUtil();
			WithdrawalsApplyBodyVO body=transorder.getBody();
			
			
			if(log.isDebugEnabled()){
				log.debug("检验通过，获取请求");
			}
			
			User user=userSer.queryUserByToken(body.getToken());
			capitalManageSer.validatePaymentCode(body.getTradePassword(), user);
			RechargeApplyReturnVO order=new RechargeApplyReturnVO();
			if(user!=null){
				order.setOrderId(orderSer.withdrawalsApply(body, user));
			}
			rm.put("order", order);
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
		rm.setBaseErrorCode(251400);
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
}
