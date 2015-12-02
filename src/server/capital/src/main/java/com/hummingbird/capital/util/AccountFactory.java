/**
 * 
 * AccountFactory.java
 * 版本所有 深圳市蜂鸟娱乐有限公司 2013-2014
 */
package com.hummingbird.capital.util;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.math.NumberUtils;

import com.hummingbird.common.exception.ValidateException;
import com.hummingbird.common.util.SpringBeanUtil;
import com.hummingbird.common.util.ValidateUtil;
import com.hummingbird.capital.constant.AccountConst;
import com.hummingbird.capital.entity.User;
import com.hummingbird.capital.exception.MaAccountException;
import com.hummingbird.capital.face.Account;
import com.hummingbird.capital.mapper.UserMapper;
import com.hummingbird.capital.services.AccountService;

/**
 * @author huangjiej_2
 * 2014年12月27日 下午11:13:00
 * 本类主要做为帐户的工具类来使用
 */
public class AccountFactory {
	
	
	static org.apache.commons.logging.Log log = org.apache.commons.logging.LogFactory
			.getLog(AccountFactory.class);
	
	public static Map<String,String> accountFlagMap = new HashMap<String,String>(); 
	static{
		accountFlagMap.put(Account.ACCOUNT_PROJECT, AccountConst.ACCOUNT_TYPE_PROJECT);
		accountFlagMap.put(Account.ACCOUNT_BANK, AccountConst.ACCOUNT_TYPE_OTHER);
		accountFlagMap.put(Account.ACCOUNT_APP, AccountConst.ACCOUNT_TYPE_OTHER);
		
	}
	
	/**
	 * 获取订单标识
	 * @param accountType
	 * @return
	 */
	public static String getAccountFlag4Order(String accountType){
		return accountFlagMap.get(accountType);
	}
	

	/**
	 * 获取帐户
	 * @param accountType
	 * @param mobileNum
	 * @return
	 * @throws MaAccountException 
	 */
	public static Account getAccount(String accountType, String mobile) throws MaAccountException {
		
		AccountService accountService = AccountServiceFactory.getAccountService(accountType);
		Account acc = accountService.getAccount(mobile);
		if(acc==null)
		{
			//创建帐户
			if (log.isDebugEnabled()) {
				log.debug(String.format("相关帐户不存在，尝试创建帐户"));
			}
			acc=accountService.createAccountByMobileNum(mobile);
		}
		return acc;
	}
	

	/**
	 * 创建帐户
	 * @param userId
	 * @throws MaAccountException 
	 */
	public static void createAccounts(Integer userId) throws MaAccountException {
		//创建现金帐户
//		try {
			AccountService cashaccService = AccountServiceFactory.getAccountService(Account.ACCOUNT_PROJECT);
			cashaccService.createAccount(userId);
//		} catch (MaAccountException e) {
//			log.error(String.format(""),e);
//		}
			
	}


	/**
	 * @param accountInvestment
	 * @param accountId
	 * @return
	 * @throws MaAccountException 
	 */
	public static Account getAccountByAccountId(
			String accountCode, String accountId) throws MaAccountException {
		AccountService accountService = AccountServiceFactory.getAccountService(accountCode);
		Account acc = accountService.getAccountByAccountId(accountId);
		
		return acc;
	}
	
	

}
