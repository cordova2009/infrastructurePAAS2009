package com.hummingbird.usercenter.vo;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import com.hummingbird.commonbiz.vo.AppBaseVO;
import com.hummingbird.commonbiz.vo.AppMobileDecidable;

@JsonIgnoreProperties(value = {"appId", "type","authed","businessKeys"})
public class LoginVO extends AppBaseVO implements AppMobileDecidable{
	private LoginBodyVO body;
	
	@Override
	public String toString() {
		return "LoginVO [body=" + body + ", app=" + app +"]";
	}
	public LoginBodyVO getBody() {
		return body;
	}

	public void setBody(LoginBodyVO body) {
		this.body = body;
	}

	@Override
	public String getAppId() {
		// TODO Auto-generated method stub
		return app.getAppId();
	}

	@Override
	public String getMobileNum() {
		// TODO Auto-generated method stub
		return body.getMobileNum();
	}
	
}
