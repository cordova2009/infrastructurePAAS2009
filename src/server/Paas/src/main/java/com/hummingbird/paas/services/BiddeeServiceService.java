package com.hummingbird.paas.services;

import java.util.List;

import com.hummingbird.common.exception.BusinessException;
import com.hummingbird.common.face.Pagingnation;
import com.hummingbird.paas.entity.Token;
import com.hummingbird.paas.vo.QueryMyBidObjectListResultVO;
import com.hummingbird.paas.vo.QueryMyBuildingObjectListResultVO;
import com.hummingbird.paas.vo.QueryMyEndedObjectListResultVO;
import com.hummingbird.paas.vo.QueryMyLoseObjectListResultVO;
import com.hummingbird.paas.vo.QueryObjectDetailBodyVO;
import com.hummingbird.paas.vo.QueryObjectDetailResultVO;
import com.hummingbird.paas.vo.QueryObjectListResultVO;

public interface BiddeeServiceService {
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
	* 查询招标公告列表接口接口
	*
	* @return 
	* @throws BusinessException 
	*/
	public List<QueryMyBidObjectListResultVO> queryMyBidObjectList(Integer user_id,Pagingnation page) throws BusinessException; 

//	/**
//	* 查询我的投标中项目列表接口【页面是项目竣工日期？】
//	*
//	* @return 
//	* @throws BusinessException 
//	*/
//	public List<QueryMyBuildingObjectListResultVO> queryMyBuildingObjectList(Integer user_id,Integer pageIndex,Integer pageSize) throws BusinessException; 

	/**
	* 查询我的已结束项目列表接口
	*
	* @return 
	* @throws BusinessException 
	*/
	public List<QueryMyEndedObjectListResultVO> queryMyEndedObjectList(Integer user_id,Integer pageIndex,Integer pageSize) throws BusinessException; 
	/**
	* 查询我的未中标项目接口
	*
	* @return 
	* @throws BusinessException 
	*/
	public List<QueryMyLoseObjectListResultVO> queryMyLoseObjectList(Integer user_id,Integer pageIndex,Integer pageSize) throws BusinessException;
	
	/**
	 * 查询我的实施中的工程
	 * @param userId
	 * @param pagingnation
	 * @return
	 */
	public List<QueryMyBuildingObjectListResultVO> queryMyBuildingObjectPage(Integer userId, Pagingnation pagingnation); 


}
