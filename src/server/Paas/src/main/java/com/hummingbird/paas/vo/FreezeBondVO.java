package com.hummingbird.paas.vo;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import com.hummingbird.commonbiz.vo.AppBaseVO;
import com.hummingbird.commonbiz.vo.AppMobileDecidable;

@JsonIgnoreProperties(value = {"appId", "type","authed","businessKeys"})
public class FreezeBondVO extends AppBaseVO implements AppMobileDecidable{
	private FreezeBondBodyVO body;

	public FreezeBondBodyVO getBody() {
		return body;
	}

	public void setBody(FreezeBondBodyVO body) {
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
	
	@Override
	public String toString() {
		return "FreezeBondVO [body=" + body + ", app="
				+ app + "]";
	}

}
