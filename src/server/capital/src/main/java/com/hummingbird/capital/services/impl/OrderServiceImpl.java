
package com.hummingbird.capital.services.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.hummingbird.capital.constant.OrderConst;
import com.hummingbird.capital.entity.ProjectAccount;
import com.hummingbird.capital.entity.ProjectAccountOrder;
import com.hummingbird.capital.entity.ProjectPaymentAccount;
import com.hummingbird.capital.entity.ProjectPaymentAccountOrder;
import com.hummingbird.capital.entity.ProjectPaymentWithdrawApply;
import com.hummingbird.capital.entity.RechargeApply;
import com.hummingbird.capital.entity.User;
import com.hummingbird.capital.entity.WithdrawApply;
import com.hummingbird.capital.event.DrawalsEvent;
import com.hummingbird.capital.event.RechargeEvent;
import com.hummingbird.capital.event.projectPaymentWithdrawalsApplyEvent;
import com.hummingbird.capital.exception.MaAccountException;
import com.hummingbird.capital.face.Account;
import com.hummingbird.capital.mapper.FeeRateMapper;
import com.hummingbird.capital.mapper.ProjectAccountMapper;
import com.hummingbird.capital.mapper.ProjectAccountOrderMapper;
import com.hummingbird.capital.mapper.ProjectPaymentAccountMapper;
import com.hummingbird.capital.mapper.ProjectPaymentAccountOrderMapper;
import com.hummingbird.capital.mapper.ProjectPaymentWithdrawApplyMapper;
import com.hummingbird.capital.mapper.RechargeApplyMapper;
import com.hummingbird.capital.mapper.UserBankcardMapper;
import com.hummingbird.capital.mapper.UserMapper;
import com.hummingbird.capital.mapper.WithdrawApplyMapper;
import com.hummingbird.capital.services.CapitalManageService;
import com.hummingbird.capital.services.OrderService;
import com.hummingbird.capital.util.AccountFactory;
import com.hummingbird.capital.util.AccountGenerationUtil;
import com.hummingbird.capital.util.AccountValidateUtil;
import com.hummingbird.capital.util.MoneyUtil;
import com.hummingbird.capital.vo.ApplyListReturnVO;
import com.hummingbird.capital.vo.CapitalOrderReturnVO;
import com.hummingbird.capital.vo.CheckRechargeApplyBodyVO;
import com.hummingbird.capital.vo.CheckWithdrawalBodyVO;
import com.hummingbird.capital.vo.FreezeBodyVO;
import com.hummingbird.capital.vo.FreezeBondBodyVO;
import com.hummingbird.capital.vo.FreezeBondReturnVO;
import com.hummingbird.capital.vo.LoseVO;
import com.hummingbird.capital.vo.PayMatchHandingChargeVO;
import com.hummingbird.capital.vo.RechargeApplyBodyVO;
import com.hummingbird.capital.vo.UnfreezeVO;
import com.hummingbird.capital.vo.WithdrawalsApplyBodyVO;
import com.hummingbird.capital.vo.WithdrawalsApplyListReturnVO;
import com.hummingbird.common.event.EventListenerContainer;
import com.hummingbird.common.exception.DataInvalidException;
import com.hummingbird.common.face.Pagingnation;
import com.hummingbird.common.util.DateUtil;
import com.hummingbird.common.util.PropertiesUtil;
import com.hummingbird.common.util.ValidateUtil;

@Service

public class OrderServiceImpl implements OrderService{
	
	@Autowired
	CapitalManageService capManageSer;
	@Autowired
	ProjectAccountOrderMapper accOrdDao;
	@Autowired
	ProjectPaymentAccountOrderMapper ppaccOrdDao;
	
	@Autowired
	ProjectAccountMapper proActDao;
	@Autowired
	ProjectPaymentAccountMapper pproActDao;
	@Autowired
	RechargeApplyMapper applyDao;
	@Autowired
	UserBankcardMapper userBankDao;
	@Autowired
	UserMapper userDao;
	@Autowired
	WithdrawApplyMapper withdrawApplyDao;
	@Autowired
	ProjectPaymentWithdrawApplyMapper ppwithdrawApplyDao;

	@Autowired
	FeeRateMapper feeRateDao;
	
	org.apache.commons.logging.Log log = org.apache.commons.logging.LogFactory
			.getLog(this.getClass());

