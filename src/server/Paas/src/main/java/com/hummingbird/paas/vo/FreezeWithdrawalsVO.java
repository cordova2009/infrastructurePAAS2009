package com.hummingbird.paas.vo;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import com.hummingbird.commonbiz.vo.AppBaseVO;
import com.hummingbird.commonbiz.vo.AppMobileDecidable;

@JsonIgnoreProperties(value = {"appId", "type","authed","businessKeys"})
public class FreezeWithdrawalsVO extends AppBaseVO implements AppMobileDecidable{
	private FreezeWithdrawalsBodyVO body;
	
	public FreezeWithdrawalsBodyVO getBody() {
		return body;
	}

	public void setBody(FreezeWithdrawalsBodyVO body) {
		this.body = body;
	}

	@Override
	public String toString() {
		return "RegisterVO [body=" + body + ", app="
				+ app + "]";
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
