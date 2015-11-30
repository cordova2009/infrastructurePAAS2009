package com.hummingbird.usercenter.vo;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import com.hummingbird.commonbiz.vo.AppBaseVO;
import com.hummingbird.commonbiz.vo.AppMobileDecidable;
import com.hummingbird.commonbiz.vo.Decidable;
@JsonIgnoreProperties(value = {"appId","mobileNum", "type","authed","businessKeys"})
public class MobileNumVO extends AppBaseVO implements AppMobileDecidable{

	private MobileVO body;

	@Override
	public String toString() {
		return "MobileNumVO [body=" + body + ", app=" + app +"]";
	}
	
	public MobileVO getBody() {
		return body;
	}

	public void setBody(MobileVO body) {
		this.body = body;
	}

	@Override
	public String getAppId() {
		// TODO Auto-generated method stub
		return app.getAppId();
	}

	public String getMobileNum() {
		// TODO Auto-generated method stub
		return body.getMobileNum();
	}
	
}
