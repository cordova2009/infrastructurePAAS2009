package com.hummingbird.paas.services;

import java.util.Date;
import java.util.List;

import com.hummingbird.common.exception.BusinessException;
import com.hummingbird.common.face.Pagingnation;
import com.hummingbird.paas.entity.Announcement;
import com.hummingbird.paas.entity.BiddeeBankAduit;
import com.hummingbird.paas.entity.Token;
import com.hummingbird.paas.vo.BiddeeBankInfo;
import com.hummingbird.paas.vo.BiddeeBaseInfo;
import com.hummingbird.paas.vo.BiddeeLegalPerson;
import com.hummingbird.paas.vo.BiddeeRegisteredInfo;

/**
 * 
 * */
public interface MyBiddeeService {
	/**
	* 查询我的招标人认证信息接口
	* @return 
	* @throws BusinessException 
	*/
	public Boolean getAuthInfo(Token token) throws BusinessException; 
	/**
	* 查询保存的招标人基本信息接口
	* @return 
	* @throws BusinessException 
	*/
	public BiddeeBaseInfo getBaseInfo_apply(Token token) throws BusinessException; 
	/**
	* 查询我的招标人认证信息接口
	* @return 
	* @throws BusinessException 
	*/
	public void saveBaseInfo_apply(Token token) throws BusinessException; 
	/**
	* 查询我的招标人认证信息接口
	* @return 
	* @throws BusinessException 
	*/
	public BiddeeLegalPerson getLegalPersonInfo_apply(Token token) throws BusinessException; 
	/**
	* 查询我的招标人认证信息接口
	* @return 
	* @throws BusinessException 
	*/
	public void saveLegalPersonInfo_apply(Token token) throws BusinessException; 
	/**
	* 查询我的招标人认证信息接口
	* @return 
	* @throws BusinessException 
	*/
	public BiddeeRegisteredInfo getRegisteredInfo_apply(Token token) throws BusinessException; 
	/**
	* 查询我的招标人认证信息接口
	* @return 
	* @throws BusinessException 
	*/
	public void saveRegisteredInfo(Token token) throws BusinessException; 
	/**
	* 查询我的招标人认证信息接口
	* @return 
	* @throws BusinessException 
	*/
	public BiddeeBankInfo getBankInfo_apply(Token token) throws BusinessException; 
	/**
	* 查询我的招标人认证信息接口
	* @return 
	* @throws BusinessException 
	*/
	public void saveBankInfo(Token token) throws BusinessException; 
	
	
}