	@Transactional(propagation=Propagation.REQUIRED,rollbackFor=Exception.class,value="txManager")
	public FreezeBondReturnVO freeze(FreezeBondBodyVO body,User user,String method) throws MaAccountException{
		
		if(body.getAmount()>=0&&body.getAmount()!=null){
			//检查用户余额是否足够
			ProjectAccount account=(ProjectAccount)AccountFactory.getAccount(Account.ACCOUNT_PROJECT,user.getMobileNum());
			AccountValidateUtil.validateAccount(account);
			if(account==null){
				if (log.isDebugEnabled()) {
					log.debug(String.format("用户【%s】资金账户信息查询失败",user.getMobileNum()));
				}
				throw new MaAccountException(MaAccountException.ERR_ACCOUNT_EXCEPTION,String.format("用户【%s】资金账户查询失败",user.getMobileNum()));
				
			}
			Long remainingSum=account.getRemainingSum()-body.getAmount();
			if(remainingSum<0){
				if (log.isDebugEnabled()) {
					log.debug(String.format("用户【%s】可用余额不足",user.getMobileNum()));
				}
				throw new MaAccountException(MaAccountException.ERR_ORDER_EXCEPTION,String.format("用户【%s】可用余额不足",user.getMobileNum()));
				
			
			}else{
				if (log.isDebugEnabled()) {
					log.debug(String.format("订单处理开始"));
				}
				if (log.isTraceEnabled()) {
					log.trace(String.format("创建冻结订单"));
				}
				//创建资金账户订单
				ProjectAccountOrder accountOrder=new ProjectAccountOrder();
				String accountOrderId=AccountGenerationUtil.genNO("PA00");
				accountOrder.setOrderId(accountOrderId);
				accountOrder.setType(body.getType());
				accountOrder.setAppOrderId(body.getAppOrderId());
				accountOrder.setRemark(body.getRemark());
				accountOrder.setStatus("OK#");
				accountOrder.setSum(body.getAmount());
				accountOrder.setMethod(method);
				accountOrder.setObjectId(body.getObjectId());
				accountOrder.setFrozenSumSnapshot(remainingSum);
				accountOrder.setInsertTime(new Date());
				accountOrder.setFlowDirection(OrderConst.FLOW_DIRECTION_OUT);
				accountOrder.setBalance(remainingSum);
				accountOrder.setAccountId(account.getAccountId());
				accOrdDao.insert(accountOrder);
				//更新账户信息
				account.setUpdateTime(new Date());
				account.setFrozenSum(account.getFrozenSum()+body.getAmount());
				account.setRemainingSum(remainingSum);
				AccountValidateUtil.updateAccountSignature(account);
				proActDao.updateByPrimaryKey(account);
				//组装返回信息
				FreezeBondReturnVO bond=new FreezeBondReturnVO();
				bond.setAccountId(account.getAccountId());
				bond.setAmount(body.getAmount().toString());
				bond.setBalance(remainingSum.toString());
				bond.setFlowDirection(OrderConst.FLOW_DIRECTION_OUT);
				bond.setOrderId(accountOrderId);
				bond.setRemark(body.getRemark());
				bond.setType(body.getType());
				return bond;
			}
			
		}else{
			if (log.isDebugEnabled()) {
				log.debug(String.format("根据objectId[%s]查询投标保证金失败",body.getObjectId()));
			}
			throw new MaAccountException(MaAccountException.ERR_ACCOUNT_EXCEPTION,String.format("根据objectId[%s]查询投标保证金失败",body.getObjectId()));
			
		}
	}
	
	
	@Transactional(propagation=Propagation.REQUIRED,rollbackFor=Exception.class,value="txManager")
	public CapitalOrderReturnVO freezeProjectPaymentAccount(FreezeBodyVO body,User user,String method) throws MaAccountException, DataInvalidException{
		
		ValidateUtil.assertNullnoappend(body, "冻结参数不能为空");
		ValidateUtil.assertNullnoappend(body.getAmount(), "冻结金额不能为空");
		if(body.getAmount()!=null&&body.getAmount()>=0){
			//检查用户余额是否足够
			ProjectPaymentAccount account=(ProjectPaymentAccount)AccountFactory.getAccount(Account.ACCOUNT_PROJECT_PAYMENT,user.getMobileNum());
			AccountValidateUtil.validateAccount(account);
			if(account==null){
				if (log.isDebugEnabled()) {
					log.debug(String.format("用户【%s】工程款账户信息查询失败",user.getMobileNum()));
				}
				throw new MaAccountException(MaAccountException.ERR_ACCOUNT_EXCEPTION,String.format("工程款账户账户查询失败"));
				
			}
			Long remainingSum=account.getRemainingSum()-body.getAmount();
			Long frozensum = account.getFrozenSum()+body.getAmount();
			if(remainingSum<0){
				if (log.isDebugEnabled()) {
					log.debug(String.format("用户【%s】工程款账户可用余额不足",user.getMobileNum()));
				}
				throw new MaAccountException(MaAccountException.ERR_ORDER_EXCEPTION,String.format("工程款账户可用余额不足"));
				
				
			}else{
				if (log.isDebugEnabled()) {
					log.debug(String.format("订单处理开始"));
				}
				if (log.isTraceEnabled()) {
					log.trace(String.format("创建冻结订单"));
				}
				//创建资金账户订单
				ProjectPaymentAccountOrder accountOrder=new ProjectPaymentAccountOrder();
				String accountOrderId=AccountGenerationUtil.genNO("PA00");
				accountOrder.setOrderId(accountOrderId);
				accountOrder.setType(body.getType());
				accountOrder.setAppOrderId(body.getAppOrderId());
				accountOrder.setRemark(body.getRemark());
				accountOrder.setStatus("OK#");
				accountOrder.setSum(body.getAmount());
				accountOrder.setMethod(method);
				accountOrder.setObjectId(body.getObjectId());
				accountOrder.setFrozenSumSnapshot(frozensum);
				accountOrder.setInsertTime(new Date());
				accountOrder.setFlowDirection(OrderConst.FLOW_DIRECTION_OUT);
				accountOrder.setBalance(remainingSum);
				accountOrder.setAccountId(account.getAccountId());
				ppaccOrdDao.insert(accountOrder);
				//更新账户信息
				account.setUpdateTime(new Date());
				account.setFrozenSum(frozensum);
				account.setRemainingSum(remainingSum);
				AccountValidateUtil.updateAccountSignature(account);
				pproActDao.updateByPrimaryKey(account);
				//组装返回信息
				CapitalOrderReturnVO ord=new CapitalOrderReturnVO();
				ord.setAccountId(account.getAccountId());
				ord.setAmount(body.getAmount().toString());
				ord.setBalance(remainingSum.toString());
				ord.setFlowDirection(OrderConst.FLOW_DIRECTION_OUT);
				ord.setOrderId(accountOrderId);
				ord.setRemark(body.getRemark());
				ord.setType(body.getType());
				return ord;
			}
			
		}else{
			if (log.isDebugEnabled()) {
				log.debug(String.format("根据objectId[%s]查询投标保证金失败",body.getObjectId()));
			}
			throw new MaAccountException(MaAccountException.ERR_ACCOUNT_EXCEPTION,String.format("要冻结的资金金额错误"));
			
		}
	}
	
