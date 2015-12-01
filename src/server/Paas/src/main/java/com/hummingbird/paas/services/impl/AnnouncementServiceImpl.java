package com.hummingbird.paas.services.impl;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.hummingbird.common.face.Pagingnation;
import com.hummingbird.common.util.DateUtil;
import com.hummingbird.paas.entity.Announcement;

import com.hummingbird.paas.entity.InstationNotification;
import com.hummingbird.paas.mapper.AnnouncementMapper;
import com.hummingbird.paas.mapper.InstationNotificationMapper;
import com.hummingbird.paas.services.AnnouncementService;
import com.hummingbird.paas.services.InstationNotificationService;
@Service
public class AnnouncementServiceImpl implements AnnouncementService {
	
	@Autowired
	private AnnouncementMapper announcementDao;
	
	org.apache.commons.logging.Log log = org.apache.commons.logging.LogFactory.getLog(this.getClass());

	@Override
	public List<Announcement> selectAnnouncementInValid(Integer creator, String status, Date startTime, Date endTime,
			Pagingnation page) {
		
		if(page!=null&&page.isCountsize()){
			int totalcount = announcementDao.selectTotalCountAnnouncement(creator, status, startTime, endTime);
			page.setTotalCount(totalcount);
			page.calculatePageCount();
		}
		List<Announcement> ans = announcementDao.selectAnnouncement(creator, status, startTime, endTime, page); 
		
		return ans;
	}
		  
	}


