package com.hummingbird.paas.services;

import java.util.List;

import com.hummingbird.common.exception.BusinessException;
import com.hummingbird.common.face.Pagingnation;
import com.hummingbird.paas.entity.Biddee;
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

/**
* 查询未完成招标项目投标文件接口
* @param appId 应用id
* @param body 参数
* @return 
* @throws BusinessException 
*/
public QueryBidFileTypeInfoResult queryBidFileTypeInfo(String appId,QueryObjectBodyVO body,Integer biddeeId) throws BusinessException;

/**
* 保存招标项目投标文件接口
* @param appId 应用id
* @param body 参数
* @return 
* @throws BusinessException 
*/
public void saveBidFileTypeInfo(String appId,SaveBidFileTypeInfo body,Integer biddeeId) throws BusinessException;
	
/**
 * 查询未完成招标方式接口
 * @param appId 应用id
 * @param body 参数
 * @return 
 * @throws BusinessException 
 */
public QueryObjectMethodInfoResult queryObjectMethodInfo(String appId,QueryObjectBodyVO body,Integer biddeeId) throws BusinessException;

/**
 * saveObjectMethodInfo
 * @param appId 应用id
 * @param body 参数
 * @return 
 * @throws BusinessException 
 */
public void saveObjectMethodInfo(String appId,SaveObjectMethodInfo body,Integer biddeeId) throws BusinessException;

/**
* 查询未完成招标答疑方式接口
* @param appId 应用id
* @param body 参数
* @return 
* @throws BusinessException 
*/
public QueryAnswerMethodInfoBodyVOResult queryAnswerMethodInfo(String appId,QueryObjectBodyVO body,Integer biddeeId) throws BusinessException;

/**
* 保存招标答疑方式接口
* @param appId 应用id
* @param body 参数
* @return 
* @throws BusinessException 
*/
public void saveAnswerMethodInfo(String appId,SaveAnswerMethodInfoBodyVO body) throws BusinessException;
/**
* 查询未完成招标时间要求接口
* @param appId 应用id
* @param body 参数
* @return 
* @throws BusinessException 
*/
public QueryDateRequirementInfoBodyVOResult queryDateRequirementInfo(String appId,QueryObjectBodyVO body,Integer biddeeId) throws BusinessException;


/**
* 保存招标时间要求
* @param appId 应用id
* @param body 参数
* @return 
* @throws BusinessException 
*/
public void saveDateRequirementInfo(String appId,SaveDateRequirementInfoBodyVO body) throws BusinessException;
/**
* 查询未完成招标评标方式接口
* @param appId 应用id
* @param body 参数
* @return 
* @throws BusinessException 
*/
public QueryBidEvaluationTypeInfoBodyVOResult queryBidEvaluationTypeInfo(String appId,QueryObjectBodyVO body,Integer biddeeId) throws BusinessException;

/**
 * 保存招标评标方式接口
 * @param appId 应用id
 * @param body 参数
 * @return 
 * @throws BusinessException 
 */
public void saveBidEvaluationTypeInfo(String appId,SaveBidEvaluationTypeInfoBodyVO body) throws BusinessException;

/**
* 发布标的接口
* @param appId 应用id
* @param body 参数
* @return 
* @throws BusinessException 
*/
public void submitObject(String appId,QueryObjectBodyVO body,Integer biddeeId) throws BusinessException;


/**
* 取得我的招标项目列表
* @param appId 应用id
* @param body 参数
* @return 
* @throws BusinessException 
*/
public List<MyTenderObjectListVO> getTenderObjectList(Integer  user_id,Pagingnation page) throws BusinessException;

/**
* 查询我的施工项目列表接口
* @param appId 应用id
* @param body 参数
* @return 
* @throws BusinessException 
*/
public List<TenderMyBuildingObjectVO> getTenderBuildingObjectList(Integer  user_id,Pagingnation page) throws BusinessException;

/**
* 查询我的已结束项目列表接口
* @param appId 应用id
* @param body 参数
* @return 
* @throws BusinessException 
*/
public List<TenderMyEndedObjectVO> getTenderEndedObjectList(Integer  user_id,Pagingnation page) throws BusinessException;

/**
* 查询招标项目列表接口
* @param appId 应用id
* @param body 参数
* @return 
* @throws BusinessException 
*/
public List<TenderObjectListReturnVO> getTenderObjectList(String[] keywords,Pagingnation page) throws BusinessException;


/**
* 查询首页招标项目列表接口
* @param appId 应用id
* @param body 参数
* @return 
* @throws BusinessException 
*/
//public List<QueryIndexObjectListResult> getIndexObjectList(Pagingnation page) throws BusinessException;
public List<QueryIndexObjectListResult> getIndexObjectList() throws BusinessException;
/**
* 查询首页中标结果概况接口
* @param appId 应用id
* @param body 参数
* @return 
* @throws BusinessException 
*/
public QueryBidIndexSurveyResult getBidIndexSurvey() throws BusinessException;
/**
* 查询首页中标结果列表接口
* @param appId 应用id
* @param body 参数
* @return 
* @throws BusinessException 
*/
public List<QueryBidIndexListResult> getBidIndexList(Pagingnation page,String projectName,Integer publishTime) throws BusinessException;

/**
* 查询首页中标结果概况接口
* @param appId 应用id
* @param body 参数
* @return 
* @throws BusinessException 
*/
//public QueryBidIndexSurveyResult getBidIndexSurvey() throws BusinessException;

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
* 查询首页投标人推荐列表接口
*
* @return 
* @throws BusinessException 
*/
public List<QueryIndexBidListResultVO> queryIndexBidList(Integer pageIndex,Integer pageSize) throws BusinessException; 



}
