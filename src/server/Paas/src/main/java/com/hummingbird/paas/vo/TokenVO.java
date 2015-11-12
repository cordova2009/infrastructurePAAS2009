package com.hummingbird.paas.vo;

import com.hummingbird.commonbiz.vo.AppBaseVO;
import com.hummingbird.commonbiz.vo.Decidable;

public class TokenVO extends AppBaseVO implements Decidable{

	private TokenBodyVO body;

	public TokenBodyVO getBody() {
		return body;
	}

	public void setBody(TokenBodyVO body) {
		this.body = body;
	}
	
	@Override
	public String toString() {
		return "RegisterVO [body=" + body + ", app="
				+ app + "]";
	}
	
}
