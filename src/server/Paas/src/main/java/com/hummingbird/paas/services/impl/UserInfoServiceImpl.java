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
<<<<<<< HEAD
import com.hummingbird.commonbiz.exception.TokenException;
import com.hummingbird.commonbiz.util.NoGenerationUtil;
import com.hummingbird.commonbiz.vo.BaseTransVO;
import com.hummingbird.paas.entity.Announcement;
import com.hummingbird.paas.entity.BidInviteBidder;
import com.hummingbird.paas.entity.BidObject;
import com.hummingbird.paas.entity.ObjectProjectInfo;
import com.hummingbird.paas.entity.Biddee;
import com.hummingbird.paas.entity.Bidder;
import com.hummingbird.paas.entity.BidderCerticate;
import com.hummingbird.paas.entity.CertificationType;
import com.hummingbird.paas.entity.Industry;
import com.hummingbird.paas.entity.ObjectBaseinfo;
import com.hummingbird.paas.entity.ObjectBondSetting;
import com.hummingbird.paas.entity.ObjectCertificationRequirement;
import com.hummingbird.paas.entity.ProjectEvaluationBiddee;
import com.hummingbird.paas.entity.ProjectInfo;
import com.hummingbird.paas.entity.Qanda;
=======
>>>>>>> 768ccc76ca944006747e0a0f63b99a94cc8a85df
import com.hummingbird.paas.entity.Token;
import com.hummingbird.paas.entity.User;
import com.hummingbird.paas.entity.UserInformation;
import com.hummingbird.paas.entity.UserInformationComment;
import com.hummingbird.paas.mapper.UserInformationCommentMapper;
import com.hummingbird.paas.mapper.UserInformationMapper;
import com.hummingbird.paas.mapper.UserMapper;
import com.hummingbird.paas.services.TokenService;
import com.hummingbird.paas.services.UserInfoService;
<<<<<<< HEAD
import com.hummingbird.paas.vo.EvaluateBidderBodyVO;
import com.hummingbird.paas.vo.InviteTenderVO;
import com.hummingbird.paas.vo.MyObjectTenderSurveyBodyVO;
import com.hummingbird.paas.vo.MyObjectTenderSurveyBodyVOResult;
import com.hummingbird.paas.vo.MyTenderObjectListVO;
import com.hummingbird.paas.vo.QueryAnswerMethodInfoBodyVOResult;
import com.hummingbird.paas.vo.QueryBidEvaluationTypeInfoBodyVOResult;
import com.hummingbird.paas.vo.QueryBidFileTypeInfoResult;
import com.hummingbird.paas.vo.QueryBidIndexListResult;
import com.hummingbird.paas.vo.QueryBidIndexSurveyResult;
import com.hummingbird.paas.vo.QueryBidderListResultVO;
import com.hummingbird.paas.vo.QueryCertificateListResultBodyVO;
import com.hummingbird.paas.vo.QueryCertificateListResultVO;
import com.hummingbird.paas.vo.QueryDateRequirementInfoBodyVOResult;
import com.hummingbird.paas.vo.QueryIndexBidListResultVO;
import com.hummingbird.paas.vo.QueryIndexObjectListResult;
import com.hummingbird.paas.vo.QueryObjectBaseInfoBodyVOResult;
import com.hummingbird.paas.vo.QueryObjectBodyVO;
import com.hummingbird.paas.vo.QueryObjectBondInfoResult;
import com.hummingbird.paas.vo.QueryObjectCertificationInfoResult;
import com.hummingbird.paas.vo.QueryObjectConstructionInfoResult;
import com.hummingbird.paas.vo.QueryObjectMethodInfoResult;
import com.hummingbird.paas.vo.QueryObjectProjectInfoResult;
import com.hummingbird.paas.vo.SaveAnswerMethodInfoBodyVO;
import com.hummingbird.paas.vo.SaveBidEvaluationTypeInfoBodyVO;
import com.hummingbird.paas.vo.SaveBidFileTypeInfo;
import com.hummingbird.paas.vo.SaveDateRequirementInfoBodyVO;
import com.hummingbird.paas.vo.SaveObjectBaseInfo;
import com.hummingbird.paas.vo.SaveObjectBondInfo;
import com.hummingbird.paas.vo.SaveObjectCertificationInfo;
import com.hummingbird.paas.vo.SaveObjectConstructionInfo;
import com.hummingbird.paas.vo.SaveObjectMethodInfo;
import com.hummingbird.paas.vo.SaveObjectProjectInfoBodyVO;
import com.hummingbird.paas.vo.SaveObjectProjectInfoBodyVOResult;
import com.hummingbird.paas.vo.SaveProjectRequirementInfoBodyVO;
import com.hummingbird.paas.vo.TenderMyBuildingObjectVO;
import com.hummingbird.paas.vo.TenderMyEndedObjectVO;
import com.hummingbird.paas.vo.TenderMyObjectBidReturnVO;
import com.hummingbird.paas.vo.TenderObjectListReturnVO;
import com.hummingbird.paas.vo.UserInformationAuditBodyVO;
=======
>>>>>>> 768ccc76ca944006747e0a0f63b99a94cc8a85df
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
				uidr.setUserName(user.getNickName());
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
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, value = "txManager")
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


	@Override
	public void auditUserInformation(UserInformationAuditBodyVO body)
			throws BusinessException {
					 if (log.isDebugEnabled()) {
						log.debug("审核用户发布的信息接口开始");
					 }
		              //数据校验
		              String status = body.getAuditStatus();
		              Integer informationId = body.getInformationId();
		              ValidateUtil.assertNull(status, "审核状态");
		              ValidateUtil.assertNull(informationId, "发布信息ID");
		              if(status != null && !"OK#".equals(status) && !"FLS".equals(status)){
						  throw new BusinessException(242400,"审核状态不正确,状态必须是OK#或者FLS");
		              }
		              //判断当前操作者是否有审核权限
		        	  
		        	  //判断要审核的信息是否存在
		        	   UserInformation userInfo=uiDao.selectByPrimaryKey(informationId);
					   if(userInfo == null){
							throw new BusinessException(10111,"不存在该发布信息");
					   }
					   //要审核的状态和信息目前的状态不相同的时候才进行更新操作
					   if(!status.equals(userInfo.getAuditStatus())){
						   UserInformation audit = new UserInformation();
							audit.setId(userInfo.getId());
							audit.setAuditStatus(status);
							uiDao.updateByPrimaryKeySelective(audit);
					   }
					   if (log.isDebugEnabled()) {
							log.debug("审核用户发布的信息接口完成");
					   }
	}

}