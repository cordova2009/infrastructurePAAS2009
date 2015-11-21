
package com.hummingbird.paas.services.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;








import com.hummingbird.paas.constant.AccountConst;
import com.hummingbird.paas.constant.OrderConst;
import com.hummingbird.paas.entity.BidRecord;
import com.hummingbird.paas.entity.Bidder;
import com.hummingbird.paas.entity.FeeRate;
import com.hummingbird.paas.entity.FeeRate;
import com.hummingbird.paas.entity.MakeMatchBondRecord;
import com.hummingbird.paas.entity.ObjectBondRecord;
import com.hummingbird.paas.entity.ProjectAccount;
import com.hummingbird.paas.entity.ProjectAccountOrder;
import com.hummingbird.paas.entity.RechargeApply;
import com.hummingbird.paas.entity.User;
import com.hummingbird.paas.entity.UserBankcard;
import com.hummingbird.paas.entity.WithdrawApply;
import com.hummingbird.paas.exception.MaAccountException;
import com.hummingbird.paas.mapper.BidRecordMapper;
import com.hummingbird.paas.mapper.FeeRateMapper;
import com.hummingbird.paas.mapper.MakeMatchBondRecordMapper;
import com.hummingbird.paas.mapper.ObjectBondRecordMapper;
import com.hummingbird.paas.mapper.ObjectBondSettingMapper;
import com.hummingbird.paas.mapper.ProjectAccountMapper;
import com.hummingbird.paas.mapper.ProjectAccountOrderMapper;
import com.hummingbird.paas.mapper.RechargeApplyMapper;
import com.hummingbird.paas.mapper.UserBankcardMapper;
import com.hummingbird.paas.mapper.WithdrawApplyMapper;
import com.hummingbird.paas.services.CapitalManageService;
import com.hummingbird.paas.services.OrderService;
import com.hummingbird.paas.services.UserService;
import com.hummingbird.paas.util.AccountGenerationUtil;
import com.hummingbird.paas.util.AccountValidateUtil;
import com.hummingbird.paas.vo.ApplyListReturnVO;
import com.hummingbird.paas.vo.CheckWithdrawalBodyVO;
import com.hummingbird.paas.vo.FreezeBondBodyVO;
import com.hummingbird.paas.vo.FreezeBondReturnVO;
import com.hummingbird.paas.vo.RechargeApplyBodyVO;
import com.hummingbird.paas.vo.UnfreezeBondVO;
import com.hummingbird.paas.vo.UnfreezeVO;
import com.hummingbird.paas.vo.WithdrawalsApplyBodyVO;
import com.hummingbird.paas.vo.WithdrawalsApplyListReturnVO;

@Service

public class OrderServiceImpl implements OrderService{
	@Autowired
	ObjectBondSettingMapper bondSettingDao;
	@Autowired
	CapitalManageService capManageSer;
	@Autowired
	UserService userSer;
	@Autowired
	ProjectAccountOrderMapper accOrdDao;
	@Autowired
	ObjectBondRecordMapper bondRecordDao;
	MakeMatchBondRecordMapper makeMatchBondRecordDao;
	@Autowired
	ProjectAccountMapper proActDao;
	@Autowired
	RechargeApplyMapper applyDao;
	@Autowired
	UserBankcardMapper userBankDao;
	@Autowired
	WithdrawApplyMapper withdrawApplyDao;

	@Autowired
	FeeRateMapper feeRateDao;
	
	@Autowired
	BidRecordMapper bidRecordDao;
	
	org.apache.commons.logging.Log log = org.apache.commons.logging.LogFactory
			.getLog(this.getClass());

