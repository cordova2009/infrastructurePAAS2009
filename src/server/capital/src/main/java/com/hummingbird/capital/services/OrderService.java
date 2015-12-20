package com.hummingbird.capital.services;

import java.util.List;

import com.hummingbird.capital.entity.ProjectPaymentWithdrawApply;
import com.hummingbird.capital.entity.RechargeApply;
import com.hummingbird.capital.entity.User;
import com.hummingbird.capital.entity.WithdrawApply;
import com.hummingbird.capital.exception.MaAccountException;
import com.hummingbird.capital.vo.ApplyListReturnVO;
import com.hummingbird.capital.vo.CheckRechargeApplyBodyVO;
import com.hummingbird.capital.vo.CheckWithdrawalBodyVO;
import com.hummingbird.capital.vo.FreezeBondBodyVO;
import com.hummingbird.capital.vo.FreezeBondReturnVO;
import com.hummingbird.capital.vo.PayMatchHandingChargeVO;
import com.hummingbird.capital.vo.RechargeApplyBodyVO;
import com.hummingbird.capital.vo.UnfreezeBondVO;
import com.hummingbird.capital.vo.UnfreezeVO;
import com.hummingbird.capital.vo.WithdrawalsApplyBodyVO;
import com.hummingbird.capital.vo.WithdrawalsApplyListReturnVO;
import com.hummingbird.common.exception.DataInvalidException;
import com.hummingbird.common.face.Pagingnation;
import com.hummingbird.common.util.PropertiesUtil;
import com.hummingbird.common.vo.ResultModel;
import com.hummingbird.commonbiz.vo.AppVO;

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
	public FreezeBondReturnVO unfreeze(UnfreezeVO body,String method)throws MaAccountException;
	/**
	 * 扣除撮合保证金
	 * @param body
	 * @return
	 */
	public PayMatchHandingChargeVO payMatchHandingCharge(PayMatchHandingChargeVO body,String method)throws MaAccountException;
	
	/**
	 * 提现
	 * @param body
	 * @param userId
	 * @param method
	 * @return
	 * @throws MaAccountException
	 */
	public String withdrawals(UnfreezeVO body,User user,String method)throws MaAccountException;
	
	/**
	 * 充值
	 * @param body
	 * @param userId
	 * @param method
	 * @return
	 * @throws MaAccountException
	 */
	public String recharge(UnfreezeVO body,User user,String method)throws MaAccountException;
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
	 * 查询提现手续费
	 * @param body
	 * @return
	 */
	public Long queryWithdrawalsFee(Long amount);
	/**
	 * 提现申请审核
	 * @param body
	 */
	public void checkWithdrawalApply(CheckWithdrawalBodyVO body,String method)throws MaAccountException;
	/**
	 * 工程款提现申请审核
	 * @param body
	 */
	public void checkProjectPaymentWithdrawalApply(CheckWithdrawalBodyVO body,String method)throws MaAccountException;
	/**
	 * 提现充值审核
	 * @param body
	 */
	public void checkRechargeApply(CheckRechargeApplyBodyVO body,String method)throws MaAccountException;
	
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
	/**
	 * 工程款提现申请
	 * @param body
	 * @param user
	 * @param method
	 * @return
	 * @throws MaAccountException
	 * @throws DataInvalidException 
	 */
	String projectPaymentWithdrawalsApply(WithdrawalsApplyBodyVO body, User user, String method)
			throws MaAccountException, DataInvalidException;
	/**
	 * 查询工程款提现记录
	 * @param userId
	 * @param pagingnation
	 * @return
	 */
	public List<ProjectPaymentWithdrawApply> queryProjectPaymentWithdrawalsApplyList(Integer userId,
			Pagingnation pagingnation);

	
}
