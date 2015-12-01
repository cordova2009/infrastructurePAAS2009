package com.hummingbird.paas.services;

import com.hummingbird.paas.entity.UserNotices;
import com.hummingbird.paas.exception.PaasException;
import com.hummingbird.paas.vo.GetMsgListResultVO;

public interface MymsgService {
	/**
	 * 查询我的消息列表
	 * 
	 * @param userId
	 * @param pageIndex
	 * @param pageSize
	 * @return
	 */
	public GetMsgListResultVO getMsgList(Integer userId, Integer pageIndex, Integer pageSize);

	/**
	 * 查询我的未读消息 
	 * @param token
	 * @return
	 */
	public Integer getUnreadMsgNum(Integer userId);
	
	/**
	 * 获取消息明细
	 * @param msgId
	 * @return
	 * @throws PaasException 
	 */
	public UserNotices getMsgDetail(Integer msgId) throws PaasException;
	
}
