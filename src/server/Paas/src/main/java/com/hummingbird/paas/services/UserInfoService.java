package com.hummingbird.paas.services;

import java.util.List;

import com.hummingbird.common.exception.BusinessException;
import com.hummingbird.common.face.Pagingnation;
import com.hummingbird.paas.entity.Token;
import com.hummingbird.paas.vo.BaseUserInformationPageBodyVO;
import com.hummingbird.paas.vo.UserInformationAuditBodyVO;
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
	public UserInformationDetailWithCommentsReturnVO getUserInformationDetailWithComments(String appId, UserInformationDetailBodyVO body)
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
	public int queryUserInformationPageTotal(String appId, UserInformationPageBodyVO body,Token token)
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

	/**
	 * 审核用户发布的信息
	 * @param body
	 *            参数
	 * 
	 * @return
	 * @throws BusinessException
	 */
	public void auditUserInformation(UserInformationAuditBodyVO body)
			throws BusinessException;


	/**
	 * 查询用户信息列表
	 * @param appId
	 * @param body
	 * @param pagingnation
	 * @return
	 */
	public List<UserInformationPageReturnVO> queryUserInformationPage(String appId, BaseUserInformationPageBodyVO body,
			Pagingnation pagingnation,Token token);


}
