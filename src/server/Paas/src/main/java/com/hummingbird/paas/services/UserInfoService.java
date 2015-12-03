package com.hummingbird.paas.services;

import java.util.List;

import com.hummingbird.common.exception.BusinessException;
import com.hummingbird.common.face.Pagingnation;
import com.hummingbird.paas.entity.Biddee;
import com.hummingbird.paas.entity.Token;
import com.hummingbird.paas.vo.MyObjectTenderSurveyBodyVO;
import com.hummingbird.paas.vo.MyObjectTenderSurveyBodyVOResult;
import com.hummingbird.paas.vo.MyTenderObjectListVO;
import com.hummingbird.paas.vo.QueryAnswerMethodInfoBodyVOResult;
import com.hummingbird.paas.vo.QueryBidEvaluationTypeInfoBodyVOResult;
import com.hummingbird.paas.vo.QueryBidFileTypeInfoResult;
import com.hummingbird.paas.vo.QueryBidIndexListResult;
import com.hummingbird.paas.vo.QueryBidIndexSurveyResult;
import com.hummingbird.paas.vo.QueryBidderListResultVO;
import com.hummingbird.paas.vo.QueryCertificateListResultVO;
import com.hummingbird.paas.vo.QueryDateRequirementInfoBodyVOResult;
import com.hummingbird.paas.vo.QueryIndexBidListResultVO;
import com.hummingbird.paas.vo.QueryIndexObjectListResult;
import com.hummingbird.paas.vo.QueryMyLoseObjectListResultVO;
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
import com.hummingbird.paas.vo.UserInformationBodyVO;
import com.hummingbird.paas.vo.UserInformationDetailBodyVO;
import com.hummingbird.paas.vo.UserInformationDetailReturnVO;
import com.hummingbird.paas.vo.UserInformationDetailWithCommentsReturnVO;
import com.hummingbird.paas.vo.UserInformationPageBodyVO;
import com.hummingbird.paas.vo.UserInformationPageReturnVO;
import com.hummingbird.paas.vo.UserInformationReplyBodyVO;

/**
 * @author YJY
 * @date 2015年12月2日19:48:56
 * @version 1.0 service接口
 */
public interface UserInfoService {
	
	/**
	 * 提交用户信息接口
	 * 
	 * @param appId
	 *            应用id
	 * @param body
	 *            参数
	 * @param biddee 
	 * @return
	 * @throws BusinessException
	 */
	public int submitUserInformation(String appId, UserInformationBodyVO body,Token token)
			throws BusinessException;


	/**
	 * 查看我的发布信息详情接口
	 * 
	 * @param appId
	 *            应用id
	 * @param body
	 *            参数
	 * 
	 * @return
	 * @throws BusinessException
	 */
	public UserInformationDetailReturnVO getUserInformationDetail(String appId, UserInformationDetailBodyVO body,Token token)
			throws BusinessException;


	/**
	 * 查看发布信息详情接口
	 * 
	 * @param appId
	 *            应用id
	 * @param body
	 *            参数
	 * 
	 * @return
	 * @throws BusinessException
	 */
	public UserInformationDetailWithCommentsReturnVO getUserInformationDetailWithComments(String appId, UserInformationDetailBodyVO body,Token token)
			throws BusinessException;

	
	/**
	 * 查看发布信息详情接口
	 * 
	 * @param appId
	 *            应用id
	 * @param body
	 *            参数
	 * 
	 * @return
	 * @throws BusinessException
	 */
	public List<UserInformationPageReturnVO> queryUserInformationPage(String appId, UserInformationPageBodyVO body,Token token)
			throws BusinessException;


	/**
	 * 回复用户信息接口
	 * 
	 * @param appId
	 *            应用id
	 * @param body
	 *            参数
	 * 
	 * @return
	 * @throws BusinessException
	 */
	public int replyUserInformation(String appId, UserInformationReplyBodyVO body,Token token)
			throws BusinessException;




}
