package com.hummingbird.paas.services;

import java.util.List;

import com.hummingbird.paas.entity.UserBankcard;

public interface GeneralService {

	public boolean validateSMSCode(String appId, String mobileNum,String authCode,Boolean isDelete);
	
}
