package com.hummingbird.paas.services;

import com.hummingbird.paas.entity.Bidder;
import com.hummingbird.paas.entity.User;
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
	 * 新增用户，包括用户新，身份认证信息，资金账户信息
	 * @param body
	 */
	public void saveUser(RegisterBodyVO body,String appId);
	
	/**
	 * 查询投标人信息
	 * @param userId
	 * @return
	 */
	public Bidder queryBidderByUserId(Integer userId);
}
