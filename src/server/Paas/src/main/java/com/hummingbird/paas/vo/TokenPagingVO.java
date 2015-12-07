package com.hummingbird.paas.vo;

import com.hummingbird.commonbiz.vo.AppBaseVO;
import com.hummingbird.commonbiz.vo.Decidable;

/**
 * @author john huang
 * 2015年12月7日 下午8:38:21
 * 本类主要做为 带分页的token查询vo
 */
public class TokenPagingVO extends AppBaseVO implements Decidable{

	private TokenQueryVO body;

	public TokenQueryVO getBody() {
		return body;
	}

	public void setBody(TokenQueryVO body) {
		this.body = body;
	}
	
	@Override
	public String toString() {
		return "RegisterVO [body=" + body + ", app="
				+ app + "]";
	}
	
}
