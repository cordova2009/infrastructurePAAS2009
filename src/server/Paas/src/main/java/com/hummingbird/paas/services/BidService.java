package com.hummingbird.paas.services;

import java.util.List;
import java.util.Map;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.hummingbird.common.exception.BusinessException;
import com.hummingbird.common.exception.DataInvalidException;
import com.hummingbird.common.face.Pagingnation;
import com.hummingbird.paas.entity.BidRecord;
import com.hummingbird.paas.entity.Bidder;
import com.hummingbird.paas.entity.Token;
import com.hummingbird.paas.entity.User;
import com.hummingbird.paas.vo.AbstractBidFileTypeInfo;
import com.hummingbird.paas.vo.EvaluateBiddeeBodyVO;
import com.hummingbird.paas.vo.FreezeBondReturnVO;
import com.hummingbird.paas.vo.QueryBidBodyVO;
import com.hummingbird.paas.vo.QueryBidRequirementInfoBodyVOResult;
import com.hummingbird.paas.vo.QueryBidderBondBodyVOResult;
import com.hummingbird.paas.vo.QueryBidderCompanyInfoBodyVOResult;
import com.hummingbird.paas.vo.QueryBusinessStandardInfoBodyVOResult;
import com.hummingbird.paas.vo.QueryMakeMatchBidderBondBodyVOResult;
import com.hummingbird.paas.vo.QueryObjectBodyVO;
import com.hummingbird.paas.vo.QueryObjectCertificationInfoResult;
import com.hummingbird.paas.vo.QueryObjectDetailBodyVO;
import com.hummingbird.paas.vo.QueryObjectDetailResultVO;
import com.hummingbird.paas.vo.QueryObjectListResultVO;
import com.hummingbird.paas.vo.QueryTechnicalStandardInfoBodyVOResult;
import com.hummingbird.paas.vo.SaveBidRequirementInfoBodyVO;
import com.hummingbird.paas.vo.SaveBidderBondBodyVO;
import com.hummingbird.paas.vo.SaveBusinessStandardInfoBodyVO;
import com.hummingbird.paas.vo.SaveMakeMatchBidderBondBodyVO;
import com.hummingbird.paas.vo.SaveTechnicalStandardInfoBodyVO;
import com.hummingbird.paas.vo.SubmitBidBodyVO;
import com.hummingbird.paas.vo.UnfreezeBondVO;

/**
 * @author
 * @date 2015-11-13
 * @version 1.0 service接口
 */
public interface BidService {

	/**
	 * 查询未完成的投标资格审查信息接口
	 * 
	 * @param appId
	 *            应用id
	 * @param body
	 *            参数
	 * @param bidderId
	 * @return
	 * @throws BusinessException
	 */
	public QueryBidRequirementInfoBodyVOResult queryBidRequirementInfo(String appId, QueryBidBodyVO body,
			Integer bidderId) throws BusinessException;

	/**
	 * 保存投标资格审查信息接口
	 * 
	 * @param appId
	 *            应用id
	 * @param body
	 *            参数
	 * @return
	 * @throws BusinessException
	 */
	public BidRecord saveBidRequirementInfo(String appId, SaveBidRequirementInfoBodyVO body, Integer bidderId)
			throws BusinessException;

	/**
	 * 查询未完成投标的商务标信息接口
	 * 
	 * @param appId
	 *            应用id
	 * @param body
	 *            参数
	 * @return
	 * @throws BusinessException
	 */
	public QueryBusinessStandardInfoBodyVOResult queryBusinessStandardInfo(String appId, QueryBidBodyVO body,
			Integer bidderId) throws BusinessException;

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
	 * 
	 * @param appId
	 *            应用id
	 * @param body
	 *            参数
	 * @return
	 * @throws BusinessException
	 */
	public QueryTechnicalStandardInfoBodyVOResult queryTechnicalStandardInfo(String appId, QueryBidBodyVO body,
			Integer bidderId) throws BusinessException;

	/**
	 * 保存投标的技术标信息接口
	 * 
	 * @param appId
	 *            应用id
	 * @param body
	 *            参数
	 * @return
	 * @throws BusinessException
	 */
	public void saveTechnicalStandardInfo(String appId, SaveTechnicalStandardInfoBodyVO body, Integer bidderId)
			throws BusinessException;

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
	public QueryBidderBondBodyVOResult queryBidderBond(String appId, QueryBidBodyVO body, Integer bidderId)
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
	public void saveBidderBond(String appId, SaveBidderBondBodyVO body, Integer bidderId) throws BusinessException;

