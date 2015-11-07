package com.hummingbird.paas.services;

import com.hummingbird.paas.entity.User;
import com.hummingbird.paas.exception.MaAccountException;
import com.hummingbird.paas.vo.RegisterBodyVO;

public interface UserService {
	public User queryUserByMobile(String mobileNum)throws MaAccountException;
	
	public User queryUserByToken(String token)throws MaAccountException;
	
	/**
	 * 新增用户，包括用户新，身份认证信息，资金账户信息
	 * @param body
	 */
	public void saveUser(RegisterBodyVO body,String appId);
}
