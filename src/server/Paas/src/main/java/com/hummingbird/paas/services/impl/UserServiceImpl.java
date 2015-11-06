package com.hummingbird.paas.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.hummingbird.paas.entity.User;
import com.hummingbird.paas.exception.MaAccountException;
import com.hummingbird.paas.mapper.UserMapper;
import com.hummingbird.paas.services.UserService;

public class UserServiceImpl implements UserService{

	org.apache.commons.logging.Log log = org.apache.commons.logging.LogFactory
			.getLog(this.getClass());
	
	@Autowired
	UserMapper userDao;

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
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
