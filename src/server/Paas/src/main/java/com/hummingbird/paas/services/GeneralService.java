package com.hummingbird.paas.services;

public interface GeneralService {

	public boolean validateSMSCode(String appId, String mobileNum,String authCode,Boolean isDelete);
	
}
