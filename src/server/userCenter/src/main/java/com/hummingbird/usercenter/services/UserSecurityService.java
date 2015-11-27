package com.hummingbird.usercenter.services;

import com.hummingbird.common.exception.BusinessException;
import com.hummingbird.usercenter.vo.PlatformResetPasswordBodyVO;


/**
 * @author 
 * @date 2015-11-26
 * @version 1.0
 *  service接口
 */
public interface UserSecurityService  {

			/**
	 * 重置登录密码接口
	 * @param appId 应用id
	 * @param body 参数
	 * @return 
	 * @throws BusinessException 
	 */
	public void resetPassword(String appId,PlatformResetPasswordBodyVO body) throws BusinessException;
	
		
		
	}