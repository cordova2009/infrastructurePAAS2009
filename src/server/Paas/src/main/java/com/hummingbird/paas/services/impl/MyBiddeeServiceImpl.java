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
import com.hummingbird.paas.mapper.BiddeeCerticateMapper;
import com.hummingbird.paas.mapper.InstationNotificationMapper;
import com.hummingbird.paas.services.AnnouncementService;
import com.hummingbird.paas.services.InstationNotificationService;
import com.hummingbird.paas.services.MyBiddeeService;
@Service
public class MyBiddeeServiceImpl implements MyBiddeeService {
	
	@Autowired
	private BiddeeCerticateMapper biddeeCerticateDao;
		  
	}


