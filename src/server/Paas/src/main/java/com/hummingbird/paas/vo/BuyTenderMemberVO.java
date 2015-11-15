package com.hummingbird.paas.vo;

import com.hummingbird.commonbiz.vo.AppBaseVO;
import com.hummingbird.commonbiz.vo.Decidable;

public class BuyTenderMemberVO extends AppBaseVO implements Decidable{

	private BuyTenderMemberBodyVO body;

	public BuyTenderMemberBodyVO getBody() {
		return body;
	}

	public void setBody(BuyTenderMemberBodyVO body) {
		this.body = body;
	}
	@Override
	public String toString() {
		return "BuyTenderMemberVO [body=" + body + ", app="
				+ app + "]";
	}

}
