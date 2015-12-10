package com.hummingbird.paas.services.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.hummingbird.common.exception.BusinessException;
import com.hummingbird.common.util.ValidateUtil;
import com.hummingbird.paas.entity.Token;
import com.hummingbird.paas.entity.User;
import com.hummingbird.paas.entity.UserInformation;
import com.hummingbird.paas.entity.UserInformationComment;
import com.hummingbird.paas.mapper.UserInformationCommentMapper;
import com.hummingbird.paas.mapper.UserInformationMapper;
import com.hummingbird.paas.mapper.UserMapper;
import com.hummingbird.paas.services.TokenService;
import com.hummingbird.paas.services.UserInfoService;
import com.hummingbird.paas.vo.UserInformationBodyVO;
import com.hummingbird.paas.vo.UserInformationComments;
import com.hummingbird.paas.vo.UserInformationDetailBodyVO;
import com.hummingbird.paas.vo.UserInformationDetailReturnVO;
import com.hummingbird.paas.vo.UserInformationDetailWithCommentsReturnVO;
import com.hummingbird.paas.vo.UserInformationPageBodyVO;
import com.hummingbird.paas.vo.UserInformationPageReturnVO;
import com.hummingbird.paas.vo.UserInformationReplyBodyVO;

/**
 * @author YJY
 * @date 2015年12月2日19:48:21
 * @version 1.0 service接口实现
 */
@Service
public class UserInfoServiceImpl implements UserInfoService {

	org.apache.commons.logging.Log log = org.apache.commons.logging.LogFactory.getLog(this.getClass());
	@Autowired
	TokenService tokenSrv;
	
