package com.hummingbird.usercenter.vo;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import com.hummingbird.commonbiz.vo.AppBaseVO;
import com.hummingbird.commonbiz.vo.AppMobileDecidable;

@JsonIgnoreProperties(value = {"appId", "type","authed","businessKeys"})
public class ForgetPasswordVO extends AppBaseVO implements AppMobileDecidable{
	private ForgetPasswordBodyVO body;

	public ForgetPasswordBodyVO getBody() {
		return body;
	}

	public void setBody(ForgetPasswordBodyVO body) {
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
