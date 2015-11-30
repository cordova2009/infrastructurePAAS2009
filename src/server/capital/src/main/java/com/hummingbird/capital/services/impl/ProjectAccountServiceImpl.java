/**
 * 
 * InvestmentAccountService.java
 * 版本所有 深圳市蜂鸟娱乐有限公司 2013-2014
 */
package com.hummingbird.capital.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hummingbird.capital.entity.ProjectAccount;
import com.hummingbird.capital.exception.MaAccountException;
import com.hummingbird.capital.face.Account;
import com.hummingbird.capital.mapper.AccountOrderDao;
import com.hummingbird.capital.mapper.DefaultAccountDao;
import com.hummingbird.capital.mapper.ProjectAccountMapper;
import com.hummingbird.capital.mapper.ProjectAccountOrderMapper;
import com.hummingbird.capital.services.ProjectAccountService;
import com.hummingbird.capital.util.AccountValidateUtil;

/**
 * @author huangjiej_2
 * 2014年12月27日 下午9:52:32
 * 本类主要做为 现金帐户service
 */
@Service
public class ProjectAccountServiceImpl extends DefaultAccountService implements ProjectAccountService {

	
	@Autowired
	AccountIdServiceImpl accountIdSrv;
	
	@Autowired
	ProjectAccountMapper caDao;
	
	/**
	 * 现金订单
	 */
	@Autowired
	ProjectAccountOrderMapper caorderDao;
	
	
	/* (non-Javadoc)
	 * @see com.hummingbird.maaccount.service.impl.DefaultAccountService#getAccountDao()
	 */
	@Override
	public DefaultAccountDao getAccountDao() {
		return caDao;
	}

	/* (non-Javadoc)
	 * @see com.hummingbird.maaccount.service.impl.DefaultAccountService#getAccountOrderDao()
	 */
	@Override
	public AccountOrderDao getAccountOrderDao() {
		return caorderDao;
	}
	
	/**
	 * 创建现金帐户
	 * @throws MaAccountException 
	 * @see com.hummingbird.maaccount.service.impl.DefaultAccountService#createAccount(java.lang.Integer)
	 */
	public Account createAccount(Integer userId) throws MaAccountException{
		Account acc = getAccountDao().getAccountByUserId(userId);
		String accountId=null;
		if(acc==null){
			if (log.isDebugEnabled()) {
				log.debug(String.format("为用户%s创建现金帐户",userId));
			}
			ProjectAccount ca = new ProjectAccount();
			ca.setUserId(userId);
			accountId = accountIdSrv.prepareGetAccountId("9500");
			//accountId = accountIdSrv.prepareGetAccountIdByaccountType(AccountConst.ACCOUNT_TYPE_CASH);
			ca.setAccountId(accountId);
//			ca.setAccountId(NoGenerationUtil.genNO("cash_"+userId+"_",6));
			ca.setRemainingSum(0L);
			ca.setStatus("OK#");
			AccountValidateUtil.updateAccountSignature(ca);
			try {
				getAccountDao().createAccount(ca);
			} catch (Exception e) {
				if (log.isDebugEnabled()) {
					log.debug(String.format("创建现金帐户出错"),e);
				}
				//还原帐户
//				accountIdSrv.returnAccountId(accountId);
				throw new MaAccountException(MaAccountException.ERR_ACCOUNT_EXCEPTION,"帐户创建失败");
			}
			acc = ca;
		}else{
			if (log.isDebugEnabled()) {
				log.debug(String.format("用户%s现金帐户已创建",userId));
			}
		}
		
		return acc;
	}

	
	public void open(ProjectAccount cashAccount) throws MaAccountException{
		
		
		int updateAccountsuccess =caDao.updateAccount(cashAccount);
		if(updateAccountsuccess==1){
			if (log.isDebugEnabled()) {
				log.debug(String.format("现金账户开通成功"));
			}
		}
		else{
			throw new MaAccountException(MaAccountException.ERR_ACCOUNT_EXCEPTION,"现金账户开通失败");
		}
	}

}
