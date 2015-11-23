package com.hummingbird.paas.vo;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import com.hummingbird.commonbiz.vo.AppBaseVO;
import com.hummingbird.commonbiz.vo.AppMobileDecidable;

@JsonIgnoreProperties(value = {"appId", "type","authed","businessKeys"})
public class UpdateLoginPasswordVO extends AppBaseVO implements AppMobileDecidable{
	private UpdateLoginPasswordBodyVO body;

	
	
	public UpdateLoginPasswordBodyVO getBody() {
		return body;
	}

	public void setBody(UpdateLoginPasswordBodyVO body) {
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
		return null;
	}
	
}