	/**
	 * 查询投标人资质证书接口
	 * @param body 
	 * @param bidderId
	 * @return
	 * @throws BusinessException
	 */
	public Map queryBidderCertificationInfo(QueryBidBodyVO body, Integer bidderId) throws BusinessException;


	/**
	 * 查询招标公告列表接口接口
	 *
	 * @return
	 * @throws BusinessException
	 */
	public List<QueryObjectListResultVO> queryObjectList(Pagingnation pagingnation,Integer userId) throws BusinessException ;
	/**
	 * 查询撮合投标保证金接口
	 * 
	 * @param appId
	 *            应用id
	 * @param body
	 *            参数
	 * @return
	 * @throws BusinessException
	 */
	public QueryMakeMatchBidderBondBodyVOResult queryMakeMatchBidderBond(String appId, QueryBidBodyVO body,
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
	public void saveMakeMatchBidderBond(String appId, SaveMakeMatchBidderBondBodyVO body, Bidder bidder)
			throws BusinessException;

	public FreezeBondReturnVO unfreezeMakeMatchBidderBond(UnfreezeBondVO body, Bidder bidder, String method)
			throws BusinessException;

	/**
	 * 提交投标接口
	 * 
	 * @param appId
	 *            应用id
	 * @param submitBidBodyVO
	 *            参数
	 * @return
	 * @throws BusinessException
	 */
	public void submitBid(String appId, SubmitBidBodyVO submitBidBodyVO, Bidder bidder) throws BusinessException;

	/**
		 * 查询用户是否具有投标的资质
		 * 
		 * @param queryobject
		 * @param userId
		 * @return
		 * @throws BusinessException
		 */
	void hadQualify2bid(QueryObjectBodyVO queryobject, Integer userId) throws BusinessException;

	/**
	 * 查询标的详情接口 
	 * @param appId
	 * @param body
	 * @param id
	 * @return
	 * @throws BusinessException 
	 */
	public QueryObjectDetailResultVO queryObjectDetail(String appId, QueryBidBodyVO body, Integer bidderId) throws BusinessException;

	/**
	 * 查询投标要求基础信息接口
	 * 
	 * @param appId
	 *            应用id
	 * @param body
	 *            参数
	 * @return
	 * @return
	 * @throws BusinessException
	 */
	public QueryObjectCertificationInfoResult queryObjectRequirementInfo(String appId, QueryBidBodyVO body
			) throws BusinessException;
	
	/**
	 * 查询投标人基础信息接口
	 * 
	 * @param appId
	 *            应用id
	 * @param body
	 *            参数
	 * @return
	 * @throws BusinessException
	 */
	public QueryBidderCompanyInfoBodyVOResult queryBidderCompanyInfo(String appId, QueryBidBodyVO body,
			Bidder bidder) throws BusinessException;

	/**
	 * 投标方给招标方评价接口
	 * @param appId
	 * @param body
	 * @param bidder
	 * @throws BusinessException 
	 */
	public void evaluateBiddee(String appId, EvaluateBiddeeBodyVO body, Bidder bidder) throws BusinessException;
	/**
	 * 校验标签组
	 * @param appId
	 * @param body
	 * @param bidder
	 * @throws BusinessException 
	 */
	public void ValidEvaluateBiddee(String appId, EvaluateBiddeeBodyVO body, Bidder bidder) throws BusinessException;

	/**
	 * 查询未完成的投标信息(投标附件)
	 * @param appId
	 * @param body
	 * @param id
	 * @return
	 * @throws DataInvalidException 
	 */
	public SubmitBidBodyVO queryBidSubmit(String appId, QueryBidBodyVO body, Integer bidderId) throws DataInvalidException;

	/**
	 * 查询未完成招标项目投标文件
	 * @param appId
	 * @param body
	 * @return
	 * @throws DataInvalidException 
	 */
	public AbstractBidFileTypeInfo queryBidFileTypeInfo(String appId, QueryObjectBodyVO body) throws DataInvalidException;
	
}