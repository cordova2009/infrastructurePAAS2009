package com.hummingbird.usercenter.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hummingbird.common.exception.ValidateException;
import com.hummingbird.usercenter.entity.User;
import com.hummingbird.usercenter.entity.UserAuth;
import com.hummingbird.usercenter.entity.UserBankcard;
import com.hummingbird.usercenter.entity.UserPassword;
import com.hummingbird.usercenter.exception.MaAccountException;
import com.hummingbird.usercenter.services.UserService;
import com.hummingbird.usercenter.vo.RegisterBodyVO;


@Service
public class UserServiceImpl implements UserService{

	@Override
	public User queryUserByMobile(String mobileNum) throws MaAccountException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User queryUserByToken(String token) throws MaAccountException {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public List<UserBankcard> queryBankListByUserId(Integer userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void saveUser(RegisterBodyVO body, String appId, String appkey) throws ValidateException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public UserPassword queryUserPassword(Integer userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserAuth queryUserAuth(Integer userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateUser(User user) throws MaAccountException {
		// TODO Auto-generated method stub
		
	}

	/*org.apache.commons.logging.Log log = org.apache.commons.logging.LogFactory
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
	private UserBankcardMapper bankcardDao;
	@Override
	public List<UserBankcard> queryBankListByUserId(Integer userId) {
		// TODO Auto-generated method stub
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
		return users==null?null:users.get(0);
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
		int userId = userDao.insert(user);
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

	@Override
	public UserPassword queryUserPassword(Integer userId) {
		// TODO Auto-generated method stub
		return passwordDao.selectByPrimaryKey(userId);
	}

	@Override
	public UserAuth queryUserAuth(Integer userId) {
		// TODO Auto-generated method stub
		return userAuthDao.selectByPrimaryKey(userId);
	}
	@Override
	public void updateUser(User user) throws MaAccountException{
		// TODO Auto-generated method stub
		int updateUser=userDao.updateByPrimaryKeySelective(user);
		if(updateUser!=1){
			throw new MaAccountException(211101,"用户更新失败");
		}
	}
	
	*/

}
