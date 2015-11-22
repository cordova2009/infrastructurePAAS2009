package com.hummingbird.paas.vo;

import com.hummingbird.commonbiz.vo.AppBaseVO;
import com.hummingbird.commonbiz.vo.Decidable;

public class ObjectVO extends AppBaseVO implements Decidable{
	private ObjectBodyVO body;

	public ObjectBodyVO getBody() {
		return body;
	}

	public void setBody(ObjectBodyVO body) {
		this.body = body;
	}
	@Override
	public String toString() {
		return "RegisterVO [body=" + body + ", app="
				+ app + "]";
	}
}