	@Autowired
	UserInformationMapper uiDao;
	@Autowired
	UserInformationCommentMapper uicDao;
	@Autowired
	UserMapper userDao;
	

	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, value = "txManager")
	public int submitUserInformation(String appId, UserInformationBodyVO ui, Token token) throws BusinessException {
		// TODO Auto-generated method stub

			int i= 0;
			UserInformation userinformation=uiDao.selectByPrimaryKey(ui.getInformationId());
			if(userinformation==null){
				userinformation=new UserInformation();
				if(ui!= null){
					
					userinformation.setId(ui.getInformationId());
					userinformation.setUserId(token.getUserId());
					userinformation.setAddress(ui.getAddress());
					userinformation.setObjectAmount(ui.getObjectAmount());
					userinformation.setDistrict(ui.getDistrict());
					userinformation.setObjectName(ui.getObjectName());
					userinformation.setObjectType(ui.getObjectType());
					userinformation.setEmployer(ui.getEmployer());
					userinformation.setPhase(ui.getPhase());
					userinformation.setProjectPeriod(ui.getProjectPeriod());
					userinformation.setProjectSituation(ui.getProjectSituation());
					userinformation.setInsertTime(new Date());
					userinformation.setStatus("CRT");
					
				}
			
				i = uiDao.insertSelective(userinformation);
			}else{
				if(ui!= null){
					userinformation.setAddress(ui.getAddress());
					userinformation.setUserId(token.getUserId());
					userinformation.setObjectAmount(ui.getObjectAmount());
					userinformation.setDistrict(ui.getDistrict());
					userinformation.setObjectName(ui.getObjectName());
					userinformation.setObjectType(ui.getObjectType());
					userinformation.setEmployer(ui.getEmployer());
					userinformation.setPhase(ui.getPhase());
					userinformation.setProjectPeriod(ui.getProjectPeriod());
					userinformation.setProjectSituation(ui.getProjectSituation());
					userinformation.setUpdateTime(new Date());
					userinformation.setStatus("CRT");
					
				}
				i = uiDao.updateByPrimaryKeySelective(userinformation);
			}
			

		
		return i;
	}

	@Override
	public UserInformationDetailReturnVO getUserInformationDetail(String appId, UserInformationDetailBodyVO body,
			Token token) throws BusinessException {
		// TODO Auto-generated method stub
		UserInformationDetailReturnVO uidr = new UserInformationDetailReturnVO();
		UserInformation ui = uiDao.selectByPrimaryKey(body.getInformationId());
		if(ui!= null){
			uidr.setAddress(ui.getAddress());
			uidr.setDistrict(ui.getDistrict());
			uidr.setEmployer(ui.getEmployer());
			uidr.setInformationId(ui.getId());
			uidr.setObjectAmount(ui.getObjectAmount());
			uidr.setObjectName(ui.getObjectName());
			uidr.setObjectType(ui.getObjectType());
			uidr.setPhase(ui.getPhase());
			uidr.setProjectPeriod(ui.getProjectPeriod());
			uidr.setProjectSituation(ui.getProjectPeriod());
			uidr.setStatus(ui.getStatus());
		}
		return uidr;
	}

	@Override
	public UserInformationDetailWithCommentsReturnVO getUserInformationDetailWithComments(String appId,
			UserInformationDetailBodyVO body, Token token) throws BusinessException {
		// TODO Auto-generated method stub
		UserInformationDetailWithCommentsReturnVO uidr = new UserInformationDetailWithCommentsReturnVO();
		UserInformation ui = uiDao.selectByPrimaryKey(body.getInformationId());
		if(ui!= null){
			uidr.setAddress(ui.getAddress());
			uidr.setDistrict(ui.getDistrict());
			uidr.setEmployer(ui.getEmployer());
			uidr.setInformationId(ui.getId());
			uidr.setObjectAmount(ui.getObjectAmount());
			uidr.setObjectName(ui.getObjectName());
			uidr.setObjectType(ui.getObjectType());
			uidr.setPhase(ui.getPhase());
			uidr.setProjectPeriod(ui.getProjectPeriod());
			uidr.setProjectSituation(ui.getProjectPeriod());
			uidr.setStatus(ui.getStatus());
			User user = userDao.selectByPrimaryKey(ui.getUserId());
			if(user!= null){
				uidr.setUserName(user.getUserName());
			}
			
			List<UserInformationComments> comments = uicDao.selectByInformationId(ui.getId());
			uidr.setComments(comments);
		}
		return uidr;
	}

	@Override
	public List<UserInformationPageReturnVO> queryUserInformationPage(String appId, UserInformationPageBodyVO body,
			Token token) throws BusinessException {
		// TODO Auto-generated method stub
		Integer pageIndex = body.getPageIndex();
		Integer pageSize = body.getPageSize();
		
		List<UserInformationPageReturnVO> qlr = new ArrayList<UserInformationPageReturnVO>();
		qlr = uiDao.selectByUserIdAndStatus(token.getUserId(), body.getStatus(), (pageIndex-1)*pageSize, pageSize);
		return qlr;
	}

	@Override
	public int replyUserInformation(String appId, UserInformationReplyBodyVO ui, Token token)
			throws BusinessException {
		// TODO Auto-generated method stub
		
		int i= 0;
		UserInformation userinformation=uiDao.selectByPrimaryKey(ui.getInformationId());
		UserInformationComment uic = uicDao.selectByInformationIdAndUserId(ui.getInformationId(), token.getUserId());
		ValidateUtil.assertNull(userinformation, "用户信息记录未找到！");
	
		UserInformationComment uics=new UserInformationComment();
			if(ui!= null){
				
				uics.setInformationId(ui.getInformationId());
				uics.setReplier(token.getUserId());
				uics.setReplyContent(ui.getReplyContent());
				uics.setReplyTime(new Date());
				uics.setStatus("OK#");
				
			}
		
			i = uicDao.insertSelective(uics);
		
			return i;
	}

	@Override
	public int queryUserInformationPageTotal(String appId, UserInformationPageBodyVO body, Token token)
			throws BusinessException {
		// TODO Auto-generated method stub
		int num = 0;
		num = uiDao.selectTotalByUserIdAndStatus(token.getUserId(), body.getStatus());
		return num;
	}


}