package com.hummingbird.paas.services;

import java.util.List;

import com.hummingbird.common.exception.DataInvalidException;
import com.hummingbird.common.face.Pagingnation;
import com.hummingbird.common.vo.ValidateResult;
import com.hummingbird.paas.entity.ProjectAccount;
import com.hummingbird.paas.entity.ProjectAccountOrder;
import com.hummingbird.paas.entity.User;
import com.hummingbird.paas.entity.UserBankcard;

public interface CapitalManageService {

	
	
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
	public ValidateResult validatePaymentCode(String tradePassword,User user) throws DataInvalidException;

}
