package com.hummingbird.paas.vo;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import com.hummingbird.commonbiz.vo.AppBaseVO;
import com.hummingbird.commonbiz.vo.AppMobileDecidable;

@JsonIgnoreProperties(value = {"appId", "type","authed","businessKeys"})
public class UpdateTradePasswordVO extends AppBaseVO implements AppMobileDecidable{
	private UpdateTradePasswordBodyVO body;

	public UpdateTradePasswordBodyVO getBody() {
		return body;
	}

	public void setBody(UpdateTradePasswordBodyVO body) {
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
