package com.hummingbird.paas.services.impl;

import java.util.ArrayList;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.hummingbird.common.exception.BusinessException;
import com.hummingbird.common.util.ValidateUtil;
import com.hummingbird.paas.entity.UserNotices;
import com.hummingbird.paas.mapper.UserMapper;
import com.hummingbird.paas.mapper.UserNoticesMapper;
import com.hummingbird.paas.services.TokenService;
import com.hummingbird.paas.services.UserMsgService;
import com.hummingbird.paas.vo.UserMsgBodyVO;

/**
 * @author YJY
 * @date 2015年12月19日10:49:34 
 * @version 1.0 service接口实现
 */
@Service
public class UserMsgServiceImpl implements UserMsgService {

	org.apache.commons.logging.Log log = org.apache.commons.logging.LogFactory.getLog(this.getClass());
	@Autowired
	TokenService tokenSrv;
	
	@Autowired
	UserNoticesMapper unDao;
	@Autowired
	UserMapper userDao;




	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, value = "txManager")
	public int addMsg(UserMsgBodyVO um) throws BusinessException {
		// TODO Auto-generated method stub
		int i= 0;
		UserNotices un =new UserNotices();
			if(un != null){
				
				un.setNoticeText(um.getMsgContent());
				un.setNoticeTitle(um.getMsgTitle());
				un.setNoticeType(um.getMsgType());
				un.setReceiver(um.getUserId());
				un.setSender(-999);//代表系统
				un.setInsertTime(new Date());
				un.setExpiryDate(90);//系统默认暂定  三个月
				un.setStatus("NO#");//未读
			}
		
			i = unDao.insertSelective(un);
		
			return i;
	}


}