	@Transactional(propagation=Propagation.REQUIRED,rollbackFor=Exception.class,value="txManager")
	public PayMatchHandingChargeVO payMatchHandingCharge(
			PayMatchHandingChargeVO body,String method)throws MaAccountException {
		
		//中标人，扣除撮合保证金
		//根据订单号查询历史冻结订单信息
		ProjectAccountOrder freezeOrder=accOrdDao.selectByPrimaryKey(body.getOrderId());
		if(freezeOrder==null){
			if (log.isDebugEnabled()) {
				log.debug(String.format("账户订单号【%s】查询不到账户冻结记录",body.getOrderId()));
			}
			throw new MaAccountException(MaAccountException.ERR_ORDER_EXCEPTION,String.format("账户订单号【%s】查询不到账户冻结记录",body.getOrderId()));		
		
		}
		
		ProjectAccount account=proActDao.selectByPrimaryKey(freezeOrder.getAccountId());
		AccountValidateUtil.validateAccount(account);
	
		Long balance=account.getRemainingSum();
		if(account.getFrozenSum()<freezeOrder.getSum()){
			if (log.isDebugEnabled()) {
				log.debug(String.format("用户提现金额大于冻结金额，提现失败"));
			}
			throw new MaAccountException(MaAccountException.ERR_ORDER_EXCEPTION,String.format("用户提现金额大于冻结金额，提现失败"));		
		
		}
		//插入资金账户订单表
		ProjectAccountOrder accountOrder=new ProjectAccountOrder();
		String accountOrderId=AccountGenerationUtil.genNO("PA00");
		accountOrder.setType("PBZ");
		accountOrder.setOrderId(accountOrderId);
		accountOrder.setAppOrderId(body.getAppOrderId());
		accountOrder.setRemark("扣除撮合保证金");
		accountOrder.setStatus("OK#");
		accountOrder.setSum(freezeOrder.getSum());
		accountOrder.setMethod(method);
		accountOrder.setObjectId(freezeOrder.getObjectId());
		accountOrder.setFrozenSumSnapshot(balance);
		accountOrder.setInsertTime(new Date());
		accountOrder.setFlowDirection(OrderConst.FLOW_DIRECTION_OUT);
		accountOrder.setBalance(balance);
		accountOrder.setAccountId(account.getAccountId());
		accOrdDao.insert(accountOrder);
		
		//更新账户信息
		account.setUpdateTime(new Date());
		account.setFrozenSum(account.getFrozenSum()-freezeOrder.getSum());
		account.setRemainingSum(balance);
		AccountValidateUtil.updateAccountSignature(account);
		proActDao.updateByPrimaryKey(account);
		//平台方收手续费
		PropertiesUtil pu = new PropertiesUtil();
		ProjectAccount platformAccount=proActDao.selectByPrimaryKey(pu.getProperty("accountId"));
		AccountValidateUtil.validateAccount(platformAccount);
	
		Long platformBalance=platformAccount.getRemainingSum()+freezeOrder.getSum();
		
		//插入资金账户订单表
		ProjectAccountOrder platformAccountOrder=new ProjectAccountOrder();
		String platformAccountOrderId=AccountGenerationUtil.genNO("PA00");
		platformAccountOrder.setType("RBZ");
		platformAccountOrder.setOrderId(platformAccountOrderId);
		platformAccountOrder.setAppOrderId(body.getAppOrderId());
		platformAccountOrder.setRemark("平台方收取撮合保证金");
		platformAccountOrder.setStatus("OK#");
		platformAccountOrder.setSum(freezeOrder.getSum());
		platformAccountOrder.setMethod(method);
		platformAccountOrder.setObjectId(freezeOrder.getObjectId());
		platformAccountOrder.setFrozenSumSnapshot(platformBalance);
		platformAccountOrder.setInsertTime(new Date());
		platformAccountOrder.setFlowDirection(OrderConst.FLOW_DIRECTION_IN);
		platformAccountOrder.setBalance(platformBalance);
		platformAccountOrder.setAccountId(platformAccount.getAccountId());
		accOrdDao.insert(platformAccountOrder);
		
		//更新账户信息
		platformAccount.setUpdateTime(new Date());
		platformAccount.setRemainingSum(platformBalance);
		AccountValidateUtil.updateAccountSignature(platformAccount);
		proActDao.updateByPrimaryKey(platformAccount);
		//流标人，解除冻结
		List<LoseVO> orderIds=new ArrayList<LoseVO>();
		for(LoseVO lose:body.getLose()){
			LoseVO vo=new LoseVO();
			UnfreezeVO unfreeze=new UnfreezeVO();
			unfreeze.setAppOrderId(lose.getAppOrderId());
			unfreeze.setOrignalOrderId(lose.getOrderId());
			unfreeze.setRemark("解除撮合保证金冻结");
			unfreeze.setType("SBZ");
			FreezeBondReturnVO bond=unfreeze(unfreeze, method);
			vo.setAppOrderId(lose.getAppOrderId());
			vo.setOrderId(bond.getOrderId());
			orderIds.add(vo);
		}
		//组装返回信息
		PayMatchHandingChargeVO payReturnInfo=new PayMatchHandingChargeVO();
		payReturnInfo.setAppOrderId(body.getAppOrderId());
		payReturnInfo.setOrderId(accountOrderId);
		payReturnInfo.setLose(orderIds);
		return payReturnInfo;
	}

