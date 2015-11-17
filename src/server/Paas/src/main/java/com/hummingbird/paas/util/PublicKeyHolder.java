package com.hummingbird.paas.util;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

import org.apache.commons.lang.ObjectUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.time.DateUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.hummingbird.common.util.JsonUtil;
import com.hummingbird.common.util.PropertiesUtil;
import com.hummingbird.common.util.StrUtil;
import com.hummingbird.common.util.http.HttpRequester;

/**
 * @author huangjiej_2
 * 公钥保存�?
 */
public class PublicKeyHolder {

	private static long lastupdate = 0;
	static Log log = LogFactory.getLog(PublicKeyHolder.class);
	
	/**
	 * 公钥
	 */
	String publickey;
	
	static PublicKeyHolder self=null;
	
	private PublicKeyHolder(){
		
	}
	
	
	public static PublicKeyHolder getInstance(){
		if(self==null) 
		{
			self = new PublicKeyHolder();
		}
		return self;
	}
	
	
	public void init(){
		long currentTimeMillis = System.currentTimeMillis();
		if(currentTimeMillis-lastupdate>24*3600*1000||DateUtils.isSameDay(DateUtils.truncate(new Date(currentTimeMillis),Calendar.DATE),DateUtils.truncate(DateUtils.addDays(new Date(lastupdate),1),Calendar.DATE))){
			refreshPublickey();
		}
		else{
			if (log.isDebugEnabled()) {
				log.debug(String.format("由于上次调用时间不足24小时，不执行调用刷新publickey"));
			}
		}
	}

	/**
	 * 刷新publickey
	 * @return 
	 */
	private boolean refreshPublickey() {
		try {
			PropertiesUtil pu = new PropertiesUtil();
			String getpublickeyurl = StrUtil.replaceAllWithToken(pu.getProperty("flow.exchange.url")+pu.getProperty("part.getPublicKey.url"), "partnerID", pu.getProperty("partnerID"));
			String result = new HttpRequester().send(getpublickeyurl, "POST",null);
			
			if(result==null)
			{
				if (log.isDebugEnabled()) {
					log.debug(String.format("刷新publickey，调用不成功，可能存在网络问题，或�?�地�?不正�?"));
				}
				return false;
			}
			else{
				if (log.isDebugEnabled()) {
					log.debug(String.format("刷新publickey，返回内容为%s",result));
				}
				HashMap resultmap = JsonUtil.convertJson2Obj(result, HashMap.class);
				String tmppublickey = ObjectUtils.toString(resultmap.get("publickey"));
				if(StringUtils.isBlank(tmppublickey)){
					log.warn(String.format("刷新publickey，获取到公钥为空"));
					return false;
				}
				else{
					publickey = tmppublickey;
					return true;
				}
			}
		} catch (Exception e) {
			log.error("刷新publickey出错",e);
			return false;
		}
	}


	/**
	 * 公钥 
	 */
	public String getPublickey() {
		self.init();
		return publickey;
	}

	
	
	
}
