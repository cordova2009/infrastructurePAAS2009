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
import com.hummingbird.paas.services.InstationNotificationService;
@Service
public class InstationNotificationServiceImpl implements InstationNotificationService {
	@Autowired
	private InstationNotificationMapper notificationDao;

	

	@Override
	public List<InstationNotification> selectByUserInValid(String token,String status,Pagingnation page) {
		// TODO Auto-generated method stub
		org.apache.commons.logging.Log log = org.apache.commons.logging.LogFactory.getLog(this.getClass());
		
		if(page!=null&&page.isCountsize()){
			int totalcount = notificationDao.selectTotalCountByTokenAndStatus(token, status);
			page.setTotalCount(totalcount);
			page.calculatePageCount();
		}
		List<InstationNotification> nos = notificationDao.selectByUserInValid(token, status, page); 
		
		return nos;

	}


	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, value = "txManager")
	public int updateNotice(InstationNotification nn) {
		// TODO Auto-generated method stub
		if(StringUtils.isNotBlank(String.valueOf(nn.getNoticeTitle()))){
			return notificationDao.updateByPrimaryKeySelective(nn);
		}
		return 0;
		
	}
		  
	}


