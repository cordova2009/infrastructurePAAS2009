package com.hummingbird.paas.vo;

import com.hummingbird.commonbiz.vo.AppBaseVO;
import com.hummingbird.commonbiz.vo.Decidable;

public class MyObjectPaymentVO extends AppBaseVO implements Decidable{
	private MyObjectPaymentBodyVO body;

	public MyObjectPaymentBodyVO getBody() {
		return body;
	}

	public void setBody(MyObjectPaymentBodyVO body) {
		this.body = body;
	}
	@Override
	public String toString() {
		return "MyObjectPaymentVO [body=" + body + ", app="
				+ app + "]";
	}
}
