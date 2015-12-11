package com.hummingbird.paas.services;

import com.hummingbird.common.exception.BusinessException;
import com.hummingbird.paas.entity.Token;
import com.hummingbird.paas.vo.UserComplainBodyVO;

/**
 * @author YJY
 * @date 2015年12月2日19:48:56
 * @version 1.0 service接口
 */
public interface UserComplainService {
	

	/**
	 *提交投诉接口
	 * 
	 * @param appId
	 *            应用id
	 * @param body
	 *            参数
	 * 
	 * @return
	 * @throws BusinessException
	 */
	public int submitComplain(String appId, UserComplainBodyVO body,Token token)
			throws BusinessException;




}
