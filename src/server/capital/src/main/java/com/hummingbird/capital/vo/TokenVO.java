package com.hummingbird.capital.vo;

import com.hummingbird.commonbiz.vo.AppBaseVO;
import com.hummingbird.commonbiz.vo.Decidable;
import com.hummingbird.commonbiz.vo.TransOrderVOSign;

public class TokenVO extends AppBaseVO implements Decidable{

	private TokenBodyVO body;
	/**
	 * 签名信息
	 */
	protected TransOrderVOSign tsig;
	
	public TransOrderVOSign getTsig() {
		return tsig;
	}

	public void setTsig(TransOrderVOSign tsig) {
		this.tsig = tsig;
	}

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
