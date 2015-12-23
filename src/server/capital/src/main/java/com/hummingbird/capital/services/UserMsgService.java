package com.hummingbird.capital.services;

import com.hummingbird.capital.vo.UserMsgBodyVO;
import com.hummingbird.common.exception.BusinessException;

/**
 * @author YJY
 * @date 2015年12月19日10:47:51
 * @version 1.0 service接口
 */
public interface UserMsgService {
	

	/**
	 *向用户发送站内消息接口
	 * 
	 * @param appId
	 *            应用id
	 * @param body
	 *            参数
	 * 
	 * @return
	 * @throws BusinessException
	 */
	public int addMsg(UserMsgBodyVO body)
			throws BusinessException;




}
