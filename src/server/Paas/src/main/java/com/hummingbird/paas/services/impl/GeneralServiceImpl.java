package com.hummingbird.paas.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hummingbird.paas.entity.UserBankcard;
import com.hummingbird.paas.entity.UserSmscode;
import com.hummingbird.paas.mapper.UserBankcardMapper;
import com.hummingbird.paas.mapper.UserSmscodeMapper;
import com.hummingbird.paas.services.GeneralService;
@Service
@Service
public class GeneralServiceImpl implements GeneralService{

	
	org.apache.commons.logging.Log log = org.apache.commons.logging.LogFactory
			.getLog(this.getClass());
	@Autowired(required = true)
	private UserSmscodeMapper smscodemapper;
	
	@Override
	public boolean validateSMSCode(String appId, String mobileNum,String authCode,Boolean delSmsCode) {

		UserSmscode query = new UserSmscode();
		query.setAppid(appId);
		query.setMobilenum(mobileNum);
		UserSmscode code = smscodemapper.getAuthCode(query);
		if (log.isTraceEnabled()) {
			log.trace("手机验证码信息是：" + code);
		}
		try{
			if (code != null
					&& code.getSmscode().equals(authCode)
					&& (code.getSendtime().getTime() + code.getExpirein() * 1000) > System
							.currentTimeMillis()) {
				return true;
			}
			return false;
		}
		finally{
			// 删除验证码
			if(delSmsCode){
				smscodemapper.deleteAuthCode(query);
			}
		}
	
	}

	

}
