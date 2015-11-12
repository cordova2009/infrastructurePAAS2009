package com.hummingbird.paas.services.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.hummingbird.paas.entity.Bidder;
import com.hummingbird.paas.entity.ObjectBondRecord;
import com.hummingbird.paas.entity.ProjectAccount;
import com.hummingbird.paas.entity.ProjectAccountOrder;
import com.hummingbird.paas.entity.RechargeApply;
import com.hummingbird.paas.entity.User;
import com.hummingbird.paas.entity.UserBankcard;
import com.hummingbird.paas.entity.WithdrawApply;
import com.hummingbird.paas.exception.MaAccountException;
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
	@Autowired
	ProjectAccountMapper proActDao;
	@Autowired
	RechargeApplyMapper applyDao;
	@Autowired
	UserBankcardMapper userBankDao;
	@Autowired
	WithdrawApplyMapper withdrawApplyDao;
	
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
		Integer objectBond=bondSettingDao.getObjectBidderBond(body.getObjectId());		
		if(objectBond!=null){
			//检查用户余额是否足够
			ProjectAccount account=capManageSer.queryAccountInfo(user.getId());
			AccountValidateUtil.validateAccount(account);
			if(account==null){
				if (log.isDebugEnabled()) {
					log.debug(String.format("用户【%s】资金账户信息查询失败",user.getMobileNum()));
				}
				throw new MaAccountException(MaAccountException.ERR_ACCOUNT_EXCEPTION,String.format("用户【%s】资金账户查询失败",user.getMobileNum()));
				
			}
			Integer remainingSum=account.getRemainingSum()-objectBond;
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
				ObjectBondRecord bondRecord=new ObjectBondRecord();
				String bondorderId=AccountGenerationUtil.genNO("BZ00");
				bondRecord.setOrderId(bondorderId);
				//这里的数据库字段类型不对
				bondRecord.setCompanyId(bidder.getId());
				bondRecord.setInsertTime(new Date());
				bondRecord.setObjectId(body.getObjectId());
				bondRecord.setCompanyType("BIR");
				bondRecord.setType("FOZ");
				bondRecord.setBondType("BID");
				bondRecord.setBondAmount(objectBond);
				bondRecordDao.insert(bondRecord);
				//创建资金账户订单
				ProjectAccountOrder accountOrder=new ProjectAccountOrder();
				String accountOrderId=AccountGenerationUtil.genNO("PA00");
				accountOrder.setOrderId(accountOrderId);
				accountOrder.setType("SBZ");
				accountOrder.setOriginalOrderId(bondorderId);
				accountOrder.setOriginalTable("t_ztgl_object_bond_record");
				accountOrder.setRemark(body.getRemark());
				accountOrder.setStatus("OK#");
				accountOrder.setSum(objectBond);
				accountOrder.setMethod(method);
				//数据库字段有问题
				//accountOrder.setObjectId(body.getObjectId());
				accountOrder.setFrozenSumSnapshot(objectBond);
				accountOrder.setInsertTime(new Date());
				accountOrder.setFlowDirection("OUT");
				accountOrder.setBalance(remainingSum);
				accountOrder.setAccountId(account.getAccountId());
				//这个字段不明白
				//accountOrder.setFrozenSumSnapshot(objectBond);
				accOrdDao.insert(accountOrder);
				//更新账户信息
				account.setUpdateTime(new Date());
				account.setFrozenSum(account.getFrozenSum()+objectBond);
				account.setRemainingSum(remainingSum);
				AccountValidateUtil.updateAccountSignature(account);
				proActDao.updateByPrimaryKey(account);
				//组装返回信息
				FreezeBondReturnVO bond=new FreezeBondReturnVO();
				bond.setAccountId(account.getAccountId());
				bond.setAmount(objectBond.toString());
				bond.setBalance(remainingSum.toString());
				bond.setFlowDirection("OUT");
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
		ProjectAccountOrder oldActOrd=accOrdDao.selectByPrimaryKey(body.getOrderId());
		if(oldActOrd==null){
			if (log.isDebugEnabled()) {
				log.debug(String.format("根据订单号【%s】查询不到原来的订单信息",body.getOrderId()));
			}
			throw new MaAccountException(MaAccountException.ERR_ORDER_EXCEPTION,String.format("根据订单号【%s】查询不到原来的订单信息",body.getOrderId()));
			
		}
		//查询是否退还过保证金，避免重复退还
		//因为数据库待定，这段逻辑待定
		
		
		Integer balance=account.getRemainingSum()+oldActOrd.getSum();
		Integer objectBond=oldActOrd.getSum();
		//创建保证金订单
		ObjectBondRecord bondRecord=new ObjectBondRecord();
		String bondorderId=AccountGenerationUtil.genNO("BZ00");
		bondRecord.setOrderId(bondorderId);
		//这里的数据库字段类型不对
		bondRecord.setCompanyId(bidder.getId());
		bondRecord.setInsertTime(new Date());
		//这里的数据库字段类型不对
		bondRecord.setObjectId(oldActOrd.getObjectId());
		bondRecord.setCompanyType("BIR");
		//REV要像john确定是否为退回保证金的意思
		bondRecord.setType("REV");
		bondRecord.setBondType("BID");
		bondRecord.setBondAmount(objectBond);
		bondRecordDao.insert(bondRecord);
		//插入资金账户订单表
		ProjectAccountOrder accountOrder=new ProjectAccountOrder();
		String accountOrderId=AccountGenerationUtil.genNO("PA00");
		//这里数据库的类型好像没有退还保证金
		accountOrder.setType("SBZ");
		accountOrder.setOrderId(accountOrderId);
		accountOrder.setOriginalOrderId(bondorderId);
		accountOrder.setOriginalTable("t_ztgl_object_bond_record");
		accountOrder.setRemark("解冻保证金");
		accountOrder.setStatus("OK#");
		accountOrder.setSum(objectBond);
		accountOrder.setMethod(method);
		//数据库字段有问题
		//accountOrder.setObjectId(body.getObjectId());
		accountOrder.setFrozenSumSnapshot(objectBond);
		accountOrder.setInsertTime(new Date());
		accountOrder.setFlowDirection("IN#");
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
		bond.setAmount(objectBond.toString());
		bond.setBalance(balance.toString());
		bond.setFlowDirection("IN#");
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
			returnvo.setRechargeTime(转账时间);
			returnvo.setRemark("提现");
			returnvo.setStatus(apply.getStatus());
			returnvo.setVoucherNo(apply.getVoucher());
			list.add(returnvo);
		}
		return list;
	}

	@Override
	public String withdrawalsApply(WithdrawalsApplyBodyVO body, User user)
			throws MaAccountException {
		//查询用户银行账户信息
		//UserBankcard bankcard=userBankDao.selectByPrimaryKey(body.getBankId());
		WithdrawApply apply=new WithdrawApply();
		String applyOrderId=AccountGenerationUtil.genNO("TX00");
		apply.setOrderId(applyOrderId);
//		apply.setCommissionFees(手续费);
		apply.setInsertTime(new Date());
		apply.setStatus("CRT");
		apply.setUserBankcardId(body.getBankId());
		apply.setUserId(user.getId());
		apply.setWithdrawAmount(body.getAmount());
		withdrawApplyDao.insert(apply);
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
			returnvo.setWithdrawalsNo(转账凭证号);
			returnvo.setWithdrawalsTime(转账时间缺少);
			list.add(returnvo);
		}
		return null;
	}

	
}
