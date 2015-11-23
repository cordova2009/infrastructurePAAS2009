package com.hummingbird.paas.services;

import java.util.Date;
import java.util.List;

import com.hummingbird.common.exception.BusinessException;
import com.hummingbird.common.face.Pagingnation;
import com.hummingbird.paas.entity.Token;
import com.hummingbird.paas.vo.BidderBankInfo;
import com.hummingbird.paas.vo.BidderBaseInfo;
import com.hummingbird.paas.vo.BidderEqInfo;
import com.hummingbird.paas.vo.BidderLegalPerson;
import com.hummingbird.paas.vo.BidderRegisteredInfo;

/**
 * 
 * */
public interface MyBidderService {
	
	/**
	* 查询我的招标人认证信息接口
	* @return 
	* @throws BusinessException 
	*/
	public Boolean getAuthInfo(Token token) throws BusinessException; 
	/**
	* 查询保存的招标人基本信息接口
	* @return 
	* @throws BusinessException 
	*/
	public BidderBaseInfo getBaseInfo_apply(Token token) throws BusinessException; 
	/**
	 * 保存招标人基本信息接口
	 * 
	 * @param appId
	 *            应用id
	 * @param body
	 *            参数
	 * @param userId
	 * @return 招标编号
	 * @throws BusinessException
	 */
	public int saveBaseInfo_apply(String appId, BidderBaseInfo body,Token token) throws BusinessException;

	/**
	* 查询保存的招标人法人信息接口
	* @return 
	* @throws BusinessException 
	*/
	public BidderLegalPerson getLegalPersonInfo_apply(Token token) throws BusinessException; 
	/**
	 * 保存招标人法人信息接口
	 * 
	 * @param appId
	 *            应用id
	 * @param body
	 *            参数
	 * @param userId
	 * @return 招标编号
	 * @throws BusinessException
	 */
	public int saveLegalPersonInfo_apply(String appId, BidderLegalPerson body,Token token) throws BusinessException;
	/**
	* 查询保存的招标人公司注册信息接口
	* @return 
	* @throws BusinessException 
	*/
	public BidderRegisteredInfo getRegisteredInfo_apply(Token token) throws BusinessException; 
	/**
	 * 保存招标人公司注册信息接口
	 * 
	 * @param appId
	 *            应用id
	 * @param body
	 *            参数
	 * @param userId
	 * @return 招标编号
	 * @throws BusinessException
	 */
	public int saveRegisteredInfo(String appId, BidderRegisteredInfo body,Token token) throws BusinessException;

	/**
	* 查询保存的招标人开户行信息接口
	* @return 
	* @throws BusinessException 
	*/
	public BidderBankInfo getBankInfo_apply(Token token) throws BusinessException; 
	
	/**
	 *保存招标人开户行信息接口
	 * 
	 * @param appId
	 *            应用id
	 * @param body
	 *            参数
	 * @param userId
	 * @return 招标编号
	 * @throws BusinessException
	 */
	public int saveBankInfo(String appId, BidderBankInfo body,Token token) throws BusinessException;
	/**
	 *提交投标人认证申请接口
	 * 
	 * @param appId
	 *            应用id
	 * @param body
	 *            参数
	 * @param userId
	 * @return 招标编号
	 * @throws BusinessException
	 */
	public int applay(String appId,Token token) throws BusinessException;
	
	/**
	* 查询保存的招标人基本信息接口
	* @return 
	* @throws BusinessException 
	*/
	public List<BidderEqInfo> getEnterpriseQualification(Token token) throws BusinessException; 
	
	/**
	 *保存投标人企业资质接口
	 * 
	 * @param appId
	 *            应用id
	 * @param body
	 *            参数
	 * @param userId
	 * @return 招标编号
	 * @throws BusinessException
	 */
	public int saveEnterpriseQualification(String appId, List<BidderEqInfo> body,Token token) throws BusinessException;
	
}
