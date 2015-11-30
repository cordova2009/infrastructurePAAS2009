/**
 * 
 * Account.java
 * 版本所有 深圳市蜂鸟娱乐有限公司 2013-2014
 */
package com.hummingbird.capital.services;


import com.hummingbird.capital.exception.MaAccountException;
import com.hummingbird.capital.face.Account;
/**
 * @author huangjiej_2
 * 2014年12月18日 下午10:28:57
 * 本类主要做为帐户接口
 */
public interface AccountService {
	
	/**
	 * 获取帐户
	 * @param mobileNum
	 * @return
	 */
	Account getAccount(String mobileNum);
	
	
	/**
	 * 创建帐户
	 * @param userId
	 */
	Account createAccount(Integer userId)  throws MaAccountException;
	
	/**
	 * 创建帐户
	 * @param mobile 手机号
	 */
	Account createAccountByMobileNum(String mobileNum)  throws MaAccountException;
	
	

	/**
	 * 更新帐户
	 * @param account
	 */
	public abstract boolean updateAccount(Account account);

	/**
	 * 根据帐户id查询帐户
	 * @param accountId
	 * @return
	 * @throws MaAccountException 
	 */
	Account getAccountByAccountId(String accountId) throws MaAccountException;

	
	
}
