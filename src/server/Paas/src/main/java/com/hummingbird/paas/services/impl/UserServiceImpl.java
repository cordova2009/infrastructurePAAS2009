package com.hummingbird.paas.services.impl;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.hummingbird.common.exception.ValidateException;
import com.hummingbird.common.util.DESUtil;
import com.hummingbird.paas.entity.Biddee;
import com.hummingbird.paas.entity.Bidder;
import com.hummingbird.paas.entity.ProjectAccount;
import com.hummingbird.paas.entity.Token;
import com.hummingbird.paas.entity.User;
import com.hummingbird.paas.entity.UserAuth;
import com.hummingbird.paas.entity.UserBankcard;
import com.hummingbird.paas.entity.UserPassword;
import com.hummingbird.paas.exception.MaAccountException;
import com.hummingbird.paas.mapper.BiddeeMapper;
import com.hummingbird.paas.mapper.BidderMapper;
import com.hummingbird.paas.mapper.ProjectAccountMapper;
import com.hummingbird.paas.mapper.UserAuthMapper;
import com.hummingbird.paas.mapper.UserBankcardMapper;
import com.hummingbird.paas.mapper.UserMapper;
import com.hummingbird.paas.mapper.UserPasswordMapper;
import com.hummingbird.paas.services.TokenService;
import com.hummingbird.paas.services.UserService;
import com.hummingbird.paas.util.AccountGenerationUtil;
import com.hummingbird.paas.util.AccountValidateUtil;
import com.hummingbird.paas.vo.RegisterBodyVO;


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
	@Autowired
	BiddeeMapper biddeeDao;
	@Autowired
	private UserBankcardMapper bankcardDao;
	@Override
	public List<UserBankcard> queryBankListByUserId(Integer userId) {
		
		return bankcardDao.queryBankListByUserId(userId);
	}
	@Override
	public User queryUserByMobile(String mobileNum) throws MaAccountException{
		List<User> users=userDao.queryUserByMobile(mobileNum);
		
		if(users.size()>1){
			if (log.isDebugEnabled()) {
				log.debug(String.format("根据手机号[%s]查询到多个用户",mobileNum));
			}
			throw new MaAccountException(MaAccountException.ERR_ACCOUNT_EXCEPTION,"根据手机号查询到多个用户");
		
		}
		return users.size()==0?null:users.get(0);
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
			throw new MaAccountException(MaAccountException.ERR_ACCOUNT_EXCEPTION,String.format("token[%s]无效或已过期,请重新登录",token));
			
		}
	}

	@Transactional(propagation=Propagation.REQUIRED,rollbackFor=Exception.class,value="txManager")
	public void saveUser(RegisterBodyVO body,String appId,String appkey) throws ValidateException{
		//保存用户信息
		User user = new User();
		user.setInsertTime(new Date());
		user.setNickName(body.getNickname());
		user.setMobileNum(body.getMobileNum());
		user.setUpdateTime(new Date());
		user.setStatus("OK#");
		userDao.insert(user);

		//保存密码信息
		UserPassword password=new UserPassword();
		//尝试进行解密
		if(StringUtils.isNotBlank(body.getTradePassword())){
			try {
				String tradePassword = DESUtil.decodeDES(body.getTradePassword(), appkey);
				password.setTradePassword(tradePassword);
			} catch (Exception e) {
				log.error(String.format("支付密码des解密出错"),e);
				throw ValidateException.ERROR_PARAM_FORMAT_ERROR.clone(e,"支付密码des解密出错");
				
			}
		}
		if(StringUtils.isNotBlank(body.getLoginPassword())){
			try {
				String loginPassword = DESUtil.decodeDES(body.getLoginPassword(), appkey);
				password.setPassword(loginPassword);
			} catch (Exception e) {
				log.error(String.format("登录密码des解密出错"),e);
				throw ValidateException.ERROR_PARAM_FORMAT_ERROR.clone(e,"登录密码des解密出错");
				
			}
		}
		password.setUserId(user.getId());
		passwordDao.insert(password);
		//保存实名认证信息
		UserAuth auth=new UserAuth();
		auth.setIdentityNo(body.getCardID());
		auth.setRealName(body.getRealName());
		auth.setUserId(user.getId());
		auth.setRealNameVerify("OK#");
		userAuthDao.insert(auth);
		//添加资金账户
		ProjectAccount account=new ProjectAccount();
		String accountId = AccountGenerationUtil.genAmountOrderAccountNo();
		account.setAccountId(accountId);
		account.setFrozenSum(0l);
		account.setInsertTime(new Date());
		account.setRemainingSum(0l);
		account.setStatus("OK#");
		account.setUserId(user.getId());
		AccountValidateUtil.updateAccountSignature(account);
		proActDao.insert(account);
		
	}

	@Override
	public Bidder queryBidderByUserId(Integer userId) {
		return bidderDao.selectByUserId(userId);
	}

	@Override
	public UserPassword queryUserPassword(Integer userId) {
	
		return passwordDao.selectByPrimaryKey(userId);
	}

	@Override
	public UserAuth queryUserAuth(Integer userId) {
	
		return userAuthDao.selectByPrimaryKey(userId);
	}
	@Override
	public void updateUser(User user) throws MaAccountException{
	
		user.setUpdateTime(new Date());
		int updateUser=userDao.updateByPrimaryKey(user);
		if(updateUser!=1){
			throw new MaAccountException(211101,"用户更新失败");
		}

	}
	@Override
	public Biddee queryBiddeeByUserId(Integer userId) {
		return biddeeDao.selectByUserId(userId);
	}
	@Override
	public void updateUserPassword(UserPassword password)
			throws MaAccountException {
		int updatePassword= passwordDao.updateByPrimaryKeySelective(password);
		if(updatePassword!=1){
			throw new MaAccountException(211501,"用户登录密码更新失败");
		}
	}
	@Override
	public Boolean authPassword(Integer userId, String loginPassword)
			throws MaAccountException {
		UserPassword userPassword=passwordDao.selectByPrimaryKey(userId);
		if(!StringUtils.equals(loginPassword, userPassword.getPassword())){
			if (log.isDebugEnabled()) {
				log.debug("原登录密码错误");
			}
			throw new MaAccountException(MaAccountException.ERR_ACCOUNT_EXCEPTION,"原登录密码错误");
			
		}
		return true;
	}
	
	/**
	 * 加载用户信息
	 * @param userId
	 * @return
	 */
	public User loadUser(Integer userId){
		return userDao.selectByPrimaryKey(userId);
	}

}
