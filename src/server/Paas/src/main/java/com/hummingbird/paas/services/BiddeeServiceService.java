package com.hummingbird.paas.services;

import java.util.List;

import com.hummingbird.common.exception.BusinessException;
import com.hummingbird.paas.entity.Token;
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

}
