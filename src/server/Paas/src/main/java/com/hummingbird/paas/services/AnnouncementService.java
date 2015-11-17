package com.hummingbird.paas.services;

import java.util.Date;
import java.util.List;

import com.hummingbird.common.face.Pagingnation;
import com.hummingbird.paas.entity.Announcement;

/**
 * 根据用户查询有效期记录
 * */
public interface AnnouncementService {
	
	public List<Announcement> selectAnnouncementInValid(Integer  uid,String status, Date time1,Date time2, Pagingnation page);
	
	
}