	@Transactional(propagation=Propagation.REQUIRED,rollbackFor=Exception.class,value="txManager")
	public FreezeBondReturnVO unfreeze(UnfreezeVO body,
			String method) throws MaAccountException {
		//根据订单号查询历史冻结订单信息
		ProjectAccountOrder freezeOrder=accOrdDao.selectByPrimaryKey(body.getOrignalOrderId());
		if(freezeOrder==null){
			if (log.isDebugEnabled()) {
				log.debug(String.format("账户订单号【%s】查询不到账户冻结记录",body.getOrignalOrderId()));
			}
			throw new MaAccountException(MaAccountException.ERR_ORDER_EXCEPTION,String.format("账户订单号【%s】查询不到账户冻结记录",body.getOrignalOrderId()));		
		
		}
		ProjectAccount account=proActDao.selectByPrimaryKey(freezeOrder.getAccountId());
		AccountValidateUtil.validateAccount(account);
		//查询该订单是否解冻过
		ProjectAccountOrder unfreezeOrder=accOrdDao.queryUnfreezeRecord(body.getOrignalOrderId());
		if(unfreezeOrder!=null){
			if (log.isDebugEnabled()) {
				log.debug(String.format("该账户冻结订单号【%s】已解冻，无法再次解冻",body.getOrignalOrderId()));
			}
			throw new MaAccountException(MaAccountException.ERR_ORDER_EXCEPTION,String.format("该账户冻结订单号【%s】已解冻，无法再次解冻",body.getOrignalOrderId()));		
		
		}

		//创建保证金订单
		Long balance=account.getRemainingSum()+freezeOrder.getSum();
		Long frozensum = account.getFrozenSum()-freezeOrder.getSum();
		//插入资金账户订单表
		ProjectAccountOrder accountOrder=new ProjectAccountOrder();
		String accountOrderId=AccountGenerationUtil.genNO("PA00");
		accountOrder.setType(body.getType());
		accountOrder.setOrderId(accountOrderId);
		accountOrder.setAppOrderId(body.getOrignalOrderId());
		accountOrder.setOriginalOrderId(body.getOrignalOrderId());
		accountOrder.setRemark(body.getRemark());
		accountOrder.setStatus("OK#");
		accountOrder.setSum(freezeOrder.getSum());
		accountOrder.setMethod(method);
		accountOrder.setObjectId(freezeOrder.getObjectId());
		accountOrder.setFrozenSumSnapshot(frozensum);
		accountOrder.setInsertTime(new Date());
		accountOrder.setFlowDirection(OrderConst.FLOW_DIRECTION_IN);
		accountOrder.setBalance(balance);
		accountOrder.setAccountId(account.getAccountId());
		accOrdDao.insert(accountOrder);
		
		//更新账户信息
		account.setUpdateTime(new Date());
		account.setFrozenSum(frozensum);
		account.setRemainingSum(balance);
		AccountValidateUtil.updateAccountSignature(account);
		proActDao.updateByPrimaryKey(account);
		//组装返回信息
		FreezeBondReturnVO bond=new FreezeBondReturnVO();
		bond.setAccountId(account.getAccountId());
		bond.setAmount(freezeOrder.getSum().toString());
		bond.setBalance(balance.toString());
		bond.setFlowDirection(OrderConst.FLOW_DIRECTION_IN);
		bond.setOrderId(accountOrderId);
		bond.setRemark(body.getRemark());
		bond.setType(body.getType());
		return bond;
	}
	
	@Transactional(propagation=Propagation.REQUIRED,rollbackFor=Exception.class,value="txManager")
	public FreezeBondReturnVO projectPaymentUnfreeze(UnfreezeVO body,String method) throws MaAccountException {
		//根据订单号查询历史冻结订单信息
		ProjectPaymentAccountOrder freezeOrder=ppaccOrdDao.selectByPrimaryKey(body.getOrignalOrderId());
		if(freezeOrder==null){
			if (log.isDebugEnabled()) {
				log.debug(String.format("账户订单号【%s】查询不到账户冻结记录",body.getOrignalOrderId()));
			}
			throw new MaAccountException(MaAccountException.ERR_ORDER_EXCEPTION,String.format("账户订单号【%s】查询不到账户冻结记录",body.getOrignalOrderId()));		
			
		}
		ProjectPaymentAccount account=pproActDao.selectByPrimaryKey(freezeOrder.getAccountId());
		AccountValidateUtil.validateAccount(account);
		//查询该订单是否解冻过
		ProjectPaymentAccountOrder unfreezeOrder=ppaccOrdDao.queryUnfreezeRecord(body.getOrignalOrderId());
		if(unfreezeOrder!=null){
			if (log.isDebugEnabled()) {
				log.debug(String.format("该账户冻结订单号【%s】已解冻，无法再次解冻",body.getOrignalOrderId()));
			}
			throw new MaAccountException(MaAccountException.ERR_ORDER_EXCEPTION,String.format("该账户冻结订单号【%s】已解冻，无法再次解冻",body.getOrignalOrderId()));		
			
		}
		
		//创建保证金订单
		Long balance=account.getRemainingSum()+freezeOrder.getSum();
		Long frozensum = account.getFrozenSum()-freezeOrder.getSum();
		//插入资金账户订单表
		ProjectPaymentAccountOrder accountOrder=new ProjectPaymentAccountOrder();
		String accountOrderId=AccountGenerationUtil.genNO("PA00");
		accountOrder.setType(body.getType());
		accountOrder.setOrderId(accountOrderId);
		accountOrder.setAppOrderId(body.getOrignalOrderId());
		accountOrder.setOriginalOrderId(body.getOrignalOrderId());
		accountOrder.setRemark(body.getRemark());
		accountOrder.setStatus("OK#");
		accountOrder.setSum(freezeOrder.getSum());
		accountOrder.setMethod(method);
		accountOrder.setObjectId(freezeOrder.getObjectId());
		accountOrder.setFrozenSumSnapshot(frozensum);
		accountOrder.setInsertTime(new Date());
		accountOrder.setFlowDirection(OrderConst.FLOW_DIRECTION_IN);
		accountOrder.setBalance(balance);
		accountOrder.setAccountId(account.getAccountId());
		ppaccOrdDao.insert(accountOrder);
		
		//更新账户信息
		account.setUpdateTime(new Date());
		account.setFrozenSum(frozensum);
		account.setRemainingSum(balance);
		AccountValidateUtil.updateAccountSignature(account);
		pproActDao.updateByPrimaryKey(account);
		//组装返回信息
		FreezeBondReturnVO bond=new FreezeBondReturnVO();
		bond.setAccountId(account.getAccountId());
		bond.setAmount(freezeOrder.getSum().toString());
		bond.setBalance(balance.toString());
		bond.setFlowDirection(OrderConst.FLOW_DIRECTION_IN);
		bond.setOrderId(accountOrderId);
		bond.setRemark(body.getRemark());
		bond.setType(body.getType());
		return bond;
	}

