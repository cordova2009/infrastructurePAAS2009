package com.hummingbird.paas.services;

import java.util.List;

import com.hummingbird.common.exception.BusinessException;
import com.hummingbird.common.face.Pagingnation;
import com.hummingbird.paas.entity.Biddee;
import com.hummingbird.paas.vo.MyObjectTenderSurveyBodyVO;
import com.hummingbird.paas.vo.MyObjectTenderSurveyBodyVOResult;
import com.hummingbird.paas.vo.QueryObjectBaseInfoBodyVOResult;
import com.hummingbird.paas.vo.QueryObjectBodyVO;
import com.hummingbird.paas.vo.QueryObjectBondInfoResult;
import com.hummingbird.paas.vo.QueryObjectCertificationInfoResult;
import com.hummingbird.paas.vo.QueryObjectConstructionInfoResult;
import com.hummingbird.paas.vo.QueryObjectProjectInfoResult;
import com.hummingbird.paas.vo.SaveObjectBaseInfo;
import com.hummingbird.paas.vo.SaveObjectBondInfo;
import com.hummingbird.paas.vo.SaveObjectCertificationInfo;
import com.hummingbird.paas.vo.SaveObjectConstructionInfo;
import com.hummingbird.paas.vo.SaveObjectProjectInfoBodyVO;
import com.hummingbird.paas.vo.SaveObjectProjectInfoBodyVOResult;
import com.hummingbird.paas.vo.SaveProjectRequirementInfoBodyVO;
import com.hummingbird.paas.vo.TenderMyObjectBidReturnVO;

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
	 * @param biddee 
	 * @return
	 * @throws BusinessException
	 */
	public MyObjectTenderSurveyBodyVOResult queryMyObjectTenderSurvey(String appId, MyObjectTenderSurveyBodyVO body, Biddee biddee)
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
	public QueryObjectBaseInfoBodyVOResult queryObjectBaseInfo(String appId, QueryObjectBodyVO body, Biddee biddee)
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
	public String saveObjectBaseInfo(String appId, SaveObjectBaseInfo body,Integer biddeeId) throws BusinessException;

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
	public QueryObjectProjectInfoResult queryObjectProjectInfo(String appId, QueryObjectBodyVO body,Integer biddeeId)
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
	public void saveObjectProjectInfo(String appId,int userId, SaveObjectProjectInfoBodyVO body,Integer biddeeId) throws BusinessException;

	/**
 * 查询未完成招标项目工程要求接口
 * @param appId 应用id
 * @param queryObjectBodyVO 参数
 * @return 
 * @throws BusinessException 
 */
public SaveObjectProjectInfoBodyVOResult queryProjectRequirementInfo(String appId,QueryObjectBodyVO queryObjectBodyVO,Integer biddeeId) throws BusinessException;
	
/**
* 保存招标项目工程施工证明接口
* @param appId 应用id
* @param body 参数
* @return 
* @throws BusinessException 
*/
public void saveProjectRequirementInfo(String appId,SaveProjectRequirementInfoBodyVO body,Integer biddeeId) throws BusinessException;
	
/**
* 查询未完成招标项目工程施工证明接口
* @param appId 应用id
* @param body 参数
* @return 
* @throws BusinessException 
*/
public QueryObjectConstructionInfoResult queryObjectConstructionInfo(String appId,QueryObjectBodyVO body,Integer biddeeId) throws BusinessException;

/**
* 保存招标项目工程施工证明接口
* @param appId 应用id
* @param body 参数
 * @param biddeeId 
* @return 
* @throws BusinessException 
*/
public void saveObjectConstructionInfo(String appId,SaveObjectConstructionInfo body, Integer biddeeId) throws BusinessException;
/**
* 查询未完成招标项目资质要求接口
* @param appId 应用id
* @param body 参数
* @return 
* @throws BusinessException 
*/
public QueryObjectCertificationInfoResult queryObjectCertificationInfo(String appId,QueryObjectBodyVO body, Integer biddeeId) throws BusinessException;


/**
 * 保存招标项目资质要求接口
 * @param appId 应用id
 * @param body 参数
 * @return 
 * @throws BusinessException 
 */
public void saveObjectCertificationInfo(String appId,SaveObjectCertificationInfo body,Integer biddeeId) throws BusinessException;


/**
 * 查询未完成招标项目保证金接口
 * @param appId 应用id
 * @param body 参数
 * @return 
 * @throws BusinessException 
 */
public QueryObjectBondInfoResult queryObjectBondInfo(String appId,QueryObjectBodyVO body,Integer biddeeId) throws BusinessException;
/**
* 保存招标项目保证金接口
* @param appId 应用id
* @param body 参数
* @return 
* @throws BusinessException 
*/
public void saveObjectBondInfo(String appId,SaveObjectBondInfo body,Integer biddeeId) throws BusinessException;
/**
* 查询标项目投标列表列表
* @param appId 应用id
* @param body 参数
* @return 
* @throws BusinessException 
*/
public List<TenderMyObjectBidReturnVO> selectByObjectIdInValid(Integer userId, String objectId, Pagingnation page);

	
}
