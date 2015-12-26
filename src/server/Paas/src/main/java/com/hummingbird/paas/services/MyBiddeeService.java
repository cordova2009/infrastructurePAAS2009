package com.hummingbird.paas.services;

import com.hummingbird.common.exception.BusinessException;
import com.hummingbird.paas.entity.Token;
import com.hummingbird.paas.vo.BiddeeAuditBodyInfo;
import com.hummingbird.paas.vo.BiddeeBankInfo;
import com.hummingbird.paas.vo.BiddeeBaseInfo;
import com.hummingbird.paas.vo.BiddeeLegalPerson;
import com.hummingbird.paas.vo.BiddeeRegisteredInfo;

/**
 * 
 * */
public interface MyBiddeeService {
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
	public BiddeeBaseInfo getBaseInfo_apply(Token token) throws BusinessException; 
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
	public int saveBaseInfo_apply(String appId, BiddeeBaseInfo body,Token token) throws BusinessException;

	/**
	* 查询保存的招标人法人信息接口
	* @return 
	* @throws BusinessException 
	*/
	public BiddeeLegalPerson getLegalPersonInfo_apply(Token token) throws BusinessException; 
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
	public int saveLegalPersonInfo_apply(String appId, BiddeeLegalPerson body,Token token) throws BusinessException;
	/**
	* 查询保存的招标人公司注册信息接口
	* @return 
	* @throws BusinessException 
	*/
	public BiddeeRegisteredInfo getRegisteredInfo_apply(Token token) throws BusinessException; 
	
	/**
	* 查询保存的招标人公司注册信息接口
	* @return 
	* @throws BusinessException 
	*/
	public BiddeeRegisteredInfo getRegisteredInfo(Token token) throws BusinessException; 
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
	public int saveRegisteredInfo(String appId, BiddeeRegisteredInfo body,Token token) throws BusinessException;

	/**
	* 查询保存的招标人开户行信息接口
	* @return 
	* @throws BusinessException 
	*/
	public BiddeeBankInfo getBankInfo_apply(Token token) throws BusinessException; 
	
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
	public int saveBankInfo(String appId, BiddeeBankInfo body,Token token) throws BusinessException;
	/**
	 *提交投标人认证申请接口
	 * 
	 * @param appId
	 *            应用id
	 * @param body
	 *            参数
	 * @param token
	 * @return 
	 * @throws BusinessException
	 */
	public int applay(String appId,Token token) throws BusinessException;
	/**
	 *提交招标人认证申请审核结果。
	 * 
	 * @param appId
	 *            应用id
	 * @param body
	 *            参数
	 * @param biddeeId
	 * @return 
	 * @throws BusinessException
	 */
	public  String checkApplication(String appId, BiddeeAuditBodyInfo body,Integer biddeeId) throws BusinessException;
	
	
}