	@Transactional(propagation=Propagation.REQUIRED,rollbackFor=Exception.class,value="txManager")
	public String rechargeApply(RechargeApplyBodyVO body, User user)
			throws MaAccountException {
		//创建充值申请记录
		RechargeApply apply=new RechargeApply();
		String applyOrderId=AccountGenerationUtil.genNO("RC00");
		apply.setTransportTime(body.getTransferTime());
		apply.setAmount(body.getAmount());
		apply.setBank(body.getBankName());
		apply.setInsertTime(new Date());
		apply.setStatus("CRT");
		apply.setUserId(user.getId());
		apply.setVoucher(body.getVoucherNo());
		apply.setVoucherPic(body.getVoucherFileUrl());
		apply.setOrderId(applyOrderId);
		applyDao.insert(apply);
		return applyOrderId;
	}

	@Transactional(propagation=Propagation.REQUIRED,rollbackFor=Exception.class,value="txManager")
	public List<ApplyListReturnVO> queryRechargeApplyList(User user) {
		
		List<RechargeApply> applys=applyDao.queryApplyByUserId(user.getId());
		List<ApplyListReturnVO> list=new ArrayList<ApplyListReturnVO>();
		for(RechargeApply apply:applys){
			ApplyListReturnVO returnvo=new ApplyListReturnVO();
			returnvo.setAmount(apply.getAmount().toString());
			returnvo.setCreateTime(DateUtil.formatCommonDateorNull(apply.getInsertTime()));
			returnvo.setRechargeTime(DateUtil.formatCommonDateorNull(apply.getTransportTime()));
			returnvo.setRemark("充值");
			returnvo.setStatus(apply.getStatus());
			returnvo.setVoucherNo(apply.getVoucher());
			list.add(returnvo);
		}
		return list;
	}

	@Transactional(propagation=Propagation.REQUIRED,rollbackFor=Exception.class,value="txManager")
	public String withdrawalsApply(WithdrawalsApplyBodyVO body, User user,String method)
			throws MaAccountException {

		Long feeAmount=feeRateDao.selectMoney(body.getAmount(), "TX#")==null?0:feeRateDao.selectMoney(body.getAmount(), "TX#");
		feeAmount = 0l;
		WithdrawApply apply=new WithdrawApply();
		String applyOrderId=AccountGenerationUtil.genNO("TX00");
		apply.setOrderId(applyOrderId);
		apply.setCommissionFees(feeAmount);
		apply.setInsertTime(new Date());
		apply.setStatus("CRT");
		apply.setUserBankcardId(body.getBankId());
		apply.setUserId(user.getId());
		apply.setWithdrawAmount(body.getAmount());
		withdrawApplyDao.insert(apply);
		
		//冻结
		//调用提现冻结接口
		FreezeBondBodyVO freezeBody=new FreezeBondBodyVO();
		freezeBody.setAppOrderId(applyOrderId);
		freezeBody.setRemark("用户请求提现，冻结金额"+body.getAmount().toString()+"元");
		freezeBody.setAmount(body.getAmount());
		freezeBody.setType("FRZ");
		FreezeBondReturnVO bond=freeze(freezeBody,user,method);
		
		return applyOrderId;
	}
	
	/**
	 * 工程款提现申请
	 * @param body
	 * @param user
	 * @param method
	 * @return
	 * @throws MaAccountException
	 * @throws DataInvalidException 
	 */
	@Transactional(propagation=Propagation.REQUIRED,rollbackFor=Exception.class,value="txManager")
	public String projectPaymentWithdrawalsApply(WithdrawalsApplyBodyVO body, User user,String method)
			throws MaAccountException, DataInvalidException {
		
//		Long feeAmount=feeRateDao.selectMoney(body.getAmount(), "TX#")==null?0:feeRateDao.selectMoney(body.getAmount(), "TX#");
		Long feeAmount=0l;
		ProjectPaymentWithdrawApply apply=new ProjectPaymentWithdrawApply();
		String applyOrderId=AccountGenerationUtil.genNO("TX00");
		apply.setOrderId(applyOrderId);
		apply.setCommissionFees(feeAmount);
		apply.setInsertTime(new Date());
		apply.setStatus("CRT");
		apply.setUserBankcardId(body.getBankId());
		apply.setUserId(user.getId());
		apply.setWithdrawAmount(body.getAmount());
		apply.setRealWithdrawAmount(0l);
		ppwithdrawApplyDao.insert(apply);
		
		//冻结
		//调用提现冻结接口
		FreezeBodyVO freezeBody=new FreezeBodyVO();
		freezeBody.setAppOrderId(applyOrderId);
		freezeBody.setRemark("用户请求提现，冻结金额"+body.getAmount().toString()+"元");
		freezeBody.setAmount(body.getAmount());
		freezeBody.setType("FRZ");
		CapitalOrderReturnVO retorder=freezeProjectPaymentAccount(freezeBody,user,method);
		
		projectPaymentWithdrawalsApplyEvent bide = new projectPaymentWithdrawalsApplyEvent(applyOrderId, user.getId(), body.getAmount(), "STA");
		EventListenerContainer.getInstance().fireEvent(bide);
		return applyOrderId;
	}

	public List<WithdrawalsApplyListReturnVO> queryWithdrawalsApplyList(User user) {
		List<WithdrawApply> applys=withdrawApplyDao.queryWithdrawalsApplyList(user.getId());
		List<WithdrawalsApplyListReturnVO> list=new ArrayList<WithdrawalsApplyListReturnVO>();
		for(WithdrawApply apply:applys){
			WithdrawalsApplyListReturnVO returnvo=new WithdrawalsApplyListReturnVO();
			returnvo.setAmount(apply.getWithdrawAmount().toString());
			returnvo.setCreateTime(DateUtil.formatCommonDateorNull(apply.getInsertTime()));
			returnvo.setHandingCharge(apply.getCommissionFees().toString());
			returnvo.setRemark("提现");
			returnvo.setStatus(apply.getStatus());
			returnvo.setWithdrawalsNo(apply.getVoucher());
			returnvo.setWithdrawalsTime(DateUtil.formatCommonDateorNull(apply.getTransportTime()));
			list.add(returnvo);
		}
		return list;
	}

