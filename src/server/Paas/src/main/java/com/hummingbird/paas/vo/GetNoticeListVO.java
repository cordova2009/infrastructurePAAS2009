package com.hummingbird.paas.vo;

import com.hummingbird.commonbiz.vo.AppBaseVO;
import com.hummingbird.commonbiz.vo.Decidable;

public class GetNoticeListVO  extends AppBaseVO implements Decidable{
    private GetNoticeListBodyVO body;

	public GetNoticeListBodyVO getBody() {
		return body;
	}

	public void setBody(GetNoticeListBodyVO body) {
		this.body = body;
	}
	@Override
	public String toString() {
		return "GetNoticeListVO  [body=" + body + ", app="
				+ app + "]";
	}
}
