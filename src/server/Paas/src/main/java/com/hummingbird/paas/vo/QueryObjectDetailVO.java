package com.hummingbird.paas.vo;

import com.hummingbird.commonbiz.vo.AppBaseVO;
import com.hummingbird.commonbiz.vo.Decidable;

public class QueryObjectDetailVO extends AppBaseVO implements Decidable{
     private QueryObjectDetailBodyVO body;

	public QueryObjectDetailBodyVO getBody() {
		return body;
	}

	public void setBody(QueryObjectDetailBodyVO body) {
		this.body = body;
	}
	@Override
	public String toString() {
		return "QueryObjectDetailVO [body=" + body + ", app="
				+ app + "]";
	}
}
