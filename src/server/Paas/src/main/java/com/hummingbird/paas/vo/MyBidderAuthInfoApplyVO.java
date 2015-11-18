package com.hummingbird.paas.vo;

import java.util.Date;

import com.hummingbird.commonbiz.vo.AppBaseVO;
import com.hummingbird.commonbiz.vo.Decidable;

/**
 * 提交投标人资质认证信息
 * @author YJY  
 * @since 2015年11月10日16:08:5
 * */
public class MyBidderAuthInfoApplyVO extends AppBaseVO implements Decidable{
	
	private MyBidderAuthInfoBodyVO body;

	/**
	 * @return the body
	 */
	public MyBidderAuthInfoBodyVO getBody() {
		return body;
	}

	/**
	 * @param body the body to set
	 */
	public void setBody(MyBidderAuthInfoBodyVO body) {
		this.body = body;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "MyBidderAuthInfoApplyVO [body=" + body + "]";
	}


}
