package com.hummingbird.paas.vo;

import com.hummingbird.commonbiz.vo.AppBaseVO;
import com.hummingbird.commonbiz.vo.Decidable;

public class GetSiteNewsListVO extends AppBaseVO implements Decidable{

	private GetSiteNewsListBodyVO body;

	public GetSiteNewsListBodyVO getBody() {
		return body;
	}

	public void setBody(GetSiteNewsListBodyVO body) {
		this.body = body;
	}
	@Override
	public String toString() {
		return " GetSiteNewsListVO [body=" + body + ", app="
				+ app + "]";
	}

    
}