	@Transactional(propagation=Propagation.REQUIRED,rollbackFor=Exception.class,value="txManager")
	public FreezeBondReturnVO freeze(FreezeBondBodyVO body,User user,String method) throws MaAccountException{
		
		if(body.getSum()>=0&&body.getSum()!=null){
			//检查用户余额是否足够
			ProjectAccount account=capManageSer.queryAccountInfo(user.getId());
			AccountValidateUtil.validateAccount(account);
			if(account==null){
				if (log.isDebugEnabled()) {
					log.debug(String.format("用户【%s】资金账户信息查询失败",user.getMobileNum()));
				}
				throw new MaAccountException(MaAccountException.ERR_ACCOUNT_EXCEPTION,String.format("用户【%s】资金账户查询失败",user.getMobileNum()));
				
			}
			Integer remainingSum=account.getRemainingSum()-body.getSum();
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
				accountOrder.setOriginalOrderId(body.getOriginalOrderId());
				accountOrder.setOriginalTable(body.getOriginalTable());
				accountOrder.setRemark(body.getRemark());
				accountOrder.setStatus("OK#");
				accountOrder.setSum(body.getSum());
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
				account.setFrozenSum(account.getFrozenSum()+body.getSum());
				account.setRemainingSum(remainingSum);
				AccountValidateUtil.updateAccountSignature(account);
				proActDao.updateByPrimaryKey(account);
				//组装返回信息
				FreezeBondReturnVO bond=new FreezeBondReturnVO();
				bond.setAccountId(account.getAccountId());
				bond.setAmount(body.getSum());
				bond.setBalance(remainingSum);
				bond.setFlowDirection(OrderConst.FLOW_DIRECTION_OUT);
				bond.setOrderId(accountOrderId);
				bond.setRemark(body.getRemark());
				bond.setType("FOZ");
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
	public FreezeBondReturnVO unfreeze(UnfreezeVO body, Integer userId,
			String method) throws MaAccountException {
		ProjectAccount account=capManageSer.queryAccountInfo(userId);
		AccountValidateUtil.validateAccount(account);
		
		//创建保证金订单
		Integer balance=account.getRemainingSum()+body.getSum();
		
		//插入资金账户订单表
		ProjectAccountOrder accountOrder=new ProjectAccountOrder();
		String accountOrderId=AccountGenerationUtil.genNO("PA00");
		accountOrder.setType(body.getType());
		accountOrder.setOrderId(accountOrderId);
		accountOrder.setOriginalOrderId(body.getOrignalOrderId());
		accountOrder.setOriginalTable(body.getOrignalTable());
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
		account.setFrozenSum(account.getFrozenSum()-body.getSum());
		account.setRemainingSum(balance);
		AccountValidateUtil.updateAccountSignature(account);
		proActDao.updateByPrimaryKey(account);
		//组装返回信息
		FreezeBondReturnVO bond=new FreezeBondReturnVO();
		bond.setAccountId(account.getAccountId());
		bond.setAmount(body.getSum());
		bond.setBalance(balance);
		bond.setFlowDirection(OrderConst.FLOW_DIRECTION_IN);
		bond.setOrderId(accountOrderId);
		bond.setRemark(body.getRemark());
		
		bond.setType(body.getType());
		return bond;
	}

	@Transactional(propagation=Propagation.REQUIRED,rollbackFor=Exception.class,value="txManager")
	public String rechargeApply(RechargeApplyBodyVO body, User user)
			throws MaAccountException {
		// TODO Auto-generated method stub
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

	@Override
	public List<ApplyListReturnVO> queryRechargeApplyList(User user) {
		// TODO Auto-generated method stub
		List<RechargeApply> applys=applyDao.queryApplyByUserId(user.getId());
		List<ApplyListReturnVO> list=new ArrayList<ApplyListReturnVO>();
		for(RechargeApply apply:applys){
			ApplyListReturnVO returnvo=new ApplyListReturnVO();
			returnvo.setAmount(apply.getAmount().toString());
			returnvo.setCreateTime(new Date());
			returnvo.setRechargeTime(apply.getTransportTime());
			returnvo.setRemark("提现");
			returnvo.setStatus(apply.getStatus());
			returnvo.setVoucherNo(apply.getVoucher());
			list.add(returnvo);
		}
		return list;
	}

	@Transactional(propagation=Propagation.REQUIRED,rollbackFor=Exception.class,value="txManager")
	public String withdrawalsApply(WithdrawalsApplyBodyVO body, User user,String method)
			throws MaAccountException {

		Integer feeAmount=feeRateDao.selectMoney(body.getAmount(), "TX#");
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
		return applyOrderId;
	}

	@Override
	public List<WithdrawalsApplyListReturnVO> queryWithdrawalsApplyList(User user) {
		List<WithdrawApply> applys=withdrawApplyDao.queryWithdrawalsApplyList(user.getId());
		List<WithdrawalsApplyListReturnVO> list=new ArrayList<WithdrawalsApplyListReturnVO>();
		for(WithdrawApply apply:applys){
			WithdrawalsApplyListReturnVO returnvo=new WithdrawalsApplyListReturnVO();
			returnvo.setAmount(apply.getWithdrawAmount().toString());
			returnvo.setCreateTime(apply.getInsertTime());
			returnvo.setHandingCharge(apply.getCommissionFees().toString());
			returnvo.setRemark("提现");
			returnvo.setStatus(apply.getStatus());

			returnvo.setWithdrawalsNo(apply.getVoucher());
			returnvo.setWithdrawalsTime(apply.getTransportTime());
			list.add(returnvo);
		}
		return list;
	}

	@Override
	public WithdrawApply queryWithdrawalByOrderId(String OrderId) throws MaAccountException{
		// TODO Auto-generated method stub
		User user=new User();
		WithdrawApply apply=withdrawApplyDao.selectByPrimaryKey(OrderId);
		if(apply==null){
			if (log.isDebugEnabled()) {
				log.debug(String.format("提现申请订单号【%s】查询不到提现申请记录",OrderId));
			}
			throw new MaAccountException(MaAccountException.ERR_ORDER_EXCEPTION,String.format("提现申请订单号【%s】查询不到提现申请记录",OrderId));		
		
		}
		return apply;
	}

	@Override
	public void CheckWithdrawalApply(CheckWithdrawalBodyVO body) throws MaAccountException{
		// 提现申请审核
		WithdrawApply apply=withdrawApplyDao.selectByPrimaryKey(body.getOrderId());
		if(apply==null){
			if (log.isDebugEnabled()) {
				log.debug(String.format("提现申请订单号【%s】查询不到提现申请记录",body.getOrderId()));
			}
			throw new MaAccountException(MaAccountException.ERR_ORDER_EXCEPTION,String.format("提现申请订单号【%s】查询不到提现申请记录",body.getOrderId()));		
		
		}
		
		if(StringUtils.equals(body.getCheckResult(), "OK#")){
			//调用提现成功接口
		}else if(StringUtils.equals(body.getCheckResult(), "FLS")){
			//调用提现失败接口
		}else{
			if (log.isDebugEnabled()) {
				log.debug(String.format("提现申请审核结果【%s】无法识别",body.getCheckResult()));
			}
			throw new MaAccountException(MaAccountException.ERR_ORDER_EXCEPTION,String.format("提现申请审核结果【%s】无法识别",body.getCheckResult()));		
		
		}
		apply.setStatus(body.getCheckResult());
		apply.setTransportTime(body.getTransferTime());
		apply.setUpdateTime(new Date());
		apply.setUpdator(body.getOperator());
		apply.setVoucher(body.getVoucherNo());
		apply.setVoucherPic(body.getVoucherFileUrl());
		withdrawApplyDao.updateByPrimaryKey(apply);
	}

	@Override
	public String withdrawals(UnfreezeVO body, Integer userId, String method)
			throws MaAccountException {
		// TODO Auto-generated method stub
		//提现 扣除冻结金额
		ProjectAccount account=capManageSer.queryAccountInfo(userId);
		AccountValidateUtil.validateAccount(account);
		//创建保证金订单
		Integer balance=account.getRemainingSum();
		if(account.getFrozenSum()<body.getSum()){
			if (log.isDebugEnabled()) {
				log.debug(String.format("用户【%s】提现金额大于冻结金额，提现失败",userId));
			}
			throw new MaAccountException(MaAccountException.ERR_ORDER_EXCEPTION,String.format("用户【%s】提现金额大于冻结金额，提现失败",userId));		
		
		}
		//插入资金账户订单表
		ProjectAccountOrder accountOrder=new ProjectAccountOrder();
		String accountOrderId=AccountGenerationUtil.genNO("PA00");
		accountOrder.setType(body.getType());
		accountOrder.setOrderId(accountOrderId);
		accountOrder.setOriginalOrderId(body.getOrignalOrderId());
		accountOrder.setOriginalTable(body.getOrignalTable());
		accountOrder.setRemark(body.getRemark());
		accountOrder.setStatus("OK#");
		accountOrder.setSum(body.getSum());
		accountOrder.setMethod(method);
		accountOrder.setObjectId(body.getObjectId());
		accountOrder.setFrozenSumSnapshot(balance);
		accountOrder.setInsertTime(new Date());
		accountOrder.setFlowDirection(OrderConst.FLOW_DIRECTION_OUT);
		accountOrder.setBalance(balance);
		accountOrder.setAccountId(account.getAccountId());
		accOrdDao.insert(accountOrder);
		
		//更新账户信息
		account.setUpdateTime(new Date());
		account.setFrozenSum(account.getFrozenSum()-body.getSum());
		account.setRemainingSum(balance);
		AccountValidateUtil.updateAccountSignature(account);
		proActDao.updateByPrimaryKey(account);
		
		return accountOrderId;
	}

	
}