	public WithdrawApply queryWithdrawalByOrderId(String OrderId) throws MaAccountException{
		
		WithdrawApply apply=withdrawApplyDao.selectByPrimaryKey(OrderId);
		if(apply==null){
			if (log.isDebugEnabled()) {
				log.debug(String.format("提现申请订单号【%s】查询不到提现申请记录",OrderId));
			}
			throw new MaAccountException(MaAccountException.ERR_ORDER_EXCEPTION,String.format("提现申请订单号【%s】查询不到提现申请记录",OrderId));		
		
		}
		return apply;
	}

	@Transactional(propagation=Propagation.REQUIRED,rollbackFor=Exception.class,value="txManager")
	public void checkWithdrawalApply(CheckWithdrawalBodyVO body,String method) throws MaAccountException{
		// 提现申请审核 
		WithdrawApply apply=withdrawApplyDao.selectByPrimaryKey(body.getOrderId());
		if(apply==null){
			if (log.isDebugEnabled()) {
				log.debug(String.format("提现申请订单号【%s】查询不到提现申请记录",body.getOrderId()));
			}
			throw new MaAccountException(MaAccountException.ERR_ORDER_EXCEPTION,String.format("提现申请订单号【%s】查询不到提现申请记录",body.getOrderId()));		
		
		}
		//根据订单号查询历史冻结订单信息
		ProjectAccountOrder freezeOrder=accOrdDao.selectByAppOrderId(body.getOrderId());
		if(freezeOrder==null){
			if (log.isDebugEnabled()) {
				log.debug(String.format("账户AppOrderId【%s】查询不到账户冻结记录",body.getOrderId()));
			}
			throw new MaAccountException(MaAccountException.ERR_ORDER_EXCEPTION,String.format("账户订单号【%s】查询不到账户冻结记录",body.getOrderId()));		
		
		}
		
		if(StringUtils.equals(body.getCheckResult(), "OK#")){
			//调用提现成功接口
			UnfreezeVO withdraw=new UnfreezeVO();
			withdraw.setAppOrderId(body.getOrderId());
			withdraw.setRemark(body.getRemark());
			withdraw.setSum(body.getAmount()==null?apply.getWithdrawAmount():body.getAmount());
			withdraw.setType("TX#");
			User user=userDao.selectByPrimaryKey(apply.getUserId());
			withdrawals(withdraw, user, method);
		}else if(StringUtils.equals(body.getCheckResult(), "FLS")){
			UnfreezeVO unfreezeBody=new UnfreezeVO();
			unfreezeBody.setAppOrderId(body.getOrderId());
			unfreezeBody.setOrignalOrderId(freezeOrder.getOrderId());
			unfreezeBody.setRemark(body.getRemark());
			unfreezeBody.setSum(apply.getWithdrawAmount());
			unfreezeBody.setType("UFZ");
			
			unfreeze(unfreezeBody, method);
		}else{
			if (log.isDebugEnabled()) {
				log.debug(String.format("提现申请审核结果【%s】无法识别",body.getCheckResult()));
			}
			throw new MaAccountException(MaAccountException.ERR_ORDER_EXCEPTION,String.format("提现申请审核结果【%s】无法识别",body.getCheckResult()));		
		
		}
		apply.setStatus(body.getCheckResult());
		apply.setTransportTime(body.getTransferTime());
		apply.setUpdateTime(new Date());
		apply.setUpdator(body.getOperator().toString());
		apply.setVoucher(body.getVoucherNo());
		apply.setVoucherPic(body.getVoucherFileUrl());
		if(StringUtils.equals(body.getCheckResult(), "OK#")){
			apply.setRealWithdrawAmount(body.getAmount()==null?apply.getWithdrawAmount():body.getAmount());
			DrawalsEvent de = new DrawalsEvent(apply.getUserId(), MoneyUtil.getMoneyStringDecimal4yuan(apply.getRealWithdrawAmount()), "OK#");
			EventListenerContainer.getInstance().fireEvent(de);
		}else{
			apply.setRealWithdrawAmount(0l);
			DrawalsEvent de = new DrawalsEvent(apply.getUserId(), MoneyUtil.getMoneyStringDecimal4yuan(apply.getWithdrawAmount()), "FLS");
			EventListenerContainer.getInstance().fireEvent(de);
			
		}
		withdrawApplyDao.updateByPrimaryKey(apply);
	}
	
