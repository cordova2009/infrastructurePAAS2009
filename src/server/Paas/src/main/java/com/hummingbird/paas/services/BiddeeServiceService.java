package com.hummingbird.paas.services;

import com.hummingbird.common.exception.BusinessException;
import com.hummingbird.paas.entity.Token;
import com.hummingbird.paas.vo.QueryObjectDetailBodyVO;
import com.hummingbird.paas.vo.QueryObjectDetailResultVO;

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

}
