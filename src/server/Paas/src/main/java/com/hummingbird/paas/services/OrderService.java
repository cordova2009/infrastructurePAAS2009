package com.hummingbird.paas.services;

import java.util.List;

import com.hummingbird.paas.entity.User;
import com.hummingbird.paas.exception.MaAccountException;
import com.hummingbird.paas.vo.ApplyListReturnVO;
import com.hummingbird.paas.vo.FreezeBondBodyVO;
import com.hummingbird.paas.vo.FreezeBondReturnVO;
import com.hummingbird.paas.vo.RechargeApplyBodyVO;
import com.hummingbird.paas.vo.UnfreezeBondVO;
import com.hummingbird.paas.vo.WithdrawalsApplyBodyVO;
import com.hummingbird.paas.vo.WithdrawalsApplyListReturnVO;

public interface OrderService {
	/**
	 * 冻结
	 * @param body
	 * @return
	 */
	public FreezeBondReturnVO freezeBond(FreezeBondBodyVO body,User user,String method)throws MaAccountException;
	/**
	 * 解冻
	 * @param body
	 * @return
	 */
	public FreezeBondReturnVO unfreezeBond(UnfreezeBondVO body,User user,String method)throws MaAccountException;

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


}
