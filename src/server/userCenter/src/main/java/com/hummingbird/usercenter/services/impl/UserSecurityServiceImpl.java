package com.hummingbird.usercenter.services.impl;

import org.apache.commons.collections.keyvalue.DefaultKeyValue;
import org.apache.commons.lang.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.hummingbird.common.exception.BusinessException;
import com.hummingbird.common.exception.ValidateException;
import com.hummingbird.common.util.Md5Util;
import com.hummingbird.common.util.SmsSenderUtil;
import com.hummingbird.usercenter.entity.User;
import com.hummingbird.usercenter.entity.UserPassword;
import com.hummingbird.usercenter.mapper.UserMapper;
import com.hummingbird.usercenter.mapper.UserPasswordMapper;
import com.hummingbird.usercenter.services.UserSecurityService;
import com.hummingbird.usercenter.services.UserService;
import com.hummingbird.usercenter.vo.PlatformResetPasswordBodyVO;

/**
 * @author 
 * @date 2015-11-26
 * @version 1.0
 *  service接口实现
 */
@Service
public class UserSecurityServiceImpl  implements UserSecurityService{

	org.apache.commons.logging.Log log = org.apache.commons.logging.LogFactory.getLog(this.getClass());
	
	@Autowired
	UserMapper userDao;
	@Autowired
	UserPasswordMapper passwordDao;
	@Autowired
	UserService userSrv;

	/**
	 * 重置登录密码接口(平台方重置)
	 * @param appId 应用id
	 * @param body 参数
	 * @return 
	 * @throws BusinessException 
	 */
	 @Transactional(propagation=Propagation.REQUIRED,rollbackFor=Exception.class,value="txManager")
	public void resetPassword(String appId,PlatformResetPasswordBodyVO body) throws BusinessException{
		if(log.isDebugEnabled()){
				log.debug("重置登录密码接口开始");
		}
		//根据3个参数找到用户id,再重置一个6位随机混合英文和数字的密码,再通过手机短信形式发送到手机上
		User user = userDao.selectUser(body.getMobileNum(),body.getCardID(),body.getRealName());
		if(user==null){
			log.error("用户不存在,无法进行重置");
			throw ValidateException.ERROR_EXISTING_USER_NOT_EXISTS;
		}
		String passwd = RandomStringUtils.randomAlphabetic(6);
		userSrv.createOrUpdatePassword(user.getId(), Md5Util.Encrypt(passwd));
		//发送短信
		SmsSenderUtil.sendSms(user.getMobileNum(), "sms.user.resetpassword",new DefaultKeyValue("password", passwd));
		
		if(log.isDebugEnabled()){
				log.debug("重置登录密码接口完成");
		}
	}
		
		
		
}