	/**
	 * 工程款提现审核
	 * @see com.hummingbird.capital.services.OrderService#checkProjectPaymentWithdrawalApply(com.hummingbird.capital.vo.CheckWithdrawalBodyVO, java.lang.String)
	 */
	@Transactional(propagation=Propagation.REQUIRED,rollbackFor=Exception.class,value="txManager")
	public void checkProjectPaymentWithdrawalApply(CheckWithdrawalBodyVO body,String method) throws MaAccountException{
		// 提现申请审核
		ProjectPaymentWithdrawApply apply=ppwithdrawApplyDao.selectByPrimaryKey(body.getOrderId());
		if(apply==null){
			if (log.isDebugEnabled()) {
				log.debug(String.format("提现申请订单号【%s】查询不到提现申请记录",body.getOrderId()));
			}
			throw new MaAccountException(MaAccountException.ERR_ORDER_EXCEPTION,String.format("提现申请订单号【%s】查询不到提现申请记录",body.getOrderId()));		
			
		}
		//根据订单号查询历史冻结订单信息
		ProjectPaymentAccountOrder freezeOrder=ppaccOrdDao.selectByAppOrderId(body.getOrderId());
		if(freezeOrder==null){
			if (log.isDebugEnabled()) {
				log.debug(String.format("账户AppOrderId【%s】查询不到账户冻结记录",body.getOrderId()));
			}
			throw new MaAccountException(MaAccountException.ERR_ORDER_EXCEPTION,String.format("账户订单号【%s】查询不到账户冻结记录",body.getOrderId()));		
			
		}
		
		if(StringUtils.equals(body.getCheckResult(), "OK#")){
			//调用提现成功接口
			UnfreezeVO withdraw=new UnfreezeVO();
			withdraw.setAppOrderId(body.getOrderId());
			withdraw.setRemark(body.getRemark());
			withdraw.setSum(body.getAmount()==null?apply.getWithdrawAmount():body.getAmount());
			withdraw.setType("TX#");
			User user=userDao.selectByPrimaryKey(apply.getUserId());
			projectPaymentWithdrawals(withdraw, user, method);
		}else if(StringUtils.equals(body.getCheckResult(), "FLS")){
			UnfreezeVO unfreezeBody=new UnfreezeVO();
			unfreezeBody.setAppOrderId(body.getOrderId());
			unfreezeBody.setOrignalOrderId(freezeOrder.getOrderId());
			unfreezeBody.setRemark(body.getRemark());
			unfreezeBody.setSum(apply.getWithdrawAmount());
			unfreezeBody.setType("UFZ");
			
			projectPaymentUnfreeze(unfreezeBody, method);
		}else{
			if (log.isDebugEnabled()) {
				log.debug(String.format("提现申请审核结果【%s】无法识别",body.getCheckResult()));
			}
			throw new MaAccountException(MaAccountException.ERR_ORDER_EXCEPTION,String.format("提现申请审核结果【%s】无法识别",body.getCheckResult()));		
			
		}
		apply.setStatus(body.getCheckResult());
		apply.setTransportTime(body.getTransferTime());
		apply.setUpdateTime(new Date());
		apply.setUpdator(body.getOperator().toString());
		apply.setVoucher(body.getVoucherNo());
		apply.setVoucherPic(body.getVoucherFileUrl());
		if(StringUtils.equals(body.getCheckResult(), "OK#")){
			
			apply.setRealWithdrawAmount(body.getAmount()==null?apply.getWithdrawAmount():body.getAmount());
			projectPaymentWithdrawalsApplyEvent bide = new projectPaymentWithdrawalsApplyEvent(apply.getOrderId(), apply.getUserId(), apply.getRealWithdrawAmount(), "OK#");
			EventListenerContainer.getInstance().fireEvent(bide);
		}
		else{
			apply.setRealWithdrawAmount(0l);
			projectPaymentWithdrawalsApplyEvent bide = new projectPaymentWithdrawalsApplyEvent(apply.getOrderId(), apply.getUserId(), apply.getWithdrawAmount(), "FLS");
			EventListenerContainer.getInstance().fireEvent(bide);
		}
		ppwithdrawApplyDao.updateByPrimaryKey(apply);
	}

	@Transactional(propagation=Propagation.REQUIRED,rollbackFor=Exception.class,value="txManager")
	public String withdrawals(UnfreezeVO body, User user, String method)
			throws MaAccountException {
		
		//提现 
		ProjectAccount account=(ProjectAccount)AccountFactory.getAccount(Account.ACCOUNT_PROJECT,user.getMobileNum());
		AccountValidateUtil.validateAccount(account);
		Long balance=account.getRemainingSum();
		Long frozensum = account.getFrozenSum()-body.getSum();
		if(account.getFrozenSum()<body.getSum()){
			if (log.isDebugEnabled()) {
				log.debug(String.format("用户【%s】提现金额大于冻结金额，提现失败",user.getMobileNum(),user.getMobileNum()));
			}
			throw new MaAccountException(MaAccountException.ERR_ORDER_EXCEPTION,String.format("用户【%s】提现金额大于冻结金额，提现失败",user.getMobileNum()));		
		
		}
		//插入资金账户订单表
		ProjectAccountOrder accountOrder=new ProjectAccountOrder();
		String accountOrderId=AccountGenerationUtil.genNO("PA00");
		accountOrder.setType(body.getType());
		accountOrder.setOrderId(accountOrderId);
		accountOrder.setAppOrderId(body.getAppOrderId());
		accountOrder.setRemark(body.getRemark());
		accountOrder.setStatus("OK#");
		accountOrder.setSum(body.getSum());
		accountOrder.setMethod(method);
		accountOrder.setObjectId(body.getObjectId());
		accountOrder.setFrozenSumSnapshot(frozensum);
		accountOrder.setInsertTime(new Date());
		accountOrder.setFlowDirection(OrderConst.FLOW_DIRECTION_OUT);
		accountOrder.setBalance(balance);
		accountOrder.setAccountId(account.getAccountId());
		accOrdDao.insert(accountOrder);
		
		//更新账户信息
		account.setUpdateTime(new Date());
		account.setFrozenSum(frozensum);
		account.setRemainingSum(balance);
		AccountValidateUtil.updateAccountSignature(account);
		proActDao.updateByPrimaryKey(account);
		
		return accountOrderId;
	}
	
	@Transactional(propagation=Propagation.REQUIRED,rollbackFor=Exception.class,value="txManager")
	public String projectPaymentWithdrawals(UnfreezeVO body, User user, String method)
			throws MaAccountException {
		
		//提现 
		ProjectPaymentAccount account=(ProjectPaymentAccount)AccountFactory.getAccount(Account.ACCOUNT_PROJECT_PAYMENT,user.getMobileNum());
		AccountValidateUtil.validateAccount(account);
		Long balance=account.getRemainingSum();
		Long frozensum = account.getFrozenSum()-body.getSum();
		if(account.getFrozenSum()<body.getSum()){
			if (log.isDebugEnabled()) {
				log.debug(String.format("用户【%s】提现金额大于冻结金额，提现失败",user.getMobileNum(),user.getMobileNum()));
			}
			throw new MaAccountException(MaAccountException.ERR_ORDER_EXCEPTION,String.format("用户【%s】提现金额大于冻结金额，提现失败",user.getMobileNum()));		
			
		}
		//插入资金账户订单表
		ProjectPaymentAccountOrder accountOrder=new ProjectPaymentAccountOrder();
		String accountOrderId=AccountGenerationUtil.genNO("PA00");
		accountOrder.setType(body.getType());
		accountOrder.setOrderId(accountOrderId);
		accountOrder.setAppOrderId(body.getAppOrderId());
		accountOrder.setRemark(body.getRemark());
		accountOrder.setStatus("OK#");
		accountOrder.setSum(body.getSum());
		accountOrder.setMethod(method);
		accountOrder.setObjectId(body.getObjectId());
		accountOrder.setFrozenSumSnapshot(frozensum);
		accountOrder.setInsertTime(new Date());
		accountOrder.setFlowDirection(OrderConst.FLOW_DIRECTION_OUT);
		accountOrder.setBalance(balance);
		accountOrder.setAccountId(account.getAccountId());
		ppaccOrdDao.insert(accountOrder);
		
		//更新账户信息
		account.setUpdateTime(new Date());
		account.setFrozenSum(frozensum);
		account.setRemainingSum(balance);
		AccountValidateUtil.updateAccountSignature(account);
		pproActDao.updateByPrimaryKey(account);
		
		return accountOrderId;
	}

