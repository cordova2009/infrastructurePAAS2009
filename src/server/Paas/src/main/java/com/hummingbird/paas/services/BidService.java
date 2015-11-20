package com.hummingbird.paas.services;

import java.util.List;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.hummingbird.common.exception.BusinessException;
import com.hummingbird.paas.entity.BidRecord;
import com.hummingbird.paas.entity.Bidder;
import com.hummingbird.paas.entity.Token;
import com.hummingbird.paas.entity.User;
import com.hummingbird.paas.vo.FreezeBondReturnVO;
import com.hummingbird.paas.vo.QueryBidBodyVO;
import com.hummingbird.paas.vo.QueryBidRequirementInfoBodyVOResult;
import com.hummingbird.paas.vo.QueryBidderBondBodyVOResult;
import com.hummingbird.paas.vo.QueryBusinessStandardInfoBodyVOResult;
import com.hummingbird.paas.vo.QueryMakeMatchBidderBondBodyVOResult;
import com.hummingbird.paas.vo.QueryObjectDetailBodyVO;
import com.hummingbird.paas.vo.QueryObjectDetailResultVO;
import com.hummingbird.paas.vo.QueryObjectListResultVO;
import com.hummingbird.paas.vo.QueryTechnicalStandardInfoBodyVOResult;
import com.hummingbird.paas.vo.SaveBidRequirementInfoBodyVO;
import com.hummingbird.paas.vo.SaveBidderBondBodyVO;
import com.hummingbird.paas.vo.SaveBusinessStandardInfoBodyVO;
import com.hummingbird.paas.vo.SaveMakeMatchBidderBondBodyVO;
import com.hummingbird.paas.vo.SaveTechnicalStandardInfoBodyVO;
import com.hummingbird.paas.vo.UnfreezeBondVO;
/**
 * @author 
 * @date 2015-11-13
 * @version 1.0
 *  service接口
 */
public interface BidService  {

		/**
	 * 查询未完成的投标资格审查信息接口
	 * @param appId 应用id
	 * @param body 参数
		 * @param bidderId 
	 * @return 
	 * @throws BusinessException 
	 */
	public QueryBidRequirementInfoBodyVOResult queryBidRequirementInfo(String appId,QueryBidBodyVO body, Integer bidderId) throws BusinessException;
		
	/**
	 * 保存投标资格审查信息接口
	 * @param appId 应用id
	 * @param body 参数
	 * @return 
	 * @throws BusinessException 
	 */
	public BidRecord saveBidRequirementInfo(String appId,SaveBidRequirementInfoBodyVO body, Integer bidderId) throws BusinessException;
	/**
 * 查询未完成投标的商务标信息接口
 * @param appId 应用id
 * @param body 参数
 * @return 
 * @throws BusinessException 
 */
public QueryBusinessStandardInfoBodyVOResult queryBusinessStandardInfo(String appId,QueryBidBodyVO body,Integer bidderId) throws BusinessException;

/**
 * 保存投标的商务标信息接口
 * 
 * @param appId
 *            应用id
 * @param body
 *            参数
 * @return
 * @throws BusinessException
 */
public void saveBusinessStandardInfo(String appId, SaveBusinessStandardInfoBodyVO body, Integer bidderId)
		throws BusinessException;
/**
* 查询未完成投标的技术标信息接口
* @param appId 应用id
* @param body 参数
* @return 
* @throws BusinessException 
*/
public QueryTechnicalStandardInfoBodyVOResult queryTechnicalStandardInfo(String appId,QueryBidBodyVO body,Integer bidderId) throws BusinessException;
	
/**
* 保存投标的技术标信息接口
* @param appId 应用id
* @param body 参数
* @return 
* @throws BusinessException 
*/
public void saveTechnicalStandardInfo(String appId,SaveTechnicalStandardInfoBodyVO body,Integer bidderId) throws BusinessException;
/**
 * 查询投标保证金信息接口
 * 
 * @param appId
 *            应用id
 * @param body
 *            参数
 * @return
 * @throws BusinessException
 */
public QueryBidderBondBodyVOResult queryBidderBond(String appId, QueryBidBodyVO body,
		Integer bidderId)
		throws BusinessException;

/**
 * 保存投标保证金接口
 * 
 * @param appId
 *            应用id
 * @param body
 *            参数
 * @return
 * @throws BusinessException
 */
public void saveBidderBond(String appId, SaveBidderBondBodyVO body,Integer bidderId) throws BusinessException ;

/**
* 询投标人资质证书接口
* @return 
* @throws BusinessException 
*/
public Boolean queryTender(Token token) throws BusinessException; 
/**
* 询投标人资质证书接口
* @return 
* @throws BusinessException 
*/
public QueryObjectDetailResultVO queryObjectDetail(QueryObjectDetailBodyVO body) throws BusinessException; 
/**
* 查询招标公告列表接口接口
*
* @return 
* @throws BusinessException 
*/
public List<QueryObjectListResultVO> queryObjectList(Integer pageIndex,Integer pageSize) throws BusinessException; 
/**
* 查询撮合投标保证金接口
* @param appId 应用id
* @param body 参数
* @return 
* @throws BusinessException 
*/
public QueryMakeMatchBidderBondBodyVOResult queryMakeMatchBidderBond(String appId,QueryBidBodyVO body,
	Integer bidderId) throws BusinessException;
	
/**
 * 提交撮合投标保证金信息接口
 * 
 * @param appId
 *            应用id
 * @param body
 *            参数
 * @return
 * @throws BusinessException
 */
public void saveMakeMatchBidderBond(String appId, SaveMakeMatchBidderBondBodyVO body,Bidder bidder) throws BusinessException
;

	public FreezeBondReturnVO unfreezeMakeMatchBidderBond(UnfreezeBondVO body, Bidder bidder,String method)throws BusinessException;

/**
 * 提交投标接口
 * 
 * @param appId
 *            应用id
 * @param body
 *            参数
 * @return
 * @throws BusinessException
 */
public void submitBid(String appId, QueryBidBodyVO body, Bidder bidder) throws BusinessException 
;

}