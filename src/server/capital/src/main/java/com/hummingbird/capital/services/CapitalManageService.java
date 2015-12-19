package com.hummingbird.capital.services;

import java.util.List;

import com.hummingbird.common.exception.DataInvalidException;
import com.hummingbird.common.face.Pagingnation;
import com.hummingbird.common.vo.ValidateResult;
import com.hummingbird.capital.entity.ProjectAccount;
import com.hummingbird.capital.entity.ProjectAccountOrder;
import com.hummingbird.capital.entity.User;
import com.hummingbird.capital.entity.UserBankcard;
import com.hummingbird.capital.exception.MaAccountException;
import com.hummingbird.capital.face.Account;


public interface CapitalManageService {

	/**
	 * 根据用户Id查询银行卡列表
	 * @param userId
	 * @return
	 */
	public List<UserBankcard> queryBankListByUserId(Integer userId);
	
	/**
	 * 根据用户Id查询资金账户信息
	 * @param userId
	 * @return
	 */
	public ProjectAccount queryAccountInfo(Integer userId);
	
	/**
	 * 查询用户资金账户流水
	 * @param accountId
	 * @param page
	 * @return
	 */
	public List<ProjectAccountOrder> queryAccountRecordsByAccountId(String accountId,Pagingnation page);
	
	/**
	 * 查询用户资金账户总收入
	 * @param accountId
	 * @return
	 */
	public Integer getAccountIncome(String accountId);
	
	/**
	 * 查询用户资金账户总支出
	 * @param accountId
	 * @return
	 */
	public Integer getAccountOutlay(String accountId);
	
	/**
	 * 验证支付码
	 * @param paymentCode
	 * @return
	 * @throws DataInvalidException 
	 */
	public ValidateResult validatePaymentCode(String tradePassword,User user,String appkey) throws DataInvalidException;

	/**
	 * 创建现金帐户
	 * @throws MaAccountException 
	 * @see com.hummingbird.maaccount.service.impl.DefaultAccountService#createAccount(java.lang.Integer)
	 */
	public Account createAccount(Integer userId) throws MaAccountException;

	/**
	 * 工程款收入
	 * @param platformuserId
	 * @param amount
	 * @param appOrderId
	 * @throws MaAccountException 
	 */
	public void incomeProjectPayment(Integer userId, Long amount, String appOrderId,String remark) throws MaAccountException;

	/**
	 * 创建工程款帐户
	 * @param userId
	 * @return
	 * @throws MaAccountException
	 */
	Account createProjectPaymentAccount(Integer userId) throws MaAccountException;
	
}
