package com.hummingbird.paas.services.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.hummingbird.commonbiz.vo.UserToken;
import com.hummingbird.paas.entity.Bidder;
import com.hummingbird.paas.entity.ProjectAccount;
import com.hummingbird.paas.entity.Token;
import com.hummingbird.paas.entity.User;
import com.hummingbird.paas.entity.UserAuth;
import com.hummingbird.paas.entity.UserPassword;
import com.hummingbird.paas.exception.MaAccountException;
import com.hummingbird.paas.mapper.BidderMapper;
import com.hummingbird.paas.mapper.ProjectAccountMapper;
import com.hummingbird.paas.mapper.UserAuthMapper;
import com.hummingbird.paas.mapper.UserMapper;
import com.hummingbird.paas.mapper.UserPasswordMapper;
import com.hummingbird.paas.services.TokenService;
import com.hummingbird.paas.services.UserService;
import com.hummingbird.paas.util.AccountGenerationUtil;
import com.hummingbird.paas.util.AccountValidateUtil;
import com.hummingbird.paas.vo.RegisterBodyVO;
@Service
@Service
public class UserServiceImpl implements UserService{

	org.apache.commons.logging.Log log = org.apache.commons.logging.LogFactory
			.getLog(this.getClass());
	
	@Autowired
	UserMapper userDao;
	@Autowired
	UserPasswordMapper passwordDao;
	@Autowired
	UserAuthMapper userAuthDao;
	@Autowired
	ProjectAccountMapper proActDao;
	@Autowired(required = true)
	private TokenService tokensrv;
	@Autowired
	BidderMapper bidderDao;
	
	@Override
	public User queryUserByMobile(String mobileNum) throws MaAccountException{
		List<User> users=userDao.queryUserByMobile(mobileNum);
		if(users.size()>1){
			if (log.isDebugEnabled()) {
				log.debug(String.format("根据手机号[%s]查询到多个用户",mobileNum));
			}
			throw new MaAccountException(MaAccountException.ERR_ACCOUNT_EXCEPTION,"根据手机号查询到多个用户");
		
		}
		return users.get(0);
	}

	@Override
	public User queryUserByToken(String token) throws MaAccountException{
		Token userToken = tokensrv.getToken(token);
		if(userToken!=null){
			User user = userDao.selectByPrimaryKey(userToken.getUserId());
			if(user==null)
			{
				if (log.isDebugEnabled()) {
					log.debug(String.format("根据用户id[%s]查找不到用户",userToken.getUserId()));
				}
				throw new MaAccountException(MaAccountException.ERR_ACCOUNT_EXCEPTION,String.format("根据用户id[%s]查找不到用户",userToken.getUserId()));
				
			}
			else{
				return user;			
			}
		}
		else{
			if (log.isDebugEnabled()) {
				log.debug(String.format("token[%s]无效",token));
			}
			throw new MaAccountException(MaAccountException.ERR_ACCOUNT_EXCEPTION,String.format("token[%s]无效或已过期",token));
			
		}
	}

	@Transactional(propagation=Propagation.REQUIRED,rollbackFor=Exception.class,value="txManager")
	public void saveUser(RegisterBodyVO body,String appId) {
		//保存用户信息
		User user = new User();
		user.setInsertTime(new Date());
		user.setNickName(body.getNickname());
		user.setMobileNum(body.getMobileNum());
		int userId = userDao.insert(user);
		//保存密码信息
		UserPassword password=new UserPassword();
		password.setPassword(body.getLoginPassword());
		password.setTradePassword(body.getTradePassword());
		password.setUserId(userId);
		passwordDao.insert(password);
		//保存实名认证信息
		UserAuth auth=new UserAuth();
		auth.setIdentityNo(body.getCardID());
		auth.setRealName(body.getRealName());
		auth.setUserId(userId);
		userAuthDao.insert(auth);
		//添加资金账户
		ProjectAccount account=new ProjectAccount();
		String accountId = AccountGenerationUtil.genAmountOrderAccountNo();
		account.setAccountId(accountId);
		account.setFrozenSum(0);
		account.setInsertTime(new Date());
		account.setRemainingSum(0);
		account.setStatus("OK#");
		account.setUserId(userId);
		AccountValidateUtil.updateAccountSignature(account);
		proActDao.insert(account);
		//UserToken createToken = tokensrv.createToken(appId,userId);
		
	}

	@Override
	public Bidder queryBidderByUserId(Integer userId) {
		// TODO Auto-generated method stub
		return bidderDao.selectByUserId(userId);
	}
	
	

}
