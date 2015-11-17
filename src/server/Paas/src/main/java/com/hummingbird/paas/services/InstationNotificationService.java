package com.hummingbird.paas.services;

import java.util.List;

import com.hummingbird.common.face.Pagingnation;
import com.hummingbird.paas.entity.InstationNotification;

/**
 * 根据用户查询有效期记录
 * */
public interface InstationNotificationService {

	public List<InstationNotification> selectByUserInValid(String token,String status,Pagingnation page);
	
	
	public int updateNotice(InstationNotification ns) ;
	
}
