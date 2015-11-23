package com.hummingbird.paas.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hummingbird.common.face.Pagingnation;
import com.hummingbird.paas.vo.SaveMakeMatchBidderBondBodyVO;
import com.hummingbird.paas.service.BidService;
import com.hummingbird.common.exception.BusinessException;
import com.hummingbird.paas.vo.SaveMakeMatchBidderBondBodyVOResult;

/**
 * @author 
 * @date 2015-11-15
 * @version 1.0
 *  service接口实现
 */
@Service
public class BidServiceImpl  implements BidService{

	org.apache.commons.logging.Log log = org.apache.commons.logging.LogFactory.getLog(this.getClass());
	
	@Autowired
	BidMapper dao;

			/**
	 * 提交撮合投标保证金信息接口
	 * @param appId 应用id
	 * @param body 参数
	 * @return 
	 * @throws BusinessException 
	 */
	 @Transactional(propagation=Propagation.REQUIRED,rollbackFor=Exception.class,value="txManager")
	public void saveMakeMatchBidderBond(String appId,SaveMakeMatchBidderBondBodyVO body) throws BusinessException{
		if(log.isDebugEnabled()){
				log.debug("提交撮合投标保证金信息接口开始");
		}
		
		if(log.isDebugEnabled()){
				log.debug("提交撮合投标保证金信息接口完成");
		}
	}
		
		
		
}