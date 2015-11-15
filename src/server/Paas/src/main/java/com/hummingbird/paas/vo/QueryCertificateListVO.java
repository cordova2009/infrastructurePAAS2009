package com.hummingbird.paas.vo;

import com.hummingbird.commonbiz.vo.AppBaseVO;
import com.hummingbird.commonbiz.vo.Decidable;

public class QueryCertificateListVO  extends AppBaseVO implements Decidable{
    private   QueryCertificateListBodyVO body;

	public QueryCertificateListBodyVO getBody() {
		return body;
	}

	public void setBody(QueryCertificateListBodyVO body) {
		this.body = body;
	}
	@Override
	public String toString() {
		return " QueryCertificateListVO [body=" + body + ", app="
				+ app + "]";
	}
}
