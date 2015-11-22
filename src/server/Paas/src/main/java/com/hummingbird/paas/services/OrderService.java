package com.hummingbird.paas.services;

import java.util.List;

import com.hummingbird.paas.entity.RechargeApply;
import com.hummingbird.paas.entity.User;
import com.hummingbird.paas.entity.WithdrawApply;
import com.hummingbird.paas.exception.MaAccountException;
import com.hummingbird.paas.vo.ApplyListReturnVO;
import com.hummingbird.paas.vo.CheckRechargeApplyBodyVO;
import com.hummingbird.paas.vo.CheckWithdrawalBodyVO;
import com.hummingbird.paas.vo.FreezeBondBodyVO;
import com.hummingbird.paas.vo.FreezeBondReturnVO;
import com.hummingbird.paas.vo.RechargeApplyBodyVO;
import com.hummingbird.paas.vo.UnfreezeBondVO;
import com.hummingbird.paas.vo.UnfreezeVO;
import com.hummingbird.paas.vo.WithdrawalsApplyBodyVO;
import com.hummingbird.paas.vo.WithdrawalsApplyListReturnVO;

public interface OrderService {
	/**
	 * 冻结
	 * @param body
	 * @return
	 */
	public FreezeBondReturnVO freeze(FreezeBondBodyVO body,User user,String method)throws MaAccountException;
	/**
	 * 解冻
	 * @param body
	 * @return
	 */
	public FreezeBondReturnVO unfreeze(UnfreezeVO body,Integer userId,String method)throws MaAccountException;

	/**
	 * 提现
	 * @param body
	 * @param userId
	 * @param method
	 * @return
	 * @throws MaAccountException
	 */
	public String withdrawals(UnfreezeVO body,Integer userId,String method)throws MaAccountException;
	
	/**
	 * 充值
	 * @param body
	 * @param userId
	 * @param method
	 * @return
	 * @throws MaAccountException
	 */
	public String recharge(UnfreezeVO body,Integer userId,String method)throws MaAccountException;
	/**
	 * 充值申请
	 * @param body
	 * @return
	 */
	public String rechargeApply(RechargeApplyBodyVO body,User user)throws MaAccountException;

	/**
	 * 查询充值申请记录
	 * @param body
	 * @return
	 */
	public List<ApplyListReturnVO> queryRechargeApplyList(User user);
	/**
	 * 提现申请审核
	 * @param body
	 */
	public void CheckWithdrawalApply(CheckWithdrawalBodyVO body)throws MaAccountException;
	/**
	 * 提现充值审核
	 * @param body
	 */
	public void CheckRechargeApply(CheckRechargeApplyBodyVO body)throws MaAccountException;
	
	/**
	 * 提现申请
	 * @param body
	 * @return
	 */
	public String withdrawalsApply(WithdrawalsApplyBodyVO body,User user,String method)throws MaAccountException;

	/**
	 * 查询提现申请记录
	 * @param body
	 * @return
	 */
	public List<WithdrawalsApplyListReturnVO> queryWithdrawalsApplyList(User user);

	/**
	 * 根据提现订单Id查询用户
	 * @param OrderId
	 * @return
	 */
	public WithdrawApply queryWithdrawalByOrderId(String OrderId)throws MaAccountException;

	public RechargeApply queryRechargeByOrderId(String OrderId)throws MaAccountException;

	
}
