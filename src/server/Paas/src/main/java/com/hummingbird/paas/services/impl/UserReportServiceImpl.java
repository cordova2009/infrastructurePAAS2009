package com.hummingbird.paas.services.impl;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.hummingbird.common.constant.CommonStatusConst;
import com.hummingbird.common.exception.BusinessException;
import com.hummingbird.common.exception.ValidateException;
import com.hummingbird.common.face.Pagingnation;
import com.hummingbird.common.util.DateUtil;
import com.hummingbird.common.util.ValidateUtil;
import com.hummingbird.paas.entity.Token;
import com.hummingbird.paas.entity.User;
import com.hummingbird.paas.entity.UserInformation;
import com.hummingbird.paas.entity.UserInformationComment;
import com.hummingbird.paas.entity.UserReport;
import com.hummingbird.paas.mapper.UserInformationMapper;
import com.hummingbird.paas.mapper.UserMapper;
import com.hummingbird.paas.mapper.UserReportMapper;
import com.hummingbird.paas.services.TenderService;
import com.hummingbird.paas.services.TokenService;
import com.hummingbird.paas.services.UserInfoService;
import com.hummingbird.paas.services.UserReportService;
import com.hummingbird.paas.vo.UserReportBodyVO;

/**
 * @author YJY
 * @date 2015年12月2日19:48:21
 * @version 1.0 service接口实现
 */
@Service
public class UserReportServiceImpl implements UserReportService {

	org.apache.commons.logging.Log log = org.apache.commons.logging.LogFactory.getLog(this.getClass());
	@Autowired
	TokenService tokenSrv;
	
	@Autowired
	UserInformationMapper uiDao;
	@Autowired
	UserReportMapper urDao;
	@Autowired
	UserMapper userDao;

	

	@Override
	public int submitReport(String appId, UserReportBodyVO ui, Token token) throws BusinessException {
		// TODO Auto-generated method stub
		int i= 0;
		User user = userDao.selectByPrimaryKey(token.getUserId());
		ValidateUtil.assertNull(user, "用户记录未找到！");
	
		UserReport ur=new UserReport();
			if(ui!= null){
				ur.setUserId(token.getUserId());
				ur.setInsertTime(new Date());
				ur.setRefId(ui.getRefId());
				ur.setRefType(ui.getRefType());
				ur.setReportType(ui.getReportType());
				ur.setReportContent(ui.getReportContent());
	            ur.setDealStatus("CRT");
				
				
			}
		
			i = urDao.insertSelective(ur);
		
			return i;
	}


}