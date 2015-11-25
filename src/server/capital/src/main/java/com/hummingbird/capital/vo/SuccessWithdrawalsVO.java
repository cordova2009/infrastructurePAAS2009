package com.hummingbird.capital.vo;

import com.hummingbird.commonbiz.vo.AppBaseVO;
import com.hummingbird.commonbiz.vo.AppMobileDecidable;

public class SuccessWithdrawalsVO  extends AppBaseVO implements AppMobileDecidable{

	private SuccessRechargeBodyVO body;
	
	
	public SuccessRechargeBodyVO getBody() {
		return body;
	}

	public void setBody(SuccessRechargeBodyVO body) {
		this.body = body;
	}

	@Override
	public String toString() {
		return "SuccessWithdrawalsVO [body=" + body + ", app="
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
