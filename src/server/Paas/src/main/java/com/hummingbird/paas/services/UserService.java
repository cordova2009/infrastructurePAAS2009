package com.hummingbird.paas.services;

import com.hummingbird.paas.entity.User;
import com.hummingbird.paas.exception.MaAccountException;

public interface UserService {
	public User queryUserByMobile(String mobileNum)throws MaAccountException;
	
	public User queryUserByToken(String token)throws MaAccountException;
}
