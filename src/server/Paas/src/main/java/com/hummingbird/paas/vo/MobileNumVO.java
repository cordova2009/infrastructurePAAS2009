package com.hummingbird.paas.vo;

import com.hummingbird.commonbiz.vo.AppBaseVO;
import com.hummingbird.commonbiz.vo.Decidable;

public class MobileNumVO extends AppBaseVO implements Decidable{

	private MobileVO body;

	public MobileVO getBody() {
		return body;
	}

	public void setBody(MobileVO body) {
		this.body = body;
	}
	
}
