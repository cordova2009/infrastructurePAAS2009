/**
 * 
 * DefaultAccountService.java
 * 版本所有 深圳市蜂鸟娱乐有限公司 2013-2014
 */
package com.hummingbird.capital.services.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.hummingbird.capital.entity.User;
import com.hummingbird.capital.exception.MaAccountException;
import com.hummingbird.capital.face.Account;
import com.hummingbird.capital.mapper.AccountOrderDao;
import com.hummingbird.capital.mapper.DefaultAccountDao;
import com.hummingbird.capital.mapper.UserMapper;
import com.hummingbird.capital.services.AccountService;

/**
 * @author huangjiej_2
 * 2014年12月27日 下午9:39:29
 * 本类主要做为
 */
public class DefaultAccountService implements AccountService {

	org.apache.commons.logging.Log log = org.apache.commons.logging.LogFactory
			.getLog(this.getClass());
	
	@Autowired
	UserMapper userDao; 
	
	
	/**
	 * 帐户dao
	 * @return
	 */
	public DefaultAccountDao getAccountDao(){
		return null;
	}
	
	/**
	 * 订单dao
	 * @return
	 */
	public AccountOrderDao getAccountOrderDao(){
		return null;
	}

	/* (non-Javadoc)
	 * @see com.hummingbird.maaccount.service.AccountService#getAccount(java.lang.String)
	 */
	@Override
	public Account getAccount(String mobileNum) {
		Account acc = getAccountDao().getAccountByMobile(mobileNum);
		return acc;
	}
	
	/**
	 * 更新帐户
	 * @param account
	 */
	@Override
	public boolean updateAccount(Account account){
		int updatesuccess = getAccountDao().updateAccount(account);
		return 1==updatesuccess;
	}

	/**
	 * 创建帐户
	 * @see com.hummingbird.maaccount.service.AccountService#createAccount(java.lang.Integer)
	 */
	@Override
	public Account createAccount(Integer userId)  throws MaAccountException {
		if (log.isDebugEnabled()) {
			log.debug(String.format("创建帐户（虚拟帐户）默认方法，不处理"));
		}
		return null;
	}
	
	/**
	 * 根据帐户id查询帐户
	 * @param accountId
	 * @return
	 * @throws MaAccountException 
	 */
	public Account getAccountByAccountId(String accountId) throws MaAccountException{
		return getAccountDao().getAccountByAccountId(accountId);
	}
	
	/**
	 * 创建帐户
	 * @param mobile 手机号
	 */
	public Account createAccountByMobileNum(String mobileNum)  throws MaAccountException{
		User user = userDao.queryUserByMobile(mobileNum)==null?null:userDao.queryUserByMobile(mobileNum).get(0);
		if(user==null){
			if (log.isDebugEnabled()) {
				log.debug(String.format("用户%s不存在",mobileNum));
			}
			throw new MaAccountException(MaAccountException.ERR_USER_EXCEPTION,String.format("用户%s不存在",mobileNum));
		}
		return createAccount(user.getId());
	}

}
