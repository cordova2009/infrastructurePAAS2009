package com.hummingbird.usercenter.services.impl;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.lang.ObjectUtils;
import org.apache.commons.lang.StringUtils;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializationConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.hummingbird.common.exception.ValidateException;
import com.hummingbird.common.util.DESUtil;
import com.hummingbird.common.util.Md5Util;
import com.hummingbird.common.util.ValidateUtil;
import com.hummingbird.common.util.http.HttpRequester;
import com.hummingbird.common.vo.ResultModel;
import com.hummingbird.commonbiz.vo.AppVO;
import com.hummingbird.usercenter.vo.MobileNumVO;
import com.hummingbird.usercenter.vo.MobileVO;
import com.hummingbird.usercenter.vo.UserBodyVO;
import com.hummingbird.usercenter.vo.UserVO;
import com.hummingbird.usercenter.entity.ProjectAccount;
import com.hummingbird.usercenter.entity.Token;
import com.hummingbird.usercenter.entity.User;
import com.hummingbird.usercenter.entity.UserAuth;
import com.hummingbird.usercenter.entity.UserBankcard;
import com.hummingbird.usercenter.entity.UserPassword;
import com.hummingbird.usercenter.exception.MaAccountException;
import com.hummingbird.usercenter.mapper.ProjectAccountMapper;
import com.hummingbird.usercenter.mapper.UserAuthMapper;
import com.hummingbird.usercenter.mapper.UserBankcardMapper;
import com.hummingbird.usercenter.mapper.UserMapper;
import com.hummingbird.usercenter.mapper.UserPasswordMapper;
import com.hummingbird.usercenter.services.TokenService;
import com.hummingbird.usercenter.services.UserService;
import com.hummingbird.usercenter.util.AccountGenerationUtil;
import com.hummingbird.usercenter.util.AccountValidateUtil;
import com.hummingbird.usercenter.vo.RegisterBodyVO;


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
	@Autowired(required = true)
	private TokenService tokensrv;
	@Autowired
	private UserBankcardMapper bankcardDao;
	@Autowired
	ProjectAccountMapper proActDao;
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
				throw new MaAccountException(MaAccountException.ERR_ACCOUNT_EXCEPTION,"根据用户编号查找不到用户");
				
			}
			else{
				return user;			
			}
		}
		else{
			if (log.isDebugEnabled()) {
				log.debug(String.format("token[%s]无效",token));
			}
			throw new MaAccountException(MaAccountException.ERR_ACCOUNT_EXCEPTION,String.format("用户登录已失效,请重新登录",token));
			
		}
	}

	@Transactional(propagation=Propagation.REQUIRED,rollbackFor=Exception.class,value="txManager")
	public void saveUser(RegisterBodyVO body1,String appId,String appkey,String url,ResultModel rm) throws ValidateException,MaAccountException{
			
		//保存用户信息
		User user = new User();
		user.setInsertTime(new Date());
		user.setNickName(body1.getNickname());
		user.setMobileNum(body1.getMobileNum());
		user.setUpdateTime(new Date());
		user.setStatus("OK#");
		userDao.insert(user);

		//保存密码信息
		UserPassword password=new UserPassword();
		//尝试进行解密
		if(StringUtils.isNotBlank(body1.getTradePassword())){
			try {
				String tradePassword = DESUtil.decodeDESwithCBC(body1.getTradePassword(), appkey);
				password.setTradePassword(tradePassword);
			} catch (Exception e) {
				log.error(String.format("支付密码des解密出错"),e);
				throw ValidateException.ERROR_PARAM_FORMAT_ERROR.clone(e,"支付密码des解密出错");
				
			}
		}
		if(StringUtils.isNotBlank(body1.getLoginPassword())){
			try {
				String loginPassword = DESUtil.decodeDESwithCBC(body1.getLoginPassword(), appkey);
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
		//尝试进行解密
		if(StringUtils.isNotBlank(body1.getRealName())){
			try {
				String realName = DESUtil.decodeDESwithCBC(body1.getRealName(), appkey);
				auth.setRealName(realName);
			} catch (Exception e) {
				log.error(String.format("支付密码des解密出错"),e);
				throw ValidateException.ERROR_PARAM_FORMAT_ERROR.clone(e,"支付密码des解密出错");
				
			}
		}
		if(StringUtils.isNotBlank(body1.getCardID())){
			try {
				String cardId = DESUtil.decodeDESwithCBC(body1.getCardID(), appkey);
				auth.setIdentityNo(cardId);
			} catch (Exception e) {
				log.error(String.format("登录密码des解密出错"),e);
				throw ValidateException.ERROR_PARAM_FORMAT_ERROR.clone(e,"登录密码des解密出错");
				
			}
		}				
		
		auth.setUserId(user.getId());
		auth.setRealNameVerify("OK#");
		userAuthDao.insert(auth);
		//添加资金账户
		//调用资金账户管理开通资金账户接口
		AppVO app=new AppVO();
		app.setAppId(appId);
		app.setNonce(String.valueOf((long)(10000000*Math.random())));
		app.setTimeStamp(String.valueOf(System.currentTimeMillis()));
		String mingwen=ValidateUtil.sortbyValues(app.getAppId(),appkey,app.getNonce(),app.getTimeStamp());
		String signature = Md5Util.Encrypt(mingwen);
		app.setSignature(signature);
		UserBodyVO body=new UserBodyVO();
		body.setMobileNum(body1.getMobileNum());
		body.setUserId(user.getId());
		UserVO transOrder=new UserVO();
		transOrder.setApp(app);
		transOrder.setBody(body);
		String requestJson=null;
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(SerializationConfig.Feature.INDENT_OUTPUT,
				Boolean.TRUE);
		try {
			requestJson = mapper.writeValueAsString(transOrder);
		
		String paygatewayUrl = String.format("%s/capitalManage/open",url);
		String result = new HttpRequester().postRequest(paygatewayUrl,
				requestJson);
		if (log.isDebugEnabled()) {
			log.debug(String.format("调用资金账户管理系统开通资金账户接口返回结果为%s",result));
		}
		HashMap resultmap = mapper.readValue(result, HashMap.class);
		rm.putAll(resultmap);
		//返回结果处理
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		boolean mapsuccess = "0".equals(ObjectUtils.toString(rm.get("errcode")));
		if(!mapsuccess){
			if (log.isDebugEnabled()) {
				log.debug(String.format("用户【%s】开通资金账户失败",user.getMobileNum()));
			}
			throw new MaAccountException(MaAccountException.ERR_ACCOUNT_EXCEPTION,String.format("用户【%s】开通资金账户失败",user.getMobileNum()));
			
		}
	}

	/*@Override
	public Bidder queryBidderByUserId(Integer userId) {
		return bidderDao.selectByUserId(userId);
	}*/

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
	/*@Override
	public Biddee queryBiddeeByUserId(Integer userId) {
		return biddeeDao.selectByUserId(userId);
	}*/
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
	 * 创建或更新用户密码
	 * @param userId
	 * @param password md5加密后的密码
	 */
	@Override
	public void createOrUpdatePassword(Integer userId,String password){
		UserPassword up = passwordDao.selectByPrimaryKey(userId);
		if(up==null){
			up=new UserPassword();
			up.setUserId(userId);
			up.setPassword(password);
			passwordDao.insert(up);
		}
		else{
			up.setPassword(password);
			passwordDao.updateByPrimaryKey(up);
		}
		
	}
	
	

}
