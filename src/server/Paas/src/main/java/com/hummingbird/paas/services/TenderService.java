package com.hummingbird.paas.services;

import java.util.List;

import com.hummingbird.common.exception.BusinessException;
import com.hummingbird.paas.entity.Token;
import com.hummingbird.paas.vo.MyObjectTenderSurveyBodyVO;
import com.hummingbird.paas.vo.MyObjectTenderSurveyBodyVOResult;
import com.hummingbird.paas.vo.QueryBidderListResultVO;
import com.hummingbird.paas.vo.QueryCertificateListResultVO;
import com.hummingbird.paas.vo.QueryObjectBaseInfoBodyVOResult;
import com.hummingbird.paas.vo.QueryObjectBodyVO;
import com.hummingbird.paas.vo.QueryObjectListResultVO;
import com.hummingbird.paas.vo.QueryObjectProjectInfoResult;
import com.hummingbird.paas.vo.SaveObjectBaseInfo;
import com.hummingbird.paas.vo.SaveObjectProjectInfoBodyVO;
import com.hummingbird.paas.vo.SaveObjectProjectInfoBodyVOResult;
import com.hummingbird.paas.vo.SaveProjectRequirementInfoBodyVO;

/**
 * @author
 * @date 2015-11-08
 * @version 1.0 service接口
 */
public interface TenderService {

	/**
	 * 我的招标评标概况接口
	 * 
	 * @param appId
	 *            应用id
	 * @param body
	 *            参数
	 * @return
	 * @throws BusinessException
	 */
	public MyObjectTenderSurveyBodyVOResult queryMyObjectTenderSurvey(String appId, MyObjectTenderSurveyBodyVO body)
			throws BusinessException;

	/**
	 * 查询未完成招标项目基础信息接口
	 * 
	 * @param appId
	 *            应用id
	 * @param body
	 *            参数
	 * @return
	 * @throws BusinessException
	 */
	public QueryObjectBaseInfoBodyVOResult queryObjectBaseInfo(String appId, QueryObjectBodyVO body)
			throws BusinessException;

	/**
	 * 保存招标项目基础信息接口
	 * 
	 * @param appId
	 *            应用id
	 * @param body
	 *            参数
	 * @param userId
	 * @return 招标编号
	 * @throws BusinessException
	 */
	public String saveObjectBaseInfo(String appId, SaveObjectBaseInfo body, Integer userId) throws BusinessException;

	/**
	 * 查询未完成招标项目工程信息接口
	 * 
	 * @param appId
	 *            应用id
	 * @param body
	 *            参数
	 * @return
	 * @throws BusinessException
	 */
	public QueryObjectProjectInfoResult queryObjectProjectInfo(String appId, QueryObjectBodyVO body)
			throws BusinessException;

	/**
	 * 保存招标项目工程信息接口
	 * 
	 * @param appId
	 *            应用id
	 * @param body
	 *            参数
	 * @return
	 * @throws BusinessException
	 */
	public void saveObjectProjectInfo(String appId,int userId, SaveObjectProjectInfoBodyVO body) throws BusinessException;

	/**
 * 查询未完成招标项目工程要求接口
 * @param appId 应用id
 * @param queryObjectBodyVO 参数
 * @return 
 * @throws BusinessException 
 */
public SaveObjectProjectInfoBodyVOResult queryProjectRequirementInfo(String appId,QueryObjectBodyVO queryObjectBodyVO) throws BusinessException;
	
/**
* 保存招标项目工程施工证明接口
* @param appId 应用id
* @param body 参数
* @return 
* @throws BusinessException 
*/
public void saveProjectRequirementInfo(String appId,SaveProjectRequirementInfoBodyVO body) throws BusinessException;
	
/**
* 查询未完成招标项目工程施工证明接口
* @param appId 应用id
* @param body 参数
* @return 
* @throws BusinessException 
*/
public void queryObjectConstructionInfo(String appId,QueryObjectBodyVO body) throws BusinessException;

/**
* 查询资质证书类型列表接口
*
* @return 
* @throws BusinessException 
*/
public List<QueryCertificateListResultVO> queryCertificateList() throws BusinessException;

/**
* 查询投标方列表接口
*
* @return 
* @throws BusinessException 
*/
public List<QueryBidderListResultVO> queryBidderList() throws BusinessException;
/**
* 查询招标公告列表接口接口
*
* @return 
* @throws BusinessException 
*/
public List<QueryObjectListResultVO> queryObjectList(Integer pageIndex,Integer pageSize) throws BusinessException; 

	
}