	@Transactional(propagation=Propagation.REQUIRED,rollbackFor=Exception.class,value="txManager")
	public void checkRechargeApply(CheckRechargeApplyBodyVO body,String method)
			throws MaAccountException {
		
		// 充值申请审核
		RechargeApply apply=applyDao.selectByPrimaryKey(body.getOrderId());
		if(apply==null){
			if (log.isDebugEnabled()) {
				log.debug(String.format("根据充值申请订单号【%s】查询不到充值申请记录",body.getOrderId()));
			}
			throw new MaAccountException(MaAccountException.ERR_ORDER_EXCEPTION,String.format("根据充值申请订单号【%s】查询不到充值申请记录",body.getOrderId()));		
		
		}
		
		if(StringUtils.equals(body.getCheckResult(), "OK#")){
			//调用充值成功接口
			UnfreezeVO unfreezeBody=new UnfreezeVO();
			unfreezeBody.setAppOrderId(body.getOrderId());
			unfreezeBody.setRemark(body.getRemark());
			unfreezeBody.setSum(apply.getAmount());
			unfreezeBody.setType("CZ#");
			User user=userDao.selectByPrimaryKey(apply.getUserId());
			recharge(unfreezeBody, user, method);
			RechargeEvent re =new RechargeEvent(apply.getUserId(), MoneyUtil.getMoneyStringDecimal4yuan(apply.getAmount()), "OK#");
			EventListenerContainer.getInstance().fireEvent(re);
		}else if(StringUtils.equals(body.getCheckResult(), "FLS")){
			RechargeEvent re =new RechargeEvent(apply.getUserId(), MoneyUtil.getMoneyStringDecimal4yuan(apply.getAmount()), "FLS");
			EventListenerContainer.getInstance().fireEvent(re);
		}
		else{
			if (log.isDebugEnabled()) {
				log.debug(String.format("充值申请审核结果【%s】无法识别",body.getCheckResult()));
			}
			throw new MaAccountException(MaAccountException.ERR_ORDER_EXCEPTION,String.format("提现申请审核结果【%s】无法识别",body.getCheckResult()));		
		
		}
		apply.setStatus(body.getCheckResult());
		apply.setUpdateTime(new Date());
		apply.setUpdator(body.getOperator().toString());
		applyDao.updateByPrimaryKey(apply);
	}

	@Override
	public String recharge(UnfreezeVO body, User user, String method)
			throws MaAccountException {
		
		//充值
		ProjectAccount account=(ProjectAccount)AccountFactory.getAccount(Account.ACCOUNT_PROJECT,user.getMobileNum());
		AccountValidateUtil.validateAccount(account);
		//创建保证金订单
		Long balance=account.getRemainingSum()+body.getSum();
		
		//插入资金账户订单表
		ProjectAccountOrder accountOrder=new ProjectAccountOrder();
		String accountOrderId=AccountGenerationUtil.genNO("PA00");
		accountOrder.setType(body.getType());
		accountOrder.setOrderId(accountOrderId);
		accountOrder.setAppOrderId(body.getAppOrderId());
		accountOrder.setRemark(body.getRemark());
		accountOrder.setStatus("OK#");
		accountOrder.setSum(body.getSum());
		accountOrder.setMethod(method);
		accountOrder.setObjectId(body.getObjectId());
		accountOrder.setFrozenSumSnapshot(balance);
		accountOrder.setInsertTime(new Date());
		accountOrder.setFlowDirection(OrderConst.FLOW_DIRECTION_IN);
		accountOrder.setBalance(balance);
		accountOrder.setAccountId(account.getAccountId());
		accOrdDao.insert(accountOrder);
				
		//更新账户信息
		account.setUpdateTime(new Date());
		account.setRemainingSum(balance);
		AccountValidateUtil.updateAccountSignature(account);
		proActDao.updateByPrimaryKey(account);
				
		return accountOrderId;
	}

	@Override
	public RechargeApply queryRechargeByOrderId(String OrderId)
			throws MaAccountException {
		
		return applyDao.selectByPrimaryKey(OrderId);
	}

	@Override
	public Long queryWithdrawalsFee(Long amount) {
		// TODO Auto-generated method stub
		return feeRateDao.selectMoney(amount, "TX#")==null?0:feeRateDao.selectMoney(amount, "TX#");
	}

	/**
	 * 查询工程款提现记录
	 * @param userId
	 * @param pagingnation
	 * @return
	 */
	public List<ProjectPaymentWithdrawApply> queryProjectPaymentWithdrawalsApplyList(Integer userId,
			Pagingnation pagingnation){
		if(pagingnation!=null&&pagingnation.isCountsize())
		{
			int count=ppwithdrawApplyDao.selectCount(userId);
			pagingnation.setTotalCount(count);
			pagingnation.calculatePageCount();
		}
		List<ProjectPaymentWithdrawApply> list = ppwithdrawApplyDao.selectWithdrawRecords(userId, pagingnation);
		return list;
	}

	
}
