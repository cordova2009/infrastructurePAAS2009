package com.hummingbird.paas.vo;

import com.hummingbird.commonbiz.vo.AppBaseVO;
import com.hummingbird.commonbiz.vo.Decidable;

public class GetMsgListVO extends AppBaseVO implements Decidable{
    private GetMsgListBodyVO body;

	public GetMsgListBodyVO getBody() {
		return body;
	}

	public void setBody(GetMsgListBodyVO body) {
		this.body = body;
	}
	@Override
	public String toString() {
		return "GetMsgListVO  [body=" + body + ", app="
				+ app + "]";
	}
}
