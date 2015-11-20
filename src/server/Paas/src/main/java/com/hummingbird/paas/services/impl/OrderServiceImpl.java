
package com.hummingbird.paas.services.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
import com.hummingbird.paas.vo.FreezeBondBodyVO;
import com.hummingbird.paas.vo.FreezeBondReturnVO;
import com.hummingbird.paas.vo.RechargeApplyBodyVO;
import com.hummingbird.paas.vo.UnfreezeBondVO;
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
	public FreezeBondReturnVO freezeBond(FreezeBondBodyVO body,User user,String method) throws MaAccountException{
		Bidder bidder=userSer.queryBidderByUserId(user.getId());
		if(bidder==null){
			if (log.isDebugEnabled()) {
				log.debug(String.format("用户【%s】未认证投标人或被禁用",user.getMobileNum()));
			}
			throw new MaAccountException(MaAccountException.ERR_ACCOUNT_EXCEPTION,String.format("用户【%s】未认证投标人或被禁用",user.getMobileNum()));
			
		}
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
				//数据库字段有问题
				accountOrder.setObjectId(body.getObjectId());
				accountOrder.setFrozenSumSnapshot(body.getSum());
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
	public FreezeBondReturnVO unfreezeBond(UnfreezeBondVO body, User user,
			String method) throws MaAccountException {
		ProjectAccount account=capManageSer.queryAccountInfo(user.getId());
		AccountValidateUtil.validateAccount(account);
		Bidder bidder=userSer.queryBidderByUserId(user.getId());
		if(bidder==null){
			if (log.isDebugEnabled()) {
				log.debug(String.format("用户【%s】未认证投标人或被禁用",user.getMobileNum()));
			}
			throw new MaAccountException(MaAccountException.ERR_ACCOUNT_EXCEPTION,String.format("用户【%s】未认证投标人或被禁用",user.getMobileNum()));
			
		}
		//根据orderId查询原来的订单信息
		//ProjectAccountOrder oldActOrd=accOrdDao.selectByPrimaryKey(body.getOrderId());
		MakeMatchBondRecord oldActOrd=makeMatchBondRecordDao.selectByPrimaryKey(body.getOrderId());
		if(oldActOrd==null){
			if (log.isDebugEnabled()) {
				log.debug(String.format("根据订单号【%s】查询不到原来的订单信息",body.getOrderId()));
			}
			throw new MaAccountException(MaAccountException.ERR_ORDER_EXCEPTION,String.format("根据订单号【%s】查询不到原来的订单信息",body.getOrderId()));
			
		}
		List<MakeMatchBondRecord> returnActOrds=makeMatchBondRecordDao.selectReturnByBidId(oldActOrd.getBidId());
		if(returnActOrds.size()>0){
			if (log.isDebugEnabled()) {
				log.debug(String.format("投标订单号【%s】已经退还过撮合保证金，无法再次退还",oldActOrd.getBidId()));
			}
			throw new MaAccountException(MaAccountException.ERR_ORDER_EXCEPTION,String.format("投标订单号【%s】已经退还过撮合保证金，无法再次退还",oldActOrd.getBidId()));		
		}
		
		//创建保证金订单
		Integer balance=account.getRemainingSum()+oldActOrd.getBondAmount();
		Integer objectBond=oldActOrd.getBondAmount();
		//创建解冻撮合担保金订单
		MakeMatchBondRecord bondRecord=new MakeMatchBondRecord();
		String bondorderId=AccountGenerationUtil.genNO("BZ00");
		bondRecord.setOrderId(bondorderId);
		bondRecord.setUpdateTime(new Date());
		bondRecord.setBidId(oldActOrd.getBidId());
		bondRecord.setCreator(user.getId().toString());
		bondRecord.setInsertTime(new Date());
		bondRecord.setObjectId(oldActOrd.getObjectId());
		bondRecord.setBondAmount(objectBond);
		bondRecord.setStatus("REV");
		makeMatchBondRecordDao.insert(bondRecord);
		
		//插入资金账户订单表
		ProjectAccountOrder accountOrder=new ProjectAccountOrder();
		String accountOrderId=AccountGenerationUtil.genNO("PA00");
		accountOrder.setType("SBZ");
		accountOrder.setOrderId(accountOrderId);
		accountOrder.setOriginalOrderId(bondorderId);
		accountOrder.setOriginalTable("t_ztgl_object_makematch_bond_record");
		accountOrder.setRemark("解冻保证金");
		accountOrder.setStatus("OK#");
		accountOrder.setSum(objectBond);
		accountOrder.setMethod(method);
		accountOrder.setObjectId(oldActOrd.getObjectId());
		accountOrder.setFrozenSumSnapshot(objectBond);
		accountOrder.setInsertTime(new Date());
		accountOrder.setFlowDirection("IN#");
		accountOrder.setFlowDirection(OrderConst.FLOW_DIRECTION_IN);
		accountOrder.setBalance(balance);
		accountOrder.setAccountId(account.getAccountId());
		accOrdDao.insert(accountOrder);
		
		//更新账户信息
		account.setUpdateTime(new Date());
		account.setFrozenSum(account.getFrozenSum()-objectBond);
		account.setRemainingSum(balance);
		AccountValidateUtil.updateAccountSignature(account);
		proActDao.updateByPrimaryKey(account);
		//组装返回信息
		FreezeBondReturnVO bond=new FreezeBondReturnVO();
		bond.setAccountId(account.getAccountId());
		bond.setAmount(objectBond);
		bond.setBalance(balance);
		bond.setFlowDirection("IN#");
		bond.setFlowDirection(OrderConst.FLOW_DIRECTION_IN);
		bond.setOrderId(accountOrderId);
		bond.setRemark("退还保证金");
		
		bond.setType("REV");
		return bond;
	}

	@Transactional(propagation=Propagation.REQUIRED,rollbackFor=Exception.class,value="txManager")
	public String rechargeApply(RechargeApplyBodyVO body, User user)
			throws MaAccountException {
		// TODO Auto-generated method stub
		//创建充值申请记录
		RechargeApply apply=new RechargeApply();
		String applyOrderId=AccountGenerationUtil.genNO("RC00");
		//数据库少了转账时间字段
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

		//查询提现手续费
		/*List<FeeRate> feeRate=feeRateDao.selectFeeRate("TX#");
		if(body.getAmount()*feeRate.getFeeRate()<feeRate.get){
			
		}*/
		Integer feeAmount=feeRateDao.selectMoney(body.getAmount(), "TX#");
		
		FreezeBondBodyVO freezeBody=new FreezeBondBodyVO();
		
		WithdrawApply apply=new WithdrawApply();
		String applyOrderId=AccountGenerationUtil.genNO("TX00");
		apply.setOrderId(applyOrderId);
//		apply.setCommissionFees(手续费);
		apply.setCommissionFees(feeAmount);
		apply.setInsertTime(new Date());
		apply.setStatus("CRT");
		apply.setUserBankcardId(body.getBankId());
		apply.setUserId(user.getId());
		apply.setWithdrawAmount(body.getAmount());
		withdrawApplyDao.insert(apply);
		freezeBody.setOriginalOrderId(applyOrderId);
		freezeBody.setOriginalTable("t_ddgl_withdraw_apply");
		freezeBody.setRemark("提现申请");
		freezeBody.setSum(body.getAmount());
		//冻结
		freezeBond(freezeBody,user,method);
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

	
}
