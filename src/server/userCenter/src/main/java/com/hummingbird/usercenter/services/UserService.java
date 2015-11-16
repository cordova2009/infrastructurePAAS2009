package com.hummingbird.usercenter.services;

import java.util.List;

import com.hummingbird.common.exception.ValidateException;
import com.hummingbird.usercenter.entity.User;
import com.hummingbird.usercenter.entity.UserAuth;
import com.hummingbird.usercenter.entity.UserBankcard;
import com.hummingbird.usercenter.entity.UserPassword;
import com.hummingbird.usercenter.exception.MaAccountException;
import com.hummingbird.usercenter.vo.RegisterBodyVO;

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
	
	
	public UserPassword queryUserPassword(Integer userId);
	
	public UserAuth queryUserAuth(Integer userId);
	
	/**
	 * 更新用户信息
	 * @param user
	 */
	public void updateUser(User user)throws MaAccountException;
}
