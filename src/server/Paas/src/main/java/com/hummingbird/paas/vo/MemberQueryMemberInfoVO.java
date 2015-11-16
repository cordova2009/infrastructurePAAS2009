package com.hummingbird.paas.vo;

import com.hummingbird.commonbiz.vo.AppBaseVO;
import com.hummingbird.commonbiz.vo.Decidable;

public class MemberQueryMemberInfoVO extends AppBaseVO implements Decidable {
	private MemberQueryMemberInfoBodyVO body;

	public MemberQueryMemberInfoBodyVO getBody() {
		return body;
	}

	public void setBody(MemberQueryMemberInfoBodyVO body) {
		this.body = body;
	}

	@Override
	public String toString() {
		return "MemberQueryMemberInfoVO [body=" + body + ", app="
				+ app + "]";
	}

}
