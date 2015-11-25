package com.hummingbird.usercenter.vo;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import com.hummingbird.commonbiz.vo.AppBaseVO;
import com.hummingbird.commonbiz.vo.AppMobileDecidable;

@JsonIgnoreProperties(value = {"appId", "type","authed","businessKeys"})
public class UpdateLoginPasswordVO extends AppBaseVO implements AppMobileDecidable{
	private UpdateLoginPasswordBodyVO body;

	@Override
	public String toString() {
		return "UpdateLoginPasswordVO [body=" + body + ", app="
				+ app + "]";
	}
	
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
