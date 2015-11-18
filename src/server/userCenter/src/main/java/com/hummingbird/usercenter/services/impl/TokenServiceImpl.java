/**
 * 
 */
package com.hummingbird.usercenter.services.impl;

import java.util.Date;

import org.apache.commons.lang.math.NumberUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.hummingbird.common.util.Md5Util;
import com.hummingbird.common.util.PropertiesUtil;
import com.hummingbird.commonbiz.exception.TokenException;
import com.hummingbird.commonbiz.vo.BaseUserToken;
import com.hummingbird.commonbiz.vo.UserToken;
import com.hummingbird.usercenter.entity.Token;
import com.hummingbird.usercenter.mapper.UserTokenMapper;
import com.hummingbird.usercenter.services.TokenService;

/**
 * @author huangjiej_2
 * 2014年10月18日 下午12:21:17
 */
@Service
public class TokenServiceImpl implements TokenService {

	protected  final Log log = LogFactory.getLog(getClass());
	@Autowired
	UserTokenMapper tokenmapper;
	
	/**
	 * 获取token，如果token超时会返回空
	 * @param token
	 * @return
	 */
	public Token getToken(String token){
		Token to = tokenmapper.selectByTokenStr(token);
		if(to!=null)
		{
			if(isOvertime(to)){
				if (log.isDebugEnabled()) {
					log.debug(String.format("用户token已过期"));
				}
				return null;
			}
			return to;
		}
		return null;
	}

	/**
	 * 检查是否超时
	 * @param to
	 * @return
	 */
	private boolean isOvertime(Token to) {
		long lastlogintime = to.getUpdateTime()!=null?to.getUpdateTime().getTime():to.getInsertTime().getTime();
		return to.getExpireIn()>0&&(long)to.getExpireIn()*1000+lastlogintime<System.currentTimeMillis();
	}
	
	/**
	 * 获取token，如果token超时会返回空
	 * @param token
	 * @return
	 */
	@Override
	public Token getToken(String token,String appId){
		Token to = tokenmapper.selectByToken(new BaseUserToken(appId,null,token));
		if(to!=null)
		{
			if(isOvertime(to)){
				if (log.isDebugEnabled()) {
					log.debug(String.format("用户token已过期"));
				}
				return null;
			}
			return to;
		}
		return null;
	}
	
	/* (non-Javadoc)
	 * @see com.pay2b.service.ITokenService#validateToken(com.pay2b.vo.UserToken)
	 */
	public boolean validateToken(UserToken token)throws TokenException {
		//如果appid，手机，令牌都存在，就校验这3者有没有关联
		String appId = token.getAppId();
		String userId = token.getMobileNum();
		String tokenstr = token.getToken();
		if(StringUtils.hasText(tokenstr)){
			if(StringUtils.hasText(appId)&&StringUtils.hasText(userId)){
				Token relationtoken = tokenmapper.selectByToken(token);
				if(relationtoken==null){
					if(log.isDebugEnabled())
					{
						log.debug(String.format("appid[%s],userId[%s]和token[%s]没有关联，校验不通过",appId,userId,tokenstr));
					}
					return false;
				}
			}
			//判断token在数据库中是否存在
			Token selectByTokenStr = tokenmapper.selectByTokenStr(tokenstr);
			if(selectByTokenStr==null){
				if(log.isDebugEnabled())
				{
					log.debug(String.format("token[%s]在系统中不存在，校验不通过",tokenstr));
				}
				return false;
			}
			//更新手机号
			token.setMobileNum(selectByTokenStr.getUserId().toString());
			
			return true;
		}
		
		return false;
	}

	/* (non-Javadoc)
	 * @see com.pay2b.service.ITokenService#createToken(java.lang.String, java.lang.String)
	 */
	public UserToken createToken(String appId,int userId) {
		String token =new Md5Util().Encrypt(appId+userId+System.currentTimeMillis());
		Token record=new Token();
		record.setAppId(appId);
		record.setUserId(userId);
		record.setToken(token);
		record.setInsertTime(new Date());
		record.setUpdateTime(new Date());
		record.setExpireIn(getDefaultExpireIn());
		tokenmapper.insert(record);
		return new BaseUserToken(appId,String.valueOf(userId),token,record.getExpireIn());
	}

	/* (non-Javadoc)
	 * @see com.pay2b.service.ITokenService#queryToken()
	 */
	@Override
	public UserToken queryToken(String appId,int userId) {
		Token selectByAppAndMobile = tokenmapper.selectByToken(new BaseUserToken(appId, String.valueOf(userId), null));
		if(selectByAppAndMobile==null)
		{
			return null;
		}
		return new BaseUserToken(appId, String.valueOf(userId), selectByAppAndMobile.getToken(),selectByAppAndMobile.getExpireIn() );
	}
	
	/**
	 * 获取或创建token(如果token不存在,或token超时)
	 * @param appId
	 * @param userId
	 * @return
	 */
	@Override
	public UserToken getOrCreateToken(String appId,int userId){
		Token selectByAppAndMobile = tokenmapper.selectByToken(new BaseUserToken(appId, String.valueOf(userId), null));
		if(selectByAppAndMobile!=null&&isOvertime(selectByAppAndMobile)){
			if (log.isDebugEnabled()) {
				log.debug(String.format("token超时,更新token"));
			}
			tokenmapper.deleteByPrimaryKey(selectByAppAndMobile.getToken());
			selectByAppAndMobile=null;
		}
		if(selectByAppAndMobile==null)
		{
			return createToken(appId, userId);
		}
		return new BaseUserToken(appId,String.valueOf(userId),selectByAppAndMobile.getToken(),selectByAppAndMobile.getExpireIn());
		
	}
	
	/**
	 * 更新token,此方法已无用,被getOrCreateToken 代替
	 * @param selectToken
	 * @return 
	 */
	public UserToken RenewToken(UserToken token){
		int defaultExpireIn = getDefaultExpireIn();
		Token to = new Token();
		to.setExpireIn(defaultExpireIn);
		to.setToken(token.getToken());
		to.setUpdateTime(new Date());
		tokenmapper.updateByPrimaryKeySelective(to);
		((BaseUserToken)token).setExpirein(defaultExpireIn);
		return token;
	}
	
	private int getDefaultExpireIn(){
		//1小时有效
		return new PropertiesUtil().getInt("usertoken.expirein", 3600);
	}
	
	/**
	 * 更新令牌的有效期
	 * @param token
	 */
	public void postponeToken(Token token){
		
	}

}
