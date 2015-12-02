package com.hummingbird.usercenter.vo;

import com.hummingbird.commonbiz.vo.AppBaseVO;
import com.hummingbird.commonbiz.vo.Decidable;

public class UserVO extends AppBaseVO implements Decidable{
	private UserBodyVO body;

	public UserBodyVO getBody() {
		return body;
	}

	public void setBody(UserBodyVO body) {
		this.body = body;
	}
	
	@Override
	public String toString() {
		return "UserVO [body=" + body + ", app="
				+ app + "]";
	}
	
}
