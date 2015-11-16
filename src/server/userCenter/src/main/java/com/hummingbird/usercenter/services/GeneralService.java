package com.hummingbird.usercenter.services;

import java.util.List;

import com.hummingbird.usercenter.entity.UserBankcard;

public interface GeneralService {

	public boolean validateSMSCode(String appId, String mobileNum,String authCode,Boolean isDelete);
	
}
