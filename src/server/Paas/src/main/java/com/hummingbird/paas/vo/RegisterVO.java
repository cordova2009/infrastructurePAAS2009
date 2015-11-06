package com.hummingbird.paas.vo;

import com.hummingbird.commonbiz.vo.AppBaseVO;
import com.hummingbird.commonbiz.vo.Decidable;

public class RegisterVO extends AppBaseVO implements Decidable{
	
	private RegisterBodyVO body;

	public RegisterBodyVO getBody() {
		return body;
	}

	public void setBody(RegisterBodyVO body) {
		this.body = body;
	}
	
	@Override
	public String toString() {
		return "RegisterVO [body=" + body + ", app="
				+ app + "]";
	}
}
