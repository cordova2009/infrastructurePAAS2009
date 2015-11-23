/**
 * 
 */
package com.hummingbird.usercenter.services.impl;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hummingbird.common.exception.AuthenticationException;
import com.hummingbird.common.exception.SignatureException;
import com.hummingbird.common.exception.ValidateException;
import com.hummingbird.commonbiz.service.IAuthenticationService;
import com.hummingbird.commonbiz.vo.AppMobileDecidable;
import com.hummingbird.commonbiz.vo.AppVO;
import com.hummingbird.commonbiz.vo.Decidable;
import com.hummingbird.usercenter.entity.Appinfo;
import com.hummingbird.usercenter.mapper.AppinfoMapper;
import com.hummingbird.usercenter.mapper.UserTokenMapper;

/**
 * 验证service
 * 
 * @author huangjiej_2 2014年10月16日 上午7:55:54
 */
@Service
public class AuthenticationServiceImpl implements IAuthenticationService {

	protected Log log = LogFactory.getLog(getClass());

	// @Autowired(required = true)
	// private SellerMapper sellerMapper;

	@Autowired(required = true)
	private AppinfoMapper appInfoMapper;
	@Autowired(required = true)
	private UserTokenMapper tokenMapper;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.pay2b.service.IAuthenticationService#validateToken(com.pay2b.vo.Decidable
	 * )
	 */
	@Override
	public Object validateAuth(Decidable authObj)
			throws AuthenticationException {

		Map map = new HashMap();
		// 用户，根据appid进行查询
		if (authObj instanceof AppVO) {
			AppVO baseuserdecide = (AppVO) authObj;
			String appid= baseuserdecide.getAppId();
			Appinfo info = appInfoMapper.selectByPrimaryKey(appid);
			if (info == null) {
				log.error("根据appid:" + appid + "无法在系统中查询到相关数据");
				//throw ValidateException.ERROR_EXISTING_APP_NOT_EXISTS;
				throw new AuthenticationException(ValidateException.ERROR_EXISTING_APP_NOT_EXISTS.getErrcode(),"appId不存在");
			}
			map.put("appKey", info.getAppkey());
		}
		else if (authObj instanceof AppMobileDecidable) {
			AppMobileDecidable baseuserdecide = (AppMobileDecidable) authObj;

			String appid= baseuserdecide.getAppId();
			Appinfo info = appInfoMapper.selectByPrimaryKey(appid);
			if (info == null) {
				log.error("根据appid:" + appid + "无法在系统中查询到相关数据");
				//throw ValidateException.ERROR_EXISTING_APP_NOT_EXISTS;
				throw new AuthenticationException(ValidateException.ERROR_EXISTING_APP_NOT_EXISTS.getErrcode(),"appId不存在");
			}
			map.put("appKey", info.getAppkey());
//			Token to = tokenMapper.selectByToken(baseuserdecide);
//			if (to != null) {
//				map.put("token", to.getToken());
//			}
		} else {
			log.error("认证中无法取得appid和手机号，无法进行认证");
			throw new AuthenticationException(ValidateException.ERROR_SIGNATURE_MD5.getErrcode(),"签名验证失败");
		}
		authObj.setOtherParam(map);
		boolean authed;
		try {
			authed = authObj.isAuthed();
		} catch (SignatureException e) {
			log.error("校验签名失败",e);
			throw new AuthenticationException(ValidateException.ERROR_SIGNATURE_MD5.getErrcode(),ValidateException.ERROR_SIGNATURE_MD5.getMessage(),e);
		}
		if(!authed){
			throw new AuthenticationException(ValidateException.ERROR_SIGNATURE_MD5.getErrcode(),ValidateException.ERROR_SIGNATURE_MD5.getMessage());
		}
		return map;
	}

}
