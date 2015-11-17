package com.hummingbird.paas.vo;

import java.util.Date;

import com.hummingbird.commonbiz.vo.AppBaseVO;
import com.hummingbird.commonbiz.vo.Decidable;

/**
 * 提交招标人资质认证信息
 * @author YJY  
 * @since 2015年11月7日12:06:30
 * */
public class MyBiddeeAuthInfoApplyVO extends AppBaseVO implements Decidable{
	
	private MyBiddeeAuthInfoBodyVO body;

	/**
	 * @return the body
	 */
	public MyBiddeeAuthInfoBodyVO getBody() {
		return body;
	}

	/**
	 * @param body the body to set
	 */
	public void setBody(MyBiddeeAuthInfoBodyVO body) {
		this.body = body;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "MyBiddeeAuthInfoApplyVO [body=" + body + "]";
	}

	

	
	

}
