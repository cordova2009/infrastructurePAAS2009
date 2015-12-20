/**
 * 
 * AccountServiceFactory.java
 * 版本所有 深圳市蜂鸟娱乐有限公司 2013-2014
 */
package com.hummingbird.capital.util;

import com.hummingbird.common.util.SpringBeanUtil;
import com.hummingbird.capital.exception.MaAccountException;
import com.hummingbird.capital.face.Account;
import com.hummingbird.capital.services.AccountService;
import com.hummingbird.capital.services.ProjectAccountService;
import com.hummingbird.capital.services.ProjectPaymentAccountService;

/**
 * @author huangjiej_2
 * 2014年12月27日 下午9:31:42
 * 本类主要做为帐户服务类工厂
 */
public class AccountServiceFactory {

	static org.apache.commons.logging.Log log = org.apache.commons.logging.LogFactory
			.getLog(AccountServiceFactory.class);
	
	
	/**
	 * 根据代号获取对应的帐户service
	 * @param accountcode
	 * @return
	 * @throws MaAccountException
	 */
	public static AccountService getAccountService(String accountcode) throws MaAccountException {
		AccountService as=null;
		switch (accountcode) {
		case Account.ACCOUNT_PROJECT:
			as= SpringBeanUtil.getInstance().getBean(ProjectAccountService.class );
			break;
		case Account.ACCOUNT_PROJECT_PAYMENT:
			as= SpringBeanUtil.getInstance().getBean(ProjectPaymentAccountService.class );
			break;
		
		default:
			
			log.error("创建AccountServicer失败，不支持的帐户类型:"+accountcode);
			throw new MaAccountException(MaAccountException.ERR_ACCOUNT_EXCEPTION,"创建Service失败，不支持的帐户类型");
		}
		
		
		return as;
	}
	
	
	/**
	 * 获取相关的帐户Service
	 * @param fromaccount
	 * @return
	 * @throws MaAccountException 
	 */
	public static AccountService getAccountService(Account fromaccount) throws MaAccountException {
		if(fromaccount==null){
			log.error("帐户为空，无法创建AccountService");
			throw new MaAccountException(MaAccountException.ERR_ACCOUNT_EXCEPTION,"创建Service失败，帐户为空");
		}
		AccountService accountService = getAccountService(fromaccount.getAccountCode());
		
		return accountService;
	}

	
	
	
}
