package com.hummingbird.paas.services;

import java.util.List;

import com.hummingbird.common.exception.ValidateException;
import com.hummingbird.paas.entity.Biddee;
import com.hummingbird.paas.entity.Bidder;
import com.hummingbird.paas.entity.User;
import com.hummingbird.paas.entity.UserAuth;
import com.hummingbird.paas.entity.UserBankcard;
import com.hummingbird.paas.entity.UserPassword;
import com.hummingbird.paas.exception.MaAccountException;
import com.hummingbird.paas.vo.RegisterBodyVO;

public interface UserService {
	/**
	 * 根据手机号查询用户信息
	 * @param mobileNum
	 * @return
	 * @throws MaAccountException
	 */
	public User queryUserByMobile(String mobileNum)throws MaAccountException;
	
	/**
	 * 根据token查询用户信息
	 * @param token
	 * @return
	 * @throws MaAccountException
	 */
	public User queryUserByToken(String token)throws MaAccountException;
	
	/**
	 * 根据用户Id查询银行卡列表
	 * @param userId
	 * @return
	 */
	public List<UserBankcard> queryBankListByUserId(Integer userId);
	
	/**
	 * 新增用户，包括用户新，身份认证信息，资金账户信息
	 * @param body
	 */
	public void saveUser(RegisterBodyVO body,String appId,String appkey)throws ValidateException;
	
	/**
	 * 查询投标人信息
	 * @param userId
	 * @return
	 */
	public Bidder queryBidderByUserId(Integer userId);
	
	/**
	 * 查询z招标人信息
	 * @param userId
	 * @return
	 */
	public Biddee queryBiddeeByUserId(Integer userId);
	
	public UserPassword queryUserPassword(Integer userId);
	
	public UserAuth queryUserAuth(Integer userId);
	
	public void updateUserPassword(UserPassword password)throws MaAccountException;
	
	public Boolean authPassword(Integer userId,String loginPassword)throws MaAccountException;
	
	/**
	 * 更新用户信息
	 * @param user
	 */
	public void updateUser(User user)throws MaAccountException;
}
