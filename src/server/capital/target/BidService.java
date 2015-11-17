package com.hummingbird.paas.service;

import java.util.List;

import com.hummingbird.common.face.Pagingnation;
import com.hummingbird.paas.vo.SaveMakeMatchBidderBondBodyVO;
import com.hummingbird.common.exception.BusinessException;
import com.hummingbird.paas.vo.SaveMakeMatchBidderBondBodyVOResult;


/**
 * @author 
 * @date 2015-11-15
 * @version 1.0
 *  service接口
 */
public interface BidService  {

			/**
	 * 提交撮合投标保证金信息接口
	 * @param appId 应用id
	 * @param body 参数
	 * @return 
	 * @throws BusinessException 
	 */
	public void saveMakeMatchBidderBond(String appId,SaveMakeMatchBidderBondBodyVO body) throws BusinessException;
	
		
		
	}