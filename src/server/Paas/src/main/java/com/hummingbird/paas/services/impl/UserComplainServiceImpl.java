package com.hummingbird.paas.services.impl;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hummingbird.common.exception.BusinessException;
import com.hummingbird.common.util.ValidateUtil;
import com.hummingbird.paas.entity.Token;
import com.hummingbird.paas.entity.User;
import com.hummingbird.paas.entity.UserComplain;
import com.hummingbird.paas.mapper.UserComplainMapper;
import com.hummingbird.paas.mapper.UserInformationCommentMapper;
import com.hummingbird.paas.mapper.UserInformationMapper;
import com.hummingbird.paas.mapper.UserMapper;
import com.hummingbird.paas.services.TenderService;
import com.hummingbird.paas.services.TokenService;
import com.hummingbird.paas.services.UserComplainService;
import com.hummingbird.paas.vo.UserComplainBodyVO;

/**
 * @author YJY
 * @date 2015年12月2日19:48:21
 * @version 1.0 service接口实现
 */
@Service
public class UserComplainServiceImpl implements UserComplainService {

	org.apache.commons.logging.Log log = org.apache.commons.logging.LogFactory.getLog(this.getClass());
	@Autowired
	TokenService tokenSrv;
	
	@Autowired
	UserInformationMapper uiDao;
	@Autowired
	UserComplainMapper ucDao;
	@Autowired
	UserMapper userDao;




	@Override
	public int submitComplain(String appId, UserComplainBodyVO uc, Token token) throws BusinessException {
		// TODO Auto-generated method stub
		int i= 0;
		User user = userDao.selectByPrimaryKey(token.getUserId());
		ValidateUtil.assertNull(user, "用户记录未找到！");
	
		UserComplain ur=new UserComplain();
			if(uc!= null){
				
				ur.setUserId(token.getUserId());
				ur.setInsertTime(new Date());
				ur.setRefId(uc.getRefId());
				ur.setRefType(uc.getRefType());
				ur.setComplainContent(uc.getComplainContent());
				ur.setComplainType(uc.getComplainType());
	            ur.setDealStatus("CRT");
				
				
			}
		
			i = ucDao.insertSelective(ur);
		
			return i;
	}


}